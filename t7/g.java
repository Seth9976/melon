package T7;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Objects;

public final class g implements Serializable, WildcardType {
    public final Type a;
    public final Type b;
    private static final long serialVersionUID;

    public g(Type[] arr_type, Type[] arr_type1) {
        boolean z = true;
        h.b(arr_type1.length <= 1);
        h.b(arr_type.length == 1);
        if(arr_type1.length == 1) {
            Objects.requireNonNull(arr_type1[0]);
            h.c(arr_type1[0]);
            Class class0 = Object.class;
            if(arr_type[0] != class0) {
                z = false;
            }
            h.b(z);
            this.b = h.a(arr_type1[0]);
            this.a = class0;
            return;
        }
        Objects.requireNonNull(arr_type[0]);
        h.c(arr_type[0]);
        this.b = null;
        this.a = h.a(arr_type[0]);
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof WildcardType && h.e(this, ((WildcardType)object0));
    }

    @Override
    public final Type[] getLowerBounds() {
        return this.b == null ? h.a : new Type[]{this.b};
    }

    @Override
    public final Type[] getUpperBounds() {
        return new Type[]{this.a};
    }

    @Override
    public final int hashCode() {
        return this.b == null ? 1 ^ this.a.hashCode() + 0x1F : this.b.hashCode() + 0x1F ^ this.a.hashCode() + 0x1F;
    }

    @Override
    public final String toString() {
        Type type0 = this.b;
        if(type0 != null) {
            return "? super " + h.l(type0);
        }
        return this.a == Object.class ? "?" : "? extends " + h.l(this.a);
    }
}

