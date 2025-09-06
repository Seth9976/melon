package com.google.android.gms.measurement.internal;

import com.google.android.gms.tasks.OnFailureListener;

final class zzgo implements OnFailureListener {
    private final zzgp zza;
    private final long zzb;

    public zzgo(zzgp zzgp0, long v) {
        this.zza = zzgp0;
        this.zzb = v;
    }

    @Override  // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exception0) {
        this.zza.zzc(this.zzb, exception0);
    }
}

