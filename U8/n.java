package U8;

import androidx.compose.runtime.l;
import com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListItemKt;
import ie.H;
import java.util.List;
import jd.U2;
import r0.q;
import we.k;

public final class n implements we.n {
    public final int a;
    public final Object b;
    public final boolean c;
    public final int d;
    public final int e;
    public final int f;
    public final Object g;

    public n(String s, q q0, boolean z, int v, int v1, int v2) {
        this.a = 1;
        super();
        this.g = s;
        this.b = q0;
        this.c = z;
        this.d = v;
        this.e = v1;
        this.f = v2;
    }

    public n(List list0, boolean z, int v, int v1, int v2, k k0, int v3) {
        this.a = 2;
        super();
        this.b = list0;
        this.c = z;
        this.d = v;
        this.e = v1;
        this.f = v2;
        this.g = k0;
    }

    public n(q q0, boolean z, k k0, int v, int v1, int v2) {
        this.a = 0;
        super();
        this.b = q0;
        this.c = z;
        this.g = k0;
        this.d = v;
        this.e = v1;
        this.f = v2;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                p.b(((q)this.b), this.c, ((k)this.g), this.d, this.e, ((l)object0), (this.f | 1) & -920350135 | ((0x24924924 & (this.f | 1)) >> 1 | 306783378 & (this.f | 1)) | (306783378 & (this.f | 1)) << 1 & (0x24924924 & (this.f | 1)));
                return H.a;
            }
            case 1: {
                ((Integer)object1).intValue();
                DrawerPlytListItemKt.DrawerPlytPlytThumbSingle(((String)this.g), ((q)this.b), this.c, this.d, ((l)object0), (this.e | 1) & -920350135 | ((0x24924924 & (this.e | 1)) >> 1 | 306783378 & (this.e | 1)) | (306783378 & (this.e | 1)) << 1 & (0x24924924 & (this.e | 1)), this.f);
                return H.a;
            }
            default: {
                ((Integer)object1).getClass();
                U2.d(((List)this.b), this.c, this.d, this.e, this.f, ((k)this.g), ((l)object0), 1);
                return H.a;
            }
        }
    }
}

