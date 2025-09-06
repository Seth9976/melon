package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.media.uicontroller.UIController;

public abstract class zzda extends UIController {
    private boolean zza;

    public zzda() {
        this.zza = true;
    }

    public void zza(boolean z) {
        this.zza = z;
    }

    public abstract void zzb(long arg1);

    public final boolean zzc() {
        return this.zza;
    }
}

