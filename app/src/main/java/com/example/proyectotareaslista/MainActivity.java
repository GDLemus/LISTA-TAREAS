package com.example.proyectotareaslista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

//    private List<String> dataList;
    private List<ListItemm> itemList;

    private CustomAdapter customAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>();
        itemList.add(new ListItemm("Elemento 1", "Descripción del elemento 1"));
        itemList.add(new ListItemm("Elemento 2", "Descripción del elemento 2"));
        itemList.add(new ListItemm("Elemento 3", "Descripción del elemento 3"));

        customAdapter = new CustomAdapter(itemList);
        recyclerView.setAdapter(customAdapter);

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(500); // Duración de la animación de agregado (en milisegundos)
        itemAnimator.setRemoveDuration(500); // Duración de la animación de eliminación (en milisegundos)
        itemAnimator.setChangeDuration(500); // Duración de la animación de cambio (en milisegundos)
        itemAnimator.setMoveDuration(500); // Duración de la animación de movimiento (en milisegundos)
        recyclerView.setItemAnimator(itemAnimator);

//        Button addButton = findViewById(R.id.addButton);

//        Button removeButton = findViewById(R.id.removeButton);
//
//        removeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                removeItem();
//            }
//        });

        ImageView deletebtn = findViewById(R.id.deletebtn);
                deletebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        removeItem();
                    }
                });

        ImageView addBtn = findViewById(R.id.addbtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ADDTAREA.class);
                startActivity(intent);
            }
        });

    }

private void removeItem(){
    if (!itemList.isEmpty())
    {
        int lastIndex = itemList.size()-1;
        itemList.remove(lastIndex);
        customAdapter.notifyItemRemoved(lastIndex);
    }
}
}




































