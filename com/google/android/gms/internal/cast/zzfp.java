package com.google.android.gms.internal.cast;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class zzfp extends zza implements IInterface {
    public zzfp(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.usagereporting.internal.IUsageReportingService");
    }

    public final void zze(zzfn zzfn0) {
        Parcel parcel0 = this.zza();
        zzc.zze(parcel0, zzfn0);
        this.zzc(2, parcel0);
    }

    public final void zzf(zzfo zzfo0, zzfn zzfn0) {
        Parcel parcel0 = this.zza();
        zzc.zze(parcel0, zzfo0);
        zzc.zze(parcel0, zzfn0);
        this.zzc(5, parcel0);
    }
}

