package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class zzix implements Runnable {
    private final zzjc zza;
    private final zzr zzb;
    private final Bundle zzc;
    private final zzgd zzd;
    private final String zze;

    public zzix(zzjc zzjc0, zzr zzr0, Bundle bundle0, zzgd zzgd0, String s) {
        this.zza = zzjc0;
        this.zzb = zzr0;
        this.zzc = bundle0;
        this.zzd = zzgd0;
        this.zze = s;
    }

    @Override
    public final void run() {
        this.zza.zzH(this.zzb, this.zzc, this.zzd, this.zze);
    }
}

