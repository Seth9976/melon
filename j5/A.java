package J5;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class a implements c {
    public IBinder a;

    public final Bundle C0(Bundle bundle0, String s) {
        Parcel parcel0 = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("com.gaa.extern.auth.IGlobalAuthService");
            parcel0.writeString(s);
            parcel0.writeInt(1);
            bundle0.writeToParcel(parcel0, 0);
            this.a.transact(1, parcel0, parcel1, 0);
            parcel1.readException();
            return parcel1.readInt() == 0 ? null : ((Bundle)Bundle.CREATOR.createFromParcel(parcel1));
        }
        finally {
            parcel1.recycle();
            parcel0.recycle();
        }
    }

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }
}

