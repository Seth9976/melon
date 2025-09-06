package K5;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class a implements c {
    public IBinder a;

    public final Bundle C0(int v, String s, String s1, Bundle bundle0) {
        Parcel parcel0 = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("com.gaa.extern.iap.IGlobalInAppService");
            parcel0.writeInt(v);
            parcel0.writeString(s);
            parcel0.writeString(s1);
            parcel0.writeInt(1);
            bundle0.writeToParcel(parcel0, 0);
            this.a.transact(7, parcel0, parcel1, 0);
            parcel1.readException();
            return parcel1.readInt() == 0 ? null : ((Bundle)Bundle.CREATOR.createFromParcel(parcel1));
        }
        finally {
            parcel1.recycle();
            parcel0.recycle();
        }
    }

    public final Bundle D0(int v, String s, String s1, Bundle bundle0) {
        Parcel parcel0 = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("com.gaa.extern.iap.IGlobalInAppService");
            parcel0.writeInt(v);
            parcel0.writeString(s);
            parcel0.writeString("inapp");
            parcel0.writeString(s1);
            parcel0.writeInt(1);
            bundle0.writeToParcel(parcel0, 0);
            this.a.transact(6, parcel0, parcel1, 0);
            parcel1.readException();
            return parcel1.readInt() == 0 ? null : ((Bundle)Bundle.CREATOR.createFromParcel(parcel1));
        }
        finally {
            parcel1.recycle();
            parcel0.recycle();
        }
    }

    public final int E0(Bundle bundle0, String s) {
        Parcel parcel0 = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("com.gaa.extern.iap.IGlobalInAppService");
            parcel0.writeInt(7);
            parcel0.writeString(s);
            parcel0.writeString("subscription");
            parcel0.writeInt(1);
            bundle0.writeToParcel(parcel0, 0);
            this.a.transact(4, parcel0, parcel1, 0);
            parcel1.readException();
            return parcel1.readInt();
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

