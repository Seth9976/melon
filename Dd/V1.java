package Dd;

import Ac.p0;
import kotlin.jvm.internal.q;

public final class v1 extends p0 {
    public final String a;

    public v1(String s) {
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof v1 ? q.b(this.a, ((v1)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Homepage(webSiteVal=" + this.a + ")";
    }
}

