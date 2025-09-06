package com.google.android.gms.common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.common.zzaj;
import java.util.List;

final class zzaa {
    private String zza;
    private long zzb;
    private zzaj zzc;
    private zzaj zzd;

    public zzaa() {
        this.zza = null;
        this.zzb = -1L;
        this.zzc = zzaj.zzj();
        this.zzd = zzaj.zzj();
    }

    public final zzaa zza(String s) {
        this.zza = s;
        return this;
    }

    public final zzaa zzb(long v) {
        this.zzb = v;
        return this;
    }

    public final zzaa zzc(List list0) {
        Preconditions.checkNotNull(list0);
        this.zzc = zzaj.zzp(list0);
        return this;
    }

    public final zzaa zzd(List list0) {
        Preconditions.checkNotNull(list0);
        this.zzd = zzaj.zzp(list0);
        return this;
    }

    public final zzab zze() {
        if(this.zza == null) {
            throw new IllegalStateException("packageName must be defined");
        }
        if(this.zzb < 0L) {
            throw new IllegalStateException("minimumStampedVersionNumber must be greater than or equal to 0");
        }
        if(this.zzc.isEmpty() && this.zzd.isEmpty()) {
            throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        }
        return new zzab(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}

