package com.google.android.gms.cast.framework.media.internal;

import android.graphics.Bitmap;

final class zzk implements zza {
    final zzm zza;
    final zzn zzb;

    public zzk(zzn zzn0, zzm zzm0) {
        this.zza = zzm0;
        this.zzb = zzn0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.media.internal.zza
    public final void zza(Bitmap bitmap0) {
        this.zza.zzb = bitmap0;
        zzn.zza(this.zzb, this.zza);
        zzn.zzb(this.zzb);
    }
}

