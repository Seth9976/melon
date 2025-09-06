package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzdv extends zzeq {
    final Runnable zza;
    final zzfb zzb;

    public zzdv(zzfb zzfb0, Runnable runnable0) {
        this.zza = runnable0;
        Objects.requireNonNull(zzfb0);
        this.zzb = zzfb0;
        super(zzfb0, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr)Preconditions.checkNotNull(this.zzb.zzQ())).retrieveAndUploadBatches(new zzdu(this, this.zza));
    }
}

