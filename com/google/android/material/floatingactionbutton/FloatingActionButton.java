package com.google.android.material.floatingactionbutton;

import android.animation.Animator.AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView.ScaleType;
import androidx.appcompat.widget.A;
import androidx.appcompat.widget.x;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.a;
import androidx.coordinatorlayout.widget.c;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomappbar.b;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.B;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.internal.d;
import com.google.android.material.stateful.ExtendableSavedState;
import d5.e;
import e1.n;
import e6.f;
import java.util.ArrayList;
import pc.t;
import r6.h;
import r6.i;
import r6.q;
import z6.o;
import z6.y;

public class FloatingActionButton extends VisibilityAwareImageButton implements a, q6.a, y {
    public static class BaseBehavior extends Behavior {
        public Rect a;
        public final boolean b;

        public BaseBehavior() {
            this.b = true;
        }

        public BaseBehavior(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, d6.a.t);
            this.b = typedArray0.getBoolean(0, true);
            typedArray0.recycle();
        }

        @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
        public final boolean e(View view0, Rect rect0) {
            rect0.set(((FloatingActionButton)view0).getLeft() + ((FloatingActionButton)view0).l.left, ((FloatingActionButton)view0).getTop() + ((FloatingActionButton)view0).l.top, ((FloatingActionButton)view0).getRight() - ((FloatingActionButton)view0).l.right, ((FloatingActionButton)view0).getBottom() - ((FloatingActionButton)view0).l.bottom);
            return true;
        }

        @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
        public final void g(c c0) {
            if(c0.h == 0) {
                c0.h = 80;
            }
        }

        @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
        public final boolean h(CoordinatorLayout coordinatorLayout0, View view0, View view1) {
            if(view1 instanceof AppBarLayout) {
                this.w(coordinatorLayout0, ((AppBarLayout)view1), ((FloatingActionButton)view0));
                return false;
            }
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = view1.getLayoutParams();
            if((viewGroup$LayoutParams0 instanceof c ? ((c)viewGroup$LayoutParams0).a instanceof BottomSheetBehavior : false)) {
                this.x(view1, ((FloatingActionButton)view0));
            }
            return false;
        }

        @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
        public final boolean l(CoordinatorLayout coordinatorLayout0, View view0, int v) {
            int v4;
            ArrayList arrayList0 = coordinatorLayout0.i(((FloatingActionButton)view0));
            int v1 = arrayList0.size();
            int v2 = 0;
            for(int v3 = 0; v3 < v1; ++v3) {
                View view1 = (View)arrayList0.get(v3);
                if(!(view1 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams viewGroup$LayoutParams0 = view1.getLayoutParams();
                    if(!(viewGroup$LayoutParams0 instanceof c ? ((c)viewGroup$LayoutParams0).a instanceof BottomSheetBehavior : false) || !this.x(view1, ((FloatingActionButton)view0))) {
                        continue;
                    }
                    break;
                }
                else if(this.w(coordinatorLayout0, ((AppBarLayout)view1), ((FloatingActionButton)view0))) {
                    break;
                }
            }
            coordinatorLayout0.p(((FloatingActionButton)view0), v);
            Rect rect0 = ((FloatingActionButton)view0).l;
            if(rect0 != null && rect0.centerX() > 0 && rect0.centerY() > 0) {
                c c0 = (c)((FloatingActionButton)view0).getLayoutParams();
                if(((FloatingActionButton)view0).getRight() >= coordinatorLayout0.getWidth() - c0.rightMargin) {
                    v4 = rect0.right;
                }
                else {
                    v4 = ((FloatingActionButton)view0).getLeft() > c0.leftMargin ? 0 : -rect0.left;
                }
                if(((FloatingActionButton)view0).getBottom() >= coordinatorLayout0.getHeight() - c0.bottomMargin) {
                    v2 = rect0.bottom;
                }
                else if(((FloatingActionButton)view0).getTop() <= c0.topMargin) {
                    v2 = -rect0.top;
                }
                if(v2 != 0) {
                    ((FloatingActionButton)view0).offsetTopAndBottom(v2);
                }
                if(v4 != 0) {
                    ((FloatingActionButton)view0).offsetLeftAndRight(v4);
                }
            }
            return true;
        }

        public final boolean w(CoordinatorLayout coordinatorLayout0, AppBarLayout appBarLayout0, FloatingActionButton floatingActionButton0) {
            c c0 = (c)floatingActionButton0.getLayoutParams();
            if(this.b) {
                int v = appBarLayout0.getId();
                if(c0.f == v && floatingActionButton0.getUserSetVisibility() == 0) {
                    if(this.a == null) {
                        this.a = new Rect();
                    }
                    Rect rect0 = this.a;
                    d.a(coordinatorLayout0, appBarLayout0, rect0);
                    if(rect0.bottom <= appBarLayout0.getMinimumHeightForVisibleOverlappingContent()) {
                        floatingActionButton0.g(null, false);
                        return true;
                    }
                    floatingActionButton0.l(null, false);
                    return true;
                }
            }
            return false;
        }

        public final boolean x(View view0, FloatingActionButton floatingActionButton0) {
            c c0 = (c)floatingActionButton0.getLayoutParams();
            if(this.b) {
                int v = view0.getId();
                if(c0.f == v && floatingActionButton0.getUserSetVisibility() == 0) {
                    c c1 = (c)floatingActionButton0.getLayoutParams();
                    if(view0.getTop() < floatingActionButton0.getHeight() / 2 + c1.topMargin) {
                        floatingActionButton0.g(null, false);
                        return true;
                    }
                    floatingActionButton0.l(null, false);
                    return true;
                }
            }
            return false;
        }
    }

    public static class com.google.android.material.floatingactionbutton.FloatingActionButton.Behavior extends BaseBehavior {
        public com.google.android.material.floatingactionbutton.FloatingActionButton.Behavior() {
        }

        public com.google.android.material.floatingactionbutton.FloatingActionButton.Behavior(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
        }
    }

    public ColorStateList b;
    public PorterDuff.Mode c;
    public ColorStateList d;
    public PorterDuff.Mode e;
    public ColorStateList f;
    public int g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public final Rect l;
    public final Rect m;
    public final A n;
    public final O.a o;
    public q r;

    public FloatingActionButton(Context context0) {
        this(context0, null);
    }

    public FloatingActionButton(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040297);  // attr:floatingActionButtonStyle
    }

    public FloatingActionButton(Context context0, AttributeSet attributeSet0, int v) {
        super(E6.a.a(context0, attributeSet0, v, 0x7F1403C1), attributeSet0, v);  // style:Widget.Design.FloatingActionButton
        this.l = new Rect();
        this.m = new Rect();
        Context context1 = this.getContext();
        TypedArray typedArray0 = B.m(context1, attributeSet0, d6.a.s, v, 0x7F1403C1, new int[0]);  // style:Widget.Design.FloatingActionButton
        this.b = n.r(context1, typedArray0, 1);
        this.c = B.o(typedArray0.getInt(2, -1), null);
        this.f = n.r(context1, typedArray0, 12);
        this.g = typedArray0.getInt(7, -1);
        this.h = typedArray0.getDimensionPixelSize(6, 0);
        int v1 = typedArray0.getDimensionPixelSize(3, 0);
        float f = typedArray0.getDimension(4, 0.0f);
        float f1 = typedArray0.getDimension(9, 0.0f);
        float f2 = typedArray0.getDimension(11, 0.0f);
        this.k = typedArray0.getBoolean(16, false);
        int v2 = this.getResources().getDimensionPixelSize(0x7F070398);  // dimen:mtrl_fab_min_touch_target
        this.setMaxImageSize(typedArray0.getDimensionPixelSize(10, 0));
        f f3 = f.a(context1, typedArray0, 15);
        f f4 = f.a(context1, typedArray0, 8);
        o o0 = o.c(context1, attributeSet0, v, 0x7F1403C1, o.m).a();  // style:Widget.Design.FloatingActionButton
        boolean z = typedArray0.getBoolean(5, false);
        this.setEnabled(typedArray0.getBoolean(0, true));
        typedArray0.recycle();
        A a0 = new A(this);
        this.n = a0;
        a0.b(attributeSet0, v);
        O.a a1 = new O.a();  // 初始化器: Ljava/lang/Object;-><init>()V
        a1.b = false;
        a1.a = 0;
        a1.c = this;
        this.o = a1;
        this.getImpl().o(o0);
        this.getImpl().g(this.b, this.c, this.f, v1);
        this.getImpl().k = v2;
        r6.o o1 = this.getImpl();
        if(o1.h != f) {
            o1.h = f;
            o1.k(f, o1.i, o1.j);
        }
        r6.o o2 = this.getImpl();
        if(o2.i != f1) {
            o2.i = f1;
            o2.k(o2.h, f1, o2.j);
        }
        r6.o o3 = this.getImpl();
        if(o3.j != f2) {
            o3.j = f2;
            o3.k(o3.h, o3.i, f2);
        }
        this.getImpl().m = f3;
        this.getImpl().n = f4;
        this.getImpl().f = z;
        this.setScaleType(ImageView.ScaleType.MATRIX);
    }

    public final void c(com.google.android.material.bottomappbar.a a0) {
        r6.o o0 = this.getImpl();
        if(o0.t == null) {
            o0.t = new ArrayList();
        }
        o0.t.add(a0);
    }

    public final void d(com.google.android.material.bottomappbar.a a0) {
        r6.o o0 = this.getImpl();
        if(o0.s == null) {
            o0.s = new ArrayList();
        }
        o0.s.add(a0);
    }

    @Override  // android.widget.ImageView
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        this.getImpl().j(this.getDrawableState());
    }

    public final void e(b b0) {
        r6.o o0 = this.getImpl();
        h h0 = new h(this, b0);
        if(o0.u == null) {
            o0.u = new ArrayList();
        }
        o0.u.add(h0);
    }

    public final int f(int v) {
        int v1 = this.h;
        if(v1 != 0) {
            return v1;
        }
        Resources resources0 = this.getResources();
        switch(v) {
            case -1: {
                return Math.max(resources0.getConfiguration().screenWidthDp, resources0.getConfiguration().screenHeightDp) >= 470 ? this.f(0) : this.f(1);
            }
            case 1: {
                return resources0.getDimensionPixelSize(0x7F0700C6);  // dimen:design_fab_size_mini
            }
            default: {
                return resources0.getDimensionPixelSize(0x7F0700C7);  // dimen:design_fab_size_normal
            }
        }
    }

    public final void g(com.google.android.material.bottomappbar.d d0, boolean z) {
        r6.o o0 = this.getImpl();
        e e0 = d0 == null ? null : new e(this, d0, false, 14);
        FloatingActionButton floatingActionButton0 = o0.v;
        if(o0.v.getVisibility() == 0) {
            if(o0.r != 1) {
                goto label_7;
            }
        }
        else if(o0.r == 2) {
        label_7:
            Animator animator0 = o0.l;
            if(animator0 != null) {
                animator0.cancel();
            }
            if(floatingActionButton0.isLaidOut() && !floatingActionButton0.isInEditMode()) {
                f f0 = o0.n;
                AnimatorSet animatorSet0 = f0 == null ? o0.c(0.0f, 0.4f, 0.4f, r6.o.F, r6.o.G) : o0.b(f0, 0.0f, 0.0f, 0.0f);
                animatorSet0.addListener(new i(o0, z, e0));
                ArrayList arrayList0 = o0.t;
                if(arrayList0 != null) {
                    for(Object object0: arrayList0) {
                        animatorSet0.addListener(((Animator.AnimatorListener)object0));
                    }
                }
                animatorSet0.start();
                return;
            }
            floatingActionButton0.a((z ? 8 : 4), z);
            if(e0 != null) {
                ((e2.a)e0.b).N(((FloatingActionButton)e0.c));
            }
        }
    }

    @Override  // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.b;
    }

    @Override  // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.c;
    }

    @Override  // androidx.coordinatorlayout.widget.a
    public Behavior getBehavior() {
        return new com.google.android.material.floatingactionbutton.FloatingActionButton.Behavior();
    }

    public float getCompatElevation() {
        return this.getImpl().e();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return this.getImpl().i;
    }

    public float getCompatPressedTranslationZ() {
        return this.getImpl().j;
    }

    public Drawable getContentBackground() {
        return this.getImpl().e;
    }

    public int getCustomSize() {
        return this.h;
    }

    public int getExpandedComponentIdHint() {
        return this.o.a;
    }

    public f getHideMotionSpec() {
        return this.getImpl().n;
    }

    private r6.o getImpl() {
        if(this.r == null) {
            this.r = new q(this, new t(this, 6));  // 初始化器: Lr6/o;-><init>(Lcom/google/android/material/floatingactionbutton/FloatingActionButton;Lpc/t;)V
        }
        return this.r;
    }

    @Deprecated
    public int getRippleColor() {
        return this.f == null ? 0 : this.f.getDefaultColor();
    }

    public ColorStateList getRippleColorStateList() {
        return this.f;
    }

    public o getShapeAppearanceModel() {
        o o0 = this.getImpl().a;
        o0.getClass();
        return o0;
    }

    public f getShowMotionSpec() {
        return this.getImpl().m;
    }

    public int getSize() {
        return this.g;
    }

    public int getSizeDimension() {
        return this.f(this.g);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.d;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.e;
    }

    public boolean getUseCompatPadding() {
        return this.k;
    }

    public final boolean h() {
        r6.o o0 = this.getImpl();
        return o0.v.getVisibility() == 0 ? o0.r == 1 : o0.r != 2;
    }

    public final boolean i() {
        r6.o o0 = this.getImpl();
        return o0.v.getVisibility() == 0 ? o0.r != 1 : o0.r == 2;
    }

    public final void j(Rect rect0) {
        rect0.left += this.l.left;
        rect0.top += this.l.top;
        rect0.right -= this.l.right;
        rect0.bottom -= this.l.bottom;
    }

    @Override  // android.widget.ImageView
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.getImpl().h();
    }

    public final void k() {
        Drawable drawable0 = this.getDrawable();
        if(drawable0 == null) {
            return;
        }
        ColorStateList colorStateList0 = this.d;
        if(colorStateList0 == null) {
            drawable0.clearColorFilter();
            return;
        }
        int v = colorStateList0.getColorForState(this.getDrawableState(), 0);
        PorterDuff.Mode porterDuff$Mode0 = this.e == null ? PorterDuff.Mode.SRC_IN : this.e;
        drawable0.mutate().setColorFilter(x.c(v, porterDuff$Mode0));
    }

    public final void l(com.google.android.material.bottomappbar.c c0, boolean z) {
        r6.o o0 = this.getImpl();
        e e0 = c0 == null ? null : new e(this, c0, false, 14);
        FloatingActionButton floatingActionButton0 = o0.v;
        Matrix matrix0 = o0.A;
        FloatingActionButton floatingActionButton1 = o0.v;
        boolean z1 = true;
        if(floatingActionButton0.getVisibility() != 0) {
            if(o0.r != 2) {
                goto label_10;
            }
        }
        else if(o0.r == 1) {
        label_10:
            Animator animator0 = o0.l;
            if(animator0 != null) {
                animator0.cancel();
            }
            if(o0.m != null) {
                z1 = false;
            }
            if(floatingActionButton1.isLaidOut() && !floatingActionButton1.isInEditMode()) {
                if(floatingActionButton0.getVisibility() != 0) {
                    float f = 0.0f;
                    floatingActionButton0.setAlpha(0.0f);
                    floatingActionButton0.setScaleY((z1 ? 0.4f : 0.0f));
                    floatingActionButton0.setScaleX((z1 ? 0.4f : 0.0f));
                    if(z1) {
                        f = 0.4f;
                    }
                    o0.p = f;
                    o0.a(f, matrix0);
                    floatingActionButton1.setImageMatrix(matrix0);
                }
                f f1 = o0.m;
                AnimatorSet animatorSet0 = f1 == null ? o0.c(1.0f, 1.0f, 1.0f, r6.o.D, r6.o.E) : o0.b(f1, 1.0f, 1.0f, 1.0f);
                animatorSet0.addListener(new G6.b(o0, z, e0));
                ArrayList arrayList0 = o0.s;
                if(arrayList0 != null) {
                    for(Object object0: arrayList0) {
                        animatorSet0.addListener(((Animator.AnimatorListener)object0));
                    }
                }
                animatorSet0.start();
                return;
            }
            floatingActionButton0.a(0, z);
            floatingActionButton0.setAlpha(1.0f);
            floatingActionButton0.setScaleY(1.0f);
            floatingActionButton0.setScaleX(1.0f);
            o0.p = 1.0f;
            o0.a(1.0f, matrix0);
            floatingActionButton1.setImageMatrix(matrix0);
            if(e0 != null) {
                ((e2.a)e0.b).O();
            }
        }
    }

    @Override  // android.widget.ImageView
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        r6.o o0 = this.getImpl();
        FloatingActionButton floatingActionButton0 = o0.v;
        z6.i i0 = o0.b;
        if(i0 != null) {
            d5.n.A(floatingActionButton0, i0);
        }
        if(!(o0 instanceof q)) {
            ViewTreeObserver viewTreeObserver0 = floatingActionButton0.getViewTreeObserver();
            if(o0.B == null) {
                o0.B = new L1.b(o0, 2);
            }
            viewTreeObserver0.addOnPreDrawListener(o0.B);
        }
    }

    @Override  // android.widget.ImageView
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        r6.o o0 = this.getImpl();
        ViewTreeObserver viewTreeObserver0 = o0.v.getViewTreeObserver();
        L1.b b0 = o0.B;
        if(b0 != null) {
            viewTreeObserver0.removeOnPreDrawListener(b0);
            o0.B = null;
        }
    }

    @Override  // android.widget.ImageView
    public final void onMeasure(int v, int v1) {
        int v2 = this.getSizeDimension();
        this.i = (v2 - this.j) / 2;
        this.getImpl().r();
        int v3 = Math.min(View.resolveSize(v2, v), View.resolveSize(v2, v1));
        this.setMeasuredDimension(this.l.left + v3 + this.l.right, v3 + this.l.top + this.l.bottom);
    }

    @Override  // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        super.onRestoreInstanceState(((ExtendableSavedState)parcelable0).a);
        Bundle bundle0 = (Bundle)((ExtendableSavedState)parcelable0).c.get("expandableWidgetHelper");
        bundle0.getClass();
        O.a a0 = this.o;
        a0.getClass();
        a0.b = bundle0.getBoolean("expanded", false);
        a0.a = bundle0.getInt("expandedComponentIdHint", 0);
        if(a0.b) {
            FloatingActionButton floatingActionButton0 = (FloatingActionButton)a0.c;
            ViewParent viewParent0 = floatingActionButton0.getParent();
            if(viewParent0 instanceof CoordinatorLayout) {
                ((CoordinatorLayout)viewParent0).g(floatingActionButton0);
            }
        }
    }

    @Override  // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = super.onSaveInstanceState();
        if(parcelable0 == null) {
            parcelable0 = new Bundle();
        }
        Parcelable parcelable1 = new ExtendableSavedState(parcelable0);
        this.o.getClass();
        Bundle bundle0 = new Bundle();
        bundle0.putBoolean("expanded", this.o.b);
        bundle0.putInt("expandedComponentIdHint", this.o.a);
        parcelable1.c.put("expandableWidgetHelper", bundle0);
        return parcelable1;
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        if(motionEvent0.getAction() == 0) {
            int v = this.getMeasuredWidth();
            int v1 = this.getMeasuredHeight();
            this.m.set(0, 0, v, v1);
            this.j(this.m);
            int v2 = this.r.f ? Math.max((this.r.k - this.r.v.getSizeDimension()) / 2, 0) : 0;
            this.m.inset(-v2, -v2);
            return this.m.contains(((int)motionEvent0.getX()), ((int)motionEvent0.getY())) ? super.onTouchEvent(motionEvent0) : false;
        }
        return super.onTouchEvent(motionEvent0);
    }

    @Override  // android.view.View
    public void setBackgroundColor(int v) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override  // android.view.View
    public void setBackgroundDrawable(Drawable drawable0) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override  // android.view.View
    public void setBackgroundResource(int v) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override  // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList0) {
        if(this.b != colorStateList0) {
            this.b = colorStateList0;
            r6.o o0 = this.getImpl();
            z6.i i0 = o0.b;
            if(i0 != null) {
                i0.setTintList(colorStateList0);
            }
            r6.b b0 = o0.d;
            if(b0 != null) {
                if(colorStateList0 != null) {
                    b0.m = colorStateList0.getColorForState(b0.getState(), b0.m);
                }
                b0.p = colorStateList0;
                b0.n = true;
                b0.invalidateSelf();
            }
        }
    }

    @Override  // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode porterDuff$Mode0) {
        if(this.c != porterDuff$Mode0) {
            this.c = porterDuff$Mode0;
            z6.i i0 = this.getImpl().b;
            if(i0 != null) {
                i0.setTintMode(porterDuff$Mode0);
            }
        }
    }

    public void setCompatElevation(float f) {
        r6.o o0 = this.getImpl();
        if(o0.h != f) {
            o0.h = f;
            o0.k(f, o0.i, o0.j);
        }
    }

    public void setCompatElevationResource(int v) {
        this.setCompatElevation(this.getResources().getDimension(v));
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        r6.o o0 = this.getImpl();
        if(o0.i != f) {
            o0.i = f;
            o0.k(o0.h, f, o0.j);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(int v) {
        this.setCompatHoveredFocusedTranslationZ(this.getResources().getDimension(v));
    }

    public void setCompatPressedTranslationZ(float f) {
        r6.o o0 = this.getImpl();
        if(o0.j != f) {
            o0.j = f;
            o0.k(o0.h, o0.i, f);
        }
    }

    public void setCompatPressedTranslationZResource(int v) {
        this.setCompatPressedTranslationZ(this.getResources().getDimension(v));
    }

    public void setCustomSize(int v) {
        if(v < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if(v != this.h) {
            this.h = v;
            this.requestLayout();
        }
    }

    @Override  // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        z6.i i0 = this.getImpl().b;
        if(i0 != null) {
            i0.l(f);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if(z != this.getImpl().f) {
            this.getImpl().f = z;
            this.requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int v) {
        this.o.a = v;
    }

    public void setHideMotionSpec(f f0) {
        this.getImpl().n = f0;
    }

    public void setHideMotionSpecResource(int v) {
        this.setHideMotionSpec(f.b(this.getContext(), v));
    }

    @Override  // android.widget.ImageView
    public void setImageDrawable(Drawable drawable0) {
        if(this.getDrawable() != drawable0) {
            super.setImageDrawable(drawable0);
            r6.o o0 = this.getImpl();
            float f = o0.p;
            o0.p = f;
            o0.a(f, o0.A);
            o0.v.setImageMatrix(o0.A);
            if(this.d != null) {
                this.k();
            }
        }
    }

    @Override  // android.widget.ImageView
    public void setImageResource(int v) {
        this.n.c(v);
        this.k();
    }

    public void setMaxImageSize(int v) {
        this.j = v;
        r6.o o0 = this.getImpl();
        if(o0.q != v) {
            o0.q = v;
            float f = o0.p;
            o0.p = f;
            o0.a(f, o0.A);
            o0.v.setImageMatrix(o0.A);
        }
    }

    public void setRippleColor(int v) {
        this.setRippleColor(ColorStateList.valueOf(v));
    }

    public void setRippleColor(ColorStateList colorStateList0) {
        if(this.f != colorStateList0) {
            this.f = colorStateList0;
            this.getImpl().n(this.f);
        }
    }

    @Override  // android.view.View
    public void setScaleX(float f) {
        super.setScaleX(f);
        this.getImpl().l();
    }

    @Override  // android.view.View
    public void setScaleY(float f) {
        super.setScaleY(f);
        this.getImpl().l();
    }

    public void setShadowPaddingEnabled(boolean z) {
        r6.o o0 = this.getImpl();
        o0.g = z;
        o0.r();
    }

    @Override  // z6.y
    public void setShapeAppearanceModel(o o0) {
        this.getImpl().o(o0);
    }

    public void setShowMotionSpec(f f0) {
        this.getImpl().m = f0;
    }

    public void setShowMotionSpecResource(int v) {
        this.setShowMotionSpec(f.b(this.getContext(), v));
    }

    public void setSize(int v) {
        this.h = 0;
        if(v != this.g) {
            this.g = v;
            this.requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList0) {
        this.setBackgroundTintList(colorStateList0);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode porterDuff$Mode0) {
        this.setBackgroundTintMode(porterDuff$Mode0);
    }

    public void setSupportImageTintList(ColorStateList colorStateList0) {
        if(this.d != colorStateList0) {
            this.d = colorStateList0;
            this.k();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode porterDuff$Mode0) {
        if(this.e != porterDuff$Mode0) {
            this.e = porterDuff$Mode0;
            this.k();
        }
    }

    @Override  // android.view.View
    public void setTranslationX(float f) {
        super.setTranslationX(f);
        this.getImpl().m();
    }

    @Override  // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        this.getImpl().m();
    }

    @Override  // android.view.View
    public void setTranslationZ(float f) {
        super.setTranslationZ(f);
        this.getImpl().m();
    }

    public void setUseCompatPadding(boolean z) {
        if(this.k != z) {
            this.k = z;
            this.getImpl().i();
        }
    }

    @Override  // com.google.android.material.internal.VisibilityAwareImageButton
    public void setVisibility(int v) {
        super.setVisibility(v);
    }
}

