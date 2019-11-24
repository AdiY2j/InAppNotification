package com.example.inappnotification.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.inappnotification.Fragments.HdfcFragment;
import com.example.inappnotification.Fragments.JioFragment;
import com.example.inappnotification.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

public class DemoActivity extends AppCompatActivity {

    @BindView(R.id.tvToolbarTitle)
    TextView tvTitle;
    @BindView(R.id.ivSearch)
    ImageView ivSearch;
    @BindView(R.id.ivBack)
    ImageView ivBack;
    @BindView(R.id.searchLayout)
    TextInputLayout searchLayout;
    @BindView(R.id.etSearchBox)
    TextInputEditText etSearchBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.ivBack)
    public void goBack(){
        etSearchBox.setText("");
        hideSearchBox();
        getSupportFragmentManager().popBackStack();
    }

    @OnClick(R.id.ivSearch)
    public void search(){
        showSearchBox();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new HdfcFragment())
                .addToBackStack(null)
                .commit();
    }

    @OnTouch(R.id.etSearchBox)
    public boolean onTouch(MotionEvent event){
        final int DRAWABLE_LEFT = 0;
        final int DRAWABLE_TOP = 1;
        final int DRAWABLE_RIGHT = 2;
        final int DRAWABLE_BOTTOM = 3;

        if(event.getAction() == MotionEvent.ACTION_UP) {
            if(event.getRawX() >= (etSearchBox.getRight() - etSearchBox.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                etSearchBox.setText("");
                return true;
            }
        }
        return false;
    }


    private void showSearchBox() {
        if(ivSearch.getVisibility() == View.VISIBLE){
            tvTitle.setVisibility(View.GONE);
            ivSearch.setVisibility(View.GONE);
            searchLayout.setVisibility(View.VISIBLE);
            ivBack.setVisibility(View.VISIBLE);
        }
    }

    private void hideSearchBox() {
        if(ivBack.getVisibility() == View.VISIBLE){
            searchLayout.setVisibility(View.GONE);
            ivBack.setVisibility(View.GONE);
            tvTitle.setVisibility(View.VISIBLE);
            ivSearch.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        }else{
            goBack();
        }
    }


}
