package zc;

import Cc.e0;
import F.E;
import android.content.Context;
import android.graphics.Path;
import androidx.compose.foundation.Q0;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.I0;
import androidx.compose.runtime.Z;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.q;
import r0.n;
import we.o;
import y0.M;
import y0.g;

public final class y implements o {
    public final float a;
    public final Q0 b;
    public final float c;
    public final ArrayList d;
    public final int e;
    public final Context f;
    public final I g;
    public final List h;
    public final List i;
    public final float j;
    public final float k;
    public final float l;
    public final float m;
    public final boolean n;
    public final Z o;
    public final Z r;

    public y(float f, Q0 q00, float f1, ArrayList arrayList0, int v, Context context0, I i0, List list0, List list1, float f2, float f3, float f4, float f5, boolean z, Z z1, Z z2) {
        this.a = f;
        this.b = q00;
        this.c = f1;
        this.d = arrayList0;
        this.e = v;
        this.f = context0;
        this.g = i0;
        this.h = list0;
        this.i = list1;
        this.j = f2;
        this.k = f3;
        this.l = f4;
        this.m = f5;
        this.n = z;
        this.o = z1;
        this.r = z2;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        B b0;
        ((Integer)object2).getClass();
        q.g(((E)object0), "$this$AnimatedVisibility");
        float f = ((I0)this.o).m();
        float f1 = this.a;
        float f2 = f + f1;
        g g0 = new g(new Path());
        g0.g();
        float f3 = this.m;
        g0.e(this.m, f2);
        r0.q q0 = d.h(d.q(androidx.compose.foundation.q.f(androidx.compose.foundation.q.u(n.a, this.b, true, false), e0.T(((l)object1), 0x7F06048A), M.a), this.c), 282.0f);  // color:transparent
        ArrayList arrayList0 = this.d;
        boolean z = ((p)(((l)object1))).i(arrayList0);
        int v = this.e;
        boolean z1 = ((p)(((l)object1))).e(v);
        Context context0 = this.f;
        boolean z2 = ((p)(((l)object1))).i(context0);
        boolean z3 = ((p)(((l)object1))).i(this.g);
        List list0 = this.h;
        boolean z4 = ((p)(((l)object1))).i(list0);
        List list1 = this.i;
        boolean z5 = ((p)(((l)object1))).i(list1);
        boolean z6 = ((p)(((l)object1))).d(f2);
        float f4 = this.j;
        boolean z7 = ((p)(((l)object1))).d(f4);
        I i0 = this.g;
        float f5 = this.k;
        boolean z8 = ((p)(((l)object1))).d(f5);
        boolean z9 = ((p)(((l)object1))).d(f1);
        float f6 = this.l;
        boolean z10 = ((p)(((l)object1))).d(f6);
        Z z11 = this.o;
        boolean z12 = ((p)(((l)object1))).h(false);
        boolean z13 = ((p)(((l)object1))).i(g0);
        boolean z14 = ((p)(((l)object1))).d(this.m);
        boolean z15 = this.n;
        boolean z16 = ((p)(((l)object1))).h(z15);
        Object object3 = ((p)(((l)object1))).N();
        if((z | z1 | z2 | z3 | z4 | z5 | z6 | z7 | z8 | z9 | z10 | z12 | z13 | z14 | z16) != 0 || object3 == k.a) {
            b0 = new B(arrayList0, g0, z15, context0, i0, v, list0, list1, f2, f4, f5, f1, f6, z11, f3, this.r);
            ((p)(((l)object1))).l0(b0);
        }
        else {
            b0 = object3;
        }
        androidx.compose.foundation.q.b(q0, b0, ((p)(((l)object1))), 0);
        return H.a;
    }
}

