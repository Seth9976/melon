package I6;

import java.util.Collection;
import java.util.Set;

public final class p extends m implements Set {
    public final u f;

    public p(u u0, Object object0, Set set0) {
        this.f = u0;
        super(u0, object0, set0, null);
    }

    @Override  // I6.m
    public final boolean removeAll(Collection collection0) {
        if(collection0.isEmpty()) {
            return false;
        }
        int v = this.size();
        boolean z = w.p(((Set)this.b), collection0);
        if(z) {
            this.f.e += this.b.size() - v;
            this.e();
        }
        return z;
    }
}

