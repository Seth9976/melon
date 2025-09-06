package androidx.media3.session;

import I6.p0;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import x1.a;

public final class j implements k {
    public IBinder a;

    @Override  // androidx.media3.session.k
    public final void J(int v, Bundle bundle0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcel0.writeInt(v);
            a.T(parcel0, bundle0);
            this.a.transact(3002, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.k
    public final void Y(int v, Bundle bundle0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcel0.writeInt(v);
            a.T(parcel0, bundle0);
            this.a.transact(3015, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }

    @Override  // androidx.media3.session.k
    public final void c0(int v, Bundle bundle0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcel0.writeInt(v);
            a.T(parcel0, bundle0);
            this.a.transact(3009, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.k
    public final void d() {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcel0.writeInt(0);
            this.a.transact(3006, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.k
    public final void e(int v) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcel0.writeInt(v);
            this.a.transact(3011, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.k
    public final void e0(int v, Bundle bundle0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcel0.writeInt(v);
            a.T(parcel0, bundle0);
            this.a.transact(3008, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.k
    public final void f(int v, List list0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcel0.writeInt(v);
            if(list0 == null) {
                parcel0.writeInt(-1);
            }
            else {
                int v2 = ((p0)list0).d;
                parcel0.writeInt(v2);
                for(int v3 = 0; v3 < v2; ++v3) {
                    a.T(parcel0, ((Parcelable)((p0)list0).get(v3)));
                }
            }
            this.a.transact(3004, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.k
    public final void g0(int v, Bundle bundle0, Bundle bundle1) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcel0.writeInt(v);
            a.T(parcel0, bundle0);
            a.T(parcel0, bundle1);
            this.a.transact(3013, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.k
    public final void i(int v, Bundle bundle0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcel0.writeInt(v);
            a.T(parcel0, bundle0);
            this.a.transact(3001, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.k
    public final void q(int v, Bundle bundle0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcel0.writeInt(v);
            a.T(parcel0, bundle0);
            this.a.transact(3003, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.k
    public final void t0(int v, Bundle bundle0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcel0.writeInt(v);
            a.T(parcel0, bundle0);
            this.a.transact(3012, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.k
    public final void u(Bundle bundle0, int v, boolean z) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcel0.writeInt(v);
            a.T(parcel0, bundle0);
            parcel0.writeInt(((int)z));
            this.a.transact(3007, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // androidx.media3.session.k
    public final void v0(int v, String s, int v1, Bundle bundle0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcel0.writeInt(v);
            parcel0.writeString(s);
            parcel0.writeInt(0);
            a.T(parcel0, bundle0);
            this.a.transact(4001, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }
}

