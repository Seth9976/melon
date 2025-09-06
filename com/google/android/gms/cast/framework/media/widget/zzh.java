package com.google.android.gms.cast.framework.media.widget;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.google.android.gms.cast.framework.media.internal.zza;

final class zzh implements zza {
    final ExpandedControllerActivity zza;

    public zzh(ExpandedControllerActivity expandedControllerActivity0) {
        this.zza = expandedControllerActivity0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.media.internal.zza
    @TargetApi(23)
    public final void zza(Bitmap bitmap0) {
        if(bitmap0 != null) {
            ExpandedControllerActivity expandedControllerActivity0 = this.zza;
            if(expandedControllerActivity0.zzG != null) {
                expandedControllerActivity0.zzG.setVisibility(8);
            }
            if(expandedControllerActivity0.zzF != null) {
                expandedControllerActivity0.zzF.setVisibility(0);
                expandedControllerActivity0.zzF.setImageBitmap(bitmap0);
            }
        }
    }
}

