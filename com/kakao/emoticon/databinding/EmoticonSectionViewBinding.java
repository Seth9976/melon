package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.ui.EmoticonSectionView;
import com.kakao.emoticon.ui.widget.EmptyRetryView;

public final class EmoticonSectionViewBinding implements a {
    public final EmoticonSectionView emoticonRoot;
    public final EmptyRetryView empty;
    public final ViewPager keyboardViewpager;
    private final EmoticonSectionView rootView;
    public final RecyclerView tabRecyclerview;
    public final View vBottomLine;
    public final View vContentDim;
    public final View vTopLine;

    private EmoticonSectionViewBinding(EmoticonSectionView emoticonSectionView0, EmoticonSectionView emoticonSectionView1, EmptyRetryView emptyRetryView0, ViewPager viewPager0, RecyclerView recyclerView0, View view0, View view1, View view2) {
        this.rootView = emoticonSectionView0;
        this.emoticonRoot = emoticonSectionView1;
        this.empty = emptyRetryView0;
        this.keyboardViewpager = viewPager0;
        this.tabRecyclerview = recyclerView0;
        this.vBottomLine = view0;
        this.vContentDim = view1;
        this.vTopLine = view2;
    }

    public static EmoticonSectionViewBinding bind(View view0) {
        int v = 0x1020004;
        View view1 = view0.findViewById(0x1020004);
        if(((EmptyRetryView)view1) != null) {
            v = id.keyboard_viewpager;
            View view2 = view0.findViewById(v);
            if(((ViewPager)view2) != null) {
                v = id.tab_recyclerview;
                View view3 = view0.findViewById(v);
                if(((RecyclerView)view3) != null) {
                    v = id.v_bottom_line;
                    View view4 = view0.findViewById(v);
                    if(view4 != null) {
                        v = id.v_content_dim;
                        View view5 = view0.findViewById(v);
                        if(view5 != null) {
                            v = id.v_top_line;
                            View view6 = view0.findViewById(v);
                            if(view6 != null) {
                                return new EmoticonSectionViewBinding(((EmoticonSectionView)view0), ((EmoticonSectionView)view0), ((EmptyRetryView)view1), ((ViewPager)view2), ((RecyclerView)view3), view4, view5, view6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // Q4.a
    public View getRoot() {
        return this.getRoot();
    }

    public EmoticonSectionView getRoot() {
        return this.rootView;
    }

    public static EmoticonSectionViewBinding inflate(LayoutInflater layoutInflater0) {
        return EmoticonSectionViewBinding.inflate(layoutInflater0, null, false);
    }

    public static EmoticonSectionViewBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.emoticon_section_view, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return EmoticonSectionViewBinding.bind(view0);
    }
}

