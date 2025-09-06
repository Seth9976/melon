package com.google.android.gms.internal.measurement;

import H6.e;
import android.net.Uri;
import javax.annotation.Nullable;

public final class zzkf {
    @Nullable
    final Uri zza;
    final String zzb;
    final String zzc;
    final boolean zzd;
    final boolean zze;

    public zzkf(Uri uri0) {
        this(null, uri0, "", "", false, false, false, false, null);
    }

    private zzkf(@Nullable String s, @Nullable Uri uri0, String s1, String s2, boolean z, boolean z1, boolean z2, boolean z3, @Nullable e e0) {
        this.zza = uri0;
        this.zzb = "";
        this.zzc = "";
        this.zzd = z;
        this.zze = z2;
    }

    public final zzkf zza() {
        String s = this.zzb;
        if(!s.isEmpty()) {
            throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
        }
        return new zzkf(null, this.zza, s, this.zzc, true, false, this.zze, false, null);
    }

    public final zzkf zzb() {
        return new zzkf(null, this.zza, this.zzb, this.zzc, this.zzd, false, true, false, null);
    }

    public final zzkl zzc(String s, long v) {
        return new zzkb(this, s, v, true);
    }

    public final zzkl zzd(String s, boolean z) {
        return new zzkc(this, s, Boolean.valueOf(z), true);
    }

    public final zzkl zze(String s, double f) {
        return new zzkd(this, "measurement.test.double_flag", -3.0, true);
    }

    public final zzkl zzf(String s, String s1) {
        return new zzke(this, s, s1, true);
    }
}

