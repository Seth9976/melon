package l4;

import android.media.MediaRoute2Info.Builder;
import android.media.MediaRoute2Info;
import android.media.RoutingSessionInfo.Builder;
import android.media.RoutingSessionInfo;
import android.os.Bundle;
import java.util.List;

public abstract class p {
    public static MediaRoute2Info.Builder C(MediaRoute2Info.Builder mediaRoute2Info$Builder0, int v) {
        return mediaRoute2Info$Builder0.setVolumeMax(v);
    }

    public static MediaRoute2Info.Builder a(MediaRoute2Info.Builder mediaRoute2Info$Builder0, int v) {
        return mediaRoute2Info$Builder0.setConnectionState(v);
    }

    public static MediaRoute2Info.Builder b(MediaRoute2Info.Builder mediaRoute2Info$Builder0, String s) {
        return mediaRoute2Info$Builder0.setDescription(s);
    }

    public static MediaRoute2Info c(MediaRoute2Info.Builder mediaRoute2Info$Builder0) {
        return mediaRoute2Info$Builder0.build();
    }

    public static RoutingSessionInfo.Builder f(RoutingSessionInfo routingSessionInfo0) {
        return new RoutingSessionInfo.Builder(routingSessionInfo0);
    }

    public static CharSequence h(MediaRoute2Info mediaRoute2Info0) {
        return mediaRoute2Info0.getName();
    }

    public static List j(MediaRoute2Info mediaRoute2Info0) {
        return mediaRoute2Info0.getFeatures();
    }

    public static void l(MediaRoute2Info.Builder mediaRoute2Info$Builder0) {
        mediaRoute2Info$Builder0.addFeature("android.media.route.feature.REMOTE_GROUP_PLAYBACK");
    }

    public static void m(MediaRoute2Info.Builder mediaRoute2Info$Builder0, Bundle bundle0) {
        mediaRoute2Info$Builder0.setExtras(bundle0);
    }

    public static void r(t t0, long v) {
        t0.notifyRequestFailed(v, 1);
    }

    public static void u(t t0, String s) {
        t0.notifySessionReleased(s);
    }

    public static MediaRoute2Info.Builder v(MediaRoute2Info.Builder mediaRoute2Info$Builder0, int v) {
        return mediaRoute2Info$Builder0.setVolumeHandling(v);
    }

    public static void w(MediaRoute2Info.Builder mediaRoute2Info$Builder0) {
        mediaRoute2Info$Builder0.addFeature("android.media.route.feature.EMPTY");
    }

    public static void x(RoutingSessionInfo.Builder routingSessionInfo$Builder0) {
        routingSessionInfo$Builder0.clearSelectableRoutes();
    }

    public static void y(RoutingSessionInfo.Builder routingSessionInfo$Builder0, String s) {
        routingSessionInfo$Builder0.addDeselectableRoute(s);
    }

    public static MediaRoute2Info.Builder z(MediaRoute2Info.Builder mediaRoute2Info$Builder0, int v) {
        return mediaRoute2Info$Builder0.setVolume(v);
    }
}

