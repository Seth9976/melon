package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcu;
import java.util.Objects;

final class zzmi implements Runnable {
    final zzr zza;
    final zzcu zzb;
    final zznk zzc;

    public zzmi(zznk zznk0, zzr zzr0, zzcu zzcu0) {
        this.zza = zzr0;
        this.zzb = zzcu0;
        Objects.requireNonNull(zznk0);
        this.zzc = zznk0;
        super();
    }

    @Override
    public final void run() {
        zzib zzib0;
        String s;
        try {
            try {
                s = null;
                zznk zznk0 = this.zzc;
                zzib0 = zznk0.zzu;
                if(zzib0.zzd().zzl().zzo(zzjj.zzb)) {
                    zzga zzga0 = zznk0.zzZ();
                    if(zzga0 == null) {
                        zzib0.zzaV().zzb().zza("Failed to get app instance id");
                        goto label_28;
                    }
                    else {
                        Preconditions.checkNotNull(this.zza);
                        s = zzga0.zzm(this.zza);
                        if(s != null) {
                            zznk0.zzu.zzj().zzR(s);
                            zzib0.zzd().zze.zzb(s);
                        }
                        zznk0.zzV();
                        goto label_23;
                    }
                }
                else {
                    zzib0.zzaV().zzh().zza("Analytics storage consent denied; will not get app instance id");
                    zznk0.zzu.zzj().zzR(null);
                    zzib0.zzd().zze.zzb(null);
                    goto label_28;
                }
                goto label_30;
            }
            catch(RemoteException remoteException0) {
            }
            this.zzc.zzu.zzaV().zzb().zzb("Failed to get app instance id", remoteException0);
        }
        catch(Throwable throwable0) {
            this.zzc.zzu.zzk().zzal(this.zzb, s);
            throw throwable0;
        }
    label_23:
        zzcu zzcu0 = this.zzb;
        zzpo zzpo0 = this.zzc.zzu.zzk();
        goto label_30;
    label_28:
        zzpo0 = zzib0.zzk();
        zzcu0 = this.zzb;
    label_30:
        zzpo0.zzal(zzcu0, s);
    }
}

