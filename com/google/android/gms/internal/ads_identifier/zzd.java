package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.Parcel;

public final class zzd extends zza implements zzf {
    public zzd(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override  // com.google.android.gms.internal.ads_identifier.zzf
    public final String zzc() {
        Parcel parcel0 = this.zzb(1, this.zza());
        String s = parcel0.readString();
        parcel0.recycle();
        return s;
    }

    @Override  // com.google.android.gms.internal.ads_identifier.zzf
    public final boolean zzd() {
        Parcel parcel0 = this.zzb(6, this.zza());
        boolean z = zzc.zza(parcel0);
        parcel0.recycle();
        return z;
    }

    @Override  // com.google.android.gms.internal.ads_identifier.zzf
    public final boolean zze(boolean z) {
        Parcel parcel0 = this.zza();
        parcel0.writeInt(1);
        Parcel parcel1 = this.zzb(2, parcel0);
        boolean z1 = zzc.zza(parcel1);
        parcel1.recycle();
        return z1;
    }
}

