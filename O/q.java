package O;

import C0.c;
import Cc.c1;
import Cc.e0;
import Cc.n3;
import De.I;
import I.u0;
import M.f;
import M.h;
import M.i0;
import N0.M;
import N0.N;
import N0.k0;
import android.content.Context;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.lazy.layout.C;
import androidx.compose.foundation.lazy.layout.s;
import androidx.compose.runtime.J;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import com.melon.ui.playermusic.BgType.Album;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import je.w;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineScope;
import r0.d;
import r0.g;
import r0.i;
import r1.m;
import we.a;
import we.n;
import x1.e;
import x1.j;
import y0.z;

public final class q extends r implements n {
    public final int f;
    public final a g;
    public final boolean h;
    public final boolean i;
    public final Object j;
    public final Object k;
    public final Object l;
    public final Object m;
    public final Object n;
    public final Object o;
    public final Object r;
    public final Object w;

    public q(F f0, boolean z, i0 i00, boolean z1, De.r r0, h h0, f f1, CoroutineScope coroutineScope0, z z2, C c0, g g0, r0.h h1) {
        this.f = 0;
        this.j = f0;
        this.h = z;
        this.k = i00;
        this.i = z1;
        this.g = r0;
        this.l = h0;
        this.m = f1;
        this.n = coroutineScope0;
        this.o = c0;
        this.r = g0;
        this.w = h1;
        super(2);
    }

    public q(b0 b00, j j0, a a0, b0 b01, b0 b02, b0 b03, a a1, Context context0, Album bgType$Album0, boolean z, boolean z1) {
        this.f = 1;
        this.j = b00;
        this.k = j0;
        this.g = a0;
        this.l = b01;
        this.m = b02;
        this.n = b03;
        this.o = a1;
        this.r = context0;
        this.w = bgType$Album0;
        this.h = z;
        this.i = z1;
        super(2);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v21;
        int v20;
        Integer integer1;
        ArrayList arrayList6;
        androidx.compose.foundation.lazy.layout.z z24;
        int v108;
        int v107;
        int v102;
        p p3;
        ArrayList arrayList5;
        int v101;
        v v100;
        androidx.compose.foundation.lazy.layout.z z23;
        int v88;
        Object object6;
        v v85;
        float f18;
        Object object5;
        v v80;
        Object object3;
        int v78;
        w w3;
        ArrayList arrayList3;
        v v73;
        int v71;
        ArrayList arrayList2;
        float f16;
        v v57;
        int v56;
        int v55;
        v v60;
        int v53;
        int v52;
        int v51;
        int v47;
        int v34;
        long v32;
        u u1;
        androidx.compose.foundation.lazy.layout.z z16;
        float f12;
        int v12;
        int v7;
        int v6;
        H h1;
        int v1;
        androidx.compose.runtime.p p0;
        if(this.f != 0) {
            Album bgType$Album0 = (Album)this.w;
            Context context0 = (Context)this.r;
            a a0 = (a)this.o;
            b0 b00 = (b0)this.l;
            j j0 = (j)this.k;
            H h0 = H.a;
            if((((Number)object1).intValue() & 3) == 2 && ((androidx.compose.runtime.p)(((l)object0))).D()) {
                ((androidx.compose.runtime.p)(((l)object0))).T();
                return h0;
            }
            ((b0)this.j).setValue(h0);
            int v = j0.b;
            j0.h();
            ((androidx.compose.runtime.p)(((l)object0))).a0(-718105481);
            if(((Number)b00.getValue()).intValue() == 0) {
                ((androidx.compose.runtime.p)(((l)object0))).p(false);
                p0 = (androidx.compose.runtime.p)(((l)object0));
                v1 = v;
                h1 = h0;
            }
            else {
                wa.a a1 = j0.f();
                e e0 = ((j)a1.a).e();
                e e1 = ((j)a1.a).e();
                float f = e0.Z(((androidx.compose.runtime.p)(((l)object0))), ((Number)b00.getValue()).intValue());
                float f1 = e0.Z(((androidx.compose.runtime.p)(((l)object0))), ((Number)((b0)this.m).getValue()).intValue());
                float f2 = e0.Z(((androidx.compose.runtime.p)(((l)object0))), ((Number)((b0)this.n).getValue()).intValue());
                boolean z = ((androidx.compose.runtime.p)(((l)object0))).g(e0);
                boolean z1 = ((androidx.compose.runtime.p)(((l)object0))).d(f1);
                com.melon.ui.playermusic.e e2 = ((androidx.compose.runtime.p)(((l)object0))).N();
                V v2 = k.a;
                if(z || z1 || e2 == v2) {
                    e2 = new com.melon.ui.playermusic.e(e0, f1);
                    ((androidx.compose.runtime.p)(((l)object0))).l0(e2);
                }
                r0.q q0 = j.b(r0.n.a, e1, e2);
                c c0 = I.Q(0x7F080669, ((androidx.compose.runtime.p)(((l)object0))), 6);  // drawable:img_player_cover_shadow
                v1 = v;
                r0.n n0 = r0.n.a;
                h1 = h0;
                androidx.compose.foundation.q.c(c0, null, q0, null, null, 0.0f, null, ((androidx.compose.runtime.p)(((l)object0))), 0x30, 120);
                androidx.compose.runtime.p p1 = (androidx.compose.runtime.p)(((l)object0));
                boolean z2 = p1.d(f2);
                boolean z3 = p1.d(f);
                com.melon.ui.playermusic.f f3 = p1.N();
                if(z2 || z3 || f3 == v2) {
                    f3 = new com.melon.ui.playermusic.f(f2, f);
                    p1.l0(f3);
                }
                r0.q q1 = j.b(n0, e0, f3);
                boolean z4 = p1.g(a0);
                boolean z5 = p1.d(0.92f);
                com.melon.ui.playermusic.g g0 = p1.N();
                if(z4 || z5 || g0 == v2) {
                    g0 = new com.melon.ui.playermusic.g(a0);
                    p1.l0(g0);
                }
                r0.q q2 = e0.L(androidx.compose.ui.graphics.a.a(q1, g0), 0x7F0604AE);  // color:white120e
                i i0 = d.a;
                M m0 = M.p.d(i0, false);
                int v3 = p1.P;
                androidx.compose.runtime.i0 i00 = p1.m();
                r0.q q3 = r0.a.d(p1, q2);
                P0.k.y.getClass();
                P0.i i1 = P0.j.b;
                p1.e0();
                if(p1.O) {
                    p1.l(i1);
                }
                else {
                    p1.o0();
                }
                P0.h h2 = P0.j.f;
                androidx.compose.runtime.w.x(p1, m0, h2);
                P0.h h3 = P0.j.e;
                androidx.compose.runtime.w.x(p1, i00, h3);
                P0.h h4 = P0.j.g;
                if(p1.O || !kotlin.jvm.internal.q.b(p1.N(), v3)) {
                    A7.d.q(v3, p1, v3, h4);
                }
                P0.h h5 = P0.j.d;
                androidx.compose.runtime.w.x(p1, q3, h5);
                FillElement fillElement0 = androidx.compose.foundation.layout.d.c;
                r0.q q4 = androidx.compose.foundation.q.f(fillElement0, e0.T(p1, 0x7F060144), y0.M.a);  // color:gray050e
                M m1 = M.p.d(i0, false);
                int v4 = p1.P;
                androidx.compose.runtime.i0 i01 = p1.m();
                r0.q q5 = r0.a.d(p1, q4);
                p1.e0();
                if(p1.O) {
                    p1.l(i1);
                }
                else {
                    p1.o0();
                }
                androidx.compose.runtime.w.x(p1, m1, h2);
                androidx.compose.runtime.w.x(p1, i01, h3);
                if(p1.O || !kotlin.jvm.internal.q.b(p1.N(), v4)) {
                    A7.d.q(v4, p1, v4, h4);
                }
                androidx.compose.runtime.w.x(p1, q5, h5);
                r0.q q6 = androidx.compose.foundation.layout.d.n(n0, 100.0f);
                r0.q q7 = (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q6, d.e);
                androidx.compose.foundation.q.c(I.Q(0x7F080793, p1, 6), null, q7, null, null, 0.0f, null, p1, 0x30, 120);  // drawable:noimage_logo_xlarge_w
                p1.p(true);
                n3 n30 = c1.W(p1, 0);
                j5.n.b(((t5.j)((O0)n30.c).getValue()), com.melon.ui.playermusic.l.f(context0, bgType$Album0), d5.n.o(fillElement0, T.e.b(4.0f)), null, N0.j.b, null, p1, 0x180000, 0xFB8);
                p0 = p1;
                Boolean boolean0 = Boolean.valueOf(this.h);
                Boolean boolean1 = Boolean.valueOf(this.i);
                boolean z6 = p0.i(bgType$Album0);
                boolean z7 = p0.i(n30);
                boolean z8 = p0.i(context0);
                boolean z9 = p0.h(this.h);
                boolean z10 = p0.h(this.i);
                boolean z11 = p0.f(10000L);
                com.melon.ui.playermusic.h h6 = p0.N();
                if((z9 | (z8 | (z6 | z7)) | z10 | z11) != 0 || h6 == v2) {
                    h6 = new com.melon.ui.playermusic.h(((Album)this.w), n30, ((Context)this.r), this.h, this.i, null);
                    p0.l0(h6);
                }
                J.e(bgType$Album0, boolean0, boolean1, h6, p0);
                p0.p(true);
                p0.p(false);
            }
            if(j0.b != v1) {
                J.h(this.g, p0);
            }
            return h1;
        }
        long v5 = ((r1.a)object1).a;
        f f4 = (f)this.m;
        h h7 = (h)this.l;
        i0 i02 = (i0)this.k;
        F f5 = (F)this.j;
        f5.r.getValue();
        boolean z12 = f5.b || ((androidx.compose.foundation.lazy.layout.z)object0).b.u();
        boolean z13 = this.h;
        androidx.compose.foundation.q.k((z13 ? u0.a : u0.b), v5);
        if(z13) {
            float f6 = i02.b(((androidx.compose.foundation.lazy.layout.z)object0).b.getLayoutDirection());
            v6 = ((androidx.compose.foundation.lazy.layout.z)object0).b.z(f6);
        }
        else {
            m m2 = ((androidx.compose.foundation.lazy.layout.z)object0).b.getLayoutDirection();
            float f7 = m2 == m.a ? i02.b(m2) : i02.c(m2);
            v6 = ((androidx.compose.foundation.lazy.layout.z)object0).b.z(f7);
        }
        if(z13) {
            float f8 = i02.c(((androidx.compose.foundation.lazy.layout.z)object0).b.getLayoutDirection());
            v7 = ((androidx.compose.foundation.lazy.layout.z)object0).b.z(f8);
        }
        else {
            m m3 = ((androidx.compose.foundation.lazy.layout.z)object0).b.getLayoutDirection();
            float f9 = m3 == m.a ? i02.c(m3) : i02.b(m3);
            v7 = ((androidx.compose.foundation.lazy.layout.z)object0).b.z(f9);
        }
        float f10 = i02.d();
        int v8 = ((androidx.compose.foundation.lazy.layout.z)object0).b.z(f10);
        float f11 = i02.a();
        k0 k00 = ((androidx.compose.foundation.lazy.layout.z)object0).b;
        int v9 = k00.z(f11);
        int v10 = v8 + v9;
        int v11 = v6 + v7;
        boolean z14 = this.i;
        if(z13 && !z14) {
            v12 = v8;
        }
        else if(!z13 || !z14) {
            v12 = z13 || z14 ? v7 : v6;
        }
        else {
            v12 = v9;
        }
        long v13 = r1.b.i(-v11, -v10, v5);
        O.k k0 = (O.k)this.g.invoke();
        B7.b b0 = k0.d;
        O.j j1 = k0.b;
        ((K0)k0.c.a).n(r1.a.h(v13));
        ((K0)k0.c.b).n(r1.a.g(v13));
        if(z13) {
            if(h7 != null) {
                f12 = h7.a();
                goto label_168;
            }
            L.a.b("null verticalArrangement when isVertical == true");
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        if(f4 != null) {
            f12 = f4.a();
        label_168:
            int v14 = k00.z(f12);
            int v15 = j1.n().a;
            int v16 = z13 ? r1.a.g(v5) - v10 : r1.a.h(v5) - v11;
            boolean z15 = this.i;
            if(z15 && v16 <= 0) {
                if(!z13) {
                    v6 += v16;
                }
                if(z13) {
                    v8 += v16;
                }
            }
            int v17 = (z13 ? v10 : v11) - v12;
            p p2 = new p(v13, this.h, k0, ((androidx.compose.foundation.lazy.layout.z)object0), v15, v14, ((g)this.r), ((r0.h)this.w), z15, v12, v17, ((long)v6) << 0x20 | ((long)v8) & 0xFFFFFFFFL, ((F)this.j));
            p0.h h8 = p0.q.d();
            Integer integer0 = null;
            we.k k1 = h8 == null ? null : h8.e();
            p0.h h9 = p0.q.e(h8);
            try {
                x x0 = f5.d;
                int v19 = x0.a();
                v20 = androidx.compose.foundation.lazy.layout.j.l(v19, k0, x0.e);
                if(v19 == v20) {
                    z16 = (androidx.compose.foundation.lazy.layout.z)object0;
                }
                else {
                    z16 = (androidx.compose.foundation.lazy.layout.z)object0;
                    ((K0)x0.b).n(v20);
                    x0.f.a(v19);
                }
                v21 = x0.b();
            }
            finally {
                p0.q.g(h8, h9, k1);
            }
            List list0 = androidx.compose.foundation.lazy.layout.j.j(k0, f5.q, f5.n);
            float f13 = k00.u() || !z12 ? f5.g : ((Number)((O0)((G.p)f5.v.a).b).getValue()).floatValue();
            boolean z17 = k00.u();
            u u0 = f5.c;
            CoroutineScope coroutineScope0 = (CoroutineScope)this.n;
            s s0 = f5.m;
            int v22 = v21;
            C c1 = (C)this.o;
            b0 b01 = f5.u;
            int v23 = v20;
            o o0 = new o(z16, v5, v11, v10, 0);
            if(v12 < 0) {
                L.a.a("invalid beforeContentPadding");
            }
            if(v17 < 0) {
                L.a.a("invalid afterContentPadding");
            }
            boolean z18 = this.i;
            w w0 = w.a;
            if(v15 <= 0) {
                int v24 = r1.a.j(v13);
                int v25 = r1.a.i(v13);
                s0.c(v24, v25, new ArrayList(), b0, p2, z17, 1, z12, 0, 0);
                if(!z17) {
                    s0.b();
                }
                u1 = new u(null, 0, false, 0.0f, ((N)o0.invoke(v24, v25, O.r.g)), 0.0f, false, coroutineScope0, z16, p2.c, w0, -v12, v16 + v17, 0, z18, (z13 ? u0.a : u0.b), v17, v14);
            }
            else {
                if(v23 >= v15) {
                    v23 = v15 - 1;
                    v22 = 0;
                }
                int v26 = Math.round(f13);
                int v27 = v22 - v26;
                if(v23 == 0 && v27 < 0) {
                    v26 += v27;
                    v27 = 0;
                }
                je.m m4 = new je.m();
                int v28 = (v14 >= 0 ? 0 : v14) - v12;
                int v29 = v27 + v28;
                int v30 = v23;
                int v31 = 0;
                while(true) {
                    v32 = p2.c;
                    if(v29 >= 0 || v30 <= 0) {
                        break;
                    }
                    v v33 = p2.a(v30 - 1, v32);
                    m4.add(0, v33);
                    v31 = Math.max(v31, v33.p);
                    v29 += v33.o;
                    --v30;
                }
                if(v29 < v28) {
                    v34 = v26 - (v28 - v29);
                    v29 = v28;
                }
                else {
                    v34 = v26;
                }
                int v35 = v29 - v28;
                int v36 = v16 + v17;
                int v37 = v36 >= 0 ? v36 : 0;
                int v38 = v35;
                int v39 = -v35;
                int v40 = v30;
                int v41 = 0;
                boolean z19 = false;
                while(v41 < m4.c) {
                    if(v39 >= v37) {
                        m4.d(v41);
                        z19 = true;
                    }
                    else {
                        ++v40;
                        v39 += ((v)m4.get(v41)).o;
                        ++v41;
                    }
                }
                int v42 = v39;
                int v43 = v31;
                boolean z20 = z19;
                int v44 = v40;
                while(v44 < v15 && (v42 < v37 || v42 <= 0 || m4.isEmpty())) {
                    v v45 = p2.a(v44, v32);
                    int v46 = v45.o;
                    v42 += v46;
                    if(v42 <= v28) {
                        v47 = v28;
                        if(v44 != v15 - 1) {
                            v38 -= v46;
                            v30 = v44 + 1;
                            z20 = true;
                            goto label_283;
                        }
                    }
                    else {
                        v47 = v28;
                    }
                    m4.addLast(v45);
                    v43 = Math.max(v43, v45.p);
                label_283:
                    ++v44;
                    v28 = v47;
                }
                if(v42 < v16) {
                    int v48 = v16 - v42;
                    v42 += v48;
                    int v49 = v38 - v48;
                    while(v49 < v12 && v30 > 0) {
                        v v50 = p2.a(v30 - 1, v32);
                        m4.add(0, v50);
                        v43 = Math.max(v43, v50.p);
                        v49 += v50.o;
                        --v30;
                    }
                    v51 = v34 + v48;
                    if(v49 < 0) {
                        v51 += v49;
                        v42 += v49;
                        v52 = v30;
                        v53 = 0;
                    }
                    else {
                        v52 = v30;
                        v53 = v49;
                    }
                }
                else {
                    v51 = v34;
                    v52 = v30;
                    v53 = v38;
                }
                float f14 = Integer.signum(Math.round(f13)) != Integer.signum(v51) || Math.abs(Math.round(f13)) < Math.abs(v51) ? f13 : ((float)v51);
                float f15 = f13 - f14;
                if(v53 < 0) {
                    L.a.a("negative currentFirstItemScrollOffset");
                }
                v v54 = (v)m4.first();
                if(v12 > 0 || v14 < 0) {
                    int v58 = m4.b();
                    v55 = -v53;
                    int v59 = 0;
                    while(v59 < v58) {
                        v60 = v54;
                        int v61 = ((v)m4.get(v59)).o;
                        if(v53 != 0 && v61 <= v53) {
                            v56 = v53;
                            if(v59 == e.k.s(m4)) {
                                goto label_337;
                            }
                            v53 = v56 - v61;
                            ++v59;
                            v54 = (v)m4.get(v59);
                            continue;
                        }
                        v56 = v53;
                        goto label_337;
                    }
                    v56 = v53;
                    v60 = v54;
                label_337:
                    v57 = v60;
                }
                else {
                    v55 = -v53;
                    v56 = v53;
                    v57 = v54;
                }
                int v62 = Math.max(0, v52);
                int v63 = v52 - 1;
                ArrayList arrayList0 = null;
                if(v62 <= v63) {
                    while(true) {
                        if(arrayList0 == null) {
                            arrayList0 = new ArrayList();
                        }
                        arrayList0.add(p2.a(v63, v32));
                        if(v63 == v62) {
                            break;
                        }
                        --v63;
                    }
                }
                w w1 = arrayList0;
                int v64 = list0.size() - 1;
                if(v64 >= 0) {
                    while(true) {
                        int v65 = ((Number)list0.get(v64)).intValue();
                        if(v65 < v62) {
                            if(w1 == null) {
                                w1 = new ArrayList();
                            }
                            w1.add(p2.a(v65, v32));
                        }
                        if(v64 - 1 < 0) {
                            break;
                        }
                        --v64;
                    }
                }
                w w2 = w1 == null ? w0 : w1;
                int v66 = w2.size();
                int v67 = v43;
                Collection collection0 = w2;
                for(int v68 = 0; v68 < v66; ++v68) {
                    v67 = Math.max(v67, ((v)w2.get(v68)).p);
                }
                int v69 = Math.min(((v)je.p.s0(m4)).a, v15 - 1);
                int v70 = ((v)je.p.s0(m4)).a + 1;
                if(v70 <= v69) {
                    ArrayList arrayList1 = null;
                    while(true) {
                        if(arrayList1 == null) {
                            arrayList1 = new ArrayList();
                        }
                        f16 = f14;
                        arrayList2 = arrayList1;
                        v71 = v44;
                        arrayList2.add(p2.a(v70, v32));
                        if(v70 == v69) {
                            break;
                        }
                        ++v70;
                        v44 = v71;
                        arrayList1 = arrayList2;
                        f14 = f16;
                    }
                }
                else {
                    v71 = v44;
                    f16 = f14;
                    arrayList2 = null;
                }
                if(!z17 || u0 == null) {
                    w3 = w2;
                    v78 = v42;
                    arrayList3 = arrayList2;
                }
                else {
                    Object object2 = u0.k;
                    if(((Collection)object2).isEmpty()) {
                        w3 = w2;
                        v78 = v42;
                        arrayList3 = arrayList2;
                    }
                    else {
                        for(int v72 = ((List)object2).size() - 1; true; --v72) {
                            v73 = null;
                            if(-1 >= v72) {
                                break;
                            }
                            if(((v)((List)object2).get(v72)).a > v69 && (v72 == 0 || ((v)((List)object2).get(v72 - 1)).a <= v69)) {
                                v73 = (v)((List)object2).get(v72);
                                break;
                            }
                        }
                        v v74 = (v)je.p.s0(((List)object2));
                        if(v73 == null) {
                            w3 = w2;
                            v78 = v42;
                            arrayList3 = arrayList2;
                        }
                        else {
                            int v75 = v73.a;
                            int v76 = Math.min(v74.a, v15 - 1);
                            if(v75 <= v76) {
                                arrayList3 = arrayList2;
                                while(true) {
                                    w3 = w2;
                                    if(arrayList3 == null) {
                                        v78 = v42;
                                        v80 = null;
                                    }
                                    else {
                                        int v77 = arrayList3.size();
                                        v78 = v42;
                                        int v79 = 0;
                                        while(true) {
                                            object3 = null;
                                            if(v79 < v77) {
                                                Object object4 = arrayList3.get(v79);
                                                if(((v)object4).a == v75) {
                                                    object3 = object4;
                                                }
                                                else {
                                                    ++v79;
                                                    continue;
                                                }
                                            }
                                            break;
                                        }
                                        v80 = (v)object3;
                                    }
                                    if(v80 == null) {
                                        if(arrayList3 == null) {
                                            arrayList3 = new ArrayList();
                                        }
                                        arrayList3.add(p2.a(v75, v32));
                                    }
                                    if(v75 == v76) {
                                        break;
                                    }
                                    ++v75;
                                    w2 = w3;
                                    v42 = v78;
                                }
                            }
                            else {
                                w3 = w2;
                                v78 = v42;
                                arrayList3 = arrayList2;
                            }
                        }
                        float f17 = ((float)(u0.m - v74.m - v74.n)) - f16;
                        if(f17 > 0.0f) {
                            int v81 = v74.a + 1;
                            int v82 = 0;
                            while(v81 < v15 && ((float)v82) < f17) {
                                if(v81 <= v69) {
                                    int v83 = m4.b();
                                    int v84 = 0;
                                    while(true) {
                                        if(v84 < v83) {
                                            object5 = m4.get(v84);
                                            f18 = f17;
                                            if(((v)object5).a == v81) {
                                                break;
                                            }
                                            else {
                                                ++v84;
                                                f17 = f18;
                                                continue;
                                            }
                                        }
                                        f18 = f17;
                                        object5 = null;
                                        break;
                                    }
                                    v85 = (v)object5;
                                }
                                else {
                                    f18 = f17;
                                    if(arrayList3 == null) {
                                        v85 = null;
                                    }
                                    else {
                                        int v86 = arrayList3.size();
                                        int v87 = 0;
                                        while(true) {
                                            object6 = null;
                                            if(v87 < v86) {
                                                Object object7 = arrayList3.get(v87);
                                                if(((v)object7).a == v81) {
                                                    object6 = object7;
                                                }
                                                else {
                                                    ++v87;
                                                    continue;
                                                }
                                            }
                                            break;
                                        }
                                        v85 = (v)object6;
                                    }
                                }
                                if(v85 == null) {
                                    if(arrayList3 == null) {
                                        arrayList3 = new ArrayList();
                                    }
                                    arrayList3.add(p2.a(v81, v32));
                                    ++v81;
                                    v88 = ((v)je.p.s0(arrayList3)).o;
                                }
                                else {
                                    ++v81;
                                    v88 = v85.o;
                                }
                                v82 += v88;
                                f17 = f18;
                            }
                        }
                    }
                }
                if(arrayList3 != null && ((v)je.p.s0(arrayList3)).a > v69) {
                    v69 = ((v)je.p.s0(arrayList3)).a;
                }
                int v89 = list0.size();
                for(int v90 = 0; v90 < v89; ++v90) {
                    int v91 = ((Number)list0.get(v90)).intValue();
                    if(v91 > v69) {
                        if(arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList3.add(p2.a(v91, v32));
                    }
                }
                if(arrayList3 == null) {
                    arrayList3 = w0;
                }
                int v92 = arrayList3.size();
                int v93 = v67;
                for(int v94 = 0; v94 < v92; ++v94) {
                    v93 = Math.max(v93, ((v)arrayList3.get(v94)).p);
                }
                boolean z21 = kotlin.jvm.internal.q.b(v57, m4.first()) && w3.isEmpty() && arrayList3.isEmpty();
                int v95 = r1.b.g((z13 ? v93 : v78), v13);
                if(z13) {
                    v93 = v78;
                }
                int v96 = r1.b.f(v93, v13);
                int v97 = z13 ? v96 : v95;
                boolean z22 = v78 < Math.min(v97, v16);
                if(z22 && v55 != 0) {
                    L.a.c("non-zero itemsScrollOffset");
                }
                ArrayList arrayList4 = new ArrayList(arrayList3.size() + (w3.size() + m4.b()));
                if(z22) {
                    if(!w3.isEmpty() || !arrayList3.isEmpty()) {
                        L.a.a("no extra items");
                    }
                    int v98 = m4.b();
                    int[] arr_v = new int[v98];
                    for(int v99 = 0; v99 < v98; ++v99) {
                        arr_v[v99] = ((v)m4.get((z18 ? v98 - v99 - 1 : v99))).n;
                    }
                    int[] arr_v1 = new int[v98];
                    if(z13) {
                        if(h7 != null) {
                            z23 = z16;
                            h7.c(z23, v97, arr_v, arr_v1);
                            v100 = v57;
                            v101 = v78;
                            arrayList5 = arrayList4;
                            p3 = p2;
                            goto label_547;
                        }
                        L.a.b("null verticalArrangement when isVertical == true");
                    }
                    else {
                        z23 = z16;
                        if(f4 != null) {
                            v100 = v57;
                            arrayList5 = arrayList4;
                            p3 = p2;
                            v101 = v78;
                            f4.d(z23, v97, arr_v, m.a, arr_v1);
                        label_547:
                            Ce.e e3 = je.n.j0(arr_v1);
                            if(z18) {
                                v102 = v98;
                                e3 = new Ce.e(e3.b, e3.a, -e3.c);
                            }
                            else {
                                v102 = v98;
                            }
                            int v103 = e3.a;
                            int v104 = e3.b;
                            int v105 = e3.c;
                            if((v105 <= 0 || v103 > v104) && (v105 >= 0 || v104 > v103)) {
                                z24 = z23;
                            }
                            else {
                                while(true) {
                                    int v106 = arr_v1[v103];
                                    if(z18) {
                                        v107 = v105;
                                        v108 = v102 - v103 - 1;
                                    }
                                    else {
                                        v107 = v105;
                                        v108 = v103;
                                    }
                                    v v109 = (v)m4.get(v108);
                                    if(z18) {
                                        z24 = z23;
                                        v106 = v97 - v106 - v109.n;
                                    }
                                    else {
                                        z24 = z23;
                                    }
                                    v109.k(v106, v95, v96);
                                    arrayList5.add(v109);
                                    if(v103 == v104) {
                                        break;
                                    }
                                    v103 += v107;
                                    v105 = v107;
                                    z23 = z24;
                                }
                            }
                            arrayList6 = arrayList5;
                            goto label_616;
                        }
                        L.a.b("null horizontalArrangement when isVertical == false");
                    }
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                else {
                    v100 = v57;
                    p3 = p2;
                    v101 = v78;
                    arrayList6 = arrayList4;
                    z24 = z16;
                    int v110 = collection0.size();
                    int v111 = v55;
                    for(int v112 = 0; v112 < v110; ++v112) {
                        v v113 = (v)w3.get(v112);
                        v111 -= v113.o;
                        v113.k(v111, v95, v96);
                        arrayList6.add(v113);
                    }
                    int v114 = m4.b();
                    int v115 = v55;
                    for(int v116 = 0; v116 < v114; ++v116) {
                        v v117 = (v)m4.get(v116);
                        v117.k(v115, v95, v96);
                        arrayList6.add(v117);
                        v115 += v117.o;
                    }
                    int v118 = arrayList3.size();
                    for(int v119 = 0; v119 < v118; ++v119) {
                        v v120 = (v)arrayList3.get(v119);
                        v120.k(v115, v95, v96);
                        arrayList6.add(v120);
                        v115 += v120.o;
                    }
                }
            label_616:
                s0.c(v95, v96, arrayList6, b0, p3, z17, 1, z12, v56, v101);
                if(!z17) {
                    s0.b();
                }
                List list1 = androidx.compose.foundation.lazy.layout.j.i(c1, arrayList6, (j1.c == null ? androidx.collection.l.a : j1.c), v12, v95, v96, new B0.b(p3, 12));
                if(z21) {
                    v v121 = (v)je.p.m0(arrayList6);
                    integer1 = v121 == null ? null : v121.a;
                }
                else {
                    Object object8 = m4.isEmpty() ? null : m4.b[m4.a];
                    integer1 = ((v)object8) == null ? null : ((v)object8).a;
                }
                if(z21) {
                    v v122 = (v)je.p.t0(arrayList6);
                    if(v122 != null) {
                        integer0 = v122.a;
                    }
                }
                else {
                    v v123 = (v)m4.k();
                    if(v123 != null) {
                        integer0 = v123.a;
                    }
                }
                Object object9 = o0.invoke(v95, v96, new t(b01, arrayList6, list1, z17, 0));
                List list2 = androidx.compose.foundation.lazy.layout.j.s((integer1 == null ? 0 : ((int)integer1)), (integer0 == null ? 0 : ((int)integer0)), arrayList6, list1);
                u1 = new u(v100, v56, v71 < v15 || v101 > v16, f16, ((N)object9), (!z17 || v51 <= v34 || f15 > 0.0f ? 0.0f : ((float)(v51 - v34)) + f15), z20, coroutineScope0, z24, p3.c, list2, -v12, v36, v15, z18, (z13 ? u0.a : u0.b), v17, v14);
            }
            f5.g(u1, k00.u(), false);
            return u1;
        }
        L.a.b("null horizontalAlignment when isVertical == false");
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }
}

