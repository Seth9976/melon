package p3;

import De.I;
import P3.c;
import androidx.media3.common.b;

public final class a {
    public static final a a;

    static {
        a.a = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final I a(b b0) {
        String s = b0.n;
        if(s != null) {
            switch(s) {
                case "application/id3": {
                    return new c(null);
                }
                case "application/vnd.dvb.ait": {
                    return new L3.a();  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                case "application/x-emsg": {
                    return new M3.a();  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                case "application/x-icy": {
                    return new O3.a();
                }
                case "application/x-scte35": {
                    return new R3.a();
                }
            }
        }
        throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + s);
    }

    // 去混淆评级： 中等(50)
    public final boolean b(b b0) {
        return "application/id3".equals(b0.n) || "application/x-emsg".equals(b0.n) || "application/x-scte35".equals(b0.n) || "application/x-icy".equals(b0.n) || "application/vnd.dvb.ait".equals(b0.n);
    }
}

