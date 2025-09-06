package com.google.android.gms.internal.auth-api-phone;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.internal.IStatusCallback;

public final class zzk extends zza implements IInterface {
    public zzk(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
    }

    public final void zzc(zze zze0) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, zze0);
        this.zzb(4, parcel0);
    }

    public final void zzd(String s, zzj zzj0) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        zzc.zzc(parcel0, zzj0);
        this.zzb(5, parcel0);
    }

    public final void zze(IStatusCallback iStatusCallback0) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, iStatusCallback0);
        this.zzb(3, parcel0);
    }

    public final void zzf(IStatusCallback iStatusCallback0) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, iStatusCallback0);
        this.zzb(6, parcel0);
    }

    public final void zzg(zzm zzm0) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, zzm0);
        this.zzb(1, parcel0);
    }

    public final void zzh(String s, zzm zzm0) {
        Parcel parcel0 = this.zza();
        parcel0.writeString(s);
        zzc.zzc(parcel0, zzm0);
        this.zzb(2, parcel0);
    }
}

