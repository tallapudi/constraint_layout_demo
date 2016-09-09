package com.example.vamsi.myapplication.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.vamsi.myapplication.R;

import java.util.List;

/**
 * Created by Vamsi on 9/2/2016.
 */

public class SwipeDeckAdapter extends BaseAdapter {

    private List<String> data;
    private Context context;
    int selection;

    public SwipeDeckAdapter(int selection,List<String> data, Context context) {
        this.data = data;
        this.context = context;
        this.selection = selection;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if(v == null){

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // normally use a viewholder

            if(selection==0){

                v = inflater.inflate(R.layout.card_view, parent, false);
            }else{
                v= inflater.inflate(R.layout.community_card,parent,false);
            }

        }
        ((TextView) v.findViewById(R.id.tv_reviews)).setText(data.get(position));

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = (String)getItem(position);
                Log.i("SwipeDeckAdapter", item);
            }
        });

        return v;
    }
}