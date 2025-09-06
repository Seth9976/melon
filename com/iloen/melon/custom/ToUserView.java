package com.iloen.melon.custom;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ToUserView extends LinearLayout {
    public TextView a;
    public View.OnClickListener b;
    public View.OnClickListener c;

    public ToUserView(Context context0) {
        super(context0);
        this.a(-1);
    }

    public final void a(int v) {
        LayoutInflater layoutInflater0 = (LayoutInflater)this.getContext().getSystemService("layout_inflater");
        if(v == -1) {
            v = 0x7F0D0897;  // layout:to_user_view
        }
        layoutInflater0.inflate(v, this);
        this.a = (TextView)this.findViewById(0x7F0A0B49);  // id:text
        if(!TextUtils.isEmpty(null)) {
            this.a.setText(null);
        }
        this.a.setOnClickListener(new n1(this, 0));
        this.findViewById(0x7F0A02C7).setOnClickListener(new n1(this, 1));  // id:close
    }

    public void setOnContentClickListener(View.OnClickListener view$OnClickListener0) {
        this.c = view$OnClickListener0;
    }

    public void setOnDeleteBtnClickListener(View.OnClickListener view$OnClickListener0) {
        this.b = view$OnClickListener0;
    }

    public void setText(String s) {
        TextView textView0 = this.a;
        if(textView0 != null) {
            textView0.setText(s);
        }
    }
}

