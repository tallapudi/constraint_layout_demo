package com.example.vamsi.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.daprlabs.cardstack.SwipeDeck;
import com.example.vamsi.myapplication.R;
import com.example.vamsi.myapplication.adapters.SwipeDeckAdapter;

import java.util.ArrayList;

/**
 * Created by SAURAV on 9/6/2016.
 */

public class CommunitiesFragment extends Fragment {

    SwipeDeck cardStack;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_experts, container, false);
        cardStack = (SwipeDeck) v.findViewById(R.id.swipe_deck);

        final ArrayList<String> testData = new ArrayList<>();
        testData.add("Food and Diet Tips for a Healthier Life");
        testData.add("10 Things you should eat");
        testData.add("5 Things you should stay away from");
        testData.add("Top 7 apps for Health and Fitness");
        testData.add("Whom should you follow for healthy life tips");

        final SwipeDeckAdapter adapter = new SwipeDeckAdapter(1, testData, getContext());
        cardStack.setAdapter(adapter);

        cardStack.setEventCallback(new SwipeDeck.SwipeEventCallback() {
            @Override
            public void cardSwipedLeft(int position) {
                Log.i("MainActivity", "card was swiped left, position in adapter: " + position);
            }

            @Override
            public void cardSwipedRight(int position) {
                Log.i("MainActivity", "card was swiped right, position in adapter: " + position);
            }

            @Override
            public void cardsDepleted() {
                Log.i("MainActivity", "no more cards");
            }

            @Override
            public void cardActionDown() {

            }

            @Override
            public void cardActionUp() {

            }
        });
        return v;
    }
}
