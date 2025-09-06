package androidx.mediarouter.app;

import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat.Callback;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;

public final class o extends Callback {
    public final MediaRouteControllerDialog a;

    public o(MediaRouteControllerDialog mediaRouteControllerDialog0) {
        this.a = mediaRouteControllerDialog0;
        super();
    }

    @Override  // android.support.v4.media.session.MediaControllerCompat$Callback
    public final void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat0) {
        this.a.r0 = mediaMetadataCompat0 == null ? null : mediaMetadataCompat0.getDescription();
        this.a.o();
        this.a.n(false);
    }

    @Override  // android.support.v4.media.session.MediaControllerCompat$Callback
    public final void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat0) {
        this.a.q0 = playbackStateCompat0;
        this.a.n(false);
    }

    @Override  // android.support.v4.media.session.MediaControllerCompat$Callback
    public final void onSessionDestroyed() {
        MediaRouteControllerDialog mediaRouteControllerDialog0 = this.a;
        MediaControllerCompat mediaControllerCompat0 = mediaRouteControllerDialog0.o0;
        if(mediaControllerCompat0 != null) {
            mediaControllerCompat0.unregisterCallback(mediaRouteControllerDialog0.p0);
            mediaRouteControllerDialog0.o0 = null;
        }
    }
}

