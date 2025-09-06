package ld;

import A7.d;
import com.melon.ui.c3;

public final class o extends r {
    public final boolean a;
    public final int b;
    public final c3 c;

    public o(boolean z, int v, c3 c30) {
        this.a = z;
        this.b = v;
        this.c = c30;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof o && this.a == ((o)object0).a && this.b == ((o)object0).b && this.c.equals(((o)object0).c);
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + d.b(this.b, Boolean.hashCode(this.a) * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        return "Error(filterVisible=" + this.a + ", filterIndex=" + this.b + ", errorUiState=" + this.c + ")";
    }
}

