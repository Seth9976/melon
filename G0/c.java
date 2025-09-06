package g0;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.q;

public final class c implements List, xe.c {
    public final Object a;
    public final int b;
    public int c;

    public c(List list0, int v, int v1) {
        this.a = list0;
        this.b = v;
        this.c = v1;
    }

    @Override
    public final void add(int v, Object object0) {
        ((List)this.a).add(v + this.b, object0);
        ++this.c;
    }

    @Override
    public final boolean add(Object object0) {
        int v = this.c;
        this.c = v + 1;
        ((List)this.a).add(v, object0);
        return true;
    }

    @Override
    public final boolean addAll(int v, Collection collection0) {
        ((List)this.a).addAll(v + this.b, collection0);
        int v1 = collection0.size();
        this.c += v1;
        return v1 > 0;
    }

    @Override
    public final boolean addAll(Collection collection0) {
        ((List)this.a).addAll(this.c, collection0);
        int v = collection0.size();
        this.c += v;
        return v > 0;
    }

    @Override
    public final void clear() {
        int v = this.c - 1;
        int v1 = this.b;
        if(v1 <= v) {
            while(true) {
                ((List)this.a).remove(v);
                if(v == v1) {
                    break;
                }
                --v;
            }
        }
        this.c = v1;
    }

    @Override
    public final boolean contains(Object object0) {
        int v = this.c;
        for(int v1 = this.b; v1 < v; ++v1) {
            if(q.b(((List)this.a).get(v1), object0)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final boolean containsAll(Collection collection0) {
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

    @Override
    public final Object get(int v) {
        f.a(v, this);
        return ((List)this.a).get(v + this.b);
    }

    @Override
    public final int indexOf(Object object0) {
        int v = this.c;
        int v1 = this.b;
        for(int v2 = v1; v2 < v; ++v2) {
            if(q.b(((List)this.a).get(v2), object0)) {
                return v2 - v1;
            }
        }
        return -1;
    }

    @Override
    public final boolean isEmpty() {
        return this.c == this.b;
    }

    @Override
    public final Iterator iterator() {
        return new d(this, 0);
    }

    @Override
    public final int lastIndexOf(Object object0) {
        int v = this.c - 1;
        int v1 = this.b;
        if(v1 <= v) {
            while(true) {
                if(q.b(((List)this.a).get(v), object0)) {
                    return v - v1;
                }
                if(v == v1) {
                    break;
                }
                --v;
            }
        }
        return -1;
    }

    @Override
    public final ListIterator listIterator() {
        return new d(this, 0);
    }

    @Override
    public final ListIterator listIterator(int v) {
        return new d(this, v);
    }

    @Override
    public final Object remove(int v) {
        f.a(v, this);
        Object object0 = ((List)this.a).remove(v + this.b);
        --this.c;
        return object0;
    }

    @Override
    public final boolean remove(Object object0) {
        int v = this.c;
        for(int v1 = this.b; v1 < v; ++v1) {
            Object object1 = this.a;
            if(q.b(((List)object1).get(v1), object0)) {
                ((List)object1).remove(v1);
                --this.c;
                return true;
            }
        }
        return false;
    }

    @Override
    public final boolean removeAll(Collection collection0) {
        int v = this.c;
        for(Object object0: collection0) {
            this.remove(object0);
        }
        return v != this.c;
    }

    @Override
    public final boolean retainAll(Collection collection0) {
        int v = this.c;
        int v1 = v - 1;
        int v2 = this.b;
        if(v2 <= v1) {
            while(true) {
                Object object0 = this.a;
                if(!collection0.contains(((List)object0).get(v1))) {
                    ((List)object0).remove(v1);
                    --this.c;
                }
                if(v1 == v2) {
                    break;
                }
                --v1;
            }
        }
        return v != this.c;
    }

    @Override
    public final Object set(int v, Object object0) {
        f.a(v, this);
        return ((List)this.a).set(v + this.b, object0);
    }

    @Override
    public final int size() {
        return this.c - this.b;
    }

    @Override
    public final List subList(int v, int v1) {
        f.b(v, v1, this);
        return new c(this, v, v1);
    }

    @Override
    public final Object[] toArray() {
        return p.a(this);
    }

    @Override
    public final Object[] toArray(Object[] arr_object) {
        return p.b(this, arr_object);
    }
}

