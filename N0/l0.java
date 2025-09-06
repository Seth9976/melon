package N0;

import De.I;
import Sf.i;
import androidx.collection.H;
import androidx.collection.J;
import androidx.collection.K;
import androidx.collection.X;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.q;
import xe.a;

public final class l0 implements Collection, a {
    public final int a;
    public final Object b;

    public l0() {
        this.a = 0;
        H h0 = new H(6);
        super();
        this.b = h0;
    }

    public l0(K k0) {
        this.a = 1;
        q.g(k0, "parent");
        super();
        this.b = k0;
    }

    @Override
    public final boolean add(Object object0) {
        if(this.a != 0) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
        return ((H)this.b).a(object0);
    }

    @Override
    public final boolean addAll(Collection collection0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final void clear() {
        if(this.a != 0) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
        ((H)this.b).b();
    }

    @Override
    public final boolean contains(Object object0) {
        return this.a == 0 ? ((H)this.b).c(object0) : ((K)this.b).d(object0);
    }

    @Override
    public final boolean containsAll(Collection collection0) {
        if(this.a != 0) {
            q.g(collection0, "elements");
            if(!collection0.isEmpty()) {
                for(Object object0: collection0) {
                    if(!((K)this.b).d(object0)) {
                        return false;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            return true;
        }
        for(Object object1: collection0) {
            if(!((H)this.b).c(object1)) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    @Override
    public final boolean isEmpty() {
        return this.a == 0 ? ((H)this.b).g == 0 : ((K)this.b).i();
    }

    @Override
    public final Iterator iterator() {
        if(this.a != 0) {
            return I.P(new X(this, null));
        }
        ((H)this.b).getClass();
        return new i(new J(((H)this.b)));
    }

    @Override
    public final boolean remove(Object object0) {
        if(this.a != 0) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
        return ((H)this.b).g(object0);
    }

    @Override
    public final boolean removeAll(Collection collection0) {
        if(this.a != 0) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
        return ((H)this.b).g(collection0);
    }

    @Override
    public final boolean removeIf(Predicate predicate0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean retainAll(Collection collection0) {
        if(this.a != 0) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
        return ((H)this.b).i(collection0);
    }

    @Override
    public final int size() {
        return this.a == 0 ? ((H)this.b).g : ((K)this.b).e;
    }

    @Override
    public final Object[] toArray() {
        return p.a(this);
    }

    @Override
    public final Object[] toArray(Object[] arr_object) {
        if(this.a != 0) {
            q.g(arr_object, "array");
            return p.b(this, arr_object);
        }
        return p.b(this, arr_object);
    }
}

