package H6;

import java.io.ObjectInputStream;
import java.io.Serializable;
import va.e;

public final class l implements k, Serializable {
    public transient Object a;
    public final k b;
    public volatile transient boolean c;
    public transient Object d;
    private static final long serialVersionUID;

    public l(k k0) {
        this.a = new Object();
        this.b = k0;
    }

    @Override  // H6.k
    public final Object get() {
        if(!this.c) {
            Object object0 = this.a;
            synchronized(object0) {
                if(!this.c) {
                    Object object1 = this.b.get();
                    this.d = object1;
                    this.c = true;
                    return object1;
                }
            }
        }
        return this.d;
    }

    private void readObject(ObjectInputStream objectInputStream0) {
        objectInputStream0.defaultReadObject();
        this.a = new Object();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Suppliers.memoize(");
        return this.c ? e.d(stringBuilder0, e.d(new StringBuilder("<supplier that returned "), this.d, ">"), ")") : e.d(stringBuilder0, this.b, ")");
    }
}

