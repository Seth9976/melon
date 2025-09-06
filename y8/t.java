package y8;

import A7.d;
import U4.x;
import kotlin.jvm.internal.q;

public final class t {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public t(String s, String s1, String s2, String s3, String s4) {
        q.g(s, "contentId");
        q.g(s1, "cTypeCode");
        q.g(s2, "solTypeCode");
        q.g(s3, "regDate");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof t)) {
            return false;
        }
        if(!q.b(this.a, ((t)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((t)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((t)object0).c)) {
            return false;
        }
        return q.b(this.d, ((t)object0).d) ? q.b(this.e, ((t)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        int v = x.b(x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d);
        return this.e == null ? v : v + this.e.hashCode();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("SolMetaData(contentId=", this.a, ", cTypeCode=", this.b, ", solTypeCode=");
        d.u(stringBuilder0, this.c, ", regDate=", this.d, ", metaData=");
        return x.m(stringBuilder0, this.e, ")");
    }
}

