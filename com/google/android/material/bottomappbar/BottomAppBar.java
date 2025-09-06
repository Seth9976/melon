package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar.LayoutParams;
import androidx.appcompat.widget.Toolbar;
import androidx.collection.V;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.a;
import androidx.coordinatorlayout.widget.c;
import androidx.customview.view.AbsSavedState;
import c2.M;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.B;
import e1.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import z6.f;
import z6.i;
import z6.l;
import z6.o;

public class BottomAppBar extends Toolbar implements a {
    public static class Behavior extends HideBottomViewOnScrollBehavior {
        public final Rect j;
        public WeakReference k;
        public int l;
        public final g m;

        public Behavior() {
            this.m = new g(this);
            this.j = new Rect();
        }

        public Behavior(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
            this.m = new g(this);
            this.j = new Rect();
        }

        @Override  // com.google.android.material.behavior.HideBottomViewOnScrollBehavior
        public final boolean l(CoordinatorLayout coordinatorLayout0, View view0, int v) {
            this.k = new WeakReference(((BottomAppBar)view0));
            View view1 = ((BottomAppBar)view0).C();
            if(view1 != null && !view1.isLaidOut()) {
                BottomAppBar.L(((BottomAppBar)view0), view1);
                this.l = ((c)view1.getLayoutParams()).bottomMargin;
                if(view1 instanceof FloatingActionButton) {
                    if(((BottomAppBar)view0).z0 == 0 && ((BottomAppBar)view0).D0) {
                        M.l(((FloatingActionButton)view1), 0.0f);
                        ((FloatingActionButton)view1).setCompatElevation(0.0f);
                    }
                    if(((FloatingActionButton)view1).getShowMotionSpec() == null) {
                        ((FloatingActionButton)view1).setShowMotionSpecResource(0x7F020021);  // animator:mtrl_fab_show_motion_spec
                    }
                    if(((FloatingActionButton)view1).getHideMotionSpec() == null) {
                        ((FloatingActionButton)view1).setHideMotionSpecResource(0x7F020020);  // animator:mtrl_fab_hide_motion_spec
                    }
                    ((FloatingActionButton)view1).c(((BottomAppBar)view0).O0);
                    ((FloatingActionButton)view1).d(new com.google.android.material.bottomappbar.a(((BottomAppBar)view0), 3));
                    ((FloatingActionButton)view1).e(((BottomAppBar)view0).P0);
                }
                view1.addOnLayoutChangeListener(this.m);
                ((BottomAppBar)view0).I();
            }
            coordinatorLayout0.p(((BottomAppBar)view0), v);
            super.l(coordinatorLayout0, ((BottomAppBar)view0), v);
            return false;
        }

        // 去混淆评级： 低(20)
        @Override  // com.google.android.material.behavior.HideBottomViewOnScrollBehavior
        public final boolean t(CoordinatorLayout coordinatorLayout0, View view0, View view1, View view2, int v, int v1) {
            return ((BottomAppBar)view0).getHideOnScroll() && super.t(coordinatorLayout0, ((BottomAppBar)view0), view1, view2, v, v1);
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator CREATOR;
        public int c;
        public boolean d;

        static {
            SavedState.CREATOR = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public SavedState(Parcel parcel0, ClassLoader classLoader0) {
            super(parcel0, classLoader0);
            this.c = parcel0.readInt();
            this.d = parcel0.readInt() != 0;
        }

        @Override  // androidx.customview.view.AbsSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeInt(this.c);
            parcel0.writeInt(((int)this.d));
        }
    }

    public final int A0;
    public int B0;
    public int C0;
    public final boolean D0;
    public boolean E0;
    public final boolean F0;
    public final boolean G0;
    public final boolean H0;
    public boolean I0;
    public boolean J0;
    public Behavior K0;
    public int L0;
    public int M0;
    public int N0;
    public final com.google.android.material.bottomappbar.a O0;
    public final b P0;
    public static final int Q0;
    public Integer t0;
    public final i u0;
    public AnimatorSet v0;
    public AnimatorSet w0;
    public int x0;
    public int y0;
    public int z0;

    public BottomAppBar(Context context0) {
        this(context0, null);
    }

    public BottomAppBar(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040097);  // attr:bottomAppBarStyle
    }

    public BottomAppBar(Context context0, AttributeSet attributeSet0, int v) {
        super(E6.a.a(context0, attributeSet0, v, 0x7F140481), attributeSet0, v);  // style:Widget.MaterialComponents.BottomAppBar
        i i0 = new i();
        this.u0 = i0;
        this.I0 = false;
        this.J0 = true;
        this.O0 = new com.google.android.material.bottomappbar.a(this, 0);
        this.P0 = new b(this);
        Context context1 = this.getContext();
        TypedArray typedArray0 = B.m(context1, attributeSet0, d6.a.e, v, 0x7F140481, new int[0]);  // style:Widget.MaterialComponents.BottomAppBar
        ColorStateList colorStateList0 = n.r(context1, typedArray0, 1);
        if(typedArray0.hasValue(12)) {
            this.setNavigationIconTint(typedArray0.getColor(12, -1));
        }
        int v1 = typedArray0.getDimensionPixelSize(2, 0);
        float f = (float)typedArray0.getDimensionPixelOffset(7, 0);
        float f1 = (float)typedArray0.getDimensionPixelOffset(8, 0);
        float f2 = (float)typedArray0.getDimensionPixelOffset(9, 0);
        this.x0 = typedArray0.getInt(3, 0);
        this.y0 = typedArray0.getInt(6, 0);
        this.z0 = typedArray0.getInt(5, 1);
        this.D0 = typedArray0.getBoolean(16, true);
        this.C0 = typedArray0.getInt(11, 0);
        this.E0 = typedArray0.getBoolean(10, false);
        this.F0 = typedArray0.getBoolean(13, false);
        this.G0 = typedArray0.getBoolean(14, false);
        this.H0 = typedArray0.getBoolean(15, false);
        this.B0 = typedArray0.getDimensionPixelOffset(4, -1);
        boolean z = typedArray0.getBoolean(0, true);
        typedArray0.recycle();
        this.A0 = this.getResources().getDimensionPixelOffset(0x7F070334);  // dimen:mtrl_bottomappbar_fabOffsetEndMode
        com.google.android.material.bottomappbar.i i1 = new com.google.android.material.bottomappbar.i(0);  // 初始化器: Lz6/f;-><init>(I)V
        i1.g = -1.0f;
        i1.c = f;
        i1.b = f1;
        i1.u(f2);
        i1.f = 0.0f;
        l l0 = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
        l l1 = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
        l l2 = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
        l l3 = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
        z6.a a0 = new z6.a(0.0f);
        z6.a a1 = new z6.a(0.0f);
        z6.a a2 = new z6.a(0.0f);
        z6.a a3 = new z6.a(0.0f);
        f f3 = new f(0);
        f f4 = new f(0);
        f f5 = new f(0);
        o o0 = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
        o0.a = l0;
        o0.b = l1;
        o0.c = l2;
        o0.d = l3;
        o0.e = a0;
        o0.f = a1;
        o0.g = a2;
        o0.h = a3;
        o0.i = i1;
        o0.j = f3;
        o0.k = f4;
        o0.l = f5;
        i0.setShapeAppearanceModel(o0);
        if(z) {
            i0.q(2);
        }
        else {
            i0.q(1);
            if(Build.VERSION.SDK_INT >= 28) {
                androidx.window.layout.util.a.q(this);
                androidx.window.layout.util.a.z(this);
            }
        }
        i0.o();
        i0.k(context1);
        this.setElevation(((float)v1));
        i0.setTintList(colorStateList0);
        this.setBackground(i0);
        b b0 = new b(this);
        TypedArray typedArray1 = this.getContext().obtainStyledAttributes(attributeSet0, d6.a.w, v, 0x7F140481);  // style:Widget.MaterialComponents.BottomAppBar
        boolean z1 = typedArray1.getBoolean(3, false);
        boolean z2 = typedArray1.getBoolean(4, false);
        boolean z3 = typedArray1.getBoolean(5, false);
        typedArray1.recycle();
        B.f(this, new androidx.lifecycle.i(z1, z2, z3, b0));
    }

    public final View C() {
        if(this.getParent() instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout0 = (CoordinatorLayout)this.getParent();
            List list0 = (List)((V)coordinatorLayout0.b.b).get(this);
            ArrayList arrayList0 = coordinatorLayout0.d;
            arrayList0.clear();
            if(list0 != null) {
                arrayList0.addAll(list0);
            }
            for(Object object0: arrayList0) {
                View view0 = (View)object0;
                if(view0 instanceof FloatingActionButton || view0 instanceof ExtendedFloatingActionButton) {
                    return view0;
                }
                if(false) {
                    break;
                }
            }
        }
        return null;
    }

    public final int D(ActionMenuView actionMenuView0, int v, boolean z) {
        int v1 = 0;
        if(this.C0 != 1 && (v != 1 || !z)) {
            return 0;
        }
        boolean z1 = B.l(this);
        int v2 = z1 ? this.getMeasuredWidth() : 0;
        for(int v3 = 0; v3 < this.getChildCount(); ++v3) {
            View view0 = this.getChildAt(v3);
            if(view0.getLayoutParams() instanceof LayoutParams && (((LayoutParams)view0.getLayoutParams()).a & 0x800007) == 0x800003) {
                v2 = z1 ? Math.min(v2, view0.getLeft()) : Math.max(v2, view0.getRight());
            }
        }
        int v4 = z1 ? actionMenuView0.getRight() : actionMenuView0.getLeft();
        int v5 = z1 ? this.M0 : -this.N0;
        if(this.getNavigationIcon() == null) {
            v1 = this.getResources().getDimensionPixelOffset(0x7F070172);  // dimen:m3_bottomappbar_horizontal_padding
            if(!z1) {
                v1 = -v1;
            }
        }
        return v2 - (v4 + v5 + v1);
    }

    public final float E(int v) {
        boolean z = B.l(this);
        int v1 = 1;
        if(v == 1) {
            View view0 = this.C();
            int v2 = z ? this.N0 : this.M0;
            int v3 = this.B0 == -1 || view0 == null ? this.A0 + v2 : view0.getMeasuredWidth() / 2 + this.B0 + v2;
            int v4 = this.getMeasuredWidth();
            if(z) {
                v1 = -1;
            }
            return (float)((v4 / 2 - v3) * v1);
        }
        return 0.0f;
    }

    public final boolean F() {
        View view0 = this.C();
        FloatingActionButton floatingActionButton0 = view0 instanceof FloatingActionButton ? ((FloatingActionButton)view0) : null;
        return floatingActionButton0 != null && floatingActionButton0.i();
    }

    public final void G(int v, boolean z) {
        if(!this.isLaidOut()) {
            this.I0 = false;
            return;
        }
        AnimatorSet animatorSet0 = this.w0;
        if(animatorSet0 != null) {
            animatorSet0.cancel();
        }
        ArrayList arrayList0 = new ArrayList();
        if(!this.F()) {
            v = 0;
            z = false;
        }
        ActionMenuView actionMenuView0 = this.getActionMenuView();
        if(actionMenuView0 != null) {
            float f = (float)this.getFabAlignmentAnimationDuration();
            ObjectAnimator objectAnimator0 = ObjectAnimator.ofFloat(actionMenuView0, "alpha", new float[]{1.0f});
            objectAnimator0.setDuration(((long)(0.8f * f)));
            if(Math.abs(actionMenuView0.getTranslationX() - ((float)this.D(actionMenuView0, v, z))) > 1.0f) {
                ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(actionMenuView0, "alpha", new float[]{0.0f});
                objectAnimator1.setDuration(((long)(f * 0.2f)));
                objectAnimator1.addListener(new e(this, actionMenuView0, v, z));
                AnimatorSet animatorSet1 = new AnimatorSet();
                animatorSet1.playSequentially(new Animator[]{objectAnimator1, objectAnimator0});
                arrayList0.add(animatorSet1);
            }
            else if(actionMenuView0.getAlpha() < 1.0f) {
                arrayList0.add(objectAnimator0);
            }
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(arrayList0);
        this.w0 = animatorSet2;
        animatorSet2.addListener(new com.google.android.material.bottomappbar.a(this, 2));
        this.w0.start();
    }

    public final void H() {
        ActionMenuView actionMenuView0 = this.getActionMenuView();
        if(actionMenuView0 != null && this.w0 == null) {
            actionMenuView0.setAlpha(1.0f);
            if(!this.F()) {
                this.K(actionMenuView0, 0, false, false);
                return;
            }
            this.K(actionMenuView0, this.x0, this.J0, false);
        }
    }

    public final void I() {
        com.google.android.material.bottomappbar.i i0 = this.getTopEdgeTreatment();
        i0.f = this.getFabTranslationX();
        float f = !this.J0 || !this.F() || this.z0 != 1 ? 0.0f : 1.0f;
        this.u0.n(f);
        View view0 = this.C();
        if(view0 != null) {
            view0.setTranslationY(this.getFabTranslationY());
            view0.setTranslationX(this.getFabTranslationX());
        }
    }

    public final void J(int v) {
        if(((float)v) != this.getTopEdgeTreatment().d) {
            this.getTopEdgeTreatment().d = (float)v;
            this.u0.invalidateSelf();
        }
    }

    public final void K(ActionMenuView actionMenuView0, int v, boolean z, boolean z1) {
        com.google.android.material.bottomappbar.f f0 = new com.google.android.material.bottomappbar.f(this, actionMenuView0, v, z);
        if(z1) {
            actionMenuView0.post(f0);
            return;
        }
        f0.run();
    }

    public static void L(BottomAppBar bottomAppBar0, View view0) {
        c c0 = (c)view0.getLayoutParams();
        c0.d = 17;
        int v = bottomAppBar0.z0;
        if(v == 1) {
            c0.d = 49;
        }
        if(v == 0) {
            c0.d |= 80;
        }
    }

    private ActionMenuView getActionMenuView() {
        for(int v = 0; v < this.getChildCount(); ++v) {
            View view0 = this.getChildAt(v);
            if(view0 instanceof ActionMenuView) {
                return (ActionMenuView)view0;
            }
        }
        return null;
    }

    public ColorStateList getBackgroundTint() {
        return this.u0.a.e;
    }

    @Override  // androidx.coordinatorlayout.widget.a
    public androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior getBehavior() {
        return this.getBehavior();
    }

    public Behavior getBehavior() {
        if(this.K0 == null) {
            this.K0 = new Behavior();
        }
        return this.K0;
    }

    private int getBottomInset() {
        return this.L0;
    }

    public float getCradleVerticalOffset() {
        return this.getTopEdgeTreatment().e;
    }

    private int getFabAlignmentAnimationDuration() {
        return n.B(this.getContext(), 0x7F040454, 300);  // attr:motionDurationLong2
    }

    public int getFabAlignmentMode() {
        return this.x0;
    }

    public int getFabAlignmentModeEndMargin() {
        return this.B0;
    }

    public int getFabAnchorMode() {
        return this.z0;
    }

    public int getFabAnimationMode() {
        return this.y0;
    }

    public float getFabCradleMargin() {
        return this.getTopEdgeTreatment().c;
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.getTopEdgeTreatment().b;
    }

    private float getFabTranslationX() {
        return this.E(this.x0);
    }

    private float getFabTranslationY() {
        if(this.z0 == 1) {
            return -this.getTopEdgeTreatment().e;
        }
        View view0 = this.C();
        return view0 == null ? 0.0f : ((float)(-(this.getMeasuredHeight() + this.getBottomInset() - view0.getMeasuredHeight()) / 2));
    }

    public boolean getHideOnScroll() {
        return this.E0;
    }

    private int getLeftInset() {
        return this.N0;
    }

    public int getMenuAlignmentMode() {
        return this.C0;
    }

    private int getRightInset() {
        return this.M0;
    }

    private com.google.android.material.bottomappbar.i getTopEdgeTreatment() {
        return (com.google.android.material.bottomappbar.i)this.u0.a.a.i;
    }

    @Override  // androidx.appcompat.widget.Toolbar
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d5.n.A(this, this.u0);
        if(this.getParent() instanceof ViewGroup) {
            ((ViewGroup)this.getParent()).setClipChildren(false);
        }
    }

    @Override  // androidx.appcompat.widget.Toolbar
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        if(z) {
            AnimatorSet animatorSet0 = this.w0;
            if(animatorSet0 != null) {
                animatorSet0.cancel();
            }
            AnimatorSet animatorSet1 = this.v0;
            if(animatorSet1 != null) {
                animatorSet1.cancel();
            }
            this.I();
            View view0 = this.C();
            if(view0 != null && view0.isLaidOut()) {
                view0.post(new c2.B(view0, 1));
            }
        }
        this.H();
    }

    @Override  // androidx.appcompat.widget.Toolbar
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        super.onRestoreInstanceState(((SavedState)parcelable0).a);
        this.x0 = ((SavedState)parcelable0).c;
        this.J0 = ((SavedState)parcelable0).d;
    }

    @Override  // androidx.appcompat.widget.Toolbar
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroidx/customview/view/AbsSavedState;-><init>(Landroid/os/Parcelable;)V
        parcelable0.c = this.x0;
        parcelable0.d = this.J0;
        return parcelable0;
    }

    public void setBackgroundTint(ColorStateList colorStateList0) {
        this.u0.setTintList(colorStateList0);
    }

    public void setCradleVerticalOffset(float f) {
        if(f != this.getCradleVerticalOffset()) {
            this.getTopEdgeTreatment().u(f);
            this.u0.invalidateSelf();
            this.I();
        }
    }

    @Override  // android.view.View
    public void setElevation(float f) {
        this.u0.l(f);
        int v = this.u0.a.o - this.u0.h();
        Behavior bottomAppBar$Behavior0 = this.getBehavior();
        bottomAppBar$Behavior0.h = v;
        if(bottomAppBar$Behavior0.g == 1) {
            this.setTranslationY(((float)(bottomAppBar$Behavior0.f + v)));
        }
    }

    public void setFabAlignmentMode(int v) {
        this.I0 = true;
        this.G(v, this.J0);
        if(this.x0 != v && this.isLaidOut()) {
            AnimatorSet animatorSet0 = this.v0;
            if(animatorSet0 != null) {
                animatorSet0.cancel();
            }
            ArrayList arrayList0 = new ArrayList();
            FloatingActionButton floatingActionButton0 = null;
            if(this.y0 == 1) {
                View view0 = this.C();
                if(view0 instanceof FloatingActionButton) {
                    floatingActionButton0 = (FloatingActionButton)view0;
                }
                ObjectAnimator objectAnimator0 = ObjectAnimator.ofFloat(floatingActionButton0, "translationX", new float[]{this.E(v)});
                objectAnimator0.setDuration(((long)this.getFabAlignmentAnimationDuration()));
                arrayList0.add(objectAnimator0);
            }
            else {
                View view1 = this.C();
                if(view1 instanceof FloatingActionButton) {
                    floatingActionButton0 = (FloatingActionButton)view1;
                }
                if(floatingActionButton0 != null && !floatingActionButton0.h()) {
                    floatingActionButton0.g(new d(this, v), true);
                }
            }
            AnimatorSet animatorSet1 = new AnimatorSet();
            animatorSet1.playTogether(arrayList0);
            animatorSet1.setInterpolator(n.C(this.getContext(), 0x7F040464, e6.a.a));  // attr:motionEasingEmphasizedInterpolator
            this.v0 = animatorSet1;
            animatorSet1.addListener(new com.google.android.material.bottomappbar.a(this, 1));
            this.v0.start();
        }
        this.x0 = v;
    }

    public void setFabAlignmentModeEndMargin(int v) {
        if(this.B0 != v) {
            this.B0 = v;
            this.I();
        }
    }

    public void setFabAnchorMode(int v) {
        this.z0 = v;
        this.I();
        View view0 = this.C();
        if(view0 != null) {
            BottomAppBar.L(this, view0);
            view0.requestLayout();
            this.u0.invalidateSelf();
        }
    }

    public void setFabAnimationMode(int v) {
        this.y0 = v;
    }

    public void setFabCornerSize(float f) {
        if(f != this.getTopEdgeTreatment().g) {
            this.getTopEdgeTreatment().g = f;
            this.u0.invalidateSelf();
        }
    }

    public void setFabCradleMargin(float f) {
        if(f != this.getFabCradleMargin()) {
            this.getTopEdgeTreatment().c = f;
            this.u0.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        if(f != this.getFabCradleRoundedCornerRadius()) {
            this.getTopEdgeTreatment().b = f;
            this.u0.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z) {
        this.E0 = z;
    }

    public void setMenuAlignmentMode(int v) {
        if(this.C0 != v) {
            this.C0 = v;
            ActionMenuView actionMenuView0 = this.getActionMenuView();
            if(actionMenuView0 != null) {
                this.K(actionMenuView0, this.x0, this.F(), false);
            }
        }
    }

    @Override  // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable0) {
        if(drawable0 != null && this.t0 != null) {
            drawable0 = drawable0.mutate();
            drawable0.setTint(((int)this.t0));
        }
        super.setNavigationIcon(drawable0);
    }

    public void setNavigationIconTint(int v) {
        this.t0 = v;
        Drawable drawable0 = this.getNavigationIcon();
        if(drawable0 != null) {
            this.setNavigationIcon(drawable0);
        }
    }

    @Override  // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence0) {
    }

    @Override  // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence0) {
    }
}

