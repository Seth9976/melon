package uc;

import A7.d;
import Cb.i;
import com.iloen.melon.net.v6x.response.LiveDetailRes;
import java.util.List;
import je.w;
import k8.Y;
import kotlin.jvm.internal.q;
import oc.Q;

public final class k implements Q {
    public final List a;
    public final int b;
    public final LiveDetailRes c;
    public static final k d;

    static {
        k.d = new k(w.a, -1, null);
    }

    public k(List list0, int v, LiveDetailRes liveDetailRes0) {
        q.g(list0, "playableDataList");
        super();
        this.a = list0;
        this.b = v;
        this.c = liveDetailRes0;
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
        if(!(object0 instanceof k)) {
            return false;
        }
        if(!q.b(this.a, ((k)object0).a)) {
            return false;
        }
        return this.b == ((k)object0).b ? q.b(this.c, ((k)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        int v = d.b(this.b, this.a.hashCode() * 0x1F, 0x1F);
        return this.c == null ? v : v + this.c.hashCode();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = Y.p("LivePlaylistState(");
        i.a(stringBuilder0, "playableDataList=" + this.a.size() + ", ");
        i.a(stringBuilder0, "currentIndex=" + this.b + ", ");
        i.a(stringBuilder0, ")");
        return stringBuilder0.toString();
    }
}

