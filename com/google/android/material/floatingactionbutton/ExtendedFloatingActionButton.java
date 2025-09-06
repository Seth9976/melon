package com.google.android.material.floatingactionbutton;

import A6.h;
import N4.b;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.a;
import androidx.coordinatorlayout.widget.c;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.B;
import com.google.android.material.internal.d;
import d5.m;
import java.util.ArrayList;
import pc.t;
import r6.e;
import r6.f;
import z6.o;

public class ExtendedFloatingActionButton extends MaterialButton implements a {
    public static class ExtendedFloatingActionButtonBehavior extends Behavior {
        public Rect a;
        public final boolean b;
        public final boolean c;

        public ExtendedFloatingActionButtonBehavior() {
            this.b = false;
            this.c = true;
        }

        public ExtendedFloatingActionButtonBehavior(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, d6.a.r);
            this.b = typedArray0.getBoolean(0, false);
            this.c = typedArray0.getBoolean(1, true);
            typedArray0.recycle();
        }

        @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
        public final boolean e(View view0, Rect rect0) {
            ExtendedFloatingActionButton extendedFloatingActionButton0 = (ExtendedFloatingActionButton)view0;
            return false;
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
                this.w(coordinatorLayout0, ((AppBarLayout)view1), ((ExtendedFloatingActionButton)view0));
                return false;
            }
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = view1.getLayoutParams();
            if((viewGroup$LayoutParams0 instanceof c ? ((c)viewGroup$LayoutParams0).a instanceof BottomSheetBehavior : false)) {
                this.x(view1, ((ExtendedFloatingActionButton)view0));
            }
            return false;
        }

        @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
        public final boolean l(CoordinatorLayout coordinatorLayout0, View view0, int v) {
            ArrayList arrayList0 = coordinatorLayout0.i(((ExtendedFloatingActionButton)view0));
            int v1 = arrayList0.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                View view1 = (View)arrayList0.get(v2);
                if(!(view1 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams viewGroup$LayoutParams0 = view1.getLayoutParams();
                    if(!(viewGroup$LayoutParams0 instanceof c ? ((c)viewGroup$LayoutParams0).a instanceof BottomSheetBehavior : false) || !this.x(view1, ((ExtendedFloatingActionButton)view0))) {
                        continue;
                    }
                    break;
                }
                else if(this.w(coordinatorLayout0, ((AppBarLayout)view1), ((ExtendedFloatingActionButton)view0))) {
                    break;
                }
            }
            coordinatorLayout0.p(((ExtendedFloatingActionButton)view0), v);
            return true;
        }

        public final boolean w(CoordinatorLayout coordinatorLayout0, AppBarLayout appBarLayout0, ExtendedFloatingActionButton extendedFloatingActionButton0) {
            c c0 = (c)extendedFloatingActionButton0.getLayoutParams();
            int v = 0;
            if(this.b || this.c) {
                int v1 = appBarLayout0.getId();
                if(c0.f == v1) {
                    if(this.a == null) {
                        this.a = new Rect();
                    }
                    Rect rect0 = this.a;
                    d.a(coordinatorLayout0, appBarLayout0, rect0);
                    if(rect0.bottom <= appBarLayout0.getMinimumHeightForVisibleOverlappingContent()) {
                        ExtendedFloatingActionButton.e(extendedFloatingActionButton0, (this.c ? 2 : 1));
                        return true;
                    }
                    if(this.c) {
                        v = 3;
                    }
                    ExtendedFloatingActionButton.e(extendedFloatingActionButton0, v);
                    return true;
                }
            }
            return false;
        }

        public final boolean x(View view0, ExtendedFloatingActionButton extendedFloatingActionButton0) {
            c c0 = (c)extendedFloatingActionButton0.getLayoutParams();
            int v = 0;
            if(this.b || this.c) {
                int v1 = view0.getId();
                if(c0.f == v1) {
                    c c1 = (c)extendedFloatingActionButton0.getLayoutParams();
                    int v2 = 2;
                    if(view0.getTop() < extendedFloatingActionButton0.getHeight() / 2 + c1.topMargin) {
                        if(!this.c) {
                            v2 = 1;
                        }
                        ExtendedFloatingActionButton.e(extendedFloatingActionButton0, v2);
                        return true;
                    }
                    if(this.c) {
                        v = 3;
                    }
                    ExtendedFloatingActionButton.e(extendedFloatingActionButton0, v);
                    return true;
                }
            }
            return false;
        }
    }

    public int E;
    public final r6.d G;
    public final r6.d I;
    public final f M;
    public final e N;
    public final int S;
    public int T;
    public int V;
    public final ExtendedFloatingActionButtonBehavior W;
    public boolean b0;
    public boolean c0;
    public boolean d0;
    public ColorStateList e0;
    public int f0;
    public int g0;
    public static final b h0;
    public static final b i0;
    public static final b j0;
    public static final b k0;

    static {
        ExtendedFloatingActionButton.h0 = new b("width", 11, Float.class);
        ExtendedFloatingActionButton.i0 = new b("height", 12, Float.class);
        ExtendedFloatingActionButton.j0 = new b("paddingStart", 13, Float.class);
        ExtendedFloatingActionButton.k0 = new b("paddingEnd", 14, Float.class);
    }

    public ExtendedFloatingActionButton(Context context0) {
        this(context0, null);
    }

    public ExtendedFloatingActionButton(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040269);  // attr:extendedFloatingActionButtonStyle
    }

    public ExtendedFloatingActionButton(Context context0, AttributeSet attributeSet0, int v) {
        super(E6.a.a(context0, attributeSet0, v, 0x7F1404A5), attributeSet0, v);  // style:Widget.MaterialComponents.ExtendedFloatingActionButton.Icon
        this.E = 0;
        t t0 = new t(5, false);
        f f0 = new f(this, t0);
        this.M = f0;
        e e0 = new e(this, t0);
        this.N = e0;
        this.b0 = true;
        this.c0 = false;
        this.d0 = false;
        Context context1 = this.getContext();
        this.W = new ExtendedFloatingActionButtonBehavior(context1, attributeSet0);
        TypedArray typedArray0 = B.m(context1, attributeSet0, d6.a.q, v, 0x7F1404A5, new int[0]);  // style:Widget.MaterialComponents.ExtendedFloatingActionButton.Icon
        e6.f f1 = e6.f.a(context1, typedArray0, 5);
        e6.f f2 = e6.f.a(context1, typedArray0, 4);
        e6.f f3 = e6.f.a(context1, typedArray0, 2);
        e6.f f4 = e6.f.a(context1, typedArray0, 6);
        this.S = typedArray0.getDimensionPixelSize(0, -1);
        int v1 = typedArray0.getInt(3, 1);
        this.T = this.getPaddingStart();
        this.V = this.getPaddingEnd();
        t t1 = new t(5, false);
        r6.c c0 = new r6.c(this, 1);
        d5.c c1 = new d5.c(this, c0, false, 14);
        m m0 = new m(this, c1, c0);
        if(v1 != 1) {
            c0 = v1 == 2 ? c1 : m0;
        }
        r6.d d0 = new r6.d(this, t1, c0, true);
        this.I = d0;
        r6.d d1 = new r6.d(this, t1, new r6.c(this, 0), false);
        this.G = d1;
        f0.f = f1;
        e0.f = f2;
        d0.f = f3;
        d1.f = f4;
        typedArray0.recycle();
        this.setShapeAppearanceModel(o.c(context1, attributeSet0, v, 0x7F1404A5, o.m).a());  // style:Widget.MaterialComponents.ExtendedFloatingActionButton.Icon
        this.e0 = this.getTextColors();
    }

    public static void e(ExtendedFloatingActionButton extendedFloatingActionButton0, int v) {
        f f0;
        switch(v) {
            case 0: {
                f0 = extendedFloatingActionButton0.M;
                break;
            }
            case 1: {
                f0 = extendedFloatingActionButton0.N;
                break;
            }
            case 2: {
                f0 = extendedFloatingActionButton0.G;
                break;
            }
            default: {
                if(v != 3) {
                    throw new IllegalStateException("Unknown strategy type: " + v);
                }
                f0 = extendedFloatingActionButton0.I;
                break;
            }
        }
        if(f0.h()) {
            return;
        }
        if((extendedFloatingActionButton0.isLaidOut() || !(extendedFloatingActionButton0.getVisibility() == 0 ? extendedFloatingActionButton0.E != 1 : extendedFloatingActionButton0.E == 2) && extendedFloatingActionButton0.d0) && !extendedFloatingActionButton0.isInEditMode()) {
            if(v == 2) {
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = extendedFloatingActionButton0.getLayoutParams();
                if(viewGroup$LayoutParams0 == null) {
                    extendedFloatingActionButton0.f0 = extendedFloatingActionButton0.getWidth();
                    extendedFloatingActionButton0.g0 = extendedFloatingActionButton0.getHeight();
                }
                else {
                    extendedFloatingActionButton0.f0 = viewGroup$LayoutParams0.width;
                    extendedFloatingActionButton0.g0 = viewGroup$LayoutParams0.height;
                }
            }
            extendedFloatingActionButton0.measure(0, 0);
            AnimatorSet animatorSet0 = f0.a();
            animatorSet0.addListener(new h(f0, 10));
            for(Object object0: f0.c) {
                animatorSet0.addListener(((Animator.AnimatorListener)object0));
            }
            animatorSet0.start();
            return;
        }
        f0.g();
    }

    public final void f(ColorStateList colorStateList0) {
        super.setTextColor(colorStateList0);
    }

    @Override  // androidx.coordinatorlayout.widget.a
    public Behavior getBehavior() {
        return this.W;
    }

    public int getCollapsedPadding() {
        return (this.getCollapsedSize() - this.getIconSize()) / 2;
    }

    public int getCollapsedSize() {
        return this.S >= 0 ? this.S : this.getIconSize() + Math.min(this.getPaddingStart(), this.getPaddingEnd()) * 2;
    }

    public e6.f getExtendMotionSpec() {
        return this.I.f;
    }

    public e6.f getHideMotionSpec() {
        return this.N.f;
    }

    public e6.f getShowMotionSpec() {
        return this.M.f;
    }

    public e6.f getShrinkMotionSpec() {
        return this.G.f;
    }

    @Override  // com.google.android.material.button.MaterialButton
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(this.b0 && TextUtils.isEmpty(this.getText()) && this.getIcon() != null) {
            this.b0 = false;
            this.G.g();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z) {
        this.d0 = z;
    }

    public void setExtendMotionSpec(e6.f f0) {
        this.I.f = f0;
    }

    public void setExtendMotionSpecResource(int v) {
        this.setExtendMotionSpec(e6.f.b(this.getContext(), v));
    }

    public void setExtended(boolean z) {
        if(this.b0 != z) {
            r6.d d0 = z ? this.I : this.G;
            if(!d0.h()) {
                d0.g();
            }
        }
    }

    public void setHideMotionSpec(e6.f f0) {
        this.N.f = f0;
    }

    public void setHideMotionSpecResource(int v) {
        this.setHideMotionSpec(e6.f.b(this.getContext(), v));
    }

    @Override  // android.widget.TextView
    public final void setPadding(int v, int v1, int v2, int v3) {
        super.setPadding(v, v1, v2, v3);
        if(this.b0 && !this.c0) {
            this.T = this.getPaddingStart();
            this.V = this.getPaddingEnd();
        }
    }

    @Override  // android.widget.TextView
    public final void setPaddingRelative(int v, int v1, int v2, int v3) {
        super.setPaddingRelative(v, v1, v2, v3);
        if(this.b0 && !this.c0) {
            this.T = v;
            this.V = v2;
        }
    }

    public void setShowMotionSpec(e6.f f0) {
        this.M.f = f0;
    }

    public void setShowMotionSpecResource(int v) {
        this.setShowMotionSpec(e6.f.b(this.getContext(), v));
    }

    public void setShrinkMotionSpec(e6.f f0) {
        this.G.f = f0;
    }

    public void setShrinkMotionSpecResource(int v) {
        this.setShrinkMotionSpec(e6.f.b(this.getContext(), v));
    }

    @Override  // android.widget.TextView
    public void setTextColor(int v) {
        super.setTextColor(v);
        this.e0 = this.getTextColors();
    }

    @Override  // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList0) {
        super.setTextColor(colorStateList0);
        this.e0 = this.getTextColors();
    }
}

