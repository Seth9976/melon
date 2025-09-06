package zd;

import A7.d;
import Ad.C;
import U4.x;
import kotlin.jvm.internal.q;

public final class m0 extends C {
    public final boolean a;
    public final int b;
    public final String c;

    public m0(boolean z, int v, String s) {
        q.g(s, "contsTypeCode");
        super();
        this.a = z;
        this.b = v;
        this.c = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof m0)) {
            return false;
        }
        if(this.a != ((m0)object0).a) {
            return false;
        }
        return this.b == ((m0)object0).b ? q.b(this.c, ((m0)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + d.b(this.b, Boolean.hashCode(this.a) * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("UpdateLikeUi(isLiked=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", likeCount=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", contsTypeCode=");
        return x.m(stringBuilder0, this.c, ")");
    }
}

