package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;

public final class zzhk {
    private final zzhk.zza zza;

    public zzhk(zzhk.zza zzhk$zza0) {
        Preconditions.checkNotNull(zzhk$zza0);
        this.zza = zzhk$zza0;
    }

    public final void zza(Context context0, Intent intent0) {
        zzgt zzgt0 = zzib.zzy(context0, null, null).zzaV();
        if(intent0 == null) {
            zzgt0.zze().zza("Receiver called with null intent");
            return;
        }
        String s = intent0.getAction();
        zzgt0.zzk().zzb("Local receiver got", s);
        if("com.google.android.gms.measurement.UPLOAD".equals(s)) {
            Intent intent1 = new Intent().setClassName(context0, "com.google.android.gms.measurement.AppMeasurementService");
            intent1.setAction("com.google.android.gms.measurement.UPLOAD");
            zzgt0.zzk().zza("Starting wakeful intent.");
            this.zza.doStartService(context0, intent1);
            return;
        }
        if("com.android.vending.INSTALL_REFERRER".equals(s)) {
            zzgt0.zze().zza("Install Referrer Broadcasts are deprecated");
        }
    }
}

