package com.example.proyectotareaslista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView left = findViewById(R.id.left_icon);
        ImageView menu = findViewById(R.id.menu_icon);
        TextView title = findViewById(R.id.title_tool);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showPopupMenu(v);
                //Toast.makeText(MainActivity.this,"LEFT",Toast.LENGTH_SHORT).show();
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"MENU",Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(R.menu.popup_menu); // Crea un archivo XML llamado popup_menu en res/menu con las opciones del menú

        // Configura el listener para manejar las acciones del menú
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Maneja las acciones correspondientes a las opciones del menú
                switch (item.getItemId()) {
                    case R.id.option1:

                        // Acción para la opción 1
                        return true;
                    case R.id.option1:

                        // Acción para la opción 2
                        return true;
                    // Agrega más casos según tus necesidades
                }
                return false;
            }
        });

        popupMenu.show();
    }


}


































