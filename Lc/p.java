package Lc;

import Bb.c;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class p implements K4 {
    public final c a;

    public p(c c0) {
        q.g(c0, "item");
        super();
        this.a = c0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof p ? q.b(this.a, ((p)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "FailedItemUiState(item=" + this.a + ")";
    }
}

