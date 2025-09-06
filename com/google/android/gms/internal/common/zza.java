package com.google.android.gms.internal.common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class zza implements IInterface {
    private final IBinder zza;
    private final String zzb;

    public zza(IBinder iBinder0, String s) {
        this.zza = iBinder0;
        this.zzb = s;
    }

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this.zza;
    }

    public final Parcel zzB(int v, Parcel parcel0) {
        Parcel parcel1 = Parcel.obtain();
        try {
            this.zza.transact(v, parcel0, parcel1, 0);
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

    public final void zzC(int v, Parcel parcel0) {
        try {
            this.zza.transact(2, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }

    public final void zzD(int v, Parcel parcel0) {
        Parcel parcel1 = Parcel.obtain();
        try {
            this.zza.transact(1, parcel0, parcel1, 0);
            parcel1.readException();
        }
        finally {
            parcel0.recycle();
            parcel1.recycle();
        }
    }

    public final Parcel zza() {
        Parcel parcel0 = Parcel.obtain();
        parcel0.writeInterfaceToken(this.zzb);
        return parcel0;
    }
}

