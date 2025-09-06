package j0;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import ke.c;
import ke.e;
import kotlin.jvm.internal.q;
import m0.f;
import xe.b;

public final class g extends AbstractCollection implements Collection, b {
    public final int a;
    public final Object b;

    public g(Object object0, int v) {
        this.a = v;
        super();
        this.b = object0;
    }

    @Override
    public final boolean add(Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection collection0) {
        if(this.a != 1) {
            return super.addAll(collection0);
        }
        q.g(collection0, "elements");
        throw new UnsupportedOperationException();
    }

    @Override
    public final void clear() {
        if(this.a != 0) {
            ((e)this.b).clear();
            return;
        }
        ((f)this.b).clear();
    }

    @Override
    public final boolean contains(Object object0) {
        return this.a == 0 ? ((f)this.b).containsValue(object0) : ((e)this.b).containsValue(object0);
    }

    @Override
    public boolean isEmpty() {
        return this.a == 1 ? ((e)this.b).isEmpty() : super.isEmpty();
    }

    @Override
    public final Iterator iterator() {
        if(this.a != 0) {
            ((e)this.b).getClass();
            return new c(((e)this.b), 2);
        }
        f f0 = (f)this.b;
        k[] arr_k = new k[8];
        for(int v = 0; v < 8; ++v) {
            arr_k[v] = new l(2);
        }
        return new j0.f(f0, arr_k);  // 初始化器: Lj0/d;-><init>(Lm0/f;[Lj0/k;)V
    }

    @Override
    public boolean remove(Object object0) {
        if(this.a != 1) {
            return super.remove(object0);
        }
        e e0 = (e)this.b;
        e0.d();
        int v = e0.k(object0);
        if(v < 0) {
            return false;
        }
        e0.n(v);
        return true;
    }

    @Override
    public boolean removeAll(Collection collection0) {
        if(this.a != 1) {
            return super.removeAll(collection0);
        }
        q.g(collection0, "elements");
        ((e)this.b).d();
        return super.removeAll(collection0);
    }

    @Override
    public boolean retainAll(Collection collection0) {
        if(this.a != 1) {
            return super.retainAll(collection0);
        }
        q.g(collection0, "elements");
        ((e)this.b).d();
        return super.retainAll(collection0);
    }

    @Override
    public final int size() {
        return this.a == 0 ? ((f)this.b).size() : ((e)this.b).i;
    }
}

