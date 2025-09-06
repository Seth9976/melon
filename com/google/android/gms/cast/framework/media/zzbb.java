package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.zzas;
import com.google.android.gms.cast.zzr;
import java.util.concurrent.atomic.AtomicLong;

final class zzbb implements zzas {
    final RemoteMediaClient zza;
    private zzr zzb;
    private final AtomicLong zzc;

    public zzbb(RemoteMediaClient remoteMediaClient0) {
        this.zza = remoteMediaClient0;
        super();
        this.zzc = new AtomicLong((CastUtils.zza() & 0xFFFFL) * 10000L);
    }

    @Override  // com.google.android.gms.cast.internal.zzas
    public final long zza() {
        return this.zzc.getAndIncrement();
    }

    @Override  // com.google.android.gms.cast.internal.zzas
    public final void zzb(String s, String s1, long v, String s2) {
        zzr zzr0 = this.zzb;
        if(zzr0 == null) {
            throw new IllegalStateException("Device is not connected");
        }
        zzr0.zzh(s, s1).addOnFailureListener(new zzba(this, v));
    }

    public final void zzc(zzr zzr0) {
        this.zzb = zzr0;
    }
}

