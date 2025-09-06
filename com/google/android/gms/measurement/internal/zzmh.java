package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class zzmh implements Runnable {
    final AtomicReference zza;
    final zzr zzb;
    final zznk zzc;

    public zzmh(zznk zznk0, AtomicReference atomicReference0, zzr zzr0) {
        this.zza = atomicReference0;
        this.zzb = zzr0;
        Objects.requireNonNull(zznk0);
        this.zzc = zznk0;
        super();
    }

    @Override
    public final void run() {
        AtomicReference atomicReference0 = this.zza;
        __monitor_enter(atomicReference0);
        try {
            try {
                zznk zznk0 = this.zzc;
                zzib zzib0 = zznk0.zzu;
                if(zzib0.zzd().zzl().zzo(zzjj.zzb)) {
                    zzga zzga0 = zznk0.zzZ();
                    if(zzga0 != null) {
                        Preconditions.checkNotNull(this.zzb);
                        atomicReference0.set(zzga0.zzm(this.zzb));
                        String s = (String)atomicReference0.get();
                        if(s != null) {
                            zznk0.zzu.zzj().zzR(s);
                            zzib0.zzd().zze.zzb(s);
                        }
                        zznk0.zzV();
                        goto label_24;
                    }
                    zzib0.zzaV().zzb().zza("Failed to get app instance id");
                }
                else {
                    zzib0.zzaV().zzh().zza("Analytics storage consent denied; will not get app instance id");
                    zznk0.zzu.zzj().zzR(null);
                    zzib0.zzd().zze.zzb(null);
                    atomicReference0.set(null);
                }
                goto label_30;
            }
            catch(RemoteException remoteException0) {
                this.zzc.zzu.zzaV().zzb().zzb("Failed to get app instance id", remoteException0);
            }
        }
        catch(Throwable throwable0) {
            goto label_28;
        }
        try {
        label_24:
            this.zza.notify();
        }
        catch(Throwable throwable1) {
            __monitor_exit(atomicReference0);
            throw throwable1;
        }
        __monitor_exit(atomicReference0);
        return;
        try {
        label_28:
            this.zza.notify();
            throw throwable0;
        label_30:
            atomicReference0.notify();
        }
        catch(Throwable throwable1) {
            __monitor_exit(atomicReference0);
            throw throwable1;
        }
        __monitor_exit(atomicReference0);
    }
}

