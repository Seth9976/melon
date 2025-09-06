package com.google.android.gms.ads.identifier;

import com.google.android.gms.tasks.OnFailureListener;

public final class zzc implements OnFailureListener {
    public final zzd zza;
    public final long zzb;

    public zzc(zzd zzd0, long v) {
        this.zza = zzd0;
        this.zzb = v;
    }

    @Override  // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exception0) {
        zzd.zzb(this.zza, this.zzb, exception0);
    }
}

