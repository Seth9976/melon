package I6;

import i.n.i.b.a.s.e.B1;
import i.n.i.b.a.s.e.J0;
import i.n.i.b.a.s.e.K0;
import i.n.i.b.a.s.e.L0;
import i.n.i.b.a.s.e.N0;
import i.n.i.b.a.s.e.O0;
import i.n.i.b.a.s.e.Q0;
import i.n.i.b.a.s.e.S0;
import i.n.i.b.a.s.e.n8;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;

public class f extends AbstractMap {
    public final int a;
    public final transient Map b;
    public transient AbstractSet c;
    public transient AbstractCollection d;
    public final Serializable e;

    public f(Serializable serializable0, Map map0, int v) {
        this.a = v;
        this.e = serializable0;
        super();
        this.b = map0;
    }

    public n8 a(Map.Entry map$Entry0) {
        Object object0 = map$Entry0.getKey();
        B1 b10 = (B1)this.e;
        List list0 = (List)(((Collection)map$Entry0.getValue()));
        return list0 instanceof RandomAccess ? new n8(object0, new O0(b10, object0, list0, null)) : new n8(object0, new S0(b10, object0, list0, null));  // 初始化器: Li/n/i/b/a/s/e/S0;-><init>(Li/n/i/b/a/s/e/B1;Ljava/lang/Object;Ljava/util/List;Li/n/i/b/a/s/e/S0;)V
    }

    public P b(Map.Entry map$Entry0) {
        Object object0 = map$Entry0.getKey();
        Collection collection0 = (Collection)map$Entry0.getValue();
        return new P(object0, ((q)this.e).j(object0, collection0));
    }

    @Override
    public final void clear() {
        if(this.a != 0) {
            B1 b10 = (B1)this.e;
            if(this.b == b10.d) {
                b10.c();
                return;
            }
            K0 k00 = new K0(this);
            while(k00.hasNext()) {
                k00.next();
                k00.remove();
            }
            return;
        }
        q q0 = (q)this.e;
        if(this.b == q0.d) {
            q0.d();
            return;
        }
        e e0 = new e(this);
        while(e0.hasNext()) {
            e0.next();
            e0.remove();
        }
    }

    @Override
    public final boolean containsKey(Object object0) {
        if(this.a != 0) {
            this.b.getClass();
            try {
                return this.b.containsKey(object0);
            }
            catch(ClassCastException | NullPointerException unused_ex) {
                return false;
            }
        }
        this.b.getClass();
        try {
            return this.b.containsKey(object0);
        }
        catch(ClassCastException | NullPointerException unused_ex) {
            return false;
        }
    }

    @Override
    public final Set entrySet() {
        if(this.a != 0) {
            AbstractSet abstractSet0 = (J0)this.c;
            if(abstractSet0 == null) {
                abstractSet0 = new J0(this);
                this.c = abstractSet0;
            }
            return abstractSet0;
        }
        AbstractSet abstractSet1 = (d)this.c;
        if(abstractSet1 == null) {
            abstractSet1 = new d(this);
            this.c = abstractSet1;
        }
        return abstractSet1;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || this.b.equals(object0);
    }

    @Override
    public final Object get(Object object0) {
        Object object1;
        if(this.a != 0) {
            this.b.getClass();
            try {
                object1 = this.b.get(object0);
            }
            catch(ClassCastException | NullPointerException unused_ex) {
                object1 = null;
            }
            if(((Collection)object1) != null) {
                B1 b10 = (B1)this.e;
                return ((List)(((Collection)object1))) instanceof RandomAccess ? new O0(b10, object0, ((List)(((Collection)object1))), null) : new S0(b10, object0, ((List)(((Collection)object1))), null);  // 初始化器: Li/n/i/b/a/s/e/S0;-><init>(Li/n/i/b/a/s/e/B1;Ljava/lang/Object;Ljava/util/List;Li/n/i/b/a/s/e/S0;)V
            }
            return null;
        }
        this.b.getClass();
        try {
            Object object2 = this.b.get(object0);
            return ((Collection)object2) == null ? null : ((q)this.e).j(object0, ((Collection)object2));
        }
        catch(ClassCastException | NullPointerException unused_ex) {
            return null;
        }
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode();
    }

    @Override
    public Set keySet() {
        L0 l00;
        if(this.a != 0) {
            B1 b10 = (B1)this.e;
            Set set0 = b10.a;
            if(set0 == null) {
                Map map0 = b10.d;
                if(map0 instanceof NavigableMap) {
                    l00 = new N0(b10, ((NavigableMap)map0));
                }
                else if(map0 instanceof SortedMap) {
                    l00 = new Q0(b10, ((SortedMap)map0));
                }
                else {
                    l00 = new L0(b10, map0);
                }
                set0 = l00;
                b10.a = set0;
            }
            return set0;
        }
        q q0 = (q)this.e;
        Set set1 = q0.a;
        if(set1 == null) {
            set1 = q0.g();
            q0.a = set1;
        }
        return set1;
    }

    @Override
    public final Object remove(Object object0) {
        if(this.a != 0) {
            B1 b10 = (B1)this.e;
            Collection collection0 = (Collection)this.b.remove(object0);
            if(collection0 == null) {
                return null;
            }
            List list0 = (List)b10.f.a();
            list0.addAll(collection0);
            b10.e -= collection0.size();
            collection0.clear();
            return list0;
        }
        q q0 = (q)this.e;
        Collection collection1 = (Collection)this.b.remove(object0);
        if(collection1 == null) {
            return null;
        }
        Collection collection2 = q0.f();
        collection2.addAll(collection1);
        q0.e -= collection1.size();
        collection1.clear();
        return collection2;
    }

    @Override
    public final int size() {
        return this.b.size();
    }

    @Override
    public final String toString() {
        return this.b.toString();
    }

    @Override
    public final Collection values() {
        if(this.a != 0) {
            AbstractCollection abstractCollection0 = (s)this.d;
            if(abstractCollection0 == null) {
                abstractCollection0 = new s(this, 3);
                this.d = abstractCollection0;
            }
            return abstractCollection0;
        }
        AbstractCollection abstractCollection1 = (s)this.d;
        if(abstractCollection1 == null) {
            abstractCollection1 = new s(this, 2);
            this.d = abstractCollection1;
        }
        return abstractCollection1;
    }
}

