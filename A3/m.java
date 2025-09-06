package a3;

import E9.w;
import U4.x;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback;
import com.google.android.gms.cast.framework.media.RemoteMediaClient.ProgressListener;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import e3.b;

public final class m extends Callback implements SessionManagerListener, ProgressListener {
    public final n a;

    public m(n n0) {
        this.a = n0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Callback
    public final void onAdBreakStatusUpdated() {
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Callback
    public final void onMetadataUpdated() {
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Callback
    public final void onPreloadStatusUpdated() {
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$ProgressListener
    public final void onProgressUpdated(long v, long v1) {
        this.a.v = v;
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Callback
    public final void onQueueStatusUpdated() {
        this.a.w0();
        this.a.l.b();
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Callback
    public final void onSendingRemoteMediaRequest() {
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionEnded(Session session0, int v) {
        CastSession castSession0 = (CastSession)session0;
        this.a.o0(null);
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionEnding(Session session0) {
        CastSession castSession0 = (CastSession)session0;
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionResumeFailed(Session session0, int v) {
        CastSession castSession0 = (CastSession)session0;
        StringBuilder stringBuilder0 = x.n(v, "Session resume failed. Error code ", ": ");
        stringBuilder0.append(w.B(v));
        b.p("CastPlayer", stringBuilder0.toString());
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionResumed(Session session0, boolean z) {
        RemoteMediaClient remoteMediaClient0 = ((CastSession)session0).getRemoteMediaClient();
        this.a.o0(remoteMediaClient0);
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionResuming(Session session0, String s) {
        CastSession castSession0 = (CastSession)session0;
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionStartFailed(Session session0, int v) {
        CastSession castSession0 = (CastSession)session0;
        StringBuilder stringBuilder0 = x.n(v, "Session start failed. Error code ", ": ");
        stringBuilder0.append(w.B(v));
        b.p("CastPlayer", stringBuilder0.toString());
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionStarted(Session session0, String s) {
        RemoteMediaClient remoteMediaClient0 = ((CastSession)session0).getRemoteMediaClient();
        this.a.o0(remoteMediaClient0);
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionStarting(Session session0) {
        CastSession castSession0 = (CastSession)session0;
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionSuspended(Session session0, int v) {
        CastSession castSession0 = (CastSession)session0;
        this.a.o0(null);
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Callback
    public final void onStatusUpdated() {
        this.a.s0();
    }
}

