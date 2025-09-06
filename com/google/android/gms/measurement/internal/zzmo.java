package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzcu;
import java.util.Objects;

final class zzmo implements Runnable {
    final zzbg zza;
    final String zzb;
    final zzcu zzc;
    final zznk zzd;

    public zzmo(zznk zznk0, zzbg zzbg0, String s, zzcu zzcu0) {
        this.zza = zzbg0;
        this.zzb = s;
        this.zzc = zzcu0;
        Objects.requireNonNull(zznk0);
        this.zzd = zznk0;
        super();
    }

    @Override
    public final void run() {
        zzga zzga0;
        zznk zznk0;
        byte[] arr_b = null;
        try {
            zznk0 = this.zzd;
            zzga0 = zznk0.zzZ();
            if(zzga0 == null) {
                zznk0.zzu.zzaV().zzb().zza("Discarding data. Failed to send event to service to bundle");
                goto label_5;
            }
            else {
                goto label_8;
            }
            goto label_19;
        }
        catch(RemoteException remoteException0) {
            goto label_12;
        }
        catch(Throwable throwable0) {
            this.zzd.zzu.zzk().zzao(this.zzc, arr_b);
            throw throwable0;
        }
    label_5:
        zzpo zzpo0 = zznk0.zzu.zzk();
        zzcu zzcu0 = this.zzc;
        goto label_19;
        try {
            try {
            label_8:
                arr_b = zzga0.zzk(this.zza, this.zzb);
                zznk0.zzV();
            }
            catch(RemoteException remoteException0) {
            label_12:
                this.zzd.zzu.zzaV().zzb().zzb("Failed to send event to the service to bundle", remoteException0);
            }
        }
        catch(Throwable throwable0) {
            this.zzd.zzu.zzk().zzao(this.zzc, arr_b);
            throw throwable0;
        }
        zzcu0 = this.zzc;
        zzpo0 = this.zzd.zzu.zzk();
    label_19:
        zzpo0.zzao(zzcu0, arr_b);
    }
}

