package gc;

import Bf.a;
import I6.V;
import I6.p0;
import Nb.u0;
import Nb.z0;
import U4.F;
import a3.n;
import android.net.Uri;
import b3.E;
import b3.K;
import b3.P;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.iloen.melon.custom.S0;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import hc.p;
import hc.s;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.q;

public final class b extends a implements P {
    public final CastContext b;
    public final n c;
    public final AtomicReference d;
    public final AtomicBoolean e;
    public final AtomicBoolean f;
    public int g;
    public int h;
    public long i;
    public final LogU j;
    public final u0 k;

    public b(S0 s00, CastContext castContext0) {
        super(s00);
        this.b = castContext0;
        n n0 = new n(castContext0, new gc.a(this));
        this.c = n0;
        this.d = new AtomicReference(E.g);
        this.e = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
        this.i = -1L;
        this.j = Companion.create$default(LogU.Companion, "CastPlayer", false, Category.Playback, 2, null);
        n0.l.a(this);
        this.k = u0.b;
    }

    @Override  // Bf.a
    public final E X0() {
        Object object0 = this.d.get();
        q.f(object0, "get(...)");
        return (E)object0;
    }

    @Override  // Bf.a
    public final long Y0() {
        return this.c.getContentDuration();
    }

    @Override  // Bf.a
    public final z0 a1() {
        return this.k;
    }

    @Override  // Bf.a
    public final long b1() {
        return this.c.getCurrentPosition();
    }

    @Override  // Bf.a
    public final void j1() {
        this.c.setPlayWhenReady(false);
    }

    @Override  // b3.P
    public final void k0(K k0) {
        q.g(k0, "error");
        ((S0)this.a).e0(this, k0, "CastPlayer Error");
    }

    @Override  // Bf.a
    public final void k1() {
        this.c.setPlayWhenReady(true);
    }

    @Override  // Bf.a
    public final void l1() {
        this.c.release();
    }

    @Override  // Bf.a
    public final void m1(long v) {
        if(this.f.compareAndSet(false, true)) {
            this.c.i0(5, v);
        }
    }

    @Override  // Bf.a
    public final void n1(Uri uri0, E e0, s s0) {
        q.g(uri0, "uri");
        q.g(e0, "mediaItem");
        String s1 = F.M(e0) ? "video/mp4" : "audio/mpeg";
        if(s0 instanceof p) {
            this.g = ((p)s0).a.b;
            this.h = ((p)s0).a.c;
            this.i = ((p)s0).a.a;
        }
        b3.s s2 = e0.a();
        s2.b = uri0;
        s2.c = s1;
        E e1 = s2.a();
        this.d.set(e0);
        this.e.set(true);
        this.f.set(false);
        this.c.getClass();
        p0 p00 = V.t(e1);
        this.c.U(p00);
    }

    @Override  // Bf.a
    public final void o1(float f) {
        this.c.getClass();
    }

    @Override  // Bf.a
    public final void p1() {
        this.c.stop();
    }

    @Override  // b3.P
    public final void w(int v) {
        Integer integer0;
        S0 s00 = (S0)this.a;
        LogConstantsKt.debugOnlyDebugMode(this.j, "onPlaybackStateChanged(): " + F.a0(v));
        switch(v) {
            case 1: {
                CastSession castSession0 = this.b.getSessionManager().getCurrentCastSession();
                if(castSession0 == null) {
                    integer0 = null;
                }
                else {
                    RemoteMediaClient remoteMediaClient0 = castSession0.getRemoteMediaClient();
                    integer0 = remoteMediaClient0 == null ? null : remoteMediaClient0.getIdleReason();
                }
                if(integer0 != null && 1 == ((int)integer0)) {
                    s00.d0(this);
                    return;
                }
                this.d.set(E.g);
                return;
            }
            case 3: {
                if(this.e.compareAndSet(true, false)) {
                    s00.f0(this);
                    return;
                }
                if(this.f.compareAndSet(true, false)) {
                    s00.g0(this);
                }
                return;
            }
            case 4: {
                s00.d0(this);
            }
        }
    }
}

