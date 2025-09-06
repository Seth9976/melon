package Ac;

import kotlin.jvm.internal.q;

public final class o0 extends p0 {
    public final String a;
    public final int b;

    public o0(String s, int v) {
        q.g(s, "musicType");
        super();
        this.a = s;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof o0)) {
            return false;
        }
        return q.b(this.a, ((o0)object0).a) ? this.b == ((o0)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.b + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClickFilter(musicType=" + this.a + ", filterIndex=" + this.b + ")";
    }
}

