package com.google.android.gms.internal.measurement;

import H6.k;
import H6.o;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzqo implements k {
    private static final zzqo zza;
    private final k zzb;

    static {
        zzqo.zza = new zzqo();
    }

    public zzqo() {
        this.zzb = new o(new zzqq());
    }

    @Override  // H6.k
    public final Object get() {
        return this.zzb();
    }

    @SideEffectFree
    public static boolean zza() {
        return zzqo.zza.zzb().zza();
    }

    public final zzqp zzb() {
        return (zzqp)this.zzb.get();
    }
}

