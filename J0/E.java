package j0;

import D0.E;
import java.util.Iterator;
import java.util.Map.Entry;
import je.j;
import m0.f;

public final class e extends j {
    public final int a;
    public final f b;

    public e(int v, f f0) {
        this.a = v;
        super();
        this.b = f0;
    }

    @Override
    public final boolean add(Object object0) {
        if(this.a != 0) {
            throw new UnsupportedOperationException();
        }
        Map.Entry map$Entry0 = (Map.Entry)object0;
        throw new UnsupportedOperationException();
    }

    @Override  // je.j
    public final int b() {
        return this.b.size();
    }

    @Override
    public final void clear() {
        if(this.a != 0) {
            this.b.clear();
            return;
        }
        this.b.clear();
    }

    @Override
    public final boolean contains(Object object0) {
        if(this.a != 0) {
            return this.b.containsKey(object0);
        }
        if(object0 instanceof Map.Entry && (((Map.Entry)object0) == null ? null : ((Map.Entry)object0)) != null) {
            Object object1 = ((Map.Entry)object0).getKey();
            Object object2 = this.b.get(object1);
            return object2 == null ? ((Map.Entry)object0).getValue() == null && this.b.containsKey(((Map.Entry)object0).getKey()) : object2.equals(((Map.Entry)object0).getValue());
        }
        return false;
    }

    @Override
    public final Iterator iterator() {
        if(this.a != 0) {
            k[] arr_k = new k[8];
            for(int v = 0; v < 8; ++v) {
                arr_k[v] = new l(1);
            }
            return new j0.f(this.b, arr_k);  // 初始化器: Lj0/d;-><init>(Lm0/f;[Lj0/k;)V
        }
        return new E(this.b);
    }

    @Override
    public final boolean remove(Object object0) {
        if(this.a != 0) {
            f f0 = this.b;
            if(f0.containsKey(object0)) {
                f0.remove(object0);
                return true;
            }
            return false;
        }
        if(object0 instanceof Map.Entry && (((Map.Entry)object0) == null ? null : ((Map.Entry)object0)) != null) {
            Object object1 = ((Map.Entry)object0).getKey();
            Object object2 = ((Map.Entry)object0).getValue();
            return this.b.remove(object1, object2);
        }
        return false;
    }
}

