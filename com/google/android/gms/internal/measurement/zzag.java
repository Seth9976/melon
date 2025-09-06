package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

public final class zzag implements zzao {
    private final zzao zza;
    private final String zzb;

    public zzag() {
        this.zza = zzao.zzf;
        this.zzb = "return";
    }

    public zzag(String s) {
        this.zza = zzao.zzf;
        this.zzb = s;
    }

    public zzag(String s, zzao zzao0) {
        this.zza = zzao0;
        this.zzb = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof zzag ? this.zzb.equals(((zzag)object0).zzb) && this.zza.equals(((zzag)object0).zza) : false;
    }

    @Override
    public final int hashCode() {
        return this.zza.hashCode() + this.zzb.hashCode() * 0x1F;
    }

    public final zzao zzb() {
        return this.zza;
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        throw new IllegalStateException("Control is not a String");
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final zzao zzcA(String s, zzg zzg0, List list0) {
        throw new IllegalStateException("Control does not have functions");
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        throw new IllegalStateException("Control is not a double");
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        throw new IllegalStateException("Control is not a boolean");
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return null;
    }

    public final String zzg() [...] // 潜在的解密器

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final zzao zzt() {
        zzao zzao0 = this.zza.zzt();
        return new zzag(this.zzb, zzao0);
    }
}

