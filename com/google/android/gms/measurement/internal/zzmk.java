package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import b3.Z;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzmk implements Runnable {
    final zzr zza;
    final zznk zzb;

    public zzmk(zznk zznk0, zzr zzr0) {
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
            Z.A(zznk0.zzu, "Failed to send app backgrounded");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzga0.zzA(this.zza);
            zznk0.zzV();
        }
        catch(RemoteException remoteException0) {
            this.zzb.zzu.zzaV().zzb().zzb("Failed to send app backgrounded to the service", remoteException0);
        }
    }
}

