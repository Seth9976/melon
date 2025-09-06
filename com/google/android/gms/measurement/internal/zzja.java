package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class zzja implements Runnable {
    private final zzjc zza;
    private final Bundle zzb;
    private final String zzc;
    private final zzr zzd;

    public zzja(zzjc zzjc0, Bundle bundle0, String s, zzr zzr0) {
        this.zza = zzjc0;
        this.zzb = bundle0;
        this.zzc = s;
        this.zzd = zzr0;
    }

    @Override
    public final void run() {
        this.zza.zzK(this.zzb, this.zzc, this.zzd);
    }
}

