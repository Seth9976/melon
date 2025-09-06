package rf;

import java.io.Serializable;
import java.util.Collections;

public abstract class m extends a implements Serializable {
    public static l e(a a0, a a1, int v, J j0, Class class0) {
        return new l(a0, Collections.EMPTY_LIST, a1, new k(v, j0, true), class0);
    }

    public static l f(a a0, Object object0, a a1, int v, J j0, Class class0) {
        return new l(a0, object0, a1, new k(v, j0, false), class0);
    }
}

