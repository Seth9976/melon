package j0;

import Ce.e;
import P4.a;
import androidx.compose.runtime.j0;
import de.c;
import java.util.Arrays;
import je.n;
import kotlin.jvm.internal.q;
import l0.b;
import m0.f;

public final class j {
    public int a;
    public int b;
    public final b c;
    public Object[] d;
    public static final j e;

    static {
        j.e = new j(0, 0, new Object[0], null);
    }

    public j(int v, int v1, Object[] arr_object, b b0) {
        this.a = v;
        this.b = v1;
        this.c = b0;
        this.d = arr_object;
    }

    public final Object[] a(int v, int v1, int v2, Object object0, Object object1, int v3, b b0) {
        Object object2 = this.d[v];
        j j0 = j.j((object2 == null ? 0 : object2.hashCode()), object2, this.x(v), v2, object0, object1, v3 + 5, b0);
        int v4 = this.t(v1);
        Object[] arr_object = this.d;
        Object[] arr_object1 = new Object[arr_object.length - 1];
        n.Y(arr_object, 0, arr_object1, v, 6);
        n.W(arr_object, v, arr_object1, v + 2, v4 + 1);
        arr_object1[v4 - 1] = j0;
        n.W(arr_object, v4, arr_object1, v4 + 1, arr_object.length);
        return arr_object1;
    }

    public final int b() {
        if(this.b == 0) {
            return this.d.length / 2;
        }
        int v = Integer.bitCount(this.a);
        for(int v1 = v * 2; v1 < this.d.length; ++v1) {
            v += this.s(v1).b();
        }
        return v;
    }

    public final boolean c(Object object0) {
        e e0 = a.C(a.K(0, this.d.length), 2);
        int v = e0.a;
        int v1 = e0.b;
        int v2 = e0.c;
        if(v2 > 0 && v <= v1 || v2 < 0 && v1 <= v) {
            while(true) {
                if(q.b(object0, this.d[v])) {
                    return true;
                }
                if(v == v1) {
                    break;
                }
                v += v2;
            }
        }
        return false;
    }

    public final boolean d(int v, int v1, Object object0) {
        int v2 = v >> v1 & 0x1F;
        if(this.h(1 << v2)) {
            return q.b(object0, this.d[this.f(1 << v2)]);
        }
        if(this.i(1 << v2)) {
            j j0 = this.s(this.t(1 << v2));
            return v1 == 30 ? j0.c(object0) : j0.d(v, v1 + 5, object0);
        }
        return false;
    }

    public final boolean e(j j0) {
        if(this != j0) {
            if(this.b == j0.b && this.a == j0.a) {
                for(int v = 0; v < this.d.length; ++v) {
                    if(this.d[v] != j0.d[v]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int f(int v) {
        return Integer.bitCount(v - 1 & this.a) * 2;
    }

    public final Object g(int v, int v1, Object object0) {
        int v2 = v >> v1 & 0x1F;
        if(this.h(1 << v2)) {
            int v3 = this.f(1 << v2);
            return q.b(object0, this.d[v3]) ? this.x(v3) : null;
        }
        if(this.i(1 << v2)) {
            j j0 = this.s(this.t(1 << v2));
            if(v1 != 30) {
                return j0.g(v, v1 + 5, object0);
            }
            e e0 = a.C(a.K(0, j0.d.length), 2);
            int v4 = e0.a;
            int v5 = e0.b;
            int v6 = e0.c;
            if(v6 > 0 && v4 <= v5 || v6 < 0 && v5 <= v4) {
                while(true) {
                    if(q.b(object0, j0.d[v4])) {
                        return j0.x(v4);
                    }
                    if(v4 == v5) {
                        return null;
                    }
                    v4 += v6;
                }
                return j0.g(v, v1 + 5, object0);
            }
        }
        return null;
    }

    public final boolean h(int v) {
        return (v & this.a) != 0;
    }

    public final boolean i(int v) {
        return (v & this.b) != 0;
    }

    public static j j(int v, Object object0, Object object1, int v1, Object object2, Object object3, int v2, b b0) {
        if(v2 > 30) {
            return new j(0, 0, new Object[]{object0, object1, object2, object3}, b0);
        }
        int v3 = v >> v2 & 0x1F;
        int v4 = v1 >> v2 & 0x1F;
        if(v3 != v4) {
            return v3 >= v4 ? new j(1 << v3 | 1 << v4, 0, new Object[]{object2, object3, object0, object1}, b0) : new j(1 << v3 | 1 << v4, 0, new Object[]{object0, object1, object2, object3}, b0);
        }
        return new j(0, 1 << v3, new Object[]{j.j(v, object0, object1, v1, object2, object3, v2 + 5, b0)}, b0);
    }

    public final j k(int v, f f0) {
        f0.g(f0.size() - 1);
        f0.c = this.x(v);
        Object[] arr_object = this.d;
        if(arr_object.length == 2) {
            return null;
        }
        if(this.c == f0.a) {
            this.d = c.j(v, arr_object);
            return this;
        }
        return new j(0, 0, c.j(v, arr_object), f0.a);
    }

    public final j l(int v, Object object0, Object object1, int v1, f f0) {
        j j1;
        int v2 = v >> v1 & 0x1F;
        b b0 = this.c;
        if(this.h(1 << v2)) {
            int v3 = this.f(1 << v2);
            if(q.b(object0, this.d[v3])) {
                f0.c = this.x(v3);
                if(this.x(v3) != object1) {
                    if(b0 == f0.a) {
                        this.d[v3 + 1] = object1;
                        return this;
                    }
                    ++f0.d;
                    Object[] arr_object = Arrays.copyOf(this.d, this.d.length);
                    q.f(arr_object, "copyOf(...)");
                    arr_object[v3 + 1] = object1;
                    return new j(this.a, this.b, arr_object, f0.a);
                }
                return this;
            }
            f0.g(f0.size() + 1);
            b b1 = f0.a;
            if(b0 == b1) {
                this.d = this.a(v3, 1 << v2, v, object0, object1, v1, b1);
                this.a ^= 1 << v2;
                this.b |= 1 << v2;
                return this;
            }
            Object[] arr_object1 = this.a(v3, 1 << v2, v, object0, object1, v1, b1);
            return new j(this.a ^ 1 << v2, this.b | 1 << v2, arr_object1, b1);
        }
        if(this.i(1 << v2)) {
            int v4 = this.t(1 << v2);
            j j0 = this.s(v4);
            if(v1 == 30) {
                e e0 = a.C(a.K(0, j0.d.length), 2);
                int v5 = e0.a;
                int v6 = e0.b;
                int v7 = e0.c;
                if(v7 > 0 && v5 <= v6 || v7 < 0 && v6 <= v5) {
                    while(true) {
                        if(q.b(object0, j0.d[v5])) {
                            f0.c = j0.x(v5);
                            if(j0.c == f0.a) {
                                j0.d[v5 + 1] = object1;
                                return this;
                            }
                            ++f0.d;
                            Object[] arr_object2 = Arrays.copyOf(j0.d, j0.d.length);
                            q.f(arr_object2, "copyOf(...)");
                            arr_object2[v5 + 1] = object1;
                            j1 = new j(0, 0, arr_object2, f0.a);
                            return j0 == j1 ? this : this.r(v4, j1, f0.a);
                        }
                        if(v5 == v6) {
                            break;
                        }
                        v5 += v7;
                    }
                }
                f0.g(f0.size() + 1);
                j1 = new j(0, 0, c.i(0, object0, object1, j0.d), f0.a);
                return j0 == j1 ? this : this.r(v4, j1, f0.a);
            }
            j1 = j0.l(v, object0, object1, v1 + 5, f0);
            return j0 == j1 ? this : this.r(v4, j1, f0.a);
        }
        f0.g(f0.size() + 1);
        b b2 = f0.a;
        int v8 = this.f(1 << v2);
        if(b0 == b2) {
            this.d = c.i(v8, object0, object1, this.d);
            this.a |= 1 << v2;
            return this;
        }
        Object[] arr_object3 = c.i(v8, object0, object1, this.d);
        return new j(this.a | 1 << v2, this.b, arr_object3, b2);
    }

    public final j m(j j0, int v, l0.a a0, f f0) {
        Object[] arr_object4;
        j j2;
        if(this == j0) {
            int v1 = this.b();
            a0.a += v1;
            return this;
        }
        if(v > 30) {
            b b0 = f0.a;
            Object[] arr_object = Arrays.copyOf(this.d, this.d.length + j0.d.length);
            q.f(arr_object, "copyOf(...)");
            int v2 = this.d.length;
            e e0 = a.C(a.K(0, j0.d.length), 2);
            int v3 = e0.a;
            int v4 = e0.b;
            int v5 = e0.c;
            if(v5 > 0 && v3 <= v4 || v5 < 0 && v4 <= v3) {
                while(true) {
                    if(this.c(j0.d[v3])) {
                        ++a0.a;
                    }
                    else {
                        Object[] arr_object1 = j0.d;
                        arr_object[v2] = arr_object1[v3];
                        arr_object[v2 + 1] = arr_object1[v3 + 1];
                        v2 += 2;
                    }
                    if(v3 == v4) {
                        break;
                    }
                    v3 += v5;
                }
            }
            if(v2 == this.d.length) {
                return this;
            }
            if(v2 == j0.d.length) {
                return j0;
            }
            if(v2 == arr_object.length) {
                return new j(0, 0, arr_object, b0);
            }
            Object[] arr_object2 = Arrays.copyOf(arr_object, v2);
            q.f(arr_object2, "copyOf(...)");
            return new j(0, 0, arr_object2, b0);
        }
        int v6 = this.b | j0.b;
        int v7 = this.a & j0.a;
        int v8 = (this.a ^ j0.a) & ~v6;
        while(v7 != 0) {
            int v9 = Integer.lowestOneBit(v7);
            if(q.b(this.d[this.f(v9)], j0.d[j0.f(v9)])) {
                v8 |= v9;
            }
            else {
                v6 |= v9;
            }
            v7 ^= v9;
        }
        if((v6 & v8) != 0) {
            j0.b("Check failed.");
        }
        j j1 = !q.b(this.c, f0.a) || this.a != v8 || this.b != v6 ? new j(v8, v6, new Object[Integer.bitCount(v6) + Integer.bitCount(v8) * 2], null) : this;
        int v10 = v6;
        int v11 = 0;
        while(v10 != 0) {
            int v12 = Integer.lowestOneBit(v10);
            Object[] arr_object3 = j1.d;
            int v13 = arr_object3.length - 1 - v11;
            if(this.i(v12)) {
                j2 = this.s(this.t(v12));
                if(j0.i(v12)) {
                    j2 = j2.m(j0.s(j0.t(v12)), v + 5, a0, f0);
                    arr_object4 = arr_object3;
                }
                else if(j0.h(v12)) {
                    int v14 = j0.f(v12);
                    Object object0 = j0.d[v14];
                    arr_object4 = arr_object3;
                    j2 = j2.l((object0 == null ? 0 : object0.hashCode()), object0, j0.x(v14), v + 5, f0);
                    ++a0.a;
                }
                else {
                    arr_object4 = arr_object3;
                }
            }
            else {
                arr_object4 = arr_object3;
                if(j0.i(v12)) {
                    j j3 = j0.s(j0.t(v12));
                    if(this.h(v12)) {
                        int v15 = this.f(v12);
                        Object object1 = this.d[v15];
                        if(j3.d((object1 == null ? 0 : object1.hashCode()), v + 5, object1)) {
                            ++a0.a;
                        }
                        else {
                            j2 = j3.l((object1 == null ? 0 : object1.hashCode()), object1, this.x(v15), v + 5, f0);
                            goto label_86;
                        }
                    }
                    j2 = j3;
                }
                else {
                    int v16 = this.f(v12);
                    Object object2 = this.d[v16];
                    Object object3 = this.x(v16);
                    int v17 = j0.f(v12);
                    Object object4 = j0.d[v17];
                    j2 = j.j((object2 == null ? 0 : object2.hashCode()), object2, object3, (object4 == null ? 0 : object4.hashCode()), object4, j0.x(v17), v + 5, f0.a);
                }
            }
        label_86:
            arr_object4[v13] = j2;
            ++v11;
            v10 ^= v12;
        }
        int v18 = 0;
        while(v8 != 0) {
            int v19 = Integer.lowestOneBit(v8);
            if(j0.h(v19)) {
                int v21 = j0.f(v19);
                Object[] arr_object6 = j1.d;
                arr_object6[v18 * 2] = j0.d[v21];
                arr_object6[v18 * 2 + 1] = j0.x(v21);
                if(this.h(v19)) {
                    ++a0.a;
                }
            }
            else {
                int v20 = this.f(v19);
                Object[] arr_object5 = j1.d;
                arr_object5[v18 * 2] = this.d[v20];
                arr_object5[v18 * 2 + 1] = this.x(v20);
            }
            ++v18;
            v8 ^= v19;
        }
        if(this.e(j1)) {
            return this;
        }
        return j0.e(j1) ? j0 : j1;
    }

    public final j n(int v, Object object0, int v1, f f0) {
        int v2 = v >> v1 & 0x1F;
        if(this.h(1 << v2)) {
            int v3 = this.f(1 << v2);
            return q.b(object0, this.d[v3]) ? this.p(v3, 1 << v2, f0) : this;
        }
        if(this.i(1 << v2)) {
            int v4 = this.t(1 << v2);
            j j0 = this.s(v4);
            if(v1 == 30) {
                e e0 = a.C(a.K(0, j0.d.length), 2);
                int v5 = e0.a;
                int v6 = e0.b;
                int v7 = e0.c;
                if(v7 > 0 && v5 <= v6 || v7 < 0 && v6 <= v5) {
                    while(true) {
                        if(q.b(object0, j0.d[v5])) {
                            return this.q(j0, j0.k(v5, f0), v4, 1 << v2, f0.a);
                        }
                        if(v5 == v6) {
                            break;
                        }
                        v5 += v7;
                    }
                }
                return this.q(j0, j0, v4, 1 << v2, f0.a);
            }
            return this.q(j0, j0.n(v, object0, v1 + 5, f0), v4, 1 << v2, f0.a);
        }
        return this;
    }

    public final j o(int v, Object object0, Object object1, int v1, f f0) {
        int v2 = v >> v1 & 0x1F;
        if(this.h(1 << v2)) {
            int v3 = this.f(1 << v2);
            return !q.b(object0, this.d[v3]) || !q.b(object1, this.x(v3)) ? this : this.p(v3, 1 << v2, f0);
        }
        if(this.i(1 << v2)) {
            int v4 = this.t(1 << v2);
            j j0 = this.s(v4);
            if(v1 == 30) {
                e e0 = a.C(a.K(0, j0.d.length), 2);
                int v5 = e0.a;
                int v6 = e0.b;
                int v7 = e0.c;
                if(v7 > 0 && v5 <= v6 || v7 < 0 && v6 <= v5) {
                    while(true) {
                        if(q.b(object0, j0.d[v5]) && q.b(object1, j0.x(v5))) {
                            return this.q(j0, j0.k(v5, f0), v4, 1 << v2, f0.a);
                        }
                        if(v5 == v6) {
                            break;
                        }
                        v5 += v7;
                    }
                }
                return this.q(j0, j0, v4, 1 << v2, f0.a);
            }
            return this.q(j0, j0.o(v, object0, object1, v1 + 5, f0), v4, 1 << v2, f0.a);
        }
        return this;
    }

    public final j p(int v, int v1, f f0) {
        f0.g(f0.size() - 1);
        f0.c = this.x(v);
        Object[] arr_object = this.d;
        if(arr_object.length == 2) {
            return null;
        }
        if(this.c == f0.a) {
            this.d = c.j(v, arr_object);
            this.a ^= v1;
            return this;
        }
        Object[] arr_object1 = c.j(v, arr_object);
        return new j(v1 ^ this.a, this.b, arr_object1, f0.a);
    }

    public final j q(j j0, j j1, int v, int v1, b b0) {
        b b1 = this.c;
        if(j1 == null) {
            Object[] arr_object = this.d;
            if(arr_object.length == 1) {
                return null;
            }
            if(b1 == b0) {
                this.d = c.k(v, arr_object);
                this.b ^= v1;
                return this;
            }
            Object[] arr_object1 = c.k(v, arr_object);
            return new j(this.a, v1 ^ this.b, arr_object1, b0);
        }
        return b1 == b0 || j0 != j1 ? this.r(v, j1, b0) : this;
    }

    public final j r(int v, j j0, b b0) {
        Object[] arr_object = this.d;
        if(arr_object.length == 1 && j0.d.length == 2 && j0.b == 0) {
            j0.a = this.b;
            return j0;
        }
        if(this.c == b0) {
            arr_object[v] = j0;
            return this;
        }
        Object[] arr_object1 = Arrays.copyOf(arr_object, arr_object.length);
        q.f(arr_object1, "copyOf(...)");
        arr_object1[v] = j0;
        return new j(this.a, this.b, arr_object1, b0);
    }

    public final j s(int v) {
        Object object0 = this.d[v];
        q.e(object0, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode>");
        return (j)object0;
    }

    public final int t(int v) {
        return this.d.length - 1 - Integer.bitCount(v - 1 & this.b);
    }

    public final T3.e u(int v, Object object0, Object object1, int v1) {
        T3.e e1;
        int v2 = v >> v1 & 0x1F;
        if(this.h(1 << v2)) {
            int v3 = this.f(1 << v2);
            if(q.b(object0, this.d[v3])) {
                if(this.x(v3) == object1) {
                    return null;
                }
                Object[] arr_object = Arrays.copyOf(this.d, this.d.length);
                q.f(arr_object, "copyOf(...)");
                arr_object[v3 + 1] = object1;
                return new T3.e(new j(this.a, this.b, arr_object, null), 0);
            }
            Object[] arr_object1 = this.a(v3, 1 << v2, v, object0, object1, v1, null);
            return new T3.e(new j(this.a ^ 1 << v2, this.b | 1 << v2, arr_object1, null), 1);
        }
        if(this.i(1 << v2)) {
            int v4 = this.t(1 << v2);
            j j0 = this.s(v4);
            if(v1 == 30) {
                e e0 = a.C(a.K(0, j0.d.length), 2);
                int v5 = e0.a;
                int v6 = e0.b;
                int v7 = e0.c;
                if(v7 > 0 && v5 <= v6 || v7 < 0 && v6 <= v5) {
                    while(true) {
                        if(q.b(object0, j0.d[v5])) {
                            if(object1 == j0.x(v5)) {
                                e1 = null;
                                goto label_33;
                            }
                            Object[] arr_object2 = Arrays.copyOf(j0.d, j0.d.length);
                            q.f(arr_object2, "copyOf(...)");
                            arr_object2[v5 + 1] = object1;
                            e1 = new T3.e(new j(0, 0, arr_object2, null), 0);
                            goto label_33;
                        }
                        if(v5 == v6) {
                            break;
                        }
                        v5 += v7;
                    }
                }
                e1 = new T3.e(new j(0, 0, c.i(0, object0, object1, j0.d), null), 1);
            label_33:
                if(e1 == null) {
                    return null;
                }
            }
            else {
                e1 = j0.u(v, object0, object1, v1 + 5);
                if(e1 == null) {
                    return null;
                }
            }
            e1.b = this.w(v4, 1 << v2, ((j)e1.b));
            return e1;
        }
        Object[] arr_object3 = c.i(this.f(1 << v2), object0, object1, this.d);
        return new T3.e(new j(this.a | 1 << v2, this.b, arr_object3, null), 1);
    }

    public final j v(int v, int v1, Object object0) {
        j j1;
        int v2 = v >> v1 & 0x1F;
        if(this.h(1 << v2)) {
            int v3 = this.f(1 << v2);
            if(q.b(object0, this.d[v3])) {
                Object[] arr_object = this.d;
                if(arr_object.length == 2) {
                    return null;
                }
                Object[] arr_object1 = c.j(v3, arr_object);
                return new j(this.a ^ 1 << v2, this.b, arr_object1, null);
            }
        }
        else if(this.i(1 << v2)) {
            int v4 = this.t(1 << v2);
            j j0 = this.s(v4);
            if(v1 == 30) {
                e e0 = a.C(a.K(0, j0.d.length), 2);
                int v5 = e0.a;
                int v6 = e0.b;
                int v7 = e0.c;
                if(v7 > 0 && v5 <= v6 || v7 < 0 && v6 <= v5) {
                    while(true) {
                        if(q.b(object0, j0.d[v5])) {
                            Object[] arr_object2 = j0.d;
                            if(arr_object2.length == 2) {
                                j1 = null;
                                goto label_30;
                            }
                            j1 = new j(0, 0, c.j(v5, arr_object2), null);
                            goto label_30;
                        }
                        if(v5 == v6) {
                            break;
                        }
                        v5 += v7;
                    }
                }
                j1 = j0;
            }
            else {
                j1 = j0.v(v, v1 + 5, object0);
            }
        label_30:
            if(j1 == null) {
                Object[] arr_object3 = this.d;
                if(arr_object3.length == 1) {
                    return null;
                }
                Object[] arr_object4 = c.k(v4, arr_object3);
                return new j(this.a, 1 << v2 ^ this.b, arr_object4, null);
            }
            return j0 == j1 ? this : this.w(v4, 1 << v2, j1);
        }
        return this;
    }

    public final j w(int v, int v1, j j0) {
        Object[] arr_object = j0.d;
        if(arr_object.length == 2 && j0.b == 0) {
            if(this.d.length == 1) {
                j0.a = this.b;
                return j0;
            }
            int v2 = this.f(v1);
            Object[] arr_object1 = this.d;
            Object object0 = arr_object[0];
            Object object1 = arr_object[1];
            Object[] arr_object2 = Arrays.copyOf(arr_object1, arr_object1.length + 1);
            q.f(arr_object2, "copyOf(...)");
            n.W(arr_object2, v + 2, arr_object2, v + 1, arr_object1.length);
            n.W(arr_object2, v2 + 2, arr_object2, v2, v);
            arr_object2[v2] = object0;
            arr_object2[v2 + 1] = object1;
            return new j(this.a ^ v1, v1 ^ this.b, arr_object2, null);
        }
        Object[] arr_object3 = Arrays.copyOf(this.d, this.d.length);
        q.f(arr_object3, "copyOf(...)");
        arr_object3[v] = j0;
        return new j(this.a, this.b, arr_object3, null);
    }

    public final Object x(int v) {
        return this.d[v + 1];
    }
}

