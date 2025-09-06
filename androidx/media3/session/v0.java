package androidx.media3.session;

import com.google.firebase.messaging.u;

public final class V0 implements Runnable {
    public final f1 a;
    public final w0 b;
    public final s1 c;
    public final int d;
    public final int e;
    public final e1 f;
    public final n0 g;

    public V0(f1 f10, w0 w00, s1 s10, int v, int v1, e1 e10, n0 n00) {
        this.a = f10;
        this.b = w00;
        this.c = s10;
        this.d = v;
        this.e = v1;
        this.f = e10;
        this.g = n00;
    }

    @Override
    public final void run() {
        u u0 = this.a.c;
        w0 w00 = this.b;
        if(!u0.s(w00)) {
            return;
        }
        s1 s10 = this.c;
        int v = this.d;
        if(s10 != null) {
            if(!u0.v(w00, s10)) {
                f1.J0(w00, v, new w1(-4));
                return;
            }
        }
        else if(!u0.u(w00, this.e)) {
            f1.J0(w00, v, new w1(-4));
            return;
        }
        this.f.e(this.g, w00, v);
    }
}

