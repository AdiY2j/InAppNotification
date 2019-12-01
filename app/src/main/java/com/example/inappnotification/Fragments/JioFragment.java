package com.example.inappnotification.Fragments;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.inappnotification.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class JioFragment extends Fragment {

    @BindView(R.id.btnExit)
    Button btnExit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_jio, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @OnClick(R.id.btnExit)
    public void showDialog(){
        BottomSheetDialog dialog = new BottomSheetDialog(getActivity());
        dialog.setContentView(R.layout.alert_dialog_layout);
        dialog.show();
    }

}
