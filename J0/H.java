package j0;

import java.util.Iterator;
import java.util.Map.Entry;
import je.k;

public final class h extends k {
    public final int a;
    public final b b;

    public h(b b0, int v) {
        this.a = v;
        this.b = b0;
        super();
    }

    @Override  // je.a
    public final boolean contains(Object object0) {
        if(this.a != 0) {
            return this.b.containsKey(object0);
        }
        if(object0 instanceof Map.Entry && ((Map.Entry)object0) != null) {
            Object object1 = ((Map.Entry)object0).getKey();
            Object object2 = this.b.get(object1);
            return object2 == null ? ((Map.Entry)object0).getValue() == null && this.b.containsKey(((Map.Entry)object0).getKey()) : object2.equals(((Map.Entry)object0).getValue());
        }
        return false;
    }

    @Override  // je.a
    public final int getSize() {
        if(this.a != 0) {
            this.b.getClass();
            return this.b.b;
        }
        this.b.getClass();
        return this.b.b;
    }

    @Override
    public final Iterator iterator() {
        if(this.a != 0) {
            j j0 = this.b.a;
            j0.k[] arr_k = new j0.k[8];
            for(int v = 0; v < 8; ++v) {
                arr_k[v] = new l(1);
            }
            return new i(j0, arr_k);  // 初始化器: Lj0/c;-><init>(Lj0/j;[Lj0/k;)V
        }
        j j1 = this.b.a;
        j0.k[] arr_k1 = new j0.k[8];
        for(int v1 = 0; v1 < 8; ++v1) {
            arr_k1[v1] = new l(0);
        }
        return new i(j1, arr_k1);  // 初始化器: Lj0/c;-><init>(Lj0/j;[Lj0/k;)V
    }
}

