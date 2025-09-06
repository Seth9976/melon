package Se;

import gf.d;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import je.w;
import kotlin.jvm.internal.q;
import qf.c;

public final class p extends A implements d {
    public final Type a;
    public final r b;

    public p(Type type0) {
        q.g(type0, "reflectType");
        n n0;
        super();
        this.a = type0;
        if(type0 instanceof Class) {
            n0 = new n(((Class)type0));
        }
        else if(type0 instanceof TypeVariable) {
            n0 = new B(((TypeVariable)type0));
        }
        else if(type0 instanceof ParameterizedType) {
            Type type1 = ((ParameterizedType)type0).getRawType();
            q.e(type1, "null cannot be cast to non-null type java.lang.Class<*>");
            n0 = new n(((Class)type1));
        }
        else {
            throw new IllegalStateException("Not a classifier type (" + type0.getClass() + "): " + type0);
        }
        this.b = n0;
    }

    @Override  // Se.A, gf.b
    public final Se.d a(c c0) {
        q.g(c0, "fqName");
        return null;
    }

    @Override  // Se.A
    public final Type b() {
        return this.a;
    }

    public final ArrayList c() {
        y y0;
        h h0;
        Iterable iterable0 = Se.c.c(this.a);
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
        for(Object object0: iterable0) {
            Type type0 = (Type)object0;
            q.g(type0, "type");
            boolean z = type0 instanceof Class;
            if(!z || !((Class)type0).isPrimitive()) {
                if(type0 instanceof GenericArrayType || z && ((Class)type0).isArray()) {
                    h0 = new h(type0);
                }
                else if(type0 instanceof WildcardType) {
                    h0 = new D(((WildcardType)type0));
                }
                else {
                    h0 = new p(type0);
                }
                y0 = h0;
            }
            else {
                y0 = new y(((Class)type0));
            }
            arrayList0.add(y0);
        }
        return arrayList0;
    }

    public final boolean d() {
        Type type0 = this.a;
        if(type0 instanceof Class) {
            TypeVariable[] arr_typeVariable = ((Class)type0).getTypeParameters();
            q.f(arr_typeVariable, "getTypeParameters(...)");
            return arr_typeVariable.length != 0;
        }
        return false;
    }

    @Override  // gf.b
    public final Collection getAnnotations() {
        return w.a;
    }
}

