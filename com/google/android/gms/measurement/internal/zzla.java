package com.google.android.gms.measurement.internal;

import android.os.Build.VERSION;
import android.util.SparseArray;
import java.util.List;

final class zzla implements Runnable {
    private final zzli zza;
    private final List zzb;

    public zzla(zzli zzli0, List list0) {
        this.zza = zzli0;
        this.zzb = list0;
    }

    @Override
    public final void run() {
        zzli zzli0 = this.zza;
        zzli0.zzg();
        if(Build.VERSION.SDK_INT < 30) {
            return;
        }
        SparseArray sparseArray0 = zzli0.zzu.zzd().zzf();
        for(Object object0: this.zzb) {
            zzog zzog0 = (zzog)object0;
            if(!sparseArray0.contains(zzog0.zzc) || ((long)(((Long)sparseArray0.get(zzog0.zzc)))) < zzog0.zzb) {
                zzli0.zzy().add(zzog0);
            }
        }
        zzli0.zzz();
    }
}

