package com.google.android.material.progressindicator;

import O4.p;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import v6.d;
import v6.e;
import v6.f;
import v6.h;
import v6.j;
import v6.o;

public class CircularProgressIndicator extends d {
    public static final int l;

    public CircularProgressIndicator(Context context0) {
        this(context0, null);
    }

    public CircularProgressIndicator(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040136);  // attr:circularProgressIndicatorStyle
    }

    public CircularProgressIndicator(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v, 0x7F14049C);  // style:Widget.MaterialComponents.CircularProgressIndicator
        f f0 = new f(((CircularProgressIndicatorSpec)this.a));  // 初始化器: Lv6/n;-><init>(Lv6/e;)V
        Context context1 = this.getContext();
        h h0 = new h(((CircularProgressIndicatorSpec)this.a));
        o o0 = new o(context1, ((CircularProgressIndicatorSpec)this.a), f0, h0);
        Resources resources0 = context1.getResources();
        p p0 = new p();
        p0.a = resources0.getDrawable(0x7F080690, null);  // drawable:indeterminate_static
        new O4.o(p0.a.getConstantState());
        o0.n = p0;
        this.setIndeterminateDrawable(o0);
        this.setProgressDrawable(new j(this.getContext(), ((CircularProgressIndicatorSpec)this.a), f0));
    }

    @Override  // v6.d
    public final e a(Context context0, AttributeSet attributeSet0) {
        return new CircularProgressIndicatorSpec(context0, attributeSet0);
    }

    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec)this.a).j;
    }

    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec)this.a).i;
    }

    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec)this.a).h;
    }

    public void setIndicatorDirection(int v) {
        ((CircularProgressIndicatorSpec)this.a).j = v;
        this.invalidate();
    }

    public void setIndicatorInset(int v) {
        e e0 = this.a;
        if(((CircularProgressIndicatorSpec)e0).i != v) {
            ((CircularProgressIndicatorSpec)e0).i = v;
            this.invalidate();
        }
    }

    public void setIndicatorSize(int v) {
        int v1 = Math.max(v, this.getTrackThickness() * 2);
        e e0 = this.a;
        if(((CircularProgressIndicatorSpec)e0).h != v1) {
            ((CircularProgressIndicatorSpec)e0).h = v1;
            ((CircularProgressIndicatorSpec)e0).a();
            this.requestLayout();
            this.invalidate();
        }
    }

    @Override  // v6.d
    public void setTrackThickness(int v) {
        super.setTrackThickness(v);
        ((CircularProgressIndicatorSpec)this.a).a();
    }
}

