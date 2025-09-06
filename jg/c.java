package jg;

import Tf.o;
import Tf.v;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.q;

public abstract class c {
    public static final int a;

    static {
        new ReentrantLock();
        TimeZone timeZone0 = TimeZone.getTimeZone("GMT");
        Locale locale0 = Locale.US;
        new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z", locale0).setTimeZone(timeZone0);
        new SimpleDateFormat("EEEE, dd-MMM-yy HH:mm:ss z", locale0).setTimeZone(timeZone0);
        new SimpleDateFormat("E MMM d HH:mm:ss yyyy", locale0).setTimeZone(timeZone0);
    }

    public static URL a(int v, String s, String s1) {
        q.g(s, "baseUrl");
        q.g(s1, "url");
        if(!v.r0(s1, "http://", true)) {
            String s2 = o.a1(s, '?');
            if(v.r0(s1, "/", false)) {
                int v1 = o.E0(s2, '/', 7, 4);
                if(v1 < 0) {
                    return c.b(v, s2 + s1);
                }
                s2 = s2.substring(0, v1);
                q.f(s2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return c.b(v, s2 + s1);
            }
            if(v.i0(s2, "/", false)) {
                return c.b(v, s2 + s1);
            }
            int v2 = o.J0(s2, '/', 0, 6);
            if(v2 > 7) {
                String s3 = s2.substring(0, v2 + 1);
                q.f(s3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return c.b(v, s3 + s1);
            }
            s1 = s2 + '/' + s1;
        }
        return c.b(v, s1);
    }

    public static URL b(int v, String s) {
        String s3;
        q.g(s, "urlString");
        URL uRL0 = new URL(s);
        if(v == 0) {
            return uRL0;
        }
        String s1 = uRL0.getHost();
        q.f(s1, "url.host");
        try {
            boolean z = false;
            z = InetAddress.getByName(s1) instanceof Inet6Address;
        }
        catch(UnknownHostException unused_ex) {
        }
        if(z) {
            int v1 = s1.length();
            if(s1.charAt(v1 - 1) == 93) {
                int v2 = o.F0(s1, "%", 0, false, 6);
                if(v2 < 0) {
                    String s2 = s1.substring(0, v1 - 1);
                    q.f(s2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    s3 = s2 + '%' + v + ']';
                }
                else {
                    String s4 = s1.substring(0, v2);
                    q.f(s4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    s3 = s4 + '%' + v + ']';
                }
                s1 = s3;
            }
        }
        int v3 = uRL0.getPort();
        return uRL0.getDefaultPort() == v3 || v3 <= 0 ? new URL(uRL0.getProtocol() + "://" + s1 + uRL0.getFile()) : new URL(uRL0.getProtocol() + "://" + s1 + ':' + uRL0.getPort() + uRL0.getFile());
    }
}

