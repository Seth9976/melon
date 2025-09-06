package Ic;

import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class x implements K4 {
    public final v a;
    public final y b;

    public x(v v0, y y0) {
        this.a = v0;
        this.b = y0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof x)) {
            return false;
        }
        return q.b(this.a, ((x)object0).a) ? q.b(this.b, ((x)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "RatingInfoUiState(notice=" + this.a + ", rating=" + this.b + ")";
    }
}

