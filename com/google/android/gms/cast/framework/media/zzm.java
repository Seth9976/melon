package com.google.android.gms.cast.framework.media;

import java.util.TimerTask;

final class zzm extends TimerTask {
    final MediaQueue zza;

    public zzm(MediaQueue mediaQueue0) {
        this.zza = mediaQueue0;
        super();
    }

    @Override
    public final void run() {
        MediaQueue.zzj(this.zza);
    }
}

