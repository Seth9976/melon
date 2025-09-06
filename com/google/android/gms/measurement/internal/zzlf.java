package com.google.android.gms.measurement.internal;

final class zzlf implements Runnable {
    private final zzli zza;
    private final String zzb;

    public zzlf(zzli zzli0, String s) {
        this.zza = zzli0;
        this.zzb = s;
    }

    @Override
    public final void run() {
        zzib zzib0 = this.zza.zzu;
        if(zzib0.zzv().zzq(this.zzb)) {
            zzib0.zzv().zzi();
        }
    }
}

