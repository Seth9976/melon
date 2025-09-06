package com.google.android.gms.internal.measurement;

import H6.k;
import H6.o;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzrj implements k {
    private static final zzrj zza;
    private final k zzb;

    static {
        zzrj.zza = new zzrj();
    }

    public zzrj() {
        this.zzb = new o(new zzrl());
    }

    @Override  // H6.k
    public final Object get() {
        return this.zzb();
    }

    @SideEffectFree
    public static boolean zza() {
        return zzrj.zza.zzb().zza();
    }

    public final zzrk zzb() {
        return (zzrk)this.zzb.get();
    }
}

