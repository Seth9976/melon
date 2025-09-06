package com.google.android.gms.internal.cast;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

final class zzjh extends zzjm {
    private static final zzjh zza;
    private final AtomicReference zzb;

    static {
        zzjh.zza = new zzjh(zzjm.zze());
    }

    public zzjh(zzjm zzjm0) {
        this.zzb = new AtomicReference(zzjm0);
    }

    @Override  // com.google.android.gms.internal.cast.zzjm
    public final zzik zza() {
        return ((zzjm)this.zzb.get()).zza();
    }

    public static final zzjh zzb() {
        return zzjh.zza;
    }

    @Override  // com.google.android.gms.internal.cast.zzjm
    public final zzjy zzc() {
        return ((zzjm)this.zzb.get()).zzc();
    }

    @Override  // com.google.android.gms.internal.cast.zzjm
    public final boolean zzd(String s, Level level0, boolean z) {
        ((zzjm)this.zzb.get()).zzd(s, level0, z);
        return false;
    }
}

