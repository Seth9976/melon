package co.ab180.airbridge.internal.d0.b.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class a implements IInterface {
    private final IBinder a;
    private final String b;

    public a(IBinder iBinder0, String s) {
        this.a = iBinder0;
        this.b = s;
    }

    public Parcel a() {
        Parcel parcel0 = Parcel.obtain();
        parcel0.writeInterfaceToken(this.b);
        return parcel0;
    }

    public Parcel a(int v, Parcel parcel0) {
        Parcel parcel1 = Parcel.obtain();
        try {
            this.a.transact(v, parcel0, parcel1, 0);
            parcel1.readException();
            return parcel1;
        }
        catch(RuntimeException runtimeException0) {
            parcel1.recycle();
            throw runtimeException0;
        }
        finally {
            parcel0.recycle();
        }
    }

    @Override  // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }
}

