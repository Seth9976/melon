package com.google.android.gms.internal.cast;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.SeekBar;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient.ProgressListener;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.cast.framework.media.uicontroller.zza;

public final class zzcu extends UIController implements ProgressListener {
    private final SeekBar zza;
    private final long zzb;
    private final zza zzc;
    private boolean zzd;
    private Boolean zze;
    private Drawable zzf;

    public zzcu(SeekBar seekBar0, long v, zza zza0) {
        this.zzd = true;
        this.zzf = null;
        this.zza = seekBar0;
        this.zzb = v;
        this.zzc = zza0;
        seekBar0.setEnabled(false);
        this.zzf = seekBar0.getThumb();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        this.zzb();
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$ProgressListener
    public final void onProgressUpdated(long v, long v1) {
        this.zzb();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession0) {
        super.onSessionConnected(castSession0);
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null) {
            remoteMediaClient0.addProgressListener(this, this.zzb);
        }
        this.zzb();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null) {
            remoteMediaClient0.removeProgressListener(this);
        }
        super.onSessionEnded();
        this.zzb();
    }

    public final void zza(boolean z) {
        this.zzd = z;
    }

    public final void zzb() {
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession()) {
            if(this.zzd) {
                SeekBar seekBar0 = this.zza;
                zza zza0 = this.zzc;
                seekBar0.setMax(zza0.zzb());
                if(!remoteMediaClient0.isLiveStream() || !zza0.zzm()) {
                    seekBar0.setProgress(zza0.zza());
                }
                else {
                    seekBar0.setProgress(zza0.zzc());
                }
                if(remoteMediaClient0.isPlayingAd()) {
                    seekBar0.setEnabled(false);
                }
                else {
                    seekBar0.setEnabled(true);
                }
                RemoteMediaClient remoteMediaClient1 = this.getRemoteMediaClient();
                if(remoteMediaClient1 != null && remoteMediaClient1.hasMediaSession() && (this.zze == null || this.zze.booleanValue() != remoteMediaClient1.zzw())) {
                    Boolean boolean0 = Boolean.valueOf(remoteMediaClient1.zzw());
                    this.zze = boolean0;
                    if(boolean0.booleanValue()) {
                        Drawable drawable0 = this.zzf;
                        if(drawable0 != null) {
                            seekBar0.setThumb(drawable0);
                        }
                        seekBar0.setClickable(true);
                        seekBar0.setOnTouchListener(null);
                        return;
                    }
                    seekBar0.setThumb(new ColorDrawable(0));
                    seekBar0.setClickable(false);
                    seekBar0.setOnTouchListener(new zzct(this));
                }
            }
            return;
        }
        int v = this.zzc.zzb();
        this.zza.setMax(v);
        int v1 = this.zzc.zza();
        this.zza.setProgress(v1);
        this.zza.setEnabled(false);
    }
}

