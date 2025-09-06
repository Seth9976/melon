package androidx.media3.session;

import A3.m;
import A6.d;
import A6.e;
import Ac.X3;
import B9.g;
import I6.V;
import I6.p0;
import a3.f;
import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import b3.N;
import e3.b;
import e3.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import x1.a;

public final class c0 extends Binder implements k {
    public final WeakReference a;

    public c0(Q q0) {
        this.attachInterface(this, "androidx.media3.session.IMediaController");
        this.a = new WeakReference(q0);
    }

    public static k C0(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("androidx.media3.session.IMediaController");
        if(iInterface0 != null && iInterface0 instanceof k) {
            return (k)iInterface0;
        }
        k k0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
        k0.a = iBinder0;
        return k0;
    }

    public final void D0(b0 b00) {
        long v = Binder.clearCallingIdentity();
        try {
            Q q0 = (Q)this.a.get();
            if(q0 == null) {
                return;
            }
            m m0 = new m(16, q0, b00);
            x.P(q0.a.e, m0);
        }
        finally {
            Binder.restoreCallingIdentity(v);
        }
    }

    public final int E0() {
        Q q0 = (Q)this.a.get();
        if(q0 != null) {
            return q0.k == null ? -1 : q0.k.a.c();
        }
        return -1;
    }

    public final void F0(int v, Object object0) {
        long v1 = Binder.clearCallingIdentity();
        try {
            Q q0 = (Q)this.a.get();
            if(q0 == null) {
                return;
            }
            q0.b.t(v, object0);
            d d0 = new d(q0, v, 7);
            q0.a.f0(d0);
        }
        finally {
            Binder.restoreCallingIdentity(v1);
        }
    }

    @Override  // androidx.media3.session.k
    public final void J(int v, Bundle bundle0) {
        w1 w10;
        if(bundle0 == null) {
            return;
        }
        try {
            w10 = w1.a(bundle0);
        }
        catch(RuntimeException runtimeException0) {
            b.E("MediaControllerStub", "Ignoring malformed Bundle for SessionResult", runtimeException0);
            return;
        }
        this.F0(v, w10);
    }

    @Override  // androidx.media3.session.k
    public final void Y(int v, Bundle bundle0) {
        try {
            u1.a(bundle0);
        }
        catch(RuntimeException runtimeException0) {
            b.E("MediaControllerStub", "Ignoring malformed Bundle for SessionError", runtimeException0);
            return;
        }
        this.D0(new androidx.media3.exoplayer.x(4));
    }

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override  // androidx.media3.session.k
    public final void c0(int v, Bundle bundle0) {
        N n0;
        if(bundle0 == null) {
            return;
        }
        try {
            n0 = N.b(bundle0);
        }
        catch(RuntimeException runtimeException0) {
            b.E("MediaControllerStub", "Ignoring malformed Bundle for Commands", runtimeException0);
            return;
        }
        this.D0(new Z(n0));
    }

    @Override  // androidx.media3.session.k
    public final void d() {
        this.D0(new androidx.media3.exoplayer.x(6));
    }

    @Override  // androidx.media3.session.k
    public final void e(int v) {
        this.D0(new androidx.media3.exoplayer.x(5));
    }

    @Override  // androidx.media3.session.k
    public final void e0(int v, Bundle bundle0) {
        v1 v10;
        if(bundle0 == null) {
            return;
        }
        try {
            v10 = v1.b(bundle0);
        }
        catch(RuntimeException runtimeException0) {
            b.E("MediaControllerStub", "Ignoring malformed Bundle for SessionPositionInfo", runtimeException0);
            return;
        }
        this.D0(new X3(v10, 29));
    }

    @Override  // androidx.media3.session.k
    public final void f(int v, List list0) {
        p0 p00;
        try {
            if(list0 == null) {
                return;
            }
            int v1 = this.E0();
            if(v1 == -1) {
                return;
            }
            I6.Q q0 = V.o();
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                Bundle bundle0 = (Bundle)list0.get(v2);
                bundle0.getClass();
                q0.a(androidx.media3.session.b.a(v1, bundle0));
            }
            p00 = q0.g();
        }
        catch(RuntimeException runtimeException0) {
            b.E("MediaControllerStub", "Ignoring malformed Bundle for CommandButton", runtimeException0);
            return;
        }
        this.D0(new e(v, p00, 3));
    }

    @Override  // androidx.media3.session.k
    public final void g0(int v, Bundle bundle0, Bundle bundle1) {
        i1 i10;
        k1 k10;
        if(bundle0 != null && bundle1 != null) {
            try {
                int v1 = this.E0();
                if(v1 != -1) {
                    k10 = k1.r(v1, bundle0);
                    goto label_8;
                }
            }
            catch(RuntimeException runtimeException0) {
                b.E("MediaControllerStub", "Ignoring malformed Bundle for PlayerInfo", runtimeException0);
            }
            return;
            try {
            label_8:
                i10 = new i1(bundle1.getBoolean("0", false), bundle1.getBoolean("1", false));
            }
            catch(RuntimeException runtimeException1) {
                b.E("MediaControllerStub", "Ignoring malformed Bundle for BundlingExclusions", runtimeException1);
                return;
            }
            this.D0(new g(26, k10, i10));
        }
    }

    @Override  // androidx.media3.session.k
    public final void i(int v, Bundle bundle0) {
        i i0;
        if(bundle0 == null) {
            return;
        }
        try {
            i0 = i.a(bundle0);
        }
        catch(RuntimeException runtimeException0) {
            b.E("MediaControllerStub", "Malformed Bundle for ConnectionResult. Disconnected from the session.", runtimeException0);
            this.d();
            return;
        }
        this.D0(new a0(i0, 0));
    }

    @Override  // android.os.Binder
    public final boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
        p0 p00;
        N n0;
        t1 t10;
        s1 s10;
        if(v >= 1 && v <= 0xFFFFFF) {
            parcel0.enforceInterface("androidx.media3.session.IMediaController");
        }
        switch(v) {
            case 4001: {
                this.v0(parcel0.readInt(), parcel0.readString(), parcel0.readInt(), ((Bundle)a.i(parcel0, Bundle.CREATOR)));
                return true;
            }
            case 4002: {
                parcel0.readInt();
                String s = parcel0.readString();
                int v8 = parcel0.readInt();
                Bundle bundle6 = (Bundle)a.i(parcel0, Bundle.CREATOR);
                if(TextUtils.isEmpty(s)) {
                    b.D("MediaControllerStub", "onSearchResultChanged(): Ignoring empty query");
                    return true;
                }
                if(v8 < 0) {
                    com.iloen.melon.utils.a.r(v8, "onSearchResultChanged(): Ignoring negative itemCount: ", "MediaControllerStub");
                    return true;
                }
                if(bundle6 != null) {
                    try {
                        d0.a(bundle6);
                    }
                    catch(RuntimeException runtimeException4) {
                        b.E("MediaControllerStub", "Ignoring malformed Bundle for LibraryParams", runtimeException4);
                        return true;
                    }
                }
                this.D0(new androidx.media3.exoplayer.x(7));
                return true;
            }
            case 0x5F4E5446: {
                parcel1.writeString("androidx.media3.session.IMediaController");
                return true;
            }
            default: {
                int v2 = 0;
                switch(v) {
                    case 3001: {
                        this.i(parcel0.readInt(), ((Bundle)a.i(parcel0, Bundle.CREATOR)));
                        return true;
                    }
                    case 3002: {
                        this.J(parcel0.readInt(), ((Bundle)a.i(parcel0, Bundle.CREATOR)));
                        return true;
                    }
                    case 3003: {
                        this.q(parcel0.readInt(), ((Bundle)a.i(parcel0, Bundle.CREATOR)));
                        return true;
                    }
                    case 3004: {
                        this.f(parcel0.readInt(), parcel0.createTypedArrayList(Bundle.CREATOR));
                        return true;
                    }
                    case 3005: {
                        int v3 = parcel0.readInt();
                        Parcelable.Creator parcelable$Creator0 = Bundle.CREATOR;
                        Bundle bundle0 = (Bundle)a.i(parcel0, parcelable$Creator0);
                        Bundle bundle1 = (Bundle)a.i(parcel0, parcelable$Creator0);
                        if(bundle0 != null && bundle1 != null) {
                            try {
                                s10 = s1.a(bundle0);
                            }
                            catch(RuntimeException runtimeException0) {
                                b.E("MediaControllerStub", "Ignoring malformed Bundle for SessionCommand", runtimeException0);
                                return true;
                            }
                            this.D0(new f(v3, s10, bundle1));
                            return true;
                        }
                        b.D("MediaControllerStub", "Ignoring custom command with null args.");
                        return true;
                    }
                    case 3006: {
                        parcel0.readInt();
                        this.d();
                        return true;
                    }
                    case 3007: {
                        int v4 = parcel0.readInt();
                        Bundle bundle2 = (Bundle)a.i(parcel0, Bundle.CREATOR);
                        if(parcel0.readInt() != 0) {
                            v2 = 1;
                        }
                        this.u(bundle2, v4, ((boolean)v2));
                        return true;
                    }
                    case 3008: {
                        this.e0(parcel0.readInt(), ((Bundle)a.i(parcel0, Bundle.CREATOR)));
                        return true;
                    }
                    case 3009: {
                        this.c0(parcel0.readInt(), ((Bundle)a.i(parcel0, Bundle.CREATOR)));
                        return true;
                    }
                    case 3010: {
                        parcel0.readInt();
                        Parcelable.Creator parcelable$Creator2 = Bundle.CREATOR;
                        Bundle bundle3 = (Bundle)a.i(parcel0, parcelable$Creator2);
                        Bundle bundle4 = (Bundle)a.i(parcel0, parcelable$Creator2);
                        if(bundle3 != null && bundle4 != null) {
                            try {
                                t10 = t1.b(bundle3);
                            }
                            catch(RuntimeException runtimeException1) {
                                b.E("MediaControllerStub", "Ignoring malformed Bundle for SessionCommands", runtimeException1);
                                return true;
                            }
                            try {
                                n0 = N.b(bundle4);
                            }
                            catch(RuntimeException runtimeException2) {
                                b.E("MediaControllerStub", "Ignoring malformed Bundle for Commands", runtimeException2);
                                return true;
                            }
                            this.D0(new g(27, t10, n0));
                            return true;
                        }
                        break;
                    }
                    case 3011: {
                        this.e(parcel0.readInt());
                        return true;
                    }
                    case 3012: {
                        this.t0(parcel0.readInt(), ((Bundle)a.i(parcel0, Bundle.CREATOR)));
                        return true;
                    }
                    case 3013: {
                        int v5 = parcel0.readInt();
                        Parcelable.Creator parcelable$Creator1 = Bundle.CREATOR;
                        this.g0(v5, ((Bundle)a.i(parcel0, parcelable$Creator1)), ((Bundle)a.i(parcel0, parcelable$Creator1)));
                        return true;
                    }
                    case 3014: {
                        parcel0.readInt();
                        if(((PendingIntent)a.i(parcel0, PendingIntent.CREATOR)) == null) {
                            b.D("MediaControllerStub", "Ignoring null session activity intent");
                            return true;
                        }
                        this.D0(new androidx.media3.exoplayer.x(8));
                        return true;
                    }
                    case 3015: {
                        this.Y(parcel0.readInt(), ((Bundle)a.i(parcel0, Bundle.CREATOR)));
                        return true;
                    }
                    case 3016: {
                        int v6 = parcel0.readInt();
                        ArrayList arrayList0 = parcel0.createTypedArrayList(Bundle.CREATOR);
                        if(arrayList0 != null) {
                            try {
                                int v7 = this.E0();
                                if(v7 != -1) {
                                    I6.Q q0 = V.o();
                                    while(v2 < arrayList0.size()) {
                                        Bundle bundle5 = (Bundle)arrayList0.get(v2);
                                        bundle5.getClass();
                                        q0.a(androidx.media3.session.b.a(v7, bundle5));
                                        ++v2;
                                    }
                                    p00 = q0.g();
                                    goto label_87;
                                }
                                break;
                            }
                            catch(RuntimeException runtimeException3) {
                                b.E("MediaControllerStub", "Ignoring malformed Bundle for CommandButton", runtimeException3);
                                return true;
                            }
                        label_87:
                            this.D0(new e(v6, p00, 2));
                            return true;
                        }
                        break;
                    }
                    default: {
                        return super.onTransact(v, parcel0, parcel1, v1);
                    }
                }
                try {
                }
                catch(RuntimeException runtimeException3) {
                    b.E("MediaControllerStub", "Ignoring malformed Bundle for CommandButton", runtimeException3);
                }
                return true;
            }
        }
    }

    @Override  // androidx.media3.session.k
    public final void q(int v, Bundle bundle0) {
        r r0;
        if(bundle0 == null) {
            return;
        }
        try {
            r0 = r.a(bundle0);
        }
        catch(RuntimeException runtimeException0) {
            b.E("MediaControllerStub", "Ignoring malformed Bundle for LibraryResult", runtimeException0);
            return;
        }
        this.F0(v, r0);
    }

    @Override  // androidx.media3.session.k
    public final void t0(int v, Bundle bundle0) {
        if(bundle0 == null) {
            b.D("MediaControllerStub", "Ignoring null Bundle for extras");
            return;
        }
        this.D0(new androidx.media3.exoplayer.x(9));
    }

    @Override  // androidx.media3.session.k
    public final void u(Bundle bundle0, int v, boolean z) {
        Bundle bundle1 = new Bundle();
        bundle1.putBoolean("0", z);
        bundle1.putBoolean("1", true);
        this.g0(v, bundle0, bundle1);
    }

    @Override  // androidx.media3.session.k
    public final void v0(int v, String s, int v1, Bundle bundle0) {
        if(TextUtils.isEmpty(s)) {
            b.D("MediaControllerStub", "onChildrenChanged(): Ignoring empty parentId");
            return;
        }
        if(v1 < 0) {
            com.iloen.melon.utils.a.r(v1, "onChildrenChanged(): Ignoring negative itemCount: ", "MediaControllerStub");
            return;
        }
        if(bundle0 != null) {
            try {
                d0.a(bundle0);
            }
            catch(RuntimeException runtimeException0) {
                b.E("MediaControllerStub", "Ignoring malformed Bundle for LibraryParams", runtimeException0);
                return;
            }
        }
        this.D0(new androidx.media3.exoplayer.x(7));
    }
}

