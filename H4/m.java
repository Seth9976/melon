package h4;

import B3.L;
import e3.b;

public final class m {
    public boolean a;
    public boolean b;
    public boolean c;
    public int d;
    public int e;
    public long f;
    public long g;
    public final Object h;

    public m(Object object0) {
        this.h = object0;
        super();
    }

    public void a(byte[] arr_b, int v, int v1) {
        if(this.b) {
            int v2 = this.e;
            int v3 = v + 1 - v2;
            if(v3 < v1) {
                this.c = (arr_b[v3] & 0xC0) >> 6 == 0;
                this.b = false;
                return;
            }
            this.e = v1 - v + v2;
        }
    }

    public void b(byte[] arr_b, int v, int v1) {
        if(this.b) {
            int v2 = this.e;
            int v3 = v + 1 - v2;
            if(v3 < v1) {
                this.c = (arr_b[v3] & 0xC0) >> 6 == 0;
                this.b = false;
                return;
            }
            this.e = v1 - v + v2;
        }
    }

    public void c(long v, int v1, boolean z) {
        b.j(this.g != 0x8000000000000001L);
        if(this.d == 0xB6 && z && this.a) {
            ((L)this.h).c(this.g, ((int)this.c), ((int)(v - this.f)), v1, null);
        }
        if(this.d != 0xB3) {
            this.f = v;
        }
    }
}

