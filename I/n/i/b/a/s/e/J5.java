package i.n.i.b.a.s.e;

import B3.v;
import I.H1;
import android.util.Log;
import org.xmlpull.v1.XmlPullParserException;

public final class j5 implements q4 {
    public final wb a;
    public U5 b;
    public int c;
    public int d;
    public int e;
    public long f;
    public ca g;
    public i5 h;
    public H1 i;
    public s4 j;

    public j5() {
        this.a = new wb(6);
        this.f = -1L;
    }

    public final void a(b[] arr_x8$b) {
        U5 u50 = this.b;
        u50.getClass();
        ie ie0 = u50.i(0x400, 4);
        ob ob0 = new ob();
        ob0.i = new x8(arr_x8$b);
        ie0.a(new u(ob0));
    }

    public final void b() {
        this.a(new b[0]);
        U5 u50 = this.b;
        u50.getClass();
        u50.b();
        this.b.t(new K8(0x8000000000000001L));
        this.c = 6;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void d(long v, long v1) {
        if(v == 0L) {
            this.c = 0;
            this.j = null;
            return;
        }
        if(this.c == 5) {
            s4 s40 = this.j;
            s40.getClass();
            s40.d(v, v1);
        }
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final boolean e(i5 i50) {
        wb wb0 = this.a;
        wb0.l(2);
        i50.s(wb0.a, 0, 2);
        if(wb0.b() == 0xFFD8) {
            wb0.l(2);
            i50.s(wb0.a, 0, 2);
            int v = wb0.b();
            this.d = v;
            if(v == 0xFFE0) {
                wb0.l(2);
                i50.s(wb0.a, 0, 2);
                i50.e(wb0.b() - 2);
                wb0.l(2);
                i50.s(wb0.a, 0, 2);
                this.d = wb0.b();
            }
            if(this.d == 0xFFE1) {
                i50.e(2);
                wb0.l(6);
                i50.s(wb0.a, 0, 6);
                return wb0.A() == 1165519206L && wb0.b() == 0;
            }
        }
        return false;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final int f(i5 i50, v v0) {
        ca ca0;
        long v11;
        H1 h10;
        int v1 = this.c;
        wb wb0 = this.a;
        switch(v1) {
            case 0: {
                wb0.l(2);
                ((D2)i50).f(wb0.a, 0, 2, false);
                int v2 = wb0.b();
                this.d = v2;
                if(v2 == 0xFFDA) {
                    if(this.f != -1L) {
                        this.c = 4;
                        return 0;
                    }
                    this.b();
                    return 0;
                }
                if((v2 < 0xFFD0 || v2 > 0xFFD9) && v2 != 0xFF01) {
                    this.c = 1;
                }
                return 0;
            }
            case 1: {
                wb0.l(2);
                ((D2)i50).f(wb0.a, 0, 2, false);
                this.e = wb0.b() - 2;
                this.c = 2;
                return 0;
            }
            case 2: {
                if(this.d == 0xFFE1) {
                    wb wb1 = new wb(this.e);
                    ((D2)i50).f(wb1.a, 0, this.e, false);
                    if(this.g == null && "http://ns.adobe.com/xap/1.0/".equals(wb1.x())) {
                        String s = wb1.x();
                        if(s != null) {
                            long v3 = ((D2)i50).c;
                            if(v3 == -1L) {
                                ca0 = null;
                            }
                            else {
                                try {
                                    h10 = Ja.R(s);
                                }
                                catch(XmlPullParserException | H4 | NumberFormatException unused_ex) {
                                    Log.w("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
                                    h10 = null;
                                }
                                if(h10 == null) {
                                    ca0 = null;
                                }
                                else {
                                    c5 c50 = (c5)h10.c;
                                    int v4 = c50.d;
                                    if(v4 >= 2) {
                                        int v5 = v4 - 1;
                                        long v6 = -1L;
                                        long v7 = -1L;
                                        long v8 = -1L;
                                        long v9 = -1L;
                                        for(boolean z = false; v5 >= 0; z = v10) {
                                            V5 v50 = (V5)c50.get(v5);
                                            int v10 = "video/mp4".equals(v50.a) | z;
                                            if(v5 == 0) {
                                                v3 -= v50.c;
                                                v11 = 0L;
                                            }
                                            else {
                                                v11 = v3 - v50.b;
                                            }
                                            long v12 = v3;
                                            v3 = v11;
                                            if(v10 != 0 && v3 != v12) {
                                                v9 = v12 - v3;
                                                v8 = v3;
                                                v10 = 0;
                                            }
                                            if(v5 == 0) {
                                                v6 = v3;
                                                v7 = v12;
                                            }
                                            --v5;
                                        }
                                        ca0 = v8 == -1L || v9 == -1L || v6 == -1L || v7 == -1L ? null : new ca(v6, v7, h10.b, v8, v9);
                                    }
                                    else {
                                        ca0 = null;
                                    }
                                }
                            }
                            this.g = ca0;
                            if(ca0 != null) {
                                this.f = ca0.d;
                            }
                        }
                    }
                }
                else {
                    ((D2)i50).g(this.e);
                }
                this.c = 0;
                return 0;
            }
            case 4: {
                long v13 = this.f;
                if(((D2)i50).d != v13) {
                    v0.a = v13;
                    return 1;
                }
                if(!((D2)i50).k(wb0.a, 0, 1, true)) {
                    this.b();
                    return 0;
                }
                ((D2)i50).f = 0;
                if(this.j == null) {
                    this.j = new s4(0);
                }
                H1 h11 = new H1(i50, this.f);
                this.i = h11;
                this.j.getClass();
                if(Ja.F(h11, false, false)) {
                    s4 s40 = this.j;
                    long v14 = this.f;
                    U5 u50 = this.b;
                    u50.getClass();
                    s40.q = new H1(v14, u50, 8);
                    ca ca1 = this.g;
                    ca1.getClass();
                    this.a(new b[]{ca1});
                    this.c = 5;
                    return 0;
                }
                this.b();
                return 0;
            }
            case 5: {
                if(this.i == null || i50 != this.h) {
                    this.h = i50;
                    this.i = new H1(i50, this.f);
                }
                s4 s41 = this.j;
                s41.getClass();
                int v15 = s41.f(this.i, v0);
                if(v15 == 1) {
                    v0.a += this.f;
                }
                return v15;
            }
            default: {
                if(v1 != 6) {
                    throw new IllegalStateException();
                }
                return -1;
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void g(U5 u50) {
        this.b = u50;
    }
}

