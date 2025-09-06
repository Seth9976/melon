package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzt extends zzai {
    private final zzr zza;

    public zzt(zzr zzr0) {
        super("internal.logger");
        this.zza = zzr0;
        zzs zzs0 = new zzs(this, false, true);
        this.zze.put("log", zzs0);
        zzp zzp0 = new zzp(this, "silent");
        this.zze.put("silent", zzp0);
        ((zzai)this.zze.get("silent")).zzm("log", new zzs(this, true, true));
        zzq zzq0 = new zzq(this, "unmonitored");
        this.zze.put("unmonitored", zzq0);
        ((zzai)this.zze.get("unmonitored")).zzm("log", new zzs(this, false, false));
    }

    @Override  // com.google.android.gms.internal.measurement.zzai
    public final zzao zza(zzg zzg0, List list0) {
        return zzao.zzf;
    }

    public final zzr zzb() {
        return this.zza;
    }
}

