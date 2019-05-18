package com.example.UTSZHAFIR.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.UTSZHAFIR.R;
//17-05-2019-10116368-ZHAFIR-MAHDI-IF-8
/**
 * A simple {@link Fragment} subclass.
 */
public class BiodataFragment extends Fragment {


    public BiodataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layoutss for this fragment
        return inflater.inflate(R.layout.fragment_biodata, container, false);
    }

}
