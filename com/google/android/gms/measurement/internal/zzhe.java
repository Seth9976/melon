package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

public final class zzhe {
    final String zza;
    final zzhg zzb;
    private final String zzc;
    private final String zzd;
    private final long zze;

    public zzhe(zzhg zzhg0, String s, long v, byte[] arr_b) {
        Objects.requireNonNull(zzhg0);
        this.zzb = zzhg0;
        super();
        new String("health_monitor");
        Preconditions.checkArgument(v > 0L);
        this.zza = "health_monitor:start";
        this.zzc = "health_monitor:count";
        this.zzd = "health_monitor:value";
        this.zze = v;
    }

    public final void zza(String s, long v) {
        zzhg zzhg0 = this.zzb;
        zzhg0.zzg();
        if(this.zzd() == 0L) {
            this.zzc();
        }
        if(s == null) {
            s = "";
        }
        SharedPreferences sharedPreferences0 = zzhg0.zzd();
        String s1 = this.zzc;
        long v1 = sharedPreferences0.getLong(s1, 0L);
        if(Long.compare(v1, 0L) <= 0) {
            SharedPreferences.Editor sharedPreferences$Editor0 = zzhg0.zzd().edit();
            sharedPreferences$Editor0.putString(this.zzd, s);
            sharedPreferences$Editor0.putLong(s1, 1L);
            sharedPreferences$Editor0.apply();
            return;
        }
        long v2 = zzhg0.zzu.zzk().zzf().nextLong();
        SharedPreferences.Editor sharedPreferences$Editor1 = zzhg0.zzd().edit();
        if((v2 & 0x7FFFFFFFFFFFFFFFL) < 0x7FFFFFFFFFFFFFFFL / (v1 + 1L)) {
            sharedPreferences$Editor1.putString(this.zzd, s);
        }
        sharedPreferences$Editor1.putLong(s1, v1 + 1L);
        sharedPreferences$Editor1.apply();
    }

    public final Pair zzb() {
        long v1;
        zzhg zzhg0 = this.zzb;
        zzhg0.zzg();
        zzhg0.zzg();
        long v = this.zzd();
        if(v == 0L) {
            this.zzc();
            v1 = 0L;
        }
        else {
            v1 = Math.abs(v - zzhg0.zzu.zzaZ().currentTimeMillis());
        }
        long v2 = this.zze;
        if(Long.compare(v1, v2) < 0) {
            return null;
        }
        if(v1 > v2 + v2) {
            this.zzc();
            return null;
        }
        String s = zzhg0.zzd().getString(this.zzd, null);
        long v3 = zzhg0.zzd().getLong(this.zzc, 0L);
        this.zzc();
        return s == null || v3 <= 0L ? zzhg.zza : new Pair(s, v3);
    }

    private final void zzc() {
        this.zzb.zzg();
        long v = this.zzb.zzu.zzaZ().currentTimeMillis();
        SharedPreferences.Editor sharedPreferences$Editor0 = this.zzb.zzd().edit();
        sharedPreferences$Editor0.remove(this.zzc);
        sharedPreferences$Editor0.remove(this.zzd);
        sharedPreferences$Editor0.putLong(this.zza, v);
        sharedPreferences$Editor0.apply();
    }

    private final long zzd() {
        return this.zzb.zzd().getLong(this.zza, 0L);
    }
}

