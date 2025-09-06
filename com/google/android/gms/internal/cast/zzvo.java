package com.google.android.gms.internal.cast;

import java.util.logging.Logger;

final class zzvo {
    private final zzgv zza;
    private final String zzb;
    private volatile Logger zzc;

    public zzvo(Class class0) {
        this.zza = new zzgv();
        this.zzb = class0.getName();
    }

    public final Logger zza() {
        Logger logger0 = this.zzc;
        if(logger0 != null) {
            return logger0;
        }
        synchronized(this.zza) {
            Logger logger1 = this.zzc;
            if(logger1 != null) {
                return logger1;
            }
            Logger logger2 = Logger.getLogger(this.zzb);
            this.zzc = logger2;
            return logger2;
        }
    }
}

