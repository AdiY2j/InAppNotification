package com.example.inappnotification.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.inappnotification.ContentProviders.MySuggestionProvider;
import com.example.inappnotification.Fragments.HdfcFragment;
import com.example.inappnotification.Fragments.JioFragment;
import com.example.inappnotification.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

public class DemoActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {


    @BindView(R.id.ivSearch)
    SearchView ivSearch;

    private static final String TAG = "DemoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        ButterKnife.bind(this);

        ivSearch.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
            SearchRecentSuggestions suggestions = new SearchRecentSuggestions(this,
                    MySuggestionProvider.AUTHORITY, MySuggestionProvider.MODE);
            suggestions.saveRecentQuery(s, null);

            Uri uri = Uri.parse("content://com.example.inappnotification.MySuggestionProvider/suggestions");
            Cursor cursor = getContentResolver().query(uri, null, null, null, "_id DESC"+ " LIMIT 5");
            if(cursor != null){
                cursor.moveToFirst();
                do{
                    Log.d(TAG, "onQueryTextSubmit: "+ " => "+ cursor.getString(cursor.getColumnIndexOrThrow("display1")));
                }while (cursor.moveToNext());
            }
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}
