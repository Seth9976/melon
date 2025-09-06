package tg;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class e {
    public abstract f get(Type arg1, Annotation[] arg2, U arg3);

    public static Type getParameterUpperBound(int v, ParameterizedType parameterizedType0) {
        return b0.g(v, parameterizedType0);
    }

    public static Class getRawType(Type type0) {
        return b0.h(type0);
    }
}

