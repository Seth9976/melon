package com.google.android.gms.common;

import java.util.concurrent.Callable;

final class zzl implements Callable {
    private final boolean zza;
    private final String zzb;
    private final zzj zzc;

    public zzl(boolean z, String s, zzj zzj0) {
        this.zza = z;
        this.zzb = s;
        this.zzc = zzj0;
    }

    @Override
    public final Object call() {
        return zzo.zze(this.zza, this.zzb, this.zzc);
    }
}

