package com.google.android.gms.cast.framework;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzab extends zzan {
    private final CastStateListener zza;

    public zzab(CastStateListener castStateListener0) {
        this.zza = castStateListener0;
    }

    @Override  // com.google.android.gms.cast.framework.zzao
    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap(this.zza);
    }

    @Override  // com.google.android.gms.cast.framework.zzao
    public final void zzc(int v) {
        this.zza.onCastStateChanged(v);
    }
}

