package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zzb implements Callable {
    final SharedPreferences zza;
    final String zzb;
    final Integer zzc;

    public zzb(SharedPreferences sharedPreferences0, String s, Integer integer0) {
        this.zza = sharedPreferences0;
        this.zzb = s;
        this.zzc = integer0;
        super();
    }

    @Override
    public final Object call() {
        return this.zza.getInt(this.zzb, ((int)this.zzc));
    }
}

