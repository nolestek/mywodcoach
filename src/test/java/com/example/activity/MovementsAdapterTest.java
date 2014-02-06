package com.example.activity;

import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.helper.MovementsAdapter;
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
public class MovementsAdapterTest {

    private ArrayList<String> movements;
    private MovementsAdapter movementsAdapter;

    @Before
    public void setUp() throws Exception {
        movements = new ArrayList<String>();
        movements.add("Lauren Conrad");
        movements.add("Heidi Montag");
        movements.add("Kim Kardashian");
        movementsAdapter = new MovementsAdapter(movements);
    }

    @Test
    public void testGetCount() throws Exception {
        assertThat(movementsAdapter.getCount(), equalTo(movements.size()));
    }

    @Test
    public void testGetItem() throws Exception {
        assertThat((String) movementsAdapter.getItem(0), equalTo("Lauren Conrad"));
        assertThat((String) movementsAdapter.getItem(1), equalTo("Heidi Montag"));
        assertThat((String) movementsAdapter.getItem(2), equalTo("Kim Kardashian"));
    }

    @Test
    public void testGetItemId() throws Exception {
        assertThat(movementsAdapter.getItemId(0), equalTo(0L));
        assertThat(movementsAdapter.getItemId(1), equalTo(1L));
        assertThat(movementsAdapter.getItemId(2), equalTo(2L));
    }

    @Test
    public void testGetView() throws Exception {
        Activity activity = Robolectric.buildActivity(Activity.class).create().get();
        TextView nameView = (TextView) movementsAdapter.getView(1, null, new LinearLayout(activity));
        assertThat(nameView.getText().toString(), equalTo("Heidi Montag"));
    }

    @Test
    public void shouldRecycleProvidedViews() throws Exception {
        Activity activity = Robolectric.buildActivity(Activity.class).create().get();
        TextView existingView = new TextView(Robolectric.application);
        TextView nameView = (TextView) movementsAdapter.getView(2, existingView, new LinearLayout(activity));
        assertThat(nameView, sameInstance(existingView));
}
}