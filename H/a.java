package H;

import De.I;
import F.g;
import N0.g0;
import N0.j0;
import U.L0;
import androidx.compose.runtime.l;
import ie.H;
import java.util.Arrays;
import kotlin.jvm.internal.r;
import m0.b;
import r0.e;
import r0.q;
import v1.p;
import we.k;
import we.n;

public final class a extends r implements n {
    public final int f;
    public final int g;
    public final Object h;
    public final Object i;
    public final Object j;

    public a(H.n n0, we.a a0, g g0, int v) {
        this.f = 0;
        this.h = n0;
        this.i = a0;
        this.j = g0;
        this.g = v;
        super(2);
    }

    public a(Object object0, Object object1, Object object2, int v, int v1) {
        this.f = v1;
        this.h = object0;
        this.i = object1;
        this.j = object2;
        this.g = v;
        super(2);
    }

    public a(String s, c c0, we.a a0, int v) {
        this.f = 1;
        this.h = s;
        this.i = c0;
        this.j = (r)a0;
        this.g = v;
        super(2);
    }

    public a(p p0, we.a a0, g g0, int v) {
        this.f = 2;
        this.h = p0;
        this.i = a0;
        this.j = g0;
        this.g = v;
        super(2);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.f) {
            case 0: {
                ((Number)object1).intValue();
                Q1.c.c(((H.n)this.h), ((we.a)this.i), r0.n.a, ((g)this.j), ((l)object0), (this.g | 1) & -920350135 | ((0x24924924 & (this.g | 1)) >> 1 | 306783378 & (this.g | 1)) | (306783378 & (this.g | 1)) << 1 & (0x24924924 & (this.g | 1)));
                return H.a;
            }
            case 1: {
                ((Number)object1).intValue();
                H.p.b(((String)this.h), ((c)this.i), ((we.a)(((r)this.j))), ((l)object0), (this.g | 1) & -920350135 | ((0x24924924 & (this.g | 1)) >> 1 | 306783378 & (this.g | 1)) | (306783378 & (this.g | 1)) << 1 & (0x24924924 & (this.g | 1)));
                return H.a;
            }
            case 2: {
                ((Number)object1).intValue();
                H.p.c(((p)this.h), ((we.a)this.i), ((g)this.j), ((l)object0), (this.g | 1) & -920350135 | ((0x24924924 & (this.g | 1)) >> 1 | 306783378 & (this.g | 1)) | (306783378 & (this.g | 1)) << 1 & (0x24924924 & (this.g | 1)));
                return H.a;
            }
            case 3: {
                ((Number)object1).intValue();
                g0.b(((j0)this.h), ((q)this.i), ((n)this.j), ((l)object0), (this.g | 1) & -920350135 | ((0x24924924 & (this.g | 1)) >> 1 | 306783378 & (this.g | 1)) | (306783378 & (this.g | 1)) << 1 & (0x24924924 & (this.g | 1)));
                return H.a;
            }
            case 4: {
                ((Number)object1).intValue();
                Object[] arr_object = Arrays.copyOf(((Object[])this.i), ((Object[])this.i).length);
                ((L0)this.h).b(arr_object, ((k)this.j), ((l)object0), (this.g | 1) & -920350135 | ((0x24924924 & (this.g | 1)) >> 1 | 306783378 & (this.g | 1)) | (306783378 & (this.g | 1)) << 1 & (0x24924924 & (this.g | 1)));
                return H.a;
            }
            case 5: {
                ((Number)object1).intValue();
                I.c(((Y.k)this.h), ((e)this.i), ((b)this.j), ((l)object0), (this.g | 1) & -920350135 | ((0x24924924 & (this.g | 1)) >> 1 | 306783378 & (this.g | 1)) | (306783378 & (this.g | 1)) << 1 & (0x24924924 & (this.g | 1)));
                return H.a;
            }
            default: {
                ((Number)object1).intValue();
                ((b)this.h).f(this.i, this.j, ((l)object0), this.g & -920350135 | ((0x24924924 & this.g) >> 1 | 306783378 & this.g) | (306783378 & this.g) << 1 & (0x24924924 & this.g) | 1);
                return H.a;
            }
        }
    }
}

