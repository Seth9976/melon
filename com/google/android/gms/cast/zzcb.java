package com.google.android.gms.cast;

import java.util.HashMap;
import java.util.Map;

final class zzcb {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;

    public zzcb() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
    }

    public final int zza(String s) {
        Integer integer0 = (Integer)this.zzc.get(s);
        return integer0 == null ? 0 : ((int)integer0);
    }

    public final zzcb zzb(String s, String s1, int v) {
        this.zza.put(s, s1);
        this.zzb.put(s1, s);
        this.zzc.put(s, v);
        return this;
    }

    public final String zzc(String s) {
        return (String)this.zza.get(s);
    }

    public final String zzd(String s) {
        return (String)this.zzb.get(s);
    }
}

