package i.n.i.b.a.s.e;

import B3.N;
import a4.b;
import a4.g;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;

public final class id {
    public final Paint a;
    public final Paint b;
    public final Canvas c;
    public final b d;
    public final dd e;
    public final g f;
    public Bitmap g;
    public static final byte[] h;
    public static final byte[] i;
    public static final byte[] j;

    static {
        id.h = new byte[]{0, 7, 8, 15};
        id.i = new byte[]{0, 0x77, -120, -1};
        id.j = new byte[]{0, 17, 34, 51, 68, 85, 102, 0x77, -120, -103, -86, -69, -52, -35, -18, -1};
    }

    public id(int v, int v1) {
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
        int[] arr_v = id.f();
        int[] arr_v1 = id.g();
        this.e = new dd(0, new int[]{0, -1, 0xFF000000, 0xFF7F7F7F}, arr_v, arr_v1);
        this.f = new g(v, v1, 1);
    }

    public static int a(int v, int v1, int v2, int v3) [...] // Inlined contents

    public static dd b(N n0, int v) {
        int v9;
        int v8;
        int v7;
        int v6;
        int v5;
        int[] arr_v3;
        int v1 = n0.a(8);
        n0.v(8);
        int v2 = v - 2;
        int[] arr_v = {0, -1, 0xFF000000, 0xFF7F7F7F};
        int[] arr_v1 = id.f();
        int[] arr_v2 = id.g();
        while(v2 > 0) {
            int v3 = n0.a(8);
            int v4 = n0.a(8);
            if((v4 & 0x80) == 0) {
                arr_v3 = (v4 & 0x40) == 0 ? arr_v2 : arr_v1;
            }
            else {
                arr_v3 = arr_v;
            }
            if((v4 & 1) == 0) {
                int v10 = n0.a(6);
                int v11 = n0.a(4);
                v7 = n0.a(4) << 4;
                v9 = v2 - 4;
                v8 = n0.a(2) << 6;
                v5 = v10 << 2;
                v6 = v11 << 4;
            }
            else {
                v5 = n0.a(8);
                v6 = n0.a(8);
                v7 = n0.a(8);
                v8 = n0.a(8);
                v9 = v2 - 6;
            }
            if(v5 == 0) {
                v6 = 0;
                v7 = 0;
                v8 = 0xFF;
            }
            arr_v3[v3] = ((int)(((byte)(~v8 & 0xFF)))) << 24 | L7.d(((int)(1.402 * ((double)(v6 - 0x80)) + ((double)v5))), 0, 0xFF) << 16 | L7.d(((int)(((double)v5) - 0.34414 * ((double)(v7 - 0x80)) - ((double)(v6 - 0x80)) * 0.71414)), 0, 0xFF) << 8 | L7.d(((int)(((double)(v7 - 0x80)) * 1.772 + ((double)v5))), 0, 0xFF);
            v2 = v9;
        }
        return new dd(v1, arr_v, arr_v1, arr_v2);
    }

    public static void c(byte[] arr_b, int[] arr_v, int v, int v1, int v2, Paint paint0, Canvas canvas0) {
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
        N n0 = new N(arr_b, arr_b.length, 6, 0);
        int v3 = v1;
        int v4 = v2;
        byte[] arr_b1 = null;
        byte[] arr_b2 = null;
        byte[] arr_b3 = null;
    label_6:
        while(n0.h() != 0) {
            int v5 = n0.a(8);
            if(v5 != 0xF0) {
                switch(v5) {
                    case 16: {
                        switch(v) {
                            case 2: {
                                arr_b4 = arr_b3 == null ? id.h : arr_b3;
                                break;
                            }
                            case 3: {
                                arr_b4 = arr_b1 == null ? id.i : arr_b1;
                                break;
                            }
                            default: {
                                arr_b4 = null;
                            }
                        }
                        do {
                            int v6 = n0.a(2);
                            if(v6 != 0) {
                                z = false;
                                v7 = v6;
                                v8 = 1;
                            }
                            else if(n0.y()) {
                                int v9 = n0.a(3);
                                z = false;
                                v7 = n0.a(2);
                                v8 = v9 + 3;
                            }
                            else if(n0.y()) {
                                z = false;
                                v8 = 1;
                                v7 = 0;
                            }
                            else {
                                switch(n0.a(2)) {
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
                                        v8 = n0.a(4) + 12;
                                        v7 = n0.a(2);
                                        z = false;
                                        break;
                                    }
                                    case 3: {
                                        int v10 = n0.a(8);
                                        v7 = n0.a(2);
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
                        n0.o();
                        continue;
                    }
                    case 17: {
                        if(v != 3) {
                            arr_b5 = null;
                        }
                        else if(arr_b2 == null) {
                            arr_b5 = id.j;
                        }
                        else {
                            arr_b5 = arr_b2;
                        }
                        do {
                            int v12 = n0.a(4);
                            if(v12 != 0) {
                                z1 = false;
                                v13 = v12;
                                v14 = 1;
                            }
                            else if(n0.y()) {
                                if(n0.y()) {
                                    switch(n0.a(2)) {
                                        case 0: {
                                            z1 = false;
                                            v14 = 1;
                                            v13 = 0;
                                            goto label_116;
                                        }
                                        case 1: {
                                            z1 = false;
                                            v14 = 2;
                                            v13 = 0;
                                            goto label_116;
                                        }
                                        case 2: {
                                            v14 = n0.a(4) + 9;
                                            v13 = n0.a(4);
                                            break;
                                        }
                                        case 3: {
                                            v14 = n0.a(8) + 25;
                                            v13 = n0.a(4);
                                            break;
                                        }
                                        default: {
                                            z1 = false;
                                            v14 = 0;
                                            v13 = 0;
                                            goto label_116;
                                        }
                                    }
                                }
                                else {
                                    v14 = n0.a(2) + 4;
                                    v13 = n0.a(4);
                                }
                                z1 = false;
                            }
                            else {
                                int v15 = n0.a(3);
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
                        label_116:
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
                        n0.o();
                        continue;
                    }
                    case 18: {
                        while(true) {
                            int v17 = n0.a(8);
                            if(v17 != 0) {
                                z2 = false;
                                v18 = 1;
                            }
                            else if(n0.y()) {
                                z2 = false;
                                v18 = n0.a(7);
                                v17 = n0.a(8);
                            }
                            else {
                                int v19 = n0.a(7);
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
                        arr_b3 = id.d(4, 4, n0);
                        continue;
                    }
                    case 33: {
                        arr_b1 = id.d(4, 8, n0);
                        continue;
                    }
                    case 34: {
                        arr_b2 = id.d(16, 8, n0);
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

    public static byte[] d(int v, int v1, N n0) {
        byte[] arr_b = new byte[v];
        for(int v2 = 0; v2 < v; ++v2) {
            arr_b[v2] = (byte)n0.a(v1);
        }
        return arr_b;
    }

    public static ed e(N n0) {
        int v = n0.a(16);
        n0.v(4);
        int v1 = n0.a(2);
        boolean z = n0.y();
        n0.v(1);
        byte[] arr_b = L7.g;
        if(v1 == 1) {
            n0.v(n0.a(8) * 16);
            return new ed(v, z, arr_b, arr_b);
        }
        if(v1 == 0) {
            int v2 = n0.a(16);
            int v3 = n0.a(16);
            if(v2 > 0) {
                arr_b = new byte[v2];
                n0.k(v2, arr_b);
            }
            if(v3 > 0) {
                byte[] arr_b1 = new byte[v3];
                n0.k(v3, arr_b1);
                return new ed(v, z, arr_b, arr_b1);
            }
        }
        return new ed(v, z, arr_b, arr_b);
    }

    public static int[] f() {
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

    public static int[] g() {
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
}

