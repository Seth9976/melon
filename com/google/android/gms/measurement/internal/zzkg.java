package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class zzkg implements Runnable {
    final long zza;
    final zzli zzb;

    public zzkg(zzli zzli0, long v) {
        this.zza = v;
        Objects.requireNonNull(zzli0);
        this.zzb = zzli0;
        super();
    }

    @Override
    public final void run() {
        zzli zzli0 = this.zzb;
        zzli0.zzg();
        zzli0.zzb();
        zzli0.zzu.zzaV().zzj().zza("Resetting analytics data (FE)");
        zzib zzib0 = zzli0.zzu;
        zzob zzob0 = zzib0.zzh();
        zzob0.zzg();
        zzob0.zzb.zzc();
        zzib0.zzv().zzi();
        boolean z = zzli0.zzu.zzB();
        zzhg zzhg0 = zzli0.zzu.zzd();
        zzhg0.zzc.zzb(this.zza);
        zzib zzib1 = zzhg0.zzu;
        if(!TextUtils.isEmpty(zzib1.zzd().zzq.zza())) {
            zzhg0.zzq.zzb(null);
        }
        zzhg0.zzk.zzb(0L);
        zzhg0.zzl.zzb(0L);
        if(!zzib1.zzc().zzt()) {
            zzhg0.zzn(!z);
        }
        zzhg0.zzr.zzb(null);
        zzhg0.zzs.zzb(0L);
        zzhg0.zzt.zzb(null);
        zzib0.zzt().zzB();
        zzib0.zzh().zza.zza();
        zzli0.zzc = !z;
        zzib0.zzt().zzC(new AtomicReference());
    }
}

