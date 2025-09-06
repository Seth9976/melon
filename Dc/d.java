package dc;

import com.melon.playback.melon.streaming.tracker.ConnectionInfo;
import com.melon.playback.melon.streaming.tracker.NetworkEvents;
import java.util.ArrayList;
import java.util.Collection;
import je.p;
import kotlin.jvm.internal.q;
import okhttp3.Connection;
import we.k;

public final class d implements k {
    public final int a;
    public final Connection b;

    public d(Connection connection0, int v) {
        this.a = v;
        this.b = connection0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((NetworkEvents)object0), "previous");
            Collection collection0 = ((NetworkEvents)object0).getEvents();
            ArrayList arrayList0 = p.z0(new a("connectionAcquired", System.currentTimeMillis()), collection0);
            String s = this.b.route().socketAddress().toString();
            q.f(s, "toString(...)");
            return NetworkEvents.copy$default(((NetworkEvents)object0), arrayList0, new ConnectionInfo(s, this.b.protocol().toString()), null, null, null, 28, null);
        }
        q.g(((NetworkEvents)object0), "previous");
        Collection collection1 = ((NetworkEvents)object0).getEvents();
        ArrayList arrayList1 = p.z0(new a("connectionReleased", System.currentTimeMillis()), collection1);
        String s1 = this.b.route().socketAddress().toString();
        q.f(s1, "toString(...)");
        return NetworkEvents.copy$default(((NetworkEvents)object0), arrayList1, new ConnectionInfo(s1, this.b.protocol().toString()), null, null, null, 28, null);
    }
}

