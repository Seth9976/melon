package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zzd implements Callable {
    final SharedPreferences zza;
    final String zzb;
    final String zzc;

    public zzd(SharedPreferences sharedPreferences0, String s, String s1) {
        this.zza = sharedPreferences0;
        this.zzb = s;
        this.zzc = s1;
        super();
    }

    @Override
    public final Object call() {
        return this.zza.getString(this.zzb, this.zzc);
    }
}

