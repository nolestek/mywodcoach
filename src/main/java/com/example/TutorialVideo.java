package com.example;

public class TutorialVideo {
    private String name;
    private String id;
    private String description;
    private int thumbnail;


    public TutorialVideo(String name, String id, String description, int thumbnail){
        this.name = name;
        this.id = id;
        this.description = description;
        this.thumbnail = thumbnail;

    }
    public String getName(){  return name; }
    public String getID(){ return id; }
    public String getDescription(){ return description; }
    public int getThumbnailImageId(){ return thumbnail; }
    }

