package i.n.i.b.a.s.e;

import B3.N;
import B3.g;
import B3.v;
import com.iloen.melon.fragments.radio.a;
import d5.l;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class a2 implements q4 {
    public final byte[] a;
    public final wb b;
    public final boolean c;
    public final v d;
    public U5 e;
    public ie f;
    public int g;
    public x8 h;
    public I9 i;
    public int j;
    public int k;
    public r l;
    public int m;
    public long n;

    static {
    }

    public a2() {
        this.a = new byte[42];
        this.b = new wb(new byte[0x8000], 0);
        this.c = false;
        this.d = new v();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.g = 0;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void d(long v, long v1) {
        long v2 = 0L;
        if(Long.compare(v, 0L) == 0) {
            this.g = 0;
        }
        else {
            r r0 = this.l;
            if(r0 != null) {
                r0.c(v1);
            }
        }
        if(v1 != 0L) {
            v2 = -1L;
        }
        this.n = v2;
        this.m = 0;
        this.b.l(0);
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final boolean e(i5 i50) {
        M7.i(i50, false);
        byte[] arr_b = new byte[4];
        i50.s(arr_b, 0, 4);
        return (((long)arr_b[3]) & 0xFFL | ((((long)arr_b[0]) & 0xFFL) << 24 | (((long)arr_b[1]) & 0xFFL) << 16 | (((long)arr_b[2]) & 0xFFL) << 8)) == 0x664C6143L;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final int f(i5 i50, v v0) {
        boolean z2;
        int v25;
        long v24;
        long v16;
        long v13;
        long v12;
        K8 k80;
        x8 x84;
        x8 x82;
        I9 i93;
        int v1 = this.g;
        boolean z = true;
        if(v1 != 0) {
            byte[] arr_b = this.a;
            if(v1 != 1) {
                int v2 = 7;
                switch(v1) {
                    case 2: {
                        byte[] arr_b4 = new byte[4];
                        ((D2)i50).f(arr_b4, 0, 4, false);
                        if((((long)arr_b4[3]) & 0xFFL | ((((long)arr_b4[0]) & 0xFFL) << 24 | (((long)arr_b4[1]) & 0xFFL) << 16 | (((long)arr_b4[2]) & 0xFFL) << 8)) != 0x664C6143L) {
                            throw new H4("Failed to read FLAC stream marker.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                        }
                        this.g = 3;
                        return 0;
                    }
                    case 3: {
                        I9 i92 = this.i;
                        boolean z3 = false;
                        while(!z3) {
                            ((D2)i50).f = 0;
                            byte[] arr_b5 = new byte[4];
                            N n0 = new N(arr_b5, 4, 6, 0);
                            ((D2)i50).k(arr_b5, 0, 4, false);
                            boolean z4 = n0.y();
                            int v29 = n0.a(7);
                            int v30 = n0.a(24) + 4;
                            if(v29 == 0) {
                                byte[] arr_b6 = new byte[38];
                                ((D2)i50).f(arr_b6, 0, 38, false);
                                i92 = new I9(arr_b6, 4);
                            }
                            else {
                                if(i92 == null) {
                                    throw new IllegalArgumentException();
                                }
                                x8 x80 = i92.l;
                                if(v29 == 3) {
                                    wb wb2 = new wb(v30);
                                    ((D2)i50).f(wb2.a, 0, v30, false);
                                    l l0 = M7.b(wb2);
                                    i93 = new I9(i92.a, i92.b, i92.c, i92.d, i92.e, i92.g, i92.h, i92.j, l0, i92.l);
                                }
                                else {
                                    switch(v29) {
                                        case 4: {
                                            wb wb3 = new wb(v30);
                                            ((D2)i50).f(wb3.a, 0, v30, false);
                                            wb3.o(4);
                                            x8 x81 = I9.c(Arrays.asList(Ja.k(wb3, false, false).a), Collections.EMPTY_LIST);
                                            if(x80 == null) {
                                                x82 = x81;
                                            }
                                            else {
                                                if(x81 != null) {
                                                    b[] arr_x8$b = x81.a;
                                                    if(arr_x8$b.length != 0) {
                                                        Object[] arr_object = Arrays.copyOf(x80.a, x80.a.length + arr_x8$b.length);
                                                        System.arraycopy(arr_x8$b, 0, arr_object, x80.a.length, arr_x8$b.length);
                                                        x82 = new x8(((b[])arr_object));
                                                        i93 = new I9(i92.a, i92.b, i92.c, i92.d, i92.e, i92.g, i92.h, i92.j, i92.k, x82);
                                                        break;
                                                    }
                                                }
                                                x82 = x80;
                                            }
                                            i93 = new I9(i92.a, i92.b, i92.c, i92.d, i92.e, i92.g, i92.h, i92.j, i92.k, x82);
                                            break;
                                        }
                                        case 6: {
                                            wb wb4 = new wb(v30);
                                            ((D2)i50).f(wb4.a, 0, v30, false);
                                            wb4.o(4);
                                            int v31 = wb4.p();
                                            String s = wb4.g(wb4.p(), b9.a);
                                            String s1 = wb4.g(wb4.p(), b9.c);
                                            int v32 = wb4.p();
                                            int v33 = wb4.p();
                                            int v34 = wb4.p();
                                            int v35 = wb4.p();
                                            int v36 = wb4.p();
                                            byte[] arr_b7 = new byte[v36];
                                            wb4.j(arr_b7, 0, v36);
                                            List list0 = Collections.singletonList(new j9(v31, s, s1, v32, v33, v34, v35, arr_b7));
                                            x8 x83 = I9.c(Collections.EMPTY_LIST, list0);
                                            if(x80 == null) {
                                                x84 = x83;
                                            }
                                            else {
                                                if(x83 != null) {
                                                    b[] arr_x8$b1 = x83.a;
                                                    if(arr_x8$b1.length != 0) {
                                                        Object[] arr_object1 = Arrays.copyOf(x80.a, x80.a.length + arr_x8$b1.length);
                                                        System.arraycopy(arr_x8$b1, 0, arr_object1, x80.a.length, arr_x8$b1.length);
                                                        x84 = new x8(((b[])arr_object1));
                                                        i93 = new I9(i92.a, i92.b, i92.c, i92.d, i92.e, i92.g, i92.h, i92.j, i92.k, x84);
                                                        break;
                                                    }
                                                }
                                                x84 = x80;
                                            }
                                            i93 = new I9(i92.a, i92.b, i92.c, i92.d, i92.e, i92.g, i92.h, i92.j, i92.k, x84);
                                            break;
                                        }
                                        default: {
                                            ((D2)i50).g(v30);
                                            goto label_224;
                                        }
                                    }
                                }
                                i92 = i93;
                            }
                        label_224:
                            this.i = i92;
                            z3 = z4;
                        }
                        this.i.getClass();
                        this.j = Math.max(this.i.c, 6);
                        this.f.a(this.i.b(arr_b, this.h));
                        this.g = 4;
                        return 0;
                    }
                    default: {
                        long v3 = 0L;
                        switch(v1) {
                            case 4: {
                                ((D2)i50).f = 0;
                                byte[] arr_b1 = new byte[2];
                                ((D2)i50).k(arr_b1, 0, 2, false);
                                int v4 = arr_b1[1] & 0xFF | (arr_b1[0] & 0xFF) << 8;
                                if(v4 >> 2 == 0x3FFE) {
                                    ((D2)i50).f = 0;
                                    this.k = v4;
                                    U5 u50 = this.e;
                                    long v5 = ((D2)i50).d;
                                    long v6 = ((D2)i50).c;
                                    this.i.getClass();
                                    I9 i90 = this.i;
                                    if(i90.k != null) {
                                        k80 = new K8(i90, v5);
                                    }
                                    else if(v6 == -1L || i90.j <= 0L) {
                                        k80 = new K8(i90.e());
                                    }
                                    else {
                                        int v7 = this.k;
                                        int v8 = i90.c;
                                        a a0 = new a(i90, 14);
                                        f1 f10 = new f1(i90, v7);
                                        long v9 = i90.e();
                                        long v10 = i90.j;
                                        int v11 = i90.d;
                                        if(v11 > 0) {
                                            v12 = v10;
                                            v13 = (((long)v11) + ((long)v8)) / 2L + 1L;
                                        }
                                        else {
                                            v12 = v10;
                                            v13 = (i90.a != i90.b || i90.a <= 0 ? 0x1000L : ((long)i90.a)) * ((long)i90.g) * ((long)i90.h) / 8L + 0x40L;
                                        }
                                        r r0 = new r(a0, f10, v9, v12, v5, v6, v13, Math.max(6, v8));  // 初始化器: LB3/k;-><init>(Li/n/i/b/a/s/e/S;Li/n/i/b/a/s/e/U;JJJJJI)V
                                        this.l = r0;
                                        k80 = (Q)r0.b;
                                    }
                                    u50.t(k80);
                                    this.g = 5;
                                    return 0;
                                }
                                ((D2)i50).f = 0;
                                throw new H4("First frame does not start with sync code.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                            }
                            case 5: {
                                this.f.getClass();
                                this.i.getClass();
                                r r1 = this.l;
                                if(r1 != null && ((g)r1.d) != null) {
                                    return r1.b(i50, v0);
                                }
                                if(Long.compare(this.n, -1L) == 0) {
                                    I9 i91 = this.i;
                                    ((D2)i50).f = 0;
                                    ((D2)i50).d(1, false);
                                    byte[] arr_b2 = new byte[1];
                                    ((D2)i50).k(arr_b2, 0, 1, false);
                                    boolean z1 = (arr_b2[0] & 1) == 1;
                                    ((D2)i50).d(2, false);
                                    if(!z1) {
                                        v2 = 6;
                                    }
                                    wb wb0 = new wb(v2);
                                    byte[] arr_b3 = wb0.a;
                                    int v14;
                                    for(v14 = 0; v14 < v2; v14 += v15) {
                                        int v15 = ((D2)i50).m(arr_b3, v14, v2 - v14);
                                        if(v15 == -1) {
                                            break;
                                        }
                                    }
                                    wb0.m(v14);
                                    ((D2)i50).f = 0;
                                    try {
                                        v16 = wb0.c();
                                    }
                                    catch(NumberFormatException unused_ex) {
                                        z = false;
                                        goto label_81;
                                    }
                                    if(!z1) {
                                        v16 *= (long)i91.b;
                                    }
                                    v3 = v16;
                                label_81:
                                    if(!z) {
                                        throw new H4();  // 初始化器: Ljava/io/IOException;-><init>()V
                                    }
                                    this.n = v3;
                                    return 0;
                                }
                                wb wb1 = this.b;
                                int v17 = wb1.c;
                                if(v17 < 0x8000) {
                                    int v18 = ((D2)i50).o(wb1.a, v17, 0x8000 - v17);
                                    if(v18 != -1) {
                                        z = false;
                                        wb1.m(v17 + v18);
                                    }
                                    else if(wb1.d() == 0) {
                                        this.f.f(this.n * 1000000L / ((long)this.i.e), 1, this.m, 0, null);
                                        return -1;
                                    }
                                }
                                else {
                                    z = false;
                                }
                                int v19 = wb1.b;
                                int v20 = this.m;
                                int v21 = this.j;
                                if(v20 < v21) {
                                    wb1.o(Math.min(v21 - v20, wb1.d()));
                                }
                                this.i.getClass();
                                int v22 = wb1.b;
                            alab1:
                                while(true) {
                                    v v23 = this.d;
                                    if(v22 > wb1.c - 16) {
                                        if(z) {
                                            while(true) {
                                                v25 = wb1.c;
                                                if(v22 > v25 - this.j) {
                                                    break;
                                                }
                                                wb1.n(v22);
                                                try {
                                                    z2 = false;
                                                    z2 = Ja.G(wb1, this.i, this.k, v23);
                                                }
                                                catch(IndexOutOfBoundsException unused_ex) {
                                                }
                                                if(wb1.b > wb1.c) {
                                                    z2 = false;
                                                }
                                                if(z2) {
                                                    wb1.n(v22);
                                                    v24 = v23.a;
                                                    break alab1;
                                                }
                                                ++v22;
                                            }
                                            wb1.n(v25);
                                        }
                                        else {
                                            wb1.n(v22);
                                        }
                                        v24 = -1L;
                                        break;
                                    }
                                    wb1.n(v22);
                                    if(Ja.G(wb1, this.i, this.k, v23)) {
                                        wb1.n(v22);
                                        v24 = v23.a;
                                        break;
                                    }
                                    ++v22;
                                }
                                int v26 = wb1.b - v19;
                                wb1.n(v19);
                                this.f.b(v26, wb1);
                                int v27 = this.m + v26;
                                this.m = v27;
                                if(v24 != -1L) {
                                    this.f.f(this.n * 1000000L / ((long)this.i.e), 1, v27, 0, null);
                                    this.m = 0;
                                    this.n = v24;
                                }
                                if(wb1.d() < 16) {
                                    int v28 = wb1.d();
                                    System.arraycopy(wb1.a, wb1.b, wb1.a, 0, v28);
                                    wb1.n(0);
                                    wb1.m(v28);
                                }
                                return 0;
                            }
                            default: {
                                throw new IllegalStateException();
                            }
                        }
                    }
                }
            }
            ((D2)i50).k(arr_b, 0, arr_b.length, false);
            ((D2)i50).f = 0;
            this.g = 2;
            return 0;
        }
        ((D2)i50).f = 0;
        long v37 = ((D2)i50).d();
        x8 x85 = M7.i(i50, !this.c);
        ((D2)i50).g(((int)(((D2)i50).d() - v37)));
        this.h = x85;
        this.g = 1;
        return 0;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void g(U5 u50) {
        this.e = u50;
        this.f = u50.i(0, 1);
        u50.b();
    }
}

