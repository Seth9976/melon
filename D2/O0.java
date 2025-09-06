package D2;

import A7.d;
import java.util.Map;
import je.x;
import kotlin.jvm.internal.q;

public final class o0 {
    public final int a;
    public final int b;
    public final Map c;

    public o0(int v, int v1, Map map0) {
        this.a = v;
        this.b = v1;
        this.c = map0;
    }

    public o0(int v, int v1, Map map0, int v2) {
        if((v2 & 1) != 0) {
            v = -1;
        }
        if((v2 & 2) != 0) {
            v1 = -1;
        }
        if((v2 & 4) != 0) {
            map0 = x.a;
        }
        this(v, v1, map0);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof o0)) {
            return false;
        }
        if(this.a != ((o0)object0).a) {
            return false;
        }
        return this.b == ((o0)object0).b ? q.b(this.c, ((o0)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + d.b(this.b, this.a * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        return "InsertedViewInfo(mainViewId=" + this.a + ", complexViewId=" + this.b + ", children=" + this.c + ')';
    }
}

