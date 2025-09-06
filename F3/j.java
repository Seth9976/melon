package f3;

import B3.N;
import I6.Q;
import I6.V;
import I6.w;
import Nf.p;
import androidx.recyclerview.widget.p0;
import d5.i;
import d5.v;
import e3.b;
import ea.a;
import java.lang.reflect.Array;
import java.util.Arrays;

public abstract class j {
    public static final byte[] a;
    public static final float[] b;
    public static final Object c;
    public static int[] d;

    static {
        j.a = new byte[]{0, 0, 0, 1};
        j.b = new float[]{1.0f, 1.0f, 1.090909f, 0.909091f, 1.454545f, 1.212121f, 2.181818f, 1.818182f, 2.909091f, 2.424242f, 1.636364f, 1.363636f, 1.939394f, 1.616162f, 1.333333f, 1.5f, 2.0f};
        j.c = new Object();
        j.d = new int[10];
    }

    public static void a(boolean[] arr_z) {
        arr_z[0] = false;
        arr_z[1] = false;
        arr_z[2] = false;
    }

    public static int b(byte[] arr_b, int v, int v1, boolean[] arr_z) {
        boolean z2;
        boolean z1;
        int v2 = v1 - v;
        boolean z = false;
        b.j(v2 >= 0);
        if(v2 == 0) {
            return v1;
        }
        if(arr_z[0]) {
            j.a(arr_z);
            return v - 3;
        }
        if(v2 > 1 && arr_z[1] && arr_b[v] == 1) {
            j.a(arr_z);
            return v - 2;
        }
        if(v2 > 2 && arr_z[2] && arr_b[v] == 0 && arr_b[v + 1] == 1) {
            j.a(arr_z);
            return v - 1;
        }
        for(int v3 = v + 2; v3 < v1 - 1; v3 += 3) {
            int v4 = arr_b[v3];
            if((v4 & 0xFE) == 0) {
                if(arr_b[v3 - 2] == 0 && arr_b[v3 - 1] == 0 && v4 == 1) {
                    j.a(arr_z);
                    return v3 - 2;
                }
                v3 -= 2;
            }
        }
        if(v2 <= 2) {
            if(v2 != 2) {
                z1 = arr_z[1] && arr_b[v1 - 1] == 1;
            }
            else if(arr_z[2] && arr_b[v1 - 2] == 0 && arr_b[v1 - 1] == 1) {
                z1 = true;
            }
            else {
                z1 = false;
            }
        }
        else if(arr_b[v1 - 3] == 0 && arr_b[v1 - 2] == 0 && arr_b[v1 - 1] == 1) {
            z1 = true;
        }
        else {
            z1 = false;
        }
        arr_z[0] = z1;
        if(v2 <= 1) {
            z2 = arr_z[2] && arr_b[v1 - 1] == 0;
        }
        else if(arr_b[v1 - 2] == 0 && arr_b[v1 - 1] == 0) {
            z2 = true;
        }
        else {
            z2 = false;
        }
        arr_z[1] = z2;
        if(arr_b[v1 - 1] == 0) {
            z = true;
        }
        arr_z[2] = z;
        return v1;
    }

    public static boolean c(byte b) {
        if((b & 0x60) >> 5 != 0) {
            return true;
        }
        switch(b & 0x1F) {
            case 1: {
                return false;
            }
            case 9: {
                return false;
            }
            case 14: {
                return false;
            }
            default: {
                return true;
            }
        }
    }

    public static p0 d(N n0) {
        n0.N();
        int v = n0.D(6);
        int v1 = n0.D(6);
        n0.D(3);
        return new p0(v, v1);
    }

    public static d e(N n0, boolean z, int v, d d0) {
        int v9;
        int v8;
        boolean z2;
        int[] arr_v1;
        int v7;
        int v4;
        int v3;
        boolean z1;
        int[] arr_v = new int[6];
        if(z) {
            int v2 = n0.D(2);
            z1 = n0.C();
            v3 = n0.D(5);
            v4 = 0;
            for(int v5 = 0; v5 < 0x20; ++v5) {
                if(n0.C()) {
                    v4 |= 1 << v5;
                }
            }
            for(int v6 = 0; v6 < 6; ++v6) {
                arr_v[v6] = n0.D(8);
            }
            v7 = v2;
            arr_v1 = arr_v;
            z2 = z1;
            v8 = v3;
            v9 = v4;
        }
        else if(d0 == null) {
            arr_v1 = arr_v;
            v7 = 0;
            z2 = false;
            v8 = 0;
            v9 = 0;
        }
        else {
            z1 = d0.b;
            v3 = d0.c;
            v4 = d0.d;
            arr_v = d0.e;
            v7 = d0.a;
            arr_v1 = arr_v;
            z2 = z1;
            v8 = v3;
            v9 = v4;
        }
        int v10 = n0.D(8);
        int v11 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            if(n0.C()) {
                v11 += 88;
            }
            if(n0.C()) {
                v11 += 8;
            }
        }
        n0.O(v11);
        if(v > 0) {
            n0.O((8 - v) * 2);
        }
        return new d(v7, z2, v8, v9, arr_v1, v10);
    }

    public static p f(byte[] arr_b, int v, int v1) {
        int v2;
        for(v2 = v1 - 1; true; --v2) {
            int v3 = arr_b[v2];
            if(v3 != 0 || v2 <= v + 2) {
                break;
            }
        }
        if(v3 != 0 && v2 > v + 2) {
            N n0 = new N(v + 2, v2 + 1, 3, arr_b);
        alab1:
            while(n0.s(16)) {
                int v4 = n0.D(8);
                int v5 = 0;
                while(v4 == 0xFF) {
                    v5 += 0xFF;
                    v4 = n0.D(8);
                }
                int v6 = n0.D(8);
                int v7 = 0;
                while(v6 == 0xFF) {
                    v7 += 0xFF;
                    v6 = n0.D(8);
                }
                if(v7 + v6 == 0 || !n0.s(v7 + v6)) {
                    break;
                }
                if(v5 + v4 == 0xB0) {
                    int v8 = n0.H();
                    boolean z = n0.C();
                    int v9 = z ? n0.H() : 0;
                    int v10 = n0.H();
                    int v11 = -1;
                    for(int v12 = 0; v12 <= v10; ++v12) {
                        v11 = n0.H();
                        n0.H();
                        int v13 = n0.D(6);
                        if(v13 == 0x3F) {
                            break alab1;
                        }
                        n0.D((v13 == 0 ? Math.max(0, v8 - 30) : Math.max(0, v13 + v8 - 0x1F)));
                        if(z) {
                            int v14 = n0.D(6);
                            if(v14 == 0x3F) {
                                break alab1;
                            }
                            n0.D((v14 == 0 ? Math.max(0, v9 - 30) : Math.max(0, v14 + v9 - 0x1F)));
                        }
                        if(n0.C()) {
                            n0.O(10);
                        }
                    }
                    return new p(v11);
                }
                if(false) {
                    break;
                }
            }
        }
        return null;
    }

    public static f g(byte[] arr_b, int v, int v1, i i0) {
        int v65;
        int v64;
        int v61;
        int v41;
        int v36;
        int v25;
        int v14;
        int v13;
        int v12;
        int v11;
        int v18;
        int v17;
        int v16;
        int v15;
        int v5;
        p0 p00 = j.d(new N(v, v1, 3, arr_b));
        N n0 = new N(v + 2, v1, 3, arr_b);
        n0.O(4);
        int v2 = n0.D(3);
        int v3 = p00.b;
        boolean z = v3 != 0 && v2 == 7;
        if(i0 == null) {
            v5 = 0;
        }
        else {
            V v4 = (V)i0.a;
            v5 = v4.isEmpty() ? 0 : ((c)v4.get(Math.min(v3, v4.size() - 1))).a;
        }
        d d0 = null;
        if(!z) {
            n0.N();
            d0 = j.e(n0, true, v2, null);
        }
        else if(i0 != null) {
            v v6 = (v)i0.b;
            int[] arr_v = (int[])v6.b;
            V v7 = (V)v6.a;
            int v8 = arr_v[v5];
            if(v7.size() > v8) {
                d0 = (d)v7.get(v8);
            }
        }
        n0.H();
        if(z) {
            int v9 = n0.C() ? n0.D(8) : -1;
            if(i0 != null) {
                a a0 = (a)i0.c;
                if(a0 != null) {
                    V v10 = (V)a0.a;
                    if(v9 == -1) {
                        v9 = ((int[])a0.b)[v5];
                    }
                    if(v9 != -1 && v10.size() > v9) {
                        e e0 = (e)v10.get(v9);
                        v11 = e0.d;
                        v12 = e0.e;
                        v13 = e0.b;
                        v14 = e0.c;
                        goto label_59;
                    }
                }
            }
            v15 = 0;
            v16 = 0;
            v17 = 0;
            v18 = 0;
        }
        else {
            int v19 = n0.H();
            if(v19 == 3) {
                n0.N();
            }
            int v20 = n0.H();
            int v21 = n0.H();
            if(n0.C()) {
                v20 -= (n0.H() + n0.H()) * (v19 == 1 || v19 == 2 ? 2 : 1);
                v21 -= (n0.H() + n0.H()) * (v19 == 1 ? 2 : 1);
            }
            v12 = v21;
            v11 = v20;
            v13 = n0.H();
            v14 = n0.H();
        label_59:
            v16 = v13;
            v15 = v12;
            v18 = v11;
            v17 = v14;
        }
        int v22 = n0.H();
        if(z) {
            v25 = -1;
        }
        else {
            int v23 = n0.C() ? 0 : v2;
            int v24 = -1;
            while(v23 <= v2) {
                n0.H();
                v24 = Math.max(n0.H(), v24);
                n0.H();
                ++v23;
            }
            v25 = v24;
        }
        n0.H();
        n0.H();
        n0.H();
        n0.H();
        n0.H();
        n0.H();
        if(n0.C()) {
            if((z ? n0.C() : false)) {
                n0.O(6);
            }
            else if(n0.C()) {
                for(int v26 = 0; v26 < 4; ++v26) {
                    for(int v27 = 0; v27 < 6; v27 += (v26 == 3 ? 3 : 1)) {
                        if(n0.C()) {
                            int v28 = Math.min(0x40, 1 << (v26 << 1) + 4);
                            if(v26 > 1) {
                                n0.I();
                            }
                            for(int v29 = 0; v29 < v28; ++v29) {
                                n0.I();
                            }
                        }
                        else {
                            n0.H();
                        }
                    }
                }
            }
        }
        n0.O(2);
        if(n0.C()) {
            n0.O(8);
            n0.H();
            n0.H();
            n0.N();
        }
        int v30 = n0.H();
        int[] arr_v1 = new int[0];
        int[] arr_v2 = new int[0];
        int v31 = 0;
        int v32 = -1;
        int v33 = -1;
        while(v31 < v30) {
            if(v31 == 0 || !n0.C()) {
                v36 = v30;
                v41 = v5;
                int v51 = n0.H();
                int v52 = n0.H();
                int[] arr_v7 = new int[v51];
                for(int v53 = 0; v53 < v51; ++v53) {
                    arr_v7[v53] = (v53 <= 0 ? 0 : arr_v7[v53 - 1]) - (n0.H() + 1);
                    n0.N();
                }
                int[] arr_v8 = new int[v52];
                for(int v54 = 0; v54 < v52; ++v54) {
                    int v55 = v54 <= 0 ? 0 : arr_v8[v54 - 1];
                    arr_v8[v54] = n0.H() + 1 + v55;
                    n0.N();
                }
                v33 = v51;
                arr_v1 = arr_v7;
                arr_v2 = arr_v8;
                v32 = v52;
            }
            else {
                int v34 = v33 + v32;
                int v35 = (1 - n0.C() * 2) * (n0.H() + 1);
                v36 = v30;
                boolean[] arr_z = new boolean[v34 + 1];
                for(int v37 = 0; v37 <= v34; ++v37) {
                    arr_z[v37] = n0.C() ? true : n0.C();
                }
                int[] arr_v3 = new int[v34 + 1];
                int[] arr_v4 = new int[v34 + 1];
                int v38 = v32 - 1;
                int v39 = 0;
                while(v38 >= 0) {
                    int v40 = arr_v2[v38] + v35;
                    if(v40 < 0 && arr_z[v33 + v38]) {
                        arr_v3[v39] = v40;
                        ++v39;
                    }
                    --v38;
                }
                if(v35 < 0 && arr_z[v34]) {
                    arr_v3[v39] = v35;
                    ++v39;
                }
                v41 = v5;
                int v42 = v39;
                int[] arr_v5 = arr_v1;
                for(int v43 = 0; v43 < v33; ++v43) {
                    int v44 = arr_v5[v43] + v35;
                    if(v44 < 0 && arr_z[v43]) {
                        arr_v3[v42] = v44;
                        ++v42;
                    }
                }
                int[] arr_v6 = Arrays.copyOf(arr_v3, v42);
                int v45 = v33 - 1;
                int v46 = 0;
                while(v45 >= 0) {
                    int v47 = arr_v5[v45] + v35;
                    if(v47 > 0 && arr_z[v45]) {
                        arr_v4[v46] = v47;
                        ++v46;
                    }
                    --v45;
                }
                if(v35 > 0 && arr_z[v34]) {
                    arr_v4[v46] = v35;
                    ++v46;
                }
                int v48 = v46;
                for(int v49 = 0; v49 < v32; ++v49) {
                    int v50 = arr_v2[v49] + v35;
                    if(v50 > 0 && arr_z[v33 + v49]) {
                        arr_v4[v48] = v50;
                        ++v48;
                    }
                }
                arr_v2 = Arrays.copyOf(arr_v4, v48);
                v33 = v42;
                v32 = v48;
                arr_v1 = arr_v6;
            }
            ++v31;
            v30 = v36;
            v5 = v41;
        }
        if(n0.C()) {
            int v56 = n0.H();
            for(int v57 = 0; v57 < v56; ++v57) {
                n0.O(v22 + 5);
            }
        }
        n0.O(2);
        float f = 1.0f;
        if(n0.C()) {
            if(n0.C()) {
                int v58 = n0.D(8);
                if(v58 == 0xFF) {
                    int v59 = n0.D(16);
                    int v60 = n0.D(16);
                    if(v59 != 0 && v60 != 0) {
                        f = ((float)v59) / ((float)v60);
                    }
                }
                else if(v58 < 17) {
                    f = j.b[v58];
                }
                else {
                    com.iloen.melon.utils.a.r(v58, "Unexpected aspect_ratio_idc value: ", "NalUnitUtil");
                }
            }
            if(n0.C()) {
                n0.N();
            }
            if(n0.C()) {
                n0.O(3);
                v61 = n0.C() ? true : 2;
                if(n0.C()) {
                    int v62 = n0.D(8);
                    int v63 = n0.D(8);
                    n0.O(8);
                    v64 = b3.i.f(v62);
                    v65 = b3.i.g(v63);
                }
                else {
                    v64 = -1;
                    v65 = -1;
                }
            }
            else if(i0 == null) {
            label_262:
                v64 = -1;
                v65 = -1;
                v61 = -1;
            }
            else {
                ea.b b0 = (ea.b)i0.d;
                if(b0 != null) {
                    V v66 = (V)b0.a;
                    int v67 = ((int[])b0.b)[v5];
                    if(v66.size() > v67) {
                        g g0 = (g)v66.get(v67);
                        v65 = g0.c;
                        v64 = g0.a;
                        v61 = g0.b;
                        goto label_265;
                    }
                }
                goto label_262;
            }
        label_265:
            if(n0.C()) {
                n0.H();
                n0.H();
            }
            n0.N();
            if(n0.C()) {
                v15 *= 2;
            }
            return new f(d0, v16, v17, v18, v15, f, v25, v64, v61, v65);
        }
        return new f(d0, v16, v17, v18, v15, 1.0f, v25, -1, -1, -1);
    }

    public static i h(byte[] arr_b, int v, int v1) {
        int v85;
        int v84;
        int v83;
        boolean[][] arr2_z5;
        I6.p0 p02;
        int[] arr_v17;
        int[] arr_v16;
        boolean[][] arr2_z3;
        int v65;
        int[] arr_v13;
        int v29;
        int[] arr_v4;
        int v18;
        int v17;
        boolean z4;
        int v15;
        int v14;
        boolean z2;
        N n0 = new N(v, v1, 3, arr_b);
        j.d(n0);
        n0.O(4);
        boolean z = n0.C();
        boolean z1 = n0.C();
        int v2 = n0.D(6);
        int v3 = v2 + 1;
        int v4 = n0.D(3);
        n0.O(17);
        d d0 = j.e(n0, true, v4, null);
        for(int v5 = n0.C() ? 0 : v4; v5 <= v4; ++v5) {
            n0.H();
            n0.H();
            n0.H();
        }
        int v6 = n0.D(6);
        int v7 = n0.H();
        v v8 = new v(V.t(d0), new int[1]);
        if(v3 < 2 || v7 + 1 < 2 || (!z || !z1) || v6 + 1 < v3) {
            return new i(null, v8, null, null);
        }
        Class class0 = Integer.TYPE;
        int[][] arr2_v = (int[][])Array.newInstance(class0, new int[]{v7 + 1, v6 + 1});
        int[] arr_v = new int[v7 + 1];
        int[] arr_v1 = new int[v7 + 1];
        arr2_v[0][0] = 0;
        arr_v[0] = 1;
        arr_v1[0] = 0;
        for(int v9 = 1; v9 < v7 + 1; ++v9) {
            int v11 = 0;
            for(int v10 = 0; v10 <= v6; ++v10) {
                if(n0.C()) {
                    arr2_v[v9][v11] = v10;
                    arr_v1[v9] = v10;
                    ++v11;
                }
                arr_v[v9] = v11;
            }
        }
        if(n0.C()) {
            n0.O(0x40);
            if(n0.C()) {
                n0.H();
            }
            int v12 = n0.H();
            int v13 = 0;
            while(v13 < v12) {
                n0.H();
                if(v13 == 0 || n0.C()) {
                    v14 = n0.C();
                    v15 = n0.C();
                    if(v14 || v15) {
                        z2 = n0.C();
                        if(z2) {
                            n0.O(19);
                        }
                        n0.O(8);
                        if(z2) {
                            n0.O(4);
                        }
                        n0.O(15);
                        goto label_67;
                    }
                }
                else {
                    v14 = 0;
                    v15 = 0;
                }
                z2 = false;
            label_67:
                int v16 = 0;
                while(v16 <= v4) {
                    boolean z3 = n0.C();
                    if(!z3) {
                        z3 = n0.C();
                    }
                    if(z3) {
                        n0.H();
                        z4 = false;
                    }
                    else {
                        z4 = n0.C();
                    }
                    if(z4) {
                        v17 = v13;
                        v18 = 0;
                    }
                    else {
                        v17 = v13;
                        v18 = n0.H();
                    }
                    int v19 = v14 + v15;
                    for(int v20 = 0; v20 < v19; ++v20) {
                        for(int v21 = 0; v21 <= v18; ++v21) {
                            n0.H();
                            n0.H();
                            if(z2) {
                                n0.H();
                                n0.H();
                            }
                            n0.N();
                        }
                    }
                    ++v16;
                    v13 = v17;
                }
                ++v13;
            }
        }
        if(!n0.C()) {
            return new i(null, v8, null, null);
        }
        int v22 = n0.e;
        if(v22 > 0) {
            n0.O(8 - v22);
        }
        d d1 = j.e(n0, false, v4, d0);
        boolean z5 = n0.C();
        boolean[] arr_z = new boolean[16];
        int v23 = 0;
        for(int v24 = 0; v24 < 16; ++v24) {
            boolean z6 = n0.C();
            arr_z[v24] = z6;
            if(z6) {
                ++v23;
            }
        }
        if(v23 == 0 || !arr_z[1]) {
            return new i(null, v8, null, null);
        }
        int[] arr_v2 = new int[v23];
        for(int v25 = 0; v25 < v23 - z5; ++v25) {
            arr_v2[v25] = n0.D(3);
        }
        int[] arr_v3 = new int[v23 + 1];
        if(z5) {
            for(int v26 = 1; v26 < v23; ++v26) {
                for(int v27 = 0; v27 < v26; ++v27) {
                    arr_v3[v26] = arr_v2[v27] + 1 + arr_v3[v26];
                }
            }
            arr_v4 = arr_v3;
            arr_v4[v23] = 6;
        }
        else {
            arr_v4 = arr_v3;
        }
        int[][] arr2_v1 = (int[][])Array.newInstance(class0, new int[]{v3, v23});
        int[] arr_v5 = new int[v3];
        arr_v5[0] = 0;
        boolean z7 = n0.C();
        for(int v28 = 1; v28 < v3; v28 = v29 + 1) {
            if(z7) {
                v29 = v28;
                arr_v5[v29] = n0.D(6);
            }
            else {
                v29 = v28;
                arr_v5[v29] = v29;
            }
            if(z5) {
                for(int v31 = 0; v31 < v23; ++v31) {
                    arr2_v1[v29][v31] = (arr_v5[v29] & (1 << arr_v4[v31 + 1]) - 1) >> arr_v4[v31];
                }
            }
            else {
                for(int v30 = 0; v30 < v23; ++v30) {
                    int[] arr_v6 = arr2_v1[v29];
                    arr_v6[v30] = n0.D(arr_v2[v30] + 1);
                }
            }
        }
        int[] arr_v7 = new int[v6 + 1];
        int v32 = 1;
        int v33 = 0;
        while(v33 < v3) {
            arr_v7[arr_v5[v33]] = -1;
            int v34 = 0;
            for(int v35 = 0; v35 < 16; ++v35) {
                if(arr_z[v35]) {
                    if(v35 == 1) {
                        arr_v7[arr_v5[v33]] = arr2_v1[v33][v34];
                    }
                    ++v34;
                }
            }
            if(v33 > 0) {
                int v36 = 0;
                while(true) {
                    boolean z8 = true;
                    if(v36 < v33) {
                        if(arr_v7[arr_v5[v33]] == arr_v7[arr_v5[v36]]) {
                            z8 = false;
                        }
                        else {
                            ++v36;
                            continue;
                        }
                    }
                    break;
                }
                if(z8) {
                    ++v32;
                }
            }
            ++v33;
        }
        int v37 = n0.D(4);
        if(v32 >= 2 && v37 != 0) {
            int[] arr_v8 = new int[v32];
            for(int v38 = 0; v38 < v32; ++v38) {
                arr_v8[v38] = n0.D(v37);
            }
            int[] arr_v9 = new int[v6 + 1];
            for(int v39 = 0; v39 < v3; ++v39) {
                arr_v9[Math.min(arr_v5[v39], v6)] = v39;
            }
            Q q0 = V.o();
            for(int v40 = 0; v40 <= v6; ++v40) {
                int v41 = Math.min(arr_v7[v40], v32 - 1);
                q0.a(new c(arr_v9[v40], (v41 < 0 ? -1 : arr_v8[v41])));
            }
            I6.p0 p00 = q0.g();
            if(((c)p00.get(0)).b == -1) {
                return new i(null, v8, null, null);
            }
            int v42;
            for(v42 = 1; true; ++v42) {
                if(v42 > v6) {
                    v42 = -1;
                    break;
                }
                if(((c)p00.get(v42)).b != -1) {
                    break;
                }
            }
            if(v42 == -1) {
                return new i(null, v8, null, null);
            }
            Class class1 = Boolean.TYPE;
            boolean[][] arr2_z = (boolean[][])Array.newInstance(class1, new int[]{v3, v3});
            boolean[][] arr2_z1 = (boolean[][])Array.newInstance(class1, new int[]{v3, v3});
            for(int v43 = 1; v43 < v3; ++v43) {
                for(int v44 = 0; v44 < v43; ++v44) {
                    boolean[] arr_z1 = arr2_z[v43];
                    boolean[] arr_z2 = arr2_z1[v43];
                    boolean z9 = n0.C();
                    arr_z2[v44] = z9;
                    arr_z1[v44] = z9;
                }
            }
            for(int v45 = 1; v45 < v3; ++v45) {
                for(int v46 = 0; v46 < v2; ++v46) {
                    for(int v47 = 0; v47 < v45; ++v47) {
                        boolean[] arr_z3 = arr2_z1[v45];
                        if(arr_z3[v47] && arr2_z1[v47][v46]) {
                            arr_z3[v46] = true;
                            break;
                        }
                    }
                }
            }
            int[] arr_v10 = new int[v6 + 1];
            for(int v48 = 0; v48 < v3; ++v48) {
                int v50 = 0;
                for(int v49 = 0; v49 < v48; ++v49) {
                    v50 += arr2_z[v48][v49];
                }
                arr_v10[arr_v5[v48]] = v50;
            }
            int v52 = 0;
            for(int v51 = 0; v51 < v3; ++v51) {
                if(arr_v10[arr_v5[v51]] == 0) {
                    ++v52;
                }
            }
            if(v52 > 1) {
                return new i(null, v8, null, null);
            }
            int[] arr_v11 = new int[v3];
            int[] arr_v12 = new int[v7 + 1];
            if(n0.C()) {
                arr_v13 = arr_v10;
                for(int v53 = 0; v53 < v3; ++v53) {
                    arr_v11[v53] = n0.D(3);
                }
            }
            else {
                arr_v13 = arr_v10;
                Arrays.fill(arr_v11, 0, v3, v4);
            }
            for(int v54 = 0; v54 < v7 + 1; v54 = v55 + 1) {
                int v55 = v54;
                int v57 = 0;
                for(int v56 = 0; v56 < arr_v[v55]; ++v56) {
                    v57 = Math.max(v57, arr_v11[((c)p00.get(arr2_v[v55][v56])).a]);
                }
                arr_v12[v55] = v57 + 1;
            }
            if(n0.C()) {
                for(int v58 = 0; v58 < v2; ++v58) {
                    for(int v59 = v58 + 1; v59 < v3; ++v59) {
                        if(arr2_z[v59][v58]) {
                            n0.O(3);
                        }
                    }
                }
            }
            n0.N();
            int v60 = n0.H();
            Q q1 = V.o();
            q1.a(d0);
            if(v60 + 1 > 1) {
                q1.a(d1);
                for(int v61 = 2; v61 < v60 + 1; ++v61) {
                    d1 = j.e(n0, n0.C(), v4, d1);
                    q1.a(d1);
                }
            }
            I6.p0 p01 = q1.g();
            int v62 = n0.H() + (v7 + 1);
            if(v62 > v7 + 1) {
                return new i(null, v8, null, null);
            }
            int v63 = n0.D(2);
            boolean[][] arr2_z2 = (boolean[][])Array.newInstance(class1, new int[]{v62, v6 + 1});
            int[] arr_v14 = new int[v62];
            int[] arr_v15 = new int[v62];
            int v64 = 0;
            while(v64 < v7 + 1) {
                arr_v14[v64] = 0;
                arr_v15[v64] = arr_v1[v64];
                if(v63 == 0) {
                    v65 = v64;
                    arr2_z3 = arr2_z2;
                    arr_v16 = arr_v14;
                    arr_v17 = arr_v12;
                    Arrays.fill(arr2_z2[v65], 0, arr_v[v65], true);
                    arr_v16[v65] = arr_v[v65];
                }
                else {
                    v65 = v64;
                    arr2_z3 = arr2_z2;
                    arr_v16 = arr_v14;
                    arr_v17 = arr_v12;
                    if(v63 == 1) {
                        int v66 = arr_v1[v65];
                        for(int v67 = 0; v67 < arr_v[v65]; ++v67) {
                            arr2_z3[v65][v67] = arr2_v[v65][v67] == v66;
                        }
                        arr_v16[v65] = 1;
                    }
                    else {
                        arr2_z3[0][0] = true;
                        arr_v16[0] = 1;
                    }
                }
                v64 = v65 + 1;
                arr2_z2 = arr2_z3;
                arr_v14 = arr_v16;
                arr_v12 = arr_v17;
            }
            int[] arr_v18 = new int[v6 + 1];
            boolean[][] arr2_z4 = (boolean[][])Array.newInstance(class1, new int[]{v62, v6 + 1});
            int v69 = 0;
            for(int v68 = 1; v68 < v62; ++v68) {
                if(v63 == 2) {
                    for(int v70 = 0; v70 < arr_v[v68]; ++v70) {
                        boolean[] arr_z4 = arr2_z2[v68];
                        arr_z4[v70] = n0.C();
                        int v71 = arr_v14[v68];
                        int v72 = arr2_z2[v68][v70];
                        arr_v14[v68] = v71 + v72;
                        if(v72 != 0) {
                            arr_v15[v68] = arr2_v[v68][v70];
                        }
                    }
                }
                if(v69 == 0 && arr2_v[v68][0] == 0 && arr2_z2[v68][0]) {
                    for(int v73 = 1; v73 < arr_v[v68]; ++v73) {
                        if(arr2_v[v68][v73] == v42 && arr2_z2[v68][v42]) {
                            v69 = v68;
                        }
                    }
                }
                int v74 = 0;
                while(v74 < arr_v[v68]) {
                    if(v60 + 1 > 1) {
                        arr2_z4[v68][v74] = arr2_z2[v68][v74];
                        p02 = p01;
                        arr2_z5 = arr2_z4;
                        int v75 = K6.b.c(v60 + 1);
                        if(!arr2_z5[v68][v74]) {
                            int v76 = ((c)p00.get(arr2_v[v68][v74])).a;
                            for(int v77 = 0; v77 < v74; ++v77) {
                                if(arr2_z1[v76][((c)p00.get(arr2_v[v68][v77])).a]) {
                                    arr2_z5[v68][v74] = true;
                                    break;
                                }
                            }
                        }
                        if(arr2_z5[v68][v74]) {
                            if(v69 <= 0 || v68 != v69) {
                                n0.O(v75);
                            }
                            else {
                                arr_v18[v74] = n0.D(v75);
                            }
                        }
                    }
                    else {
                        p02 = p01;
                        arr2_z5 = arr2_z4;
                    }
                    ++v74;
                    p01 = p02;
                    arr2_z4 = arr2_z5;
                }
                if(arr_v14[v68] == 1 && arr_v13[arr_v15[v68]] > 0) {
                    n0.N();
                }
            }
            if(v69 == 0) {
                return new i(null, v8, null, null);
            }
            int v78 = n0.H();
            w.c(v78 + 1, "expectedSize");
            w.c(v78 + 1, "initialCapacity");
            int[] arr_v19 = new int[v3];
            Object[] arr_object = new Object[v78 + 1];
            int v80 = 0;
            for(int v79 = 0; v79 < v78 + 1; ++v79) {
                int v81 = n0.D(16);
                int v82 = n0.D(16);
                if(n0.C()) {
                    v83 = n0.D(2);
                    if(v83 == 3) {
                        n0.N();
                    }
                    v84 = n0.D(4);
                    v85 = n0.D(4);
                }
                else {
                    v83 = 0;
                    v84 = 0;
                    v85 = 0;
                }
                if(n0.C()) {
                    v81 -= (n0.H() + n0.H()) * (v83 == 1 || v83 == 2 ? 2 : 1);
                    v82 -= (n0.H() + n0.H()) * (v83 == 1 ? 2 : 1);
                }
                e e0 = new e(v83, v84, v85, v81, v82);
                int v86 = I6.N.f(arr_object.length, v80 + 1);
                if(v86 > arr_object.length) {
                    arr_object = Arrays.copyOf(arr_object, v86);
                }
                arr_object[v80] = e0;
                ++v80;
            }
            if(v78 + 1 <= 1 || !n0.C()) {
                for(int v89 = 1; v89 < v3; ++v89) {
                    arr_v19[v89] = Math.min(v89, v78);
                }
            }
            else {
                int v87 = K6.b.c(v78 + 1);
                for(int v88 = 1; v88 < v3; ++v88) {
                    arr_v19[v88] = n0.D(v87);
                }
            }
            a a0 = new a(V.l(v80, arr_object), arr_v19);
            n0.O(2);
            for(int v90 = 1; v90 < v3; ++v90) {
                if(arr_v13[arr_v5[v90]] == 0) {
                    n0.N();
                }
            }
            for(int v91 = 1; v91 < v62; ++v91) {
                boolean z10 = n0.C();
                for(int v92 = 0; v92 < arr_v12[v91]; ++v92) {
                    if((v92 <= 0 || !z10 ? v92 == 0 : n0.C())) {
                        for(int v93 = 0; v93 < arr_v[v91]; ++v93) {
                            if(arr2_z4[v91][v93]) {
                                n0.H();
                            }
                        }
                        n0.H();
                        n0.H();
                    }
                }
            }
            int v94 = n0.H();
            if(n0.C()) {
                n0.O(v94 + 2);
            }
            else {
                for(int v95 = 1; v95 < v3; ++v95) {
                    for(int v96 = 0; v96 < v95; ++v96) {
                        if(arr2_z[v95][v96]) {
                            n0.O(v94 + 2);
                        }
                    }
                }
            }
            int v97 = n0.H();
            for(int v98 = 1; v98 <= v97; ++v98) {
                n0.O(8);
            }
            if(n0.C()) {
                int v99 = n0.e;
                if(v99 > 0) {
                    n0.O(8 - v99);
                }
                if((n0.C() ? true : n0.C())) {
                    n0.N();
                }
                boolean z11 = n0.C();
                boolean z12 = n0.C();
                if(z11 || z12) {
                    for(int v100 = 0; v100 < v7 + 1; ++v100) {
                        for(int v101 = 0; v101 < arr_v12[v100]; ++v101) {
                            boolean z13 = z11 ? n0.C() : false;
                            boolean z14 = z12 ? n0.C() : false;
                            if(z13) {
                                n0.O(0x20);
                            }
                            if(z14) {
                                n0.O(18);
                            }
                        }
                    }
                }
                boolean z15 = n0.C();
                int v102 = z15 ? n0.D(4) + 1 : v3;
                w.c(v102, "expectedSize");
                w.c(v102, "initialCapacity");
                int[] arr_v20 = new int[v3];
                Object[] arr_object1 = new Object[v102];
                int v103 = 0;
                int v104;
                for(v104 = 0; v103 < v102; ++v104) {
                    n0.O(3);
                    int v105 = n0.C() ? 1 : 2;
                    int v106 = b3.i.f(n0.D(8));
                    int v107 = b3.i.g(n0.D(8));
                    n0.O(8);
                    g g0 = new g(v106, v105, v107);
                    int v108 = I6.N.f(arr_object1.length, v104 + 1);
                    if(v108 > arr_object1.length) {
                        arr_object1 = Arrays.copyOf(arr_object1, v108);
                    }
                    arr_object1[v104] = g0;
                    ++v103;
                }
                if(z15 && v102 > 1) {
                    for(int v109 = 0; v109 < v3; ++v109) {
                        arr_v20[v109] = n0.D(4);
                    }
                }
                I6.p0 p03 = V.l(v104, arr_object1);
                ea.b b0 = new ea.b();  // 初始化器: Ljava/lang/Object;-><init>()V
                b0.a = V.p(p03);
                b0.b = arr_v20;
                return new i(p00, new v(p01, arr_v18), a0, b0);
            }
            return new i(p00, new v(p01, arr_v18), a0, null);
        }
        return new i(null, v8, null, null);
    }

    public static f3.i i(byte[] arr_b, int v, int v1) {
        int v42;
        int v39;
        int v38;
        int v33;
        int v32;
        boolean z2;
        int v19;
        int v18;
        int v17;
        int v8;
        boolean z;
        int v7;
        int v6;
        N n0 = new N(v + 1, v1, 3, arr_b);
        int v2 = n0.D(8);
        int v3 = n0.D(8);
        int v4 = n0.D(8);
        int v5 = n0.H();
        if(v2 == 44 || v2 == 100 || v2 == 110 || v2 == 0x7A || v2 == 0xF4 || (v2 == 83 || v2 == 86) || (v2 == 0x76 || v2 == 0x80 || v2 == 0x8A)) {
            v6 = n0.H();
            boolean z1 = v6 == 3 ? n0.C() : false;
            int v9 = n0.H();
            v8 = n0.H();
            n0.N();
            if(n0.C()) {
                for(int v10 = 0; v10 < (v6 == 3 ? 12 : 8); ++v10) {
                    if(n0.C()) {
                        int v11 = v10 >= 6 ? 0x40 : 16;
                        int v13 = 8;
                        int v14 = 8;
                        for(int v12 = 0; v12 < v11; ++v12) {
                            if(v13 != 0) {
                                v13 = (n0.I() + v14 + 0x100) % 0x100;
                            }
                            if(v13 != 0) {
                                v14 = v13;
                            }
                        }
                    }
                }
            }
            z = z1;
            v7 = v9;
        }
        else {
            v6 = 1;
            v7 = 0;
            z = false;
            v8 = 0;
        }
        int v15 = n0.H();
        int v16 = n0.H();
        if(v16 == 0) {
            v17 = n0.H() + 4;
            v18 = 0;
            v19 = v8;
            z2 = false;
        }
        else if(v16 == 1) {
            boolean z3 = n0.C();
            n0.I();
            n0.I();
            long v20 = (long)n0.H();
            v18 = 1;
            for(int v21 = 0; ((long)v21) < v20; ++v21) {
                n0.H();
            }
            v19 = v8;
            z2 = z3;
            v17 = 0;
        }
        else {
            v18 = v16;
            v19 = v8;
            v17 = 0;
            z2 = false;
        }
        n0.H();
        n0.N();
        int v22 = n0.H();
        int v23 = n0.H();
        int v24 = n0.C();
        int v25 = 2 - v24;
        if(v24 == 0) {
            n0.N();
        }
        n0.N();
        int v26 = (v22 + 1) * 16;
        int v27 = (v23 + 1) * v25 * 16;
        if(n0.C()) {
            int v28 = n0.H();
            int v29 = n0.H();
            int v30 = n0.H();
            int v31 = n0.H();
            if(v6 == 0) {
                v32 = 1;
            }
            else {
                v32 = v6 == 3 ? 1 : 2;
                v25 *= (v6 == 1 ? 2 : 1);
            }
            v26 -= (v28 + v29) * v32;
            v27 -= (v30 + v31) * v25;
        }
        switch(v2) {
            case 44: 
            case 86: 
            case 100: 
            case 110: 
            case 0x7A: 
            case 0xF4: {
                v33 = (v3 & 16) == 0 ? 16 : 0;
                break;
            }
            default: {
                v33 = 16;
            }
        }
        int v34 = -1;
        float f = 1.0f;
        if(n0.C()) {
            if(n0.C()) {
                int v35 = n0.D(8);
                if(v35 == 0xFF) {
                    int v36 = n0.D(16);
                    int v37 = n0.D(16);
                    if(v36 != 0 && v37 != 0) {
                        f = ((float)v36) / ((float)v37);
                    }
                    v38 = v15 + 4;
                }
                else if(v35 < 17) {
                    f = j.b[v35];
                    v38 = v15 + 4;
                }
                else {
                    v38 = v15 + 4;
                    com.iloen.melon.utils.a.r(v35, "Unexpected aspect_ratio_idc value: ", "NalUnitUtil");
                }
            }
            else {
                v38 = v15 + 4;
            }
            if(n0.C()) {
                n0.N();
            }
            if(n0.C()) {
                n0.O(3);
                v39 = n0.C() ? 1 : 2;
                if(n0.C()) {
                    int v40 = n0.D(8);
                    int v41 = n0.D(8);
                    n0.O(8);
                    v34 = b3.i.f(v40);
                    v42 = b3.i.g(v41);
                }
                else {
                    v42 = -1;
                }
            }
            else {
                v39 = -1;
                v42 = -1;
            }
            if(n0.C()) {
                n0.H();
                n0.H();
            }
            if(n0.C()) {
                n0.O(65);
            }
            boolean z4 = n0.C();
            if(z4) {
                j.j(n0);
            }
            boolean z5 = n0.C();
            if(z5) {
                j.j(n0);
            }
            if(z4 || z5) {
                n0.N();
            }
            n0.N();
            if(n0.C()) {
                n0.N();
                n0.H();
                n0.H();
                n0.H();
                n0.H();
                v33 = n0.H();
                n0.H();
            }
            return new f3.i(v2, v3, v4, v5, v26, v27, f, v7, v19, z, ((boolean)v24), v38, v18, v17, z2, v34, v39, v42, v33);
        }
        return new f3.i(v2, v3, v4, v5, v26, v27, 1.0f, v7, v19, z, ((boolean)v24), v15 + 4, v18, v17, z2, -1, -1, -1, v33);
    }

    public static void j(N n0) {
        int v = n0.H();
        n0.O(8);
        for(int v1 = 0; v1 < v + 1; ++v1) {
            n0.H();
            n0.H();
            n0.N();
        }
        n0.O(20);
    }

    public static int k(byte[] arr_b, int v) {
        Object object0 = j.c;
        __monitor_enter(object0);
        int v1 = 0;
        int v2 = 0;
        try {
            while(v1 < v) {
                while(true) {
                    if(v1 < v - 2) {
                        if(arr_b[v1] == 0 && arr_b[v1 + 1] == 0 && arr_b[v1 + 2] == 3) {
                            break;
                        }
                        else {
                            ++v1;
                            continue;
                        }
                    }
                    v1 = v;
                    break;
                }
                if(v1 < v) {
                    int[] arr_v = j.d;
                    if(arr_v.length <= v2) {
                        j.d = Arrays.copyOf(arr_v, arr_v.length * 2);
                    }
                    j.d[v2] = v1;
                    v1 += 3;
                    ++v2;
                }
            }
            int v4 = v - v2;
            int v6 = 0;
            int v7 = 0;
            for(int v5 = 0; v5 < v2; ++v5) {
                int v8 = j.d[v5] - v7;
                System.arraycopy(arr_b, v7, arr_b, v6, v8);
                int v9 = v6 + v8;
                arr_b[v9] = 0;
                v6 = v9 + 2;
                arr_b[v9 + 1] = 0;
                v7 += v8 + 3;
            }
            System.arraycopy(arr_b, v7, arr_b, v6, v4 - v6);
            return v4;
        }
        finally {
            __monitor_exit(object0);
        }
    }
}

