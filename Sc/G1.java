package sc;

import A7.d;
import androidx.appcompat.app.o;
import java.util.List;
import kotlin.jvm.internal.q;
import oc.L;
import oc.M;
import oc.N;
import oc.O;
import oc.P;
import oc.Q;
import oc.y0;

public final class g1 implements L, N, O, P, Q {
    public final List a;
    public final int b;
    public final M c;
    public final boolean d;
    public final y0 e;
    public final List f;
    public final boolean g;

    public g1(List list0, int v, M m0, boolean z, y0 y00, List list1, boolean z1) {
        q.g(list0, "playableDataList");
        q.g(y00, "sortType");
        super();
        this.a = list0;
        this.b = v;
        this.c = m0;
        this.d = z;
        this.e = y00;
        this.f = list1;
        this.g = z1;
    }

    @Override  // oc.P
    public final y0 a() {
        return this.e;
    }

    @Override  // oc.Q
    public final int b() {
        return this.b;
    }

    @Override  // oc.Q
    public final List c() {
        return this.a;
    }

    @Override  // oc.O
    public final List d() {
        return this.f;
    }

    @Override  // oc.L
    public final boolean e() {
        return this.g;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof g1)) {
            return false;
        }
        if(!q.b(this.a, ((g1)object0).a)) {
            return false;
        }
        if(this.b != ((g1)object0).b) {
            return false;
        }
        if(this.c != ((g1)object0).c) {
            return false;
        }
        if(this.d != ((g1)object0).d) {
            return false;
        }
        if(!q.b(this.e, ((g1)object0).e)) {
            return false;
        }
        return q.b(this.f, ((g1)object0).f) ? this.g == ((g1)object0).g : false;
    }

    public static g1 f(g1 g10, List list0, int v, M m0, boolean z, y0 y00, List list1, boolean z1, int v1) {
        if((v1 & 1) != 0) {
            list0 = g10.a;
        }
        if((v1 & 2) != 0) {
            v = g10.b;
        }
        if((v1 & 4) != 0) {
            m0 = g10.c;
        }
        if((v1 & 8) != 0) {
            z = g10.d;
        }
        if((v1 & 16) != 0) {
            y00 = g10.e;
        }
        if((v1 & 0x20) != 0) {
            list1 = g10.f;
        }
        if((v1 & 0x40) != 0) {
            z1 = g10.g;
        }
        g10.getClass();
        q.g(list0, "playableDataList");
        q.g(m0, "repeatMode");
        q.g(y00, "sortType");
        q.g(list1, "selectRepeatIndices");
        return new g1(list0, v, m0, z, y00, list1, z1);
    }

    @Override  // oc.N
    public final M getRepeatMode() {
        return this.c;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.g) + d.d((this.e.hashCode() + d.e((this.c.hashCode() + d.b(this.b, this.a.hashCode() * 0x1F, 0x1F)) * 0x1F, 0x1F, this.d)) * 0x1F, 0x1F, this.f);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SmartPlaylistState(playableDataList=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", currentIndex=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", repeatMode=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", isShuffle=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", sortType=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", selectRepeatIndices=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", isOfflineMode=");
        return o.s(stringBuilder0, this.g, ")");
    }
}

