package He;

import Q8.h;
import com.google.firebase.b;
import e.k;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import je.n;
import kotlin.jvm.internal.q;

public abstract class x implements g {
    public final Member a;
    public final Type b;
    public final Class c;
    public final List d;

    public x(Member member0, Type type0, Class class0, Type[] arr_type) {
        List list0;
        this.a = member0;
        this.b = type0;
        this.c = class0;
        if(class0 == null) {
            list0 = n.z0(arr_type);
        }
        else {
            h h0 = new h(2);
            ArrayList arrayList0 = h0.a;
            h0.f(class0);
            h0.h(arr_type);
            list0 = k.A(arrayList0.toArray(new Type[arrayList0.size()]));
        }
        this.d = list0;
    }

    @Override  // He.g
    public final List a() {
        return this.d;
    }

    @Override  // He.g
    public final Member b() {
        return this.a;
    }

    @Override  // He.g
    public final boolean c() {
        return false;
    }

    public void d(Object[] arr_object) {
        q.g(arr_object, "args");
        if(b.C(this) == arr_object.length) {
            return;
        }
        StringBuilder stringBuilder0 = new StringBuilder("Callable expects ");
        stringBuilder0.append(b.C(this));
        stringBuilder0.append(" arguments, but ");
        throw new IllegalArgumentException(U4.x.g(arr_object.length, " were provided.", stringBuilder0));
    }

    public final void e(Object object0) {
        if(object0 == null || !this.a.getDeclaringClass().isInstance(object0)) {
            throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }

    @Override  // He.g
    public final Type getReturnType() {
        return this.b;
    }
}

