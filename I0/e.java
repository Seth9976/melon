package i0;

import B6.f;
import androidx.compose.runtime.j0;
import androidx.fragment.app.p;
import c2.Y;
import df.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import je.h;
import je.n;
import kotlin.jvm.internal.q;
import we.k;
import xe.b;

public final class e extends h implements Collection, b {
    public i0.b a;
    public Object[] b;
    public Object[] c;
    public int d;
    public l0.b e;
    public Object[] f;
    public Object[] g;
    public int h;

    public e(i0.b b0, Object[] arr_object, Object[] arr_object1, int v) {
        this.a = b0;
        this.b = arr_object;
        this.c = arr_object1;
        this.d = v;
        this.e = new l0.b();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.f = arr_object;
        this.g = arr_object1;
        this.h = b0.size();
    }

    public final void A(Object[] arr_object, Object[] arr_object1, Object[] arr_object2) {
        int v = this.h;
        int v1 = this.d;
        if(v >> 5 > 1 << v1) {
            Object[] arr_object3 = this.u(arr_object);
            this.f = this.B(this.d + 5, arr_object3, arr_object1);
            this.g = arr_object2;
            this.d += 5;
            ++this.h;
            return;
        }
        if(arr_object == null) {
            this.f = arr_object1;
            this.g = arr_object2;
            this.h = v + 1;
            return;
        }
        this.f = this.B(v1, arr_object, arr_object1);
        this.g = arr_object2;
        ++this.h;
    }

    public final Object[] B(int v, Object[] arr_object, Object[] arr_object1) {
        int v1 = this.b() - 1 >> v & 0x1F;
        Object[] arr_object2 = this.r(arr_object);
        if(v == 5) {
            arr_object2[v1] = arr_object1;
            return arr_object2;
        }
        arr_object2[v1] = this.B(v - 5, ((Object[])arr_object2[v1]), arr_object1);
        return arr_object2;
    }

    public final int C(k k0, Object[] arr_object, int v, int v1, f f0, ArrayList arrayList0, ArrayList arrayList1) {
        if(this.p(arr_object)) {
            arrayList0.add(arr_object);
        }
        Object object0 = f0.a;
        q.e(object0, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] arr_object1 = (Object[])object0;
        for(int v2 = 0; v2 < v; ++v2) {
            Object object1 = arr_object[v2];
            if(!((Boolean)k0.invoke(object1)).booleanValue()) {
                if(v1 == 0x20) {
                    arr_object1 = arrayList0.isEmpty() ? this.t() : ((Object[])arrayList0.remove(arrayList0.size() - 1));
                    v1 = 0;
                }
                arr_object1[v1] = object1;
                ++v1;
            }
        }
        f0.a = arr_object1;
        if(((Object[])object0) != arr_object1) {
            arrayList1.add(((Object[])object0));
        }
        return v1;
    }

    public final int D(k k0, Object[] arr_object, int v, f f0) {
        Object[] arr_object1 = arr_object;
        int v2 = v;
        boolean z = false;
        for(int v1 = 0; v1 < v; ++v1) {
            Object object0 = arr_object[v1];
            if(!((Boolean)k0.invoke(object0)).booleanValue()) {
                if(z) {
                    arr_object1[v2] = object0;
                    ++v2;
                }
            }
            else if(!z) {
                arr_object1 = this.r(arr_object);
                z = true;
                v2 = v1;
            }
        }
        f0.a = arr_object1;
        return v2;
    }

    public final int E(k k0, int v, f f0) {
        int v1 = this.D(k0, this.g, v, f0);
        if(v1 == v) {
            return v;
        }
        Object object0 = f0.a;
        q.e(object0, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Arrays.fill(((Object[])object0), v1, v, null);
        this.g = (Object[])object0;
        this.h -= v - v1;
        return v1;
    }

    public final boolean G(k k0) {
        int v7;
        Object[] arr_object1;
        int v = this.N();
        Object[] arr_object = null;
        f f0 = new f(null);
        boolean z = false;
        if(this.f != null) {
            a a0 = this.q(0);
            int v1;
            for(v1 = 0x20; v1 == 0x20 && a0.hasNext(); v1 = this.D(k0, ((Object[])a0.next()), 0x20, f0)) {
            }
            if(v1 == 0x20) {
                int v2 = this.E(k0, v, f0);
                if(v2 == 0) {
                    this.x(this.f, this.h, this.d);
                }
                if(v2 != v) {
                    z = true;
                }
            }
            else {
                int v3 = a0.a - 1 << 5;
                ArrayList arrayList0 = new ArrayList();
                ArrayList arrayList1 = new ArrayList();
                int v4;
                for(v4 = v1; a0.hasNext(); v4 = this.C(k0, ((Object[])a0.next()), 0x20, v4, f0, arrayList1, arrayList0)) {
                }
                int v5 = this.C(k0, this.g, v, v4, f0, arrayList1, arrayList0);
                Object object0 = f0.a;
                q.e(object0, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                Arrays.fill(((Object[])object0), v5, 0x20, null);
                if(arrayList0.isEmpty()) {
                    arr_object1 = this.f;
                    q.d(arr_object1);
                }
                else {
                    arr_object1 = this.y(this.f, v3, this.d, arrayList0.iterator());
                }
                int v6 = v3 + (arrayList0.size() << 5);
                if((v6 & 0x1F) != 0) {
                    j0.a("invalid size");
                }
                if(v6 == 0) {
                    this.d = 0;
                }
                else {
                    while(true) {
                        v7 = this.d;
                        if(v6 - 1 >> v7 != 0) {
                            break;
                        }
                        this.d = v7 - 5;
                        Object object1 = arr_object1[0];
                        q.e(object1, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                        arr_object1 = (Object[])object1;
                    }
                    arr_object = this.v(arr_object1, v6 - 1, v7);
                }
                this.f = arr_object;
                this.g = (Object[])object0;
                this.h = v6 + v5;
                z = true;
            }
        }
        else if(this.E(k0, v, f0) != v) {
            z = true;
        }
        if(z) {
            ++this.modCount;
        }
        return z;
    }

    public final Object[] H(Object[] arr_object, int v, int v1, f f0) {
        int v2 = v1 >> v & 0x1F;
        int v3 = 0x1F;
        if(v == 0) {
            Object object0 = arr_object[v2];
            Object[] arr_object1 = this.r(arr_object);
            n.W(arr_object, v2, arr_object1, v2 + 1, 0x20);
            arr_object1[0x1F] = f0.a;
            f0.a = object0;
            return arr_object1;
        }
        if(arr_object[0x1F] == null) {
            v3 = v.y(this.J() - 1, v);
        }
        Object[] arr_object2 = this.r(arr_object);
        if(v2 + 1 <= v3) {
            while(true) {
                Object object1 = arr_object2[v3];
                q.e(object1, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                arr_object2[v3] = this.H(((Object[])object1), v - 5, 0, f0);
                if(v3 == v2 + 1) {
                    break;
                }
                --v3;
            }
        }
        Object object2 = arr_object2[v2];
        q.e(object2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        arr_object2[v2] = this.H(((Object[])object2), v - 5, v1, f0);
        return arr_object2;
    }

    public final Object I(Object[] arr_object, int v, int v1, int v2) {
        int v3 = this.h - v;
        if(v3 == 1) {
            Object object0 = this.g[0];
            this.x(arr_object, v, v1);
            return object0;
        }
        Object[] arr_object1 = this.g;
        Object object1 = arr_object1[v2];
        Object[] arr_object2 = this.r(arr_object1);
        n.W(arr_object1, v2, arr_object2, v2 + 1, v3);
        arr_object2[v3 - 1] = null;
        this.f = arr_object;
        this.g = arr_object2;
        this.h = v + v3 - 1;
        this.d = v1;
        return object1;
    }

    public final int J() {
        return this.h > 0x20 ? this.h - 1 & 0xFFFFFFE0 : 0;
    }

    public final Object[] L(Object[] arr_object, int v, int v1, Object object0, f f0) {
        int v2 = v1 >> v & 0x1F;
        Object[] arr_object1 = this.r(arr_object);
        if(v == 0) {
            if(arr_object1 != arr_object) {
                ++this.modCount;
            }
            f0.a = arr_object1[v2];
            arr_object1[v2] = object0;
            return arr_object1;
        }
        Object object1 = arr_object1[v2];
        q.e(object1, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        arr_object1[v2] = this.L(((Object[])object1), v - 5, v1, object0, f0);
        return arr_object1;
    }

    public final void M(Collection collection0, int v, Object[] arr_object, int v1, Object[][] arr2_object, int v2, Object[] arr_object1) {
        Object[] arr_object3;
        if(v2 < 1) {
            j0.a("requires at least one nullBuffer");
        }
        Object[] arr_object2 = this.r(arr_object);
        arr2_object[0] = arr_object2;
        int v4 = collection0.size() + v - 1 & 0x1F;
        int v5 = v1 - (v & 0x1F) + v4;
        if(v5 < 0x20) {
            n.W(arr_object2, v4 + 1, arr_object1, v & 0x1F, v1);
        }
        else {
            if(v2 == 1) {
                arr_object3 = arr_object2;
            }
            else {
                arr_object3 = this.t();
                --v2;
                arr2_object[v2] = arr_object3;
            }
            int v6 = v1 - (v5 - 0x1F);
            n.W(arr_object2, 0, arr_object1, v6, v1);
            n.W(arr_object2, v4 + 1, arr_object3, v & 0x1F, v6);
            arr_object1 = arr_object3;
        }
        Iterator iterator0 = collection0.iterator();
        e.g(arr_object2, v & 0x1F, iterator0);
        for(int v3 = 1; v3 < v2; ++v3) {
            Object[] arr_object4 = this.t();
            e.g(arr_object4, 0, iterator0);
            arr2_object[v3] = arr_object4;
        }
        e.g(arr_object1, 0, iterator0);
    }

    public final int N() {
        return this.h > 0x20 ? this.h - (this.h - 1 & 0xFFFFFFE0) : this.h;
    }

    @Override
    public final void add(int v, Object object0) {
        e2.a.t(v, this.b());
        if(v == this.b()) {
            this.add(object0);
            return;
        }
        ++this.modCount;
        int v1 = this.J();
        if(v >= v1) {
            this.o(object0, this.f, v - v1);
            return;
        }
        f f0 = new f(null);
        Object[] arr_object = this.f;
        q.d(arr_object);
        Object[] arr_object1 = this.l(arr_object, this.d, v, object0, f0);
        this.o(f0.a, arr_object1, 0);
    }

    @Override
    public final boolean add(Object object0) {
        ++this.modCount;
        int v = this.N();
        if(v < 0x20) {
            Object[] arr_object = this.r(this.g);
            arr_object[v] = object0;
            this.g = arr_object;
            this.h = this.b() + 1;
            return true;
        }
        Object[] arr_object1 = this.u(object0);
        this.A(this.f, this.g, arr_object1);
        return true;
    }

    @Override
    public final boolean addAll(int v, Collection collection0) {
        Object[] arr_object2;
        e2.a.t(v, this.h);
        if(v == this.h) {
            return this.addAll(collection0);
        }
        if(collection0.isEmpty()) {
            return false;
        }
        ++this.modCount;
        int v1 = v >> 5 << 5;
        int v2 = (collection0.size() + (this.h - v1) - 1) / 0x20;
        if(v2 == 0) {
            Object[] arr_object = this.g;
            Object[] arr_object1 = this.r(arr_object);
            n.W(arr_object, (collection0.size() + v - 1 & 0x1F) + 1, arr_object1, v & 0x1F, this.N());
            e.g(arr_object1, v & 0x1F, collection0.iterator());
            this.g = arr_object1;
            this.h = collection0.size() + this.h;
            return true;
        }
        Object[][] arr2_object = new Object[v2][];
        int v3 = this.N();
        int v4 = collection0.size() + this.h;
        v4 = v4 <= 0x20 ? collection0.size() + this.h : v4 - (v4 - 1 & 0xFFFFFFE0);
        if(v >= this.J()) {
            arr_object2 = this.t();
            this.M(collection0, v, this.g, v3, arr2_object, v2, arr_object2);
        }
        else if(v4 > v3) {
            int v5 = v4 - v3;
            Object[] arr_object3 = this.s(v5, this.g);
            this.k(collection0, v, v5, arr2_object, v2, arr_object3);
            arr_object2 = arr_object3;
        }
        else {
            Object[] arr_object4 = this.g;
            arr_object2 = this.t();
            int v6 = v3 - v4;
            n.W(arr_object4, 0, arr_object2, v6, v3);
            Object[] arr_object5 = this.s(0x20 - v6, this.g);
            arr2_object[v2 - 1] = arr_object5;
            this.k(collection0, v, 0x20 - v6, arr2_object, v2 - 1, arr_object5);
        }
        this.f = this.z(this.f, v1, arr2_object);
        this.g = arr_object2;
        this.h = collection0.size() + this.h;
        return true;
    }

    @Override
    public final boolean addAll(Collection collection0) {
        if(collection0.isEmpty()) {
            return false;
        }
        ++this.modCount;
        int v = this.N();
        Iterator iterator0 = collection0.iterator();
        if(0x20 - v >= collection0.size()) {
            Object[] arr_object = this.r(this.g);
            e.g(arr_object, v, iterator0);
            this.g = arr_object;
            this.h = collection0.size() + this.h;
            return true;
        }
        int v1 = (collection0.size() + v - 1) / 0x20;
        Object[][] arr2_object = new Object[v1][];
        Object[] arr_object1 = this.r(this.g);
        e.g(arr_object1, v, iterator0);
        arr2_object[0] = arr_object1;
        for(int v2 = 1; v2 < v1; ++v2) {
            Object[] arr_object2 = this.t();
            e.g(arr_object2, 0, iterator0);
            arr2_object[v2] = arr_object2;
        }
        this.f = this.z(this.f, this.J(), arr2_object);
        Object[] arr_object3 = this.t();
        e.g(arr_object3, 0, iterator0);
        this.g = arr_object3;
        this.h = collection0.size() + this.h;
        return true;
    }

    @Override  // je.h
    public final int b() {
        return this.h;
    }

    @Override  // je.h
    public final Object d(int v) {
        e2.a.s(v, this.b());
        ++this.modCount;
        int v1 = this.J();
        if(v >= v1) {
            return this.I(this.f, v1, this.d, v - v1);
        }
        f f0 = new f(this.g[0]);
        Object[] arr_object = this.f;
        q.d(arr_object);
        this.I(this.H(arr_object, this.d, v, f0), v1, this.d, 0);
        return f0.a;
    }

    public final i0.b e() {
        i0.b b0;
        Object[] arr_object = this.f;
        if(arr_object != this.b || this.g != this.c) {
            this.e = new l0.b();  // 初始化器: Ljava/lang/Object;-><init>()V
            this.b = arr_object;
            Object[] arr_object1 = this.g;
            this.c = arr_object1;
            if(arr_object != null) {
                b0 = new d(arr_object, arr_object1, this.h, this.d);
            }
            else if(arr_object1.length == 0) {
                b0 = i0.h.b;
            }
            else {
                Object[] arr_object2 = Arrays.copyOf(arr_object1, this.h);
                q.f(arr_object2, "copyOf(...)");
                b0 = new i0.h(arr_object2);
            }
        }
        else {
            b0 = this.a;
        }
        this.a = b0;
        return b0;
    }

    public static void g(Object[] arr_object, int v, Iterator iterator0) {
        while(v < 0x20 && iterator0.hasNext()) {
            Object object0 = iterator0.next();
            arr_object[v] = object0;
            ++v;
        }
    }

    @Override
    public final Object get(int v) {
        e2.a.s(v, this.b());
        if(this.J() <= v) {
            return this.g[v & 0x1F];
        }
        Object[] arr_object = this.f;
        q.d(arr_object);
        for(int v1 = this.d; v1 > 0; v1 -= 5) {
            Object object0 = arr_object[v >> v1 & 0x1F];
            q.e(object0, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            arr_object = (Object[])object0;
        }
        return arr_object[v & 0x1F];
    }

    public final int i() {
        return this.modCount;
    }

    @Override
    public final Iterator iterator() {
        return this.listIterator(0);
    }

    public final void k(Collection collection0, int v, int v1, Object[][] arr2_object, int v2, Object[] arr_object) {
        if(this.f == null) {
            throw new IllegalStateException("root is null");
        }
        a a0 = this.q(this.J() >> 5);
        int v3 = v2;
        Object[] arr_object1 = arr_object;
        while(a0.a - 1 != v >> 5) {
            Object[] arr_object2 = (Object[])a0.previous();
            n.W(arr_object2, 0, arr_object1, 0x20 - v1, 0x20);
            arr_object1 = this.s(v1, arr_object2);
            --v3;
            arr2_object[v3] = arr_object1;
        }
        Object object0 = a0.previous();
        int v4 = v2 - ((this.J() >> 5) - 1 - (v >> 5));
        if(v4 < v2) {
            arr_object = arr2_object[v4];
            q.d(arr_object);
        }
        this.M(collection0, v, ((Object[])object0), 0x20, arr2_object, v4, arr_object);
    }

    public final Object[] l(Object[] arr_object, int v, int v1, Object object0, f f0) {
        int v2 = v1 >> v & 0x1F;
        if(v == 0) {
            f0.a = arr_object[0x1F];
            Object[] arr_object1 = this.r(arr_object);
            n.W(arr_object, v2 + 1, arr_object1, v2, 0x1F);
            arr_object1[v2] = object0;
            return arr_object1;
        }
        Object[] arr_object2 = this.r(arr_object);
        Object object1 = arr_object2[v2];
        q.e(object1, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        arr_object2[v2] = this.l(((Object[])object1), v - 5, v1, object0, f0);
        while(true) {
            ++v2;
            if(v2 >= 0x20) {
                break;
            }
            Object object2 = arr_object2[v2];
            if(object2 == null) {
                break;
            }
            arr_object2[v2] = this.l(((Object[])object2), v - 5, 0, f0.a, f0);
        }
        return arr_object2;
    }

    @Override
    public final ListIterator listIterator() {
        return this.listIterator(0);
    }

    @Override
    public final ListIterator listIterator(int v) {
        e2.a.t(v, this.h);
        return new g(this, v);
    }

    public final void o(Object object0, Object[] arr_object, int v) {
        int v1 = this.N();
        Object[] arr_object1 = this.r(this.g);
        if(v1 < 0x20) {
            n.W(this.g, v + 1, arr_object1, v, v1);
            arr_object1[v] = object0;
            this.f = arr_object;
            this.g = arr_object1;
            ++this.h;
            return;
        }
        Object[] arr_object2 = this.g;
        Object object1 = arr_object2[0x1F];
        n.W(arr_object2, v + 1, arr_object1, v, 0x1F);
        arr_object1[v] = object0;
        this.A(arr_object, arr_object1, this.u(object1));
    }

    public final boolean p(Object[] arr_object) {
        return arr_object.length == 33 && arr_object[0x20] == this.e;
    }

    public final a q(int v) {
        Object[] arr_object = this.f;
        if(arr_object == null) {
            throw new IllegalStateException("Invalid root");
        }
        int v1 = this.J();
        e2.a.t(v, v1 >> 5);
        int v2 = this.d;
        return v2 == 0 ? new c(arr_object, v) : new i(arr_object, v, v1 >> 5, v2 / 5);
    }

    public final Object[] r(Object[] arr_object) {
        if(arr_object == null) {
            return this.t();
        }
        if(this.p(arr_object)) {
            return arr_object;
        }
        Object[] arr_object1 = this.t();
        n.Y(arr_object, 0, arr_object1, (arr_object.length <= 0x20 ? arr_object.length : 0x20), 6);
        return arr_object1;
    }

    @Override
    public final boolean removeAll(Collection collection0) {
        return this.G(new p(2, collection0));
    }

    public final Object[] s(int v, Object[] arr_object) {
        if(this.p(arr_object)) {
            n.W(arr_object, v, arr_object, 0, 0x20 - v);
            return arr_object;
        }
        Object[] arr_object1 = this.t();
        n.W(arr_object, v, arr_object1, 0, 0x20 - v);
        return arr_object1;
    }

    @Override
    public final Object set(int v, Object object0) {
        e2.a.s(v, this.b());
        if(this.J() <= v) {
            Object[] arr_object = this.r(this.g);
            if(arr_object != this.g) {
                ++this.modCount;
            }
            Object object1 = arr_object[v & 0x1F];
            arr_object[v & 0x1F] = object0;
            this.g = arr_object;
            return object1;
        }
        f f0 = new f(null);
        Object[] arr_object1 = this.f;
        q.d(arr_object1);
        this.f = this.L(arr_object1, this.d, v, object0, f0);
        return f0.a;
    }

    public final Object[] t() {
        Object[] arr_object = new Object[33];
        arr_object[0x20] = this.e;
        return arr_object;
    }

    public final Object[] u(Object object0) {
        Object[] arr_object = new Object[33];
        arr_object[0] = object0;
        arr_object[0x20] = this.e;
        return arr_object;
    }

    public final Object[] v(Object[] arr_object, int v, int v1) {
        if(v1 < 0) {
            j0.a("shift should be positive");
        }
        if(v1 == 0) {
            return arr_object;
        }
        int v2 = v >> v1 & 0x1F;
        Object object0 = arr_object[v2];
        q.e(object0, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] arr_object1 = this.v(((Object[])object0), v, v1 - 5);
        if(v2 < 0x1F && arr_object[v2 + 1] != null) {
            if(this.p(arr_object)) {
                Arrays.fill(arr_object, v2 + 1, 0x20, null);
            }
            Object[] arr_object2 = this.t();
            n.W(arr_object, 0, arr_object2, 0, v2 + 1);
            arr_object = arr_object2;
        }
        if(arr_object1 != arr_object[v2]) {
            arr_object = this.r(arr_object);
            arr_object[v2] = arr_object1;
        }
        return arr_object;
    }

    public final Object[] w(Object[] arr_object, int v, int v1, f f0) {
        Object[] arr_object1;
        int v2 = v1 - 1 >> v & 0x1F;
        if(v == 5) {
            f0.a = arr_object[v2];
            arr_object1 = null;
        }
        else {
            Object object0 = arr_object[v2];
            q.e(object0, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            arr_object1 = this.w(((Object[])object0), v - 5, v1, f0);
        }
        if(arr_object1 == null && v2 == 0) {
            return null;
        }
        Object[] arr_object2 = this.r(arr_object);
        arr_object2[v2] = arr_object1;
        return arr_object2;
    }

    public final void x(Object[] arr_object, int v, int v1) {
        if(v1 == 0) {
            this.f = null;
            if(arr_object == null) {
                arr_object = new Object[0];
            }
            this.g = arr_object;
            this.h = v;
            this.d = 0;
            return;
        }
        f f0 = new f(null);
        q.d(arr_object);
        Object[] arr_object1 = this.w(arr_object, v1, v, f0);
        q.d(arr_object1);
        Object object0 = f0.a;
        q.e(object0, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        this.g = (Object[])object0;
        this.h = v;
        if(arr_object1[1] == null) {
            this.f = (Object[])arr_object1[0];
            this.d = v1 - 5;
            return;
        }
        this.f = arr_object1;
        this.d = v1;
    }

    public final Object[] y(Object[] arr_object, int v, int v1, Iterator iterator0) {
        if(!iterator0.hasNext()) {
            j0.a("invalid buffersIterator");
        }
        if(v1 < 0) {
            j0.a("negative shift");
        }
        if(v1 == 0) {
            return iterator0.next();
        }
        Object[] arr_object1 = this.r(arr_object);
        int v2 = v >> v1 & 0x1F;
        arr_object1[v2] = this.y(((Object[])arr_object1[v2]), v, v1 - 5, iterator0);
        while(true) {
            ++v2;
            if(v2 >= 0x20 || !iterator0.hasNext()) {
                break;
            }
            arr_object1[v2] = this.y(((Object[])arr_object1[v2]), 0, v1 - 5, iterator0);
        }
        return arr_object1;
    }

    public final Object[] z(Object[] arr_object, int v, Object[][] arr2_object) {
        Y y0 = q.j(arr2_object);
        int v1 = this.d;
        Object[] arr_object1 = v >> 5 >= 1 << v1 ? this.r(arr_object) : this.y(arr_object, v, v1, y0);
        while(y0.hasNext()) {
            this.d += 5;
            arr_object1 = this.u(arr_object1);
            this.y(arr_object1, 1 << this.d, this.d, y0);
        }
        return arr_object1;
    }
}

