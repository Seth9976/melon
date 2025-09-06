package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zza implements Callable {
    final SharedPreferences zza;
    final String zzb;
    final Boolean zzc;

    public zza(SharedPreferences sharedPreferences0, String s, Boolean boolean0) {
        this.zza = sharedPreferences0;
        this.zzb = s;
        this.zzc = boolean0;
        super();
    }

    @Override
    public final Object call() {
        return Boolean.valueOf(this.zza.getBoolean(this.zzb, this.zzc.booleanValue()));
    }
}

