package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.Cast.Listener;

final class zzco extends Listener {
    final zzcp zza;

    public zzco(zzcp zzcp0) {
        this.zza = zzcp0;
        super();
    }

    @Override  // com.google.android.gms.cast.Cast$Listener
    public final void onVolumeChanged() {
        this.zza.zza();
    }
}

