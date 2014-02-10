package com.example.helper;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.R;
import com.example.TutorialVideo;

import java.util.ArrayList;

public class VideoListAdapter extends BaseAdapter {
    private Activity activity;
    private static LayoutInflater inflater = null;
    private ArrayList<TutorialVideo> data;

    public VideoListAdapter(Activity a, ArrayList<TutorialVideo> d){
        activity = a;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        data = d;

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public TutorialVideo getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.video_list_item, null);

        TextView title = (TextView)vi.findViewById(R.id.title); // title
        TextView artist = (TextView)vi.findViewById(R.id.artist); // artist name
        TextView duration = (TextView)vi.findViewById(R.id.duration); // duration
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.list_image);

        title.setText(data.get(position).getName());
        artist.setText(data.get(position).getDescription());
        duration.setText(data.get(position).getDescription());

        thumb_image.setImageDrawable(vi.getResources().getDrawable(R.drawable.thumb));



        return vi;
    }
}
