package i.n.i.b.a.s.e;

import Bf.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public final class W3 extends a {
    public long b;
    public long[] c;
    public long[] d;

    public static Serializable r1(int v, wb wb0) {
        int v1 = 0;
        switch(v) {
            case 0: {
                return Double.longBitsToDouble(wb0.w());
            }
            case 1: {
                if(wb0.z() == 1) {
                    v1 = 1;
                }
                return Boolean.valueOf(((boolean)v1));
            }
            case 2: {
                return W3.t1(wb0);
            }
            case 8: {
                return W3.s1(wb0);
            }
            case 10: {
                int v3 = wb0.C();
                Serializable serializable2 = new ArrayList(v3);
                while(v1 < v3) {
                    Serializable serializable3 = W3.r1(wb0.z(), wb0);
                    if(serializable3 != null) {
                        ((ArrayList)serializable2).add(serializable3);
                    }
                    ++v1;
                }
                return serializable2;
            }
            case 11: {
                Serializable serializable4 = new Date(((long)Double.longBitsToDouble(wb0.w())));
                wb0.o(2);
                return serializable4;
            }
            default: {
                if(v != 3) {
                    return null;
                }
                Serializable serializable0 = new HashMap();
                while(true) {
                    String s = W3.t1(wb0);
                    int v2 = wb0.z();
                    if(v2 == 9) {
                        break;
                    }
                    Serializable serializable1 = W3.r1(v2, wb0);
                    if(serializable1 != null) {
                        ((HashMap)serializable0).put(s, serializable1);
                    }
                }
                return serializable0;
            }
        }
    }

    public static HashMap s1(wb wb0) {
        int v = wb0.C();
        HashMap hashMap0 = new HashMap(v);
        for(int v1 = 0; v1 < v; ++v1) {
            String s = W3.t1(wb0);
            Serializable serializable0 = W3.r1(wb0.z(), wb0);
            if(serializable0 != null) {
                hashMap0.put(s, serializable0);
            }
        }
        return hashMap0;
    }

    public static String t1(wb wb0) {
        int v = wb0.b();
        int v1 = wb0.b;
        wb0.o(v);
        return new String(wb0.a, v1, v);
    }
}

