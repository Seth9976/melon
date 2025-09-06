package com.google.android.gms.internal.cast;

import android.graphics.Bitmap;
import com.google.android.gms.cast.framework.media.internal.zza;

final class zzch implements zza {
    final zzcj zza;

    public zzch(zzcj zzcj0) {
        this.zza = zzcj0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.media.internal.zza
    public final void zza(Bitmap bitmap0) {
        if(bitmap0 != null) {
            zzcj zzcj0 = this.zza;
            if(zzcj0.zzd != null) {
                zzcj0.zzd.setVisibility(4);
            }
            zzcj.zzb(zzcj0).setVisibility(0);
            zzcj.zzb(zzcj0).setImageBitmap(bitmap0);
            if(zzcj.zzc(zzcj0) != null) {
                zzcj.zzc(zzcj0).zza();
            }
        }
    }
}

