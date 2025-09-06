package l4;

import android.media.MediaRouter2.ControllerCallback;
import android.media.MediaRouter2.RoutingController;

public final class j extends MediaRouter2.ControllerCallback {
    public final o a;

    public j(o o0) {
        this.a = o0;
        super();
    }

    @Override  // android.media.MediaRouter2$ControllerCallback
    public final void onControllerUpdated(MediaRouter2.RoutingController mediaRouter2$RoutingController0) {
        this.a.j(mediaRouter2$RoutingController0);
    }
}

