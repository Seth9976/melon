package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;

public final class LayoutSectionviewEmptyBinding implements a {
    public final FrameLayout btnReload;
    public final ImageView ivReload;
    public final ImageView loadingImage;
    private final LinearLayout rootView;

    private LayoutSectionviewEmptyBinding(LinearLayout linearLayout0, FrameLayout frameLayout0, ImageView imageView0, ImageView imageView1) {
        this.rootView = linearLayout0;
        this.btnReload = frameLayout0;
        this.ivReload = imageView0;
        this.loadingImage = imageView1;
    }

    public static LayoutSectionviewEmptyBinding bind(View view0) {
        int v = id.btn_reload;
        FrameLayout frameLayout0 = (FrameLayout)view0.findViewById(v);
        if(frameLayout0 != null) {
            v = id.iv_reload;
            ImageView imageView0 = (ImageView)view0.findViewById(v);
            if(imageView0 != null) {
                v = id.loading_image;
                ImageView imageView1 = (ImageView)view0.findViewById(v);
                if(imageView1 != null) {
                    return new LayoutSectionviewEmptyBinding(((LinearLayout)view0), frameLayout0, imageView0, imageView1);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // Q4.a
    public View getRoot() {
        return this.getRoot();
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutSectionviewEmptyBinding inflate(LayoutInflater layoutInflater0) {
        return LayoutSectionviewEmptyBinding.inflate(layoutInflater0, null, false);
    }

    public static LayoutSectionviewEmptyBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.layout_sectionview_empty, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return LayoutSectionviewEmptyBinding.bind(view0);
    }
}

