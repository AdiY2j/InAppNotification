package com.example.inappnotification.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.inappnotification.Adapters.SubscriptionAdapter;
import com.example.inappnotification.R;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubscriptionActivity extends AppCompatActivity implements SubscriptionAdapter.OnTopicSelectListener {

    @BindView(R.id.rvRedemption)
    RecyclerView rvRedemption;

    private ArrayList<String> topicList = new ArrayList<>(Arrays.asList("Merchandise", "Mobile", "DTH", "Cards"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription);
        ButterKnife.bind(this);
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d("Hello", "onCreate: " + token);
        setupAdapter();
    }

    private void setupAdapter() {
        SubscriptionAdapter adapter = new SubscriptionAdapter(this, topicList, this);
        rvRedemption.setAdapter(adapter);
    }

    @Override
    public void onTopicSelected(String name) {
        FirebaseMessaging.getInstance().subscribeToTopic(name);
    }

    @Override
    public void onTopicUnSelected(String name) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic(name);
    }


}
