package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.kakao.emoticon.R.layout;

public final class EmoticonCircleProgressBinding implements a {
    private final ProgressBar rootView;

    private EmoticonCircleProgressBinding(ProgressBar progressBar0) {
        this.rootView = progressBar0;
    }

    public static EmoticonCircleProgressBinding bind(View view0) {
        if(view0 == null) {
            throw new NullPointerException("rootView");
        }
        return new EmoticonCircleProgressBinding(((ProgressBar)view0));
    }

    @Override  // Q4.a
    public View getRoot() {
        return this.getRoot();
    }

    public ProgressBar getRoot() {
        return this.rootView;
    }

    public static EmoticonCircleProgressBinding inflate(LayoutInflater layoutInflater0) {
        return EmoticonCircleProgressBinding.inflate(layoutInflater0, null, false);
    }

    public static EmoticonCircleProgressBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.emoticon_circle_progress, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return EmoticonCircleProgressBinding.bind(view0);
    }
}

