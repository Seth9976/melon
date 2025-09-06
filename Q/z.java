package Q;

import I.u0;
import J.l;
import Ld.p;
import M.i0;
import N0.N;
import N0.k0;
import O.o;
import androidx.compose.foundation.lazy.layout.D;
import androidx.compose.foundation.lazy.layout.j;
import androidx.compose.foundation.q;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import java.util.ArrayList;
import java.util.List;
import je.w;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineScope;
import r0.g;
import r0.h;
import r1.b;
import we.a;
import we.k;
import we.n;

public final class z extends r implements n {
    public final K f;
    public final u0 g;
    public final i0 h;
    public final float i;
    public final m j;
    public final a k;
    public final a l;
    public final h m;
    public final g n;
    public final int o;
    public final l r;
    public final CoroutineScope w;

    public z(K k0, u0 u00, i0 i00, float f, m m0, De.r r0, a a0, h h0, g g0, int v, l l0, CoroutineScope coroutineScope0) {
        this.f = k0;
        this.g = u00;
        this.h = i00;
        this.i = f;
        this.j = m0;
        this.k = r0;
        this.l = a0;
        this.m = h0;
        this.n = g0;
        this.o = v;
        this.r = l0;
        this.w = coroutineScope0;
        super(2);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v17;
        int v15;
        Object object10;
        w w4;
        w w3;
        ArrayList arrayList6;
        w w2;
        je.m m8;
        ArrayList arrayList5;
        int v91;
        int v90;
        int v87;
        int v70;
        ArrayList arrayList1;
        long v66;
        int v60;
        g g2;
        int v59;
        int v63;
        int v57;
        int v56;
        int v55;
        je.m m6;
        g g1;
        int v54;
        je.m m5;
        int v49;
        h h3;
        androidx.compose.foundation.lazy.layout.z z3;
        int v47;
        long v46;
        int v45;
        int v44;
        int v43;
        int v42;
        je.m m4;
        g g0;
        h h2;
        k0 k01;
        A a0;
        long v16;
        int v2;
        int v1;
        long v = ((r1.a)object1).a;
        K k0 = this.f;
        k0.E.getValue();
        u0 u00 = u0.a;
        u0 u01 = this.g;
        boolean z = u01 == u00;
        q.k((z ? u00 : u0.b), v);
        i0 i00 = this.h;
        if(z) {
            float f = i00.b(((androidx.compose.foundation.lazy.layout.z)object0).b.getLayoutDirection());
            v1 = ((androidx.compose.foundation.lazy.layout.z)object0).b.z(f);
        }
        else {
            r1.m m0 = ((androidx.compose.foundation.lazy.layout.z)object0).b.getLayoutDirection();
            float f1 = m0 == r1.m.a ? i00.b(m0) : i00.c(m0);
            v1 = ((androidx.compose.foundation.lazy.layout.z)object0).b.z(f1);
        }
        if(z) {
            float f2 = i00.c(((androidx.compose.foundation.lazy.layout.z)object0).b.getLayoutDirection());
            v2 = ((androidx.compose.foundation.lazy.layout.z)object0).b.z(f2);
        }
        else {
            r1.m m1 = ((androidx.compose.foundation.lazy.layout.z)object0).b.getLayoutDirection();
            float f3 = m1 == r1.m.a ? i00.c(m1) : i00.b(m1);
            v2 = ((androidx.compose.foundation.lazy.layout.z)object0).b.z(f3);
        }
        float f4 = i00.d();
        int v3 = ((androidx.compose.foundation.lazy.layout.z)object0).b.z(f4);
        float f5 = i00.a();
        k0 k00 = ((androidx.compose.foundation.lazy.layout.z)object0).b;
        int v4 = k00.z(f5) + v3;
        int v5 = v1 + v2;
        v2 = z ? v3 : v1;
        int v6 = (z ? v4 : v5) - v2;
        long v7 = b.i(-v5, -v4, v);
        k0.q = (androidx.compose.foundation.lazy.layout.z)object0;
        int v8 = k00.z(this.i);
        int v9 = z ? r1.a.g(v) - v4 : r1.a.h(v) - v5;
        long v10 = ((long)v1) << 0x20 | ((long)v3) & 0xFFFFFFFFL;
        int v11 = this.j.a(((androidx.compose.foundation.lazy.layout.z)object0), v9);
        int v12 = v11 >= 0 ? v11 : 0;
        k0.B = b.b((u01 == u00 ? r1.a.h(v7) : v12), (u01 == u00 ? v12 : r1.a.g(v7)), 5);
        x x0 = (x)this.k.invoke();
        l l0 = this.r;
        p0.h h0 = p0.q.d();
        k k1 = h0 == null ? null : h0.e();
        p0.h h1 = p0.q.e(h0);
        try {
            int v14 = k0.j();
            C c0 = k0.d;
            v15 = j.l(v14, x0, c0.e);
            if(v14 == v15) {
                v16 = v7;
            }
            else {
                v16 = v7;
                ((K0)(((a0)c0.c))).n(v15);
                ((D)c0.f).a(v14);
            }
            k0.j();
            float f6 = c0.a();
            k0.l();
            l0.getClass();
            v17 = v12 + v8;
            int v18 = ye.a.V(0.0f - f6 * ((float)v17));
        }
        finally {
            p0.q.g(h0, h1, k1);
        }
        List list0 = j.j(x0, k0.C, k0.x);
        int v19 = ((Number)this.l.invoke()).intValue();
        b0 b00 = k0.D;
        int v20 = v15;
        o o0 = new o(((androidx.compose.foundation.lazy.layout.z)object0), v, v5, v4, 2);
        if(v2 < 0) {
            L.a.a("negative beforeContentPadding");
        }
        if(v6 < 0) {
            L.a.a("negative afterContentPadding");
        }
        int v21 = v17 >= 0 ? v17 : 0;
        int v22 = this.o;
        l l1 = this.r;
        CoroutineScope coroutineScope0 = this.w;
        if(v19 <= 0) {
            a0 = new A(v12, v8, v6, u01, -v2, v9 + v6, v22, l1, ((N)o0.invoke(r1.a.j(v16), r1.a.i(v16), d.h)), coroutineScope0);
            k01 = k00;
        }
        else {
            long v23 = b.b((u01 == u00 ? r1.a.h(v16) : v12), (u01 == u00 ? v12 : r1.a.g(v16)), 5);
            int v24;
            for(v24 = v18; v20 > 0 && v24 > 0; v24 -= v21) {
                --v20;
            }
            int v25 = -v24;
            if(v20 >= v19) {
                v20 = v19 - 1;
                v25 = 0;
            }
            je.m m2 = new je.m();
            int v26 = (v8 >= 0 ? 0 : v8) - v2;
            int v27 = v25 + v26;
            int v28 = 0;
            while(true) {
                h2 = this.m;
                g0 = this.n;
                if(v27 >= 0 || v20 <= 0) {
                    break;
                }
                Q.j j0 = y5.a.A(((androidx.compose.foundation.lazy.layout.z)object0), v20 - 1, v23, x0, v10, u01, g0, h2, k00.getLayoutDirection(), false, v12);
                m2.add(0, j0);
                v28 = Math.max(v28, j0.j);
                --v20;
                v27 += v21;
            }
            int v29 = v28;
            int v30 = v21;
            int v31 = v27;
            je.m m3 = m2;
            if(v31 < v26) {
                v31 = v26;
            }
            int v32 = v31 - v26;
            int v33 = v9 + v6;
            int v34 = v33 >= 0 ? v33 : 0;
            int v35 = -v32;
            int v36 = v20;
            int v37 = 0;
            boolean z1 = false;
            while(v37 < m3.c) {
                if(v35 >= v34) {
                    m3.d(v37);
                    z1 = true;
                }
                else {
                    ++v36;
                    v35 += v30;
                    ++v37;
                }
            }
            int v38 = v35;
            int v39 = v32;
            int v40 = v36;
            boolean z2 = z1;
            int v41 = v20;
            while(true) {
                if(v40 >= v19) {
                    m4 = m3;
                    v42 = v19;
                    v43 = v38;
                    v44 = v12;
                    v46 = v23;
                    v47 = v29;
                    z3 = (androidx.compose.foundation.lazy.layout.z)object0;
                    h3 = h2;
                    v45 = v9;
                    break;
                }
                if(v38 >= v34 && v38 > 0 && !m3.isEmpty()) {
                    m4 = m3;
                    v42 = v19;
                    v43 = v38;
                    v44 = v12;
                    v45 = v9;
                    v46 = v23;
                    v47 = v29;
                    z3 = (androidx.compose.foundation.lazy.layout.z)object0;
                    h3 = h2;
                    break;
                }
                Q.j j1 = y5.a.A(((androidx.compose.foundation.lazy.layout.z)object0), v40, v23, x0, v10, u01, g0, h2, k00.getLayoutDirection(), false, v12);
                int v48 = v38 + (v40 == v19 - 1 ? v12 : v30);
                if(v48 > v26 || v40 == v19 - 1) {
                    v49 = Math.max(v29, j1.j);
                    m5 = m3;
                    m5.addLast(j1);
                }
                else {
                    v39 -= v30;
                    z2 = true;
                    v41 = v40 + 1;
                    v49 = v29;
                    m5 = m3;
                }
                ++v40;
                m3 = m5;
                v38 = v48;
                v29 = v49;
            }
            if(v43 < v45) {
                int v50 = v45 - v43;
                int v51 = v43 + v50;
                int v52 = v47;
                int v53;
                for(v53 = v39 - v50; v53 < v2 && v41 > 0; v53 += v30) {
                    --v41;
                    Q.j j2 = y5.a.A(z3, v41, v46, x0, v10, u01, g0, h3, k00.getLayoutDirection(), false, v44);
                    m4.add(0, j2);
                    v52 = Math.max(v52, j2.j);
                }
                v54 = v40;
                g1 = g0;
                m6 = m4;
                v55 = v45;
                if(v53 < 0) {
                    v43 = v51 + v53;
                    v56 = v52;
                    v57 = 0;
                }
                else {
                    v43 = v51;
                    v56 = v52;
                    v57 = v53;
                }
            }
            else {
                v55 = v45;
                m6 = m4;
                v54 = v40;
                g1 = g0;
                v56 = v47;
                v57 = v39;
            }
            if(v57 < 0) {
                L.a.a("invalid currentFirstPageScrollOffset");
            }
            int v58 = -v57;
            Q.j j3 = (Q.j)m6.first();
            if(v2 > 0 || v8 < 0) {
                int v61 = m6.b();
                v59 = v43;
                int v62 = 0;
                while(true) {
                    if(v62 >= v61 || v57 == 0) {
                        g2 = g1;
                        v60 = v30;
                        v63 = v57;
                        break;
                    }
                    g2 = g1;
                    v60 = v30;
                    v63 = v57;
                    if(v60 > v57 || v62 == e.k.s(m6)) {
                        break;
                    }
                    v57 = v63 - v60;
                    ++v62;
                    j3 = (Q.j)m6.get(v62);
                    v30 = v60;
                    g1 = g2;
                }
                v57 = v63;
            }
            else {
                v59 = v43;
                g2 = g1;
                v60 = v30;
            }
            je.m m7 = m6;
            y y0 = new y(z3, v46, x0, v10, u01, g2, h3, v44, 1);
            int v64 = Math.max(0, v41 - v22);
            int v65 = v41 - 1;
            if(v64 <= v65) {
                ArrayList arrayList0 = null;
                while(true) {
                    if(arrayList0 == null) {
                        arrayList0 = new ArrayList();
                    }
                    v66 = v46;
                    arrayList1 = arrayList0;
                    arrayList1.add(y0.invoke(v65));
                    if(v65 == v64) {
                        break;
                    }
                    --v65;
                    arrayList0 = arrayList1;
                    v46 = v66;
                }
            }
            else {
                v66 = v46;
                arrayList1 = null;
            }
            int v67 = list0.size();
            ArrayList arrayList2 = arrayList1;
            for(int v68 = 0; v68 < v67; v68 = v70 + 1) {
                int v69 = ((Number)list0.get(v68)).intValue();
                if(v69 < v64) {
                    if(arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    v70 = v68;
                    arrayList2.add(y0.invoke(v69));
                }
                else {
                    v70 = v68;
                }
            }
            w w0 = w.a;
            w w1 = arrayList2 == null ? w0 : arrayList2;
            int v71 = w1.size();
            int v72 = v56;
            for(int v73 = 0; v73 < v71; ++v73) {
                v72 = Math.max(v72, ((Q.j)w1.get(v73)).j);
            }
            int v74 = ((Q.j)m7.last()).a;
            y y1 = new y(z3, v66, x0, v10, u01, g2, h3, v44, 0);
            int v75 = Math.min(v74 + v22, v42 - 1);
            int v76 = v74 + 1;
            ArrayList arrayList3 = null;
            if(v76 <= v75) {
                while(true) {
                    if(arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    arrayList3.add(y1.invoke(v76));
                    if(v76 == v75) {
                        break;
                    }
                    ++v76;
                }
            }
            int v77 = list0.size();
            for(int v78 = 0; v78 < v77; ++v78) {
                int v79 = ((Number)list0.get(v78)).intValue();
                if(v75 + 1 <= v79 && v79 < v42) {
                    if(arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    arrayList3.add(y1.invoke(v79));
                }
            }
            if(arrayList3 == null) {
                arrayList3 = w0;
            }
            int v80 = arrayList3.size();
            int v81 = v72;
            for(int v82 = 0; v82 < v80; ++v82) {
                v81 = Math.max(v81, ((Q.j)arrayList3.get(v82)).j);
            }
            int v83 = !kotlin.jvm.internal.q.b(j3, m7.first()) || !w1.isEmpty() || !arrayList3.isEmpty() ? 0 : 1;
            u0 u02 = u0.a;
            int v84 = b.g((u01 == u02 ? v81 : v59), v16);
            if(u01 == u02) {
                v81 = v59;
            }
            int v85 = b.f(v81, v16);
            int v86 = u01 == u02 ? v85 : v84;
            boolean z4 = v59 < Math.min(v86, v55);
            if(!z4 || v58 == 0) {
                v87 = v58;
            }
            else {
                v87 = v58;
                L.a.c(("non-zero pagesScrollOffset=" + v87));
            }
            ArrayList arrayList4 = new ArrayList(arrayList3.size() + (w1.size() + m7.b()));
            if(z4) {
                if(!w1.isEmpty() || !arrayList3.isEmpty()) {
                    L.a.a("No extra pages");
                }
                int v88 = m7.b();
                int[] arr_v = new int[v88];
                for(int v89 = 0; v89 < v88; ++v89) {
                    arr_v[v89] = v44;
                }
                int[] arr_v1 = new int[v88];
                v90 = v83;
                k01 = k00;
                M.g g3 = new M.g(k00.R(v8), false, null);
                if(u01 == u0.a) {
                    g3.c(z3, v86, arr_v, arr_v1);
                    v91 = v55;
                    arrayList5 = arrayList4;
                }
                else {
                    v91 = v55;
                    arrayList5 = arrayList4;
                    g3.d(z3, v86, arr_v, r1.m.a, arr_v1);
                }
                Ce.g g4 = je.n.j0(arr_v1);
                int v92 = g4.a;
                int v93 = g4.b;
                int v94 = g4.c;
                if((v94 <= 0 || v92 > v93) && (v94 >= 0 || v93 > v92)) {
                    m8 = m7;
                }
                else {
                    while(true) {
                        int v95 = arr_v1[v92];
                        m8 = m7;
                        Object object2 = m8.get(v92);
                        ((Q.j)object2).b(v95, v84, v85);
                        arrayList5.add(((Q.j)object2));
                        if(v92 == v93) {
                            break;
                        }
                        v92 += v94;
                        m7 = m8;
                    }
                }
                w2 = w1;
            }
            else {
                k01 = k00;
                arrayList5 = arrayList4;
                v90 = v83;
                m8 = m7;
                v91 = v55;
                int v96 = w1.size();
                int v97 = v87;
                for(int v98 = 0; v98 < v96; ++v98) {
                    Object object3 = w1.get(v98);
                    v97 -= v17;
                    ((Q.j)object3).b(v97, v84, v85);
                    arrayList5.add(((Q.j)object3));
                }
                w2 = w1;
                int v99 = m8.b();
                int v100 = v87;
                for(int v101 = 0; v101 < v99; ++v101) {
                    Q.j j4 = (Q.j)m8.get(v101);
                    j4.b(v100, v84, v85);
                    arrayList5.add(j4);
                    v100 += v17;
                }
                int v102 = arrayList3.size();
                for(int v103 = 0; v103 < v102; ++v103) {
                    Q.j j5 = (Q.j)arrayList3.get(v103);
                    j5.b(v100, v84, v85);
                    arrayList5.add(j5);
                    v100 += v17;
                }
            }
            if(v90 == 0) {
                arrayList6 = new ArrayList(arrayList5.size());
                int v104 = arrayList5.size();
                for(int v105 = 0; v105 < v104; ++v105) {
                    Object object4 = arrayList5.get(v105);
                    Q.j j6 = (Q.j)object4;
                    Object object5 = m8.first();
                    if(j6.a >= ((Q.j)object5).a) {
                        int v106 = ((Q.j)m8.last()).a;
                        if(j6.a <= v106) {
                            arrayList6.add(object4);
                        }
                    }
                }
            }
            else {
                arrayList6 = arrayList5;
            }
            if(w2.isEmpty()) {
                w3 = w0;
            }
            else {
                ArrayList arrayList7 = new ArrayList(arrayList5.size());
                int v107 = arrayList5.size();
                for(int v108 = 0; v108 < v107; ++v108) {
                    Object object6 = arrayList5.get(v108);
                    Object object7 = m8.first();
                    if(((Q.j)object6).a < ((Q.j)object7).a) {
                        arrayList7.add(object6);
                    }
                }
                w3 = arrayList7;
            }
            if(arrayList3.isEmpty()) {
                w4 = w0;
            }
            else {
                ArrayList arrayList8 = new ArrayList(arrayList5.size());
                int v109 = arrayList5.size();
                for(int v110 = 0; v110 < v109; ++v110) {
                    Object object8 = arrayList5.get(v110);
                    Object object9 = m8.last();
                    if(((Q.j)object8).a > ((Q.j)object9).a) {
                        arrayList8.add(object8);
                    }
                }
                w4 = arrayList8;
            }
            if(arrayList6.isEmpty()) {
                object10 = null;
            }
            else {
                Object object11 = arrayList6.get(0);
                int v111 = ((Q.j)object11).l;
                l1.getClass();
                float f7 = -Math.abs(((float)v111) - 0.0f);
                int v112 = e.k.s(arrayList6);
                if(1 <= v112) {
                    for(int v113 = 1; true; ++v113) {
                        Object object12 = arrayList6.get(v113);
                        float f8 = -Math.abs(((float)((Q.j)object12).l) - 0.0f);
                        if(Float.compare(f7, f8) < 0) {
                            f7 = f8;
                            object11 = object12;
                        }
                        if(v113 == v112) {
                            break;
                        }
                    }
                }
                object10 = object11;
            }
            l1.getClass();
            a0 = new A(arrayList6, v44, v8, v6, u01, -v2, v33, v22, j3, ((Q.j)object10), (v60 == 0 ? 0.0f : P4.a.i(((float)(-(((Q.j)object10) == null ? 0 : ((Q.j)object10).l))) / ((float)v60), -0.5f, 0.5f)), v57, v54 < v42 || v59 > v91, l1, ((N)o0.invoke(v84, v85, new p(4, b00, arrayList5))), z2, w3, w4, coroutineScope0);
        }
        k0.h(a0, k01.u(), false);
        return a0;
    }
}

