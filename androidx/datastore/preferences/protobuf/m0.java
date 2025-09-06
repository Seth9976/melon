package androidx.datastore.preferences.protobuf;

import Vd.w;

public final class m0 {
    public final l0 a(Object object0) {
        l0 l00 = ((A)object0).unknownFields;
        if(l00 == l0.f) {
            l00 = new l0(0, new int[8], new Object[8], true);
            ((A)object0).unknownFields = l00;
        }
        return l00;
    }

    public final boolean b(int v, w w0, Object object0) {
        int v1 = w0.b;
        m m0 = (m)w0.e;
        switch(v1 & 7) {
            case 0: {
                w0.v0(0);
                ((l0)object0).c(v1 >>> 3 << 3, m0.t());
                return true;
            }
            case 1: {
                w0.v0(1);
                ((l0)object0).c(v1 >>> 3 << 3 | 1, m0.p());
                return true;
            }
            default: {
                switch(v1 & 7) {
                    case 2: {
                        ((l0)object0).c(v1 >>> 3 << 3 | 2, w0.u());
                        return true;
                    }
                    case 3: {
                        l0 l00 = new l0(0, new int[8], new Object[8], true);
                        int v2 = v1 >>> 3 << 3;
                        if(v + 1 >= 100) {
                            throw new F("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                        }
                        while(w0.h() != 0x7FFFFFFF && this.b(v + 1, w0, l00)) {
                        }
                        if((v2 | 4) != w0.b) {
                            throw new F("Protocol message end-group tag did not match expected tag.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                        }
                        if(l00.e) {
                            l00.e = false;
                        }
                        ((l0)object0).c(v2 | 3, l00);
                        return true;
                    }
                    default: {
                        switch(v1 & 7) {
                            case 4: {
                                return false;
                            }
                            case 5: {
                                w0.v0(5);
                                ((l0)object0).c(5 | v1 >>> 3 << 3, m0.o());
                                return true;
                            }
                            default: {
                                throw F.b();
                            }
                        }
                    }
                }
            }
        }
    }
}

