package okhttp3.internal.platform;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.security.NetworkSecurityPolicy;
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
import okhttp3.internal.platform.android.Android10SocketAdapter;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.tls.CertificateChainCleaner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001E2\u00020\u0001:\u0001\u001EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0011\u001A\u00020\u00102\u0006\u0010\n\u001A\u00020\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u000E0\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001A\u00020\u00152\u0006\u0010\f\u001A\u00020\u000BH\u0017¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u001AR\u001A\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u001B0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001C\u0010\u001D¨\u0006\u001F"}, d2 = {"Lokhttp3/internal/platform/Android10Platform;", "Lokhttp3/internal/platform/Platform;", "<init>", "()V", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lie/H;", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "", "isCleartextTrafficPermitted", "(Ljava/lang/String;)Z", "Lokhttp3/internal/tls/CertificateChainCleaner;", "buildCertificateChainCleaner", "(Ljavax/net/ssl/X509TrustManager;)Lokhttp3/internal/tls/CertificateChainCleaner;", "Lokhttp3/internal/platform/android/SocketAdapter;", "socketAdapters", "Ljava/util/List;", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@SuppressSignatureCheck
public final class Android10Platform extends Platform {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0005¨\u0006\b"}, d2 = {"Lokhttp3/internal/platform/Android10Platform$Companion;", "", "()V", "isSupported", "", "()Z", "buildIfSupported", "Lokhttp3/internal/platform/Platform;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Nullable
        public final Platform buildIfSupported() {
            return this.isSupported() ? new Android10Platform() : null;
        }

        public final boolean isSupported() {
            return Android10Platform.isSupported;
        }
    }

    @NotNull
    public static final Companion Companion;
    private static final boolean isSupported;
    @NotNull
    private final List socketAdapters;

    static {
        Android10Platform.Companion = new Companion(null);
        Android10Platform.isSupported = Platform.Companion.isAndroid() && Build.VERSION.SDK_INT >= 29;
    }

    public Android10Platform() {
        ArrayList arrayList0 = n.g0(new SocketAdapter[]{Android10SocketAdapter.Companion.buildIfSupported(), new DeferredSocketAdapter(AndroidSocketAdapter.Companion.getPlayProviderFactory()), new DeferredSocketAdapter(ConscryptSocketAdapter.Companion.getFactory()), new DeferredSocketAdapter(BouncyCastleSocketAdapter.Companion.getFactory())});
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: arrayList0) {
            if(((SocketAdapter)object0).isSupported()) {
                arrayList1.add(object0);
            }
        }
        this.socketAdapters = arrayList1;
    }

    @Override  // okhttp3.internal.platform.Platform
    @NotNull
    public CertificateChainCleaner buildCertificateChainCleaner(@NotNull X509TrustManager x509TrustManager0) {
        q.g(x509TrustManager0, "trustManager");
        CertificateChainCleaner certificateChainCleaner0 = AndroidCertificateChainCleaner.Companion.buildIfSupported(x509TrustManager0);
        return certificateChainCleaner0 == null ? super.buildCertificateChainCleaner(x509TrustManager0) : certificateChainCleaner0;
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
    @SuppressLint({"NewApi"})
    public boolean isCleartextTrafficPermitted(@NotNull String s) {
        q.g(s, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(s);
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

