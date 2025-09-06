package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class zzaw {
    final Map zza;
    final zzbi zzb;

    public zzaw() {
        this.zza = new HashMap();
        this.zzb = new zzbi();
        this.zza(new zzau());
        this.zza(new zzax());
        this.zza(new zzay());
        this.zza(new zzbb());
        this.zza(new zzbg());
        this.zza(new zzbh());
        this.zza(new zzbj());
    }

    public final void zza(zzav zzav0) {
        for(Object object0: zzav0.zza) {
            String s = ((zzbk)object0).zzb().toString();
            this.zza.put(s, zzav0);
        }
    }

    public final zzao zzb(zzg zzg0, zzao zzao0) {
        zzh.zzl(zzg0);
        if(zzao0 instanceof zzap) {
            ArrayList arrayList0 = ((zzap)zzao0).zzg();
            String s = ((zzap)zzao0).zzb();
            return this.zza.containsKey(s) ? ((zzav)this.zza.get(s)).zza(s, zzg0, arrayList0) : this.zzb.zza(s, zzg0, arrayList0);
        }
        return zzao0;
    }
}

