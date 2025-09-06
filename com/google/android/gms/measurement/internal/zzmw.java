package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class zzmw implements Runnable {
    final AtomicReference zza;
    final String zzb;
    final String zzc;
    final zzr zzd;
    final boolean zze;
    final zznk zzf;

    public zzmw(zznk zznk0, AtomicReference atomicReference0, String s, String s1, String s2, zzr zzr0, boolean z) {
        this.zza = atomicReference0;
        this.zzb = s1;
        this.zzc = s2;
        this.zzd = zzr0;
        this.zze = z;
        Objects.requireNonNull(zznk0);
        this.zzf = zznk0;
        super();
    }

    @Override
    public final void run() {
        AtomicReference atomicReference0 = this.zza;
        __monitor_enter(atomicReference0);
        try {
            try {
                zznk zznk0 = this.zzf;
                zzga zzga0 = zznk0.zzZ();
                if(zzga0 != null) {
                    if(TextUtils.isEmpty(null)) {
                        Preconditions.checkNotNull(this.zzd);
                        atomicReference0.set(zzga0.zzp(this.zzb, this.zzc, this.zze, this.zzd));
                    }
                    else {
                        atomicReference0.set(zzga0.zzq(null, this.zzb, this.zzc, this.zze));
                    }
                    zznk0.zzV();
                    goto label_18;
                }
                zznk0.zzu.zzaV().zzb().zzd("(legacy) Failed to get user properties; not connected to service", null, this.zzb, this.zzc);
                atomicReference0.set(Collections.EMPTY_LIST);
                goto label_24;
            }
            catch(RemoteException remoteException0) {
                this.zzf.zzu.zzaV().zzb().zzd("(legacy) Failed to get user properties; remote exception", null, this.zzb, remoteException0);
                this.zza.set(Collections.EMPTY_LIST);
            }
        }
        catch(Throwable throwable0) {
            goto label_22;
        }
        try {
        label_18:
            this.zza.notify();
        }
        catch(Throwable throwable1) {
            __monitor_exit(atomicReference0);
            throw throwable1;
        }
        __monitor_exit(atomicReference0);
        return;
        try {
        label_22:
            this.zza.notify();
            throw throwable0;
        label_24:
            atomicReference0.notify();
        }
        catch(Throwable throwable1) {
            __monitor_exit(atomicReference0);
            throw throwable1;
        }
        __monitor_exit(atomicReference0);
    }
}

