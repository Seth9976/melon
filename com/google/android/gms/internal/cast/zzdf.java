package com.google.android.gms.internal.cast;

import android.widget.TextView;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R.string;
import com.google.android.gms.cast.framework.media.RemoteMediaClient.ProgressListener;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.cast.framework.media.uicontroller.zza;

public final class zzdf extends UIController implements ProgressListener {
    private final TextView zza;
    private final zza zzb;

    public zzdf(TextView textView0, zza zza0) {
        this.zza = textView0;
        this.zzb = zza0;
        textView0.setText(textView0.getContext().getString(string.cast_invalid_stream_duration_text));
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
        super.onSessionEnded();
        this.zza();
    }

    public final void zza() {
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession()) {
            long v = remoteMediaClient0.getApproximateStreamPosition();
            if(v == MediaInfo.zza) {
                v = remoteMediaClient0.getStreamDuration();
            }
            String s = this.zzb.zzl(v);
            this.zza.setText(s);
            return;
        }
        String s1 = this.zza.getContext().getString(string.cast_invalid_stream_duration_text);
        this.zza.setText(s1);
    }
}

