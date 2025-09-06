package com.google.android.material.divider;

import E6.a;
import P1.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View;
import com.google.android.material.internal.B;
import e1.n;
import z6.i;

public class MaterialDivider extends View {
    public final i a;
    public int b;
    public int c;
    public int d;
    public int e;

    public MaterialDivider(Context context0) {
        this(context0, null);
    }

    public MaterialDivider(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F04040C);  // attr:materialDividerStyle
    }

    public MaterialDivider(Context context0, AttributeSet attributeSet0, int v) {
        super(a.a(context0, attributeSet0, v, 0x7F1404C2), attributeSet0, v);  // style:Widget.MaterialComponents.MaterialDivider
        Context context1 = this.getContext();
        this.a = new i();
        TypedArray typedArray0 = B.m(context1, attributeSet0, d6.a.G, v, 0x7F1404C2, new int[0]);  // style:Widget.MaterialComponents.MaterialDivider
        this.b = typedArray0.getDimensionPixelSize(3, this.getResources().getDimensionPixelSize(0x7F0702DF));  // dimen:material_divider_thickness
        this.d = typedArray0.getDimensionPixelOffset(2, 0);
        this.e = typedArray0.getDimensionPixelOffset(1, 0);
        this.setDividerColor(n.r(context1, typedArray0, 0).getDefaultColor());
        typedArray0.recycle();
    }

    public int getDividerColor() {
        return this.c;
    }

    public int getDividerInsetEnd() {
        return this.e;
    }

    public int getDividerInsetStart() {
        return this.d;
    }

    public int getDividerThickness() {
        return this.b;
    }

    @Override  // android.view.View
    public final void onDraw(Canvas canvas0) {
        super.onDraw(canvas0);
        int v = this.getLayoutDirection() == 1 ? this.e : this.d;
        int v1 = this.getWidth();
        int v2 = this.d;
        int v3 = this.getBottom();
        int v4 = this.getTop();
        this.a.setBounds(v, 0, v1 - v2, v3 - v4);
        this.a.draw(canvas0);
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        int v2 = View.MeasureSpec.getMode(v1);
        int v3 = this.getMeasuredHeight();
        if(v2 != 0x80000000 && v2 != 0) {
            return;
        }
        int v4 = this.b;
        if(v4 > 0 && v3 != v4) {
            v3 = v4;
        }
        this.setMeasuredDimension(this.getMeasuredWidth(), v3);
    }

    public void setDividerColor(int v) {
        if(this.c != v) {
            this.c = v;
            ColorStateList colorStateList0 = ColorStateList.valueOf(v);
            this.a.m(colorStateList0);
            this.invalidate();
        }
    }

    public void setDividerColorResource(int v) {
        this.setDividerColor(c.getColor(this.getContext(), v));
    }

    public void setDividerInsetEnd(int v) {
        this.e = v;
    }

    public void setDividerInsetEndResource(int v) {
        this.setDividerInsetEnd(this.getContext().getResources().getDimensionPixelOffset(v));
    }

    public void setDividerInsetStart(int v) {
        this.d = v;
    }

    public void setDividerInsetStartResource(int v) {
        this.setDividerInsetStart(this.getContext().getResources().getDimensionPixelOffset(v));
    }

    public void setDividerThickness(int v) {
        if(this.b != v) {
            this.b = v;
            this.requestLayout();
        }
    }

    public void setDividerThicknessResource(int v) {
        this.setDividerThickness(this.getContext().getResources().getDimensionPixelSize(v));
    }
}

