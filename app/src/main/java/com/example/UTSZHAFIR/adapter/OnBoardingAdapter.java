package com.example.UTSZHAFIR.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.UTSZHAFIR.fragment.OnBoarding1;
import com.example.UTSZHAFIR.fragment.OnBoarding2;
import com.example.UTSZHAFIR.fragment.OnBoarding3;
//17-05-2019-10116368-ZHAFIR-MAHDI-IF-8
public class OnBoardingAdapter extends FragmentPagerAdapter {
    private static int ITEM_COUNT = 3;

    public OnBoardingAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new OnBoarding1();
            case 1:
                return new OnBoarding2();
            case 2:
                return new OnBoarding3();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return ITEM_COUNT;
    }
}