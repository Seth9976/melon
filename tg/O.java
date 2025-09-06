package tg;

import ea.b;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

public final class o extends e {
    public final Executor a;

    public o(Executor executor0) {
        this.a = executor0;
    }

    @Override  // tg.e
    public final f get(Type type0, Annotation[] arr_annotation, U u0) {
        Executor executor0 = null;
        if(e.getRawType(type0) != d.class) {
            return null;
        }
        if(!(type0 instanceof ParameterizedType)) {
            throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
        }
        Type type1 = b0.g(0, ((ParameterizedType)type0));
        if(!b0.l(arr_annotation, W.class)) {
            executor0 = this.a;
        }
        return new b(type1, executor0);
    }
}

