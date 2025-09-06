package ud;

import kotlin.jvm.internal.q;

public final class e0 extends g0 {
    public final String a;
    public final String b;

    public e0(String s, String s1) {
        q.g(s, "bbsChannelSeq");
        q.g(s1, "bbsContsId");
        super();
        this.a = s;
        this.b = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof e0)) {
            return false;
        }
        return q.b(this.a, ((e0)object0).a) ? q.b(this.b, ((e0)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ShowCommentPopup(bbsChannelSeq=" + this.a + ", bbsContsId=" + this.b + ")";
    }
}

