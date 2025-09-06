package com.kakao.emoticon.databinding;

import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;

public final class EmoticonLoginItemBinding implements a {
    public final FrameLayout btnLogin;
    public final TextView comKakaoLoginBtn;
    public final ImageView ivRyan;
    private final RelativeLayout rootView;
    public final TextView tvLoginMsg;

    private EmoticonLoginItemBinding(RelativeLayout relativeLayout0, FrameLayout frameLayout0, TextView textView0, ImageView imageView0, TextView textView1) {
        this.rootView = relativeLayout0;
        this.btnLogin = frameLayout0;
        this.comKakaoLoginBtn = textView0;
        this.ivRyan = imageView0;
        this.tvLoginMsg = textView1;
    }

    public static EmoticonLoginItemBinding bind(View view0) {
        int v = id.btn_login;
        View view1 = view0.findViewById(v);
        if(((FrameLayout)view1) != null) {
            v = id.com_kakao_login_btn;
            View view2 = view0.findViewById(v);
            if(((TextView)view2) != null) {
                View view3 = view0.findViewById(id.iv_ryan);
                v = id.tv_login_msg;
                View view4 = view0.findViewById(v);
                if(((TextView)view4) != null) {
                    return new EmoticonLoginItemBinding(((RelativeLayout)view0), ((FrameLayout)view1), ((TextView)view2), ((ImageView)view3), ((TextView)view4));
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

    public static EmoticonLoginItemBinding inflate(LayoutInflater layoutInflater0) {
        return EmoticonLoginItemBinding.inflate(layoutInflater0, null, false);
    }

    public static EmoticonLoginItemBinding inflate(LayoutInflater layoutInflater0, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.emoticon_login_item, viewGroup0, false);
        if(z) {
            viewGroup0.addView(view0);
        }
        return EmoticonLoginItemBinding.bind(view0);
    }
}

