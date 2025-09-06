package com.iloen.melon.custom;

import android.view.View.OnClickListener;
import android.view.View;

public final class n1 implements View.OnClickListener {
    public final int a;
    public final ToUserView b;

    public n1(ToUserView toUserView0, int v) {
        this.a = v;
        this.b = toUserView0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            ToUserView toUserView0 = this.b;
            View.OnClickListener view$OnClickListener0 = toUserView0.b;
            if(view$OnClickListener0 != null) {
                view$OnClickListener0.onClick(toUserView0);
            }
            return;
        }
        ToUserView toUserView1 = this.b;
        View.OnClickListener view$OnClickListener1 = toUserView1.c;
        if(view$OnClickListener1 != null) {
            view$OnClickListener1.onClick(toUserView1);
        }
    }
}

