package w3;

import E9.t;
import android.os.Looper;
import android.os.SystemClock;
import androidx.media3.session.N;
import com.google.android.exoplayer2.util.e;
import e3.b;
import i.n.i.b.a.s.e.eb;
import java.io.IOException;
import java.util.concurrent.Executors;
import t9.B;
import y3.a;

public final class k {
    public final a a;
    public eb b;
    public IOException c;
    public static final N d;
    public static final N e;
    public static final N f;

    static {
        k.d = new N(0x8000000000000001L, 0, false);
        k.e = new N(0x8000000000000001L, 2, false);
        k.f = new N(0x8000000000000001L, 3, false);
    }

    public k(String s) {
        this(new a(Executors.newSingleThreadExecutor(new e("ExoPlayer:Loader:" + s, 1)), new B(5)));
    }

    public k(a a0) {
        this.a = a0;
    }

    public final void a() {
        eb eb0 = this.b;
        b.k(eb0);
        eb0.c(false);
    }

    public final boolean b() {
        return this.b != null;
    }

    public final void c(i i0) {
        eb eb0 = this.b;
        if(eb0 != null) {
            eb0.c(true);
        }
        a a0 = this.a;
        if(i0 != null) {
            a0.execute(new t(i0, 26));
        }
        a0.b.accept(a0.a);
    }

    public final long d(h h0, g g0, int v) {
        Looper looper0 = Looper.myLooper();
        b.k(looper0);
        this.c = null;
        long v1 = SystemClock.elapsedRealtime();
        eb eb0 = new eb(this, looper0, h0, g0, v, v1, 1);
        b.j(this.b == null);
        this.b = eb0;
        SystemClock.elapsedRealtime();
        ((g)eb0.j).getClass();
        eb0.d = null;
        eb eb1 = this.b;
        eb1.getClass();
        this.a.execute(eb1);
        return v1;
    }
}

