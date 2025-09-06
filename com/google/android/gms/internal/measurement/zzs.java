package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

final class zzs extends zzai {
    final boolean zza;
    final boolean zzb;
    final zzt zzc;

    public zzs(zzt zzt0, boolean z, boolean z1) {
        Objects.requireNonNull(zzt0);
        this.zzc = zzt0;
        super("log");
        this.zza = z;
        this.zzb = z1;
    }

    @Override  // com.google.android.gms.internal.measurement.zzai
    public final zzao zza(zzg zzg0, List list0) {
        int v2;
        zzh.zzb("log", 1, list0);
        if(list0.size() == 1) {
            String s = zzg0.zza(((zzao)list0.get(0))).zzc();
            this.zzc.zzb().zza(3, s, Collections.EMPTY_LIST, this.zza, this.zzb);
            return zzao.zzf;
        }
        int v = zzh.zzg(((double)zzg0.zza(((zzao)list0.get(0))).zzd()));
        if(v == 2) {
            v2 = 4;
        }
        else {
            switch(v) {
                case 3: {
                    v2 = 1;
                    break;
                }
                case 5: {
                    v2 = 5;
                    break;
                }
                default: {
                    v2 = v == 6 ? 2 : 3;
                }
            }
        }
        String s1 = zzg0.zza(((zzao)list0.get(1))).zzc();
        if(list0.size() == 2) {
            this.zzc.zzb().zza(v2, s1, Collections.EMPTY_LIST, this.zza, this.zzb);
            return zzao.zzf;
        }
        ArrayList arrayList0 = new ArrayList();
        for(int v1 = 2; v1 < Math.min(list0.size(), 5); ++v1) {
            arrayList0.add(zzg0.zza(((zzao)list0.get(v1))).zzc());
        }
        this.zzc.zzb().zza(v2, s1, arrayList0, this.zza, this.zzb);
        return zzao.zzf;
    }
}

