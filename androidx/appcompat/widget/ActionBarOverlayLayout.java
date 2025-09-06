package androidx.appcompat.widget;

import A6.h;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window.Callback;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.app.P;
import androidx.appcompat.view.menu.MenuBuilder;
import c2.B0;
import c2.K;
import c2.M;
import c2.W;
import c2.m0;
import c2.o0;
import c2.p0;
import c2.q0;
import c2.s;
import c2.t;
import c2.u;
import c2.y0;
import d5.w;
import k.v;

@SuppressLint({"UnknownNullness"})
public class ActionBarOverlayLayout extends ViewGroup implements d0, s, t {
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
        }
    }

    public B0 B;
    public B0 D;
    public B0 E;
    public d G;
    public OverScroller I;
    public ViewPropertyAnimator M;
    public final h N;
    public final c S;
    public final c T;
    public final u V;
    public final e W;
    public int a;
    public int b;
    public static final int[] b0;
    public ContentFrameLayout c;
    public static final B0 c0;
    public ActionBarContainer d;
    public static final Rect d0;
    public e0 e;
    public Drawable f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public final Rect m;
    public final Rect n;
    public final Rect o;
    public final Rect r;
    public B0 w;

    static {
        o0 o00;
        ActionBarOverlayLayout.b0 = new int[]{0x7F040006, 0x1010059};  // attr:actionBarSize
        int v = Build.VERSION.SDK_INT;
        if(v >= 34) {
            o00 = new q0();
        }
        else if(v >= 30) {
            o00 = new p0();
        }
        else if(v >= 29) {
            o00 = new o0();
        }
        else {
            o00 = new m0();
        }
        o00.g(S1.d.c(0, 1, 0, 1));
        ActionBarOverlayLayout.c0 = o00.b();
        ActionBarOverlayLayout.d0 = new Rect();
    }

    public ActionBarOverlayLayout(Context context0) {
        this(context0, null);
    }

    public ActionBarOverlayLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.b = 0;
        this.m = new Rect();
        this.n = new Rect();
        this.o = new Rect();
        this.r = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        this.w = B0.b;
        this.B = B0.b;
        this.D = B0.b;
        this.E = B0.b;
        this.N = new h(this, 5);
        this.S = new c(this, 0);
        this.T = new c(this, 1);
        this.d(context0);
        this.V = new u();  // 初始化器: Ljava/lang/Object;-><init>()V
        e e0 = new e(context0);  // 初始化器: Landroid/view/View;-><init>(Landroid/content/Context;)V
        e0.setWillNotDraw(true);
        this.W = e0;
        this.addView(e0);
    }

    public static boolean a(View view0, Rect rect0, boolean z) {
        boolean z1;
        LayoutParams actionBarOverlayLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        int v = rect0.left;
        if(actionBarOverlayLayout$LayoutParams0.leftMargin == v) {
            z1 = false;
        }
        else {
            actionBarOverlayLayout$LayoutParams0.leftMargin = v;
            z1 = true;
        }
        int v1 = rect0.top;
        if(actionBarOverlayLayout$LayoutParams0.topMargin != v1) {
            actionBarOverlayLayout$LayoutParams0.topMargin = v1;
            z1 = true;
        }
        int v2 = rect0.right;
        if(actionBarOverlayLayout$LayoutParams0.rightMargin != v2) {
            actionBarOverlayLayout$LayoutParams0.rightMargin = v2;
            z1 = true;
        }
        if(z) {
            int v3 = rect0.bottom;
            if(actionBarOverlayLayout$LayoutParams0.bottomMargin != v3) {
                actionBarOverlayLayout$LayoutParams0.bottomMargin = v3;
                return true;
            }
        }
        return z1;
    }

    public final void b() {
        this.g();
        ActionMenuView actionMenuView0 = ((k1)this.e).a.a;
        if(actionMenuView0 != null) {
            ActionMenuPresenter actionMenuPresenter0 = actionMenuView0.E;
            if(actionMenuPresenter0 != null) {
                actionMenuPresenter0.l();
                f f0 = actionMenuPresenter0.G;
                if(f0 != null && f0.b()) {
                    f0.i.dismiss();
                }
            }
        }
    }

    public final void c() {
        this.removeCallbacks(this.S);
        this.removeCallbacks(this.T);
        ViewPropertyAnimator viewPropertyAnimator0 = this.M;
        if(viewPropertyAnimator0 != null) {
            viewPropertyAnimator0.cancel();
        }
    }

    @Override  // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return viewGroup$LayoutParams0 instanceof LayoutParams;
    }

    public final void d(Context context0) {
        TypedArray typedArray0 = this.getContext().getTheme().obtainStyledAttributes(ActionBarOverlayLayout.b0);
        boolean z = false;
        this.a = typedArray0.getDimensionPixelSize(0, 0);
        Drawable drawable0 = typedArray0.getDrawable(1);
        this.f = drawable0;
        if(drawable0 == null) {
            z = true;
        }
        this.setWillNotDraw(z);
        typedArray0.recycle();
        this.I = new OverScroller(context0);
    }

    @Override  // android.view.View
    public final void draw(Canvas canvas0) {
        int v;
        super.draw(canvas0);
        if(this.f != null) {
            if(this.d.getVisibility() == 0) {
                float f = (float)this.d.getBottom();
                v = (int)(this.d.getTranslationY() + f + 0.5f);
            }
            else {
                v = 0;
            }
            this.f.setBounds(0, v, this.getWidth(), this.f.getIntrinsicHeight() + v);
            this.f.draw(canvas0);
        }
    }

    public final void e(int v) {
        this.g();
        switch(v) {
            case 2: {
                ((k1)this.e).getClass();
                Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
                return;
            }
            case 5: {
                ((k1)this.e).getClass();
                Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
                return;
            }
            case 109: {
                this.setOverlayMode(true);
            }
        }
    }

    public final boolean f() {
        this.g();
        ActionMenuView actionMenuView0 = ((k1)this.e).a.a;
        return actionMenuView0 != null && (actionMenuView0.E != null && (actionMenuView0.E.I != null || actionMenuView0.E.m()));
    }

    @Override  // android.view.View
    public final boolean fitSystemWindows(Rect rect0) {
        return super.fitSystemWindows(rect0);
    }

    public final void g() {
        e0 e00;
        if(this.c == null) {
            this.c = (ContentFrameLayout)this.findViewById(0x7F0A0054);  // id:action_bar_activity_content
            this.d = (ActionBarContainer)this.findViewById(0x7F0A0055);  // id:action_bar_container
            View view0 = this.findViewById(0x7F0A0053);  // id:action_bar
            if(view0 instanceof e0) {
                e00 = (e0)view0;
            }
            else if(view0 instanceof Toolbar) {
                e00 = ((Toolbar)view0).getWrapper();
            }
            else {
                throw new IllegalStateException("Can\'t make a decor toolbar out of " + view0.getClass().getSimpleName());
            }
            this.e = e00;
        }
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);  // 初始化器: Landroid/view/ViewGroup$MarginLayoutParams;-><init>(II)V
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return new LayoutParams(this.getContext(), attributeSet0);
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return new LayoutParams(viewGroup$LayoutParams0);  // 初始化器: Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V
    }

    public int getActionBarHideOffset() {
        return this.d == null ? 0 : -((int)this.d.getTranslationY());
    }

    @Override  // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.V.a();
    }

    public CharSequence getTitle() {
        this.g();
        return ((k1)this.e).a.getTitle();
    }

    public final void h(Menu menu0, v v0) {
        this.g();
        k1 k10 = (k1)this.e;
        Toolbar toolbar0 = k10.a;
        if(k10.m == null) {
            ActionMenuPresenter actionMenuPresenter0 = new ActionMenuPresenter(toolbar0.getContext());
            k10.m = actionMenuPresenter0;
            actionMenuPresenter0.i = 0x7F0A0060;  // id:action_menu_presenter
        }
        ActionMenuPresenter actionMenuPresenter1 = k10.m;
        actionMenuPresenter1.e = v0;
        if(((MenuBuilder)menu0) != null || toolbar0.a != null) {
            toolbar0.f();
            MenuBuilder menuBuilder0 = toolbar0.a.r;
            if(menuBuilder0 != ((MenuBuilder)menu0)) {
                if(menuBuilder0 != null) {
                    menuBuilder0.r(toolbar0.k0);
                    menuBuilder0.r(toolbar0.l0);
                }
                if(toolbar0.l0 == null) {
                    toolbar0.l0 = new f1(toolbar0);
                }
                actionMenuPresenter1.B = true;
                if(((MenuBuilder)menu0) == null) {
                    actionMenuPresenter1.k(toolbar0.j, null);
                    toolbar0.l0.k(toolbar0.j, null);
                    actionMenuPresenter1.i(true);
                    toolbar0.l0.i(true);
                }
                else {
                    ((MenuBuilder)menu0).b(actionMenuPresenter1, toolbar0.j);
                    ((MenuBuilder)menu0).b(toolbar0.l0, toolbar0.j);
                }
                toolbar0.a.setPopupTheme(toolbar0.k);
                toolbar0.a.setPresenter(actionMenuPresenter1);
                toolbar0.k0 = actionMenuPresenter1;
                toolbar0.w();
            }
        }
    }

    @Override  // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets0) {
        this.g();
        B0 b00 = B0.h(this, windowInsets0);
        Rect rect0 = new Rect(b00.b(), b00.d(), b00.c(), b00.a());
        boolean z = ActionBarOverlayLayout.a(this.d, rect0, false);
        Rect rect1 = this.m;
        M.b(this, b00, rect1);
        y0 y00 = b00.a;
        B0 b01 = y00.n(rect1.left, rect1.top, rect1.right, rect1.bottom);
        this.w = b01;
        boolean z1 = true;
        if(!this.B.equals(b01)) {
            this.B = this.w;
            z = true;
        }
        Rect rect2 = this.n;
        if(rect2.equals(rect1)) {
            z1 = z;
        }
        else {
            rect2.set(rect1);
        }
        if(z1) {
            this.requestLayout();
        }
        return y00.a().a.c().a.b().g();
    }

    @Override  // android.view.View
    public final void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        this.d(this.getContext());
        K.c(this);
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c();
    }

    @Override  // android.view.ViewGroup
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v4 = this.getChildCount();
        int v5 = this.getPaddingLeft();
        int v6 = this.getPaddingTop();
        for(int v7 = 0; v7 < v4; ++v7) {
            View view0 = this.getChildAt(v7);
            if(view0.getVisibility() != 8) {
                LayoutParams actionBarOverlayLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                int v8 = view0.getMeasuredWidth();
                int v9 = view0.getMeasuredHeight();
                int v10 = actionBarOverlayLayout$LayoutParams0.leftMargin + v5;
                int v11 = actionBarOverlayLayout$LayoutParams0.topMargin + v6;
                view0.layout(v10, v11, v8 + v10, v9 + v11);
            }
        }
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        o0 o00;
        int v5;
        this.g();
        this.measureChildWithMargins(this.d, v, 0, v1, 0);
        LayoutParams actionBarOverlayLayout$LayoutParams0 = (LayoutParams)this.d.getLayoutParams();
        int v2 = Math.max(0, this.d.getMeasuredWidth() + actionBarOverlayLayout$LayoutParams0.leftMargin + actionBarOverlayLayout$LayoutParams0.rightMargin);
        int v3 = Math.max(0, this.d.getMeasuredHeight() + actionBarOverlayLayout$LayoutParams0.topMargin + actionBarOverlayLayout$LayoutParams0.bottomMargin);
        int v4 = View.combineMeasuredStates(0, this.d.getMeasuredState());
        boolean z = (this.getWindowSystemUiVisibility() & 0x100) != 0;
        if(z) {
            v5 = this.a;
            if(this.h && this.d.getTabContainer() != null) {
                v5 += this.a;
            }
        }
        else {
            v5 = this.d.getVisibility() == 8 ? 0 : this.d.getMeasuredHeight();
        }
        Rect rect0 = this.o;
        rect0.set(this.m);
        this.D = this.w;
        if(this.g || z) {
        label_23:
            S1.d d0 = S1.d.c(this.D.b(), this.D.d() + v5, this.D.c(), this.D.a());
            B0 b00 = this.D;
            int v6 = Build.VERSION.SDK_INT;
            if(v6 >= 34) {
                o00 = new q0(b00);
            }
            else if(v6 >= 30) {
                o00 = new p0(b00);
            }
            else if(v6 >= 29) {
                o00 = new o0(b00);
            }
            else {
                o00 = new m0(b00);
            }
            o00.g(d0);
            this.D = o00.b();
        }
        else {
            M.b(this.W, ActionBarOverlayLayout.c0, this.r);
            if(!this.r.equals(ActionBarOverlayLayout.d0)) {
                rect0.top += v5;
                rect0.bottom = rect0.bottom;
                this.D = this.D.a.n(0, v5, 0, 0);
                goto label_38;
            }
            goto label_23;
        }
    label_38:
        ActionBarOverlayLayout.a(this.c, rect0, true);
        if(!this.E.equals(this.D)) {
            this.E = this.D;
            W.b(this.c, this.D);
        }
        this.measureChildWithMargins(this.c, v, 0, v1, 0);
        LayoutParams actionBarOverlayLayout$LayoutParams1 = (LayoutParams)this.c.getLayoutParams();
        int v7 = Math.max(v2, this.c.getMeasuredWidth() + actionBarOverlayLayout$LayoutParams1.leftMargin + actionBarOverlayLayout$LayoutParams1.rightMargin);
        int v8 = Math.max(v3, this.c.getMeasuredHeight() + actionBarOverlayLayout$LayoutParams1.topMargin + actionBarOverlayLayout$LayoutParams1.bottomMargin);
        int v9 = View.combineMeasuredStates(v4, this.c.getMeasuredState());
        int v10 = this.getPaddingLeft();
        int v11 = this.getPaddingRight();
        int v12 = this.getPaddingTop();
        int v13 = Math.max(this.getPaddingBottom() + v12 + v8, this.getSuggestedMinimumHeight());
        this.setMeasuredDimension(View.resolveSizeAndState(Math.max(v11 + v10 + v7, this.getSuggestedMinimumWidth()), v, v9), View.resolveSizeAndState(v13, v1, v9 << 16));
    }

    @Override  // android.view.ViewGroup
    public final boolean onNestedFling(View view0, float f, float f1, boolean z) {
        if(this.i && z) {
            this.I.fling(0, 0, 0, ((int)f1), 0, 0, 0x80000000, 0x7FFFFFFF);
            if(this.I.getFinalY() > this.d.getHeight()) {
                this.c();
                this.T.run();
            }
            else {
                this.c();
                this.S.run();
            }
            this.j = true;
            return true;
        }
        return false;
    }

    @Override  // android.view.ViewGroup
    public final boolean onNestedPreFling(View view0, float f, float f1) {
        return false;
    }

    @Override  // android.view.ViewGroup
    public final void onNestedPreScroll(View view0, int v, int v1, int[] arr_v) {
    }

    @Override  // c2.s
    public final void onNestedPreScroll(View view0, int v, int v1, int[] arr_v, int v2) {
    }

    @Override  // android.view.ViewGroup
    public final void onNestedScroll(View view0, int v, int v1, int v2, int v3) {
        int v4 = this.k + v1;
        this.k = v4;
        this.setActionBarHideOffset(v4);
    }

    @Override  // c2.s
    public final void onNestedScroll(View view0, int v, int v1, int v2, int v3, int v4) {
        if(v4 == 0) {
            this.onNestedScroll(view0, v, v1, v2, v3);
        }
    }

    @Override  // c2.t
    public final void onNestedScroll(View view0, int v, int v1, int v2, int v3, int v4, int[] arr_v) {
        this.onNestedScroll(view0, v, v1, v2, v3, v4);
    }

    @Override  // android.view.ViewGroup
    public final void onNestedScrollAccepted(View view0, View view1, int v) {
        this.V.a = v;
        this.k = this.getActionBarHideOffset();
        this.c();
        d d0 = this.G;
        if(d0 != null) {
            j.h h0 = ((P)d0).t;
            if(h0 != null) {
                h0.a();
                ((P)d0).t = null;
            }
        }
    }

    @Override  // c2.s
    public final void onNestedScrollAccepted(View view0, View view1, int v, int v1) {
        if(v1 == 0) {
            this.onNestedScrollAccepted(view0, view1, v);
        }
    }

    @Override  // android.view.ViewGroup
    public final boolean onStartNestedScroll(View view0, View view1, int v) {
        return (v & 2) == 0 || this.d.getVisibility() != 0 ? false : this.i;
    }

    @Override  // c2.s
    public final boolean onStartNestedScroll(View view0, View view1, int v, int v1) {
        return v1 == 0 && this.onStartNestedScroll(view0, view1, v);
    }

    @Override  // android.view.ViewGroup
    public final void onStopNestedScroll(View view0) {
        if(this.i && !this.j) {
            if(this.k <= this.d.getHeight()) {
                this.c();
                this.postDelayed(this.S, 600L);
                return;
            }
            this.c();
            this.postDelayed(this.T, 600L);
        }
    }

    @Override  // c2.s
    public final void onStopNestedScroll(View view0, int v) {
        if(v == 0) {
            this.onStopNestedScroll(view0);
        }
    }

    @Override  // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int v) {
        super.onWindowSystemUiVisibilityChanged(v);
        this.g();
        int v1 = this.l ^ v;
        this.l = v;
        int v2 = (v & 0x100) == 0 ? 0 : 1;
        d d0 = this.G;
        if(d0 != null) {
            ((P)d0).o = v2 ^ 1;
            if((v & 4) == 0 || v2 == 0) {
                if(((P)d0).q) {
                    ((P)d0).q = false;
                    ((P)d0).x(true);
                }
            }
            else if(!((P)d0).q) {
                ((P)d0).q = true;
                ((P)d0).x(true);
            }
        }
        if((v1 & 0x100) != 0 && this.G != null) {
            K.c(this);
        }
    }

    @Override  // android.view.View
    public final void onWindowVisibilityChanged(int v) {
        super.onWindowVisibilityChanged(v);
        this.b = v;
        d d0 = this.G;
        if(d0 != null) {
            ((P)d0).n = v;
        }
    }

    public void setActionBarHideOffset(int v) {
        this.c();
        int v1 = Math.max(0, Math.min(v, this.d.getHeight()));
        this.d.setTranslationY(((float)(-v1)));
    }

    public void setActionBarVisibilityCallback(d d0) {
        this.G = d0;
        if(this.getWindowToken() != null) {
            ((P)this.G).n = this.b;
            int v = this.l;
            if(v != 0) {
                this.onWindowSystemUiVisibilityChanged(v);
                K.c(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.h = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if(z != this.i) {
            this.i = z;
            if(!z) {
                this.c();
                this.setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int v) {
        this.g();
        k1 k10 = (k1)this.e;
        k10.d = v == 0 ? null : w.B(k10.a.getContext(), v);
        k10.f();
    }

    public void setIcon(Drawable drawable0) {
        this.g();
        ((k1)this.e).d = drawable0;
        ((k1)this.e).f();
    }

    public void setLogo(int v) {
        this.g();
        k1 k10 = (k1)this.e;
        k10.e = v == 0 ? null : w.B(k10.a.getContext(), v);
        k10.f();
    }

    public void setOverlayMode(boolean z) {
        this.g = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int v) {
    }

    @Override  // androidx.appcompat.widget.d0
    public void setWindowCallback(Window.Callback window$Callback0) {
        this.g();
        ((k1)this.e).k = window$Callback0;
    }

    @Override  // androidx.appcompat.widget.d0
    public void setWindowTitle(CharSequence charSequence0) {
        this.g();
        k1 k10 = (k1)this.e;
        if(!k10.g) {
            Toolbar toolbar0 = k10.a;
            k10.h = charSequence0;
            if((k10.b & 8) != 0) {
                toolbar0.setTitle(charSequence0);
                if(k10.g) {
                    W.p(toolbar0.getRootView(), charSequence0);
                }
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}

