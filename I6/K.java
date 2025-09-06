package I6;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public class k extends f implements SortedMap {
    public SortedSet f;
    public final k0 g;

    public k(k0 k00, SortedMap sortedMap0) {
        this.g = k00;
        super(k00, sortedMap0, 0);
    }

    public SortedSet c() {
        SortedMap sortedMap0 = this.e();
        return new l(this.g, sortedMap0);
    }

    @Override
    public final Comparator comparator() {
        return this.e().comparator();
    }

    public SortedSet d() {
        SortedSet sortedSet0 = this.f;
        if(sortedSet0 == null) {
            sortedSet0 = this.c();
            this.f = sortedSet0;
        }
        return sortedSet0;
    }

    public SortedMap e() {
        return (SortedMap)this.b;
    }

    @Override
    public final Object firstKey() {
        return this.e().firstKey();
    }

    @Override
    public SortedMap headMap(Object object0) {
        SortedMap sortedMap0 = this.e().headMap(object0);
        return new k(this.g, sortedMap0);
    }

    @Override  // I6.f
    public Set keySet() {
        return this.d();
    }

    @Override
    public final Object lastKey() {
        return this.e().lastKey();
    }

    @Override
    public SortedMap subMap(Object object0, Object object1) {
        SortedMap sortedMap0 = this.e().subMap(object0, object1);
        return new k(this.g, sortedMap0);
    }

    @Override
    public SortedMap tailMap(Object object0) {
        SortedMap sortedMap0 = this.e().tailMap(object0);
        return new k(this.g, sortedMap0);
    }
}

