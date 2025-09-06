package com.google.android.gms.internal.cast;

import android.text.format.DateUtils;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient.ProgressListener;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;

public final class zzcy extends UIController implements ProgressListener {
    private final TextView zza;
    private final String zzb;
    private final View zzc;

    public zzcy(TextView textView0, String s, View view0) {
        this.zza = textView0;
        this.zzb = s;
        this.zzc = view0;
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        this.zza(-1L, true);
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$ProgressListener
    public final void onProgressUpdated(long v, long v1) {
        this.zza(v1, false);
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession0) {
        super.onSessionConnected(castSession0);
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null) {
            remoteMediaClient0.addProgressListener(this, 1000L);
        }
        this.zza(-1L, true);
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        this.zza.setText(this.zzb);
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null) {
            remoteMediaClient0.removeProgressListener(this);
        }
        super.onSessionEnded();
    }

    private final void zza(long v, boolean z) {
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 == null || !remoteMediaClient0.hasMediaSession()) {
            this.zza.setVisibility(0);
            this.zza.setText(this.zzb);
            View view2 = this.zzc;
            if(view2 != null) {
                view2.setVisibility(4);
            }
        }
        else if(!remoteMediaClient0.isLiveStream()) {
            if(z) {
                v = remoteMediaClient0.getStreamDuration();
            }
            this.zza.setVisibility(0);
            String s = DateUtils.formatElapsedTime(v / 1000L);
            this.zza.setText(s);
            View view0 = this.zzc;
            if(view0 != null) {
                view0.setVisibility(4);
            }
        }
        else {
            TextView textView0 = this.zza;
            textView0.setText(this.zzb);
            View view1 = this.zzc;
            if(view1 != null) {
                textView0.setVisibility(4);
                view1.setVisibility(0);
            }
        }
    }
}

