package og;

import com.google.firebase.messaging.u;
import e3.o;
import java.io.ByteArrayInputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import kg.h;
import kotlin.jvm.internal.q;
import mg.f;

public final class e {
    public h a;
    public final d b;
    public final i c;

    public e(u u0, a a0, NetworkInterface networkInterface0) {
        q.g(a0, "address");
        q.g(networkInterface0, "ni");
        i i0 = new i(u0, a0, networkInterface0, 1900);
        super();
        this.c = i0;
        this.b = d.g;
        i0.c = new F.d(this, 8);
    }

    public final f a(int v, byte[] arr_b) {
        q.g(arr_b, "data");
        InetAddress inetAddress0 = this.c.a.getAddress();
        q.f(inetAddress0, "interfaceAddress.address");
        jg.e e0 = new jg.e("GET", "", "HTTP/1.1");
        mg.d d0 = new mg.d(e0, null);
        o o0 = new o(e0, d0);
        d0.e(new ByteArrayInputStream(arr_b, 0, v));
        return new f(o0, new mg.e(o0, inetAddress0));
    }
}

