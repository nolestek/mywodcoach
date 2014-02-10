package com.example;

import android.graphics.drawable.Drawable;

import java.io.InputStream;
import java.net.URL;

public class TutorialVideo {
    private String name;
    private String id;
    private String description;


    public TutorialVideo(String name, String id, String description){
        this.name = name;
        this.id = id;
        this.description = description;

    }
    public String getName(){
        return name;
    }
    public String getID(){
        return id;
    }
    public Drawable getThumbnailImage(){
        try {
            InputStream is = (InputStream) new URL("http://img.youtube.com/vi/"+id+"/default.jpg").getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }
    public String getDescription(){
        return description;
    }
}
