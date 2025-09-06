package com.google.android.gms.measurement.internal;

import b3.Z;
import java.util.Objects;

final class zzu implements Runnable {
    private final zzib zza;

    public zzu(zzib zzib0) {
        this.zza = zzib0;
    }

    @Override
    public final void run() {
        zzib zzib0 = this.zza;
        if(!zzib0.zzk().zzS()) {
            Z.A(zzib0, "registerTrigger called but app not eligible");
            return;
        }
        zzib0.zzj().zzv();
        zzli zzli0 = zzib0.zzj();
        Objects.requireNonNull(zzli0);
        new Thread(new zzv(zzli0)).start();
    }
}

