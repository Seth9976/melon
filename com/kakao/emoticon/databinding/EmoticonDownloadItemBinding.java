package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;

public final class EmoticonDownloadItemBinding implements a {
    public final ImageView emoticonIcon;
    public final TextView emoticonSetEditor;
    public final TextView emoticonSetExpire;
    public final TextView emoticonSetName;
    public final ImageView ivAdd;
    public final LinearLayout layoutEdit;
    public final RelativeLayout rlDownload;
    private final RelativeLayout rootView;

    private EmoticonDownloadItemBinding(RelativeLayout relativeLayout0, ImageView imageView0, TextView textView0, TextView textView1, TextView textView2, ImageView imageView1, LinearLayout linearLayout0, RelativeLayout relativeLayout1) {
        this.rootView = relativeLayout0;
        this.emoticonIcon = imageView0;
        this.emoticonSetEditor = textView0;
        this.emoticonSetExpire = textView1;
        this.emoticonSetName = textView2;
        this.ivAdd = imageView1;
        this.layoutEdit = linearLayout0;
        this.rlDownload = relativeLayout1;
    }

    public static EmoticonDownloadItemBinding bind(View view0) {
        int v = id.emoticon_icon;
        View view1 = view0.findViewById(v);
        if(((ImageView)view1) != null) {
            v = id.emoticon_set_editor;
            View view2 = view0.findViewById(v);
            if(((TextView)view2) != null) {
                v = id.emoticon_set_expire;
                View view3 = view0.findViewById(v);
                if(((TextView)view3) != null) {
                    v = id.emoticon_set_name;
                    View view4 = view0.findViewById(v);
                    if(((TextView)view4) != null) {
                        v = id.iv_add;
                        View view5 = view0.findViewById(v);
                        if(((ImageView)view5) != null) {
                            v = id.layout_edit;
                            View view6 = view0.findViewById(v);
                            if(((LinearLayout)view6) != null) {
                                v = id.rl_download;
                                View view7 = view0.findViewById(v);
                                if(((RelativeLayout)view7) != null) {
                                    return new EmoticonDownloadItemBinding(((RelativeLayout)view0), ((ImageView)view1), ((TextView)view2), ((TextView)view3), ((TextView)view4), ((ImageView)view5), ((LinearLayout)view6), ((RelativeLayout)view7));
                                }
                            }
                        }
                    }
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

    public static EmoticonDownloadItemBinding inflate(LayoutInflater layoutInflater0) {
        return EmoticonDownloadItemBinding.inflate(layoutInflater0, null, false);
    }

    public static EmoticonDownloadItemBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.emoticon_download_item, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return EmoticonDownloadItemBinding.bind(view0);
    }
}

