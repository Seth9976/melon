package u1;

import N0.M;
import N0.N;
import N0.O;
import N0.q;
import P0.I;
import android.view.ViewGroup.LayoutParams;
import java.util.List;
import je.x;
import r1.a;

public final class d implements M {
    public final o a;
    public final I b;

    public d(o o0, I i0) {
        this.a = o0;
        this.b = i0;
    }

    @Override  // N0.M
    public final int maxIntrinsicHeight(q q0, List list0, int v) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.a.getLayoutParams();
        kotlin.jvm.internal.q.d(viewGroup$LayoutParams0);
        int v1 = i.e(this.a, 0, v, viewGroup$LayoutParams0.width);
        this.a.measure(v1, 0);
        return this.a.getMeasuredHeight();
    }

    @Override  // N0.M
    public final int maxIntrinsicWidth(q q0, List list0, int v) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.a.getLayoutParams();
        kotlin.jvm.internal.q.d(viewGroup$LayoutParams0);
        int v1 = i.e(this.a, 0, v, viewGroup$LayoutParams0.height);
        this.a.measure(0, v1);
        return this.a.getMeasuredWidth();
    }

    @Override  // N0.M
    public final N measure-3p2s80s(O o0, List list0, long v) {
        o o1 = this.a;
        int v1 = o1.getChildCount();
        x x0 = x.a;
        if(v1 == 0) {
            return o0.w(a.j(v), a.i(v), x0, u1.a.j);
        }
        if(a.j(v) != 0) {
            o1.getChildAt(0).setMinimumWidth(a.j(v));
        }
        if(a.i(v) != 0) {
            o1.getChildAt(0).setMinimumHeight(a.i(v));
        }
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = o1.getLayoutParams();
        kotlin.jvm.internal.q.d(viewGroup$LayoutParams0);
        int v2 = i.e(o1, a.j(v), a.h(v), viewGroup$LayoutParams0.width);
        ViewGroup.LayoutParams viewGroup$LayoutParams1 = o1.getLayoutParams();
        kotlin.jvm.internal.q.d(viewGroup$LayoutParams1);
        o1.measure(v2, i.e(o1, a.i(v), a.g(v), viewGroup$LayoutParams1.height));
        return o0.w(o1.getMeasuredWidth(), o1.getMeasuredHeight(), x0, new c(o1, this.b, 1));
    }

    @Override  // N0.M
    public final int minIntrinsicHeight(q q0, List list0, int v) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.a.getLayoutParams();
        kotlin.jvm.internal.q.d(viewGroup$LayoutParams0);
        int v1 = i.e(this.a, 0, v, viewGroup$LayoutParams0.width);
        this.a.measure(v1, 0);
        return this.a.getMeasuredHeight();
    }

    @Override  // N0.M
    public final int minIntrinsicWidth(q q0, List list0, int v) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.a.getLayoutParams();
        kotlin.jvm.internal.q.d(viewGroup$LayoutParams0);
        int v1 = i.e(this.a, 0, v, viewGroup$LayoutParams0.height);
        this.a.measure(0, v1);
        return this.a.getMeasuredWidth();
    }
}

