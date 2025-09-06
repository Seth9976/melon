package com.google.android.gms.measurement.internal;

import android.util.Log;
import java.util.Objects;

final class zzgq implements Runnable {
    final int zza;
    final String zzb;
    final Object zzc;
    final Object zzd;
    final Object zze;
    final zzgt zzf;

    public zzgq(zzgt zzgt0, int v, String s, Object object0, Object object1, Object object2) {
        this.zza = v;
        this.zzb = s;
        this.zzc = object0;
        this.zzd = object1;
        this.zze = object2;
        Objects.requireNonNull(zzgt0);
        this.zzf = zzgt0;
        super();
    }

    @Override
    public final void run() {
        zzgt zzgt0 = this.zzf;
        zzhg zzhg0 = zzgt0.zzu.zzd();
        if(zzhg0.zzv()) {
            if(zzgt0.zzr() == 0) {
                if(zzgt0.zzu.zzc().zzj()) {
                    zzgt0.zzs('C');
                }
                else {
                    zzgt0.zzs('c');
                }
            }
            if(zzgt0.zzt() < 0L) {
                zzgt0.zzu.zzc().zzi();
                zzgt0.zzu(130000L);
            }
            String s = this.zzb;
            String s1 = zzgt.zzo(true, s, this.zzc, this.zzd, this.zze);
            String s2 = "2" + "01VDIWEA?".charAt(this.zza) + zzgt0.zzr() + zzgt0.zzt() + ":" + s1;
            if(s2.length() > 0x400) {
                s2 = s.substring(0, 0x400);
            }
            zzhe zzhe0 = zzhg0.zzb;
            if(zzhe0 != null) {
                zzhe0.zza(s2, 1L);
            }
            return;
        }
        Log.println(6, zzgt0.zzn(), "Persisted config not initialized. Not logging error/warn");
    }
}

