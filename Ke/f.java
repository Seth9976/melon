package ke;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import je.j;
import kotlin.jvm.internal.q;

public final class f extends j {
    public final int a;
    public final e b;

    public f(e e0, int v) {
        this.a = v;
        super();
        this.b = e0;
    }

    @Override
    public final boolean add(Object object0) {
        if(this.a != 0) {
            throw new UnsupportedOperationException();
        }
        q.g(((Map.Entry)object0), "element");
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean addAll(Collection collection0) {
        if(this.a != 0) {
            q.g(collection0, "elements");
            throw new UnsupportedOperationException();
        }
        q.g(collection0, "elements");
        throw new UnsupportedOperationException();
    }

    @Override  // je.j
    public final int b() {
        return this.b.i;
    }

    @Override
    public final void clear() {
        if(this.a != 0) {
            this.b.clear();
            return;
        }
        this.b.clear();
    }

    @Override
    public final boolean contains(Object object0) {
        if(this.a != 0) {
            return this.b.containsKey(object0);
        }
        if(!(object0 instanceof Map.Entry)) {
            return false;
        }
        q.g(((Map.Entry)object0), "element");
        return this.b.h(((Map.Entry)object0));
    }

    @Override
    public boolean containsAll(Collection collection0) {
        if(this.a != 0) {
            return super.containsAll(collection0);
        }
        q.g(collection0, "elements");
        return this.b.g(collection0);
    }

    @Override
    public final boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override
    public final Iterator iterator() {
        if(this.a != 0) {
            this.b.getClass();
            return new c(this.b, 1);
        }
        this.b.getClass();
        return new c(this.b, 0);
    }

    @Override
    public final boolean remove(Object object0) {
        if(this.a != 0) {
            e e0 = this.b;
            e0.d();
            int v = e0.j(object0);
            if(v < 0) {
                return false;
            }
            e0.n(v);
            return true;
        }
        if(object0 instanceof Map.Entry) {
            q.g(((Map.Entry)object0), "element");
            e e1 = this.b;
            e1.getClass();
            e1.d();
            int v1 = e1.j(((Map.Entry)object0).getKey());
            if(v1 >= 0) {
                Object[] arr_object = e1.b;
                q.d(arr_object);
                if(q.b(arr_object[v1], ((Map.Entry)object0).getValue())) {
                    e1.n(v1);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public final boolean removeAll(Collection collection0) {
        if(this.a != 0) {
            q.g(collection0, "elements");
            this.b.d();
            return super.removeAll(collection0);
        }
        q.g(collection0, "elements");
        this.b.d();
        return super.removeAll(collection0);
    }

    @Override
    public final boolean retainAll(Collection collection0) {
        if(this.a != 0) {
            q.g(collection0, "elements");
            this.b.d();
            return super.retainAll(collection0);
        }
        q.g(collection0, "elements");
        this.b.d();
        return super.retainAll(collection0);
    }
}

