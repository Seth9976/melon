package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Objects;

final class zzm extends zzai {
    final zzo zza;

    public zzm(zzn zzn0, String s, zzo zzo0) {
        this.zza = zzo0;
        Objects.requireNonNull(zzn0);
        super("getValue");
    }

    @Override  // com.google.android.gms.internal.measurement.zzai
    public final zzao zza(zzg zzg0, List list0) {
        zzh.zza("getValue", 2, list0);
        zzao zzao0 = zzg0.zza(((zzao)list0.get(0)));
        zzao zzao1 = zzg0.zza(((zzao)list0.get(1)));
        String s = zzao0.zzc();
        String s1 = this.zza.zza(s);
        return s1 != null ? new zzas(s1) : zzao1;
    }
}

