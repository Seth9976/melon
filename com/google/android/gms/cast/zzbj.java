package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzac;

public final class zzbj implements Runnable {
    public final zzbq zza;
    public final zzac zzb;

    public zzbj(zzbq zzbq0, zzac zzac0) {
        this.zza = zzbq0;
        this.zzb = zzac0;
    }

    @Override
    public final void run() {
        zzbr.zzI(this.zza.zza, this.zzb);
    }
}

