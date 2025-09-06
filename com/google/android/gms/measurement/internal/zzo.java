package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcx;

final class zzo implements Runnable {
    private final AppMeasurementDynamiteService zza;
    private final zzcx zzb;

    public zzo(AppMeasurementDynamiteService appMeasurementDynamiteService0, zzcx zzcx0) {
        this.zza = appMeasurementDynamiteService0;
        this.zzb = zzcx0;
    }

    @Override
    public final void run() {
        try {
            this.zzb.zze();
        }
        catch(RemoteException remoteException0) {
            ((zzib)Preconditions.checkNotNull(this.zza.zza)).zzaV().zze().zzb("Failed to call IDynamiteUploadBatchesCallback", remoteException0);
        }
    }
}

