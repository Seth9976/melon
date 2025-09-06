package androidx.media3.session;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import androidx.media3.session.legacy.b0;
import androidx.media3.session.legacy.c0;
import e3.b;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class O0 extends Binder implements o {
    public final WeakReference a;
    public final Handler b;
    public final c0 c;
    public final Set d;

    public O0(MediaSessionService mediaSessionService0) {
        this.attachInterface(this, "androidx.media3.session.IMediaSessionService");
        this.a = new WeakReference(mediaSessionService0);
        Context context0 = mediaSessionService0.getApplicationContext();
        this.b = new Handler(context0.getMainLooper());
        this.c = c0.a(context0);
        this.d = Collections.synchronizedSet(new HashSet());
    }

    public static o C0(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("androidx.media3.session.IMediaSessionService");
        if(iInterface0 != null && iInterface0 instanceof o) {
            return (o)iInterface0;
        }
        o o0 = new n();  // 初始化器: Ljava/lang/Object;-><init>()V
        o0.a = iBinder0;
        return o0;
    }

    @Override  // androidx.media3.session.o
    public final void U(k k0, Bundle bundle0) {
        g g0;
        if(k0 != null && bundle0 != null) {
            try {
                g0 = g.a(bundle0);
            }
            catch(RuntimeException runtimeException0) {
                b.E("MSessionService", "Ignoring malformed Bundle for ConnectionRequest", runtimeException0);
                return;
            }
            if(this.a.get() == null) {
                try {
                    k0.d();
                }
                catch(RemoteException unused_ex) {
                }
                return;
            }
            int v = Binder.getCallingPid();
            int v1 = Binder.getCallingUid();
            long v2 = Binder.clearCallingIdentity();
            if(v == 0) {
                v = g0.d;
            }
            b0 b00 = new b0(g0.c, v, v1);
            boolean z = this.c.b(b00);
            this.d.add(k0);
            try {
                q0 q00 = new q0(1, this, k0, b00, g0, z);
                this.b.post(q00);
            }
            finally {
                Binder.restoreCallingIdentity(v2);
            }
        }
    }

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override  // android.os.Binder
    public final boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v >= 1 && v <= 0xFFFFFF) {
            parcel0.enforceInterface("androidx.media3.session.IMediaSessionService");
        }
        switch(v) {
            case 3001: {
                k k0 = androidx.media3.session.c0.C0(parcel0.readStrongBinder());
                Parcelable.Creator parcelable$Creator0 = Bundle.CREATOR;
                this.U(k0, ((Bundle)(parcel0.readInt() == 0 ? null : parcelable$Creator0.createFromParcel(parcel0))));
                return true;
            }
            case 0x5F4E5446: {
                parcel1.writeString("androidx.media3.session.IMediaSessionService");
                return true;
            }
            default: {
                return super.onTransact(v, parcel0, parcel1, v1);
            }
        }
    }
}

