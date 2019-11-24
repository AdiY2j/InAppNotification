package com.example.inappnotification.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.inappnotification.Adapters.TabAdapter;
import com.example.inappnotification.Fragments.FlipkartFragment;
import com.example.inappnotification.Fragments.HdfcFragment;
import com.example.inappnotification.Fragments.JioFragment;
import com.example.inappnotification.R;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.toolBar)
    Toolbar toolbar;

    private TabAdapter tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setAdapter();
        setToolbar();
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
    }

    private void setAdapter() {
        tabAdapter = new TabAdapter(getSupportFragmentManager(), 0);
        tabAdapter.addFragment(new JioFragment(), "Jio");
        tabAdapter.addFragment(new HdfcFragment(), "Hdfc");
        tabAdapter.addFragment(new FlipkartFragment(), "Flipkart");

        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
