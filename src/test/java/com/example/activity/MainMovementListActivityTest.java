package com.example.activity;
import android.app.ListActivity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;
import static org.robolectric.Robolectric.shadowOf;
import static org.robolectric.Robolectric.clickOn;

import android.content.Intent;
import android.widget.Adapter;
import android.widget.ListView;

import android.app.Activity;
import android.widget.ListView;
import android.widget.TextView;
import com.example.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class MainMovementListActivityTest  {

        @Test
        public void shouldShowAListOfNames() throws Exception {
            ListActivity activity = Robolectric.buildActivity(MainMovementListActivity.class)
                    .create()
                    .get();

            ListView movements_listView = activity.getListView();

            // ListViews only create as many children as will fit in their bounds, so make it big...
            movements_listView.layout(0, 0, 100, 1000);

            TextView nameRow = (TextView) movements_listView.getChildAt(0);
            assertThat(nameRow.getText().toString(), equalTo("Kipping Pull Ups"));
        }
}

