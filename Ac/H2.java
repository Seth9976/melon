package Ac;

import O.F;
import androidx.compose.runtime.l;
import com.melon.ui.playerdjmalrang.DjMalrangPlayerPageData;
import ie.H;
import java.util.List;
import r0.q;
import we.a;
import we.k;
import we.n;

public final class h2 implements n {
    public final int a;
    public final k b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;
    public final Object g;

    public h2(v2 v20, q q0, F f0, O2 o20, List list0, k k0, int v) {
        this.a = 0;
        super();
        this.c = v20;
        this.d = q0;
        this.e = f0;
        this.f = o20;
        this.g = list0;
        this.b = k0;
    }

    public h2(DjMalrangPlayerPageData djMalrangPlayerPageData0, a a0, k k0, a a1, a a2, a a3, int v) {
        this.a = 1;
        super();
        this.c = djMalrangPlayerPageData0;
        this.d = a0;
        this.b = k0;
        this.e = a1;
        this.f = a2;
        this.g = a3;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            ((Integer)object1).getClass();
            rd.a.h(((DjMalrangPlayerPageData)this.c), ((a)this.d), this.b, ((a)this.e), ((a)this.f), ((a)this.g), ((l)object0), 0x30C01);
            return H.a;
        }
        ((Integer)object1).getClass();
        ((v2)this.c).o(((q)this.d), ((F)this.e), ((O2)this.f), ((List)this.g), this.b, ((l)object0), 7);
        return H.a;
    }
}

