package b2;

import i.n.i.b.a.s.e.Ja;
import i.n.i.b.a.s.e.K5;
import i.n.i.b.a.s.e.M7;
import i.n.i.b.a.s.e.Qb;
import i.n.i.b.a.s.e.c9;
import java.util.Arrays;
import kotlin.jvm.internal.q;
import y1.b;

public class e implements d {
    public Object[] a;
    public int b;

    public e() {
        this.a = new Object[0x100];
    }

    public e(int v, int v1) {
        if(v1 != 1) {
            super();
            if(v <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.a = new Object[v];
            return;
        }
        super();
        this.a = new Object[v * 2];
        this.b = 0;
    }

    public K5 a() {
        int v = 0;
        int v1 = this.b;
        Object[] arr_object = this.a;
        if(v1 == 0) {
            return K5.g;
        }
        if(v1 == 1) {
            Ja.A(arr_object[0], arr_object[1]);
            return new K5(null, arr_object, 1);
        }
        M7.E(v1, arr_object.length >> 1);
        int v2 = Qb.k(v1);
        int[] arr_v = new int[v2];
        Arrays.fill(arr_v, -1);
        while(v < v1) {
            Object object0 = arr_object[v * 2];
            Object object1 = arr_object[v * 2 + 1];
            Ja.A(object0, object1);
            int v3 = Ja.L(object0.hashCode());
        label_17:
            int v4 = v3 & v2 - 1;
            int v5 = arr_v[v4];
            if(v5 == -1) {
                arr_v[v4] = v * 2;
                ++v;
                continue;
            }
            if(arr_object[v5].equals(object0)) {
                throw new IllegalArgumentException("Multiple entries with same key: " + object0 + "=" + object1 + " and " + arr_object[v5] + "=" + arr_object[1 ^ v5]);
            }
            v3 = v4 + 1;
            goto label_17;
        }
        return new K5(arr_v, arr_object, v1);
    }

    @Override  // b2.d
    public Object acquire() {
        Object[] arr_object = this.a;
        int v = this.b;
        if(v > 0) {
            Object object0 = arr_object[v - 1];
            q.e(object0, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
            arr_object[v - 1] = null;
            --this.b;
            return object0;
        }
        return null;
    }

    public void b(Object object0, Object object1) {
        int v = (this.b + 1) * 2;
        Object[] arr_object = this.a;
        if(v > arr_object.length) {
            this.a = Arrays.copyOf(arr_object, c9.a(arr_object.length, v));
        }
        Ja.A(object0, object1);
        Object[] arr_object1 = this.a;
        int v1 = this.b;
        arr_object1[v1 * 2] = object0;
        arr_object1[v1 * 2 + 1] = object1;
        this.b = v1 + 1;
    }

    public void c(b b0) {
        int v = this.b;
        Object[] arr_object = this.a;
        if(v < arr_object.length) {
            arr_object[v] = b0;
            this.b = v + 1;
        }
    }

    @Override  // b2.d
    public boolean release(Object object0) {
        Object[] arr_object = this.a;
        q.g(object0, "instance");
        int v = this.b;
        for(int v1 = 0; true; ++v1) {
            boolean z = false;
            if(v1 >= v) {
                break;
            }
            if(arr_object[v1] == object0) {
                z = true;
                break;
            }
        }
        if(z) {
            throw new IllegalStateException("Already in the pool!");
        }
        int v2 = this.b;
        if(v2 < arr_object.length) {
            arr_object[v2] = object0;
            this.b = v2 + 1;
            return true;
        }
        return false;
    }
}

