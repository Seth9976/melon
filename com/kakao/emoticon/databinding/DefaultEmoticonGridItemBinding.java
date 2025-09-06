package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.ui.widget.EmoticonView;

public final class DefaultEmoticonGridItemBinding implements a {
    public final EmoticonView emoticonIcon;
    public final FrameLayout root;
    private final FrameLayout rootView;

    private DefaultEmoticonGridItemBinding(FrameLayout frameLayout0, EmoticonView emoticonView0, FrameLayout frameLayout1) {
        this.rootView = frameLayout0;
        this.emoticonIcon = emoticonView0;
        this.root = frameLayout1;
    }

    public static DefaultEmoticonGridItemBinding bind(View view0) {
        EmoticonView emoticonView0 = (EmoticonView)view0.findViewById(id.emoticon_icon);
        if(emoticonView0 == null) {
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A0419));  // id:emoticon_icon
        }
        return new DefaultEmoticonGridItemBinding(((FrameLayout)view0), emoticonView0, ((FrameLayout)view0));
    }

    @Override  // Q4.a
    public View getRoot() {
        return this.getRoot();
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DefaultEmoticonGridItemBinding inflate(LayoutInflater layoutInflater0) {
        return DefaultEmoticonGridItemBinding.inflate(layoutInflater0, null, false);
    }

    public static DefaultEmoticonGridItemBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.default_emoticon_grid_item, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return DefaultEmoticonGridItemBinding.bind(view0);
    }
}

