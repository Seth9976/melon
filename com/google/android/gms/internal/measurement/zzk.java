package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzk extends zzai {
    private final zzab zza;

    public zzk(zzab zzab0) {
        super("internal.eventLogger");
        this.zza = zzab0;
    }

    @Override  // com.google.android.gms.internal.measurement.zzai
    public final zzao zza(zzg zzg0, List list0) {
        zzh.zza(this.zzd, 3, list0);
        String s = zzg0.zza(((zzao)list0.get(0))).zzc();
        long v = (long)zzh.zzi(((double)zzg0.zza(((zzao)list0.get(1))).zzd()));
        zzao zzao0 = zzg0.zza(((zzao)list0.get(2)));
        Map map0 = zzao0 instanceof zzal ? zzh.zzk(((zzal)zzao0)) : new HashMap();
        this.zza.zze(s, v, map0);
        return zzao.zzf;
    }
}

