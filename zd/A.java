package zd;

import java.util.ArrayList;
import kotlin.jvm.internal.q;

public final class a extends D0 {
    public final M a;

    public a(M m0) {
        q.g(m0, "id");
        super();
        this.a = m0;
    }

    @Override  // zd.D0
    public final String a() {
        return "";
    }

    @Override  // zd.Q
    public final ArrayList c() {
        ArrayList arrayList0 = new ArrayList();
        if(this.a == M.S) {
            arrayList0.add(x.p0);
            arrayList0.add(x.r0);
            arrayList0.add(x.q0);
            return arrayList0;
        }
        arrayList0.add(x.p0);
        arrayList0.add(x.q0);
        return arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof a ? this.a == ((a)object0).a : false;
    }

    @Override  // zd.Q
    public final int g() {
        return 34;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override  // zd.Q
    public final String r() {
        switch(this.a.ordinal()) {
            case 24: {
                return "";
            }
            case 25: {
                return "";
            }
            default: {
                return "";
            }
        }
    }

    @Override
    public final String toString() {
        return "AddPositionPopupType(id=" + this.a + ")";
    }
}

