package com.google.android.gms.cast.framework.media.widget;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;

final class zzj implements Runnable {
    final RemoteMediaClient zza;
    final zzk zzb;

    public zzj(zzk zzk0, RemoteMediaClient remoteMediaClient0) {
        this.zza = remoteMediaClient0;
        this.zzb = zzk0;
        super();
    }

    @Override
    public final void run() {
        this.zzb.zzb.zzm(this.zza);
    }
}

