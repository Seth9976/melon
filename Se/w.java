package Se;

import gf.e;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.q;

public final class w extends v implements e {
    public final Method a;

    public w(Method method0) {
        q.g(method0, "member");
        super();
        this.a = method0;
    }

    @Override  // Se.v
    public final Member b() {
        return this.a;
    }

    public final A f() {
        Type type0 = this.a.getGenericReturnType();
        q.f(type0, "getGenericReturnType(...)");
        if(type0 instanceof Class && ((Class)type0).isPrimitive()) {
            return new y(((Class)type0));
        }
        if(!(type0 instanceof GenericArrayType) && (!(type0 instanceof Class) || !((Class)type0).isArray())) {
            return type0 instanceof WildcardType ? new D(((WildcardType)type0)) : new p(type0);
        }
        return new h(type0);
    }

    public final List g() {
        Type[] arr_type = this.a.getGenericParameterTypes();
        q.f(arr_type, "getGenericParameterTypes(...)");
        Annotation[][] arr2_annotation = this.a.getParameterAnnotations();
        q.f(arr2_annotation, "getParameterAnnotations(...)");
        return this.d(arr_type, arr2_annotation, this.a.isVarArgs());
    }

    @Override  // gf.e
    public final ArrayList getTypeParameters() {
        TypeVariable[] arr_typeVariable = this.a.getTypeParameters();
        q.f(arr_typeVariable, "getTypeParameters(...)");
        ArrayList arrayList0 = new ArrayList(arr_typeVariable.length);
        for(int v = 0; v < arr_typeVariable.length; ++v) {
            arrayList0.add(new B(arr_typeVariable[v]));
        }
        return arrayList0;
    }
}

