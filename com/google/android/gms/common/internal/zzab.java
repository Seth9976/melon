package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.zzp;
import com.google.android.gms.common.zzr;
import com.google.android.gms.common.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzab extends zza implements zzad {
    public zzab(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override  // com.google.android.gms.common.internal.zzad
    public final boolean zze(zzt zzt0, IObjectWrapper iObjectWrapper0) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, zzt0);
        zzc.zze(parcel0, iObjectWrapper0);
        Parcel parcel1 = this.zzB(5, parcel0);
        boolean z = zzc.zza(parcel1);
        parcel1.recycle();
        return z;
    }

    @Override  // com.google.android.gms.common.internal.zzad
    public final zzr zzf(zzp zzp0) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, zzp0);
        Parcel parcel1 = this.zzB(6, parcel0);
        zzr zzr0 = (zzr)zzc.zzb(parcel1, zzr.CREATOR);
        parcel1.recycle();
        return zzr0;
    }

    @Override  // com.google.android.gms.common.internal.zzad
    public final boolean zzg() {
        Parcel parcel0 = this.zzB(7, this.zza());
        boolean z = zzc.zza(parcel0);
        parcel0.recycle();
        return z;
    }

    @Override  // com.google.android.gms.common.internal.zzad
    public final zzr zzh(zzp zzp0) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, zzp0);
        Parcel parcel1 = this.zzB(8, parcel0);
        zzr zzr0 = (zzr)zzc.zzb(parcel1, zzr.CREATOR);
        parcel1.recycle();
        return zzr0;
    }

    @Override  // com.google.android.gms.common.internal.zzad
    public final boolean zzi() {
        Parcel parcel0 = this.zzB(9, this.zza());
        boolean z = zzc.zza(parcel0);
        parcel0.recycle();
        return z;
    }
}

