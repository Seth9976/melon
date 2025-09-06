package com.google.android.gms.internal.cast;

import java.util.concurrent.Callable;

final class zzvw extends zzvn {
    final zzvx zza;
    private final Callable zzb;

    public zzvw(zzvx zzvx0, Callable callable0) {
        this.zza = zzvx0;
        super();
        callable0.getClass();
        this.zzb = callable0;
    }

    @Override  // com.google.android.gms.internal.cast.zzvn
    public final Object zza() {
        return this.zzb.call();
    }

    @Override  // com.google.android.gms.internal.cast.zzvn
    public final String zzb() {
        return this.zzb.toString();
    }

    @Override  // com.google.android.gms.internal.cast.zzvn
    public final void zzc(Throwable throwable0) {
        this.zza.zzg(throwable0);
    }

    @Override  // com.google.android.gms.internal.cast.zzvn
    public final void zzd(Object object0) {
        this.zza.zzf(object0);
    }

    @Override  // com.google.android.gms.internal.cast.zzvn
    public final boolean zzf() {
        return this.zza.isDone();
    }
}

