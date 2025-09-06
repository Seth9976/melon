package p0;

import androidx.collection.L;
import java.util.Arrays;
import java.util.HashMap;
import we.k;

public final class e extends d {
    public final d o;
    public boolean p;

    public e(long v, l l0, k k0, k k1, d d0) {
        super(v, l0, k0, k1);
        this.o = d0;
        d0.k();
    }

    @Override  // p0.d
    public final void c() {
        if(!this.c) {
            super.c();
            if(!this.p) {
                this.p = true;
                this.o.l();
            }
        }
    }

    @Override  // p0.d
    public final q w() {
        q q0;
        d d0 = this.o;
        if(d0.m || d0.c) {
            return new i(this);
        }
        L l0 = this.h;
        long v = this.b;
        HashMap hashMap0 = l0 == null ? null : m.c(d0.g(), this, this.o.d());
        Object object0 = m.b;
        __monitor_enter(object0);
        try {
            m.d(this);
            if(l0 == null || l0.d == 0) {
                this.a();
                goto label_20;
            }
            q0 = this.z(this.o.g(), l0, hashMap0, this.o.d());
            if(q0.equals(j.b)) {
                L l1 = this.o.x();
                if(l1 == null) {
                    this.o.B(l0);
                    this.h = null;
                }
                else {
                    l1.j(l0);
                }
            label_20:
                if(this.o.g() < v) {
                    this.o.v();
                }
                l l2 = this.o.d().b(v).a(this.j);
                this.o.r(l2);
                this.o.A(v);
                d d1 = this.o;
                int v1 = this.d;
                this.d = -1;
                if(v1 >= 0) {
                    int[] arr_v = d1.k;
                    kotlin.jvm.internal.q.g(arr_v, "<this>");
                    int[] arr_v1 = Arrays.copyOf(arr_v, arr_v.length + 1);
                    arr_v1[arr_v.length] = v1;
                    d1.k = arr_v1;
                }
                else {
                    d1.getClass();
                }
                l l3 = this.j;
                this.o.getClass();
                synchronized(object0) {
                    this.o.j = this.o.j.e(l3);
                }
                d d2 = this.o;
                int[] arr_v2 = this.k;
                d2.getClass();
                if(arr_v2.length != 0) {
                    int[] arr_v3 = d2.k;
                    if(arr_v3.length != 0) {
                        int[] arr_v4 = Arrays.copyOf(arr_v3, arr_v3.length + arr_v2.length);
                        System.arraycopy(arr_v2, 0, arr_v4, arr_v3.length, arr_v2.length);
                        kotlin.jvm.internal.q.d(arr_v4);
                        arr_v2 = arr_v4;
                    }
                    d2.k = arr_v2;
                }
                goto label_59;
            }
            goto label_65;
        }
        catch(Throwable throwable0) {
        }
        __monitor_exit(object0);
        throw throwable0;
    label_59:
        __monitor_exit(object0);
        this.m = true;
        if(!this.p) {
            this.p = true;
            this.o.l();
        }
        return j.b;
    label_65:
        __monitor_exit(object0);
        return q0;
    }
}

