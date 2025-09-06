package com.google.android.gms.cast.framework.media.internal;

import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;

final class zzp implements zza {
    final zzu zza;

    public zzp(zzu zzu0) {
        this.zza = zzu0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.media.internal.zza
    public final void zza(Bitmap bitmap0) {
        Bitmap bitmap1 = null;
        if(bitmap0 != null) {
            int v = bitmap0.getWidth();
            int v1 = bitmap0.getHeight();
            int v2 = (int)(9.0f * ((float)v) / 16.0f + 0.5f);
            float f = ((float)(v2 - v1)) / 2.0f;
            RectF rectF0 = new RectF(0.0f, f, ((float)v), ((float)v1) + f);
            Bitmap.Config bitmap$Config0 = bitmap0.getConfig();
            if(bitmap$Config0 == null) {
                bitmap$Config0 = Bitmap.Config.ARGB_8888;
            }
            Bitmap bitmap2 = Bitmap.createBitmap(v, v2, bitmap$Config0);
            new Canvas(bitmap2).drawBitmap(bitmap0, null, rectF0, null);
            bitmap1 = bitmap2;
        }
        this.zza.zzj(bitmap1, 0);
    }
}

