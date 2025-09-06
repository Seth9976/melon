package I6;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public abstract class m extends AbstractCollection {
    public final Object a;
    public Collection b;
    public final m c;
    public final Collection d;
    public final q e;

    public m(q q0, Object object0, Collection collection0, m m0) {
        this.e = q0;
        super();
        this.a = object0;
        this.b = collection0;
        this.c = m0;
        this.d = m0 == null ? null : m0.b;
    }

    @Override
    public final boolean add(Object object0) {
        this.d();
        boolean z = this.b.isEmpty();
        boolean z1 = this.b.add(object0);
        if(z1) {
            ++this.e.e;
            if(z) {
                this.b();
            }
        }
        return z1;
    }

    @Override
    public final boolean addAll(Collection collection0) {
        if(collection0.isEmpty()) {
            return false;
        }
        int v = this.size();
        boolean z = this.b.addAll(collection0);
        if(z) {
            this.e.e += this.b.size() - v;
            if(v == 0) {
                this.b();
            }
        }
        return z;
    }

    public final void b() {
        m m0 = this.c;
        if(m0 != null) {
            m0.b();
            return;
        }
        this.e.d.put(this.a, this.b);
    }

    @Override
    public final void clear() {
        int v = this.size();
        if(v == 0) {
            return;
        }
        this.b.clear();
        this.e.e -= v;
        this.e();
    }

    @Override
    public final boolean contains(Object object0) {
        this.d();
        return this.b.contains(object0);
    }

    @Override
    public final boolean containsAll(Collection collection0) {
        this.d();
        return this.b.containsAll(collection0);
    }

    public final void d() {
        m m0 = this.c;
        if(m0 != null) {
            m0.d();
            if(m0.b != this.d) {
                throw new ConcurrentModificationException();
            }
        }
        else if(this.b.isEmpty()) {
            Collection collection0 = (Collection)this.e.d.get(this.a);
            if(collection0 != null) {
                this.b = collection0;
            }
        }
    }

    public final void e() {
        m m0 = this.c;
        if(m0 != null) {
            m0.e();
            return;
        }
        if(this.b.isEmpty()) {
            this.e.d.remove(this.a);
        }
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        this.d();
        return this.b.equals(object0);
    }

    @Override
    public final int hashCode() {
        this.d();
        return this.b.hashCode();
    }

    @Override
    public final Iterator iterator() {
        this.d();
        return new e(this);
    }

    @Override
    public final boolean remove(Object object0) {
        this.d();
        boolean z = this.b.remove(object0);
        if(z) {
            --this.e.e;
            this.e();
        }
        return z;
    }

    @Override
    public boolean removeAll(Collection collection0) {
        if(collection0.isEmpty()) {
            return false;
        }
        int v = this.size();
        boolean z = this.b.removeAll(collection0);
        if(z) {
            this.e.e += this.b.size() - v;
            this.e();
        }
        return z;
    }

    @Override
    public final boolean retainAll(Collection collection0) {
        collection0.getClass();
        int v = this.size();
        boolean z = this.b.retainAll(collection0);
        if(z) {
            this.e.e += this.b.size() - v;
            this.e();
        }
        return z;
    }

    @Override
    public final int size() {
        this.d();
        return this.b.size();
    }

    @Override
    public final String toString() {
        this.d();
        return this.b.toString();
    }
}

