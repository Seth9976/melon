package X0;

import P0.I;
import Q0.u;
import a.a;
import a1.g;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import androidx.collection.A;
import androidx.collection.G;
import androidx.collection.m;
import androidx.collection.z;
import pc.t;
import s0.c;
import s0.e;

public final class q {
    public final I a;
    public final f b;
    public final m c;
    public final G d;

    public q(I i0, f f0, z z0) {
        this.a = i0;
        this.b = f0;
        this.c = z0;
        this.d = new G(2);
    }

    public final p a() {
        l l0 = new l();
        return new p(this.b, false, this.a, l0);
    }

    public final void b(I i0, l l0) {
        String s1;
        Object[] arr_object = this.d.a;
        int v = this.d.b;
        for(int v1 = 0; v1 < v; ++v1) {
            c c0 = (c)arr_object[v1];
            A a0 = c0.h;
            u u0 = c0.c;
            t t0 = c0.a;
            l l1 = i0.w();
            int v2 = i0.b;
            String s = null;
            if(l0 == null) {
                s1 = null;
            }
            else {
                Object object0 = l0.a.g(s.B);
                if(object0 == null) {
                    object0 = null;
                }
                if(((g)object0) != null) {
                    s1 = ((g)object0).b;
                }
            }
            if(l1 != null) {
                Object object1 = l1.a.g(s.B);
                if(object1 == null) {
                    object1 = null;
                }
                if(((g)object1) != null) {
                    s = ((g)object1).b;
                }
            }
            int v3 = 1;
            if(s1 != s) {
                if(s1 == null) {
                    t0.D(u0, v2, true);
                }
                else if(s == null) {
                    t0.D(u0, v2, false);
                }
                else if(kotlin.jvm.internal.q.b(((e)a.z(l1, s.q)), s0.m.a)) {
                    AutofillValue autofillValue0 = AutofillValue.forText(s.toString());
                    ((AutofillManager)t0.b).notifyValueChanged(u0, v2, autofillValue0);
                }
            }
            int v4 = l0 == null || !l0.a.b(s.p) ? 0 : 1;
            if(l1 == null || !l1.a.b(s.p)) {
                v3 = 0;
            }
            if(v4 != v3) {
                if(v3 == 0) {
                    a0.e(v2);
                }
                else {
                    a0.a(v2);
                }
            }
        }
    }
}

