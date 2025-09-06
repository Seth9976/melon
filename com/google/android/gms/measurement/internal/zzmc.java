package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class zzmc implements Runnable {
    final AtomicReference zza;
    final zzr zzb;
    final boolean zzc;
    final zznk zzd;

    public zzmc(zznk zznk0, AtomicReference atomicReference0, zzr zzr0, boolean z) {
        this.zza = atomicReference0;
        this.zzb = zzr0;
        this.zzc = z;
        Objects.requireNonNull(zznk0);
        this.zzd = zznk0;
        super();
    }

    @Override
    public final void run() {
        zzga zzga0;
        zznk zznk0;
        AtomicReference atomicReference0 = this.zza;
        __monitor_enter(atomicReference0);
        try {
            zznk0 = this.zzd;
            zzga0 = zznk0.zzZ();
            if(zzga0 == null) {
                zznk0.zzu.zzaV().zzb().zza("Failed to get all user properties; not connected to service");
                goto label_6;
            }
            goto label_9;
        }
        catch(RemoteException remoteException0) {
            goto label_14;
        }
        catch(Throwable throwable0) {
            goto label_17;
        }
        try {
        label_6:
            atomicReference0.notify();
        }
        catch(Throwable throwable1) {
            __monitor_exit(atomicReference0);
            throw throwable1;
        }
        __monitor_exit(atomicReference0);
        return;
        try {
            try {
            label_9:
                Preconditions.checkNotNull(this.zzb);
                atomicReference0.set(zzga0.zzj(this.zzb, this.zzc));
                zznk0.zzV();
            }
            catch(RemoteException remoteException0) {
            label_14:
                this.zzd.zzu.zzaV().zzb().zzb("Failed to get all user properties; remote exception", remoteException0);
            }
            goto label_19;
        }
        catch(Throwable throwable0) {
            try {
            label_17:
                this.zza.notify();
                throw throwable0;
            label_19:
                this.zza.notify();
                goto label_24;
            }
            catch(Throwable throwable1) {
            }
        }
        __monitor_exit(atomicReference0);
        throw throwable1;
    label_24:
        __monitor_exit(atomicReference0);
    }
}

