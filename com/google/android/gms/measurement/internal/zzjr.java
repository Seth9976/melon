package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdd;

public final class zzjr {
    final Context zza;
    Boolean zzb;
    long zzc;
    zzdd zzd;
    boolean zze;
    final Long zzf;
    String zzg;

    public zzjr(Context context0, zzdd zzdd0, Long long0) {
        this.zze = true;
        Preconditions.checkNotNull(context0);
        Context context1 = context0.getApplicationContext();
        Preconditions.checkNotNull(context1);
        this.zza = context1;
        this.zzf = long0;
        if(zzdd0 != null) {
            this.zzd = zzdd0;
            this.zze = zzdd0.zzc;
            this.zzc = zzdd0.zzb;
            this.zzg = zzdd0.zze;
            Bundle bundle0 = zzdd0.zzd;
            if(bundle0 != null) {
                this.zzb = Boolean.valueOf(bundle0.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}

