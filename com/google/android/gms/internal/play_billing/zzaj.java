package com.google.android.gms.internal.play_billing;

import A7.d;
import k8.Y;

final class zzaj {
    private final Object zza;
    private final Object zzb;
    private final Object zzc;

    public zzaj(Object object0, Object object1, Object object2) {
        this.zza = object0;
        this.zzb = object1;
        this.zzc = object2;
    }

    public final IllegalArgumentException zza() {
        return new IllegalArgumentException(Y.l(d.o("Multiple entries with same key: ", String.valueOf(this.zza), "=", String.valueOf(this.zzb), " and "), String.valueOf(this.zza), "=", String.valueOf(this.zzc)));
    }
}

