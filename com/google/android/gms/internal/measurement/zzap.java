package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzap implements zzao {
    private final String zza;
    private final ArrayList zzb;

    public zzap(String s, List list0) {
        this.zza = s;
        ArrayList arrayList0 = new ArrayList();
        this.zzb = arrayList0;
        arrayList0.addAll(list0);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof zzap)) {
            return false;
        }
        String s = this.zza;
        if(s != null) {
            return s.equals(((zzap)object0).zza) ? this.zzb.equals(((zzap)object0).zzb) : false;
        }
        return ((zzap)object0).zza == null ? this.zzb.equals(((zzap)object0).zzb) : false;
    }

    @Override
    public final int hashCode() {
        return this.zza == null ? this.zzb.hashCode() : this.zzb.hashCode() + this.zza.hashCode() * 0x1F;
    }

    public final String zzb() {
        return this.zza;
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        throw new IllegalStateException("Statement cannot be cast as String");
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final zzao zzcA(String s, zzg zzg0, List list0) {
        throw new IllegalStateException("Statement is not an evaluated entity");
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        throw new IllegalStateException("Statement cannot be cast as Double");
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        throw new IllegalStateException("Statement cannot be cast as Boolean");
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return null;
    }

    public final ArrayList zzg() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final zzao zzt() {
        return this;
    }
}

