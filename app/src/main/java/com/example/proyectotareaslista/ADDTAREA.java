package com.example.proyectotareaslista;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ADDTAREA extends AppCompatActivity {

    private static final int REQUEST_CAMERA_PERMISSION = 1001;
    private static final int REQUEST_IMAGE_CAPTURE = 1002;
    private ImageView addphoto;

    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_tarea);
        Button btnCapture= findViewById(R.id.btnCapture);
        addphoto = findViewById(R.id.addphoto);
        back = findViewById(R.id.left_icon);
        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(ADDTAREA.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)
                {
                    starCamera();
                }else {
                    requestCameraPermission();
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ADDTAREA.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private  void requestCameraPermission(){
        ActivityCompat.requestPermissions(this ,new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
    }
    private void starCamera(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager())!=null){
//        startActivity(intent, REGUEST_IMAGE_CAPTURE);
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }else {
            Toast.makeText(this, "No se encontro una Aplicacion de camera", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int reguestCode, int resultCode,Intent data) {
        super.onActivityResult(reguestCode, resultCode, data);
        if (reguestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            addphoto.setImageBitmap(imageBitmap);
            String imageFileName = "imagenCapturada.jpg";
            File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File imageFile = new File(storageDir, imageFileName);

            try {
                FileOutputStream outputStream = new FileOutputStream(imageFile);
                imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);

                outputStream.close();
                Toast.makeText(this, "Imagen guardar", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                Toast.makeText(this, "Error al guardar la imagen", Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResult)
    {
        super.onRequestPermissionsResult(requestCode,permissions, grantResult);
        if (requestCode==REQUEST_CAMERA_PERMISSION){
            if(grantResult.length>0 && grantResult[0]== PackageManager.PERMISSION_GRANTED){
                starCamera();
            }else {
                Toast.makeText(this, "Permiso de camara denegado", Toast.LENGTH_SHORT).show();
            }

        }
    }

}
