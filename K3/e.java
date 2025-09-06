package k3;

import android.os.Handler;
import e3.x;
import i.n.i.b.a.s.e.u9;

public final class e implements n {
    public final k a;
    public h b;
    public boolean c;
    public final f d;

    public e(f f0, k k0) {
        this.d = f0;
        this.a = k0;
    }

    @Override  // k3.n
    public final void release() {
        Handler handler0 = this.d.u;
        handler0.getClass();
        x.P(handler0, new u9(this, 9));
    }
}

