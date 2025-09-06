package rf;

import java.util.Iterator;

public final class A implements Iterable {
    @Override
    public final Iterator iterator() {
        return B.a;
    }
}

