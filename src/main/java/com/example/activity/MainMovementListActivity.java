package com.example.activity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.example.R;
import com.example.helper.MovementsAdapter;

import java.util.Arrays;
import java.util.List;

public class MainMovementListActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.movements_list);

      String[] movements = getResources().getStringArray(R.array.movements);

      List<String> movementList = Arrays.asList(movements);

      ListView lv = ((ListView) findViewById(R.id.movement_list));
              lv.setAdapter(new MovementsAdapter(movementList));



      lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view,
                                  int position, long id) {

              // selected item
              String exercise = ((TextView) view).getText().toString();

              // Launching new Activity on selecting single List Item
              Intent i = new Intent(getApplicationContext(), VideoListActivity.class);
              // sending data to new activity
              i.putExtra("exercise", exercise);
              startActivity(i);

          }
      });
  }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
  }

