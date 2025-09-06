package com.google.android.gms.internal.cast;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import javax.annotation.Nullable;

public final class zzfq implements Result {
    private final Status zza;
    @Nullable
    private final zzfk zzb;

    public zzfq(Status status0, @Nullable zzfk zzfk0) {
        this.zza = status0;
        this.zzb = zzfk0;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }

    @Override
    public final String toString() {
        Preconditions.checkNotNull(this.zzb);
        return "OptInOptionsResultImpl[" + (this.zzb.zza() == 1) + "]";
    }

    public final boolean zza() {
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zza() == 1;
    }
}

