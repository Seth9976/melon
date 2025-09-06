package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.AdBreakClipInfo;
import com.google.android.gms.cast.AdBreakInfo;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient.ProgressListener;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.cast.framework.media.uicontroller.zza;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import com.google.android.gms.cast.framework.media.widget.zzb;
import com.google.android.gms.cast.framework.media.widget.zzc;
import com.google.android.gms.cast.framework.media.widget.zze;
import java.util.ArrayList;
import java.util.List;

public final class zzcc extends UIController implements ProgressListener {
    private final CastSeekBar zza;
    private final long zzb;
    private final zza zzc;

    public zzcc(CastSeekBar castSeekBar0, long v, zza zza0) {
        this.zza = castSeekBar0;
        this.zzb = v;
        this.zzc = zza0;
        castSeekBar0.setEnabled(false);
        castSeekBar0.zzd(null);
        castSeekBar0.zzb = null;
        castSeekBar0.postInvalidate();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final RemoteMediaClient getRemoteMediaClient() {
        return super.getRemoteMediaClient();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        this.zzc();
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$ProgressListener
    public final void onProgressUpdated(long v, long v1) {
        this.zzb();
        this.zza();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession0) {
        super.onSessionConnected(castSession0);
        RemoteMediaClient remoteMediaClient0 = super.getRemoteMediaClient();
        if(remoteMediaClient0 != null) {
            remoteMediaClient0.addProgressListener(this, this.zzb);
        }
        this.zzc();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        RemoteMediaClient remoteMediaClient0 = super.getRemoteMediaClient();
        if(remoteMediaClient0 != null) {
            remoteMediaClient0.removeProgressListener(this);
        }
        super.onSessionEnded();
        this.zzc();
    }

    public final void zza() {
        RemoteMediaClient remoteMediaClient0 = super.getRemoteMediaClient();
        AdBreakClipInfo adBreakClipInfo0 = null;
        if(remoteMediaClient0 != null && remoteMediaClient0.isPlayingAd()) {
            int v = (int)remoteMediaClient0.getApproximateAdBreakClipPositionMs();
            MediaStatus mediaStatus0 = remoteMediaClient0.getMediaStatus();
            if(mediaStatus0 != null) {
                adBreakClipInfo0 = mediaStatus0.getCurrentAdBreakClip();
            }
            int v1 = adBreakClipInfo0 == null ? v : ((int)adBreakClipInfo0.getDurationInMs());
            if(v < 0) {
                v = 0;
            }
            if(v1 < 0) {
                v1 = 1;
            }
            CastSeekBar castSeekBar0 = this.zza;
            if(v > v1) {
                v1 = v;
            }
            castSeekBar0.zzb = new zzc(v, v1);
            castSeekBar0.postInvalidate();
            return;
        }
        this.zza.zzb = null;
        this.zza.postInvalidate();
    }

    public final void zzb() {
        RemoteMediaClient remoteMediaClient0 = super.getRemoteMediaClient();
        boolean z = true;
        if(remoteMediaClient0 == null || !remoteMediaClient0.hasMediaSession() || remoteMediaClient0.isPlayingAd()) {
            this.zza.setEnabled(false);
        }
        else {
            this.zza.setEnabled(true);
        }
        zze zze0 = new zze();
        zze0.zza = this.zzc.zza();
        zze0.zzb = this.zzc.zzb();
        zze0.zzc = (int)(-this.zzc.zze());
        RemoteMediaClient remoteMediaClient1 = super.getRemoteMediaClient();
        zze0.zzd = remoteMediaClient1 == null || !remoteMediaClient1.hasMediaSession() || !remoteMediaClient1.zzw() ? this.zzc.zza() : this.zzc.zzd();
        RemoteMediaClient remoteMediaClient2 = super.getRemoteMediaClient();
        zze0.zze = remoteMediaClient2 == null || !remoteMediaClient2.hasMediaSession() || !remoteMediaClient2.zzw() ? this.zzc.zza() : this.zzc.zzc();
        RemoteMediaClient remoteMediaClient3 = super.getRemoteMediaClient();
        if(remoteMediaClient3 == null || !remoteMediaClient3.hasMediaSession() || !remoteMediaClient3.zzw()) {
            z = false;
        }
        zze0.zzf = z;
        this.zza.zze(zze0);
    }

    public final void zzc() {
        this.zzb();
        RemoteMediaClient remoteMediaClient0 = super.getRemoteMediaClient();
        ArrayList arrayList0 = null;
        MediaInfo mediaInfo0 = remoteMediaClient0 == null ? null : remoteMediaClient0.getMediaInfo();
        if(remoteMediaClient0 == null || !remoteMediaClient0.hasMediaSession() || remoteMediaClient0.isLoadingNextItem() || mediaInfo0 == null) {
            this.zza.zzd(null);
        }
        else {
            CastSeekBar castSeekBar0 = this.zza;
            List list0 = mediaInfo0.getAdBreaks();
            if(list0 != null) {
                arrayList0 = new ArrayList();
                for(Object object0: list0) {
                    AdBreakInfo adBreakInfo0 = (AdBreakInfo)object0;
                    if(adBreakInfo0 != null) {
                        long v = adBreakInfo0.getPlaybackPositionInMs();
                        int v1 = v == -1000L ? this.zzc.zzb() : Math.min(((int)(v - this.zzc.zze())), this.zzc.zzb());
                        if(v1 >= 0) {
                            arrayList0.add(new zzb(v1, ((int)adBreakInfo0.getDurationInMs()), adBreakInfo0.isExpanded()));
                        }
                    }
                }
            }
            castSeekBar0.zzd(arrayList0);
        }
        this.zza();
    }
}

