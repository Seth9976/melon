package okhttp3.internal.connection;

import e.k;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy.Type;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import je.u;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u0001:\u0002-.B\'\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ!\u0010\u0011\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0014\u001A\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001A\u001A\u00020\u0013H\u0086\u0002¢\u0006\u0004\b\u001A\u0010\u0015J\u0010\u0010\u001C\u001A\u00020\u001BH\u0086\u0002¢\u0006\u0004\b\u001C\u0010\u001DR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001ER\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001FR\u0014\u0010\u0007\u001A\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010 R\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010!R\u001C\u0010#\u001A\b\u0012\u0004\u0012\u00020\u000E0\"8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001A\u00020%8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b&\u0010\'R\u001C\u0010)\u001A\b\u0012\u0004\u0012\u00020(0\"8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b)\u0010$R\u001A\u0010,\u001A\b\u0012\u0004\u0012\u00020+0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010$¨\u0006/"}, d2 = {"Lokhttp3/internal/connection/RouteSelector;", "", "Lokhttp3/Address;", "address", "Lokhttp3/internal/connection/RouteDatabase;", "routeDatabase", "Lokhttp3/Call;", "call", "Lokhttp3/EventListener;", "eventListener", "<init>", "(Lokhttp3/Address;Lokhttp3/internal/connection/RouteDatabase;Lokhttp3/Call;Lokhttp3/EventListener;)V", "Lokhttp3/HttpUrl;", "url", "Ljava/net/Proxy;", "proxy", "Lie/H;", "resetNextProxy", "(Lokhttp3/HttpUrl;Ljava/net/Proxy;)V", "", "hasNextProxy", "()Z", "nextProxy", "()Ljava/net/Proxy;", "resetNextInetSocketAddress", "(Ljava/net/Proxy;)V", "hasNext", "Lokhttp3/internal/connection/RouteSelector$Selection;", "next", "()Lokhttp3/internal/connection/RouteSelector$Selection;", "Lokhttp3/Address;", "Lokhttp3/internal/connection/RouteDatabase;", "Lokhttp3/Call;", "Lokhttp3/EventListener;", "", "proxies", "Ljava/util/List;", "", "nextProxyIndex", "I", "Ljava/net/InetSocketAddress;", "inetSocketAddresses", "", "Lokhttp3/Route;", "postponedRoutes", "Companion", "Selection", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class RouteSelector {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0015\u0010\u0003\u001A\u00020\u0004*\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lokhttp3/internal/connection/RouteSelector$Companion;", "", "()V", "socketHost", "", "Ljava/net/InetSocketAddress;", "getSocketHost", "(Ljava/net/InetSocketAddress;)Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final String getSocketHost(@NotNull InetSocketAddress inetSocketAddress0) {
            q.g(inetSocketAddress0, "<this>");
            InetAddress inetAddress0 = inetSocketAddress0.getAddress();
            if(inetAddress0 == null) {
                String s = inetSocketAddress0.getHostName();
                q.f(s, "hostName");
                return s;
            }
            String s1 = inetAddress0.getHostAddress();
            q.f(s1, "address.hostAddress");
            return s1;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001A\u00020\u000BH\u0086\u0002J\t\u0010\f\u001A\u00020\u0004H\u0086\u0002R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lokhttp3/internal/connection/RouteSelector$Selection;", "", "routes", "", "Lokhttp3/Route;", "(Ljava/util/List;)V", "nextRouteIndex", "", "getRoutes", "()Ljava/util/List;", "hasNext", "", "next", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Selection {
        private int nextRouteIndex;
        @NotNull
        private final List routes;

        public Selection(@NotNull List list0) {
            q.g(list0, "routes");
            super();
            this.routes = list0;
        }

        @NotNull
        public final List getRoutes() {
            return this.routes;
        }

        public final boolean hasNext() {
            return this.nextRouteIndex < this.routes.size();
        }

        @NotNull
        public final Route next() {
            if(!this.hasNext()) {
                throw new NoSuchElementException();
            }
            int v = this.nextRouteIndex;
            this.nextRouteIndex = v + 1;
            return (Route)this.routes.get(v);
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final Address address;
    @NotNull
    private final Call call;
    @NotNull
    private final EventListener eventListener;
    @NotNull
    private List inetSocketAddresses;
    private int nextProxyIndex;
    @NotNull
    private final List postponedRoutes;
    @NotNull
    private List proxies;
    @NotNull
    private final RouteDatabase routeDatabase;

    static {
        RouteSelector.Companion = new Companion(null);
    }

    public RouteSelector(@NotNull Address address0, @NotNull RouteDatabase routeDatabase0, @NotNull Call call0, @NotNull EventListener eventListener0) {
        q.g(address0, "address");
        q.g(routeDatabase0, "routeDatabase");
        q.g(call0, "call");
        q.g(eventListener0, "eventListener");
        super();
        this.address = address0;
        this.routeDatabase = routeDatabase0;
        this.call = call0;
        this.eventListener = eventListener0;
        this.proxies = w.a;
        this.inetSocketAddresses = w.a;
        this.postponedRoutes = new ArrayList();
        this.resetNextProxy(address0.url(), address0.proxy());
    }

    // 去混淆评级： 低(20)
    public final boolean hasNext() {
        return this.hasNextProxy() || !this.postponedRoutes.isEmpty();
    }

    private final boolean hasNextProxy() {
        return this.nextProxyIndex < this.proxies.size();
    }

    @NotNull
    public final Selection next() {
        if(!this.hasNext()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList0 = new ArrayList();
        while(this.hasNextProxy()) {
            Proxy proxy0 = this.nextProxy();
            for(Object object0: this.inetSocketAddresses) {
                Route route0 = new Route(this.address, proxy0, ((InetSocketAddress)object0));
                if(this.routeDatabase.shouldPostpone(route0)) {
                    this.postponedRoutes.add(route0);
                }
                else {
                    arrayList0.add(route0);
                }
            }
            if(!arrayList0.isEmpty()) {
                break;
            }
        }
        if(arrayList0.isEmpty()) {
            u.U(arrayList0, this.postponedRoutes);
            this.postponedRoutes.clear();
        }
        return new Selection(arrayList0);
    }

    private final Proxy nextProxy() {
        if(!this.hasNextProxy()) {
            throw new SocketException("No route to " + this.address.url().host() + "; exhausted proxy configurations: " + this.proxies);
        }
        int v = this.nextProxyIndex;
        this.nextProxyIndex = v + 1;
        Proxy proxy0 = (Proxy)this.proxies.get(v);
        this.resetNextInetSocketAddress(proxy0);
        return proxy0;
    }

    private final void resetNextInetSocketAddress(Proxy proxy0) {
        List list0;
        int v;
        String s;
        ArrayList arrayList0 = new ArrayList();
        this.inetSocketAddresses = arrayList0;
        if(proxy0.type() == Proxy.Type.DIRECT || proxy0.type() == Proxy.Type.SOCKS) {
            s = this.address.url().host();
            v = this.address.url().port();
        }
        else {
            SocketAddress socketAddress0 = proxy0.address();
            if(!(socketAddress0 instanceof InetSocketAddress)) {
                throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + socketAddress0.getClass()).toString());
            }
            q.f(socketAddress0, "proxyAddress");
            s = RouteSelector.Companion.getSocketHost(((InetSocketAddress)socketAddress0));
            v = ((InetSocketAddress)socketAddress0).getPort();
        }
        if(1 > v || v >= 0x10000) {
            throw new SocketException("No route to " + s + ':' + v + "; port is out of range");
        }
        if(proxy0.type() == Proxy.Type.SOCKS) {
            arrayList0.add(InetSocketAddress.createUnresolved(s, v));
            return;
        }
        if(Util.canParseAsIpAddress(s)) {
            list0 = k.z(InetAddress.getByName(s));
        }
        else {
            this.eventListener.dnsStart(this.call, s);
            list0 = this.address.dns().lookup(s);
            if(list0.isEmpty()) {
                throw new UnknownHostException(this.address.dns() + " returned no addresses for " + s);
            }
            this.eventListener.dnsEnd(this.call, s, list0);
        }
        for(Object object0: list0) {
            arrayList0.add(new InetSocketAddress(((InetAddress)object0), v));
        }
    }

    private final void resetNextProxy(HttpUrl httpUrl0, Proxy proxy0) {
        this.eventListener.proxySelectStart(this.call, httpUrl0);
        List list0 = RouteSelector.resetNextProxy$selectProxies(proxy0, httpUrl0, this);
        this.proxies = list0;
        this.nextProxyIndex = 0;
        this.eventListener.proxySelectEnd(this.call, httpUrl0, list0);
    }

    private static final List resetNextProxy$selectProxies(Proxy proxy0, HttpUrl httpUrl0, RouteSelector routeSelector0) {
        if(proxy0 != null) {
            return k.z(proxy0);
        }
        URI uRI0 = httpUrl0.uri();
        if(uRI0.getHost() == null) {
            return Util.immutableListOf(new Proxy[]{Proxy.NO_PROXY});
        }
        List list0 = routeSelector0.address.proxySelector().select(uRI0);
        if(list0 != null && !list0.isEmpty()) {
            q.f(list0, "proxiesOrNull");
            return Util.toImmutableList(list0);
        }
        return Util.immutableListOf(new Proxy[]{Proxy.NO_PROXY});
    }
}

