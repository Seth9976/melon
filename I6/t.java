package I6;

import java.io.Serializable;

public final class T implements Serializable {
    public final Object[] a;
    private static final long serialVersionUID;

    public T(Object[] arr_object) {
        this.a = arr_object;
    }

    public Object readResolve() {
        return V.q(this.a);
    }
}

