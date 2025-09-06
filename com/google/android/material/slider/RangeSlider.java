package com.google.android.material.slider;

import P1.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import com.google.android.material.internal.B;
import d6.a;
import java.util.ArrayList;
import java.util.List;
import z6.i;

public class RangeSlider extends BaseSlider {
    static class RangeSliderState extends AbsSavedState {
        public static final Parcelable.Creator CREATOR;
        public float a;
        public int b;

        static {
            RangeSliderState.CREATOR = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public RangeSliderState(Parcel parcel0) {
            super(parcel0.readParcelable(RangeSliderState.class.getClassLoader()));
            this.a = parcel0.readFloat();
            this.b = parcel0.readInt();
        }

        public RangeSliderState(Parcelable parcelable0) {
            super(parcelable0);
        }

        @Override  // android.view.AbsSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeFloat(this.a);
            parcel0.writeInt(this.b);
        }
    }

    public float R0;
    public int S0;

    public RangeSlider(Context context0) {
        this(context0, null);
    }

    public RangeSlider(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040572);  // attr:sliderStyle
    }

    public RangeSlider(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        TypedArray typedArray0 = B.m(context0, attributeSet0, a.S, v, 0x7F1404CF, new int[0]);  // style:Widget.MaterialComponents.Slider
        if(typedArray0.hasValue(1)) {
            int v1 = typedArray0.getResourceId(1, 0);
            TypedArray typedArray1 = typedArray0.getResources().obtainTypedArray(v1);
            ArrayList arrayList0 = new ArrayList();
            for(int v2 = 0; v2 < typedArray1.length(); ++v2) {
                arrayList0.add(typedArray1.getFloat(v2, -1.0f));
            }
            this.setValues(arrayList0);
        }
        this.R0 = typedArray0.getDimension(0, 0.0f);
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

    @Override  // com.google.android.material.slider.BaseSlider
    public float getMinSeparation() {
        return this.R0;
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

    @Override  // com.google.android.material.slider.BaseSlider
    public float getValueFrom() {
        return this.p0;
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public float getValueTo() {
        return this.q0;
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public List getValues() {
        return super.getValues();
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        super.onRestoreInstanceState(((RangeSliderState)parcelable0).getSuperState());
        this.R0 = ((RangeSliderState)parcelable0).a;
        this.S0 = ((RangeSliderState)parcelable0).b;
        this.setSeparationUnit(((RangeSliderState)parcelable0).b);
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new RangeSliderState(super.onSaveInstanceState());
        parcelable0.a = this.R0;
        parcelable0.b = this.S0;
        return parcelable0;
    }

    public void setCustomThumbDrawable(int v) {
        this.setCustomThumbDrawable(this.getResources().getDrawable(v));
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setCustomThumbDrawable(Drawable drawable0) {
        super.setCustomThumbDrawable(drawable0);
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setCustomThumbDrawablesForValues(int[] arr_v) {
        super.setCustomThumbDrawablesForValues(arr_v);
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setCustomThumbDrawablesForValues(Drawable[] arr_drawable) {
        super.setCustomThumbDrawablesForValues(arr_drawable);
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

    public void setMinSeparation(float f) {
        this.R0 = f;
        this.S0 = 0;
        this.setSeparationUnit(0);
    }

    public void setMinSeparationValue(float f) {
        this.R0 = f;
        this.S0 = 1;
        this.setSeparationUnit(1);
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

    @Override  // com.google.android.material.slider.BaseSlider
    public void setValues(List list0) {
        super.setValues(list0);
    }

    @Override  // com.google.android.material.slider.BaseSlider
    public void setValues(Float[] arr_float) {
        super.setValues(arr_float);
    }
}

