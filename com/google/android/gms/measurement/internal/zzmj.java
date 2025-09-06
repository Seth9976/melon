package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import b3.Z;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzmj implements Runnable {
    final zzr zza;
    final zznk zzb;

    public zzmj(zznk zznk0, zzr zzr0, boolean z) {
        this.zza = zzr0;
        Objects.requireNonNull(zznk0);
        this.zzb = zznk0;
        super();
    }

    @Override
    public final void run() {
        zznk zznk0 = this.zzb;
        zzga zzga0 = zznk0.zzZ();
        if(zzga0 == null) {
            Z.u(zznk0.zzu, "Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzr zzr0 = this.zza;
            Preconditions.checkNotNull(zzr0);
            zzib zzib0 = zznk0.zzu;
            zzfw zzfw0 = zzfx.zzbc;
            if(zzib0.zzc().zzp(null, zzfw0)) {
                zznk0.zzm(zzga0, null, zzr0);
            }
            zzga0.zzg(zzr0);
            zznk0.zzu.zzm().zzo();
            zzib0.zzc().zzp(null, zzfw0);
            zznk0.zzm(zzga0, null, zzr0);
            zznk0.zzV();
            return;
        }
        catch(RemoteException remoteException0) {
        }
        this.zzb.zzu.zzaV().zzb().zzb("Failed to send app launch to the service", remoteException0);
    }
}

