package okhttp3.internal.platform.android;

import Tf.a;
import Tf.v;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.platform.AndroidPlatform;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u001F2\u00020\u0001:\u0001\u001FB\u0017\u0012\u000E\u0010\u0004\u001A\n\u0012\u0006\b\u0000\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000B\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u000B\u0010\fJ/\u0010\u0013\u001A\u00020\u00122\u0006\u0010\n\u001A\u00020\u00032\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00100\u000FH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001A\u0004\u0018\u00010\r2\u0006\u0010\n\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001C\u0010\u0004\u001A\n\u0012\u0006\b\u0000\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0017R\u0014\u0010\u0019\u001A\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001AR\u001C\u0010\u001C\u001A\n \u001B*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001C\u0010\u001AR\u001C\u0010\u001D\u001A\n \u001B*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001D\u0010\u001AR\u001C\u0010\u001E\u001A\n \u001B*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001E\u0010\u001A¨\u0006 "}, d2 = {"Lokhttp3/internal/platform/android/AndroidSocketAdapter;", "Lokhttp3/internal/platform/android/SocketAdapter;", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "sslSocketClass", "<init>", "(Ljava/lang/Class;)V", "", "isSupported", "()Z", "sslSocket", "matchesSocket", "(Ljavax/net/ssl/SSLSocket;)Z", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lie/H;", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "Ljava/lang/Class;", "Ljava/lang/reflect/Method;", "setUseSessionTickets", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "setHostname", "getAlpnSelectedProtocol", "setAlpnProtocols", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class AndroidSocketAdapter implements SocketAdapter {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001A\u00020\b2\u000E\u0010\t\u001A\n\u0012\u0006\b\u0000\u0012\u00020\u000B0\nH\u0002J\u000E\u0010\f\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\u000ER\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u000F"}, d2 = {"Lokhttp3/internal/platform/android/AndroidSocketAdapter$Companion;", "", "()V", "playProviderFactory", "Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "getPlayProviderFactory", "()Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "build", "Lokhttp3/internal/platform/android/AndroidSocketAdapter;", "actualSSLSocketClass", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "factory", "packageName", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final AndroidSocketAdapter build(Class class0) {
            Class class1 = class0;
            while(class1 != null && !class1.getSimpleName().equals("OpenSSLSocketImpl")) {
                class1 = class1.getSuperclass();
                if(class1 == null) {
                    throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + class0);
                }
                if(false) {
                    break;
                }
            }
            q.d(class1);
            return new AndroidSocketAdapter(class1);
        }

        @NotNull
        public final Factory factory(@NotNull String s) {
            q.g(s, "packageName");
            return new Factory() {
                @Override  // okhttp3.internal.platform.android.DeferredSocketAdapter$Factory
                @NotNull
                public SocketAdapter create(@NotNull SSLSocket sSLSocket0) {
                    q.g(sSLSocket0, "sslSocket");
                    Class class0 = sSLSocket0.getClass();
                    return AndroidSocketAdapter.Companion.build(class0);
                }

                @Override  // okhttp3.internal.platform.android.DeferredSocketAdapter$Factory
                public boolean matchesSocket(@NotNull SSLSocket sSLSocket0) {
                    q.g(sSLSocket0, "sslSocket");
                    return v.r0(sSLSocket0.getClass().getName(), this.$packageName + '.', false);
                }
            };
        }

        @NotNull
        public final Factory getPlayProviderFactory() {
            return AndroidSocketAdapter.playProviderFactory;
        }
    }

    @NotNull
    public static final Companion Companion;
    private final Method getAlpnSelectedProtocol;
    @NotNull
    private static final Factory playProviderFactory;
    private final Method setAlpnProtocols;
    private final Method setHostname;
    @NotNull
    private final Method setUseSessionTickets;
    @NotNull
    private final Class sslSocketClass;

    static {
        Companion androidSocketAdapter$Companion0 = new Companion(null);
        AndroidSocketAdapter.Companion = androidSocketAdapter$Companion0;
        AndroidSocketAdapter.playProviderFactory = androidSocketAdapter$Companion0.factory("com.google.android.gms.org.conscrypt");
    }

    public AndroidSocketAdapter(@NotNull Class class0) {
        q.g(class0, "sslSocketClass");
        super();
        this.sslSocketClass = class0;
        Method method0 = class0.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        q.f(method0, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.setUseSessionTickets = method0;
        this.setHostname = class0.getMethod("setHostname", String.class);
        this.getAlpnSelectedProtocol = class0.getMethod("getAlpnSelectedProtocol", null);
        this.setAlpnProtocols = class0.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override  // okhttp3.internal.platform.android.SocketAdapter
    public void configureTlsExtensions(@NotNull SSLSocket sSLSocket0, @Nullable String s, @NotNull List list0) {
        q.g(sSLSocket0, "sslSocket");
        q.g(list0, "protocols");
        if(this.matchesSocket(sSLSocket0)) {
            try {
                this.setUseSessionTickets.invoke(sSLSocket0, Boolean.TRUE);
                if(s != null) {
                    this.setHostname.invoke(sSLSocket0, s);
                }
                Object[] arr_object = {Platform.Companion.concatLengthPrefixed(list0)};
                this.setAlpnProtocols.invoke(sSLSocket0, arr_object);
                return;
            }
            catch(IllegalAccessException illegalAccessException0) {
            }
            catch(InvocationTargetException invocationTargetException0) {
                throw new AssertionError(invocationTargetException0);
            }
            throw new AssertionError(illegalAccessException0);
        }
    }

    @Override  // okhttp3.internal.platform.android.SocketAdapter
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sSLSocket0) {
        q.g(sSLSocket0, "sslSocket");
        if(!this.matchesSocket(sSLSocket0)) {
            return null;
        }
        try {
            byte[] arr_b = (byte[])this.getAlpnSelectedProtocol.invoke(sSLSocket0, null);
            return arr_b == null ? null : new String(arr_b, a.a);
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new AssertionError(illegalAccessException0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            Throwable throwable0 = invocationTargetException0.getCause();
            if(!(throwable0 instanceof NullPointerException) || !q.b(((NullPointerException)throwable0).getMessage(), "ssl == null")) {
                throw new AssertionError(invocationTargetException0);
            }
            return null;
        }
    }

    @Override  // okhttp3.internal.platform.android.SocketAdapter
    public boolean isSupported() {
        return AndroidPlatform.Companion.isSupported();
    }

    @Override  // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(@NotNull SSLSocket sSLSocket0) {
        q.g(sSLSocket0, "sslSocket");
        return this.sslSocketClass.isInstance(sSLSocket0);
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

