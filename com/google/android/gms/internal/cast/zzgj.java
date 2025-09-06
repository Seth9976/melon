package com.google.android.gms.internal.cast;

final class zzgj extends zzgn {
    static final zzgj zza;

    static {
        zzgj.zza = new zzgj();
    }

    @Override
    public final boolean equals(Object object0) {
        return this == object0;
    }

    @Override
    public final int hashCode() {
        return 2040732332;
    }

    @Override
    public final String toString() {
        return "Optional.absent()";
    }

    @Override  // com.google.android.gms.internal.cast.zzgn
    public final Object zza(Object object0) {
        zzgo.zzc(object0, "use Optional.orNull() instead of Optional.or(null)");
        return object0;
    }
}

