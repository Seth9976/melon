package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzel {
    private static final zzel zza;
    private final zzep zzb;
    private final ConcurrentMap zzc;

    static {
        zzel.zza = new zzel();
    }

    private zzel() {
        this.zzc = new ConcurrentHashMap();
        this.zzb = new zzdu();
    }

    public static zzel zza() {
        return zzel.zza;
    }

    public final zzeo zzb(Class class0) {
        zzda.zzc(class0, "messageType");
        zzeo zzeo0 = (zzeo)this.zzc.get(class0);
        if(zzeo0 == null) {
            zzeo zzeo1 = this.zzb.zza(class0);
            zzda.zzc(class0, "messageType");
            zzeo zzeo2 = (zzeo)this.zzc.putIfAbsent(class0, zzeo1);
            return zzeo2 == null ? zzeo1 : zzeo2;
        }
        return zzeo0;
    }
}

