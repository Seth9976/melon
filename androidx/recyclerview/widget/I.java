package androidx.recyclerview.widget;

public final class i implements a0 {
    public final a0 a;
    public int b;
    public int c;
    public int d;
    public Object e;

    public i(a0 a00) {
        this.b = 0;
        this.c = -1;
        this.d = -1;
        this.e = null;
        this.a = a00;
    }

    public final void a() {
        int v = this.b;
        if(v == 0) {
            return;
        }
        a0 a00 = this.a;
        switch(v) {
            case 1: {
                a00.e(this.c, this.d);
                break;
            }
            case 2: {
                a00.i(this.c, this.d);
                break;
            }
            case 3: {
                a00.q(this.c, this.d, this.e);
            }
        }
        this.e = null;
        this.b = 0;
    }

    @Override  // androidx.recyclerview.widget.a0
    public final void e(int v, int v1) {
        if(this.b == 1) {
            int v2 = this.c;
            if(v >= v2) {
                int v3 = this.d;
                if(v <= v2 + v3) {
                    this.d = v3 + v1;
                    this.c = Math.min(v, v2);
                    return;
                }
            }
        }
        this.a();
        this.c = v;
        this.d = v1;
        this.b = 1;
    }

    @Override  // androidx.recyclerview.widget.a0
    public final void i(int v, int v1) {
        if(this.b == 2 && (this.c >= v && this.c <= v + v1)) {
            this.d += v1;
            this.c = v;
            return;
        }
        this.a();
        this.c = v;
        this.d = v1;
        this.b = 2;
    }

    @Override  // androidx.recyclerview.widget.a0
    public final void q(int v, int v1, Object object0) {
        if(this.b == 3) {
            int v2 = this.c;
            int v3 = this.d + v2;
            if(v <= v3) {
                int v4 = v + v1;
                if(v4 >= v2 && this.e == object0) {
                    this.c = Math.min(v, v2);
                    this.d = Math.max(v3, v4) - this.c;
                    return;
                }
            }
        }
        this.a();
        this.c = v;
        this.d = v1;
        this.e = object0;
        this.b = 3;
    }

    @Override  // androidx.recyclerview.widget.a0
    public final void s(int v, int v1) {
        this.a();
        this.a.s(v, v1);
    }
}

