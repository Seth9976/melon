package com.google.android.gms.measurement.internal;

import java.util.Objects;

public final class zzgr {
    final zzgt zza;
    private final int zzb;
    private final boolean zzc;
    private final boolean zzd;

    public zzgr(zzgt zzgt0, int v, boolean z, boolean z1) {
        Objects.requireNonNull(zzgt0);
        this.zza = zzgt0;
        super();
        this.zzb = v;
        this.zzc = z;
        this.zzd = z1;
    }

    public final void zza(String s) {
        this.zza.zzm(this.zzb, this.zzc, this.zzd, s, null, null, null);
    }

    public final void zzb(String s, Object object0) {
        this.zza.zzm(this.zzb, this.zzc, this.zzd, s, object0, null, null);
    }

    public final void zzc(String s, Object object0, Object object1) {
        this.zza.zzm(this.zzb, this.zzc, this.zzd, s, object0, object1, null);
    }

    public final void zzd(String s, Object object0, Object object1, Object object2) {
        this.zza.zzm(this.zzb, this.zzc, this.zzd, s, object0, object1, object2);
    }
}

