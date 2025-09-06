package com.google.android.gms.internal.measurement;

import H6.k;
import H6.o;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class zzqx implements k {
    private static final zzqx zza;
    private final k zzb;

    static {
        zzqx.zza = new zzqx();
    }

    public zzqx() {
        this.zzb = new o(new zzqz());
    }

    @Override  // H6.k
    public final Object get() {
        return this.zzb();
    }

    @SideEffectFree
    public static boolean zza() {
        return zzqx.zza.zzb().zza();
    }

    public final zzqy zzb() {
        return (zzqy)this.zzb.get();
    }
}

