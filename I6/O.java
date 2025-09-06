package I6;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class o extends m implements List {
    public final q f;

    public o(q q0, Object object0, List list0, m m0) {
        this.f = q0;
        super(q0, object0, list0, m0);
    }

    @Override
    public final void add(int v, Object object0) {
        this.d();
        boolean z = this.b.isEmpty();
        ((List)this.b).add(v, object0);
        ++this.f.e;
        if(z) {
            this.b();
        }
    }

    @Override
    public final boolean addAll(int v, Collection collection0) {
        if(collection0.isEmpty()) {
            return false;
        }
        int v1 = this.size();
        boolean z = ((List)this.b).addAll(v, collection0);
        if(z) {
            this.f.e += this.b.size() - v1;
            if(v1 == 0) {
                this.b();
            }
        }
        return z;
    }

    @Override
    public final Object get(int v) {
        this.d();
        return ((List)this.b).get(v);
    }

    @Override
    public final int indexOf(Object object0) {
        this.d();
        return ((List)this.b).indexOf(object0);
    }

    @Override
    public final int lastIndexOf(Object object0) {
        this.d();
        return ((List)this.b).lastIndexOf(object0);
    }

    @Override
    public final ListIterator listIterator() {
        this.d();
        return new n(this);
    }

    @Override
    public final ListIterator listIterator(int v) {
        this.d();
        return new n(this, v);
    }

    @Override
    public final Object remove(int v) {
        this.d();
        Object object0 = ((List)this.b).remove(v);
        --this.f.e;
        this.e();
        return object0;
    }

    @Override
    public final Object set(int v, Object object0) {
        this.d();
        return ((List)this.b).set(v, object0);
    }

    @Override
    public final List subList(int v, int v1) {
        this.d();
        List list0 = ((List)this.b).subList(v, v1);
        m m0 = this.c;
        if(m0 == null) {
            m0 = this;
        }
        q q0 = this.f;
        Object object0 = this.a;
        return list0 instanceof RandomAccess ? new j(q0, object0, list0, m0) : new o(q0, object0, list0, m0);  // 初始化器: LI6/o;-><init>(LI6/q;Ljava/lang/Object;Ljava/util/List;LI6/m;)V
    }
}

