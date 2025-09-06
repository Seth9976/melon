package com.google.android.gms.cloudmessaging;

public final class zzn implements Runnable {
    public final zzp zza;
    public final zzs zzb;

    public zzn(zzp zzp0, zzs zzs0) {
        this.zza = zzp0;
        this.zzb = zzs0;
    }

    @Override
    public final void run() {
        this.zza.zze(this.zzb.zza);
    }
}

