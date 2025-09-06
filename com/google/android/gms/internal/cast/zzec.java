package com.google.android.gms.internal.cast;

import com.google.android.gms.common.api.Status;

public final class zzec extends zzea {
    final zzed zza;

    public zzec(zzed zzed0) {
        this.zza = zzed0;
        super();
    }

    @Override  // com.google.android.gms.internal.cast.zzea
    public final void zzd(int v) {
        zzef.zzb().d("onError: %d", new Object[]{v});
        zzef.zzf(this.zza.zzc);
        zzee zzee0 = new zzee(Status.RESULT_INTERNAL_ERROR);
        this.zza.setResult(zzee0);
    }

    @Override  // com.google.android.gms.internal.cast.zzea
    public final void zzf() {
        zzef.zzb().d("onDisconnected", new Object[0]);
        zzef.zzf(this.zza.zzc);
        zzee zzee0 = new zzee(Status.RESULT_SUCCESS);
        this.zza.setResult(zzee0);
    }
}

