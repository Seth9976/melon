package A8;

import U4.x;
import k8.Y;
import kotlin.jvm.internal.q;

public final class l {
    public final long a;
    public final String b;
    public final String c;

    public l(long v, String s, String s1) {
        q.g(s, "refreshToken");
        q.g(s1, "accessToken");
        super();
        this.a = v;
        this.b = s;
        this.c = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof l)) {
            return false;
        }
        if(this.a != ((l)object0).a) {
            return false;
        }
        return q.b(this.b, ((l)object0).b) ? q.b(this.c, ((l)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + x.b(Long.hashCode(this.a) * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("KakaoLoginData(userId=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", refreshToken=");
        stringBuilder0.append(this.b);
        return Y.l(stringBuilder0, ", accessToken=", this.c, ")");
    }
}

