package i.n.i.b.a.s.e;

import android.net.Uri;
import h9.d;
import java.util.Map;

public final class jd extends Kb {
    public final d e;
    public final pc f;

    public jd(d d0) {
        super(false);
        this.e = d0;
        this.f = new pc(((byte[])d0.d));
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final long b(W2 w20) {
        return this.f.b(w20);
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final Uri c() {
        return (Uri)this.e.f;
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final void close() {
        this.f.close();
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final Map e() {
        return (Map)this.e.g;
    }

    @Override  // i.n.i.b.a.s.e.xe
    public final int o(byte[] arr_b, int v, int v1) {
        return this.f.o(arr_b, v, v1);
    }
}

