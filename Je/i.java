package je;

import j0.e;
import j0.g;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import m0.f;
import xe.d;

public abstract class i extends AbstractMap implements Map, d {
    @Override
    public final Set entrySet() {
        return new e(0, ((f)this));
    }

    @Override
    public final Set keySet() {
        return new e(1, ((f)this));
    }

    @Override
    public final int size() {
        return ((f)this).e;
    }

    @Override
    public final Collection values() {
        return new g(((f)this), 0);
    }
}

