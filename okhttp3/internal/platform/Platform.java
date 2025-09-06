package okhttp3.internal.platform;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.platform.android.AndroidLog;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0019\u0010\u000F\u001A\u0004\u0018\u00010\n2\u0006\u0010\u000E\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J/\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0012\u001A\u00020\u00112\b\u0010\u0013\u001A\u0004\u0018\u00010\u00042\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001A\u001A\u00020\u00172\u0006\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0019\u0010\u001C\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\'\u0010$\u001A\u00020\u00172\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010!\u001A\u00020 2\u0006\u0010#\u001A\u00020\"H\u0016\u00A2\u0006\u0004\b$\u0010%J-\u0010*\u001A\u00020\u00172\u0006\u0010&\u001A\u00020\u00042\b\b\u0002\u0010\'\u001A\u00020\"2\n\b\u0002\u0010)\u001A\u0004\u0018\u00010(H\u0016\u00A2\u0006\u0004\b*\u0010+J\u0017\u0010-\u001A\u00020,2\u0006\u0010\u0013\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b-\u0010.J\u0019\u00100\u001A\u0004\u0018\u00010\u00012\u0006\u0010/\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b0\u00101J!\u00103\u001A\u00020\u00172\u0006\u0010&\u001A\u00020\u00042\b\u00102\u001A\u0004\u0018\u00010\u0001H\u0016\u00A2\u0006\u0004\b3\u00104J\u0017\u00106\u001A\u0002052\u0006\u0010\u000F\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b6\u00107J\u0017\u00109\u001A\u0002082\u0006\u0010\u000F\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b9\u0010:J\u0017\u0010;\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b;\u0010<J\u000F\u0010=\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b=\u0010\u0006\u00A8\u0006?"}, d2 = {"Lokhttp3/internal/platform/Platform;", "", "<init>", "()V", "", "getPrefix", "()Ljava/lang/String;", "Ljavax/net/ssl/SSLContext;", "newSSLContext", "()Ljavax/net/ssl/SSLContext;", "Ljavax/net/ssl/X509TrustManager;", "platformTrustManager", "()Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lie/H;", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "afterHandshake", "(Ljavax/net/ssl/SSLSocket;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "Ljava/net/Socket;", "socket", "Ljava/net/InetSocketAddress;", "address", "", "connectTimeout", "connectSocket", "(Ljava/net/Socket;Ljava/net/InetSocketAddress;I)V", "message", "level", "", "t", "log", "(Ljava/lang/String;ILjava/lang/Throwable;)V", "", "isCleartextTrafficPermitted", "(Ljava/lang/String;)Z", "closer", "getStackTraceForCloseable", "(Ljava/lang/String;)Ljava/lang/Object;", "stackTrace", "logCloseableLeak", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lokhttp3/internal/tls/CertificateChainCleaner;", "buildCertificateChainCleaner", "(Ljavax/net/ssl/X509TrustManager;)Lokhttp3/internal/tls/CertificateChainCleaner;", "Lokhttp3/internal/tls/TrustRootIndex;", "buildTrustRootIndex", "(Ljavax/net/ssl/X509TrustManager;)Lokhttp3/internal/tls/TrustRootIndex;", "newSslSocketFactory", "(Ljavax/net/ssl/X509TrustManager;)Ljavax/net/ssl/SSLSocketFactory;", "toString", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class Platform {
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\u0007\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000F\u0010\t\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\f\u001A\u00020\u000B2\b\b\u0002\u0010\n\u001A\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00110\u000E2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000E¢\u0006\u0004\b\u0012\u0010\u0013J\u001B\u0010\u0015\u001A\u00020\u00142\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000E¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001A\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001A\u001A\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u0019R\u0014\u0010\u001B\u001A\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u0019R\u0011\u0010\u001C\u001A\u00020\u00178F¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u0019R\u0014\u0010\u001E\u001A\u00020\u001D8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001E\u0010\u001FR\u0014\u0010 \u001A\u00020\u001D8\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u001FR\u001C\u0010#\u001A\n \"*\u0004\u0018\u00010!0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010\n\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\n\u0010%¨\u0006&"}, d2 = {"Lokhttp3/internal/platform/Platform$Companion;", "", "<init>", "()V", "Lokhttp3/internal/platform/Platform;", "findPlatform", "()Lokhttp3/internal/platform/Platform;", "findAndroidPlatform", "findJvmPlatform", "get", "platform", "Lie/H;", "resetForTests", "(Lokhttp3/internal/platform/Platform;)V", "", "Lokhttp3/Protocol;", "protocols", "", "alpnProtocolNames", "(Ljava/util/List;)Ljava/util/List;", "", "concatLengthPrefixed", "(Ljava/util/List;)[B", "", "isConscryptPreferred", "()Z", "isOpenJSSEPreferred", "isBouncyCastlePreferred", "isAndroid", "", "INFO", "I", "WARN", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "logger", "Ljava/util/logging/Logger;", "Lokhttp3/internal/platform/Platform;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final Platform access$findPlatform(Companion platform$Companion0) {
            return platform$Companion0.findPlatform();
        }

        @NotNull
        public final List alpnProtocolNames(@NotNull List list0) {
            q.g(list0, "protocols");
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: list0) {
                if(((Protocol)object0) != Protocol.HTTP_1_0) {
                    arrayList0.add(object0);
                }
            }
            List list1 = new ArrayList(je.q.Q(10, arrayList0));
            for(Object object1: arrayList0) {
                list1.add(((Protocol)object1).toString());
            }
            return list1;
        }

        @NotNull
        public final byte[] concatLengthPrefixed(@NotNull List list0) {
            q.g(list0, "protocols");
            Buffer buffer0 = new Buffer();
            for(Object object0: this.alpnProtocolNames(list0)) {
                buffer0.writeByte(((String)object0).length());
                buffer0.writeUtf8(((String)object0));
            }
            return new byte[0];
        }

        private final Platform findAndroidPlatform() {
            AndroidLog.INSTANCE.enable();
            Platform platform0 = Android10Platform.Companion.buildIfSupported();
            if(platform0 == null) {
                platform0 = AndroidPlatform.Companion.buildIfSupported();
                q.d(platform0);
            }
            return platform0;
        }

        private final Platform findJvmPlatform() {
            if(this.isConscryptPreferred()) {
                Platform platform0 = ConscryptPlatform.Companion.buildIfSupported();
                if(platform0 != null) {
                    return platform0;
                }
            }
            if(this.isBouncyCastlePreferred()) {
                Platform platform1 = BouncyCastlePlatform.Companion.buildIfSupported();
                if(platform1 != null) {
                    return platform1;
                }
            }
            if(this.isOpenJSSEPreferred()) {
                Platform platform2 = OpenJSSEPlatform.Companion.buildIfSupported();
                if(platform2 != null) {
                    return platform2;
                }
            }
            Platform platform3 = Jdk9Platform.Companion.buildIfSupported();
            if(platform3 != null) {
                return platform3;
            }
            Platform platform4 = Jdk8WithJettyBootPlatform.Companion.buildIfSupported();
            return platform4 == null ? new Platform() : platform4;
        }

        // 去混淆评级： 低(20)
        private final Platform findPlatform() {
            return this.isAndroid() ? this.findAndroidPlatform() : this.findJvmPlatform();
        }

        @NotNull
        public final Platform get() {
            return Platform.platform;
        }

        // 去混淆评级： 低(20)
        public final boolean isAndroid() {
            return "Dalvik".equals("Dalvik");
        }

        // 去混淆评级： 低(20)
        private final boolean isBouncyCastlePreferred() {
            return "BC".equals("SUN");
        }

        // 去混淆评级： 低(20)
        private final boolean isConscryptPreferred() {
            return "Conscrypt".equals("SUN");
        }

        // 去混淆评级： 低(20)
        private final boolean isOpenJSSEPreferred() {
            return "OpenJSSE".equals("SUN");
        }

        public final void resetForTests(@NotNull Platform platform0) {
            q.g(platform0, "platform");
            Platform.platform = platform0;
        }

        public static void resetForTests$default(Companion platform$Companion0, Platform platform0, int v, Object object0) {
            if((v & 1) != 0) {
                platform0 = platform$Companion0.findPlatform();
            }
            platform$Companion0.resetForTests(platform0);
        }
    }

    @NotNull
    public static final Companion Companion = null;
    public static final int INFO = 4;
    public static final int WARN = 5;
    private static final Logger logger;
    @NotNull
    private static volatile Platform platform;

    static {
        Companion platform$Companion0 = new Companion(null);
        Platform.Companion = platform$Companion0;
        Platform.platform = Companion.access$findPlatform(platform$Companion0);
        Platform.logger = Logger.getLogger("okhttp3.OkHttpClient");
    }

    public void afterHandshake(@NotNull SSLSocket sSLSocket0) {
        q.g(sSLSocket0, "sslSocket");
    }

    @NotNull
    public CertificateChainCleaner buildCertificateChainCleaner(@NotNull X509TrustManager x509TrustManager0) {
        q.g(x509TrustManager0, "trustManager");
        return new BasicCertificateChainCleaner(this.buildTrustRootIndex(x509TrustManager0));
    }

    @NotNull
    public TrustRootIndex buildTrustRootIndex(@NotNull X509TrustManager x509TrustManager0) {
        q.g(x509TrustManager0, "trustManager");
        X509Certificate[] arr_x509Certificate = x509TrustManager0.getAcceptedIssuers();
        q.f(arr_x509Certificate, "trustManager.acceptedIssuers");
        return new BasicTrustRootIndex(((X509Certificate[])Arrays.copyOf(arr_x509Certificate, arr_x509Certificate.length)));
    }

    public void configureTlsExtensions(@NotNull SSLSocket sSLSocket0, @Nullable String s, @NotNull List list0) {
        q.g(sSLSocket0, "sslSocket");
        q.g(list0, "protocols");
    }

    public void connectSocket(@NotNull Socket socket0, @NotNull InetSocketAddress inetSocketAddress0, int v) {
        q.g(socket0, "socket");
        q.g(inetSocketAddress0, "address");
        socket0.connect(inetSocketAddress0, v);
    }

    @NotNull
    public static final Platform get() {
        return Platform.Companion.get();
    }

    @NotNull
    public final String getPrefix() [...] // 潜在的解密器

    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sSLSocket0) {
        q.g(sSLSocket0, "sslSocket");
        return null;
    }

    @Nullable
    public Object getStackTraceForCloseable(@NotNull String s) {
        q.g(s, "closer");
        return Platform.logger.isLoggable(Level.FINE) ? new Throwable(s) : null;
    }

    public boolean isCleartextTrafficPermitted(@NotNull String s) {
        q.g(s, "hostname");
        return true;
    }

    public void log(@NotNull String s, int v, @Nullable Throwable throwable0) {
        q.g(s, "message");
        Platform.logger.log((v == 5 ? Level.WARNING : Level.INFO), s, throwable0);
    }

    public static void log$default(Platform platform0, String s, int v, Throwable throwable0, int v1, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
        if((v1 & 2) != 0) {
            v = 4;
        }
        if((v1 & 4) != 0) {
            throwable0 = null;
        }
        platform0.log(s, v, throwable0);
    }

    public void logCloseableLeak(@NotNull String s, @Nullable Object object0) {
        q.g(s, "message");
        if(object0 == null) {
            s = s + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        this.log(s, 5, ((Throwable)object0));
    }

    @NotNull
    public SSLContext newSSLContext() {
        SSLContext sSLContext0 = SSLContext.getInstance("TLS");
        q.f(sSLContext0, "getInstance(\"TLS\")");
        return sSLContext0;
    }

    @NotNull
    public SSLSocketFactory newSslSocketFactory(@NotNull X509TrustManager x509TrustManager0) {
        q.g(x509TrustManager0, "trustManager");
        try {
            SSLContext sSLContext0 = this.newSSLContext();
            sSLContext0.init(null, new TrustManager[]{x509TrustManager0}, null);
            SSLSocketFactory sSLSocketFactory0 = sSLContext0.getSocketFactory();
            q.f(sSLSocketFactory0, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return sSLSocketFactory0;
        }
        catch(GeneralSecurityException generalSecurityException0) {
            throw new AssertionError("No System TLS: " + generalSecurityException0, generalSecurityException0);
        }
    }

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
                return (X509TrustManager)trustManager0;
            }
        }
        q.f("[sun.security.ssl.X509TrustManagerImpl@2d5eaf80]", "toString(this)");
        throw new IllegalStateException("Unexpected default trust managers: [sun.security.ssl.X509TrustManagerImpl@2d5eaf80]");
    }

    @Override
    @NotNull
    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory sSLSocketFactory0) {
        q.g(sSLSocketFactory0, "sslSocketFactory");
        try {
            Object object0 = Util.readFieldOrNull(sSLSocketFactory0, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            return object0 == null ? null : ((X509TrustManager)Util.readFieldOrNull(object0, X509TrustManager.class, "trustManager"));
        }
        catch(ClassNotFoundException runtimeException0) {
            if(!runtimeException0.getClass().getName().equals("java.lang.reflect.InaccessibleObjectException")) {
                throw runtimeException0;
            }
        }
        catch(RuntimeException unused_ex) {
        }
        return null;
    }
}

