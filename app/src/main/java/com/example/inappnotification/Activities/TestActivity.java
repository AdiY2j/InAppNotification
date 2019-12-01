package com.example.inappnotification.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.inappnotification.Adapters.OperatorAdapter;
import com.example.inappnotification.R;
import com.example.inappnotification.Utils.DividerItemDecorator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.rcList)
    RecyclerView rcList;

    private List<String> opList = new ArrayList<>();
    private OperatorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        setAdapter();
    }

    private void setAdapter() {
        setData();
        adapter = new OperatorAdapter(this, opList);
        rcList.setAdapter(adapter);

        RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecorator(ContextCompat.getDrawable(this, R.drawable.divider));
        rcList.addItemDecoration(dividerItemDecoration);
    }

    private void setData() {
        opList.add("Vodafone");
        opList.add("Jio");
        opList.add("Idea");
        opList.add("Airtel");
        opList.add("Reliance");
        opList.add("Uninor");
        opList.add("Dolphin");
        opList.add("MTNL");
        opList.add("BSNL");
    }
}
