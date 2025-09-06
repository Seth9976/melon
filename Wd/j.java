package wd;

import gd.Z3;
import kotlin.jvm.internal.q;

public final class j extends Z3 {
    public final String a;

    public j(String s) {
        q.g(s, "playlistName");
        super();
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof j ? q.b(this.a, ((j)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "AddNewList(playlistName=" + this.a + ")";
    }
}

