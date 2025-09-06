package com.google.android.gms.cast.framework;

public class MediaNotificationManager {
    private final SessionManager zza;

    public MediaNotificationManager(SessionManager sessionManager0) {
        this.zza = sessionManager0;
    }

    public void updateNotification() {
        CastSession castSession0 = this.zza.getCurrentCastSession();
        if(castSession0 != null) {
            castSession0.zze().zzl(true);
        }
    }
}

