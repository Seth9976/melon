package androidx.media3.session;

import D5.a;
import I6.G0;
import I6.K;
import I6.Q;
import I6.V;
import I6.o0;
import I6.p0;
import M6.B;
import M6.H;
import X5.g;
import a3.d;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Surface;
import androidx.compose.foundation.s;
import androidx.media3.common.TrackSelectionParameters.Builder;
import androidx.media3.exoplayer.o;
import androidx.media3.exoplayer.q;
import androidx.media3.exoplayer.x;
import androidx.media3.session.legacy.b0;
import androidx.media3.session.legacy.c0;
import b3.E;
import b3.G;
import b3.L;
import b3.T;
import b3.q0;
import b3.r0;
import b3.u0;
import b3.v0;
import com.google.firebase.messaging.u;
import e3.b;
import e3.e;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class f1 extends Binder implements m {
    public final WeakReference a;
    public final c0 b;
    public final u c;
    public final Set d;
    public o0 e;
    public int j;
    public static final int k;

    public f1(n0 n00) {
        this.attachInterface(this, "androidx.media3.session.IMediaSession");
        this.a = new WeakReference(n00);
        this.b = c0.a(n00.f);
        this.c = new u(n00);
        this.d = Collections.synchronizedSet(new HashSet());
        this.e = o0.i;
    }

    @Override  // androidx.media3.session.m
    public final void A(k k0, int v, int v1) {
        if(k0 != null && v1 >= 0) {
            this.H0(k0, v, 20, new a0(new R0(this, v1, 4), 6));
        }
    }

    @Override  // androidx.media3.session.m
    public final void B(k k0, int v) {
        if(k0 == null) {
            return;
        }
        this.H0(k0, v, 8, f1.K0(new x(14)));
    }

    @Override  // androidx.media3.session.m
    public final void B0(k k0, int v, Bundle bundle0) {
        u0 u00;
        if(k0 != null && bundle0 != null) {
            try {
                u00 = u0.b(bundle0);
            }
            catch(RuntimeException runtimeException0) {
                b.E("MediaSessionStub", "Ignoring malformed Bundle for TrackSelectionParameters", runtimeException0);
                return;
            }
            this.H0(k0, v, 29, f1.K0(new H0(1, this, u00)));
        }
    }

    @Override  // androidx.media3.session.m
    public final void C(k k0, int v, long v1) {
        if(k0 == null) {
            return;
        }
        this.H0(k0, v, 5, f1.K0(new g(v1)));
    }

    public final void C0(k k0, w0 w00) {
        if(k0 != null) {
            Object object0 = this.a.get();
            if(((n0)object0) != null && !((n0)object0).l()) {
                this.d.add(w00);
                a a0 = new a(this, w00, ((n0)object0), k0, 14);
                e3.x.P(((n0)object0).l, a0);
                return;
            }
            try {
                k0.d();
            }
            catch(RemoteException unused_ex) {
            }
        }
    }

    public final void D0(k k0, int v, s1 s10, int v1, e1 e10) {
        long v2 = Binder.clearCallingIdentity();
        try {
            Object object0 = this.a.get();
            if(((n0)object0) != null && !((n0)object0).l()) {
                IBinder iBinder0 = k0.asBinder();
                w0 w00 = this.c.l(iBinder0);
                if(w00 == null) {
                    return;
                }
                V0 v00 = new V0(this, w00, s10, v, v1, e10, ((n0)object0));
                e3.x.P(((n0)object0).l, v00);
            }
        }
        finally {
            Binder.restoreCallingIdentity(v2);
        }
    }

    @Override  // androidx.media3.session.m
    public final void E(k k0, int v, float f) {
        if(k0 != null && f >= 0.0f && f <= 1.0f) {
            this.H0(k0, v, 24, f1.K0(new s(f, 4)));
        }
    }

    public final k1 E0(k1 k10) {
        V v0 = k10.D.a;
        Q q0 = V.o();
        K k0 = new K(4);  // 初始化器: LB7/b;-><init>(I)V
        for(int v1 = 0; v1 < v0.size(); ++v1) {
            v0 v00 = (v0)v0.get(v1);
            q0 q00 = v00.b;
            String s = (String)this.e.get(q00);
            if(s == null) {
                int v2 = this.j;
                this.j = v2 + 1;
                s = Integer.toString(v2, 36) + "-" + q00.b;
            }
            k0.B(q00, s);
            q0.a(new v0(new q0(s, v00.b.d), v00.c, v00.d, v00.e));
        }
        this.e = k0.A();
        k1 k11 = k10.b(new b3.w0(q0.g()));
        u0 u00 = k11.E;
        if(u00.A.isEmpty()) {
            return k11;
        }
        TrackSelectionParameters.Builder trackSelectionParameters$Builder0 = u00.a().c();
        G0 g00 = u00.A.e().k();
        while(g00.hasNext()) {
            Object object0 = g00.next();
            r0 r00 = (r0)object0;
            q0 q01 = r00.a;
            String s1 = (String)this.e.get(q01);
            if(s1 == null) {
                trackSelectionParameters$Builder0.a(r00);
            }
            else {
                trackSelectionParameters$Builder0.a(new r0(new q0(s1, q01.d), r00.b));
            }
        }
        return k11.o(trackSelectionParameters$Builder0.b());
    }

    @Override  // androidx.media3.session.m
    public final void F(k k0, int v, Bundle bundle0) {
        f f0;
        P0.c0 c00;
        w1 w10;
        if(k0 != null && bundle0 != null) {
            try {
                w10 = w1.a(bundle0);
            }
            catch(RuntimeException runtimeException0) {
                b.E("MediaSessionStub", "Ignoring malformed Bundle for SessionResult", runtimeException0);
                return;
            }
            long v1 = Binder.clearCallingIdentity();
            try {
                IBinder iBinder0 = k0.asBinder();
                synchronized(this.c.a) {
                    w0 w00 = this.c.l(iBinder0);
                    c00 = null;
                    f0 = w00 == null ? null : ((f)((androidx.collection.f)this.c.c).get(w00));
                }
                if(f0 != null) {
                    c00 = f0.b;
                }
                if(c00 == null) {
                    return;
                }
                c00.t(v, w10);
            }
            finally {
                Binder.restoreCallingIdentity(v1);
            }
        }
    }

    public static B F0(n0 n00, w0 w00, int v, e1 e10, e e0) {
        if(n00.l()) {
            return M6.x.b;
        }
        Object object0 = e10.e(n00, w00, v);
        B b0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
        ((B)object0).addListener(new a(n00, b0, e0, ((B)object0), 15), M6.s.a);
        return b0;
    }

    @Override  // androidx.media3.session.m
    public final void G(k k0, int v, int v1, int v2) {
        if(k0 != null && v1 >= 0 && v2 >= 0) {
            this.H0(k0, v, 20, f1.K0(new q(v1, v2, 3)));
        }
    }

    // 去混淆评级： 低(30)
    public final int G0(w0 w00, o1 o10, int v) {
        return !o10.Y(17) || (this.c.t(w00, 17) || !this.c.t(w00, 16)) ? v : o10.L() + v;
    }

    @Override  // androidx.media3.session.m
    public final void H(k k0, int v, float f) {
        if(k0 != null && f > 0.0f) {
            this.H0(k0, v, 13, f1.K0(new s(f, 3)));
        }
    }

    public final void H0(k k0, int v, int v1, e1 e10) {
        IBinder iBinder0 = k0.asBinder();
        w0 w00 = this.c.l(iBinder0);
        if(w00 != null) {
            this.I0(w00, v, v1, e10);
        }
    }

    @Override  // androidx.media3.session.m
    public final void I(k k0, int v, int v1, Bundle bundle0) {
        E e0;
        if(k0 != null && bundle0 != null && v1 >= 0) {
            try {
                e0 = E.b(bundle0);
            }
            catch(RuntimeException runtimeException0) {
                b.E("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", runtimeException0);
                return;
            }
            this.H0(k0, v, 20, new X0(new H0(6, new a3.e(2, e0), new R0(this, v1, 2)), 1));
        }
    }

    public final void I0(w0 w00, int v, int v1, e1 e10) {
        long v2 = Binder.clearCallingIdentity();
        try {
            Object object0 = this.a.get();
            if(((n0)object0) != null && !((n0)object0).l()) {
                W0 w01 = new W0(this, w00, v1, v, ((n0)object0), e10);
                e3.x.P(((n0)object0).l, w01);
            }
        }
        finally {
            Binder.restoreCallingIdentity(v2);
        }
    }

    public static void J0(w0 w00, int v, w1 w10) {
        try {
            b.k(w00.d);
            w00.d.q(v, w10);
        }
        catch(RemoteException remoteException0) {
            b.E("MediaSessionStub", "Failed to send result to controller " + w00, remoteException0);
        }
    }

    @Override  // androidx.media3.session.m
    public final void K(k k0, int v, IBinder iBinder0) {
        p0 p00;
        if(k0 != null && iBinder0 != null) {
            try {
                V v1 = b3.g.a(iBinder0);
                Q q0 = V.o();
                for(int v2 = 0; v2 < v1.size(); ++v2) {
                    Bundle bundle0 = (Bundle)v1.get(v2);
                    bundle0.getClass();
                    q0.a(E.b(bundle0));
                }
                p00 = q0.g();
            }
            catch(RuntimeException runtimeException0) {
                b.E("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", runtimeException0);
                return;
            }
            this.H0(k0, v, 20, new X0(new H0(6, new C5.a(p00, 3), new x(21)), 1));
        }
    }

    public static a0 K0(e e0) {
        return new a0(new a0(e0, 7), 6);
    }

    @Override  // androidx.media3.session.m
    public final void M(k k0, int v, int v1, Bundle bundle0) {
        E e0;
        if(k0 != null && bundle0 != null && v1 >= 0) {
            try {
                e0 = E.b(bundle0);
            }
            catch(RuntimeException runtimeException0) {
                b.E("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", runtimeException0);
                return;
            }
            this.H0(k0, v, 20, new X0(new H0(6, new a3.e(1, e0), new R0(this, v1, 1)), 1));
        }
    }

    @Override  // androidx.media3.session.m
    public final void N(k k0, int v, int v1, int v2) {
        if(k0 != null && v1 >= 0) {
            this.H0(k0, v, 33, f1.K0(new q(v1, v2, 2)));
        }
    }

    @Override  // androidx.media3.session.m
    public final void O(k k0, int v, boolean z) {
        if(k0 == null) {
            return;
        }
        this.H0(k0, v, 26, f1.K0(new a3.a(z, 5)));
    }

    @Override  // androidx.media3.session.m
    public final void P(k k0, int v, int v1) {
        if(k0 != null && v1 >= 0) {
            this.H0(k0, v, 10, new a0(new R0(this, v1, 0), 6));
        }
    }

    @Override  // androidx.media3.session.m
    public final void R(k k0, int v, int v1, long v2) {
        if(k0 != null && v1 >= 0) {
            this.H0(k0, v, 10, new a0(new Y3.m(v1, v2, this), 6));
        }
    }

    @Override  // androidx.media3.session.m
    public final void S(k k0, int v, int v1) {
        if(k0 == null || v1 != 0 && v1 != 2 && v1 != 1) {
            return;
        }
        this.H0(k0, v, 15, f1.K0(new a3.f(v1, 7)));
    }

    @Override  // androidx.media3.session.m
    public final void V(k k0, int v, Bundle bundle0) {
        L l0;
        if(k0 != null && bundle0 != null) {
            try {
                l0 = new L(bundle0.getFloat("0", 1.0f), bundle0.getFloat("1", 1.0f));
            }
            catch(RuntimeException runtimeException0) {
                b.E("MediaSessionStub", "Ignoring malformed Bundle for PlaybackParameters", runtimeException0);
                return;
            }
            this.H0(k0, v, 13, f1.K0(new d(l0, 3)));
        }
    }

    @Override  // androidx.media3.session.m
    public final void W(k k0, int v, int v1, int v2, int v3) {
        if(k0 != null && v1 >= 0 && v2 >= v1 && v3 >= 0) {
            this.H0(k0, v, 20, f1.K0(new T0(v1, v2, v3)));
        }
    }

    @Override  // androidx.media3.session.m
    public final void Z(k k0, int v, Surface surface0) {
        if(k0 == null) {
            return;
        }
        this.H0(k0, v, 27, f1.K0(new a0(surface0, 4)));
    }

    @Override  // androidx.media3.session.m
    public final void a(k k0, int v) {
        if(k0 == null) {
            return;
        }
        this.H0(k0, v, 26, f1.K0(new x(15)));
    }

    @Override  // androidx.media3.session.m
    public final void a0(k k0, int v, int v1, IBinder iBinder0) {
        p0 p00;
        if(k0 != null && iBinder0 != null && v1 >= 0) {
            try {
                V v2 = b3.g.a(iBinder0);
                Q q0 = V.o();
                for(int v3 = 0; v3 < v2.size(); ++v3) {
                    Bundle bundle0 = (Bundle)v2.get(v3);
                    bundle0.getClass();
                    q0.a(E.b(bundle0));
                }
                p00 = q0.g();
            }
            catch(RuntimeException runtimeException0) {
                b.E("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", runtimeException0);
                return;
            }
            this.H0(k0, v, 20, new X0(new H0(6, new C5.a(p00, 2), new R0(this, v1, 3)), 1));
        }
    }

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override  // androidx.media3.session.m
    public final void b(k k0, int v) {
        if(k0 != null) {
            IBinder iBinder0 = k0.asBinder();
            w0 w00 = this.c.l(iBinder0);
            if(w00 != null) {
                this.I0(w00, v, 1, f1.K0(new x(13)));
            }
        }
    }

    @Override  // androidx.media3.session.m
    public final void b0(k k0, int v, Bundle bundle0) {
        G g0;
        if(k0 != null && bundle0 != null) {
            try {
                g0 = G.b(bundle0);
            }
            catch(RuntimeException runtimeException0) {
                b.E("MediaSessionStub", "Ignoring malformed Bundle for MediaMetadata", runtimeException0);
                return;
            }
            this.H0(k0, v, 19, f1.K0(new o(g0, 2)));
        }
    }

    @Override  // androidx.media3.session.m
    public final void d0(k k0, int v) {
        if(k0 == null) {
            return;
        }
        this.H0(k0, v, 2, f1.K0(new x(25)));
    }

    @Override  // androidx.media3.session.m
    public final void h(k k0, int v) {
        if(k0 == null) {
            return;
        }
        this.H0(k0, v, 20, f1.K0(new x(27)));
    }

    @Override  // androidx.media3.session.m
    public final void h0(k k0) {
        if(k0 == null) {
            return;
        }
        long v = Binder.clearCallingIdentity();
        try {
            n0 n00 = (n0)this.a.get();
            if(n00 != null && !n00.l()) {
                IBinder iBinder0 = k0.asBinder();
                w0 w00 = this.c.l(iBinder0);
                if(w00 != null) {
                    A3.m m0 = new A3.m(26, this, w00);
                    e3.x.P(n00.l, m0);
                }
            }
        }
        finally {
            Binder.restoreCallingIdentity(v);
        }
    }

    @Override  // androidx.media3.session.m
    public final void i0(k k0, int v, int v1, int v2) {
        if(k0 != null && v1 >= 0 && v2 >= v1) {
            this.H0(k0, v, 20, new a0(new P0(this, v1, v2), 6));
        }
    }

    @Override  // androidx.media3.session.m
    public final void j(k k0, int v) {
        if(k0 == null) {
            return;
        }
        long v1 = Binder.clearCallingIdentity();
        try {
            n0 n00 = (n0)this.a.get();
            if(n00 != null && !n00.l()) {
                A3.m m0 = new A3.m(25, this, k0);
                e3.x.P(n00.l, m0);
            }
        }
        finally {
            Binder.restoreCallingIdentity(v1);
        }
    }

    @Override  // androidx.media3.session.m
    public final void k(k k0, int v, boolean z) {
        if(k0 == null) {
            return;
        }
        this.H0(k0, v, 14, f1.K0(new a3.a(z, 6)));
    }

    @Override  // androidx.media3.session.m
    public final void l(k k0, int v, Bundle bundle0, boolean z) {
        b3.d d0;
        if(k0 != null && bundle0 != null) {
            try {
                d0 = b3.d.a(bundle0);
            }
            catch(RuntimeException runtimeException0) {
                b.E("MediaSessionStub", "Ignoring malformed Bundle for AudioAttributes", runtimeException0);
                return;
            }
            this.H0(k0, v, 35, f1.K0(new S0(d0, z, 1)));
        }
    }

    @Override  // androidx.media3.session.m
    public final void l0(k k0, int v, Bundle bundle0, boolean z) {
        E e0;
        if(k0 != null && bundle0 != null) {
            try {
                e0 = E.b(bundle0);
            }
            catch(RuntimeException runtimeException0) {
                b.E("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", runtimeException0);
                return;
            }
            this.H0(k0, v, 0x1F, new X0(new H0(5, new S0(e0, z, 0), new x(28)), 1));
        }
    }

    @Override  // androidx.media3.session.m
    public final void m(k k0, int v, int v1) {
        if(k0 != null && v1 >= 0) {
            this.H0(k0, v, 25, f1.K0(new a3.f(v1, 8)));
        }
    }

    @Override  // androidx.media3.session.m
    public final void m0(k k0, int v) {
        if(k0 != null) {
            IBinder iBinder0 = k0.asBinder();
            w0 w00 = this.c.l(iBinder0);
            if(w00 != null) {
                this.I0(w00, v, 3, f1.K0(new x(24)));
            }
        }
    }

    @Override  // androidx.media3.session.m
    public final void n(k k0, int v, IBinder iBinder0, boolean z) {
        p0 p00;
        if(k0 != null && iBinder0 != null) {
            try {
                V v1 = b3.g.a(iBinder0);
                Q q0 = V.o();
                for(int v2 = 0; v2 < v1.size(); ++v2) {
                    Bundle bundle0 = (Bundle)v1.get(v2);
                    bundle0.getClass();
                    q0.a(E.b(bundle0));
                }
                p00 = q0.g();
            }
            catch(RuntimeException runtimeException0) {
                b.E("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", runtimeException0);
                return;
            }
            this.H0(k0, v, 20, new X0(new H0(5, new S0(p00, z, 2), new x(28)), 1));
        }
    }

    @Override  // androidx.media3.session.m
    public final void n0(k k0, int v) {
        if(k0 != null) {
            IBinder iBinder0 = k0.asBinder();
            w0 w00 = this.c.l(iBinder0);
            if(w00 != null) {
                this.I0(w00, v, 12, f1.K0(new x(19)));
            }
        }
    }

    @Override  // androidx.media3.session.m
    public final void o(k k0, int v) {
        if(k0 == null) {
            return;
        }
        this.H0(k0, v, 6, f1.K0(new x(18)));
    }

    @Override  // androidx.media3.session.m
    public final void o0(k k0, int v, int v1, int v2, IBinder iBinder0) {
        p0 p00;
        if(k0 != null && iBinder0 != null && v1 >= 0 && v2 >= v1) {
            try {
                V v3 = b3.g.a(iBinder0);
                Q q0 = V.o();
                for(int v4 = 0; v4 < v3.size(); ++v4) {
                    Bundle bundle0 = (Bundle)v3.get(v4);
                    bundle0.getClass();
                    q0.a(E.b(bundle0));
                }
                p00 = q0.g();
            }
            catch(RuntimeException runtimeException0) {
                b.E("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", runtimeException0);
                return;
            }
            this.H0(k0, v, 20, new X0(new H0(6, new a0(p00, 3), new P0(this, v1, v2)), 1));
        }
    }

    @Override  // android.os.Binder
    public final boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
        d0 d04;
        d0 d03;
        d0 d02;
        d0 d01;
        d0 d00;
        T t1;
        T t0;
        E e0;
        if(v >= 1 && v <= 0xFFFFFF) {
            parcel0.enforceInterface("androidx.media3.session.IMediaSession");
        }
        if(v != 0x5F4E5446) {
            boolean z = false;
            switch(v) {
                case 3002: {
                    this.E(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), parcel0.readFloat());
                    return true;
                }
                case 3003: {
                    this.m(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), parcel0.readInt());
                    return true;
                }
                case 3004: {
                    this.a(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt());
                    return true;
                }
                case 3005: {
                    this.u0(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt());
                    return true;
                }
                case 3006: {
                    k k0 = androidx.media3.session.c0.C0(parcel0.readStrongBinder());
                    int v2 = parcel0.readInt();
                    if(parcel0.readInt() != 0) {
                        z = true;
                    }
                    this.O(k0, v2, z);
                    return true;
                }
                case 3007: {
                    this.l0(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), ((Bundle)y5.a.c(parcel0, Bundle.CREATOR)), true);
                    return true;
                }
                case 3008: {
                    this.y(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), ((Bundle)y5.a.c(parcel0, Bundle.CREATOR)), parcel0.readLong());
                    return true;
                }
                case 3009: {
                    k k1 = androidx.media3.session.c0.C0(parcel0.readStrongBinder());
                    int v3 = parcel0.readInt();
                    Bundle bundle0 = (Bundle)y5.a.c(parcel0, Bundle.CREATOR);
                    if(parcel0.readInt() != 0) {
                        z = true;
                    }
                    this.l0(k1, v3, bundle0, z);
                    return true;
                }
                case 3010: {
                    this.n(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), parcel0.readStrongBinder(), true);
                    return true;
                }
                case 3011: {
                    k k2 = androidx.media3.session.c0.C0(parcel0.readStrongBinder());
                    int v4 = parcel0.readInt();
                    IBinder iBinder0 = parcel0.readStrongBinder();
                    if(parcel0.readInt() != 0) {
                        z = true;
                    }
                    this.n(k2, v4, iBinder0, z);
                    return true;
                }
                case 3012: {
                    this.z0(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), parcel0.readStrongBinder(), parcel0.readInt(), parcel0.readLong());
                    return true;
                }
                case 3013: {
                    k k3 = androidx.media3.session.c0.C0(parcel0.readStrongBinder());
                    int v5 = parcel0.readInt();
                    if(parcel0.readInt() != 0) {
                        z = true;
                    }
                    this.q0(k3, v5, z);
                    return true;
                }
                case 3014: {
                    this.F(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), ((Bundle)y5.a.c(parcel0, Bundle.CREATOR)));
                    return true;
                }
                case 3015: {
                    this.s(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), ((Bundle)y5.a.c(parcel0, Bundle.CREATOR)));
                    return true;
                }
                case 3016: {
                    k k4 = androidx.media3.session.c0.C0(parcel0.readStrongBinder());
                    int v6 = parcel0.readInt();
                    Parcelable.Creator parcelable$Creator0 = Bundle.CREATOR;
                    this.x0(k4, v6, ((Bundle)y5.a.c(parcel0, parcelable$Creator0)), ((Bundle)y5.a.c(parcel0, parcelable$Creator0)));
                    return true;
                }
                case 3017: {
                    this.S(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), parcel0.readInt());
                    return true;
                }
                case 3018: {
                    k k5 = androidx.media3.session.c0.C0(parcel0.readStrongBinder());
                    int v7 = parcel0.readInt();
                    if(parcel0.readInt() != 0) {
                        z = true;
                    }
                    this.k(k5, v7, z);
                    return true;
                }
                case 3019: {
                    this.A(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), parcel0.readInt());
                    return true;
                }
                case 3020: {
                    this.i0(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), parcel0.readInt(), parcel0.readInt());
                    return true;
                }
                case 3021: {
                    this.h(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt());
                    return true;
                }
                case 3022: {
                    this.G(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), parcel0.readInt(), parcel0.readInt());
                    return true;
                }
                case 0xBCF: {
                    this.W(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), parcel0.readInt(), parcel0.readInt(), parcel0.readInt());
                    return true;
                }
                case 0xBD0: {
                    this.p0(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt());
                    return true;
                }
                case 3025: {
                    this.b(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt());
                    return true;
                }
                case 3026: {
                    this.d0(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt());
                    return true;
                }
                case 3027: {
                    this.V(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), ((Bundle)y5.a.c(parcel0, Bundle.CREATOR)));
                    return true;
                }
                case 3028: {
                    this.H(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), parcel0.readFloat());
                    return true;
                }
                case 3029: {
                    k k8 = androidx.media3.session.c0.C0(parcel0.readStrongBinder());
                    int v10 = parcel0.readInt();
                    Bundle bundle2 = (Bundle)y5.a.c(parcel0, Bundle.CREATOR);
                    if(k8 != null && bundle2 != null) {
                        try {
                            e0 = E.b(bundle2);
                        }
                        catch(RuntimeException runtimeException0) {
                            b.E("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", runtimeException0);
                            return true;
                        }
                        this.H0(k8, v10, 20, new X0(new H0(6, new a3.e(3, e0), new x(23)), 1));
                        return true;
                    }
                    break;
                }
                case 3030: {
                    this.M(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), parcel0.readInt(), ((Bundle)y5.a.c(parcel0, Bundle.CREATOR)));
                    return true;
                }
                case 3031: {
                    this.K(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), parcel0.readStrongBinder());
                    return true;
                }
                case 3032: {
                    this.a0(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), parcel0.readInt(), parcel0.readStrongBinder());
                    return true;
                }
                case 3033: {
                    this.b0(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), ((Bundle)y5.a.c(parcel0, Bundle.CREATOR)));
                    return true;
                }
                case 3034: {
                    this.m0(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt());
                    return true;
                }
                case 3035: {
                    this.j(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt());
                    return true;
                }
                case 3036: {
                    this.w(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt());
                    return true;
                }
                case 3037: {
                    this.P(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), parcel0.readInt());
                    return true;
                }
                case 3038: {
                    this.C(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), parcel0.readLong());
                    return true;
                }
                case 0xBDF: {
                    this.R(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), parcel0.readInt(), parcel0.readLong());
                    return true;
                }
                case 3040: {
                    this.s0(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt());
                    return true;
                }
                case 3041: {
                    this.n0(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt());
                    return true;
                }
                case 3042: {
                    this.o(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt());
                    return true;
                }
                case 3043: {
                    this.B(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt());
                    return true;
                }
                case 3044: {
                    this.Z(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), ((Surface)y5.a.c(parcel0, Surface.CREATOR)));
                    return true;
                }
                case 3045: {
                    this.h0(androidx.media3.session.c0.C0(parcel0.readStrongBinder()));
                    return true;
                }
                case 3046: {
                    this.v(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt());
                    return true;
                }
                case 3047: {
                    this.p(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt());
                    return true;
                }
                case 3048: {
                    this.B0(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), ((Bundle)y5.a.c(parcel0, Bundle.CREATOR)));
                    return true;
                }
                case 3049: {
                    k k9 = androidx.media3.session.c0.C0(parcel0.readStrongBinder());
                    int v11 = parcel0.readInt();
                    String s = parcel0.readString();
                    Bundle bundle3 = (Bundle)y5.a.c(parcel0, Bundle.CREATOR);
                    if(k9 != null && s != null && bundle3 != null) {
                        if(TextUtils.isEmpty(s)) {
                            b.D("MediaSessionStub", "setRatingWithMediaId(): Ignoring empty mediaId");
                            return true;
                        }
                        try {
                            t0 = T.a(bundle3);
                        }
                        catch(RuntimeException runtimeException1) {
                            b.E("MediaSessionStub", "Ignoring malformed Bundle for Rating", runtimeException1);
                            return true;
                        }
                        this.D0(k9, v11, null, 40010, new X0(new H0(4, s, t0), 1));
                        return true;
                    }
                    break;
                }
                case 3050: {
                    k k10 = androidx.media3.session.c0.C0(parcel0.readStrongBinder());
                    int v12 = parcel0.readInt();
                    Bundle bundle4 = (Bundle)y5.a.c(parcel0, Bundle.CREATOR);
                    if(k10 != null && bundle4 != null) {
                        try {
                            t1 = T.a(bundle4);
                        }
                        catch(RuntimeException runtimeException2) {
                            b.E("MediaSessionStub", "Ignoring malformed Bundle for Rating", runtimeException2);
                            return true;
                        }
                        this.D0(k10, v12, null, 40010, new X0(new a0(t1, 8), 1));
                        return true;
                    }
                    break;
                }
                case 3051: {
                    this.N(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), parcel0.readInt(), parcel0.readInt());
                    return true;
                }
                case 3052: {
                    this.r0(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), parcel0.readInt());
                    return true;
                }
                case 3053: {
                    this.x(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), parcel0.readInt());
                    return true;
                }
                case 3054: {
                    k k6 = androidx.media3.session.c0.C0(parcel0.readStrongBinder());
                    int v8 = parcel0.readInt();
                    if(parcel0.readInt() != 0) {
                        z = true;
                    }
                    this.w0(k6, v8, z, parcel0.readInt());
                    return true;
                }
                case 0xBEF: {
                    this.I(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), parcel0.readInt(), ((Bundle)y5.a.c(parcel0, Bundle.CREATOR)));
                    return true;
                }
                case 0xBF0: {
                    this.o0(androidx.media3.session.c0.C0(parcel0.readStrongBinder()), parcel0.readInt(), parcel0.readInt(), parcel0.readInt(), parcel0.readStrongBinder());
                    return true;
                }
                case 0xBF1: {
                    k k7 = androidx.media3.session.c0.C0(parcel0.readStrongBinder());
                    int v9 = parcel0.readInt();
                    Bundle bundle1 = (Bundle)y5.a.c(parcel0, Bundle.CREATOR);
                    if(parcel0.readInt() != 0) {
                        z = true;
                    }
                    this.l(k7, v9, bundle1, z);
                    return true;
                }
                case 4001: {
                    k k11 = androidx.media3.session.c0.C0(parcel0.readStrongBinder());
                    int v13 = parcel0.readInt();
                    Bundle bundle5 = (Bundle)y5.a.c(parcel0, Bundle.CREATOR);
                    if(k11 != null) {
                        if(bundle5 == null) {
                            d00 = null;
                        }
                        else {
                            try {
                                d00 = d0.a(bundle5);
                            }
                            catch(RuntimeException runtimeException3) {
                                b.E("MediaSessionStub", "Ignoring malformed Bundle for LibraryParams", runtimeException3);
                                return true;
                            }
                        }
                        this.D0(k11, v13, null, 50000, new X0(new a0(d00, 5), 0));
                        return true;
                    }
                    break;
                }
                case 4002: {
                    k k12 = androidx.media3.session.c0.C0(parcel0.readStrongBinder());
                    int v14 = parcel0.readInt();
                    String s1 = parcel0.readString();
                    if(k12 != null) {
                        if(TextUtils.isEmpty(s1)) {
                            b.D("MediaSessionStub", "getItem(): Ignoring empty mediaId");
                            return true;
                        }
                        this.D0(k12, v14, null, 50004, new X0(new T7.a(s1, 5), 0));
                        return true;
                    }
                    break;
                }
                case 4003: {
                    k k13 = androidx.media3.session.c0.C0(parcel0.readStrongBinder());
                    int v15 = parcel0.readInt();
                    String s2 = parcel0.readString();
                    int v16 = parcel0.readInt();
                    int v17 = parcel0.readInt();
                    Bundle bundle6 = (Bundle)y5.a.c(parcel0, Bundle.CREATOR);
                    if(k13 != null) {
                        if(TextUtils.isEmpty(s2)) {
                            b.D("MediaSessionStub", "getChildren(): Ignoring empty parentId");
                            return true;
                        }
                        if(v16 < 0) {
                            b.D("MediaSessionStub", "getChildren(): Ignoring negative page");
                            return true;
                        }
                        if(v17 < 1) {
                            b.D("MediaSessionStub", "getChildren(): Ignoring pageSize less than 1");
                            return true;
                        }
                        if(bundle6 == null) {
                            d01 = null;
                        }
                        else {
                            try {
                                d01 = d0.a(bundle6);
                            }
                            catch(RuntimeException runtimeException4) {
                                b.E("MediaSessionStub", "Ignoring malformed Bundle for LibraryParams", runtimeException4);
                                return true;
                            }
                        }
                        this.D0(k13, v15, null, 50003, new X0(new Q0(s2, v16, v17, d01, 0), 0));
                        return true;
                    }
                    break;
                }
                case 4004: {
                    k k14 = androidx.media3.session.c0.C0(parcel0.readStrongBinder());
                    int v18 = parcel0.readInt();
                    String s3 = parcel0.readString();
                    Bundle bundle7 = (Bundle)y5.a.c(parcel0, Bundle.CREATOR);
                    if(k14 != null) {
                        if(TextUtils.isEmpty(s3)) {
                            b.D("MediaSessionStub", "search(): Ignoring empty query");
                            return true;
                        }
                        if(bundle7 == null) {
                            d02 = null;
                        }
                        else {
                            try {
                                d02 = d0.a(bundle7);
                            }
                            catch(RuntimeException runtimeException5) {
                                b.E("MediaSessionStub", "Ignoring malformed Bundle for LibraryParams", runtimeException5);
                                return true;
                            }
                        }
                        this.D0(k14, v18, null, 50005, new X0(new U0(s3, d02, 1), 0));
                        return true;
                    }
                    break;
                }
                case 4005: {
                    k k15 = androidx.media3.session.c0.C0(parcel0.readStrongBinder());
                    int v19 = parcel0.readInt();
                    String s4 = parcel0.readString();
                    int v20 = parcel0.readInt();
                    int v21 = parcel0.readInt();
                    Bundle bundle8 = (Bundle)y5.a.c(parcel0, Bundle.CREATOR);
                    if(k15 != null) {
                        if(TextUtils.isEmpty(s4)) {
                            b.D("MediaSessionStub", "getSearchResult(): Ignoring empty query");
                            return true;
                        }
                        if(v20 < 0) {
                            b.D("MediaSessionStub", "getSearchResult(): Ignoring negative page");
                            return true;
                        }
                        if(v21 < 1) {
                            b.D("MediaSessionStub", "getSearchResult(): Ignoring pageSize less than 1");
                            return true;
                        }
                        if(bundle8 == null) {
                            d03 = null;
                        }
                        else {
                            try {
                                d03 = d0.a(bundle8);
                            }
                            catch(RuntimeException runtimeException6) {
                                b.E("MediaSessionStub", "Ignoring malformed Bundle for LibraryParams", runtimeException6);
                                return true;
                            }
                        }
                        this.D0(k15, v19, null, 50006, new X0(new Q0(s4, v20, v21, d03, 1), 0));
                        return true;
                    }
                    break;
                }
                case 4006: {
                    k k16 = androidx.media3.session.c0.C0(parcel0.readStrongBinder());
                    int v22 = parcel0.readInt();
                    String s5 = parcel0.readString();
                    Bundle bundle9 = (Bundle)y5.a.c(parcel0, Bundle.CREATOR);
                    if(k16 != null) {
                        if(TextUtils.isEmpty(s5)) {
                            b.D("MediaSessionStub", "subscribe(): Ignoring empty parentId");
                            return true;
                        }
                        if(bundle9 == null) {
                            d04 = null;
                        }
                        else {
                            try {
                                d04 = d0.a(bundle9);
                            }
                            catch(RuntimeException runtimeException7) {
                                b.E("MediaSessionStub", "Ignoring malformed Bundle for LibraryParams", runtimeException7);
                                return true;
                            }
                        }
                        this.D0(k16, v22, null, 50001, new X0(new U0(s5, d04, 0), 0));
                        return true;
                    }
                    break;
                }
                case 4007: {
                    k k17 = androidx.media3.session.c0.C0(parcel0.readStrongBinder());
                    int v23 = parcel0.readInt();
                    String s6 = parcel0.readString();
                    if(k17 != null) {
                        if(TextUtils.isEmpty(s6)) {
                            b.D("MediaSessionStub", "unsubscribe(): Ignoring empty parentId");
                            return true;
                        }
                        this.D0(k17, v23, null, 50002, new X0(new T7.a(s6, 4), 0));
                        return true;
                    }
                    break;
                }
                default: {
                    return super.onTransact(v, parcel0, parcel1, v1);
                }
            }
            return true;
        }
        parcel1.writeString("androidx.media3.session.IMediaSession");
        return true;
    }

    @Override  // androidx.media3.session.m
    public final void p(k k0, int v) {
        if(k0 != null) {
            IBinder iBinder0 = k0.asBinder();
            w0 w00 = this.c.l(iBinder0);
            if(w00 != null) {
                this.I0(w00, v, 9, f1.K0(new x(20)));
            }
        }
    }

    @Override  // androidx.media3.session.m
    public final void p0(k k0, int v) {
        if(k0 != null) {
            IBinder iBinder0 = k0.asBinder();
            w0 w00 = this.c.l(iBinder0);
            if(w00 != null) {
                this.I0(w00, v, 1, f1.K0(new H0(3, this, w00)));
            }
        }
    }

    @Override  // androidx.media3.session.m
    public final void q0(k k0, int v, boolean z) {
        if(k0 == null) {
            return;
        }
        this.H0(k0, v, 1, f1.K0(new a3.a(z, 4)));
    }

    @Override  // androidx.media3.session.m
    public final void r0(k k0, int v, int v1) {
        if(k0 == null) {
            return;
        }
        this.H0(k0, v, 34, f1.K0(new a3.f(v1, 6)));
    }

    @Override  // androidx.media3.session.m
    public final void s(k k0, int v, Bundle bundle0) {
        androidx.media3.session.g g0;
        if(k0 != null && bundle0 != null) {
            try {
                g0 = androidx.media3.session.g.a(bundle0);
            }
            catch(RuntimeException runtimeException0) {
                b.E("MediaSessionStub", "Ignoring malformed Bundle for ConnectionRequest", runtimeException0);
                return;
            }
            int v1 = Binder.getCallingUid();
            int v2 = Binder.getCallingPid();
            long v3 = Binder.clearCallingIdentity();
            if(v2 == 0) {
                v2 = g0.d;
            }
            try {
                b0 b00 = new b0(g0.c, v2, v1);
                boolean z = this.b.b(b00);
                b1 b10 = new b1(k0, g0.b);
                this.C0(k0, new w0(b00, g0.a, g0.b, z, b10, g0.e));
            }
            finally {
                Binder.restoreCallingIdentity(v3);
            }
        }
    }

    @Override  // androidx.media3.session.m
    public final void s0(k k0, int v) {
        if(k0 != null) {
            IBinder iBinder0 = k0.asBinder();
            w0 w00 = this.c.l(iBinder0);
            if(w00 != null) {
                this.I0(w00, v, 11, f1.K0(new x(16)));
            }
        }
    }

    @Override  // androidx.media3.session.m
    public final void u0(k k0, int v) {
        if(k0 == null) {
            return;
        }
        this.H0(k0, v, 26, f1.K0(new x(22)));
    }

    @Override  // androidx.media3.session.m
    public final void v(k k0, int v) {
        if(k0 != null) {
            IBinder iBinder0 = k0.asBinder();
            w0 w00 = this.c.l(iBinder0);
            if(w00 != null) {
                this.I0(w00, v, 7, f1.K0(new x(17)));
            }
        }
    }

    @Override  // androidx.media3.session.m
    public final void w(k k0, int v) {
        if(k0 == null) {
            return;
        }
        this.H0(k0, v, 4, f1.K0(new x(26)));
    }

    @Override  // androidx.media3.session.m
    public final void w0(k k0, int v, boolean z, int v1) {
        if(k0 == null) {
            return;
        }
        this.H0(k0, v, 34, f1.K0(new a3.g(z, v1, 2)));
    }

    @Override  // androidx.media3.session.m
    public final void x(k k0, int v, int v1) {
        if(k0 == null) {
            return;
        }
        this.H0(k0, v, 34, f1.K0(new a3.f(v1, 5)));
    }

    @Override  // androidx.media3.session.m
    public final void x0(k k0, int v, Bundle bundle0, Bundle bundle1) {
        s1 s10;
        if(k0 != null && bundle0 != null && bundle1 != null) {
            try {
                s10 = s1.a(bundle0);
            }
            catch(RuntimeException runtimeException0) {
                b.E("MediaSessionStub", "Ignoring malformed Bundle for SessionCommand", runtimeException0);
                return;
            }
            this.D0(k0, v, s10, 0, new X0(new H0(2, s10, bundle1), 1));
        }
    }

    @Override  // androidx.media3.session.m
    public final void y(k k0, int v, Bundle bundle0, long v1) {
        E e0;
        if(k0 != null && bundle0 != null) {
            try {
                e0 = E.b(bundle0);
            }
            catch(RuntimeException runtimeException0) {
                b.E("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", runtimeException0);
                return;
            }
            this.H0(k0, v, 0x1F, new X0(new H0(5, new X5.f(e0, v1), new x(28)), 1));
        }
    }

    @Override  // androidx.media3.session.m
    public final void z0(k k0, int v, IBinder iBinder0, int v1, long v2) {
        p0 p00;
        if(k0 != null && iBinder0 != null && (v1 == -1 || v1 >= 0)) {
            try {
                V v3 = b3.g.a(iBinder0);
                Q q0 = V.o();
                for(int v4 = 0; v4 < v3.size(); ++v4) {
                    Bundle bundle0 = (Bundle)v3.get(v4);
                    bundle0.getClass();
                    q0.a(E.b(bundle0));
                }
                p00 = q0.g();
            }
            catch(RuntimeException runtimeException0) {
                b.E("MediaSessionStub", "Ignoring malformed Bundle for MediaItem", runtimeException0);
                return;
            }
            this.H0(k0, v, 20, new X0(new H0(5, new Y3.m(v1, v2, p00), new x(28)), 1));
        }
    }
}

