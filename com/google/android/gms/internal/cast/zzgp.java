package com.google.android.gms.internal.cast;

import U4.x;

final class zzgp extends zzgn {
    private final Object zza;

    public zzgp(Object object0) {
        this.zza = object0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof zzgp ? this.zza.equals(((zzgp)object0).zza) : false;
    }

    @Override
    public final int hashCode() {
        return this.zza.hashCode() + 0x598DF91C;
    }

    @Override
    public final String toString() {
        return x.k("Optional.of(", this.zza.toString(), ")");
    }

    @Override  // com.google.android.gms.internal.cast.zzgn
    public final Object zza(Object object0) {
        zzgo.zzc(object0, "use Optional.orNull() instead of Optional.or(null)");
        return this.zza;
    }
}

