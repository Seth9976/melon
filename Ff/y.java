package Ff;

import java.util.List;
import je.w;
import kotlin.jvm.internal.q;

public final class y {
    public final boolean a;
    public final List b;

    public y(boolean z) {
        this.a = z;
        this.b = w.a;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof y)) {
            return false;
        }
        return this.a == ((y)object0).a ? q.b(this.b, ((y)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + Boolean.hashCode(this.a) * 0x1F;
    }

    @Override
    public final String toString() {
        return "PreReleaseInfo(isInvisible=" + this.a + ", poisoningFeatures=" + this.b + ')';
    }
}

