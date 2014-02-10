package com.example.activity;


import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.R;
import com.example.helper.VideoListAdapter;
import com.example.helper.VideoListAdapter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class VideoListAdapterTest {

    private ArrayList<String> videos;
    private VideoListAdapter videoListAdapter;

    @Before
    public void setUp() throws Exception {
        VideoListActivity activity  = Robolectric.buildActivity(VideoListActivity.class)
                .create()
                .get();
        videos = new ArrayList<String>();
        videos.add("Lauren Conrad");
        videos.add("Heidi Montag");
        videos.add("Kim Kardashian");
        videoListAdapter = new VideoListAdapter(activity, videos);
    }

    @Test
    public void testGetCount() throws Exception {
        assertThat(videoListAdapter.getCount(), equalTo(videos.size()));
    }

    @Test
    public void testGetItem() throws Exception {
        assertThat((String) videoListAdapter.getItem(0), equalTo("Lauren Conrad"));
        assertThat((String) videoListAdapter.getItem(1), equalTo("Heidi Montag"));
        assertThat((String) videoListAdapter.getItem(2), equalTo("Kim Kardashian"));
    }

    @Test
    public void testGetItemId() throws Exception {
        assertThat(videoListAdapter.getItemId(0), equalTo(0L));
        assertThat(videoListAdapter.getItemId(1), equalTo(1L));
        assertThat(videoListAdapter.getItemId(2), equalTo(2L));
    }

    @Test
    public void testGetView() throws Exception {
        Activity activity = Robolectric.buildActivity(Activity.class).create().get();
        RelativeLayout relLayout = (RelativeLayout) videoListAdapter.getView(1, null, new LinearLayout(activity));
        TextView name = (TextView) relLayout.findViewById(R.id.artist);
        assertThat(name.getText().toString(), equalTo("Heidi Montag"));
    }

    @Test
    public void shouldRecycleProvidedViews() throws Exception {
        Activity activity = Robolectric.buildActivity(Activity.class).create().get();
        RelativeLayout existingView = new RelativeLayout(Robolectric.application);
        RelativeLayout relativeLayout = (RelativeLayout) videoListAdapter.getView(2, existingView, new LinearLayout(activity));
        assertThat(relativeLayout, sameInstance(existingView));
    }
}
