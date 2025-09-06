package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.flags.zzd;

public final class zzf {
    private static SharedPreferences zza;

    public static SharedPreferences zza(Context context0) {
        synchronized(SharedPreferences.class) {
            if(zzf.zza == null) {
                zzf.zza = (SharedPreferences)zzd.zza(new zze(context0));
            }
            return zzf.zza;
        }
    }
}

