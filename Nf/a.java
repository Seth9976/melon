package nf;

import androidx.appcompat.app.o;
import java.util.ArrayList;
import java.util.List;
import je.n;
import je.p;
import je.w;
import kotlin.jvm.internal.q;

public abstract class a {
    public final int[] a;
    public final int b;
    public final int c;
    public final int d;
    public final List e;

    public a(int[] arr_v) {
        q.g(arr_v, "numbers");
        List list0;
        super();
        this.a = arr_v;
        Integer integer0 = n.m0(0, arr_v);
        int v = -1;
        this.b = integer0 == null ? -1 : ((int)integer0);
        Integer integer1 = n.m0(1, arr_v);
        this.c = integer1 == null ? -1 : ((int)integer1);
        Integer integer2 = n.m0(2, arr_v);
        if(integer2 != null) {
            v = (int)integer2;
        }
        this.d = v;
        if(arr_v.length > 3) {
            if(arr_v.length > 0x400) {
                throw new IllegalArgumentException(o.q(new StringBuilder("BinaryVersion with length more than 1024 are not supported. Provided length "), arr_v.length, '.'));
            }
            list0 = p.P0(new je.o(arr_v, 0).subList(3, arr_v.length));
        }
        else {
            list0 = w.a;
        }
        this.e = list0;
    }

    public final boolean a(int v, int v1, int v2) {
        int v3 = this.b;
        if(v3 > v) {
            return true;
        }
        if(v3 < v) {
            return false;
        }
        int v4 = this.c;
        if(v4 > v1) {
            return true;
        }
        return v4 >= v1 ? this.d >= v2 : false;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 != null && this.getClass().equals(object0.getClass()) && this.b == ((a)object0).b && this.c == ((a)object0).c && this.d == ((a)object0).d && q.b(this.e, ((a)object0).e);
    }

    // 去混淆评级： 低(40)
    @Override
    public final int hashCode() {
        return this.e.hashCode() + 0x20 * this.d + 0x8000 * this.b + 0x400 * this.c;
    }

    @Override
    public final String toString() {
        ArrayList arrayList0 = new ArrayList();
        int[] arr_v = this.a;
        for(int v = 0; v < arr_v.length; v = com.iloen.melon.utils.a.d(v1, v, 1, arrayList0)) {
            int v1 = arr_v[v];
            if(v1 == -1) {
                break;
            }
        }
        return arrayList0.isEmpty() ? "unknown" : p.q0(arrayList0, ".", null, null, null, 62);
    }
}

