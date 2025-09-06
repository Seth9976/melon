package Ua;

import com.iloen.melon.net.v3x.comments.ListCmtRes;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import kotlin.jvm.internal.q;

public final class a {
    public final LoadPgnRes a;
    public final ListCmtRes b;

    public a(LoadPgnRes loadPgnRes0, ListCmtRes listCmtRes0) {
        q.g(loadPgnRes0, "loadPgnRes");
        q.g(listCmtRes0, "listCmtRes");
        super();
        this.a = loadPgnRes0;
        this.b = listCmtRes0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof a)) {
            return false;
        }
        return q.b(this.a, ((a)object0).a) ? q.b(this.b, ((a)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "CommentData(loadPgnRes=" + this.a + ", listCmtRes=" + this.b + ")";
    }
}

