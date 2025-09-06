package yc;

import androidx.appcompat.app.o;
import com.melon.net.res.common.SongInfoBase;
import gd.Z3;
import kotlin.jvm.internal.q;

public final class t extends Z3 {
    public final int a;
    public final SongInfoBase b;
    public final boolean c;

    public t(int v, SongInfoBase songInfoBase0, boolean z) {
        q.g(songInfoBase0, "songInfoBase");
        super();
        this.a = v;
        this.b = songInfoBase0;
        this.c = z;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof t && this.a == ((t)object0).a && q.b(this.b, ((t)object0).b) && this.c == ((t)object0).c;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.c) + (this.b.hashCode() + this.a * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ClickPlayButton(index=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", songInfoBase=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", isThumbnailButton=");
        return o.s(stringBuilder0, this.c, ")");
    }
}

