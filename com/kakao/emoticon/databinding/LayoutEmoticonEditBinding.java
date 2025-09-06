package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;

public final class LayoutEmoticonEditBinding implements a {
    public final Button btnDelete;
    public final LinearLayout emoticonEditEmpty;
    public final RecyclerView emoticonSetList;
    private final RelativeLayout rootView;

    private LayoutEmoticonEditBinding(RelativeLayout relativeLayout0, Button button0, LinearLayout linearLayout0, RecyclerView recyclerView0) {
        this.rootView = relativeLayout0;
        this.btnDelete = button0;
        this.emoticonEditEmpty = linearLayout0;
        this.emoticonSetList = recyclerView0;
    }

    public static LayoutEmoticonEditBinding bind(View view0) {
        int v = id.btn_delete;
        Button button0 = (Button)view0.findViewById(v);
        if(button0 != null) {
            v = id.emoticon_edit_empty;
            LinearLayout linearLayout0 = (LinearLayout)view0.findViewById(v);
            if(linearLayout0 != null) {
                v = id.emoticon_set_list;
                RecyclerView recyclerView0 = (RecyclerView)view0.findViewById(v);
                if(recyclerView0 != null) {
                    return new LayoutEmoticonEditBinding(((RelativeLayout)view0), button0, linearLayout0, recyclerView0);
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

    public static LayoutEmoticonEditBinding inflate(LayoutInflater layoutInflater0) {
        return LayoutEmoticonEditBinding.inflate(layoutInflater0, null, false);
    }

    public static LayoutEmoticonEditBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.layout_emoticon_edit, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return LayoutEmoticonEditBinding.bind(view0);
    }
}

