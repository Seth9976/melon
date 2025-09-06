package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

public final class zzhb {
    final zzhg zza;
    private final String zzb;
    private final boolean zzc;
    private boolean zzd;
    private boolean zze;

    public zzhb(zzhg zzhg0, String s, boolean z) {
        Objects.requireNonNull(zzhg0);
        this.zza = zzhg0;
        super();
        Preconditions.checkNotEmpty(s);
        this.zzb = s;
        this.zzc = z;
    }

    public final boolean zza() {
        if(!this.zzd) {
            this.zzd = true;
            this.zze = this.zza.zzd().getBoolean(this.zzb, this.zzc);
        }
        return this.zze;
    }

    public final void zzb(boolean z) {
        SharedPreferences.Editor sharedPreferences$Editor0 = this.zza.zzd().edit();
        sharedPreferences$Editor0.putBoolean(this.zzb, z);
        sharedPreferences$Editor0.apply();
        this.zze = z;
    }
}

