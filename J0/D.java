package j0;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.q;
import m0.f;

public class d extends c {
    public final f d;
    public Object e;
    public boolean f;
    public int g;

    public d(f f0, k[] arr_k) {
        super(f0.b, arr_k);
        this.d = f0;
        this.g = f0.d;
    }

    public final void d(int v, j j0, Object object0, int v1) {
        k[] arr_k = this.a;
        if(v1 * 5 > 30) {
            arr_k[v1].a(j0.d, j0.d.length, 0);
            while(true) {
                k k0 = arr_k[v1];
                if(q.b(k0.a[k0.c], object0)) {
                    break;
                }
                k k1 = arr_k[v1];
                k1.c += 2;
            }
            this.b = v1;
            return;
        }
        int v2 = v >> v1 * 5 & 0x1F;
        if(j0.h(1 << v2)) {
            arr_k[v1].a(j0.d, Integer.bitCount(j0.a) * 2, j0.f(1 << v2));
            this.b = v1;
            return;
        }
        int v3 = j0.t(1 << v2);
        j j1 = j0.s(v3);
        arr_k[v1].a(j0.d, Integer.bitCount(j0.a) * 2, v3);
        this.d(v, j1, object0, v1 + 1);
    }

    @Override  // j0.c
    public final Object next() {
        if(this.d.d != this.g) {
            throw new ConcurrentModificationException();
        }
        if(!this.c) {
            throw new NoSuchElementException();
        }
        k k0 = this.a[this.b];
        this.e = k0.a[k0.c];
        this.f = true;
        return super.next();
    }

    @Override  // j0.c
    public final void remove() {
        if(!this.f) {
            throw new IllegalStateException();
        }
        f f0 = this.d;
        if(this.c) {
            k k0 = this.a[this.b];
            Object object0 = k0.a[k0.c];
            Object object1 = this.e;
            N.c(f0).remove(object1);
            this.d((object0 == null ? 0 : object0.hashCode()), f0.b, object0, 0);
        }
        else {
            Object object2 = this.e;
            N.c(f0).remove(object2);
        }
        this.e = null;
        this.f = false;
        this.g = f0.d;
    }
}

