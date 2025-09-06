package com.airbnb.lottie.utils;

import android.app.PictureInPictureParams.Builder;
import android.graphics.RenderEffect;
import android.graphics.Shader.TileMode;
import android.media.metrics.NetworkEvent.Builder;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackMetrics.Builder;
import android.media.metrics.PlaybackSession;

public abstract class a {
    public static RenderEffect b(float f, float f1, RenderEffect renderEffect0) {
        return RenderEffect.createBlurEffect(f, f1, renderEffect0, Shader.TileMode.CLAMP);
    }

    public static NetworkEvent.Builder c(NetworkEvent.Builder networkEvent$Builder0, int v) {
        return networkEvent$Builder0.setNetworkType(v);
    }

    public static NetworkEvent.Builder d(NetworkEvent.Builder networkEvent$Builder0, long v) {
        return networkEvent$Builder0.setTimeSinceCreatedMillis(v);
    }

    public static NetworkEvent e(NetworkEvent.Builder networkEvent$Builder0) {
        return networkEvent$Builder0.build();
    }

    public static PlaybackMetrics.Builder f(PlaybackMetrics.Builder playbackMetrics$Builder0) {
        return playbackMetrics$Builder0.setPlayerName("AndroidXMedia3");
    }

    public static PlaybackMetrics.Builder g(Object object0) [...] // Inlined contents

    public static void k(PictureInPictureParams.Builder pictureInPictureParams$Builder0) {
        pictureInPictureParams$Builder0.setAutoEnterEnabled(true);
    }

    public static void l(PlaybackMetrics.Builder playbackMetrics$Builder0, int v) {
        playbackMetrics$Builder0.setDrmType(v);
    }

    public static void m(PlaybackSession playbackSession0, NetworkEvent networkEvent0) {
        playbackSession0.reportNetworkEvent(networkEvent0);
    }

    public static PlaybackMetrics.Builder v(PlaybackMetrics.Builder playbackMetrics$Builder0) {
        return playbackMetrics$Builder0.setPlayerVersion("1.5.1");
    }

    public static void w(PictureInPictureParams.Builder pictureInPictureParams$Builder0) {
        pictureInPictureParams$Builder0.setAutoEnterEnabled(false);
    }
}

