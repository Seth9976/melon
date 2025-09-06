package og;

import com.google.firebase.messaging.u;
import java.net.NetworkInterface;
import kg.h;
import kotlin.jvm.internal.q;

public final class g {
    public final d a;
    public h b;
    public final i c;

    public g(u u0, a a0, NetworkInterface networkInterface0) {
        q.g(a0, "address");
        q.g(networkInterface0, "ni");
        i i0 = new i(u0, a0, networkInterface0, 0);
        super();
        this.c = i0;
        this.a = d.h;
        i0.c = new F.d(this, 9);
    }
}

