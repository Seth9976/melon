package i.n.i.b.a.s.e;

import B3.v;
import G.E0;
import W3.b;
import W3.e;
import W3.f;
import W3.i;
import ea.c;
import java.util.Arrays;

public final class ha implements q4 {
    public U5 a;
    public i b;
    public boolean c;
    public static final p d;

    static {
        ha.d = new p(14);
    }

    public final boolean a(i5 i50) {
        boolean z1;
        f f0 = new f(1);
        if(f0.b(i50, true) && (f0.a & 2) == 2) {
            int v = Math.min(f0.e, 8);
            wb wb0 = new wb(v);
            i50.s(wb0.a, 0, v);
            wb0.n(0);
            if(wb0.d() >= 5 && wb0.z() == 0x7F && wb0.A() == 1179402563L) {
                this.b = new J9(1);  // 初始化器: LW3/i;-><init>(I)V
                return true;
            }
            wb0.n(0);
            try {
                boolean z = false;
                z = Ja.E(1, wb0, true);
            }
            catch(H4 unused_ex) {
            }
            if(z) {
                this.b = new Pd(1);  // 初始化器: LW3/i;-><init>(I)V
                return true;
            }
            wb0.n(0);
            if(wb0.d() < 8) {
                z1 = false;
            }
            else {
                byte[] arr_b = new byte[8];
                wb0.j(arr_b, 0, 8);
                z1 = Arrays.equals(arr_b, Jc.o);
            }
            if(z1) {
                this.b = new Jc(1);  // 初始化器: LW3/i;-><init>(I)V
                return true;
            }
        }
        return false;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void d(long v, long v1) {
        i i0 = this.b;
        if(i0 != null) {
            f f0 = (f)((e)i0.i).d;
            f0.a = 0;
            f0.b = 0L;
            f0.c = 0;
            f0.d = 0;
            f0.e = 0;
            ((wb)((e)i0.i).e).l(0);
            ((e)i0.i).a = -1;
            ((e)i0.i).c = false;
            if(v == 0L) {
                i0.b(!i0.g);
                return;
            }
            if(i0.d != 0) {
                long v2 = ((long)i0.e) * v1 / 1000000L;
                i0.a = v2;
                ((bc)i0.l).a(v2);
                i0.d = 2;
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final boolean e(i5 i50) {
        try {
            return this.a(i50);
        }
        catch(H4 unused_ex) {
            return false;
        }
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final int f(i5 i50, v v0) {
        wb wb1;
        wb wb0;
        M7.G(this.a);
        if(this.b == null) {
            if(!this.a(i50)) {
                throw new H4("Failed to determine bitstream type");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
            }
            ((D2)i50).f = 0;
        }
        if(!this.c) {
            ie ie0 = this.a.i(0, 1);
            this.a.b();
            this.b.k = this.a;
            this.b.j = ie0;
            this.b.b(true);
            this.c = true;
        }
        i i0 = this.b;
        e e0 = (e)i0.i;
        M7.G(((ie)i0.j));
        switch(i0.d) {
            case 0: {
                while(true) {
                    boolean z = e0.b(i50);
                    wb0 = (wb)e0.e;
                    if(!z) {
                        i0.d = 3;
                        return -1;
                    }
                    long v1 = i0.b;
                    i0.f = ((D2)i50).d - v1;
                    if(!i0.c(wb0, v1, ((c)i0.m))) {
                        break;
                    }
                    i0.b = ((D2)i50).d;
                }
                u u0 = (u)((c)i0.m).b;
                i0.e = u0.T;
                if(!i0.h) {
                    ((ie)i0.j).a(u0);
                    i0.h = true;
                }
                E0 e00 = (E0)((c)i0.m).c;
                if(e00 == null) {
                    long v2 = ((D2)i50).c;
                    if(v2 == -1L) {
                        i0.l = new E4(22);
                        wb1 = wb0;
                    }
                    else {
                        f f0 = (f)e0.d;
                        wb1 = wb0;
                        i0.l = new b(i0, i0.b, v2, ((long)(f0.d + f0.e)), f0.b, (f0.a & 4) != 0, false);
                    }
                }
                else {
                    i0.l = e00;
                    wb1 = wb0;
                }
                i0.d = 2;
                byte[] arr_b = wb1.a;
                if(arr_b.length == 0xFE01) {
                    return 0;
                }
                byte[] arr_b1 = Arrays.copyOf(arr_b, Math.max(0xFE01, wb1.c));
                wb1.i(wb1.c, arr_b1);
                return 0;
            }
            case 1: {
                ((D2)i50).g(((int)i0.b));
                i0.d = 2;
                return 0;
            }
            case 2: {
                long v3 = ((bc)i0.l).e(i50);
                if(v3 >= 0L) {
                    v0.a = v3;
                    return 1;
                }
                if(v3 < -1L) {
                    i0.d(-(v3 + 2L));
                }
                if(!i0.g) {
                    sd sd0 = ((bc)i0.l).a();
                    M7.G(sd0);
                    ((U5)i0.k).t(sd0);
                    i0.g = true;
                }
                if(i0.f <= 0L && !e0.b(i50)) {
                    i0.d = 3;
                    return -1;
                }
                i0.f = 0L;
                wb wb2 = (wb)e0.e;
                long v4 = i0.a(wb2);
                if(v4 >= 0L) {
                    long v5 = i0.c;
                    if(v5 + v4 >= i0.a) {
                        long v6 = v5 * 1000000L / ((long)i0.e);
                        ((ie)i0.j).b(wb2.c, wb2);
                        ((ie)i0.j).f(v6, 1, wb2.c, 0, null);
                        i0.a = -1L;
                    }
                }
                i0.c += v4;
                return 0;
            }
            case 3: {
                return -1;
            }
            default: {
                throw new IllegalStateException();
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void g(U5 u50) {
        this.a = u50;
    }
}

