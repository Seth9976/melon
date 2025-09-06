package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.SessionState;
import com.google.android.gms.cast.framework.SessionTransferCallback;

public final class zzv extends SessionTransferCallback {
    final zzx zza;

    public zzv(zzx zzx0) {
        this.zza = zzx0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.SessionTransferCallback
    public final void onTransferFailed(int v, int v1) {
        zzca zzca0 = new zzca(11);
        zzca0.zzb(v1);
        zzca0.zza(Boolean.valueOf(zzx.zzd(this.zza).zzf()));
        zzcb zzcb0 = new zzcb(zzca0);
        zzx.zzf(this.zza, zzcb0);
    }

    @Override  // com.google.android.gms.cast.framework.SessionTransferCallback
    public final void onTransferred(int v, SessionState sessionState0) {
    }

    @Override  // com.google.android.gms.cast.framework.SessionTransferCallback
    public final void onTransferring(int v) {
        zzca zzca0 = new zzca(10);
        zzca0.zza(Boolean.valueOf(zzx.zzd(this.zza).zzf()));
        zzcb zzcb0 = new zzcb(zzca0);
        zzx.zzf(this.zza, zzcb0);
        zzx.zzc(this.zza).zzd(new zzab(new zzaa(v)));
    }
}

