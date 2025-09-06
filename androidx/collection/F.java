package androidx.collection;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;

public class f extends V implements Map {
    a mEntrySet;
    c mKeySet;
    e mValues;

    public f() {
        super(0);
    }

    public f(f f0) {
        super(0);
        this.putAll(f0);
    }

    public boolean containsAll(Collection collection0) {
        for(Object object0: collection0) {
            if(!this.containsKey(object0)) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    @Override  // androidx.collection.V
    public boolean containsKey(Object object0) {
        return super.containsKey(object0);
    }

    @Override  // androidx.collection.V
    public boolean containsValue(Object object0) {
        return super.containsValue(object0);
    }

    @Override
    public Set entrySet() {
        a a0 = this.mEntrySet;
        if(a0 == null) {
            a0 = new a(this);
            this.mEntrySet = a0;
        }
        return a0;
    }

    public static boolean equalsSetHelper(Set set0, Object object0) {
        if(set0 == object0) {
            return true;
        }
        if(object0 instanceof Set) {
            Set set1 = (Set)object0;
            try {
                if(set0.size() == set1.size() && set0.containsAll(set1)) {
                    return true;
                }
            }
            catch(NullPointerException | ClassCastException unused_ex) {
            }
        }
        return false;
    }

    @Override  // androidx.collection.V
    public Object get(Object object0) {
        return super.get(object0);
    }

    @Override
    public Set keySet() {
        c c0 = this.mKeySet;
        if(c0 == null) {
            c0 = new c(this);
            this.mKeySet = c0;
        }
        return c0;
    }

    @Override
    public void putAll(Map map0) {
        this.ensureCapacity(map0.size() + this.size());
        for(Object object0: map0.entrySet()) {
            this.put(((Map.Entry)object0).getKey(), ((Map.Entry)object0).getValue());
        }
    }

    @Override  // androidx.collection.V
    public Object remove(Object object0) {
        return super.remove(object0);
    }

    public boolean removeAll(Collection collection0) {
        int v = this.size();
        for(Object object0: collection0) {
            this.remove(object0);
        }
        return v != this.size();
    }

    public boolean retainAll(Collection collection0) {
        int v = this.size();
        for(int v1 = this.size() - 1; v1 >= 0; --v1) {
            if(!collection0.contains(this.keyAt(v1))) {
                this.removeAt(v1);
            }
        }
        return v != this.size();
    }

    @Override
    public Collection values() {
        e e0 = this.mValues;
        if(e0 == null) {
            e0 = new e(this);
            this.mValues = e0;
        }
        return e0;
    }
}

