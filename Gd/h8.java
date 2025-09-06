package gd;

import A7.d;
import java.util.List;
import kotlin.jvm.internal.q;

public final class h8 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final List f;

    public h8(String s, String s1, String s2, String s3, boolean z, List list0) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = z;
        this.f = list0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof h8)) {
            return false;
        }
        if(!q.b(this.a, ((h8)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((h8)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((h8)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((h8)object0).d)) {
            return false;
        }
        return this.e == ((h8)object0).e ? q.b(this.f, ((h8)object0).f) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        String s = this.d;
        if(s != null) {
            v = s.hashCode();
        }
        return this.f.hashCode() + d.e((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v) * 0x1F, 0x1F, this.e);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("TodayTagData(tagSeq=", this.a, ", tagName=", this.b, ", count=");
        d.u(stringBuilder0, this.c, ", imageUrl=", this.d, ", isLike=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", list=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

