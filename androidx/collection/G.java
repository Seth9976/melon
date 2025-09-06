package androidx.collection;

import E.a;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import je.n;
import je.p;
import kotlin.jvm.internal.q;
import xe.b;
import xe.e;

public final class g implements Collection, Set, b, e {
    public int[] a;
    public Object[] b;
    public int c;

    public g(int v) {
        this.a = a.a;
        this.b = a.c;
        if(v > 0) {
            t.a(this, v);
        }
    }

    public final Object a(int v) {
        int v1 = this.c;
        Object[] arr_object = this.b;
        Object object0 = arr_object[v];
        if(v1 <= 1) {
            this.clear();
            return object0;
        }
        int[] arr_v = this.a;
        int v2 = 8;
        if(arr_v.length <= 8 || v1 >= arr_v.length / 3) {
            if(v < v1 - 1) {
                n.S(v, v + 1, v1, arr_v, arr_v);
                n.W(this.b, v, this.b, v + 1, v1);
            }
            this.b[v1 - 1] = null;
        }
        else {
            if(v1 > 8) {
                v2 = v1 + (v1 >> 1);
            }
            int[] arr_v1 = new int[v2];
            this.a = arr_v1;
            this.b = new Object[v2];
            if(v > 0) {
                n.X(0, v, 6, arr_v, arr_v1);
                n.Y(arr_object, 0, this.b, v, 6);
            }
            if(v < v1 - 1) {
                n.S(v, v + 1, v1, arr_v, this.a);
                n.W(arr_object, v, this.b, v + 1, v1);
            }
        }
        if(v1 != this.c) {
            throw new ConcurrentModificationException();
        }
        this.c = v1 - 1;
        return object0;
    }

    @Override
    public final boolean add(Object object0) {
        int v2;
        int v1;
        int v = this.c;
        if(object0 == null) {
            v1 = t.b(this, null, 0);
            v2 = 0;
        }
        else {
            int v3 = object0.hashCode();
            v2 = v3;
            v1 = t.b(this, object0, v3);
        }
        if(v1 >= 0) {
            return false;
        }
        int v4 = 8;
        int[] arr_v = this.a;
        if(v >= arr_v.length) {
            if(v >= 8) {
                v4 = (v >> 1) + v;
            }
            else if(v < 4) {
                v4 = 4;
            }
            Object[] arr_object = this.b;
            int[] arr_v1 = new int[v4];
            this.a = arr_v1;
            this.b = new Object[v4];
            if(v != this.c) {
                throw new ConcurrentModificationException();
            }
            if(arr_v1.length != 0) {
                n.X(0, arr_v.length, 6, arr_v, arr_v1);
                n.Y(arr_object, 0, this.b, arr_object.length, 6);
            }
        }
        if(~v1 < v) {
            n.S(-v1, ~v1, v, this.a, this.a);
            n.W(this.b, -v1, this.b, ~v1, v);
        }
        int v5 = this.c;
        if(v == v5) {
            int[] arr_v2 = this.a;
            if(~v1 < arr_v2.length) {
                arr_v2[~v1] = v2;
                this.b[~v1] = object0;
                this.c = v5 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override
    public final boolean addAll(Collection collection0) {
        q.g(collection0, "elements");
        int v = collection0.size() + this.c;
        int v1 = this.c;
        int[] arr_v = this.a;
        boolean z = false;
        if(arr_v.length < v) {
            Object[] arr_object = this.b;
            int[] arr_v1 = new int[v];
            this.a = arr_v1;
            this.b = new Object[v];
            if(v1 > 0) {
                n.X(0, v1, 6, arr_v, arr_v1);
                n.Y(arr_object, 0, this.b, this.c, 6);
            }
        }
        if(this.c != v1) {
            throw new ConcurrentModificationException();
        }
        for(Object object0: collection0) {
            z |= this.add(object0);
        }
        return z;
    }

    @Override
    public final void clear() {
        if(this.c != 0) {
            this.a = a.a;
            this.b = a.c;
            this.c = 0;
        }
        if(this.c != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override
    public final boolean contains(Object object0) {
        return (object0 == null ? t.b(this, null, 0) : t.b(this, object0, object0.hashCode())) >= 0;
    }

    @Override
    public final boolean containsAll(Collection collection0) {
        q.g(collection0, "elements");
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
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Set) || this.c != ((Set)object0).size()) {
            return false;
        }
        try {
            int v = this.c;
            for(int v1 = 0; true; ++v1) {
                if(v1 >= v) {
                    return true;
                }
                if(!((Set)object0).contains(this.b[v1])) {
                    break;
                }
            }
        }
        catch(NullPointerException | ClassCastException unused_ex) {
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int[] arr_v = this.a;
        int v = this.c;
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += arr_v[v1];
        }
        return v2;
    }

    @Override
    public final boolean isEmpty() {
        return this.c <= 0;
    }

    @Override
    public final Iterator iterator() {
        return new androidx.collection.b(this);
    }

    @Override
    public final boolean remove(Object object0) {
        int v = object0 == null ? t.b(this, null, 0) : t.b(this, object0, object0.hashCode());
        if(v >= 0) {
            this.a(v);
            return true;
        }
        return false;
    }

    @Override
    public final boolean removeAll(Collection collection0) {
        q.g(collection0, "elements");
        boolean z = false;
        for(Object object0: collection0) {
            z |= this.remove(object0);
        }
        return z;
    }

    @Override
    public final boolean retainAll(Collection collection0) {
        q.g(collection0, "elements");
        int v = this.c - 1;
        boolean z = false;
        while(-1 < v) {
            if(!p.d0(collection0, this.b[v])) {
                this.a(v);
                z = true;
            }
            --v;
        }
        return z;
    }

    @Override
    public final int size() {
        return this.c;
    }

    @Override
    public final Object[] toArray() {
        return n.a0(this.b, 0, this.c);
    }

    @Override
    public final Object[] toArray(Object[] arr_object) {
        q.g(arr_object, "array");
        int v = this.c;
        if(arr_object.length < v) {
            arr_object = (Object[])Array.newInstance(arr_object.getClass().getComponentType(), v);
        }
        else if(arr_object.length > v) {
            arr_object[v] = null;
        }
        n.W(this.b, 0, arr_object, 0, this.c);
        return arr_object;
    }

    @Override
    public final String toString() {
        if(this.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder0 = new StringBuilder(this.c * 14);
        stringBuilder0.append('{');
        int v = this.c;
        for(int v1 = 0; v1 < v; ++v1) {
            if(v1 > 0) {
                stringBuilder0.append(", ");
            }
            Object object0 = this.b[v1];
            if(object0 == this) {
                stringBuilder0.append("(this Set)");
            }
            else {
                stringBuilder0.append(object0);
            }
        }
        stringBuilder0.append('}');
        String s = stringBuilder0.toString();
        q.f(s, "toString(...)");
        return s;
    }
}

