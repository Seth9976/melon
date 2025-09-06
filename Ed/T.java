package ed;

import androidx.compose.runtime.l;
import com.melon.net.res.SearchMainContentRes.ThemeOffering;
import d3.g;
import ie.H;
import we.k;
import we.n;

public final class t implements n {
    public final int a;
    public final String b;
    public final int c;
    public final k d;
    public final int e;
    public final Object f;
    public final Object g;
    public final Object h;

    public t(a z$a0, ThemeOffering searchMainContentRes$ThemeOffering0, b0 b00, String s, int v, k k0, int v1) {
        this.a = 0;
        super();
        this.f = z$a0;
        this.g = searchMainContentRes$ThemeOffering0;
        this.h = b00;
        this.b = s;
        this.c = v;
        this.d = k0;
        this.e = v1;
    }

    public t(String s, String s1, String s2, String s3, int v, k k0, int v1) {
        this.a = 1;
        super();
        this.b = s;
        this.f = s1;
        this.g = s2;
        this.h = s3;
        this.c = v;
        this.d = k0;
        this.e = v1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            ((Integer)object1).getClass();
            g.C(this.b, ((String)this.f), ((String)this.g), ((String)this.h), this.c, this.d, ((l)object0), (this.e | 1) & -920350135 | ((0x24924924 & (this.e | 1)) >> 1 | 306783378 & (this.e | 1)) | (306783378 & (this.e | 1)) << 1 & (0x24924924 & (this.e | 1)));
            return H.a;
        }
        ((Integer)object1).getClass();
        ((a)this.f).s(((ThemeOffering)this.g), ((b0)this.h), this.b, this.c, this.d, ((l)object0), (this.e | 1) & -920350135 | ((0x24924924 & (this.e | 1)) >> 1 | 306783378 & (this.e | 1)) | (306783378 & (this.e | 1)) << 1 & (0x24924924 & (this.e | 1)));
        return H.a;
    }
}

