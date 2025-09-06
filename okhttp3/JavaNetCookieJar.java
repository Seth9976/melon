package okhttp3;

import Tf.v;
import ie.m;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import je.D;
import je.w;
import je.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0007\u001A\u00020\u00062\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u000B0\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001D\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014¨\u0006\u0015"}, d2 = {"Lokhttp3/JavaNetCookieJar;", "Lokhttp3/CookieJar;", "Ljava/net/CookieHandler;", "cookieHandler", "<init>", "(Ljava/net/CookieHandler;)V", "Lokhttp3/HttpUrl;", "url", "", "header", "", "Lokhttp3/Cookie;", "decodeHeaderAsJavaNetCookies", "(Lokhttp3/HttpUrl;Ljava/lang/String;)Ljava/util/List;", "cookies", "Lie/H;", "saveFromResponse", "(Lokhttp3/HttpUrl;Ljava/util/List;)V", "loadForRequest", "(Lokhttp3/HttpUrl;)Ljava/util/List;", "Ljava/net/CookieHandler;", "okhttp-urlconnection"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class JavaNetCookieJar implements CookieJar {
    @NotNull
    private final CookieHandler cookieHandler;

    public JavaNetCookieJar(@NotNull CookieHandler cookieHandler0) {
        q.g(cookieHandler0, "cookieHandler");
        super();
        this.cookieHandler = cookieHandler0;
    }

    private final List decodeHeaderAsJavaNetCookies(HttpUrl httpUrl0, String s) {
        List list0 = new ArrayList();
        int v = s.length();
        for(int v1 = 0; v1 < v; v1 = v2 + 1) {
            int v2 = Util.delimiterOffset(s, ";,", v1, v);
            int v3 = Util.delimiterOffset(s, '=', v1, v2);
            String s1 = Util.trimSubstring(s, v1, v3);
            if(!v.r0(s1, "$", false)) {
                String s2 = v3 >= v2 ? "" : Util.trimSubstring(s, v3 + 1, v2);
                if(v.r0(s2, "\"", false) && v.i0(s2, "\"", false)) {
                    s2 = s2.substring(1, s2.length() - 1);
                    q.f(s2, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                ((ArrayList)list0).add(new Builder().name(s1).value(s2).domain(httpUrl0.host()).build());
            }
        }
        return list0;
    }

    @Override  // okhttp3.CookieJar
    @NotNull
    public List loadForRequest(@NotNull HttpUrl httpUrl0) {
        Map map0;
        List list0 = w.a;
        q.g(httpUrl0, "url");
        try {
            URI uRI0 = httpUrl0.uri();
            map0 = this.cookieHandler.get(uRI0, x.a);
        }
        catch(IOException iOException0) {
            Platform platform0 = Platform.Companion.get();
            HttpUrl httpUrl1 = httpUrl0.resolve("/...");
            q.d(httpUrl1);
            platform0.log("Loading cookies failed for " + httpUrl1, 5, iOException0);
            return list0;
        }
        q.f(map0, "cookieHeaders");
        List list1 = null;
        for(Object object0: map0.entrySet()) {
            String s = (String)((Map.Entry)object0).getKey();
            List list2 = (List)((Map.Entry)object0).getValue();
            if("Cookie".equalsIgnoreCase(s) || "Cookie2".equalsIgnoreCase(s)) {
                q.f(list2, "value");
                if(!list2.isEmpty()) {
                    for(Object object1: list2) {
                        if(list1 == null) {
                            list1 = new ArrayList();
                        }
                        q.f(((String)object1), "header");
                        list1.addAll(this.decodeHeaderAsJavaNetCookies(httpUrl0, ((String)object1)));
                    }
                }
            }
        }
        if(list1 != null) {
            List list3 = Collections.unmodifiableList(list1);
            q.f(list3, "{\n      Collections.unmo…fiableList(cookies)\n    }");
            return list3;
        }
        return list0;
    }

    @Override  // okhttp3.CookieJar
    public void saveFromResponse(@NotNull HttpUrl httpUrl0, @NotNull List list0) {
        q.g(httpUrl0, "url");
        q.g(list0, "cookies");
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            arrayList0.add(Internal.cookieToString(((Cookie)object0), true));
        }
        Map map0 = D.O(new m("Set-Cookie", arrayList0));
        try {
            URI uRI0 = httpUrl0.uri();
            this.cookieHandler.put(uRI0, map0);
        }
        catch(IOException iOException0) {
            Platform platform0 = Platform.Companion.get();
            HttpUrl httpUrl1 = httpUrl0.resolve("/...");
            q.d(httpUrl1);
            platform0.log("Saving cookies failed for " + httpUrl1, 5, iOException0);
        }
    }
}

