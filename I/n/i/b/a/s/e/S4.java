package i.n.i.b.a.s.e;

import B3.v;
import H4.b;
import U4.x;
import android.util.Log;
import android.util.Pair;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class s4 implements q4, sd {
    public final wb a;
    public final wb b;
    public final wb c;
    public final wb d;
    public final ArrayDeque e;
    public final l5 f;
    public final ArrayList g;
    public int h;
    public int i;
    public long j;
    public int k;
    public wb l;
    public int m;
    public int n;
    public int o;
    public int p;
    public U5 q;
    public r4[] r;
    public long[][] s;
    public int t;
    public long u;
    public int v;
    public static final p w;

    static {
        s4.w = new p(9);
    }

    public s4(int v) {
        this.h = 0;
        this.f = new l5();
        this.g = new ArrayList();
        this.d = new wb(16);
        this.e = new ArrayDeque();
        this.a = new wb(Ja.u);
        this.b = new wb(4);
        this.c = new wb(1, false);
        this.m = -1;
    }

    @Override  // i.n.i.b.a.s.e.sd
    public final rd b(long v) {
        int[] arr_v5;
        int v11;
        long v7;
        long v5;
        long v4;
        r4[] arr_r4 = this.r;
        arr_r4.getClass();
        Nd nd0 = Nd.c;
        if(arr_r4.length == 0) {
            return new rd(nd0, nd0);
        }
        int v1 = this.t;
        long v2 = -1L;
        if(v1 == -1) {
            v5 = 0x7FFFFFFFFFFFFFFFL;
            v4 = v;
            v7 = 0x8000000000000001L;
        }
        else {
            U7 u70 = this.r[v1].b;
            long[] arr_v = u70.f;
            int v3;
            for(v3 = L7.y(arr_v, v, false); true; --v3) {
                if(v3 < 0) {
                    v3 = -1;
                    break;
                }
                if((u70.g[v3] & 1) != 0) {
                    break;
                }
            }
            if(v3 == -1) {
                v3 = u70.a(v);
            }
            long[] arr_v1 = u70.c;
            if(v3 == -1) {
                return new rd(nd0, nd0);
            }
            v4 = arr_v[v3];
            v5 = arr_v1[v3];
            if(v4 >= v || v3 >= u70.b - 1) {
                v7 = 0x8000000000000001L;
            }
            else {
                int v6 = u70.a(v);
                if(v6 == -1 || v6 == v3) {
                    v7 = 0x8000000000000001L;
                }
                else {
                    v7 = arr_v[v6];
                    v2 = arr_v1[v6];
                }
            }
        }
        int v8 = 0;
        long v9 = v5;
        while(true) {
            r4[] arr_r41 = this.r;
            if(v8 >= arr_r41.length) {
                break;
            }
            if(v8 != this.t) {
                U7 u71 = arr_r41[v8].b;
                long[] arr_v2 = u71.c;
                int[] arr_v3 = u71.g;
                long[] arr_v4 = u71.f;
                int v10 = L7.y(arr_v4, v4, false);
                while(true) {
                    v11 = -1;
                    if(v10 >= 0) {
                        if((arr_v3[v10] & 1) == 0) {
                            --v10;
                            continue;
                        }
                        else {
                            v11 = v10;
                        }
                    }
                    break;
                }
                if(v11 == -1) {
                    v11 = u71.a(v4);
                }
                if(v11 == -1) {
                    arr_v5 = arr_v3;
                }
                else {
                    arr_v5 = arr_v3;
                    v9 = Math.min(arr_v2[v11], v9);
                }
                if(v7 != 0x8000000000000001L) {
                    int v12 = L7.y(arr_v4, v7, false);
                    while(true) {
                        if(v12 >= 0) {
                            if((arr_v5[v12] & 1) == 0) {
                                --v12;
                                continue;
                            }
                            else {
                                break;
                            }
                        }
                        v12 = -1;
                        break;
                    }
                    if(v12 == -1) {
                        v12 = u71.a(v7);
                    }
                    if(v12 != -1) {
                        v2 = Math.min(arr_v2[v12], v2);
                    }
                }
            }
            ++v8;
        }
        Nd nd1 = new Nd(v4, v9);
        return v7 == 0x8000000000000001L ? new rd(nd1, nd1) : new rd(nd1, new Nd(v7, v2));
    }

    @Override  // i.n.i.b.a.s.e.sd
    public final boolean b() {
        return true;
    }

    public final void c(long v) {
        int v47;
        Ka ka5;
        x8 x811;
        int v46;
        int v39;
        Ka ka4;
        ArrayList arrayList4;
        x8 x88;
        x8 x87;
        long v38;
        x8 x86;
        Ka ka2;
        o0 o03;
        x8 x85;
        ba ba0;
        Ka ka1;
        o0 o02;
        x8 x84;
        x8 x83;
        x8 x82;
        ArrayDeque arrayDeque2;
        ArrayDeque arrayDeque1;
        v9 v90;
        int v12;
        v9 v91;
        String s;
        while(true) {
            ArrayDeque arrayDeque0 = this.e;
            if(arrayDeque0.isEmpty() || ((o0)arrayDeque0.peek()).c != v) {
                break;
            }
            o0 o00 = (o0)arrayDeque0.pop();
            if(o00.b == 0x6D6F6F76) {
                ArrayList arrayList0 = new ArrayList();
                boolean z = this.v == 1;
                Ka ka0 = new Ka();
                p0 p00 = o00.p(0x75647461);
                if(p00 == null) {
                    arrayDeque2 = arrayDeque0;
                    x83 = null;
                    x82 = null;
                }
                else {
                    wb wb0 = p00.c;
                    wb0.n(8);
                    x8 x80 = null;
                    x8 x81 = null;
                    while(wb0.d() >= 8) {
                        int v1 = wb0.b;
                        int v2 = wb0.p();
                        int v3 = wb0.p();
                        if(v3 == 0x6D657461) {
                            wb0.n(v1);
                            int v4 = v1 + v2;
                            wb0.o(8);
                            int v5 = wb0.b;
                            wb0.o(4);
                            if(wb0.p() != 0x68646C72) {
                                v5 += 4;
                            }
                            wb0.n(v5);
                            int v6;
                            while((v6 = wb0.b) < v4) {
                                int v7 = wb0.p();
                                if(wb0.p() != 0x696C7374) {
                                    goto label_167;
                                }
                                wb0.n(v6);
                                int v8 = v6 + v7;
                                wb0.o(8);
                                ArrayList arrayList1 = new ArrayList();
                                int v9;
                                while((v9 = wb0.b) < v8) {
                                    int v10 = wb0.p() + v9;
                                    int v11 = wb0.p();
                                    if((v11 >> 24 & 0xFF) != 0xA9 && (v11 >> 24 & 0xFF) != 0xFD) {
                                        goto label_65;
                                    label_71:
                                        wb0.n(v10);
                                        v90 = null;
                                        goto label_159;
                                        try {
                                        label_74:
                                            int v13 = X3.f(wb0);
                                            if(v13 > 0) {
                                                String[] arr_s = X3.a;
                                                if(v13 <= 0xC0) {
                                                    s = arr_s[v13 - 1];
                                                }
                                            }
                                            else {
                                                s = null;
                                            }
                                            if(s == null) {
                                                Log.w("MetadataUtil", "Failed to parse standard genre code");
                                                v90 = null;
                                            }
                                            else {
                                                v90 = new z9("TCON", null, s);
                                            }
                                            goto label_116;
                                        label_111:
                                            v91 = X3.c(0x70676170, "ITUNESGAPLESS", wb0, false, true);
                                        }
                                        catch(Throwable throwable0) {
                                            wb0.n(v10);
                                            throw throwable0;
                                        }
                                    label_112:
                                        wb0.n(v10);
                                        v90 = v91;
                                        v12 = v8;
                                        goto label_159;
                                        try {
                                        label_115:
                                            v90 = X3.e(0x736F736E, wb0, "TVSHOWSORT");
                                        }
                                        catch(Throwable throwable0) {
                                            wb0.n(v10);
                                            throw throwable0;
                                        }
                                    label_116:
                                        wb0.n(v10);
                                        v12 = v8;
                                        goto label_159;
                                        try {
                                        label_119:
                                            v90 = X3.e(0x74767368, wb0, "TVSHOW");
                                        }
                                        catch(Throwable throwable0) {
                                            wb0.n(v10);
                                            throw throwable0;
                                        }
                                        wb0.n(v10);
                                        v12 = v8;
                                        goto label_159;
                                    label_123:
                                        String s1 = null;
                                        String s2 = null;
                                        int v14 = -1;
                                        int v15 = -1;
                                        try {
                                            int v16;
                                            while((v16 = wb0.b) < v10) {
                                                int v17 = wb0.p();
                                                int v18 = wb0.p();
                                                wb0.o(4);
                                                if(v18 == 1835360622) {
                                                    s1 = wb0.k(v17 - 12);
                                                }
                                                else {
                                                    switch(v18) {
                                                        case 1684108385: {
                                                            v14 = v16;
                                                            v15 = v17;
                                                            wb0.o(v17 - 12);
                                                            break;
                                                        }
                                                        case 0x6E616D65: {
                                                            s2 = wb0.k(v17 - 12);
                                                            break;
                                                        }
                                                        default: {
                                                            wb0.o(v17 - 12);
                                                        }
                                                    }
                                                }
                                            }
                                            v12 = v8;
                                            if(s1 == null || s2 == null || v14 == -1) {
                                                v90 = null;
                                            }
                                            else {
                                                wb0.n(v14);
                                                wb0.o(16);
                                                v90 = new w9(s1, s2, wb0.k(v15 - 16));
                                            }
                                        }
                                        catch(Throwable throwable0) {
                                            wb0.n(v10);
                                            throw throwable0;
                                        }
                                    }
                                    else {
                                        try {
                                            v12 = v8;
                                            switch(0xFFFFFF & v11) {
                                                case 4280916: {
                                                    v90 = X3.e(v11, wb0, "TPE1");
                                                    goto label_158;
                                                }
                                                case 0x616C62: {
                                                    v90 = X3.e(v11, wb0, "TALB");
                                                    goto label_158;
                                                }
                                                case 6516084: {
                                                    v90 = X3.b(v11, wb0);
                                                    goto label_158;
                                                }
                                                case 0x646179: {
                                                    v90 = X3.e(v11, wb0, "TDRC");
                                                    goto label_158;
                                                }
                                                case 0x67656E: {
                                                    v90 = X3.e(v11, wb0, "TCON");
                                                    goto label_158;
                                                }
                                                case 0x677270: {
                                                    v90 = X3.e(v11, wb0, "TIT1");
                                                    goto label_158;
                                                }
                                                case 7108978: {
                                                    v90 = X3.e(v11, wb0, "USLT");
                                                    goto label_158;
                                                }
                                                case 0x746F6F: {
                                                    v90 = X3.e(v11, wb0, "TSSE");
                                                    goto label_158;
                                                }
                                                case 7233901: 
                                                case 0x74726B: {
                                                    v90 = X3.e(v11, wb0, "TIT2");
                                                    goto label_158;
                                                }
                                                case 0x636F6D: 
                                                case 7828084: {
                                                    v90 = X3.e(v11, wb0, "TCOM");
                                                    goto label_158;
                                                }
                                                default: {
                                                    Log.d("MetadataUtil", "Skipped unknown metadata entry: " + b.b(v11));
                                                    goto label_71;
                                                }
                                            }
                                        label_65:
                                            switch(v11) {
                                                case 757935405: {
                                                    goto label_123;
                                                }
                                                case 1631670868: {
                                                    v90 = X3.e(1631670868, wb0, "TPE2");
                                                    goto label_116;
                                                }
                                                case 0x636F7672: {
                                                    v90 = X3.a(wb0);
                                                    goto label_116;
                                                }
                                                case 0x6370696C: {
                                                    v91 = X3.c(0x6370696C, "TCMP", wb0, true, true);
                                                    goto label_112;
                                                }
                                                case 0x6469736B: {
                                                    v90 = X3.d(0x6469736B, wb0, "TPOS");
                                                    goto label_116;
                                                }
                                                case 0x676E7265: {
                                                    goto label_74;
                                                }
                                                case 0x70676170: {
                                                    goto label_111;
                                                }
                                                case 1920233063: {
                                                    v90 = X3.c(1920233063, "ITUNESADVISORY", wb0, false, false);
                                                    goto label_116;
                                                }
                                                case 0x736F6161: {
                                                    v90 = X3.e(0x736F6161, wb0, "TSOP");
                                                    goto label_116;
                                                }
                                                case 0x736F616C: {
                                                    v90 = X3.e(0x736F616C, wb0, "TSO2");
                                                    goto label_116;
                                                }
                                                case 0x736F6172: {
                                                    v90 = X3.e(0x736F6172, wb0, "TSOA");
                                                    goto label_116;
                                                }
                                                case 0x736F636F: {
                                                    v90 = X3.e(0x736F636F, wb0, "TSOC");
                                                    goto label_116;
                                                }
                                                case 0x736F6E6D: {
                                                    v90 = X3.e(0x736F6E6D, wb0, "TSOT");
                                                    goto label_116;
                                                }
                                                case 0x736F736E: {
                                                    goto label_115;
                                                }
                                                case 0x746D706F: {
                                                    v91 = X3.c(0x746D706F, "TBPM", wb0, true, false);
                                                    goto label_112;
                                                }
                                                case 0x74726B6E: {
                                                    v90 = X3.d(0x74726B6E, wb0, "TRCK");
                                                    goto label_116;
                                                }
                                                case 0x74767368: {
                                                    goto label_119;
                                                }
                                            }
                                            v12 = v8;
                                            if(v11 == 1635087464) {
                                                v90 = X3.e(1635087464, wb0, "AUTH");
                                                goto label_158;
                                            }
                                            else {
                                                Log.d("MetadataUtil", "Skipped unknown metadata entry: " + b.b(v11));
                                            }
                                            goto label_71;
                                        }
                                        catch(Throwable throwable0) {
                                            wb0.n(v10);
                                            throw throwable0;
                                        }
                                    }
                                label_158:
                                    wb0.n(v10);
                                label_159:
                                    if(v90 != null) {
                                        arrayList1.add(v90);
                                    }
                                    v8 = v12;
                                }
                                arrayDeque1 = arrayDeque0;
                                if(!arrayList1.isEmpty()) {
                                    x80 = new x8(arrayList1);
                                    goto label_192;
                                label_167:
                                    wb0.n(v6 + v7);
                                    continue;
                                }
                                goto label_170;
                            }
                            arrayDeque1 = arrayDeque0;
                        label_170:
                            x80 = null;
                        }
                        else {
                            arrayDeque1 = arrayDeque0;
                            if(v3 == 1936553057) {
                                wb0.n(v1);
                                int v19 = v1 + v2;
                                wb0.o(12);
                                while(true) {
                                    int v20 = wb0.b;
                                    if(v20 < v19) {
                                        int v21 = wb0.p();
                                        if(wb0.p() != 1935766900) {
                                            wb0.n(v20 + v21);
                                            continue;
                                        }
                                        else if(v21 >= 14) {
                                            wb0.o(5);
                                            int v22 = wb0.z();
                                            if(v22 == 12 || v22 == 13) {
                                                wb0.o(1);
                                                x81 = new x8(new i.n.i.b.a.s.e.x8.b[]{new ea((v22 == 12 ? 240.0f : 120.0f), wb0.z())});
                                                break;
                                            }
                                        }
                                    }
                                    x81 = null;
                                    break;
                                }
                            }
                        }
                    label_192:
                        wb0.n(v1 + v2);
                        arrayDeque0 = arrayDeque1;
                    }
                    arrayDeque2 = arrayDeque0;
                    Pair pair0 = Pair.create(x80, x81);
                    x82 = (x8)pair0.first;
                    x83 = (x8)pair0.second;
                    if(x82 != null) {
                        ka0.a(x82);
                    }
                }
                o0 o01 = o00.o(0x6D657461);
                if(o01 == null) {
                label_274:
                    x85 = x82;
                    o03 = o00;
                    ka2 = ka0;
                }
                else {
                    p0 p01 = o01.p(0x68646C72);
                    p0 p02 = o01.p(1801812339);
                    p0 p03 = o01.p(0x696C7374);
                    if(p01 == null || p02 == null || p03 == null) {
                        goto label_274;
                    }
                    else {
                        p01.c.n(16);
                        if(p01.c.p() == 0x6D647461) {
                            wb wb1 = p02.c;
                            wb1.n(12);
                            int v23 = wb1.p();
                            String[] arr_s1 = new String[v23];
                            for(int v24 = 0; v24 < v23; ++v24) {
                                int v25 = wb1.p();
                                wb1.o(4);
                                arr_s1[v24] = wb1.g(v25 - 8, b9.c);
                            }
                            wb wb2 = p03.c;
                            wb2.n(8);
                            ArrayList arrayList2 = new ArrayList();
                            while(wb2.d() > 8) {
                                int v26 = wb2.b;
                                int v27 = wb2.p();
                                int v28 = wb2.p() - 1;
                                if(v28 < 0 || v28 >= v23) {
                                    x84 = x82;
                                    o02 = o00;
                                    ka1 = ka0;
                                    x.u(v28, "Skipped metadata with unknown key index: ", "AtomParsers");
                                }
                                else {
                                    String s3 = arr_s1[v28];
                                    int v29 = v26 + v27;
                                    while(true) {
                                        int v30 = wb2.b;
                                        if(v30 < v29) {
                                            int v31 = wb2.p();
                                            x84 = x82;
                                            o02 = o00;
                                            if(wb2.p() == 1684108385) {
                                                int v32 = wb2.p();
                                                int v33 = wb2.p();
                                                byte[] arr_b = new byte[v31 - 16];
                                                ka1 = ka0;
                                                wb2.j(arr_b, 0, v31 - 16);
                                                ba0 = new ba(s3, arr_b, v33, v32);
                                                break;
                                            }
                                            else {
                                                wb2.n(v30 + v31);
                                                x82 = x84;
                                                o00 = o02;
                                                continue;
                                            }
                                        }
                                        x84 = x82;
                                        o02 = o00;
                                        ka1 = ka0;
                                        ba0 = null;
                                        break;
                                    }
                                    if(ba0 != null) {
                                        arrayList2.add(ba0);
                                    }
                                }
                                wb2.n(v26 + v27);
                                x82 = x84;
                                o00 = o02;
                                ka0 = ka1;
                            }
                            x85 = x82;
                            o03 = o00;
                            ka2 = ka0;
                            if(!arrayList2.isEmpty()) {
                                x86 = new x8(arrayList2);
                                goto label_278;
                            }
                        }
                        else {
                            goto label_274;
                        }
                    }
                }
                x86 = null;
            label_278:
                Ka ka3 = ka2;
                ArrayList arrayList3 = i1.c(o03, ka3, 0x8000000000000001L, null, false, z, new Ma(8));
                U5 u50 = this.q;
                u50.getClass();
                int v34 = arrayList3.size();
                int v35 = -1;
                int v36 = 0;
                long v37 = 0x8000000000000001L;
                while(true) {
                    v38 = 0L;
                    if(v36 >= v34) {
                        break;
                    }
                    U7 u70 = (U7)arrayList3.get(v36);
                    if(u70.b == 0) {
                        x87 = x83;
                        x88 = x86;
                        arrayList4 = arrayList3;
                        ka4 = ka3;
                        v39 = v34;
                    }
                    else {
                        D6 d60 = u70.a;
                        long v40 = d60.e;
                        int v41 = d60.b;
                        if(v40 == 0x8000000000000001L) {
                            v40 = u70.h;
                        }
                        long v42 = Math.max(v37, v40);
                        arrayList4 = arrayList3;
                        v39 = v34;
                        r4 r40 = new r4(d60, u70, u50.i(v36, v41));
                        ob ob0 = d60.f.a();
                        ob0.l = u70.e + 30;
                        if(v41 == 2 && v40 > 0L) {
                            int v43 = u70.b;
                            if(v43 > 1) {
                                ob0.r = ((float)v43) / (((float)v40) / 1000000.0f);
                            }
                        }
                        if(v41 == 1 && ka3.c()) {
                            ob0.A = ka3.a;
                            ob0.B = ka3.b;
                        }
                        x8[] arr_x8 = {x83, (this.g.isEmpty() ? null : new x8(this.g))};
                        x8 x89 = new x8(new i.n.i.b.a.s.e.x8.b[0]);
                        if(v41 != 1) {
                            if(v41 == 2 && x86 != null) {
                                int v44 = 0;
                                while(true) {
                                    i.n.i.b.a.s.e.x8.b[] arr_x8$b = x86.a;
                                    x87 = x83;
                                    if(v44 >= arr_x8$b.length) {
                                        goto label_334;
                                    }
                                    i.n.i.b.a.s.e.x8.b x8$b0 = arr_x8$b[v44];
                                    if(x8$b0 instanceof ba && "com.android.capture.fps".equals(((ba)x8$b0).a)) {
                                        x89 = new x8(new i.n.i.b.a.s.e.x8.b[]{((ba)x8$b0)});
                                        goto label_334;
                                    }
                                    ++v44;
                                    x83 = x87;
                                }
                            }
                        }
                        else if(x85 != null) {
                            x87 = x83;
                            x89 = x85;
                            goto label_334;
                        }
                        x87 = x83;
                    label_334:
                        int v45 = 0;
                        while(true) {
                            i.n.i.b.a.s.e.x8.b[] arr_x8$b1 = x89.a;
                            if(v45 >= 2) {
                                break;
                            }
                            x8 x810 = arr_x8[v45];
                            if(x810 == null) {
                                v46 = v45;
                                x811 = x86;
                                ka5 = ka3;
                            }
                            else {
                                i.n.i.b.a.s.e.x8.b[] arr_x8$b2 = x810.a;
                                v46 = v45;
                                if(arr_x8$b2.length == 0) {
                                    x811 = x86;
                                    ka5 = ka3;
                                }
                                else {
                                    x811 = x86;
                                    Object[] arr_object = Arrays.copyOf(arr_x8$b1, arr_x8$b1.length + arr_x8$b2.length);
                                    ka5 = ka3;
                                    System.arraycopy(arr_x8$b2, 0, arr_object, arr_x8$b1.length, arr_x8$b2.length);
                                    x89 = new x8(((i.n.i.b.a.s.e.x8.b[])arr_object));
                                }
                            }
                            v45 = v46 + 1;
                            x86 = x811;
                            ka3 = ka5;
                        }
                        x88 = x86;
                        ka4 = ka3;
                        if(arr_x8$b1.length > 0) {
                            ob0.i = x89;
                        }
                        u u0 = new u(ob0);
                        r40.c.a(u0);
                        if(v41 != 2) {
                            v47 = v35;
                        }
                        else if(v35 == -1) {
                            v47 = arrayList0.size();
                        }
                        else {
                            v47 = v35;
                        }
                        arrayList0.add(r40);
                        v37 = v42;
                        v35 = v47;
                    }
                    ++v36;
                    arrayList3 = arrayList4;
                    v34 = v39;
                    x83 = x87;
                    x86 = x88;
                    ka3 = ka4;
                }
                this.t = v35;
                this.u = v37;
                r4[] arr_r4 = (r4[])arrayList0.toArray(new r4[0]);
                this.r = arr_r4;
                long[][] arr2_v = new long[arr_r4.length][];
                int[] arr_v = new int[arr_r4.length];
                long[] arr_v1 = new long[arr_r4.length];
                boolean[] arr_z = new boolean[arr_r4.length];
                for(int v48 = 0; v48 < arr_r4.length; ++v48) {
                    arr2_v[v48] = new long[arr_r4[v48].b.b];
                    arr_v1[v48] = arr_r4[v48].b.f[0];
                }
                int v49 = 0;
                while(v49 < arr_r4.length) {
                    long v50 = 0x7FFFFFFFFFFFFFFFL;
                    int v51 = -1;
                    for(int v52 = 0; v52 < arr_r4.length; ++v52) {
                        if(!arr_z[v52]) {
                            long v53 = arr_v1[v52];
                            if(v53 <= v50) {
                                v51 = v52;
                                v50 = v53;
                            }
                        }
                    }
                    int v54 = arr_v[v51];
                    long[] arr_v2 = arr2_v[v51];
                    arr_v2[v54] = v38;
                    U7 u71 = arr_r4[v51].b;
                    v38 += (long)u71.d[v54];
                    int v55 = v54 + 1;
                    arr_v[v51] = v55;
                    if(v55 < arr_v2.length) {
                        arr_v1[v51] = u71.f[v55];
                    }
                    else {
                        arr_z[v51] = true;
                        ++v49;
                    }
                }
                this.s = arr2_v;
                u50.b();
                u50.t(this);
                arrayDeque2.clear();
                this.h = 2;
            }
            else if(!arrayDeque0.isEmpty()) {
                ((o0)arrayDeque0.peek()).e.add(o00);
            }
        }
        if(this.h != 2) {
            this.h = 0;
            this.k = 0;
        }
    }

    @Override  // i.n.i.b.a.s.e.sd
    public final long d() {
        return this.u;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void d(long v, long v1) {
        this.e.clear();
        this.k = 0;
        this.m = -1;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        if(v == 0L) {
            if(this.h != 3) {
                this.h = 0;
                this.k = 0;
                return;
            }
            this.f.a.clear();
            this.f.b = 0;
            this.g.clear();
            return;
        }
        r4[] arr_r4 = this.r;
        if(arr_r4 != null) {
            int v2 = 0;
            while(v2 < arr_r4.length) {
                r4 r40 = arr_r4[v2];
                U7 u70 = r40.b;
                int v3 = L7.y(u70.f, v1, false);
                while(true) {
                    if(v3 >= 0) {
                        if((u70.g[v3] & 1) == 0) {
                            --v3;
                            continue;
                        }
                        else {
                            break;
                        }
                    }
                    v3 = -1;
                    break;
                }
                if(v3 == -1) {
                    v3 = u70.a(v1);
                }
                r40.d = v3;
                ++v2;
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final boolean e(i5 i50) {
        return Ja.F(i50, false, false);
    }

    // This method was un-flattened
    @Override  // i.n.i.b.a.s.e.q4
    public final int f(i5 i50, v v0) {
        boolean z;
        int v38;
        while(true) {
            int v1 = this.h;
            ArrayDeque arrayDeque0 = this.e;
            wb wb0 = this.c;
            if(v1 != 0) {
                switch(v1) {
                    case 1: {
                        long v36 = this.j - ((long)this.k);
                        long v37 = i50.getPosition();
                        wb wb5 = this.l;
                        if(wb5 != null) {
                            i50.q(wb5.a, this.k, ((int)v36));
                            if(this.i == 0x66747970) {
                                wb5.n(8);
                            alab1:
                                switch(wb5.p()) {
                                    case 0x68656963: {
                                        break;
                                    }
                                    case 0x71742020: {
                                        v38 = 1;
                                        break;
                                    }
                                    default: {
                                        wb5.o(4);
                                        while(wb5.d() > 0) {
                                            switch(wb5.p()) {
                                                case 0x68656963: {
                                                    break alab1;
                                                }
                                                case 0x71742020: {
                                                    v38 = 1;
                                                    break alab1;
                                                }
                                                default: {
                                                    v38 = 0;
                                                }
                                            }
                                        }
                                        v38 = 0;
                                    }
                                }
                                this.v = v38;
                            }
                            else if(!arrayDeque0.isEmpty()) {
                                o0 o00 = (o0)arrayDeque0.peek();
                                p0 p00 = new p0(this.i, wb5);
                                o00.d.add(p00);
                            }
                            z = false;
                        }
                        else if(v36 < 0x40000L) {
                            i50.a(((int)v36));
                            z = false;
                        }
                        else {
                            v0.a = i50.getPosition() + v36;
                            z = true;
                        }
                        this.c(v37 + v36);
                        if(z && this.h != 2) {
                            break;
                        }
                        continue;
                    }
                    case 2: {
                        long v2 = i50.getPosition();
                        if(this.m == -1) {
                            int v4 = -1;
                            int v5 = -1;
                            int v6 = 1;
                            int v7 = 1;
                            long v8 = 0x7FFFFFFFFFFFFFFFL;
                            long v9 = 0x7FFFFFFFFFFFFFFFL;
                            long v10 = 0x7FFFFFFFFFFFFFFFL;
                            for(int v3 = 0; true; ++v3) {
                                r4[] arr_r4 = this.r;
                                if(v3 >= arr_r4.length) {
                                    break;
                                }
                                r4 r40 = arr_r4[v3];
                                int v11 = r40.d;
                                U7 u70 = r40.b;
                                if(v11 != u70.b) {
                                    long v12 = u70.c[v11];
                                    long v13 = this.s[v3][v11];
                                    long v14 = v12 - v2;
                                    int v15 = v14 < 0L || v14 >= 0x40000L ? 1 : 0;
                                    if(v15 == 0 && v7 != 0 || v15 == v7 && v14 < v9) {
                                        v7 = v15;
                                        v5 = v3;
                                        v9 = v14;
                                        v10 = v13;
                                    }
                                    if(v13 < v8) {
                                        v6 = v15;
                                        v4 = v3;
                                        v8 = v13;
                                    }
                                }
                            }
                            if(v8 == 0x7FFFFFFFFFFFFFFFL || v6 == 0 || v10 < v8 + 0xA00000L) {
                                v4 = v5;
                            }
                            this.m = v4;
                            if(v4 == -1) {
                                return -1;
                            }
                        }
                        r4 r41 = this.r[this.m];
                        ie ie0 = r41.c;
                        D6 d60 = r41.a;
                        U7 u71 = r41.b;
                        int v16 = r41.d;
                        long v17 = u71.c[v16];
                        int v18 = u71.d[v16];
                        long v19 = v17 - v2 + ((long)this.n);
                        if(v19 < 0L || v19 >= 0x40000L) {
                            v0.a = v17;
                            return 1;
                        }
                        if(d60.g == 1) {
                            v19 += 8L;
                            v18 -= 8;
                        }
                        int v20 = v18;
                        i50.a(((int)v19));
                        int v21 = d60.j;
                        if(v21 == 0) {
                            if("audio/ac4".equals(d60.f.l)) {
                                if(this.o == 0) {
                                    Ja.w(v20, wb0);
                                    ie0.b(7, wb0);
                                    this.o += 7;
                                }
                                v20 += 7;
                            }
                            int v25;
                            while((v25 = this.o) < v20) {
                                int v26 = ie0.e(i50, v20 - v25, false);
                                this.n += v26;
                                this.o += v26;
                                this.p -= v26;
                            }
                        }
                        else {
                            wb wb1 = this.b;
                            byte[] arr_b = wb1.a;
                            arr_b[0] = 0;
                            arr_b[1] = 0;
                            arr_b[2] = 0;
                            while(this.o < v20) {
                                int v22 = this.p;
                                if(v22 == 0) {
                                    i50.q(arr_b, 4 - v21, v21);
                                    this.n += v21;
                                    wb1.n(0);
                                    int v23 = wb1.p();
                                    if(v23 < 0) {
                                        throw new H4("Invalid NAL length");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                                    }
                                    this.p = v23;
                                    this.a.n(0);
                                    ie0.b(4, this.a);
                                    this.o += 4;
                                    v20 += 4 - v21;
                                }
                                else {
                                    int v24 = ie0.e(i50, v22, false);
                                    this.n += v24;
                                    this.o += v24;
                                    this.p -= v24;
                                }
                            }
                        }
                        ie0.f(u71.f[v16], u71.g[v16], v20, 0, null);
                        ++r41.d;
                        this.m = -1;
                        this.n = 0;
                        this.o = 0;
                        this.p = 0;
                        return 0;
                    label_106:
                        if(v1 != 3) {
                            throw new IllegalStateException();
                        }
                        l5 l50 = this.f;
                        ArrayList arrayList0 = l50.a;
                        switch(l50.b) {
                            case 0: {
                                long v27 = i50.a();
                                v0.a = v27 == -1L || v27 < 8L ? 0L : v27 - 8L;
                                l50.b = 1;
                                break;
                            }
                            case 1: {
                                wb wb2 = new wb(8);
                                i50.q(wb2.a, 0, 8);
                                l50.c = wb2.r() + 8;
                                if(wb2.p() == 1397048916) {
                                    v0.a = i50.getPosition() - ((long)(l50.c - 12));
                                    l50.b = 2;
                                }
                                else {
                                    v0.a = 0L;
                                }
                                break;
                            }
                            case 2: {
                                long v28 = i50.a();
                                int v29 = l50.c - 20;
                                wb wb3 = new wb(v29);
                                i50.q(wb3.a, 0, v29);
                                for(int v30 = 0; v30 < v29 / 12; ++v30) {
                                    wb3.o(2);
                                    switch(wb3.s()) {
                                        case 0x890: 
                                        case 0xB00: 
                                        case 0xB01: 
                                        case 0xB03: 
                                        case 0xB04: {
                                            arrayList0.add(new k5(v28 - ((long)l50.c) - ((long)wb3.r()), wb3.r()));
                                            break;
                                        }
                                        default: {
                                            wb3.o(8);
                                        }
                                    }
                                }
                                if(arrayList0.isEmpty()) {
                                    v0.a = 0L;
                                }
                                else {
                                    l50.b = 3;
                                    v0.a = ((k5)arrayList0.get(0)).a;
                                }
                                break;
                            }
                            case 3: {
                                long v31 = i50.getPosition();
                                int v32 = (int)(i50.a() - i50.getPosition() - ((long)l50.c));
                                wb wb4 = new wb(v32);
                                i50.q(wb4.a, 0, v32);
                                for(int v33 = 0; v33 < arrayList0.size(); ++v33) {
                                    k5 k50 = (k5)arrayList0.get(v33);
                                    wb4.n(((int)(k50.a - v31)));
                                    wb4.o(4);
                                    int v34 = wb4.r();
                                    Charset charset0 = b9.c;
                                    switch(wb4.g(v34, charset0)) {
                                        case "SlowMotion_Data": {
                                            ArrayList arrayList1 = new ArrayList();
                                            String s = wb4.g(k50.b - (v34 + 8), charset0);
                                            List list0 = l5.e.d(s);
                                            for(int v35 = 0; v35 < list0.size(); ++v35) {
                                                CharSequence charSequence0 = (CharSequence)list0.get(v35);
                                                List list1 = l5.d.d(charSequence0);
                                                if(list1.size() != 3) {
                                                    throw new H4();  // 初始化器: Ljava/io/IOException;-><init>()V
                                                }
                                                try {
                                                    arrayList1.add(new i.n.i.b.a.s.e.da.b(Long.parseLong(((String)list1.get(0))), Long.parseLong(((String)list1.get(1))), 1 << Integer.parseInt(((String)list1.get(2))) - 1));
                                                }
                                                catch(NumberFormatException numberFormatException0) {
                                                    throw new H4(numberFormatException0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
                                                }
                                            }
                                            da da0 = new da(arrayList1);
                                            this.g.add(da0);
                                            break;
                                        }
                                        case "Super_SlowMotion_BGM": 
                                        case "Super_SlowMotion_Data": 
                                        case "Super_SlowMotion_Deflickering_On": 
                                        case "Super_SlowMotion_Edit_Data": {
                                            break;
                                        }
                                        default: {
                                            throw new H4("Invalid SEF name");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                                        }
                                    }
                                }
                                v0.a = 0L;
                                break;
                            }
                            default: {
                                throw new IllegalStateException();
                            }
                        }
                        if(v0.a == 0L) {
                            this.h = 0;
                            this.k = 0;
                            return 1;
                        }
                        break;
                    }
                    default: {
                        goto label_106;
                    }
                }
                return 1;
            }
            wb wb6 = this.d;
            if(this.k == 0) {
                if(!i50.f(wb6.a, 0, 8, true)) {
                    return -1;
                }
                this.k = 8;
                wb6.n(0);
                this.j = wb6.A();
                this.i = wb6.p();
            }
            long v39 = this.j;
            if(v39 == 1L) {
                i50.q(wb6.a, 8, 8);
                this.k += 8;
                this.j = wb6.a();
            }
            else if(v39 == 0L) {
                long v40 = i50.a();
                if(v40 == -1L) {
                    o0 o01 = (o0)arrayDeque0.peek();
                    if(o01 != null) {
                        v40 = o01.c;
                    }
                }
                if(v40 != -1L) {
                    this.j = v40 - i50.getPosition() + ((long)this.k);
                }
            }
            int v41 = this.k;
            if(this.j < ((long)v41)) {
                break;
            }
            switch(this.i) {
                case 1701082227: 
                case 0x6D646961: 
                case 0x6D657461: 
                case 1835626086: 
                case 0x6D6F6F76: 
                case 1937007212: 
                case 1953653099: {
                    break;
                }
                case 0x636F3634: 
                case 0x63747473: 
                case 1701606260: 
                case 0x66747970: 
                case 0x68646C72: 
                case 0x696C7374: 
                case 1801812339: 
                case 0x6D646864: 
                case 0x6D766864: 
                case 1937007471: 
                case 1937011555: 
                case 1937011556: 
                case 1937011571: 
                case 1937011578: 
                case 1937011827: 
                case 1937013298: 
                case 0x746B6864: 
                case 0x75647461: {
                    M7.J(v41 == 8);
                    M7.J(this.j <= 0x7FFFFFFFL);
                    wb wb7 = new wb(((int)this.j));
                    System.arraycopy(wb6.a, 0, wb7.a, 0, 8);
                    this.l = wb7;
                    this.h = 1;
                    continue;
                }
                default: {
                    long v42 = i50.getPosition();
                    long v43 = (long)this.k;
                    long v44 = v42 - v43;
                    if(this.i == 0x6D707664) {
                        new ca(0L, v44, 0x8000000000000001L, v44 + v43, this.j - v43);
                    }
                    this.l = null;
                    this.h = 1;
                    continue;
                }
            }
            long v45 = i50.getPosition() + this.j - ((long)this.k);
            if(this.j != ((long)this.k) && this.i == 0x6D657461) {
                wb0.l(8);
                i50.s(wb0.a, 0, 8);
                int v46 = wb0.b;
                wb0.o(4);
                if(wb0.p() != 0x68646C72) {
                    v46 += 4;
                }
                wb0.n(v46);
                i50.a(wb0.b);
                i50.b();
            }
            arrayDeque0.push(new o0(this.i, v45));
            if(this.j == ((long)this.k)) {
                this.c(v45);
            }
            else {
                this.h = 0;
                this.k = 0;
            }
        }
        throw new H4("Atom size less than header length (unsupported).");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void g(U5 u50) {
        this.q = u50;
    }
}

