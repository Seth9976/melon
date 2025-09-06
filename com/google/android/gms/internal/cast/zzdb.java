package com.google.android.gms.internal.cast;

import android.view.View;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.common.internal.Preconditions;

public final class zzdb extends UIController {
    private final View zza;
    private final int zzb;

    public zzdb(View view0, int v) {
        this.zza = view0;
        this.zzb = v;
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        this.zza();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession0) {
        super.onSessionConnected(castSession0);
        this.zza();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        this.zza.setVisibility(this.zzb);
        super.onSessionEnded();
    }

    private final void zza() {
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession()) {
            if(((MediaStatus)Preconditions.checkNotNull(remoteMediaClient0.getMediaStatus())).getPreloadedItemId() == 0) {
                this.zza.setVisibility(this.zzb);
                return;
            }
            this.zza.setVisibility(0);
            return;
        }
        this.zza.setVisibility(this.zzb);
    }
}

