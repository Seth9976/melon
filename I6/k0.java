package I6;

import H6.k;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.SortedMap;

public final class k0 extends b {
    public transient k f;
    private static final long serialVersionUID;

    @Override  // I6.q
    public final f e() {
        Map map0 = this.d;
        if(map0 instanceof NavigableMap) {
            return new h(this, ((NavigableMap)this.d));
        }
        return map0 instanceof SortedMap ? new I6.k(this, ((SortedMap)this.d)) : new f(this, this.d, 0);
    }

    @Override  // I6.q
    public final Collection f() {
        return (List)this.f.get();
    }

    @Override  // I6.q
    public final g g() {
        Map map0 = this.d;
        if(map0 instanceof NavigableMap) {
            return new i(this, ((NavigableMap)this.d));
        }
        return map0 instanceof SortedMap ? new l(this, ((SortedMap)this.d)) : new g(this, this.d);
    }

    private void readObject(ObjectInputStream objectInputStream0) {
        objectInputStream0.defaultReadObject();
        Object object0 = objectInputStream0.readObject();
        Objects.requireNonNull(object0);
        this.f = (k)object0;
        Object object1 = objectInputStream0.readObject();
        Objects.requireNonNull(object1);
        this.i(((Map)object1));
    }

    private void writeObject(ObjectOutputStream objectOutputStream0) {
        objectOutputStream0.defaultWriteObject();
        objectOutputStream0.writeObject(this.f);
        objectOutputStream0.writeObject(this.d);
    }
}

