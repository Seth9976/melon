package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;

public final class EmoticonAlertBinding implements a {
    public final Button btnNegative;
    public final Button btnPositive;
    public final CheckBox cbEmoticonDialog;
    public final ImageView ivMsgImg;
    public final RelativeLayout rlDialogBg;
    private final RelativeLayout rootView;
    public final TextView tvMsg;
    public final TextView tvTitle;

    private EmoticonAlertBinding(RelativeLayout relativeLayout0, Button button0, Button button1, CheckBox checkBox0, ImageView imageView0, RelativeLayout relativeLayout1, TextView textView0, TextView textView1) {
        this.rootView = relativeLayout0;
        this.btnNegative = button0;
        this.btnPositive = button1;
        this.cbEmoticonDialog = checkBox0;
        this.ivMsgImg = imageView0;
        this.rlDialogBg = relativeLayout1;
        this.tvMsg = textView0;
        this.tvTitle = textView1;
    }

    public static EmoticonAlertBinding bind(View view0) {
        int v = id.btn_negative;
        View view1 = view0.findViewById(v);
        if(((Button)view1) != null) {
            v = id.btn_positive;
            View view2 = view0.findViewById(v);
            if(((Button)view2) != null) {
                v = id.cb_emoticon_dialog;
                View view3 = view0.findViewById(v);
                if(((CheckBox)view3) != null) {
                    v = id.iv_msg_img;
                    View view4 = view0.findViewById(v);
                    if(((ImageView)view4) != null) {
                        v = id.tv_msg;
                        View view5 = view0.findViewById(v);
                        if(((TextView)view5) != null) {
                            v = id.tv_title;
                            View view6 = view0.findViewById(v);
                            if(((TextView)view6) != null) {
                                return new EmoticonAlertBinding(((RelativeLayout)view0), ((Button)view1), ((Button)view2), ((CheckBox)view3), ((ImageView)view4), ((RelativeLayout)view0), ((TextView)view5), ((TextView)view6));
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

    public static EmoticonAlertBinding inflate(LayoutInflater layoutInflater0) {
        return EmoticonAlertBinding.inflate(layoutInflater0, null, false);
    }

    public static EmoticonAlertBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.emoticon_alert, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return EmoticonAlertBinding.bind(view0);
    }
}

