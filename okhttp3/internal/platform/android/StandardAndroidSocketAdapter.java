package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB1\u0012\u000E\u0010\u0002\u001A\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u0003\u0012\u000E\u0010\u0005\u001A\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u0003\u0012\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0006H\u0016J\u0012\u0010\f\u001A\u0004\u0018\u00010\r2\u0006\u0010\u000B\u001A\u00020\u0006H\u0016R\u0012\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001A\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lokhttp3/internal/platform/android/StandardAndroidSocketAdapter;", "Lokhttp3/internal/platform/android/AndroidSocketAdapter;", "sslSocketClass", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "sslSocketFactoryClass", "Ljavax/net/ssl/SSLSocketFactory;", "paramClass", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V", "matchesSocketFactory", "", "sslSocketFactory", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class StandardAndroidSocketAdapter extends AndroidSocketAdapter {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001A\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/platform/android/StandardAndroidSocketAdapter$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/android/SocketAdapter;", "packageName", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Nullable
        public final SocketAdapter buildIfSupported(@NotNull String s) {
            q.g(s, "packageName");
            try {
                return new StandardAndroidSocketAdapter(Class.forName((s + ".OpenSSLSocketImpl")), Class.forName((s + ".OpenSSLSocketFactoryImpl")), Class.forName((s + ".SSLParametersImpl")));
            }
            catch(Exception exception0) {
                Platform.Companion.get().log("unable to load android socket classes", 5, exception0);
                return null;
            }
        }

        public static SocketAdapter buildIfSupported$default(Companion standardAndroidSocketAdapter$Companion0, String s, int v, Object object0) {
            if((v & 1) != 0) {
                s = "com.android.org.conscrypt";
            }
            return standardAndroidSocketAdapter$Companion0.buildIfSupported(s);
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final Class paramClass;
    @NotNull
    private final Class sslSocketFactoryClass;

    static {
        StandardAndroidSocketAdapter.Companion = new Companion(null);
    }

    public StandardAndroidSocketAdapter(@NotNull Class class0, @NotNull Class class1, @NotNull Class class2) {
        q.g(class0, "sslSocketClass");
        q.g(class1, "sslSocketFactoryClass");
        q.g(class2, "paramClass");
        super(class0);
        this.sslSocketFactoryClass = class1;
        this.paramClass = class2;
    }

    @Override  // okhttp3.internal.platform.android.AndroidSocketAdapter
    public boolean matchesSocketFactory(@NotNull SSLSocketFactory sSLSocketFactory0) {
        q.g(sSLSocketFactory0, "sslSocketFactory");
        return this.sslSocketFactoryClass.isInstance(sSLSocketFactory0);
    }

    @Override  // okhttp3.internal.platform.android.AndroidSocketAdapter
    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory sSLSocketFactory0) {
        q.g(sSLSocketFactory0, "sslSocketFactory");
        Object object0 = Util.readFieldOrNull(sSLSocketFactory0, this.paramClass, "sslParameters");
        q.d(object0);
        X509TrustManager x509TrustManager0 = (X509TrustManager)Util.readFieldOrNull(object0, X509TrustManager.class, "x509TrustManager");
        return x509TrustManager0 == null ? ((X509TrustManager)Util.readFieldOrNull(object0, X509TrustManager.class, "trustManager")) : x509TrustManager0;
    }
}

