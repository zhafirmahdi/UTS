package com.example.UTSZHAFIR.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.UTSZHAFIR.R;
import com.example.UTSZHAFIR.adapter.DailyActivityAdapter;
import com.example.UTSZHAFIR.adapter.FriendAdapter;
import com.example.UTSZHAFIR.model.DailyActivityModel;
import com.example.UTSZHAFIR.model.FriendModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyActivityFragment extends Fragment {
    RecyclerView recycle, recycleUser;
    NestedScrollView scroll;
    DailyActivityModel[] model;
    FriendModel[] friendModel;

    public DailyActivityFragment() {
        FriendModel us1 = new FriendModel(R.drawable.about_me, "Ashary", "Cibiru, Bandung"); //friendlist
        FriendModel us2 = new FriendModel(R.drawable.coding, "Jojo", "sekeloa, Bandung");
        FriendModel us3 = new FriendModel(R.drawable.coffe, "Mirecle", "Pajajaran, Bandung");
        FriendModel us4 = new FriendModel(R.drawable.contact_us, "Kaimot", "Antapani, Bandung");
        FriendModel us5 = new FriendModel(R.drawable.gaming, "Utuy", ", Bandung");
        FriendModel us6 = new FriendModel(R.drawable.onboarding_image, "Jason", "Padalarang");
        FriendModel us7 = new FriendModel(R.drawable.personal_info, "Isal;", "Cibaduyut, Bandung");
        FriendModel us8 = new FriendModel(R.drawable.reading, "Kai", "kopo, Bandung");
        friendModel = new FriendModel[]{us1,us2,us3,us4,us5,us6,us7,us8};


        // Required empty public constructor
        DailyActivityModel dal1 = new DailyActivityModel(
                new int[]{R.drawable.sss},
                "10 Minutes Ago",
                "Wonderful indonesia",
                "Danau Weekuri, Indonesia",
                "image1",
                50,
                4
        );

        model = new DailyActivityModel[]{dal1};
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layoutss for this fragment
        View root = inflater.inflate(R.layout.fragment_daily_activity, container, false);

        recycle = (RecyclerView) root.findViewById(R.id.recycle_daily);
        recycleUser = (RecyclerView) root.findViewById(R.id.recycle_user);
        scroll = (NestedScrollView) root.findViewById(R.id.gallery_scrollbar);
        LinearLayoutManager layout = new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        LinearLayoutManager layout2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean canScrollHorizontally() {
                return true;
            }

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        recycle.setNestedScrollingEnabled(false);
        recycleUser.setNestedScrollingEnabled(false);
        scroll.setNestedScrollingEnabled(false);
        recycle.setLayoutManager(layout);
        recycleUser.setLayoutManager(layout2);

        DailyActivityAdapter adapterFeed = new DailyActivityAdapter(getActivity(), model);
        recycle.setAdapter(adapterFeed);

        FriendAdapter adapterFriend = new FriendAdapter(getActivity(), friendModel);
        recycleUser.setAdapter(adapterFriend);

        return root;
    }

}
