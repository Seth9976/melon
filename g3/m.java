package g3;

import I6.B0;
import I6.w;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;

public final class m extends w implements Map {
    public final Map b;

    public m(Map map0) {
        this.b = map0;
    }

    @Override
    public final void clear() {
        this.b.clear();
    }

    @Override
    public final boolean containsKey(Object object0) {
        return object0 != null && this.b.containsKey(object0);
    }

    @Override
    public final boolean containsValue(Object object0) {
        Iterator iterator0 = ((B0)this.entrySet()).iterator();
        iterator0.getClass();
        if(object0 == null) {
            while(iterator0.hasNext()) {
                Object object1 = iterator0.next();
                if(((Map.Entry)object1).getValue() != null) {
                    continue;
                }
                return true;
            }
        }
        else {
            while(iterator0.hasNext()) {
                Object object2 = iterator0.next();
                if(object0.equals(((Map.Entry)object2).getValue())) {
                    return true;
                }
                if(false) {
                    break;
                }
            }
        }
        return false;
    }

    @Override  // I6.w
    public final Object e() {
        return this.b;
    }

    @Override
    public final Set entrySet() {
        return w.i(this.b.entrySet(), new l(0));
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 != null && w.g(object0, this);
    }

    @Override
    public final Object get(Object object0) {
        return object0 == null ? null : ((List)this.b.get(object0));
    }

    @Override
    public final int hashCode() {
        return w.k(this.entrySet());
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean isEmpty() {
        return this.b.isEmpty() || this.b.size() == 1 && this.b.containsKey(null);
    }

    @Override
    public final Set keySet() {
        return w.i(this.b.keySet(), new l(1));
    }

    @Override
    public final Object put(Object object0, Object object1) {
        return this.b.put(object0, object1);
    }

    @Override
    public final void putAll(Map map0) {
        this.b.putAll(map0);
    }

    @Override
    public final Object remove(Object object0) {
        return this.b.remove(object0);
    }

    @Override
    public final int size() {
        int v = this.b.containsKey(null);
        return this.b.size() - v;
    }

    @Override
    public final Collection values() {
        return this.b.values();
    }
}

