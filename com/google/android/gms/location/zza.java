package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
public final class zza {
    private long zza;

    public zza() {
        this.zza = 0x8000000000000000L;
    }

    public final zza zza(long v) {
        Preconditions.checkArgument(v >= 0L, "intervalMillis can\'t be negative.");
        this.zza = v;
        return this;
    }

    public final zzb zzb() {
        Preconditions.checkState(this.zza != 0x8000000000000000L, "Must set intervalMillis.");
        return new zzb(this.zza, true, null, null, null, false, null, 0L, null);
    }
}

