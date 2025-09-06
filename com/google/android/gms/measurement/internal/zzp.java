package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzda;
import java.util.Objects;

final class zzp implements zzjo {
    public final zzda zza;
    final AppMeasurementDynamiteService zzb;

    public zzp(AppMeasurementDynamiteService appMeasurementDynamiteService0, zzda zzda0) {
        Objects.requireNonNull(appMeasurementDynamiteService0);
        this.zzb = appMeasurementDynamiteService0;
        super();
        this.zza = zzda0;
    }

    @Override  // com.google.android.gms.measurement.internal.zzjo
    public final void interceptEvent(String s, String s1, Bundle bundle0, long v) {
        try {
            this.zza.zze(s, s1, bundle0, v);
        }
        catch(RemoteException remoteException0) {
            zzib zzib0 = this.zzb.zza;
            if(zzib0 != null) {
                zzib0.zzaV().zze().zzb("Event interceptor threw exception", remoteException0);
            }
        }
    }
}

