package okhttp3.internal.platform;

import java.security.Provider;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.conscrypt.Conscrypt.Version;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001F2\u00020\u0001:\u0002\u001F B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001A\u0004\u0018\u00010\u00102\u0006\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001A\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001D\u001A\u00020\u001C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001D\u0010\u001E¨\u0006!"}, d2 = {"Lokhttp3/internal/platform/ConscryptPlatform;", "Lokhttp3/internal/platform/Platform;", "<init>", "()V", "Ljavax/net/ssl/SSLContext;", "newSSLContext", "()Ljavax/net/ssl/SSLContext;", "Ljavax/net/ssl/X509TrustManager;", "platformTrustManager", "()Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lie/H;", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "newSslSocketFactory", "(Ljavax/net/ssl/X509TrustManager;)Ljavax/net/ssl/SSLSocketFactory;", "Ljava/security/Provider;", "provider", "Ljava/security/Provider;", "Companion", "DisabledHostnameVerifier", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ConscryptPlatform extends Platform {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0006\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\bJ\b\u0010\u000B\u001A\u0004\u0018\u00010\fR\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0005¨\u0006\r"}, d2 = {"Lokhttp3/internal/platform/ConscryptPlatform$Companion;", "", "()V", "isSupported", "", "()Z", "atLeastVersion", "major", "", "minor", "patch", "buildIfSupported", "Lokhttp3/internal/platform/ConscryptPlatform;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final boolean atLeastVersion(int v, int v1, int v2) {
            Conscrypt.Version conscrypt$Version0 = Conscrypt.version();
            if(conscrypt$Version0.major() != v) {
                return conscrypt$Version0.major() > v;
            }
            return conscrypt$Version0.minor() == v1 ? conscrypt$Version0.patch() >= v2 : conscrypt$Version0.minor() > v1;
        }

        public static boolean atLeastVersion$default(Companion conscryptPlatform$Companion0, int v, int v1, int v2, int v3, Object object0) {
            if((v3 & 2) != 0) {
                v1 = 0;
            }
            if((v3 & 4) != 0) {
                v2 = 0;
            }
            return conscryptPlatform$Companion0.atLeastVersion(v, v1, v2);
        }

        // 去混淆评级： 低(30)
        @Nullable
        public final ConscryptPlatform buildIfSupported() {
            return null;
        }

        public final boolean isSupported() [...] // 潜在的解密器
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u0003\u001A\u00020\u00042\u0010\u0010\u0005\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\b\u001A\u0004\u0018\u00010\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BH\u0016¢\u0006\u0002\u0010\fJ\u001A\u0010\u0003\u001A\u00020\u00042\b\u0010\b\u001A\u0004\u0018\u00010\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000B¨\u0006\r"}, d2 = {"Lokhttp3/internal/platform/ConscryptPlatform$DisabledHostnameVerifier;", "Lorg/conscrypt/ConscryptHostnameVerifier;", "()V", "verify", "", "certs", "", "Ljava/security/cert/X509Certificate;", "hostname", "", "session", "Ljavax/net/ssl/SSLSession;", "([Ljava/security/cert/X509Certificate;Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class DisabledHostnameVerifier implements ConscryptHostnameVerifier {
        @NotNull
        public static final DisabledHostnameVerifier INSTANCE;

        static {
            DisabledHostnameVerifier.INSTANCE = new DisabledHostnameVerifier();
        }

        public final boolean verify(@Nullable String s, @Nullable SSLSession sSLSession0) {
            return true;
        }

        public boolean verify(@Nullable X509Certificate[] arr_x509Certificate, @Nullable String s, @Nullable SSLSession sSLSession0) {
            return true;
        }
    }

    @NotNull
    public static final Companion Companion;
    private static final boolean isSupported;
    @NotNull
    private final Provider provider;

    static {
        Companion conscryptPlatform$Companion0 = new Companion(null);
        ConscryptPlatform.Companion = conscryptPlatform$Companion0;
        boolean z = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, conscryptPlatform$Companion0.getClass().getClassLoader());
            if(Conscrypt.isAvailable() && conscryptPlatform$Companion0.atLeastVersion(2, 1, 0)) {
                z = true;
            }
        }
        catch(NoClassDefFoundError | ClassNotFoundException unused_ex) {
        }
        ConscryptPlatform.isSupported = z;
    }

    private ConscryptPlatform() {
        Provider provider0 = Conscrypt.newProvider();
        q.f(provider0, "newProvider()");
        this.provider = provider0;
    }

    public ConscryptPlatform(DefaultConstructorMarker defaultConstructorMarker0) {
    }

    public static final boolean access$isSupported$cp() [...] // 潜在的解密器

    @Override  // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(@NotNull SSLSocket sSLSocket0, @Nullable String s, @NotNull List list0) {
        q.g(sSLSocket0, "sslSocket");
        q.g(list0, "protocols");
        if(Conscrypt.isConscrypt(sSLSocket0)) {
            Conscrypt.setUseSessionTickets(sSLSocket0, true);
            Conscrypt.setApplicationProtocols(sSLSocket0, ((String[])Platform.Companion.alpnProtocolNames(list0).toArray(new String[0])));
            return;
        }
        super.configureTlsExtensions(sSLSocket0, s, list0);
    }

    @Override  // okhttp3.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sSLSocket0) {
        q.g(sSLSocket0, "sslSocket");
        return Conscrypt.isConscrypt(sSLSocket0) ? Conscrypt.getApplicationProtocol(sSLSocket0) : super.getSelectedProtocol(sSLSocket0);
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
    public SSLSocketFactory newSslSocketFactory(@NotNull X509TrustManager x509TrustManager0) {
        q.g(x509TrustManager0, "trustManager");
        SSLContext sSLContext0 = this.newSSLContext();
        sSLContext0.init(null, new TrustManager[]{x509TrustManager0}, null);
        SSLSocketFactory sSLSocketFactory0 = sSLContext0.getSocketFactory();
        q.f(sSLSocketFactory0, "newSSLContext().apply {\n…null)\n    }.socketFactory");
        return sSLSocketFactory0;
    }

    @Override  // okhttp3.internal.platform.Platform
    @NotNull
    public X509TrustManager platformTrustManager() {
        TrustManagerFactory trustManagerFactory0 = TrustManagerFactory.getInstance("PKIX");
        trustManagerFactory0.init(null);
        TrustManager[] arr_trustManager = trustManagerFactory0.getTrustManagers();
        q.d(arr_trustManager);
        if(arr_trustManager.length == 1) {
            TrustManager trustManager0 = arr_trustManager[0];
            if(trustManager0 instanceof X509TrustManager) {
                q.e(trustManager0, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                Conscrypt.setHostnameVerifier(((X509TrustManager)trustManager0), DisabledHostnameVerifier.INSTANCE);
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
        return null;
    }
}

