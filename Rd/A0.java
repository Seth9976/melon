package rd;

import A7.d;
import java.util.List;
import k8.Y;
import kotlin.jvm.internal.q;

public final class a0 implements b0 {
    public final D0 a;
    public final List b;
    public final List c;

    public a0(D0 d00, List list0, List list1) {
        q.g(list1, "extraBottomMenus");
        super();
        this.a = d00;
        this.b = list0;
        this.c = list1;
    }

    public static a0 a(a0 a00, D0 d00, List list0, int v) {
        if((v & 1) != 0) {
            d00 = a00.a;
        }
        List list1 = a00.b;
        if((v & 4) != 0) {
            list0 = a00.c;
        }
        a00.getClass();
        q.g(d00, "playerUiState");
        q.g(list0, "extraBottomMenus");
        return new a0(d00, list1, list0);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof a0)) {
            return false;
        }
        if(!q.b(this.a, ((a0)object0).a)) {
            return false;
        }
        return q.b(this.b, ((a0)object0).b) ? q.b(this.c, ((a0)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + d.d(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Open(playerUiState=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", defaultBottomMenus=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", extraBottomMenus=");
        return Y.m(stringBuilder0, this.c, ")");
    }
}

