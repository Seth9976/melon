package s5;

import Tf.v;
import okhttp3.Headers.Builder;
import okhttp3.Headers;

public abstract class c {
    public static Headers a(Headers headers0, Headers headers1) {
        Builder headers$Builder0 = new Builder();
        int v = headers0.size();
        for(int v2 = 0; v2 < v; ++v2) {
            String s = headers0.name(v2);
            String s1 = headers0.value(v2);
            if((!"Warning".equalsIgnoreCase(s) || !v.r0(s1, "1", false)) && ("Content-Length".equalsIgnoreCase(s) || "Content-Encoding".equalsIgnoreCase(s) || "Content-Type".equalsIgnoreCase(s) || !c.b(s) || headers1.get(s) == null)) {
                headers$Builder0.addUnsafeNonAscii(s, s1);
            }
        }
        int v3 = headers1.size();
        for(int v1 = 0; v1 < v3; ++v1) {
            String s2 = headers1.name(v1);
            if(!"Content-Length".equalsIgnoreCase(s2) && !"Content-Encoding".equalsIgnoreCase(s2) && !"Content-Type".equalsIgnoreCase(s2) && c.b(s2)) {
                headers$Builder0.addUnsafeNonAscii(s2, headers1.value(v1));
            }
        }
        return headers$Builder0.build();
    }

    // 去混淆评级： 中等(80)
    public static boolean b(String s) {
        return !"Connection".equalsIgnoreCase(s) && !"Keep-Alive".equalsIgnoreCase(s) && !"Proxy-Authenticate".equalsIgnoreCase(s) && !"Proxy-Authorization".equalsIgnoreCase(s) && !"TE".equalsIgnoreCase(s) && !"Trailers".equalsIgnoreCase(s) && !"Transfer-Encoding".equalsIgnoreCase(s) && !"Upgrade".equalsIgnoreCase(s);
    }
}

