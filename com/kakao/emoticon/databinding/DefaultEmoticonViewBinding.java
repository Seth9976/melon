package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.ui.FloatingLayout;

public final class DefaultEmoticonViewBinding implements a {
    public final FloatingLayout root;
    private final FloatingLayout rootView;

    private DefaultEmoticonViewBinding(FloatingLayout floatingLayout0, FloatingLayout floatingLayout1) {
        this.rootView = floatingLayout0;
        this.root = floatingLayout1;
    }

    public static DefaultEmoticonViewBinding bind(View view0) {
        if(view0 == null) {
            throw new NullPointerException("rootView");
        }
        return new DefaultEmoticonViewBinding(((FloatingLayout)view0), ((FloatingLayout)view0));
    }

    @Override  // Q4.a
    public View getRoot() {
        return this.getRoot();
    }

    public FloatingLayout getRoot() {
        return this.rootView;
    }

    public static DefaultEmoticonViewBinding inflate(LayoutInflater layoutInflater0) {
        return DefaultEmoticonViewBinding.inflate(layoutInflater0, null, false);
    }

    public static DefaultEmoticonViewBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.default_emoticon_view, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return DefaultEmoticonViewBinding.bind(view0);
    }
}

