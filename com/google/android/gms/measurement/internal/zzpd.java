package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzpd {
    private final zzpf zza;
    private int zzb;
    private long zzc;

    public zzpd(zzpf zzpf0) {
        this.zza = zzpf0;
        this.zzb = 1;
        this.zzc = this.zzd();
    }

    public final void zza() {
        ++this.zzb;
        this.zzc = this.zzd();
    }

    public final boolean zzb() {
        return this.zza.zzaZ().currentTimeMillis() >= this.zzc;
    }

    public final long zzc() {
        return this.zzc;
    }

    private final long zzd() {
        zzpf zzpf0 = this.zza;
        Preconditions.checkNotNull(zzpf0);
        long v = (long)(((Long)zzfx.zzu.zzb(null)));
        long v1 = (long)(((Long)zzfx.zzv.zzb(null)));
        for(int v2 = 1; v2 < this.zzb; ++v2) {
            v += v;
            if(v >= v1) {
                break;
            }
        }
        return Math.min(v, v1) + zzpf0.zzaZ().currentTimeMillis();
    }
}

