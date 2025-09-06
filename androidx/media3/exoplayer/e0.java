package androidx.media3.exoplayer;

import android.os.Looper;
import android.os.SystemClock;
import b3.p0;
import e3.b;
import e3.r;
import java.util.concurrent.TimeoutException;

public final class e0 {
    public final d0 a;
    public final c0 b;
    public final r c;
    public int d;
    public Object e;
    public final Looper f;
    public boolean g;
    public boolean h;
    public boolean i;

    public e0(c0 c00, d0 d00, p0 p00, int v, r r0, Looper looper0) {
        this.b = c00;
        this.a = d00;
        this.f = looper0;
        this.c = r0;
    }

    public final void a(long v) {
        synchronized(this) {
            b.j(this.g);
            b.j(this.f.getThread() != Thread.currentThread());
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
        b.j(!this.g);
        this.g = true;
        H h0 = (H)this.b;
        synchronized(h0) {
            if(!h0.X && h0.k.getThread().isAlive()) {
                h0.i.a(14, this).b();
                return;
            }
            b.D("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            this.b(false);
        }
    }
}

