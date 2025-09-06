package com.google.android.gms.cast;

public final class zzbm implements Runnable {
    public final zzbq zza;
    public final int zzb;

    public zzbm(zzbq zzbq0, int v) {
        this.zza = zzbq0;
        this.zzb = v;
    }

    @Override
    public final void run() {
        zzbq zzbq0 = this.zza;
        int v = this.zzb;
        if(v == 0) {
            zzbr.zzO(zzbq0.zza, 3);
            zzbr.zzF(zzbq0.zza, true);
            zzbr.zzE(zzbq0.zza, true);
            synchronized(zzbr.zzt(zzbq0.zza)) {
                for(Object object0: zzbr.zzt(zzbq0.zza)) {
                    ((zzq)object0).zza();
                }
            }
            return;
        }
        zzbr.zzO(zzbq0.zza, 1);
        synchronized(zzbr.zzt(zzbq0.zza)) {
            for(Object object1: zzbr.zzt(zzbq0.zza)) {
                ((zzq)object1).zzb(v);
            }
        }
        zzbr.zzJ(zzbq0.zza);
    }
}

