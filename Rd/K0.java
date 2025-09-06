package rd;

import androidx.compose.runtime.l;
import com.melon.ui.playerdjmalrang.DjMalrangPlayerPageData;
import d5.w;
import d8.d;
import ie.H;
import ie.f;
import java.util.List;
import r0.q;
import we.a;
import we.n;
import xd.k;
import zd.D0;

public final class k0 implements n {
    public final int a;
    public final int b;
    public final a c;
    public final Object d;
    public final Object e;
    public final Object f;
    public final f g;

    public k0(q q0, DjMalrangPlayerPageData djMalrangPlayerPageData0, a a0, a a1, a a2, int v) {
        this.a = 0;
        super();
        this.d = q0;
        this.e = djMalrangPlayerPageData0;
        this.c = a0;
        this.f = a1;
        this.g = a2;
        this.b = v;
    }

    public k0(k k0, com.melon.ui.popup.context.more.a a0, we.k k1, int v, we.k k2, a a1, int v1) {
        this.a = 2;
        super();
        this.d = k0;
        this.e = a0;
        this.f = k1;
        this.b = v;
        this.g = k2;
        this.c = a1;
    }

    public k0(D0 d00, List list0, int v, String s, we.k k0, a a0, int v1) {
        this.a = 1;
        super();
        this.d = d00;
        this.e = list0;
        this.b = v;
        this.f = s;
        this.g = k0;
        this.c = a0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                rd.a.c(((q)this.d), ((DjMalrangPlayerPageData)this.e), this.c, ((a)this.f), ((a)this.g), ((l)object0), (this.b | 1) & -920350135 | ((0x24924924 & (this.b | 1)) >> 1 | 306783378 & (this.b | 1)) | (306783378 & (this.b | 1)) << 1 & (0x24924924 & (this.b | 1)));
                return H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                w.g(((D0)this.d), ((List)this.e), this.b, ((String)this.f), ((we.k)this.g), this.c, ((l)object0), 1);
                return H.a;
            }
            default: {
                ((Integer)object1).getClass();
                d.b(((k)this.d), ((com.melon.ui.popup.context.more.a)this.e), ((we.k)this.f), this.b, ((we.k)this.g), this.c, ((l)object0), 1);
                return H.a;
            }
        }
    }
}

