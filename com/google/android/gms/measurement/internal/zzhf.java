package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

public final class zzhf {
    final zzhg zza;
    private final String zzb;
    private boolean zzc;
    private String zzd;

    public zzhf(zzhg zzhg0, String s, String s1) {
        Objects.requireNonNull(zzhg0);
        this.zza = zzhg0;
        super();
        Preconditions.checkNotEmpty(s);
        this.zzb = s;
    }

    public final String zza() {
        if(!this.zzc) {
            this.zzc = true;
            this.zzd = this.zza.zzd().getString(this.zzb, null);
        }
        return this.zzd;
    }

    public final void zzb(String s) {
        SharedPreferences.Editor sharedPreferences$Editor0 = this.zza.zzd().edit();
        sharedPreferences$Editor0.putString(this.zzb, s);
        sharedPreferences$Editor0.apply();
        this.zzd = s;
    }
}

