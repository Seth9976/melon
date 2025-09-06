package I6;

import java.io.Serializable;

public final class a0 implements Serializable {
    public final Object[] a;
    private static final long serialVersionUID;

    public a0(Object[] arr_object) {
        this.a = arr_object;
    }

    public Object readResolve() {
        Object[] arr_object = this.a;
        switch(arr_object.length) {
            case 0: {
                return v0.j;
            }
            case 1: {
                return new E0(arr_object[0]);
            }
            default: {
                Object[] arr_object1 = (Object[])arr_object.clone();
                return b0.o(arr_object.length, arr_object1);
            }
        }
    }
}

