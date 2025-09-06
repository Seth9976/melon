package l4;

import android.media.MediaRouter2.RouteCallback;
import java.util.List;

public final class m extends MediaRouter2.RouteCallback {
    public final int a;
    public final o b;

    public m(o o0, int v) {
        this.a = v;
        this.b = o0;
        super();
    }

    @Override  // android.media.MediaRouter2$RouteCallback
    public void onRoutesAdded(List list0) {
        if(this.a != 0) {
            super.onRoutesAdded(list0);
            return;
        }
        this.b.i();
    }

    @Override  // android.media.MediaRouter2$RouteCallback
    public void onRoutesChanged(List list0) {
        if(this.a != 0) {
            super.onRoutesChanged(list0);
            return;
        }
        this.b.i();
    }

    @Override  // android.media.MediaRouter2$RouteCallback
    public void onRoutesRemoved(List list0) {
        if(this.a != 0) {
            super.onRoutesRemoved(list0);
            return;
        }
        this.b.i();
    }

    @Override  // android.media.MediaRouter2$RouteCallback
    public void onRoutesUpdated(List list0) {
        if(this.a != 1) {
            super.onRoutesUpdated(list0);
            return;
        }
        this.b.i();
    }
}

