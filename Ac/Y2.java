package Ac;

import A7.d;
import androidx.appcompat.app.o;
import java.util.List;
import kotlin.jvm.internal.q;

public final class y2 extends z2 {
    public final O2 a;
    public final List b;
    public final boolean c;

    public y2(O2 o20, List list0, boolean z) {
        this.a = o20;
        this.b = list0;
        this.c = z;
    }

    public static y2 a(y2 y20, O2 o20, int v) {
        if((v & 1) != 0) {
            o20 = y20.a;
        }
        y20.getClass();
        return new y2(o20, y20.b, ((v & 4) == 0 ? true : y20.c));
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof y2)) {
            return false;
        }
        if(!q.b(this.a, ((y2)object0).a)) {
            return false;
        }
        return q.b(this.b, ((y2)object0).b) ? this.c == ((y2)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.c) + d.d(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Success(comment=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", replyList=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", isInitInputMessage=");
        return o.s(stringBuilder0, this.c, ")");
    }
}

