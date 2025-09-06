package I6;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

public class l extends g implements SortedSet {
    public final k0 d;

    public l(k0 k00, SortedMap sortedMap0) {
        this.d = k00;
        super(k00, sortedMap0);
    }

    public SortedMap b() {
        return (SortedMap)this.b;
    }

    @Override
    public final Comparator comparator() {
        return this.b().comparator();
    }

    @Override
    public final Object first() {
        return this.b().firstKey();
    }

    @Override
    public SortedSet headSet(Object object0) {
        SortedMap sortedMap0 = this.b().headMap(object0);
        return new l(this.d, sortedMap0);
    }

    @Override
    public final Object last() {
        return this.b().lastKey();
    }

    @Override
    public SortedSet subSet(Object object0, Object object1) {
        SortedMap sortedMap0 = this.b().subMap(object0, object1);
        return new l(this.d, sortedMap0);
    }

    @Override
    public SortedSet tailSet(Object object0) {
        SortedMap sortedMap0 = this.b().tailMap(object0);
        return new l(this.d, sortedMap0);
    }
}

