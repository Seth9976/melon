package com.google.android.material.timepicker;

import B6.f;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import c2.W;
import d6.a;
import e1.n;
import java.util.Arrays;

class ClockFaceView extends RadialViewGroup implements d {
    public final ClockHandView B;
    public final Rect D;
    public final RectF E;
    public final Rect G;
    public final SparseArray I;
    public final c M;
    public final int[] N;
    public final float[] S;
    public final int T;
    public final int V;
    public final int W;
    public final int b0;
    public final String[] c0;
    public float d0;
    public final ColorStateList e0;

    public ClockFaceView(Context context0) {
        this(context0, null);
    }

    public ClockFaceView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040409);  // attr:materialClockStyle
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.D = new Rect();
        this.E = new RectF();
        this.G = new Rect();
        SparseArray sparseArray0 = new SparseArray();
        this.I = sparseArray0;
        this.S = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, a.m, v, 0x7F1404E5);  // style:Widget.MaterialComponents.TimePicker.Clock
        Resources resources0 = this.getResources();
        ColorStateList colorStateList0 = n.r(context0, typedArray0, 1);
        this.e0 = colorStateList0;
        LayoutInflater.from(context0).inflate(0x7F0D04D0, this, true);  // layout:material_clockface_view
        ClockHandView clockHandView0 = (ClockHandView)this.findViewById(0x7F0A07DB);  // id:material_clock_hand
        this.B = clockHandView0;
        this.T = resources0.getDimensionPixelSize(0x7F0702D5);  // dimen:material_clock_hand_padding
        int v1 = colorStateList0.getDefaultColor();
        int v2 = colorStateList0.getColorForState(new int[]{0x10100A1}, v1);
        this.N = new int[]{v2, v2, colorStateList0.getDefaultColor()};
        clockHandView0.c.add(this);
        int v3 = P1.c.getColorStateList(context0, 0x7F0603F0).getDefaultColor();  // color:material_timepicker_clockface
        ColorStateList colorStateList1 = n.r(context0, typedArray0, 0);
        if(colorStateList1 != null) {
            v3 = colorStateList1.getDefaultColor();
        }
        this.setBackgroundColor(v3);
        this.getViewTreeObserver().addOnPreDrawListener(new b(this));
        this.setFocusable(true);
        typedArray0.recycle();
        this.M = new c(this);
        String[] arr_s = new String[12];
        Arrays.fill(arr_s, "");
        this.c0 = arr_s;
        LayoutInflater layoutInflater0 = LayoutInflater.from(this.getContext());
        int v4 = sparseArray0.size();
        boolean z = false;
        for(int v5 = 0; v5 < Math.max(this.c0.length, v4); ++v5) {
            TextView textView0 = (TextView)sparseArray0.get(v5);
            if(v5 >= this.c0.length) {
                this.removeView(textView0);
                sparseArray0.remove(v5);
            }
            else {
                if(textView0 == null) {
                    textView0 = (TextView)layoutInflater0.inflate(0x7F0D04CF, this, false);  // layout:material_clockface_textview
                    sparseArray0.put(v5, textView0);
                    this.addView(textView0);
                }
                textView0.setText(this.c0[v5]);
                textView0.setTag(0x7F0A07EB, v5);  // id:material_value_index
                int v6 = v5 / 12 + 1;
                textView0.setTag(0x7F0A07DC, v6);  // id:material_clock_level
                if(v6 > 1) {
                    z = true;
                }
                W.o(textView0, this.M);
                textView0.setTextColor(this.e0);
            }
        }
        ClockHandView clockHandView1 = this.B;
        if(clockHandView1.b && !z) {
            clockHandView1.m = 1;
        }
        clockHandView1.b = z;
        clockHandView1.invalidate();
        this.V = resources0.getDimensionPixelSize(0x7F0702F1);  // dimen:material_time_picker_minimum_screen_height
        this.W = resources0.getDimensionPixelSize(0x7F0702F2);  // dimen:material_time_picker_minimum_screen_width
        this.b0 = resources0.getDimensionPixelSize(0x7F0702DC);  // dimen:material_clock_size
    }

    @Override  // com.google.android.material.timepicker.RadialViewGroup
    public final void c() {
        super.c();
        for(int v = 0; true; ++v) {
            SparseArray sparseArray0 = this.I;
            if(v >= sparseArray0.size()) {
                break;
            }
            ((TextView)sparseArray0.get(v)).setVisibility(0);
        }
    }

    public final void d() {
        RectF rectF1;
        Rect rect0;
        SparseArray sparseArray0;
        RectF rectF0 = this.B.g;
        float f = 3.402823E+38f;
        TextView textView0 = null;
        for(int v = 0; true; ++v) {
            sparseArray0 = this.I;
            rect0 = this.D;
            rectF1 = this.E;
            if(v >= sparseArray0.size()) {
                break;
            }
            TextView textView1 = (TextView)sparseArray0.get(v);
            if(textView1 != null) {
                textView1.getHitRect(rect0);
                rectF1.set(rect0);
                rectF1.union(rectF0);
                float f1 = rectF1.width();
                float f2 = rectF1.height() * f1;
                if(f2 < f) {
                    textView0 = textView1;
                    f = f2;
                }
            }
        }
        for(int v1 = 0; v1 < sparseArray0.size(); ++v1) {
            TextView textView2 = (TextView)sparseArray0.get(v1);
            if(textView2 != null) {
                textView2.setSelected(textView2 == textView0);
                textView2.getHitRect(rect0);
                rectF1.set(rect0);
                textView2.getLineBounds(0, this.G);
                rectF1.inset(((float)this.G.left), ((float)this.G.top));
                RadialGradient radialGradient0 = RectF.intersects(rectF0, rectF1) ? new RadialGradient(rectF0.centerX() - rectF1.left, rectF0.centerY() - rectF1.top, 0.5f * rectF0.width(), this.N, this.S, Shader.TileMode.CLAMP) : null;
                textView2.getPaint().setShader(radialGradient0);
                textView2.invalidate();
            }
        }
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo0) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
        accessibilityNodeInfo0.setCollectionInfo(((AccessibilityNodeInfo.CollectionInfo)f.d(1, this.c0.length, 1, false).a));
    }

    @Override  // androidx.constraintlayout.widget.ConstraintLayout
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        this.d();
    }

    @Override  // androidx.constraintlayout.widget.ConstraintLayout
    public final void onMeasure(int v, int v1) {
        DisplayMetrics displayMetrics0 = this.getResources().getDisplayMetrics();
        int v2 = (int)(((float)this.b0) / Math.max(Math.max(((float)this.V) / ((float)displayMetrics0.heightPixels), ((float)this.W) / ((float)displayMetrics0.widthPixels)), 1.0f));
        int v3 = View.MeasureSpec.makeMeasureSpec(v2, 0x40000000);
        this.setMeasuredDimension(v2, v2);
        super.onMeasure(v3, v3);
    }
}

