package com.example.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import com.example.R;
import com.example.TutorialVideo;
import com.example.helper.VideoListAdapter;

import java.util.ArrayList;
import java.util.List;

public class VideoListActivity extends Activity {

    ListView list;
    VideoListAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videos_list);

        ArrayList<TutorialVideo> videos = new ArrayList<TutorialVideo>();
        videos.add(new TutorialVideo("Kipping Pull Ups", "QrigE0M7j4o", "Kipping Pull Ups Tutorial", R.id.thumbnail));

          list = (ListView)findViewById(R.id.videos_list);

        adapter = new VideoListAdapter(this, videos);
        list.setAdapter(adapter);


        }



}
