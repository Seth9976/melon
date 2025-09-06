package g0;

import e.k;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.jvm.internal.q;

public final class e implements RandomAccess {
    public Object[] a;
    public b b;
    public int c;

    public e(Object[] arr_object) {
        this.a = arr_object;
        this.c = 0;
    }

    public final void a(int v, Object object0) {
        int v1 = this.c + 1;
        if(this.a.length < v1) {
            this.m(v1);
        }
        Object[] arr_object = this.a;
        int v2 = this.c;
        if(v != v2) {
            System.arraycopy(arr_object, v, arr_object, v + 1, v2 - v);
        }
        arr_object[v] = object0;
        ++this.c;
    }

    public final void b(Object object0) {
        int v = this.c + 1;
        if(this.a.length < v) {
            this.m(v);
        }
        int v1 = this.c;
        this.a[v1] = object0;
        this.c = v1 + 1;
    }

    public final void c(int v, e e0) {
        int v1 = e0.c;
        if(v1 == 0) {
            return;
        }
        int v2 = this.c + v1;
        if(this.a.length < v2) {
            this.m(v2);
        }
        Object[] arr_object = this.a;
        int v3 = this.c;
        if(v != v3) {
            System.arraycopy(arr_object, v, arr_object, v + v1, v3 - v);
        }
        System.arraycopy(e0.a, 0, arr_object, v, v1);
        this.c += v1;
    }

    public final void d(int v, List list0) {
        if(list0.isEmpty()) {
            return;
        }
        int v1 = list0.size();
        int v2 = this.c + v1;
        if(this.a.length < v2) {
            this.m(v2);
        }
        Object[] arr_object = this.a;
        int v3 = this.c;
        if(v != v3) {
            System.arraycopy(arr_object, v, arr_object, v + v1, v3 - v);
        }
        int v4 = list0.size();
        for(int v5 = 0; v5 < v4; ++v5) {
            arr_object[v + v5] = list0.get(v5);
        }
        this.c += v1;
    }

    public final boolean e(int v, Collection collection0) {
        int v1 = 0;
        if(collection0.isEmpty()) {
            return false;
        }
        int v2 = collection0.size();
        int v3 = this.c + v2;
        if(this.a.length < v3) {
            this.m(v3);
        }
        Object[] arr_object = this.a;
        int v4 = this.c;
        if(v != v4) {
            System.arraycopy(arr_object, v, arr_object, v + v2, v4 - v);
        }
        for(Object object0: collection0) {
            if(v1 >= 0) {
                arr_object[v1 + v] = object0;
                ++v1;
                continue;
            }
            k.O();
            throw null;
        }
        this.c += v2;
        return true;
    }

    public final List f() {
        b b0 = this.b;
        if(b0 == null) {
            b0 = new b(this);
            this.b = b0;
        }
        return b0;
    }

    public final void g() {
        Object[] arr_object = this.a;
        int v = this.c;
        for(int v1 = 0; v1 < v; ++v1) {
            arr_object[v1] = null;
        }
        this.c = 0;
    }

    public final boolean h(Object object0) {
        int v = this.c - 1;
        if(v >= 0) {
            for(int v1 = 0; true; ++v1) {
                if(q.b(this.a[v1], object0)) {
                    return true;
                }
                if(v1 == v) {
                    break;
                }
            }
        }
        return false;
    }

    public final int i(Object object0) {
        Object[] arr_object = this.a;
        int v = this.c;
        for(int v1 = 0; v1 < v; ++v1) {
            if(q.b(object0, arr_object[v1])) {
                return v1;
            }
        }
        return -1;
    }

    public final boolean j(Object object0) {
        int v = this.i(object0);
        if(v >= 0) {
            this.k(v);
            return true;
        }
        return false;
    }

    public final Object k(int v) {
        Object[] arr_object = this.a;
        Object object0 = arr_object[v];
        int v1 = this.c;
        if(v != v1 - 1) {
            System.arraycopy(arr_object, v + 1, arr_object, v, v1 - (v + 1));
        }
        int v2 = this.c - 1;
        this.c = v2;
        arr_object[v2] = null;
        return object0;
    }

    public final void l(int v, int v1) {
        if(v1 > v) {
            int v2 = this.c;
            if(v1 < v2) {
                System.arraycopy(this.a, v1, this.a, v, v2 - v1);
            }
            int v3 = this.c - (v1 - v);
            int v4 = this.c - 1;
            if(v3 <= v4) {
                for(int v5 = v3; true; ++v5) {
                    this.a[v5] = null;
                    if(v5 == v4) {
                        break;
                    }
                }
            }
            this.c = v3;
        }
    }

    public final void m(int v) {
        Object[] arr_object = this.a;
        Object[] arr_object1 = new Object[Math.max(v, arr_object.length * 2)];
        System.arraycopy(arr_object, 0, arr_object1, 0, arr_object.length);
        this.a = arr_object1;
    }

    public final void o(Comparator comparator0) {
        Arrays.sort(this.a, 0, this.c, comparator0);
    }
}

