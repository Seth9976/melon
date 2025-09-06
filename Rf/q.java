package rf;

import java.io.UnsupportedEncodingException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class q extends AbstractList implements RandomAccess, r {
    public final ArrayList a;
    public static final E b;

    static {
        q.b = new E(new q());
    }

    public q() {
        this.a = new ArrayList();
    }

    public q(r r0) {
        this.a = new ArrayList(r0.size());
        this.addAll(r0);
    }

    @Override  // rf.r
    public final void T(s s0) {
        this.a.add(s0);
        ++this.modCount;
    }

    @Override  // rf.r
    public final E a0() {
        return new E(this);
    }

    @Override
    public final void add(int v, Object object0) {
        this.a.add(v, ((String)object0));
        ++this.modCount;
    }

    @Override
    public final boolean addAll(int v, Collection collection0) {
        if(collection0 instanceof r) {
            collection0 = ((r)collection0).h();
        }
        boolean z = this.a.addAll(v, collection0);
        ++this.modCount;
        return z;
    }

    @Override
    public final boolean addAll(Collection collection0) {
        return this.addAll(this.a.size(), collection0);
    }

    @Override
    public final void clear() {
        this.a.clear();
        ++this.modCount;
    }

    @Override
    public final Object get(int v) {
        String s1;
        ArrayList arrayList0 = this.a;
        Object object0 = arrayList0.get(v);
        if(object0 instanceof String) {
            return (String)object0;
        }
        if(object0 instanceof d) {
            String s = ((d)object0).r();
            if(((d)object0).i()) {
                arrayList0.set(v, s);
            }
            return s;
        }
        byte[] arr_b = (byte[])object0;
        try {
            s1 = new String(arr_b, "UTF-8");
        }
        catch(UnsupportedEncodingException unsupportedEncodingException0) {
            throw new RuntimeException("UTF-8 not supported?", unsupportedEncodingException0);
        }
        if(B.c(arr_b, 0, arr_b.length) == 0) {
            arrayList0.set(v, s1);
        }
        return s1;
    }

    @Override  // rf.r
    public final List h() {
        return Collections.unmodifiableList(this.a);
    }

    @Override  // rf.r
    public final d j(int v) {
        d d0;
        ArrayList arrayList0 = this.a;
        Object object0 = arrayList0.get(v);
        if(object0 instanceof d) {
            d0 = (d)object0;
        }
        else if(object0 instanceof String) {
            String s = (String)object0;
            try {
                d0 = new s(s.getBytes("UTF-8"));
            }
            catch(UnsupportedEncodingException unsupportedEncodingException0) {
                throw new RuntimeException("UTF-8 not supported?", unsupportedEncodingException0);
            }
        }
        else {
            byte[] arr_b = new byte[((byte[])object0).length];
            System.arraycopy(((byte[])object0), 0, arr_b, 0, ((byte[])object0).length);
            d0 = new s(arr_b);
        }
        if(d0 != object0) {
            arrayList0.set(v, d0);
        }
        return d0;
    }

    @Override
    public final Object remove(int v) {
        Object object0 = this.a.remove(v);
        ++this.modCount;
        if(object0 instanceof String) {
            return (String)object0;
        }
        if(object0 instanceof d) {
            return ((d)object0).r();
        }
        byte[] arr_b = (byte[])object0;
        try {
            return new String(arr_b, "UTF-8");
        }
        catch(UnsupportedEncodingException unsupportedEncodingException0) {
            throw new RuntimeException("UTF-8 not supported?", unsupportedEncodingException0);
        }
    }

    @Override
    public final Object set(int v, Object object0) {
        Object object1 = this.a.set(v, ((String)object0));
        if(object1 instanceof String) {
            return (String)object1;
        }
        if(object1 instanceof d) {
            return ((d)object1).r();
        }
        byte[] arr_b = (byte[])object1;
        try {
            return new String(arr_b, "UTF-8");
        }
        catch(UnsupportedEncodingException unsupportedEncodingException0) {
            throw new RuntimeException("UTF-8 not supported?", unsupportedEncodingException0);
        }
    }

    @Override
    public final int size() {
        return this.a.size();
    }
}

