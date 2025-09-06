package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;

public final class EmoticonSetItemBinding implements a {
    public final FrameLayout flEmoticonSetBg;
    public final ImageView imgEmoticonSetIcon;
    private final FrameLayout rootView;

    private EmoticonSetItemBinding(FrameLayout frameLayout0, FrameLayout frameLayout1, ImageView imageView0) {
        this.rootView = frameLayout0;
        this.flEmoticonSetBg = frameLayout1;
        this.imgEmoticonSetIcon = imageView0;
    }

    public static EmoticonSetItemBinding bind(View view0) {
        ImageView imageView0 = (ImageView)view0.findViewById(id.img_emoticon_set_icon);
        if(imageView0 == null) {
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A0561));  // id:img_emoticon_set_icon
        }
        return new EmoticonSetItemBinding(((FrameLayout)view0), ((FrameLayout)view0), imageView0);
    }

    @Override  // Q4.a
    public View getRoot() {
        return this.getRoot();
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static EmoticonSetItemBinding inflate(LayoutInflater layoutInflater0) {
        return EmoticonSetItemBinding.inflate(layoutInflater0, null, false);
    }

    public static EmoticonSetItemBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.emoticon_set_item, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return EmoticonSetItemBinding.bind(view0);
    }
}

