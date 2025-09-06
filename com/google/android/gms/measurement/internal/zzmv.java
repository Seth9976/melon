package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcu;
import java.util.ArrayList;
import java.util.Objects;

final class zzmv implements Runnable {
    final String zza;
    final String zzb;
    final zzr zzc;
    final zzcu zzd;
    final zznk zze;

    public zzmv(zznk zznk0, String s, String s1, zzr zzr0, zzcu zzcu0) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = zzr0;
        this.zzd = zzcu0;
        Objects.requireNonNull(zznk0);
        this.zze = zznk0;
        super();
    }

    @Override
    public final void run() {
        zzga zzga0;
        zznk zznk0;
        ArrayList arrayList0 = new ArrayList();
        try {
            zznk0 = this.zze;
            zzga0 = zznk0.zzZ();
            if(zzga0 == null) {
                zznk0.zzu.zzaV().zzb().zzc("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                goto label_5;
            }
            else {
                goto label_8;
            }
            goto label_20;
        }
        catch(RemoteException remoteException0) {
            goto label_13;
        }
        catch(Throwable throwable0) {
            this.zze.zzu.zzk().zzar(this.zzd, arrayList0);
            throw throwable0;
        }
    label_5:
        zzpo zzpo0 = zznk0.zzu.zzk();
        zzcu zzcu0 = this.zzd;
        goto label_20;
        try {
            try {
            label_8:
                Preconditions.checkNotNull(this.zzc);
                arrayList0 = zzpo.zzas(zzga0.zzr(this.zza, this.zzb, this.zzc));
                zznk0.zzV();
            }
            catch(RemoteException remoteException0) {
            label_13:
                this.zze.zzu.zzaV().zzb().zzd("Failed to get conditional properties; remote exception", this.zza, this.zzb, remoteException0);
            }
        }
        catch(Throwable throwable0) {
            this.zze.zzu.zzk().zzar(this.zzd, arrayList0);
            throw throwable0;
        }
        zzcu0 = this.zzd;
        zzpo0 = this.zze.zzu.zzk();
    label_20:
        zzpo0.zzar(zzcu0, arrayList0);
    }
}

