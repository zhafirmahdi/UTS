package com.example.UTSZHAFIR.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.UTSZHAFIR.R;
import com.example.UTSZHAFIR.adapter.GalleryAdapter;
import com.example.UTSZHAFIR.model.GalleryModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {

    RecyclerView recycle;
    GalleryModel[] images;
    NestedScrollView scroll;

    public GalleryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);


        recycle = (RecyclerView) root.findViewById(R.id.recyclerview);
        scroll = (NestedScrollView) root.findViewById(R.id.gallery_scrollbar);
        GridLayoutManager layout = new GridLayoutManager(getActivity(), 2) {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        recycle.setNestedScrollingEnabled(false);
        recycle.setLayoutManager(layout);

        GalleryModel gal1 = new GalleryModel(
                R.drawable.sss,
                "Danau",
                "Sumba, Indonesia");
        GalleryModel gal2 = new GalleryModel(
                R.drawable.sss2,
                "Pegunungan",
                "Semarang, Indonesia");
        GalleryModel gal3 = new GalleryModel(
                R.drawable.sss3,
                "Vanesia",
                "Venice, Italia");
        GalleryModel gal4 = new GalleryModel(
                R.drawable.cofi,
                "Coffe Shop",
                "Bandung, Indonesia");


        images = new GalleryModel[]{gal1, gal2, gal3, gal4,};
        GalleryAdapter myAdapter = new GalleryAdapter(getActivity(), images);
        recycle.setAdapter(myAdapter);

        return root;
    }

}
