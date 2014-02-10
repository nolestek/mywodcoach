package com.example.activity;


import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.R;
import com.example.TutorialVideo;
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

    private ArrayList<TutorialVideo> videos;
    private VideoListAdapter videoListAdapter;
    private VideoListActivity activity;

    @Before
    public void setUp() throws Exception {
        activity  = Robolectric.buildActivity(VideoListActivity.class)
                .create().visible()
                .get();
        videos = new ArrayList<TutorialVideo>();
        videos.add(new TutorialVideo("Kipping Pull Ups", "SomeTestID", "Kipping Pull Ups Tutorial", R.drawable.thumb));
        videos.add(new TutorialVideo("Butterfly Pull Ups", "SomeTestID", "Butterfly Pull Ups Tutorial", R.drawable.thumb));
        videos.add(new TutorialVideo("Muscle Ups", "SomeTestID", "Muscle Ups Tutorial", R.drawable.thumb));
        videoListAdapter = new VideoListAdapter(activity, videos);
    }

    @Test
    public void testGetCount() throws Exception {
        assertThat(videoListAdapter.getCount(), equalTo(videos.size()));
    }

    @Test
    public void testGetItem() throws Exception {
        assertThat((String) videoListAdapter.getItem(0).getName(), equalTo("Kipping Pull Ups"));
        assertThat((String) videoListAdapter.getItem(1).getName(), equalTo("Butterfly Pull Ups"));
        assertThat((String) videoListAdapter.getItem(2).getName(), equalTo("Muscle Ups"));
    }

    @Test
    public void testGetItemId() throws Exception {
        assertThat(videoListAdapter.getItemId(0), equalTo(0L));
        assertThat(videoListAdapter.getItemId(1), equalTo(1L));
        assertThat(videoListAdapter.getItemId(2), equalTo(2L));
    }

    @Test
    public void testGetView() throws Exception {
        RelativeLayout relLayout = (RelativeLayout) videoListAdapter.getView(1, null, new LinearLayout(activity));
        TextView name = (TextView) relLayout.findViewById(R.id.artist);
        assertThat(name.getText().toString(), equalTo("Butterfly Pull Ups Tutorial"));
    }

    @Test
    public void shouldRecycleProvidedViews() throws Exception {
        View existingView = View.inflate(activity, R.layout.video_list_item, null);
        View relativeLayout = videoListAdapter.getView(1, existingView, null);
        assertThat(relativeLayout, sameInstance(existingView));
    }
}
