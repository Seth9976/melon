package I6;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public final class h extends k implements NavigableMap {
    public final k0 h;

    public h(k0 k00, NavigableMap navigableMap0) {
        this.h = k00;
        super(k00, navigableMap0);
    }

    @Override  // I6.k
    public final SortedSet c() {
        NavigableMap navigableMap0 = this.h();
        return new i(this.h, navigableMap0);
    }

    @Override
    public final Map.Entry ceilingEntry(Object object0) {
        Map.Entry map$Entry0 = this.h().ceilingEntry(object0);
        return map$Entry0 == null ? null : this.b(map$Entry0);
    }

    @Override
    public final Object ceilingKey(Object object0) {
        return this.h().ceilingKey(object0);
    }

    @Override  // I6.k
    public final SortedSet d() {
        return (NavigableSet)super.d();
    }

    @Override
    public final NavigableSet descendingKeySet() {
        return (NavigableSet)((h)this.descendingMap()).super.d();
    }

    @Override
    public final NavigableMap descendingMap() {
        NavigableMap navigableMap0 = this.h().descendingMap();
        return new h(this.h, navigableMap0);
    }

    @Override  // I6.k
    public final SortedMap e() {
        return this.h();
    }

    @Override
    public final Map.Entry firstEntry() {
        Map.Entry map$Entry0 = this.h().firstEntry();
        return map$Entry0 == null ? null : this.b(map$Entry0);
    }

    @Override
    public final Map.Entry floorEntry(Object object0) {
        Map.Entry map$Entry0 = this.h().floorEntry(object0);
        return map$Entry0 == null ? null : this.b(map$Entry0);
    }

    @Override
    public final Object floorKey(Object object0) {
        return this.h().floorKey(object0);
    }

    public final P g(Iterator iterator0) {
        if(!iterator0.hasNext()) {
            return null;
        }
        Object object0 = iterator0.next();
        Collection collection0 = this.h.f();
        collection0.addAll(((Collection)((Map.Entry)object0).getValue()));
        iterator0.remove();
        return new P(((Map.Entry)object0).getKey(), Collections.unmodifiableList(((List)collection0)));
    }

    public final NavigableMap h() {
        return (NavigableMap)(((SortedMap)this.b));
    }

    @Override
    public final NavigableMap headMap(Object object0, boolean z) {
        NavigableMap navigableMap0 = this.h().headMap(object0, z);
        return new h(this.h, navigableMap0);
    }

    @Override  // I6.k
    public final SortedMap headMap(Object object0) {
        return this.headMap(object0, false);
    }

    @Override
    public final Map.Entry higherEntry(Object object0) {
        Map.Entry map$Entry0 = this.h().higherEntry(object0);
        return map$Entry0 == null ? null : this.b(map$Entry0);
    }

    @Override
    public final Object higherKey(Object object0) {
        return this.h().higherKey(object0);
    }

    @Override  // I6.k
    public final Set keySet() {
        return (NavigableSet)super.d();
    }

    @Override
    public final Map.Entry lastEntry() {
        Map.Entry map$Entry0 = this.h().lastEntry();
        return map$Entry0 == null ? null : this.b(map$Entry0);
    }

    @Override
    public final Map.Entry lowerEntry(Object object0) {
        Map.Entry map$Entry0 = this.h().lowerEntry(object0);
        return map$Entry0 == null ? null : this.b(map$Entry0);
    }

    @Override
    public final Object lowerKey(Object object0) {
        return this.h().lowerKey(object0);
    }

    @Override
    public final NavigableSet navigableKeySet() {
        return (NavigableSet)super.d();
    }

    @Override
    public final Map.Entry pollFirstEntry() {
        return this.g(((d)this.entrySet()).iterator());
    }

    @Override
    public final Map.Entry pollLastEntry() {
        return this.g(((d)((f)this.descendingMap()).entrySet()).iterator());
    }

    @Override
    public final NavigableMap subMap(Object object0, boolean z, Object object1, boolean z1) {
        NavigableMap navigableMap0 = this.h().subMap(object0, z, object1, z1);
        return new h(this.h, navigableMap0);
    }

    @Override  // I6.k
    public final SortedMap subMap(Object object0, Object object1) {
        return this.subMap(object0, true, object1, false);
    }

    @Override
    public final NavigableMap tailMap(Object object0, boolean z) {
        NavigableMap navigableMap0 = this.h().tailMap(object0, z);
        return new h(this.h, navigableMap0);
    }

    @Override  // I6.k
    public final SortedMap tailMap(Object object0) {
        return this.tailMap(object0, true);
    }
}

