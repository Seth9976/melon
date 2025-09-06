package com.google.protobuf;

import Vd.w;

public final class T2 {
    public final S2 a(Object object0) {
        S2 s20 = ((A1)object0).unknownFields;
        if(s20 == S2.f) {
            s20 = new S2();
            ((A1)object0).unknownFields = s20;
        }
        return s20;
    }

    public final boolean b(int v, w w0, Object object0) {
        int v1 = w0.b;
        t t0 = (t)w0.e;
        switch(v1 & 7) {
            case 0: {
                w0.v0(0);
                ((S2)object0).f(v1 >>> 3 << 3, t0.u());
                return true;
            }
            case 1: {
                w0.v0(1);
                ((S2)object0).f(v1 >>> 3 << 3 | 1, t0.q());
                return true;
            }
            default: {
                switch(v1 & 7) {
                    case 2: {
                        ((S2)object0).f(v1 >>> 3 << 3 | 2, w0.w());
                        return true;
                    }
                    case 3: {
                        S2 s20 = new S2();
                        int v2 = v1 >>> 3 << 3;
                        if(v + 1 >= 100) {
                            throw new R1("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                        }
                        while(w0.h() != 0x7FFFFFFF && this.b(v + 1, w0, s20)) {
                        }
                        if((v2 | 4) != w0.b) {
                            throw R1.a();
                        }
                        if(s20.e) {
                            s20.e = false;
                        }
                        ((S2)object0).f(v2 | 3, s20);
                        return true;
                    }
                    default: {
                        switch(v1 & 7) {
                            case 4: {
                                if(v == 0) {
                                    throw R1.a();
                                }
                                return false;
                            }
                            case 5: {
                                w0.v0(5);
                                ((S2)object0).f(5 | v1 >>> 3 << 3, t0.p());
                                return true;
                            }
                            default: {
                                throw R1.d();
                            }
                        }
                    }
                }
            }
        }
    }

    public final void c(Object object0, Object object1) {
        ((A1)object0).unknownFields = (S2)object1;
    }
}

