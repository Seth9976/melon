package co.ab180.airbridge.internal.d0.b.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class b extends Binder implements IInterface {
    public b(String s) {
        this.attachInterface(this, s);
    }

    public boolean a(int v, Parcel parcel0, Parcel parcel1, int v1) {
        return false;
    }

    @Override  // android.os.IInterface
    public IBinder asBinder() [...] // Inlined contents

    public boolean b(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v > 0xFFFFFF) {
            return super.onTransact(v, parcel0, parcel1, v1);
        }
        parcel0.enforceInterface(this.getInterfaceDescriptor());
        return false;
    }

    // 去混淆评级： 低(20)
    @Override  // android.os.Binder
    public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
        return this.b(v, parcel0, parcel1, v1) ? true : this.a(v, parcel0, parcel1, v1);
    }
}

