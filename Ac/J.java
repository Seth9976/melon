package ac;

import A7.d;
import U4.x;
import kotlin.jvm.internal.q;

public final class j {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public static final j f;

    static {
        j.f = new j("", "", "", "", "");
    }

    public j(String s, String s1, String s2, String s3, String s4) {
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
        if(!(object0 instanceof j)) {
            return false;
        }
        if(!q.b(this.a, ((j)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((j)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((j)object0).c)) {
            return false;
        }
        return q.b(this.d, ((j)object0).d) ? q.b(this.e, ((j)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        return this.e.hashCode() + x.b(x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("AudioEffectInfo(contentId=", this.a, ", cTypeCode=", this.b, ", solTypeCode=");
        d.u(stringBuilder0, this.c, ", regDate=", this.d, ", metadata=");
        return x.m(stringBuilder0, this.e, ")");
    }
}

