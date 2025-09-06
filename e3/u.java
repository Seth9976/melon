package e3;

import i.n.i.b.a.s.e.M7;
import java.util.Arrays;

public final class u {
    public long[] a;
    public Object[] b;
    public int c;
    public int d;

    public u() {
        this.a = new long[10];
        this.b = new Object[10];
    }

    public void a() {
        synchronized(this) {
            this.c = 0;
            this.d = 0;
            Arrays.fill(this.b, null);
        }
    }

    public void b(long v, Object object0) {
        synchronized(this) {
            if(this.d > 0 && v <= this.a[(this.c + this.d - 1) % this.b.length]) {
                this.d();
            }
            this.f();
            int v2 = this.d;
            Object[] arr_object = this.b;
            int v3 = (this.c + v2) % arr_object.length;
            this.a[v3] = v;
            arr_object[v3] = object0;
            this.d = v2 + 1;
        }
    }

    public void c() {
        int v = this.b.length;
        if(this.d < v) {
            return;
        }
        long[] arr_v = new long[v * 2];
        Object[] arr_object = new Object[v * 2];
        int v1 = v - this.c;
        System.arraycopy(this.a, this.c, arr_v, 0, v1);
        System.arraycopy(this.b, this.c, arr_object, 0, v1);
        int v2 = this.c;
        if(v2 > 0) {
            System.arraycopy(this.a, 0, arr_v, v1, v2);
            System.arraycopy(this.b, 0, arr_object, v1, this.c);
        }
        this.a = arr_v;
        this.b = arr_object;
        this.c = 0;
    }

    public void d() {
        synchronized(this) {
            this.c = 0;
            this.d = 0;
            Arrays.fill(this.b, null);
        }
    }

    public Object e() {
        M7.J(this.d > 0);
        Object[] arr_object = this.b;
        int v = this.c;
        Object object0 = arr_object[v];
        arr_object[v] = null;
        this.c = (v + 1) % arr_object.length;
        --this.d;
        return object0;
    }

    public void f() {
        int v = this.b.length;
        if(this.d < v) {
            return;
        }
        long[] arr_v = new long[v * 2];
        Object[] arr_object = new Object[v * 2];
        int v1 = v - this.c;
        System.arraycopy(this.a, this.c, arr_v, 0, v1);
        System.arraycopy(this.b, this.c, arr_object, 0, v1);
        int v2 = this.c;
        if(v2 > 0) {
            System.arraycopy(this.a, 0, arr_v, v1, v2);
            System.arraycopy(this.b, 0, arr_object, v1, this.c);
        }
        this.a = arr_v;
        this.b = arr_object;
        this.c = 0;
    }

    public Object g(long v, boolean z) {
        Object object0 = null;
        for(long v1 = 0x7FFFFFFFFFFFFFFFL; this.d > 0; v1 = v2) {
            long v2 = v - this.a[this.c];
            if(v2 < 0L && (z || -v2 >= v1)) {
                break;
            }
            object0 = this.j();
        }
        return object0;
    }

    public Object h() {
        synchronized(this) {
            return this.d == 0 ? null : this.j();
        }
    }

    public Object i(long v) {
        synchronized(this) {
            return this.g(v, true);
        }
    }

    public Object j() {
        b.j(this.d > 0);
        Object[] arr_object = this.b;
        int v = this.c;
        Object object0 = arr_object[v];
        arr_object[v] = null;
        this.c = (v + 1) % arr_object.length;
        --this.d;
        return object0;
    }

    public int k() {
        synchronized(this) {
        }
        return this.d;
    }
}

