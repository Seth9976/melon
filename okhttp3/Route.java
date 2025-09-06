package okhttp3;

import ie.d;
import java.net.InetSocketAddress;
import java.net.Proxy.Type;
import java.net.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u0002\u001A\u00020\u0003H\u0007¢\u0006\u0002\b\fJ\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001A\u00020\u0011H\u0016J\r\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0002\b\u0012J\u0006\u0010\u0013\u001A\u00020\u000EJ\r\u0010\u0006\u001A\u00020\u0007H\u0007¢\u0006\u0002\b\u0014J\b\u0010\u0015\u001A\u00020\u0016H\u0016R\u0013\u0010\u0002\u001A\u00020\u00038\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\tR\u0013\u0010\u0004\u001A\u00020\u00058\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\nR\u0013\u0010\u0006\u001A\u00020\u00078\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u000B¨\u0006\u0017"}, d2 = {"Lokhttp3/Route;", "", "address", "Lokhttp3/Address;", "proxy", "Ljava/net/Proxy;", "socketAddress", "Ljava/net/InetSocketAddress;", "(Lokhttp3/Address;Ljava/net/Proxy;Ljava/net/InetSocketAddress;)V", "()Lokhttp3/Address;", "()Ljava/net/Proxy;", "()Ljava/net/InetSocketAddress;", "-deprecated_address", "equals", "", "other", "hashCode", "", "-deprecated_proxy", "requiresTunnel", "-deprecated_socketAddress", "toString", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Route {
    @NotNull
    private final Address address;
    @NotNull
    private final Proxy proxy;
    @NotNull
    private final InetSocketAddress socketAddress;

    @d
    @NotNull
    public final Address -deprecated_address() {
        return this.address;
    }

    @d
    @NotNull
    public final Proxy -deprecated_proxy() {
        return this.proxy;
    }

    @d
    @NotNull
    public final InetSocketAddress -deprecated_socketAddress() {
        return this.socketAddress;
    }

    public Route(@NotNull Address address0, @NotNull Proxy proxy0, @NotNull InetSocketAddress inetSocketAddress0) {
        q.g(address0, "address");
        q.g(proxy0, "proxy");
        q.g(inetSocketAddress0, "socketAddress");
        super();
        this.address = address0;
        this.proxy = proxy0;
        this.socketAddress = inetSocketAddress0;
    }

    @NotNull
    public final Address address() {
        return this.address;
    }

    // 去混淆评级： 低(40)
    @Override
    public boolean equals(@Nullable Object object0) {
        return object0 instanceof Route && q.b(((Route)object0).address, this.address) && q.b(((Route)object0).proxy, this.proxy) && q.b(((Route)object0).socketAddress, this.socketAddress);
    }

    @Override
    public int hashCode() {
        return this.socketAddress.hashCode() + (this.proxy.hashCode() + (this.address.hashCode() + 0x20F) * 0x1F) * 0x1F;
    }

    @NotNull
    public final Proxy proxy() {
        return this.proxy;
    }

    public final boolean requiresTunnel() {
        return this.address.sslSocketFactory() != null && this.proxy.type() == Proxy.Type.HTTP;
    }

    @NotNull
    public final InetSocketAddress socketAddress() {
        return this.socketAddress;
    }

    @Override
    @NotNull
    public String toString() {
        return "Route{" + this.socketAddress + '}';
    }
}

