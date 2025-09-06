package com.google.android.gms.measurement.internal;

import android.content.Intent;

final class zznr implements Runnable {
    private final zzns zza;
    private final int zzb;
    private final zzgt zzc;
    private final Intent zzd;

    public zznr(zzns zzns0, int v, zzgt zzgt0, Intent intent0) {
        this.zza = zzns0;
        this.zzb = v;
        this.zzc = zzgt0;
        this.zzd = intent0;
    }

    @Override
    public final void run() {
        this.zza.zzf(this.zzb, this.zzc, this.zzd);
    }
}

