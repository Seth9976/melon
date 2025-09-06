package zc;

import Cc.e0;
import F.E;
import android.content.Context;
import androidx.compose.foundation.Q0;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.I0;
import androidx.compose.runtime.Z;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.q;
import r0.n;
import we.o;
import y0.M;

public final class f implements o {
    public final float a;
    public final Q0 b;
    public final float c;
    public final k d;
    public final ArrayList e;
    public final List f;
    public final Context g;
    public final List h;
    public final float i;
    public final float j;
    public final float k;
    public final int l;
    public final Z m;

    public f(float f, Q0 q00, float f1, k k0, ArrayList arrayList0, List list0, Context context0, List list1, float f2, float f3, float f4, int v, Z z0) {
        this.a = f;
        this.b = q00;
        this.c = f1;
        this.d = k0;
        this.e = arrayList0;
        this.f = list0;
        this.g = context0;
        this.h = list1;
        this.i = f2;
        this.j = f3;
        this.k = f4;
        this.l = v;
        this.m = z0;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        g g0;
        ((Integer)object2).getClass();
        q.g(((E)object0), "$this$AnimatedVisibility");
        int v = ViewUtilsKt.dpToPx(3);
        int v1 = ViewUtilsKt.dpToPx(1);
        int v2 = ViewUtilsKt.dpToPx(5);
        int v3 = ViewUtilsKt.dpToPx(2);
        float f = ((I0)this.m).m();
        float f1 = this.a;
        float f2 = f + f1;
        r0.q q0 = d.q(androidx.compose.foundation.q.f(androidx.compose.foundation.q.u(n.a, this.b, true, false), e0.T(((l)object1), 0x7F06048A), M.a), this.c);  // color:transparent
        k k0 = this.d;
        r0.q q1 = d.h(q0, k0.b);
        boolean z = ((p)(((l)object1))).i(this.e);
        boolean z1 = ((p)(((l)object1))).i(this.f);
        Z z2 = this.m;
        Context context0 = this.g;
        boolean z3 = ((p)(((l)object1))).i(context0);
        boolean z4 = ((p)(((l)object1))).i(k0);
        List list0 = this.h;
        boolean z5 = ((p)(((l)object1))).i(list0);
        float f3 = this.i;
        boolean z6 = ((p)(((l)object1))).d(f3);
        boolean z7 = ((p)(((l)object1))).d(f2);
        float f4 = this.j;
        boolean z8 = ((p)(((l)object1))).d(f4);
        List list1 = this.f;
        float f5 = this.k;
        boolean z9 = ((p)(((l)object1))).d(f5);
        boolean z10 = ((p)(((l)object1))).d(f1);
        ArrayList arrayList0 = this.e;
        int v4 = this.l;
        boolean z11 = ((p)(((l)object1))).e(v4);
        boolean z12 = ((p)(((l)object1))).e(v);
        boolean z13 = ((p)(((l)object1))).e(v1);
        boolean z14 = ((p)(((l)object1))).e(v2);
        boolean z15 = ((p)(((l)object1))).e(v3);
        Object object3 = ((p)(((l)object1))).N();
        if((z | z1 | z3 | z4 | z5 | z6 | z7 | z8 | z9 | z10 | z11 | z12 | z13 | z14 | z15) != 0 || object3 == androidx.compose.runtime.k.a) {
            g0 = new g(arrayList0, list1, context0, k0, list0, f3, f2, f4, f5, f1, v4, v, v1, v2, v3, z2);
            ((p)(((l)object1))).l0(g0);
        }
        else {
            g0 = object3;
        }
        androidx.compose.foundation.q.b(q1, g0, ((p)(((l)object1))), 0);
        return H.a;
    }
}

