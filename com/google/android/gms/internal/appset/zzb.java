package com.google.android.gms.internal.appset;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class zzb extends Binder implements IInterface {
    public zzb(String s) {
        this.attachInterface(this, "com.google.android.gms.appset.internal.IAppSetIdCallback");
    }

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override  // android.os.Binder
    public final boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v > 0xFFFFFF) {
            return super.onTransact(v, parcel0, parcel1, v1) ? true : this.zza(v, parcel0, parcel1, v1);
        }
        parcel0.enforceInterface(this.getInterfaceDescriptor());
        return this.zza(v, parcel0, parcel1, v1);
    }

    public boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        throw null;
    }
}

