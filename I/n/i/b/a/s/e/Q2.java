package i.n.i.b.a.s.e;

import android.os.SystemClock;
import java.util.Arrays;
import java.util.List;

public abstract class q2 {
    public final vc a;
    public final int b;
    public final int[] c;
    public final u[] d;
    public final long[] e;
    public int f;

    public q2(vc vc0, int[] arr_v, int v) {
        M7.J(arr_v.length > 0);
        int v3;
        vc0.getClass();
        this.a = vc0;
        this.b = arr_v.length;
        this.d = new u[arr_v.length];
        for(int v2 = 0; v2 < arr_v.length; ++v2) {
            this.d[v2] = vc0.b[arr_v[v2]];
        }
        A0 a00 = new A0(1);
        Arrays.sort(this.d, a00);
        this.c = new int[this.b];
        for(int v1 = 0; true; ++v1) {
            v3 = this.b;
            if(v1 >= v3) {
                break;
            }
            this.c[v1] = vc0.a(this.d[v1]);
        }
        this.e = new long[v3];
    }

    public int a(long v, List list0) {
        return list0.size();
    }

    public final int b(u u0) {
        for(int v = 0; v < this.b; ++v) {
            if(this.d[v] == u0) {
                return v;
            }
        }
        return -1;
    }

    public void c(float f) {
    }

    public abstract void d(long arg1, long arg2, long arg3, List arg4, c8[] arg5, int arg6);

    public void e(u u0, int v) {
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 != null && this.getClass() == object0.getClass() && this.a == ((q2)object0).a && Arrays.equals(this.c, ((q2)object0).c);
    }

    public boolean f(int v, long v1) {
        long v2 = SystemClock.elapsedRealtime();
        boolean z = this.g(v, v2);
        for(int v3 = 0; v3 < this.b && !z; ++v3) {
            z = v3 != v && !this.g(v3, v2);
        }
        if(!z) {
            return false;
        }
        long v4 = v2 + v1;
        this.e[v] = Math.max(this.e[v], (((v1 ^ v4) & (v2 ^ v4)) >= 0L ? v2 + v1 : 0x7FFFFFFFFFFFFFFFL));
        return true;
    }

    public final boolean g(int v, long v1) {
        return this.e[v] > v1;
    }

    public final u h() {
        return this.d[this.j()];
    }

    @Override
    public final int hashCode() {
        if(this.f == 0) {
            this.f = Arrays.hashCode(this.c) + System.identityHashCode(this.a) * 0x1F;
        }
        return this.f;
    }

    public abstract int i();

    public abstract int j();

    public void k() {
    }

    public void l() {
    }

    public abstract Object m();
}

