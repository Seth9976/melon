package i.n.i.b.a.s.e;

import java.io.Serializable;

public final class n8 extends A1 implements Serializable {
    public final Object a;
    public final Object b;

    public n8(Object object0, Object object1) {
        this.a = object0;
        this.b = object1;
    }

    @Override
    public final Object getKey() {
        return this.a;
    }

    @Override
    public final Object getValue() {
        return this.b;
    }

    @Override
    public final Object setValue(Object object0) {
        throw new UnsupportedOperationException();
    }
}

