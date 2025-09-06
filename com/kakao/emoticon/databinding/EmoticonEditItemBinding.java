package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;

public final class EmoticonEditItemBinding implements a {
    public final LinearLayout emoticonHandler;
    public final ImageView emoticonIcon;
    public final TextView emoticonSetName;
    public final LinearLayout layoutEdit;
    private final LinearLayout rootView;

    private EmoticonEditItemBinding(LinearLayout linearLayout0, LinearLayout linearLayout1, ImageView imageView0, TextView textView0, LinearLayout linearLayout2) {
        this.rootView = linearLayout0;
        this.emoticonHandler = linearLayout1;
        this.emoticonIcon = imageView0;
        this.emoticonSetName = textView0;
        this.layoutEdit = linearLayout2;
    }

    public static EmoticonEditItemBinding bind(View view0) {
        int v = id.emoticon_handler;
        View view1 = view0.findViewById(v);
        if(((LinearLayout)view1) != null) {
            v = id.emoticon_icon;
            View view2 = view0.findViewById(v);
            if(((ImageView)view2) != null) {
                v = id.emoticon_set_name;
                View view3 = view0.findViewById(v);
                if(((TextView)view3) != null) {
                    return new EmoticonEditItemBinding(((LinearLayout)view0), ((LinearLayout)view1), ((ImageView)view2), ((TextView)view3), ((LinearLayout)view0));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // Q4.a
    public View getRoot() {
        return this.getRoot();
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EmoticonEditItemBinding inflate(LayoutInflater layoutInflater0) {
        return EmoticonEditItemBinding.inflate(layoutInflater0, null, false);
    }

    public static EmoticonEditItemBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.emoticon_edit_item, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return EmoticonEditItemBinding.bind(view0);
    }
}

