package com.google.android.gms.measurement.internal;

final class zziy implements Runnable {
    private final zzjc zza;
    private final String zzb;
    private final zzon zzc;
    private final zzgg zzd;

    public zziy(zzjc zzjc0, String s, zzon zzon0, zzgg zzgg0) {
        this.zza = zzjc0;
        this.zzb = s;
        this.zzc = zzon0;
        this.zzd = zzgg0;
    }

    @Override
    public final void run() {
        this.zza.zzI(this.zzb, this.zzc, this.zzd);
    }
}

