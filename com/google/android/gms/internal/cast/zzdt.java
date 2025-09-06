package com.google.android.gms.internal.cast;

public final class zzdt implements Runnable {
    public final zzdv zza;
    public final zzdr zzb;

    public zzdt(zzdv zzdv0, zzdr zzdr0) {
        this.zza = zzdv0;
        this.zzb = zzdr0;
    }

    @Override
    public final void run() {
        zzdv.zzb(this.zza, this.zzb);
    }
}

