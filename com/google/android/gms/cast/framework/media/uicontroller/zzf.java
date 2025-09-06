package com.google.android.gms.cast.framework.media.uicontroller;

import android.view.View.OnClickListener;
import android.view.View;

final class zzf implements View.OnClickListener {
    final long zza;
    final UIMediaController zzb;

    public zzf(UIMediaController uIMediaController0, long v) {
        this.zza = v;
        this.zzb = uIMediaController0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        this.zzb.onForwardClicked(view0, this.zza);
    }
}

