package com.google.android.gms.cast;

public final class zzbp implements Runnable {
    public final zzbq zza;
    public final int zzb;

    public zzbp(zzbq zzbq0, int v) {
        this.zza = zzbq0;
        this.zzb = v;
    }

    @Override
    public final void run() {
        zzbr.zzO(this.zza.zza, 4);
        int v = this.zzb;
        synchronized(zzbr.zzt(this.zza.zza)) {
            for(Object object0: zzbr.zzt(this.zza.zza)) {
                ((zzq)object0).zzc(v);
            }
        }
    }
}

