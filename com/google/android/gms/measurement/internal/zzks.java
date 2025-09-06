package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.Editor;
import java.util.Objects;

final class zzks implements Runnable {
    final zzaz zza;
    final zzli zzb;

    public zzks(zzli zzli0, zzaz zzaz0) {
        this.zza = zzaz0;
        Objects.requireNonNull(zzli0);
        this.zzb = zzli0;
        super();
    }

    @Override
    public final void run() {
        zzli zzli0 = this.zzb;
        zzib zzib0 = zzli0.zzu;
        zzhg zzhg0 = zzib0.zzd();
        zzhg0.zzg();
        zzaz zzaz0 = zzhg0.zzj();
        zzaz zzaz1 = this.zza;
        if(zzjk.zzu(zzaz1.zzb(), zzaz0.zzb())) {
            SharedPreferences.Editor sharedPreferences$Editor0 = zzhg0.zzd().edit();
            sharedPreferences$Editor0.putString("dma_consent_settings", zzaz1.zze());
            sharedPreferences$Editor0.apply();
            zzib0.zzaV().zzk().zzb("Setting DMA consent(FE)", zzaz1);
            zzib zzib1 = zzli0.zzu;
            if(zzib1.zzt().zzP()) {
                zzib1.zzt().zzl();
                return;
            }
            zzib1.zzt().zzj(false);
            return;
        }
        zzib0.zzaV().zzi().zzb("Lower precedence consent source ignored, proposed source", zzaz1.zzb());
    }
}

