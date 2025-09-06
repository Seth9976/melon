package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.Callable;

final class zzoy implements Callable {
    final zzr zza;
    final zzpf zzb;

    public zzoy(zzpf zzpf0, zzr zzr0) {
        this.zza = zzr0;
        Objects.requireNonNull(zzpf0);
        this.zzb = zzpf0;
        super();
    }

    @Override
    public final Object call() {
        zzr zzr0 = this.zza;
        String s = (String)Preconditions.checkNotNull(zzr0.zza);
        zzpf zzpf0 = this.zzb;
        if(zzpf0.zzB(s).zzo(zzjj.zzb) && zzjk.zzf(zzr0.zzs, 100).zzo(zzjj.zzb)) {
            return zzpf0.zzan(zzr0).zzd();
        }
        zzpf0.zzaV().zzk().zza("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}

