package ke;

import e1.u;
import j0.g;
import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.q;
import xe.d;

public final class e implements Serializable, Map, d {
    public Object[] a;
    public Object[] b;
    public int[] c;
    public int[] d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public f j;
    public g k;
    public f l;
    public boolean m;
    public static final e n;

    static {
        e e0 = new e(0);
        e0.m = true;
        e.n = e0;
    }

    public e() {
        this(8);
    }

    public e(int v) {
        if(v < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        Object[] arr_object = new Object[v];
        int[] arr_v = new int[v];
        if(v < 1) {
            v = 1;
        }
        int v1 = Integer.highestOneBit(v * 3);
        super();
        this.a = arr_object;
        this.b = null;
        this.c = arr_v;
        this.d = new int[v1];
        this.e = 2;
        this.f = 0;
        this.g = Integer.numberOfLeadingZeros(v1) + 1;
    }

    public final int a(Object object0) {
        int v;
        this.d();
        while(true) {
            v = this.l(object0);
            int v1 = this.e * 2;
            int v2 = this.d.length / 2;
            if(v1 > v2) {
                v1 = v2;
            }
            int v3 = 0;
        label_7:
            int[] arr_v = this.d;
            int v4 = arr_v[v];
            if(v4 <= 0) {
                int v5 = this.f;
                Object[] arr_object = this.a;
                if(v5 >= arr_object.length) {
                    this.i(1);
                    continue;
                }
                this.f = v5 + 1;
                arr_object[v5] = object0;
                this.c[v5] = v;
                arr_v[v] = v5 + 1;
                ++this.i;
                ++this.h;
                if(v3 > this.e) {
                    this.e = v3;
                }
                return v5;
            }
            if(q.b(this.a[v4 - 1], object0)) {
                return -v4;
            }
            ++v3;
            if(v3 <= v1) {
                break;
            }
            this.m(this.d.length * 2);
        }
        if(v != 0) {
            --v;
            goto label_7;
        }
        v = this.d.length - 1;
        goto label_7;
    }

    public final e b() {
        this.d();
        this.m = true;
        if(this.i > 0) {
            return this;
        }
        q.e(e.n, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return e.n;
    }

    @Override
    public final void clear() {
        this.d();
        int v = this.f - 1;
        if(v >= 0) {
            for(int v1 = 0; true; ++v1) {
                int[] arr_v = this.c;
                int v2 = arr_v[v1];
                if(v2 >= 0) {
                    this.d[v2] = 0;
                    arr_v[v1] = -1;
                }
                if(v1 == v) {
                    break;
                }
            }
        }
        u.R(this.a, 0, this.f);
        Object[] arr_object = this.b;
        if(arr_object != null) {
            u.R(arr_object, 0, this.f);
        }
        this.i = 0;
        this.f = 0;
        ++this.h;
    }

    @Override
    public final boolean containsKey(Object object0) {
        return this.j(object0) >= 0;
    }

    @Override
    public final boolean containsValue(Object object0) {
        return this.k(object0) >= 0;
    }

    public final void d() {
        if(this.m) {
            throw new UnsupportedOperationException();
        }
    }

    public final void e(boolean z) {
        int v2;
        Object[] arr_object = this.b;
        int v1 = 0;
        for(int v = 0; true; ++v) {
            v2 = this.f;
            if(v >= v2) {
                break;
            }
            int[] arr_v = this.c;
            int v3 = arr_v[v];
            if(v3 >= 0) {
                this.a[v1] = this.a[v];
                if(arr_object != null) {
                    arr_object[v1] = arr_object[v];
                }
                if(z) {
                    arr_v[v1] = v3;
                    this.d[v3] = v1 + 1;
                }
                ++v1;
            }
        }
        u.R(this.a, v1, v2);
        if(arr_object != null) {
            u.R(arr_object, v1, this.f);
        }
        this.f = v1;
    }

    @Override
    public final Set entrySet() {
        f f0 = this.l;
        if(f0 == null) {
            f0 = new f(this, 0);
            this.l = f0;
        }
        return f0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 == this || object0 instanceof Map && this.i == ((Map)object0).size() && this.g(((Map)object0).entrySet());
    }

    public final boolean g(Collection collection0) {
        q.g(collection0, "m");
        for(Object object0: collection0) {
            if(object0 != null) {
                try {
                    if(!this.h(((Map.Entry)object0))) {
                        return false;
                    }
                    continue;
                }
                catch(ClassCastException unused_ex) {
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public final Object get(Object object0) {
        int v = this.j(object0);
        if(v < 0) {
            return null;
        }
        Object[] arr_object = this.b;
        q.d(arr_object);
        return arr_object[v];
    }

    public final boolean h(Map.Entry map$Entry0) {
        q.g(map$Entry0, "entry");
        int v = this.j(map$Entry0.getKey());
        if(v < 0) {
            return false;
        }
        Object[] arr_object = this.b;
        q.d(arr_object);
        return q.b(arr_object[v], map$Entry0.getValue());
    }

    @Override
    public final int hashCode() {
        int v = 0;
        c c0 = new c(this, 0);
        while(c0.hasNext()) {
            int v1 = c0.a;
            e e0 = (e)c0.d;
            if(v1 >= e0.f) {
                throw new NoSuchElementException();
            }
            c0.a = v1 + 1;
            c0.b = v1;
            Object object0 = e0.a[v1];
            Object[] arr_object = e0.b;
            q.d(arr_object);
            Object object1 = arr_object[c0.b];
            c0.g();
            v += (object0 == null ? 0 : object0.hashCode()) ^ (object1 == null ? 0 : object1.hashCode());
        }
        return v;
    }

    public final void i(int v) {
        Object[] arr_object4;
        Object[] arr_object = this.a;
        int v1 = this.f;
        int v2 = arr_object.length - v1;
        int v3 = v1 - this.i;
        int v4 = 1;
        if(v2 < v && v2 + v3 >= v && v3 >= arr_object.length / 4) {
            this.e(true);
            return;
        }
        int v5 = v1 + v;
        if(v5 < 0) {
            throw new OutOfMemoryError();
        }
        if(v5 > arr_object.length) {
            je.f.Companion.getClass();
            int v6 = je.c.e(arr_object.length, v5);
            Object[] arr_object1 = this.a;
            q.g(arr_object1, "<this>");
            Object[] arr_object2 = Arrays.copyOf(arr_object1, v6);
            q.f(arr_object2, "copyOf(...)");
            this.a = arr_object2;
            Object[] arr_object3 = this.b;
            if(arr_object3 == null) {
                arr_object4 = null;
            }
            else {
                arr_object4 = Arrays.copyOf(arr_object3, v6);
                q.f(arr_object4, "copyOf(...)");
            }
            this.b = arr_object4;
            int[] arr_v = Arrays.copyOf(this.c, v6);
            q.f(arr_v, "copyOf(...)");
            this.c = arr_v;
            if(v6 >= 1) {
                v4 = v6;
            }
            int v7 = Integer.highestOneBit(v4 * 3);
            if(v7 > this.d.length) {
                this.m(v7);
            }
        }
    }

    @Override
    public final boolean isEmpty() {
        return this.i == 0;
    }

    public final int j(Object object0) {
        int v = this.l(object0);
        int v1 = this.e;
        while(true) {
            int v2 = this.d[v];
            if(v2 == 0) {
                return -1;
            }
            if(v2 > 0 && q.b(this.a[v2 - 1], object0)) {
                return v2 - 1;
            }
            --v1;
            if(v1 < 0) {
                return -1;
            }
            if(v == 0) {
                v = this.d.length - 1;
            }
            else {
                --v;
            }
        }
    }

    public final int k(Object object0) {
        int v = this.f;
    alab1:
        while(true) {
            do {
                --v;
                if(v < 0) {
                    break alab1;
                }
                if(this.c[v] < 0) {
                    continue alab1;
                }
                Object[] arr_object = this.b;
                q.d(arr_object);
            }
            while(!q.b(arr_object[v], object0));
            return v;
        }
        return -1;
    }

    @Override
    public final Set keySet() {
        f f0 = this.j;
        if(f0 == null) {
            f0 = new f(this, 1);
            this.j = f0;
        }
        return f0;
    }

    public final int l(Object object0) {
        return object0 == null ? 0 : object0.hashCode() * -1640531527 >>> this.g;
    }

    public final void m(int v) {
        ++this.h;
        int v1 = 0;
        if(this.f > this.i) {
            this.e(false);
        }
        this.d = new int[v];
        this.g = Integer.numberOfLeadingZeros(v) + 1;
        while(v1 < this.f) {
            int v2 = this.l(this.a[v1]);
            int v3 = this.e;
        label_9:
            int[] arr_v = this.d;
            if(arr_v[v2] == 0) {
                arr_v[v2] = v1 + 1;
                this.c[v1] = v2;
                ++v1;
                continue;
            }
            --v3;
            if(v3 < 0) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            if(v2 == 0) {
                v2 = arr_v.length - 1;
            }
            else {
                --v2;
            }
            goto label_9;
        }
    }

    public final void n(int v) {
        Object[] arr_object = this.a;
        q.g(arr_object, "<this>");
        arr_object[v] = null;
        Object[] arr_object1 = this.b;
        if(arr_object1 != null) {
            arr_object1[v] = null;
        }
        int v1 = this.c[v];
        int v2 = this.e * 2;
        int v3 = this.d.length / 2;
        if(v2 > v3) {
            v2 = v3;
        }
        int v4 = v2;
        int v5 = 0;
        int v6 = v1;
        while(true) {
            v1 = v1 == 0 ? this.d.length - 1 : v1 - 1;
            ++v5;
            if(v5 > this.e) {
                this.d[v6] = 0;
                break;
            }
            int[] arr_v = this.d;
            int v7 = arr_v[v1];
            if(v7 == 0) {
                arr_v[v6] = 0;
                break;
            }
            if(v7 < 0) {
                arr_v[v6] = -1;
                v6 = v1;
                v5 = 0;
            }
            else {
                int[] arr_v1 = this.d;
                if((this.l(this.a[v7 - 1]) - v1 & arr_v1.length - 1) >= v5) {
                    arr_v1[v6] = v7;
                    this.c[v7 - 1] = v6;
                    v6 = v1;
                    v5 = 0;
                }
            }
            --v4;
            if(v4 < 0) {
                this.d[v6] = -1;
                break;
            }
        }
        this.c[v] = -1;
        --this.i;
        ++this.h;
    }

    @Override
    public final Object put(Object object0, Object object1) {
        this.d();
        int v = this.a(object0);
        Object[] arr_object = this.b;
        if(arr_object == null) {
            int v1 = this.a.length;
            if(v1 < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            arr_object = new Object[v1];
            this.b = arr_object;
        }
        if(v < 0) {
            Object object2 = arr_object[-v - 1];
            arr_object[-v - 1] = object1;
            return object2;
        }
        arr_object[v] = object1;
        return null;
    }

    @Override
    public final void putAll(Map map0) {
        q.g(map0, "from");
        this.d();
        Collection collection0 = map0.entrySet();
        if(!collection0.isEmpty()) {
            this.i(collection0.size());
            for(Object object0: collection0) {
                Map.Entry map$Entry0 = (Map.Entry)object0;
                int v = this.a(map$Entry0.getKey());
                Object[] arr_object = this.b;
                if(arr_object == null) {
                    int v1 = this.a.length;
                    if(v1 < 0) {
                        throw new IllegalArgumentException("capacity must be non-negative.");
                    }
                    arr_object = new Object[v1];
                    this.b = arr_object;
                }
                if(v >= 0) {
                    arr_object[v] = map$Entry0.getValue();
                }
                else {
                    Object object1 = arr_object[-v - 1];
                    if(!q.b(map$Entry0.getValue(), object1)) {
                        arr_object[-v - 1] = map$Entry0.getValue();
                    }
                }
            }
        }
    }

    private final void readObject(ObjectInputStream objectInputStream0) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    @Override
    public final Object remove(Object object0) {
        this.d();
        int v = this.j(object0);
        if(v < 0) {
            return null;
        }
        Object[] arr_object = this.b;
        q.d(arr_object);
        Object object1 = arr_object[v];
        this.n(v);
        return object1;
    }

    @Override
    public final int size() {
        return this.i;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(this.i * 3 + 2);
        stringBuilder0.append("{");
        c c0 = new c(this, 0);
        for(int v = 0; c0.hasNext(); ++v) {
            if(v > 0) {
                stringBuilder0.append(", ");
            }
            int v1 = c0.a;
            e e0 = (e)c0.d;
            if(v1 >= e0.f) {
                throw new NoSuchElementException();
            }
            c0.a = v1 + 1;
            c0.b = v1;
            Object object0 = e0.a[v1];
            if(object0 == e0) {
                stringBuilder0.append("(this Map)");
            }
            else {
                stringBuilder0.append(object0);
            }
            stringBuilder0.append('=');
            Object[] arr_object = e0.b;
            q.d(arr_object);
            Object object1 = arr_object[c0.b];
            if(object1 == e0) {
                stringBuilder0.append("(this Map)");
            }
            else {
                stringBuilder0.append(object1);
            }
            c0.g();
        }
        stringBuilder0.append("}");
        String s = stringBuilder0.toString();
        q.f(s, "toString(...)");
        return s;
    }

    @Override
    public final Collection values() {
        g g0 = this.k;
        if(g0 == null) {
            g0 = new g(this, 1);
            this.k = g0;
        }
        return g0;
    }

    private final Object writeReplace() {
        if(!this.m) {
            throw new NotSerializableException("The map cannot be serialized while it is being built.");
        }
        h h0 = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        h0.a = this;
        return h0;
    }
}

