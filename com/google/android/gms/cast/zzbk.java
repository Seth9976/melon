package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zza;

public final class zzbk implements Runnable {
    public final zzbq zza;
    public final zza zzb;

    public zzbk(zzbq zzbq0, zza zza0) {
        this.zza = zzbq0;
        this.zzb = zza0;
    }

    @Override
    public final void run() {
        zzbr.zzH(this.zza.zza, this.zzb);
    }
}

