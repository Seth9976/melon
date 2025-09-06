package pc;

import A7.d;
import java.util.List;
import kotlin.jvm.internal.q;
import oc.Q;

public final class z0 implements Q {
    public final List a;
    public final int b;
    public final c c;
    public final int d;

    public z0(List list0, int v, c c0, int v1) {
        q.g(list0, "playableDataList");
        super();
        this.a = list0;
        this.b = v;
        this.c = c0;
        this.d = v1;
    }

    @Override  // oc.Q
    public final int b() {
        return this.b;
    }

    @Override  // oc.Q
    public final List c() {
        return this.a;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof z0)) {
            return false;
        }
        if(!q.b(this.a, ((z0)object0).a)) {
            return false;
        }
        if(this.b != ((z0)object0).b) {
            return false;
        }
        return q.b(this.c, ((z0)object0).c) ? this.d == ((z0)object0).d : false;
    }

    public static z0 f(z0 z00, List list0, int v, int v1, int v2) {
        if((v2 & 1) != 0) {
            list0 = z00.a;
        }
        if((v2 & 2) != 0) {
            v = z00.b;
        }
        c c0 = z00.c;
        if((v2 & 8) != 0) {
            v1 = z00.d;
        }
        z00.getClass();
        q.g(list0, "playableDataList");
        return new z0(list0, v, c0, v1);
    }

    @Override
    public final int hashCode() {
        int v = d.b(this.b, this.a.hashCode() * 0x1F, 0x1F);
        return this.c == null ? this.d + v * 0x1F : this.d + (v + this.c.hashCode()) * 0x1F;
    }

    @Override
    public final String toString() {
        return "MixUpPlaylistState(playableDataList=" + this.a + ", currentIndex=" + this.b + ", mixUpInfo=" + this.c + ", firstPosOnWaitingList=" + this.d + ")";
    }
}

