package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;

public class zzal implements zzak, zzao {
    final Map zza;

    public zzal() {
        this.zza = new HashMap();
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof zzal ? this.zza.equals(((zzal)object0).zza) : false;
    }

    @Override
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override
    public final String toString() [...] // 潜在的解密器

    public final List zzb() {
        return new ArrayList(this.zza.keySet());
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        return "[object Object]";
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public zzao zzcA(String s, zzg zzg0, List list0) {
        return "toString".equals(s) ? new zzas("{}") : zzak.zzu(this, new zzas(s), zzg0, list0);
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
        return zzak.zzv(this.zza);
    }

    @Override  // com.google.android.gms.internal.measurement.zzak
    public final boolean zzj(String s) {
        return this.zza.containsKey(s);
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.internal.measurement.zzak
    public final zzao zzk(String s) {
        return this.zza.containsKey(s) ? ((zzao)this.zza.get(s)) : zzao.zzf;
    }

    @Override  // com.google.android.gms.internal.measurement.zzak
    public final void zzm(String s, zzao zzao0) {
        if(zzao0 == null) {
            this.zza.remove(s);
            return;
        }
        this.zza.put(s, zzao0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final zzao zzt() {
        zzao zzao0 = new zzal();
        for(Object object0: this.zza.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            if(map$Entry0.getValue() instanceof zzak) {
                String s = (String)map$Entry0.getKey();
                zzao zzao1 = (zzao)map$Entry0.getValue();
                zzao0.zza.put(s, zzao1);
            }
            else {
                String s1 = (String)map$Entry0.getKey();
                zzao zzao2 = ((zzao)map$Entry0.getValue()).zzt();
                zzao0.zza.put(s1, zzao2);
            }
        }
        return zzao0;
    }
}

