package com.google.android.gms.cast.framework.media.widget;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManagerListener;

final class zzo implements SessionManagerListener {
    final ExpandedControllerActivity zza;

    public zzo(ExpandedControllerActivity expandedControllerActivity0, zzp zzp0) {
        this.zza = expandedControllerActivity0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionEnded(Session session0, int v) {
        CastSession castSession0 = (CastSession)session0;
        this.zza.finish();
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionEnding(Session session0) {
        CastSession castSession0 = (CastSession)session0;
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionResumeFailed(Session session0, int v) {
        CastSession castSession0 = (CastSession)session0;
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionResumed(Session session0, boolean z) {
        CastSession castSession0 = (CastSession)session0;
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionResuming(Session session0, String s) {
        CastSession castSession0 = (CastSession)session0;
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionStartFailed(Session session0, int v) {
        CastSession castSession0 = (CastSession)session0;
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionStarted(Session session0, String s) {
        CastSession castSession0 = (CastSession)session0;
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionStarting(Session session0) {
        CastSession castSession0 = (CastSession)session0;
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionSuspended(Session session0, int v) {
        CastSession castSession0 = (CastSession)session0;
    }
}

