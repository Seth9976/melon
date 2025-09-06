package i.n.i.b.a.s.e;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public final class k0 {
    public final Object a;
    public final Object b;
    public final B7[] c;
    public boolean d;
    public boolean e;
    public Y0 f;
    public boolean g;
    public final boolean[] h;
    public final d2[] i;
    public final C4 j;
    public final i3 k;
    public k0 l;
    public wc m;
    public F7 n;
    public long o;

    public k0(d2[] arr_d2, long v, C4 c40, L3 l30, i3 i30, Y0 y00, F7 f70) {
        this.i = arr_d2;
        this.o = v;
        this.j = c40;
        this.k = i30;
        this.b = y00.a.a;
        this.f = y00;
        this.m = wc.d;
        this.n = f70;
        this.c = new B7[arr_d2.length];
        this.h = new boolean[arr_d2.length];
        long v1 = y00.b;
        long v2 = y00.d;
        i30.getClass();
        Object object0 = ((Pair)y00.a.a).first;
        e2 e20 = y00.a.b(((Pair)y00.a.a).second);
        h3 h30 = (h3)i30.c.get(object0);
        h30.getClass();
        i30.h.add(h30);
        g3 g30 = (g3)i30.g.get(h30);
        if(g30 != null) {
            g30.a.h(g30.b);
        }
        h30.c.add(e20);
        oe oe0 = h30.a.x(e20, l30, v1);
        i30.b.put(oe0, h30);
        i30.d();
        if(v2 != 0x8000000000000001L && v2 != 0x8000000000000000L) {
            oe0 = new A7(oe0, true, 0L, v2);
        }
        this.a = oe0;
    }

    public final long a(F7 f70, long v, boolean z, boolean[] arr_z) {
        boolean[] arr_z1;
        q2[] arr_q2 = (q2[])f70.c;
        for(int v1 = 0; true; ++v1) {
            arr_z1 = this.h;
            boolean z1 = true;
            if(v1 >= f70.a) {
                break;
            }
            if(z || !f70.d(this.n, v1)) {
                z1 = false;
            }
            arr_z1[v1] = z1;
        }
        boolean[] arr_z2 = new boolean[arr_q2.length];
        q2[] arr_q21 = (q2[])this.n.c;
        for(int v2 = 0; v2 < arr_q2.length; ++v2) {
            if(!arr_z1[v2] && !z) {
                q2 q20 = arr_q2[v2];
                if(q20 != null) {
                    q2 q21 = arr_q21[v2];
                    if(q21 != null && q20.a == q21.a) {
                        arr_z2[v2] = true;
                    }
                }
            }
        }
        boolean[] arr_z3 = (boolean[])f70.e;
        boolean z2 = false;
        for(int v3 = 0; v3 < arr_z3.length; ++v3) {
            z2 |= arr_z3[v3];
        }
        Object object0 = this.a;
        B7[] arr_b7 = this.c;
        if(!z && !z2 && ((v0)object0).m(arr_q2, arr_z2, arr_b7)) {
            for(int v4 = 0; true; ++v4) {
                q2[] arr_q22 = (q2[])this.n.c;
                if(v4 >= arr_q22.length) {
                    break;
                }
                q2 q22 = arr_q22[v4];
                q2 q23 = arr_q2[v4];
                arr_z1[v4] = q22 == null || q23 == null ? true : q22.a.equals(q23.a);
            }
        }
        for(int v5 = 0; true; ++v5) {
            d2[] arr_d2 = this.i;
            if(v5 >= arr_d2.length) {
                break;
            }
            if(arr_d2[v5].a == 7) {
                arr_b7[v5] = null;
            }
        }
        this.b();
        this.n = f70;
        this.d();
        long v6 = ((v0)object0).v(((q2[])f70.c), this.h, this.c, arr_z, v);
        for(int v7 = 0; v7 < arr_d2.length; ++v7) {
            if(arr_d2[v7].a == 7 && this.n.a(v7)) {
                arr_b7[v7] = new dc();  // 初始化器: Ljava/lang/Object;-><init>()V
            }
        }
        this.e = false;
        for(int v8 = 0; v8 < arr_b7.length; ++v8) {
            if(arr_b7[v8] == null) {
                M7.J(arr_q2[v8] == null);
            }
            else {
                M7.J(f70.a(v8));
                if(arr_d2[v8].a != 7) {
                    this.e = true;
                }
            }
        }
        return v6;
    }

    public final void b() {
        if(this.l == null) {
            for(int v = 0; true; ++v) {
                F7 f70 = this.n;
                if(v >= f70.a) {
                    break;
                }
                boolean z = f70.a(v);
                q2 q20 = ((q2[])this.n.c)[v];
                if(z && q20 != null) {
                    q20.k();
                }
            }
        }
    }

    public final F7 c(float f, i i0) {
        int v60;
        int[][] arr2_v3;
        vc vc13;
        Pair pair1;
        int v64;
        J3 j32;
        int v54;
        int v53;
        int v52;
        Pair pair0;
        boolean[] arr_z1;
        B4 b41;
        vc vc9;
        vc[] arr_vc1;
        int[] arr_v9;
        int v41;
        J3 j31;
        int v37;
        int v36;
        int v32;
        int[] arr_v6;
        wc[] arr_wc1;
        int v21;
        int[] arr_v2;
        wc wc0 = this.m;
        e2 e20 = this.f.a;
        C4 c40 = this.j;
        c40.getClass();
        d2[] arr_d2 = this.i;
        int[] arr_v = new int[arr_d2.length + 1];
        int v = arr_d2.length + 1;
        vc[][] arr2_vc = new vc[v][];
        int[][][] arr3_v = new int[arr_d2.length + 1][][];
        for(int v1 = 0; v1 < v; ++v1) {
            arr2_vc[v1] = new vc[wc0.a];
            arr3_v[v1] = new int[wc0.a][];
        }
        boolean[] arr_z = new boolean[arr_d2.length + 1];
        int[] arr_v1 = new int[arr_d2.length];
        for(int v2 = 0; v2 < arr_d2.length; ++v2) {
            arr_v1[v2] = arr_d2[v2].v();
        }
        int v3 = 0;
        while(true) {
            int v4 = wc0.a;
            vc[] arr_vc = wc0.b;
            if(v3 >= v4) {
                break;
            }
            if(arr_vc[v3].b[0].l != null) {
                boolean z = v4 == 0;
                int v5 = 0;
                int v6 = 0;
                while(v5 < wc0.a) {
                    vc vc0 = arr_vc[v5];
                    u[] arr_u = vc0.b;
                    int v7 = vc0.a;
                    int v8 = mb.g(arr_u[0].l) == 5 ? 1 : 0;
                    int v9 = arr_d2.length;
                    int v10 = v8;
                    int v11 = 1;
                    int v13 = 0;
                    for(int v12 = 0; v12 < arr_d2.length; ++v12) {
                        d2 d20 = arr_d2[v12];
                        int v15 = 0;
                        for(int v14 = 0; v14 < v7; ++v14) {
                            v15 = Math.max(v15, d20.g(arr_u[v14]) & 7);
                        }
                        int v16 = arr_v[v12] == 0 ? 1 : 0;
                        if(v15 > v13 || v15 == v13 && v10 != 0 && v11 == 0 && v16 != 0) {
                            v11 = v16;
                            v13 = v15;
                            v9 = v12;
                        }
                    }
                    if(v9 == arr_d2.length) {
                        arr_v2 = new int[v7];
                    }
                    else {
                        d2 d21 = arr_d2[v9];
                        int[] arr_v3 = new int[v7];
                        for(int v17 = 0; v17 < v7; ++v17) {
                            arr_v3[v17] = d21.g(arr_u[v17]);
                        }
                        arr_v2 = arr_v3;
                    }
                    int v18 = arr_v[v9];
                    arr2_vc[v9][v18] = vc0;
                    arr3_v[v9][v18] = arr_v2;
                    arr_v[v9] = v18 + 1;
                    int v19 = arr_v2.length;
                    int v20 = 0;
                    while(v20 < v19) {
                        switch(arr_v2[v20] & 7) {
                            case 2: {
                                v21 = 1;
                                v6 |= v21;
                                ++v20;
                                continue;
                            }
                            case 3: 
                            case 4: {
                                break;
                            }
                            default: {
                                v21 = 0;
                                v6 |= v21;
                                ++v20;
                                continue;
                            }
                        }
                        z = true;
                        if(true) {
                            break;
                        }
                    }
                    ++v5;
                }
                if(!z && !c40.d) {
                    X9 x90 = v6 == 0 ? new N("No renderer that supports this content") : new X9();  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                    throw new y7(1, x90, null, -1, null, 4, false);
                }
                wc[] arr_wc = new wc[arr_d2.length];
                String[] arr_s = new String[arr_d2.length];
                int[] arr_v4 = new int[arr_d2.length];
                for(int v22 = 0; v22 < arr_d2.length; ++v22) {
                    int v23 = arr_v[v22];
                    arr_wc[v22] = new wc(((vc[])L7.s(v23, arr2_vc[v22])));
                    arr3_v[v22] = (int[][])L7.s(v23, arr3_v[v22]);
                    arr_s[v22] = arr_d2[v22].r();
                    arr_v4[v22] = arr_d2[v22].a;
                }
                new wc(((vc[])L7.s(arr_v[arr_d2.length], arr2_vc[arr_d2.length])));
                B4 b40 = new B4(arr_v4, arr_wc);
                d fi$d0 = (d)((fi)c40).f.get();
                int v24 = b40.a;
                J3[] arr_j3 = new J3[v24];
                boolean z1 = false;
                int v25 = 0;
                int v26 = 0;
                while(v25 < v24) {
                    if(2 == arr_v4[v25]) {
                        if(z1) {
                            arr_wc1 = arr_wc;
                            arr_v6 = arr_v4;
                            v32 = v25;
                            v37 = v26;
                        }
                        else {
                            J3 j30 = null;
                            wc wc1 = arr_wc[v25];
                            int[][] arr2_v = arr3_v[v25];
                            int v27 = arr_v1[v25];
                            if(fi$d0.Z || fi$d0.Y) {
                                arr_wc1 = arr_wc;
                                arr_v6 = arr_v4;
                            }
                            else {
                                int v28 = fi$d0.w ? 24 : 16;
                                int v29 = !fi$d0.r || (v27 & v28) == 0 ? 0 : 1;
                                int v30 = fi$d0.I;
                                if(v30 == -1) {
                                    arr_wc1 = arr_wc;
                                }
                                else if(v30 < wc1.a) {
                                    vc vc1 = wc1.b[v30];
                                    arr_wc1 = arr_wc;
                                    int[] arr_v5 = fi.f(vc1, arr2_v[v30], ((boolean)v29), v28, fi$d0.g, fi$d0.h, fi$d0.i, fi$d0.j, fi$d0.k, fi$d0.l, fi$d0.m, fi$d0.n, fi$d0.B, fi$d0.D, fi$d0.E);
                                    vc vc2 = vc1;
                                    if(arr_v5.length > 0) {
                                        arr_v6 = arr_v4;
                                        j30 = new J3(vc2, arr_v5, 0);
                                        goto label_150;
                                    }
                                }
                                else {
                                    arr_wc1 = arr_wc;
                                    arr_v6 = arr_v4;
                                    Log.w("DefaultTrackSelector", "The configured track index is out of range. The number of tracks: " + wc1.a);
                                    goto label_137;
                                }
                                arr_v6 = arr_v4;
                            label_137:
                                for(int v31 = 0; v31 < wc1.a; ++v31) {
                                    vc vc3 = wc1.b[v31];
                                    int[] arr_v7 = fi.f(vc3, arr2_v[v31], ((boolean)v29), v28, fi$d0.g, fi$d0.h, fi$d0.i, fi$d0.j, fi$d0.k, fi$d0.l, fi$d0.m, fi$d0.n, fi$d0.B, fi$d0.D, fi$d0.E);
                                    vc vc4 = vc3;
                                    if(arr_v7.length > 0) {
                                        j30 = new J3(vc4, arr_v7, 0);
                                        break;
                                    }
                                }
                            }
                        label_150:
                            if(j30 == null) {
                                v32 = v25;
                                vc vc5 = null;
                                V2 v20_1 = null;
                                int v33 = 0;
                                int v34 = -1;
                                while(v33 < wc1.a) {
                                    vc vc6 = wc1.b[v33];
                                    ArrayList arrayList0 = fi.c(vc6, fi$d0.B, fi$d0.D, fi$d0.E);
                                    int[] arr_v8 = arr2_v[v33];
                                    vc vc7 = vc5;
                                    int v35 = 0;
                                    while(v35 < vc6.a) {
                                        u u0 = vc6.b[v35];
                                        if((u0.e & 0x4000) == 0) {
                                            if(fi.d(arr_v8[v35], fi$d0.b0)) {
                                                v36 = v35;
                                                V2 v21_1 = new V2(u0, fi$d0, arr_v8[v35], arrayList0.contains(v36));
                                                if((v21_1.a || fi$d0.o) && (v20_1 == null || v21_1.a(v20_1) > 0)) {
                                                    v20_1 = v21_1;
                                                    vc7 = vc6;
                                                    v34 = v36;
                                                }
                                            }
                                            else {
                                                v36 = v35;
                                            }
                                            v35 = v36 + 1;
                                        }
                                        else {
                                            ++v35;
                                        }
                                    }
                                    ++v33;
                                    vc5 = vc7;
                                }
                                v37 = v26;
                                j31 = vc5 == null ? null : new J3(vc5, new int[]{v34}, 0);
                            }
                            else {
                                v32 = v25;
                                v37 = v26;
                                j31 = j30;
                            }
                            arr_j3[v32] = j31;
                            z1 = j31 == null ? false : true;
                        }
                        v26 = v37 | (arr_wc1[v32].a <= 0 ? 0 : 1);
                    }
                    else {
                        arr_wc1 = arr_wc;
                        arr_v6 = arr_v4;
                        v32 = v25;
                    }
                    v25 = v32 + 1;
                    arr_wc = arr_wc1;
                    arr_v4 = arr_v6;
                }
                Q2 q20 = null;
                String s = null;
                int v38 = 0;
                int v39 = -1;
                while(v38 < v24) {
                    if(1 == arr_v4[v38]) {
                        boolean z2 = fi$d0.d0 || v26 == 0;
                        wc wc2 = arr_wc[v38];
                        int[][] arr2_v1 = arr3_v[v38];
                        int v40 = arr_v1[v38];
                        v41 = v38;
                        arr_v9 = arr_v1;
                        Q2 q21 = null;
                        int v42 = -1;
                        int v43 = -1;
                        int v44 = 0;
                        while(true) {
                            arr_vc1 = wc2.b;
                            if(v44 >= wc2.a) {
                                break;
                            }
                            vc vc8 = arr_vc1[v44];
                            int[] arr_v10 = arr2_v1[v44];
                            int v45 = v43;
                            Q2 q22 = q21;
                            int v46 = v42;
                            int v47 = 0;
                            while(v47 < vc8.a) {
                                if(fi.d(arr_v10[v47], fi$d0.b0)) {
                                    vc9 = vc8;
                                    Q2 q23 = new Q2(vc8.b[v47], fi$d0, arr_v10[v47], v44);
                                    if((q23.a || fi$d0.S) && (q22 == null || q23.a(q22) > 0)) {
                                        q22 = q23;
                                        v46 = v44;
                                        v45 = v47;
                                    }
                                }
                                else {
                                    vc9 = vc8;
                                }
                                ++v47;
                                vc8 = vc9;
                            }
                            ++v44;
                            v42 = v46;
                            q21 = q22;
                            v43 = v45;
                        }
                        if(v42 == -1) {
                            b41 = b40;
                            arr_z1 = arr_z;
                            pair0 = null;
                        }
                        else {
                            vc vc10 = arr_vc1[v42];
                            if(fi$d0.Z || fi$d0.Y || !z2) {
                                b41 = b40;
                                arr_z1 = arr_z;
                                v54 = v43;
                            }
                            else {
                                int v48 = fi$d0.N;
                                int[] arr_v11 = arr2_v1[v42];
                                boolean z3 = fi$d0.W;
                                u u1 = vc10.b[v43];
                                boolean z4 = fi$d0.T;
                                int v49 = vc10.a;
                                boolean z5 = fi$d0.V;
                                int[] arr_v12 = new int[v49];
                                b41 = b40;
                                arr_z1 = arr_z;
                                int v50 = 0;
                                int v51 = 0;
                                while(v50 < v49) {
                                    if(v50 == v43) {
                                        v52 = v43;
                                        v53 = v49;
                                        arr_v12[v51] = v50;
                                        ++v51;
                                    }
                                    else {
                                        u u2 = vc10.b[v50];
                                        v52 = v43;
                                        v53 = v49;
                                        if(fi.d(arr_v11[v50], false) && (u2.h != -1 && u2.h <= v48) && (z3 || u2.S != -1 && u2.S == u1.S) && (z4 || u2.l != null && TextUtils.equals(u2.l, u1.l)) && (z5 || u2.T != -1 && u2.T == u1.T)) {
                                            arr_v12[v51] = v50;
                                            ++v51;
                                        }
                                    }
                                    ++v50;
                                    v43 = v52;
                                    v49 = v53;
                                }
                                v54 = v43;
                                int[] arr_v13 = Arrays.copyOf(arr_v12, v51);
                                if(arr_v13.length > 1) {
                                    j32 = new J3(vc10, arr_v13, 0);
                                    goto label_296;
                                }
                            }
                            j32 = null;
                        label_296:
                            if(j32 == null) {
                                j32 = new J3(vc10, new int[]{v54}, 0);
                            }
                            q21.getClass();
                            pair0 = Pair.create(j32, q21);
                        }
                        if(pair0 != null && (q20 == null || ((Q2)pair0.second).a(q20) > 0)) {
                            if(v39 != -1) {
                                arr_j3[v39] = null;
                            }
                            J3 j33 = (J3)pair0.first;
                            arr_j3[v41] = j33;
                            s = j33.a.b[j33.b[0]].c;
                            q20 = (Q2)pair0.second;
                            v39 = v41;
                        }
                    }
                    else {
                        v41 = v38;
                        b41 = b40;
                        arr_z1 = arr_z;
                        arr_v9 = arr_v1;
                    }
                    v38 = v41 + 1;
                    arr_v1 = arr_v9;
                    b40 = b41;
                    arr_z = arr_z1;
                }
                U2 u20 = null;
                int v55 = 0;
                int v56 = -1;
                while(v55 < v24) {
                    switch(arr_v4[v55]) {
                        case 1: 
                        case 2: {
                            v60 = v55;
                            break;
                        }
                        case 3: {
                            v60 = v55;
                            wc wc4 = arr_wc[v60];
                            int[][] arr2_v4 = arr3_v[v60];
                            vc vc14 = null;
                            U2 u21 = null;
                            int v62 = -1;
                            for(int v61 = 0; v61 < wc4.a; ++v61) {
                                vc vc15 = wc4.b[v61];
                                int[] arr_v15 = arr2_v4[v61];
                                int v63 = 0;
                                while(v63 < vc15.a) {
                                    if(fi.d(arr_v15[v63], fi$d0.b0)) {
                                        v64 = v61;
                                        U2 u22 = new U2(vc15.b[v63], fi$d0, arr_v15[v63], s);
                                        if(u22.a && (u21 == null || u22.a(u21) > 0)) {
                                            u21 = u22;
                                            vc14 = vc15;
                                            v62 = v63;
                                        }
                                    }
                                    else {
                                        v64 = v61;
                                    }
                                    ++v63;
                                    v61 = v64;
                                }
                            }
                            if(vc14 == null) {
                                pair1 = null;
                            }
                            else {
                                J3 j34 = new J3(vc14, new int[]{v62}, 0);
                                u21.getClass();
                                pair1 = Pair.create(j34, u21);
                            }
                            if(pair1 != null && (u20 == null || ((U2)pair1.second).a(u20) > 0)) {
                                if(v56 != -1) {
                                    arr_j3[v56] = null;
                                }
                                arr_j3[v60] = (J3)pair1.first;
                                u20 = (U2)pair1.second;
                                v56 = v60;
                            }
                            break;
                        }
                        default: {
                            wc wc3 = arr_wc[v55];
                            int[][] arr2_v2 = arr3_v[v55];
                            vc vc11 = null;
                            R2 r20 = null;
                            int v57 = 0;
                            int v58 = 0;
                            while(v57 < wc3.a) {
                                vc vc12 = wc3.b[v57];
                                int[] arr_v14 = arr2_v2[v57];
                                int v59 = 0;
                                while(v59 < vc12.a) {
                                    if(fi.d(arr_v14[v59], fi$d0.b0)) {
                                        vc13 = vc12;
                                        R2 r21 = new R2(vc12.b[v59], arr_v14[v59]);
                                        if(r20 == null) {
                                            arr2_v3 = arr2_v2;
                                        label_342:
                                            r20 = r21;
                                            v58 = v59;
                                            vc11 = vc13;
                                        }
                                        else {
                                            arr2_v3 = arr2_v2;
                                            if(u6.a.c(r21.b, r20.b).c(r21.a, r20.a).e() > 0) {
                                                goto label_342;
                                            }
                                        }
                                    }
                                    else {
                                        vc13 = vc12;
                                        arr2_v3 = arr2_v2;
                                    }
                                    ++v59;
                                    vc12 = vc13;
                                    arr2_v2 = arr2_v3;
                                }
                                ++v57;
                            }
                            v60 = v55;
                            arr_j3[v60] = vc11 == null ? null : new J3(vc11, new int[]{v58}, 0);
                        }
                    }
                    v55 = v60 + 1;
                }
                for(int v65 = 0; v65 < v24; ++v65) {
                    SparseArray sparseArray0 = fi$d0.e0;
                    if(fi$d0.f0.get(v65)) {
                        arr_j3[v65] = null;
                    }
                    else {
                        wc wc5 = arr_wc[v65];
                        Map map0 = (Map)sparseArray0.get(v65);
                        if(map0 != null && map0.containsKey(wc5)) {
                            Map map1 = (Map)sparseArray0.get(v65);
                            f fi$f0 = map1 == null ? null : ((f)map1.get(wc5));
                            arr_j3[v65] = fi$f0 == null ? null : new J3(wc5.b[fi$f0.a], fi$f0.b, fi$f0.c);
                            if(fi$f0 != null) {
                                arr_z[v65] = fi$f0.d;
                            }
                        }
                    }
                }
                bb bb0 = ((fi)c40).b;
                bb0.getClass();
                q2[] arr_q2 = ((fi)c40).e.c(arr_j3, bb0, e20, i0);
                Ha[] arr_ha = new Ha[v24];
                for(int v66 = 0; v66 < v24; ++v66) {
                    arr_ha[v66] = fi$d0.f0.get(v66) || arr_v4[v66] != 7 && arr_q2[v66] == null ? null : Ha.b;
                }
                if(fi$d0.c0) {
                    int v67 = -1;
                    int v68 = 0;
                    int v69 = -1;
                    while(true) {
                        int v70 = 1;
                        if(v68 >= v24) {
                            goto label_455;
                        }
                        int v71 = arr_v4[v68];
                        q2 q24 = arr_q2[v68];
                        if(v71 != 1 && v71 != 2 || q24 == null) {
                            goto label_453;
                        }
                        int[][] arr2_v5 = arr3_v[v68];
                        int v72 = arr_wc[v68].a(q24.a);
                        int v73 = 0;
                        while(true) {
                            int[] arr_v16 = q24.c;
                            if(v73 >= arr_v16.length) {
                                break;
                            }
                            if((arr2_v5[v72][arr_v16[v73]] & 0x20) != 0x20) {
                                goto label_453;
                            }
                            ++v73;
                        }
                        if(v71 != 1) {
                            if(v69 == -1) {
                                v69 = v68;
                                ++v68;
                                continue;
                            label_453:
                                ++v68;
                                continue;
                            }
                            else {
                                v70 = 0;
                            }
                        label_455:
                            break;
                        }
                        else if(v67 == -1) {
                            v67 = v68;
                            goto label_453;
                        }
                        else {
                            v70 = 0;
                            break;
                        }
                        goto label_460;
                    }
                    if((v70 & (v67 == -1 || v69 == -1 ? 0 : 1)) != 0) {
                        Ha ha0 = new Ha(true);
                        arr_ha[v67] = ha0;
                        arr_ha[v69] = ha0;
                    }
                }
            label_460:
                Pair pair2 = Pair.create(arr_ha, arr_q2);
                F7 f70 = new F7(((Ha[])pair2.first), ((q2[])pair2.second), arr_z, b40);
                q2[] arr_q21 = (q2[])f70.c;
                for(int v74 = 0; v74 < arr_q21.length; ++v74) {
                    q2 q25 = arr_q21[v74];
                    if(q25 != null) {
                        q25.c(f);
                    }
                }
                return f70;
            }
            ++v3;
        }
        throw new y7(0, new H4("No format in the content."));  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
    }

    public final void d() {
        if(this.l == null) {
            for(int v = 0; true; ++v) {
                F7 f70 = this.n;
                if(v >= f70.a) {
                    break;
                }
                boolean z = f70.a(v);
                q2 q20 = ((q2[])this.n.c)[v];
                if(z && q20 != null) {
                    q20.l();
                }
            }
        }
    }

    public final long e() {
        if(!this.d) {
            return this.f.b;
        }
        long v = this.e ? ((b8)this.a).c() : 0x8000000000000000L;
        return v == 0x8000000000000000L ? this.f.e : v;
    }

    public final long f() {
        return this.f.b + this.o;
    }

    public final void g() {
        this.b();
        long v = this.f.d;
        i3 i30 = this.k;
        Object object0 = this.a;
        try {
            if(Long.compare(v, 0x8000000000000001L) != 0 && v != 0x8000000000000000L) {
                i30.b(((A7)object0).a);
                return;
            }
            i30.b(((v0)object0));
            return;
        }
        catch(RuntimeException runtimeException0) {
        }
        M7.H("MediaPeriodHolder", "Period release failed.", runtimeException0);
    }
}

