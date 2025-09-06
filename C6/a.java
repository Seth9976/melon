package c6;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public final class a implements IInterface, c {
    public final IBinder a;

    public a(IBinder iBinder0) {
        this.a = iBinder0;
    }

    public final Bundle C0(Bundle bundle0) {
        Parcel parcel0 = Parcel.obtain();
        parcel0.writeInterfaceToken("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
        parcel0.writeInt(1);
        bundle0.writeToParcel(parcel0, 0);
        Parcel parcel1 = Parcel.obtain();
        try {
            this.a.transact(1, parcel0, parcel1, 0);
            parcel1.readException();
        }
        catch(RuntimeException runtimeException0) {
            parcel1.recycle();
            throw runtimeException0;
        }
        finally {
            parcel0.recycle();
        }
        Parcelable.Creator parcelable$Creator0 = Bundle.CREATOR;
        Parcelable parcelable0 = parcel1.readInt() == 0 ? null : ((Parcelable)parcelable$Creator0.createFromParcel(parcel1));
        parcel1.recycle();
        return (Bundle)parcelable0;
    }

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }
}

