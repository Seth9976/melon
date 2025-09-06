package okhttp3.internal.platform;

import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001D2\u00020\u0001:\u0001\u001DB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001A\u0004\u0018\u00010\u00102\u0006\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001B\u001A\u00020\u001A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001B\u0010\u001C¨\u0006\u001E"}, d2 = {"Lokhttp3/internal/platform/BouncyCastlePlatform;", "Lokhttp3/internal/platform/Platform;", "<init>", "()V", "Ljavax/net/ssl/SSLContext;", "newSSLContext", "()Ljavax/net/ssl/SSLContext;", "Ljavax/net/ssl/X509TrustManager;", "platformTrustManager", "()Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lie/H;", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "Ljava/security/Provider;", "provider", "Ljava/security/Provider;", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class BouncyCastlePlatform extends Platform {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0005¨\u0006\b"}, d2 = {"Lokhttp3/internal/platform/BouncyCastlePlatform$Companion;", "", "()V", "isSupported", "", "()Z", "buildIfSupported", "Lokhttp3/internal/platform/BouncyCastlePlatform;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        // 去混淆评级： 低(40)
        @Nullable
        public final BouncyCastlePlatform buildIfSupported() {
            return null;
        }

        public final boolean isSupported() [...] // 潜在的解密器
    }

    @NotNull
    public static final Companion Companion;
    private static final boolean isSupported;
    @NotNull
    private final Provider provider;

    static {
        Companion bouncyCastlePlatform$Companion0 = new Companion(null);
        BouncyCastlePlatform.Companion = bouncyCastlePlatform$Companion0;
        boolean z = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, bouncyCastlePlatform$Companion0.getClass().getClassLoader());
            z = true;
        }
        catch(ClassNotFoundException unused_ex) {
        }
        BouncyCastlePlatform.isSupported = z;
    }

    private BouncyCastlePlatform() {
        this.provider = (Provider)new BouncyCastleJsseProvider();
    }

    public BouncyCastlePlatform(DefaultConstructorMarker defaultConstructorMarker0) {
    }

    public static final boolean access$isSupported$cp() [...] // 潜在的解密器

    @Override  // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(@NotNull SSLSocket sSLSocket0, @Nullable String s, @NotNull List list0) {
        q.g(sSLSocket0, "sslSocket");
        q.g(list0, "protocols");
        super.configureTlsExtensions(sSLSocket0, s, list0);
    }

    @Override  // okhttp3.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sSLSocket0) {
        q.g(sSLSocket0, "sslSocket");
        return super.getSelectedProtocol(sSLSocket0);
    }

    @Override  // okhttp3.internal.platform.Platform
    @NotNull
    public SSLContext newSSLContext() {
        SSLContext sSLContext0 = SSLContext.getInstance("TLS", this.provider);
        q.f(sSLContext0, "getInstance(\"TLS\", provider)");
        return sSLContext0;
    }

    @Override  // okhttp3.internal.platform.Platform
    @NotNull
    public X509TrustManager platformTrustManager() {
        TrustManagerFactory trustManagerFactory0 = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
        trustManagerFactory0.init(null);
        TrustManager[] arr_trustManager = trustManagerFactory0.getTrustManagers();
        q.d(arr_trustManager);
        if(arr_trustManager.length == 1) {
            TrustManager trustManager0 = arr_trustManager[0];
            if(trustManager0 instanceof X509TrustManager) {
                q.e(trustManager0, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                return (X509TrustManager)trustManager0;
            }
        }
        String s = Arrays.toString(arr_trustManager);
        q.f(s, "toString(this)");
        throw new IllegalStateException(("Unexpected default trust managers: " + s).toString());
    }

    @Override  // okhttp3.internal.platform.Platform
    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory sSLSocketFactory0) {
        q.g(sSLSocketFactory0, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with BouncyCastle");
    }
}

