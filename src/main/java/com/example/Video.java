package com.example;

public class Video {
    private String name;
    private String id;

    public Video(String name, String id){
        this.name = name;
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public String getID(){
        return id;
    }
}
