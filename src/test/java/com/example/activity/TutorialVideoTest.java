package com.example.activity;

import android.graphics.drawable.Drawable;
import com.example.TutorialVideo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
public class TutorialVideoTest
{
    @Test
    public void getImageIsNotNull(){
        TutorialVideo video = new TutorialVideo("Test Name", "QrigE0M7j4o", "Test Description");
        Drawable thumb = video.getThumbnailImage();
        assertNotNull(thumb);
    }
}
