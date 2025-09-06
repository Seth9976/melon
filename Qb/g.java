package qb;

import com.iloen.melon.constants.AddPosition;
import java.util.List;
import kotlin.jvm.internal.q;

public final class g {
    public final List a;
    public final AddPosition b;
    public final AddPosition c;
    public final AddPosition d;

    public g(List list0, AddPosition addPosition0, AddPosition addPosition1, AddPosition addPosition2) {
        q.g(list0, "list");
        super();
        this.a = list0;
        this.b = addPosition0;
        this.c = addPosition1;
        this.d = addPosition2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof g)) {
            return false;
        }
        if(!q.b(this.a, ((g)object0).a)) {
            return false;
        }
        if(this.b != ((g)object0).b) {
            return false;
        }
        return this.c == ((g)object0).c ? this.d == ((g)object0).d : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        int v1 = 0;
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        AddPosition addPosition0 = this.d;
        if(addPosition0 != null) {
            v1 = addPosition0.hashCode();
        }
        return ((v * 0x1F + v2) * 0x1F + v3) * 0x1F + v1;
    }

    @Override
    public final String toString() {
        return "ContextItemList(list=" + this.a + ", addPosition=" + this.b + ", addNormalPlaylistPosition=" + this.c + ", addDjPlaylistPosition=" + this.d + ")";
    }
}

