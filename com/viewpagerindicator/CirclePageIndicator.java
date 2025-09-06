package com.viewpagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.j;
import b3.Z;
import k8.t1;

public class CirclePageIndicator extends View implements j {
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR;
        public int a;

        static {
            SavedState.CREATOR = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        @Override  // android.view.View$BaseSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeInt(this.a);
        }
    }

    public float a;
    public final Paint b;
    public final Paint c;
    public final Paint d;
    public ViewPager e;
    public j f;
    public int g;
    public int h;
    public float i;
    public int j;
    public int k;
    public boolean l;
    public boolean m;
    public final int n;
    public float o;
    public int r;
    public boolean w;

    public CirclePageIndicator(Context context0) {
        this(context0, null);
    }

    public CirclePageIndicator(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F0406A9);  // attr:vpiCirclePageIndicatorStyle
    }

    public CirclePageIndicator(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        Paint paint0 = new Paint(1);
        this.b = paint0;
        Paint paint1 = new Paint(1);
        this.c = paint1;
        Paint paint2 = new Paint(1);
        this.d = paint2;
        this.o = -1.0f;
        this.r = -1;
        if(this.isInEditMode()) {
            return;
        }
        Resources resources0 = this.getResources();
        int v1 = resources0.getColor(0x7F0600C8);  // color:default_circle_indicator_page_color
        int v2 = resources0.getColor(0x7F0600C7);  // color:default_circle_indicator_fill_color
        int v3 = resources0.getInteger(0x7F0B000C);  // integer:default_circle_indicator_orientation
        int v4 = resources0.getColor(0x7F0600C9);  // color:default_circle_indicator_stroke_color
        float f = resources0.getDimension(0x7F0700B1);  // dimen:default_circle_indicator_stroke_width
        float f1 = resources0.getDimension(0x7F0700B0);  // dimen:default_circle_indicator_radius
        boolean z = resources0.getBoolean(0x7F050002);  // bool:default_circle_indicator_centered
        boolean z1 = resources0.getBoolean(0x7F050003);  // bool:default_circle_indicator_snap
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, t1.f, v, 0);
        this.l = typedArray0.getBoolean(1, z);
        this.k = typedArray0.getInt(0, v3);
        Paint.Style paint$Style0 = Paint.Style.FILL;
        paint0.setStyle(paint$Style0);
        paint0.setColor(typedArray0.getColor(4, v1));
        paint1.setStyle(paint$Style0);
        paint1.setColor(typedArray0.getColor(7, v4));
        paint1.setStrokeWidth(typedArray0.getDimension(8, f));
        paint2.setStyle(paint$Style0);
        paint2.setColor(typedArray0.getColor(3, v2));
        this.a = typedArray0.getDimension(5, f1);
        this.m = typedArray0.getBoolean(6, z1);
        typedArray0.recycle();
        this.n = ViewConfiguration.get(context0).getScaledPagingTouchSlop();
    }

    public final int a(int v) {
        int v1 = View.MeasureSpec.getMode(v);
        int v2 = View.MeasureSpec.getSize(v);
        if(v1 != 0x40000000) {
            ViewPager viewPager0 = this.e;
            if(viewPager0 != null) {
                int v3 = viewPager0.getAdapter().getCount();
                int v4 = this.getPaddingLeft();
                int v5 = this.getPaddingRight();
                int v6 = (int)(((float)(v3 - 1)) * this.a + (((float)(v3 * 2)) * this.a + ((float)(v5 + v4))) + 1.0f);
                return v1 == 0x80000000 ? Math.min(v6, v2) : v6;
            }
        }
        return v2;
    }

    public final int b(int v) {
        int v1 = View.MeasureSpec.getMode(v);
        int v2 = View.MeasureSpec.getSize(v);
        if(v1 == 0x40000000) {
            return v2;
        }
        int v3 = (int)(this.a * 2.0f + ((float)this.getPaddingTop()) + ((float)this.getPaddingBottom()) + 1.0f);
        return v1 == 0x80000000 ? Math.min(v3, v2) : v3;
    }

    public int getCurrentItem() {
        return this.g;
    }

    public int getFillColor() {
        return this.d.getColor();
    }

    public int getOrientation() {
        return this.k;
    }

    public int getPageColor() {
        return this.b.getColor();
    }

    public float getRadius() {
        return this.a;
    }

    public int getStrokeColor() {
        return this.c.getColor();
    }

    public float getStrokeWidth() {
        return this.c.getStrokeWidth();
    }

    @Override  // android.view.View
    public final void onDraw(Canvas canvas0) {
        float f8;
        float f5;
        int v4;
        int v3;
        int v2;
        int v1;
        super.onDraw(canvas0);
        ViewPager viewPager0 = this.e;
        if(viewPager0 != null) {
            int v = viewPager0.getAdapter().getCount();
            if(v != 0) {
                if(this.g >= v) {
                    this.setCurrentItem(v - 1);
                    return;
                }
                if(this.k == 0) {
                    v1 = this.getWidth();
                    v2 = this.getPaddingLeft();
                    v3 = this.getPaddingRight();
                    v4 = this.getPaddingTop();
                }
                else {
                    v1 = this.getHeight();
                    v2 = this.getPaddingTop();
                    v3 = this.getPaddingBottom();
                    v4 = this.getPaddingLeft();
                }
                float f = this.a;
                float f1 = 3.0f * f;
                float f2 = ((float)v4) + f;
                float f3 = this.l ? ((float)v2) + f + (((float)(v1 - v2 - v3)) / 2.0f - ((float)v) * f1 / 2.0f) : ((float)v2) + f;
                Paint paint0 = this.c;
                if(paint0.getStrokeWidth() > 0.0f) {
                    f -= paint0.getStrokeWidth() / 2.0f;
                }
                for(int v5 = 0; v5 < v; ++v5) {
                    float f4 = ((float)v5) * f1 + f3;
                    if(this.k == 0) {
                        f5 = f2;
                    }
                    else {
                        f5 = f4;
                        f4 = f2;
                    }
                    Paint paint1 = this.b;
                    if(paint1.getAlpha() > 0) {
                        canvas0.drawCircle(f4, f5, f, paint1);
                    }
                    float f6 = this.a;
                    if(f != f6) {
                        canvas0.drawCircle(f4, f5, f6, paint0);
                    }
                }
                int v6 = this.m ? this.h : this.g;
                float f7 = this.m ? ((float)v6) * f1 : ((float)v6) * f1 + this.i * f1;
                if(this.k == 0) {
                    f8 = f2;
                    f2 = f3 + f7;
                }
                else {
                    f8 = f3 + f7;
                }
                canvas0.drawCircle(f2, f8, this.a, this.d);
            }
        }
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        if(this.k == 0) {
            this.setMeasuredDimension(this.a(v), this.b(v1));
            return;
        }
        this.setMeasuredDimension(this.b(v), this.a(v1));
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageScrollStateChanged(int v) {
        Z.r(v, "onPageScrollStateChanged: ", "CirclePageIndicator");
        this.j = v;
        j j0 = this.f;
        if(j0 != null) {
            j0.onPageScrollStateChanged(v);
        }
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageScrolled(int v, float f, int v1) {
        this.g = v;
        this.i = f;
        this.invalidate();
        j j0 = this.f;
        if(j0 != null) {
            j0.onPageScrolled(v, f, v1);
        }
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageSelected(int v) {
        Z.r(v, "onPageSelected: ", "CirclePageIndicator");
        if(this.m || this.j == 0 || Math.abs(this.g - v) > 1) {
            this.g = v;
            this.h = v;
            this.invalidate();
        }
        j j0 = this.f;
        if(j0 != null) {
            j0.onPageSelected(v);
        }
    }

    @Override  // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        super.onRestoreInstanceState(((SavedState)parcelable0).getSuperState());
        this.g = ((SavedState)parcelable0).a;
        this.h = ((SavedState)parcelable0).a;
        this.requestLayout();
    }

    @Override  // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcelable;)V
        parcelable0.a = this.g;
        return parcelable0;
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        int v = 0;
        if(!super.onTouchEvent(motionEvent0)) {
            if(this.e == null || this.e.getAdapter().getCount() == 0) {
                return false;
            }
            int v1 = motionEvent0.getAction();
        alab1:
            switch(v1 & 0xFF) {
                case 0: {
                    this.r = motionEvent0.getPointerId(0);
                    this.o = motionEvent0.getX();
                    return true;
                label_9:
                    switch(v1 & 0xFF) {
                        case 2: {
                            float f = motionEvent0.getX(motionEvent0.findPointerIndex(this.r));
                            float f1 = f - this.o;
                            if(!this.w && Math.abs(f1) > ((float)this.n)) {
                                this.w = true;
                            }
                            if(this.w) {
                                this.o = f;
                                if(this.e.isFakeDragging() || this.e.beginFakeDrag()) {
                                    this.e.fakeDragBy(f1);
                                    return true;
                                }
                            }
                            break alab1;
                        }
                        case 3: {
                            goto label_31;
                        }
                        case 5: {
                            int v2 = motionEvent0.getActionIndex();
                            this.o = motionEvent0.getX(v2);
                            this.r = motionEvent0.getPointerId(v2);
                            return true;
                        }
                        case 6: {
                            int v3 = motionEvent0.getActionIndex();
                            if(motionEvent0.getPointerId(v3) == this.r) {
                                if(v3 == 0) {
                                    v = 1;
                                }
                                this.r = motionEvent0.getPointerId(v);
                            }
                            this.o = motionEvent0.getX(motionEvent0.findPointerIndex(this.r));
                            return true;
                        }
                        default: {
                            return true;
                        }
                    }
                }
                case 1: {
                label_31:
                    if(!this.w) {
                        int v4 = this.e.getAdapter().getCount();
                        float f2 = (float)this.getWidth();
                        if(this.g > 0 && motionEvent0.getX() < f2 / 2.0f - f2 / 6.0f) {
                            this.e.setCurrentItem(this.g - 1);
                            return true;
                        }
                        if(this.g < v4 - 1 && motionEvent0.getX() > f2 / 2.0f + f2 / 6.0f) {
                            this.e.setCurrentItem(this.g + 1);
                            return true;
                        }
                    }
                    this.w = false;
                    this.r = -1;
                    if(this.e.isFakeDragging()) {
                        this.e.endFakeDrag();
                        return true;
                    }
                    break;
                }
                default: {
                    goto label_9;
                }
            }
        }
        return true;
    }

    public void setCentered(boolean z) {
        this.l = z;
        this.invalidate();
    }

    public void setCurrentItem(int v) {
        ViewPager viewPager0 = this.e;
        if(viewPager0 == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        viewPager0.setCurrentItem(v);
        this.g = v;
        this.invalidate();
    }

    public void setFillColor(int v) {
        this.d.setColor(v);
        this.invalidate();
    }

    public void setOnPageChangeListener(j j0) {
        this.f = j0;
    }

    public void setOrientation(int v) {
        if(v != 0 && v != 1) {
            throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
        }
        this.k = v;
        this.requestLayout();
    }

    public void setPageColor(int v) {
        this.b.setColor(v);
        this.invalidate();
    }

    public void setRadius(float f) {
        this.a = f;
        this.invalidate();
    }

    public void setSnap(boolean z) {
        this.m = z;
        this.invalidate();
    }

    public void setStrokeColor(int v) {
        this.c.setColor(v);
        this.invalidate();
    }

    public void setStrokeWidth(float f) {
        this.c.setStrokeWidth(f);
        this.invalidate();
    }

    public void setViewPager(ViewPager viewPager0) {
        ViewPager viewPager1 = this.e;
        if(viewPager1 == viewPager0) {
            return;
        }
        if(viewPager1 != null) {
            viewPager1.setOnPageChangeListener(null);
        }
        if(viewPager0.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        this.e = viewPager0;
        viewPager0.setOnPageChangeListener(this);
        this.invalidate();
    }
}

