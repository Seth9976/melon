package dc;

import com.melon.playback.melon.streaming.tracker.NetworkEvents;
import java.io.IOException;
import java.util.Collection;
import je.p;
import kotlin.jvm.internal.q;
import we.k;

public final class b implements k {
    public final int a;
    public final IOException b;

    public b(int v, IOException iOException0) {
        this.a = v;
        this.b = iOException0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.g(((NetworkEvents)object0), "previous");
                Collection collection1 = ((NetworkEvents)object0).getEvents();
                return NetworkEvents.copy$default(((NetworkEvents)object0), p.z0(new a("responseFailed", System.currentTimeMillis()), collection1), null, null, null, this.b, 14, null);
            }
            case 1: {
                q.g(((NetworkEvents)object0), "previous");
                Collection collection2 = ((NetworkEvents)object0).getEvents();
                return NetworkEvents.copy$default(((NetworkEvents)object0), p.z0(new a("requestFailed", System.currentTimeMillis()), collection2), null, null, null, this.b, 14, null);
            }
            case 2: {
                q.g(((NetworkEvents)object0), "previous");
                Collection collection3 = ((NetworkEvents)object0).getEvents();
                NetworkEvents networkEvents0 = NetworkEvents.copy$default(((NetworkEvents)object0), p.z0(new a("callFailed", System.currentTimeMillis()), collection3), null, null, null, this.b, 14, null);
                g.c.q(networkEvents0);
                return networkEvents0;
            }
            default: {
                q.g(((NetworkEvents)object0), "previous");
                Collection collection0 = ((NetworkEvents)object0).getEvents();
                return NetworkEvents.copy$default(((NetworkEvents)object0), p.z0(new a("connectFailed", System.currentTimeMillis()), collection0), null, null, null, this.b, 14, null);
            }
        }
    }
}

