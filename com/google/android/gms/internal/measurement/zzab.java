package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzab {
    private zzaa zza;
    private zzaa zzb;
    private final List zzc;

    public zzab() {
        this.zza = new zzaa("", 0L, null);
        this.zzb = new zzaa("", 0L, null);
        this.zzc = new ArrayList();
    }

    public zzab(zzaa zzaa0) {
        this.zza = zzaa0;
        this.zzb = zzaa0.zzg();
        this.zzc = new ArrayList();
    }

    @Override
    public final Object clone() {
        zzab zzab0 = new zzab(this.zza.zzg());
        for(Object object0: this.zzc) {
            zzaa zzaa0 = ((zzaa)object0).zzg();
            zzab0.zzc.add(zzaa0);
        }
        return zzab0;
    }

    public final zzaa zza() {
        return this.zza;
    }

    public final void zzb(zzaa zzaa0) {
        this.zza = zzaa0;
        this.zzb = zzaa0.zzg();
        this.zzc.clear();
    }

    public final zzaa zzc() {
        return this.zzb;
    }

    public final void zzd(zzaa zzaa0) {
        this.zzb = zzaa0;
    }

    public final void zze(String s, long v, Map map0) {
        HashMap hashMap0 = new HashMap();
        for(Object object0: map0.keySet()) {
            hashMap0.put(((String)object0), zzaa.zzh(((String)object0), this.zza.zze(((String)object0)), map0.get(((String)object0))));
        }
        zzaa zzaa0 = new zzaa(s, v, hashMap0);
        this.zzc.add(zzaa0);
    }

    public final List zzf() {
        return this.zzc;
    }
}

