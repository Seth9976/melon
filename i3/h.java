package i3;

import android.media.metrics.NetworkEvent.Builder;
import android.media.metrics.PlaybackErrorEvent.Builder;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics.Builder;
import android.media.metrics.PlaybackSession;
import android.media.metrics.PlaybackStateEvent.Builder;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent.Builder;
import b3.K;

public abstract class h {
    public static NetworkEvent.Builder b() {
        return new NetworkEvent.Builder();
    }

    public static PlaybackErrorEvent.Builder c() {
        return new PlaybackErrorEvent.Builder();
    }

    public static PlaybackErrorEvent.Builder d(PlaybackErrorEvent.Builder playbackErrorEvent$Builder0, int v) {
        return playbackErrorEvent$Builder0.setErrorCode(v);
    }

    public static PlaybackErrorEvent.Builder e(PlaybackErrorEvent.Builder playbackErrorEvent$Builder0, long v) {
        return playbackErrorEvent$Builder0.setTimeSinceCreatedMillis(v);
    }

    public static PlaybackErrorEvent.Builder f(PlaybackErrorEvent.Builder playbackErrorEvent$Builder0, K k0) {
        return playbackErrorEvent$Builder0.setException(k0);
    }

    public static PlaybackErrorEvent g(PlaybackErrorEvent.Builder playbackErrorEvent$Builder0) {
        return playbackErrorEvent$Builder0.build();
    }

    public static PlaybackMetrics.Builder h() {
        return new PlaybackMetrics.Builder();
    }

    public static PlaybackStateEvent.Builder j() {
        return new PlaybackStateEvent.Builder();
    }

    public static PlaybackStateEvent.Builder k(PlaybackStateEvent.Builder playbackStateEvent$Builder0, int v) {
        return playbackStateEvent$Builder0.setState(v);
    }

    public static PlaybackStateEvent.Builder l(PlaybackStateEvent.Builder playbackStateEvent$Builder0, long v) {
        return playbackStateEvent$Builder0.setTimeSinceCreatedMillis(v);
    }

    public static PlaybackStateEvent m(PlaybackStateEvent.Builder playbackStateEvent$Builder0) {
        return playbackStateEvent$Builder0.build();
    }

    public static TrackChangeEvent.Builder n(int v) {
        return new TrackChangeEvent.Builder(v);
    }

    public static void q(PlaybackSession playbackSession0, PlaybackErrorEvent playbackErrorEvent0) {
        playbackSession0.reportPlaybackErrorEvent(playbackErrorEvent0);
    }

    public static void s(PlaybackSession playbackSession0, PlaybackStateEvent playbackStateEvent0) {
        playbackSession0.reportPlaybackStateEvent(playbackStateEvent0);
    }

    public static PlaybackErrorEvent.Builder v(PlaybackErrorEvent.Builder playbackErrorEvent$Builder0, int v) {
        return playbackErrorEvent$Builder0.setSubErrorCode(v);
    }
}

