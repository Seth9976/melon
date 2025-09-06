package hd;

import androidx.compose.runtime.l;
import com.melon.net.res.MusicDnaMainRes.RESPONSE.MYDNA.CARD;
import java.util.List;
import we.n;
import zc.a;
import zc.j;
import zc.k;
import zc.w;

public final class f implements n {
    public final int a;
    public final int b;
    public final float c;
    public final int d;
    public final Object e;
    public final Object f;
    public final Object g;

    public f(int v, List list0, List list1, int v1, float f, a a0, int v2) {
        this.a = 2;
        super();
        this.b = v;
        this.e = list0;
        this.f = list1;
        this.d = v1;
        this.c = f;
        this.g = a0;
    }

    public f(int v, List list0, List list1, k k0, float f, int v1) {
        this.a = 1;
        super();
        this.b = v;
        this.e = list0;
        this.f = list1;
        this.g = k0;
        this.c = f;
        this.d = v1;
    }

    public f(CARD musicDnaMainRes$RESPONSE$MYDNA$CARD0, int v, float f, we.k k0, we.a a0, int v1) {
        this.a = 0;
        super();
        this.e = musicDnaMainRes$RESPONSE$MYDNA$CARD0;
        this.b = v;
        this.c = f;
        this.f = k0;
        this.g = a0;
        this.d = v1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                H.h(((CARD)this.e), this.b, this.c, ((we.k)this.f), ((we.a)this.g), ((l)object0), (this.d | 1) & -920350135 | ((0x24924924 & (this.d | 1)) >> 1 | 306783378 & (this.d | 1)) | (306783378 & (this.d | 1)) << 1 & (0x24924924 & (this.d | 1)));
                return ie.H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                j.a(this.b, ((List)this.e), ((List)this.f), ((k)this.g), this.c, ((l)object0), (this.d | 1) & -920350135 | ((0x24924924 & (this.d | 1)) >> 1 | 306783378 & (this.d | 1)) | (306783378 & (this.d | 1)) << 1 & (0x24924924 & (this.d | 1)));
                return ie.H.a;
            }
            default: {
                ((Integer)object1).getClass();
                w.a(this.b, ((List)this.e), ((List)this.f), this.d, this.c, ((a)this.g), ((l)object0), 1);
                return ie.H.a;
            }
        }
    }
}

