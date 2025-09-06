package G;

import U.b0;
import U.g;
import Y.Q;
import androidx.compose.foundation.lazy.layout.v;
import androidx.compose.foundation.q;
import androidx.compose.runtime.l;
import androidx.compose.runtime.m0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.tooling.ComposeViewAdapter;
import ie.H;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.r;
import m0.b;
import we.k;
import we.n;

public final class s0 extends r implements n {
    public final int f;
    public final int g;
    public final Object h;
    public final Object i;

    public s0(int v, v v1, Object object0) {
        this.f = 4;
        this.h = v1;
        this.g = v;
        this.i = object0;
        super(2);
    }

    public s0(Object object0, Object object1, int v, int v1) {
        this.f = v1;
        this.h = object0;
        this.i = object1;
        this.g = v;
        super(2);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.f) {
            case 0: {
                ((Number)object1).intValue();
                ((t0)this.h).a(this.i, ((l)object0), (this.g | 1) & -920350135 | ((0x24924924 & (this.g | 1)) >> 1 | 306783378 & (this.g | 1)) | (306783378 & (this.g | 1)) << 1 & (0x24924924 & (this.g | 1)));
                return H.a;
            }
            case 1: {
                ((Number)object1).intValue();
                g.a(((a1.g)this.h), ((List)this.i), ((l)object0), (this.g | 1) & -920350135 | ((0x24924924 & (this.g | 1)) >> 1 | 306783378 & (this.g | 1)) | (306783378 & (this.g | 1)) << 1 & (0x24924924 & (this.g | 1)));
                return H.a;
            }
            case 2: {
                ((Number)object1).intValue();
                b0.e(((Q)this.h), ((b)this.i), ((l)object0), (this.g | 1) & -920350135 | ((0x24924924 & (this.g | 1)) >> 1 | 306783378 & (this.g | 1)) | (306783378 & (this.g | 1)) << 1 & (0x24924924 & (this.g | 1)));
                return H.a;
            }
            case 3: {
                ((Number)object1).intValue();
                q.b(((r0.q)this.h), ((k)this.i), ((l)object0), (this.g | 1) & -920350135 | ((0x24924924 & (this.g | 1)) >> 1 | 306783378 & (this.g | 1)) | (306783378 & (this.g | 1)) << 1 & (0x24924924 & (this.g | 1)));
                return H.a;
            }
            case 4: {
                int v = ((Number)object1).intValue();
                if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                    ((v)this.h).d(this.g, this.i, ((p)(((l)object0))));
                    return H.a;
                }
                ((p)(((l)object0))).T();
                return H.a;
            }
            case 5: {
                ((Number)object1).intValue();
                w.b(((m0[])Arrays.copyOf(((m0[])this.h), ((m0[])this.h).length)), ((n)this.i), ((l)object0), (this.g | 1) & -920350135 | ((0x24924924 & (this.g | 1)) >> 1 | 306783378 & (this.g | 1)) | (306783378 & (this.g | 1)) << 1 & (0x24924924 & (this.g | 1)));
                return H.a;
            }
            case 6: {
                ((Number)object1).intValue();
                w.a(((m0)this.h), ((b)this.i), ((l)object0), (this.g | 1) & -920350135 | ((0x24924924 & (this.g | 1)) >> 1 | 306783378 & (this.g | 1)) | (306783378 & (this.g | 1)) << 1 & (0x24924924 & (this.g | 1)));
                return H.a;
            }
            case 7: {
                ((Number)object1).intValue();
                ((b)this.h).e(this.i, ((l)object0), this.g & -920350135 | ((0x24924924 & this.g) >> 1 | 306783378 & this.g) | (306783378 & this.g) << 1 & (0x24924924 & this.g) | 1);
                return H.a;
            }
            default: {
                ((Number)object1).intValue();
                ComposeViewAdapter.a(((ComposeViewAdapter)this.h), ((b)this.i), ((l)object0), (this.g | 1) & -920350135 | ((0x24924924 & (this.g | 1)) >> 1 | 306783378 & (this.g | 1)) | (306783378 & (this.g | 1)) << 1 & (0x24924924 & (this.g | 1)));
                return H.a;
            }
        }
    }
}

