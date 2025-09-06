package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import b3.Z;
import java.util.Objects;

final class zzmm implements Runnable {
    final zzlt zza;
    final zznk zzb;

    public zzmm(zznk zznk0, zzlt zzlt0) {
        this.zza = zzlt0;
        Objects.requireNonNull(zznk0);
        this.zzb = zznk0;
        super();
    }

    @Override
    public final void run() {
        zznk zznk0 = this.zzb;
        zzga zzga0 = zznk0.zzZ();
        if(zzga0 == null) {
            Z.u(zznk0.zzu, "Failed to send current screen to service");
            return;
        }
        try {
            zzlt zzlt0 = this.zza;
            if(zzlt0 == null) {
                zzga0.zzl(0L, null, null, "com.iloen.melon");
            }
            else {
                zzga0.zzl(zzlt0.zzc, zzlt0.zza, zzlt0.zzb, "com.iloen.melon");
            }
            zznk0.zzV();
            return;
        }
        catch(RemoteException remoteException0) {
        }
        this.zzb.zzu.zzaV().zzb().zzb("Failed to send current screen to the service", remoteException0);
    }
}

