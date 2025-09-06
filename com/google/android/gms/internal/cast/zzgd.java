package com.google.android.gms.internal.cast;

import android.os.Handler;
import android.os.Looper;

final class zzgd extends zzgf {
    private final Handler zza;

    public zzgd(Looper looper0) {
        this.zza = new Handler(looper0);
    }

    @Override  // com.google.android.gms.internal.cast.zzgf
    public final void zza(zzgc zzgc0) {
        Runnable runnable0 = zzgc0.zzc();
        this.zza.postDelayed(runnable0, 0L);
    }
}

