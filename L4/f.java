package l4;

import androidx.mediarouter.media.MediaRouteProvider;
import d5.t;
import df.B;

public final class f extends t {
    public final int i;
    public final Object j;

    public f(Object object0, int v) {
        this.i = v;
        this.j = object0;
        super();
    }

    @Override  // d5.t
    public final void m(MediaRouteProvider mediaRouteProvider0, B b0) {
        if(this.i != 0) {
            ((F)this.j).g(b0);
            return;
        }
        h h0 = (h)this.j;
        N n0 = h0.d(mediaRouteProvider0);
        if(n0 != null) {
            h0.p(n0, b0);
        }
    }
}

