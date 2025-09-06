package com.google.android.gms.internal.cast;

import com.google.android.gms.common.api.Status;

final class zzeh extends zzem {
    final zzen zza;
    final zzei zzb;

    public zzeh(zzei zzei0, zzen zzen0) {
        this.zza = zzen0;
        this.zzb = zzei0;
        super();
    }

    @Override  // com.google.android.gms.internal.cast.zzen
    public final void zzb(int v) {
        zzei.zze.d("onRemoteDisplayEnded", new Object[0]);
        zzen zzen0 = this.zza;
        if(zzen0 != null) {
            zzen0.zzb(v);
        }
        zzei zzei0 = this.zzb;
        if(zzei0.zzf != null) {
            zzei0.zzf.onRemoteDisplayEnded(new Status(v));
        }
    }
}

