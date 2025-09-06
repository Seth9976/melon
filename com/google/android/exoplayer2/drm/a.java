package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.EventDispatcher.Event;

public final class a implements ReleaseCallback, Event {
    public final int a;
    public final Object b;

    public a(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // com.google.android.exoplayer2.drm.DefaultDrmSession$ReleaseCallback
    public void onSessionReleased(DefaultDrmSession defaultDrmSession0) {
        ((DefaultDrmSessionManager)this.b).onSessionReleased(defaultDrmSession0);
    }

    @Override  // com.google.android.exoplayer2.util.EventDispatcher$Event
    public void sendTo(Object object0) {
        if(this.a != 0) {
            DefaultDrmSessionManager.lambda$acquireSession$0(((MissingSchemeDataException)this.b), ((DefaultDrmSessionEventListener)object0));
            return;
        }
        DefaultDrmSession.lambda$onError$0(((Exception)this.b), ((DefaultDrmSessionEventListener)object0));
    }
}

