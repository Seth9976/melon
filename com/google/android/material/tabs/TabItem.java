package com.google.android.material.tabs;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import d5.m;
import d6.a;

public class TabItem extends View {
    public final CharSequence a;
    public final Drawable b;
    public final int c;

    public TabItem(Context context0) {
        this(context0, null);
    }

    public TabItem(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        m m0 = m.q(context0, attributeSet0, a.d0);
        TypedArray typedArray0 = (TypedArray)m0.c;
        this.a = typedArray0.getText(2);
        this.b = m0.k(0);
        this.c = typedArray0.getResourceId(1, 0);
        m0.t();
    }
}

