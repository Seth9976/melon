package com.google.android.gms.internal.appset;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class zzg extends zza implements IInterface {
    public zzg(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.appset.internal.IAppSetService");
    }

    public final void zzc(com.google.android.gms.appset.zza zza0, zzf zzf0) {
        Parcel parcel0 = this.zza();
        zzc.zzb(parcel0, zza0);
        zzc.zzc(parcel0, zzf0);
        this.zzb(1, parcel0);
    }
}

