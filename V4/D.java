package v4;

import U4.x;
import va.e;

public final class d {
    public final long a;
    public final long b;
    public final int c;

    public d(long v, long v1, int v2) {
        this.a = v;
        this.b = v1;
        this.c = v2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof d ? this.a == ((d)object0).a && this.b == ((d)object0).b && this.c == ((d)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return this.c + A7.d.c(Long.hashCode(this.a) * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("TaxonomyVersion=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", ModelVersion=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", TopicCode=");
        return e.b("Topic { ", x.g(this.c, " }", stringBuilder0));
    }
}

