package a4;

import B3.N;
import G.I0;
import I6.p0;
import Y3.k;
import Y3.l;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import e3.e;
import e3.p;
import e3.x;
import java.util.ArrayList;
import java.util.List;

public final class h implements l {
    public final Paint a;
    public final Paint b;
    public final Canvas c;
    public final b d;
    public final a e;
    public final g f;
    public Bitmap g;
    public static final byte[] h;
    public static final byte[] i;
    public static final byte[] j;

    static {
        h.h = new byte[]{0, 7, 8, 15};
        h.i = new byte[]{0, 0x77, -120, -1};
        h.j = new byte[]{0, 17, 34, 51, 68, 85, 102, 0x77, -120, -103, -86, -69, -52, -35, -18, -1};
    }

    public h(List list0) {
        p p0 = new p(((byte[])list0.get(0)));
        int v = p0.A();
        int v1 = p0.A();
        Paint paint0 = new Paint();
        this.a = paint0;
        paint0.setStyle(Paint.Style.FILL_AND_STROKE);
        paint0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint0.setPathEffect(null);
        Paint paint1 = new Paint();
        this.b = paint1;
        paint1.setStyle(Paint.Style.FILL);
        paint1.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint1.setPathEffect(null);
        this.c = new Canvas();
        this.d = new b(0x2CF, 0x23F, 0, 0x2CF, 0, 0x23F);
        int[] arr_v = h.b();
        int[] arr_v1 = h.c();
        this.e = new a(0, new int[]{0, -1, 0xFF000000, 0xFF7F7F7F}, arr_v, arr_v1);
        this.f = new g(v, v1, 0);
    }

    public static byte[] a(int v, int v1, N n0) {
        byte[] arr_b = new byte[v];
        for(int v2 = 0; v2 < v; ++v2) {
            arr_b[v2] = (byte)n0.D(v1);
        }
        return arr_b;
    }

    public static int[] b() {
        int[] arr_v = new int[16];
        arr_v[0] = 0;
        for(int v = 1; true; ++v) {
            int v1 = 0x7F;
            if(v >= 16) {
                break;
            }
            if(v < 8) {
                arr_v[v] = 0xFF000000 | ((v & 1) == 0 ? 0 : 0xFF) << 16 | ((v & 2) == 0 ? 0 : 0xFF) << 8 | ((v & 4) == 0 ? 0 : 0xFF);
            }
            else {
                if((v & 4) == 0) {
                    v1 = 0;
                }
                arr_v[v] = 0xFF000000 | ((v & 1) == 0 ? 0 : 0x7F) << 16 | ((v & 2) == 0 ? 0 : 0x7F) << 8 | v1;
            }
        }
        return arr_v;
    }

    public static int[] c() {
        int[] arr_v = new int[0x100];
        arr_v[0] = 0;
        for(int v = 0; true; ++v) {
            int v1 = 0xFF;
            if(v >= 0x100) {
                break;
            }
            if(v < 8) {
                if((v & 4) == 0) {
                    v1 = 0;
                }
                arr_v[v] = 0x3F000000 | ((v & 1) == 0 ? 0 : 0xFF) << 16 | ((v & 2) == 0 ? 0 : 0xFF) << 8 | v1;
            }
            else {
                int v2 = 43;
                int v3 = 170;
                int v4 = 85;
                switch(v & 0x88) {
                    case 0: {
                        if((v & 4) == 0) {
                            v4 = 0;
                        }
                        if((v & 0x40) == 0) {
                            v3 = 0;
                        }
                        arr_v[v] = 0xFF000000 | ((v & 1) == 0 ? 0 : 85) + ((v & 16) == 0 ? 0 : 170) << 16 | ((v & 2) == 0 ? 0 : 85) + ((v & 0x20) == 0 ? 0 : 170) << 8 | v4 + v3;
                        break;
                    }
                    case 8: {
                        if((v & 4) == 0) {
                            v4 = 0;
                        }
                        if((v & 0x40) == 0) {
                            v3 = 0;
                        }
                        arr_v[v] = 0x7F000000 | ((v & 1) == 0 ? 0 : 85) + ((v & 16) == 0 ? 0 : 170) << 16 | ((v & 2) == 0 ? 0 : 85) + ((v & 0x20) == 0 ? 0 : 170) << 8 | v4 + v3;
                        break;
                    }
                    default: {
                        switch(v & 0x88) {
                            case 0x80: {
                                if((v & 4) == 0) {
                                    v2 = 0;
                                }
                                if((v & 0x40) == 0) {
                                    v4 = 0;
                                }
                                arr_v[v] = 0xFF000000 | ((v & 1) == 0 ? 0 : 43) + 0x7F + ((v & 16) == 0 ? 0 : 85) << 16 | ((v & 2) == 0 ? 0 : 43) + 0x7F + ((v & 0x20) == 0 ? 0 : 85) << 8 | v2 + 0x7F + v4;
                                break;
                            }
                            case 0x88: {
                                if((v & 4) == 0) {
                                    v2 = 0;
                                }
                                if((v & 0x40) == 0) {
                                    v4 = 0;
                                }
                                arr_v[v] = 0xFF000000 | ((v & 1) == 0 ? 0 : 43) + ((v & 16) == 0 ? 0 : 85) << 16 | ((v & 2) == 0 ? 0 : 43) + ((v & 0x20) == 0 ? 0 : 85) << 8 | v2 + v4;
                            }
                        }
                    }
                }
            }
        }
        return arr_v;
    }

    public static int d(int v, int v1, int v2, int v3) [...] // Inlined contents

    public static void e(byte[] arr_b, int[] arr_v, int v, int v1, int v2, Paint paint0, Canvas canvas0) {
        int v20;
        int v18;
        boolean z2;
        int v16;
        int v14;
        int v13;
        boolean z1;
        byte[] arr_b5;
        int v11;
        int v8;
        int v7;
        boolean z;
        byte[] arr_b4;
        N n0 = new N(arr_b, arr_b.length, 2, 0);
        int v3 = v1;
        int v4 = v2;
        byte[] arr_b1 = null;
        byte[] arr_b2 = null;
        byte[] arr_b3 = null;
    label_6:
        while(n0.m() != 0) {
            int v5 = n0.D(8);
            if(v5 != 0xF0) {
                switch(v5) {
                    case 16: {
                        switch(v) {
                            case 2: {
                                arr_b4 = arr_b3 == null ? h.h : arr_b3;
                                break;
                            }
                            case 3: {
                                arr_b4 = arr_b1 == null ? h.i : arr_b1;
                                break;
                            }
                            default: {
                                arr_b4 = null;
                            }
                        }
                        do {
                            int v6 = n0.D(2);
                            if(v6 != 0) {
                                z = false;
                                v7 = v6;
                                v8 = 1;
                            }
                            else if(n0.C()) {
                                int v9 = n0.D(3);
                                z = false;
                                v7 = n0.D(2);
                                v8 = v9 + 3;
                            }
                            else if(n0.C()) {
                                z = false;
                                v8 = 1;
                                v7 = 0;
                            }
                            else {
                                switch(n0.D(2)) {
                                    case 0: {
                                        z = true;
                                        v7 = 0;
                                        v8 = 0;
                                        break;
                                    }
                                    case 1: {
                                        z = false;
                                        v8 = 2;
                                        v7 = 0;
                                        break;
                                    }
                                    case 2: {
                                        v8 = n0.D(4) + 12;
                                        v7 = n0.D(2);
                                        z = false;
                                        break;
                                    }
                                    case 3: {
                                        int v10 = n0.D(8);
                                        v7 = n0.D(2);
                                        z = false;
                                        v8 = v10 + 29;
                                        break;
                                    }
                                    default: {
                                        z = false;
                                        v7 = 0;
                                        v8 = 0;
                                    }
                                }
                            }
                            if(v8 == 0 || paint0 == null) {
                                v11 = v3;
                            }
                            else {
                                if(arr_b4 != null) {
                                    v7 = arr_b4[v7];
                                }
                                paint0.setColor(arr_v[v7]);
                                v11 = v3;
                                canvas0.drawRect(((float)v3), ((float)v4), ((float)(v3 + v8)), ((float)(v4 + 1)), paint0);
                            }
                            v3 = v11 + v8;
                        }
                        while(!z);
                        n0.n();
                        continue;
                    }
                    case 17: {
                        if(v == 3) {
                            arr_b5 = arr_b2 == null ? h.j : arr_b2;
                        }
                        else {
                            arr_b5 = null;
                        }
                        do {
                            int v12 = n0.D(4);
                            if(v12 != 0) {
                                z1 = false;
                                v13 = v12;
                                v14 = 1;
                            }
                            else if(n0.C()) {
                                if(n0.C()) {
                                    switch(n0.D(2)) {
                                        case 0: {
                                            z1 = false;
                                            v14 = 1;
                                            v13 = 0;
                                            goto label_113;
                                        }
                                        case 1: {
                                            z1 = false;
                                            v14 = 2;
                                            v13 = 0;
                                            goto label_113;
                                        }
                                        case 2: {
                                            v14 = n0.D(4) + 9;
                                            v13 = n0.D(4);
                                            break;
                                        }
                                        case 3: {
                                            v14 = n0.D(8) + 25;
                                            v13 = n0.D(4);
                                            break;
                                        }
                                        default: {
                                            z1 = false;
                                            v14 = 0;
                                            v13 = 0;
                                            goto label_113;
                                        }
                                    }
                                }
                                else {
                                    v14 = n0.D(2) + 4;
                                    v13 = n0.D(4);
                                }
                                z1 = false;
                            }
                            else {
                                int v15 = n0.D(3);
                                if(v15 == 0) {
                                    z1 = true;
                                    v14 = 0;
                                }
                                else {
                                    v14 = v15 + 2;
                                    z1 = false;
                                }
                                v13 = 0;
                            }
                        label_113:
                            if(v14 == 0 || paint0 == null) {
                                v16 = v3;
                            }
                            else {
                                if(arr_b5 != null) {
                                    v13 = arr_b5[v13];
                                }
                                paint0.setColor(arr_v[v13]);
                                v16 = v3;
                                canvas0.drawRect(((float)v3), ((float)v4), ((float)(v3 + v14)), ((float)(v4 + 1)), paint0);
                            }
                            v3 = v16 + v14;
                        }
                        while(!z1);
                        n0.n();
                        continue;
                    }
                    case 18: {
                        while(true) {
                            int v17 = n0.D(8);
                            if(v17 != 0) {
                                z2 = false;
                                v18 = 1;
                            }
                            else if(n0.C()) {
                                z2 = false;
                                v18 = n0.D(7);
                                v17 = n0.D(8);
                            }
                            else {
                                int v19 = n0.D(7);
                                if(v19 == 0) {
                                    z2 = true;
                                    v17 = 0;
                                    v18 = 0;
                                }
                                else {
                                    z2 = false;
                                    v18 = v19;
                                    v17 = 0;
                                }
                            }
                            if(v18 == 0 || paint0 == null) {
                                v20 = v3;
                            }
                            else {
                                paint0.setColor(arr_v[v17]);
                                v20 = v3;
                                canvas0.drawRect(((float)v3), ((float)v4), ((float)(v3 + v18)), ((float)(v4 + 1)), paint0);
                            }
                            v3 = v20 + v18;
                            if(z2) {
                                continue label_6;
                            }
                        }
                    }
                    case 0x20: {
                        arr_b3 = h.a(4, 4, n0);
                        continue;
                    }
                    case 33: {
                        arr_b1 = h.a(4, 8, n0);
                        continue;
                    }
                    case 34: {
                        arr_b2 = h.a(16, 8, n0);
                        continue;
                    }
                    default: {
                        continue;
                    }
                }
            }
            v4 += 2;
            v3 = v1;
        }
    }

    public static a f(N n0, int v) {
        int v9;
        int v8;
        int v7;
        int v6;
        int v5;
        int[] arr_v3;
        int v1 = n0.D(8);
        n0.O(8);
        int v2 = v - 2;
        int[] arr_v = {0, -1, 0xFF000000, 0xFF7F7F7F};
        int[] arr_v1 = h.b();
        int[] arr_v2 = h.c();
        while(v2 > 0) {
            int v3 = n0.D(8);
            int v4 = n0.D(8);
            if((v4 & 0x80) == 0) {
                arr_v3 = (v4 & 0x40) == 0 ? arr_v2 : arr_v1;
            }
            else {
                arr_v3 = arr_v;
            }
            if((v4 & 1) == 0) {
                int v10 = n0.D(6);
                int v11 = n0.D(4);
                v7 = n0.D(4) << 4;
                v9 = v2 - 4;
                v8 = n0.D(2) << 6;
                v5 = v10 << 2;
                v6 = v11 << 4;
            }
            else {
                v5 = n0.D(8);
                v6 = n0.D(8);
                v7 = n0.D(8);
                v8 = n0.D(8);
                v9 = v2 - 6;
            }
            if(v5 == 0) {
                v6 = 0;
                v7 = 0;
                v8 = 0xFF;
            }
            arr_v3[v3] = ((int)(((byte)(~v8 & 0xFF)))) << 24 | x.h(((int)(1.402 * ((double)(v6 - 0x80)) + ((double)v5))), 0, 0xFF) << 16 | x.h(((int)(((double)v5) - 0.34414 * ((double)(v7 - 0x80)) - ((double)(v6 - 0x80)) * 0.71414)), 0, 0xFF) << 8 | x.h(((int)(((double)(v7 - 0x80)) * 1.772 + ((double)v5))), 0, 0xFF);
            v2 = v9;
        }
        return new a(v1, arr_v, arr_v1, arr_v2);
    }

    @Override  // Y3.l
    public final void g(byte[] arr_b, int v, int v1, k k0, e e0) {
        int v53;
        int v51;
        int v50;
        a4.e e4;
        int v49;
        ArrayList arrayList1;
        int v48;
        int v47;
        b b1;
        int[] arr_v;
        g g1;
        Y3.a a2;
        int v30;
        int v29;
        int v28;
        int v27;
        g g0;
        N n0 = new N(arr_b, v + v1, 2, 0);
        n0.L(v);
        while(true) {
            g0 = this.f;
            if(n0.m() < 0x30 || n0.D(8) != 15) {
                break;
            }
            int v2 = n0.D(8);
            int v3 = n0.D(16);
            int v4 = n0.D(16);
            int v5 = n0.A() + v4;
            if(v4 * 8 > n0.m()) {
                e3.b.D("DvbParser", "Data field length exceeds limit");
                n0.O(n0.m());
            }
            else {
                switch(v2) {
                    case 16: {
                        if(v3 == g0.a) {
                            I0 i00 = (I0)g0.i;
                            n0.D(8);
                            int v6 = n0.D(4);
                            int v7 = n0.D(2);
                            n0.O(2);
                            int v8 = v4 - 2;
                            SparseArray sparseArray0 = new SparseArray();
                            while(v8 > 0) {
                                int v9 = n0.D(8);
                                n0.O(8);
                                v8 -= 6;
                                sparseArray0.put(v9, new d(n0.D(16), n0.D(16)));
                            }
                            I0 i01 = new I0(v6, v7, sparseArray0);
                            if(v7 != 0) {
                                g0.i = i01;
                                g0.c.clear();
                                g0.d.clear();
                                g0.e.clear();
                            }
                            else if(i00 != null && i00.b != v6) {
                                g0.i = i01;
                            }
                        }
                        break;
                    }
                    case 17: {
                        I0 i02 = (I0)g0.i;
                        SparseArray sparseArray1 = g0.c;
                        if(v3 == g0.a && i02 != null) {
                            int v10 = n0.D(8);
                            n0.O(4);
                            boolean z = n0.C();
                            n0.O(3);
                            int v11 = n0.D(16);
                            int v12 = n0.D(16);
                            n0.D(3);
                            int v13 = n0.D(3);
                            n0.O(2);
                            int v14 = n0.D(8);
                            int v15 = n0.D(8);
                            int v16 = n0.D(4);
                            int v17 = n0.D(2);
                            n0.O(2);
                            int v18 = v4 - 10;
                            SparseArray sparseArray2 = new SparseArray();
                            while(v18 > 0) {
                                int v19 = n0.D(16);
                                int v20 = n0.D(2);
                                n0.D(2);
                                int v21 = n0.D(12);
                                n0.O(4);
                                int v22 = n0.D(12);
                                if(v20 == 1 || v20 == 2) {
                                    n0.D(8);
                                    n0.D(8);
                                    v18 -= 8;
                                }
                                else {
                                    v18 -= 6;
                                }
                                sparseArray2.put(v19, new f(v21, v22));
                            }
                            a4.e e1 = new a4.e(v10, z, v11, v12, v13, v14, v15, v16, v17, sparseArray2);
                            if(i02.c == 0) {
                                a4.e e2 = (a4.e)sparseArray1.get(v10);
                                if(e2 != null) {
                                    SparseArray sparseArray3 = e2.j;
                                    for(int v23 = 0; v23 < sparseArray3.size(); ++v23) {
                                        int v24 = sparseArray3.keyAt(v23);
                                        f f0 = (f)sparseArray3.valueAt(v23);
                                        e1.j.put(v24, f0);
                                    }
                                }
                            }
                            sparseArray1.put(e1.a, e1);
                        }
                        break;
                    }
                    case 18: {
                        if(v3 == g0.a) {
                            a a0 = h.f(n0, v4);
                            g0.d.put(a0.a, a0);
                        }
                        else if(v3 == g0.b) {
                            a a1 = h.f(n0, v4);
                            g0.f.put(a1.a, a1);
                        }
                        break;
                    }
                    case 19: {
                        if(v3 == g0.a) {
                            c c0 = h.h(n0);
                            g0.e.put(c0.a, c0);
                        }
                        else if(v3 == g0.b) {
                            c c1 = h.h(n0);
                            g0.g.put(c1.a, c1);
                        }
                        break;
                    }
                    case 20: {
                        if(v3 == g0.a) {
                            n0.O(4);
                            boolean z1 = n0.C();
                            n0.O(3);
                            int v25 = n0.D(16);
                            int v26 = n0.D(16);
                            if(z1) {
                                v27 = n0.D(16);
                                v28 = n0.D(16);
                                v29 = n0.D(16);
                                v30 = n0.D(16);
                            }
                            else {
                                v27 = 0;
                                v29 = 0;
                                v28 = v25;
                                v30 = v26;
                            }
                            g0.h = new b(v25, v26, v27, v28, v29, v30);
                        }
                    }
                }
                n0.P(v5 - n0.A());
            }
        }
        I0 i03 = (I0)g0.i;
        if(i03 == null) {
            a2 = new Y3.a(p0.e, 0x8000000000000001L, 0x8000000000000001L);
        }
        else {
            b b0 = (b)g0.h;
            if(b0 == null) {
                b0 = this.d;
            }
            Bitmap bitmap0 = this.g;
            Canvas canvas0 = this.c;
            if(bitmap0 == null) {
            label_135:
                Bitmap bitmap1 = Bitmap.createBitmap(b0.a + 1, b0.b + 1, Bitmap.Config.ARGB_8888);
                this.g = bitmap1;
                canvas0.setBitmap(bitmap1);
            }
            else {
                int v31 = bitmap0.getWidth();
                if(b0.a + 1 == v31) {
                    int v32 = this.g.getHeight();
                    if(b0.b + 1 != v32) {
                        goto label_135;
                    }
                }
                else {
                    goto label_135;
                }
            }
            ArrayList arrayList0 = new ArrayList();
            SparseArray sparseArray4 = (SparseArray)i03.d;
            for(int v33 = 0; v33 < sparseArray4.size(); ++v33) {
                canvas0.save();
                d d0 = (d)sparseArray4.valueAt(v33);
                int v34 = sparseArray4.keyAt(v33);
                a4.e e3 = (a4.e)g0.c.get(v34);
                int v35 = d0.a + b0.c;
                int v36 = d0.b + b0.e;
                int v37 = e3.c;
                int v38 = e3.f;
                int v39 = e3.d;
                int v40 = v35 + v37;
                int v41 = v36 + v39;
                canvas0.clipRect(v35, v36, Math.min(v40, b0.d), Math.min(v41, b0.f));
                a a3 = (a)g0.d.get(v38);
                if(a3 == null) {
                    a a4 = (a)g0.f.get(v38);
                    a3 = a4 == null ? this.e : a4;
                }
                SparseArray sparseArray5 = e3.j;
                int v42 = 0;
                while(v42 < sparseArray5.size()) {
                    int v43 = sparseArray5.keyAt(v42);
                    f f1 = (f)sparseArray5.valueAt(v42);
                    c c2 = (c)g0.e.get(v43);
                    if(c2 == null) {
                        c2 = (c)g0.g.get(v43);
                    }
                    if(c2 == null) {
                        arrayList1 = arrayList0;
                        v49 = v36;
                        b1 = b0;
                        g1 = g0;
                        e4 = e3;
                        v48 = v35;
                        v47 = v37;
                        v50 = v42;
                        v51 = v39;
                    }
                    else {
                        Paint paint0 = c2.b ? null : this.a;
                        int v44 = e3.e;
                        g1 = g0;
                        int v45 = v35 + f1.a;
                        int v46 = v36 + f1.b;
                        if(v44 == 3) {
                            arr_v = a3.d;
                        }
                        else {
                            arr_v = v44 == 2 ? a3.c : a3.b;
                        }
                        b1 = b0;
                        v47 = v37;
                        v48 = v35;
                        arrayList1 = arrayList0;
                        v49 = v36;
                        e4 = e3;
                        v50 = v42;
                        v51 = v39;
                        h.e(c2.c, arr_v, v44, v45, v46, paint0, canvas0);
                        h.e(c2.d, arr_v, v44, v45, v46 + 1, paint0, canvas0);
                    }
                    v42 = v50 + 1;
                    v37 = v47;
                    v36 = v49;
                    e3 = e4;
                    v35 = v48;
                    arrayList0 = arrayList1;
                    b0 = b1;
                    g0 = g1;
                    v39 = v51;
                }
                if(e3.b) {
                    int v52 = e3.e;
                    if(v52 == 3) {
                        v53 = a3.d[e3.g];
                    }
                    else {
                        v53 = v52 == 2 ? a3.c[e3.h] : a3.b[e3.i];
                    }
                    this.b.setColor(v53);
                    canvas0.drawRect(((float)v35), ((float)v36), ((float)v40), ((float)v41), this.b);
                }
                arrayList0.add(new d3.b(null, null, null, Bitmap.createBitmap(this.g, v35, v36, v37, v39), ((float)v36) / ((float)b0.b), 0, 0, ((float)v35) / ((float)b0.a), 0, 0x80000000, -3.402823E+38f, ((float)v37) / ((float)b0.a), ((float)v39) / ((float)b0.b), false, 0xFF000000, 0x80000000, 0.0f));
                canvas0.drawColor(0, PorterDuff.Mode.CLEAR);
                canvas0.restore();
            }
            a2 = new Y3.a(arrayList0, 0x8000000000000001L, 0x8000000000000001L);
        }
        e0.accept(a2);
    }

    public static c h(N n0) {
        int v = n0.D(16);
        n0.O(4);
        int v1 = n0.D(2);
        boolean z = n0.C();
        n0.O(1);
        byte[] arr_b = x.f;
        if(v1 == 1) {
            n0.O(n0.D(8) * 16);
            return new c(v, z, arr_b, arr_b);
        }
        if(v1 == 0) {
            int v2 = n0.D(16);
            int v3 = n0.D(16);
            if(v2 > 0) {
                arr_b = new byte[v2];
                n0.G(arr_b, v2);
            }
            if(v3 > 0) {
                byte[] arr_b1 = new byte[v3];
                n0.G(arr_b1, v3);
                return new c(v, z, arr_b, arr_b1);
            }
        }
        return new c(v, z, arr_b, arr_b);
    }

    @Override  // Y3.l
    public final int j() {
        return 2;
    }

    @Override  // Y3.l
    public final void reset() {
        this.f.c.clear();
        this.f.d.clear();
        this.f.e.clear();
        this.f.f.clear();
        this.f.g.clear();
        this.f.h = null;
        this.f.i = null;
    }
}

