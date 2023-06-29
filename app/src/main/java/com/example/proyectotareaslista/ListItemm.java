package com.example.proyectotareaslista;

public class ListItemm {
    private String title;
    private String description;

    public ListItemm(String _tilte, String _description)
    {
        this.title = _tilte;
        this.description = _description;
    }

    public  String getTitle(){
        return  title;
    }

    public  String getDesctiption(){
        return  description;
    }
}