package pe;

import d8.d;
import java.io.Serializable;
import kotlin.jvm.internal.q;

public final class c implements Serializable {
    public final Class a;
    private static final long serialVersionUID;

    public c(Enum[] arr_enum) {
        q.g(arr_enum, "entries");
        super();
        Class class0 = arr_enum.getClass().getComponentType();
        q.d(class0);
        this.a = class0;
    }

    private final Object readResolve() {
        Object[] arr_object = this.a.getEnumConstants();
        q.f(arr_object, "getEnumConstants(...)");
        return d.q(((Enum[])arr_object));
    }
}

