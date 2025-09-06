package com.google.android.gms.internal.cast;

import android.app.Activity;
import android.view.ViewGroup;

public final class zzap implements Runnable {
    public final zzar zza;
    public final Activity zzb;

    public zzap(zzar zzar0, Activity activity0) {
        this.zza = zzar0;
        this.zzb = activity0;
    }

    @Override
    public final void run() {
        zzas zzas0 = this.zza.zzc;
        if(zzas.zzc(zzas0)) {
            ((ViewGroup)this.zzb.getWindow().getDecorView()).removeView(zzas0);
            if(zzas.zza(zzas0) != null) {
                zzas.zza(zzas0).onOverlayDismissed();
            }
            zzas.zzb(zzas0);
        }
    }
}

