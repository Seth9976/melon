package Lc;

import Bb.c;
import U4.x;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class r implements K4 {
    public final boolean a;
    public final c b;
    public final long c;

    public r(boolean z, c c0, long v) {
        q.g(c0, "item");
        super();
        this.a = z;
        this.b = c0;
        this.c = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof r)) {
            return false;
        }
        if(this.a != ((r)object0).a) {
            return false;
        }
        return q.b(this.b, ((r)object0).b) ? this.c == ((r)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.c) + (this.b.hashCode() + Boolean.hashCode(this.a) * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("PendingItemUiState(isFirst=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", item=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", currentBytes=");
        return x.h(this.c, ")", stringBuilder0);
    }
}

