package og;

import com.google.firebase.messaging.u;
import d8.d;
import java.net.NetworkInterface;
import kg.h;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import we.k;

public final class f extends r implements k {
    public final int f;
    public final u g;
    public final h h;

    public f(u u0, h h0, int v) {
        this.f = v;
        this.g = u0;
        this.h = h0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.f != 0) {
            NetworkInterface networkInterface0 = (NetworkInterface)object0;
            q.g(networkInterface0, "it");
            q.g(a.e, "address");
            try {
                e e0 = new e(this.g, a.e, networkInterface0);
                e0.a = this.h;
                return e0;
            }
            catch(IllegalArgumentException illegalArgumentException0) {
                d.p(illegalArgumentException0);
                return null;
            }
        }
        NetworkInterface networkInterface1 = (NetworkInterface)object0;
        q.g(networkInterface1, "it");
        q.g(a.d, "address");
        try {
            e e1 = new e(this.g, a.d, networkInterface1);
            e1.a = this.h;
            return e1;
        }
        catch(IllegalArgumentException illegalArgumentException1) {
            d.p(illegalArgumentException1);
            return null;
        }
    }
}

