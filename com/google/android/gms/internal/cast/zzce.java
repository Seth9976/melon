package com.google.android.gms.internal.cast;

import android.view.View;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient.ProgressListener;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.cast.framework.media.uicontroller.zza;

public final class zzce extends UIController implements ProgressListener {
    private final View zza;
    private final zza zzb;

    public zzce(View view0, zza zza0) {
        this.zza = view0;
        this.zzb = zza0;
        view0.setEnabled(false);
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        this.zza();
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$ProgressListener
    public final void onProgressUpdated(long v, long v1) {
        this.zza();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSendingRemoteMediaRequest() {
        this.zza.setEnabled(false);
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession0) {
        super.onSessionConnected(castSession0);
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null) {
            remoteMediaClient0.addProgressListener(this, 1000L);
        }
        this.zza();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null) {
            remoteMediaClient0.removeProgressListener(this);
        }
        this.zza.setEnabled(false);
        super.onSessionEnded();
        this.zza();
    }

    public final void zza() {
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        boolean z = false;
        if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession() && !remoteMediaClient0.isPlayingAd()) {
            if(!remoteMediaClient0.isLiveStream()) {
                this.zza.setEnabled(true);
                return;
            }
            View view0 = this.zza;
            if(remoteMediaClient0.zzw() && !this.zzb.zzm()) {
                z = true;
            }
            view0.setEnabled(z);
            return;
        }
        this.zza.setEnabled(false);
    }
}

