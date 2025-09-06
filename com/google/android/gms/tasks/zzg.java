package com.google.android.gms.tasks;

final class zzg implements Runnable {
    final zzh zza;

    public zzg(zzh zzh0) {
        this.zza = zzh0;
        super();
    }

    @Override
    public final void run() {
        synchronized(zzh.zzb(this.zza)) {
            zzh zzh0 = this.zza;
            if(zzh.zza(zzh0) != null) {
                zzh.zza(zzh0).onCanceled();
            }
        }
    }
}

