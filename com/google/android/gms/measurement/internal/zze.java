package com.google.android.gms.measurement.internal;

import android.text.TextUtils;

final class zze {
    private final zzjh zza;

    public zze(zzjh zzjh0) {
        this.zza = zzjh0;
    }

    public final zzjh zza() {
        return this.zza;
    }

    public final String zzb() {
        return String.valueOf(zzjk.zzm(this.zza));
    }

    public static zze zzc(String s) {
        return TextUtils.isEmpty(s) || s.length() > 1 ? new zze(zzjh.zza) : new zze(zzjk.zzj(s.charAt(0)));
    }
}

