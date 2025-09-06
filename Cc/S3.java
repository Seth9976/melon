package Cc;

import Fd.D;
import Fd.Z;
import Kd.g;
import androidx.compose.runtime.l;
import com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt;
import ie.H;
import r0.q;
import we.a;
import we.n;

public final class s3 implements n {
    public final int a;
    public final boolean b;
    public final long c;
    public final int d;
    public final int e;
    public final Object f;
    public final Object g;
    public final Object h;

    public s3(D d0, Z z0, boolean z1, long v, String s, int v1, int v2) {
        this.a = 1;
        super();
        this.f = d0;
        this.g = z0;
        this.b = z1;
        this.c = v;
        this.h = s;
        this.d = v1;
        this.e = v2;
    }

    public s3(q q0, g g0, long v, boolean z, a a0, int v1, int v2) {
        this.a = 0;
        super();
        this.f = q0;
        this.g = g0;
        this.c = v;
        this.b = z;
        this.h = a0;
        this.d = v1;
        this.e = v2;
    }

    public s3(q q0, boolean z, String s, String s1, long v, int v1, int v2) {
        this.a = 2;
        super();
        this.f = q0;
        this.b = z;
        this.g = s;
        this.h = s1;
        this.c = v;
        this.d = v1;
        this.e = v2;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                c1.R(((q)this.f), ((g)this.g), this.c, this.b, ((a)this.h), ((l)object0), (this.d | 1) & -920350135 | ((0x24924924 & (this.d | 1)) >> 1 | 306783378 & (this.d | 1)) | (306783378 & (this.d | 1)) << 1 & (0x24924924 & (this.d | 1)), this.e);
                return H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                ((D)this.f).t(((Z)this.g), this.b, this.c, ((String)this.h), this.d, ((l)object0), (this.e | 1) & -920350135 | ((0x24924924 & (this.e | 1)) >> 1 | 306783378 & (this.e | 1)) | (306783378 & (this.e | 1)) << 1 & (0x24924924 & (this.e | 1)));
                return H.a;
            }
            default: {
                return TrendMusicWavePopularFragmentKt.ThumbnailTypeItem$lambda$11(((q)this.f), this.b, ((String)this.g), ((String)this.h), this.c, this.d, this.e, ((l)object0), ((int)(((Integer)object1))));
            }
        }
    }
}

