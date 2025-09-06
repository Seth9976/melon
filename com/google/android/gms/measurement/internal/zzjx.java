package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzjx implements Runnable {
    final boolean zza;
    final zzli zzb;

    public zzjx(zzli zzli0, boolean z) {
        this.zza = z;
        Objects.requireNonNull(zzli0);
        this.zzb = zzli0;
        super();
    }

    @Override
    public final void run() {
        zzli zzli0 = this.zzb;
        zzib zzib0 = zzli0.zzu;
        boolean z = zzib0.zzB();
        boolean z1 = zzib0.zzA();
        boolean z2 = this.zza;
        zzib0.zzz(z2);
        if(z1 == z2) {
            zzib0.zzaV().zzk().zzb("Default data collection state already set to", Boolean.valueOf(z2));
        }
        if(zzib0.zzB() == z || zzib0.zzB() != zzib0.zzA()) {
            zzib0.zzaV().zzh().zzc("Default data collection is different than actual status", Boolean.valueOf(z2), Boolean.valueOf(z));
        }
        zzli0.zzak();
    }
}

