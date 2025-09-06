package gd;

import A7.d;
import kotlin.jvm.internal.q;

public final class a8 {
    public final String a;
    public final String b;
    public final boolean c;
    public final boolean d;

    public a8(String s, String s1, boolean z, boolean z1) {
        this.a = s;
        this.b = s1;
        this.c = z;
        this.d = z1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof a8)) {
            return false;
        }
        if(!q.b(this.a, ((a8)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((a8)object0).b)) {
            return false;
        }
        return this.c == ((a8)object0).c ? this.d == ((a8)object0).d : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? Boolean.hashCode(this.d) + d.e(v * 961, 0x1F, this.c) : Boolean.hashCode(this.d) + d.e((v * 0x1F + this.b.hashCode()) * 0x1F, 0x1F, this.c);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("LikeTagData(tag=", this.a, ", likeTagSeq=", this.b, ", isFirst=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", isLast=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

