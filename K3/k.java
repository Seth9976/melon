package k3;

import androidx.media3.exoplayer.V;
import e3.x;
import i.n.i.b.a.s.e.I2;
import java.util.concurrent.CopyOnWriteArrayList;
import s3.z;

public final class k {
    public final int a;
    public final z b;
    public final CopyOnWriteArrayList c;

    public k(CopyOnWriteArrayList copyOnWriteArrayList0, int v, z z0) {
        this.c = copyOnWriteArrayList0;
        this.a = v;
        this.b = z0;
    }

    public final void a() {
        for(Object object0: this.c) {
            x.P(((j)object0).a, new i(this, ((l)((j)object0).b), 1));
        }
    }

    public final void b() {
        for(Object object0: this.c) {
            x.P(((j)object0).a, new i(this, ((l)((j)object0).b), 0));
        }
    }

    public final void c(int v) {
        for(Object object0: this.c) {
            x.P(((j)object0).a, new V(this, ((j)object0).b, v, 8));
        }
    }

    public final void d(Exception exception0) {
        for(Object object0: this.c) {
            x.P(((j)object0).a, new I2(this, ((j)object0).b, exception0, 5));
        }
    }

    public final void e() {
        for(Object object0: this.c) {
            x.P(((j)object0).a, new i(this, ((l)((j)object0).b), 2));
        }
    }
}

