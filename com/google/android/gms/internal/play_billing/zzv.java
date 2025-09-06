package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class zzv implements IInterface {
    private final IBinder zza;
    private final String zzb;

    public zzv(IBinder iBinder0, String s) {
        this.zza = iBinder0;
        this.zzb = "com.android.vending.billing.IInAppBillingService";
    }

    @Override  // android.os.IInterface
    public final IBinder asBinder() {
        return this.zza;
    }

    public final Parcel zzu() {
        Parcel parcel0 = Parcel.obtain();
        parcel0.writeInterfaceToken(this.zzb);
        return parcel0;
    }

    public final Parcel zzv(int v, Parcel parcel0) {
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

    public final void zzw(int v, Parcel parcel0) {
        Parcel parcel1 = Parcel.obtain();
        try {
            this.zza.transact(v, parcel0, parcel1, 0);
            parcel1.readException();
        }
        finally {
            parcel0.recycle();
            parcel1.recycle();
        }
    }

    public final void zzx(int v, Parcel parcel0) {
        try {
            this.zza.transact(v, parcel0, null, 1);
        }
        finally {
            parcel0.recycle();
        }
    }
}

