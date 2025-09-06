package com.google.android.gms.internal.cast;

import android.widget.TextView;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import java.util.ArrayList;
import java.util.List;

public final class zzcm extends UIController {
    private final TextView zza;
    private final List zzb;

    public zzcm(TextView textView0, List list0) {
        ArrayList arrayList0 = new ArrayList();
        this.zzb = arrayList0;
        this.zza = textView0;
        arrayList0.addAll(list0);
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession()) {
            MediaQueueItem mediaQueueItem0 = remoteMediaClient0.getPreloadedItem();
            if(mediaQueueItem0 != null) {
                MediaInfo mediaInfo0 = mediaQueueItem0.getMedia();
                if(mediaInfo0 != null) {
                    MediaMetadata mediaMetadata0 = mediaInfo0.getMetadata();
                    if(mediaMetadata0 != null) {
                        for(Object object0: this.zzb) {
                            String s = (String)object0;
                            if(mediaMetadata0.containsKey(s)) {
                                String s1 = mediaMetadata0.getString(s);
                                this.zza.setText(s1);
                                return;
                            }
                            if(false) {
                                break;
                            }
                        }
                        this.zza.setText("");
                    }
                }
            }
        }
    }
}

