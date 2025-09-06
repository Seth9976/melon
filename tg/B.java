package tg;

import ie.H;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import pc.t;
import vg.w;

public final class b extends l {
    public final int a;

    public b(int v) {
        this.a = v;
        super();
    }

    @Override  // tg.l
    public m a(Type type0, Annotation[] arr_annotation, Annotation[] arr_annotation1, U u0) {
        if(this.a != 0) {
            return super.a(type0, arr_annotation, arr_annotation1, u0);
        }
        Class class0 = b0.h(type0);
        return RequestBody.class.isAssignableFrom(class0) ? a.d : null;
    }

    @Override  // tg.l
    public final m b(Type type0, Annotation[] arr_annotation, U u0) {
        if(this.a != 0) {
            return b0.h(type0) != Optional.class ? null : new t(u0.d(b0.g(0, ((ParameterizedType)type0)), arr_annotation), 20);
        }
        if(type0 == ResponseBody.class) {
            return b0.l(arr_annotation, w.class) ? a.e : a.c;
        }
        if(type0 == Void.class) {
            return a.g;
        }
        return b0.b && type0 == H.class ? a.f : null;
    }
}

