package p0;

import Ce.f;
import P4.a;
import androidx.compose.runtime.j0;
import i0.b;
import i0.e;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import je.E;
import kotlin.jvm.internal.F;
import xe.c;

public final class w implements List, c {
    public final p a;
    public final int b;
    public int c;
    public int d;

    public w(p p0, int v, int v1) {
        this.a = p0;
        this.b = v;
        this.c = p0.i();
        this.d = v1 - v;
    }

    @Override
    public final void add(int v, Object object0) {
        this.b();
        this.a.add(this.b + v, object0);
        ++this.d;
        this.c = this.a.i();
    }

    @Override
    public final boolean add(Object object0) {
        this.b();
        this.a.add(this.b + this.d, object0);
        ++this.d;
        this.c = this.a.i();
        return true;
    }

    @Override
    public final boolean addAll(int v, Collection collection0) {
        this.b();
        p p0 = this.a;
        boolean z = p0.addAll(v + this.b, collection0);
        if(z) {
            this.d = collection0.size() + this.d;
            this.c = p0.i();
        }
        return z;
    }

    @Override
    public final boolean addAll(Collection collection0) {
        return this.addAll(this.d, collection0);
    }

    public final void b() {
        if(this.a.i() != this.c) {
            throw new ConcurrentModificationException();
        }
    }

    @Override
    public final void clear() {
        if(this.d > 0) {
            this.b();
            this.a.l(this.b, this.d + this.b);
            this.d = 0;
            this.c = this.a.i();
        }
    }

    @Override
    public final boolean contains(Object object0) {
        return this.indexOf(object0) >= 0;
    }

    @Override
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

    @Override
    public final Object get(int v) {
        this.b();
        q.a(v, this.d);
        return this.a.get(this.b + v);
    }

    @Override
    public final int indexOf(Object object0) {
        this.b();
        int v = this.b;
        Iterator iterator0 = a.K(v, this.d + v).iterator();
        while(iterator0.hasNext()) {
            int v1 = ((f)iterator0).nextInt();
            if(kotlin.jvm.internal.q.b(object0, this.a.get(v1))) {
                return v1 - v;
            }
            if(false) {
                break;
            }
        }
        return -1;
    }

    @Override
    public final boolean isEmpty() {
        return this.d == 0;
    }

    @Override
    public final Iterator iterator() {
        return this.listIterator(0);
    }

    @Override
    public final int lastIndexOf(Object object0) {
        this.b();
        int v = this.b;
        for(int v1 = this.d + v - 1; v1 >= v; --v1) {
            if(kotlin.jvm.internal.q.b(object0, this.a.get(v1))) {
                return v1 - v;
            }
        }
        return -1;
    }

    @Override
    public final ListIterator listIterator() {
        return this.listIterator(0);
    }

    @Override
    public final ListIterator listIterator(int v) {
        this.b();
        F f0 = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
        f0.a = v - 1;
        return new E(f0, this);
    }

    @Override
    public final Object remove(int v) {
        this.b();
        Object object0 = this.a.remove(this.b + v);
        --this.d;
        this.c = this.a.i();
        return object0;
    }

    @Override
    public final boolean remove(Object object0) {
        int v = this.indexOf(object0);
        if(v >= 0) {
            this.remove(v);
            return true;
        }
        return false;
    }

    @Override
    public final boolean removeAll(Collection collection0) {
        boolean z;
        Iterator iterator0 = collection0.iterator();
    alab1:
        while(true) {
            for(z = false; true; z = true) {
                if(!iterator0.hasNext()) {
                    break alab1;
                }
                Object object0 = iterator0.next();
                if(!this.remove(object0) && !z) {
                    break;
                }
            }
        }
        return z;
    }

    @Override
    public final boolean retainAll(Collection collection0) {
        h h0;
        b b0;
        int v4;
        this.b();
        p p0 = this.a;
        int v = this.b;
        int v1 = this.d + v;
        int v2 = p0.size();
        do {
            synchronized(q.a) {
                o o0 = p0.a;
                kotlin.jvm.internal.q.e(o0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                o o1 = (o)m.i(o0);
                v4 = o1.d;
                b0 = o1.c;
            }
            kotlin.jvm.internal.q.d(b0);
            e e0 = b0.e();
            e0.subList(v, v1).retainAll(collection0);
            b b1 = e0.e();
            if(kotlin.jvm.internal.q.b(b1, b0)) {
                break;
            }
            o o2 = p0.a;
            kotlin.jvm.internal.q.e(o2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            synchronized(m.b) {
                h0 = m.k();
                boolean z = p.d(((o)m.w(o2, p0, h0)), v4, b1, true);
            }
            m.n(h0, p0);
        }
        while(!z);
        int v6 = v2 - p0.size();
        if(v6 > 0) {
            this.c = this.a.i();
            this.d -= v6;
        }
        return v6 > 0;
    }

    @Override
    public final Object set(int v, Object object0) {
        q.a(v, this.d);
        this.b();
        Object object1 = this.a.set(v + this.b, object0);
        this.c = this.a.i();
        return object1;
    }

    @Override
    public final int size() {
        return this.d;
    }

    @Override
    public final List subList(int v, int v1) {
        if(v < 0 || v > v1 || v1 > this.d) {
            j0.a("fromIndex or toIndex are out of bounds");
        }
        this.b();
        return new w(this.a, v + this.b, v1 + this.b);
    }

    @Override
    public final Object[] toArray() {
        return kotlin.jvm.internal.p.a(this);
    }

    @Override
    public final Object[] toArray(Object[] arr_object) {
        return kotlin.jvm.internal.p.b(this, arr_object);
    }
}

