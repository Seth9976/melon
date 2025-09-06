package com.google.android.gms.cast.framework.media.widget;

import android.os.Looper;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.internal.cast.zzet;
import java.util.TimerTask;

final class zzk extends TimerTask {
    final RemoteMediaClient zza;
    final ExpandedControllerActivity zzb;

    public zzk(ExpandedControllerActivity expandedControllerActivity0, RemoteMediaClient remoteMediaClient0) {
        this.zza = remoteMediaClient0;
        this.zzb = expandedControllerActivity0;
        super();
    }

    @Override
    public final void run() {
        new zzet(Looper.getMainLooper()).post(new zzj(this, this.zza));
    }
}

