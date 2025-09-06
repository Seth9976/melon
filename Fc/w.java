package Fc;

import A7.d;
import androidx.appcompat.app.o;
import java.util.List;
import kotlin.jvm.internal.q;

public final class w extends x {
    public final String a;
    public final int b;
    public final boolean c;
    public final List d;

    public w(int v, String s, List list0, boolean z) {
        q.g(s, "title");
        q.g(list0, "list");
        super();
        this.a = s;
        this.b = v;
        this.c = z;
        this.d = list0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof w)) {
            return false;
        }
        if(!q.b(this.a, ((w)object0).a)) {
            return false;
        }
        if(this.b != ((w)object0).b) {
            return false;
        }
        return this.c == ((w)object0).c ? q.b(this.d, ((w)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode() + d.e(d.b(this.b, this.a.hashCode() * 0x1F, 0x1F), 0x1F, this.c);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = o.u(this.b, "Success(title=", this.a, ", currentPosition=", ", isPlaying=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", list=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

