package tg;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

public final class a0 implements WildcardType {
    public final Type a;
    public final Type b;

    public a0(Type[] arr_type, Type[] arr_type1) {
        if(arr_type1.length > 1 || arr_type.length != 1) {
            throw new IllegalArgumentException();
        }
        if(arr_type1.length == 1) {
            arr_type1[0].getClass();
            b0.d(arr_type1[0]);
            Class class0 = Object.class;
            if(arr_type[0] != class0) {
                throw new IllegalArgumentException();
            }
            this.b = arr_type1[0];
            this.a = class0;
            return;
        }
        arr_type[0].getClass();
        b0.d(arr_type[0]);
        this.b = null;
        this.a = arr_type[0];
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof WildcardType && b0.e(this, ((WildcardType)object0));
    }

    @Override
    public final Type[] getLowerBounds() {
        return this.b == null ? b0.a : new Type[]{this.b};
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
            return "? super " + b0.s(type0);
        }
        return this.a == Object.class ? "?" : "? extends " + b0.s(this.a);
    }
}

