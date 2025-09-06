package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import androidx.customview.view.AbsSavedState;
import c2.W;
import j2.c;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public float a;
        public boolean b;
        public boolean c;
        public Paint d;
        public static final int[] e;

        static {
            LayoutParams.e = new int[]{0x1010181};
        }

        public LayoutParams(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
            this.a = 0.0f;
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, LayoutParams.e);
            this.a = typedArray0.getFloat(0, 0.0f);
            typedArray0.recycle();
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator CREATOR;
        public boolean c;

        static {
            SavedState.CREATOR = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public SavedState(Parcel parcel0) {
            super(parcel0, null);
            this.c = parcel0.readInt() != 0;
        }

        @Override  // androidx.customview.view.AbsSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeInt(((int)this.c));
        }
    }

    public final Rect B;
    public final ArrayList D;
    public static final int E;
    public int a;
    public int b;
    public Drawable c;
    public Drawable d;
    public final int e;
    public boolean f;
    public View g;
    public float h;
    public float i;
    public int j;
    public boolean k;
    public int l;
    public float m;
    public float n;
    public final c o;
    public boolean r;
    public boolean w;

    public SlidingPaneLayout(Context context0) {
        this(context0, null);
    }

    public SlidingPaneLayout(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public SlidingPaneLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = -858993460;
        this.w = true;
        this.B = new Rect();
        this.D = new ArrayList();
        float f = context0.getResources().getDisplayMetrics().density;
        this.e = (int)(32.0f * f + 0.5f);
        this.setWillNotDraw(false);
        W.o(this, new a(this));
        this.setImportantForAccessibility(1);
        androidx.slidingpanelayout.widget.c c0 = new androidx.slidingpanelayout.widget.c(this);
        c c1 = new c(this.getContext(), this, c0);
        c1.b = (int)(2.0f * ((float)c1.b));
        this.o = c1;
        c1.n = f * 400.0f;
    }

    public final void a(View view0, float f, int v) {
        LayoutParams slidingPaneLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        if(f > 0.0f && v != 0) {
            if(slidingPaneLayout$LayoutParams0.d == null) {
                slidingPaneLayout$LayoutParams0.d = new Paint();
            }
            slidingPaneLayout$LayoutParams0.d.setColorFilter(new PorterDuffColorFilter(((int)(((float)((0xFF000000 & v) >>> 24)) * f)) << 24 | v & 0xFFFFFF, PorterDuff.Mode.SRC_OVER));
            if(view0.getLayerType() != 2) {
                view0.setLayerType(2, slidingPaneLayout$LayoutParams0.d);
            }
            view0.setLayerPaint(((LayoutParams)view0.getLayoutParams()).d);
            return;
        }
        if(view0.getLayerType() != 0) {
            Paint paint0 = slidingPaneLayout$LayoutParams0.d;
            if(paint0 != null) {
                paint0.setColorFilter(null);
            }
            b b0 = new b(this, view0);
            this.D.add(b0);
            this.postOnAnimation(b0);
        }
    }

    public final boolean b(View view0) {
        if(view0 == null) {
            return false;
        }
        LayoutParams slidingPaneLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        return this.f && slidingPaneLayout$LayoutParams0.c && this.h > 0.0f;
    }

    public final boolean c() {
        return this.getLayoutDirection() == 1;
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return viewGroup$LayoutParams0 instanceof LayoutParams && super.checkLayoutParams(viewGroup$LayoutParams0);
    }

    @Override  // android.view.View
    public final void computeScroll() {
        c c0 = this.o;
        if(c0.h()) {
            if(!this.f) {
                c0.a();
                return;
            }
            this.postInvalidateOnAnimation();
        }
    }

    public final void d(float f) {
        boolean z = this.c();
        LayoutParams slidingPaneLayout$LayoutParams0 = (LayoutParams)this.g.getLayoutParams();
        boolean z1 = slidingPaneLayout$LayoutParams0.c && (z ? slidingPaneLayout$LayoutParams0.rightMargin : slidingPaneLayout$LayoutParams0.leftMargin) <= 0;
        int v1 = this.getChildCount();
        for(int v = 0; v < v1; ++v) {
            View view0 = this.getChildAt(v);
            if(view0 != this.g) {
                int v2 = (int)((1.0f - this.i) * ((float)this.l));
                this.i = f;
                view0.offsetLeftAndRight((z ? -(v2 - ((int)((1.0f - f) * ((float)this.l)))) : v2 - ((int)((1.0f - f) * ((float)this.l)))));
                if(z1) {
                    this.a(view0, (z ? this.i - 1.0f : 1.0f - this.i), this.b);
                }
            }
        }
    }

    @Override  // android.view.View
    public final void draw(Canvas canvas0) {
        int v4;
        int v3;
        super.draw(canvas0);
        Drawable drawable0 = this.c() ? this.d : this.c;
        View view0 = this.getChildCount() <= 1 ? null : this.getChildAt(1);
        if(view0 != null && drawable0 != null) {
            int v = view0.getTop();
            int v1 = view0.getBottom();
            int v2 = drawable0.getIntrinsicWidth();
            if(this.c()) {
                v3 = view0.getRight();
                v4 = v2 + v3;
            }
            else {
                int v5 = view0.getLeft();
                v4 = v5;
                v3 = v5 - v2;
            }
            drawable0.setBounds(v3, v, v4, v1);
            drawable0.draw(canvas0);
        }
    }

    @Override  // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas0, View view0, long v) {
        LayoutParams slidingPaneLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        int v1 = canvas0.save();
        if(this.f && !slidingPaneLayout$LayoutParams0.b && this.g != null) {
            Rect rect0 = this.B;
            canvas0.getClipBounds(rect0);
            if(this.c()) {
                rect0.left = Math.max(rect0.left, this.g.getRight());
            }
            else {
                rect0.right = Math.min(rect0.right, this.g.getLeft());
            }
            canvas0.clipRect(rect0);
        }
        boolean z = super.drawChild(canvas0, view0, v);
        canvas0.restoreToCount(v1);
        return z;
    }

    public final boolean e(float f) {
        int v2;
        if(this.f) {
            boolean z = this.c();
            LayoutParams slidingPaneLayout$LayoutParams0 = (LayoutParams)this.g.getLayoutParams();
            if(z) {
                int v = this.getPaddingRight() + slidingPaneLayout$LayoutParams0.rightMargin;
                int v1 = this.g.getWidth();
                v2 = (int)(((float)this.getWidth()) - (f * ((float)this.j) + ((float)v) + ((float)v1)));
            }
            else {
                int v3 = this.getPaddingLeft();
                v2 = (int)(f * ((float)this.j) + ((float)(v3 + slidingPaneLayout$LayoutParams0.leftMargin)));
            }
            View view0 = this.g;
            int v4 = view0.getTop();
            if(this.o.u(view0, v2, v4)) {
                int v5 = this.getChildCount();
                for(int v6 = 0; v6 < v5; ++v6) {
                    View view1 = this.getChildAt(v6);
                    if(view1.getVisibility() == 4) {
                        view1.setVisibility(0);
                    }
                }
                this.postInvalidateOnAnimation();
                return true;
            }
        }
        return false;
    }

    public final void f(View view0) {
        int v8;
        int v7;
        int v6;
        int v5;
        boolean z = this.c();
        int v = z ? this.getWidth() - this.getPaddingRight() : this.getPaddingLeft();
        int v1 = z ? this.getPaddingLeft() : this.getWidth() - this.getPaddingRight();
        int v2 = this.getPaddingTop();
        int v3 = this.getHeight();
        int v4 = this.getPaddingBottom();
        if(view0 == null || !view0.isOpaque()) {
            v5 = 0;
            v6 = 0;
            v7 = 0;
            v8 = 0;
        }
        else {
            v5 = view0.getLeft();
            v6 = view0.getRight();
            v7 = view0.getTop();
            v8 = view0.getBottom();
        }
        int v9 = this.getChildCount();
        for(int v10 = 0; v10 < v9; ++v10) {
            View view1 = this.getChildAt(v10);
            if(view1 == view0) {
                break;
            }
            if(view1.getVisibility() != 8) {
                view1.setVisibility((Math.max((z ? v1 : v), view1.getLeft()) < v5 || Math.max(v2, view1.getTop()) < v7 || Math.min((z ? v : v1), view1.getRight()) > v6 || Math.min(v3 - v4, view1.getBottom()) > v8 ? 0 : 4));
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = new LayoutParams(-1, -1);  // 初始化器: Landroid/view/ViewGroup$MarginLayoutParams;-><init>(II)V
        viewGroup$LayoutParams0.a = 0.0f;
        return viewGroup$LayoutParams0;
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return new LayoutParams(this.getContext(), attributeSet0);
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.LayoutParams viewGroup$LayoutParams1 = new LayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0));  // 初始化器: Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V
            viewGroup$LayoutParams1.a = 0.0f;
            return viewGroup$LayoutParams1;
        }
        ViewGroup.LayoutParams viewGroup$LayoutParams2 = new LayoutParams(viewGroup$LayoutParams0);  // 初始化器: Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V
        viewGroup$LayoutParams2.a = 0.0f;
        return viewGroup$LayoutParams2;
    }

    public int getCoveredFadeColor() {
        return this.b;
    }

    public int getParallaxDistance() {
        return this.l;
    }

    public int getSliderFadeColor() {
        return this.a;
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.w = true;
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.w = true;
        ArrayList arrayList0 = this.D;
        int v = arrayList0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            ((b)arrayList0.get(v1)).run();
        }
        arrayList0.clear();
    }

    @Override  // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent0) {
        int v = motionEvent0.getActionMasked();
        c c0 = this.o;
        if(!this.f && v == 0 && this.getChildCount() > 1) {
            View view0 = this.getChildAt(1);
            if(view0 != null) {
                int v1 = (int)motionEvent0.getX();
                int v2 = (int)motionEvent0.getY();
                c0.getClass();
                this.r = !c.l(view0, v1, v2);
            }
        }
        if(this.f && (!this.k || v == 0)) {
            if(v != 1 && v != 3) {
                switch(v) {
                    case 0: {
                        this.k = false;
                        float f = motionEvent0.getX();
                        float f1 = motionEvent0.getY();
                        this.m = f;
                        this.n = f1;
                        View view1 = this.g;
                        c0.getClass();
                        return !c.l(view1, ((int)f), ((int)f1)) || !this.b(this.g) ? c0.t(motionEvent0) : c0.t(motionEvent0) || true;
                    }
                    case 2: {
                        float f2 = motionEvent0.getX();
                        float f3 = motionEvent0.getY();
                        float f4 = Math.abs(f2 - this.m);
                        if(f4 > ((float)c0.b) && Math.abs(f3 - this.n) > f4) {
                            c0.b();
                            this.k = true;
                            return false;
                        }
                        return c0.t(motionEvent0);
                    }
                    default: {
                        return c0.t(motionEvent0);
                    }
                }
            }
            c0.b();
            return false;
        }
        c0.b();
        return super.onInterceptTouchEvent(motionEvent0);
    }

    @Override  // android.view.ViewGroup
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v20;
        int v19;
        int v18;
        int v16;
        boolean z1 = this.c();
        c c0 = this.o;
        c0.q = z1 ? 2 : 1;
        int v4 = v2 - v;
        int v5 = z1 ? this.getPaddingRight() : this.getPaddingLeft();
        int v6 = z1 ? this.getPaddingLeft() : this.getPaddingRight();
        int v7 = this.getPaddingTop();
        int v8 = this.getChildCount();
        if(this.w) {
            this.h = !this.f || !this.r ? 0.0f : 1.0f;
        }
        int v9 = v5;
        int v10 = 0;
        while(v10 < v8) {
            View view0 = this.getChildAt(v10);
            if(view0.getVisibility() != 8) {
                LayoutParams slidingPaneLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                int v11 = view0.getMeasuredWidth();
                if(slidingPaneLayout$LayoutParams0.b) {
                    int v12 = v4 - v6;
                    int v13 = Math.min(v5, v12 - this.e) - v9 - (slidingPaneLayout$LayoutParams0.leftMargin + slidingPaneLayout$LayoutParams0.rightMargin);
                    this.j = v13;
                    int v14 = z1 ? slidingPaneLayout$LayoutParams0.rightMargin : slidingPaneLayout$LayoutParams0.leftMargin;
                    slidingPaneLayout$LayoutParams0.c = v11 / 2 + (v9 + v14 + v13) > v12;
                    int v15 = (int)(this.h * ((float)v13));
                    v16 = v14 + v15 + v9;
                    this.h = ((float)v15) / ((float)v13);
                }
                else {
                    if(this.f) {
                        int v17 = this.l;
                        if(v17 != 0) {
                            v18 = (int)((1.0f - this.h) * ((float)v17));
                            v16 = v5;
                            goto label_38;
                        }
                    }
                    v16 = v5;
                }
                v18 = 0;
            label_38:
                if(z1) {
                    v19 = v4 - v16 + v18;
                    v20 = v19 - v11;
                }
                else {
                    v20 = v16 - v18;
                    v19 = v20 + v11;
                }
                view0.layout(v20, v7, v19, view0.getMeasuredHeight() + v7);
                v9 = v16;
                v5 = view0.getWidth() + v5;
            }
            ++v10;
        }
        if(this.w) {
            if(this.f) {
                if(this.l != 0) {
                    this.d(this.h);
                }
                if(((LayoutParams)this.g.getLayoutParams()).c) {
                    this.a(this.g, this.h, this.a);
                }
            }
            else {
                for(int v21 = 0; v21 < v8; ++v21) {
                    this.a(this.getChildAt(v21), 0.0f, this.a);
                }
            }
            this.f(this.g);
        }
        this.w = false;
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        int v24;
        int v26;
        int v17;
        int v15;
        int v12;
        int v7;
        int v6;
        int v2 = View.MeasureSpec.getMode(v);
        int v3 = View.MeasureSpec.getSize(v);
        int v4 = View.MeasureSpec.getMode(v1);
        int v5 = View.MeasureSpec.getSize(v1);
        if(v2 != 0x40000000) {
            if(!this.isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            }
            if(v2 != 0x80000000 && v2 == 0) {
                v3 = 300;
            }
        }
        else if(v4 == 0) {
            if(!this.isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            }
            v5 = 300;
            v4 = 0x80000000;
        }
        switch(v4) {
            case 0x80000000: {
                v7 = v5 - this.getPaddingTop() - this.getPaddingBottom();
                v6 = 0;
                break;
            }
            case 0x40000000: {
                v6 = v5 - this.getPaddingTop() - this.getPaddingBottom();
                v7 = v6;
                break;
            }
            default: {
                v6 = 0;
                v7 = 0;
            }
        }
        int v8 = v3 - this.getPaddingLeft() - this.getPaddingRight();
        int v9 = this.getChildCount();
        if(v9 > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.g = null;
        int v10 = 0;
        boolean z = false;
        int v11 = v8;
        float f = 0.0f;
        while(v10 < v9) {
            View view0 = this.getChildAt(v10);
            LayoutParams slidingPaneLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
            if(view0.getVisibility() == 8) {
                slidingPaneLayout$LayoutParams0.c = false;
                v12 = v8;
            }
            else {
                float f1 = slidingPaneLayout$LayoutParams0.a;
                if(f1 > 0.0f) {
                    f += f1;
                    if(slidingPaneLayout$LayoutParams0.width == 0) {
                        v12 = v8;
                        goto label_69;
                    }
                }
                int v13 = slidingPaneLayout$LayoutParams0.leftMargin + slidingPaneLayout$LayoutParams0.rightMargin;
                int v14 = slidingPaneLayout$LayoutParams0.width;
                if(v14 == -2) {
                    v15 = View.MeasureSpec.makeMeasureSpec(v8 - v13, 0x80000000);
                }
                else {
                    v15 = v14 == -1 ? View.MeasureSpec.makeMeasureSpec(v8 - v13, 0x40000000) : View.MeasureSpec.makeMeasureSpec(v14, 0x40000000);
                }
                int v16 = slidingPaneLayout$LayoutParams0.height;
                v12 = v8;
                if(v16 == -2) {
                    v17 = View.MeasureSpec.makeMeasureSpec(v7, 0x80000000);
                }
                else {
                    v17 = v16 == -1 ? View.MeasureSpec.makeMeasureSpec(v7, 0x40000000) : View.MeasureSpec.makeMeasureSpec(v16, 0x40000000);
                }
                view0.measure(v15, v17);
                int v18 = view0.getMeasuredWidth();
                int v19 = view0.getMeasuredHeight();
                if(v4 == 0x80000000 && v19 > v6) {
                    v6 = Math.min(v19, v7);
                }
                v11 -= v18;
                slidingPaneLayout$LayoutParams0.b = v11 < 0;
                z |= v11 < 0;
                if(v11 < 0) {
                    this.g = view0;
                }
            }
        label_69:
            ++v10;
            v8 = v12;
        }
        if(z || f > 0.0f) {
            int v20 = v8 - this.e;
            for(int v21 = 0; v21 < v9; ++v21) {
                View view1 = this.getChildAt(v21);
                if(view1.getVisibility() != 8) {
                    LayoutParams slidingPaneLayout$LayoutParams1 = (LayoutParams)view1.getLayoutParams();
                    if(view1.getVisibility() != 8) {
                        float f2 = slidingPaneLayout$LayoutParams1.a;
                        boolean z1 = slidingPaneLayout$LayoutParams1.width == 0 && f2 > 0.0f;
                        int v22 = z1 ? 0 : view1.getMeasuredWidth();
                        if(!z || view1 == this.g) {
                            if(f2 > 0.0f) {
                                if(slidingPaneLayout$LayoutParams1.width == 0) {
                                    int v25 = slidingPaneLayout$LayoutParams1.height;
                                    if(v25 == -2) {
                                        v26 = View.MeasureSpec.makeMeasureSpec(v7, 0x80000000);
                                    }
                                    else if(v25 == -1) {
                                        v26 = View.MeasureSpec.makeMeasureSpec(v7, 0x40000000);
                                    }
                                    else {
                                        v26 = View.MeasureSpec.makeMeasureSpec(v25, 0x40000000);
                                    }
                                }
                                else {
                                    v26 = View.MeasureSpec.makeMeasureSpec(view1.getMeasuredHeight(), 0x40000000);
                                }
                                if(z) {
                                    int v27 = v8 - (slidingPaneLayout$LayoutParams1.leftMargin + slidingPaneLayout$LayoutParams1.rightMargin);
                                    int v28 = View.MeasureSpec.makeMeasureSpec(v27, 0x40000000);
                                    if(v22 != v27) {
                                        view1.measure(v28, v26);
                                    }
                                }
                                else {
                                    view1.measure(View.MeasureSpec.makeMeasureSpec(v22 + ((int)(f2 * ((float)Math.max(0, v11)) / f)), 0x40000000), v26);
                                }
                            }
                        }
                        else if(slidingPaneLayout$LayoutParams1.width < 0 && (v22 > v20 || f2 > 0.0f)) {
                            if(z1) {
                                int v23 = slidingPaneLayout$LayoutParams1.height;
                                if(v23 == -2) {
                                    v24 = View.MeasureSpec.makeMeasureSpec(v7, 0x80000000);
                                }
                                else if(v23 == -1) {
                                    v24 = View.MeasureSpec.makeMeasureSpec(v7, 0x40000000);
                                }
                                else {
                                    v24 = View.MeasureSpec.makeMeasureSpec(v23, 0x40000000);
                                }
                            }
                            else {
                                v24 = View.MeasureSpec.makeMeasureSpec(view1.getMeasuredHeight(), 0x40000000);
                            }
                            view1.measure(View.MeasureSpec.makeMeasureSpec(v20, 0x40000000), v24);
                        }
                    }
                }
            }
        }
        int v29 = this.getPaddingTop();
        this.setMeasuredDimension(v3, this.getPaddingBottom() + (v29 + v6));
        this.f = z;
        c c0 = this.o;
        if(c0.a != 0 && !z) {
            c0.a();
        }
    }

    @Override  // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        super.onRestoreInstanceState(((SavedState)parcelable0).a);
        if(!((SavedState)parcelable0).c) {
            if(this.w || this.e(0.0f)) {
                this.r = false;
            }
        }
        else if(this.w || this.e(1.0f)) {
            this.r = true;
        }
        this.r = ((SavedState)parcelable0).c;
    }

    @Override  // android.view.View
    public final Parcelable onSaveInstanceState() {
        boolean z;
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroidx/customview/view/AbsSavedState;-><init>(Landroid/os/Parcelable;)V
        if(!this.f) {
            z = this.r;
        }
        else if(this.h == 1.0f) {
            z = true;
        }
        else {
            z = false;
        }
        parcelable0.c = z;
        return parcelable0;
    }

    @Override  // android.view.View
    public final void onSizeChanged(int v, int v1, int v2, int v3) {
        super.onSizeChanged(v, v1, v2, v3);
        if(v != v2) {
            this.w = true;
        }
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        if(!this.f) {
            return super.onTouchEvent(motionEvent0);
        }
        c c0 = this.o;
        c0.m(motionEvent0);
        switch(motionEvent0.getActionMasked()) {
            case 0: {
                float f = motionEvent0.getX();
                float f1 = motionEvent0.getY();
                this.m = f;
                this.n = f1;
                return true;
            }
            case 1: {
                if(this.b(this.g)) {
                    float f2 = motionEvent0.getX();
                    float f3 = motionEvent0.getY();
                    float f4 = f2 - this.m;
                    float f5 = f3 - this.n;
                    if(f5 * f5 + f4 * f4 < ((float)(c0.b * c0.b)) && c.l(this.g, ((int)f2), ((int)f3)) && (this.w || this.e(0.0f))) {
                        this.r = false;
                    }
                }
                return true;
            }
            default: {
                return true;
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final void requestChildFocus(View view0, View view1) {
        super.requestChildFocus(view0, view1);
        if(!this.isInTouchMode() && !this.f) {
            this.r = view0 == this.g;
        }
    }

    public void setCoveredFadeColor(int v) {
        this.b = v;
    }

    public void setPanelSlideListener(d d0) {
    }

    public void setParallaxDistance(int v) {
        this.l = v;
        this.requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable0) {
        this.setShadowDrawableLeft(drawable0);
    }

    public void setShadowDrawableLeft(Drawable drawable0) {
        this.c = drawable0;
    }

    public void setShadowDrawableRight(Drawable drawable0) {
        this.d = drawable0;
    }

    @Deprecated
    public void setShadowResource(int v) {
        this.setShadowDrawable(this.getResources().getDrawable(v));
    }

    public void setShadowResourceLeft(int v) {
        this.setShadowDrawableLeft(P1.c.getDrawable(this.getContext(), v));
    }

    public void setShadowResourceRight(int v) {
        this.setShadowDrawableRight(P1.c.getDrawable(this.getContext(), v));
    }

    public void setSliderFadeColor(int v) {
        this.a = v;
    }
}

