package og;

import d5.w;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import kotlin.jvm.internal.q;

public enum a {
    IP_V4("239.255.255.250", "239.255.255.246"),
    IP_V6("FF02::C", "FF02::130");

    public final InetAddress a;
    public final InetSocketAddress b;
    public final String c;

    public a(String s1, String s2) {
        InetAddress inetAddress0 = InetAddress.getByName(s1);
        q.f(inetAddress0, "InetAddress.getByName(ssdpAddress)");
        this.a = inetAddress0;
        InetSocketAddress inetSocketAddress0 = new InetSocketAddress(inetAddress0, 1900);
        this.b = inetSocketAddress0;
        InetAddress inetAddress1 = inetSocketAddress0.getAddress();
        q.f(inetAddress1, "address");
        this.c = w.S(inetAddress1, inetSocketAddress0.getPort());
        q.f(InetAddress.getByName(s2), "InetAddress.getByName(eventAddress)");
    }
}

