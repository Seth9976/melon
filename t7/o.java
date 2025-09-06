package T7;

import A1.f;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Set;

public final class o extends AbstractMap implements Serializable {
    public final Comparator a;
    public final boolean b;
    public n c;
    public int d;
    public int e;
    public final n f;
    public l g;
    public l h;
    public static final f i;

    static {
        o.i = new f(6);
    }

    public o(boolean z) {
        this.d = 0;
        this.e = 0;
        this.a = o.i;
        this.b = z;
        this.f = new n(z);
    }

    public final n a(Object object0, boolean z) {
        n n3;
        int v;
        n n0 = this.c;
        f f0 = o.i;
        Comparator comparator0 = this.a;
        if(n0 == null) {
            v = 0;
        }
        else {
            Comparable comparable0 = comparator0 == f0 ? ((Comparable)object0) : null;
            while(true) {
                v = comparable0 == null ? comparator0.compare(object0, n0.f) : comparable0.compareTo(n0.f);
                if(v == 0) {
                    return n0;
                }
                n n1 = v >= 0 ? n0.c : n0.b;
                if(n1 == null) {
                    break;
                }
                n0 = n1;
            }
        }
        if(!z) {
            return null;
        }
        n n2 = this.f;
        if(n0 == null) {
            if(comparator0 == f0 && !(object0 instanceof Comparable)) {
                throw new ClassCastException(object0.getClass().getName() + " is not Comparable");
            }
            n3 = new n(this.b, null, object0, n2, n2.e);
            this.c = n3;
        }
        else {
            n3 = new n(this.b, n0, object0, n2, n2.e);
            if(v < 0) {
                n0.b = n3;
            }
            else {
                n0.c = n3;
            }
            this.b(n0, true);
        }
        ++this.d;
        ++this.e;
        return n3;
    }

    public final void b(n n0, boolean z) {
    alab1:
        while(n0 != null) {
            n n1 = n0.b;
            n n2 = n0.c;
            int v = 0;
            int v1 = n1 == null ? 0 : n1.i;
            int v2 = n2 == null ? 0 : n2.i;
            int v3 = v1 - v2;
            if(v3 == -2) {
                n n3 = n2.b;
                int v4 = n2.c == null ? 0 : n2.c.i;
                if(n3 != null) {
                    v = n3.i;
                }
                if(v - v4 != -1 && (v - v4 != 0 || z)) {
                    this.g(n2);
                }
                this.e(n0);
                if(z) {
                    return;
                }
            }
            else {
                switch(v3) {
                    case 0: {
                        n0.i = v1 + 1;
                        if(z) {
                            return;
                        }
                        break;
                    }
                    case 2: {
                        n n4 = n1.b;
                        int v5 = n1.c == null ? 0 : n1.c.i;
                        if(n4 != null) {
                            v = n4.i;
                        }
                        if(v - v5 != 1 && (v - v5 != 0 || z)) {
                            this.e(n1);
                        }
                        this.g(n0);
                        if(z) {
                            return;
                        }
                        break;
                    }
                    default: {
                        n0.i = Math.max(v1, v2) + 1;
                        if(!z) {
                            break alab1;
                        }
                    }
                }
            }
            n0 = n0.a;
        }
    }

    public final void c(n n0, boolean z) {
        int v1;
        n n8;
        n n5;
        if(z) {
            n0.e.d = n0.d;
            n0.d.e = n0.e;
        }
        n n1 = n0.b;
        n n2 = n0.c;
        n n3 = n0.a;
        int v = 0;
        if(n1 != null && n2 != null) {
            if(n1.i > n2.i) {
                for(n n4 = n1.c; true; n4 = n1.c) {
                    n5 = n1;
                    n1 = n4;
                    if(n1 == null) {
                        break;
                    }
                }
            }
            else {
                for(n n6 = n2.b; true; n6 = n2.b) {
                    n n7 = n2;
                    n2 = n6;
                    n8 = n7;
                    if(n2 == null) {
                        break;
                    }
                }
                n5 = n8;
            }
            this.c(n5, false);
            n n9 = n0.b;
            if(n9 == null) {
                v1 = 0;
            }
            else {
                v1 = n9.i;
                n5.b = n9;
                n9.a = n5;
                n0.b = null;
            }
            n n10 = n0.c;
            if(n10 != null) {
                v = n10.i;
                n5.c = n10;
                n10.a = n5;
                n0.c = null;
            }
            n5.i = Math.max(v1, v) + 1;
            this.d(n0, n5);
            return;
        }
        if(n1 != null) {
            this.d(n0, n1);
            n0.b = null;
        }
        else if(n2 == null) {
            this.d(n0, null);
        }
        else {
            this.d(n0, n2);
            n0.c = null;
        }
        this.b(n3, false);
        --this.d;
        ++this.e;
    }

    @Override
    public final void clear() {
        this.c = null;
        this.d = 0;
        ++this.e;
        this.f.e = this.f;
        this.f.d = this.f;
    }

    @Override
    public final boolean containsKey(Object object0) {
        n n0 = null;
        if(object0 != null) {
            try {
                n0 = this.a(object0, false);
            }
            catch(ClassCastException unused_ex) {
            }
        }
        return n0 != null;
    }

    public final void d(n n0, n n1) {
        n n2 = n0.a;
        n0.a = null;
        if(n1 != null) {
            n1.a = n2;
        }
        if(n2 != null) {
            if(n2.b == n0) {
                n2.b = n1;
                return;
            }
            n2.c = n1;
            return;
        }
        this.c = n1;
    }

    public final void e(n n0) {
        n n1 = n0.b;
        n n2 = n0.c;
        n n3 = n2.b;
        n n4 = n2.c;
        n0.c = n3;
        if(n3 != null) {
            n3.a = n0;
        }
        this.d(n0, n2);
        n2.b = n0;
        n0.a = n2;
        int v = 0;
        int v1 = Math.max((n1 == null ? 0 : n1.i), (n3 == null ? 0 : n3.i));
        n0.i = v1 + 1;
        if(n4 != null) {
            v = n4.i;
        }
        n2.i = Math.max(v1 + 1, v) + 1;
    }

    @Override
    public final Set entrySet() {
        l l0 = this.g;
        if(l0 == null) {
            l0 = new l(this, 0);
            this.g = l0;
        }
        return l0;
    }

    public final void g(n n0) {
        n n1 = n0.b;
        n n2 = n0.c;
        n n3 = n1.b;
        n n4 = n1.c;
        n0.b = n4;
        if(n4 != null) {
            n4.a = n0;
        }
        this.d(n0, n1);
        n1.c = n0;
        n0.a = n1;
        int v = 0;
        int v1 = Math.max((n2 == null ? 0 : n2.i), (n4 == null ? 0 : n4.i));
        n0.i = v1 + 1;
        if(n3 != null) {
            v = n3.i;
        }
        n1.i = Math.max(v1 + 1, v) + 1;
    }

    @Override
    public final Object get(Object object0) {
        n n0 = null;
        if(object0 != null) {
            try {
                n0 = this.a(object0, false);
            }
            catch(ClassCastException unused_ex) {
            }
        }
        return n0 == null ? null : n0.h;
    }

    @Override
    public final Set keySet() {
        l l0 = this.h;
        if(l0 == null) {
            l0 = new l(this, 1);
            this.h = l0;
        }
        return l0;
    }

    @Override
    public final Object put(Object object0, Object object1) {
        if(object0 == null) {
            throw new NullPointerException("key == null");
        }
        if(object1 == null && !this.b) {
            throw new NullPointerException("value == null");
        }
        n n0 = this.a(object0, true);
        Object object2 = n0.h;
        n0.h = object1;
        return object2;
    }

    private void readObject(ObjectInputStream objectInputStream0) {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    @Override
    public final Object remove(Object object0) {
        n n0 = null;
        if(object0 != null) {
            try {
                n0 = this.a(object0, false);
            }
            catch(ClassCastException unused_ex) {
            }
        }
        if(n0 != null) {
            this.c(n0, true);
        }
        return n0 == null ? null : n0.h;
    }

    @Override
    public final int size() {
        return this.d;
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }
}

