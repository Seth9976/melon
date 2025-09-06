package i0;

import androidx.fragment.app.p;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import je.f;
import xe.a;

public abstract class b extends f implements Collection, List, a {
    public abstract b a(int arg1, Object arg2);

    public abstract b b(Object arg1);

    @Override  // je.a
    public final boolean contains(Object object0) {
        return this.indexOf(object0) != -1;
    }

    @Override  // je.a
    public final boolean containsAll(Collection collection0) {
        if(collection0 instanceof Collection && collection0.isEmpty()) {
            return true;
        }
        for(Object object0: collection0) {
            if(!this.contains(object0)) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    public b d(Collection collection0) {
        e e0 = this.e();
        e0.addAll(collection0);
        return e0.e();
    }

    public abstract e e();

    public abstract b g(p arg1);

    public abstract b i(int arg1);

    @Override  // je.f
    public final Iterator iterator() {
        return this.listIterator(0);
    }

    public abstract b k(int arg1, Object arg2);

    @Override  // je.f
    public final ListIterator listIterator() {
        return this.listIterator(0);
    }

    @Override  // je.f
    public final List subList(int v, int v1) {
        return new h0.a(this, v, v1);
    }
}

