package og;

import com.google.firebase.messaging.u;
import d5.w;
import d8.d;
import ie.H;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketTimeoutException;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import pc.t;
import pg.c;
import we.o;

public final class i implements Runnable {
    public final InterfaceAddress a;
    public MulticastSocket b;
    public r c;
    public final c d;
    public final u e;
    public final a f;
    public final NetworkInterface g;
    public final int h;

    public i(u u0, a a0, NetworkInterface networkInterface0, int v) {
        q.g(a0, "address");
        InterfaceAddress interfaceAddress0;
        q.g(networkInterface0, "networkInterface");
        super();
        this.e = u0;
        this.f = a0;
        this.g = networkInterface0;
        this.h = v;
        if(a0 == a.d) {
            q.g(networkInterface0, "$this$findInet4Address");
            List list0 = networkInterface0.getInterfaceAddresses();
            q.f(list0, "interfaceAddresses");
            for(Object object0: list0) {
                q.f(((InterfaceAddress)object0), "it");
                InetAddress inetAddress0 = ((InterfaceAddress)object0).getAddress();
                q.f(inetAddress0, "it.address");
                if(!(inetAddress0 instanceof Inet4Address)) {
                    continue;
                }
                goto label_20;
            }
            object0 = null;
        label_20:
            interfaceAddress0 = (InterfaceAddress)object0;
            if(interfaceAddress0 == null) {
                throw new IllegalArgumentException(networkInterface0 + " does not have IPv4 address.");
            }
        }
        else {
            q.g(networkInterface0, "$this$findInet6Address");
            List list1 = networkInterface0.getInterfaceAddresses();
            q.f(list1, "interfaceAddresses");
            for(Object object1: list1) {
                q.f(((InterfaceAddress)object1), "it");
                InetAddress inetAddress1 = ((InterfaceAddress)object1).getAddress();
                q.f(inetAddress1, "it.address");
                if(!(inetAddress1 instanceof Inet6Address) || !((Inet6Address)inetAddress1).isLinkLocalAddress()) {
                    continue;
                }
                goto label_35;
            }
            object1 = null;
        label_35:
            interfaceAddress0 = (InterfaceAddress)object1;
            if(interfaceAddress0 == null) {
                throw new IllegalArgumentException(networkInterface0 + " does not have IPv6 address.");
            }
        }
        this.a = interfaceAddress0;
        this.d = new c(((t)u0.d));
    }

    public final void a(MulticastSocket multicastSocket0) {
        while(true) {
            c c0 = this.d;
            if(c0.a()) {
                break;
            }
            try {
                DatagramPacket datagramPacket0 = new DatagramPacket(new byte[1500], 1500);
                multicastSocket0.receive(datagramPacket0);
                if(c0.a()) {
                    break;
                }
                r r0 = this.c;
                if(r0 == null) {
                    continue;
                }
                InetAddress inetAddress0 = datagramPacket0.getAddress();
                q.f(inetAddress0, "dp.address");
                byte[] arr_b = datagramPacket0.getData();
                q.f(arr_b, "dp.data");
                H h0 = (H)((o)r0).invoke(inetAddress0, arr_b, datagramPacket0.getLength());
            }
            catch(SocketTimeoutException unused_ex) {
            }
        }
    }

    @Override
    public final void run() {
        String s;
        a a0 = this.f;
        StringBuilder stringBuilder0 = new StringBuilder();
        int v = this.h;
        stringBuilder0.append((v == 0 ? "-ssdp-notify-" : "-ssdp-search-"));
        NetworkInterface networkInterface0 = this.g;
        stringBuilder0.append(networkInterface0.getName());
        stringBuilder0.append("-");
        InetAddress inetAddress0 = this.a.getAddress();
        q.f(inetAddress0, "interfaceAddress.address");
        if(inetAddress0 instanceof Inet6Address) {
            s = w.V(((Inet6Address)inetAddress0));
        }
        else {
            s = inetAddress0.getHostAddress();
            q.f(s, "hostAddress");
        }
        stringBuilder0.append(s);
        Thread thread0 = Thread.currentThread();
        q.f(thread0, "it");
        thread0.setName("jeb-dexdec-sb-st-2465" + stringBuilder0.toString());
        c c0 = this.d;
        if(c0.a()) {
            return;
        }
        try {
            MulticastSocket multicastSocket0 = new MulticastSocket(v);
            multicastSocket0.setNetworkInterface(networkInterface0);
            multicastSocket0.setTimeToLive(4);
            this.b = multicastSocket0;
            if(v != 0) {
                multicastSocket0.joinGroup(a0.a);
            }
            c0.b();
            this.a(multicastSocket0);
            goto label_44;
        }
        catch(IOException unused_ex) {
        }
        catch(Throwable throwable0) {
            goto label_37;
        }
        if(v != 0) {
            MulticastSocket multicastSocket1 = this.b;
            if(multicastSocket1 != null) {
                multicastSocket1.leaveGroup(a0.a);
                d.m(this.b);
                this.b = null;
                return;
            label_37:
                if(v != 0) {
                    MulticastSocket multicastSocket2 = this.b;
                    if(multicastSocket2 != null) {
                        multicastSocket2.leaveGroup(a0.a);
                    }
                }
                d.m(this.b);
                this.b = null;
                throw throwable0;
            label_44:
                if(v != 0) {
                    multicastSocket1 = this.b;
                    if(multicastSocket1 != null) {
                        multicastSocket1.leaveGroup(a0.a);
                    }
                }
            }
        }
        d.m(this.b);
        this.b = null;
    }
}

