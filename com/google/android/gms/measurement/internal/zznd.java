package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

final class zznd implements Runnable {
    final ConnectionResult zza;
    final zzne zzb;

    public zznd(zzne zzne0, ConnectionResult connectionResult0) {
        this.zza = connectionResult0;
        Objects.requireNonNull(zzne0);
        this.zzb = zzne0;
        super();
    }

    @Override
    public final void run() {
        zznk zznk0 = this.zzb.zza;
        zznk0.zzaa(null);
        if(this.zza.getErrorCode() == 7777) {
            if(zznk0.zzab() == null) {
                zznk0.zzac(Executors.newScheduledThreadPool(1));
            }
            zznk0.zzab().schedule(new zznb(this), ((long)(((Long)zzfx.zzZ.zzb(null)))), TimeUnit.MILLISECONDS);
            return;
        }
        zznk0.zzX();
    }
}

