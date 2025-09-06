package okhttp3.internal.platform;

import Tf.v;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.SuppressSignatureCheck;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\bH\u0017¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000E\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0017¢\u0006\u0004\b\u000E\u0010\u000FJ\u0019\u0010\u0013\u001A\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/platform/Jdk9Platform;", "Lokhttp3/internal/platform/Platform;", "<init>", "()V", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lie/H;", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class Jdk9Platform extends Platform {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0005¨\u0006\b"}, d2 = {"Lokhttp3/internal/platform/Jdk9Platform$Companion;", "", "()V", "isAvailable", "", "()Z", "buildIfSupported", "Lokhttp3/internal/platform/Jdk9Platform;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        // 去混淆评级： 低(40)
        @Nullable
        public final Jdk9Platform buildIfSupported() {
            return new Jdk9Platform();
        }

        public final boolean isAvailable() [...] // 潜在的解密器
    }

    @NotNull
    public static final Companion Companion;
    private static final boolean isAvailable;

    static {
        Jdk9Platform.Companion = new Companion(null);
        Integer integer0 = v.t0("0.9");
        boolean z = false;
        if(integer0 == null) {
            try {
                SSLSocket.class.getMethod("getApplicationProtocol", null);
                z = true;
            }
            catch(NoSuchMethodException unused_ex) {
            }
        }
        else if(((int)integer0) >= 9) {
            z = true;
            Jdk9Platform.isAvailable = z;
            return;
        }
        Jdk9Platform.isAvailable = z;
    }

    @Override  // okhttp3.internal.platform.Platform
    @SuppressSignatureCheck
    public void configureTlsExtensions(@NotNull SSLSocket sSLSocket0, @Nullable String s, @NotNull List list0) {
        q.g(sSLSocket0, "sslSocket");
        q.g(list0, "protocols");
        SSLParameters sSLParameters0 = sSLSocket0.getSSLParameters();
        sSLParameters0.setApplicationProtocols(((String[])Platform.Companion.alpnProtocolNames(list0).toArray(new String[0])));
        sSLSocket0.setSSLParameters(sSLParameters0);
    }

    @Override  // okhttp3.internal.platform.Platform
    @SuppressSignatureCheck
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sSLSocket0) {
        q.g(sSLSocket0, "sslSocket");
        try {
            String s = sSLSocket0.getApplicationProtocol();
            return (s == null ? true : s.equals("")) ? null : s;
        }
        catch(UnsupportedOperationException unused_ex) {
            return null;
        }
    }

    @Override  // okhttp3.internal.platform.Platform
    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory sSLSocketFactory0) {
        q.g(sSLSocketFactory0, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }
}

