package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;

public final class LayoutListGuideBinding implements a {
    private final LinearLayout rootView;
    public final TextView tvListGuide;

    private LayoutListGuideBinding(LinearLayout linearLayout0, TextView textView0) {
        this.rootView = linearLayout0;
        this.tvListGuide = textView0;
    }

    public static LayoutListGuideBinding bind(View view0) {
        TextView textView0 = (TextView)view0.findViewById(id.tv_list_guide);
        if(textView0 == null) {
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A0CA0));  // id:tv_list_guide
        }
        return new LayoutListGuideBinding(((LinearLayout)view0), textView0);
    }

    @Override  // Q4.a
    public View getRoot() {
        return this.getRoot();
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutListGuideBinding inflate(LayoutInflater layoutInflater0) {
        return LayoutListGuideBinding.inflate(layoutInflater0, null, false);
    }

    public static LayoutListGuideBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.layout_list_guide, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return LayoutListGuideBinding.bind(view0);
    }
}

