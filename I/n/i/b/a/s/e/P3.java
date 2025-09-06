package i.n.i.b.a.s.e;

public final class p3 {
    public final ie a;
    public final w7 b;
    public final wb c;
    public U7 d;
    public b2 e;
    public int f;
    public int g;
    public int h;
    public int i;
    public final wb j;
    public final wb k;
    public boolean l;
    public long m;

    public p3(ie ie0, U7 u70, b2 b20) {
        this.a = ie0;
        this.d = u70;
        this.e = b20;
        this.b = new w7();
        this.c = new wb(1, false);
        this.j = new wb(1);
        this.k = new wb(1, false);
        this.m = -1L;
        this.d = u70;
        this.e = b20;
        ie0.a(u70.a.f);
        this.d();
    }

    public final int a(int v, int v1) {
        wb wb0;
        a7 a70 = this.b();
        if(a70 == null) {
            return 0;
        }
        int v2 = a70.d;
        w7 w70 = this.b;
        if(v2 == 0) {
            this.k.i(a70.e.length, a70.e);
            v2 = a70.e.length;
            wb0 = this.k;
        }
        else {
            wb0 = w70.o;
        }
        boolean z = w70.l && w70.m[this.f];
        boolean z1 = z || v1 != 0;
        this.j.a[0] = (byte)((z1 ? 0x80 : 0) | v2);
        this.j.n(0);
        ie ie0 = this.a;
        ie0.c(1, this.j);
        ie0.c(v2, wb0);
        if(!z1) {
            return v2 + 1;
        }
        wb wb1 = this.c;
        if(!z) {
            wb1.l(8);
            byte[] arr_b = wb1.a;
            arr_b[0] = 0;
            arr_b[1] = 1;
            arr_b[2] = 0;
            arr_b[3] = (byte)(v1 & 0xFF);
            arr_b[4] = (byte)(v >> 24 & 0xFF);
            arr_b[5] = (byte)(v >> 16 & 0xFF);
            arr_b[6] = (byte)(v >> 8 & 0xFF);
            arr_b[7] = (byte)(v & 0xFF);
            ie0.c(8, wb1);
            return v2 + 9;
        }
        wb wb2 = w70.o;
        int v3 = wb2.b();
        wb2.o(-2);
        int v4 = v3 * 6 + 2;
        if(v1 == 0) {
            wb1 = wb2;
        }
        else {
            wb1.l(v4);
            byte[] arr_b1 = wb1.a;
            wb2.j(arr_b1, 0, v4);
            int v5 = ((arr_b1[2] & 0xFF) << 8 | arr_b1[3] & 0xFF) + v1;
            arr_b1[2] = (byte)(v5 >> 8 & 0xFF);
            arr_b1[3] = (byte)(v5 & 0xFF);
        }
        ie0.c(v4, wb1);
        return v2 + 1 + v4;
    }

    public final a7 b() {
        if(this.l) {
            int v = this.b.a.a;
            a7 a70 = this.b.n;
            if(a70 == null) {
                a7[] arr_a7 = this.d.a.k;
                a70 = arr_a7 == null ? null : arr_a7[v];
            }
            return a70 == null || !a70.a ? null : a70;
        }
        return null;
    }

    public final boolean c() {
        ++this.f;
        if(!this.l) {
            return false;
        }
        int v = this.g + 1;
        this.g = v;
        int v1 = this.h;
        if(v == this.b.g[v1]) {
            this.h = v1 + 1;
            this.g = 0;
            return false;
        }
        return true;
    }

    public final void d() {
        this.b.d = 0;
        this.b.q = 0L;
        this.b.r = false;
        this.b.l = false;
        this.b.p = false;
        this.b.n = null;
        this.f = 0;
        this.h = 0;
        this.g = 0;
        this.i = 0;
        this.l = false;
    }
}

