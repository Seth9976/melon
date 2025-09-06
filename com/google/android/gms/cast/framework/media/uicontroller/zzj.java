package com.google.android.gms.cast.framework.media.uicontroller;

import android.view.View.OnClickListener;
import android.view.View;

final class zzj implements View.OnClickListener {
    final UIMediaController zza;

    public zzj(UIMediaController uIMediaController0) {
        this.zza = uIMediaController0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        this.zza.onLaunchExpandedControllerClicked(view0);
    }
}

