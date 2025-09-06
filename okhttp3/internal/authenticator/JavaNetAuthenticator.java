package okhttp3.internal.authenticator;

import java.net.Authenticator.RequestorType;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy.Type;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.Challenge;
import okhttp3.Credentials;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001C\u0010\u0005\u001A\u0004\u0018\u00010\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\b2\u0006\u0010\t\u001A\u00020\nH\u0016J\u001C\u0010\u000B\u001A\u00020\f*\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0003H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/authenticator/JavaNetAuthenticator;", "Lokhttp3/Authenticator;", "defaultDns", "Lokhttp3/Dns;", "(Lokhttp3/Dns;)V", "authenticate", "Lokhttp3/Request;", "route", "Lokhttp3/Route;", "response", "Lokhttp3/Response;", "connectToInetAddress", "Ljava/net/InetAddress;", "Ljava/net/Proxy;", "url", "Lokhttp3/HttpUrl;", "dns", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class JavaNetAuthenticator implements Authenticator {
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[Proxy.Type.values().length];
            try {
                arr_v[Proxy.Type.DIRECT.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    @NotNull
    private final Dns defaultDns;

    public JavaNetAuthenticator() {
        this(null, 1, null);
    }

    public JavaNetAuthenticator(@NotNull Dns dns0) {
        q.g(dns0, "defaultDns");
        super();
        this.defaultDns = dns0;
    }

    public JavaNetAuthenticator(Dns dns0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            dns0 = Dns.SYSTEM;
        }
        this(dns0);
    }

    @Override  // okhttp3.Authenticator
    @Nullable
    public Request authenticate(@Nullable Route route0, @NotNull Response response0) {
        PasswordAuthentication passwordAuthentication0;
        Dns dns1;
        Proxy proxy0;
        q.g(response0, "response");
        List list0 = response0.challenges();
        Request request0 = response0.request();
        HttpUrl httpUrl0 = request0.url();
        boolean z = response0.code() == 407;
        if(route0 == null) {
            proxy0 = Proxy.NO_PROXY;
        }
        else {
            proxy0 = route0.proxy();
            if(proxy0 == null) {
                proxy0 = Proxy.NO_PROXY;
            }
        }
        for(Object object0: list0) {
            Challenge challenge0 = (Challenge)object0;
            if("Basic".equalsIgnoreCase(challenge0.scheme())) {
                if(route0 == null) {
                    dns1 = this.defaultDns;
                }
                else {
                    Address address0 = route0.address();
                    if(address0 != null) {
                        Dns dns0 = address0.dns();
                        if(dns0 != null) {
                            dns1 = dns0;
                        }
                    }
                }
                if(z) {
                    SocketAddress socketAddress0 = proxy0.address();
                    q.e(socketAddress0, "null cannot be cast to non-null type java.net.InetSocketAddress");
                    passwordAuthentication0 = java.net.Authenticator.requestPasswordAuthentication(((InetSocketAddress)socketAddress0).getHostName(), this.connectToInetAddress(proxy0, httpUrl0, dns1), ((InetSocketAddress)socketAddress0).getPort(), httpUrl0.scheme(), challenge0.realm(), challenge0.scheme(), httpUrl0.url(), Authenticator.RequestorType.PROXY);
                }
                else {
                    q.f(proxy0, "proxy");
                    passwordAuthentication0 = java.net.Authenticator.requestPasswordAuthentication(httpUrl0.host(), this.connectToInetAddress(proxy0, httpUrl0, dns1), httpUrl0.port(), httpUrl0.scheme(), challenge0.realm(), challenge0.scheme(), httpUrl0.url(), Authenticator.RequestorType.SERVER);
                }
                if(passwordAuthentication0 != null) {
                    String s = passwordAuthentication0.getUserName();
                    q.f(s, "auth.userName");
                    char[] arr_c = passwordAuthentication0.getPassword();
                    q.f(arr_c, "auth.password");
                    String s1 = Credentials.basic(s, new String(arr_c), challenge0.charset());
                    return request0.newBuilder().header((z ? "Proxy-Authorization" : "Authorization"), s1).build();
                }
                if(false) {
                    break;
                }
            }
        }
        return null;
    }

    private final InetAddress connectToInetAddress(Proxy proxy0, HttpUrl httpUrl0, Dns dns0) {
        Proxy.Type proxy$Type0 = proxy0.type();
        if((proxy$Type0 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[proxy$Type0.ordinal()]) == 1) {
            return (InetAddress)p.k0(dns0.lookup(httpUrl0.host()));
        }
        SocketAddress socketAddress0 = proxy0.address();
        q.e(socketAddress0, "null cannot be cast to non-null type java.net.InetSocketAddress");
        InetAddress inetAddress0 = ((InetSocketAddress)socketAddress0).getAddress();
        q.f(inetAddress0, "address() as InetSocketAddress).address");
        return inetAddress0;
    }
}

