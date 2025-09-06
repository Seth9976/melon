package sc;

import A7.d;
import com.iloen.melon.constants.AddPosition;
import com.iloen.melon.constants.ListKeepOption;
import java.util.List;
import kotlin.jvm.internal.q;

public final class h1 {
    public final List a;
    public final AddPosition b;
    public final boolean c;
    public final ListKeepOption d;

    public h1(List list0, AddPosition addPosition0, boolean z, ListKeepOption listKeepOption0) {
        q.g(addPosition0, "addPositionOption");
        q.g(listKeepOption0, "listKeepOption");
        super();
        this.a = list0;
        this.b = addPosition0;
        this.c = z;
        this.d = listKeepOption0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof h1)) {
            return false;
        }
        if(!q.b(this.a, ((h1)object0).a)) {
            return false;
        }
        if(this.b != ((h1)object0).b) {
            return false;
        }
        return this.c == ((h1)object0).c ? this.d == ((h1)object0).d : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? this.d.hashCode() + d.e(this.b.hashCode() * 0x1F, 0x1F, this.c) : this.d.hashCode() + d.e((this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F, 0x1F, this.c);
    }

    @Override
    public final String toString() {
        return "ServerSyncData(tracks=" + this.a + ", addPositionOption=" + this.b + ", removeDuplicated=" + this.c + ", listKeepOption=" + this.d + ")";
    }
}

