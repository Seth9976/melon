package ug;

import com.google.gson.E;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import tg.U;
import tg.l;
import tg.m;

public final class a extends l {
    public final n a;

    public a(n n0) {
        this.a = n0;
    }

    @Override  // tg.l
    public final m a(Type type0, Annotation[] arr_annotation, Annotation[] arr_annotation1, U u0) {
        TypeToken typeToken0 = TypeToken.get(type0);
        E e0 = this.a.g(typeToken0);
        return new b(this.a, e0);
    }

    @Override  // tg.l
    public final m b(Type type0, Annotation[] arr_annotation, U u0) {
        TypeToken typeToken0 = TypeToken.get(type0);
        E e0 = this.a.g(typeToken0);
        return new x9.a(this.a, e0);
    }

    public static a c() {
        return new a(new n());
    }
}

