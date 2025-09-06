package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import b3.Z;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzmn implements Runnable {
    final zzr zza;
    final boolean zzb;
    final zzbe zzc;
    final Bundle zzd;
    final zznk zze;

    public zzmn(zznk zznk0, boolean z, zzr zzr0, boolean z1, zzbe zzbe0, Bundle bundle0) {
        this.zza = zzr0;
        this.zzb = z1;
        this.zzc = zzbe0;
        this.zzd = bundle0;
        Objects.requireNonNull(zznk0);
        this.zze = zznk0;
        super();
    }

    @Override
    public final void run() {
        zzbe zzbe0 = null;
        zznk zznk0 = this.zze;
        zzga zzga0 = zznk0.zzZ();
        if(zzga0 == null) {
            Z.u(zznk0.zzu, "Failed to send default event parameters to service");
            return;
        }
        if(zznk0.zzu.zzc().zzp(null, zzfx.zzbc)) {
            zzr zzr0 = this.zza;
            Preconditions.checkNotNull(zzr0);
            zznk zznk1 = this.zze;
            if(!this.zzb) {
                zzbe0 = this.zzc;
            }
            zznk1.zzm(zzga0, zzbe0, zzr0);
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzga0.zzu(this.zzd, this.zza);
            zznk0.zzV();
        }
        catch(RemoteException remoteException0) {
            this.zze.zzu.zzaV().zzb().zzb("Failed to send default event parameters to service", remoteException0);
        }
    }
}

