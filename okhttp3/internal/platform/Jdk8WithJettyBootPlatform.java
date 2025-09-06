package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\u0018\u0000 \u001B2\u00020\u0001:\u0002\u001C\u001BB7\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0002\u0012\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0010\b\u001A\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0013\u001A\u00020\u00122\u0006\u0010\f\u001A\u00020\u000B2\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00100\u000FH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001A\u00020\u00122\u0006\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001A\u0004\u0018\u00010\r2\u0006\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0014\u0010\u0004\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0019R\u0014\u0010\u0005\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0018\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001AR\u0018\u0010\b\u001A\u0006\u0012\u0002\b\u00030\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001A¨\u0006\u001D"}, d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform;", "Lokhttp3/internal/platform/Platform;", "Ljava/lang/reflect/Method;", "putMethod", "getMethod", "removeMethod", "Ljava/lang/Class;", "clientProviderClass", "serverProviderClass", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lie/H;", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "afterHandshake", "(Ljavax/net/ssl/SSLSocket;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "Ljava/lang/reflect/Method;", "Ljava/lang/Class;", "Companion", "AlpnProvider", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Jdk8WithJettyBootPlatform extends Platform {
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J0\u0010\u0011\u001A\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u00152\u000E\u0010\u0016\u001A\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0017H\u0096\u0002¢\u0006\u0002\u0010\u0018R\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u0006\u001A\u0004\u0018\u00010\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001A\u0010\u000B\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform$AlpnProvider;", "Ljava/lang/reflect/InvocationHandler;", "protocols", "", "", "(Ljava/util/List;)V", "selected", "getSelected", "()Ljava/lang/String;", "setSelected", "(Ljava/lang/String;)V", "unsupported", "", "getUnsupported", "()Z", "setUnsupported", "(Z)V", "invoke", "", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class AlpnProvider implements InvocationHandler {
        @NotNull
        private final List protocols;
        @Nullable
        private String selected;
        private boolean unsupported;

        public AlpnProvider(@NotNull List list0) {
            q.g(list0, "protocols");
            super();
            this.protocols = list0;
        }

        @Nullable
        public final String getSelected() {
            return this.selected;
        }

        public final boolean getUnsupported() {
            return this.unsupported;
        }

        @Override
        @Nullable
        public Object invoke(@NotNull Object object0, @NotNull Method method0, @Nullable Object[] arr_object) {
            q.g(object0, "proxy");
            q.g(method0, "method");
            if(arr_object == null) {
                arr_object = new Object[0];
            }
            String s = method0.getName();
            Class class0 = method0.getReturnType();
            if(q.b(s, "supports") && q.b(Boolean.TYPE, class0)) {
                return true;
            }
            if(q.b(s, "unsupported") && q.b(Void.TYPE, class0)) {
                this.unsupported = true;
                return null;
            }
            if(q.b(s, "protocols") && arr_object.length == 0) {
                return this.protocols;
            }
            if((q.b(s, "selectProtocol") || q.b(s, "select")) && String.class.equals(class0) && arr_object.length == 1) {
                Object object1 = arr_object[0];
                if(object1 instanceof List) {
                    q.e(object1, "null cannot be cast to non-null type kotlin.collections.List<*>");
                    int v = ((List)object1).size();
                    if(v >= 0) {
                        for(int v1 = 0; true; ++v1) {
                            Object object2 = ((List)object1).get(v1);
                            q.e(object2, "null cannot be cast to non-null type kotlin.String");
                            String s1 = (String)object2;
                            if(this.protocols.contains(s1)) {
                                this.selected = s1;
                                return s1;
                            }
                            if(v1 == v) {
                                break;
                            }
                        }
                    }
                    String s2 = (String)this.protocols.get(0);
                    this.selected = s2;
                    return s2;
                }
            }
            if((q.b(s, "protocolSelected") || q.b(s, "selected")) && arr_object.length == 1) {
                Object object3 = arr_object[0];
                q.e(object3, "null cannot be cast to non-null type kotlin.String");
                this.selected = (String)object3;
                return null;
            }
            return method0.invoke(this, Arrays.copyOf(arr_object, arr_object.length));
        }

        public final void setSelected(@Nullable String s) {
            this.selected = s;
        }

        public final void setUnsupported(boolean z) {
            this.unsupported = z;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/Platform;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Nullable
        public final Platform buildIfSupported() {
            Class class0;
            try {
                class0 = SSLSocket.class;
                q.f("0.9", "jvmVersion");
                if(Integer.parseInt("0.9") < 9) {
                    goto label_3;
                }
                return null;
            }
            catch(NumberFormatException unused_ex) {
            }
            try {
            label_3:
                Class class1 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                Class class2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                Class class3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                Class class4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                Method method0 = class1.getMethod("put", class0, class2);
                Method method1 = class1.getMethod("get", class0);
                Method method2 = class1.getMethod("remove", class0);
                q.f(method0, "putMethod");
                q.f(method1, "getMethod");
                q.f(method2, "removeMethod");
                q.f(class3, "clientProviderClass");
                q.f(class4, "serverProviderClass");
                return new Jdk8WithJettyBootPlatform(method0, method1, method2, class3, class4);
            }
            catch(ClassNotFoundException | NoSuchMethodException unused_ex) {
            }
            return null;
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final Class clientProviderClass;
    @NotNull
    private final Method getMethod;
    @NotNull
    private final Method putMethod;
    @NotNull
    private final Method removeMethod;
    @NotNull
    private final Class serverProviderClass;

    static {
        Jdk8WithJettyBootPlatform.Companion = new Companion(null);
    }

    public Jdk8WithJettyBootPlatform(@NotNull Method method0, @NotNull Method method1, @NotNull Method method2, @NotNull Class class0, @NotNull Class class1) {
        q.g(method0, "putMethod");
        q.g(method1, "getMethod");
        q.g(method2, "removeMethod");
        q.g(class0, "clientProviderClass");
        q.g(class1, "serverProviderClass");
        super();
        this.putMethod = method0;
        this.getMethod = method1;
        this.removeMethod = method2;
        this.clientProviderClass = class0;
        this.serverProviderClass = class1;
    }

    @Override  // okhttp3.internal.platform.Platform
    public void afterHandshake(@NotNull SSLSocket sSLSocket0) {
        q.g(sSLSocket0, "sslSocket");
        try {
            this.removeMethod.invoke(null, sSLSocket0);
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new AssertionError("failed to remove ALPN", illegalAccessException0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            throw new AssertionError("failed to remove ALPN", invocationTargetException0);
        }
    }

    @Override  // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(@NotNull SSLSocket sSLSocket0, @Nullable String s, @NotNull List list0) {
        q.g(sSLSocket0, "sslSocket");
        q.g(list0, "protocols");
        List list1 = Platform.Companion.alpnProtocolNames(list0);
        try {
            AlpnProvider jdk8WithJettyBootPlatform$AlpnProvider0 = new AlpnProvider(list1);
            Object[] arr_object = {sSLSocket0, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, jdk8WithJettyBootPlatform$AlpnProvider0)};
            this.putMethod.invoke(null, arr_object);
        }
        catch(InvocationTargetException invocationTargetException0) {
            throw new AssertionError("failed to set ALPN", invocationTargetException0);
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new AssertionError("failed to set ALPN", illegalAccessException0);
        }
    }

    @Override  // okhttp3.internal.platform.Platform
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sSLSocket0) {
        InvocationTargetException invocationTargetException1;
        q.g(sSLSocket0, "sslSocket");
        try {
            InvocationHandler invocationHandler0 = Proxy.getInvocationHandler(this.getMethod.invoke(null, sSLSocket0));
            q.e(invocationHandler0, "null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            if(!((AlpnProvider)invocationHandler0).getUnsupported() && ((AlpnProvider)invocationHandler0).getSelected() == null) {
                Platform.log$default(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                return null;
            }
            return ((AlpnProvider)invocationHandler0).getUnsupported() ? null : ((AlpnProvider)invocationHandler0).getSelected();
        label_8:
            IllegalAccessException illegalAccessException1 = illegalAccessException0;
            throw new AssertionError("failed to get ALPN selected protocol", illegalAccessException1);
        }
        catch(InvocationTargetException invocationTargetException0) {
            invocationTargetException1 = invocationTargetException0;
            throw new AssertionError("failed to get ALPN selected protocol", invocationTargetException1);
        }
        catch(IllegalAccessException illegalAccessException0) {
            goto label_8;
        }
        throw new AssertionError("failed to get ALPN selected protocol", invocationTargetException1);
    }
}

