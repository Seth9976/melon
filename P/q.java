package P;

import Ce.g;
import I.u0;
import M.f;
import M.h;
import M.i0;
import N0.N;
import N0.k0;
import androidx.collection.l;
import androidx.compose.foundation.lazy.layout.C;
import androidx.compose.foundation.lazy.layout.s;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import i.n.i.b.a.s.e.M3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import je.w;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineScope;
import r1.b;
import r1.m;
import we.a;
import we.k;
import we.n;
import y0.z;

public final class q extends r implements n {
    public final F f;
    public final boolean g;
    public final i0 h;
    public final a i;
    public final c j;
    public final h k;
    public final f l;
    public final CoroutineScope m;
    public final C n;

    public q(F f0, boolean z, i0 i00, De.r r0, c c0, h h0, f f1, CoroutineScope coroutineScope0, z z1, C c1) {
        this.f = f0;
        this.g = z;
        this.h = i00;
        this.i = r0;
        this.j = c0;
        this.k = h0;
        this.l = f1;
        this.m = coroutineScope0;
        this.n = c1;
        super(2);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v85;
        o o6;
        int v84;
        s s3;
        p p2;
        int v83;
        int v82;
        androidx.compose.foundation.lazy.layout.z z11;
        ArrayList arrayList2;
        ArrayList arrayList1;
        androidx.compose.foundation.lazy.layout.z z10;
        int v64;
        u u7;
        o o5;
        int v61;
        int v60;
        androidx.compose.foundation.lazy.layout.z z8;
        w w6;
        w w5;
        int v50;
        t t3;
        int v47;
        o o3;
        int v44;
        B b2;
        int v40;
        u u4;
        int v38;
        int v37;
        int v36;
        boolean z7;
        int v24;
        P.s s2;
        int v16;
        int v15;
        androidx.compose.foundation.lazy.layout.z z2;
        float f7;
        P.w w0;
        int v2;
        int v1;
        long v = ((r1.a)object1).a;
        F f0 = this.f;
        f0.s.getValue();
        boolean z = f0.b || ((androidx.compose.foundation.lazy.layout.z)object0).b.u();
        boolean z1 = this.g;
        androidx.compose.foundation.q.k((z1 ? u0.a : u0.b), v);
        i0 i00 = this.h;
        if(z1) {
            float f1 = i00.b(((androidx.compose.foundation.lazy.layout.z)object0).b.getLayoutDirection());
            v1 = ((androidx.compose.foundation.lazy.layout.z)object0).b.z(f1);
        }
        else {
            m m0 = ((androidx.compose.foundation.lazy.layout.z)object0).b.getLayoutDirection();
            float f2 = m0 == m.a ? i00.b(m0) : i00.c(m0);
            v1 = ((androidx.compose.foundation.lazy.layout.z)object0).b.z(f2);
        }
        if(z1) {
            float f3 = i00.c(((androidx.compose.foundation.lazy.layout.z)object0).b.getLayoutDirection());
            v2 = ((androidx.compose.foundation.lazy.layout.z)object0).b.z(f3);
        }
        else {
            m m1 = ((androidx.compose.foundation.lazy.layout.z)object0).b.getLayoutDirection();
            float f4 = m1 == m.a ? i00.c(m1) : i00.b(m1);
            v2 = ((androidx.compose.foundation.lazy.layout.z)object0).b.z(f4);
        }
        float f5 = i00.d();
        k0 k00 = ((androidx.compose.foundation.lazy.layout.z)object0).b;
        int v3 = ((androidx.compose.foundation.lazy.layout.z)object0).b.z(f5);
        int v4 = k00.z(i00.a()) + v3;
        int v5 = v1 + v2;
        int v6 = z1 ? v3 : v1;
        long v7 = b.i(-v5, -v4, v);
        j j0 = (j)this.i.invoke();
        B7.b b0 = j0.c;
        B b1 = j0.b.b;
        c c0 = this.j;
        i i0 = j0.b;
        if(c0.d == null || !r1.a.b(c0.b, v7) || c0.c != k00.b()) {
            c0.b = v7;
            c0.c = k00.b();
            r1.a a0 = new r1.a(v7);
            P.w w1 = (P.w)((n)c0.a).invoke(((androidx.compose.foundation.lazy.layout.z)object0), a0);
            c0.d = w1;
            w0 = w1;
        }
        else {
            w0 = c0.d;
            kotlin.jvm.internal.q.d(w0);
        }
        if(w0.a.length != b1.i) {
            b1.i = w0.a.length;
            b1.b.clear();
            x x0 = new x(0, 0);
            b1.b.add(x0);
            b1.c = 0;
            b1.d = 0;
            b1.e = 0;
            b1.f = -1;
            b1.g.clear();
        }
        f f6 = this.l;
        h h0 = this.k;
        if(z1) {
            if(h0 != null) {
                f7 = h0.a();
                goto label_63;
            }
            L.a.b("null verticalArrangement when isVertical == true");
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        if(f6 != null) {
            f7 = f6.a();
        label_63:
            int v8 = k00.z(f7);
            int v9 = i0.n().a;
            int v10 = z1 ? r1.a.g(v) - v4 : r1.a.h(v) - v5;
            int v11 = (z1 ? v4 : v5) - v6;
            o o0 = new o(j0, ((androidx.compose.foundation.lazy.layout.z)object0), v8, this.f, this.g, v6, v11, ((long)v1) << 0x20 | ((long)v3) & 0xFFFFFFFFL);
            p p0 = new p(this.g, w0, v9, v8, o0, b1);
            Ld.p p1 = new Ld.p(2, b1, p0);
            p0.h h1 = p0.q.d();
            k k0 = h1 == null ? null : h1.e();
            p0.h h2 = p0.q.e(h1);
            try {
                O.x x1 = this.f.d;
                int v13 = x1.a();
                int v14 = androidx.compose.foundation.lazy.layout.j.l(v13, j0, x1.e);
                if(v13 == v14) {
                    z2 = (androidx.compose.foundation.lazy.layout.z)object0;
                }
                else {
                    z2 = (androidx.compose.foundation.lazy.layout.z)object0;
                    ((K0)x1.b).n(v14);
                    x1.f.a(v13);
                }
                if(v14 < v9 || v9 <= 0) {
                    v15 = b1.c(v14);
                    v16 = x1.b();
                }
                else {
                    v15 = b1.c(v9 - 1);
                    v16 = 0;
                }
            }
            finally {
                p0.q.g(h1, h2, k0);
            }
            List list0 = androidx.compose.foundation.lazy.layout.j.j(j0, f0.q, f0.n);
            float f8 = k00.u() || !z ? f0.g : ((Number)((O0)((G.p)f0.v.a).b).getValue()).floatValue();
            boolean z3 = k00.u();
            b0 b00 = f0.r;
            int v17 = v15;
            P.s s0 = f0.c;
            s s1 = f0.m;
            androidx.compose.foundation.lazy.layout.z z4 = z2;
            O.o o1 = new O.o(z4, v, v5, v4, 1);
            if(v6 < 0) {
                L.a.a("negative beforeContentPadding");
            }
            if(v11 < 0) {
                L.a.a("negative afterContentPadding");
            }
            CoroutineScope coroutineScope0 = this.m;
            w w2 = w.a;
            if(v9 <= 0) {
                int v18 = r1.a.j(v7);
                int v19 = r1.a.i(v7);
                s1.c(v18, v19, new ArrayList(), b0, o0, z3, w0.a.length, z, 0, 0);
                if(!z3) {
                    s1.b();
                }
                s2 = new P.s(null, 0, false, 0.0f, ((N)o1.invoke(v18, v19, P.r.g)), 0.0f, false, coroutineScope0, z4, w0.a.length, p1, w2, -v6, v10 + v11, 0, (z1 ? u0.a : u0.b), v11, v8);
            }
            else {
                o o2 = o0;
                int v20 = Math.round(f8);
                int v21 = v16 - v20;
                if(v17 == 0 && v21 < 0) {
                    v20 += v21;
                    v21 = 0;
                }
                je.m m2 = new je.m();
                int v22 = (v8 >= 0 ? 0 : v8) - v6;
                int v23 = v21 + v22;
                while(v23 < 0 && v17 > 0) {
                    u u0 = p0.b(v17 - 1);
                    m2.add(0, u0);
                    v23 += u0.h;
                    --v17;
                }
                if(v23 < v22) {
                    v24 = v20 - (v22 - v23);
                    v23 = v22;
                }
                else {
                    v24 = v20;
                }
                int v25 = v23 - v22;
                int v26 = v10 + v11;
                int v27 = v26;
                if(v26 < 0) {
                    v26 = 0;
                }
                int v28 = v25;
                int v29 = -v25;
                int v30 = v17;
                int v31 = 0;
                boolean z5 = false;
                while(v31 < m2.c) {
                    if(v29 >= v26) {
                        m2.d(v31);
                        z5 = true;
                    }
                    else {
                        ++v30;
                        v29 += ((u)m2.get(v31)).h;
                        ++v31;
                    }
                }
                boolean z6 = z5;
                for(int v32 = v30; true; ++v32) {
                    if(v32 >= v9 || v29 >= v26 && v29 > 0 && !m2.isEmpty()) {
                        z7 = z6;
                        break;
                    }
                    z7 = z6;
                    u u1 = p0.b(v32);
                    int v33 = u1.h;
                    t[] arr_t = u1.b;
                    if(arr_t.length == 0) {
                        break;
                    }
                    v29 += v33;
                    if(v29 > v22 || ((t)je.n.s0(arr_t)).a == v9 - 1) {
                        m2.addLast(u1);
                        z6 = z7;
                    }
                    else {
                        v28 -= v33;
                        v17 = v32 + 1;
                        z6 = true;
                    }
                }
                if(v29 < v10) {
                    int v34 = v10 - v29;
                    int v35 = v29 + v34;
                    v36 = v28 - v34;
                    while(v36 < v6 && v17 > 0) {
                        u u2 = p0.b(v17 - 1);
                        m2.add(0, u2);
                        v36 += u2.h;
                        --v17;
                    }
                    v37 = v24 + v34;
                    if(v36 < 0) {
                        v37 += v36;
                        v38 = v35 + v36;
                        v36 = 0;
                    }
                    else {
                        v38 = v35;
                    }
                }
                else {
                    v37 = v24;
                    v38 = v29;
                    v36 = v28;
                }
                float f9 = Integer.signum(Math.round(f8)) != Integer.signum(v37) || Math.abs(Math.round(f8)) < Math.abs(v37) ? f8 : ((float)v37);
                float f10 = f8 - f9;
                if(v36 < 0) {
                    L.a.a("negative initial offset");
                }
                u u3 = (u)m2.first();
                t t0 = (t)je.n.i0(u3.b);
                int v39 = t0 == null ? 0 : t0.a;
                Object object2 = m2.k();
                if(((u)object2) == null) {
                    u4 = u3;
                    v40 = 0;
                }
                else {
                    t[] arr_t1 = ((u)object2).b;
                    u4 = u3;
                    t t1 = arr_t1.length == 0 ? null : arr_t1[arr_t1.length - 1];
                    v40 = t1 == null ? 0 : t1.a;
                }
                int v41 = list0.size();
                int v42 = 0;
                w w3 = null;
                while(true) {
                    b2 = p0.f;
                    if(v42 >= v41) {
                        break;
                    }
                    int v43 = ((Number)list0.get(v42)).intValue();
                    if(v43 < 0 || v43 >= v39) {
                        o3 = o2;
                        v44 = v42;
                    }
                    else {
                        v44 = v42;
                        int v45 = b2.e(v43);
                        t t2 = o2.a(v43, p0.a(0, v45), 0, v45, o2.c);
                        o3 = o2;
                        if(w3 == null) {
                            w3 = new ArrayList();
                        }
                        w3.add(t2);
                    }
                    v42 = v44 + 1;
                    o2 = o3;
                }
                o o4 = o2;
                w w4 = w3 == null ? w2 : w3;
                if(!z3 || s0 == null) {
                    v47 = v39;
                    z8 = z4;
                    w6 = w4;
                    v50 = v40;
                    w5 = null;
                }
                else {
                    Object object3 = s0.l;
                    if(((Collection)object3).isEmpty()) {
                        v47 = v39;
                        z8 = z4;
                        w6 = w4;
                        v50 = v40;
                        w5 = null;
                    }
                    else {
                        int v46 = ((List)object3).size() - 1;
                        v47 = v39;
                        while(true) {
                            t3 = null;
                            if(-1 >= v46) {
                                break;
                            }
                            if(((t)((List)object3).get(v46)).a > v40 && (v46 == 0 || ((t)((List)object3).get(v46 - 1)).a <= v40)) {
                                t3 = (t)((List)object3).get(v46);
                                break;
                            }
                            --v46;
                        }
                        t t4 = (t)je.p.s0(((List)object3));
                        u u5 = (u)je.p.t0(m2);
                        int v48 = u5 == null ? 0 : u5.a + 1;
                        if(t3 == null) {
                            z8 = z4;
                            w6 = w4;
                            v50 = v40;
                            w5 = null;
                        }
                        else {
                            int v49 = t3.a;
                            v50 = v40;
                            int v51 = Math.min(t4.a, v9 - 1);
                            if(v49 <= v51) {
                                w5 = null;
                                while(true) {
                                    if(w5 == null) {
                                        z8 = z4;
                                        w6 = w4;
                                    }
                                    else {
                                        w6 = w4;
                                        int v52 = w5.size();
                                        z8 = z4;
                                        int v53 = 0;
                                        while(v53 < v52) {
                                            Object object4 = w5.get(v53);
                                            t[] arr_t2 = ((u)object4).b;
                                            int v54 = 0;
                                            while(v54 < ((u)object4).b.length) {
                                                if(arr_t2[v54].a == v49) {
                                                    goto label_281;
                                                }
                                                ++v54;
                                            }
                                            ++v53;
                                        }
                                    }
                                    if(w5 == null) {
                                        w5 = new ArrayList();
                                    }
                                    u u6 = p0.b(v48);
                                    ++v48;
                                    w5.add(u6);
                                label_281:
                                    if(v49 == v51) {
                                        break;
                                    }
                                    ++v49;
                                    w4 = w6;
                                    z4 = z8;
                                }
                            }
                            else {
                                z8 = z4;
                                w6 = w4;
                                w5 = null;
                            }
                        }
                    }
                }
                if(w5 == null) {
                    w5 = w2;
                }
                int v55 = list0.size();
                int v56 = 0;
                w w7 = null;
                while(v56 < v55) {
                    int v57 = ((Number)list0.get(v56)).intValue();
                    if(v50 + 1 > v57 || v57 >= v9) {
                        v60 = v55;
                        v61 = v56;
                    }
                    else {
                        if(z3) {
                            int v58 = w5.size();
                            int v59 = 0;
                            while(v59 < v58) {
                                Object object5 = w5.get(v59);
                                v60 = v55;
                                v61 = v56;
                                t[] arr_t3 = ((u)object5).b;
                                int v62 = 0;
                                while(v62 < ((u)object5).b.length) {
                                    if(arr_t3[v62].a == v57) {
                                        goto label_332;
                                    }
                                    ++v62;
                                }
                                ++v59;
                                v56 = v61;
                                v55 = v60;
                            }
                        }
                        v60 = v55;
                        v61 = v56;
                        int v63 = b2.e(v57);
                        o5 = o4;
                        t t5 = o5.a(v57, p0.a(0, v63), 0, v63, o4.c);
                        if(w7 == null) {
                            w7 = new ArrayList();
                        }
                        w7.add(t5);
                        goto label_333;
                    }
                label_332:
                    o5 = o4;
                label_333:
                    v56 = v61 + 1;
                    o4 = o5;
                    v55 = v60;
                }
                w w8 = w7 == null ? w2 : w7;
                if(v6 > 0 || v8 < 0) {
                    int v65 = m2.b();
                    u u8 = u4;
                    int v66 = v36;
                    int v67 = 0;
                    while(v67 < v65) {
                        int v68 = ((u)m2.get(v67)).h;
                        if(v66 == 0 || v68 > v66 || v67 == e.k.s(m2)) {
                            break;
                        }
                        v66 -= v68;
                        ++v67;
                        u8 = (u)m2.get(v67);
                    }
                    v64 = v66;
                    u7 = u8;
                }
                else {
                    u7 = u4;
                    v64 = v36;
                }
                int v69 = z1 ? r1.a.h(v7) : b.g(v38, v7);
                int v70 = z1 ? b.f(v38, v7) : r1.a.g(v7);
                if(!w5.isEmpty()) {
                    m2 = je.p.A0(m2, w5);
                }
                int v71 = z1 ? v70 : v69;
                boolean z9 = v38 < Math.min(v71, v10);
                if(z9 && -v36 != 0) {
                    L.a.c("non-zero firstLineScrollOffset");
                }
                int v72 = m2.size();
                int v74 = 0;
                for(int v73 = 0; v73 < v72; ++v73) {
                    v74 += ((u)m2.get(v73)).b.length;
                }
                ArrayList arrayList0 = new ArrayList(v74);
                if(z9) {
                    if(!w6.isEmpty() || !w8.isEmpty()) {
                        L.a.a("no items");
                    }
                    int v75 = m2.size();
                    int[] arr_v = new int[v75];
                    for(int v76 = 0; v76 < v75; ++v76) {
                        arr_v[v76] = ((u)m2.get(v76)).g;
                    }
                    int[] arr_v1 = new int[v75];
                    if(z1) {
                        if(h0 != null) {
                            z10 = z8;
                            h0.c(z10, v71, arr_v, arr_v1);
                            arrayList1 = arrayList0;
                            goto label_394;
                        }
                        L.a.b("null verticalArrangement");
                    }
                    else {
                        z10 = z8;
                        if(f6 != null) {
                            arrayList1 = arrayList0;
                            f6.d(z10, v71, arr_v, m.a, arr_v1);
                        label_394:
                            g g0 = je.n.j0(arr_v1);
                            int v77 = g0.a;
                            int v78 = g0.b;
                            int v79 = g0.c;
                            if(v79 > 0 && v77 <= v78 || v79 < 0 && v78 <= v77) {
                                while(true) {
                                    int v80 = arr_v1[v77];
                                    t[] arr_t4 = ((u)m2.get(v77)).a(v80, v69, v70);
                                    t[] arr_t5 = arr_t4;
                                    for(int v81 = 0; v81 < arr_t4.length; ++v81) {
                                        arrayList1.add(arr_t5[v81]);
                                    }
                                    if(v77 == v78) {
                                        break;
                                    }
                                    v77 += v79;
                                }
                            }
                            arrayList2 = arrayList1;
                            z11 = z10;
                            v82 = v38;
                            v83 = v70;
                            p2 = p0;
                            s3 = s1;
                            v84 = w0.a.length;
                            o6 = o4;
                            v85 = v50;
                            goto label_468;
                        }
                        L.a.b("null horizontalArrangement");
                    }
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                else {
                    p2 = p0;
                    v85 = v50;
                    androidx.compose.foundation.lazy.layout.z z12 = z8;
                    int v86 = w6.size() - 1;
                    if(v86 >= 0) {
                        int v87 = -v36;
                        while(true) {
                            z11 = z12;
                            t t6 = (t)w6.get(v86);
                            v87 -= t6.m;
                            t6.g(v87, v69, v70);
                            arrayList0.add(t6);
                            if(v86 - 1 < 0) {
                                break;
                            }
                            --v86;
                            z12 = z11;
                        }
                    }
                    else {
                        z11 = z12;
                    }
                    int v88 = m2.size();
                    int v89 = -v36;
                    for(int v90 = 0; v90 < v88; ++v90) {
                        Object object6 = m2.get(v90);
                        t[] arr_t6 = ((u)object6).a(v89, v69, v70);
                        t[] arr_t7 = arr_t6;
                        for(int v91 = 0; v91 < arr_t6.length; ++v91) {
                            arrayList0.add(arr_t7[v91]);
                        }
                        v89 += ((u)object6).h;
                    }
                    int v92 = w8.size();
                    for(int v93 = 0; v93 < v92; ++v93) {
                        t t7 = (t)w8.get(v93);
                        t7.g(v89, v69, v70);
                        arrayList0.add(t7);
                        v89 += t7.m;
                    }
                    arrayList2 = arrayList0;
                    v82 = v38;
                    v83 = v70;
                    s3 = s1;
                    v84 = w0.a.length;
                    o6 = o4;
                }
            label_468:
                s3.c(v69, v83, arrayList2, b0, o6, z3, v84, z, v64, v82);
                if(!z3) {
                    s3.b();
                }
                Ld.p p3 = new Ld.p(3, p2, o6);
                List list1 = androidx.compose.foundation.lazy.layout.j.i(this.n, arrayList2, l.a, v6, v69, v83, p3);
                s2 = new P.s(u7, v64, v85 != v9 - 1 || v82 > v10, f9, ((N)o1.invoke(v69, v83, new O.t(b00, arrayList2, list1, z3, 1))), (!z3 || v37 <= v24 || f10 > 0.0f ? 0.0f : ((float)(v37 - v24)) + f10), z7, coroutineScope0, z11, v84, p1, androidx.compose.foundation.lazy.layout.j.s(v47, v85, arrayList2, list1), -v6, v27, v9, (z1 ? u0.a : u0.b), v11, v8);
            }
            f0.f(s2, k00.u(), false);
            return s2;
        }
        L.a.b("null horizontalArrangement when isVertical == false");
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }
}

