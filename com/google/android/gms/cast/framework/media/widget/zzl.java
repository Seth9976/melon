package com.google.android.gms.cast.framework.media.widget;

import com.google.android.gms.cast.Cast.Listener;

final class zzl extends Listener {
    final ExpandedControllerActivity zza;

    public zzl(ExpandedControllerActivity expandedControllerActivity0) {
        this.zza = expandedControllerActivity0;
        super();
    }

    @Override  // com.google.android.gms.cast.Cast$Listener
    public final void onDeviceNameChanged() {
        this.zza.zzn();
    }
}

