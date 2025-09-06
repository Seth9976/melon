package td;

import com.melon.ui.playermusic.BgType;
import kotlin.jvm.internal.q;

public final class v1 {
    public final BgType a;
    public final BgType b;
    public final BgType c;
    public static final v1 d;

    static {
        v1.d = new v1(null, null, null);
    }

    public v1(BgType bgType0, BgType bgType1, BgType bgType2) {
        this.a = bgType0;
        this.b = bgType1;
        this.c = bgType2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof v1)) {
            return false;
        }
        if(!q.b(this.a, ((v1)object0).a)) {
            return false;
        }
        return q.b(this.b, ((v1)object0).b) ? q.b(this.c, ((v1)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        BgType bgType0 = this.c;
        if(bgType0 != null) {
            v = bgType0.hashCode();
        }
        return (v1 * 0x1F + v2) * 0x1F + v;
    }

    @Override
    public final String toString() {
        return "PageState(currentBgData=" + this.a + ", prevBgData=" + this.b + ", nextBgData=" + this.c + ")";
    }
}

