package com.example.inappnotification.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.inappnotification.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HdfcFragment extends Fragment {


    @BindView(R.id.btnJio)
    Button btnJio;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hdfc, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btnJio)
    public void gotoJio(){

        getFragmentManager().popBackStack();

        getFragmentManager()
                .beginTransaction()
                .add(R.id.container, new JioFragment())
                .addToBackStack(null)
                .commit();
    }

}
