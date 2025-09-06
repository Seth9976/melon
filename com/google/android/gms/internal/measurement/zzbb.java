package com.google.android.gms.internal.measurement;

import b3.Z;
import java.util.List;

public final class zzbb extends zzav {
    public zzbb() {
        this.zza.add(zzbk.zzb);
        this.zza.add(zzbk.zzV);
        this.zza.add(zzbk.zzY);
    }

    @Override  // com.google.android.gms.internal.measurement.zzav
    public final zzao zza(String s, zzg zzg0, List list0) {
        switch(zzh.zze(s).ordinal()) {
            case 1: {
                zzao zzao0 = zzg0.zza(((zzao)Z.i(zzbk.zzb, 2, list0, 0)));
                return zzao0.zze().booleanValue() ? zzg0.zza(((zzao)list0.get(1))) : zzao0;
            }
            case 0x2F: {
                return new zzaf(Boolean.valueOf(!zzg0.zza(((zzao)Z.i(zzbk.zzV, 1, list0, 0))).zze().booleanValue()));
            }
            case 50: {
                zzao zzao1 = zzg0.zza(((zzao)Z.i(zzbk.zzY, 2, list0, 0)));
                return zzao1.zze().booleanValue() ? zzao1 : zzg0.zza(((zzao)list0.get(1)));
            }
            default: {
                return this.zzb(s);
            }
        }
    }
}

