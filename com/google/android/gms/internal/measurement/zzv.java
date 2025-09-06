package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzv extends zzai {
    private final zzz zza;

    public zzv(zzz zzz0) {
        super("internal.registerCallback");
        this.zza = zzz0;
    }

    @Override  // com.google.android.gms.internal.measurement.zzai
    public final zzao zza(zzg zzg0, List list0) {
        zzh.zza(this.zzd, 3, list0);
        String s = zzg0.zza(((zzao)list0.get(0))).zzc();
        zzao zzao0 = zzg0.zza(((zzao)list0.get(1)));
        if(!(zzao0 instanceof zzan)) {
            throw new IllegalArgumentException("Invalid callback type");
        }
        zzao zzao1 = zzg0.zza(((zzao)list0.get(2)));
        if(!(zzao1 instanceof zzal)) {
            throw new IllegalArgumentException("Invalid callback params");
        }
        if(!((zzal)zzao1).zzj("type")) {
            throw new IllegalArgumentException("Undefined rule type");
        }
        String s1 = ((zzal)zzao1).zzk("type").zzc();
        int v = ((zzal)zzao1).zzj("priority") ? zzh.zzg(((double)((zzal)zzao1).zzk("priority").zzd())) : 1000;
        this.zza.zza(s, v, ((zzan)zzao0), s1);
        return zzao.zzf;
    }
}

