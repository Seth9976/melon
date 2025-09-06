package r0;

import we.k;
import we.n;

public interface q {
    boolean all(k arg1);

    boolean any(k arg1);

    Object foldIn(Object arg1, n arg2);

    default q then(q q0) {
        return q0 == r0.n.a ? this : new r0.k(this, q0);
    }
}

