package td;

import O.F;
import androidx.compose.runtime.b1;
import com.melon.ui.playermusic.BgType.SpecialVideo;
import com.melon.ui.playermusic.l;
import d8.d;
import ie.H;
import java.util.List;
import r0.q;
import vd.N;
import vd.O;
import we.a;
import we.k;
import we.n;
import zc.o;

public final class i implements n {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;

    public i(Object object0, Object object1, Object object2, Object object3, int v, int v1) {
        this.a = v1;
        this.b = object0;
        this.c = object1;
        this.d = object2;
        this.e = object3;
        super();
    }

    public i(String s, List list0, a a0, k k0, int v) {
        this.a = 4;
        super();
        this.c = s;
        this.d = list0;
        this.b = a0;
        this.e = k0;
    }

    public i(String s, a a0, a a1, a a2, int v) {
        this.a = 2;
        super();
        this.c = s;
        this.b = a0;
        this.d = a1;
        this.e = a2;
    }

    public i(O o0, String s, String s1, a a0, int v) {
        this.a = 3;
        super();
        this.c = o0;
        this.d = s;
        this.e = s1;
        this.b = a0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                l.c(((a)this.b), ((b1)this.c), ((SpecialVideo)this.d), ((k)this.e), ((androidx.compose.runtime.l)object0), 7);
                return H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                ud.a.b(((q)this.b), ((F)this.c), ((List)this.d), ((Integer)this.e), ((androidx.compose.runtime.l)object0), 1);
                return H.a;
            }
            case 2: {
                ((Integer)object1).getClass();
                d5.n.b(((String)this.c), ((a)this.b), ((a)this.d), ((a)this.e), ((androidx.compose.runtime.l)object0), 1);
                return H.a;
            }
            case 3: {
                ((Integer)object1).getClass();
                N.a(((O)this.c), ((String)this.d), ((String)this.e), ((a)this.b), ((androidx.compose.runtime.l)object0), 1);
                return H.a;
            }
            case 4: {
                ((Integer)object1).getClass();
                d.j(((String)this.c), ((List)this.d), ((a)this.b), ((k)this.e), ((androidx.compose.runtime.l)object0), 1);
                return H.a;
            }
            default: {
                ((Integer)object1).getClass();
                o.a(((List)this.b), ((n)this.c), ((n)this.d), ((n)this.e), ((androidx.compose.runtime.l)object0), 1);
                return H.a;
            }
        }
    }
}

