package n4;

import kotlin.jvm.internal.q;

public final class a {
    public final String a;
    public final boolean b;

    public a(String s, boolean z) {
        this.a = s;
        this.b = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof a ? q.b(this.a, ((a)object0).a) && this.b == ((a)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.b) + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "AdId: adId=" + this.a + ", isLimitAdTrackingEnabled=" + this.b;
    }
}

