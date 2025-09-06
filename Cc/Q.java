package Cc;

import androidx.compose.runtime.l;
import com.melon.net.res.MusicDnaMainRes.RESPONSE.MYRECENTLIST.MYGNRLIST;
import ie.H;
import java.util.List;
import we.a;
import we.k;
import we.n;

public final class q implements n {
    public final int a;
    public final Object b;
    public final int c;
    public final boolean d;
    public final int e;
    public final Object f;
    public final Object g;

    public q(MYGNRLIST musicDnaMainRes$RESPONSE$MYRECENTLIST$MYGNRLIST0, int v, boolean z, k k0, a a0, int v1) {
        this.a = 2;
        super();
        this.f = musicDnaMainRes$RESPONSE$MYRECENTLIST$MYGNRLIST0;
        this.c = v;
        this.d = z;
        this.b = k0;
        this.g = a0;
        this.e = v1;
    }

    public q(String s, boolean z, r0.q q0, a a0, int v, int v1) {
        this.a = 0;
        super();
        this.f = s;
        this.d = z;
        this.b = q0;
        this.g = a0;
        this.c = v;
        this.e = v1;
    }

    public q(List list0, int v, boolean z, String s, k k0, int v1) {
        this.a = 3;
        super();
        this.b = list0;
        this.c = v;
        this.d = z;
        this.f = s;
        this.g = k0;
        this.e = v1;
    }

    public q(r0.q q0, String s, N0.k k0, boolean z, int v, int v1) {
        this.a = 4;
        super();
        this.b = q0;
        this.f = s;
        this.g = k0;
        this.d = z;
        this.c = v;
        this.e = v1;
    }

    public q(r0.q q0, List list0, int v, boolean z, k k0, int v1) {
        this.a = 1;
        super();
        this.b = q0;
        this.f = list0;
        this.c = v;
        this.d = z;
        this.g = k0;
        this.e = v1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                e0.h(((String)this.f), this.d, ((r0.q)this.b), ((a)this.g), ((l)object0), (this.c | 1) & -920350135 | ((0x24924924 & (this.c | 1)) >> 1 | 306783378 & (this.c | 1)) | (306783378 & (this.c | 1)) << 1 & (0x24924924 & (this.c | 1)), this.e);
                return H.a;
            }
            case 1: {
                ((Integer)object1).intValue();
                hd.H.f(((r0.q)this.b), ((List)this.f), this.c, this.d, ((k)this.g), ((l)object0), (this.e | 1) & -920350135 | ((0x24924924 & (this.e | 1)) >> 1 | 306783378 & (this.e | 1)) | (306783378 & (this.e | 1)) << 1 & (0x24924924 & (this.e | 1)));
                return H.a;
            }
            case 2: {
                ((Integer)object1).getClass();
                hd.H.v(((MYGNRLIST)this.f), this.c, this.d, ((k)this.b), ((a)this.g), ((l)object0), (this.e | 1) & -920350135 | ((0x24924924 & (this.e | 1)) >> 1 | 306783378 & (this.e | 1)) | (306783378 & (this.e | 1)) << 1 & (0x24924924 & (this.e | 1)));
                return H.a;
            }
            case 3: {
                ((Integer)object1).getClass();
                hd.H.l(((List)this.b), this.c, this.d, ((String)this.f), ((k)this.g), ((l)object0), (this.e | 1) & -920350135 | ((0x24924924 & (this.e | 1)) >> 1 | 306783378 & (this.e | 1)) | (306783378 & (this.e | 1)) << 1 & (0x24924924 & (this.e | 1)));
                return H.a;
            }
            default: {
                ((Integer)object1).getClass();
                hd.a.g(((r0.q)this.b), ((String)this.f), ((N0.k)this.g), this.d, ((l)object0), (this.c | 1) & -920350135 | ((0x24924924 & (this.c | 1)) >> 1 | 306783378 & (this.c | 1)) | (306783378 & (this.c | 1)) << 1 & (0x24924924 & (this.c | 1)), this.e);
                return H.a;
            }
        }
    }
}

