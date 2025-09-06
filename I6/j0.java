package I6;

import H6.k;
import java.io.Serializable;
import java.util.ArrayList;

public final class j0 implements k, Serializable {
    public final int a;

    public j0() {
        w.c(2, "expectedValuesPerKey");
        this.a = 2;
    }

    @Override  // H6.k
    public final Object get() {
        return new ArrayList(this.a);
    }
}

