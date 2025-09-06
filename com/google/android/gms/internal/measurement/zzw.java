package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public final class zzw extends zzai {
    final Map zza;
    private final zzj zzb;

    public zzw(zzj zzj0) {
        super("require");
        this.zza = new HashMap();
        this.zzb = zzj0;
    }

    @Override  // com.google.android.gms.internal.measurement.zzai
    public final zzao zza(zzg zzg0, List list0) {
        zzao zzao0;
        zzh.zza("require", 1, list0);
        String s = zzg0.zza(((zzao)list0.get(0))).zzc();
        Map map0 = this.zza;
        if(map0.containsKey(s)) {
            return (zzao)map0.get(s);
        }
        Map map1 = this.zzb.zza;
        if(map1.containsKey(s)) {
            Callable callable0 = (Callable)map1.get(s);
            try {
                zzao0 = (zzao)callable0.call();
            }
            catch(Exception unused_ex) {
                throw new IllegalStateException("Failed to create API implementation: " + s);
            }
        }
        else {
            zzao0 = zzao.zzf;
        }
        if(zzao0 instanceof zzai) {
            this.zza.put(s, ((zzai)zzao0));
        }
        return zzao0;
    }
}

