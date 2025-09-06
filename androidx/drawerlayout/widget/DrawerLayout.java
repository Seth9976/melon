package androidx.drawerlayout.widget;

import S1.d;
import U4.x;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.core.widget.f;
import androidx.customview.view.AbsSavedState;
import c2.B0;
import c2.M;
import c2.W;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigation.l;
import j2.c;
import java.util.ArrayList;
import java.util.Objects;
import pc.t;
import t2.b;

public class DrawerLayout extends ViewGroup {
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int a;
        public float b;
        public boolean c;
        public int d;

        public LayoutParams(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
            this.a = 0;
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, DrawerLayout.d0);
            this.a = typedArray0.getInt(0, 0);
            typedArray0.recycle();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator CREATOR;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;

        static {
            SavedState.CREATOR = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public SavedState(Parcel parcel0, ClassLoader classLoader0) {
            super(parcel0, classLoader0);
            this.c = parcel0.readInt();
            this.d = parcel0.readInt();
            this.e = parcel0.readInt();
            this.f = parcel0.readInt();
            this.g = parcel0.readInt();
        }

        @Override  // androidx.customview.view.AbsSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeInt(this.c);
            parcel0.writeInt(this.d);
            parcel0.writeInt(this.e);
            parcel0.writeInt(this.f);
            parcel0.writeInt(this.g);
        }
    }

    public boolean B;
    public b D;
    public ArrayList E;
    public float G;
    public float I;
    public Drawable M;
    public WindowInsets N;
    public boolean S;
    public final ArrayList T;
    public Rect V;
    public Matrix W;
    public final f a;
    public float b;
    public final t b0;
    public final int c;
    public static final int[] c0;
    public int d;
    public static final int[] d0;
    public float e;
    public static final boolean e0;
    public final Paint f;
    public static final boolean f0;
    public final c g;
    public static final boolean g0;
    public final c h;
    public final androidx.drawerlayout.widget.b i;
    public final androidx.drawerlayout.widget.b j;
    public int k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public int r;
    public int w;

    static {
        DrawerLayout.c0 = new int[]{0x1010434};
        DrawerLayout.d0 = new int[]{0x10100B3};
        boolean z = true;
        DrawerLayout.e0 = true;
        DrawerLayout.f0 = true;
        if(Build.VERSION.SDK_INT < 29) {
            z = false;
        }
        DrawerLayout.g0 = z;
    }

    public DrawerLayout(Context context0) {
        this(context0, null);
    }

    public DrawerLayout(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040227);  // attr:drawerLayoutStyle
    }

    public DrawerLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = new f(4);
        this.d = 0x99000000;
        this.f = new Paint();
        this.m = true;
        this.n = 3;
        this.o = 3;
        this.r = 3;
        this.w = 3;
        this.b0 = new t(this, 14);
        this.setDescendantFocusability(0x40000);
        DisplayMetrics displayMetrics0 = this.getResources().getDisplayMetrics();
        this.c = (int)(64.0f * displayMetrics0.density + 0.5f);
        float f = displayMetrics0.density * 400.0f;
        androidx.drawerlayout.widget.b b0 = new androidx.drawerlayout.widget.b(this, 3);
        this.i = b0;
        androidx.drawerlayout.widget.b b1 = new androidx.drawerlayout.widget.b(this, 5);
        this.j = b1;
        c c0 = new c(this.getContext(), this, b0);
        c0.b = (int)(((float)c0.b) * 1.0f);
        this.g = c0;
        c0.q = 1;
        c0.n = f;
        b0.g = c0;
        c c1 = new c(this.getContext(), this, b1);
        c1.b = (int)(1.0f * ((float)c1.b));
        this.h = c1;
        c1.q = 2;
        c1.n = f;
        b1.g = c1;
        this.setFocusableInTouchMode(true);
        this.setImportantForAccessibility(1);
        W.o(this, new androidx.slidingpanelayout.widget.a(this));
        this.setMotionEventSplittingEnabled(false);
        if(this.getFitsSystemWindows()) {
            this.setOnApplyWindowInsetsListener(new t2.a());  // 初始化器: Ljava/lang/Object;-><init>()V
            this.setSystemUiVisibility(0x500);
            TypedArray typedArray0 = context0.obtainStyledAttributes(DrawerLayout.c0);
            try {
                this.M = typedArray0.getDrawable(0);
            }
            finally {
                typedArray0.recycle();
            }
        }
        TypedArray typedArray1 = context0.obtainStyledAttributes(attributeSet0, s2.a.a, v, 0);
        try {
            this.b = typedArray1.hasValue(0) ? typedArray1.getDimension(0, 0.0f) : this.getResources().getDimension(0x7F0700AE);  // dimen:def_drawer_elevation
        }
        finally {
            typedArray1.recycle();
        }
        this.T = new ArrayList();
    }

    public final boolean a(View view0, int v) {
        return (this.g(view0) & v) == v;
    }

    @Override  // android.view.ViewGroup
    public final void addFocusables(ArrayList arrayList0, int v, int v1) {
        ArrayList arrayList1;
        if(this.getDescendantFocusability() == 0x60000) {
            return;
        }
        int v2 = this.getChildCount();
        boolean z = false;
        for(int v4 = 0; true; ++v4) {
            arrayList1 = this.T;
            if(v4 >= v2) {
                break;
            }
            View view0 = this.getChildAt(v4);
            if(!DrawerLayout.k(view0)) {
                arrayList1.add(view0);
            }
            else if(DrawerLayout.j(view0)) {
                view0.addFocusables(arrayList0, v, v1);
                z = true;
            }
        }
        if(!z) {
            int v5 = arrayList1.size();
            for(int v3 = 0; v3 < v5; ++v3) {
                View view1 = (View)arrayList1.get(v3);
                if(view1.getVisibility() == 0) {
                    view1.addFocusables(arrayList0, v, v1);
                }
            }
        }
        arrayList1.clear();
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        super.addView(view0, v, viewGroup$LayoutParams0);
        int v1 = this.getChildCount();
        for(int v2 = 0; true; ++v2) {
            View view1 = null;
            if(v2 >= v1) {
                break;
            }
            View view2 = this.getChildAt(v2);
            if((((LayoutParams)view2.getLayoutParams()).d & 1) == 1) {
                view1 = view2;
                break;
            }
        }
        if(view1 != null || DrawerLayout.k(view0)) {
            view0.setImportantForAccessibility(4);
        }
        else {
            view0.setImportantForAccessibility(1);
        }
        if(!DrawerLayout.e0) {
            W.o(view0, this.a);
        }
    }

    public final void b(View view0, boolean z) {
        if(!DrawerLayout.k(view0)) {
            throw new IllegalArgumentException("View " + view0 + " is not a sliding drawer");
        }
        LayoutParams drawerLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        if(this.m) {
            drawerLayout$LayoutParams0.b = 0.0f;
            drawerLayout$LayoutParams0.d = 0;
        }
        else if(z) {
            drawerLayout$LayoutParams0.d |= 4;
            if(this.a(view0, 3)) {
                int v = view0.getWidth();
                int v1 = view0.getTop();
                this.g.u(view0, -v, v1);
            }
            else {
                int v2 = this.getWidth();
                int v3 = view0.getTop();
                this.h.u(view0, v2, v3);
            }
        }
        else {
            float f = ((LayoutParams)view0.getLayoutParams()).b;
            float f1 = (float)view0.getWidth();
            view0.offsetLeftAndRight((this.a(view0, 3) ? ((int)(f1 * 0.0f)) - ((int)(f * f1)) : -(((int)(f1 * 0.0f)) - ((int)(f * f1)))));
            this.n(view0, 0.0f);
            this.q(view0, 0);
            view0.setVisibility(4);
        }
        this.invalidate();
    }

    public final void c(boolean z) {
        boolean z2;
        int v = this.getChildCount();
        boolean z1 = false;
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = this.getChildAt(v1);
            LayoutParams drawerLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
            if(DrawerLayout.k(view0) && (!z || drawerLayout$LayoutParams0.c)) {
                int v2 = view0.getWidth();
                if(this.a(view0, 3)) {
                    int v3 = view0.getTop();
                    z2 = this.g.u(view0, -v2, v3);
                }
                else {
                    int v4 = this.getWidth();
                    int v5 = view0.getTop();
                    z2 = this.h.u(view0, v4, v5);
                }
                z1 |= z2;
                drawerLayout$LayoutParams0.c = false;
            }
        }
        this.i.i.removeCallbacks(this.i.h);
        this.j.i.removeCallbacks(this.j.h);
        if(z1) {
            this.invalidate();
        }
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return viewGroup$LayoutParams0 instanceof LayoutParams && super.checkLayoutParams(viewGroup$LayoutParams0);
    }

    @Override  // android.view.View
    public final void computeScroll() {
        int v = this.getChildCount();
        float f = 0.0f;
        for(int v1 = 0; v1 < v; ++v1) {
            f = Math.max(f, ((LayoutParams)this.getChildAt(v1).getLayoutParams()).b);
        }
        this.e = f;
        if(!this.g.h() && !this.h.h()) {
            return;
        }
        this.postInvalidateOnAnimation();
    }

    public final View d(int v) {
        int v1 = Gravity.getAbsoluteGravity(v, this.getLayoutDirection());
        int v2 = this.getChildCount();
        for(int v3 = 0; v3 < v2; ++v3) {
            View view0 = this.getChildAt(v3);
            if((this.g(view0) & 7) == (v1 & 7)) {
                return view0;
            }
        }
        return null;
    }

    @Override  // android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent0) {
        boolean z;
        if((motionEvent0.getSource() & 2) != 0 && motionEvent0.getAction() != 10 && this.e > 0.0f) {
            int v = this.getChildCount();
            if(v != 0) {
                float f = motionEvent0.getX();
                float f1 = motionEvent0.getY();
                for(int v1 = v - 1; v1 >= 0; --v1) {
                    View view0 = this.getChildAt(v1);
                    if(this.V == null) {
                        this.V = new Rect();
                    }
                    view0.getHitRect(this.V);
                    if(this.V.contains(((int)f), ((int)f1)) && !DrawerLayout.i(view0)) {
                        if(view0.getMatrix().isIdentity()) {
                            float f2 = (float)(this.getScrollX() - view0.getLeft());
                            float f3 = (float)(this.getScrollY() - view0.getTop());
                            motionEvent0.offsetLocation(f2, f3);
                            z = view0.dispatchGenericMotionEvent(motionEvent0);
                            motionEvent0.offsetLocation(-f2, -f3);
                        }
                        else {
                            int v2 = this.getScrollX();
                            int v3 = view0.getLeft();
                            int v4 = this.getScrollY();
                            int v5 = view0.getTop();
                            MotionEvent motionEvent1 = MotionEvent.obtain(motionEvent0);
                            motionEvent1.offsetLocation(((float)(v2 - v3)), ((float)(v4 - v5)));
                            Matrix matrix0 = view0.getMatrix();
                            if(!matrix0.isIdentity()) {
                                if(this.W == null) {
                                    this.W = new Matrix();
                                }
                                matrix0.invert(this.W);
                                motionEvent1.transform(this.W);
                            }
                            z = view0.dispatchGenericMotionEvent(motionEvent1);
                            motionEvent1.recycle();
                        }
                        if(z) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return super.dispatchGenericMotionEvent(motionEvent0);
    }

    @Override  // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas0, View view0, long v) {
        int v1 = this.getHeight();
        boolean z = DrawerLayout.i(view0);
        int v2 = this.getWidth();
        int v3 = canvas0.save();
        int v4 = 0;
        if(z) {
            int v5 = this.getChildCount();
            int v7 = 0;
            for(int v6 = 0; v6 < v5; ++v6) {
                View view1 = this.getChildAt(v6);
                if(view1 != view0 && view1.getVisibility() == 0) {
                    Drawable drawable0 = view1.getBackground();
                    if(drawable0 != null && drawable0.getOpacity() == -1 && DrawerLayout.k(view1) && view1.getHeight() >= v1) {
                        if(this.a(view1, 3)) {
                            int v8 = view1.getRight();
                            if(v8 > v7) {
                                v7 = v8;
                            }
                        }
                        else {
                            int v9 = view1.getLeft();
                            if(v9 < v2) {
                                v2 = v9;
                            }
                        }
                    }
                }
            }
            canvas0.clipRect(v7, 0, v2, this.getHeight());
            v4 = v7;
        }
        boolean z1 = super.drawChild(canvas0, view0, v);
        canvas0.restoreToCount(v3);
        float f = this.e;
        if(f > 0.0f && z) {
            this.f.setColor(((int)(((float)((0xFF000000 & this.d) >>> 24)) * f)) << 24 | this.d & 0xFFFFFF);
            canvas0.drawRect(((float)v4), 0.0f, ((float)v2), ((float)this.getHeight()), this.f);
        }
        return z1;
    }

    public final View e() {
        int v = this.getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = this.getChildAt(v1);
            if(DrawerLayout.k(view0)) {
                if(!DrawerLayout.k(view0)) {
                    throw new IllegalArgumentException("View " + view0 + " is not a drawer");
                }
                if(((LayoutParams)view0.getLayoutParams()).b > 0.0f) {
                    return view0;
                }
            }
        }
        return null;
    }

    public final int f(View view0) {
        if(DrawerLayout.k(view0)) {
            int v = ((LayoutParams)view0.getLayoutParams()).a;
            int v1 = this.getLayoutDirection();
            switch(v) {
                case 3: {
                    int v2 = this.n;
                    if(v2 != 3) {
                        return v2;
                    }
                    int v3 = v1 == 0 ? this.r : this.w;
                    return v3 == 3 ? 0 : v3;
                }
                case 5: {
                    int v4 = this.o;
                    if(v4 != 3) {
                        return v4;
                    }
                    int v5 = v1 == 0 ? this.w : this.r;
                    return v5 == 3 ? 0 : v5;
                }
                case 0x800003: {
                    int v6 = this.r;
                    if(v6 != 3) {
                        return v6;
                    }
                    int v7 = v1 == 0 ? this.n : this.o;
                    return v7 == 3 ? 0 : v7;
                }
                case 0x800005: {
                    int v8 = this.w;
                    if(v8 != 3) {
                        return v8;
                    }
                    int v9 = v1 == 0 ? this.o : this.n;
                    return v9 == 3 ? 0 : v9;
                }
                default: {
                    return 0;
                }
            }
        }
        throw new IllegalArgumentException("View " + view0 + " is not a drawer");
    }

    public final int g(View view0) {
        return Gravity.getAbsoluteGravity(((LayoutParams)view0.getLayoutParams()).a, this.getLayoutDirection());
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = new LayoutParams(-1, -1);  // 初始化器: Landroid/view/ViewGroup$MarginLayoutParams;-><init>(II)V
        viewGroup$LayoutParams0.a = 0;
        return viewGroup$LayoutParams0;
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return new LayoutParams(this.getContext(), attributeSet0);
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(viewGroup$LayoutParams0 instanceof LayoutParams) {
            ViewGroup.LayoutParams viewGroup$LayoutParams1 = new LayoutParams(((LayoutParams)viewGroup$LayoutParams0));  // 初始化器: Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V
            viewGroup$LayoutParams1.a = ((LayoutParams)viewGroup$LayoutParams0).a;
            return viewGroup$LayoutParams1;
        }
        if(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.LayoutParams viewGroup$LayoutParams2 = new LayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0));  // 初始化器: Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V
            viewGroup$LayoutParams2.a = 0;
            return viewGroup$LayoutParams2;
        }
        ViewGroup.LayoutParams viewGroup$LayoutParams3 = new LayoutParams(viewGroup$LayoutParams0);  // 初始化器: Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V
        viewGroup$LayoutParams3.a = 0;
        return viewGroup$LayoutParams3;
    }

    // 去混淆评级： 低(20)
    public float getDrawerElevation() {
        return DrawerLayout.f0 ? this.b : 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.M;
    }

    public static boolean h(View view0) {
        switch(view0.getImportantForAccessibility()) {
            case 2: 
            case 4: {
                return false;
            }
            default: {
                return true;
            }
        }
    }

    public static boolean i(View view0) {
        return ((LayoutParams)view0.getLayoutParams()).a == 0;
    }

    public static boolean j(View view0) {
        if(!DrawerLayout.k(view0)) {
            throw new IllegalArgumentException("View " + view0 + " is not a drawer");
        }
        return (((LayoutParams)view0.getLayoutParams()).d & 1) == 1;
    }

    public static boolean k(View view0) {
        int v = Gravity.getAbsoluteGravity(((LayoutParams)view0.getLayoutParams()).a, view0.getLayoutDirection());
        return (v & 3) != 0 || (v & 5) != 0;
    }

    public final void l(View view0) {
        if(!DrawerLayout.k(view0)) {
            throw new IllegalArgumentException("View " + view0 + " is not a sliding drawer");
        }
        LayoutParams drawerLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        if(this.m) {
            drawerLayout$LayoutParams0.b = 1.0f;
            drawerLayout$LayoutParams0.d = 1;
            this.p(view0, true);
            this.o(view0);
        }
        else {
            drawerLayout$LayoutParams0.d |= 2;
            if(this.a(view0, 3)) {
                int v = view0.getTop();
                this.g.u(view0, 0, v);
            }
            else {
                int v1 = this.getWidth();
                int v2 = view0.getWidth();
                int v3 = view0.getTop();
                this.h.u(view0, v1 - v2, v3);
            }
        }
        this.invalidate();
    }

    public final void m(int v, int v1) {
        int v2 = Gravity.getAbsoluteGravity(v1, this.getLayoutDirection());
        switch(v1) {
            case 3: {
                this.n = v;
                break;
            }
            case 5: {
                this.o = v;
                break;
            }
            case 0x800003: {
                this.r = v;
                break;
            }
            case 0x800005: {
                this.w = v;
            }
        }
        if(v != 0) {
            (v2 == 3 ? this.g : this.h).b();
        }
        switch(v) {
            case 1: {
                View view0 = this.d(v2);
                if(view0 != null) {
                    this.b(view0, true);
                    return;
                }
                break;
            }
            case 2: {
                View view1 = this.d(v2);
                if(view1 != null) {
                    this.l(view1);
                    return;
                }
                break;
            }
        }
    }

    public final void n(View view0, float f) {
        LayoutParams drawerLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        if(f != drawerLayout$LayoutParams0.b) {
            drawerLayout$LayoutParams0.b = f;
            ArrayList arrayList0 = this.E;
            if(arrayList0 != null) {
                for(int v = arrayList0.size() - 1; v >= 0; --v) {
                    ((b)this.E.get(v)).getClass();
                }
            }
        }
    }

    public final void o(View view0) {
        d2.c c0 = d2.c.n;
        W.l(view0, c0.a());
        W.i(view0, 0);
        if(DrawerLayout.j(view0) && this.f(view0) != 2) {
            W.m(view0, c0, null, this.b0);
        }
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.m = true;
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.m = true;
    }

    @Override  // android.view.View
    public final void onDraw(Canvas canvas0) {
        super.onDraw(canvas0);
        if(this.S && this.M != null) {
            int v = this.N == null ? 0 : this.N.getSystemWindowInsetTop();
            if(v > 0) {
                this.M.setBounds(0, 0, this.getWidth(), v);
                this.M.draw(canvas0);
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent0) {
        boolean z2;
        int v = motionEvent0.getActionMasked();
        c c0 = this.g;
        boolean z = c0.t(motionEvent0);
        boolean z1 = this.h.t(motionEvent0);
        switch(v) {
            case 0: {
                float f = motionEvent0.getX();
                float f1 = motionEvent0.getY();
                this.G = f;
                this.I = f1;
                if(this.e > 0.0f) {
                    View view0 = c0.i(((int)f), ((int)f1));
                    z2 = view0 == null || !DrawerLayout.i(view0) ? false : true;
                }
                else {
                    z2 = false;
                }
                this.B = false;
                break;
            }
            case 2: {
                for(int v1 = 0; v1 < c0.d.length; ++v1) {
                    if((c0.k & 1 << v1) != 0) {
                        float f2 = c0.f[v1] - c0.d[v1];
                        float f3 = c0.g[v1] - c0.e[v1];
                        if(f3 * f3 + f2 * f2 > ((float)(c0.b * c0.b))) {
                            this.i.i.removeCallbacks(this.i.h);
                            this.j.i.removeCallbacks(this.j.h);
                            break;
                        }
                    }
                }
                z2 = false;
                break;
            }
            case 1: 
            case 3: {
                this.c(true);
                this.B = false;
                z2 = false;
                break;
            }
            default: {
                z2 = false;
            }
        }
        if(!z && !z1 && !z2) {
            int v2 = this.getChildCount();
            for(int v3 = 0; v3 < v2; ++v3) {
                if(((LayoutParams)this.getChildAt(v3).getLayoutParams()).c) {
                    return true;
                }
            }
            return this.B;
        }
        return true;
    }

    @Override  // android.view.View
    public final boolean onKeyDown(int v, KeyEvent keyEvent0) {
        if(v == 4 && this.e() != null) {
            keyEvent0.startTracking();
            return true;
        }
        return super.onKeyDown(v, keyEvent0);
    }

    @Override  // android.view.View
    public final boolean onKeyUp(int v, KeyEvent keyEvent0) {
        if(v == 4) {
            View view0 = this.e();
            if(view0 != null && this.f(view0) == 0) {
                this.c(false);
            }
            return view0 != null;
        }
        return super.onKeyUp(v, keyEvent0);
    }

    @Override  // android.view.ViewGroup
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        float f;
        int v13;
        this.l = true;
        int v4 = v2 - v;
        int v5 = this.getChildCount();
        for(int v6 = 0; v6 < v5; ++v6) {
            View view0 = this.getChildAt(v6);
            if(view0.getVisibility() != 8) {
                LayoutParams drawerLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                if(DrawerLayout.i(view0)) {
                    int v7 = drawerLayout$LayoutParams0.leftMargin;
                    int v8 = drawerLayout$LayoutParams0.topMargin;
                    int v9 = view0.getMeasuredWidth();
                    int v10 = drawerLayout$LayoutParams0.topMargin;
                    view0.layout(v7, v8, v9 + v7, view0.getMeasuredHeight() + v10);
                }
                else {
                    int v11 = view0.getMeasuredWidth();
                    int v12 = view0.getMeasuredHeight();
                    if(this.a(view0, 3)) {
                        v13 = ((int)(drawerLayout$LayoutParams0.b * ((float)v11))) - v11;
                        f = ((float)(v11 + v13)) / ((float)v11);
                    }
                    else {
                        int v14 = v4 - ((int)(drawerLayout$LayoutParams0.b * ((float)v11)));
                        f = ((float)(v4 - v14)) / ((float)v11);
                        v13 = v14;
                    }
                    boolean z1 = f != drawerLayout$LayoutParams0.b;
                    switch(drawerLayout$LayoutParams0.a & 0x70) {
                        case 16: {
                            int v15 = v3 - v1;
                            int v16 = (v15 - v12) / 2;
                            int v17 = drawerLayout$LayoutParams0.topMargin;
                            if(v16 < v17) {
                                v16 = v17;
                            }
                            else {
                                int v18 = v15 - drawerLayout$LayoutParams0.bottomMargin;
                                if(v16 + v12 > v18) {
                                    v16 = v18 - v12;
                                }
                            }
                            view0.layout(v13, v16, v11 + v13, v12 + v16);
                            break;
                        }
                        case 80: {
                            view0.layout(v13, v3 - v1 - drawerLayout$LayoutParams0.bottomMargin - view0.getMeasuredHeight(), v11 + v13, v3 - v1 - drawerLayout$LayoutParams0.bottomMargin);
                            break;
                        }
                        default: {
                            view0.layout(v13, drawerLayout$LayoutParams0.topMargin, v11 + v13, v12 + drawerLayout$LayoutParams0.topMargin);
                        }
                    }
                    if(z1) {
                        this.n(view0, f);
                    }
                    int v19 = drawerLayout$LayoutParams0.b > 0.0f ? 0 : 4;
                    if(view0.getVisibility() != v19) {
                        view0.setVisibility(v19);
                    }
                }
            }
        }
        if(DrawerLayout.g0) {
            WindowInsets windowInsets0 = this.getRootWindowInsets();
            if(windowInsets0 != null) {
                d d0 = B0.h(null, windowInsets0).a.k();
                this.g.o = Math.max(this.g.p, d0.a);
                this.h.o = Math.max(this.h.p, d0.c);
            }
        }
        this.l = false;
        this.m = false;
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        String s;
        int v2 = View.MeasureSpec.getMode(v);
        int v3 = View.MeasureSpec.getMode(v1);
        int v4 = View.MeasureSpec.getSize(v);
        int v5 = View.MeasureSpec.getSize(v1);
        if(v2 != 0x40000000 || v3 != 0x40000000) {
            if(!this.isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if(v2 == 0) {
                v4 = 300;
            }
            if(v3 == 0) {
                v5 = 300;
            }
        }
        this.setMeasuredDimension(v4, v5);
        boolean z = this.N != null && this.getFitsSystemWindows();
        int v6 = this.getLayoutDirection();
        int v7 = this.getChildCount();
        boolean z1 = false;
        boolean z2 = false;
        for(int v8 = 0; v8 < v7; ++v8) {
            View view0 = this.getChildAt(v8);
            if(view0.getVisibility() != 8) {
                LayoutParams drawerLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                if(z) {
                    int v9 = Gravity.getAbsoluteGravity(drawerLayout$LayoutParams0.a, v6);
                    if(view0.getFitsSystemWindows()) {
                        WindowInsets windowInsets0 = this.N;
                        if(v9 == 3) {
                            windowInsets0 = windowInsets0.replaceSystemWindowInsets(windowInsets0.getSystemWindowInsetLeft(), windowInsets0.getSystemWindowInsetTop(), 0, windowInsets0.getSystemWindowInsetBottom());
                        }
                        else if(v9 == 5) {
                            windowInsets0 = windowInsets0.replaceSystemWindowInsets(0, windowInsets0.getSystemWindowInsetTop(), windowInsets0.getSystemWindowInsetRight(), windowInsets0.getSystemWindowInsetBottom());
                        }
                        view0.dispatchApplyWindowInsets(windowInsets0);
                    }
                    else {
                        WindowInsets windowInsets1 = this.N;
                        if(v9 == 3) {
                            windowInsets1 = windowInsets1.replaceSystemWindowInsets(windowInsets1.getSystemWindowInsetLeft(), windowInsets1.getSystemWindowInsetTop(), 0, windowInsets1.getSystemWindowInsetBottom());
                        }
                        else if(v9 == 5) {
                            windowInsets1 = windowInsets1.replaceSystemWindowInsets(0, windowInsets1.getSystemWindowInsetTop(), windowInsets1.getSystemWindowInsetRight(), windowInsets1.getSystemWindowInsetBottom());
                        }
                        drawerLayout$LayoutParams0.leftMargin = windowInsets1.getSystemWindowInsetLeft();
                        drawerLayout$LayoutParams0.topMargin = windowInsets1.getSystemWindowInsetTop();
                        drawerLayout$LayoutParams0.rightMargin = windowInsets1.getSystemWindowInsetRight();
                        drawerLayout$LayoutParams0.bottomMargin = windowInsets1.getSystemWindowInsetBottom();
                    }
                }
                if(DrawerLayout.i(view0)) {
                    view0.measure(View.MeasureSpec.makeMeasureSpec(v4 - drawerLayout$LayoutParams0.leftMargin - drawerLayout$LayoutParams0.rightMargin, 0x40000000), View.MeasureSpec.makeMeasureSpec(v5 - drawerLayout$LayoutParams0.topMargin - drawerLayout$LayoutParams0.bottomMargin, 0x40000000));
                }
                else {
                    if(!DrawerLayout.k(view0)) {
                        throw new IllegalStateException("Child " + view0 + " at index " + v8 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if(DrawerLayout.f0) {
                        float f = M.e(view0);
                        float f1 = this.b;
                        if(f != f1) {
                            M.l(view0, f1);
                        }
                    }
                    int v10 = this.g(view0);
                    int v11 = v10 & 7;
                    if(v11 == 3 && z1 || v11 != 3 && z2) {
                        StringBuilder stringBuilder0 = new StringBuilder("Child drawer has absolute gravity ");
                        if((v10 & 3) == 3) {
                            s = "LEFT";
                        }
                        else if((v10 & 5) == 5) {
                            s = "RIGHT";
                        }
                        else {
                            s = Integer.toHexString(v11);
                        }
                        throw new IllegalStateException(x.m(stringBuilder0, s, " but this DrawerLayout already has a drawer view along that edge"));
                    }
                    if(v11 == 3) {
                        z1 = true;
                    }
                    else {
                        z2 = true;
                    }
                    view0.measure(ViewGroup.getChildMeasureSpec(v, this.c + drawerLayout$LayoutParams0.leftMargin + drawerLayout$LayoutParams0.rightMargin, drawerLayout$LayoutParams0.width), ViewGroup.getChildMeasureSpec(v1, drawerLayout$LayoutParams0.topMargin + drawerLayout$LayoutParams0.bottomMargin, drawerLayout$LayoutParams0.height));
                    continue;
                }
            }
        }
    }

    @Override  // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        super.onRestoreInstanceState(((SavedState)parcelable0).a);
        int v = ((SavedState)parcelable0).c;
        if(v != 0) {
            View view0 = this.d(v);
            if(view0 != null) {
                this.l(view0);
            }
        }
        int v1 = ((SavedState)parcelable0).d;
        if(v1 != 3) {
            this.m(v1, 3);
        }
        int v2 = ((SavedState)parcelable0).e;
        if(v2 != 3) {
            this.m(v2, 5);
        }
        int v3 = ((SavedState)parcelable0).f;
        if(v3 != 3) {
            this.m(v3, 0x800003);
        }
        int v4 = ((SavedState)parcelable0).g;
        if(v4 != 3) {
            this.m(v4, 0x800005);
        }
    }

    @Override  // android.view.View
    public final void onRtlPropertiesChanged(int v) {
        if(DrawerLayout.f0) {
            return;
        }
        this.getLayoutDirection();
        this.getLayoutDirection();
    }

    @Override  // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroidx/customview/view/AbsSavedState;-><init>(Landroid/os/Parcelable;)V
        parcelable0.c = 0;
        int v = this.getChildCount();
        int v1 = 0;
        while(v1 < v) {
            LayoutParams drawerLayout$LayoutParams0 = (LayoutParams)this.getChildAt(v1).getLayoutParams();
            if(drawerLayout$LayoutParams0.d != 1 && drawerLayout$LayoutParams0.d != 2) {
                ++v1;
            }
            else {
                parcelable0.c = drawerLayout$LayoutParams0.a;
                if(true) {
                    break;
                }
            }
        }
        parcelable0.d = this.n;
        parcelable0.e = this.o;
        parcelable0.f = this.r;
        parcelable0.g = this.w;
        return parcelable0;
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        c c0 = this.g;
        c0.m(motionEvent0);
        this.h.m(motionEvent0);
        int v = motionEvent0.getAction();
        boolean z = false;
        switch(v & 0xFF) {
            case 0: {
                float f = motionEvent0.getX();
                float f1 = motionEvent0.getY();
                this.G = f;
                this.I = f1;
                this.B = false;
                return true;
            }
            case 1: {
                float f2 = motionEvent0.getX();
                float f3 = motionEvent0.getY();
                View view0 = c0.i(((int)f2), ((int)f3));
                if(view0 == null || !DrawerLayout.i(view0)) {
                    z = true;
                }
                else {
                    float f4 = f2 - this.G;
                    float f5 = f3 - this.I;
                    if(f5 * f5 + f4 * f4 < ((float)(c0.b * c0.b))) {
                        int v1 = this.getChildCount();
                        for(int v2 = 0; true; ++v2) {
                            View view1 = null;
                            if(v2 >= v1) {
                                break;
                            }
                            View view2 = this.getChildAt(v2);
                            if((((LayoutParams)view2.getLayoutParams()).d & 1) == 1) {
                                view1 = view2;
                                break;
                            }
                        }
                        if(view1 == null || this.f(view1) == 2) {
                            z = true;
                        }
                    }
                    else {
                        z = true;
                    }
                }
                this.c(z);
                return true;
            }
            default: {
                if((v & 0xFF) != 3) {
                    return true;
                }
                this.c(true);
                this.B = false;
                return true;
            }
        }
    }

    public final void p(View view0, boolean z) {
        int v = this.getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            View view1 = this.getChildAt(v1);
            if((z || DrawerLayout.k(view1)) && (!z || view1 != view0)) {
                view1.setImportantForAccessibility(4);
            }
            else {
                view1.setImportantForAccessibility(1);
            }
        }
    }

    public final void q(View view0, int v) {
        int v1 = 2;
        int v2 = this.g.a;
        int v3 = this.h.a;
        if(v2 == 1 || v3 == 1) {
            v1 = 1;
        }
        else if(v2 != 2 && v3 != 2) {
            v1 = 0;
        }
        if(view0 != null && v == 0) {
            float f = ((LayoutParams)view0.getLayoutParams()).b;
            if(Float.compare(f, 0.0f) == 0) {
                LayoutParams drawerLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                if((drawerLayout$LayoutParams0.d & 1) == 1) {
                    drawerLayout$LayoutParams0.d = 0;
                    ArrayList arrayList0 = this.E;
                    if(arrayList0 != null) {
                        for(int v4 = arrayList0.size() - 1; v4 >= 0; --v4) {
                            NavigationView navigationView0 = ((l)(((b)this.E.get(v4)))).a;
                            if(view0 == navigationView0) {
                                navigationView0.G.A();
                                if(navigationView0.w && navigationView0.r != 0) {
                                    navigationView0.r = 0;
                                    navigationView0.h(navigationView0.getWidth(), navigationView0.getHeight());
                                }
                            }
                        }
                    }
                    this.p(view0, false);
                    this.o(view0);
                    if(this.hasWindowFocus()) {
                        View view1 = this.getRootView();
                        if(view1 != null) {
                            view1.sendAccessibilityEvent(0x20);
                        }
                    }
                }
            }
            else if(f == 1.0f) {
                LayoutParams drawerLayout$LayoutParams1 = (LayoutParams)view0.getLayoutParams();
                if((drawerLayout$LayoutParams1.d & 1) == 0) {
                    drawerLayout$LayoutParams1.d = 1;
                    ArrayList arrayList1 = this.E;
                    if(arrayList1 != null) {
                        for(int v5 = arrayList1.size() - 1; v5 >= 0; --v5) {
                            NavigationView navigationView1 = ((l)(((b)this.E.get(v5)))).a;
                            if(view0 == navigationView1) {
                                Objects.requireNonNull(navigationView1.G);
                                view0.post(new com.facebook.appevents.c(navigationView1.G, 14));
                            }
                        }
                    }
                    this.p(view0, true);
                    this.o(view0);
                    if(this.hasWindowFocus()) {
                        this.sendAccessibilityEvent(0x20);
                    }
                }
            }
        }
        if(v1 != this.k) {
            this.k = v1;
            ArrayList arrayList2 = this.E;
            if(arrayList2 != null) {
                for(int v6 = arrayList2.size() - 1; v6 >= 0; --v6) {
                    ((b)this.E.get(v6)).getClass();
                }
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if(z) {
            this.c(true);
        }
    }

    @Override  // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if(!this.l) {
            super.requestLayout();
        }
    }

    public void setDrawerElevation(float f) {
        this.b = f;
        for(int v = 0; v < this.getChildCount(); ++v) {
            View view0 = this.getChildAt(v);
            if(DrawerLayout.k(view0)) {
                M.l(view0, this.b);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(b b0) {
        b b1 = this.D;
        if(b1 != null) {
            ArrayList arrayList0 = this.E;
            if(arrayList0 != null) {
                arrayList0.remove(b1);
            }
        }
        if(b0 != null) {
            if(this.E == null) {
                this.E = new ArrayList();
            }
            this.E.add(b0);
        }
        this.D = b0;
    }

    public void setDrawerLockMode(int v) {
        this.m(v, 3);
        this.m(v, 5);
    }

    public void setScrimColor(int v) {
        this.d = v;
        this.invalidate();
    }

    public void setStatusBarBackground(int v) {
        this.M = v == 0 ? null : P1.c.getDrawable(this.getContext(), v);
        this.invalidate();
    }

    public void setStatusBarBackground(Drawable drawable0) {
        this.M = drawable0;
        this.invalidate();
    }

    public void setStatusBarBackgroundColor(int v) {
        this.M = new ColorDrawable(v);
        this.invalidate();
    }
}

