package G;

import E.a;
import androidx.collection.y;
import java.util.Arrays;
import je.n;
import kotlin.jvm.internal.q;

public final class O implements z {
    public final N a;

    public O(N n0) {
        this.a = n0;
    }

    @Override  // G.o
    public final A0 a(y0 y00) {
        return this.f(y00);
    }

    @Override  // G.z
    public final C0 a(y0 y00) {
        return this.f(y00);
    }

    public final G0 f(y0 y00) {
        Object[] arr_object2;
        int[] arr_v3;
        Object[] arr_object1;
        int[] arr_v2;
        N n0 = this.a;
        androidx.collection.z z0 = n0.b;
        y y0 = new y(z0.e + 2);
        androidx.collection.z z1 = new androidx.collection.z(z0.e);
        int[] arr_v = z0.b;
        Object[] arr_object = z0.c;
        long[] arr_v1 = z0.a;
        int v = arr_v1.length - 2;
        if(v >= 0) {
            int v1 = 0;
            while(true) {
                long v2 = arr_v1[v1];
                if((~v2 << 7 & v2 & 0x8080808080808080L) == 0x8080808080808080L) {
                    arr_v3 = arr_v;
                    arr_object2 = arr_object;
                    goto label_37;
                }
                int v3 = 8 - (~(v1 - v) >>> 0x1F);
                int v4 = 0;
                while(v4 < v3) {
                    if((v2 & 0xFFL) < 0x80L) {
                        int v5 = (v1 << 3) + v4;
                        int v6 = arr_v[v5];
                        M m0 = (M)arr_object[v5];
                        y0.a(v6);
                        arr_v2 = arr_v;
                        arr_object1 = arr_object;
                        z1.h(v6, new F0(((u)y00.a.invoke(m0.a)), m0.b));
                    }
                    else {
                        arr_v2 = arr_v;
                        arr_object1 = arr_object;
                    }
                    v2 >>= 8;
                    ++v4;
                    arr_v = arr_v2;
                    arr_object = arr_object1;
                }
                arr_v3 = arr_v;
                arr_object2 = arr_object;
                if(v3 == 8) {
                label_37:
                    if(v1 != v) {
                        ++v1;
                        arr_v = arr_v3;
                        arr_object = arr_object2;
                        continue;
                    }
                }
                goto label_42;
            }
        }
        else {
        label_42:
            if(!z0.a(0)) {
                int v7 = y0.b;
                if(v7 >= 0) {
                    y0.b(v7 + 1);
                    int[] arr_v4 = y0.a;
                    int v8 = y0.b;
                    if(v8 != 0) {
                        n.S(1, 0, v8, arr_v4, arr_v4);
                    }
                    arr_v4[0] = 0;
                    ++y0.b;
                    goto label_55;
                }
                a.d("Index must be between 0 and size");
                throw null;
            }
        }
    label_55:
        if(!z0.a(n0.a)) {
            y0.a(n0.a);
        }
        int v9 = y0.b;
        if(v9 != 0) {
            int[] arr_v5 = y0.a;
            q.g(arr_v5, "<this>");
            Arrays.sort(arr_v5, 0, v9);
        }
        return new G0(y0, z1, n0.a, C.d);
    }
}

