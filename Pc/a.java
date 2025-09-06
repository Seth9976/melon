package pc;

import A7.d;
import U4.x;
import kotlin.jvm.internal.q;

public final class a implements c {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public a(String s, String s1, String s2, String s3) {
        q.g(s, "mainTitle");
        q.g(s1, "subTitle");
        q.g(s2, "contsIdForLogging");
        q.g(s3, "mixUpTypeForLogging");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof a)) {
            return false;
        }
        if(!q.b(this.a, ((a)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((a)object0).b)) {
            return false;
        }
        return q.b(this.c, ((a)object0).c) ? q.b(this.d, ((a)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode() + x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c);
    }

    @Override
    public final String toString() {
        return d.n(d.o("DefaultMixUpInfo(mainTitle=", this.a, ", subTitle=", this.b, ", contsIdForLogging="), this.c, ", mixUpTypeForLogging=", this.d, ")");
    }
}

