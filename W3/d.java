package w3;

import java.util.Arrays;

public final class d {
    public final boolean a;
    public final int b;
    public int c;
    public int d;
    public int e;
    public a[] f;

    public d() {
        this.a = true;
        this.b = 0x10000;
        this.e = 0;
        this.f = new a[100];
    }

    public final void a(int v) {
        synchronized(this) {
            boolean z = v < this.c;
            this.c = v;
            if(z) {
                this.b();
            }
        }
    }

    public final void b() {
        synchronized(this) {
            int v1 = Math.max(0, (this.c + this.b - 1) / this.b - this.d);
            int v2 = this.e;
            if(v1 >= v2) {
                return;
            }
            Arrays.fill(this.f, v1, v2, null);
            this.e = v1;
        }
    }
}

