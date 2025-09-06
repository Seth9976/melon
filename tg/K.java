package tg;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;

public final class k extends e {
    @Override  // tg.e
    public final f get(Type type0, Annotation[] arr_annotation, U u0) {
        if(e.getRawType(type0) != CompletableFuture.class) {
            return null;
        }
        if(!(type0 instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type type1 = e.getParameterUpperBound(0, ((ParameterizedType)type0));
        if(e.getRawType(type1) != Q.class) {
            return new i(0, type1);
        }
        if(!(type1 instanceof ParameterizedType)) {
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        return new i(1, e.getParameterUpperBound(0, ((ParameterizedType)type1)));
    }
}

