package i0;

import B6.f;
import androidx.compose.runtime.j0;
import androidx.fragment.app.p;
import e2.a;
import java.util.Arrays;
import java.util.ListIterator;
import je.n;
import kotlin.jvm.internal.q;

public final class d extends b {
    public final Object[] a;
    public final Object[] b;
    public final int c;
    public final int d;

    public d(Object[] arr_object, Object[] arr_object1, int v, int v1) {
        this.a = arr_object;
        this.b = arr_object1;
        this.c = v;
        this.d = v1;
        if(this.size() <= 0x20) {
            j0.a(("Trie-based persistent vector should have at least 33 elements, got " + this.size()));
        }
    }

    @Override  // i0.b
    public final b a(int v, Object object0) {
        a.t(v, this.size());
        if(v == this.size()) {
            return this.b(object0);
        }
        int v1 = this.u();
        Object[] arr_object = this.a;
        if(v >= v1) {
            return this.o(object0, arr_object, v - v1);
        }
        f f0 = new f(null);
        Object[] arr_object1 = d.l(arr_object, this.d, v, object0, f0);
        return this.o(f0.a, arr_object1, 0);
    }

    @Override  // i0.b
    public final b b(Object object0) {
        int v = this.size() - this.u();
        Object[] arr_object = this.a;
        Object[] arr_object1 = this.b;
        if(v < 0x20) {
            Object[] arr_object2 = Arrays.copyOf(arr_object1, 0x20);
            q.f(arr_object2, "copyOf(...)");
            arr_object2[v] = object0;
            return new d(arr_object, arr_object2, this.size() + 1, this.d);
        }
        Object[] arr_object3 = new Object[0x20];
        arr_object3[0] = object0;
        return this.q(arr_object, arr_object1, arr_object3);
    }

    @Override  // i0.b
    public final e e() {
        return new e(this, this.a, this.b, this.d);
    }

    @Override  // i0.b
    public final b g(p p0) {
        e e0 = new e(this, this.a, this.b, this.d);
        e0.G(p0);
        return e0.e();
    }

    @Override
    public final Object get(int v) {
        a.s(v, this.size());
        if(this.u() <= v) {
            return this.b[v & 0x1F];
        }
        Object[] arr_object = this.a;
        for(int v1 = this.d; v1 > 0; v1 -= 5) {
            Object object0 = arr_object[v >> v1 & 0x1F];
            q.e(object0, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            arr_object = (Object[])object0;
        }
        return arr_object[v & 0x1F];
    }

    @Override  // je.a
    public final int getSize() {
        return this.c;
    }

    @Override  // i0.b
    public final b i(int v) {
        a.s(v, this.size());
        int v1 = this.u();
        return v < v1 ? this.t(this.s(this.a, this.d, v, new f(this.b[0])), v1, this.d, 0) : this.t(this.a, v1, this.d, v - v1);
    }

    @Override  // i0.b
    public final b k(int v, Object object0) {
        a.s(v, this.size());
        Object[] arr_object = this.a;
        Object[] arr_object1 = this.b;
        int v1 = this.d;
        if(this.u() <= v) {
            Object[] arr_object2 = Arrays.copyOf(arr_object1, 0x20);
            q.f(arr_object2, "copyOf(...)");
            arr_object2[v & 0x1F] = object0;
            return new d(arr_object, arr_object2, this.size(), v1);
        }
        return new d(d.v(v1, v, object0, arr_object), arr_object1, this.size(), v1);
    }

    public static Object[] l(Object[] arr_object, int v, int v1, Object object0, f f0) {
        Object[] arr_object1;
        int v2 = v1 >> v & 0x1F;
        if(v == 0) {
            if(v2 == 0) {
                arr_object1 = new Object[0x20];
            }
            else {
                arr_object1 = Arrays.copyOf(arr_object, 0x20);
                q.f(arr_object1, "copyOf(...)");
            }
            n.W(arr_object, v2 + 1, arr_object1, v2, 0x1F);
            f0.a = arr_object[0x1F];
            arr_object1[v2] = object0;
            return arr_object1;
        }
        Object[] arr_object2 = Arrays.copyOf(arr_object, 0x20);
        q.f(arr_object2, "copyOf(...)");
        Object object1 = arr_object[v2];
        q.e(object1, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        arr_object2[v2] = d.l(((Object[])object1), v - 5, v1, object0, f0);
        while(true) {
            ++v2;
            if(v2 >= 0x20 || arr_object2[v2] == null) {
                break;
            }
            Object object2 = arr_object[v2];
            q.e(object2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            arr_object2[v2] = d.l(((Object[])object2), v - 5, 0, f0.a, f0);
        }
        return arr_object2;
    }

    @Override  // je.f
    public final ListIterator listIterator(int v) {
        a.t(v, this.size());
        return new i0.f(this.a, v, this.b, this.size(), this.d / 5 + 1);
    }

    public final d o(Object object0, Object[] arr_object, int v) {
        int v1 = this.size() - this.u();
        Object[] arr_object1 = this.b;
        Object[] arr_object2 = Arrays.copyOf(arr_object1, 0x20);
        q.f(arr_object2, "copyOf(...)");
        if(v1 < 0x20) {
            n.W(arr_object1, v + 1, arr_object2, v, v1);
            arr_object2[v] = object0;
            return new d(arr_object, arr_object2, this.size() + 1, this.d);
        }
        Object object1 = arr_object1[0x1F];
        n.W(arr_object1, v + 1, arr_object2, v, v1 - 1);
        arr_object2[v] = object0;
        Object[] arr_object3 = new Object[0x20];
        arr_object3[0] = object1;
        return this.q(arr_object, arr_object2, arr_object3);
    }

    public static Object[] p(Object[] arr_object, int v, int v1, f f0) {
        Object[] arr_object1;
        int v2 = v1 >> v & 0x1F;
        if(v == 5) {
            f0.a = arr_object[v2];
            arr_object1 = null;
        }
        else {
            Object object0 = arr_object[v2];
            q.e(object0, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            arr_object1 = d.p(((Object[])object0), v - 5, v1, f0);
        }
        if(arr_object1 == null && v2 == 0) {
            return null;
        }
        Object[] arr_object2 = Arrays.copyOf(arr_object, 0x20);
        q.f(arr_object2, "copyOf(...)");
        arr_object2[v2] = arr_object1;
        return arr_object2;
    }

    public final d q(Object[] arr_object, Object[] arr_object1, Object[] arr_object2) {
        int v = this.d;
        if(this.size() >> 5 > 1 << v) {
            Object[] arr_object3 = new Object[0x20];
            arr_object3[0] = arr_object;
            return new d(this.r(v + 5, arr_object3, arr_object1), arr_object2, this.size() + 1, v + 5);
        }
        return new d(this.r(v, arr_object, arr_object1), arr_object2, this.size() + 1, v);
    }

    public final Object[] r(int v, Object[] arr_object, Object[] arr_object1) {
        Object[] arr_object2;
        int v1 = this.size() - 1 >> v & 0x1F;
        if(arr_object == null) {
            arr_object2 = new Object[0x20];
        }
        else {
            arr_object2 = Arrays.copyOf(arr_object, 0x20);
            q.f(arr_object2, "copyOf(...)");
        }
        if(v == 5) {
            arr_object2[v1] = arr_object1;
            return arr_object2;
        }
        arr_object2[v1] = this.r(v - 5, ((Object[])arr_object2[v1]), arr_object1);
        return arr_object2;
    }

    public final Object[] s(Object[] arr_object, int v, int v1, f f0) {
        Object[] arr_object1;
        int v2 = v1 >> v & 0x1F;
        int v3 = 0x1F;
        if(v == 0) {
            if(v2 == 0) {
                arr_object1 = new Object[0x20];
            }
            else {
                arr_object1 = Arrays.copyOf(arr_object, 0x20);
                q.f(arr_object1, "copyOf(...)");
            }
            n.W(arr_object, v2, arr_object1, v2 + 1, 0x20);
            arr_object1[0x1F] = f0.a;
            f0.a = arr_object[v2];
            return arr_object1;
        }
        if(arr_object[0x1F] == null) {
            v3 = this.u() - 1 >> v & 0x1F;
        }
        Object[] arr_object2 = Arrays.copyOf(arr_object, 0x20);
        q.f(arr_object2, "copyOf(...)");
        if(v2 + 1 <= v3) {
            while(true) {
                Object object0 = arr_object2[v3];
                q.e(object0, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                arr_object2[v3] = this.s(((Object[])object0), v - 5, 0, f0);
                if(v3 == v2 + 1) {
                    break;
                }
                --v3;
            }
        }
        Object object1 = arr_object2[v2];
        q.e(object1, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        arr_object2[v2] = this.s(((Object[])object1), v - 5, v1, f0);
        return arr_object2;
    }

    public final b t(Object[] arr_object, int v, int v1, int v2) {
        int v3 = this.size() - v;
        if(v3 == 1) {
            if(v1 == 0) {
                if(arr_object.length == 33) {
                    arr_object = Arrays.copyOf(arr_object, 0x20);
                    q.f(arr_object, "copyOf(...)");
                }
                return new h(arr_object);
            }
            f f0 = new f(null);
            Object[] arr_object1 = d.p(arr_object, v1, v - 1, f0);
            q.d(arr_object1);
            Object object0 = f0.a;
            q.e(object0, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            if(arr_object1[1] == null) {
                Object object1 = arr_object1[0];
                q.e(object1, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                return new d(((Object[])object1), ((Object[])object0), v, v1 - 5);
            }
            return new d(arr_object1, ((Object[])object0), v, v1);
        }
        Object[] arr_object2 = this.b;
        Object[] arr_object3 = Arrays.copyOf(arr_object2, 0x20);
        q.f(arr_object3, "copyOf(...)");
        if(v2 < v3 - 1) {
            n.W(arr_object2, v2, arr_object3, v2 + 1, v3);
        }
        arr_object3[v3 - 1] = null;
        return new d(arr_object, arr_object3, v + v3 - 1, v1);
    }

    public final int u() {
        return this.size() - 1 & 0xFFFFFFE0;
    }

    public static Object[] v(int v, int v1, Object object0, Object[] arr_object) {
        int v2 = v1 >> v & 0x1F;
        Object[] arr_object1 = Arrays.copyOf(arr_object, 0x20);
        q.f(arr_object1, "copyOf(...)");
        if(v == 0) {
            arr_object1[v2] = object0;
            return arr_object1;
        }
        Object object1 = arr_object1[v2];
        q.e(object1, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        arr_object1[v2] = d.v(v - 5, v1, object0, ((Object[])object1));
        return arr_object1;
    }
}

