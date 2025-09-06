package com.google.android.gms.cast.framework.media.uicontroller;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

public abstract class UIController {
    private RemoteMediaClient zza;

    public RemoteMediaClient getRemoteMediaClient() {
        return this.zza;
    }

    public void onMediaStatusUpdated() {
    }

    public void onSendingRemoteMediaRequest() {
    }

    public void onSessionConnected(CastSession castSession0) {
        this.zza = castSession0 == null ? null : castSession0.getRemoteMediaClient();
    }

    public void onSessionEnded() {
        this.zza = null;
    }
}

