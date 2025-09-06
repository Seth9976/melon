package androidx.glance.appwidget.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public abstract class b extends AbstractList implements A {
    public boolean a;

    @Override
    public final boolean addAll(int v, Collection collection0) {
        this.b();
        return super.addAll(v, collection0);
    }

    @Override
    public final boolean addAll(Collection collection0) {
        this.b();
        return super.addAll(collection0);
    }

    public final void b() {
        if(!this.a) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public final void clear() {
        this.b();
        super.clear();
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof List)) {
            return false;
        }
        if(!(object0 instanceof RandomAccess)) {
            return super.equals(object0);
        }
        int v = this.size();
        if(v != ((List)object0).size()) {
            return false;
        }
        for(int v1 = 0; v1 < v; ++v1) {
            if(!this.get(v1).equals(((List)object0).get(v1))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final int hashCode() {
        int v = this.size();
        int v1 = 1;
        for(int v2 = 0; v2 < v; ++v2) {
            v1 = v1 * 0x1F + this.get(v2).hashCode();
        }
        return v1;
    }

    @Override
    public abstract Object remove(int arg1);

    @Override
    public final boolean remove(Object object0) {
        this.b();
        int v = this.indexOf(object0);
        if(v == -1) {
            return false;
        }
        this.remove(v);
        return true;
    }

    @Override
    public final boolean removeAll(Collection collection0) {
        this.b();
        return super.removeAll(collection0);
    }

    @Override
    public final boolean retainAll(Collection collection0) {
        this.b();
        return super.retainAll(collection0);
    }
}

