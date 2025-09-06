package com.google.android.gms.internal.cast;

import android.content.Context;
import android.view.View;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R.string;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import java.util.List;

public final class zzcd extends UIController {
    private final View zza;
    private final String zzb;
    private final String zzc;

    public zzcd(View view0, Context context0) {
        this.zza = view0;
        this.zzb = context0.getString(string.cast_closed_captions);
        this.zzc = context0.getString(string.cast_closed_captions_unavailable);
        view0.setEnabled(false);
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        this.zza();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSendingRemoteMediaRequest() {
        this.zza.setEnabled(false);
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession0) {
        super.onSessionConnected(castSession0);
        this.zza.setEnabled(true);
        this.zza();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        this.zza.setEnabled(false);
        super.onSessionEnded();
    }

    private final void zza() {
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession()) {
            MediaInfo mediaInfo0 = remoteMediaClient0.getMediaInfo();
            if(mediaInfo0 != null) {
                List list0 = mediaInfo0.getMediaTracks();
                if(list0 != null && !list0.isEmpty()) {
                    int v = 0;
                    for(Object object0: list0) {
                        MediaTrack mediaTrack0 = (MediaTrack)object0;
                        if(mediaTrack0.getType() == 2) {
                            ++v;
                            if(v <= 1) {
                                continue;
                            }
                        }
                        else if(mediaTrack0.getType() != 1) {
                        }
                        else {
                            if(remoteMediaClient0.isPlayingAd()) {
                                break;
                            }
                            this.zza.setEnabled(true);
                            this.zza.setContentDescription(this.zzb);
                            return;
                        }
                        if(false) {
                            break;
                        }
                    }
                }
            }
        }
        this.zza.setEnabled(false);
        this.zza.setContentDescription(this.zzc);
    }
}

