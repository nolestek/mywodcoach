package com.example.activity;
import android.app.ListActivity;
import android.view.View;
import android.widget.*;
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

import android.app.Activity;
import android.widget.ListView;
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
    private Activity activity;
    private ListView movements_listView;

    @Before
    public void setup(){
        activity = Robolectric.buildActivity(MainMovementListActivity.class)
                .create().visible()
                .get();

        movements_listView = (ListView) activity.findViewById(R.id.movement_list);
    }

    @Test
    public void shouldShowAListOfMovements() throws Exception {

            movements_listView = (ListView) activity.findViewById(R.id.movement_list);

            // ListViews only create as many children as will fit in their bounds, so make it big...
            movements_listView.layout(0, 0, 100, 1000);

            TextView nameRow = (TextView) movements_listView.getChildAt(0);
            assertThat(nameRow.getText().toString(), equalTo("Kipping Pull Ups"));
    }

    @Test
    public void thingsShouldNotBeNull(){
        assertNotNull(movements_listView.getChildAt(0));
        assertNotNull(movements_listView.getItemIdAtPosition(0));
        assertNotNull(activity.findViewById(R.id.movement_list));

    }
}

