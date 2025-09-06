package yc;

import A7.d;
import com.melon.net.res.common.SongInfoBase;
import gd.Z3;
import kotlin.jvm.internal.q;

public final class n extends Z3 {
    public final boolean a;
    public final int b;
    public final SongInfoBase c;

    public n(int v, SongInfoBase songInfoBase0, boolean z) {
        q.g(songInfoBase0, "songInfoBase");
        super();
        this.a = z;
        this.b = v;
        this.c = songInfoBase0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof n && this.a == ((n)object0).a && this.b == ((n)object0).b && q.b(this.c, ((n)object0).c);
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + d.b(this.b, Boolean.hashCode(this.a) * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        return "ClickAlbum(isTopList=" + this.a + ", index=" + this.b + ", songInfoBase=" + this.c + ")";
    }
}

