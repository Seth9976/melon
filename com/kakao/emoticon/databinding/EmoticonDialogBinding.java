package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;

public final class EmoticonDialogBinding implements a {
    public final FrameLayout emoticonLayout;
    private final RelativeLayout rootView;

    private EmoticonDialogBinding(RelativeLayout relativeLayout0, FrameLayout frameLayout0) {
        this.rootView = relativeLayout0;
        this.emoticonLayout = frameLayout0;
    }

    public static EmoticonDialogBinding bind(View view0) {
        FrameLayout frameLayout0 = (FrameLayout)view0.findViewById(id.emoticon_layout);
        if(frameLayout0 == null) {
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A041B));  // id:emoticon_layout
        }
        return new EmoticonDialogBinding(((RelativeLayout)view0), frameLayout0);
    }

    @Override  // Q4.a
    public View getRoot() {
        return this.getRoot();
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static EmoticonDialogBinding inflate(LayoutInflater layoutInflater0) {
        return EmoticonDialogBinding.inflate(layoutInflater0, null, false);
    }

    public static EmoticonDialogBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.emoticon_dialog, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return EmoticonDialogBinding.bind(view0);
    }
}

