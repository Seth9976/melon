package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zzc implements Callable {
    final SharedPreferences zza;
    final String zzb;
    final Long zzc;

    public zzc(SharedPreferences sharedPreferences0, String s, Long long0) {
        this.zza = sharedPreferences0;
        this.zzb = s;
        this.zzc = long0;
        super();
    }

    @Override
    public final Object call() {
        return this.zza.getLong(this.zzb, ((long)this.zzc));
    }
}

