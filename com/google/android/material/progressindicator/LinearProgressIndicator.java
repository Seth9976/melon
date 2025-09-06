package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import v6.d;
import v6.e;
import v6.j;
import v6.o;
import v6.p;
import v6.q;
import v6.s;

public class LinearProgressIndicator extends d {
    public static final int l;

    public LinearProgressIndicator(Context context0) {
        this(context0, null);
    }

    public LinearProgressIndicator(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F0403B8);  // attr:linearProgressIndicatorStyle
    }

    public LinearProgressIndicator(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v, 0x7F1404A8);  // style:Widget.MaterialComponents.LinearProgressIndicator
        LinearProgressIndicatorSpec linearProgressIndicatorSpec0 = (LinearProgressIndicatorSpec)this.a;
        p p0 = new p(linearProgressIndicatorSpec0);  // 初始化器: Lv6/n;-><init>(Lv6/e;)V
        p0.b = 300.0f;
        Context context1 = this.getContext();
        q q0 = linearProgressIndicatorSpec0.h == 0 ? new q(linearProgressIndicatorSpec0) : new s(context1, linearProgressIndicatorSpec0);
        this.setIndeterminateDrawable(new o(context1, linearProgressIndicatorSpec0, p0, q0));
        this.setProgressDrawable(new j(this.getContext(), linearProgressIndicatorSpec0, p0));
    }

    @Override  // v6.d
    public final e a(Context context0, AttributeSet attributeSet0) {
        return new LinearProgressIndicatorSpec(context0, attributeSet0);
    }

    @Override  // v6.d
    public final void b(int v) {
        if(this.a != null && ((LinearProgressIndicatorSpec)this.a).h == 0 && this.isIndeterminate()) {
            return;
        }
        super.b(v);
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec)this.a).h;
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec)this.a).i;
    }

    public int getTrackStopIndicatorSize() {
        return ((LinearProgressIndicatorSpec)this.a).k;
    }

    @Override  // android.view.View
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        ((LinearProgressIndicatorSpec)this.a).j = ((LinearProgressIndicatorSpec)this.a).i == 1 || this.getLayoutDirection() == 1 && ((LinearProgressIndicatorSpec)this.a).i == 2 || this.getLayoutDirection() == 0 && ((LinearProgressIndicatorSpec)this.a).i == 3;
    }

    @Override  // android.widget.ProgressBar
    public final void onSizeChanged(int v, int v1, int v2, int v3) {
        int v4 = this.getPaddingLeft();
        int v5 = v - (this.getPaddingRight() + v4);
        int v6 = this.getPaddingTop();
        int v7 = v1 - (this.getPaddingBottom() + v6);
        o o0 = this.getIndeterminateDrawable();
        if(o0 != null) {
            o0.setBounds(0, 0, v5, v7);
        }
        j j0 = this.getProgressDrawable();
        if(j0 != null) {
            j0.setBounds(0, 0, v5, v7);
        }
    }

    public void setIndeterminateAnimationType(int v) {
        e e0 = this.a;
        if(((LinearProgressIndicatorSpec)e0).h == v) {
            return;
        }
        if(this.c() && this.isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        ((LinearProgressIndicatorSpec)e0).h = v;
        ((LinearProgressIndicatorSpec)e0).a();
        if(v == 0) {
            o o0 = this.getIndeterminateDrawable();
            q q0 = new q(((LinearProgressIndicatorSpec)e0));
            o0.m = q0;
            q0.a = o0;
        }
        else {
            o o1 = this.getIndeterminateDrawable();
            s s0 = new s(this.getContext(), ((LinearProgressIndicatorSpec)e0));
            o1.m = s0;
            s0.a = o1;
        }
        this.invalidate();
    }

    @Override  // v6.d
    public void setIndicatorColor(int[] arr_v) {
        super.setIndicatorColor(arr_v);
        ((LinearProgressIndicatorSpec)this.a).a();
    }

    public void setIndicatorDirection(int v) {
        ((LinearProgressIndicatorSpec)this.a).i = v;
        ((LinearProgressIndicatorSpec)this.a).j = v == 1 || this.getLayoutDirection() == 1 && ((LinearProgressIndicatorSpec)this.a).i == 2 || this.getLayoutDirection() == 0 && v == 3;
        this.invalidate();
    }

    @Override  // v6.d
    public void setTrackCornerRadius(int v) {
        super.setTrackCornerRadius(v);
        ((LinearProgressIndicatorSpec)this.a).a();
        this.invalidate();
    }

    public void setTrackStopIndicatorSize(int v) {
        e e0 = this.a;
        if(((LinearProgressIndicatorSpec)e0).k != v) {
            ((LinearProgressIndicatorSpec)e0).k = Math.min(v, ((LinearProgressIndicatorSpec)e0).a);
            ((LinearProgressIndicatorSpec)e0).a();
            this.invalidate();
        }
    }
}

