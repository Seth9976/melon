package xd;

import A7.d;
import U4.x;
import com.melon.ui.I4;
import kotlin.jvm.internal.q;

public final class m implements I4 {
    public final String a;
    public final String b;
    public final int c;

    public m(String s, String s1, int v) {
        this.a = s;
        this.b = s1;
        this.c = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof m)) {
            return false;
        }
        if(!q.b(this.a, ((m)object0).a)) {
            return false;
        }
        return q.b(this.b, ((m)object0).b) ? this.c == ((m)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return this.c + x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("ClickListItem(artistId=", this.a, ", artistName=", this.b, ", position=");
        return x.g(this.c, ")", stringBuilder0);
    }
}

