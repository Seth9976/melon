package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

public final class zzhd {
    final zzhg zza;
    private final String zzb;
    private final long zzc;
    private boolean zzd;
    private long zze;

    public zzhd(zzhg zzhg0, String s, long v) {
        Objects.requireNonNull(zzhg0);
        this.zza = zzhg0;
        super();
        Preconditions.checkNotEmpty(s);
        this.zzb = s;
        this.zzc = v;
    }

    public final long zza() {
        if(!this.zzd) {
            this.zzd = true;
            this.zze = this.zza.zzd().getLong(this.zzb, this.zzc);
        }
        return this.zze;
    }

    public final void zzb(long v) {
        SharedPreferences.Editor sharedPreferences$Editor0 = this.zza.zzd().edit();
        sharedPreferences$Editor0.putLong(this.zzb, v);
        sharedPreferences$Editor0.apply();
        this.zze = v;
    }
}

