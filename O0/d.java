package o0;

import java.util.Map;
import kotlin.jvm.internal.r;
import we.n;

public final class d extends r implements n {
    public final int f;
    public static final d g;
    public static final d h;

    static {
        d.g = new d(2, 0);
        d.h = new d(2, 1);
    }

    public d(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.f != 0) {
            b b0 = (b)object0;
            return object1;
        }
        b b1 = (b)object0;
        Map map0 = ((f)object1).a;
        Object[] arr_object = ((f)object1).b.b;
        Object[] arr_object1 = ((f)object1).b.c;
        long[] arr_v = ((f)object1).b.a;
        int v = arr_v.length - 2;
        if(v >= 0) {
            int v1 = 0;
            while(true) {
                long v2 = arr_v[v1];
                if((~v2 << 7 & v2 & 0x8080808080808080L) == 0x8080808080808080L) {
                    goto label_28;
                }
                int v3 = 8 - (~(v1 - v) >>> 0x1F);
                for(int v4 = 0; v4 < v3; ++v4) {
                    if((0xFFL & v2) < 0x80L) {
                        int v5 = (v1 << 3) + v4;
                        Object object2 = arr_object[v5];
                        Map map1 = ((i)arr_object1[v5]).b();
                        if(map1.isEmpty()) {
                            map0.remove(object2);
                        }
                        else {
                            map0.put(object2, map1);
                        }
                    }
                    v2 >>= 8;
                }
                if(v3 == 8) {
                label_28:
                    if(v1 != v) {
                        ++v1;
                        continue;
                    }
                }
                goto label_31;
            }
        }
        else {
        label_31:
            if(map0.isEmpty()) {
                return null;
            }
        }
        return map0;
    }
}

