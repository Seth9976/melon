package Ge;

import Hd.z;
import Kd.b;
import Kd.g;
import androidx.compose.runtime.b0;
import ie.H;
import ie.j;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;
import jd.F1;
import jd.Y1;
import je.n;
import kotlin.jvm.internal.q;
import ld.m;
import p0.p;
import w0.h;
import we.a;
import we.k;

public final class o0 implements a {
    public final int a;
    public final int b;
    public final Object c;
    public final Object d;

    public o0(Object object0, int v, Object object1, int v1) {
        this.a = v1;
        this.c = object0;
        this.b = v;
        this.d = object1;
        super();
    }

    public o0(Object object0, Object object1, int v, int v1) {
        this.a = v1;
        this.c = object0;
        this.d = object1;
        this.b = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        Type type1;
        switch(this.a) {
            case 0: {
                p0 p00 = (p0)this.c;
                Type type0 = p00.b == null ? null : ((Type)p00.b.invoke());
                if(type0 instanceof Class) {
                    type1 = ((Class)type0).isArray() ? ((Class)type0).getComponentType() : Object.class;
                    q.d(type1);
                    return type1;
                }
                int v = this.b;
                if(type0 instanceof GenericArrayType) {
                    if(v != 0) {
                        throw new s0("Array type has been queried for a non-0th argument: " + p00);
                    }
                    type1 = ((GenericArrayType)type0).getGenericComponentType();
                    q.d(type1);
                    return type1;
                }
                if(!(type0 instanceof ParameterizedType)) {
                    throw new s0("Non-generic type has been queried for arguments: " + p00);
                }
                type1 = (Type)((List)((j)this.d).getValue()).get(v);
                if(type1 instanceof WildcardType) {
                    Type[] arr_type = ((WildcardType)type1).getLowerBounds();
                    q.f(arr_type, "getLowerBounds(...)");
                    Type type2 = (Type)n.i0(arr_type);
                    if(type2 == null) {
                        Type[] arr_type1 = ((WildcardType)type1).getUpperBounds();
                        q.f(arr_type1, "getUpperBounds(...)");
                        type1 = (Type)n.h0(arr_type1);
                    }
                    else {
                        type1 = type2;
                    }
                    q.d(type1);
                }
                return type1;
            }
            case 1: {
                h.a(((h)this.c));
                ((z)this.d).f.invoke(this.b, ((z)this.d));
                return H.a;
            }
            case 2: {
                b0 b00 = (b0)this.c;
                int v1 = ((Number)b00.getValue()).intValue();
                int v2 = this.b;
                if(v1 != v2) {
                    b00.setValue(v2);
                    k k0 = (k)this.d;
                    if(k0 != null) {
                        k0.invoke(v2);
                    }
                }
                return H.a;
            }
            case 3: {
                h.a(((h)this.c));
                Y1 y10 = (Y1)((F1)this.d).getViewModel();
                p p0 = y10.e;
                int v3 = this.b;
                if(p0.contains(v3)) {
                    p0.remove(v3);
                }
                else {
                    p0.add(v3);
                }
                y10.g();
                return H.a;
            }
            default: {
                g g0 = (g)this.c;
                if(g0.i) {
                    b b0 = new b(g0, this.b);
                    ((m)this.d).sendUserEvent(b0);
                }
                return H.a;
            }
        }
    }
}

