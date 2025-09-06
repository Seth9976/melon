package com.google.android.material.slider;

import P1.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import z6.i;

public class Slider extends BaseSlider {
    public Slider(Context context0) {
        this(context0, null);
    }

    public Slider(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040572);  // attr:sliderStyle
    }

    public Slider(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, new int[]{0x1010024});
        if(typedArray0.hasValue(0)) {
            this.setValue(typedArray0.getFloat(0, 0.0f));
        }
        typedArray0.recycle();
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.material.slider.BaseSlider
    public CharSequence getAccessibilityClassName() {
        return "android.widget.SeekBar";
    }

    public int getActiveThumbIndex() {
        return this.s0;
    }

    public int getFocusedThumbIndex() {
        return this.t0;
    }

    public int getHaloRadius() {
        return this.f0;
    }

    public ColorStateList getHaloTintList() {
        return this.C0;
    }

    public int getLabelBehavior() {
        return this.W;
    }

    public float getStepSize() {
        return this.u0;
    }

    public float getThumbElevation() {
        return this.K0.a.m;
    }

    public int getThumbHeight() {
        return this.e0;
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public int getThumbRadius() {
        return this.d0 / 2;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.K0.a.d;
    }

    public float getThumbStrokeWidth() {
        return this.K0.a.j;
    }

    public ColorStateList getThumbTintList() {
        return this.K0.a.c;
    }

    public int getThumbTrackGapSize() {
        return this.g0;
    }

    public int getThumbWidth() {
        return this.d0;
    }

    public int getTickActiveRadius() {
        return this.x0;
    }

    public ColorStateList getTickActiveTintList() {
        return this.D0;
    }

    public int getTickInactiveRadius() {
        return this.y0;
    }

    public ColorStateList getTickInactiveTintList() {
        return this.E0;
    }

    public ColorStateList getTickTintList() {
        if(!this.E0.equals(this.D0)) {
            throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
        }
        return this.D0;
    }

    public ColorStateList getTrackActiveTintList() {
        return this.F0;
    }

    public int getTrackHeight() {
        return this.b0;
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.G0;
    }

    public int getTrackInsideCornerSize() {
        return this.k0;
    }

    public int getTrackSidePadding() {
        return this.c0;
    }

    public int getTrackStopIndicatorSize() {
        return this.j0;
    }

    public ColorStateList getTrackTintList() {
        if(!this.G0.equals(this.F0)) {
            throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
        }
        return this.F0;
    }

    public int getTrackWidth() {
        return this.z0;
    }

    public float getValue() {
        return (float)(((Float)this.getValues().get(0)));
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public float getValueFrom() {
        return this.p0;
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public float getValueTo() {
        return this.q0;
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public final boolean r() {
        if(this.getActiveThumbIndex() != -1) {
            return true;
        }
        this.setActiveThumbIndex(0);
        return true;
    }

    public void setCustomThumbDrawable(int v) {
        this.setCustomThumbDrawable(this.getResources().getDrawable(v));
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setCustomThumbDrawable(Drawable drawable0) {
        super.setCustomThumbDrawable(drawable0);
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setEnabled(boolean z) {
        super.setEnabled(z);
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setFocusedThumbIndex(int v) {
        super.setFocusedThumbIndex(v);
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setHaloRadius(int v) {
        super.setHaloRadius(v);
    }

    public void setHaloRadiusResource(int v) {
        this.setHaloRadius(this.getResources().getDimensionPixelSize(v));
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setHaloTintList(ColorStateList colorStateList0) {
        super.setHaloTintList(colorStateList0);
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setLabelBehavior(int v) {
        super.setLabelBehavior(v);
    }

    public void setLabelFormatter(g g0) {
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setStepSize(float f) {
        super.setStepSize(f);
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setThumbElevation(float f) {
        super.setThumbElevation(f);
    }

    public void setThumbElevationResource(int v) {
        this.setThumbElevation(this.getResources().getDimension(v));
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setThumbHeight(int v) {
        super.setThumbHeight(v);
    }

    public void setThumbHeightResource(int v) {
        this.setThumbHeight(this.getResources().getDimensionPixelSize(v));
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setThumbRadius(int v) {
        super.setThumbRadius(v);
    }

    public void setThumbRadiusResource(int v) {
        this.setThumbRadius(this.getResources().getDimensionPixelSize(v));
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setThumbStrokeColor(ColorStateList colorStateList0) {
        super.setThumbStrokeColor(colorStateList0);
    }

    public void setThumbStrokeColorResource(int v) {
        if(v != 0) {
            this.setThumbStrokeColor(c.getColorStateList(this.getContext(), v));
        }
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setThumbStrokeWidth(float f) {
        super.setThumbStrokeWidth(f);
    }

    public void setThumbStrokeWidthResource(int v) {
        if(v != 0) {
            this.setThumbStrokeWidth(this.getResources().getDimension(v));
        }
    }

    public void setThumbTintList(ColorStateList colorStateList0) {
        i i0 = this.K0;
        if(colorStateList0.equals(i0.a.c)) {
            return;
        }
        i0.m(colorStateList0);
        this.invalidate();
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setThumbTrackGapSize(int v) {
        super.setThumbTrackGapSize(v);
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setThumbWidth(int v) {
        super.setThumbWidth(v);
    }

    public void setThumbWidthResource(int v) {
        this.setThumbWidth(this.getResources().getDimensionPixelSize(v));
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setTickActiveRadius(int v) {
        super.setTickActiveRadius(v);
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setTickActiveTintList(ColorStateList colorStateList0) {
        super.setTickActiveTintList(colorStateList0);
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setTickInactiveRadius(int v) {
        super.setTickInactiveRadius(v);
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setTickInactiveTintList(ColorStateList colorStateList0) {
        super.setTickInactiveTintList(colorStateList0);
    }

    public void setTickTintList(ColorStateList colorStateList0) {
        this.setTickInactiveTintList(colorStateList0);
        this.setTickActiveTintList(colorStateList0);
    }

    public void setTickVisible(boolean z) {
        if(this.w0 != z) {
            this.w0 = z;
            this.postInvalidate();
        }
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setTrackActiveTintList(ColorStateList colorStateList0) {
        super.setTrackActiveTintList(colorStateList0);
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setTrackHeight(int v) {
        super.setTrackHeight(v);
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setTrackInactiveTintList(ColorStateList colorStateList0) {
        super.setTrackInactiveTintList(colorStateList0);
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setTrackInsideCornerSize(int v) {
        super.setTrackInsideCornerSize(v);
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setTrackStopIndicatorSize(int v) {
        super.setTrackStopIndicatorSize(v);
    }

    public void setTrackTintList(ColorStateList colorStateList0) {
        this.setTrackInactiveTintList(colorStateList0);
        this.setTrackActiveTintList(colorStateList0);
    }

    public void setValue(float f) {
        this.setValues(new Float[]{f});
    }

    public void setValueFrom(float f) {
        this.p0 = f;
        this.B0 = true;
        this.postInvalidate();
    }

    public void setValueTo(float f) {
        this.q0 = f;
        this.B0 = true;
        this.postInvalidate();
    }
}

