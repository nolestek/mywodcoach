package com.example.activity;

import android.widget.ListView;
import android.widget.TextView;
import com.example.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class VideoListActivityTest {

    @Test
    public void shouldShowAListOfMovements() throws Exception {
        VideoListActivity activity = Robolectric.buildActivity(VideoListActivity.class).create().visible().get();

        ListView videos = (ListView) activity.findViewById(R.id.videos_list);


        videos.layout(0, 0, 100, 1000);

        TextView nameRow = (TextView) videos.getChildAt(0).findViewById(R.id.artist);
        assertThat(nameRow.getText().toString(), equalTo("Kipping Pull Ups Tutorial"));
    }

}
