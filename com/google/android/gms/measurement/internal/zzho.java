package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzu;
import java.util.concurrent.Callable;

final class zzho implements Callable {
    private final zzhs zza;
    private final String zzb;

    public zzho(zzhs zzhs0, String s) {
        this.zza = zzhs0;
        this.zzb = s;
    }

    @Override
    public final Object call() {
        return new zzu("internal.appMetadata", new zzhq(this.zza, this.zzb));
    }
}

