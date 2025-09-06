package i.n.i.b.a.s.e;

import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.TimeoutException;

public final class r7 {
    public final d2 a;
    public final p7 b;
    public final E4 c;
    public int d;
    public Object e;
    public final Looper f;
    public boolean g;
    public boolean h;
    public boolean i;

    public r7(p7 p70, d2 d20, i i0, int v, E4 e40, Looper looper0) {
        this.b = p70;
        this.a = d20;
        this.f = looper0;
        this.c = e40;
    }

    public final void a(long v) {
        synchronized(this) {
            M7.J(this.g);
            M7.J(this.f.getThread() != Thread.currentThread());
            this.c.getClass();
            long v2 = SystemClock.elapsedRealtime() + v;
            boolean z;
            while(!z = this.i && v > 0L) {
                this.c.getClass();
                this.wait(v);
                this.c.getClass();
                v = v2 - SystemClock.elapsedRealtime();
            }
            if(z) {
                return;
            }
        }
        throw new TimeoutException("Message delivery timed out.");
    }

    public final void b(boolean z) {
        synchronized(this) {
            this.h |= z;
            this.i = true;
            this.notifyAll();
        }
    }

    public final void c() {
        M7.J(!this.g);
        this.g = true;
        L9 l90 = (L9)this.b;
        synchronized(l90) {
            if(!l90.S && l90.h.isAlive()) {
                l90.g.b(14, this).a();
                return;
            }
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            this.b(false);
        }
    }
}

