package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.StaticLayout;
import android.text.TextUtils.TruncateAt;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.b;
import c2.B0;
import c2.K;
import c2.M;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.B;
import com.google.android.material.internal.c;
import com.google.android.material.internal.d;
import d6.a;
import e1.m;
import e1.n;
import java.util.ArrayList;

public class CollapsingToolbarLayout extends FrameLayout {
    public static class LayoutParams extends FrameLayout.LayoutParams {
        public int a;
        public float b;

        public LayoutParams(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
            this.a = 0;
            this.b = 0.5f;
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, a.p);
            this.a = typedArray0.getInt(0, 0);
            this.b = typedArray0.getFloat(1, 0.5f);
            typedArray0.recycle();
        }
    }

    public boolean B;
    public ValueAnimator D;
    public long E;
    public final TimeInterpolator G;
    public final TimeInterpolator I;
    public int M;
    public f N;
    public int S;
    public int T;
    public B0 V;
    public int W;
    public boolean a;
    public final int b;
    public boolean b0;
    public ViewGroup c;
    public int c0;
    public View d;
    public boolean d0;
    public View e;
    public int f;
    public int g;
    public int h;
    public int i;
    public final Rect j;
    public final c k;
    public final ElevationOverlayProvider l;
    public boolean m;
    public boolean n;
    public Drawable o;
    public Drawable r;
    public int w;

    public CollapsingToolbarLayout(Context context0) {
        this(context0, null);
    }

    public CollapsingToolbarLayout(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040160);  // attr:collapsingToolbarLayoutStyle
    }

    public CollapsingToolbarLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(E6.a.a(context0, attributeSet0, v, 0x7F1403C0), attributeSet0, v);  // style:Widget.Design.CollapsingToolbar
        TextUtils.TruncateAt textUtils$TruncateAt0;
        this.a = true;
        this.j = new Rect();
        this.M = -1;
        this.W = 0;
        this.c0 = 0;
        Context context1 = this.getContext();
        c c0 = new c(this);
        this.k = c0;
        c0.W = e6.a.e;
        c0.i(false);
        c0.J = false;
        this.l = new ElevationOverlayProvider(context1);
        TypedArray typedArray0 = B.m(context1, attributeSet0, a.o, v, 0x7F1403C0, new int[0]);  // style:Widget.Design.CollapsingToolbar
        int v1 = typedArray0.getInt(4, 0x800053);
        if(c0.j != v1) {
            c0.j = v1;
            c0.i(false);
        }
        c0.l(typedArray0.getInt(0, 0x800013));
        int v2 = typedArray0.getDimensionPixelSize(5, 0);
        this.i = v2;
        this.h = v2;
        this.g = v2;
        this.f = v2;
        if(typedArray0.hasValue(8)) {
            this.f = typedArray0.getDimensionPixelSize(8, 0);
        }
        if(typedArray0.hasValue(7)) {
            this.h = typedArray0.getDimensionPixelSize(7, 0);
        }
        if(typedArray0.hasValue(9)) {
            this.g = typedArray0.getDimensionPixelSize(9, 0);
        }
        if(typedArray0.hasValue(6)) {
            this.i = typedArray0.getDimensionPixelSize(6, 0);
        }
        this.m = typedArray0.getBoolean(20, true);
        this.setTitle(typedArray0.getText(18));
        c0.n(0x7F140243);  // style:TextAppearance.Design.CollapsingToolbar.Expanded
        c0.k(0x7F140223);  // style:TextAppearance.AppCompat.Widget.ActionBar.Title
        if(typedArray0.hasValue(10)) {
            c0.n(typedArray0.getResourceId(10, 0));
        }
        if(typedArray0.hasValue(1)) {
            c0.k(typedArray0.getResourceId(1, 0));
        }
        if(typedArray0.hasValue(22)) {
            switch(typedArray0.getInt(22, -1)) {
                case 0: {
                    textUtils$TruncateAt0 = TextUtils.TruncateAt.START;
                    break;
                }
                case 1: {
                    textUtils$TruncateAt0 = TextUtils.TruncateAt.MIDDLE;
                    break;
                }
                case 3: {
                    textUtils$TruncateAt0 = TextUtils.TruncateAt.MARQUEE;
                    break;
                }
                default: {
                    textUtils$TruncateAt0 = TextUtils.TruncateAt.END;
                }
            }
            this.setTitleEllipsize(textUtils$TruncateAt0);
        }
        if(typedArray0.hasValue(11)) {
            ColorStateList colorStateList0 = n.r(context1, typedArray0, 11);
            if(c0.n != colorStateList0) {
                c0.n = colorStateList0;
                c0.i(false);
            }
        }
        if(typedArray0.hasValue(2)) {
            ColorStateList colorStateList1 = n.r(context1, typedArray0, 2);
            if(c0.o != colorStateList1) {
                c0.o = colorStateList1;
                c0.i(false);
            }
        }
        this.M = typedArray0.getDimensionPixelSize(16, -1);
        if(typedArray0.hasValue(14)) {
            int v3 = typedArray0.getInt(14, 1);
            if(v3 != c0.n0) {
                c0.n0 = v3;
                Bitmap bitmap0 = c0.K;
                if(bitmap0 != null) {
                    bitmap0.recycle();
                    c0.K = null;
                }
                c0.i(false);
            }
        }
        if(typedArray0.hasValue(21)) {
            c0.V = AnimationUtils.loadInterpolator(context1, typedArray0.getResourceId(21, 0));
            c0.i(false);
        }
        this.E = (long)typedArray0.getInt(15, 600);
        this.G = n.C(context1, 0x7F04046A, e6.a.c);  // attr:motionEasingStandardInterpolator
        this.I = n.C(context1, 0x7F04046A, e6.a.d);  // attr:motionEasingStandardInterpolator
        this.setContentScrim(typedArray0.getDrawable(3));
        this.setStatusBarScrim(typedArray0.getDrawable(17));
        this.setTitleCollapseMode(typedArray0.getInt(19, 0));
        this.b = typedArray0.getResourceId(23, -1);
        this.b0 = typedArray0.getBoolean(13, false);
        this.d0 = typedArray0.getBoolean(12, false);
        typedArray0.recycle();
        this.setWillNotDraw(false);
        M.n(this, new b(this, 17));
    }

    public final void a() {
        if(!this.a) {
            return;
        }
        ViewGroup viewGroup0 = null;
        this.c = null;
        this.d = null;
        int v = this.b;
        if(v != -1) {
            View view0 = (ViewGroup)this.findViewById(v);
            this.c = view0;
            if(view0 != null) {
                for(ViewParent viewParent0 = view0.getParent(); viewParent0 != this && viewParent0 != null; viewParent0 = viewParent0.getParent()) {
                    if(viewParent0 instanceof View) {
                        view0 = (View)viewParent0;
                    }
                }
                this.d = view0;
            }
        }
        if(this.c == null) {
            int v1 = this.getChildCount();
            int v2 = 0;
            while(v2 < v1) {
                View view1 = this.getChildAt(v2);
                if(!(view1 instanceof Toolbar) && !(view1 instanceof android.widget.Toolbar)) {
                    ++v2;
                }
                else {
                    viewGroup0 = (ViewGroup)view1;
                    if(true) {
                        break;
                    }
                }
            }
            this.c = viewGroup0;
        }
        this.c();
        this.a = false;
    }

    public static i b(View view0) {
        i i0 = (i)view0.getTag(0x7F0A0DC8);  // id:view_offset_helper
        if(i0 == null) {
            i0 = new i(view0);
            view0.setTag(0x7F0A0DC8, i0);  // id:view_offset_helper
        }
        return i0;
    }

    public final void c() {
        if(!this.m) {
            View view0 = this.e;
            if(view0 != null) {
                ViewParent viewParent0 = view0.getParent();
                if(viewParent0 instanceof ViewGroup) {
                    ((ViewGroup)viewParent0).removeView(this.e);
                }
            }
        }
        if(this.m && this.c != null) {
            if(this.e == null) {
                this.e = new View(this.getContext());
            }
            if(this.e.getParent() == null) {
                this.c.addView(this.e, -1, -1);
            }
        }
    }

    @Override  // android.widget.FrameLayout
    public final boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return viewGroup$LayoutParams0 instanceof LayoutParams;
    }

    public final void d() {
        if(this.o == null && this.r == null) {
            return;
        }
        this.setScrimsShown(this.getHeight() + this.S < this.getScrimVisibleHeightTrigger());
    }

    @Override  // android.view.View
    public final void draw(Canvas canvas0) {
        super.draw(canvas0);
        this.a();
        if(this.c == null) {
            Drawable drawable0 = this.o;
            if(drawable0 != null && this.w > 0) {
                drawable0.mutate().setAlpha(this.w);
                this.o.draw(canvas0);
            }
        }
        if(this.m && this.n) {
            c c0 = this.k;
            if(this.c == null || this.o == null || this.w <= 0 || this.T != 1 || c0.b >= c0.e) {
                c0.d(canvas0);
            }
            else {
                int v = canvas0.save();
                canvas0.clipRect(this.o.getBounds(), Region.Op.DIFFERENCE);
                c0.d(canvas0);
                canvas0.restoreToCount(v);
            }
        }
        if(this.r != null && this.w > 0) {
            int v1 = this.V == null ? 0 : this.V.d();
            if(v1 > 0) {
                this.r.setBounds(0, -this.S, this.getWidth(), v1 - this.S);
                this.r.mutate().setAlpha(this.w);
                this.r.draw(canvas0);
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas0, View view0, long v) {
        Drawable drawable0 = this.o;
        if(drawable0 != null && this.w > 0) {
            View view1 = this.d;
            if(view1 == null || view1 == this) {
                if(view0 == this.c) {
                label_7:
                    int v1 = this.getWidth();
                    int v2 = this.getHeight();
                    if(this.T == 1 && view0 != null && this.m) {
                        v2 = view0.getBottom();
                    }
                    drawable0.setBounds(0, 0, v1, v2);
                    this.o.mutate().setAlpha(this.w);
                    this.o.draw(canvas0);
                    return super.drawChild(canvas0, view0, v) || true;
                }
            }
            else if(view0 == view1) {
                goto label_7;
            }
        }
        return super.drawChild(canvas0, view0, v);
    }

    @Override  // android.view.ViewGroup
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] arr_v = this.getDrawableState();
        Drawable drawable0 = this.r;
        boolean z = false;
        boolean z1 = drawable0 == null || !drawable0.isStateful() ? false : drawable0.setState(arr_v);
        Drawable drawable1 = this.o;
        if(drawable1 != null && drawable1.isStateful()) {
            z1 |= drawable1.setState(arr_v);
        }
        c c0 = this.k;
        if(c0 != null) {
            c0.R = arr_v;
            if(c0.o != null && c0.o.isStateful() || c0.n != null && c0.n.isStateful()) {
                c0.i(false);
                z = true;
            }
            z1 |= z;
        }
        if(z1) {
            this.invalidate();
        }
    }

    public final void e(int v, int v1, int v2, int v3, boolean z) {
        int v8;
        int v7;
        int v6;
        if(this.m) {
            int v4 = 0;
            View view0 = this.e;
            if(view0 != null) {
                boolean z1 = view0.isAttachedToWindow() && this.e.getVisibility() == 0;
                this.n = z1;
                if(z1 || z) {
                    boolean z2 = this.getLayoutDirection() == 1;
                    View view1 = this.d;
                    if(view1 == null) {
                        view1 = this.c;
                    }
                    i i0 = CollapsingToolbarLayout.b(view1);
                    LayoutParams collapsingToolbarLayout$LayoutParams0 = (LayoutParams)view1.getLayoutParams();
                    int v5 = this.getHeight() - i0.b - view1.getHeight() - collapsingToolbarLayout$LayoutParams0.bottomMargin;
                    Rect rect0 = this.j;
                    d.a(this, this.e, rect0);
                    ViewGroup viewGroup0 = this.c;
                    if(viewGroup0 instanceof Toolbar) {
                        v4 = ((Toolbar)viewGroup0).getTitleMarginStart();
                        v6 = ((Toolbar)viewGroup0).getTitleMarginEnd();
                        v7 = ((Toolbar)viewGroup0).getTitleMarginTop();
                        v8 = ((Toolbar)viewGroup0).getTitleMarginBottom();
                    }
                    else if(viewGroup0 instanceof android.widget.Toolbar) {
                        v4 = ((android.widget.Toolbar)viewGroup0).getTitleMarginStart();
                        v6 = ((android.widget.Toolbar)viewGroup0).getTitleMarginEnd();
                        v7 = ((android.widget.Toolbar)viewGroup0).getTitleMarginTop();
                        v8 = ((android.widget.Toolbar)viewGroup0).getTitleMarginBottom();
                    }
                    else {
                        v8 = 0;
                        v6 = 0;
                        v7 = 0;
                    }
                    int v9 = rect0.left + (z2 ? v6 : v4);
                    int v10 = rect0.top + v5 + v7;
                    int v11 = rect0.right;
                    if(!z2) {
                        v4 = v6;
                    }
                    int v12 = v11 - v4;
                    int v13 = rect0.bottom + v5 - v8;
                    c c0 = this.k;
                    Rect rect1 = c0.h;
                    if(rect1.left != v9 || rect1.top != v10 || rect1.right != v12 || rect1.bottom != v13) {
                        rect1.set(v9, v10, v12, v13);
                        c0.S = true;
                    }
                    int v14 = z2 ? this.h : this.f;
                    int v15 = rect0.top + this.g;
                    int v16 = v2 - v - (z2 ? this.f : this.h);
                    int v17 = v3 - v1 - this.i;
                    Rect rect2 = c0.g;
                    if(rect2.left != v14 || rect2.top != v15 || rect2.right != v16 || rect2.bottom != v17) {
                        rect2.set(v14, v15, v16, v17);
                        c0.S = true;
                    }
                    c0.i(z);
                }
            }
        }
    }

    public final void f() {
        CharSequence charSequence0;
        if(this.c != null && this.m && TextUtils.isEmpty(this.k.G)) {
            ViewGroup viewGroup0 = this.c;
            if(viewGroup0 instanceof Toolbar) {
                charSequence0 = ((Toolbar)viewGroup0).getTitle();
            }
            else {
                charSequence0 = viewGroup0 instanceof android.widget.Toolbar ? ((android.widget.Toolbar)viewGroup0).getTitle() : null;
            }
            this.setTitle(charSequence0);
        }
    }

    @Override  // android.widget.FrameLayout
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = new LayoutParams(-1, -1);  // 初始化器: Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V
        viewGroup$LayoutParams0.a = 0;
        viewGroup$LayoutParams0.b = 0.5f;
        return viewGroup$LayoutParams0;
    }

    @Override  // android.widget.FrameLayout
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        FrameLayout.LayoutParams frameLayout$LayoutParams0 = new LayoutParams(-1, -1);  // 初始化器: Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V
        frameLayout$LayoutParams0.a = 0;
        frameLayout$LayoutParams0.b = 0.5f;
        return frameLayout$LayoutParams0;
    }

    @Override  // android.widget.FrameLayout
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return this.generateLayoutParams(attributeSet0);
    }

    @Override  // android.widget.FrameLayout
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        ViewGroup.LayoutParams viewGroup$LayoutParams1 = new LayoutParams(viewGroup$LayoutParams0);  // 初始化器: Landroid/widget/FrameLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V
        viewGroup$LayoutParams1.a = 0;
        viewGroup$LayoutParams1.b = 0.5f;
        return viewGroup$LayoutParams1;
    }

    @Override  // android.widget.FrameLayout
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return new LayoutParams(this.getContext(), attributeSet0);
    }

    public int getCollapsedTitleGravity() {
        return this.k.k;
    }

    public float getCollapsedTitleTextSize() {
        return this.k.m;
    }

    public Typeface getCollapsedTitleTypeface() {
        Typeface typeface0 = this.k.w;
        return typeface0 == null ? Typeface.DEFAULT : typeface0;
    }

    public Drawable getContentScrim() {
        return this.o;
    }

    private int getDefaultContentScrimColorForTitleCollapseFadeMode() {
        ColorStateList colorStateList0;
        Context context0 = this.getContext();
        TypedValue typedValue0 = m.y(context0, 0x7F040192);  // attr:colorSurfaceContainer
        if(typedValue0 == null) {
            colorStateList0 = null;
        }
        else {
            int v = typedValue0.resourceId;
            if(v == 0) {
                int v1 = typedValue0.data;
                colorStateList0 = v1 == 0 ? null : ColorStateList.valueOf(v1);
            }
            else {
                colorStateList0 = P1.c.getColorStateList(context0, v);
            }
        }
        if(colorStateList0 != null) {
            return colorStateList0.getDefaultColor();
        }
        float f = this.getResources().getDimension(0x7F0700B3);  // dimen:design_appbar_elevation
        return this.l.a(f, this.l.d);
    }

    public int getExpandedTitleGravity() {
        return this.k.j;
    }

    public int getExpandedTitleMarginBottom() {
        return this.i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f;
    }

    public int getExpandedTitleMarginTop() {
        return this.g;
    }

    public float getExpandedTitleTextSize() {
        return this.k.l;
    }

    public Typeface getExpandedTitleTypeface() {
        Typeface typeface0 = this.k.z;
        return typeface0 == null ? Typeface.DEFAULT : typeface0;
    }

    public int getHyphenationFrequency() {
        return this.k.q0;
    }

    public int getLineCount() {
        StaticLayout staticLayout0 = this.k.i0;
        return staticLayout0 == null ? 0 : staticLayout0.getLineCount();
    }

    public float getLineSpacingAdd() {
        return this.k.i0.getSpacingAdd();
    }

    public float getLineSpacingMultiplier() {
        return this.k.i0.getSpacingMultiplier();
    }

    public int getMaxLines() {
        return this.k.n0;
    }

    public int getScrimAlpha() {
        return this.w;
    }

    public long getScrimAnimationDuration() {
        return this.E;
    }

    public int getScrimVisibleHeightTrigger() {
        int v = this.M;
        if(v >= 0) {
            return v + this.W + this.c0;
        }
        int v1 = this.V == null ? 0 : this.V.d();
        int v2 = this.getMinimumHeight();
        return v2 <= 0 ? this.getHeight() / 3 : Math.min(v2 * 2 + v1, this.getHeight());
    }

    public Drawable getStatusBarScrim() {
        return this.r;
    }

    // 去混淆评级： 低(20)
    public CharSequence getTitle() {
        return this.m ? this.k.G : null;
    }

    public int getTitleCollapseMode() {
        return this.T;
    }

    public TimeInterpolator getTitlePositionInterpolator() {
        return this.k.V;
    }

    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.k.F;
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent viewParent0 = this.getParent();
        if(viewParent0 instanceof AppBarLayout) {
            if(this.T == 1) {
                ((AppBarLayout)viewParent0).setLiftOnScroll(false);
            }
            this.setFitsSystemWindows(((AppBarLayout)viewParent0).getFitsSystemWindows());
            if(this.N == null) {
                this.N = new f(this);
            }
            ((AppBarLayout)viewParent0).a(this.N);
            K.c(this);
        }
    }

    @Override  // android.view.View
    public final void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        this.k.h(configuration0);
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        ViewParent viewParent0 = this.getParent();
        f f0 = this.N;
        if(f0 != null && viewParent0 instanceof AppBarLayout) {
            ArrayList arrayList0 = ((AppBarLayout)viewParent0).h;
            if(arrayList0 != null) {
                arrayList0.remove(f0);
            }
        }
        super.onDetachedFromWindow();
    }

    @Override  // android.widget.FrameLayout
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        B0 b00 = this.V;
        if(b00 != null) {
            int v5 = b00.d();
            int v6 = this.getChildCount();
            for(int v7 = 0; v7 < v6; ++v7) {
                View view0 = this.getChildAt(v7);
                if(!view0.getFitsSystemWindows() && view0.getTop() < v5) {
                    view0.offsetTopAndBottom(v5);
                }
            }
        }
        int v8 = this.getChildCount();
        for(int v9 = 0; v9 < v8; ++v9) {
            i i0 = CollapsingToolbarLayout.b(this.getChildAt(v9));
            i0.b = i0.a.getTop();
            i0.c = i0.a.getLeft();
        }
        this.e(v, v1, v2, v3, false);
        this.f();
        this.d();
        int v10 = this.getChildCount();
        for(int v4 = 0; v4 < v10; ++v4) {
            CollapsingToolbarLayout.b(this.getChildAt(v4)).a();
        }
    }

    @Override  // android.widget.FrameLayout
    public final void onMeasure(int v, int v1) {
        this.a();
        super.onMeasure(v, v1);
        int v2 = View.MeasureSpec.getMode(v1);
        int v3 = this.V == null ? 0 : this.V.d();
        if((v2 == 0 || this.b0) && v3 > 0) {
            this.W = v3;
            super.onMeasure(v, View.MeasureSpec.makeMeasureSpec(this.getMeasuredHeight() + v3, 0x40000000));
        }
        if(this.d0) {
            c c0 = this.k;
            if(c0.n0 > 1) {
                this.f();
                this.e(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight(), true);
                int v4 = c0.p;
                if(v4 > 1) {
                    c0.U.setTextSize(c0.l);
                    c0.U.setTypeface(c0.z);
                    c0.U.setLetterSpacing(c0.g0);
                    float f = c0.U.ascent();
                    this.c0 = (v4 - 1) * Math.round(c0.U.descent() + -f);
                    super.onMeasure(v, View.MeasureSpec.makeMeasureSpec(this.getMeasuredHeight() + this.c0, 0x40000000));
                }
            }
        }
        ViewGroup viewGroup0 = this.c;
        if(viewGroup0 != null) {
            View view0 = this.d;
            if(view0 != null && view0 != this) {
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
                this.setMinimumHeight((viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams ? view0.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin + ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).bottomMargin : view0.getMeasuredHeight()));
                return;
            }
            ViewGroup.LayoutParams viewGroup$LayoutParams1 = viewGroup0.getLayoutParams();
            this.setMinimumHeight((viewGroup$LayoutParams1 instanceof ViewGroup.MarginLayoutParams ? viewGroup0.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams1).topMargin + ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams1).bottomMargin : viewGroup0.getMeasuredHeight()));
        }
    }

    @Override  // android.view.View
    public final void onSizeChanged(int v, int v1, int v2, int v3) {
        super.onSizeChanged(v, v1, v2, v3);
        Drawable drawable0 = this.o;
        if(drawable0 != null) {
            ViewGroup viewGroup0 = this.c;
            if(this.T == 1 && viewGroup0 != null && this.m) {
                v1 = viewGroup0.getBottom();
            }
            drawable0.setBounds(0, 0, v, v1);
        }
    }

    public void setCollapsedTitleGravity(int v) {
        this.k.l(v);
    }

    public void setCollapsedTitleTextAppearance(int v) {
        this.k.k(v);
    }

    public void setCollapsedTitleTextColor(int v) {
        this.setCollapsedTitleTextColor(ColorStateList.valueOf(v));
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList0) {
        c c0 = this.k;
        if(c0.o != colorStateList0) {
            c0.o = colorStateList0;
            c0.i(false);
        }
    }

    public void setCollapsedTitleTextSize(float f) {
        c c0 = this.k;
        if(c0.m != f) {
            c0.m = f;
            c0.i(false);
        }
    }

    public void setCollapsedTitleTypeface(Typeface typeface0) {
        c c0 = this.k;
        if(c0.m(typeface0)) {
            c0.i(false);
        }
    }

    public void setContentScrim(Drawable drawable0) {
        Drawable drawable1 = null;
        Drawable drawable2 = this.o;
        if(drawable2 != drawable0) {
            if(drawable2 != null) {
                drawable2.setCallback(null);
            }
            if(drawable0 != null) {
                drawable1 = drawable0.mutate();
            }
            this.o = drawable1;
            if(drawable1 != null) {
                int v = this.getWidth();
                int v1 = this.getHeight();
                ViewGroup viewGroup0 = this.c;
                if(this.T == 1 && viewGroup0 != null && this.m) {
                    v1 = viewGroup0.getBottom();
                }
                drawable1.setBounds(0, 0, v, v1);
                this.o.setCallback(this);
                this.o.setAlpha(this.w);
            }
            this.postInvalidateOnAnimation();
        }
    }

    public void setContentScrimColor(int v) {
        this.setContentScrim(new ColorDrawable(v));
    }

    public void setContentScrimResource(int v) {
        this.setContentScrim(P1.c.getDrawable(this.getContext(), v));
    }

    public void setExpandedTitleColor(int v) {
        this.setExpandedTitleTextColor(ColorStateList.valueOf(v));
    }

    public void setExpandedTitleGravity(int v) {
        c c0 = this.k;
        if(c0.j != v) {
            c0.j = v;
            c0.i(false);
        }
    }

    public void setExpandedTitleMarginBottom(int v) {
        this.i = v;
        this.requestLayout();
    }

    public void setExpandedTitleMarginEnd(int v) {
        this.h = v;
        this.requestLayout();
    }

    public void setExpandedTitleMarginStart(int v) {
        this.f = v;
        this.requestLayout();
    }

    public void setExpandedTitleMarginTop(int v) {
        this.g = v;
        this.requestLayout();
    }

    public void setExpandedTitleTextAppearance(int v) {
        this.k.n(v);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList0) {
        c c0 = this.k;
        if(c0.n != colorStateList0) {
            c0.n = colorStateList0;
            c0.i(false);
        }
    }

    public void setExpandedTitleTextSize(float f) {
        c c0 = this.k;
        if(c0.l != f) {
            c0.l = f;
            c0.i(false);
        }
    }

    public void setExpandedTitleTypeface(Typeface typeface0) {
        c c0 = this.k;
        if(c0.o(typeface0)) {
            c0.i(false);
        }
    }

    public void setExtraMultilineHeightEnabled(boolean z) {
        this.d0 = z;
    }

    public void setForceApplySystemWindowInsetTop(boolean z) {
        this.b0 = z;
    }

    public void setHyphenationFrequency(int v) {
        this.k.q0 = v;
    }

    public void setLineSpacingAdd(float f) {
        this.k.o0 = f;
    }

    public void setLineSpacingMultiplier(float f) {
        this.k.p0 = f;
    }

    public void setMaxLines(int v) {
        c c0 = this.k;
        if(v != c0.n0) {
            c0.n0 = v;
            Bitmap bitmap0 = c0.K;
            if(bitmap0 != null) {
                bitmap0.recycle();
                c0.K = null;
            }
            c0.i(false);
        }
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z) {
        this.k.J = z;
    }

    public void setScrimAlpha(int v) {
        if(v != this.w) {
            if(this.o != null) {
                ViewGroup viewGroup0 = this.c;
                if(viewGroup0 != null) {
                    viewGroup0.postInvalidateOnAnimation();
                }
            }
            this.w = v;
            this.postInvalidateOnAnimation();
        }
    }

    public void setScrimAnimationDuration(long v) {
        this.E = v;
    }

    public void setScrimVisibleHeightTrigger(int v) {
        if(this.M != v) {
            this.M = v;
            this.d();
        }
    }

    public void setScrimsShown(boolean z) {
        int v = 0;
        boolean z1 = this.isLaidOut() && !this.isInEditMode();
        if(this.B != z) {
            if(z1) {
                if(z) {
                    v = 0xFF;
                }
                this.a();
                ValueAnimator valueAnimator0 = this.D;
                if(valueAnimator0 == null) {
                    ValueAnimator valueAnimator1 = new ValueAnimator();
                    this.D = valueAnimator1;
                    valueAnimator1.setInterpolator((v <= this.w ? this.I : this.G));
                    this.D.addUpdateListener(new D6.b(this, 2));
                }
                else if(valueAnimator0.isRunning()) {
                    this.D.cancel();
                }
                this.D.setDuration(this.E);
                this.D.setIntValues(new int[]{this.w, v});
                this.D.start();
            }
            else {
                if(z) {
                    v = 0xFF;
                }
                this.setScrimAlpha(v);
            }
            this.B = z;
        }
    }

    public void setStaticLayoutBuilderConfigurer(g g0) {
        c c0 = this.k;
        if(g0 != null) {
            c0.i(true);
            return;
        }
        c0.getClass();
    }

    public void setStatusBarScrim(Drawable drawable0) {
        Drawable drawable1 = null;
        Drawable drawable2 = this.r;
        if(drawable2 != drawable0) {
            if(drawable2 != null) {
                drawable2.setCallback(null);
            }
            if(drawable0 != null) {
                drawable1 = drawable0.mutate();
            }
            this.r = drawable1;
            if(drawable1 != null) {
                if(drawable1.isStateful()) {
                    this.r.setState(this.getDrawableState());
                }
                this.r.setLayoutDirection(this.getLayoutDirection());
                this.r.setVisible(this.getVisibility() == 0, false);
                this.r.setCallback(this);
                this.r.setAlpha(this.w);
            }
            this.postInvalidateOnAnimation();
        }
    }

    public void setStatusBarScrimColor(int v) {
        this.setStatusBarScrim(new ColorDrawable(v));
    }

    public void setStatusBarScrimResource(int v) {
        this.setStatusBarScrim(P1.c.getDrawable(this.getContext(), v));
    }

    public void setTitle(CharSequence charSequence0) {
        c c0 = this.k;
        if(charSequence0 == null || !TextUtils.equals(c0.G, charSequence0)) {
            c0.G = charSequence0;
            c0.H = null;
            Bitmap bitmap0 = c0.K;
            if(bitmap0 != null) {
                bitmap0.recycle();
                c0.K = null;
            }
            c0.i(false);
        }
        this.setContentDescription(this.getTitle());
    }

    public void setTitleCollapseMode(int v) {
        this.T = v;
        this.k.c = v == 1;
        ViewParent viewParent0 = this.getParent();
        if(viewParent0 instanceof AppBarLayout && this.T == 1) {
            ((AppBarLayout)viewParent0).setLiftOnScroll(false);
        }
        if(v == 1 && this.o == null) {
            this.setContentScrimColor(this.getDefaultContentScrimColorForTitleCollapseFadeMode());
        }
    }

    public void setTitleEllipsize(TextUtils.TruncateAt textUtils$TruncateAt0) {
        this.k.F = textUtils$TruncateAt0;
        this.k.i(false);
    }

    public void setTitleEnabled(boolean z) {
        if(z != this.m) {
            this.m = z;
            this.setContentDescription(this.getTitle());
            this.c();
            this.requestLayout();
        }
    }

    public void setTitlePositionInterpolator(TimeInterpolator timeInterpolator0) {
        this.k.V = timeInterpolator0;
        this.k.i(false);
    }

    @Override  // android.view.View
    public void setVisibility(int v) {
        super.setVisibility(v);
        if(this.r != null && this.r.isVisible() != (v == 0)) {
            this.r.setVisible(v == 0, false);
        }
        if(this.o != null && this.o.isVisible() != (v == 0)) {
            this.o.setVisible(v == 0, false);
        }
    }

    @Override  // android.view.View
    public final boolean verifyDrawable(Drawable drawable0) {
        return super.verifyDrawable(drawable0) || drawable0 == this.o || drawable0 == this.r;
    }
}

