package com.google.android.gms.internal.base;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class zaa implements IInterface {
    private final IBinder zaa;
    private final String zab;

    public zaa(IBinder iBinder0, String s) {
        this.zaa = iBinder0;
        this.zab = s;
    }

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this.zaa;
    }

    public final Parcel zaa() {
        Parcel parcel0 = Parcel.obtain();
        parcel0.writeInterfaceToken(this.zab);
        return parcel0;
    }

    public final Parcel zab(int v, Parcel parcel0) {
        Parcel parcel1 = Parcel.obtain();
        try {
            this.zaa.transact(2, parcel0, parcel1, 0);
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

    public final void zac(int v, Parcel parcel0) {
        Parcel parcel1 = Parcel.obtain();
        try {
            this.zaa.transact(v, parcel0, parcel1, 0);
            parcel1.readException();
        }
        finally {
            parcel0.recycle();
            parcel1.recycle();
        }
    }

    public final void zad(int v, Parcel parcel0) {
        try {
            this.zaa.transact(1, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }
}

