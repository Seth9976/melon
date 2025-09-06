package androidx.media3.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.view.Surface;
import y5.a;

public final class l implements m {
    public IBinder a;

    @Override  // androidx.media3.session.m
    public final void A(k k0, int v, int v1) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeInt(v1);
            this.a.transact(3019, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void B(k k0, int v) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            this.a.transact(3043, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void B0(k k0, int v, Bundle bundle0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            a.d(parcel0, bundle0);
            this.a.transact(3048, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void C(k k0, int v, long v1) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeLong(v1);
            this.a.transact(3038, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void E(k k0, int v, float f) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeFloat(f);
            this.a.transact(3002, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void F(k k0, int v, Bundle bundle0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            a.d(parcel0, bundle0);
            this.a.transact(3014, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void G(k k0, int v, int v1, int v2) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeInt(v1);
            parcel0.writeInt(v2);
            this.a.transact(3022, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void H(k k0, int v, float f) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeFloat(f);
            this.a.transact(3028, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void I(k k0, int v, int v1, Bundle bundle0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeInt(v1);
            a.d(parcel0, bundle0);
            this.a.transact(0xBEF, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void K(k k0, int v, IBinder iBinder0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeStrongBinder(iBinder0);
            this.a.transact(3031, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void M(k k0, int v, int v1, Bundle bundle0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeInt(v1);
            a.d(parcel0, bundle0);
            this.a.transact(3030, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void N(k k0, int v, int v1, int v2) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeInt(v1);
            parcel0.writeInt(v2);
            this.a.transact(3051, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void O(k k0, int v, boolean z) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeInt(((int)z));
            this.a.transact(3006, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void P(k k0, int v, int v1) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeInt(v1);
            this.a.transact(3037, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void R(k k0, int v, int v1, long v2) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeInt(v1);
            parcel0.writeLong(v2);
            this.a.transact(0xBDF, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void S(k k0, int v, int v1) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeInt(v1);
            this.a.transact(3017, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void V(k k0, int v, Bundle bundle0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            a.d(parcel0, bundle0);
            this.a.transact(3027, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void W(k k0, int v, int v1, int v2, int v3) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeInt(v1);
            parcel0.writeInt(v2);
            parcel0.writeInt(v3);
            this.a.transact(0xBCF, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void Z(k k0, int v, Surface surface0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            a.d(parcel0, surface0);
            this.a.transact(3044, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void a(k k0, int v) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            this.a.transact(3004, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void a0(k k0, int v, int v1, IBinder iBinder0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeInt(v1);
            parcel0.writeStrongBinder(iBinder0);
            this.a.transact(3032, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }

    @Override  // androidx.media3.session.m
    public final void b(k k0, int v) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            this.a.transact(3025, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void b0(k k0, int v, Bundle bundle0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            a.d(parcel0, bundle0);
            this.a.transact(3033, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void d0(k k0, int v) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            this.a.transact(3026, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void h(k k0, int v) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            this.a.transact(3021, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void h0(k k0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            this.a.transact(3045, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void i0(k k0, int v, int v1, int v2) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeInt(v1);
            parcel0.writeInt(v2);
            this.a.transact(3020, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void j(k k0, int v) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            this.a.transact(3035, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void k(k k0, int v, boolean z) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeInt(((int)z));
            this.a.transact(3018, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void l(k k0, int v, Bundle bundle0, boolean z) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            a.d(parcel0, bundle0);
            parcel0.writeInt(((int)z));
            this.a.transact(0xBF1, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void l0(k k0, int v, Bundle bundle0, boolean z) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            a.d(parcel0, bundle0);
            parcel0.writeInt(1);
            this.a.transact(3009, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void m(k k0, int v, int v1) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeInt(v1);
            this.a.transact(3003, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void m0(k k0, int v) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            this.a.transact(3034, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void n(k k0, int v, IBinder iBinder0, boolean z) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeStrongBinder(iBinder0);
            parcel0.writeInt(1);
            this.a.transact(3011, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void n0(k k0, int v) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            this.a.transact(3041, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void o(k k0, int v) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            this.a.transact(3042, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void o0(k k0, int v, int v1, int v2, IBinder iBinder0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeInt(v1);
            parcel0.writeInt(v2);
            parcel0.writeStrongBinder(iBinder0);
            this.a.transact(0xBF0, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void p(k k0, int v) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            this.a.transact(3047, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void p0(k k0, int v) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            this.a.transact(0xBD0, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void q0(k k0, int v, boolean z) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeInt(((int)z));
            this.a.transact(3013, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void r0(k k0, int v, int v1) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeInt(v1);
            this.a.transact(3052, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void s(k k0, int v, Bundle bundle0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            a.d(parcel0, bundle0);
            this.a.transact(3015, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void s0(k k0, int v) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            this.a.transact(3040, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void u0(k k0, int v) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            this.a.transact(3005, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void v(k k0, int v) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            this.a.transact(3046, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void w(k k0, int v) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            this.a.transact(3036, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void w0(k k0, int v, boolean z, int v1) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeInt(((int)z));
            parcel0.writeInt(v1);
            this.a.transact(3054, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void x(k k0, int v, int v1) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeInt(v1);
            this.a.transact(3053, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void x0(k k0, int v, Bundle bundle0, Bundle bundle1) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            a.d(parcel0, bundle0);
            a.d(parcel0, bundle1);
            this.a.transact(3016, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void y(k k0, int v, Bundle bundle0, long v1) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            a.d(parcel0, bundle0);
            parcel0.writeLong(v1);
            this.a.transact(3008, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.m
    public final void z0(k k0, int v, IBinder iBinder0, int v1, long v2) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSession");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(v);
            parcel0.writeStrongBinder(iBinder0);
            parcel0.writeInt(v1);
            parcel0.writeLong(v2);
            this.a.transact(3012, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }
}

