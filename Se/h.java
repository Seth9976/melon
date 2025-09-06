package Se;

import gf.d;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import je.w;
import kotlin.jvm.internal.q;

public final class h extends A implements d {
    public final Type a;
    public final A b;
    public final w c;

    public h(Type type0) {
        h h0;
        y y0;
        this.a = type0;
        if(type0 instanceof GenericArrayType) {
            Type type1 = ((GenericArrayType)type0).getGenericComponentType();
            q.f(type1, "getGenericComponentType(...)");
            if(type1 instanceof Class && ((Class)type1).isPrimitive()) {
                y0 = new y(((Class)type1));
                this.b = y0;
                this.c = w.a;
                return;
            }
            if(!(type1 instanceof GenericArrayType) && (!(type1 instanceof Class) || !((Class)type1).isArray())) {
                if(type1 instanceof WildcardType) {
                    h0 = new D(((WildcardType)type1));
                    y0 = h0;
                    this.b = y0;
                    this.c = w.a;
                    return;
                }
                h0 = new p(type1);
                y0 = h0;
                this.b = y0;
                this.c = w.a;
                return;
            }
            h0 = new h(type1);
        }
        else if(type0 instanceof Class && ((Class)type0).isArray()) {
            Class class0 = ((Class)type0).getComponentType();
            q.f(class0, "getComponentType(...)");
            if(class0.isPrimitive()) {
                h0 = new y(class0);
            }
            else if(class0 instanceof GenericArrayType || class0.isArray()) {
                h0 = new h(class0);
            }
            else if(class0 instanceof WildcardType) {
                h0 = new D(((WildcardType)class0));
            }
            else {
                h0 = new p(class0);
            }
        }
        else {
            throw new IllegalArgumentException("Not an array type (" + type0.getClass() + "): " + type0);
        }
        y0 = h0;
        this.b = y0;
        this.c = w.a;
    }

    @Override  // Se.A
    public final Type b() {
        return this.a;
    }

    @Override  // gf.b
    public final Collection getAnnotations() {
        return this.c;
    }
}

