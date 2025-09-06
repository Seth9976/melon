package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

public final class zzaf implements zzao {
    private final boolean zza;

    public zzaf(Boolean boolean0) {
        this.zza = boolean0 == null ? false : boolean0.booleanValue();
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof zzaf ? this.zza == ((zzaf)object0).zza : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.valueOf(this.zza).hashCode();
    }

    @Override
    public final String toString() {
        return String.valueOf(this.zza);
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        return Boolean.toString(this.zza);
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final zzao zzcA(String s, zzg zzg0, List list0) {
        if(!"toString".equals(s)) {
            throw new IllegalArgumentException(Boolean.toString(this.zza) + "." + s + " is not a function.");
        }
        return new zzas(Boolean.toString(this.zza));
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        return this.zza ? 1.0 : 0.0;
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        return Boolean.valueOf(this.zza);
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return null;
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final zzao zzt() {
        return new zzaf(Boolean.valueOf(this.zza));
    }
}

