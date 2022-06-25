package com.example.doa_doa_harian.model;

public class Doa {
    private String id, name, doa;

    public  Doa(String name, String doa){
        this.name = name;
        this.doa = doa;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public  void  setName(){
        this.name = name;
    }
    public String getDoa(){
        return  doa;
    }
    public void setDoa(String doa){
        this.doa = doa;
    }
}