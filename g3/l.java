package g3;

import H6.g;
import java.util.Map.Entry;

public final class l implements g {
    public final int a;

    public l(int v) {
        this.a = v;
        super();
    }

    @Override  // H6.g
    public final boolean apply(Object object0) {
        return this.a == 0 ? ((Map.Entry)object0).getKey() != null : ((String)object0) != null;
    }
}

