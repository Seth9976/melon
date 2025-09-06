package androidx.media3.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class n implements o {
    public IBinder a;

    @Override  // androidx.media3.session.o
    public final void U(k k0, Bundle bundle0) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.media3.session.IMediaSessionService");
            parcel0.writeStrongInterface(k0);
            parcel0.writeInt(1);
            bundle0.writeToParcel(parcel0, 0);
            this.a.transact(3001, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }
}

