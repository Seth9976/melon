package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzn;
import java.util.concurrent.Callable;

final class zzhr implements Callable {
    private final zzhs zza;
    private final String zzb;

    public zzhr(zzhs zzhs0, String s) {
        this.zza = zzhs0;
        this.zzb = s;
    }

    @Override
    public final Object call() {
        return new zzn("internal.remoteConfig", new zzhn(this.zza, this.zzb));
    }
}

