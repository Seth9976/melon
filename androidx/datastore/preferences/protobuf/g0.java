package androidx.datastore.preferences.protobuf;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public final class g0 extends AbstractMap {
    public List a;
    public Map b;
    public boolean c;
    public volatile j0 d;
    public Map e;
    public static final int f;

    public g0() {
        this.a = Collections.EMPTY_LIST;
        this.b = Collections.EMPTY_MAP;
        this.e = Collections.EMPTY_MAP;
    }

    public final int a(Comparable comparable0) {
        int v = this.a.size();
        int v1 = v - 1;
        if(v1 >= 0) {
            int v2 = comparable0.compareTo(((h0)this.a.get(v1)).a);
            if(v2 > 0) {
                return -(v + 1);
            }
            if(v2 == 0) {
                return v1;
            }
        }
        int v3 = 0;
        while(v3 <= v1) {
            int v4 = (v3 + v1) / 2;
            int v5 = comparable0.compareTo(((h0)this.a.get(v4)).a);
            if(v5 < 0) {
                v1 = v4 - 1;
                continue;
            }
            if(v5 > 0) {
                v3 = v4 + 1;
                continue;
            }
            return v4;
        }
        return -(v3 + 1);
    }

    public final void b() {
        if(this.c) {
            throw new UnsupportedOperationException();
        }
    }

    public final Map.Entry c(int v) {
        return (Map.Entry)this.a.get(v);
    }

    @Override
    public final void clear() {
        this.b();
        if(!this.a.isEmpty()) {
            this.a.clear();
        }
        if(!this.b.isEmpty()) {
            this.b.clear();
        }
    }

    @Override
    public final boolean containsKey(Object object0) {
        return this.a(((Comparable)object0)) >= 0 || this.b.containsKey(((Comparable)object0));
    }

    // 去混淆评级： 低(20)
    public final Set d() {
        return this.b.isEmpty() ? Collections.EMPTY_SET : this.b.entrySet();
    }

    public final SortedMap e() {
        this.b();
        if(this.b.isEmpty() && !(this.b instanceof TreeMap)) {
            TreeMap treeMap0 = new TreeMap();
            this.b = treeMap0;
            this.e = treeMap0.descendingMap();
        }
        return (SortedMap)this.b;
    }

    @Override
    public final Set entrySet() {
        if(this.d == null) {
            this.d = new j0(this, 0);
        }
        return this.d;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(!(object0 instanceof g0)) {
                return super.equals(object0);
            }
            int v = this.size();
            if(v == ((g0)object0).size()) {
                int v1 = this.a.size();
                if(v1 != ((g0)object0).a.size()) {
                    return ((AbstractSet)this.entrySet()).equals(((g0)object0).entrySet());
                }
                for(int v2 = 0; v2 < v1; ++v2) {
                    if(!this.c(v2).equals(((g0)object0).c(v2))) {
                        return false;
                    }
                }
                return v1 == v ? true : this.b.equals(((g0)object0).b);
            }
            return false;
        }
        return true;
    }

    public final Object g(Comparable comparable0, Object object0) {
        this.b();
        int v = this.a(comparable0);
        if(v >= 0) {
            return ((h0)this.a.get(v)).setValue(object0);
        }
        this.b();
        if(this.a.isEmpty() && !(this.a instanceof ArrayList)) {
            this.a = new ArrayList(16);
        }
        if(-(v + 1) >= 16) {
            return this.e().put(comparable0, object0);
        }
        if(this.a.size() == 16) {
            h0 h00 = (h0)this.a.remove(15);
            this.e().put(h00.a, h00.b);
        }
        this.a.add(-(v + 1), new h0(this, comparable0, object0));
        return null;
    }

    @Override
    public final Object get(Object object0) {
        int v = this.a(((Comparable)object0));
        return v < 0 ? this.b.get(((Comparable)object0)) : ((h0)this.a.get(v)).b;
    }

    public final Object h(int v) {
        this.b();
        Object object0 = ((h0)this.a.remove(v)).b;
        if(!this.b.isEmpty()) {
            Iterator iterator0 = this.e().entrySet().iterator();
            List list0 = this.a;
            Object object1 = iterator0.next();
            list0.add(new h0(this, ((Comparable)((Map.Entry)object1).getKey()), ((Map.Entry)object1).getValue()));
            iterator0.remove();
        }
        return object0;
    }

    @Override
    public final int hashCode() {
        int v = this.a.size();
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += ((h0)this.a.get(v1)).hashCode();
        }
        return this.b.size() <= 0 ? v2 : this.b.hashCode() + v2;
    }

    @Override
    public final Object put(Object object0, Object object1) {
        return this.g(((Comparable)object0), object1);
    }

    @Override
    public final Object remove(Object object0) {
        this.b();
        int v = this.a(((Comparable)object0));
        if(v >= 0) {
            return this.h(v);
        }
        return this.b.isEmpty() ? null : this.b.remove(((Comparable)object0));
    }

    @Override
    public final int size() {
        return this.b.size() + this.a.size();
    }
}

