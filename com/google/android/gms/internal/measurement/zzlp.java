package com.google.android.gms.internal.measurement;

final class zzlp {
    private final Object zza;
    private final int zzb;

    public zzlp(Object object0, int v) {
        this.zza = object0;
        this.zzb = v;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof zzlp ? this.zza == ((zzlp)object0).zza && this.zzb == ((zzlp)object0).zzb : false;
    }

    @Override
    public final int hashCode() {
        return System.identityHashCode(this.zza) * 0xFFFF + this.zzb;
    }
}

