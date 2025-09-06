package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzt;
import java.util.concurrent.Callable;

final class zzhp implements Callable {
    private final zzhs zza;

    public zzhp(zzhs zzhs0) {
        this.zza = zzhs0;
    }

    @Override
    public final Object call() {
        return new zzt(this.zza.zze);
    }
}

