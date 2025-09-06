package com.google.android.material.appbar;

import E9.h;
import android.animation.AnimatorInflater;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.collection.V;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.a;
import androidx.customview.view.AbsSavedState;
import c2.B0;
import c2.M;
import c2.W;
import c2.b0;
import c2.q;
import com.google.android.material.internal.B;
import d5.l;
import d5.w;
import e1.m;
import e1.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import z6.i;

public class AppBarLayout extends LinearLayout implements a {
    public static class BaseBehavior extends HeaderBehavior {
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator CREATOR;
            public boolean c;
            public boolean d;
            public int e;
            public float f;
            public boolean g;

            static {
                SavedState.CREATOR = new d();  // 初始化器: Ljava/lang/Object;-><init>()V
            }

            public SavedState(Parcel parcel0, ClassLoader classLoader0) {
                super(parcel0, classLoader0);
                boolean z = false;
                this.c = parcel0.readByte() != 0;
                this.d = parcel0.readByte() != 0;
                this.e = parcel0.readInt();
                this.f = parcel0.readFloat();
                if(parcel0.readByte() != 0) {
                    z = true;
                }
                this.g = z;
            }

            @Override  // androidx.customview.view.AbsSavedState
            public final void writeToParcel(Parcel parcel0, int v) {
                super.writeToParcel(parcel0, v);
                parcel0.writeByte(((byte)this.c));
                parcel0.writeByte(((byte)this.d));
                parcel0.writeInt(this.e);
                parcel0.writeFloat(this.f);
                parcel0.writeByte(((byte)this.g));
            }
        }

        public int j;
        public int k;
        public ValueAnimator l;
        public SavedState m;
        public WeakReference n;

        public BaseBehavior() {
            this.f = -1;
            this.h = -1;
        }

        public BaseBehavior(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
        }

        @Override  // com.google.android.material.appbar.HeaderBehavior
        public final boolean A(View view0) {
            AppBarLayout appBarLayout0 = (AppBarLayout)view0;
            WeakReference weakReference0 = this.n;
            if(weakReference0 != null) {
                View view1 = (View)weakReference0.get();
                return view1 != null && view1.isShown() && !view1.canScrollVertically(-1);
            }
            return true;
        }

        @Override  // com.google.android.material.appbar.HeaderBehavior
        public final int B(View view0) {
            int v = ((AppBarLayout)view0).getDownNestedScrollRange();
            return ((AppBarLayout)view0).getTopInset() - v;
        }

        @Override  // com.google.android.material.appbar.HeaderBehavior
        public final int C(View view0) {
            return ((AppBarLayout)view0).getTotalScrollRange();
        }

        @Override  // com.google.android.material.appbar.HeaderBehavior
        public final void D(CoordinatorLayout coordinatorLayout0, View view0) {
            this.L(coordinatorLayout0, ((AppBarLayout)view0));
            if(((AppBarLayout)view0).l) {
                ((AppBarLayout)view0).f(((AppBarLayout)view0).g(BaseBehavior.I(coordinatorLayout0)));
            }
        }

        @Override  // com.google.android.material.appbar.HeaderBehavior
        public final int E(CoordinatorLayout coordinatorLayout0, View view0, int v, int v1, int v2) {
            int v12;
            int v10;
            int v3 = this.x();
            int v4 = 0;
            if(v1 == 0 || v3 < v1 || v3 > v2) {
                this.j = 0;
            }
            else {
                int v5 = h.r(v, v1, v2);
                if(v3 != v5) {
                    if(((AppBarLayout)view0).e) {
                        int v6 = Math.abs(v5);
                        int v7 = ((AppBarLayout)view0).getChildCount();
                        int v8 = 0;
                        while(v8 < v7) {
                            View view1 = ((AppBarLayout)view0).getChildAt(v8);
                            LayoutParams appBarLayout$LayoutParams0 = (LayoutParams)view1.getLayoutParams();
                            Interpolator interpolator0 = appBarLayout$LayoutParams0.c;
                            if(v6 >= view1.getTop() && v6 <= view1.getBottom()) {
                                if(interpolator0 == null) {
                                    break;
                                }
                                int v9 = appBarLayout$LayoutParams0.a;
                                if((v9 & 1) == 0) {
                                    v10 = 0;
                                }
                                else {
                                    v10 = view1.getHeight() + appBarLayout$LayoutParams0.topMargin + appBarLayout$LayoutParams0.bottomMargin;
                                    if((v9 & 2) != 0) {
                                        v10 -= view1.getMinimumHeight();
                                    }
                                }
                                if(view1.getFitsSystemWindows()) {
                                    v10 -= ((AppBarLayout)view0).getTopInset();
                                }
                                if(v10 <= 0) {
                                    break;
                                }
                                int v11 = Math.round(interpolator0.getInterpolation(((float)(v6 - view1.getTop())) / ((float)v10)) * ((float)v10));
                                v12 = (view1.getTop() + v11) * Integer.signum(v5);
                                goto label_31;
                            }
                            ++v8;
                        }
                    }
                    v12 = v5;
                label_31:
                    boolean z = this.z(v12);
                    this.j = v5 - v12;
                    if(z) {
                        for(int v13 = 0; v13 < ((AppBarLayout)view0).getChildCount(); ++v13) {
                            LayoutParams appBarLayout$LayoutParams1 = (LayoutParams)((AppBarLayout)view0).getChildAt(v13).getLayoutParams();
                            l l0 = appBarLayout$LayoutParams1.b;
                            if(l0 != null && (appBarLayout$LayoutParams1.a & 1) != 0) {
                                View view2 = ((AppBarLayout)view0).getChildAt(v13);
                                float f = (float)this.w();
                                Rect rect0 = (Rect)l0.c;
                                Rect rect1 = (Rect)l0.b;
                                view2.getDrawingRect(rect1);
                                ((AppBarLayout)view0).offsetDescendantRectToMyCoords(view2, rect1);
                                rect1.offset(0, -((AppBarLayout)view0).getTopInset());
                                float f1 = ((float)rect1.top) - Math.abs(f);
                                if(f1 <= 0.0f) {
                                    float f2 = h.q(Math.abs(f1 / ((float)rect1.height())), 0.0f, 1.0f);
                                    float f3 = -f1 - ((float)rect1.height()) * 0.3f * (1.0f - (1.0f - f2) * (1.0f - f2));
                                    view2.setTranslationY(f3);
                                    view2.getDrawingRect(rect0);
                                    rect0.offset(0, ((int)(-f3)));
                                    if(f3 >= ((float)rect0.height())) {
                                        view2.setVisibility(4);
                                    }
                                    else {
                                        view2.setVisibility(0);
                                    }
                                    view2.setClipBounds(rect0);
                                }
                                else {
                                    view2.setClipBounds(null);
                                    view2.setTranslationY(0.0f);
                                    view2.setVisibility(0);
                                }
                            }
                        }
                    }
                    if(!z && ((AppBarLayout)view0).e) {
                        coordinatorLayout0.g(((AppBarLayout)view0));
                    }
                    ((AppBarLayout)view0).d(this.w());
                    BaseBehavior.M(coordinatorLayout0, ((AppBarLayout)view0), v5, (v5 >= v3 ? 1 : -1), false);
                    v4 = v3 - v5;
                }
            }
            if(W.d(coordinatorLayout0) != null) {
                return v4;
            }
            W.o(coordinatorLayout0, new c(coordinatorLayout0, this, ((AppBarLayout)view0)));
            return v4;
        }

        public static View G(BaseBehavior appBarLayout$BaseBehavior0, CoordinatorLayout coordinatorLayout0) {
            int v = coordinatorLayout0.getChildCount();
            for(int v1 = 0; v1 < v; ++v1) {
                View view0 = coordinatorLayout0.getChildAt(v1);
                if(((androidx.coordinatorlayout.widget.c)view0.getLayoutParams()).a instanceof ScrollingViewBehavior) {
                    return view0;
                }
            }
            return null;
        }

        public final void H(CoordinatorLayout coordinatorLayout0, AppBarLayout appBarLayout0, int v) {
            int v1 = (int)((((float)Math.abs(this.x() - v)) / ((float)appBarLayout0.getHeight()) + 1.0f) * 150.0f);
            int v2 = this.x();
            if(v2 == v) {
                if(this.l != null && this.l.isRunning()) {
                    this.l.cancel();
                }
                return;
            }
            ValueAnimator valueAnimator0 = this.l;
            if(valueAnimator0 == null) {
                ValueAnimator valueAnimator1 = new ValueAnimator();
                this.l = valueAnimator1;
                valueAnimator1.setInterpolator(e6.a.e);
                this.l.addUpdateListener(new b(coordinatorLayout0, this, appBarLayout0));
            }
            else {
                valueAnimator0.cancel();
            }
            this.l.setDuration(((long)Math.min(v1, 600)));
            this.l.setIntValues(new int[]{v2, v});
            this.l.start();
        }

        public static View I(CoordinatorLayout coordinatorLayout0) {
            int v = coordinatorLayout0.getChildCount();
            int v1 = 0;
            while(v1 < v) {
                View view0 = coordinatorLayout0.getChildAt(v1);
                if(!(view0 instanceof q) && !(view0 instanceof AbsListView) && !(view0 instanceof ScrollView)) {
                    ++v1;
                    continue;
                }
                return view0;
            }
            return null;
        }

        public final void J(CoordinatorLayout coordinatorLayout0, AppBarLayout appBarLayout0, View view0, int v, int[] arr_v) {
            int v2;
            int v1;
            if(v != 0) {
                if(v < 0) {
                    v1 = -appBarLayout0.getTotalScrollRange();
                    v2 = appBarLayout0.getDownNestedPreScrollRange() + v1;
                }
                else {
                    v1 = -appBarLayout0.getUpNestedPreScrollRange();
                    v2 = 0;
                }
                if(v1 != v2) {
                    arr_v[1] = this.E(coordinatorLayout0, appBarLayout0, this.x() - v, v1, v2);
                }
            }
            if(appBarLayout0.l) {
                appBarLayout0.f(appBarLayout0.g(view0));
            }
        }

        public final SavedState K(Parcelable parcelable0, AppBarLayout appBarLayout0) {
            int v = this.w();
            int v1 = appBarLayout0.getChildCount();
            boolean z = false;
            for(int v2 = 0; v2 < v1; ++v2) {
                View view0 = appBarLayout0.getChildAt(v2);
                int v3 = view0.getBottom() + v;
                if(view0.getTop() + v <= 0 && v3 >= 0) {
                    if(parcelable0 == null) {
                        parcelable0 = AbsSavedState.b;
                    }
                    SavedState appBarLayout$BaseBehavior$SavedState0 = new SavedState(parcelable0);  // 初始化器: Landroidx/customview/view/AbsSavedState;-><init>(Landroid/os/Parcelable;)V
                    appBarLayout$BaseBehavior$SavedState0.d = v == 0;
                    appBarLayout$BaseBehavior$SavedState0.c = v != 0 && -v >= appBarLayout0.getTotalScrollRange();
                    appBarLayout$BaseBehavior$SavedState0.e = v2;
                    int v4 = view0.getMinimumHeight();
                    if(v3 == appBarLayout0.getTopInset() + v4) {
                        z = true;
                    }
                    appBarLayout$BaseBehavior$SavedState0.g = z;
                    appBarLayout$BaseBehavior$SavedState0.f = ((float)v3) / ((float)view0.getHeight());
                    return appBarLayout$BaseBehavior$SavedState0;
                }
            }
            return null;
        }

        public final void L(CoordinatorLayout coordinatorLayout0, AppBarLayout appBarLayout0) {
            int v = appBarLayout0.getTopInset();
            int v1 = appBarLayout0.getPaddingTop() + v;
            int v2 = this.x() - v1;
            int v3 = appBarLayout0.getChildCount();
            int v4;
            for(v4 = 0; true; ++v4) {
                if(v4 >= v3) {
                    v4 = -1;
                    break;
                }
                View view0 = appBarLayout0.getChildAt(v4);
                int v5 = view0.getTop();
                int v6 = view0.getBottom();
                LayoutParams appBarLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                if((appBarLayout$LayoutParams0.a & 0x20) == 0x20) {
                    v5 -= appBarLayout$LayoutParams0.topMargin;
                    v6 += appBarLayout$LayoutParams0.bottomMargin;
                }
                if(v5 <= -v2 && v6 >= -v2) {
                    break;
                }
            }
            if(v4 >= 0) {
                View view1 = appBarLayout0.getChildAt(v4);
                LayoutParams appBarLayout$LayoutParams1 = (LayoutParams)view1.getLayoutParams();
                int v7 = appBarLayout$LayoutParams1.a;
                if((v7 & 17) == 17) {
                    int v8 = -view1.getTop();
                    int v9 = -view1.getBottom();
                    if(v4 == 0 && appBarLayout0.getFitsSystemWindows() && view1.getFitsSystemWindows()) {
                        v8 -= appBarLayout0.getTopInset();
                    }
                    if((v7 & 2) == 2) {
                        v9 += view1.getMinimumHeight();
                    }
                    else if((v7 & 5) == 5) {
                        int v10 = view1.getMinimumHeight() + v9;
                        if(v2 < v10) {
                            v8 = v10;
                        }
                        else {
                            v9 = v10;
                        }
                    }
                    if((v7 & 0x20) == 0x20) {
                        v8 += appBarLayout$LayoutParams1.topMargin;
                        v9 -= appBarLayout$LayoutParams1.bottomMargin;
                    }
                    if(v2 < (v9 + v8) / 2) {
                        v8 = v9;
                    }
                    this.H(coordinatorLayout0, appBarLayout0, h.r(v8 + v1, -appBarLayout0.getTotalScrollRange(), 0));
                }
            }
        }

        public static void M(CoordinatorLayout coordinatorLayout0, AppBarLayout appBarLayout0, int v, int v1, boolean z) {
            boolean z1;
            View view0;
            int v2 = Math.abs(v);
            int v3 = appBarLayout0.getChildCount();
            int v4 = 0;
            for(int v5 = 0; true; ++v5) {
                view0 = null;
                if(v5 >= v3) {
                    break;
                }
                View view1 = appBarLayout0.getChildAt(v5);
                if(v2 >= view1.getTop() && v2 <= view1.getBottom()) {
                    view0 = view1;
                    break;
                }
            }
            if(view0 == null) {
                z1 = false;
            }
            else {
                int v6 = ((LayoutParams)view0.getLayoutParams()).a;
                if((v6 & 1) == 0) {
                    z1 = false;
                }
                else {
                    int v7 = view0.getMinimumHeight();
                    z1 = true;
                    if(v1 <= 0 || (v6 & 12) == 0) {
                        if((v6 & 2) == 0 || -v < view0.getBottom() - v7 - appBarLayout0.getTopInset()) {
                            z1 = false;
                        }
                    }
                    else if(-v < view0.getBottom() - v7 - appBarLayout0.getTopInset()) {
                        z1 = false;
                    }
                }
            }
            if(appBarLayout0.l) {
                z1 = appBarLayout0.g(BaseBehavior.I(coordinatorLayout0));
            }
            boolean z2 = appBarLayout0.f(z1);
            if(z) {
            label_47:
                if(appBarLayout0.getBackground() != null) {
                    appBarLayout0.getBackground().jumpToCurrentState();
                }
                if(appBarLayout0.getForeground() != null) {
                    appBarLayout0.getForeground().jumpToCurrentState();
                }
                if(appBarLayout0.getStateListAnimator() != null) {
                    appBarLayout0.getStateListAnimator().jumpToCurrentState();
                }
            }
            else if(z2) {
                List list0 = (List)((V)coordinatorLayout0.b.b).get(appBarLayout0);
                ArrayList arrayList0 = coordinatorLayout0.d;
                arrayList0.clear();
                if(list0 != null) {
                    arrayList0.addAll(list0);
                }
                int v8 = arrayList0.size();
                while(v4 < v8) {
                    Behavior coordinatorLayout$Behavior0 = ((androidx.coordinatorlayout.widget.c)((View)arrayList0.get(v4)).getLayoutParams()).a;
                    if(coordinatorLayout$Behavior0 instanceof ScrollingViewBehavior) {
                        if(((ScrollingViewBehavior)coordinatorLayout$Behavior0).f == 0) {
                            return;
                        }
                        goto label_47;
                    }
                    ++v4;
                }
            }
        }

        @Override  // com.google.android.material.appbar.ViewOffsetBehavior
        public final boolean l(CoordinatorLayout coordinatorLayout0, View view0, int v) {
            int v4;
            super.l(coordinatorLayout0, ((AppBarLayout)view0), v);
            int v1 = ((AppBarLayout)view0).getPendingAction();
            SavedState appBarLayout$BaseBehavior$SavedState0 = this.m;
            if(appBarLayout$BaseBehavior$SavedState0 == null || (v1 & 8) != 0) {
                if(v1 != 0) {
                    boolean z = (v1 & 4) != 0;
                    if((v1 & 2) != 0) {
                        int v5 = ((AppBarLayout)view0).getUpNestedPreScrollRange();
                        if(z) {
                            this.H(coordinatorLayout0, ((AppBarLayout)view0), -v5);
                        }
                        else {
                            this.F(coordinatorLayout0, ((AppBarLayout)view0), -v5);
                        }
                    }
                    else if((v1 & 1) != 0) {
                        if(z) {
                            this.H(coordinatorLayout0, ((AppBarLayout)view0), 0);
                        }
                        else {
                            this.F(coordinatorLayout0, ((AppBarLayout)view0), 0);
                        }
                    }
                }
            }
            else if(appBarLayout$BaseBehavior$SavedState0.c) {
                this.F(coordinatorLayout0, ((AppBarLayout)view0), -((AppBarLayout)view0).getTotalScrollRange());
            }
            else if(appBarLayout$BaseBehavior$SavedState0.d) {
                this.F(coordinatorLayout0, ((AppBarLayout)view0), 0);
            }
            else {
                View view1 = ((AppBarLayout)view0).getChildAt(appBarLayout$BaseBehavior$SavedState0.e);
                int v2 = view1.getBottom();
                if(this.m.g) {
                    int v3 = view1.getMinimumHeight();
                    v4 = ((AppBarLayout)view0).getTopInset() + v3 - v2;
                }
                else {
                    v4 = Math.round(((float)view1.getHeight()) * this.m.f) - v2;
                }
                this.F(coordinatorLayout0, ((AppBarLayout)view0), v4);
            }
            ((AppBarLayout)view0).f = 0;
            this.m = null;
            this.z(h.r(this.w(), -((AppBarLayout)view0).getTotalScrollRange(), 0));
            BaseBehavior.M(coordinatorLayout0, ((AppBarLayout)view0), this.w(), 0, true);
            ((AppBarLayout)view0).d(this.w());
            if(W.d(coordinatorLayout0) != null) {
                return true;
            }
            W.o(coordinatorLayout0, new c(coordinatorLayout0, this, ((AppBarLayout)view0)));
            return true;
        }

        @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
        public final boolean m(CoordinatorLayout coordinatorLayout0, View view0, int v, int v1, int v2) {
            if(((androidx.coordinatorlayout.widget.c)((AppBarLayout)view0).getLayoutParams()).height == -2) {
                coordinatorLayout0.q(((AppBarLayout)view0), v, v1, 0);
                return true;
            }
            return false;
        }

        @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
        public final void o(CoordinatorLayout coordinatorLayout0, View view0, View view1, int v, int v1, int[] arr_v, int v2) {
            this.J(coordinatorLayout0, ((AppBarLayout)view0), view1, v1, arr_v);
        }

        @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
        public final void p(CoordinatorLayout coordinatorLayout0, View view0, int v, int v1, int v2, int[] arr_v) {
            if(v2 < 0) {
                arr_v[1] = this.E(coordinatorLayout0, ((AppBarLayout)view0), this.x() - v2, -((AppBarLayout)view0).getDownNestedScrollRange(), 0);
            }
            if(v2 == 0 && W.d(coordinatorLayout0) == null) {
                W.o(coordinatorLayout0, new c(coordinatorLayout0, this, ((AppBarLayout)view0)));
            }
        }

        @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
        public final void r(View view0, Parcelable parcelable0) {
            AppBarLayout appBarLayout0 = (AppBarLayout)view0;
            if(parcelable0 instanceof SavedState) {
                this.m = (SavedState)parcelable0;
                return;
            }
            this.m = null;
        }

        @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
        public final Parcelable s(View view0) {
            Parcelable parcelable0 = View.BaseSavedState.EMPTY_STATE;
            Parcelable parcelable1 = this.K(parcelable0, ((AppBarLayout)view0));
            return parcelable1 == null ? parcelable0 : parcelable1;
        }

        @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
        public final boolean t(CoordinatorLayout coordinatorLayout0, View view0, View view1, View view2, int v, int v1) {
            boolean z = (v & 2) != 0 && (((AppBarLayout)view0).l || ((AppBarLayout)view0).getTotalScrollRange() != 0 && coordinatorLayout0.getHeight() - view1.getHeight() <= ((AppBarLayout)view0).getHeight());
            if(z) {
                ValueAnimator valueAnimator0 = this.l;
                if(valueAnimator0 != null) {
                    valueAnimator0.cancel();
                }
            }
            this.n = null;
            this.k = v1;
            return z;
        }

        @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
        public final void u(CoordinatorLayout coordinatorLayout0, View view0, View view1, int v) {
            if(this.k == 0 || v == 1) {
                this.L(coordinatorLayout0, ((AppBarLayout)view0));
                if(((AppBarLayout)view0).l) {
                    ((AppBarLayout)view0).f(((AppBarLayout)view0).g(view1));
                }
            }
            this.n = new WeakReference(view1);
        }

        @Override  // com.google.android.material.appbar.ViewOffsetBehavior
        public final int x() {
            return this.w() + this.j;
        }
    }

    public static class com.google.android.material.appbar.AppBarLayout.Behavior extends BaseBehavior {
        public com.google.android.material.appbar.AppBarLayout.Behavior() {
        }

        public com.google.android.material.appbar.AppBarLayout.Behavior(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
        }
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public int a;
        public final l b;
        public final Interpolator c;

        public LayoutParams(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
            this.a = 1;
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, d6.a.b);
            this.a = typedArray0.getInt(1, 0);
            this.b = typedArray0.getInt(0, 0) == 1 ? new l(7) : null;
            if(typedArray0.hasValue(2)) {
                this.c = AnimationUtils.loadInterpolator(context0, typedArray0.getResourceId(2, 0));
            }
            typedArray0.recycle();
        }
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, d6.a.U);
            this.f = typedArray0.getDimensionPixelSize(0, 0);
            typedArray0.recycle();
        }

        @Override  // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public final AppBarLayout A(ArrayList arrayList0) {
            int v = arrayList0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                View view0 = (View)arrayList0.get(v1);
                if(view0 instanceof AppBarLayout) {
                    return (AppBarLayout)view0;
                }
            }
            return null;
        }

        @Override  // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public final float B(View view0) {
            if(view0 instanceof AppBarLayout) {
                int v = ((AppBarLayout)view0).getTotalScrollRange();
                int v1 = ((AppBarLayout)view0).getDownNestedPreScrollRange();
                Behavior coordinatorLayout$Behavior0 = ((androidx.coordinatorlayout.widget.c)((AppBarLayout)view0).getLayoutParams()).a;
                int v2 = coordinatorLayout$Behavior0 instanceof BaseBehavior ? ((BaseBehavior)coordinatorLayout$Behavior0).x() : 0;
                if(v1 != 0 && v + v2 <= v1) {
                    return 0.0f;
                }
                int v3 = v - v1;
                return v3 == 0 ? 0.0f : ((float)v2) / ((float)v3) + 1.0f;
            }
            return 0.0f;
        }

        // 去混淆评级： 低(20)
        @Override  // com.google.android.material.appbar.HeaderScrollingViewBehavior
        public final int C(View view0) {
            return view0 instanceof AppBarLayout ? ((AppBarLayout)view0).getTotalScrollRange() : view0.getMeasuredHeight();
        }

        @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
        public final boolean f(View view0, View view1) {
            return view1 instanceof AppBarLayout;
        }

        @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
        public boolean h(CoordinatorLayout coordinatorLayout0, View view0, View view1) {
            Behavior coordinatorLayout$Behavior0 = ((androidx.coordinatorlayout.widget.c)view1.getLayoutParams()).a;
            if(coordinatorLayout$Behavior0 instanceof BaseBehavior) {
                view0.offsetTopAndBottom(view1.getBottom() - view0.getTop() + ((BaseBehavior)coordinatorLayout$Behavior0).j + this.e - (this.f == 0 ? 0 : h.r(((int)(this.B(view1) * ((float)this.f))), 0, this.f)));
            }
            if(view1 instanceof AppBarLayout && ((AppBarLayout)view1).l) {
                ((AppBarLayout)view1).f(((AppBarLayout)view1).g(view0));
            }
            return false;
        }

        @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
        public final void i(CoordinatorLayout coordinatorLayout0, View view0) {
            if(view0 instanceof AppBarLayout) {
                W.o(coordinatorLayout0, null);
            }
        }

        @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
        public final boolean q(CoordinatorLayout coordinatorLayout0, View view0, Rect rect0, boolean z) {
            AppBarLayout appBarLayout0;
            ArrayList arrayList0 = coordinatorLayout0.i(view0);
            int v = arrayList0.size();
            for(int v1 = 0; true; ++v1) {
                appBarLayout0 = null;
                if(v1 >= v) {
                    break;
                }
                View view1 = (View)arrayList0.get(v1);
                if(view1 instanceof AppBarLayout) {
                    appBarLayout0 = (AppBarLayout)view1;
                    break;
                }
            }
            if(appBarLayout0 != null) {
                Rect rect1 = new Rect(rect0);
                rect1.offset(view0.getLeft(), view0.getTop());
                int v2 = coordinatorLayout0.getWidth();
                int v3 = coordinatorLayout0.getHeight();
                this.c.set(0, 0, v2, v3);
                if(!this.c.contains(rect1)) {
                    appBarLayout0.e(false, !z, true);
                    return true;
                }
            }
            return false;
        }
    }

    public final ArrayList B;
    public final long D;
    public final TimeInterpolator E;
    public int[] G;
    public Drawable I;
    public Integer M;
    public final float N;
    public com.google.android.material.appbar.AppBarLayout.Behavior S;
    public static final int T;
    public int a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public int f;
    public B0 g;
    public ArrayList h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public WeakReference n;
    public final boolean o;
    public ValueAnimator r;
    public final ValueAnimator.AnimatorUpdateListener w;

    public AppBarLayout(Context context0) {
        this(context0, null);
    }

    public AppBarLayout(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F04004A);  // attr:appBarLayoutStyle
    }

    public AppBarLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(E6.a.a(context0, attributeSet0, v, 0x7F1403BD), attributeSet0, v);  // style:Widget.Design.AppBarLayout
        Throwable throwable1;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.f = 0;
        this.B = new ArrayList();
        Context context1 = this.getContext();
        this.setOrientation(1);
        if(this.getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            this.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
        Context context2 = this.getContext();
        TypedArray typedArray0 = B.m(context2, attributeSet0, j.a, v, 0x7F1403BD, new int[0]);  // style:Widget.Design.AppBarLayout
        try {
            if(typedArray0.hasValue(0)) {
                goto label_17;
            }
            goto label_23;
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
            typedArray0.recycle();
            throw throwable1;
        }
        try {
        label_17:
            this.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context2, typedArray0.getResourceId(0, 0)));
        }
        catch(Throwable throwable2) {
            throwable1 = throwable2;
            typedArray0.recycle();
            throw throwable1;
        }
    label_23:
        typedArray0.recycle();
        TypedArray typedArray1 = B.m(context1, attributeSet0, d6.a.a, v, 0x7F1403BD, new int[0]);  // style:Widget.Design.AppBarLayout
        this.setBackground(typedArray1.getDrawable(0));
        ColorStateList colorStateList0 = n.r(context1, typedArray1, 6);
        this.o = colorStateList0 != null;
        ColorStateList colorStateList1 = e2.a.F(this.getBackground());
        if(colorStateList1 != null) {
            i i0 = new i();
            i0.m(colorStateList1);
            if(colorStateList0 == null) {
                i0.k(context1);
                this.w = new b0(1, this, i0);
            }
            else {
                Context context3 = this.getContext();
                TypedValue typedValue0 = m.y(context3, 0x7F040190);  // attr:colorSurface
                this.w = new com.google.android.material.appbar.a(this, colorStateList1, colorStateList0, i0, (typedValue0 == null ? null : ((int)(typedValue0.resourceId == 0 ? typedValue0.data : P1.c.getColor(context3, typedValue0.resourceId)))));
            }
            this.setBackground(i0);
        }
        this.D = (long)n.B(context1, 0x7F040458, this.getResources().getInteger(0x7F0B0002));  // attr:motionDurationMedium2
        this.E = n.C(context1, 0x7F04046A, e6.a.a);  // attr:motionEasingStandardInterpolator
        if(typedArray1.hasValue(4)) {
            this.e(typedArray1.getBoolean(4, false), false, false);
        }
        if(typedArray1.hasValue(3)) {
            j.a(this, ((float)typedArray1.getDimensionPixelSize(3, 0)));
        }
        if(typedArray1.hasValue(2)) {
            this.setKeyboardNavigationCluster(typedArray1.getBoolean(2, false));
        }
        if(typedArray1.hasValue(1)) {
            this.setTouchscreenBlocksFocus(typedArray1.getBoolean(1, false));
        }
        this.N = this.getResources().getDimension(0x7F0700B3);  // dimen:design_appbar_elevation
        this.l = typedArray1.getBoolean(5, false);
        this.m = typedArray1.getResourceId(7, -1);
        this.setStatusBarForeground(typedArray1.getDrawable(8));
        typedArray1.recycle();
        M.n(this, new androidx.lifecycle.b(this, 16));
    }

    public final void a(e e0) {
        if(this.h == null) {
            this.h = new ArrayList();
        }
        if(e0 != null && !this.h.contains(e0)) {
            this.h.add(e0);
        }
    }

    public static LayoutParams b(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(viewGroup$LayoutParams0 instanceof LinearLayout.LayoutParams) {
            LayoutParams appBarLayout$LayoutParams0 = new LayoutParams(((LinearLayout.LayoutParams)viewGroup$LayoutParams0));  // 初始化器: Landroid/widget/LinearLayout$LayoutParams;-><init>(Landroid/widget/LinearLayout$LayoutParams;)V
            appBarLayout$LayoutParams0.a = 1;
            return appBarLayout$LayoutParams0;
        }
        if(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams) {
            LayoutParams appBarLayout$LayoutParams1 = new LayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0));  // 初始化器: Landroid/widget/LinearLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V
            appBarLayout$LayoutParams1.a = 1;
            return appBarLayout$LayoutParams1;
        }
        LayoutParams appBarLayout$LayoutParams2 = new LayoutParams(viewGroup$LayoutParams0);  // 初始化器: Landroid/widget/LinearLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V
        appBarLayout$LayoutParams2.a = 1;
        return appBarLayout$LayoutParams2;
    }

    public final void c() {
        SavedState appBarLayout$BaseBehavior$SavedState0 = this.S == null || this.b == -1 || this.f != 0 ? null : this.S.K(AbsSavedState.b, this);
        this.b = -1;
        this.c = -1;
        this.d = -1;
        if(appBarLayout$BaseBehavior$SavedState0 != null) {
            com.google.android.material.appbar.AppBarLayout.Behavior appBarLayout$Behavior0 = this.S;
            if(appBarLayout$Behavior0.m == null) {
                appBarLayout$Behavior0.m = appBarLayout$BaseBehavior$SavedState0;
            }
        }
    }

    @Override  // android.widget.LinearLayout
    public final boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return viewGroup$LayoutParams0 instanceof LayoutParams;
    }

    public final void d(int v) {
        this.a = v;
        if(!this.willNotDraw()) {
            this.postInvalidateOnAnimation();
        }
        ArrayList arrayList0 = this.h;
        if(arrayList0 != null) {
            int v1 = arrayList0.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                e e0 = (e)this.h.get(v2);
                if(e0 != null) {
                    e0.onOffsetChanged(this, v);
                }
            }
        }
    }

    @Override  // android.view.View
    public final void draw(Canvas canvas0) {
        super.draw(canvas0);
        if(this.I != null && this.getTopInset() > 0) {
            int v = canvas0.save();
            canvas0.translate(0.0f, ((float)(-this.a)));
            this.I.draw(canvas0);
            canvas0.restoreToCount(v);
        }
    }

    @Override  // android.view.ViewGroup
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] arr_v = this.getDrawableState();
        Drawable drawable0 = this.I;
        if(drawable0 != null && drawable0.isStateful() && drawable0.setState(arr_v)) {
            this.invalidateDrawable(drawable0);
        }
    }

    // 去混淆评级： 低(20)
    public final void e(boolean z, boolean z1, boolean z2) {
        this.f = (z ? 1 : 2) | (z1 ? 4 : 0) | (z2 ? 8 : 0);
        this.requestLayout();
    }

    public final boolean f(boolean z) {
        if(!this.i && this.k != z) {
            float f = 0.0f;
            this.k = z;
            this.refreshDrawableState();
            if(this.getBackground() instanceof i) {
                if(this.o) {
                    if(z) {
                        f = 1.0f;
                    }
                    this.h((z ? 0.0f : 1.0f), f);
                    return true;
                }
                if(this.l) {
                    float f1 = this.N;
                    if(z) {
                        f = f1;
                    }
                    this.h((z ? 0.0f : f1), f);
                }
            }
            return true;
        }
        return false;
    }

    public final boolean g(View view0) {
        View view1 = null;
        if(this.n == null) {
            int v = this.m;
            if(v != -1) {
                View view2 = view0 == null ? null : view0.findViewById(v);
                if(view2 == null && this.getParent() instanceof ViewGroup) {
                    view2 = ((ViewGroup)this.getParent()).findViewById(this.m);
                }
                if(view2 != null) {
                    this.n = new WeakReference(view2);
                }
            }
        }
        WeakReference weakReference0 = this.n;
        if(weakReference0 != null) {
            view1 = (View)weakReference0.get();
        }
        if(view1 != null) {
            view0 = view1;
        }
        return view0 != null && (view0.canScrollVertically(-1) || view0.getScrollY() > 0);
    }

    @Override  // android.widget.LinearLayout
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = new LayoutParams(-1, -2);  // 初始化器: Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V
        viewGroup$LayoutParams0.a = 1;
        return viewGroup$LayoutParams0;
    }

    @Override  // android.widget.LinearLayout
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        LinearLayout.LayoutParams linearLayout$LayoutParams0 = new LayoutParams(-1, -2);  // 初始化器: Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V
        linearLayout$LayoutParams0.a = 1;
        return linearLayout$LayoutParams0;
    }

    @Override  // android.widget.LinearLayout
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return new LayoutParams(this.getContext(), attributeSet0);
    }

    @Override  // android.widget.LinearLayout
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return AppBarLayout.b(viewGroup$LayoutParams0);
    }

    @Override  // android.widget.LinearLayout
    public final LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return new LayoutParams(this.getContext(), attributeSet0);
    }

    @Override  // android.widget.LinearLayout
    public final LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return AppBarLayout.b(viewGroup$LayoutParams0);
    }

    @Override  // androidx.coordinatorlayout.widget.a
    public Behavior getBehavior() {
        com.google.android.material.appbar.AppBarLayout.Behavior appBarLayout$Behavior0 = new com.google.android.material.appbar.AppBarLayout.Behavior();
        this.S = appBarLayout$Behavior0;
        return appBarLayout$Behavior0;
    }

    public int getDownNestedPreScrollRange() {
        int v6;
        int v = this.c;
        if(v != -1) {
            return v;
        }
        int v1 = this.getChildCount() - 1;
        int v2 = 0;
        while(v1 >= 0) {
            View view0 = this.getChildAt(v1);
            if(view0.getVisibility() != 8) {
                LayoutParams appBarLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                int v3 = view0.getMeasuredHeight();
                int v4 = appBarLayout$LayoutParams0.a;
                if((v4 & 5) == 5) {
                    int v5 = appBarLayout$LayoutParams0.topMargin + appBarLayout$LayoutParams0.bottomMargin;
                    if((v4 & 8) == 0) {
                        v6 = (v4 & 2) == 0 ? v5 + v3 : v3 - view0.getMinimumHeight() + v5;
                    }
                    else {
                        v6 = view0.getMinimumHeight() + v5;
                    }
                    if(v1 == 0 && view0.getFitsSystemWindows()) {
                        v6 = Math.min(v6, v3 - this.getTopInset());
                    }
                    v2 += v6;
                }
                else {
                    if(v2 <= 0) {
                        goto label_22;
                    }
                    break;
                }
            }
        label_22:
            --v1;
        }
        int v7 = Math.max(0, v2);
        this.c = v7;
        return v7;
    }

    public int getDownNestedScrollRange() {
        int v = this.d;
        if(v != -1) {
            return v;
        }
        int v1 = this.getChildCount();
        int v3 = 0;
        for(int v2 = 0; v2 < v1; ++v2) {
            View view0 = this.getChildAt(v2);
            if(view0.getVisibility() != 8) {
                LayoutParams appBarLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                int v4 = view0.getMeasuredHeight();
                int v5 = appBarLayout$LayoutParams0.topMargin + appBarLayout$LayoutParams0.bottomMargin + v4;
                int v6 = appBarLayout$LayoutParams0.a;
                if((v6 & 1) == 0) {
                    break;
                }
                v3 += v5;
                if((v6 & 2) != 0) {
                    v3 -= view0.getMinimumHeight();
                    break;
                }
            }
        }
        int v7 = Math.max(0, v3);
        this.d = v7;
        return v7;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.m;
    }

    public i getMaterialShapeBackground() {
        Drawable drawable0 = this.getBackground();
        return drawable0 instanceof i ? ((i)drawable0) : null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int v = this.getTopInset();
        int v1 = this.getMinimumHeight();
        if(v1 != 0) {
            return v1 * 2 + v;
        }
        int v2 = this.getChildCount();
        v1 = v2 < 1 ? 0 : this.getChildAt(v2 - 1).getMinimumHeight();
        return v1 == 0 ? this.getHeight() / 3 : v1 * 2 + v;
    }

    public int getPendingAction() {
        return this.f;
    }

    public Drawable getStatusBarForeground() {
        return this.I;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        return this.g == null ? 0 : this.g.d();
    }

    public final int getTotalScrollRange() {
        int v = this.b;
        if(v != -1) {
            return v;
        }
        int v1 = this.getChildCount();
        int v3 = 0;
        for(int v2 = 0; v2 < v1; ++v2) {
            View view0 = this.getChildAt(v2);
            if(view0.getVisibility() != 8) {
                LayoutParams appBarLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                int v4 = view0.getMeasuredHeight();
                int v5 = appBarLayout$LayoutParams0.a;
                if((v5 & 1) == 0) {
                    break;
                }
                int v6 = v4 + appBarLayout$LayoutParams0.topMargin + appBarLayout$LayoutParams0.bottomMargin + v3;
                v3 = v2 != 0 || !view0.getFitsSystemWindows() ? v4 + appBarLayout$LayoutParams0.topMargin + appBarLayout$LayoutParams0.bottomMargin + v3 : v6 - this.getTopInset();
                if((v5 & 2) != 0) {
                    v3 -= view0.getMinimumHeight();
                    break;
                }
            }
        }
        int v7 = Math.max(0, v3);
        this.b = v7;
        return v7;
    }

    public int getUpNestedPreScrollRange() {
        return this.getTotalScrollRange();
    }

    public final void h(float f, float f1) {
        ValueAnimator valueAnimator0 = this.r;
        if(valueAnimator0 != null) {
            valueAnimator0.cancel();
        }
        ValueAnimator valueAnimator1 = ValueAnimator.ofFloat(new float[]{f, f1});
        this.r = valueAnimator1;
        valueAnimator1.setDuration(this.D);
        this.r.setInterpolator(this.E);
        ValueAnimator.AnimatorUpdateListener valueAnimator$AnimatorUpdateListener0 = this.w;
        if(valueAnimator$AnimatorUpdateListener0 != null) {
            this.r.addUpdateListener(valueAnimator$AnimatorUpdateListener0);
        }
        this.r.start();
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d5.n.B(this);
    }

    @Override  // android.view.ViewGroup
    public final int[] onCreateDrawableState(int v) {
        if(this.G == null) {
            this.G = new int[4];
        }
        int[] arr_v = this.G;
        int[] arr_v1 = super.onCreateDrawableState(v + arr_v.length);
        boolean z = this.j;
        arr_v[0] = z ? 0x7F0405A1 : 0x80FBFA5F;  // attr:state_liftable
        arr_v[1] = !z || !this.k ? 0x80FBFA5E : 0x7F0405A2;  // attr:state_lifted
        arr_v[2] = z ? 0x7F04059D : 0x80FBFA63;  // attr:state_collapsible
        arr_v[3] = !z || !this.k ? 0x80FBFA64 : 0x7F04059C;  // attr:state_collapsed
        return View.mergeDrawableStates(arr_v1, arr_v);
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference weakReference0 = this.n;
        if(weakReference0 != null) {
            weakReference0.clear();
        }
        this.n = null;
    }

    @Override  // android.widget.LinearLayout
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        boolean z1 = true;
        if(this.getFitsSystemWindows() && this.getChildCount() > 0) {
            View view0 = this.getChildAt(0);
            if(view0.getVisibility() != 8 && !view0.getFitsSystemWindows()) {
                int v4 = this.getTopInset();
                for(int v5 = this.getChildCount() - 1; v5 >= 0; --v5) {
                    this.getChildAt(v5).offsetTopAndBottom(v4);
                }
            }
        }
        this.c();
        this.e = false;
        int v6 = this.getChildCount();
        for(int v7 = 0; v7 < v6; ++v7) {
            if(((LayoutParams)this.getChildAt(v7).getLayoutParams()).c != null) {
                this.e = true;
                break;
            }
        }
        Drawable drawable0 = this.I;
        if(drawable0 != null) {
            drawable0.setBounds(0, 0, this.getWidth(), this.getTopInset());
        }
        if(!this.i) {
            if(!this.l) {
                int v8 = this.getChildCount();
                for(int v9 = 0; true; ++v9) {
                    if(v9 >= v8) {
                        z1 = false;
                        break;
                    }
                    int v10 = ((LayoutParams)this.getChildAt(v9).getLayoutParams()).a;
                    if((v10 & 1) == 1 && (v10 & 10) != 0) {
                        break;
                    }
                }
            }
            if(this.j != z1) {
                this.j = z1;
                this.refreshDrawableState();
            }
        }
    }

    @Override  // android.widget.LinearLayout
    public final void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        int v2 = View.MeasureSpec.getMode(v1);
        if(v2 != 0x40000000 && this.getFitsSystemWindows() && this.getChildCount() > 0) {
            View view0 = this.getChildAt(0);
            if(view0.getVisibility() != 8 && !view0.getFitsSystemWindows()) {
                int v3 = this.getMeasuredHeight();
                switch(v2) {
                    case 0x80000000: {
                        int v4 = this.getMeasuredHeight();
                        v3 = h.r(this.getTopInset() + v4, 0, View.MeasureSpec.getSize(v1));
                        break;
                    }
                    case 0: {
                        v3 += this.getTopInset();
                    }
                }
                this.setMeasuredDimension(this.getMeasuredWidth(), v3);
            }
        }
        this.c();
    }

    @Override  // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        d5.n.z(this, f);
    }

    public void setExpanded(boolean z) {
        this.e(z, this.isLaidOut(), true);
    }

    public void setLiftOnScroll(boolean z) {
        this.l = z;
    }

    public void setLiftOnScrollTargetView(View view0) {
        this.m = -1;
        if(view0 == null) {
            WeakReference weakReference0 = this.n;
            if(weakReference0 != null) {
                weakReference0.clear();
            }
            this.n = null;
            return;
        }
        this.n = new WeakReference(view0);
    }

    public void setLiftOnScrollTargetViewId(int v) {
        this.m = v;
        WeakReference weakReference0 = this.n;
        if(weakReference0 != null) {
            weakReference0.clear();
        }
        this.n = null;
    }

    public void setLiftableOverrideEnabled(boolean z) {
        this.i = z;
    }

    @Override  // android.widget.LinearLayout
    public void setOrientation(int v) {
        if(v != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(1);
    }

    public void setStatusBarForeground(Drawable drawable0) {
        Integer integer0 = null;
        Drawable drawable1 = this.I;
        if(drawable1 != drawable0) {
            if(drawable1 != null) {
                drawable1.setCallback(null);
            }
            Drawable drawable2 = drawable0 == null ? null : drawable0.mutate();
            this.I = drawable2;
            if(drawable2 instanceof i) {
                integer0 = ((i)drawable2).G;
            }
            else {
                ColorStateList colorStateList0 = e2.a.F(drawable2);
                if(colorStateList0 != null) {
                    integer0 = colorStateList0.getDefaultColor();
                }
            }
            this.M = integer0;
            Drawable drawable3 = this.I;
            int v = 0;
            if(drawable3 != null) {
                if(drawable3.isStateful()) {
                    this.I.setState(this.getDrawableState());
                }
                this.I.setLayoutDirection(this.getLayoutDirection());
                this.I.setVisible(this.getVisibility() == 0, false);
                this.I.setCallback(this);
            }
            if(this.I != null && this.getTopInset() > 0) {
                v = 1;
            }
            this.setWillNotDraw(((boolean)(v ^ 1)));
            this.postInvalidateOnAnimation();
        }
    }

    public void setStatusBarForegroundColor(int v) {
        this.setStatusBarForeground(new ColorDrawable(v));
    }

    public void setStatusBarForegroundResource(int v) {
        this.setStatusBarForeground(w.B(this.getContext(), v));
    }

    @Deprecated
    public void setTargetElevation(float f) {
        j.a(this, f);
    }

    @Override  // android.view.View
    public void setVisibility(int v) {
        super.setVisibility(v);
        Drawable drawable0 = this.I;
        if(drawable0 != null) {
            drawable0.setVisible(v == 0, false);
        }
    }

    @Override  // android.view.View
    public final boolean verifyDrawable(Drawable drawable0) {
        return super.verifyDrawable(drawable0) || drawable0 == this.I;
    }
}

