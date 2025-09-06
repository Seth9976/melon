package com.google.android.gms.internal.play_billing;

final class zzcc {
    private final Object zza;
    private final int zzb;

    public zzcc(Object object0, int v) {
        this.zza = object0;
        this.zzb = v;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof zzcc ? this.zza == ((zzcc)object0).zza && this.zzb == ((zzcc)object0).zzb : false;
    }

    @Override
    public final int hashCode() {
        return System.identityHashCode(this.zza) * 0xFFFF + this.zzb;
    }
}

