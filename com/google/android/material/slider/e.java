package com.google.android.material.slider;

import E9.h;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo.RangeInfo;
import d2.c;
import d2.d;
import j2.a;
import java.util.ArrayList;
import java.util.List;

public final class e extends a {
    public final BaseSlider n;
    public final Rect o;

    public e(BaseSlider baseSlider0) {
        super(baseSlider0);
        this.o = new Rect();
        this.n = baseSlider0;
    }

    @Override  // j2.a
    public final int e(float f, float f1) {
        for(int v = 0; true; ++v) {
            BaseSlider baseSlider0 = this.n;
            if(v >= baseSlider0.getValues().size()) {
                break;
            }
            baseSlider0.w(v, this.o);
            if(this.o.contains(((int)f), ((int)f1))) {
                return v;
            }
        }
        return -1;
    }

    @Override  // j2.a
    public final void f(ArrayList arrayList0) {
        for(int v = 0; v < this.n.getValues().size(); v = com.iloen.melon.utils.a.d(v, v, 1, arrayList0)) {
        }
    }

    @Override  // j2.a
    public final boolean j(int v, int v1, Bundle bundle0) {
        BaseSlider baseSlider0 = this.n;
        if(baseSlider0.isEnabled()) {
            if(v1 == 0x1000 || v1 == 0x2000) {
                float f = baseSlider0.u0 == 0.0f ? 1.0f : baseSlider0.u0;
                float f1 = (baseSlider0.q0 - baseSlider0.p0) / f;
                if(f1 > 20.0f) {
                    f *= (float)Math.round(f1 / 20.0f);
                }
                if(v1 == 0x2000) {
                    f = -f;
                }
                if(baseSlider0.l()) {
                    f = -f;
                }
                if(baseSlider0.u(h.q(((float)(((Float)baseSlider0.getValues().get(v)))) + f, baseSlider0.getValueFrom(), baseSlider0.getValueTo()), v)) {
                    baseSlider0.x();
                    baseSlider0.postInvalidate();
                    this.g(v);
                    return true;
                }
            }
            else if(v1 == 0x102003D && bundle0 != null && bundle0.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE") && baseSlider0.u(bundle0.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"), v)) {
                baseSlider0.x();
                baseSlider0.postInvalidate();
                this.g(v);
                return true;
            }
        }
        return false;
    }

    @Override  // j2.a
    public final void l(int v, d d0) {
        String s2;
        d0.b(c.t);
        BaseSlider baseSlider0 = this.n;
        List list0 = baseSlider0.getValues();
        float f = (float)(((Float)list0.get(v)));
        float f1 = baseSlider0.getValueFrom();
        float f2 = baseSlider0.getValueTo();
        if(baseSlider0.isEnabled()) {
            if(f > f1) {
                d0.a(0x2000);
            }
            if(f < f2) {
                d0.a(0x1000);
            }
        }
        AccessibilityNodeInfo.RangeInfo accessibilityNodeInfo$RangeInfo0 = AccessibilityNodeInfo.RangeInfo.obtain(1, f1, f2, f);
        d0.a.setRangeInfo(accessibilityNodeInfo$RangeInfo0);
        d0.l("android.widget.SeekBar");
        StringBuilder stringBuilder0 = new StringBuilder();
        if(baseSlider0.getContentDescription() != null) {
            stringBuilder0.append(baseSlider0.getContentDescription());
            stringBuilder0.append(",");
        }
        String s = baseSlider0.g(f);
        String s1 = "Value";
        if(list0.size() > 1) {
            if(v == baseSlider0.getValues().size() - 1) {
                s2 = "Range end";
            }
            else {
                s2 = v == 0 ? "Range start" : "";
            }
            s1 = s2;
        }
        stringBuilder0.append(s1 + ", " + s);
        d0.o(stringBuilder0.toString());
        baseSlider0.w(v, this.o);
        d0.j(this.o);
    }
}

