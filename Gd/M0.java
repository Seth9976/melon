package gd;

import Ac.p0;
import kotlin.jvm.internal.q;

public final class m0 extends p0 {
    public final String a;

    public m0(String s) {
        q.g(s, "memberKey");
        super();
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof m0 ? q.b(this.a, ((m0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ClickFriendItem(memberKey=" + this.a + ")";
    }
}

