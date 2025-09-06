package eb;

import U4.x;
import com.melon.net.res.common.ResponseBase;

public final class q {
    public final ResponseBase a;
    public final String b;
    public final String c;

    public q(ResponseBase responseBase0, String s, String s1) {
        kotlin.jvm.internal.q.g(responseBase0, "response");
        super();
        this.a = responseBase0;
        this.b = s;
        this.c = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof q)) {
            return false;
        }
        if(!kotlin.jvm.internal.q.b(this.a, ((q)object0).a)) {
            return false;
        }
        return kotlin.jvm.internal.q.b(this.b, ((q)object0).b) ? kotlin.jvm.internal.q.b(this.c, ((q)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("PvLoggingData(response=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", url=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", prevMenuId=");
        return x.m(stringBuilder0, this.c, ")");
    }
}

