package He;

import ie.H;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import kotlin.jvm.internal.q;

public abstract class w extends x {
    public final boolean e;

    public w(Method method0, boolean z, int v) {
        if((v & 2) != 0) {
            z = !Modifier.isStatic(method0.getModifiers());
        }
        Type[] arr_type = method0.getGenericParameterTypes();
        q.f(arr_type, "getGenericParameterTypes(...)");
        this(method0, z, arr_type);
    }

    public w(Method method0, boolean z, Type[] arr_type) {
        Type type0 = method0.getGenericReturnType();
        q.f(type0, "getGenericReturnType(...)");
        super(method0, type0, (z ? method0.getDeclaringClass() : null), arr_type);
        this.e = type0.equals(Void.TYPE);
    }

    public final Object f(Object[] arr_object, Object object0) {
        q.g(arr_object, "args");
        Object[] arr_object1 = Arrays.copyOf(arr_object, arr_object.length);
        H h0 = ((Method)this.a).invoke(object0, arr_object1);
        return this.e ? H.a : h0;
    }
}

