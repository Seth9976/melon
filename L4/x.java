package l4;

import android.media.MediaRouter.RouteInfo;

public final class X extends z {
    public final MediaRouter.RouteInfo a;

    public X(MediaRouter.RouteInfo mediaRouter$RouteInfo0) {
        this.a = mediaRouter$RouteInfo0;
    }

    @Override  // l4.z
    public final void g(int v) {
        this.a.requestSetVolume(v);
    }

    @Override  // l4.z
    public final void j(int v) {
        this.a.requestUpdateVolume(v);
    }
}

