package com.google.android.gms.measurement.internal;

import A7.d;
import U4.x;
import android.os.Bundle;

public final class zzgu {
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final Bundle zzd;

    public zzgu(String s, String s1, Bundle bundle0, long v) {
        this.zza = s;
        this.zzb = s1;
        this.zzd = bundle0;
        this.zzc = v;
    }

    @Override
    public final String toString() {
        String s = this.zzd.toString();
        StringBuilder stringBuilder0 = new StringBuilder(String.valueOf(this.zzb).length() + 13 + String.valueOf(this.zza).length() + 8 + s.length());
        d.u(stringBuilder0, "origin=", this.zzb, ",name=", this.zza);
        return x.m(stringBuilder0, ",params=", s);
    }

    public static zzgu zza(zzbg zzbg0) {
        Bundle bundle0 = zzbg0.zzb.zzf();
        return new zzgu(zzbg0.zza, zzbg0.zzc, bundle0, zzbg0.zzd);
    }

    public final zzbg zzb() {
        zzbe zzbe0 = new zzbe(new Bundle(this.zzd));
        return new zzbg(this.zza, zzbe0, this.zzb, this.zzc);
    }
}

