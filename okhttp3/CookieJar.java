package okhttp3;

import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ%\u0010\b\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u00022\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u001D\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000B¨\u0006\r"}, d2 = {"Lokhttp3/CookieJar;", "", "Lokhttp3/HttpUrl;", "url", "", "Lokhttp3/Cookie;", "cookies", "Lie/H;", "saveFromResponse", "(Lokhttp3/HttpUrl;Ljava/util/List;)V", "loadForRequest", "(Lokhttp3/HttpUrl;)Ljava/util/List;", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public interface CookieJar {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0006"}, d2 = {"Lokhttp3/CookieJar$Companion;", "", "()V", "NO_COOKIES", "Lokhttp3/CookieJar;", "NoCookies", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u001D\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lokhttp3/CookieJar$Companion$NoCookies;", "Lokhttp3/CookieJar;", "<init>", "()V", "Lokhttp3/HttpUrl;", "url", "", "Lokhttp3/Cookie;", "cookies", "Lie/H;", "saveFromResponse", "(Lokhttp3/HttpUrl;Ljava/util/List;)V", "loadForRequest", "(Lokhttp3/HttpUrl;)Ljava/util/List;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        static final class NoCookies implements CookieJar {
            @Override  // okhttp3.CookieJar
            @NotNull
            public List loadForRequest(@NotNull HttpUrl httpUrl0) {
                q.g(httpUrl0, "url");
                return w.a;
            }

            @Override  // okhttp3.CookieJar
            public void saveFromResponse(@NotNull HttpUrl httpUrl0, @NotNull List list0) {
                q.g(httpUrl0, "url");
                q.g(list0, "cookies");
            }
        }

        static final Companion $$INSTANCE;

        static {
            Companion.$$INSTANCE = new Companion();
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    public static final CookieJar NO_COOKIES;

    static {
        CookieJar.Companion = Companion.$$INSTANCE;
        CookieJar.NO_COOKIES = new NoCookies();
    }

    @NotNull
    List loadForRequest(@NotNull HttpUrl arg1);

    void saveFromResponse(@NotNull HttpUrl arg1, @NotNull List arg2);
}

