package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kakao.emoticon.R.layout;

public final class EmoticonGridViewBinding implements a {
    public final RecyclerView emoticonGrid;
    private final RecyclerView rootView;

    private EmoticonGridViewBinding(RecyclerView recyclerView0, RecyclerView recyclerView1) {
        this.rootView = recyclerView0;
        this.emoticonGrid = recyclerView1;
    }

    public static EmoticonGridViewBinding bind(View view0) {
        if(view0 == null) {
            throw new NullPointerException("rootView");
        }
        return new EmoticonGridViewBinding(((RecyclerView)view0), ((RecyclerView)view0));
    }

    @Override  // Q4.a
    public View getRoot() {
        return this.getRoot();
    }

    public RecyclerView getRoot() {
        return this.rootView;
    }

    public static EmoticonGridViewBinding inflate(LayoutInflater layoutInflater0) {
        return EmoticonGridViewBinding.inflate(layoutInflater0, null, false);
    }

    public static EmoticonGridViewBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.emoticon_grid_view, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return EmoticonGridViewBinding.bind(view0);
    }
}

