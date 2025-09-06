package I6;

import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.SortedSet;

public final class i extends l implements NavigableSet {
    public final k0 e;

    public i(k0 k00, NavigableMap navigableMap0) {
        this.e = k00;
        super(k00, navigableMap0);
    }

    @Override  // I6.l
    public final SortedMap b() {
        return this.d();
    }

    @Override
    public final Object ceiling(Object object0) {
        return this.d().ceilingKey(object0);
    }

    public final NavigableMap d() {
        return (NavigableMap)(((SortedMap)this.b));
    }

    @Override
    public final Iterator descendingIterator() {
        return ((g)this.descendingSet()).iterator();
    }

    @Override
    public final NavigableSet descendingSet() {
        NavigableMap navigableMap0 = this.d().descendingMap();
        return new i(this.e, navigableMap0);
    }

    @Override
    public final Object floor(Object object0) {
        return this.d().floorKey(object0);
    }

    @Override
    public final NavigableSet headSet(Object object0, boolean z) {
        NavigableMap navigableMap0 = this.d().headMap(object0, z);
        return new i(this.e, navigableMap0);
    }

    @Override  // I6.l
    public final SortedSet headSet(Object object0) {
        return this.headSet(object0, false);
    }

    @Override
    public final Object higher(Object object0) {
        return this.d().higherKey(object0);
    }

    @Override
    public final Object lower(Object object0) {
        return this.d().lowerKey(object0);
    }

    @Override
    public final Object pollFirst() {
        e e0 = (e)this.iterator();
        if(e0.hasNext()) {
            Object object0 = e0.next();
            e0.remove();
            return object0;
        }
        return null;
    }

    @Override
    public final Object pollLast() {
        Iterator iterator0 = this.descendingIterator();
        if(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            iterator0.remove();
            return object0;
        }
        return null;
    }

    @Override
    public final NavigableSet subSet(Object object0, boolean z, Object object1, boolean z1) {
        NavigableMap navigableMap0 = this.d().subMap(object0, z, object1, z1);
        return new i(this.e, navigableMap0);
    }

    @Override  // I6.l
    public final SortedSet subSet(Object object0, Object object1) {
        return this.subSet(object0, true, object1, false);
    }

    @Override
    public final NavigableSet tailSet(Object object0, boolean z) {
        NavigableMap navigableMap0 = this.d().tailMap(object0, z);
        return new i(this.e, navigableMap0);
    }

    @Override  // I6.l
    public final SortedSet tailSet(Object object0) {
        return this.tailSet(object0, true);
    }
}

