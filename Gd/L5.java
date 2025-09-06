package gd;

import kotlin.jvm.internal.q;

public final class l5 extends Z3 {
    public final String a;

    public l5(String s) {
        q.g(s, "playlistSeq");
        super();
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof l5 ? q.b(this.a, ((l5)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ClickConfirm(playlistSeq=" + this.a + ")";
    }
}

