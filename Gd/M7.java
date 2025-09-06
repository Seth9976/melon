package gd;

import kotlin.jvm.internal.q;

public final class m7 extends Z3 {
    public final String a;

    public m7(String s) {
        q.g(s, "tagSeq");
        super();
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof m7 ? q.b(this.a, ((m7)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ClickTagItemInPlaylist(tagSeq=" + this.a + ")";
    }
}

