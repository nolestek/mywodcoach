package com.example.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.R;

import java.util.List;

public class MovementsAdapter extends BaseAdapter {
    private List<String> movementList;

    public MovementsAdapter(List<String> movements){
        this.movementList = movements;
    }

    @Override
    public int getCount() {
        return movementList.size();
    }

    @Override
    public Object getItem(int position) {
        return movementList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = convertView == null ? createView(parent) : (TextView) convertView;
        textView.setText(movementList.get(position));
        return textView;
    }
    private TextView createView(ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return (TextView) layoutInflater.inflate(R.layout.movement_list_item, parent, false);
    }
}
