package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.view.View.OnLayoutChangeListener;
import android.view.View;

final class zzc implements View.OnLayoutChangeListener {
    final zzh zza;

    public zzc(zzh zzh0, Runnable runnable0) {
        this.zza = zzh0;
        super();
    }

    @Override  // android.view.View$OnLayoutChangeListener
    public final void onLayoutChange(View view0, int v, int v1, int v2, int v3, int v4, int v5, int v6, int v7) {
        this.zza.zzk();
        this.zza.removeOnLayoutChangeListener(this);
    }
}

