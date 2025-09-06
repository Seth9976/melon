package I6;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class g extends D0 {
    public final Map b;
    public final q c;

    public g(q q0, Map map0) {
        this.c = q0;
        super(0);
        map0.getClass();
        this.b = map0;
    }

    @Override  // I6.D0
    public final void clear() {
        Iterator iterator0 = this.iterator();
        while(((e)iterator0).hasNext()) {
            ((e)iterator0).next();
            ((e)iterator0).remove();
        }
    }

    @Override
    public final boolean contains(Object object0) {
        return this.b.containsKey(object0);
    }

    @Override
    public final boolean containsAll(Collection collection0) {
        return this.b.keySet().containsAll(collection0);
    }

    @Override
    public final boolean equals(Object object0) {
        return this == object0 || this.b.keySet().equals(object0);
    }

    @Override
    public final int hashCode() {
        return this.b.keySet().hashCode();
    }

    @Override
    public final boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override
    public final Iterator iterator() {
        return new e(this, this.b.entrySet().iterator());
    }

    @Override  // I6.D0
    public final boolean remove(Object object0) {
        Collection collection0 = (Collection)this.b.remove(object0);
        if(collection0 != null) {
            int v = collection0.size();
            collection0.clear();
            this.c.e -= v;
            return v > 0;
        }
        return false;
    }

    @Override
    public final int size() {
        return this.b.size();
    }
}

