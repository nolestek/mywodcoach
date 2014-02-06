package com.example.activity;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.example.R;
import com.example.helper.MovementsAdapter;
import com.example.helper.VideosAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VideoListActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videos_list);

        List<String> videos = new ArrayList<String>();
        videos.add("QrigE0M7j4o");

        ((ListView) findViewById(R.id.videos_list_item)).setAdapter(new VideosAdapter(videos));


        }



}
