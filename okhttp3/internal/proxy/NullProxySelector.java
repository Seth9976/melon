package okhttp3.internal.proxy;

import e.k;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\u0010\u000B\u001A\u0004\u0018\u00010\n2\b\u0010\r\u001A\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/proxy/NullProxySelector;", "Ljava/net/ProxySelector;", "<init>", "()V", "Ljava/net/URI;", "uri", "", "Ljava/net/Proxy;", "select", "(Ljava/net/URI;)Ljava/util/List;", "Ljava/net/SocketAddress;", "sa", "Ljava/io/IOException;", "ioe", "Lie/H;", "connectFailed", "(Ljava/net/URI;Ljava/net/SocketAddress;Ljava/io/IOException;)V", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class NullProxySelector extends ProxySelector {
    @NotNull
    public static final NullProxySelector INSTANCE;

    static {
        NullProxySelector.INSTANCE = new NullProxySelector();
    }

    @Override
    public void connectFailed(@Nullable URI uRI0, @Nullable SocketAddress socketAddress0, @Nullable IOException iOException0) {
    }

    @Override
    @NotNull
    public List select(@Nullable URI uRI0) {
        if(uRI0 == null) {
            throw new IllegalArgumentException("uri must not be null");
        }
        return k.z(Proxy.NO_PROXY);
    }
}

