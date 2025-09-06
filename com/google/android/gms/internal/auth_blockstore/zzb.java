package com.google.android.gms.internal.auth_blockstore;

import android.os.BadParcelableException;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class zzb extends Binder implements IInterface {
    private static zzd globalInterceptor;

    public zzb(String s) {
        this.attachInterface(this, s);
    }

    @Override  // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public boolean dispatchTransaction(int v, Parcel parcel0, Parcel parcel1, int v1) {
        throw null;
    }

    public void enforceNoDataAvail(Parcel parcel0) {
        zzd zzd0 = zzb.globalInterceptor;
        if(zzd0 != null) {
            zzd0.zza();
            return;
        }
        int v = parcel0.dataAvail();
        if(v > 0) {
            throw new BadParcelableException("Parcel data not fully consumed, unread size: " + v);
        }
    }

    @Override  // android.os.Binder
    public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(this.routeToSuperOrEnforceInterface(v, parcel0, parcel1, v1)) {
            return true;
        }
        return zzb.globalInterceptor == null ? this.dispatchTransaction(v, parcel0, parcel1, v1) : zzb.globalInterceptor.zzb();
    }

    private boolean routeToSuperOrEnforceInterface(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v > 0xFFFFFF) {
            return super.onTransact(v, parcel0, parcel1, v1);
        }
        parcel0.enforceInterface(this.getInterfaceDescriptor());
        return false;
    }
}

