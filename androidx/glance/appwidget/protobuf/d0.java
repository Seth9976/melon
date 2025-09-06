package androidx.glance.appwidget.protobuf;

import Vd.w;
import androidx.datastore.preferences.protobuf.m;

public final class d0 {
    public static c0 a(Object object0) {
        c0 c00 = ((x)object0).unknownFields;
        if(c00 == c0.f) {
            c00 = new c0(0, new int[8], new Object[8], true);
            ((x)object0).unknownFields = c00;
        }
        return c00;
    }

    public static boolean b(int v, w w0, Object object0) {
        int v1 = w0.b;
        m m0 = (m)w0.e;
        switch(v1 & 7) {
            case 0: {
                w0.v0(0);
                ((c0)object0).c(v1 >>> 3 << 3, m0.t());
                return true;
            }
            case 1: {
                w0.v0(1);
                ((c0)object0).c(v1 >>> 3 << 3 | 1, m0.p());
                return true;
            }
            default: {
                switch(v1 & 7) {
                    case 2: {
                        ((c0)object0).c(v1 >>> 3 << 3 | 2, w0.v());
                        return true;
                    }
                    case 3: {
                        c0 c00 = new c0(0, new int[8], new Object[8], true);
                        int v2 = v1 >>> 3 << 3;
                        if(v + 1 >= 100) {
                            throw new D("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                        }
                        while(w0.h() != 0x7FFFFFFF && d0.b(v + 1, w0, c00)) {
                        }
                        if((v2 | 4) != w0.b) {
                            throw new D("Protocol message end-group tag did not match expected tag.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                        }
                        if(c00.e) {
                            c00.e = false;
                        }
                        ((c0)object0).c(v2 | 3, c00);
                        return true;
                    }
                    default: {
                        switch(v1 & 7) {
                            case 4: {
                                return false;
                            }
                            case 5: {
                                w0.v0(5);
                                ((c0)object0).c(5 | v1 >>> 3 << 3, m0.o());
                                return true;
                            }
                            default: {
                                throw D.b();
                            }
                        }
                    }
                }
            }
        }
    }
}

