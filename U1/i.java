package u1;

import Ac.q0;
import E4.g;
import I0.d;
import J0.B;
import N0.g0;
import P0.I;
import P0.r0;
import P0.s0;
import P0.t0;
import Q0.N;
import Q0.s;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Region;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.collection.F;
import androidx.compose.foundation.w;
import androidx.compose.runtime.n;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import c2.B0;
import c2.M;
import c2.W;
import c2.t;
import c2.u;
import c2.v;
import e1.x;
import g0.e;
import gd.y1;
import java.util.Arrays;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.r;
import r0.q;
import r1.c;
import we.a;
import we.k;

public abstract class i extends ViewGroup implements s0, androidx.compose.runtime.i, t, v {
    public final h B;
    public k D;
    public final int[] E;
    public int G;
    public int I;
    public final u M;
    public boolean N;
    public final I S;
    public final d a;
    public final View b;
    public final r0 c;
    public a d;
    public boolean e;
    public a f;
    public a g;
    public q h;
    public k i;
    public c j;
    public k k;
    public D l;
    public g m;
    public final int[] n;
    public long o;
    public B0 r;
    public final h w;

    public i(Context context0, n n0, int v, d d0, View view0, r0 r00) {
        super(context0);
        this.a = d0;
        this.b = view0;
        this.c = r00;
        this.setTag(0x7F0A009E, n0);  // id:androidx_compose_ui_view_composition_context
        this.setSaveFromParentEnabled(false);
        this.addView(view0);
        W.q(this, new b(((o)this)));
        M.n(this, this);
        this.d = u1.g.i;
        this.f = u1.g.h;
        this.g = u1.g.g;
        this.h = r0.n.a;
        this.j = df.v.c();
        this.n = new int[2];
        this.o = 0L;
        this.w = new h(((o)this), 1);
        this.B = new h(((o)this), 0);
        this.E = new int[2];
        this.G = 0x80000000;
        this.I = 0x80000000;
        this.M = new u();  // 初始化器: Ljava/lang/Object;-><init>()V
        I i0 = new I(3);
        i0.g = true;
        i0.o = (o)this;
        q q0 = X0.n.c(androidx.compose.ui.input.nestedscroll.a.a(r0.n.a, j.a, d0), true, u1.a.k);
        B b0 = new B();
        b0.a = new J0.D(((o)this), 0);
        q0 q00 = new q0();
        q0 q01 = b0.b;
        if(q01 != null) {
            q01.b = null;
        }
        b0.b = q00;
        q00.b = b0;
        this.setOnRequestDisallowInterceptTouchEvent$ui_release(q00);
        q q1 = androidx.compose.ui.layout.a.d(androidx.compose.ui.draw.a.a(androidx.compose.ui.graphics.a.b(q0.then(b0), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, false, 0x1FFFF), new F.g(((o)this), i0, ((o)this), 21)), new u1.c(((o)this), i0, 2));
        i0.c0(this.h.then(q1));
        this.i = new y1(28, i0, q1);
        i0.Z(this.j);
        this.k = new w(i0, 22);
        i0.i0 = new u1.c(((o)this), i0, 0);
        i0.j0 = new J0.D(((o)this), 1);
        i0.b0(new u1.d(((o)this), i0));
        this.S = i0;
    }

    @Override  // P0.s0
    public final boolean G() {
        return this.isAttachedToWindow();
    }

    @Override  // androidx.compose.runtime.i
    public final void a() {
        this.f.invoke();
        this.removeAllViewsInLayout();
    }

    @Override  // androidx.compose.runtime.i
    public final void b() {
        View view0 = this.b;
        if(view0.getParent() != this) {
            this.addView(view0);
            return;
        }
        this.f.invoke();
    }

    @Override  // androidx.compose.runtime.i
    public final void c() {
        this.g.invoke();
    }

    public static final int e(o o0, int v, int v1, int v2) {
        if(v2 < 0 && v != v1) {
            if(v2 == -2 && v1 != 0x7FFFFFFF) {
                return View.MeasureSpec.makeMeasureSpec(v1, 0x80000000);
            }
            return v2 != -1 || v1 == 0x7FFFFFFF ? 0 : View.MeasureSpec.makeMeasureSpec(v1, 0x40000000);
        }
        return View.MeasureSpec.makeMeasureSpec(P4.a.j(v2, v, v1), 0x40000000);
    }

    public static S1.d f(S1.d d0, int v, int v1, int v2, int v3) {
        int v4 = d0.a - v;
        int v5 = 0;
        if(v4 < 0) {
            v4 = 0;
        }
        int v6 = d0.b - v1 >= 0 ? d0.b - v1 : 0;
        int v7 = d0.c - v2 >= 0 ? d0.c - v2 : 0;
        int v8 = d0.d - v3;
        if(v8 >= 0) {
            v5 = v8;
        }
        return S1.d.c(v4, v6, v7, v5);
    }

    public final B0 g(B0 b00) {
        if(b00.a.g(-1).equals(S1.d.e) && b00.a.h(-9).equals(S1.d.e) && b00.a.f() == null) {
            return b00;
        }
        P0.v v0 = (P0.v)this.S.b0.c;
        if(v0.h()) {
            long v1 = e1.b.J(v0.j0(0L));
            int v2 = (int)(v1 >> 0x20);
            int v3 = 0;
            if(v2 < 0) {
                v2 = 0;
            }
            int v4 = ((int)(v1 & 0xFFFFFFFFL)) >= 0 ? ((int)(v1 & 0xFFFFFFFFL)) : 0;
            long v5 = g0.g(v0).l();
            long v6 = e1.b.J(v0.j0(((long)Float.floatToRawIntBits(((int)(v0.c >> 0x20)))) << 0x20 | ((long)Float.floatToRawIntBits(((int)(v0.c & 0xFFFFFFFFL)))) & 0xFFFFFFFFL));
            int v7 = ((int)(v5 >> 0x20)) - ((int)(v6 >> 0x20)) >= 0 ? ((int)(v5 >> 0x20)) - ((int)(v6 >> 0x20)) : 0;
            int v8 = ((int)(v5 & 0xFFFFFFFFL)) - ((int)(0xFFFFFFFFL & v6));
            if(v8 >= 0) {
                v3 = v8;
            }
            return v2 != 0 || v4 != 0 || v7 != 0 || v3 != 0 ? b00.a.n(v2, v4, v7, v3) : b00;
        }
        return b00;
    }

    @Override  // android.view.ViewGroup
    public final boolean gatherTransparentRegion(Region region0) {
        if(region0 == null) {
            return true;
        }
        this.getLocationInWindow(this.E);
        int v = this.E[0];
        int v1 = this.E[1];
        int v2 = this.getWidth();
        int v3 = this.E[1];
        region0.op(v, v1, v2 + v, this.getHeight() + v3, Region.Op.DIFFERENCE);
        return true;
    }

    @Override  // android.view.ViewGroup
    @NotNull
    public CharSequence getAccessibilityClassName() {
        return this.getClass().getName();
    }

    @NotNull
    public final c getDensity() {
        return this.j;
    }

    @Nullable
    public final View getInteropView() {
        return this.b;
    }

    @NotNull
    public final I getLayoutNode() {
        return this.S;
    }

    @Override  // android.view.View
    @Nullable
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.b.getLayoutParams();
        return viewGroup$LayoutParams0 == null ? new ViewGroup.LayoutParams(-1, -1) : viewGroup$LayoutParams0;
    }

    @Nullable
    public final D getLifecycleOwner() {
        return this.l;
    }

    @NotNull
    public final q getModifier() {
        return this.h;
    }

    @Override  // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.M.a();
    }

    @Nullable
    public final k getOnDensityChanged$ui_release() {
        return this.k;
    }

    @Nullable
    public final k getOnModifierChanged$ui_release() {
        return this.i;
    }

    @Nullable
    public final k getOnRequestDisallowInterceptTouchEvent$ui_release() {
        return this.D;
    }

    @NotNull
    public final a getRelease() {
        return this.g;
    }

    @NotNull
    public final a getReset() {
        return this.f;
    }

    @Nullable
    public final g getSavedStateRegistryOwner() {
        return this.m;
    }

    private final t0 getSnapshotObserver() {
        if(!this.isAttachedToWindow()) {
            M0.a.b("Expected AndroidViewHolder to be attached when observing reads.");
        }
        return ((Q0.u)this.c).getSnapshotObserver();
    }

    @NotNull
    public final a getUpdate() {
        return this.d;
    }

    @NotNull
    public final View getView() {
        return this.b;
    }

    @Override  // android.view.ViewGroup
    public final ViewParent invalidateChildInParent(int[] arr_v, Rect rect0) {
        super.invalidateChildInParent(arr_v, rect0);
        if(this.N) {
            s s0 = new s(2, this.B);
            this.b.postOnAnimation(s0);
            return null;
        }
        this.S.B();
        return null;
    }

    @Override  // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.b.isNestedScrollingEnabled();
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.w.invoke();
    }

    @Override  // android.view.ViewGroup
    public final void onDescendantInvalidated(View view0, View view1) {
        super.onDescendantInvalidated(view0, view1);
        if(this.N) {
            s s0 = new s(2, this.B);
            this.b.postOnAnimation(s0);
            return;
        }
        this.S.B();
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        int v7;
        super.onDetachedFromWindow();
        t0 t00 = this.getSnapshotObserver();
        synchronized(t00.a.g) {
            e e0 = t00.a.f;
            int v1 = e0.c;
            int v2 = 0;
            int v3 = 0;
            while(v2 < v1) {
                r r0 = (r)e0.a[v2];
                F f0 = (F)r0.f.j(this);
                if(f0 == null) {
                    v7 = v2;
                }
                else {
                    Object[] arr_object = f0.b;
                    int[] arr_v = f0.c;
                    long[] arr_v1 = f0.a;
                    int v4 = arr_v1.length - 2;
                    if(v4 >= 0) {
                        int v5 = 0;
                        while(true) {
                            long v6 = arr_v1[v5];
                            v7 = v2;
                            if((~v6 << 7 & v6 & 0x8080808080808080L) == 0x8080808080808080L) {
                                goto label_34;
                            }
                            int v8 = 8 - (~(v5 - v4) >>> 0x1F);
                            for(int v9 = 0; v9 < v8; ++v9) {
                                if((v6 & 0xFFL) < 0x80L) {
                                    int v10 = (v5 << 3) + v9;
                                    Object object1 = arr_object[v10];
                                    int v11 = arr_v[v10];
                                    r0.d(this, object1);
                                }
                                v6 >>= 8;
                            }
                            if(v8 == 8) {
                            label_34:
                                if(v5 != v4) {
                                    ++v5;
                                    v2 = v7;
                                    continue;
                                }
                            }
                            break;
                        }
                    }
                    else {
                        v7 = v2;
                    }
                }
                if(r0.f.e == 0) {
                    ++v3;
                }
                else if(v3 > 0) {
                    e0.a[v7 - v3] = e0.a[v7];
                }
                v2 = v7 + 1;
            }
            int v12 = v1 - v3;
            Arrays.fill(e0.a, v12, v1, null);
            e0.c = v12;
        }
    }

    @Override  // android.view.ViewGroup
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        this.b.layout(0, 0, v2 - v, v3 - v1);
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        View view0 = this.b;
        if(view0.getParent() != this) {
            this.setMeasuredDimension(View.MeasureSpec.getSize(v), View.MeasureSpec.getSize(v1));
            return;
        }
        if(view0.getVisibility() == 8) {
            this.setMeasuredDimension(0, 0);
            return;
        }
        view0.measure(v, v1);
        this.setMeasuredDimension(view0.getMeasuredWidth(), view0.getMeasuredHeight());
        this.G = v;
        this.I = v1;
    }

    @Override  // android.view.ViewGroup
    public final boolean onNestedFling(View view0, float f, float f1, boolean z) {
        if(!this.b.isNestedScrollingEnabled()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(this.a.c(), null, null, new u1.e(z, this, x.x(f * -1.0f, -1.0f * f1), null), 3, null);
        return false;
    }

    @Override  // android.view.ViewGroup
    public final boolean onNestedPreFling(View view0, float f, float f1) {
        if(!this.b.isNestedScrollingEnabled()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(this.a.c(), null, null, new f(this, x.x(f * -1.0f, f1 * -1.0f), null), 3, null);
        return false;
    }

    @Override  // c2.s
    public final void onNestedPreScroll(View view0, int v, int v1, int[] arr_v, int v2) {
        if(!this.b.isNestedScrollingEnabled()) {
            return;
        }
        I0.g g0 = this.a.a;
        I0.g g1 = g0 == null || !g0.isAttached() ? null : ((I0.g)P0.f.j(g0));
        long v3 = g1 == null ? 0L : g1.onPreScroll-OzD1aCk(((long)Float.floatToRawIntBits(((float)v) * -1.0f)) << 0x20 | ((long)Float.floatToRawIntBits(((float)v1) * -1.0f)) & 0xFFFFFFFFL, (v2 == 0 ? 1 : 2));
        arr_v[0] = N.h(Float.intBitsToFloat(((int)(v3 >> 0x20))));
        arr_v[1] = N.h(Float.intBitsToFloat(((int)(v3 & 0xFFFFFFFFL))));
    }

    @Override  // c2.s
    public final void onNestedScroll(View view0, int v, int v1, int v2, int v3, int v4) {
        if(!this.b.isNestedScrollingEnabled()) {
            return;
        }
        long v5 = ((long)Float.floatToRawIntBits(((float)v) * -1.0f)) << 0x20 | ((long)Float.floatToRawIntBits(((float)v1) * -1.0f)) & 0xFFFFFFFFL;
        long v6 = ((long)Float.floatToRawIntBits(((float)v2) * -1.0f)) << 0x20 | ((long)Float.floatToRawIntBits(((float)v3) * -1.0f)) & 0xFFFFFFFFL;
        I0.g g0 = this.a.a;
        I0.g g1 = g0 == null || !g0.isAttached() ? null : ((I0.g)P0.f.j(g0));
        if(g1 != null) {
            g1.onPostScroll-DzOQY0M(v5, v6, (v4 == 0 ? 1 : 2));
        }
    }

    @Override  // c2.t
    public final void onNestedScroll(View view0, int v, int v1, int v2, int v3, int v4, int[] arr_v) {
        if(!this.b.isNestedScrollingEnabled()) {
            return;
        }
        I0.g g0 = this.a.a;
        I0.g g1 = g0 == null || !g0.isAttached() ? null : ((I0.g)P0.f.j(g0));
        long v5 = g1 == null ? 0L : g1.onPostScroll-DzOQY0M(((long)Float.floatToRawIntBits(((float)v) * -1.0f)) << 0x20 | ((long)Float.floatToRawIntBits(((float)v1) * -1.0f)) & 0xFFFFFFFFL, ((long)Float.floatToRawIntBits(((float)v2) * -1.0f)) << 0x20 | ((long)Float.floatToRawIntBits(((float)v3) * -1.0f)) & 0xFFFFFFFFL, (v4 == 0 ? 1 : 2));
        arr_v[0] = N.h(Float.intBitsToFloat(((int)(v5 >> 0x20))));
        arr_v[1] = N.h(Float.intBitsToFloat(((int)(v5 & 0xFFFFFFFFL))));
    }

    @Override  // c2.s
    public final void onNestedScrollAccepted(View view0, View view1, int v, int v1) {
        u u0 = this.M;
        if(v1 == 1) {
            u0.b = v;
            return;
        }
        u0.a = v;
    }

    @Override  // c2.s
    public final boolean onStartNestedScroll(View view0, View view1, int v, int v1) {
        return (v & 2) != 0 || (v & 1) != 0;
    }

    @Override  // c2.s
    public final void onStopNestedScroll(View view0, int v) {
        u u0 = this.M;
        if(v == 1) {
            u0.b = 0;
            return;
        }
        u0.a = 0;
    }

    @Override  // android.view.View
    public final void onWindowVisibilityChanged(int v) {
        super.onWindowVisibilityChanged(v);
    }

    @Override  // android.view.ViewGroup
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        k k0 = this.D;
        if(k0 != null) {
            k0.invoke(Boolean.valueOf(z));
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override  // c2.v
    public final B0 s(View view0, B0 b00) {
        this.r = new B0(b00);
        return this.g(b00);
    }

    public final void setDensity(@NotNull c c0) {
        if(c0 != this.j) {
            this.j = c0;
            k k0 = this.k;
            if(k0 != null) {
                k0.invoke(c0);
            }
        }
    }

    public final void setLifecycleOwner(@Nullable D d0) {
        if(d0 != this.l) {
            this.l = d0;
            f0.k(this, d0);
        }
    }

    public final void setModifier(@NotNull q q0) {
        if(q0 != this.h) {
            this.h = q0;
            k k0 = this.i;
            if(k0 != null) {
                k0.invoke(q0);
            }
        }
    }

    public final void setOnDensityChanged$ui_release(@Nullable k k0) {
        this.k = k0;
    }

    public final void setOnModifierChanged$ui_release(@Nullable k k0) {
        this.i = k0;
    }

    public final void setOnRequestDisallowInterceptTouchEvent$ui_release(@Nullable k k0) {
        this.D = k0;
    }

    public final void setRelease(@NotNull a a0) {
        this.g = a0;
    }

    public final void setReset(@NotNull a a0) {
        this.f = a0;
    }

    public final void setSavedStateRegistryOwner(@Nullable g g0) {
        if(g0 != this.m) {
            this.m = g0;
            a.a.M(this, g0);
        }
    }

    public final void setUpdate(@NotNull a a0) {
        this.d = a0;
        this.e = true;
        this.w.invoke();
    }

    @Override  // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }
}

