package y9;

import A7.d;
import H0.b;
import U4.x;
import k8.Y;
import kotlin.jvm.internal.q;

public final class a {
    public int a;
    public String b;
    public String c;
    public String d;
    public String e;
    public long f;
    public String g;

    public a() {
        this.a = 0;
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = 0L;
        this.g = "0";
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof a)) {
            return false;
        }
        if(this.a != ((a)object0).a) {
            return false;
        }
        if(!q.b(this.b, ((a)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((a)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((a)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((a)object0).e)) {
            return false;
        }
        return this.f == ((a)object0).f ? q.b(this.g, ((a)object0).g) : false;
    }

    @Override
    public final int hashCode() {
        return this.g.hashCode() + d.c(x.b(x.b(x.b(x.b(this.a * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f);
    }

    @Override
    public final String toString() {
        String s = this.c;
        String s1 = this.d;
        String s2 = this.e;
        long v = this.f;
        String s3 = this.g;
        StringBuilder stringBuilder0 = x.o(this.a, "DcfLogEntity(uid=", ", cType=", this.b, ", cId=");
        d.u(stringBuilder0, s, ", mCode=", s1, ", lCode=");
        b.t(v, s2, ", extendTime=", stringBuilder0);
        return Y.l(stringBuilder0, ", memberKey=", s3, ")");
    }
}

