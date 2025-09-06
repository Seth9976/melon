package gd;

import A7.d;
import Ac.p0;
import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class n0 extends p0 {
    public final String a;
    public final boolean b;
    public final boolean c;

    public n0(String s, boolean z, boolean z1) {
        q.g(s, "memberKey");
        super();
        this.a = s;
        this.b = z;
        this.c = z1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof n0)) {
            return false;
        }
        if(!q.b(this.a, ((n0)object0).a)) {
            return false;
        }
        return this.b == ((n0)object0).b ? this.c == ((n0)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.c) + d.e(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ToggleFollow(memberKey=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", isMyFriend=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", isFollowing=");
        return o.s(stringBuilder0, this.c, ")");
    }
}

