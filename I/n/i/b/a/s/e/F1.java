package i.n.i.b.a.s.e;

import B3.v;

public final class f1 implements U {
    public final I9 a;
    public final int b;
    public final v c;

    public f1(I9 i90, int v) {
        this.a = i90;
        this.b = v;
        this.c = new v();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final long a(i5 i50) {
        I9 i90;
        v v1;
        while(true) {
            int v = Long.compare(i50.d(), i50.a() - 6L);
            v1 = this.c;
            i90 = this.a;
            if(v >= 0) {
                break;
            }
            long v2 = i50.d();
            byte[] arr_b = new byte[2];
            int v3 = 0;
            i50.s(arr_b, 0, 2);
            int v4 = this.b;
            if(((arr_b[0] & 0xFF) << 8 | arr_b[1] & 0xFF) == v4) {
                wb wb0 = new wb(16);
                System.arraycopy(arr_b, 0, wb0.a, 0, 2);
                byte[] arr_b1 = wb0.a;
                while(v3 < 14) {
                    int v5 = i50.m(arr_b1, v3 + 2, 14 - v3);
                    if(v5 == -1) {
                        break;
                    }
                    v3 += v5;
                }
                wb0.m(v3);
                i50.b();
                i50.e(((int)(v2 - i50.getPosition())));
                v3 = Ja.G(wb0, i90, v4, v1);
            }
            else {
                i50.b();
                i50.e(((int)(v2 - i50.getPosition())));
            }
            if(v3 != 0) {
                break;
            }
            i50.e(1);
        }
        if(i50.d() >= i50.a() - 6L) {
            i50.e(((int)(i50.a() - i50.d())));
            return i90.j;
        }
        return v1.a;
    }

    @Override  // i.n.i.b.a.s.e.U
    public final T b(i5 i50, long v) {
        long v1 = i50.getPosition();
        long v2 = this.a(i50);
        long v3 = i50.d();
        i50.e(Math.max(6, this.a.c));
        long v4 = this.a(i50);
        long v5 = i50.d();
        if(v2 <= v && v4 > v) {
            return new T(0, 0x8000000000000001L, v3);
        }
        return v4 > v ? new T(-1, v2, v1) : new T(-2, v4, v5);
    }
}

