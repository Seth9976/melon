package com.google.android.gms.internal.cast;

import android.widget.ProgressBar;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient.ProgressListener;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;

public final class zzcr extends UIController implements ProgressListener {
    private final ProgressBar zza;
    private final long zzb;

    public zzcr(ProgressBar progressBar0, long v) {
        this.zza = progressBar0;
        this.zzb = v;
        progressBar0.setMax(1);
        progressBar0.setProgress(0);
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
    public final void onSessionConnected(CastSession castSession0) {
        super.onSessionConnected(castSession0);
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null) {
            remoteMediaClient0.addProgressListener(this, this.zzb);
        }
        this.zza();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null) {
            remoteMediaClient0.removeProgressListener(this);
        }
        super.onSessionEnded();
        this.zza();
    }

    public final void zza() {
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession() && !remoteMediaClient0.isLiveStream()) {
            int v = (int)remoteMediaClient0.getStreamDuration();
            this.zza.setMax(v);
            int v1 = (int)remoteMediaClient0.getApproximateStreamPosition();
            this.zza.setProgress(v1);
            return;
        }
        this.zza.setMax(1);
        this.zza.setProgress(0);
    }
}

