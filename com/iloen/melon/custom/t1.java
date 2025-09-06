package com.iloen.melon.custom;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public final class t1 extends ToolBarItem {
    public Drawable d;
    public String e;
    public int f;
    public float g;

    public t1(Context context0, int v, int v1) {
        this.c = -1;
        this.a = context0;
        this.b = (ViewGroup)LayoutInflater.from(context0).inflate(0x7F0D089E, null);  // layout:toolbar_view_item
        this.d = null;
        this.e = null;
        this.f = -1;
        this.g = 11.0f;
        if(v != -1) {
            Drawable drawable0 = this.a.getResources().getDrawable(v);
            if(this.d != null) {
                this.d = null;
            }
            this.d = drawable0;
        }
        if(v1 == -1) {
            return;
        }
        String s = this.a.getResources().getString(v1);
        if(this.e != null) {
            this.e = null;
        }
        this.e = s;
    }
}

