package H6;

import java.io.Serializable;
import java.util.List;

public final class h implements g, Serializable {
    public final List a;
    private static final long serialVersionUID;

    public h(List list0) {
        this.a = list0;
    }

    @Override  // H6.g
    public final boolean apply(Object object0) {
        for(int v = 0; true; ++v) {
            List list0 = this.a;
            if(v >= list0.size()) {
                break;
            }
            if(!((g)list0.get(v)).apply(object0)) {
                return false;
            }
        }
        return true;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof h ? this.a.equals(((h)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode() + 306654252;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Predicates.and(");
        boolean z = true;
        for(Object object0: this.a) {
            if(!z) {
                stringBuilder0.append(',');
            }
            stringBuilder0.append(object0);
            z = false;
        }
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }
}

