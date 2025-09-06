package l3;

import B7.b;
import I6.p0;
import android.net.Uri;
import androidx.media3.common.Metadata;
import androidx.media3.exoplayer.J;
import androidx.media3.exoplayer.K;
import androidx.media3.exoplayer.i0;
import androidx.media3.session.N;
import b3.H;
import b3.I;
import b3.n;
import b3.q0;
import i.n.i.b.a.s.e.Ca;
import i.n.i.b.a.s.e.P3;
import i.n.i.b.a.s.e.l6;
import i3.l;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import k3.k;
import k3.o;
import kb.D;
import m3.c;
import m3.f;
import m3.p;
import s3.V;
import s3.g0;
import s3.m;
import s3.w;
import s3.x;
import w3.d;
import ye.a;

public final class j implements p, x {
    public int B;
    public g0 D;
    public l3.p[] E;
    public l3.p[] G;
    public int I;
    public m M;
    public final h a;
    public final c b;
    public final D c;
    public final g3.x d;
    public final o e;
    public final k f;
    public final Nf.p g;
    public final b h;
    public final d i;
    public final IdentityHashMap j;
    public final l6 k;
    public final e3.h l;
    public final boolean m;
    public final int n;
    public final l o;
    public final D r;
    public w w;

    public j(h h0, c c0, D d0, g3.x x0, o o0, k k0, Nf.p p0, b b0, d d1, e3.h h1, boolean z, int v, l l0) {
        this.a = h0;
        this.b = c0;
        this.c = d0;
        this.d = x0;
        this.e = o0;
        this.f = k0;
        this.g = p0;
        this.h = b0;
        this.i = d1;
        this.l = h1;
        this.m = z;
        this.n = v;
        this.o = l0;
        this.r = new D(this, 5);
        h1.getClass();
        this.M = new m(p0.e, p0.e);
        this.j = new IdentityHashMap();
        this.k = new l6();
        this.E = new l3.p[0];
        this.G = new l3.p[0];
    }

    @Override  // m3.p
    public final boolean a(Uri uri0, Ca ca0, boolean z) {
        boolean z2;
        boolean z3;
        long v1;
        l3.p[] arr_p = this.E;
        int v = 0;
        boolean z1 = true;
        while(v < arr_p.length) {
            l3.p p0 = arr_p[v];
            g g0 = p0.d;
            Uri[] arr_uri = g0.e;
            if(e3.x.j(arr_uri, uri0)) {
                if(z) {
                    v1 = 0x8000000000000001L;
                }
                else {
                    androidx.recyclerview.widget.p0 p00 = e1.b.t(g0.q);
                    p0.i.getClass();
                    N n0 = Nf.p.d(p00, ca0);
                    if(n0 != null && n0.a == 2) {
                        v1 = n0.b;
                    }
                }
                int v2 = 0;
                while(true) {
                    if(v2 < arr_uri.length) {
                        if(arr_uri[v2].equals(uri0)) {
                            break;
                        }
                        else {
                            ++v2;
                            continue;
                        }
                    }
                    v2 = -1;
                    break;
                }
                if(v2 == -1) {
                    z3 = true;
                }
                else {
                    int v3 = g0.q.indexOf(v2);
                    if(v3 != -1) {
                        g0.s |= uri0.equals(g0.o);
                        if(v1 != 0x8000000000000001L) {
                            if(g0.q.c(v3, v1)) {
                                m3.b b0 = (m3.b)g0.g.d.get(uri0);
                                int v4 = b0 == null ? 0 : !m3.b.b(b0, v1);
                                if(v4 == 0) {
                                    z3 = false;
                                }
                            }
                            else {
                                z3 = false;
                            }
                        }
                    }
                }
                z2 = z3 && v1 != 0x8000000000000001L;
            }
            else {
                z2 = true;
            }
            z1 &= z2;
            ++v;
        }
        this.w.a(this);
        return z1;
    }

    @Override  // s3.X
    public final boolean b(K k0) {
        if(this.D == null) {
            l3.p[] arr_p = this.E;
            for(int v = 0; v < arr_p.length; ++v) {
                l3.p p0 = arr_p[v];
                if(!p0.Y) {
                    J j0 = new J();
                    j0.a = p0.l0;
                    p0.b(new K(j0));
                }
            }
            return false;
        }
        return this.M.b(k0);
    }

    @Override  // s3.x
    public final long c(v3.o[] arr_o, boolean[] arr_z, V[] arr_v, boolean[] arr_z1, long v) {
        V[] arr_v6;
        boolean z1;
        int v27;
        l3.p p2;
        l3.p[] arr_p2;
        int v26;
        int v25;
        V[] arr_v5;
        int v24;
        int v23;
        g g1;
        int v18;
        long v17;
        int v14;
        v3.o[] arr_o2;
        int v12;
        IdentityHashMap identityHashMap0;
        int[] arr_v1 = new int[arr_o.length];
        int[] arr_v2 = new int[arr_o.length];
        for(int v1 = 0; true; ++v1) {
            identityHashMap0 = this.j;
            if(v1 >= arr_o.length) {
                break;
            }
            V v2 = arr_v[v1];
            arr_v1[v1] = v2 == null ? -1 : ((int)(((Integer)identityHashMap0.get(v2))));
            arr_v2[v1] = -1;
            v3.o o0 = arr_o[v1];
            if(o0 != null) {
                q0 q00 = o0.getTrackGroup();
                for(int v3 = 0; true; ++v3) {
                    l3.p[] arr_p = this.E;
                    if(v3 >= arr_p.length) {
                        break;
                    }
                    l3.p p0 = arr_p[v3];
                    p0.j();
                    if(p0.e0.b(q00) != -1) {
                        arr_v2[v1] = v3;
                        break;
                    }
                }
            }
        }
        identityHashMap0.clear();
        int v4 = arr_o.length;
        V[] arr_v3 = new V[v4];
        V[] arr_v4 = new V[arr_o.length];
        int v5 = arr_o.length;
        v3.o[] arr_o1 = new v3.o[v5];
        l3.p[] arr_p1 = new l3.p[this.E.length];
        int v6 = arr_o.length;
        int v7 = 0;
        int v8 = 0;
        boolean z = false;
        while(v7 < this.E.length) {
            for(int v9 = 0; v9 < arr_o.length; ++v9) {
                arr_v4[v9] = arr_v1[v9] == v7 ? arr_v[v9] : null;
                arr_o1[v9] = arr_v2[v9] == v7 ? arr_o[v9] : null;
            }
            l3.p p1 = this.E[v7];
            g g0 = p1.d;
            Uri[] arr_uri = g0.e;
            c c0 = g0.g;
            w3.k k0 = p1.j;
            p1.j();
            ArrayList arrayList0 = p1.n;
            int v10 = p1.Z;
            int v11 = 0;
            while(v11 < v5) {
                l3.l l0 = (l3.l)arr_v4[v11];
                if(l0 == null || arr_o1[v11] != null && arr_z[v11]) {
                    v12 = v11;
                    arr_o2 = arr_o1;
                }
                else {
                    v12 = v11;
                    --p1.Z;
                    arr_o2 = arr_o1;
                    if(l0.c != -1) {
                        l0.b.j();
                        l0.b.g0.getClass();
                        int v13 = l0.b.g0[l0.a];
                        e3.b.j(l0.b.j0[v13]);
                        l0.b.j0[v13] = false;
                        l0.c = -1;
                    }
                    arr_v4[v12] = null;
                }
                v11 = v12 + 1;
                arr_o1 = arr_o2;
            }
            v3.o[] arr_o3 = arr_o1;
            if(z) {
                v14 = 1;
            }
            else if(!p1.o0) {
                if(v == p1.l0) {
                    v14 = 0;
                }
            }
            else if(v10 != 0) {
                v14 = 0;
            }
            v3.o o1 = g0.q;
            int v15 = v14;
            v3.o o2 = o1;
            int v16 = 0;
            while(true) {
                v17 = 0L;
                if(v16 >= v5) {
                    break;
                }
                v3.o o3 = arr_o3[v16];
                if(o3 == null) {
                    v18 = v5;
                }
                else {
                    v18 = v5;
                    int v19 = p1.e0.b(o3.getTrackGroup());
                    if(v19 == p1.h0) {
                        int v20 = g0.q.getSelectedIndexInTrackGroup();
                        m3.b b0 = (m3.b)c0.d.get(arr_uri[v20]);
                        if(b0 != null) {
                            b0.k = false;
                        }
                        g0.q = o3;
                        o2 = o3;
                    }
                    if(arr_v4[v16] == null) {
                        ++p1.Z;
                        l3.l l1 = new l3.l(p1, v19);
                        arr_v4[v16] = l1;
                        arr_z1[v16] = true;
                        if(p1.g0 != null) {
                            l1.a();
                            if(v15 == 0) {
                                l3.o o4 = p1.I[p1.g0[v19]];
                                v15 = o4.l() == 0 || o4.w(v, true) ? 0 : 1;
                            }
                        }
                    }
                }
                ++v16;
                v5 = v18;
            }
            if(p1.Z == 0) {
                int v21 = g0.q.getSelectedIndexInTrackGroup();
                m3.b b1 = (m3.b)c0.d.get(arr_uri[v21]);
                if(b1 != null) {
                    b1.k = false;
                }
                g0.n = null;
                p1.c0 = null;
                p1.n0 = true;
                arrayList0.clear();
                if(k0.b()) {
                    if(p1.X) {
                        l3.o[] arr_o4 = p1.I;
                        for(int v22 = 0; v22 < arr_o4.length; ++v22) {
                            arr_o4[v22].g();
                        }
                    }
                    k0.a();
                }
                else {
                    p1.v();
                }
                g1 = g0;
                v23 = v6;
                v24 = v4;
                arr_v5 = arr_v3;
                v25 = v7;
                v26 = v15;
                arr_p2 = arr_p1;
                p2 = p1;
            }
            else {
                if(arrayList0.isEmpty() || Objects.equals(o2, o1)) {
                    g1 = g0;
                    v27 = v6;
                    v24 = v4;
                    arr_v5 = arr_v3;
                    v25 = v7;
                    arr_p2 = arr_p1;
                    p2 = p1;
                }
                else {
                    if(p1.o0) {
                        g1 = g0;
                        v27 = v6;
                        v24 = v4;
                        arr_v5 = arr_v3;
                        v25 = v7;
                        arr_p2 = arr_p1;
                        p2 = p1;
                    }
                    else {
                        if(v < 0L) {
                            v17 = -v;
                        }
                        i i0 = p1.p();
                        t3.c[] arr_c = g0.a(i0, v);
                        g1 = g0;
                        v27 = v6;
                        v24 = v4;
                        arr_v5 = arr_v3;
                        v25 = v7;
                        arr_p2 = arr_p1;
                        p2 = p1;
                        o2.d(v, v17, 0x8000000000000001L, p1.o, arr_c);
                        int v28 = g1.h.b(i0.d);
                        if(o2.getSelectedIndexInTrackGroup() == v28) {
                            goto label_176;
                        }
                    }
                    p2.n0 = true;
                    z1 = true;
                    v26 = 1;
                    goto label_178;
                }
            label_176:
                z1 = z;
                v26 = v15;
            label_178:
                if(v26 == 0) {
                    v23 = v27;
                }
                else {
                    p2.w(v, z1);
                    v23 = v27;
                    for(int v29 = 0; v29 < v23; ++v29) {
                        if(arr_v4[v29] != null) {
                            arr_z1[v29] = true;
                        }
                    }
                }
            }
            ArrayList arrayList1 = p2.D;
            arrayList1.clear();
            for(int v30 = 0; v30 < v23; ++v30) {
                V v31 = arr_v4[v30];
                if(v31 != null) {
                    arrayList1.add(((l3.l)v31));
                }
            }
            p2.o0 = true;
            int v32 = 0;
            boolean z2 = false;
            while(v32 < arr_o.length) {
                V v33 = arr_v4[v32];
                if(arr_v2[v32] == v25) {
                    v33.getClass();
                    arr_v6 = arr_v5;
                    arr_v6[v32] = v33;
                    identityHashMap0.put(v33, v25);
                    z2 = true;
                }
                else {
                    arr_v6 = arr_v5;
                    if(arr_v1[v32] == v25) {
                        e3.b.j(v33 == null);
                    }
                }
                ++v32;
                arr_v5 = arr_v6;
            }
            int v34 = v8;
            if(z2) {
                arr_p2[v34] = p2;
                v8 = v34 + 1;
                if(v34 == 0) {
                    g1.l = true;
                    if(v26 != 0 || (this.G.length == 0 || p2 != this.G[0])) {
                        this.k.a.clear();
                        z = true;
                    }
                }
                else {
                    g1.l = v25 < this.I;
                }
            }
            v7 = v25 + 1;
            arr_p1 = arr_p2;
            v4 = v24;
            v6 = v23;
            arr_v3 = arr_v5;
        }
        System.arraycopy(arr_v3, 0, arr_v, 0, v4);
        l3.p[] arr_p3 = (l3.p[])e3.x.O(arr_p1, v8);
        this.G = arr_p3;
        p0 p00 = I6.V.q(arr_p3);
        AbstractList abstractList0 = I6.w.w(new i3.d(16), p00);
        this.l.getClass();
        this.M = new m(p00, abstractList0);
        return v;
    }

    public final l3.p d(String s, int v, Uri[] arr_uri, androidx.media3.common.b[] arr_b, androidx.media3.common.b b0, List list0, Map map0, long v1) {
        g g0 = new g(this.a, this.b, arr_uri, arr_b, this.c, this.d, this.k, list0, this.o);
        return new l3.p(s, v, this.r, g0, map0, this.i, v1, b0, this.e, this.f, this.g, this.h, this.n);
    }

    @Override  // s3.x
    public final void e(w w0, long v) {
        int v14;
        Uri[] arr_uri1;
        boolean z2;
        int v5;
        boolean z1;
        this.w = w0;
        this.b.getClass();
        this.b.e.add(this);
        m3.k k0 = this.b.j;
        k0.getClass();
        List list0 = k0.g;
        List list1 = k0.e;
        Map map0 = Collections.EMPTY_MAP;
        List list2 = k0.h;
        int v1 = 0;
        this.B = 0;
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        h h0 = this.a;
        boolean z = this.m;
        if(!list1.isEmpty()) {
            androidx.media3.common.b b0 = k0.j;
            int v2 = list1.size();
            int[] arr_v = new int[v2];
            int v4 = 0;
            for(int v3 = 0; v3 < list1.size(); ++v3) {
                androidx.media3.common.b b1 = ((m3.j)list1.get(v3)).b;
                String s = b1.k;
                if(b1.v > 0 || e3.x.s(s, 2) != null) {
                    arr_v[v3] = 2;
                    ++v4;
                }
                else if(e3.x.s(s, 1) == null) {
                    arr_v[v3] = -1;
                }
                else {
                    arr_v[v3] = 1;
                    ++v1;
                }
            }
            if(v4 > 0) {
                z1 = false;
                v5 = v4;
                z2 = true;
            }
            else if(v1 < v2) {
                z2 = false;
                v5 = v2 - v1;
                z1 = true;
            }
            else {
                z2 = false;
                v5 = v2;
                z1 = false;
            }
            Uri[] arr_uri = new Uri[v5];
            androidx.media3.common.b[] arr_b = new androidx.media3.common.b[v5];
            int[] arr_v1 = new int[v5];
            int v6 = 0;
            int v7 = 0;
            while(v6 < list1.size()) {
                if(z2) {
                    arr_uri1 = arr_uri;
                    if(arr_v[v6] == 2) {
                        goto label_59;
                    }
                }
                else {
                    arr_uri1 = arr_uri;
                label_59:
                    if(!z1 || arr_v[v6] != 1) {
                        m3.j j0 = (m3.j)list1.get(v6);
                        arr_uri1[v7] = j0.a;
                        arr_b[v7] = j0.b;
                        arr_v1[v7] = v6;
                        ++v7;
                    }
                }
                ++v6;
                arr_uri = arr_uri1;
            }
            String s1 = arr_b[0].k;
            int v8 = e3.x.r(2, s1);
            int v9 = e3.x.r(1, s1);
            l3.p p0 = this.d("main", (z2 || v9 <= 0 ? 0 : 1), arr_uri, arr_b, k0.j, k0.k, map0, v);
            arrayList0.add(p0);
            arrayList1.add(arr_v1);
            if(z && ((v9 == 1 || v9 == 0 && list0.isEmpty()) && v8 <= 1 && v9 + v8 > 0)) {
                ArrayList arrayList2 = new ArrayList();
                if(v8 > 0) {
                    androidx.media3.common.b[] arr_b1 = new androidx.media3.common.b[v5];
                    for(int v10 = 0; v10 < v5; ++v10) {
                        androidx.media3.common.b b2 = arr_b[v10];
                        String s2 = e3.x.s(b2.k, 2);
                        String s3 = H.c(s2);
                        n n0 = new n();
                        n0.a = b2.a;
                        n0.b = b2.b;
                        n0.c = I6.V.p(b2.c);
                        n0.l = H.l(b2.m);
                        n0.m = H.l(s3);
                        n0.j = s2;
                        n0.k = b2.l;
                        n0.h = b2.h;
                        n0.i = b2.i;
                        n0.t = b2.u;
                        n0.u = b2.v;
                        n0.v = b2.w;
                        n0.e = b2.e;
                        n0.f = b2.f;
                        arr_b1[v10] = new androidx.media3.common.b(n0);
                    }
                    arrayList2.add(new q0("main", arr_b1));
                    if(v9 > 0 && (b0 != null || list0.isEmpty())) {
                        arrayList2.add(new q0("main:audio", new androidx.media3.common.b[]{j.h(arr_b[0], b0, false)}));
                    }
                    List list3 = k0.k;
                    if(list3 != null) {
                        for(int v11 = 0; v11 < list3.size(); ++v11) {
                            arrayList2.add(new q0("main:cc:" + v11, new androidx.media3.common.b[]{((l3.c)h0).b(((androidx.media3.common.b)list3.get(v11)))}));
                        }
                    }
                }
                else {
                    androidx.media3.common.b[] arr_b2 = new androidx.media3.common.b[v5];
                    for(int v12 = 0; v12 < v5; ++v12) {
                        arr_b2[v12] = j.h(arr_b[v12], b0, true);
                    }
                    arrayList2.add(new q0("main", arr_b2));
                }
                n n1 = new n();
                n1.a = "ID3";
                n1.m = "application/id3";
                q0 q00 = new q0("main:id3", new androidx.media3.common.b[]{new androidx.media3.common.b(n1)});
                arrayList2.add(q00);
                p0.u(((q0[])arrayList2.toArray(new q0[0])), new int[]{arrayList2.indexOf(q00)});
            }
        }
        ArrayList arrayList3 = new ArrayList(list0.size());
        ArrayList arrayList4 = new ArrayList(list0.size());
        ArrayList arrayList5 = new ArrayList(list0.size());
        HashSet hashSet0 = new HashSet();
        for(int v13 = 0; v13 < list0.size(); v13 = v14 + 1) {
            String s4 = ((m3.i)list0.get(v13)).c;
            if(hashSet0.add(s4)) {
                arrayList3.clear();
                arrayList4.clear();
                arrayList5.clear();
                int v16 = 1;
                for(int v15 = 0; v15 < list0.size(); ++v15) {
                    if(s4.equals(((m3.i)list0.get(v15)).c)) {
                        m3.i i0 = (m3.i)list0.get(v15);
                        arrayList5.add(v15);
                        arrayList3.add(i0.a);
                        arrayList4.add(i0.b);
                        v16 &= (e3.x.r(1, i0.b.k) == 1 ? 1 : 0);
                    }
                }
                v14 = v13;
                l3.p p1 = this.d("audio:" + s4, 1, ((Uri[])arrayList3.toArray(new Uri[0])), ((androidx.media3.common.b[])arrayList4.toArray(new androidx.media3.common.b[0])), null, Collections.EMPTY_LIST, map0, v);
                arrayList1.add(a.Y(arrayList5));
                arrayList0.add(p1);
                if(z && v16 != 0) {
                    p1.u(new q0[]{new q0("audio:" + s4, ((androidx.media3.common.b[])arrayList4.toArray(new androidx.media3.common.b[0])))}, new int[0]);
                }
            }
            else {
                v14 = v13;
            }
        }
        this.I = arrayList0.size();
        for(int v17 = 0; v17 < list2.size(); ++v17) {
            m3.i i1 = (m3.i)list2.get(v17);
            StringBuilder stringBuilder0 = U4.x.n(v17, "subtitle:", ":");
            stringBuilder0.append(i1.c);
            String s5 = stringBuilder0.toString();
            l3.p p2 = this.d(s5, 3, new Uri[]{i1.a}, new androidx.media3.common.b[]{i1.b}, null, Collections.EMPTY_LIST, map0, v);
            arrayList1.add(new int[]{v17});
            arrayList0.add(p2);
            p2.u(new q0[]{new q0(s5, new androidx.media3.common.b[]{((l3.c)h0).b(i1.b)})}, new int[0]);
        }
        this.E = (l3.p[])arrayList0.toArray(new l3.p[0]);
        int[][] arr2_v = (int[][])arrayList1.toArray(new int[0][]);
        this.B = this.E.length;
        for(int v18 = 0; v18 < this.I; ++v18) {
            this.E[v18].d.l = true;
        }
        l3.p[] arr_p = this.E;
        for(int v19 = 0; v19 < arr_p.length; ++v19) {
            l3.p p3 = arr_p[v19];
            if(!p3.Y) {
                J j1 = new J();
                j1.a = p3.l0;
                p3.b(new K(j1));
            }
        }
        this.G = this.E;
    }

    @Override  // s3.x
    public final long f(long v, i0 i00) {
        l3.p[] arr_p = this.G;
        for(int v1 = 0; v1 < arr_p.length; ++v1) {
            l3.p p0 = arr_p[v1];
            if(p0.V == 2) {
                c c0 = p0.d.g;
                int v2 = p0.d.q.getSelectedIndex();
                Uri[] arr_uri = p0.d.e;
                m3.h h0 = v2 >= arr_uri.length || v2 == -1 ? null : c0.b(arr_uri[p0.d.q.getSelectedIndexInTrackGroup()], true);
                if(h0 == null) {
                    break;
                }
                I6.V v3 = h0.r;
                if(v3.isEmpty() || !h0.c) {
                    break;
                }
                long v4 = h0.h - c0.n;
                long v5 = v - v4;
                int v6 = e3.x.c(v3, v5, true);
                long v7 = ((f)v3.get(v6)).e;
                return v6 == v3.size() - 1 ? i00.a(v5, v7, v7) + v4 : i00.a(v5, v7, ((f)v3.get(v6 + 1)).e) + v4;
            }
        }
        return v;
    }

    @Override  // s3.x
    public final void g(long v) {
        l3.p[] arr_p = this.G;
        for(int v1 = 0; v1 < arr_p.length; ++v1) {
            l3.p p0 = arr_p[v1];
            if(p0.X && !p0.r()) {
                int v2 = p0.I.length;
                for(int v3 = 0; v3 < v2; ++v3) {
                    p0.I[v3].f(v, p0.j0[v3]);
                }
            }
        }
    }

    @Override  // s3.X
    public final long getBufferedPositionUs() {
        return this.M.getBufferedPositionUs();
    }

    @Override  // s3.X
    public final long getNextLoadPositionUs() {
        return this.M.getNextLoadPositionUs();
    }

    @Override  // s3.x
    public final g0 getTrackGroups() {
        g0 g00 = this.D;
        g00.getClass();
        return g00;
    }

    public static androidx.media3.common.b h(androidx.media3.common.b b0, androidx.media3.common.b b1, boolean z) {
        I6.V v4;
        String s2;
        String s1;
        int v3;
        int v2;
        int v1;
        Metadata metadata0;
        String s;
        p0 p00 = p0.e;
        int v = -1;
        if(b1 == null) {
            String s3 = e3.x.s(b0.k, 1);
            metadata0 = b0.l;
            if(z) {
                v1 = b0.C;
                v2 = b0.e;
                v3 = b0.f;
                s1 = b0.d;
                s2 = b0.b;
                s = s3;
                v4 = b0.c;
            }
            else {
                v2 = 0;
                s1 = null;
                s = s3;
                v4 = p00;
                v1 = -1;
                v3 = 0;
                s2 = null;
            }
        }
        else {
            s = b1.k;
            metadata0 = b1.l;
            v1 = b1.C;
            v2 = b1.e;
            v3 = b1.f;
            s1 = b1.d;
            s2 = b1.b;
            v4 = b1.c;
        }
        String s4 = H.c(s);
        int v5 = z ? b0.h : -1;
        if(z) {
            v = b0.i;
        }
        n n0 = new n();
        n0.a = b0.a;
        n0.b = s2;
        n0.c = I6.V.p(v4);
        n0.l = H.l(b0.m);
        n0.m = H.l(s4);
        n0.j = s;
        n0.k = metadata0;
        n0.h = v5;
        n0.i = v;
        n0.B = v1;
        n0.e = v2;
        n0.f = v3;
        n0.d = s1;
        return new androidx.media3.common.b(n0);
    }

    @Override  // s3.X
    public final boolean isLoading() {
        return this.M.isLoading();
    }

    @Override  // s3.x
    public final void maybeThrowPrepareError() {
        l3.p[] arr_p = this.E;
        for(int v = 0; v < arr_p.length; ++v) {
            l3.p p0 = arr_p[v];
            p0.t();
            if(p0.p0 && !p0.Y) {
                throw I.a(null, "Loading finished before preparation is complete.");
            }
        }
    }

    @Override  // m3.p
    public final void onPlaylistChanged() {
        l3.p[] arr_p = this.E;
        for(int v = 0; v < arr_p.length; ++v) {
            l3.p p0 = arr_p[v];
            w3.k k0 = p0.j;
            ArrayList arrayList0 = p0.n;
            if(!arrayList0.isEmpty()) {
                i i0 = (i)I6.w.j(arrayList0);
                int v1 = p0.d.b(i0);
                if(v1 == 1) {
                    i0.K = true;
                }
                else if(v1 == 0) {
                    P3 p30 = new P3(15, p0, i0);
                    p0.B.post(p30);
                }
                else if(v1 == 2 && !p0.p0 && k0.b()) {
                    k0.a();
                }
            }
        }
        this.w.a(this);
    }

    @Override  // s3.x
    public final long readDiscontinuity() {
        return 0x8000000000000001L;
    }

    @Override  // s3.X
    public final void reevaluateBuffer(long v) {
        this.M.reevaluateBuffer(v);
    }

    @Override  // s3.x
    public final long seekToUs(long v) {
        l3.p[] arr_p = this.G;
        if(arr_p.length > 0) {
            boolean z = arr_p[0].w(v, false);
            for(int v1 = 1; true; ++v1) {
                l3.p[] arr_p1 = this.G;
                if(v1 >= arr_p1.length) {
                    break;
                }
                arr_p1[v1].w(v, z);
            }
            if(z) {
                this.k.a.clear();
            }
        }
        return v;
    }
}

