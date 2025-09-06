package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zznx {
    final zzob zza;
    private zznw zzb;

    public zznx(zzob zzob0) {
        Objects.requireNonNull(zzob0);
        this.zza = zzob0;
        super();
    }

    public final void zza() {
        zzob zzob0 = this.zza;
        zzob0.zzg();
        zznw zznw0 = this.zzb;
        if(zznw0 != null) {
            zzob0.zzm().removeCallbacks(zznw0);
        }
        zzib zzib0 = zzob0.zzu;
        zzib0.zzd().zzn.zzb(false);
        zzob0.zzh(false);
        if(zzib0.zzc().zzp(null, zzfx.zzaT)) {
            zzib zzib1 = zzob0.zzu;
            if(zzib1.zzj().zzx()) {
                zzib0.zzaV().zzk().zza("Retrying trigger URI registration in foreground");
                zzib1.zzj().zzz();
            }
        }
    }

    public final void zzb(long v) {
        this.zzb = new zznw(this, this.zza.zzu.zzaZ().currentTimeMillis(), v);
        this.zza.zzm().postDelayed(this.zzb, 2000L);
    }
}

