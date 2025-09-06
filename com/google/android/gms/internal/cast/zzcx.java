package com.google.android.gms.internal.cast;

import android.widget.TextView;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.internal.zzv;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;

public final class zzcx extends UIController {
    private final TextView zza;

    public zzcx(TextView textView0) {
        this.zza = textView0;
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null) {
            MediaInfo mediaInfo0 = remoteMediaClient0.getMediaInfo();
            if(mediaInfo0 != null) {
                MediaMetadata mediaMetadata0 = mediaInfo0.getMetadata();
                if(mediaMetadata0 != null) {
                    String s = zzv.zze(mediaMetadata0);
                    if(s != null) {
                        this.zza.setText(s);
                    }
                }
            }
        }
    }
}

