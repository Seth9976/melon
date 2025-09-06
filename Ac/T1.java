package Ac;

import kotlin.jvm.internal.q;

public final class t1 implements C1 {
    public final String a;
    public final String b;

    public t1(String s, String s1) {
        q.g(s1, "cmtSeq");
        super();
        this.a = s;
        this.b = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof t1)) {
            return false;
        }
        return q.b(this.a, ((t1)object0).a) ? q.b(this.b, ((t1)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "AttachmentLinkVideoItemClickEvent(originalUrl=" + this.a + ", cmtSeq=" + this.b + ")";
    }
}

