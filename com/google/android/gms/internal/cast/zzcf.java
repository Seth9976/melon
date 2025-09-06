package com.google.android.gms.internal.cast;

import android.graphics.Bitmap;
import com.google.android.gms.cast.framework.media.internal.zza;

final class zzcf implements zza {
    final zzcg zza;

    public zzcf(zzcg zzcg0) {
        this.zza = zzcg0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.media.internal.zza
    public final void zza(Bitmap bitmap0) {
        if(bitmap0 != null) {
            this.zza.zza.setImageBitmap(bitmap0);
        }
    }
}

