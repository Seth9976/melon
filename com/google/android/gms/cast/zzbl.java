package com.google.android.gms.cast;

public final class zzbl implements Runnable {
    public final zzbq zza;
    public final int zzb;

    public zzbl(zzbq zzbq0, int v) {
        this.zza = zzbq0;
        this.zzb = v;
    }

    @Override
    public final void run() {
        zzbq zzbq0 = this.zza;
        zzbr.zzG(zzbq0.zza);
        zzbr.zzO(zzbq0.zza, 1);
        int v = this.zzb;
        synchronized(zzbr.zzt(zzbq0.zza)) {
            for(Object object0: zzbr.zzt(zzbq0.zza)) {
                ((zzq)object0).zzd(v);
            }
        }
        zzbr.zzJ(zzbq0.zza);
        zzbr.zzs(zzbq0.zza, zzbq0.zza.zza);
    }
}

