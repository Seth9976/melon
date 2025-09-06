package okhttp3.internal.platform;

import android.os.Build.VERSION;
import android.security.NetworkSecurityPolicy;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.CloseGuard;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.platform.android.StandardAndroidSocketAdapter;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 42\u00020\u0001:\u000245B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\'\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u0019\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u000E\u001A\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0019\u001A\u00020\n2\u0006\u0010\u0013\u001A\u00020\u00122\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001AJ\u0019\u0010\u001B\u001A\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ\u0019\u0010\u001F\u001A\u0004\u0018\u00010\u001E2\u0006\u0010\u001D\u001A\u00020\u0014H\u0016¢\u0006\u0004\b\u001F\u0010 J!\u0010#\u001A\u00020\n2\u0006\u0010!\u001A\u00020\u00142\b\u0010\"\u001A\u0004\u0018\u00010\u001EH\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001A\u00020%2\u0006\u0010\u0015\u001A\u00020\u0014H\u0016¢\u0006\u0004\b&\u0010\'J\u0017\u0010)\u001A\u00020(2\u0006\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001A\u00020+2\u0006\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b,\u0010-R\u001A\u0010/\u001A\b\u0012\u0004\u0012\u00020.0\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001A\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00066"}, d2 = {"Lokhttp3/internal/platform/AndroidPlatform;", "Lokhttp3/internal/platform/Platform;", "<init>", "()V", "Ljava/net/Socket;", "socket", "Ljava/net/InetSocketAddress;", "address", "", "connectTimeout", "Lie/H;", "connectSocket", "(Ljava/net/Socket;Ljava/net/InetSocketAddress;I)V", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "closer", "", "getStackTraceForCloseable", "(Ljava/lang/String;)Ljava/lang/Object;", "message", "stackTrace", "logCloseableLeak", "(Ljava/lang/String;Ljava/lang/Object;)V", "", "isCleartextTrafficPermitted", "(Ljava/lang/String;)Z", "Lokhttp3/internal/tls/CertificateChainCleaner;", "buildCertificateChainCleaner", "(Ljavax/net/ssl/X509TrustManager;)Lokhttp3/internal/tls/CertificateChainCleaner;", "Lokhttp3/internal/tls/TrustRootIndex;", "buildTrustRootIndex", "(Ljavax/net/ssl/X509TrustManager;)Lokhttp3/internal/tls/TrustRootIndex;", "Lokhttp3/internal/platform/android/SocketAdapter;", "socketAdapters", "Ljava/util/List;", "Lokhttp3/internal/platform/android/CloseGuard;", "closeGuard", "Lokhttp3/internal/platform/android/CloseGuard;", "Companion", "CustomTrustRootIndex", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@SuppressSignatureCheck
public final class AndroidPlatform extends Platform {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0005¨\u0006\b"}, d2 = {"Lokhttp3/internal/platform/AndroidPlatform$Companion;", "", "()V", "isSupported", "", "()Z", "buildIfSupported", "Lokhttp3/internal/platform/Platform;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Nullable
        public final Platform buildIfSupported() {
            return this.isSupported() ? new AndroidPlatform() : null;
        }

        public final boolean isSupported() {
            return AndroidPlatform.isSupported;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001A\u00020\u0003HÂ\u0003J\t\u0010\b\u001A\u00020\u0005HÂ\u0003J\u001D\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\u0012\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0010\u001A\u00020\u000FH\u0016J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/platform/AndroidPlatform$CustomTrustRootIndex;", "Lokhttp3/internal/tls/TrustRootIndex;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "findByIssuerAndSignatureMethod", "Ljava/lang/reflect/Method;", "(Ljavax/net/ssl/X509TrustManager;Ljava/lang/reflect/Method;)V", "component1", "component2", "copy", "equals", "", "other", "", "findByIssuerAndSignature", "Ljava/security/cert/X509Certificate;", "cert", "hashCode", "", "toString", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class CustomTrustRootIndex implements TrustRootIndex {
        @NotNull
        private final Method findByIssuerAndSignatureMethod;
        @NotNull
        private final X509TrustManager trustManager;

        public CustomTrustRootIndex(@NotNull X509TrustManager x509TrustManager0, @NotNull Method method0) {
            q.g(x509TrustManager0, "trustManager");
            q.g(method0, "findByIssuerAndSignatureMethod");
            super();
            this.trustManager = x509TrustManager0;
            this.findByIssuerAndSignatureMethod = method0;
        }

        private final X509TrustManager component1() {
            return this.trustManager;
        }

        private final Method component2() {
            return this.findByIssuerAndSignatureMethod;
        }

        @NotNull
        public final CustomTrustRootIndex copy(@NotNull X509TrustManager x509TrustManager0, @NotNull Method method0) {
            q.g(x509TrustManager0, "trustManager");
            q.g(method0, "findByIssuerAndSignatureMethod");
            return new CustomTrustRootIndex(x509TrustManager0, method0);
        }

        public static CustomTrustRootIndex copy$default(CustomTrustRootIndex androidPlatform$CustomTrustRootIndex0, X509TrustManager x509TrustManager0, Method method0, int v, Object object0) {
            if((v & 1) != 0) {
                x509TrustManager0 = androidPlatform$CustomTrustRootIndex0.trustManager;
            }
            if((v & 2) != 0) {
                method0 = androidPlatform$CustomTrustRootIndex0.findByIssuerAndSignatureMethod;
            }
            return androidPlatform$CustomTrustRootIndex0.copy(x509TrustManager0, method0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof CustomTrustRootIndex)) {
                return false;
            }
            return q.b(this.trustManager, ((CustomTrustRootIndex)object0).trustManager) ? q.b(this.findByIssuerAndSignatureMethod, ((CustomTrustRootIndex)object0).findByIssuerAndSignatureMethod) : false;
        }

        @Override  // okhttp3.internal.tls.TrustRootIndex
        @Nullable
        public X509Certificate findByIssuerAndSignature(@NotNull X509Certificate x509Certificate0) {
            q.g(x509Certificate0, "cert");
            try {
                Object object0 = this.findByIssuerAndSignatureMethod.invoke(this.trustManager, x509Certificate0);
                q.e(object0, "null cannot be cast to non-null type java.security.cert.TrustAnchor");
                return ((TrustAnchor)object0).getTrustedCert();
            }
            catch(IllegalAccessException illegalAccessException0) {
                throw new AssertionError("unable to get issues and signature", illegalAccessException0);
            }
            catch(InvocationTargetException unused_ex) {
                return null;
            }
        }

        @Override
        public int hashCode() {
            return this.findByIssuerAndSignatureMethod.hashCode() + this.trustManager.hashCode() * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.trustManager + ", findByIssuerAndSignatureMethod=" + this.findByIssuerAndSignatureMethod + ')';
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final CloseGuard closeGuard;
    private static final boolean isSupported;
    @NotNull
    private final List socketAdapters;

    static {
        AndroidPlatform.Companion = new Companion(null);
        AndroidPlatform.isSupported = Platform.Companion.isAndroid() && Build.VERSION.SDK_INT < 30;
    }

    public AndroidPlatform() {
        ArrayList arrayList0 = n.g0(new SocketAdapter[]{okhttp3.internal.platform.android.StandardAndroidSocketAdapter.Companion.buildIfSupported$default(StandardAndroidSocketAdapter.Companion, null, 1, null), new DeferredSocketAdapter(AndroidSocketAdapter.Companion.getPlayProviderFactory()), new DeferredSocketAdapter(ConscryptSocketAdapter.Companion.getFactory()), new DeferredSocketAdapter(BouncyCastleSocketAdapter.Companion.getFactory())});
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: arrayList0) {
            if(((SocketAdapter)object0).isSupported()) {
                arrayList1.add(object0);
            }
        }
        this.socketAdapters = arrayList1;
        this.closeGuard = CloseGuard.Companion.get();
    }

    @Override  // okhttp3.internal.platform.Platform
    @NotNull
    public CertificateChainCleaner buildCertificateChainCleaner(@NotNull X509TrustManager x509TrustManager0) {
        q.g(x509TrustManager0, "trustManager");
        CertificateChainCleaner certificateChainCleaner0 = AndroidCertificateChainCleaner.Companion.buildIfSupported(x509TrustManager0);
        return certificateChainCleaner0 == null ? super.buildCertificateChainCleaner(x509TrustManager0) : certificateChainCleaner0;
    }

    @Override  // okhttp3.internal.platform.Platform
    @NotNull
    public TrustRootIndex buildTrustRootIndex(@NotNull X509TrustManager x509TrustManager0) {
        q.g(x509TrustManager0, "trustManager");
        try {
            Method method0 = x509TrustManager0.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            method0.setAccessible(true);
            return new CustomTrustRootIndex(x509TrustManager0, method0);
        }
        catch(NoSuchMethodException unused_ex) {
            return super.buildTrustRootIndex(x509TrustManager0);
        }
    }

    @Override  // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(@NotNull SSLSocket sSLSocket0, @Nullable String s, @NotNull List list0) {
        Object object0 = null;
        q.g(sSLSocket0, "sslSocket");
        q.g(list0, "protocols");
        for(Object object1: this.socketAdapters) {
            if(((SocketAdapter)object1).matchesSocket(sSLSocket0)) {
                object0 = object1;
                break;
            }
        }
        if(((SocketAdapter)object0) != null) {
            ((SocketAdapter)object0).configureTlsExtensions(sSLSocket0, s, list0);
        }
    }

    @Override  // okhttp3.internal.platform.Platform
    public void connectSocket(@NotNull Socket socket0, @NotNull InetSocketAddress inetSocketAddress0, int v) {
        q.g(socket0, "socket");
        q.g(inetSocketAddress0, "address");
        try {
            socket0.connect(inetSocketAddress0, v);
            return;
        }
        catch(ClassCastException classCastException0) {
            if(Build.VERSION.SDK_INT == 26) {
                throw new IOException("Exception in connect", classCastException0);
            }
            throw classCastException0;
        }
    }

    @Override  // okhttp3.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sSLSocket0) {
        q.g(sSLSocket0, "sslSocket");
        for(Object object0: this.socketAdapters) {
            if(((SocketAdapter)object0).matchesSocket(sSLSocket0)) {
                return ((SocketAdapter)object0) == null ? null : ((SocketAdapter)object0).getSelectedProtocol(sSLSocket0);
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    @Override  // okhttp3.internal.platform.Platform
    @Nullable
    public Object getStackTraceForCloseable(@NotNull String s) {
        q.g(s, "closer");
        return this.closeGuard.createAndOpen(s);
    }

    @Override  // okhttp3.internal.platform.Platform
    public boolean isCleartextTrafficPermitted(@NotNull String s) {
        q.g(s, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(s);
    }

    @Override  // okhttp3.internal.platform.Platform
    public void logCloseableLeak(@NotNull String s, @Nullable Object object0) {
        q.g(s, "message");
        if(!this.closeGuard.warnIfOpen(object0)) {
            Platform.log$default(this, s, 5, null, 4, null);
        }
    }

    @Override  // okhttp3.internal.platform.Platform
    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory sSLSocketFactory0) {
        q.g(sSLSocketFactory0, "sslSocketFactory");
        for(Object object0: this.socketAdapters) {
            if(((SocketAdapter)object0).matchesSocketFactory(sSLSocketFactory0)) {
                return ((SocketAdapter)object0) == null ? null : ((SocketAdapter)object0).trustManager(sSLSocketFactory0);
            }
            if(false) {
                break;
            }
        }
        return null;
    }
}

