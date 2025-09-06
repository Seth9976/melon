package T7;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

public final class f implements Serializable, ParameterizedType {
    public final Type a;
    public final Type b;
    public final Type[] c;
    private static final long serialVersionUID;

    public f(Type type0, Class class0, Type[] arr_type) {
        Objects.requireNonNull(class0);
        if(type0 == null && !Modifier.isStatic(class0.getModifiers()) && class0.getDeclaringClass() != null) {
            throw new IllegalArgumentException("Must specify owner type for " + class0);
        }
        this.a = type0 == null ? null : h.a(type0);
        this.b = h.a(class0);
        Type[] arr_type1 = (Type[])arr_type.clone();
        this.c = arr_type1;
        for(int v = 0; v < arr_type1.length; ++v) {
            Objects.requireNonNull(this.c[v]);
            h.c(this.c[v]);
            this.c[v] = h.a(this.c[v]);
        }
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof ParameterizedType && h.e(this, ((ParameterizedType)object0));
    }

    @Override
    public final Type[] getActualTypeArguments() {
        return (Type[])this.c.clone();
    }

    @Override
    public final Type getOwnerType() {
        return this.a;
    }

    @Override
    public final Type getRawType() {
        return this.b;
    }

    @Override
    public final int hashCode() {
        int v = Arrays.hashCode(this.c);
        int v1 = this.b.hashCode();
        return this.a == null ? v ^ v1 : v ^ v1 ^ this.a.hashCode();
    }

    @Override
    public final String toString() {
        Type[] arr_type = this.c;
        Type type0 = this.b;
        if(arr_type.length == 0) {
            return h.l(type0);
        }
        StringBuilder stringBuilder0 = new StringBuilder((arr_type.length + 1) * 30);
        stringBuilder0.append(h.l(type0));
        stringBuilder0.append("<");
        stringBuilder0.append(h.l(arr_type[0]));
        for(int v = 1; v < arr_type.length; ++v) {
            stringBuilder0.append(", ");
            stringBuilder0.append(h.l(arr_type[v]));
        }
        stringBuilder0.append(">");
        return stringBuilder0.toString();
    }
}

