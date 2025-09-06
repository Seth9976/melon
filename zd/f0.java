package zd;

import Ad.C;
import com.iloen.melon.constants.AddPosition;
import kotlin.jvm.internal.q;

public final class f0 extends C {
    public final Q a;
    public final M b;
    public final AddPosition c;

    public f0(Q q0, M m0, AddPosition addPosition0) {
        q.g(q0, "popupType");
        q.g(m0, "itemId");
        super();
        this.a = q0;
        this.b = m0;
        this.c = addPosition0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof f0)) {
            return false;
        }
        if(!q.b(this.a, ((f0)object0).a)) {
            return false;
        }
        return this.b == ((f0)object0).b ? this.c == ((f0)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClickAddPositionButton(popupType=" + this.a + ", itemId=" + this.b + ", addPosition=" + this.c + ")";
    }
}

