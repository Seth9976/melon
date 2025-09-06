package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.ui.widget.EmoticonView;

public final class EmoticonExpireItemBinding implements a {
    public final Button btnPurchase;
    public final Button btnTabRemove;
    public final EmoticonView emoticonView;
    public final RelativeLayout expireTop;
    private final RelativeLayout rootView;
    public final RelativeLayout rvMore;
    public final RelativeLayout titleBox;
    public final TextView tvExpire;
    public final TextView tvTitle;

    private EmoticonExpireItemBinding(RelativeLayout relativeLayout0, Button button0, Button button1, EmoticonView emoticonView0, RelativeLayout relativeLayout1, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TextView textView0, TextView textView1) {
        this.rootView = relativeLayout0;
        this.btnPurchase = button0;
        this.btnTabRemove = button1;
        this.emoticonView = emoticonView0;
        this.expireTop = relativeLayout1;
        this.rvMore = relativeLayout2;
        this.titleBox = relativeLayout3;
        this.tvExpire = textView0;
        this.tvTitle = textView1;
    }

    public static EmoticonExpireItemBinding bind(View view0) {
        int v = id.btn_purchase;
        View view1 = view0.findViewById(v);
        if(((Button)view1) != null) {
            v = id.btn_tab_remove;
            View view2 = view0.findViewById(v);
            if(((Button)view2) != null) {
                v = id.emoticon_view;
                View view3 = view0.findViewById(v);
                if(((EmoticonView)view3) != null) {
                    View view4 = view0.findViewById(id.expire_top);
                    View view5 = view0.findViewById(id.rv_more);
                    View view6 = view0.findViewById(id.title_box);
                    v = id.tv_expire;
                    View view7 = view0.findViewById(v);
                    if(((TextView)view7) != null) {
                        v = id.tv_title;
                        View view8 = view0.findViewById(v);
                        if(((TextView)view8) != null) {
                            return new EmoticonExpireItemBinding(((RelativeLayout)view0), ((Button)view1), ((Button)view2), ((EmoticonView)view3), ((RelativeLayout)view4), ((RelativeLayout)view5), ((RelativeLayout)view6), ((TextView)view7), ((TextView)view8));
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

    public static EmoticonExpireItemBinding inflate(LayoutInflater layoutInflater0) {
        return EmoticonExpireItemBinding.inflate(layoutInflater0, null, false);
    }

    public static EmoticonExpireItemBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.emoticon_expire_item, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return EmoticonExpireItemBinding.bind(view0);
    }
}

