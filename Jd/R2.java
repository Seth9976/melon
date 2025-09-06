package jd;

import gd.Z3;
import kotlin.jvm.internal.q;

public final class r2 extends Z3 {
    public final String a;

    public r2(String s) {
        q.g(s, "imageSeq");
        super();
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof r2 ? q.b(this.a, ((r2)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "DeleteArtistImage(imageSeq=" + this.a + ")";
    }
}

