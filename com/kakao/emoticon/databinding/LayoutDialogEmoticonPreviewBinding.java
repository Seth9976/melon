package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.ui.widget.EmoticonView;

public final class LayoutDialogEmoticonPreviewBinding implements a {
    public final Button btnPlaybtn;
    public final EmoticonView emoticonView;
    public final RelativeLayout rlShare;
    public final FrameLayout root;
    private final FrameLayout rootView;
    public final TextView tvEmoticonArtist;
    public final TextView tvEmoticonEmpty;
    public final TextView tvEmoticonMore;
    public final TextView tvEmoticonMoreOver;
    public final TextView tvEmoticonTitle;

    private LayoutDialogEmoticonPreviewBinding(FrameLayout frameLayout0, Button button0, EmoticonView emoticonView0, RelativeLayout relativeLayout0, FrameLayout frameLayout1, TextView textView0, TextView textView1, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = frameLayout0;
        this.btnPlaybtn = button0;
        this.emoticonView = emoticonView0;
        this.rlShare = relativeLayout0;
        this.root = frameLayout1;
        this.tvEmoticonArtist = textView0;
        this.tvEmoticonEmpty = textView1;
        this.tvEmoticonMore = textView2;
        this.tvEmoticonMoreOver = textView3;
        this.tvEmoticonTitle = textView4;
    }

    public static LayoutDialogEmoticonPreviewBinding bind(View view0) {
        int v = id.btn_playbtn;
        View view1 = view0.findViewById(v);
        if(((Button)view1) != null) {
            v = id.emoticon_view;
            View view2 = view0.findViewById(v);
            if(((EmoticonView)view2) != null) {
                v = id.rl_share;
                View view3 = view0.findViewById(v);
                if(((RelativeLayout)view3) != null) {
                    v = id.tv_emoticon_artist;
                    View view4 = view0.findViewById(v);
                    if(((TextView)view4) != null) {
                        v = id.tv_emoticon_empty;
                        View view5 = view0.findViewById(v);
                        if(((TextView)view5) != null) {
                            v = id.tv_emoticon_more;
                            View view6 = view0.findViewById(v);
                            if(((TextView)view6) != null) {
                                v = id.tv_emoticon_more_over;
                                View view7 = view0.findViewById(v);
                                if(((TextView)view7) != null) {
                                    v = id.tv_emoticon_title;
                                    View view8 = view0.findViewById(v);
                                    if(((TextView)view8) != null) {
                                        return new LayoutDialogEmoticonPreviewBinding(((FrameLayout)view0), ((Button)view1), ((EmoticonView)view2), ((RelativeLayout)view3), ((FrameLayout)view0), ((TextView)view4), ((TextView)view5), ((TextView)view6), ((TextView)view7), ((TextView)view8));
                                    }
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

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LayoutDialogEmoticonPreviewBinding inflate(LayoutInflater layoutInflater0) {
        return LayoutDialogEmoticonPreviewBinding.inflate(layoutInflater0, null, false);
    }

    public static LayoutDialogEmoticonPreviewBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.layout_dialog_emoticon_preview, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return LayoutDialogEmoticonPreviewBinding.bind(view0);
    }
}

