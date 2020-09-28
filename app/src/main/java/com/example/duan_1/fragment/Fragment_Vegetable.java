package com.example.duan_1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.duan_1.activity.MainActivity;
import com.example.duan_1.adapter.Adapter_Vergetable;
import com.example.duan_1.R;
import com.google.android.material.tabs.TabLayout;

public class Fragment_Vegetable extends Fragment implements View.OnClickListener {
    ViewPager viewPager_Thit ;
    TabLayout tabLayout_Thit ;
    ImageView img_back_LayoutRau, img_Cart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment__thit, container, false);
        viewPager_Thit = view.findViewById(R.id.viewPage_thit);
        img_Cart = view.findViewById(R.id.img_Cart_Thit);
        tabLayout_Thit = view.findViewById(R.id.tabLayOut_Thit);
        img_back_LayoutRau = view.findViewById(R.id.img_back_LayoutThit);
        img_back_LayoutRau.setOnClickListener(this);

        Adapter_Vergetable adapter_viewpager =new Adapter_Vergetable(getChildFragmentManager(), 1);
        viewPager_Thit.setAdapter(adapter_viewpager);
        tabLayout_Thit.setupWithViewPager(viewPager_Thit);

        img_Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment = new Fragment_Giohang();
                fragmentTransaction.add(R.id.layout_Main, fragment).commit();
                fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
            }
        });

        return  view;
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back_LayoutThit:
                ((MainActivity)getActivity()).closeFr();
                break;
        }
    }
}
