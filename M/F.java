package m;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class f implements Iterable {
    public c a;
    public c b;
    public final WeakHashMap c;
    public int d;

    public f() {
        this.c = new WeakHashMap();
        this.d = 0;
    }

    public c a(Object object0) {
        c c0;
        for(c0 = this.a; c0 != null && !c0.a.equals(object0); c0 = c0.c) {
        }
        return c0;
    }

    public Object b(Object object0) {
        c c0 = this.a(object0);
        if(c0 == null) {
            return null;
        }
        --this.d;
        WeakHashMap weakHashMap0 = this.c;
        if(!weakHashMap0.isEmpty()) {
            for(Object object1: weakHashMap0.keySet()) {
                ((e)object1).a(c0);
            }
        }
        c c1 = c0.d;
        if(c1 == null) {
            this.a = c0.c;
        }
        else {
            c1.c = c0.c;
        }
        c c2 = c0.c;
        if(c2 == null) {
            this.b = c1;
        }
        else {
            c2.d = c1;
        }
        c0.c = null;
        c0.d = null;
        return c0.b;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof f)) {
            return false;
        }
        if(this.d != ((f)object0).d) {
            return false;
        }
        Iterator iterator0 = this.iterator();
        Iterator iterator1 = ((f)object0).iterator();
        while(((b)iterator0).hasNext() && ((b)iterator1).hasNext()) {
            Map.Entry map$Entry0 = (Map.Entry)((b)iterator0).next();
            Object object1 = ((b)iterator1).next();
            if(map$Entry0 == null && object1 != null || map$Entry0 != null && !map$Entry0.equals(object1)) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return !((b)iterator0).hasNext() && !((b)iterator1).hasNext();
    }

    @Override
    public final int hashCode() {
        Iterator iterator0 = this.iterator();
        int v;
        for(v = 0; ((b)iterator0).hasNext(); v += ((Map.Entry)((b)iterator0).next()).hashCode()) {
        }
        return v;
    }

    @Override
    public final Iterator iterator() {
        Iterator iterator0 = new b(this.a, this.b, 0);
        this.c.put(iterator0, Boolean.FALSE);
        return iterator0;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[");
        Iterator iterator0 = this.iterator();
        while(((b)iterator0).hasNext()) {
            stringBuilder0.append(((Map.Entry)((b)iterator0).next()).toString());
            if(((b)iterator0).hasNext()) {
                stringBuilder0.append(", ");
            }
        }
        stringBuilder0.append("]");
        return stringBuilder0.toString();
    }
}

