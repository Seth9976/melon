package jd;

import androidx.compose.runtime.l;
import com.melon.net.res.common.SongInfoBase;
import d3.g;
import e1.x;
import ie.H;
import kd.T;
import r0.q;
import we.a;
import we.k;
import we.n;

public final class b2 implements n {
    public final int a;
    public final int b;
    public final boolean c;
    public final Object d;
    public final int e;
    public final Object f;

    public b2(int v, boolean z, SongInfoBase songInfoBase0, k k0, int v1) {
        this.a = 1;
        super();
        this.b = v;
        this.c = z;
        this.f = songInfoBase0;
        this.d = k0;
        this.e = v1;
    }

    public b2(Object object0, boolean z, Object object1, int v, int v1, int v2) {
        this.a = v2;
        this.f = object0;
        this.c = z;
        this.d = object1;
        this.b = v;
        this.e = v1;
        super();
    }

    public b2(String s, String s1, int v, boolean z, int v1) {
        this.a = 4;
        super();
        this.f = s;
        this.d = s1;
        this.c = z;
        this.b = v;
        this.e = v1;
    }

    public b2(boolean z, String s, int v, k k0, int v1) {
        this.a = 0;
        super();
        this.b = v;
        this.f = s;
        this.c = z;
        this.d = k0;
        this.e = v1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).intValue();
                n2.f(this.b, ((String)this.f), this.c, ((k)this.d), ((l)object0), (this.e | 1) & -920350135 | ((0x24924924 & (this.e | 1)) >> 1 | 306783378 & (this.e | 1)) | (306783378 & (this.e | 1)) << 1 & (0x24924924 & (this.e | 1)));
                return H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                U2.b(this.b, this.c, ((SongInfoBase)this.f), ((k)this.d), ((l)object0), (this.e | 1) & -920350135 | ((0x24924924 & (this.e | 1)) >> 1 | 306783378 & (this.e | 1)) | (306783378 & (this.e | 1)) << 1 & (0x24924924 & (this.e | 1)));
                return H.a;
            }
            case 2: {
                ((Integer)object1).getClass();
                T.c(((String)this.f), this.c, ((q)this.d), this.b, ((l)object0), (this.e | 1) & -920350135 | ((0x24924924 & (this.e | 1)) >> 1 | 306783378 & (this.e | 1)) | (306783378 & (this.e | 1)) << 1 & (0x24924924 & (this.e | 1)));
                return H.a;
            }
            case 3: {
                ((Integer)object1).getClass();
                x.f(((q)this.f), this.c, ((a)this.d), ((l)object0), (this.b | 1) & -920350135 | ((0x24924924 & (this.b | 1)) >> 1 | 306783378 & (this.b | 1)) | (306783378 & (this.b | 1)) << 1 & (0x24924924 & (this.b | 1)), this.e);
                return H.a;
            }
            default: {
                ((Integer)object1).getClass();
                g.A(((String)this.f), ((String)this.d), this.c, ((l)object0), (this.b | 1) & -920350135 | ((0x24924924 & (this.b | 1)) >> 1 | 306783378 & (this.b | 1)) | (306783378 & (this.b | 1)) << 1 & (0x24924924 & (this.b | 1)), this.e);
                return H.a;
            }
        }
    }
}

