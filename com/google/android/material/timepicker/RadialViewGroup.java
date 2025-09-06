package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.n;
import d6.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import z6.i;
import z6.k;
import z6.m;

class RadialViewGroup extends ConstraintLayout {
    public final e o;
    public int r;
    public final i w;

    public RadialViewGroup(Context context0) {
        this(context0, null);
    }

    public RadialViewGroup(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public RadialViewGroup(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        LayoutInflater.from(context0).inflate(0x7F0D04D1, this);  // layout:material_radial_view_group
        i i0 = new i();
        this.w = i0;
        k k0 = new k(0.5f);
        m m0 = i0.a.a.g();
        m0.e = k0;
        m0.f = k0;
        m0.g = k0;
        m0.h = k0;
        i0.setShapeAppearanceModel(m0.a());
        ColorStateList colorStateList0 = ColorStateList.valueOf(-1);
        this.w.m(colorStateList0);
        this.setBackground(this.w);
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, a.R, v, 0);
        this.r = typedArray0.getDimensionPixelSize(0, 0);
        this.o = new e(this);
        typedArray0.recycle();
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        super.addView(view0, v, viewGroup$LayoutParams0);
        if(view0.getId() == -1) {
            view0.setId(View.generateViewId());
        }
        Handler handler0 = this.getHandler();
        if(handler0 != null) {
            handler0.removeCallbacks(this.o);
            handler0.post(this.o);
        }
    }

    public void c() {
        n n0 = new n();
        n0.f(this);
        HashMap hashMap0 = new HashMap();
        for(int v = 0; v < this.getChildCount(); ++v) {
            View view0 = this.getChildAt(v);
            if(view0.getId() != 0x7F0A02BB && !"skip".equals(view0.getTag())) {  // id:circle_center
                Integer integer0 = (Integer)view0.getTag(0x7F0A07DC);  // id:material_clock_level
                if(integer0 == null) {
                    integer0 = 1;
                }
                if(!hashMap0.containsKey(integer0)) {
                    hashMap0.put(integer0, new ArrayList());
                }
                ((List)hashMap0.get(integer0)).add(view0);
            }
        }
        for(Object object0: hashMap0.entrySet()) {
            List list0 = (List)((Map.Entry)object0).getValue();
            int v1 = ((int)(((Integer)((Map.Entry)object0).getKey()))) == 2 ? Math.round(((float)this.r) * 0.66f) : this.r;
            float f = 0.0f;
            for(Object object1: list0) {
                androidx.constraintlayout.widget.i i0 = n0.l(((View)object1).getId());
                i0.e.A = 0x7F0A02BB;  // id:circle_center
                i0.e.B = v1;
                i0.e.C = f;
                f += 360.0f / ((float)list0.size());
            }
        }
        n0.b(this);
    }

    @Override  // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.c();
    }

    @Override  // androidx.constraintlayout.widget.ConstraintLayout
    public final void onViewRemoved(View view0) {
        super.onViewRemoved(view0);
        Handler handler0 = this.getHandler();
        if(handler0 != null) {
            handler0.removeCallbacks(this.o);
            handler0.post(this.o);
        }
    }

    @Override  // android.view.View
    public final void setBackgroundColor(int v) {
        ColorStateList colorStateList0 = ColorStateList.valueOf(v);
        this.w.m(colorStateList0);
    }
}

