package com.google.android.gms.internal.common;

public class zzi {
    private final Class zza;
    private final Object zzb;

    private zzi(Class class0, Object object0) {
        this.zza = class0;
        this.zzb = object0;
    }

    public zzi(Class class0, Object object0, byte[] arr_b) {
        this(class0, object0);
    }

    public static zzi zzb(Class class0, Object object0) {
        return new zzi(class0, object0);
    }

    public final Class zzc() {
        return this.zza;
    }

    public final Object zzd() {
        return this.zzb;
    }
}

