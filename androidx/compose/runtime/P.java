package androidx.compose.runtime;

import F.e;
import P0.w;
import android.os.Trace;
import androidx.collection.F;
import androidx.collection.G;
import androidx.collection.K;
import androidx.collection.L;
import androidx.collection.N;
import androidx.collection.x;
import androidx.collection.z;
import androidx.compose.foundation.M0;
import d5.t;
import f0.B;
import f0.C;
import f0.D;
import f0.I;
import f0.J;
import f0.a;
import f0.b;
import f0.c;
import f0.n;
import f0.r;
import ie.H;
import ie.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import jeb.synthetic.FIN;
import m0.f;
import m0.g;
import q0.d;

public final class p implements l {
    public int A;
    public boolean B;
    public final o C;
    public final ArrayList D;
    public boolean E;
    public A0 F;
    public B0 G;
    public E0 H;
    public boolean I;
    public i0 J;
    public a K;
    public final b L;
    public androidx.compose.runtime.a M;
    public c N;
    public boolean O;
    public int P;
    public u Q;
    public final Df.u a;
    public final s b;
    public final B0 c;
    public final N d;
    public final a e;
    public final a f;
    public final v g;
    public final ArrayList h;
    public h0 i;
    public int j;
    public int k;
    public int l;
    public final w m;
    public int[] n;
    public x o;
    public boolean p;
    public boolean q;
    public final ArrayList r;
    public final w s;
    public i0 t;
    public z u;
    public boolean v;
    public final w w;
    public boolean x;
    public int y;
    public int z;

    public p(Df.u u0, s s0, B0 b00, N n0, a a0, a a1, v v0) {
        androidx.compose.runtime.a a2;
        this.a = u0;
        this.b = s0;
        this.c = b00;
        this.d = n0;
        this.e = a0;
        this.f = a1;
        this.g = v0;
        this.h = new ArrayList();
        this.m = new w();
        this.r = new ArrayList();
        this.s = new w();
        this.t = g.d;
        this.w = new w();
        this.y = -1;
        this.B = s0.e() || s0.c();
        this.C = new o(this, 0);
        this.D = new ArrayList();
        A0 a00 = b00.i();
        a00.c();
        this.F = a00;
        B0 b01 = new B0();
        if(s0.e()) {
            b01.g();
        }
        if(s0.c()) {
            b01.k = new z();
        }
        this.G = b01;
        E0 e00 = b01.k();
        e00.e(true);
        this.H = e00;
        this.L = new b(this, a0);
        A0 a01 = this.G.i();
        try {
            a2 = a01.a(0);
        }
        finally {
            a01.c();
        }
        this.M = a2;
        this.N = new c();
    }

    public final n0 A() {
        if(this.z == 0) {
            return this.D.isEmpty() ? null : ((n0)com.iloen.melon.utils.a.i(1, this.D));
        }
        return null;
    }

    public final boolean B() {
        if(this.D() && !this.v) {
            n0 n00 = this.A();
            return n00 != null && (n00.a & 4) != 0;
        }
        return true;
    }

    public final boolean C() {
        return this.O;
    }

    public final boolean D() {
        if(!this.O && !this.x && !this.v) {
            n0 n00 = this.A();
            return n00 != null && (n00.a & 8) == 0;
        }
        return false;
    }

    public final void E(ArrayList arrayList0) {
        a a0;
        b b0;
        try {
            b0 = this.L;
            a0 = b0.b;
            b0.b = this.f;
            this.f.g.L(f0.z.d);
            if(arrayList0.size() <= 0) {
                b0.b.g.L(n.d);
                b0.f = 0;
                b0.b = a0;
                return;
            }
            m m0 = (m)arrayList0.get(0);
            Y y0 = (Y)m0.b;
            ((Y)m0.a).getClass();
            throw null;
        }
        catch(Throwable throwable0) {
            b0.b = a0;
            throw throwable0;
        }
    }

    public final Object F() {
        V v0 = k.a;
        if(this.O) {
            if(!this.q) {
                return v0;
            }
            q.c("A call to createNode(), emitNode() or useNode() expected");
            return v0;
        }
        Object object0 = this.F.j();
        return this.x && !(object0 instanceof androidx.compose.runtime.m) ? v0 : object0;
    }

    public final int G(int v) {
        int v1 = this.F.n(v) + 1;
        int v2 = 0;
        while(v1 < v) {
            if(!this.F.h(v1)) {
                ++v2;
            }
            v1 += D0.a(v1, this.F.b);
        }
        return v2;
    }

    public final boolean H(K k0) {
        J j0 = this.e.g;
        if(!j0.J()) {
            q.c("Expected applyChanges() to have been called");
        }
        if(k0.e <= 0 && this.r.isEmpty()) {
            return false;
        }
        this.n(k0, null);
        return j0.K();
    }

    public final Object I(v v0, v v1, Integer integer0, List list0, we.a a0) {
        int v3;
        boolean z;
        Object object1;
        try {
            z = this.E;
            v3 = this.j;
            this.E = true;
            this.j = 0;
            int v4 = list0.size();
            for(int v5 = 0; v5 < v4; ++v5) {
                m m0 = (m)list0.get(v5);
                n0 n00 = (n0)m0.a;
                Object object0 = m0.b;
                if(object0 == null) {
                    this.g0(n00, null);
                }
                else {
                    this.g0(n00, object0);
                }
            }
            if(v0 == null) {
                object1 = a0.invoke();
            }
            else {
                int v6 = integer0 == null ? -1 : ((int)integer0);
                if(v1 == null || v1.equals(v0) || v6 < 0) {
                    object1 = a0.invoke();
                }
                else {
                    try {
                        v0.r = v1;
                        v0.w = v6;
                        object1 = a0.invoke();
                        v0.r = null;
                        v0.w = 0;
                    }
                    catch(Throwable throwable0) {
                        v0.r = null;
                        v0.w = 0;
                        throw throwable0;
                    }
                }
                if(object1 == null) {
                    object1 = a0.invoke();
                }
            }
            return object1;
        }
        finally {
            this.E = z;
            this.j = v3;
        }
    }

    public final void J() {
        O o3;
        int v34;
        H h0;
        boolean z3;
        n0 n02;
        int v27;
        int v26;
        int v17;
        long v16;
        n0 n01;
        boolean z2;
        O o0;
        boolean z = this.E;
        this.E = true;
        A0 a00 = this.F;
        int v = a00.i;
        int v1 = v * 5 + 3;
        int v2 = a00.b[v1] + v;
        int v3 = this.j;
        int v4 = this.P;
        int v5 = this.k;
        int v6 = this.l;
        ArrayList arrayList0 = this.r;
        int v7 = q.f(a00.g, arrayList0);
        if(v7 < 0) {
            v7 = -(v7 + 1);
        }
        if(v7 < arrayList0.size()) {
            o0 = (O)arrayList0.get(v7);
            if(o0.b >= v2) {
                o0 = null;
            }
        }
        else {
            o0 = null;
        }
        boolean z1 = false;
        int v8 = v;
        while(o0 != null) {
            n0 n00 = o0.a;
            int v9 = o0.b;
            int v10 = q.f(v9, arrayList0);
            if(v10 >= 0) {
                O o1 = (O)arrayList0.remove(v10);
            }
            Object object0 = o0.c;
            if(object0 == null) {
                n00.getClass();
            }
            else {
                K k0 = n00.g;
                if(k0 != null) {
                    if(object0 instanceof E) {
                        z2 = n0.a(((E)object0), k0);
                        n01 = n00;
                        goto label_75;
                    }
                    else if(object0 instanceof L) {
                        if(((L)object0).h()) {
                            Object[] arr_object = ((L)object0).b;
                            long[] arr_v = ((L)object0).a;
                            Object[] arr_object1 = arr_object;
                            int v11 = arr_v.length - 2;
                            if(v11 >= 0) {
                                long[] arr_v1 = arr_v;
                                int v12 = 0;
                                while(true) {
                                    long v13 = arr_v1[v12];
                                    n01 = n00;
                                    if((~v13 << 7 & v13 & 0x8080808080808080L) == 0x8080808080808080L) {
                                        goto label_63;
                                    }
                                    int v14 = 8 - (~(v12 - v11) >>> 0x1F);
                                    int v15 = 0;
                                    while(v15 < v14) {
                                        if((v13 & 0xFFL) < 0x80L) {
                                            Object object1 = arr_object1[(v12 << 3) + v15];
                                            if(object1 instanceof E && !n0.a(((E)object1), k0)) {
                                                v16 = v13;
                                                goto label_59;
                                            }
                                            else {
                                                goto label_74;
                                            }
                                            goto label_58;
                                        }
                                        else {
                                        label_58:
                                            v16 = v13;
                                        }
                                    label_59:
                                        v13 = v16 >> 8;
                                        ++v15;
                                    }
                                    if(v14 == 8) {
                                    label_63:
                                        if(v12 != v11) {
                                            ++v12;
                                            n00 = n01;
                                            continue;
                                        }
                                    }
                                    break;
                                }
                            }
                            else {
                                n01 = n00;
                            }
                        }
                        else {
                            n01 = n00;
                        }
                        z2 = false;
                        goto label_75;
                    }
                }
            }
            n01 = n00;
        label_74:
            z2 = true;
        label_75:
            if(z2) {
                this.F.o(v9);
                v17 = this.F.g;
                this.M(v8, v17, v);
                int v18;
                for(v18 = this.F.n(v17); v18 != v && !this.F.i(v18); v18 = this.F.n(v18)) {
                }
                int v19 = this.F.i(v18) ? 0 : v3;
                if(v18 != v17) {
                    int v20 = this.n0(v18) - this.F.l(v17) + v19;
                label_86:
                    while(v19 < v20 && v18 != v9) {
                        ++v18;
                        while(true) {
                            if(v18 >= v9) {
                                break label_86;
                            }
                            A0 a01 = this.F;
                            int v21 = a01.b[v18 * 5 + 3] + v18;
                            if(v9 >= v21) {
                                v19 += (a01.i(v18) ? 1 : this.n0(v18));
                                v18 = v21;
                                continue;
                            }
                            if(false) {
                                break label_86;
                            }
                            continue label_86;
                        }
                    }
                }
                this.j = v19;
                this.l = this.G(v17);
                int v22 = this.F.n(v17);
                int v23 = 3;
                int v24 = 0;
                int v25 = 0;
                while(v22 >= 0) {
                    if(v22 == v) {
                        v26 = Integer.rotateLeft(v4, v25);
                    }
                    else {
                        A0 a02 = this.F;
                        int[] arr_v2 = a02.b;
                        if(a02.h(v22)) {
                            Object object2 = a02.m(v22, arr_v2);
                            if(object2 == null) {
                                v27 = 0;
                            }
                            else if(object2 instanceof Enum) {
                                v27 = ((Enum)object2).ordinal();
                            }
                            else {
                                v27 = object2.hashCode();
                            }
                        }
                        else {
                            int v28 = arr_v2[v22 * 5];
                            if(v28 == 0xCF) {
                                Object object3 = a02.b(v22, arr_v2);
                                if(object3 != null && !object3.equals(k.a)) {
                                    v27 = object3.hashCode();
                                    goto label_125;
                                }
                            }
                            v27 = v28;
                        }
                    label_125:
                        if(v27 == 0x78CC281) {
                            v26 = Integer.rotateLeft(0x78CC281, v25);
                        }
                        else {
                            goto label_129;
                        }
                    }
                    v24 ^= v26;
                    break;
                label_129:
                    v24 = v24 ^ Integer.rotateLeft(v27, v23) ^ Integer.rotateLeft((this.F.h(v22) ? 0 : this.G(v22)), v25);
                    v23 = (v23 + 6) % 0x20;
                    v25 = (v25 + 6) % 0x20;
                    v22 = this.F.n(v22);
                }
                this.P = v24;
                this.J = null;
                if(this.x) {
                    n02 = n01;
                }
                else {
                    n02 = n01;
                    if((n02.a & 0x80) != 0) {
                        z3 = true;
                        goto label_143;
                    }
                }
                z3 = false;
            label_143:
                if(z3) {
                    this.x = true;
                }
                we.n n0 = n02.d;
                if(n0 == null) {
                    h0 = null;
                }
                else {
                    n0.invoke(this, 1);
                    h0 = H.a;
                }
                if(h0 == null) {
                    throw new IllegalStateException("Invalid restart scope");
                }
                if(z3) {
                    this.x = false;
                }
                this.J = null;
                A0 a03 = this.F;
                int v29 = a03.b[v1] + v;
                int v30 = a03.g;
                if(v30 < v || v30 > v29) {
                    q.c(("Index " + v + " is not a parent of " + v30));
                }
                a03.i = v;
                a03.h = v29;
                a03.l = 0;
                a03.m = 0;
                z1 = true;
            }
            else {
                ArrayList arrayList1 = this.D;
                arrayList1.add(n01);
                v v31 = n01.b;
                if(v31 != null) {
                    F f0 = n01.f;
                    if(f0 != null) {
                        n01.e(true);
                        int v32 = FIN.finallyOpen$NT();
                        Object[] arr_object2 = f0.b;
                        int[] arr_v3 = f0.c;
                        long[] arr_v4 = f0.a;
                        int v33 = arr_v4.length - 2;
                        v34 = v8;
                        if(v33 >= 0) {
                            int v35 = 0;
                            while(true) {
                                long v36 = arr_v4[v35];
                                Object[] arr_object3 = arr_object2;
                                if((~v36 << 7 & v36 & 0x8080808080808080L) != 0x8080808080808080L) {
                                    int v37 = 8 - (~(v35 - v33) >>> 0x1F);
                                    long v38 = v36;
                                    for(int v39 = 0; v39 < v37; ++v39) {
                                        if((v38 & 0xFFL) < 0x80L) {
                                            int v40 = (v35 << 3) + v39;
                                            Object object4 = arr_object3[v40];
                                            int v41 = arr_v3[v40];
                                            v31.x(object4);
                                        }
                                        v38 >>= 8;
                                    }
                                    if(v37 == 8) {
                                        goto label_198;
                                    }
                                    goto label_201;
                                }
                            label_198:
                                if(v35 != v33) {
                                    ++v35;
                                    continue;
                                }
                                goto label_201;
                            }
                        }
                        else {
                        label_201:
                            FIN.finallyCodeBegin$NT(v32);
                            n01.e(false);
                            FIN.finallyCodeEnd$NT(v32);
                            goto label_206;
                        }
                    }
                }
                v34 = v8;
            label_206:
                arrayList1.remove(arrayList1.size() - 1);
                v17 = v34;
            }
            int v42 = q.f(this.F.g, arrayList0);
            if(v42 < 0) {
                v42 = -(v42 + 1);
            }
            if(v42 < arrayList0.size()) {
                O o2 = (O)arrayList0.get(v42);
                if(o2.b < v2) {
                    o3 = o2;
                }
            }
            else {
                o3 = null;
            }
            v8 = v17;
            o0 = o3;
        }
        if(z1) {
            this.M(v8, v, v);
            this.F.q();
            int v43 = this.n0(v);
            this.j = v3 + v43;
            this.k = v5 + v43;
            this.l = v6;
        }
        else {
            this.S();
        }
        this.P = v4;
        this.E = z;
    }

    public final void K() {
        this.O(this.F.g);
        b b0 = this.L;
        b0.d(false);
        w w0 = b0.d;
        p p0 = b0.a;
        A0 a00 = p0.F;
        if(a00.c > 0) {
            int v = a00.i;
            if(w0.a(-2) != v) {
                if(!b0.c && b0.e) {
                    b0.d(false);
                    b0.b.g.L(f0.q.d);
                    b0.c = true;
                }
                if(v > 0) {
                    androidx.compose.runtime.a a0 = a00.a(v);
                    w0.c(v);
                    b0.d(false);
                    J j0 = b0.b.g;
                    j0.L(f0.p.d);
                    e1.m.C(j0, 0, a0);
                    b0.c = true;
                }
            }
        }
        b0.b.g.L(f0.x.d);
        b0.f = p0.F.b[p0.F.g * 5 + 3] + b0.f;
    }

    public final void L(i0 i00) {
        z z0 = this.u;
        if(z0 == null) {
            z0 = new z();
            this.u = z0;
        }
        z0.h(this.F.g, i00);
    }

    public final void M(int v, int v1, int v2) {
        A0 a00 = this.F;
        if(v == v1) {
            v2 = v;
        }
        else if(v != v2 && v1 != v2) {
            if(a00.n(v) == v1) {
                v2 = v1;
            }
            else if(a00.n(v1) == v) {
                v2 = v;
            }
            else if(a00.n(v) == a00.n(v1)) {
                v2 = a00.n(v);
            }
            else {
                int v4 = v;
                int v5;
                for(v5 = 0; v4 > 0 && v4 != v2; ++v5) {
                    v4 = a00.n(v4);
                }
                int v6 = v1;
                int v7;
                for(v7 = 0; v6 > 0 && v6 != v2; ++v7) {
                    v6 = a00.n(v6);
                }
                int v8 = v;
                for(int v9 = 0; v9 < v5 - v7; ++v9) {
                    v8 = a00.n(v8);
                }
                int v10 = v1;
                for(int v3 = 0; v3 < v7 - v5; ++v3) {
                    v10 = a00.n(v10);
                }
                int v11 = v10;
                v2 = v8;
                while(v2 != v11) {
                    v2 = a00.n(v2);
                    v11 = a00.n(v11);
                }
            }
        }
        while(v > 0 && v != v2) {
            if(a00.i(v)) {
                this.L.a();
            }
            v = a00.n(v);
        }
        this.o(v1, v2);
    }

    public final Object N() {
        V v0 = k.a;
        if(this.O) {
            if(!this.q) {
                return v0;
            }
            q.c("A call to createNode(), emitNode() or useNode() expected");
            return v0;
        }
        w0 w00 = this.F.j();
        if(this.x && !(w00 instanceof androidx.compose.runtime.m)) {
            return v0;
        }
        return w00 instanceof x0 ? ((x0)w00).a : w00;
    }

    public final void O(int v) {
        boolean z = this.F.i(v);
        b b0 = this.L;
        if(z) {
            b0.c();
            Object object0 = this.F.k(v);
            b0.c();
            b0.h.add(object0);
        }
        p.P(this, v, z, 0);
        b0.c();
        if(z) {
            b0.a();
        }
    }

    public static final int P(p p0, int v, boolean z, int v1) {
        A0 a00 = p0.F;
        int[] arr_v = a00.b;
        int v2 = arr_v[v * 5 + 1];
        if((0x8000000 & v2) != 0) {
            if(arr_v[v * 5] == 206 && kotlin.jvm.internal.q.b(a00.m(v, arr_v), q.e)) {
                Object object0 = a00.g(v, 0);
                androidx.compose.runtime.m m0 = object0 instanceof androidx.compose.runtime.m ? ((androidx.compose.runtime.m)object0) : null;
                if(m0 != null) {
                    for(Object object1: m0.a.e) {
                        p p1 = (p)object1;
                        if(p1.c.b > 0 && (p1.c.a[1] & 0x4000000) != 0) {
                            v v3 = p1.g;
                            Object object2 = v3.d;
                            synchronized(object2) {
                                v3.o();
                                K k0 = v3.n;
                                v3.n = t.f();
                                try {
                                    v3.D.h0(k0);
                                }
                                catch(Exception exception0) {
                                    v3.n = k0;
                                    throw exception0;
                                }
                            }
                            a a0 = new a();
                            p1.K = a0;
                            A0 a01 = p1.c.i();
                            try {
                                p1.F = a01;
                                b b0 = p1.L;
                                a a1 = b0.b;
                                try {
                                    b0.b = a0;
                                    p1.O(0);
                                    b b1 = p1.L;
                                    b1.b();
                                    if(b1.c) {
                                        b1.b.g.L(B.d);
                                        if(b1.c) {
                                            b1.d(false);
                                            b1.d(false);
                                            b1.b.g.L(f0.m.d);
                                            b1.c = false;
                                        }
                                    }
                                }
                                catch(Throwable throwable0) {
                                    b0.b = a1;
                                    throw throwable0;
                                }
                                b0.b = a1;
                            }
                            finally {
                                a01.c();
                            }
                        }
                        p0.b.m(p1.g);
                    }
                }
                return a00.l(v);
            }
            return a00.i(v) ? 1 : a00.l(v);
        }
        if((v2 & 0x4000000) != 0) {
            int v6 = arr_v[v * 5 + 3] + v;
            int v7 = v + 1;
            int v8 = 0;
            while(v7 < v6) {
                boolean z1 = a00.i(v7);
                if(z1) {
                    p0.L.c();
                    Object object3 = a00.k(v7);
                    p0.L.c();
                    p0.L.h.add(object3);
                }
                v8 += p.P(p0, v7, z1 || z, (z1 ? 0 : v1 + v8));
                if(z1) {
                    p0.L.c();
                    p0.L.a();
                }
                v7 += a00.b[v7 * 5 + 3];
            }
            return a00.i(v) ? 1 : v8;
        }
        return a00.i(v) ? 1 : a00.l(v);
    }

    // 去混淆评级： 中等(50)
    public final boolean Q(int v, boolean z) {
        return (v & 1) == 0 && (this.O || this.x) || z || !this.D();
    }

    public final void R() {
        if(this.r.isEmpty()) {
            int v = this.k;
            this.k = this.F.p() + v;
            return;
        }
        A0 a00 = this.F;
        int v1 = a00.f();
        int[] arr_v = a00.b;
        Object object0 = a00.g >= a00.h ? null : a00.m(a00.g, arr_v);
        Object object1 = a00.e();
        int v2 = this.l;
        V v3 = k.a;
        if(object0 != null) {
            this.P = Integer.rotateLeft((object0 instanceof Enum ? ((Enum)object0).ordinal() : object0.hashCode()) ^ Integer.rotateLeft(this.P, 3), 3);
        }
        else if(object1 != null && v1 == 0xCF && !object1.equals(v3)) {
            this.P = Integer.rotateLeft(object1.hashCode() ^ Integer.rotateLeft(this.P, 3), 3) ^ v2;
        }
        else {
            this.P = Integer.rotateLeft(Integer.rotateLeft(this.P, 3) ^ v1, 3) ^ v2;
        }
        this.Z(null, (arr_v[a00.g * 5 + 1] & 0x40000000) != 0);
        this.J();
        a00.d();
        if(object0 == null) {
            if(object1 != null && v1 == 0xCF && !object1.equals(v3)) {
                this.P = Integer.rotateRight(object1.hashCode() ^ Integer.rotateRight(this.P ^ v2, 3), 3);
                return;
            }
            this.P = Integer.rotateRight(Integer.rotateRight(this.P ^ v2, 3) ^ v1, 3);
            return;
        }
        if(object0 instanceof Enum) {
            this.P = Integer.rotateRight(((Enum)object0).ordinal() ^ Integer.rotateRight(this.P, 3), 3);
            return;
        }
        this.P = Integer.rotateRight(object0.hashCode() ^ Integer.rotateRight(this.P, 3), 3);
    }

    public final void S() {
        A0 a00 = this.F;
        this.k = a00.i < 0 ? 0 : a00.b[a00.i * 5 + 1] & 0x3FFFFFF;
        a00.q();
    }

    public final void T() {
        if(this.k != 0) {
            q.c("No nodes can be emitted before calling skipAndEndGroup");
        }
        if(!this.O) {
            n0 n00 = this.A();
            if(n00 != null) {
                int v = n00.a;
                if((v & 0x80) == 0) {
                    n00.a = v | 16;
                }
            }
            if(this.r.isEmpty()) {
                this.S();
                return;
            }
            this.J();
        }
    }

    public final void U(int v, Object object0, Object object1, int v1) {
        h0 h02;
        Object[] arr_object2;
        int v26;
        int v24;
        int v13;
        int v12;
        int v8;
        V v2 = object0;
        if(this.q) {
            q.c("A call to createNode(), emitNode() or useNode() expected");
        }
        int v3 = this.l;
        V v4 = k.a;
        if(v2 != null) {
            this.P = Integer.rotateLeft((v2 instanceof Enum ? ((Enum)v2).ordinal() : v2.hashCode()) ^ Integer.rotateLeft(this.P, 3), 3);
        }
        else if(object1 != null && v == 0xCF && !object1.equals(v4)) {
            this.P = v3 ^ Integer.rotateLeft(object1.hashCode() ^ Integer.rotateLeft(this.P, 3), 3);
        }
        else {
            this.P = v3 ^ Integer.rotateLeft(Integer.rotateLeft(this.P, 3) ^ v, 3);
        }
        if(v2 == null) {
            ++this.l;
        }
        if(this.O) {
            ++this.F.k;
            E0 e00 = this.H;
            int v5 = e00.t;
            if(v1 != 0) {
                e00.O(v4, v4, true, v);
            }
            else if(object1 == null) {
                if(v2 == null) {
                    v2 = v4;
                }
                e00.O(v2, v4, false, v);
            }
            else {
                if(v2 == null) {
                    v2 = v4;
                }
                e00.O(v2, object1, false, v);
            }
            h0 h00 = this.i;
            if(h00 != null) {
                S s0 = new S(v, -1, -2 - v5, -1);
                androidx.compose.runtime.L l0 = new androidx.compose.runtime.L(-1, this.j - h00.b, 0);
                h00.e.h(-2 - v5, l0);
                h00.d.add(s0);
            }
            this.w(v1 != 0, null);
            return;
        }
        int v6 = v1 != 1 || !this.x ? 0 : 1;
        if(this.i != null) {
            v8 = v6;
        }
        else if(v6 == 0 && this.F.f() == v) {
            int v7 = this.F.g;
            if(kotlin.jvm.internal.q.b(v2, (v7 >= this.F.h ? null : this.F.m(v7, this.F.b)))) {
                this.Z(object1, v1 != 0);
                v8 = v6;
                goto label_68;
            }
            goto label_45;
        }
        else {
        label_45:
            A0 a00 = this.F;
            int[] arr_v = a00.b;
            ArrayList arrayList0 = new ArrayList();
            if(a00.k <= 0) {
                int v9 = a00.g;
                while(v9 < a00.h) {
                    int v10 = arr_v[v9 * 5];
                    Object object2 = a00.m(v9, arr_v);
                    int v11 = arr_v[v9 * 5 + 1];
                    if((v11 & 0x40000000) == 0) {
                        v12 = v6;
                        v13 = v11 & 0x3FFFFFF;
                    }
                    else {
                        v12 = v6;
                        v13 = 1;
                    }
                    arrayList0.add(new S(v10, object2, v9, v13));
                    v9 += arr_v[v9 * 5 + 3];
                    v6 = v12;
                }
            }
            v8 = v6;
            this.i = new h0(this.j, arrayList0);
        }
    label_68:
        h0 h01 = this.i;
        if(h01 == null) {
            h02 = null;
        }
        else {
            ArrayList arrayList1 = h01.d;
            z z0 = h01.e;
            int v14 = h01.b;
            Q q0 = v2 == null ? v : new Q(v, v2);
            K k0 = ((g0.a)h01.f.getValue()).a;
            Object object3 = k0.g(q0);
            if(object3 == null) {
                object3 = null;
            }
            else if(object3 instanceof G) {
                Object object4 = ((G)object3).i(0);
                if(((G)object3).g()) {
                    k0.j(q0);
                }
                if(((G)object3).b == 1) {
                    k0.l(q0, ((G)object3).d());
                }
                object3 = object4;
            }
            else {
                k0.j(q0);
            }
            if(v8 != 0 || ((S)object3) == null) {
                ++this.F.k;
                this.O = true;
                this.J = null;
                if(this.H.w) {
                    E0 e01 = this.G.k();
                    this.H = e01;
                    e01.J();
                    this.I = false;
                    this.J = null;
                }
                this.H.d();
                E0 e02 = this.H;
                int v34 = e02.t;
                if(v1 != 0) {
                    e02.O(v4, v4, true, v);
                }
                else if(object1 == null) {
                    V v35 = object0 == null ? v4 : object0;
                    e02.O(v35, v4, false, v);
                }
                else {
                    if(object0 != null) {
                        v4 = object0;
                    }
                    e02.O(v4, object1, false, v);
                }
                this.M = this.H.b(v34);
                S s1 = new S(v, -1, -2 - v34, -1);
                z0.h(-2 - v34, new androidx.compose.runtime.L(-1, this.j - v14, 0));
                arrayList1.add(s1);
                ArrayList arrayList2 = new ArrayList();
                h02 = new h0((v1 == 0 ? 0 : this.j), arrayList2);
            }
            else {
                int v15 = ((S)object3).c;
                arrayList1.add(((S)object3));
                androidx.compose.runtime.L l1 = (androidx.compose.runtime.L)z0.b(v15);
                this.j = (l1 == null ? -1 : l1.b) + v14;
                androidx.compose.runtime.L l2 = (androidx.compose.runtime.L)z0.b(v15);
                int v16 = l2 == null ? -1 : l2.a;
                int v17 = h01.c;
                int v18 = v16 - v17;
                if(v16 > v17) {
                    Object[] arr_object = z0.c;
                    long[] arr_v1 = z0.a;
                    int v19 = arr_v1.length - 2;
                    if(v19 >= 0) {
                        int v20 = 0;
                        while(true) {
                            long v21 = arr_v1[v20];
                            if((~v21 << 7 & v21 & 0x8080808080808080L) == 0x8080808080808080L) {
                                goto label_129;
                            }
                            int v22 = 8 - (~(v20 - v19) >>> 0x1F);
                            int v23 = 0;
                            while(v23 < v22) {
                                if((v21 & 0xFFL) < 0x80L) {
                                    androidx.compose.runtime.L l3 = (androidx.compose.runtime.L)arr_object[(v20 << 3) + v23];
                                    v24 = v18;
                                    int v25 = l3.a;
                                    if(v25 == v16) {
                                        l3.a = v17;
                                    }
                                    else if(v17 <= v25 && v25 < v16) {
                                        l3.a = v25 + 1;
                                    }
                                }
                                else {
                                    v24 = v18;
                                }
                                v21 >>= 8;
                                ++v23;
                                v18 = v24;
                            }
                            v26 = v18;
                            if(v22 == 8) {
                                goto label_130;
                            label_129:
                                v26 = v18;
                            label_130:
                                if(v20 == v19) {
                                    goto label_172;
                                }
                                else {
                                    ++v20;
                                    v18 = v26;
                                    continue;
                                }
                            }
                            else {
                                goto label_172;
                            }
                            break;
                        }
                    }
                    else {
                        v26 = v18;
                        goto label_172;
                    }
                }
                else {
                    v26 = v18;
                    if(v17 > v16) {
                        Object[] arr_object1 = z0.c;
                        long[] arr_v2 = z0.a;
                        int v27 = arr_v2.length - 2;
                        if(v27 >= 0) {
                            int v28 = 0;
                            while(true) {
                                long v29 = arr_v2[v28];
                                if((~v29 << 7 & v29 & 0x8080808080808080L) == 0x8080808080808080L) {
                                    goto label_167;
                                }
                                int v30 = 8 - (~(v28 - v27) >>> 0x1F);
                                int v31 = 0;
                                while(v31 < v30) {
                                    if((v29 & 0xFFL) < 0x80L) {
                                        androidx.compose.runtime.L l4 = (androidx.compose.runtime.L)arr_object1[(v28 << 3) + v31];
                                        int v32 = l4.a;
                                        if(v32 == v16) {
                                            l4.a = v17;
                                            arr_object2 = arr_object1;
                                        }
                                        else {
                                            arr_object2 = arr_object1;
                                            if(v16 + 1 <= v32 && v32 < v17) {
                                                l4.a = v32 - 1;
                                            }
                                        }
                                    }
                                    else {
                                        arr_object2 = arr_object1;
                                    }
                                    v29 >>= 8;
                                    ++v31;
                                    arr_object1 = arr_object2;
                                }
                                Object[] arr_object3 = arr_object1;
                                if(v30 == 8) {
                                    goto label_168;
                                label_167:
                                    arr_object3 = arr_object1;
                                label_168:
                                    if(v28 != v27) {
                                        ++v28;
                                        arr_object1 = arr_object3;
                                        continue;
                                    }
                                }
                                goto label_172;
                            }
                        }
                        else {
                            goto label_172;
                        }
                    }
                    else {
                    label_172:
                        b b0 = this.L;
                        p p0 = b0.a;
                        b0.f = v15 - p0.F.g + b0.f;
                        this.F.o(v15);
                        if(v26 > 0) {
                            b0.d(false);
                            w w0 = b0.d;
                            A0 a01 = p0.F;
                            if(a01.c > 0) {
                                int v33 = a01.i;
                                if(w0.a(-2) != v33) {
                                    if(!b0.c && b0.e) {
                                        b0.d(false);
                                        b0.b.g.L(f0.q.d);
                                        b0.c = true;
                                    }
                                    if(v33 > 0) {
                                        androidx.compose.runtime.a a0 = a01.a(v33);
                                        w0.c(v33);
                                        b0.d(false);
                                        J j0 = b0.b.g;
                                        j0.L(f0.p.d);
                                        e1.m.C(j0, 0, a0);
                                        b0.c = true;
                                    }
                                }
                            }
                            J j1 = b0.b.g;
                            j1.L(f0.u.d);
                            j1.i[j1.j - j1.g[j1.h - 1].b] = v26;
                        }
                    }
                }
                this.Z(object1, v1 != 0);
                h02 = null;
            }
        }
        this.w(v1 != 0, h02);
    }

    public final void V() {
        this.U(0xFFFFFF81, null, null, 0);
    }

    public final void W(int v, d0 d00) {
        this.U(v, d00, null, 0);
    }

    public final void X(int v, Object object0) {
        this.U(v, object0, null, 0);
    }

    public final void Y() {
        this.U(0x7D, null, null, 1);
        this.q = true;
    }

    public final void Z(Object object0, boolean z) {
        if(z) {
            A0 a00 = this.F;
            if(a00.k <= 0) {
                if((a00.b[a00.g * 5 + 1] & 0x40000000) == 0) {
                    j0.a("Expected a node group");
                }
                a00.r();
            }
            return;
        }
        if(object0 != null && this.F.e() != object0) {
            this.L.getClass();
            this.L.d(false);
            J j0 = this.L.b.g;
            j0.L(f0.E.d);
            e1.m.C(j0, 0, object0);
        }
        this.F.r();
    }

    public final void a() {
        this.j();
        this.h.clear();
        this.m.b = 0;
        this.s.b = 0;
        this.w.b = 0;
        this.u = null;
        c c0 = this.N;
        c0.h.H();
        c0.g.H();
        this.P = 0;
        this.z = 0;
        this.q = false;
        this.O = false;
        this.x = false;
        this.E = false;
        this.y = -1;
        A0 a00 = this.F;
        if(!a00.f) {
            a00.c();
        }
        if(!this.H.w) {
            this.x();
        }
    }

    public final void a0(int v) {
        if(this.i != null) {
            this.U(v, null, null, 0);
            return;
        }
        if(this.q) {
            q.c("A call to createNode(), emitNode() or useNode() expected");
        }
        this.P = this.l ^ Integer.rotateLeft(Integer.rotateLeft(this.P, 3) ^ v, 3);
        ++this.l;
        A0 a00 = this.F;
        V v1 = k.a;
        if(this.O) {
            ++a00.k;
            this.H.O(v1, v1, false, v);
            this.w(false, null);
            return;
        }
        if(a00.f() == v && (a00.g >= a00.h || (a00.b[a00.g * 5 + 1] & 0x20000000) == 0)) {
            a00.r();
            this.w(false, null);
            return;
        }
        if(a00.k <= 0) {
            int v2 = a00.g;
            if(v2 != a00.h) {
                int v3 = this.j;
                this.K();
                int v4 = a00.p();
                this.L.e(v3, v4);
                q.a(v2, a00.g, this.r);
            }
        }
        ++a00.k;
        this.O = true;
        this.J = null;
        if(this.H.w) {
            E0 e00 = this.G.k();
            this.H = e00;
            e00.J();
            this.I = false;
            this.J = null;
        }
        E0 e01 = this.H;
        e01.d();
        int v5 = e01.t;
        e01.O(v1, v1, false, v);
        this.M = e01.b(v5);
        this.w(false, null);
    }

    public static final void b(p p0, i0 i00, Object object0) {
        boolean z;
        p0.X(0x78CC281, null);
        p0.F();
        p0.m0(object0);
        int v = p0.P;
        try {
            p0.P = 0x78CC281;
            if(p0.O) {
                E0.x(p0.H);
            }
            if(p0.O) {
                z = false;
            }
            else if(!kotlin.jvm.internal.q.b(p0.F.e(), i00)) {
                z = true;
            }
            else {
                z = false;
            }
            if(z) {
                p0.L(i00);
            }
            p0.U(202, q.c, i00, 0);
            p0.J = null;
            boolean z1 = p0.v;
            p0.v = z;
            m0.c.d(p0, new m0.b(0x12D6006F, new e(object0, 16), true));
            p0.v = z1;
        }
        finally {
            p0.p(false);
            p0.J = null;
            p0.P = v;
            p0.p(false);
        }
    }

    public final void b0(int v) {
        this.U(v, null, null, 0);
    }

    public final void c(Object object0, we.n n0) {
        if(this.O) {
            J j0 = this.N.g;
            j0.L(f0.F.d);
            e1.m.C(j0, 0, object0);
            kotlin.jvm.internal.q.e(n0, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
            kotlin.jvm.internal.N.e(2, n0);
            e1.m.C(j0, 1, n0);
            return;
        }
        this.L.b();
        J j1 = this.L.b.g;
        j1.L(f0.F.d);
        kotlin.jvm.internal.q.e(n0, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
        kotlin.jvm.internal.N.e(2, n0);
        e1.m.D(j1, 0, object0, 1, n0);
    }

    public final p c0(int v) {
        n0 n01;
        this.a0(v);
        ArrayList arrayList0 = this.D;
        v v1 = this.g;
        if(this.O) {
            n0 n00 = new n0(v1);
            arrayList0.add(n00);
            this.m0(n00);
            n00.e = this.A;
            n00.a &= -17;
            return this;
        }
        int v2 = q.f(this.F.i, this.r);
        O o0 = v2 < 0 ? null : ((O)this.r.remove(v2));
        Object object0 = this.F.j();
        if(kotlin.jvm.internal.q.b(object0, k.a)) {
            n01 = new n0(v1);
            this.m0(n01);
        }
        else {
            kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
            n01 = (n0)object0;
        }
        if(o0 == null) {
            int v3 = n01.a;
            boolean z = (v3 & 0x40) != 0;
            if(z) {
                n01.a = v3 & -65;
            }
            if(z) {
                n01.a |= 8;
            }
            else {
                n01.a &= -9;
            }
        }
        else {
            n01.a |= 8;
        }
        arrayList0.add(n01);
        n01.e = this.A;
        int v4 = n01.a;
        n01.a = v4 & -17;
        if((v4 & 0x100) != 0) {
            n01.a = v4 & -273 | 0x200;
            J j0 = this.L.b.g;
            j0.L(C.d);
            e1.m.C(j0, 0, n01);
        }
        return this;
    }

    public final boolean d(float f) {
        Object object0 = this.F();
        if(object0 instanceof Float && f == ((Number)object0).floatValue()) {
            return false;
        }
        this.m0(f);
        return true;
    }

    public final void d0(Object object0) {
        if(!this.O && this.F.f() == 0xCF && !kotlin.jvm.internal.q.b(this.F.e(), object0) && this.y < 0) {
            this.y = this.F.g;
            this.x = true;
        }
        this.U(0xCF, null, object0, 0);
    }

    public final boolean e(int v) {
        Object object0 = this.F();
        if(object0 instanceof Integer && v == ((Number)object0).intValue()) {
            return false;
        }
        this.m0(v);
        return true;
    }

    public final void e0() {
        this.U(0x7D, null, null, 2);
        this.q = true;
    }

    public final boolean f(long v) {
        Object object0 = this.F();
        if(object0 instanceof Long && v == ((Number)object0).longValue()) {
            return false;
        }
        this.m0(v);
        return true;
    }

    public final void f0() {
        this.l = 0;
        this.F = this.c.i();
        this.U(100, null, null, 0);
        s s0 = this.b;
        s0.n();
        this.t = s0.f();
        this.w.c(((int)this.v));
        this.v = this.g(this.t);
        this.J = null;
        if(!this.p) {
            this.p = s0.d();
        }
        if(!this.B) {
            this.B = s0.e();
        }
        Set set0 = (Set)androidx.compose.runtime.w.u(this.t, d.a);
        if(set0 != null) {
            u u0 = this.Q;
            if(u0 == null) {
                u0 = new u(this.g);
                this.Q = u0;
            }
            set0.add(u0);
            s0.k(set0);
        }
        this.U(s0.g(), null, null, 0);
    }

    public final boolean g(Object object0) {
        if(!kotlin.jvm.internal.q.b(this.F(), object0)) {
            this.m0(object0);
            return true;
        }
        return false;
    }

    public final boolean g0(n0 n00, Object object0) {
        androidx.compose.runtime.a a0 = n00.c;
        if(a0 != null) {
            int v = this.F.a.a(a0);
            if(this.E && v >= this.F.g) {
                ArrayList arrayList0 = this.r;
                int v1 = q.f(v, arrayList0);
                if(v1 < 0) {
                    if(!(object0 instanceof E)) {
                        object0 = null;
                    }
                    arrayList0.add(-(v1 + 1), new O(n00, v, object0));
                    return true;
                }
                O o0 = (O)arrayList0.get(v1);
                if(object0 instanceof E) {
                    Object object1 = o0.c;
                    if(object1 == null) {
                        o0.c = object0;
                        return true;
                    }
                    if(object1 instanceof L) {
                        ((L)object1).a(object0);
                        return true;
                    }
                    L l0 = new L(2);
                    l0.k(object1);
                    l0.k(object0);
                    o0.c = l0;
                    return true;
                }
                o0.c = null;
                return true;
            }
        }
        return false;
    }

    public final boolean h(boolean z) {
        Object object0 = this.F();
        if(object0 instanceof Boolean && z == ((Boolean)object0).booleanValue()) {
            return false;
        }
        this.m0(Boolean.valueOf(z));
        return true;
    }

    public final void h0(K k0) {
        Object[] arr_object = k0.b;
        Object[] arr_object1 = k0.c;
        long[] arr_v = k0.a;
        int v = arr_v.length - 2;
        ArrayList arrayList0 = this.r;
        if(v >= 0) {
            int v1 = 0;
            while(true) {
                long v2 = arr_v[v1];
                if((~v2 << 7 & v2 & 0x8080808080808080L) != 0x8080808080808080L) {
                    int v3 = 8 - (~(v1 - v) >>> 0x1F);
                    for(int v4 = 0; v4 < v3; ++v4) {
                        if((0xFFL & v2) < 0x80L) {
                            int v5 = (v1 << 3) + v4;
                            Object object0 = arr_object[v5];
                            Object object1 = arr_object1[v5];
                            kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
                            n0 n00 = (n0)object0;
                            androidx.compose.runtime.a a0 = n00.c;
                            if(a0 != null) {
                                int v6 = a0.a;
                                if(object1 == V.e) {
                                    object1 = null;
                                }
                                arrayList0.add(new O(n00, v6, object1));
                            }
                        }
                        v2 >>= 8;
                    }
                    if(v3 == 8) {
                        goto label_28;
                    }
                    break;
                }
            label_28:
                if(v1 == v) {
                    break;
                }
                ++v1;
            }
        }
        je.t.S(arrayList0, q.f);
    }

    public final boolean i(Object object0) {
        if(this.F() != object0) {
            this.m0(object0);
            return true;
        }
        return false;
    }

    public final void i0(int v, int v1) {
        if(this.n0(v) != v1) {
            if(v < 0) {
                x x0 = this.o;
                if(x0 == null) {
                    x0 = new x();
                    this.o = x0;
                }
                x0.f(v, v1);
                return;
            }
            int[] arr_v = this.n;
            if(arr_v == null) {
                arr_v = new int[this.F.c];
                je.n.d0(-1, arr_v);
                this.n = arr_v;
            }
            arr_v[v] = v1;
        }
    }

    public final void j() {
        this.i = null;
        this.j = 0;
        this.k = 0;
        this.P = 0;
        this.q = false;
        this.L.c = false;
        this.L.d.b = 0;
        this.L.f = 0;
        this.D.clear();
        this.n = null;
        this.o = null;
    }

    public final void j0(int v, int v1) {
        int v2 = this.n0(v);
        if(v2 != v1) {
            ArrayList arrayList0 = this.h;
            int v3 = arrayList0.size() - 1;
            while(v != -1) {
                int v4 = this.n0(v) + (v1 - v2);
                this.i0(v, v4);
                for(int v5 = v3; -1 < v5; --v5) {
                    h0 h00 = (h0)arrayList0.get(v5);
                    if(h00 != null && h00.a(v, v4)) {
                        v3 = v5 - 1;
                        break;
                    }
                }
                if(v < 0) {
                    v = this.F.i;
                }
                else {
                    if(this.F.i(v)) {
                        break;
                    }
                    v = this.F.n(v);
                }
            }
        }
    }

    public final Object k(l0 l00) {
        return androidx.compose.runtime.w.u(this.m(), l00);
    }

    public final g k0(i0 i00, g g0) {
        ((g)i00).getClass();
        f f0 = new f(((g)i00));
        f0.putAll(g0);
        g g1 = f0.a();
        this.W(204, q.d);
        this.F();
        this.m0(g1);
        this.F();
        this.m0(g0);
        this.p(false);
        return g1;
    }

    public final void l(we.a a0) {
        if(!this.q) {
            q.c("A call to createNode(), emitNode() or useNode() expected was not expected");
        }
        this.q = false;
        if(!this.O) {
            q.c("createNode() can only be called when inserting");
        }
        int v = this.m.a[this.m.b - 1];
        androidx.compose.runtime.a a1 = this.H.b(this.H.v);
        ++this.k;
        c c0 = this.N;
        c0.g.L(r.e);
        e1.m.C(c0.g, 0, a0);
        c0.g.i[c0.g.j - c0.g.g[c0.g.h - 1].b] = v;
        e1.m.C(c0.g, 1, a1);
        c0.h.L(r.f);
        c0.h.i[c0.h.j - c0.h.g[c0.h.h - 1].b] = v;
        e1.m.C(c0.h, 0, a1);
    }

    public final void l0(Object object0) {
        A0 a01;
        int v9;
        E0 e01;
        int v4;
        androidx.compose.runtime.a a0 = null;
        if(object0 instanceof w0) {
            if(this.O) {
                E0 e00 = this.H;
                int v = e00.t;
                if(v > e00.v + 1) {
                    int v1 = v - 1;
                    for(int v2 = e00.C(v1, e00.b); true; v2 = e01.C(v1, e01.b)) {
                        int v3 = v1;
                        v1 = v2;
                        v4 = v3;
                        e01 = this.H;
                        if(v1 == e01.v || v1 < 0) {
                            break;
                        }
                    }
                    a0 = e01.b(v4);
                }
            }
            else {
                A0 a00 = this.F;
                int v5 = a00.g;
                if(v5 > a00.i + 1) {
                    int v6 = v5 - 1;
                    for(int v7 = a00.n(v6); true; v7 = a01.n(v6)) {
                        int v8 = v6;
                        v6 = v7;
                        v9 = v8;
                        a01 = this.F;
                        if(v6 == a01.i || v6 < 0) {
                            break;
                        }
                    }
                    a0 = a01.a(v9);
                }
            }
            x0 x00 = new x0(((w0)object0), a0);
            if(this.O) {
                J j0 = this.L.b.g;
                j0.L(f0.w.d);
                e1.m.C(j0, 0, x00);
            }
            this.d.add(object0);
            object0 = x00;
        }
        this.m0(object0);
    }

    public final i0 m() {
        i0 i01;
        i0 i00 = this.J;
        if(i00 != null) {
            return i00;
        }
        int v = this.F.i;
        d0 d00 = q.c;
        if(this.O && this.I) {
            for(int v1 = this.H.v; v1 > 0; v1 = this.H.C(v1, this.H.b)) {
                if(this.H.b[this.H.q(v1) * 5] == 202 && kotlin.jvm.internal.q.b(this.H.r(v1), d00)) {
                    Object object0 = this.H.p(v1);
                    kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                    this.J = (i0)object0;
                    return (i0)object0;
                }
            }
        }
        if(this.F.c > 0) {
            while(v > 0) {
                int[] arr_v = this.F.b;
                if(arr_v[v * 5] == 202 && kotlin.jvm.internal.q.b(this.F.m(v, arr_v), d00)) {
                    z z0 = this.u;
                    if(z0 == null) {
                    label_23:
                        Object object1 = this.F.b(v, this.F.b);
                        kotlin.jvm.internal.q.e(object1, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                        i01 = (i0)object1;
                    }
                    else {
                        i01 = (i0)z0.b(v);
                        if(i01 == null) {
                            goto label_23;
                        }
                    }
                    this.J = i01;
                    return i01;
                }
                v = this.F.n(v);
            }
        }
        this.J = this.t;
        return this.t;
    }

    public final void m0(Object object0) {
        if(this.O) {
            E0 e00 = this.H;
            if(e00.n > 0 && e00.i != e00.k) {
                z z0 = e00.s == null ? new z() : e00.s;
                e00.s = z0;
                int v = e00.v;
                G g0 = z0.b(v);
                if(g0 == null) {
                    g0 = new G();
                    z0.h(v, g0);
                }
                g0.a(object0);
                return;
            }
            e00.D(object0);
            return;
        }
        A0 a00 = this.F;
        b b0 = this.L;
        if(a00.n) {
            int v1 = a00.l - D0.d(a00.i, a00.b) - 1;
            if(b0.a.F.i - b0.f < 0) {
                androidx.compose.runtime.a a0 = this.F.a(this.F.i);
                J j0 = b0.b.g;
                j0.L(r.g);
                e1.m.D(j0, 0, object0, 1, a0);
                j0.i[j0.j - j0.g[j0.h - 1].b] = v1;
                return;
            }
            b0.d(true);
            J j1 = b0.b.g;
            j1.L(r.h);
            e1.m.C(j1, 0, object0);
            j1.i[j1.j - j1.g[j1.h - 1].b] = v1;
            return;
        }
        androidx.compose.runtime.a a1 = a00.a(a00.i);
        J j2 = b0.b.g;
        j2.L(f0.e.d);
        e1.m.D(j2, 0, a1, 1, object0);
    }

    public final void n(K k0, m0.b b0) {
        ArrayList arrayList0 = this.r;
        if(this.E) {
            q.c("Reentrant composition is not supported");
        }
        Trace.beginSection("Compose:recompose");
        try {
            this.A = Long.hashCode(p0.m.k().g());
            this.u = null;
            this.h0(k0);
            this.j = 0;
            this.E = true;
            try {
                this.f0();
                Object object0 = this.F();
                if(object0 != b0 && b0 != null) {
                    this.m0(b0);
                }
                g0.e e0 = androidx.compose.runtime.w.g();
                try {
                    e0.b(this.C);
                    d0 d00 = q.a;
                    if(b0 != null) {
                        this.W(200, d00);
                        m0.c.d(this, b0);
                        this.p(false);
                    }
                    else if(this.v && object0 != null && !object0.equals(k.a)) {
                        this.W(200, d00);
                        kotlin.jvm.internal.N.e(2, object0);
                        m0.c.d(this, ((we.n)object0));
                        this.p(false);
                    }
                    else {
                        this.R();
                    }
                }
                finally {
                    e0.k(e0.c - 1);
                }
                this.u();
                goto label_44;
            }
            catch(Throwable throwable0) {
            }
            this.E = false;
            arrayList0.clear();
            this.a();
            if(!this.H.w) {
                q.c("Check failed");
            }
            this.x();
            throw throwable0;
        label_44:
            this.E = false;
            arrayList0.clear();
            if(!this.H.w) {
                q.c("Check failed");
            }
            this.x();
        }
        finally {
            Trace.endSection();
        }
    }

    public final int n0(int v) {
        if(v < 0) {
            x x0 = this.o;
            if(x0 != null && x0.c(v) >= 0) {
                int v1 = x0.c(v);
                if(v1 >= 0) {
                    return x0.c[v1];
                }
                E.a.e(("Cannot find value for key " + v));
                throw null;
            }
            return 0;
        }
        int[] arr_v = this.n;
        if(arr_v != null) {
            int v2 = arr_v[v];
            return v2 < 0 ? this.F.l(v) : v2;
        }
        return this.F.l(v);
    }

    public final void o(int v, int v1) {
        if(v > 0 && v != v1) {
            this.o(this.F.n(v), v1);
            if(this.F.i(v)) {
                Object object0 = this.F.k(v);
                this.L.c();
                this.L.h.add(object0);
            }
        }
    }

    public final void o0() {
        if(!this.q) {
            q.c("A call to createNode(), emitNode() or useNode() expected was not expected");
        }
        this.q = false;
        if(this.O) {
            q.c("useNode() called while inserting");
        }
        Object object0 = this.F.k(this.F.i);
        b b0 = this.L;
        b0.c();
        b0.h.add(object0);
        if(this.x && object0 instanceof i) {
            b0.b();
            a a0 = b0.b;
            if(object0 != null) {
                a0.g.L(f0.H.d);
                return;
            }
            a0.getClass();
        }
    }

    public final void p(boolean z) {
        ArrayList arrayList6;
        w w2;
        int v15;
        w w1;
        int v41;
        long[] arr_v4;
        Object[] arr_object4;
        int v33;
        long[] arr_v1;
        Object[] arr_object1;
        int v31;
        ArrayList arrayList5;
        HashSet hashSet1;
        ArrayList arrayList4;
        ArrayList arrayList3;
        int v23;
        int v21;
        LinkedHashSet linkedHashSet1;
        h0 h01;
        int v18;
        int v17;
        w w0 = this.m;
        int v = w0.a[w0.b - 2] - 1;
        V v1 = k.a;
        if(this.O) {
            int v2 = this.H.v;
            int v3 = this.H.b[this.H.q(v2) * 5];
            Object object0 = this.H.r(v2);
            Object object1 = this.H.p(v2);
            if(object0 != null) {
                this.P = Integer.rotateRight((object0 instanceof Enum ? ((Enum)object0).ordinal() : object0.hashCode()) ^ Integer.rotateRight(this.P, 3), 3);
            }
            else if(object1 != null && v3 == 0xCF && !object1.equals(v1)) {
                this.P = Integer.rotateRight(Integer.rotateRight(v ^ this.P, 3) ^ object1.hashCode(), 3);
            }
            else {
                this.P = Integer.rotateRight(Integer.rotateRight(v ^ this.P, 3) ^ v3, 3);
            }
        }
        else {
            A0 a00 = this.F;
            int v4 = a00.i;
            int v5 = a00.b[v4 * 5];
            Object object2 = a00.m(v4, a00.b);
            Object object3 = this.F.b(v4, this.F.b);
            if(object2 != null) {
                this.P = Integer.rotateRight((object2 instanceof Enum ? ((Enum)object2).ordinal() : object2.hashCode()) ^ Integer.rotateRight(this.P, 3), 3);
            }
            else if(object3 != null && v5 == 0xCF && !object3.equals(v1)) {
                this.P = Integer.rotateRight(Integer.rotateRight(v ^ this.P, 3) ^ object3.hashCode(), 3);
            }
            else {
                this.P = Integer.rotateRight(Integer.rotateRight(v ^ this.P, 3) ^ v5, 3);
            }
        }
        int v6 = this.k;
        h0 h00 = this.i;
        ArrayList arrayList0 = this.r;
        b b0 = this.L;
        if(h00 == null) {
            w2 = w0;
            arrayList6 = arrayList0;
        }
        else {
            z z1 = h00.e;
            int v7 = h00.b;
            ArrayList arrayList1 = h00.a;
            if(arrayList1.size() > 0) {
                ArrayList arrayList2 = h00.d;
                HashSet hashSet0 = new HashSet(arrayList2.size());
                int v8 = arrayList2.size();
                for(int v9 = 0; v9 < v8; ++v9) {
                    hashSet0.add(arrayList2.get(v9));
                }
                LinkedHashSet linkedHashSet0 = new LinkedHashSet();
                int v10 = arrayList2.size();
                int v11 = arrayList1.size();
                int v12 = 0;
                int v13 = 0;
                int v14 = 0;
                while(v12 < v11) {
                    S s0 = (S)arrayList1.get(v12);
                    if(hashSet0.contains(s0)) {
                        w1 = w0;
                        v15 = v12;
                        if(!linkedHashSet0.contains(s0)) {
                            if(v13 < v10) {
                                S s1 = (S)arrayList2.get(v13);
                                if(s1 == s0) {
                                    v17 = v13;
                                    arrayList5 = arrayList0;
                                    linkedHashSet1 = linkedHashSet0;
                                    v21 = v10;
                                    v23 = v7;
                                    arrayList3 = arrayList1;
                                    arrayList4 = arrayList2;
                                    hashSet1 = hashSet0;
                                    v18 = v14;
                                    h01 = h00;
                                    v33 = v15 + 1;
                                }
                                else {
                                    androidx.compose.runtime.L l1 = (androidx.compose.runtime.L)z1.b(s1.c);
                                    int v16 = l1 == null ? -1 : l1.b;
                                    linkedHashSet0.add(s1);
                                    v17 = v13;
                                    v18 = v14;
                                    h01 = h00;
                                    if(v16 == v18) {
                                        arrayList5 = arrayList0;
                                        linkedHashSet1 = linkedHashSet0;
                                        v21 = v10;
                                        v23 = v7;
                                        arrayList3 = arrayList1;
                                        arrayList4 = arrayList2;
                                        hashSet1 = hashSet0;
                                    }
                                    else {
                                        androidx.compose.runtime.L l2 = (androidx.compose.runtime.L)z1.b(s1.c);
                                        int v19 = l2 == null ? s1.d : l2.c;
                                        linkedHashSet1 = linkedHashSet0;
                                        int v20 = v16 + v7;
                                        v21 = v10;
                                        int v22 = v18 + v7;
                                        if(v19 > 0) {
                                            v23 = v7;
                                            int v24 = b0.l;
                                            if(v24 > 0) {
                                                arrayList3 = arrayList1;
                                                if(b0.j == v20 - v24 && b0.k == v22 - v24) {
                                                    b0.l = v24 + v19;
                                                    goto label_101;
                                                }
                                            }
                                            else {
                                                arrayList3 = arrayList1;
                                            }
                                            b0.c();
                                            b0.j = v20;
                                            b0.k = v22;
                                            b0.l = v19;
                                        }
                                        else {
                                            v23 = v7;
                                            arrayList3 = arrayList1;
                                            b0.getClass();
                                        }
                                    label_101:
                                        if(v16 > v18) {
                                            Object[] arr_object = z1.c;
                                            long[] arr_v = z1.a;
                                            int v25 = arr_v.length - 2;
                                            if(v25 >= 0) {
                                                arrayList4 = arrayList2;
                                                hashSet1 = hashSet0;
                                                int v26 = 0;
                                                while(true) {
                                                    long v27 = arr_v[v26];
                                                    int v28 = v19;
                                                    arrayList5 = arrayList0;
                                                    if((~v27 << 7 & v27 & 0x8080808080808080L) == 0x8080808080808080L) {
                                                        goto label_140;
                                                    }
                                                    int v29 = 8 - (~(v26 - v25) >>> 0x1F);
                                                    int v30 = 0;
                                                    while(v30 < v29) {
                                                        if((v27 & 0xFFL) < 0x80L) {
                                                            v31 = v30;
                                                            androidx.compose.runtime.L l3 = (androidx.compose.runtime.L)arr_object[(v26 << 3) + v30];
                                                            arr_object1 = arr_object;
                                                            int v32 = l3.b;
                                                            arr_v1 = arr_v;
                                                            if(v16 <= v32 && v32 < v16 + v28) {
                                                                l3.b = v32 - v16 + v18;
                                                            }
                                                            else if(v18 <= v32 && v32 < v16) {
                                                                l3.b = v32 + v28;
                                                            }
                                                        }
                                                        else {
                                                            v31 = v30;
                                                            arr_object1 = arr_object;
                                                            arr_v1 = arr_v;
                                                        }
                                                        v27 >>= 8;
                                                        v30 = v31 + 1;
                                                        arr_object = arr_object1;
                                                        arr_v = arr_v1;
                                                    }
                                                    Object[] arr_object2 = arr_object;
                                                    long[] arr_v2 = arr_v;
                                                    if(v29 == 8) {
                                                        goto label_142;
                                                    label_140:
                                                        arr_object2 = arr_object;
                                                        arr_v2 = arr_v;
                                                    label_142:
                                                        if(v26 != v25) {
                                                            ++v26;
                                                            arrayList0 = arrayList5;
                                                            arr_object = arr_object2;
                                                            arr_v = arr_v2;
                                                            continue;
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                            else {
                                                arrayList5 = arrayList0;
                                                arrayList4 = arrayList2;
                                                hashSet1 = hashSet0;
                                                v33 = v15;
                                                goto label_223;
                                            }
                                        }
                                        else {
                                            int v34 = v19;
                                            arrayList5 = arrayList0;
                                            arrayList4 = arrayList2;
                                            hashSet1 = hashSet0;
                                            if(v18 > v16) {
                                                Object[] arr_object3 = z1.c;
                                                long[] arr_v3 = z1.a;
                                                int v35 = arr_v3.length - 2;
                                                if(v35 >= 0) {
                                                    int v36 = 0;
                                                    while(true) {
                                                        long v37 = arr_v3[v36];
                                                        if((~v37 << 7 & v37 & 0x8080808080808080L) == 0x8080808080808080L) {
                                                            goto label_194;
                                                        }
                                                        int v38 = 8 - (~(v36 - v35) >>> 0x1F);
                                                        int v39 = 0;
                                                        while(v39 < v38) {
                                                            if((v37 & 0xFFL) < 0x80L) {
                                                                arr_object4 = arr_object3;
                                                                androidx.compose.runtime.L l4 = (androidx.compose.runtime.L)arr_object3[(v36 << 3) + v39];
                                                                arr_v4 = arr_v3;
                                                                int v40 = l4.b;
                                                                v41 = v16;
                                                                if(v16 <= v40 && v40 < v41 + v34) {
                                                                    l4.b = v40 - v41 + v18;
                                                                }
                                                                else if(v41 + 1 <= v40 && v40 < v18) {
                                                                    l4.b = v40 - v34;
                                                                }
                                                            }
                                                            else {
                                                                arr_object4 = arr_object3;
                                                                arr_v4 = arr_v3;
                                                                v41 = v16;
                                                            }
                                                            v37 >>= 8;
                                                            ++v39;
                                                            arr_v3 = arr_v4;
                                                            arr_object3 = arr_object4;
                                                            v16 = v41;
                                                        }
                                                        Object[] arr_object5 = arr_object3;
                                                        long[] arr_v5 = arr_v3;
                                                        int v42 = v16;
                                                        if(v38 == 8) {
                                                            goto label_197;
                                                        label_194:
                                                            arr_object5 = arr_object3;
                                                            arr_v5 = arr_v3;
                                                            v42 = v16;
                                                        label_197:
                                                            if(v36 != v35) {
                                                                ++v36;
                                                                arr_v3 = arr_v5;
                                                                arr_object3 = arr_object5;
                                                                v16 = v42;
                                                                continue;
                                                            }
                                                        }
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    v33 = v15;
                                }
                            label_223:
                                v13 = v17 + 1;
                                androidx.compose.runtime.L l5 = (androidx.compose.runtime.L)z1.b(s1.c);
                                v12 = v33;
                                h00 = h01;
                                linkedHashSet0 = linkedHashSet1;
                                v10 = v21;
                                v7 = v23;
                                arrayList1 = arrayList3;
                                arrayList2 = arrayList4;
                                hashSet0 = hashSet1;
                                arrayList0 = arrayList5;
                                v14 = v18 + (l5 == null ? s1.d : l5.c);
                                goto label_240;
                            }
                            else {
                                w0 = w1;
                                v12 = v15;
                                continue;
                            }
                        }
                    }
                    else {
                        w1 = w0;
                        androidx.compose.runtime.L l0 = (androidx.compose.runtime.L)z1.b(s0.c);
                        v15 = v12;
                        b0.e((l0 == null ? -1 : l0.b) + v7, s0.d);
                        h00.a(s0.c, 0);
                        b0.f = s0.c - b0.a.F.g + b0.f;
                        this.F.o(s0.c);
                        this.K();
                        this.F.p();
                        q.a(s0.c, this.F.b[s0.c * 5 + 3] + s0.c, arrayList0);
                    }
                    v12 = v15 + 1;
                label_240:
                    w0 = w1;
                }
                w2 = w0;
                arrayList6 = arrayList0;
                b0.c();
                if(arrayList1.size() > 0) {
                    b0.f = this.F.h - b0.a.F.g + b0.f;
                    this.F.q();
                }
            }
            else {
                w2 = w0;
                arrayList6 = arrayList0;
            }
        }
        boolean z2 = this.O;
        if(!z2) {
            int v43 = this.F.m - this.F.l;
            if(v43 > 0) {
                b0.d(false);
                w w3 = b0.d;
                A0 a01 = b0.a.F;
                if(a01.c > 0) {
                    int v44 = a01.i;
                    if(w3.a(-2) != v44) {
                        if(!b0.c && b0.e) {
                            b0.d(false);
                            b0.b.g.L(f0.q.d);
                            b0.c = true;
                        }
                        if(v44 > 0) {
                            androidx.compose.runtime.a a0 = a01.a(v44);
                            w3.c(v44);
                            b0.d(false);
                            J j0 = b0.b.g;
                            j0.L(f0.p.d);
                            e1.m.C(j0, 0, a0);
                            b0.c = true;
                        }
                    }
                }
                J j1 = b0.b.g;
                j1.L(D.d);
                j1.i[j1.j - j1.g[j1.h - 1].b] = v43;
            }
        }
        int v45 = this.j;
        while(true) {
            A0 a02 = this.F;
            if(a02.k > 0) {
                break;
            }
            int v46 = a02.g;
            if(v46 == a02.h) {
                break;
            }
            this.K();
            b0.e(v45, this.F.p());
            q.a(v46, this.F.g, arrayList6);
        }
        if(z2) {
            if(z) {
                c c0 = this.N;
                J j2 = c0.h;
                if(!j2.K()) {
                    q.c("Cannot end node insertion, there are no pending operations that can be realized.");
                }
                I[] arr_i = j2.g;
                int v47 = j2.h - 1;
                j2.h = v47;
                I i0 = arr_i[v47];
                arr_i[v47] = null;
                c0.g.L(i0);
                int v48 = j2.l - i0.c;
                System.arraycopy(j2.k, v48, c0.g.k, c0.g.l - i0.c, j2.l - v48);
                Arrays.fill(j2.k, j2.l - i0.c, j2.l, null);
                je.n.S(c0.g.j - i0.b, j2.j - i0.b, j2.j, j2.i, c0.g.i);
                j2.l -= i0.c;
                j2.j -= i0.b;
                v6 = 1;
            }
            A0 a03 = this.F;
            if(a03.k <= 0) {
                j0.a("Unbalanced begin/end empty");
            }
            --a03.k;
            int v49 = this.H.v;
            this.H.i();
            if(this.F.k <= 0) {
                this.H.j();
                this.H.e(true);
                androidx.compose.runtime.a a1 = this.M;
                if(this.N.g.J()) {
                    B0 b00 = this.G;
                    b0.b();
                    b0.d(false);
                    w w4 = b0.d;
                    A0 a04 = b0.a.F;
                    if(a04.c > 0) {
                        int v50 = a04.i;
                        if(w4.a(-2) != v50) {
                            if(!b0.c && b0.e) {
                                b0.d(false);
                                b0.b.g.L(f0.q.d);
                                b0.c = true;
                            }
                            if(v50 > 0) {
                                androidx.compose.runtime.a a2 = a04.a(v50);
                                w4.c(v50);
                                b0.d(false);
                                J j3 = b0.b.g;
                                j3.L(f0.p.d);
                                e1.m.C(j3, 0, a2);
                                b0.c = true;
                            }
                        }
                    }
                    b0.c();
                    J j4 = b0.b.g;
                    j4.L(f0.s.d);
                    e1.m.D(j4, 0, a1, 1, b00);
                }
                else {
                    B0 b01 = this.G;
                    c c1 = this.N;
                    b0.b();
                    b0.d(false);
                    w w5 = b0.d;
                    A0 a05 = b0.a.F;
                    if(a05.c > 0) {
                        int v51 = a05.i;
                        if(w5.a(-2) != v51) {
                            if(!b0.c && b0.e) {
                                b0.d(false);
                                b0.b.g.L(f0.q.d);
                                b0.c = true;
                            }
                            if(v51 > 0) {
                                androidx.compose.runtime.a a3 = a05.a(v51);
                                w5.c(v51);
                                b0.d(false);
                                J j5 = b0.b.g;
                                j5.L(f0.p.d);
                                e1.m.C(j5, 0, a3);
                                b0.c = true;
                            }
                        }
                    }
                    b0.c();
                    J j6 = b0.b.g;
                    j6.L(f0.t.d);
                    int v52 = j6.l - j6.g[j6.h - 1].c;
                    Object[] arr_object6 = j6.k;
                    arr_object6[v52] = a1;
                    arr_object6[v52 + 1] = b01;
                    arr_object6[v52 + 2] = c1;
                    this.N = new c();
                }
                this.O = false;
                if(this.c.b != 0) {
                    this.i0(-2 - v49, 0);
                    this.j0(-2 - v49, v6);
                }
            }
        }
        else {
            if(z) {
                b0.a();
            }
            int v53 = b0.a.F.i;
            w w6 = b0.d;
            if(w6.a(-1) > v53) {
                q.c("Missed recording an endGroup");
            }
            if(w6.a(-1) == v53) {
                b0.d(false);
                w6.b();
                b0.b.g.L(f0.m.d);
            }
            int v54 = this.F.i;
            if(v6 != this.n0(v54)) {
                this.j0(v54, v6);
            }
            if(z) {
                v6 = 1;
            }
            this.F.d();
            b0.c();
        }
        h0 h02 = (h0)this.h.remove(this.h.size() - 1);
        if(h02 != null && !z2) {
            ++h02.c;
        }
        this.i = h02;
        this.j = w2.b() + v6;
        this.l = w2.b();
        this.k = w2.b() + v6;
    }

    public final void q() {
        this.p(false);
        n0 n00 = this.A();
        if(n00 != null) {
            int v = n00.a;
            if((v & 1) != 0) {
                n00.a = v | 2;
            }
        }
    }

    public final void r() {
        this.p(true);
    }

    public final void s() {
        this.p(false);
    }

    public final n0 t() {
        n0 n01;
        M0 m00;
        n0 n00 = this.D.isEmpty() ? null : ((n0)this.D.remove(this.D.size() - 1));
        if(n00 != null) {
            int v = n00.a;
            n00.a = v & -9;
            int v1 = this.A;
            F f0 = n00.f;
            if(f0 != null && (v & 16) == 0) {
                Object[] arr_object = f0.b;
                int[] arr_v = f0.c;
                long[] arr_v1 = f0.a;
                int v2 = arr_v1.length - 2;
                if(v2 >= 0) {
                    int v3 = 0;
                    while(true) {
                        long v4 = arr_v1[v3];
                        if((~v4 << 7 & v4 & 0x8080808080808080L) == 0x8080808080808080L) {
                            goto label_30;
                        }
                        int v5 = 8 - (~(v3 - v2) >>> 0x1F);
                        int v6 = 0;
                        while(v6 < v5) {
                            if((v4 & 0xFFL) < 0x80L) {
                                int v7 = (v3 << 3) + v6;
                                Object object0 = arr_object[v7];
                                if(arr_v[v7] != v1) {
                                    m00 = new M0(n00, v1, f0, 1);
                                    goto label_38;
                                }
                            }
                            v4 >>= 8;
                            ++v6;
                        }
                        if(v5 == 8) {
                        label_30:
                            if(v3 != v2) {
                                ++v3;
                                continue;
                            }
                            break;
                        }
                        else {
                            m00 = null;
                        }
                        goto label_38;
                    }
                }
            }
            m00 = null;
        label_38:
            b b0 = this.L;
            if(m00 != null) {
                J j0 = b0.b.g;
                j0.L(f0.l.d);
                e1.m.D(j0, 0, m00, 1, this.g);
            }
            int v8 = n00.a;
            if((v8 & 0x200) != 0) {
                n00.a = v8 & 0xFFFFFDFF;
                J j1 = b0.b.g;
                j1.L(f0.o.d);
                e1.m.C(j1, 0, n00);
            }
        }
        if(n00 == null || ((n00.a & 16) != 0 || (n00.a & 1) == 0 && !this.p)) {
            n01 = null;
        }
        else {
            if(n00.c == null) {
                n00.c = this.O ? this.H.b(this.H.v) : this.F.a(this.F.i);
            }
            n00.a &= -5;
            n01 = n00;
        }
        this.p(false);
        return n01;
    }

    public final void u() {
        boolean z = false;
        this.p(false);
        this.b.b();
        this.p(false);
        b b0 = this.L;
        if(b0.c) {
            b0.d(false);
            b0.d(false);
            b0.b.g.L(f0.m.d);
            b0.c = false;
        }
        b0.b();
        if(b0.d.b != 0) {
            q.c("Missed recording an endGroup()");
        }
        if(!this.h.isEmpty()) {
            q.c("Start/end imbalance");
        }
        this.j();
        this.F.c();
        if(this.w.b() != 0) {
            z = true;
        }
        this.v = z;
    }

    public final void v(int v) {
        if(v < 0) {
            E0 e00 = this.H;
            int v1;
            while((v1 = e00.v) > -v) {
                this.p(e00.w(v1));
            }
        }
        else {
            if(this.O) {
                E0 e01 = this.H;
                while(this.O) {
                    this.p(e01.w(e01.v));
                }
            }
            A0 a00 = this.F;
            int v2;
            while((v2 = a00.i) > v) {
                this.p(a00.i(v2));
            }
        }
    }

    public final void w(boolean z, h0 h00) {
        this.h.add(this.i);
        this.i = h00;
        this.m.c(this.k);
        this.m.c(this.l);
        this.m.c(this.j);
        if(z) {
            this.j = 0;
        }
        this.k = 0;
        this.l = 0;
    }

    public final void x() {
        B0 b00 = new B0();
        if(this.B) {
            b00.g();
        }
        if(this.b.c()) {
            b00.k = new z();
        }
        this.G = b00;
        E0 e00 = b00.k();
        e00.e(true);
        this.H = e00;
    }

    public final i0 y() {
        return this.m();
    }

    // 去混淆评级： 低(20)
    public final int z() {
        return this.O ? -this.H.v : this.F.i;
    }
}

