package com.google.android.gms.cast.framework.media.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.images.WebImage;

final class zzm {
    public final Uri zza;
    public Bitmap zzb;

    public zzm(WebImage webImage0) {
        this.zza = webImage0 == null ? null : webImage0.getUrl();
    }
}

