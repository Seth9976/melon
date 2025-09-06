package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzcu;
import java.util.Objects;

final class zzkl implements Runnable {
    final zzcu zza;
    final zzli zzb;

    public zzkl(zzli zzli0, zzcu zzcu0) {
        this.zza = zzcu0;
        Objects.requireNonNull(zzli0);
        this.zzb = zzli0;
        super();
    }

    @Override
    public final void run() {
        Long long0;
        zzli zzli0 = this.zzb;
        zzib zzib0 = zzli0.zzu.zzh().zzu;
        if(zzib0.zzd().zzl().zzo(zzjj.zzb)) {
            long0 = zzib0.zzd().zzp(zzib0.zzaZ().currentTimeMillis()) || zzib0.zzd().zzl.zza() == 0L ? null : zzib0.zzd().zzl.zza();
        }
        else {
            zzib0.zzaV().zzh().zza("Analytics storage consent denied; will not get session id");
            long0 = null;
        }
        if(long0 != null) {
            zzli0.zzu.zzk().zzam(this.zza, ((long)long0));
            return;
        }
        try {
            this.zza.zzb(null);
        }
        catch(RemoteException remoteException0) {
            this.zzb.zzu.zzaV().zzb().zzb("getSessionId failed with exception", remoteException0);
        }
    }
}

