package k3;

import A3.c;
import Bb.e;
import I6.G0;
import I6.b0;
import I6.p0;
import Nf.p;
import android.media.ResourceBusyException;
import android.media.UnsupportedSchemeException;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.common.DrmInitData.SchemeData;
import androidx.media3.common.DrmInitData;
import b3.H;
import b3.h;
import d5.l;
import i.n.i.b.a.s.e.P3;
import i3.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public final class f implements o {
    public final UUID b;
    public final d c;
    public final c d;
    public final HashMap e;
    public final boolean f;
    public final int[] g;
    public final boolean h;
    public final l i;
    public final p j;
    public final k3.c k;
    public final long l;
    public final ArrayList m;
    public final Set n;
    public final Set o;
    public int p;
    public t q;
    public b r;
    public b s;
    public Looper t;
    public Handler u;
    public byte[] v;
    public i3.l w;
    public volatile e x;

    public f(UUID uUID0, c c0, HashMap hashMap0, boolean z, int[] arr_v, boolean z1, p p0) {
        uUID0.getClass();
        e3.b.d(!h.b.equals(uUID0), "Use C.CLEARKEY_UUID instead");
        this.b = uUID0;
        this.c = v.d;
        this.d = c0;
        this.e = hashMap0;
        this.f = z;
        this.g = arr_v;
        this.h = z1;
        this.j = p0;
        this.i = new l(12);
        this.k = new k3.c(this);
        this.m = new ArrayList();
        this.n = Collections.newSetFromMap(new IdentityHashMap());
        this.o = Collections.newSetFromMap(new IdentityHashMap());
        this.l = 300000L;
    }

    @Override  // k3.o
    public final n a(k k0, androidx.media3.common.b b0) {
        e3.b.j(this.p > 0);
        e3.b.k(this.t);
        n n0 = new k3.e(this, k0);
        Handler handler0 = this.u;
        handler0.getClass();
        handler0.post(new P3(13, n0, b0));
        return n0;
    }

    @Override  // k3.o
    public final k3.h b(k k0, androidx.media3.common.b b0) {
        boolean z = false;
        this.k(false);
        if(this.p > 0) {
            z = true;
        }
        e3.b.j(z);
        e3.b.k(this.t);
        return this.e(this.t, k0, b0, true);
    }

    @Override  // k3.o
    public final int c(androidx.media3.common.b b0) {
        this.k(false);
        t t0 = this.q;
        t0.getClass();
        int v = t0.b();
        DrmInitData drmInitData0 = b0.r;
        if(drmInitData0 == null) {
            int v1 = H.g(b0.n);
            int v2;
            for(v2 = 0; true; ++v2) {
                int[] arr_v = this.g;
                if(v2 >= arr_v.length) {
                    v2 = -1;
                    break;
                }
                if(arr_v[v2] == v1) {
                    break;
                }
            }
            return v2 == -1 ? 0 : v;
        }
        if(this.v == null) {
            UUID uUID0 = this.b;
            if(f.i(drmInitData0, uUID0, true).isEmpty()) {
                if(drmInitData0.d == 1 && drmInitData0.a[0].a(h.b)) {
                    e3.b.D("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + uUID0);
                    return drmInitData0.c == null || "cenc".equals(drmInitData0.c) || "cbcs".equals(drmInitData0.c) || !"cbc1".equals(drmInitData0.c) && !"cens".equals(drmInitData0.c) ? v : 1;
                }
                return 1;
            }
            return drmInitData0.c == null || "cenc".equals(drmInitData0.c) || "cbcs".equals(drmInitData0.c) || !"cbc1".equals(drmInitData0.c) && !"cens".equals(drmInitData0.c) ? v : 1;
        }
        return v;
    }

    @Override  // k3.o
    public final void d(Looper looper0, i3.l l0) {
        synchronized(this) {
            Looper looper1 = this.t;
            if(looper1 == null) {
                this.t = looper0;
                this.u = new Handler(looper0);
            }
            else {
                e3.b.j(looper1 == looper0);
                this.u.getClass();
            }
        }
        this.w = l0;
    }

    public final k3.h e(Looper looper0, k k0, androidx.media3.common.b b0, boolean z) {
        ArrayList arrayList0;
        if(this.x == null) {
            this.x = new e(this, looper0, 15);
        }
        DrmInitData drmInitData0 = b0.r;
        int v = 0;
        k3.h h0 = null;
        if(drmInitData0 == null) {
            int v1 = H.g(b0.n);
            t t0 = this.q;
            t0.getClass();
            if(t0.b() != 2 || !u.c) {
                int[] arr_v = this.g;
                while(true) {
                    if(v >= arr_v.length) {
                        v = -1;
                        break;
                    }
                    if(arr_v[v] == v1) {
                        break;
                    }
                    ++v;
                }
                if(v != -1 && t0.b() != 1) {
                    b b1 = this.r;
                    if(b1 == null) {
                        b b2 = this.h(p0.e, true, null, z);
                        this.m.add(b2);
                        this.r = b2;
                        return this.r;
                    }
                    b1.a(null);
                    return this.r;
                }
            }
            return null;
        }
        if(this.v == null) {
            arrayList0 = f.i(drmInitData0, this.b, false);
            if(arrayList0.isEmpty()) {
                k3.d d0 = new k3.d("Media does not support uuid: " + this.b);  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
                e3.b.q("DefaultDrmSessionMgr", "DRM error", d0);
                k0.d(d0);
                return new q(new g(d0, 6003));
            }
        }
        else {
            arrayList0 = null;
        }
        if(this.f) {
            for(Object object0: this.m) {
                b b3 = (b)object0;
                if(Objects.equals(b3.a, arrayList0)) {
                    h0 = b3;
                    break;
                }
                if(false) {
                    break;
                }
            }
        }
        else {
            h0 = this.s;
        }
        if(h0 == null) {
            b b4 = this.h(arrayList0, false, k0, z);
            if(!this.f) {
                this.s = b4;
            }
            this.m.add(b4);
            return b4;
        }
        ((b)h0).a(k0);
        return h0;
    }

    public static boolean f(b b0) {
        b0.l();
        if(b0.o == 1) {
            g g0 = b0.getError();
            g0.getClass();
            Throwable throwable0 = g0.getCause();
            return throwable0 instanceof ResourceBusyException || df.d.A(throwable0);
        }
        return false;
    }

    public final b g(List list0, boolean z, k k0) {
        this.q.getClass();
        t t0 = this.q;
        byte[] arr_b = this.v;
        Looper looper0 = this.t;
        looper0.getClass();
        i3.l l0 = this.w;
        l0.getClass();
        b b0 = new b(this.b, t0, this.i, this.k, list0, ((boolean)(this.h | z)), z, arr_b, this.e, this.d, looper0, this.j, l0);
        b0.a(k0);
        if(this.l != 0x8000000000000001L) {
            b0.a(null);
        }
        return b0;
    }

    public final b h(List list0, boolean z, k k0, boolean z1) {
        b b0 = this.g(list0, z, k0);
        boolean z2 = f.f(b0);
        long v = this.l;
        Set set0 = this.o;
        if(z2 && !set0.isEmpty()) {
            G0 g00 = b0.p(set0).k();
            while(g00.hasNext()) {
                Object object0 = g00.next();
                ((k3.h)object0).d(null);
            }
            b0.d(k0);
            if(v != 0x8000000000000001L) {
                b0.d(null);
            }
            b0 = this.g(list0, z, k0);
        }
        if(f.f(b0) && z1) {
            Set set1 = this.n;
            if(!set1.isEmpty()) {
                G0 g01 = b0.p(set1).k();
                while(g01.hasNext()) {
                    Object object1 = g01.next();
                    ((k3.e)object1).release();
                }
                if(!set0.isEmpty()) {
                    G0 g02 = b0.p(set0).k();
                    while(g02.hasNext()) {
                        Object object2 = g02.next();
                        ((k3.h)object2).d(null);
                    }
                }
                b0.d(k0);
                if(v != 0x8000000000000001L) {
                    b0.d(null);
                }
                return this.g(list0, z, k0);
            }
        }
        return b0;
    }

    public static ArrayList i(DrmInitData drmInitData0, UUID uUID0, boolean z) {
        ArrayList arrayList0 = new ArrayList(drmInitData0.d);
        for(int v = 0; v < drmInitData0.d; ++v) {
            SchemeData drmInitData$SchemeData0 = drmInitData0.a[v];
            if((drmInitData$SchemeData0.a(uUID0) || h.c.equals(uUID0) && drmInitData$SchemeData0.a(h.b)) && (drmInitData$SchemeData0.e != null || z)) {
                arrayList0.add(drmInitData$SchemeData0);
            }
        }
        return arrayList0;
    }

    public final void j() {
        if(this.q != null && this.p == 0 && this.m.isEmpty() && this.n.isEmpty()) {
            t t0 = this.q;
            t0.getClass();
            t0.release();
            this.q = null;
        }
    }

    public final void k(boolean z) {
        if(z && this.t == null) {
            e3.b.E("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed before setPlayer(), possibly on the wrong thread.", new IllegalStateException());
            return;
        }
        Looper looper0 = this.t;
        looper0.getClass();
        if(Thread.currentThread() != looper0.getThread()) {
            e3.b.E("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed on the wrong thread.\nCurrent thread: jeb-dexdec-sb-st-1189\nExpected thread: " + this.t.getThread().getName(), new IllegalStateException());
        }
    }

    @Override  // k3.o
    public final void prepare() {
        v v1;
        this.k(true);
        int v = this.p;
        this.p = v + 1;
        if(v == 0) {
            if(this.q == null) {
                UUID uUID0 = this.b;
                this.c.getClass();
                try {
                    v1 = new v(uUID0);
                    goto label_15;
                }
                catch(UnsupportedSchemeException unsupportedSchemeException0) {
                }
                catch(Exception exception0) {
                    throw new y(exception0);  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/Throwable;)V
                }
                try {
                    throw new y(unsupportedSchemeException0);  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/Throwable;)V
                }
                catch(y unused_ex) {
                    e3.b.p("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uUID0 + ".");
                    v1 = new k3.p();  // 初始化器: Ljava/lang/Object;-><init>()V
                }
            label_15:
                this.q = v1;
                v1.a(new k3.c(this));
                return;
            }
            if(this.l != 0x8000000000000001L) {
                for(int v2 = 0; true; ++v2) {
                    ArrayList arrayList0 = this.m;
                    if(v2 >= arrayList0.size()) {
                        break;
                    }
                    ((b)arrayList0.get(v2)).a(null);
                }
            }
        }
    }

    @Override  // k3.o
    public final void release() {
        this.k(true);
        int v = this.p - 1;
        this.p = v;
        if(v != 0) {
            return;
        }
        if(this.l != 0x8000000000000001L) {
            ArrayList arrayList0 = new ArrayList(this.m);
            for(int v1 = 0; v1 < arrayList0.size(); ++v1) {
                ((b)arrayList0.get(v1)).d(null);
            }
        }
        G0 g00 = b0.p(this.n).k();
        while(g00.hasNext()) {
            Object object0 = g00.next();
            ((k3.e)object0).release();
        }
        this.j();
    }
}

