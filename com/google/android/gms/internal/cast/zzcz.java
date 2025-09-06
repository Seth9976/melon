package com.google.android.gms.internal.cast;

import android.text.format.DateUtils;
import android.widget.TextView;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient.ProgressListener;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

public final class zzcz extends zzda implements ProgressListener {
    private final TextView zza;
    private final long zzb;
    private final String zzc;
    private boolean zzd;

    public zzcz(TextView textView0, long v, String s) {
        this.zzd = true;
        this.zza = textView0;
        this.zzb = v;
        this.zzc = s;
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$ProgressListener
    public final void onProgressUpdated(long v, long v1) {
        if(this.zzd) {
            this.zza.setText(DateUtils.formatElapsedTime(v1 / 1000L));
        }
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession0) {
        super.onSessionConnected(castSession0);
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null) {
            remoteMediaClient0.addProgressListener(this, this.zzb);
            if(remoteMediaClient0.hasMediaSession()) {
                String s = DateUtils.formatElapsedTime(remoteMediaClient0.getApproximateStreamPosition() / 1000L);
                this.zza.setText(s);
                return;
            }
            this.zza.setText(this.zzc);
        }
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        this.zza.setText(this.zzc);
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null) {
            remoteMediaClient0.removeProgressListener(this);
        }
        super.onSessionEnded();
    }

    @Override  // com.google.android.gms.internal.cast.zzda
    public final void zza(boolean z) {
        this.zzd = z;
    }

    @Override  // com.google.android.gms.internal.cast.zzda
    public final void zzb(long v) {
        String s = DateUtils.formatElapsedTime(v / 1000L);
        this.zza.setText(s);
    }
}

