package com.viewpagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.BaseSavedState;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.j;
import k8.t1;

public class UnderlinePageIndicator extends View implements j {
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR;
        public int a;

        static {
            SavedState.CREATOR = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        @Override  // android.view.View$BaseSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeInt(this.a);
        }
    }

    public final Paint a;
    public boolean b;
    public int c;
    public int d;
    public int e;
    public ViewPager f;
    public j g;
    public int h;
    public int i;
    public float j;
    public final int k;
    public float l;
    public int m;
    public boolean n;
    public final e o;

    public UnderlinePageIndicator(Context context0) {
        this(context0, null);
    }

    public UnderlinePageIndicator(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F0406AE);  // attr:vpiUnderlinePageIndicatorStyle
    }

    public UnderlinePageIndicator(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = new Paint(1);
        this.l = -1.0f;
        this.m = -1;
        this.o = new e(this, 0);
        if(this.isInEditMode()) {
            return;
        }
        Resources resources0 = this.getResources();
        boolean z = resources0.getBoolean(0x7F050004);  // bool:default_underline_indicator_fades
        int v1 = resources0.getInteger(0x7F0B000D);  // integer:default_underline_indicator_fade_delay
        int v2 = resources0.getInteger(0x7F0B000E);  // integer:default_underline_indicator_fade_length
        int v3 = resources0.getColor(0x7F0600CA);  // color:default_underline_indicator_selected_color
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, t1.K, v, 0);
        this.setFades(typedArray0.getBoolean(2, z));
        this.setSelectedColor(typedArray0.getColor(3, v3));
        this.setFadeDelay(typedArray0.getInteger(0, v1));
        this.setFadeLength(typedArray0.getInteger(1, v2));
        typedArray0.recycle();
        this.k = ViewConfiguration.get(context0).getScaledPagingTouchSlop();
    }

    public int getCurrentItem() {
        return this.i;
    }

    public int getFadeDelay() {
        return this.c;
    }

    public int getFadeLength() {
        return this.d;
    }

    public boolean getFades() {
        return this.b;
    }

    public int getSelectedColor() {
        return this.a.getColor();
    }

    @Override  // android.view.View
    public final void onDraw(Canvas canvas0) {
        super.onDraw(canvas0);
        ViewPager viewPager0 = this.f;
        if(viewPager0 != null) {
            int v = viewPager0.getAdapter().getCount();
            if(v != 0) {
                if(this.i >= v) {
                    this.setCurrentItem(v - 1);
                    return;
                }
                int v1 = this.getPaddingLeft();
                float f = ((float)(this.getWidth() - v1 - this.getPaddingRight())) / (((float)v) * 1.0f);
                float f1 = (((float)this.i) + this.j) * f + ((float)v1);
                canvas0.drawRect(f1, ((float)this.getPaddingTop()), f1 + f, ((float)(this.getHeight() - this.getPaddingBottom())), this.a);
            }
        }
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageScrollStateChanged(int v) {
        this.h = v;
        j j0 = this.g;
        if(j0 != null) {
            j0.onPageScrollStateChanged(v);
        }
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageScrolled(int v, float f, int v1) {
        this.i = v;
        this.j = f;
        if(this.b) {
            e e0 = this.o;
            if(v1 > 0) {
                this.removeCallbacks(e0);
                this.a.setAlpha(0xFF);
            }
            else if(this.h != 1) {
                this.postDelayed(e0, ((long)this.c));
            }
        }
        this.invalidate();
        j j0 = this.g;
        if(j0 != null) {
            j0.onPageScrolled(v, f, v1);
        }
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageSelected(int v) {
        if(this.h == 0) {
            this.i = v;
            this.j = 0.0f;
            this.invalidate();
            this.o.run();
        }
        j j0 = this.g;
        if(j0 != null) {
            j0.onPageSelected(v);
        }
    }

    @Override  // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        super.onRestoreInstanceState(((SavedState)parcelable0).getSuperState());
        this.i = ((SavedState)parcelable0).a;
        this.requestLayout();
    }

    @Override  // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcelable;)V
        parcelable0.a = this.i;
        return parcelable0;
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        int v = 0;
        if(!super.onTouchEvent(motionEvent0)) {
            if(this.f == null || this.f.getAdapter().getCount() == 0) {
                return false;
            }
            int v1 = motionEvent0.getAction();
        alab1:
            switch(v1 & 0xFF) {
                case 0: {
                    this.m = motionEvent0.getPointerId(0);
                    this.l = motionEvent0.getX();
                    return true;
                label_9:
                    switch(v1 & 0xFF) {
                        case 2: {
                            float f = motionEvent0.getX(motionEvent0.findPointerIndex(this.m));
                            float f1 = f - this.l;
                            if(!this.n && Math.abs(f1) > ((float)this.k)) {
                                this.n = true;
                            }
                            if(this.n) {
                                this.l = f;
                                if(this.f.isFakeDragging() || this.f.beginFakeDrag()) {
                                    this.f.fakeDragBy(f1);
                                    return true;
                                }
                            }
                            break alab1;
                        }
                        case 3: {
                            goto label_32;
                        }
                        default: {
                            switch(v1 & 0xFF) {
                                case 5: {
                                    int v2 = motionEvent0.getActionIndex();
                                    this.l = motionEvent0.getX(v2);
                                    this.m = motionEvent0.getPointerId(v2);
                                    return true;
                                }
                                case 6: {
                                    int v3 = motionEvent0.getActionIndex();
                                    if(motionEvent0.getPointerId(v3) == this.m) {
                                        if(v3 == 0) {
                                            v = 1;
                                        }
                                        this.m = motionEvent0.getPointerId(v);
                                    }
                                    this.l = motionEvent0.getX(motionEvent0.findPointerIndex(this.m));
                                    return true;
                                }
                                default: {
                                    return true;
                                }
                            }
                        }
                    }
                }
                case 1: {
                label_32:
                    if(this.n) {
                    label_43:
                        this.n = false;
                        this.m = -1;
                        if(this.f.isFakeDragging()) {
                            this.f.endFakeDrag();
                            return true;
                        }
                    }
                    else {
                        int v4 = this.f.getAdapter().getCount();
                        float f2 = (float)this.getWidth();
                        if(this.i > 0 && motionEvent0.getX() < f2 / 2.0f - f2 / 6.0f) {
                            if((v1 & 0xFF) != 3) {
                                this.f.setCurrentItem(this.i - 1);
                                return true;
                            }
                        }
                        else if(this.i >= v4 - 1 || motionEvent0.getX() <= f2 / 2.0f + f2 / 6.0f) {
                            goto label_43;
                        }
                        else if((v1 & 0xFF) != 3) {
                            this.f.setCurrentItem(this.i + 1);
                            return true;
                        }
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

    public void setCurrentItem(int v) {
        ViewPager viewPager0 = this.f;
        if(viewPager0 == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        viewPager0.setCurrentItem(v);
        this.i = v;
        this.invalidate();
    }

    public void setFadeDelay(int v) {
        this.c = v;
    }

    public void setFadeLength(int v) {
        this.d = v;
        this.e = 0xFF / (v / 30);
    }

    public void setFades(boolean z) {
        if(z != this.b) {
            this.b = z;
            e e0 = this.o;
            if(z) {
                this.post(e0);
                return;
            }
            this.removeCallbacks(e0);
            this.a.setAlpha(0xFF);
            this.invalidate();
        }
    }

    public void setOnPageChangeListener(j j0) {
        this.g = j0;
    }

    public void setSelectedColor(int v) {
        this.a.setColor(v);
        this.invalidate();
    }

    public void setViewPager(ViewPager viewPager0) {
        ViewPager viewPager1 = this.f;
        if(viewPager1 == viewPager0) {
            return;
        }
        if(viewPager1 != null) {
            viewPager1.setOnPageChangeListener(null);
        }
        if(viewPager0.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        this.f = viewPager0;
        viewPager0.setOnPageChangeListener(this);
        this.invalidate();
        this.post(new e(this, 1));
    }
}

