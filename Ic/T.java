package Ic;

import A7.d;
import U4.x;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class t implements K4 {
    public final String a;
    public final u b;
    public final String c;
    public final String d;

    public t(String s, u u0, String s1, String s2) {
        this.a = s;
        this.b = u0;
        this.c = s1;
        this.d = s2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof t)) {
            return false;
        }
        if(!q.b(this.a, ((t)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((t)object0).b)) {
            return false;
        }
        return q.b(this.c, ((t)object0).c) ? q.b(this.d, ((t)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode() + x.b((this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F, 0x1F, this.c);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("HiRisingUiState(seq=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", link=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", buttonBgColor=");
        return d.n(stringBuilder0, this.c, ", buttonFontColor=", this.d, ")");
    }
}

