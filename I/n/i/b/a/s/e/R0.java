package i.n.i.b.a.s.e;

import B3.g;
import B3.v;
import B7.b;
import P.z;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import d5.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class r0 implements q4, sd {
    public final int a;
    public final List b;
    public final wb c;
    public final SparseIntArray d;
    public final z e;
    public final SparseArray f;
    public final SparseBooleanArray g;
    public final SparseBooleanArray h;
    public final X i;
    public r j;
    public U5 k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public k1 p;
    public int q;
    public int r;
    public final long s;
    public static final p t;
    public static final p u;

    static {
        r0.t = new p(3);
        r0.u = new p(4);
    }

    public r0(int v) {
        this(v, new r6(0L), new z(0, c5.e));
    }

    public r0(int v, r6 r60, z z0) {
        this.e = z0;
        this.a = v;
        if(v == 1 || v == 2 || v == 3) {
            this.b = Collections.singletonList(r60);
        }
        else {
            ArrayList arrayList0 = new ArrayList();
            this.b = arrayList0;
            arrayList0.add(r60);
        }
        this.c = new wb(new byte[9400], 0);
        this.g = new SparseBooleanArray();
        this.h = new SparseBooleanArray();
        this.f = new SparseArray();
        this.d = new SparseIntArray();
        this.i = new X(0);
        this.r = -1;
        this.a();
        this.s = 0x8000000000000001L;
    }

    public final void a() {
        this.g.clear();
        SparseArray sparseArray0 = this.f;
        sparseArray0.clear();
        this.e.getClass();
        SparseArray sparseArray1 = new SparseArray();
        int v = sparseArray1.size();
        for(int v1 = 0; v1 < v; ++v1) {
            sparseArray0.put(sparseArray1.keyAt(v1), ((k1)sparseArray1.valueAt(v1)));
        }
        sparseArray0.put(0, new Qd(new l(this)));
        this.p = null;
    }

    @Override  // i.n.i.b.a.s.e.sd
    public final rd b(long v) {
        return new rd(Nd.c, Nd.c);
    }

    @Override  // i.n.i.b.a.s.e.sd
    public final boolean b() {
        return this.s != 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.sd
    public final long d() {
        return this.s;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void d(long v, long v1) {
        SparseArray sparseArray0 = this.f;
        List list0 = this.b;
        M7.J(this.a != 2);
        int v2 = list0.size();
        if(this.a != 3 && !this.b()) {
            for(int v3 = 0; v3 < v2; ++v3) {
                r6 r60 = (r6)list0.get(v3);
                if(r60.c() == 0x8000000000000001L || r60.c() != 0L && r60.b != v1) {
                    synchronized(r60) {
                        r60.b = v1;
                        r60.d = 0x8000000000000001L;
                        r60.a = false;
                    }
                }
            }
        }
        if(v1 != 0L) {
            r r0 = this.j;
            if(r0 != null) {
                r0.c(v1);
            }
        }
        this.c.l(0);
        this.d.clear();
        for(int v4 = 0; v4 < sparseArray0.size(); ++v4) {
            ((k1)sparseArray0.valueAt(v4)).a();
        }
        this.q = 0;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final boolean e(i5 i50) {
        byte[] arr_b = this.c.a;
        i50.s(arr_b, 0, 9400);
        int v = 0;
    label_3:
        while(v < 0xBC) {
            int v1 = 0;
            while(v1 < 50) {
                if(arr_b[v1 * 0xBC + v] == 71) {
                    ++v1;
                    continue;
                }
                ++v;
                continue label_3;
            }
            i50.a(v);
            return true;
        }
        return false;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final int f(i5 i50, v v0) {
        long v1 = ((D2)i50).c;
        int v2 = this.a;
        if(this.m) {
            long v3 = 0x8000000000000001L;
            X x0 = this.i;
            if(Long.compare(v1, -1L) != 0 && v2 != 2 && !x0.d) {
                int v4 = this.r;
                r6 r60 = x0.b;
                wb wb0 = x0.c;
                if(v4 <= 0) {
                    x0.b(i50);
                    return 0;
                }
                if(!x0.f) {
                    int v5 = (int)Math.min(112800L, ((D2)i50).c);
                    long v6 = ((D2)i50).c - ((long)v5);
                    if(((D2)i50).d != v6) {
                        v0.a = v6;
                        return 1;
                    }
                    wb0.l(v5);
                    ((D2)i50).f = 0;
                    ((D2)i50).k(wb0.a, 0, v5, false);
                    int v7 = wb0.b;
                    for(int v8 = wb0.c - 1; v8 >= v7; --v8) {
                        if(wb0.a[v8] == 71) {
                            long v9 = Ja.i(wb0, v8, v4);
                            if(v9 != 0x8000000000000001L) {
                                v3 = v9;
                                break;
                            }
                        }
                    }
                    x0.h = v3;
                    x0.f = true;
                    return 0;
                }
                if(x0.h == 0x8000000000000001L) {
                    x0.b(i50);
                    return 0;
                }
                if(!x0.e) {
                    int v10 = (int)Math.min(112800L, ((D2)i50).c);
                    if(((D2)i50).d != 0L) {
                        v0.a = 0L;
                        return 1;
                    }
                    wb0.l(v10);
                    ((D2)i50).f = 0;
                    ((D2)i50).k(wb0.a, 0, v10, false);
                    int v11 = wb0.b;
                    int v12 = wb0.c;
                    while(v11 < v12) {
                        if(wb0.a[v11] == 71) {
                            long v13 = Ja.i(wb0, v11, v4);
                            if(v13 != 0x8000000000000001L) {
                                v3 = v13;
                                break;
                            }
                        }
                        ++v11;
                    }
                    x0.g = v3;
                    x0.e = true;
                    return 0;
                }
                long v14 = x0.g;
                if(v14 == 0x8000000000000001L) {
                    x0.b(i50);
                    return 0;
                }
                long v15 = r60.b(v14);
                x0.i = r60.b(x0.h) - v15;
                x0.b(i50);
                return 0;
            }
            if(!this.n) {
                this.n = true;
                long v16 = x0.i;
                if(v16 == 0x8000000000000001L) {
                    this.k.t(new K8(0x8000000000000001L));
                }
                else {
                    int v17 = this.r;
                    E4 e40 = new E4(5);
                    b b0 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b0.a = v17;
                    b0.b = x0.b;
                    b0.c = new wb(1, false);
                    r r0 = new r(e40, b0, v16, v16 + 1L, 0L, v1, 0xBCL, 940);  // 初始化器: LB3/k;-><init>(Li/n/i/b/a/s/e/S;Li/n/i/b/a/s/e/U;JJJJJI)V
                    this.j = r0;
                    this.k.t(((Q)r0.b));
                }
            }
            if(this.o) {
                this.o = false;
                this.d(0L, 0L);
                if(((D2)i50).d != 0L) {
                    v0.a = 0L;
                    return 1;
                }
            }
            r r1 = this.j;
            if(r1 != null && ((g)r1.d) != null) {
                return r1.b(i50, v0);
            }
        }
        wb wb1 = this.c;
        byte[] arr_b = wb1.a;
        if(9400 - wb1.b < 0xBC) {
            int v18 = wb1.d();
            if(v18 > 0) {
                System.arraycopy(arr_b, wb1.b, arr_b, 0, v18);
            }
            wb1.i(v18, arr_b);
        }
        while(wb1.d() < 0xBC) {
            int v19 = wb1.c;
            int v20 = ((D2)i50).o(arr_b, v19, 9400 - v19);
            if(v20 == -1) {
                return -1;
            }
            wb1.m(v19 + v20);
        }
        int v21 = wb1.b;
        int v22 = wb1.c;
        byte[] arr_b1 = wb1.a;
        int v23;
        for(v23 = v21; v23 < v22 && arr_b1[v23] != 71; ++v23) {
        }
        wb1.n(v23);
        if(v23 + 0xBC > v22) {
            int v24 = v23 - v21 + this.q;
            this.q = v24;
            if((v2 == 2 || v2 == 3) && v24 > 376) {
                throw new H4("Cannot find sync byte. Most likely not a Transport Stream.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
            }
        }
        else {
            this.q = 0;
        }
        k1 k10 = null;
        SparseIntArray sparseIntArray0 = this.d;
        if(v23 + 0xBC == 0xFFFFFF85) {
            Log.d("TsExtractor", "Malformed segment skip : " + ((D2)i50).d);
            wb1.l(0);
            sparseIntArray0.clear();
            this.a();
            this.q = 0;
            if(v2 == 3) {
                throw null;
            }
            return -1;
        }
        int v25 = wb1.c;
        if(v23 + 0xBC > v25) {
            return 0;
        }
        int v26 = wb1.p();
        if((0x800000 & v26) != 0) {
            wb1.n(v23 + 0xBC);
            return 0;
        }
        int v27 = (0x400000 & v26) == 0 ? 0 : 1;
        int v28 = (0x1FFF00 & v26) >> 8;
        if((v26 & 16) != 0) {
            k10 = (k1)this.f.get(v28);
        }
        if(k10 == null) {
            wb1.n(v23 + 0xBC);
            return 0;
        }
        if(v2 != 2) {
            int v29 = sparseIntArray0.get(v28, (v26 & 15) - 1);
            sparseIntArray0.put(v28, v26 & 15);
            if(v29 == (v26 & 15)) {
                wb1.n(v23 + 0xBC);
                return 0;
            }
            if((v26 & 15) != (v29 + 1 & 15)) {
                k10.a();
            }
        }
        if((v26 & 0x20) != 0) {
            int v30 = wb1.z();
            v27 |= ((wb1.z() & 0x40) == 0 ? 0 : 2);
            wb1.o(v30 - 1);
        }
        boolean z = this.m;
        if(v2 == 2 || z || !this.h.get(v28, false)) {
            wb1.m(v23 + 0xBC);
            k10.c(v27, wb1);
            wb1.m(v25);
        }
        if(v2 != 2 && !z && this.m && v1 != -1L) {
            this.o = true;
        }
        wb1.n(v23 + 0xBC);
        return 0;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void g(U5 u50) {
        this.k = u50;
    }
}

