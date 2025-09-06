package k3;

import Bb.e;
import Nf.p;
import android.media.DeniedByServerException;
import android.media.MediaDrm.MediaDrmStateException;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.session.legacy.C;
import d5.l;
import df.d;
import e3.f;
import e3.x;
import h3.a;
import i.n.i.b.a.s.e.u9;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import s3.q;

public final class b implements h {
    public final List a;
    public final t b;
    public final l c;
    public final c d;
    public final boolean e;
    public final boolean f;
    public final HashMap g;
    public final f h;
    public final p i;
    public final i3.l j;
    public final A3.c k;
    public final UUID l;
    public final Looper m;
    public final e n;
    public int o;
    public int p;
    public HandlerThread q;
    public C r;
    public a s;
    public g t;
    public byte[] u;
    public byte[] v;
    public r w;
    public s x;

    public b(UUID uUID0, t t0, l l0, c c0, List list0, boolean z, boolean z1, byte[] arr_b, HashMap hashMap0, A3.c c1, Looper looper0, p p0, i3.l l1) {
        this.l = uUID0;
        this.c = l0;
        this.d = c0;
        this.b = t0;
        this.e = z;
        this.f = z1;
        if(arr_b == null) {
            list0.getClass();
            this.a = Collections.unmodifiableList(list0);
        }
        else {
            this.v = arr_b;
            this.a = null;
        }
        this.g = hashMap0;
        this.k = c1;
        this.h = new f(0);
        this.i = p0;
        this.j = l1;
        this.o = 2;
        this.m = looper0;
        this.n = new e(this, looper0, 14);
    }

    @Override  // k3.h
    public final void a(k k0) {
        this.l();
        boolean z = false;
        if(this.p < 0) {
            e3.b.p("DefaultDrmSession", "Session reference count less than zero: " + this.p);
            this.p = 0;
        }
        if(k0 != null) {
            f f0 = this.h;
            synchronized(f0.b) {
                ArrayList arrayList0 = new ArrayList(f0.e);
                arrayList0.add(k0);
                f0.e = Collections.unmodifiableList(arrayList0);
                Integer integer0 = (Integer)f0.c.get(k0);
                if(integer0 == null) {
                    HashSet hashSet0 = new HashSet(f0.d);
                    hashSet0.add(k0);
                    f0.d = Collections.unmodifiableSet(hashSet0);
                }
                f0.c.put(k0, ((int)(integer0 == null ? 1 : ((int)integer0) + 1)));
            }
        }
        int v1 = this.p + 1;
        this.p = v1;
        if(v1 == 1) {
            if(this.o == 2) {
                z = true;
            }
            e3.b.j(z);
            HandlerThread handlerThread0 = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.q = handlerThread0;
            handlerThread0.start();
            this.r = new C(this, this.q.getLooper(), 3);
            if(this.j()) {
                this.f(true);
            }
        }
        else if(k0 != null && this.g() && this.h.d(k0) == 1) {
            k0.c(this.o);
        }
        k3.f f1 = this.d.a;
        if(f1.l != 0x8000000000000001L) {
            f1.o.remove(this);
            Handler handler0 = f1.u;
            handler0.getClass();
            handler0.removeCallbacksAndMessages(this);
        }
    }

    @Override  // k3.h
    public final UUID b() {
        this.l();
        return this.l;
    }

    @Override  // k3.h
    public final a c() {
        this.l();
        return this.s;
    }

    @Override  // k3.h
    public final void d(k k0) {
        this.l();
        int v = this.p;
        if(v <= 0) {
            e3.b.p("DefaultDrmSession", "release() called on a session that\'s already fully released.");
            return;
        }
        this.p = v - 1;
        if(v - 1 == 0) {
            this.o = 0;
            this.n.removeCallbacksAndMessages(null);
            C c0 = this.r;
            synchronized(c0) {
                c0.removeCallbacksAndMessages(null);
                c0.b = true;
            }
            this.r = null;
            this.q.quit();
            this.q = null;
            this.s = null;
            this.t = null;
            this.w = null;
            this.x = null;
            byte[] arr_b = this.u;
            if(arr_b != null) {
                this.b.closeSession(arr_b);
                this.u = null;
            }
        }
        if(k0 != null) {
            f f0 = this.h;
            synchronized(f0.b) {
                Integer integer0 = (Integer)f0.c.get(k0);
                if(integer0 != null) {
                    ArrayList arrayList0 = new ArrayList(f0.e);
                    arrayList0.remove(k0);
                    f0.e = Collections.unmodifiableList(arrayList0);
                    if(((int)integer0) == 1) {
                        f0.c.remove(k0);
                        HashSet hashSet0 = new HashSet(f0.d);
                        hashSet0.remove(k0);
                        f0.d = Collections.unmodifiableSet(hashSet0);
                    }
                    else {
                        f0.c.put(k0, ((int)(((int)integer0) - 1)));
                    }
                }
            }
            if(this.h.d(k0) == 0) {
                k0.e();
            }
        }
        int v2 = this.p;
        k3.f f1 = this.d.a;
        if(v2 == 1 && f1.p > 0 && f1.l != 0x8000000000000001L) {
            f1.o.add(this);
            Handler handler0 = f1.u;
            handler0.getClass();
            handler0.postAtTime(new u9(this, 10), this, SystemClock.uptimeMillis() + f1.l);
        }
        else if(v2 == 0) {
            f1.m.remove(this);
            if(f1.r == this) {
                f1.r = null;
            }
            if(f1.s == this) {
                f1.s = null;
            }
            l l0 = f1.i;
            HashSet hashSet1 = (HashSet)l0.b;
            hashSet1.remove(this);
            if(((b)l0.c) == this) {
                l0.c = null;
                if(!hashSet1.isEmpty()) {
                    Object object1 = hashSet1.iterator().next();
                    l0.c = (b)object1;
                    s s0 = ((b)object1).b.getProvisionRequest();
                    ((b)object1).x = s0;
                    C c1 = ((b)object1).r;
                    s0.getClass();
                    c1.getClass();
                    c1.obtainMessage(1, new k3.a(q.c.getAndIncrement(), true, SystemClock.elapsedRealtime(), s0)).sendToTarget();
                }
            }
            if(f1.l != 0x8000000000000001L) {
                Handler handler1 = f1.u;
                handler1.getClass();
                handler1.removeCallbacksAndMessages(this);
                f1.o.remove(this);
            }
        }
        f1.j();
    }

    @Override  // k3.h
    public final boolean e(String s) {
        this.l();
        byte[] arr_b = this.u;
        e3.b.k(arr_b);
        return this.b.e(s, arr_b);
    }

    public final void f(boolean z) {
        long v;
        Long long0;
        long v2;
        long v1;
        if(!this.f) {
            byte[] arr_b = this.u;
            boolean z1 = true;
            if(this.v == null) {
                this.k(arr_b, 1, z);
                return;
            }
            if(this.o == 4) {
            label_13:
                if(b3.h.d.equals(this.l)) {
                    this.l();
                    Pair pair0 = null;
                    Map map0 = this.u == null ? null : this.b.queryKeyStatus(this.u);
                    if(map0 != null) {
                        try {
                            v1 = 0x8000000000000001L;
                            String s = (String)map0.get("LicenseDurationRemaining");
                            v2 = 0x8000000000000001L;
                            if(s != null) {
                                v2 = Long.parseLong(s);
                            }
                        }
                        catch(NumberFormatException unused_ex) {
                        }
                        try {
                            long0 = v2;
                            String s1 = (String)map0.get("PlaybackDurationRemaining");
                            if(s1 != null) {
                                v1 = Long.parseLong(s1);
                            }
                        }
                        catch(NumberFormatException unused_ex) {
                        }
                        pair0 = new Pair(long0, v1);
                    }
                    pair0.getClass();
                    v = Math.min(((long)(((Long)pair0.first))), ((long)(((Long)pair0.second))));
                }
                else {
                    v = 0x7FFFFFFFFFFFFFFFL;
                }
                if(Long.compare(v, 60L) <= 0) {
                    e3.b.o("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + v);
                    this.k(arr_b, 2, z);
                    return;
                }
                if(v <= 0L) {
                    this.h(new w(), 2);  // 初始化器: Ljava/lang/Exception;-><init>()V
                    return;
                }
                this.o = 4;
                for(Object object0: this.h.d) {
                    ((k)object0).b();
                }
            }
            else {
                try {
                    this.b.restoreKeys(this.u, this.v);
                }
                catch(Exception | NoSuchMethodError exception0) {
                    this.h(exception0, 1);
                    z1 = false;
                }
                if(z1) {
                    goto label_13;
                }
            }
        }
    }

    public final boolean g() {
        return this.o == 3 || this.o == 4;
    }

    @Override  // k3.h
    public final g getError() {
        this.l();
        return this.o == 1 ? this.t : null;
    }

    @Override  // k3.h
    public final int getState() {
        this.l();
        return this.o;
    }

    public final void h(Throwable throwable0, int v) {
        int v1;
        if(throwable0 instanceof MediaDrm.MediaDrmStateException) {
            v1 = x.v(x.w(((MediaDrm.MediaDrmStateException)throwable0).getDiagnosticInfo()));
        }
        else if(throwable0 instanceof MediaDrmResetException) {
            v1 = 6006;
        }
        else if(throwable0 instanceof NotProvisionedException || d.z(throwable0)) {
            v1 = 6002;
        }
        else if(throwable0 instanceof DeniedByServerException) {
            v1 = 6007;
        }
        else if(throwable0 instanceof y) {
            v1 = 6001;
        }
        else if(throwable0 instanceof k3.d) {
            v1 = 6003;
        }
        else if(throwable0 instanceof w) {
            v1 = 6008;
        }
        else {
            switch(v) {
                case 1: {
                    v1 = 6006;
                    break;
                }
                case 2: {
                    v1 = 6004;
                    break;
                }
                case 3: {
                    v1 = 6002;
                    break;
                }
                default: {
                    throw new IllegalArgumentException();
                }
            }
        }
        this.t = new g(throwable0, v1);
        e3.b.q("DefaultDrmSession", "DRM session error", throwable0);
        if(throwable0 instanceof Exception) {
            for(Object object0: this.h.d) {
                ((k)object0).d(((Exception)throwable0));
            }
        }
        else if(!(throwable0 instanceof Error)) {
            throw new IllegalStateException("Unexpected Throwable subclass", throwable0);
        }
        else if(!d.A(throwable0) && !d.z(throwable0)) {
            throw (Error)throwable0;
        }
        if(this.o != 4) {
            this.o = 1;
        }
    }

    public final void i(Throwable throwable0, boolean z) {
        if(!(throwable0 instanceof NotProvisionedException) && !d.z(throwable0)) {
            this.h(throwable0, (z ? 1 : 2));
            return;
        }
        this.c.m(this);
    }

    public final boolean j() {
        if(this.g()) {
            return true;
        }
        try {
            byte[] arr_b = this.b.openSession();
            this.u = arr_b;
            this.b.d(arr_b, this.j);
            this.s = this.b.c(this.u);
            this.o = 3;
            for(Object object0: this.h.d) {
                ((k)object0).c(3);
            }
            this.u.getClass();
            return true;
        }
        catch(NotProvisionedException unused_ex) {
            this.c.m(this);
            return false;
        }
        catch(Exception | NoSuchMethodError exception0) {
            if(d.z(exception0)) {
                this.c.m(this);
                return false;
            }
            this.h(exception0, 1);
            return false;
        }
    }

    public final void k(byte[] arr_b, int v, boolean z) {
        try {
            r r0 = this.b.getKeyRequest(arr_b, this.a, v, this.g);
            this.w = r0;
            C c0 = this.r;
            r0.getClass();
            c0.getClass();
            c0.obtainMessage(2, new k3.a(q.c.getAndIncrement(), z, SystemClock.elapsedRealtime(), r0)).sendToTarget();
        }
        catch(Exception | NoSuchMethodError exception0) {
            this.i(exception0, true);
        }
    }

    public final void l() {
        Looper looper0 = this.m;
        if(Thread.currentThread() != looper0.getThread()) {
            e3.b.E("DefaultDrmSession", "DefaultDrmSession accessed on the wrong thread.\nCurrent thread: jeb-dexdec-sb-st-1260\nExpected thread: " + looper0.getThread().getName(), new IllegalStateException());
        }
    }

    @Override  // k3.h
    public final boolean playClearSamplesWithoutKeys() {
        this.l();
        return this.e;
    }
}

