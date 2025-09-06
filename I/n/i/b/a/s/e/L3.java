package i.n.i.b.a.s.e;

import B3.v;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class l3 implements q4 {
    public final wb a;
    public final wb b;
    public final wb c;
    public final wb d;
    public final W3 e;
    public U5 f;
    public int g;
    public boolean h;
    public long i;
    public int j;
    public int k;
    public int l;
    public long m;
    public boolean n;
    public E2 o;
    public L4 p;
    public static final p q;

    static {
        l3.q = new p(7);
    }

    public l3() {
        this.a = new wb(4);
        this.b = new wb(9);
        this.c = new wb(11);
        this.d = new wb(1, false);
        W3 w30 = new W3(new V3());  // 初始化器: LBf/a;-><init>(Ljava/lang/Object;)V
        w30.b = 0x8000000000000001L;
        w30.c = new long[0];
        w30.d = new long[0];
        this.e = w30;
        this.g = 1;
    }

    public final wb a(i5 i50) {
        int v = this.l;
        wb wb0 = this.d;
        byte[] arr_b = wb0.a;
        if(v > arr_b.length) {
            wb0.i(0, new byte[Math.max(arr_b.length * 2, v)]);
        }
        else {
            wb0.n(0);
        }
        wb0.m(this.l);
        i50.q(wb0.a, 0, this.l);
        return wb0;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void d(long v, long v1) {
        if(Long.compare(v, 0L) == 0) {
            this.g = 1;
            this.h = false;
        }
        else {
            this.g = 3;
        }
        this.j = 0;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final boolean e(i5 i50) {
        wb wb0 = this.a;
        i50.s(wb0.a, 0, 3);
        wb0.n(0);
        if(wb0.B() == 4607062) {
            i50.s(wb0.a, 0, 2);
            wb0.n(0);
            if((wb0.b() & 0xFA) == 0) {
                i50.s(wb0.a, 0, 4);
                wb0.n(0);
                int v = wb0.p();
                i50.b();
                i50.e(v);
                i50.s(wb0.a, 0, 4);
                wb0.n(0);
                return wb0.p() == 0;
            }
        }
        return false;
    }

    // This method was un-flattened
    @Override  // i.n.i.b.a.s.e.q4
    public final int f(i5 i50, v v0) {
        int v23;
        boolean z;
        int v8;
        long v3;
        long v2;
        wb wb7;
        boolean z1;
        M7.G(this.f);
        while(true) {
            int v1 = this.g;
            if(v1 == 1) {
                z1 = false;
                wb7 = this.b;
                if(!((D2)i50).f(wb7.a, 0, 9, true)) {
                    return -1;
                }
                goto label_207;
            }
            else {
                switch(v1) {
                    case 2: {
                        ((D2)i50).g(this.j);
                        this.j = 0;
                        this.g = 3;
                        continue;
                    }
                    case 3: {
                        wb wb0 = this.c;
                        if(((D2)i50).f(wb0.a, 0, 11, true)) {
                            wb0.n(0);
                            this.k = wb0.z();
                            this.l = wb0.B();
                            this.m = (long)wb0.B();
                            this.m = (((long)(wb0.z() << 24)) | this.m) * 1000L;
                            wb0.o(3);
                            this.g = 4;
                            continue;
                        }
                        break;
                    }
                    case 4: {
                        W3 w30 = this.e;
                        if(this.h) {
                            v2 = this.i + this.m;
                        }
                        else if(w30.b == 0x8000000000000001L) {
                            v3 = 0L;
                            goto label_28;
                        }
                        else {
                            v2 = this.m;
                        }
                        v3 = v2;
                    label_28:
                        int v4 = this.k;
                        if(v4 == 8 && this.o != null) {
                            if(!this.n) {
                                this.f.t(new K8(0x8000000000000001L));
                                this.n = true;
                            }
                            E2 e20 = this.o;
                            wb wb1 = this.a(i50);
                            ie ie0 = (ie)e20.a;
                            if(e20.b) {
                                wb1.o(1);
                            }
                            else {
                                int v5 = wb1.z();
                                int v6 = v5 >> 4 & 15;
                                e20.d = v6;
                                if(v6 == 2) {
                                    int v7 = E2.e[v5 >> 2 & 3];
                                    ob ob0 = new ob();
                                    ob0.k = "audio/mpeg";
                                    ob0.x = 1;
                                    ob0.y = v7;
                                    ie0.a(new u(ob0));
                                    e20.c = true;
                                }
                                else {
                                    switch(v6) {
                                        case 7: 
                                        case 8: {
                                            ob ob1 = new ob();
                                            ob1.k = v6 == 7 ? "audio/g711-alaw" : "audio/g711-mlaw";
                                            ob1.x = 1;
                                            ob1.y = 8000;
                                            ie0.a(new u(ob1));
                                            e20.c = true;
                                            break;
                                        }
                                        case 10: {
                                            break;
                                        }
                                        default: {
                                            throw new N("Audio format not supported: " + e20.d);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                                        }
                                    }
                                }
                                e20.b = true;
                            }
                            ie ie1 = (ie)e20.a;
                            v8 = 1;
                            if(e20.d == 2) {
                                int v9 = wb1.d();
                                ie1.b(v9, wb1);
                                ((ie)e20.a).f(v3, 1, v9, 0, null);
                            }
                            else {
                                int v10 = wb1.z();
                                if(v10 == 0 && !e20.c) {
                                    int v11 = wb1.d();
                                    byte[] arr_b = new byte[v11];
                                    wb1.j(arr_b, 0, v11);
                                    h1 h10 = Ja.l(new B3.N(arr_b, v11, 6, 0), false);
                                    ob ob2 = new ob();
                                    ob2.k = "audio/mp4a-latm";
                                    ob2.h = (String)h10.c;
                                    ob2.x = h10.b;
                                    ob2.y = h10.a;
                                    ob2.m = Collections.singletonList(arr_b);
                                    ie1.a(new u(ob2));
                                    e20.c = true;
                                }
                                else if(e20.d != 10 || v10 == 1) {
                                    int v12 = wb1.d();
                                    ie1.b(v12, wb1);
                                    ((ie)e20.a).f(v3, 1, v12, 0, null);
                                    goto label_88;
                                }
                                v8 = 0;
                            }
                        label_88:
                            z = true;
                        }
                        else if(v4 == 9 && this.p != null) {
                            if(!this.n) {
                                this.f.t(new K8(0x8000000000000001L));
                                this.n = true;
                            }
                            L4 l40 = this.p;
                            wb wb2 = this.a(i50);
                            l40.getClass();
                            int v13 = wb2.z();
                            int v14 = v13 >> 4 & 15;
                            int v15 = v13 & 15;
                            if(v15 != 7) {
                                throw new N("Video format not supported: " + v15);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                            }
                            l40.g = v14;
                            if(v14 == 5) {
                            label_148:
                                v23 = 0;
                            }
                            else {
                                wb wb3 = l40.b;
                                ie ie2 = (ie)l40.a;
                                wb wb4 = l40.c;
                                int v16 = wb2.z();
                                int v17 = wb2.b;
                                wb2.b = v17 + 3;
                                long v18 = ((long)((wb2.a[v17] & 0xFF) << 24 >> 8 | (wb2.a[v17 + 1] & 0xFF) << 8 | wb2.a[v17 + 2] & 0xFF)) * 1000L + v3;
                                if(v16 == 0 && !l40.e) {
                                    byte[] arr_b1 = new byte[wb2.d()];
                                    wb wb5 = new wb(arr_b1);
                                    wb2.j(arr_b1, 0, wb2.d());
                                    Pb pb0 = Pb.a(wb5);
                                    l40.d = pb0.b;
                                    ob ob3 = new ob();
                                    ob3.k = "video/avc";
                                    ob3.h = pb0.f;
                                    ob3.p = pb0.c;
                                    ob3.q = pb0.d;
                                    ob3.t = pb0.e;
                                    ob3.m = pb0.a;
                                    ie2.a(new u(ob3));
                                    l40.e = true;
                                    goto label_148;
                                }
                                else if(v16 == 1 && l40.e) {
                                    int v19 = l40.g == 1 ? 1 : 0;
                                    if(l40.f || v19 != 0) {
                                        byte[] arr_b2 = wb4.a;
                                        arr_b2[0] = 0;
                                        arr_b2[1] = 0;
                                        arr_b2[2] = 0;
                                        int v20 = 4 - l40.d;
                                        int v21;
                                        for(v21 = 0; wb2.d() > 0; v21 = v21 + 4 + v22) {
                                            wb2.j(wb4.a, v20, l40.d);
                                            wb4.n(0);
                                            int v22 = wb4.C();
                                            wb3.n(0);
                                            ie2.b(4, wb3);
                                            ie2.b(v22, wb2);
                                        }
                                        ((ie)l40.a).f(v18, v19, v21, 0, null);
                                        l40.f = true;
                                        v23 = 1;
                                    }
                                }
                            }
                            v8 = v23;
                            z = true;
                        }
                        else if(v4 == 18 && !this.n) {
                            wb wb6 = this.a(i50);
                            w30.getClass();
                            w30.getClass();
                            if(wb6.z() == 2 && "onMetaData".equals(W3.t1(wb6)) && wb6.z() == 8) {
                                HashMap hashMap0 = W3.s1(wb6);
                                Object object0 = hashMap0.get("duration");
                                if(object0 instanceof Double) {
                                    double f = (double)(((Double)object0));
                                    if(f > 0.0) {
                                        w30.b = (long)(f * 1000000.0);
                                    }
                                }
                                Object object1 = hashMap0.get("keyframes");
                                if(object1 instanceof Map) {
                                    Object object2 = ((Map)object1).get("filepositions");
                                    Object object3 = ((Map)object1).get("times");
                                    if(object2 instanceof List && object3 instanceof List) {
                                        List list0 = (List)object2;
                                        List list1 = (List)object3;
                                        int v24 = list1.size();
                                        w30.c = new long[v24];
                                        w30.d = new long[v24];
                                        int v25 = 0;
                                        while(v25 < v24) {
                                            Object object4 = list0.get(v25);
                                            Object object5 = list1.get(v25);
                                            if(object5 instanceof Double && object4 instanceof Double) {
                                                w30.c[v25] = (long)(((double)(((Double)object5))) * 1000000.0);
                                                w30.d[v25] = ((Double)object4).longValue();
                                                ++v25;
                                            }
                                            else {
                                                w30.c = new long[0];
                                                w30.d = new long[0];
                                                if(true) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            long v26 = w30.b;
                            if(v26 != 0x8000000000000001L) {
                                this.f.t(new Zb(v26, w30.d, w30.c));
                                this.n = true;
                            }
                            v8 = 0;
                            z = true;
                        }
                        else {
                            ((D2)i50).g(this.l);
                            z = false;
                            v8 = 0;
                        }
                        if(!this.h && v8 != 0) {
                            this.h = true;
                            this.i = w30.b == 0x8000000000000001L ? -this.m : 0L;
                        }
                        this.j = 4;
                        this.g = 2;
                        if(!z) {
                            continue;
                        }
                        return 0;
                    }
                    default: {
                        throw new IllegalStateException();
                    }
                }
            }
            return -1;
        label_207:
            wb7.n(0);
            wb7.o(4);
            int v27 = wb7.z();
            if((v27 & 1) != 0) {
                z1 = true;
            }
            if((v27 & 4) != 0 && this.o == null) {
                this.o = new E2(this.f.i(8, 1));  // 初始化器: LBf/a;-><init>(Ljava/lang/Object;)V
            }
            if(z1 && this.p == null) {
                this.p = new L4(this.f.i(9, 2));
            }
            this.f.b();
            this.j = wb7.p() - 5;
            this.g = 2;
        }
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void g(U5 u50) {
        this.f = u50;
    }
}

