package androidx.compose.runtime;

import Df.u;
import Q5.h;
import Sf.i;
import Sf.l;
import android.os.Trace;
import androidx.collection.F;
import androidx.collection.K;
import androidx.collection.L;
import androidx.collection.N;
import androidx.collection.z;
import d5.t;
import f0.a;
import g0.e;
import i.n.i.b.a.s.e.M3;
import ie.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import je.y;
import jeb.synthetic.FIN;
import m0.b;

public final class v implements r {
    public final V B;
    public final p D;
    public boolean E;
    public final s a;
    public final u b;
    public final AtomicReference c;
    public final Object d;
    public final N e;
    public final B0 f;
    public final K g;
    public final L h;
    public final L i;
    public final K j;
    public final a k;
    public final a l;
    public final K m;
    public K n;
    public boolean o;
    public v r;
    public int w;

    public v(s s0, u u0) {
        this.a = s0;
        this.b = u0;
        this.c = new AtomicReference(null);
        this.d = new Object();
        N n0 = new N(new L());
        this.e = n0;
        B0 b00 = new B0();
        if(s0.c()) {
            b00.k = new z();
        }
        if(s0.e()) {
            b00.g();
        }
        this.f = b00;
        this.g = t.f();
        this.h = new L();
        this.i = new L();
        this.j = t.f();
        a a0 = new a();
        this.k = a0;
        a a1 = new a();
        this.l = a1;
        this.m = t.f();
        this.n = t.f();
        this.B = new V(7);
        p p0 = new p(u0, s0, b00, n0, a0, a1, this);
        s0.l(p0);
        this.D = p0;
    }

    @Override  // androidx.compose.runtime.r
    public final void a() {
        synchronized(this.d) {
            if(this.D.E) {
                j0.b("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
            }
            if(!this.E) {
                this.E = true;
                a a0 = this.D.K;
                if(a0 != null) {
                    this.f(a0);
                }
                boolean z = this.f.b > 0;
                if(z || !this.e.a.g()) {
                    h h0 = new h(this.e);
                    if(z) {
                        E0 e00 = this.f.k();
                        try {
                            q.g(e00, h0);
                        }
                        catch(Throwable throwable0) {
                            e00.e(false);
                            throw throwable0;
                        }
                        e00.e(true);
                        this.b.b();
                        this.b.g();
                        h0.d();
                    }
                    h0.c();
                }
                this.D.getClass();
                Trace.beginSection("Compose:Composer.dispose");
                try {
                    this.D.b.o(this.D);
                    this.D.D.clear();
                    this.D.r.clear();
                    this.D.e.g.H();
                    this.D.u = null;
                    this.D.a.b();
                }
                catch(Throwable throwable1) {
                    Trace.endSection();
                    throw throwable1;
                }
                Trace.endSection();
            }
        }
        this.a.p(this);
    }

    public final void b() {
        this.c.set(null);
        this.k.g.H();
        this.l.g.H();
        N n0 = this.e;
        if(!n0.a.g()) {
            new ArrayList();
            if(!n0.a.g()) {
                Trace.beginSection("Compose:abandons");
                try {
                    i i0 = new i(n0);
                    l l0 = (l)i0.c;
                    while(l0.hasNext()) {
                        w0 w00 = (w0)l0.next();
                        i0.remove();
                        w00.d();
                    }
                }
                finally {
                    Trace.endSection();
                }
            }
        }
    }

    public final void c(Object object0, boolean z) {
        Object object1 = this.g.g(object0);
        if(object1 != null) {
            L l0 = this.h;
            L l1 = this.i;
            K k0 = this.m;
            if(object1 instanceof L) {
                Object[] arr_object = ((L)object1).b;
                long[] arr_v = ((L)object1).a;
                int v = arr_v.length - 2;
                if(v >= 0) {
                    int v1 = 0;
                    while(true) {
                        long v2 = arr_v[v1];
                        if((~v2 << 7 & v2 & 0x8080808080808080L) == 0x8080808080808080L) {
                            goto label_27;
                        }
                        int v3 = 8 - (~(v1 - v) >>> 0x1F);
                        for(int v4 = 0; v4 < v3; ++v4) {
                            if((0xFFL & v2) < 0x80L) {
                                n0 n00 = (n0)arr_object[(v1 << 3) + v4];
                                if(!t.o(k0, object0, n00) && n00.c(object0) != P.a) {
                                    if(n00.g == null || z) {
                                        l0.a(n00);
                                    }
                                    else {
                                        l1.a(n00);
                                    }
                                }
                            }
                            v2 >>= 8;
                        }
                        if(v3 == 8) {
                        label_27:
                            if(v1 != v) {
                                ++v1;
                                continue;
                            }
                        }
                        break;
                    }
                }
            }
            else if(!t.o(k0, object0, ((n0)object1)) && ((n0)object1).c(object0) != P.a) {
                if(((n0)object1).g != null && !z) {
                    l1.a(((n0)object1));
                    return;
                }
                l0.a(((n0)object1));
            }
        }
    }

    public final void d(Set set0, boolean z) {
        boolean z2;
        long v46;
        long v40;
        long[] arr_v13;
        long[] arr_v10;
        boolean z1;
        long v32;
        int v30;
        int v27;
        long[] arr_v9;
        long v24;
        L l0;
        K k1;
        long[] arr_v3;
        long[] arr_v2;
        long v9;
        int v6;
        K k0 = this.j;
        if(set0 instanceof g0.h) {
            Object[] arr_object = ((g0.h)set0).a.b;
            long[] arr_v = ((g0.h)set0).a.a;
            int v = arr_v.length - 2;
            if(v >= 0) {
                int v1 = 0;
                while(true) {
                    long v2 = arr_v[v1];
                    if((~v2 << 7 & v2 & 0x8080808080808080L) == 0x8080808080808080L) {
                        goto label_71;
                    }
                    int v3 = 8 - (~(v1 - v) >>> 0x1F);
                    int v4 = 0;
                    while(v4 < v3) {
                        if((v2 & 0xFFL) < 0x80L) {
                            Object object0 = arr_object[(v1 << 3) + v4];
                            if(object0 instanceof n0) {
                                ((n0)object0).c(null);
                                goto label_56;
                            }
                            else {
                                this.c(object0, z);
                                Object object1 = k0.g(object0);
                                if(object1 == null) {
                                label_56:
                                    arr_v3 = arr_v;
                                    v9 = v2;
                                    v6 = v;
                                }
                                else if(object1 instanceof L) {
                                    Object[] arr_object1 = ((L)object1).b;
                                    long[] arr_v1 = ((L)object1).a;
                                    int v5 = arr_v1.length - 2;
                                    if(v5 >= 0) {
                                        v6 = v;
                                        int v7 = 0;
                                        while(true) {
                                            long v8 = arr_v1[v7];
                                            v9 = v2;
                                            if((~v8 << 7 & v8 & 0x8080808080808080L) == 0x8080808080808080L) {
                                                goto label_45;
                                            }
                                            int v10 = 8 - (~(v7 - v5) >>> 0x1F);
                                            int v11 = 0;
                                            while(v11 < v10) {
                                                if((v8 & 0xFFL) < 0x80L) {
                                                    arr_v2 = arr_v;
                                                    this.c(((E)arr_object1[(v7 << 3) + v11]), z);
                                                }
                                                else {
                                                    arr_v2 = arr_v;
                                                }
                                                v8 >>= 8;
                                                ++v11;
                                                arr_v = arr_v2;
                                            }
                                            arr_v3 = arr_v;
                                            if(v10 == 8) {
                                                goto label_46;
                                            label_45:
                                                arr_v3 = arr_v;
                                            label_46:
                                                if(v7 != v5) {
                                                    ++v7;
                                                    v2 = v9;
                                                    arr_v = arr_v3;
                                                    continue;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                    else {
                                        goto label_56;
                                    }
                                }
                                else {
                                    arr_v3 = arr_v;
                                    v9 = v2;
                                    v6 = v;
                                    this.c(((E)object1), z);
                                }
                            }
                        }
                        else {
                            arr_v3 = arr_v;
                            v9 = v2;
                            v6 = v;
                        }
                        v2 = v9 >> 8;
                        ++v4;
                        v = v6;
                        arr_v = arr_v3;
                    }
                    long[] arr_v4 = arr_v;
                    if(v3 == 8) {
                        goto label_72;
                    label_71:
                        arr_v4 = arr_v;
                    label_72:
                        if(v1 == v) {
                            goto label_107;
                        }
                        else {
                            ++v1;
                            arr_v = arr_v4;
                            continue;
                        }
                    }
                    else {
                        goto label_107;
                    }
                    break;
                }
            }
            else {
                goto label_107;
            }
        }
        else {
            Iterator iterator0 = set0.iterator();
        label_77:
            while(iterator0.hasNext()) {
                Object object2 = iterator0.next();
                if(object2 instanceof n0) {
                    ((n0)object2).c(null);
                }
                else {
                    this.c(object2, z);
                    Object object3 = k0.g(object2);
                    if(object3 != null) {
                        if(object3 instanceof L) {
                            Object[] arr_object2 = ((L)object3).b;
                            long[] arr_v5 = ((L)object3).a;
                            int v12 = arr_v5.length - 2;
                            if(v12 < 0) {
                                continue;
                            }
                            int v13 = 0;
                            while(true) {
                                long v14 = arr_v5[v13];
                                if((~v14 << 7 & v14 & 0x8080808080808080L) != 0x8080808080808080L) {
                                    int v15 = 8 - (~(v13 - v12) >>> 0x1F);
                                    for(int v16 = 0; v16 < v15; ++v16) {
                                        if((v14 & 0xFFL) < 0x80L) {
                                            this.c(((E)arr_object2[(v13 << 3) + v16]), z);
                                        }
                                        v14 >>= 8;
                                    }
                                    if(v15 == 8) {
                                        goto label_102;
                                    }
                                    continue label_77;
                                }
                            label_102:
                                if(v13 == v12) {
                                    continue label_77;
                                }
                                ++v13;
                            }
                        }
                        this.c(((E)object3), z);
                    }
                }
            }
        label_107:
            k1 = this.g;
            l0 = this.h;
            if(z) {
                L l1 = this.i;
                if(l1.h()) {
                    long[] arr_v6 = k1.a;
                    int v17 = arr_v6.length - 2;
                    if(v17 >= 0) {
                        int v18 = 0;
                        while(true) {
                            long v19 = arr_v6[v18];
                            if((~v19 << 7 & v19 & 0x8080808080808080L) == 0x8080808080808080L) {
                                arr_v10 = arr_v6;
                            }
                            else {
                                int v20 = 8 - (~(v18 - v17) >>> 0x1F);
                                int v21 = 0;
                                while(v21 < v20) {
                                    if((v19 & 0xFFL) < 0x80L) {
                                        int v22 = (v18 << 3) + v21;
                                        Object object4 = k1.b[v22];
                                        Object object5 = k1.c[v22];
                                        if(object5 instanceof L) {
                                            kotlin.jvm.internal.q.e(object5, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                            L l2 = (L)object5;
                                            long[] arr_v7 = l2.a;
                                            Object[] arr_object3 = l2.b;
                                            int v23 = arr_v7.length - 2;
                                            if(v23 >= 0) {
                                                long[] arr_v8 = arr_v7;
                                                v24 = v19;
                                                int v25 = 0;
                                                while(true) {
                                                    long v26 = arr_v8[v25];
                                                    arr_v9 = arr_v6;
                                                    v27 = v17;
                                                    if((~v26 << 7 & v26 & 0x8080808080808080L) == 0x8080808080808080L) {
                                                        goto label_156;
                                                    }
                                                    int v28 = 8 - (~(v25 - v23) >>> 0x1F);
                                                    for(int v29 = 0; v29 < v28; v29 = v30 + 1) {
                                                        if((v26 & 0xFFL) < 0x80L) {
                                                            v30 = v29;
                                                            int v31 = (v25 << 3) + v30;
                                                            v32 = v26;
                                                            n0 n00 = (n0)arr_object3[v31];
                                                            if(l1.c(n00) || l0.c(n00)) {
                                                                l2.m(v31);
                                                            }
                                                        }
                                                        else {
                                                            v30 = v29;
                                                            v32 = v26;
                                                        }
                                                        v26 = v32 >> 8;
                                                    }
                                                    if(v28 == 8) {
                                                    label_156:
                                                        if(v25 != v23) {
                                                            ++v25;
                                                            v17 = v27;
                                                            arr_v6 = arr_v9;
                                                            continue;
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                            else {
                                                arr_v9 = arr_v6;
                                                v27 = v17;
                                                v24 = v19;
                                            }
                                            z1 = l2.g();
                                        }
                                        else {
                                            arr_v9 = arr_v6;
                                            v27 = v17;
                                            v24 = v19;
                                            kotlin.jvm.internal.q.e(object5, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                            z1 = l1.c(((n0)object5)) || l0.c(((n0)object5));
                                        }
                                        if(z1) {
                                            k1.k(v22);
                                        }
                                    }
                                    else {
                                        arr_v9 = arr_v6;
                                        v27 = v17;
                                        v24 = v19;
                                    }
                                    v19 = v24 >> 8;
                                    ++v21;
                                    v17 = v27;
                                    arr_v6 = arr_v9;
                                }
                                arr_v10 = arr_v6;
                                if(v20 != 8) {
                                    break;
                                }
                            }
                            if(v18 == v17) {
                                break;
                            }
                            ++v18;
                            arr_v6 = arr_v10;
                        }
                    }
                    l1.b();
                    this.i();
                    return;
                }
            }
        }
        if(l0.h()) {
            long[] arr_v11 = k1.a;
            int v33 = arr_v11.length - 2;
            if(v33 >= 0) {
                int v34 = 0;
                while(true) {
                    long v35 = arr_v11[v34];
                    if((~v35 << 7 & v35 & 0x8080808080808080L) == 0x8080808080808080L) {
                        goto label_256;
                    }
                    int v36 = 8 - (~(v34 - v33) >>> 0x1F);
                    int v37 = 0;
                    while(v37 < v36) {
                        if((v35 & 0xFFL) < 0x80L) {
                            int v38 = (v34 << 3) + v37;
                            Object object6 = k1.b[v38];
                            Object object7 = k1.c[v38];
                            if(object7 instanceof L) {
                                kotlin.jvm.internal.q.e(object7, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                L l3 = (L)object7;
                                Object[] arr_object4 = l3.b;
                                long[] arr_v12 = l3.a;
                                int v39 = arr_v12.length - 2;
                                arr_v13 = arr_v11;
                                if(v39 >= 0) {
                                    v40 = v35;
                                    int v41 = 0;
                                    while(true) {
                                        long v42 = arr_v12[v41];
                                        Object[] arr_object5 = arr_object4;
                                        if((~v42 << 7 & v42 & 0x8080808080808080L) == 0x8080808080808080L) {
                                            goto label_234;
                                        }
                                        int v43 = 8 - (~(v41 - v39) >>> 0x1F);
                                        int v44 = 0;
                                        while(v44 < v43) {
                                            if((v42 & 0xFFL) < 0x80L) {
                                                int v45 = (v41 << 3) + v44;
                                                v46 = v42;
                                                if(l0.c(((n0)arr_object5[v45]))) {
                                                    l3.m(v45);
                                                }
                                            }
                                            else {
                                                v46 = v42;
                                            }
                                            ++v44;
                                            v42 = v46 >> 8;
                                        }
                                        if(v43 == 8) {
                                        label_234:
                                            if(v41 != v39) {
                                                ++v41;
                                                continue;
                                            }
                                        }
                                        break;
                                    }
                                }
                                else {
                                    v40 = v35;
                                }
                                z2 = l3.g();
                            }
                            else {
                                arr_v13 = arr_v11;
                                v40 = v35;
                                kotlin.jvm.internal.q.e(object7, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                z2 = l0.c(((n0)object7));
                            }
                            if(z2) {
                                k1.k(v38);
                            }
                        }
                        else {
                            arr_v13 = arr_v11;
                            v40 = v35;
                        }
                        ++v37;
                        v35 = v40 >> 8;
                        arr_v11 = arr_v13;
                    }
                    long[] arr_v14 = arr_v11;
                    if(v36 == 8) {
                        goto label_257;
                    label_256:
                        arr_v14 = arr_v11;
                    label_257:
                        if(v34 != v33) {
                            ++v34;
                            arr_v11 = arr_v14;
                            continue;
                        }
                        this.i();
                        l0.b();
                        return;
                    }
                    break;
                }
            }
            this.i();
            l0.b();
        }
    }

    public final void e() {
        Object object0 = this.d;
        __monitor_enter(object0);
        try {
            this.f(this.k);
            this.n();
        }
        catch(Throwable throwable0) {
            try {
                try {
                    if(!this.e.a.g()) {
                        N n0 = this.e;
                        new ArrayList();
                        if(!n0.a.g()) {
                            Trace.beginSection("Compose:abandons");
                            try {
                                i i0 = new i(n0);
                                while(((l)i0.c).hasNext()) {
                                    w0 w00 = (w0)((l)i0.c).next();
                                    i0.remove();
                                    w00.d();
                                }
                            }
                            finally {
                                Trace.endSection();
                            }
                        }
                    }
                    throw throwable0;
                }
                catch(Exception exception0) {
                }
                this.b();
                throw exception0;
            }
            catch(Throwable throwable1) {
            }
            __monitor_exit(object0);
            throw throwable1;
        }
        __monitor_exit(object0);
    }

    public final void f(a a0) {
        boolean z;
        long v15;
        long[] arr_v2;
        int v12;
        E0 e00;
        u u0;
        int v;
        a a1 = this.l;
        h h0 = new h(this.e);
        try {
            if(a0.g.J()) {
                goto label_122;
            }
            else {
                Trace.beginSection("Compose:applyChanges");
                v = FIN.finallyOpen$NT();
                u0 = this.b;
                e00 = this.f.k();
                goto label_7;
            }
            return;
        }
        catch(Throwable throwable0) {
            goto label_116;
        }
        try {
        label_7:
            a0.H(u0, e00, h0);
            goto label_13;
        }
        catch(Throwable throwable1) {
            try {
                e00.e(false);
                FIN.finallyExec$NT(v);
                throw throwable1;
            label_13:
                e00.e(true);
                u0.g();
                FIN.finallyCodeBegin$NT(v);
                Trace.endSection();
                FIN.finallyCodeEnd$NT(v);
                h0.d();
                e e0 = (e)h0.e;
                if(e0.c != 0) {
                    Trace.beginSection("Compose:sideeffects");
                    try {
                        Object[] arr_object = e0.a;
                        int v2 = e0.c;
                        for(int v3 = 0; v3 < v2; ++v3) {
                            ((we.a)arr_object[v3]).invoke();
                        }
                        e0.g();
                    }
                    finally {
                        Trace.endSection();
                    }
                }
                if(this.o) {
                    Trace.beginSection("Compose:unobserve");
                    try {
                        this.o = false;
                        K k0 = this.g;
                        long[] arr_v = k0.a;
                        int v5 = arr_v.length - 2;
                        if(v5 >= 0) {
                            int v6 = 0;
                            while(true) {
                                long v7 = arr_v[v6];
                                if((~v7 << 7 & v7 & 0x8080808080808080L) == 0x8080808080808080L) {
                                    goto label_103;
                                }
                                int v8 = 8 - (~(v6 - v5) >>> 0x1F);
                                int v9 = 0;
                                while(v9 < v8) {
                                    if((v7 & 0xFFL) < 0x80L) {
                                        int v10 = (v6 << 3) + v9;
                                        Object object0 = k0.b[v10];
                                        Object object1 = k0.c[v10];
                                        if(object1 instanceof L) {
                                            kotlin.jvm.internal.q.e(object1, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                            L l0 = (L)object1;
                                            Object[] arr_object1 = l0.b;
                                            long[] arr_v1 = l0.a;
                                            int v11 = arr_v1.length - 2;
                                            v12 = v9;
                                            arr_v2 = arr_v;
                                            if(v11 >= 0) {
                                                long[] arr_v3 = arr_v1;
                                                int v13 = 0;
                                                while(true) {
                                                    long v14 = arr_v3[v13];
                                                    v15 = v7;
                                                    if((~v14 << 7 & v14 & 0x8080808080808080L) == 0x8080808080808080L) {
                                                        goto label_77;
                                                    }
                                                    int v16 = 8 - (~(v13 - v11) >>> 0x1F);
                                                    for(int v17 = 0; v17 < v16; ++v17) {
                                                        if((v14 & 0xFFL) < 0x80L) {
                                                            int v18 = (v13 << 3) + v17;
                                                            if(!((n0)arr_object1[v18]).b()) {
                                                                l0.m(v18);
                                                            }
                                                        }
                                                        v14 >>= 8;
                                                    }
                                                    if(v16 == 8) {
                                                    label_77:
                                                        if(v13 != v11) {
                                                            ++v13;
                                                            v7 = v15;
                                                            continue;
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                            else {
                                                v15 = v7;
                                            }
                                            z = l0.g();
                                        }
                                        else {
                                            v12 = v9;
                                            arr_v2 = arr_v;
                                            v15 = v7;
                                            kotlin.jvm.internal.q.e(object1, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                            z = !((n0)object1).b();
                                        }
                                        if(z) {
                                            k0.k(v10);
                                        }
                                    }
                                    else {
                                        v12 = v9;
                                        arr_v2 = arr_v;
                                        v15 = v7;
                                    }
                                    v7 = v15 >> 8;
                                    v9 = v12 + 1;
                                    arr_v = arr_v2;
                                }
                                long[] arr_v4 = arr_v;
                                if(v8 == 8) {
                                label_104:
                                    if(v6 != v5) {
                                        ++v6;
                                        arr_v = arr_v4;
                                        continue;
                                    }
                                    break;
                                }
                                else {
                                    this.i();
                                    goto label_111;
                                label_103:
                                    arr_v4 = arr_v;
                                    goto label_104;
                                }
                                goto label_111;
                            }
                        }
                        this.i();
                    }
                    finally {
                        Trace.endSection();
                    }
                }
            label_111:
                goto label_119;
            }
            catch(Throwable throwable0) {
            }
        }
    label_116:
        if(a1.g.J()) {
            h0.c();
        }
        throw throwable0;
    label_119:
        if(a1.g.J()) {
            h0.c();
            return;
        label_122:
            if(a1.g.J()) {
                h0.c();
            }
        }
    }

    public final void g() {
        Object object0 = this.d;
        __monitor_enter(object0);
        try {
            if(this.l.g.K()) {
                this.f(this.l);
            }
        }
        catch(Throwable throwable0) {
            try {
                try {
                    if(!this.e.a.g()) {
                        N n0 = this.e;
                        new ArrayList();
                        if(!n0.a.g()) {
                            Trace.beginSection("Compose:abandons");
                            try {
                                i i0 = new i(n0);
                                while(((l)i0.c).hasNext()) {
                                    w0 w00 = (w0)((l)i0.c).next();
                                    i0.remove();
                                    w00.d();
                                }
                            }
                            finally {
                                Trace.endSection();
                            }
                        }
                    }
                    throw throwable0;
                }
                catch(Exception exception0) {
                }
                this.b();
                throw exception0;
            }
            catch(Throwable throwable1) {
            }
            __monitor_exit(object0);
            throw throwable1;
        }
        __monitor_exit(object0);
    }

    public final void h() {
        Object object0 = this.d;
        __monitor_enter(object0);
        try {
            this.D.u = null;
            if(!this.e.a.g()) {
                N n0 = this.e;
                new ArrayList();
                if(!n0.a.g()) {
                    Trace.beginSection("Compose:abandons");
                    try {
                        i i0 = new i(n0);
                        while(((l)i0.c).hasNext()) {
                            w0 w00 = (w0)((l)i0.c).next();
                            i0.remove();
                            w00.d();
                        }
                    }
                    finally {
                        Trace.endSection();
                    }
                }
            }
        }
        catch(Throwable throwable0) {
            try {
                try {
                    if(!this.e.a.g()) {
                        N n1 = this.e;
                        new ArrayList();
                        if(!n1.a.g()) {
                            Trace.beginSection("Compose:abandons");
                            try {
                                i i1 = new i(n1);
                                while(((l)i1.c).hasNext()) {
                                    w0 w01 = (w0)((l)i1.c).next();
                                    i1.remove();
                                    w01.d();
                                }
                            }
                            finally {
                                Trace.endSection();
                            }
                        }
                    }
                    throw throwable0;
                }
                catch(Exception exception0) {
                }
                this.b();
                throw exception0;
            }
            catch(Throwable throwable1) {
            }
            __monitor_exit(object0);
            throw throwable1;
        }
        __monitor_exit(object0);
    }

    public final void i() {
        boolean z;
        long v14;
        int v12;
        long[] arr_v2;
        long v7;
        K k0 = this.j;
        long[] arr_v = k0.a;
        int v = arr_v.length - 2;
        if(v >= 0) {
            int v1 = 0;
            while(true) {
                long v2 = arr_v[v1];
                if((~v2 << 7 & v2 & 0x8080808080808080L) == 0x8080808080808080L) {
                    goto label_67;
                }
                int v3 = 8 - (~(v1 - v) >>> 0x1F);
                int v4 = 0;
                while(v4 < v3) {
                    if((v2 & 0xFFL) < 0x80L) {
                        int v5 = (v1 << 3) + v4;
                        Object object0 = k0.b[v5];
                        Object object1 = k0.c[v5];
                        K k1 = this.g;
                        if(object1 instanceof L) {
                            kotlin.jvm.internal.q.e(object1, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                            L l0 = (L)object1;
                            Object[] arr_object = l0.b;
                            long[] arr_v1 = l0.a;
                            int v6 = arr_v1.length - 2;
                            if(v6 >= 0) {
                                v7 = v2;
                                int v8 = 0;
                                while(true) {
                                    long v9 = arr_v1[v8];
                                    arr_v2 = arr_v;
                                    if((~v9 << 7 & v9 & 0x8080808080808080L) == 0x8080808080808080L) {
                                        goto label_43;
                                    }
                                    int v10 = 8 - (~(v8 - v6) >>> 0x1F);
                                    for(int v11 = 0; v11 < v10; v11 = v12 + 1) {
                                        if((v9 & 0xFFL) < 0x80L) {
                                            v12 = v11;
                                            int v13 = (v8 << 3) + v12;
                                            v14 = v9;
                                            if(!k1.c(((E)arr_object[v13]))) {
                                                l0.m(v13);
                                            }
                                        }
                                        else {
                                            v12 = v11;
                                            v14 = v9;
                                        }
                                        v9 = v14 >> 8;
                                    }
                                    if(v10 == 8) {
                                    label_43:
                                        if(v8 != v6) {
                                            ++v8;
                                            arr_v = arr_v2;
                                            continue;
                                        }
                                    }
                                    break;
                                }
                            }
                            else {
                                arr_v2 = arr_v;
                                v7 = v2;
                            }
                            z = l0.g();
                        }
                        else {
                            arr_v2 = arr_v;
                            v7 = v2;
                            kotlin.jvm.internal.q.e(object1, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                            z = !k1.c(((E)object1));
                        }
                        if(z) {
                            k0.k(v5);
                        }
                    }
                    else {
                        arr_v2 = arr_v;
                        v7 = v2;
                    }
                    v2 = v7 >> 8;
                    ++v4;
                    arr_v = arr_v2;
                }
                long[] arr_v3 = arr_v;
                if(v3 == 8) {
                    goto label_68;
                label_67:
                    arr_v3 = arr_v;
                label_68:
                    if(v1 != v) {
                        ++v1;
                        arr_v = arr_v3;
                        continue;
                    }
                }
                goto label_72;
            }
        }
        else {
        label_72:
            L l1 = this.i;
            if(l1.h()) {
                Object[] arr_object1 = l1.b;
                long[] arr_v4 = l1.a;
                int v15 = arr_v4.length - 2;
                if(v15 >= 0) {
                    int v16 = 0;
                    while(true) {
                        long v17 = arr_v4[v16];
                        if((~v17 << 7 & v17 & 0x8080808080808080L) != 0x8080808080808080L) {
                            int v18 = 8 - (~(v16 - v15) >>> 0x1F);
                            for(int v19 = 0; v19 < v18; ++v19) {
                                if((v17 & 0xFFL) < 0x80L) {
                                    int v20 = (v16 << 3) + v19;
                                    if(((n0)arr_object1[v20]).g == null) {
                                        l1.m(v20);
                                    }
                                }
                                v17 >>= 8;
                            }
                            if(v18 == 8) {
                                goto label_92;
                            }
                            break;
                        }
                    label_92:
                        if(v16 == v15) {
                            break;
                        }
                        ++v16;
                    }
                }
            }
        }
    }

    public final void j(b b0) {
        try {
            Object object0 = this.d;
            synchronized(object0) {
                this.m();
                K k0 = this.n;
                this.n = t.f();
                try {
                    this.B.getClass();
                    this.a.getClass();
                    p p0 = this.D;
                    if(!p0.e.g.J()) {
                        q.c("Expected applyChanges() to have been called");
                    }
                    p0.n(k0, b0);
                }
                catch(Exception exception0) {
                    this.n = k0;
                    throw exception0;
                }
            }
        }
        catch(Throwable throwable0) {
            try {
                if(!this.e.a.g()) {
                    N n0 = this.e;
                    new ArrayList();
                    if(!n0.a.g()) {
                        Trace.beginSection("Compose:abandons");
                        try {
                            i i0 = new i(n0);
                            while(((l)i0.c).hasNext()) {
                                w0 w00 = (w0)((l)i0.c).next();
                                i0.remove();
                                w00.d();
                            }
                        }
                        finally {
                            Trace.endSection();
                        }
                    }
                }
                throw throwable0;
            }
            catch(Exception exception1) {
            }
            this.b();
            throw exception1;
        }
    }

    public final void k(b b0) {
        if(this.E) {
            j0.b("The composition is disposed");
        }
        this.a.a(this, b0);
    }

    public final void l() {
        E0 e00;
        h h0;
        synchronized(this.d) {
            boolean z = this.f.b > 0;
            if(z || !this.e.a.g()) {
                Trace.beginSection("Compose:deactivate");
                try {
                    h0 = new h(this.e);
                    if(z) {
                        e00 = this.f.k();
                        goto label_9;
                    }
                    goto label_17;
                }
                catch(Throwable throwable0) {
                    Trace.endSection();
                    throw throwable0;
                }
                try {
                label_9:
                    q.e(e00, h0);
                    goto label_14;
                }
                catch(Throwable throwable1) {
                    try {
                        e00.e(false);
                        throw throwable1;
                    label_14:
                        e00.e(true);
                        this.b.g();
                        h0.d();
                    label_17:
                        h0.c();
                        goto label_23;
                    }
                    catch(Throwable throwable0) {
                    }
                }
                Trace.endSection();
                throw throwable0;
            label_23:
                Trace.endSection();
            }
            this.g.a();
            this.j.a();
            this.n.a();
            this.k.g.H();
            this.l.g.H();
            this.D.D.clear();
            this.D.r.clear();
            this.D.e.g.H();
            this.D.u = null;
        }
    }

    public final void m() {
        AtomicReference atomicReference0 = this.c;
        Object object0 = w.a;
        Object object1 = atomicReference0.getAndSet(object0);
        if(object1 != null) {
            if(!object1.equals(object0)) {
                if(object1 instanceof Set) {
                    this.d(((Set)object1), true);
                    return;
                }
                if(object1 instanceof Object[]) {
                    for(int v = 0; v < ((Set[])object1).length; ++v) {
                        this.d(((Set[])object1)[v], true);
                    }
                    return;
                }
                q.d(("corrupt pendingModifications drain: " + atomicReference0));
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            q.d("pending composition has not been applied");
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
    }

    public final void n() {
        AtomicReference atomicReference0 = this.c;
        Object object0 = atomicReference0.getAndSet(null);
        if(!kotlin.jvm.internal.q.b(object0, w.a)) {
            if(object0 instanceof Set) {
                this.d(((Set)object0), false);
                return;
            }
            if(object0 instanceof Object[]) {
                for(int v = 0; v < ((Set[])object0).length; ++v) {
                    this.d(((Set[])object0)[v], false);
                }
                return;
            }
            if(object0 == null) {
                q.d("calling recordModificationsOf and applyChanges concurrently is not supported");
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            q.d(("corrupt pendingModifications drain: " + atomicReference0));
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
    }

    public final void o() {
        AtomicReference atomicReference0 = this.c;
        Object object0 = atomicReference0.getAndSet(y.a);
        if(kotlin.jvm.internal.q.b(object0, w.a)) {
            return;
        }
        if(object0 == null) {
            return;
        }
        if(object0 instanceof Set) {
            this.d(((Set)object0), false);
            return;
        }
        if(object0 instanceof Object[]) {
            for(int v = 0; v < ((Set[])object0).length; ++v) {
                this.d(((Set[])object0)[v], false);
            }
            return;
        }
        q.d(("corrupt pendingModifications drain: " + atomicReference0));
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    public final void p(ArrayList arrayList0) {
        N n0 = this.e;
        if(arrayList0.size() <= 0) {
            try {
                p p0 = this.D;
                p0.getClass();
                try {
                    p0.E(arrayList0);
                }
                catch(Throwable throwable1) {
                    p0.a();
                    throw throwable1;
                }
                p0.j();
                return;
            }
            catch(Throwable throwable0) {
                try {
                    if(!n0.a.g()) {
                        new ArrayList();
                        if(!n0.a.g()) {
                            Trace.beginSection("Compose:abandons");
                            try {
                                i i0 = new i(n0);
                                l l0 = (l)i0.c;
                                while(l0.hasNext()) {
                                    w0 w00 = (w0)l0.next();
                                    i0.remove();
                                    w00.d();
                                }
                            }
                            finally {
                                Trace.endSection();
                            }
                        }
                    }
                    throw throwable0;
                }
                catch(Exception exception0) {
                    this.b();
                    throw exception0;
                }
            }
        }
        ((Y)((m)arrayList0.get(0)).a).getClass();
        throw null;
    }

    public final P q(n0 n00, Object object0) {
        int v = n00.a;
        if((v & 2) != 0) {
            n00.a = v | 4;
        }
        androidx.compose.runtime.a a0 = n00.c;
        if(a0 != null && a0.a()) {
            if(!this.f.l(a0)) {
                return this.r == null || (!this.r.D.E || !this.r.D.g0(n00, object0)) ? P.a : P.d;
            }
            return n00.d == null ? P.a : this.s(n00, a0, object0);
        }
        return P.a;
    }

    public final void r() {
        synchronized(this.d) {
            Object[] arr_object = this.f.c;
            for(int v1 = 0; v1 < arr_object.length; ++v1) {
                Object object1 = arr_object[v1];
                n0 n00 = object1 instanceof n0 ? ((n0)object1) : null;
                if(n00 != null) {
                    v v2 = n00.b;
                    if(v2 != null) {
                        v2.q(n00, null);
                    }
                }
            }
        }
    }

    public final P s(n0 n00, androidx.compose.runtime.a a0, Object object0) {
        v v1;
        Object object1 = this.d;
        __monitor_enter(object1);
        try {
            v v0 = this.r;
            v1 = null;
            if(v0 != null) {
                B0 b00 = this.f;
                int v2 = this.w;
                if(b00.g) {
                    q.c("Writer is active");
                }
                if(v2 < 0 || v2 >= b00.b) {
                    q.c("Invalid group index");
                }
                if(!b00.l(a0) || (v2 > a0.a || a0.a >= b00.a[v2 * 5 + 3] + v2)) {
                    v0 = null;
                }
                v1 = v0;
            }
            if(v1 == null) {
                if(this.D.E && this.D.g0(n00, object0)) {
                    goto label_59;
                }
                this.B.getClass();
                this.a.getClass();
                if(object0 == null) {
                    this.n.l(n00, V.e);
                }
                else if(object0 instanceof E) {
                    Object object2 = this.n.g(n00);
                    if(object2 == null) {
                        t.c(this.n, n00, object0);
                    }
                    else if(object2 instanceof L) {
                        Object[] arr_object = ((L)object2).b;
                        long[] arr_v = ((L)object2).a;
                        int v3 = arr_v.length - 2;
                        if(v3 >= 0) {
                            int v4 = 0;
                            while(true) {
                                long v5 = arr_v[v4];
                                if((~v5 << 7 & v5 & 0x8080808080808080L) != 0x8080808080808080L) {
                                    int v6 = 8 - (~(v4 - v3) >>> 0x1F);
                                    int v7 = 0;
                                    while(true) {
                                        if(v7 >= v6) {
                                            if(v6 == 8) {
                                                break;
                                            }
                                            t.c(this.n, n00, object0);
                                            goto label_61;
                                        }
                                        if((v5 & 0xFFL) < 0x80L && arr_object[(v4 << 3) + v7] == V.e) {
                                            goto label_61;
                                        }
                                        v5 >>= 8;
                                        ++v7;
                                    }
                                }
                                if(v4 == v3) {
                                    break;
                                }
                                ++v4;
                            }
                        }
                        t.c(this.n, n00, object0);
                    }
                    else if(object2 != V.e) {
                        t.c(this.n, n00, object0);
                    }
                }
                else {
                    this.n.l(n00, V.e);
                }
            }
            goto label_61;
        }
        catch(Throwable throwable0) {
        }
        __monitor_exit(object1);
        throw throwable0;
    label_59:
        __monitor_exit(object1);
        return P.d;
    label_61:
        __monitor_exit(object1);
        if(v1 != null) {
            return v1.s(n00, a0, object0);
        }
        this.a.i(this);
        return this.D.E ? P.c : P.b;
    }

    public final void t(Object object0) {
        Object object1 = this.g.g(object0);
        if(object1 != null) {
            K k0 = this.m;
            if(object1 instanceof L) {
                Object[] arr_object = ((L)object1).b;
                long[] arr_v = ((L)object1).a;
                int v = arr_v.length - 2;
                if(v >= 0) {
                    int v1 = 0;
                    while(true) {
                        long v2 = arr_v[v1];
                        if((~v2 << 7 & v2 & 0x8080808080808080L) == 0x8080808080808080L) {
                            goto label_22;
                        }
                        int v3 = 8 - (~(v1 - v) >>> 0x1F);
                        for(int v4 = 0; v4 < v3; ++v4) {
                            if((0xFFL & v2) < 0x80L) {
                                n0 n00 = (n0)arr_object[(v1 << 3) + v4];
                                if(n00.c(object0) == P.d) {
                                    t.c(k0, object0, n00);
                                }
                            }
                            v2 >>= 8;
                        }
                        if(v3 == 8) {
                        label_22:
                            if(v1 != v) {
                                ++v1;
                                continue;
                            }
                        }
                        break;
                    }
                }
            }
            else if(((n0)object1).c(object0) == P.d) {
                t.c(k0, object0, ((n0)object1));
            }
        }
    }

    public final boolean u(Set set0) {
        K k0 = this.j;
        K k1 = this.g;
        if(set0 instanceof g0.h) {
            Object[] arr_object = ((g0.h)set0).a.b;
            long[] arr_v = ((g0.h)set0).a.a;
            int v = arr_v.length - 2;
            if(v >= 0) {
                int v1 = 0;
                while(true) {
                    long v2 = arr_v[v1];
                    if((~v2 << 7 & v2 & 0x8080808080808080L) == 0x8080808080808080L) {
                        goto label_21;
                    }
                    int v3 = 8 - (~(v1 - v) >>> 0x1F);
                    for(int v4 = 0; v4 < v3; ++v4) {
                        if((0xFFL & v2) < 0x80L) {
                            Object object0 = arr_object[(v1 << 3) + v4];
                            if(k1.c(object0) || k0.c(object0)) {
                                return true;
                            }
                        }
                        v2 >>= 8;
                    }
                    if(v3 == 8) {
                    label_21:
                        if(v1 != v) {
                            ++v1;
                            continue;
                        }
                    }
                    break;
                }
            }
        }
        else {
            for(Object object1: set0) {
                if(k1.c(object1) || k0.c(object1)) {
                    return true;
                }
                if(false) {
                    break;
                }
            }
        }
        return false;
    }

    public final boolean v() {
        boolean z;
        synchronized(this.d) {
            this.m();
            try {
                K k0 = this.n;
                this.n = t.f();
                try {
                    this.B.getClass();
                    this.a.getClass();
                    z = this.D.H(k0);
                    if(!z) {
                        this.n();
                    }
                    return z;
                }
                catch(Exception exception0) {
                    this.n = k0;
                    throw exception0;
                }
            }
            catch(Throwable throwable0) {
                try {
                    if(!this.e.a.g()) {
                        N n0 = this.e;
                        new ArrayList();
                        if(!n0.a.g()) {
                            Trace.beginSection("Compose:abandons");
                            try {
                                i i0 = new i(n0);
                                while(((l)i0.c).hasNext()) {
                                    w0 w00 = (w0)((l)i0.c).next();
                                    i0.remove();
                                    w00.d();
                                }
                            }
                            finally {
                                Trace.endSection();
                            }
                        }
                    }
                    throw throwable0;
                }
                catch(Exception exception1) {
                }
                this.b();
                throw exception1;
            }
        }
    }

    public final void w(g0.h h0) {
        g0.h h1;
        while(true) {
            Object object0 = this.c.get();
            boolean z = true;
            if((object0 == null ? true : object0.equals(w.a))) {
                h1 = h0;
            }
            else if(object0 instanceof Set) {
                h1 = new Set[]{object0, h0};
            }
            else {
                if(!(object0 instanceof Object[])) {
                    break;
                }
                kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                kotlin.jvm.internal.q.g(((Set[])object0), "<this>");
                h1 = Arrays.copyOf(((Set[])object0), ((Set[])object0).length + 1);
                h1[((Set[])object0).length] = h0;
            }
            AtomicReference atomicReference0 = this.c;
            while(!atomicReference0.compareAndSet(object0, h1)) {
                if(atomicReference0.get() != object0) {
                    z = false;
                    break;
                }
                if(false) {
                    break;
                }
            }
            if(z) {
                if(object0 == null) {
                    synchronized(this.d) {
                        this.n();
                    }
                    return;
                }
                return;
            }
        }
        throw new IllegalStateException(("corrupt pendingModifications: " + this.c).toString());
    }

    public final void x(Object object0) {
        K k1;
        Object object1;
        int v3;
        p p0 = this.D;
        if(p0.z <= 0) {
            n0 n00 = p0.A();
            if(n00 != null) {
                int v = n00.a | 1;
                n00.a = v;
                if((v & 0x20) == 0) {
                    F f0 = n00.f;
                    if(f0 == null) {
                        f0 = new F();
                        n00.f = f0;
                    }
                    int v1 = n00.e;
                    int v2 = f0.c(object0);
                    if(v2 < 0) {
                        v2 = ~v2;
                        v3 = -1;
                    }
                    else {
                        v3 = f0.c[v2];
                    }
                    f0.b[v2] = object0;
                    f0.c[v2] = v1;
                    if(v3 != n00.e) {
                        goto label_21;
                    }
                }
                else {
                label_21:
                    if(object0 instanceof p0.u) {
                        ((p0.u)object0).k(1);
                    }
                    t.c(this.g, object0, n00);
                    if(object0 instanceof E) {
                        D d0 = ((E)object0).n();
                        K k0 = this.j;
                        t.p(k0, object0);
                        Object[] arr_object = d0.e.b;
                        long[] arr_v = d0.e.a;
                        int v4 = arr_v.length - 2;
                        if(v4 >= 0) {
                            int v5 = 0;
                            while(true) {
                                long v6 = arr_v[v5];
                                if((~v6 << 7 & v6 & 0x8080808080808080L) == 0x8080808080808080L) {
                                    goto label_47;
                                }
                                int v7 = 8 - (~(v5 - v4) >>> 0x1F);
                                for(int v8 = 0; v8 < v7; ++v8) {
                                    if((v6 & 0xFFL) < 0x80L) {
                                        p0.t t0 = (p0.t)arr_object[(v5 << 3) + v8];
                                        if(t0 instanceof p0.u) {
                                            ((p0.u)t0).k(1);
                                        }
                                        t.c(k0, t0, object0);
                                    }
                                    v6 >>= 8;
                                }
                                if(v7 == 8) {
                                label_47:
                                    if(v5 != v4) {
                                        ++v5;
                                        continue;
                                    }
                                }
                                goto label_50;
                            }
                        }
                        else {
                        label_50:
                            object1 = d0.f;
                            k1 = n00.g;
                            if(k1 == null) {
                                k1 = new K();
                                n00.g = k1;
                            }
                        }
                        k1.l(((E)object0), object1);
                    }
                }
            }
        }
    }

    public final void y(Object object0) {
        synchronized(this.d) {
            this.t(object0);
            Object object2 = this.j.g(object0);
            if(object2 != null) {
                if(object2 instanceof L) {
                    Object[] arr_object = ((L)object2).b;
                    long[] arr_v = ((L)object2).a;
                    int v1 = arr_v.length - 2;
                    if(v1 >= 0) {
                        int v2 = 0;
                        while(true) {
                            long v3 = arr_v[v2];
                            if((~v3 << 7 & v3 & 0x8080808080808080L) == 0x8080808080808080L) {
                                goto label_23;
                            }
                            int v4 = 8 - (~(v2 - v1) >>> 0x1F);
                            for(int v5 = 0; v5 < v4; ++v5) {
                                if((0xFFL & v3) < 0x80L) {
                                    this.t(((E)arr_object[(v2 << 3) + v5]));
                                }
                                v3 >>= 8;
                            }
                            if(v4 == 8) {
                            label_23:
                                if(v2 != v1) {
                                    ++v2;
                                    continue;
                                }
                            }
                            break;
                        }
                    }
                }
                else {
                    this.t(((E)object2));
                }
            }
        }
    }
}

