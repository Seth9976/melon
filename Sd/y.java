package sd;

import com.iloen.melon.playback.Playable;
import od.b;
import we.k;

public final class y implements k {
    public final int a;
    public final P b;

    public y(P p0, int v) {
        this.a = v;
        this.b = p0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                return ((b)this.b.k.getValue()).d(this.b.a, ((Playable)object0));
            }
            case 1: {
                return ((b)this.b.k.getValue()).a(((Playable)object0));
            }
            default: {
                return ((b)this.b.k.getValue()).b();
            }
        }
    }
}

