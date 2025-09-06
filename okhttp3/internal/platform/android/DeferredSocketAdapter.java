package okhttp3.internal.platform.android;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u001CB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\r\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000EJ/\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0007\u001A\u00020\u00062\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0018\u0010\u001A\u001A\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001A\u0010\u001B¨\u0006\u001D"}, d2 = {"Lokhttp3/internal/platform/android/DeferredSocketAdapter;", "Lokhttp3/internal/platform/android/SocketAdapter;", "Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "socketAdapterFactory", "<init>", "(Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;)V", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "getDelegate", "(Ljavax/net/ssl/SSLSocket;)Lokhttp3/internal/platform/android/SocketAdapter;", "", "isSupported", "()Z", "matchesSocket", "(Ljavax/net/ssl/SSLSocket;)Z", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lie/H;", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "delegate", "Lokhttp3/internal/platform/android/SocketAdapter;", "Factory", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class DeferredSocketAdapter implements SocketAdapter {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u0005H&¨\u0006\b"}, d2 = {"Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "", "create", "Lokhttp3/internal/platform/android/SocketAdapter;", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "matchesSocket", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface Factory {
        @NotNull
        SocketAdapter create(@NotNull SSLSocket arg1);

        boolean matchesSocket(@NotNull SSLSocket arg1);
    }

    @Nullable
    private SocketAdapter delegate;
    @NotNull
    private final Factory socketAdapterFactory;

    public DeferredSocketAdapter(@NotNull Factory deferredSocketAdapter$Factory0) {
        q.g(deferredSocketAdapter$Factory0, "socketAdapterFactory");
        super();
        this.socketAdapterFactory = deferredSocketAdapter$Factory0;
    }

    @Override  // okhttp3.internal.platform.android.SocketAdapter
    public void configureTlsExtensions(@NotNull SSLSocket sSLSocket0, @Nullable String s, @NotNull List list0) {
        q.g(sSLSocket0, "sslSocket");
        q.g(list0, "protocols");
        SocketAdapter socketAdapter0 = this.getDelegate(sSLSocket0);
        if(socketAdapter0 != null) {
            socketAdapter0.configureTlsExtensions(sSLSocket0, s, list0);
        }
    }

    private final SocketAdapter getDelegate(SSLSocket sSLSocket0) {
        synchronized(this) {
            if(this.delegate == null && this.socketAdapterFactory.matchesSocket(sSLSocket0)) {
                this.delegate = this.socketAdapterFactory.create(sSLSocket0);
            }
            return this.delegate;
        }
    }

    @Override  // okhttp3.internal.platform.android.SocketAdapter
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sSLSocket0) {
        q.g(sSLSocket0, "sslSocket");
        SocketAdapter socketAdapter0 = this.getDelegate(sSLSocket0);
        return socketAdapter0 == null ? null : socketAdapter0.getSelectedProtocol(sSLSocket0);
    }

    @Override  // okhttp3.internal.platform.android.SocketAdapter
    public boolean isSupported() {
        return true;
    }

    @Override  // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(@NotNull SSLSocket sSLSocket0) {
        q.g(sSLSocket0, "sslSocket");
        return this.socketAdapterFactory.matchesSocket(sSLSocket0);
    }

    @Override  // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocketFactory(@NotNull SSLSocketFactory sSLSocketFactory0) {
        return DefaultImpls.matchesSocketFactory(this, sSLSocketFactory0);
    }

    @Override  // okhttp3.internal.platform.android.SocketAdapter
    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory sSLSocketFactory0) {
        return DefaultImpls.trustManager(this, sSLSocketFactory0);
    }
}

