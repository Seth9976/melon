package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;

public final class LayoutCustomBarBinding implements a {
    public final RelativeLayout rlBack;
    public final RelativeLayout rlGoStore;
    private final RelativeLayout rootView;
    public final TextView tvTitle;

    private LayoutCustomBarBinding(RelativeLayout relativeLayout0, RelativeLayout relativeLayout1, RelativeLayout relativeLayout2, TextView textView0) {
        this.rootView = relativeLayout0;
        this.rlBack = relativeLayout1;
        this.rlGoStore = relativeLayout2;
        this.tvTitle = textView0;
    }

    public static LayoutCustomBarBinding bind(View view0) {
        int v = id.rl_back;
        RelativeLayout relativeLayout0 = (RelativeLayout)view0.findViewById(v);
        if(relativeLayout0 != null) {
            v = id.rl_go_store;
            RelativeLayout relativeLayout1 = (RelativeLayout)view0.findViewById(v);
            if(relativeLayout1 != null) {
                v = id.tv_title;
                TextView textView0 = (TextView)view0.findViewById(v);
                if(textView0 != null) {
                    return new LayoutCustomBarBinding(((RelativeLayout)view0), relativeLayout0, relativeLayout1, textView0);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // Q4.a
    public View getRoot() {
        return this.getRoot();
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutCustomBarBinding inflate(LayoutInflater layoutInflater0) {
        return LayoutCustomBarBinding.inflate(layoutInflater0, null, false);
    }

    public static LayoutCustomBarBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.layout_custom_bar, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return LayoutCustomBarBinding.bind(view0);
    }
}

