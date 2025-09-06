package okhttp3.internal.platform.android;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import android.os.Build.VERSION;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressLint({"NewApi"})
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u0005\u001A\u00020\u0004H\u0017¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u000E\u001A\u0004\u0018\u00010\u000B2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00100\u000FH\u0017¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/platform/android/Android10SocketAdapter;", "Lokhttp3/internal/platform/android/SocketAdapter;", "<init>", "()V", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "matchesSocket", "(Ljavax/net/ssl/SSLSocket;)Z", "isSupported", "()Z", "", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lie/H;", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@SuppressSignatureCheck
public final class Android10SocketAdapter implements SocketAdapter {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004J\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/platform/android/Android10SocketAdapter$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/android/SocketAdapter;", "isSupported", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    @SuppressSignatureCheck
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Nullable
        public final SocketAdapter buildIfSupported() {
            return this.isSupported() ? new Android10SocketAdapter() : null;
        }

        public final boolean isSupported() {
            return Platform.Companion.isAndroid() && Build.VERSION.SDK_INT >= 29;
        }
    }

    @NotNull
    public static final Companion Companion;

    static {
        Android10SocketAdapter.Companion = new Companion(null);
    }

    @Override  // okhttp3.internal.platform.android.SocketAdapter
    @SuppressLint({"NewApi"})
    public void configureTlsExtensions(@NotNull SSLSocket sSLSocket0, @Nullable String s, @NotNull List list0) {
        q.g(sSLSocket0, "sslSocket");
        q.g(list0, "protocols");
        try {
            o3.q.g(sSLSocket0);
            SSLParameters sSLParameters0 = sSLSocket0.getSSLParameters();
            sSLParameters0.setApplicationProtocols(((String[])Platform.Companion.alpnProtocolNames(list0).toArray(new String[0])));
            sSLSocket0.setSSLParameters(sSLParameters0);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            throw new IOException("Android internal error", illegalArgumentException0);
        }
    }

    @Override  // okhttp3.internal.platform.android.SocketAdapter
    @SuppressLint({"NewApi"})
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sSLSocket0) {
        q.g(sSLSocket0, "sslSocket");
        String s = sSLSocket0.getApplicationProtocol();
        return (s == null ? true : s.equals("")) ? null : s;
    }

    @Override  // okhttp3.internal.platform.android.SocketAdapter
    public boolean isSupported() {
        return Android10SocketAdapter.Companion.isSupported();
    }

    @Override  // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(@NotNull SSLSocket sSLSocket0) {
        q.g(sSLSocket0, "sslSocket");
        return SSLSockets.isSupportedSocket(sSLSocket0);
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

