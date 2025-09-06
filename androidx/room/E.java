package androidx.room;

import android.os.IBinder;
import android.os.Parcel;

public final class e implements f {
    public IBinder a;

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }

    @Override  // androidx.room.f
    public final void g(String[] arr_s) {
        Parcel parcel0 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
            parcel0.writeStringArray(arr_s);
            this.a.transact(1, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }
}

