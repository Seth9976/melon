package androidx.swiperefreshlayout.widget;

import L4.a;
import L4.d;
import L4.e;
import L4.f;
import L4.g;
import L4.h;
import P1.c;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ListView;
import androidx.mediarouter.app.j;
import c2.M;
import c2.q;
import c2.r;
import c2.u;

public class SwipeRefreshLayout extends ViewGroup implements q {
    public boolean B;
    public final DecelerateInterpolator D;
    public final a E;
    public int G;
    public int I;
    public float M;
    public int N;
    public int S;
    public int T;
    public final CircularProgressDrawable V;
    public f W;
    public View a;
    public h b;
    public f b0;
    public boolean c;
    public j c0;
    public final int d;
    public j d0;
    public float e;
    public f e0;
    public float f;
    public boolean f0;
    public final u g;
    public int g0;
    public final r h;
    public boolean h0;
    public final int[] i;
    public final e i0;
    public final int[] j;
    public final f j0;
    public boolean k;
    public final f k0;
    public final int l;
    public static final int[] l0;
    public int m;
    public float n;
    public float o;
    public boolean r;
    public int w;

    static {
        SwipeRefreshLayout.l0 = new int[]{0x101000E};
    }

    public SwipeRefreshLayout(Context context0) {
        this(context0, null);
    }

    public SwipeRefreshLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.c = false;
        this.e = -1.0f;
        this.i = new int[2];
        this.j = new int[2];
        this.w = -1;
        this.G = -1;
        this.i0 = new e(this, 0);
        this.j0 = new f(this, 2);
        this.k0 = new f(this, 3);
        this.d = ViewConfiguration.get(context0).getScaledTouchSlop();
        this.l = this.getResources().getInteger(0x10E0001);
        this.setWillNotDraw(false);
        this.D = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics0 = this.getResources().getDisplayMetrics();
        this.g0 = (int)(displayMetrics0.density * 40.0f);
        a a0 = new a(this.getContext());  // 初始化器: Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
        float f = a0.getContext().getResources().getDisplayMetrics().density;
        ShapeDrawable shapeDrawable0 = new ShapeDrawable(new OvalShape());
        M.l(a0, f * 4.0f);
        shapeDrawable0.getPaint().setColor(0xFFFAFAFA);
        a0.setBackground(shapeDrawable0);
        this.E = a0;
        CircularProgressDrawable circularProgressDrawable0 = new CircularProgressDrawable(this.getContext());
        this.V = circularProgressDrawable0;
        circularProgressDrawable0.c(1);
        this.E.setImageDrawable(this.V);
        this.E.setVisibility(8);
        this.addView(this.E);
        this.setChildrenDrawingOrderEnabled(true);
        int v = (int)(displayMetrics0.density * 64.0f);
        this.S = v;
        this.e = (float)v;
        this.g = new u();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.h = new r(this);
        this.setNestedScrollingEnabled(true);
        this.m = -this.g0;
        this.N = -this.g0;
        this.e(1.0f);
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, SwipeRefreshLayout.l0);
        this.setEnabled(typedArray0.getBoolean(0, true));
        typedArray0.recycle();
    }

    public final boolean a() {
        View view0 = this.a;
        return view0 instanceof ListView ? ((ListView)view0).canScrollList(-1) : view0.canScrollVertically(-1);
    }

    public final void b() {
        if(this.a == null) {
            for(int v = 0; v < this.getChildCount(); ++v) {
                View view0 = this.getChildAt(v);
                if(!view0.equals(this.E)) {
                    this.a = view0;
                    return;
                }
            }
        }
    }

    public final void c(float f) {
        if(f > this.e) {
            this.g(true, true);
            return;
        }
        this.c = false;
        this.V.a.e = 0.0f;
        this.V.a.f = 0.0f;
        this.V.invalidateSelf();
        boolean z = this.B;
        e e0 = z ? null : new e(this, 1);
        int v = this.m;
        if(z) {
            this.I = v;
            this.M = this.E.getScaleX();
            f f1 = new f(this, 4);
            this.e0 = f1;
            f1.setDuration(150L);
            if(e0 != null) {
                this.E.a = e0;
            }
            this.E.clearAnimation();
            this.E.startAnimation(this.e0);
        }
        else {
            this.I = v;
            f f2 = this.k0;
            f2.reset();
            f2.setDuration(200L);
            f2.setInterpolator(this.D);
            if(e0 != null) {
                this.E.a = e0;
            }
            this.E.clearAnimation();
            this.E.startAnimation(f2);
        }
        CircularProgressDrawable circularProgressDrawable0 = this.V;
        d d0 = circularProgressDrawable0.a;
        if(d0.n) {
            d0.n = false;
        }
        circularProgressDrawable0.invalidateSelf();
    }

    public final void d(float f) {
        CircularProgressDrawable circularProgressDrawable0 = this.V;
        d d0 = circularProgressDrawable0.a;
        if(!d0.n) {
            d0.n = true;
        }
        circularProgressDrawable0.invalidateSelf();
        float f1 = Math.min(1.0f, Math.abs(f / this.e));
        float f2 = ((float)Math.max(((double)f1) - 0.4, 0.0)) * 5.0f / 3.0f;
        float f3 = Math.abs(f) - this.e;
        int v = this.T;
        if(v <= 0) {
            v = this.h0 ? this.S - this.N : this.S;
        }
        float f4 = Math.max(0.0f, Math.min(f3, ((float)v) * 2.0f) / ((float)v));
        float f5 = ((float)(((double)(f4 / 4.0f)) - Math.pow(f4 / 4.0f, 2.0))) * 2.0f;
        int v1 = this.N + ((int)(((float)v) * f1 + ((float)v) * f5 * 2.0f));
        if(this.E.getVisibility() != 0) {
            this.E.setVisibility(0);
        }
        if(!this.B) {
            this.E.setScaleX(1.0f);
            this.E.setScaleY(1.0f);
        }
        if(this.B) {
            this.setAnimationProgress(Math.min(1.0f, f / this.e));
        }
        if(Float.compare(f, this.e) >= 0) {
            if(this.V.a.t < 0xFF) {
                j j2 = this.d0;
                if(j2 == null || !j2.hasStarted() || j2.hasEnded()) {
                    j j3 = new j(this, this.V.a.t, 0xFF);
                    j3.setDuration(300L);
                    this.E.a = null;
                    this.E.clearAnimation();
                    this.E.startAnimation(j3);
                    this.d0 = j3;
                }
            }
        }
        else if(this.V.a.t > 76) {
            j j0 = this.c0;
            if(j0 == null || !j0.hasStarted() || j0.hasEnded()) {
                j j1 = new j(this, this.V.a.t, 76);
                j1.setDuration(300L);
                this.E.a = null;
                this.E.clearAnimation();
                this.E.startAnimation(j1);
                this.c0 = j1;
            }
        }
        this.V.a.e = 0.0f;
        this.V.a.f = Math.min(0.8f, f2 * 0.8f);
        this.V.invalidateSelf();
        float f6 = Math.min(1.0f, f2);
        CircularProgressDrawable circularProgressDrawable1 = this.V;
        d d1 = circularProgressDrawable1.a;
        if(f6 != d1.p) {
            d1.p = f6;
        }
        circularProgressDrawable1.invalidateSelf();
        this.V.a.g = (f5 * 2.0f + (f2 * 0.4f - 0.25f)) * 0.5f;
        this.V.invalidateSelf();
        this.setTargetOffsetTopAndBottom(v1 - this.m);
    }

    @Override  // android.view.View
    public final boolean dispatchNestedFling(float f, float f1, boolean z) {
        return this.h.a(f, f1, z);
    }

    @Override  // android.view.View
    public final boolean dispatchNestedPreFling(float f, float f1) {
        return this.h.b(f, f1);
    }

    @Override  // android.view.View
    public final boolean dispatchNestedPreScroll(int v, int v1, int[] arr_v, int[] arr_v1) {
        return this.h.c(v, v1, arr_v, arr_v1, 0);
    }

    @Override  // android.view.View
    public final boolean dispatchNestedScroll(int v, int v1, int v2, int v3, int[] arr_v) {
        return this.h.d(v, v1, v2, v3, arr_v, 0, null);
    }

    public final void e(float f) {
        this.setTargetOffsetTopAndBottom(this.I + ((int)(((float)(this.N - this.I)) * f)) - this.E.getTop());
    }

    public final void f() {
        this.E.clearAnimation();
        this.V.stop();
        this.E.setVisibility(8);
        this.setColorViewAlpha(0xFF);
        if(this.B) {
            this.setAnimationProgress(0.0f);
        }
        else {
            this.setTargetOffsetTopAndBottom(this.N - this.m);
        }
        this.m = this.E.getTop();
    }

    public final void g(boolean z, boolean z1) {
        if(this.c != z) {
            this.f0 = z1;
            this.b();
            this.c = z;
            e e0 = this.i0;
            if(z) {
                this.I = this.m;
                f f0 = this.j0;
                f0.reset();
                f0.setDuration(200L);
                f0.setInterpolator(this.D);
                if(e0 != null) {
                    this.E.a = e0;
                }
                this.E.clearAnimation();
                this.E.startAnimation(f0);
                return;
            }
            f f1 = new f(this, 1);
            this.b0 = f1;
            f1.setDuration(150L);
            this.E.a = e0;
            this.E.clearAnimation();
            this.E.startAnimation(this.b0);
        }
    }

    @Override  // android.view.ViewGroup
    public final int getChildDrawingOrder(int v, int v1) {
        int v2 = this.G;
        if(v2 >= 0) {
            if(v1 == v - 1) {
                return v2;
            }
            return v1 < v2 ? v1 : v1 + 1;
        }
        return v1;
    }

    @Override  // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.g.a();
    }

    public int getProgressCircleDiameter() {
        return this.g0;
    }

    public int getProgressViewEndOffset() {
        return this.S;
    }

    public int getProgressViewStartOffset() {
        return this.N;
    }

    public final void h(float f) {
        float f1 = this.o;
        float f2 = (float)this.d;
        if(f - f1 > f2 && !this.r) {
            this.n = f1 + f2;
            this.r = true;
            this.V.setAlpha(76);
        }
    }

    @Override  // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.h.f(0);
    }

    @Override  // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.h.d;
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f();
    }

    @Override  // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent0) {
        this.b();
        int v = motionEvent0.getActionMasked();
        int v1 = 0;
        if(this.isEnabled() && !this.a() && !this.c && !this.k) {
            switch(v) {
                case 0: {
                    this.setTargetOffsetTopAndBottom(this.N - this.E.getTop());
                    int v5 = motionEvent0.getPointerId(0);
                    this.w = v5;
                    this.r = false;
                    int v6 = motionEvent0.findPointerIndex(v5);
                    if(v6 >= 0) {
                        this.o = motionEvent0.getY(v6);
                        return this.r;
                    }
                    break;
                }
                case 2: {
                    int v3 = this.w;
                    if(v3 == -1) {
                        Log.e("SwipeRefreshLayout", "Got ACTION_MOVE event but don\'t have an active pointer id.");
                        return false;
                    }
                    int v4 = motionEvent0.findPointerIndex(v3);
                    if(v4 >= 0) {
                        this.h(motionEvent0.getY(v4));
                        return this.r;
                    }
                    break;
                }
                case 1: 
                case 3: {
                    this.r = false;
                    this.w = -1;
                    return false;
                }
                case 6: {
                    int v2 = motionEvent0.getActionIndex();
                    if(motionEvent0.getPointerId(v2) != this.w) {
                        return this.r;
                    }
                    if(v2 == 0) {
                        v1 = 1;
                    }
                    this.w = motionEvent0.getPointerId(v1);
                    return this.r;
                }
                default: {
                    return this.r;
                }
            }
        }
        return false;
    }

    @Override  // android.view.ViewGroup
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v4 = this.getMeasuredWidth();
        int v5 = this.getMeasuredHeight();
        if(this.getChildCount() != 0) {
            if(this.a == null) {
                this.b();
            }
            View view0 = this.a;
            if(view0 != null) {
                int v6 = this.getPaddingLeft();
                int v7 = this.getPaddingTop();
                view0.layout(v6, v7, v4 - this.getPaddingLeft() - this.getPaddingRight() + v6, v5 - this.getPaddingTop() - this.getPaddingBottom() + v7);
                int v8 = this.E.getMeasuredWidth();
                int v9 = this.E.getMeasuredHeight();
                this.E.layout(v4 / 2 - v8 / 2, this.m, v4 / 2 + v8 / 2, v9 + this.m);
            }
        }
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        if(this.a == null) {
            this.b();
        }
        View view0 = this.a;
        if(view0 != null) {
            view0.measure(View.MeasureSpec.makeMeasureSpec(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), 0x40000000), View.MeasureSpec.makeMeasureSpec(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), 0x40000000));
            int v2 = View.MeasureSpec.makeMeasureSpec(this.g0, 0x40000000);
            int v3 = View.MeasureSpec.makeMeasureSpec(this.g0, 0x40000000);
            this.E.measure(v2, v3);
            this.G = -1;
            for(int v4 = 0; v4 < this.getChildCount(); ++v4) {
                if(this.getChildAt(v4) == this.E) {
                    this.G = v4;
                    return;
                }
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final boolean onNestedFling(View view0, float f, float f1, boolean z) {
        return this.h.a(f, f1, z);
    }

    @Override  // android.view.ViewGroup
    public final boolean onNestedPreFling(View view0, float f, float f1) {
        return this.h.b(f, f1);
    }

    @Override  // android.view.ViewGroup
    public final void onNestedPreScroll(View view0, int v, int v1, int[] arr_v) {
        if(v1 > 0) {
            float f = this.f;
            if(f > 0.0f) {
                if(((float)v1) > f) {
                    arr_v[1] = v1 - ((int)f);
                    this.f = 0.0f;
                }
                else {
                    this.f = f - ((float)v1);
                    arr_v[1] = v1;
                }
                this.d(this.f);
            }
        }
        if(this.h0 && v1 > 0 && this.f == 0.0f && Math.abs(v1 - arr_v[1]) > 0) {
            this.E.setVisibility(8);
        }
        int[] arr_v1 = this.i;
        if(this.dispatchNestedPreScroll(v - arr_v[0], v1 - arr_v[1], arr_v1, null)) {
            arr_v[0] += arr_v1[0];
            arr_v[1] += arr_v1[1];
        }
    }

    @Override  // android.view.ViewGroup
    public final void onNestedScroll(View view0, int v, int v1, int v2, int v3) {
        this.dispatchNestedScroll(v, v1, v2, v3, this.j);
        int v4 = v3 + this.j[1];
        if(v4 < 0 && !this.a()) {
            float f = this.f + ((float)Math.abs(v4));
            this.f = f;
            this.d(f);
        }
    }

    @Override  // android.view.ViewGroup
    public final void onNestedScrollAccepted(View view0, View view1, int v) {
        this.g.a = v;
        this.startNestedScroll(v & 2);
        this.f = 0.0f;
        this.k = true;
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.ViewGroup
    public final boolean onStartNestedScroll(View view0, View view1, int v) {
        return this.isEnabled() && !this.c && (v & 2) != 0;
    }

    @Override  // android.view.ViewGroup
    public final void onStopNestedScroll(View view0) {
        this.g.a = 0;
        this.k = false;
        float f = this.f;
        if(f > 0.0f) {
            this.c(f);
            this.f = 0.0f;
        }
        this.stopNestedScroll();
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        int v = motionEvent0.getActionMasked();
        int v1 = 0;
        if(this.isEnabled() && !this.a() && !this.c && !this.k) {
            switch(v) {
                case 0: {
                    this.w = motionEvent0.getPointerId(0);
                    this.r = false;
                    return true;
                }
                case 1: {
                    int v3 = motionEvent0.findPointerIndex(this.w);
                    if(v3 < 0) {
                        Log.e("SwipeRefreshLayout", "Got ACTION_UP event but don\'t have an active pointer id.");
                        return false;
                    }
                    if(this.r) {
                        float f = motionEvent0.getY(v3);
                        this.r = false;
                        this.c((f - this.n) * 0.5f);
                    }
                    this.w = -1;
                    return false;
                }
                case 2: {
                    int v5 = motionEvent0.findPointerIndex(this.w);
                    if(v5 < 0) {
                        Log.e("SwipeRefreshLayout", "Got ACTION_MOVE event but have an invalid active pointer id.");
                        return false;
                    }
                    float f1 = motionEvent0.getY(v5);
                    this.h(f1);
                    if(!this.r) {
                        return true;
                    }
                    float f2 = (f1 - this.n) * 0.5f;
                    if(f2 > 0.0f) {
                        this.d(f2);
                        return true;
                    }
                    break;
                }
                case 3: {
                    break;
                }
                case 5: {
                    int v2 = motionEvent0.getActionIndex();
                    if(v2 < 0) {
                        Log.e("SwipeRefreshLayout", "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.w = motionEvent0.getPointerId(v2);
                    return true;
                }
                case 6: {
                    int v4 = motionEvent0.getActionIndex();
                    if(motionEvent0.getPointerId(v4) != this.w) {
                        return true;
                    }
                    if(v4 == 0) {
                        v1 = 1;
                    }
                    this.w = motionEvent0.getPointerId(v1);
                    return true;
                }
                default: {
                    return true;
                }
            }
        }
        return false;
    }

    @Override  // android.view.ViewGroup
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        if(this.a != null && !M.i(this.a)) {
            return;
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void setAnimationProgress(float f) {
        this.E.setScaleX(f);
        this.E.setScaleY(f);
    }

    @Deprecated
    public void setColorScheme(int[] arr_v) {
        this.setColorSchemeResources(arr_v);
    }

    public void setColorSchemeColors(int[] arr_v) {
        this.b();
        this.V.a.i = arr_v;
        this.V.a.a(0);
        this.V.a.a(0);
        this.V.invalidateSelf();
    }

    public void setColorSchemeResources(int[] arr_v) {
        Context context0 = this.getContext();
        int[] arr_v1 = new int[arr_v.length];
        for(int v = 0; v < arr_v.length; ++v) {
            arr_v1[v] = c.getColor(context0, arr_v[v]);
        }
        this.setColorSchemeColors(arr_v1);
    }

    private void setColorViewAlpha(int v) {
        this.E.getBackground().setAlpha(v);
        this.V.setAlpha(v);
    }

    public void setDistanceToTriggerSync(int v) {
        this.e = (float)v;
    }

    @Override  // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if(!z) {
            this.f();
        }
    }

    @Override  // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.h.g(z);
    }

    public void setOnChildScrollUpCallback(g g0) {
    }

    public void setOnRefreshListener(h h0) {
        this.b = h0;
    }

    @Deprecated
    public void setProgressBackgroundColor(int v) {
        this.setProgressBackgroundColorSchemeResource(v);
    }

    public void setProgressBackgroundColorSchemeColor(int v) {
        this.E.setBackgroundColor(v);
    }

    public void setProgressBackgroundColorSchemeResource(int v) {
        this.setProgressBackgroundColorSchemeColor(c.getColor(this.getContext(), v));
    }

    public void setRefreshing(boolean z) {
        if(z && !this.c) {
            this.c = true;
            this.setTargetOffsetTopAndBottom((this.h0 ? this.S : this.S + this.N) - this.m);
            this.f0 = false;
            this.E.setVisibility(0);
            this.V.setAlpha(0xFF);
            f f0 = new f(this, 0);
            this.W = f0;
            f0.setDuration(((long)this.l));
            e e0 = this.i0;
            if(e0 != null) {
                this.E.a = e0;
            }
            this.E.clearAnimation();
            this.E.startAnimation(this.W);
            return;
        }
        this.g(z, false);
    }

    public void setSize(int v) {
        if(v != 0 && v != 1) {
            return;
        }
        DisplayMetrics displayMetrics0 = this.getResources().getDisplayMetrics();
        this.g0 = v == 0 ? ((int)(displayMetrics0.density * 56.0f)) : ((int)(displayMetrics0.density * 40.0f));
        this.E.setImageDrawable(null);
        this.V.c(v);
        this.E.setImageDrawable(this.V);
    }

    public void setSlingshotDistance(int v) {
        this.T = v;
    }

    public void setTargetOffsetTopAndBottom(int v) {
        this.E.bringToFront();
        this.E.offsetTopAndBottom(v);
        this.m = this.E.getTop();
    }

    @Override  // android.view.View
    public final boolean startNestedScroll(int v) {
        return this.h.h(v, 0);
    }

    @Override  // android.view.View
    public final void stopNestedScroll() {
        this.h.i(0);
    }
}

