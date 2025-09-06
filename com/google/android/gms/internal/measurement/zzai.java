package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class zzai implements zzak, zzao {
    protected final String zzd;
    protected final Map zze;

    public zzai(String s) {
        this.zze = new HashMap();
        this.zzd = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof zzai)) {
            return false;
        }
        return this.zzd == null ? false : this.zzd.equals(((zzai)object0).zzd);
    }

    @Override
    public final int hashCode() {
        return this.zzd == null ? 0 : this.zzd.hashCode();
    }

    public abstract zzao zza(zzg arg1, List arg2);

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final zzao zzcA(String s, zzg zzg0, List list0) {
        return "toString".equals(s) ? new zzas(this.zzd) : zzak.zzu(this, new zzas(s), zzg0, list0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        return NaN;
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        return true;
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return zzak.zzv(this.zze);
    }

    public final String zzg() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.internal.measurement.zzak
    public final boolean zzj(String s) {
        return this.zze.containsKey(s);
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.internal.measurement.zzak
    public final zzao zzk(String s) {
        return this.zze.containsKey(s) ? ((zzao)this.zze.get(s)) : zzao.zzf;
    }

    @Override  // com.google.android.gms.internal.measurement.zzak
    public final void zzm(String s, zzao zzao0) {
        if(zzao0 == null) {
            this.zze.remove(s);
            return;
        }
        this.zze.put(s, zzao0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public zzao zzt() {
        return this;
    }
}

