package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;

public final class LayoutTabMenuBinding implements a {
    public final RelativeLayout rlEmoticonTabTrash;
    private final RelativeLayout rootView;

    private LayoutTabMenuBinding(RelativeLayout relativeLayout0, RelativeLayout relativeLayout1) {
        this.rootView = relativeLayout0;
        this.rlEmoticonTabTrash = relativeLayout1;
    }

    public static LayoutTabMenuBinding bind(View view0) {
        RelativeLayout relativeLayout0 = (RelativeLayout)view0.findViewById(id.rl_emoticon_tab_trash);
        if(relativeLayout0 == null) {
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A0A02));  // id:rl_emoticon_tab_trash
        }
        return new LayoutTabMenuBinding(((RelativeLayout)view0), relativeLayout0);
    }

    @Override  // Q4.a
    public View getRoot() {
        return this.getRoot();
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutTabMenuBinding inflate(LayoutInflater layoutInflater0) {
        return LayoutTabMenuBinding.inflate(layoutInflater0, null, false);
    }

    public static LayoutTabMenuBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.layout_tab_menu, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return LayoutTabMenuBinding.bind(view0);
    }
}

