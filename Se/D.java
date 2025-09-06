package Se;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import qf.e;

public final class d extends r {
    public final Annotation a;

    public d(Annotation annotation0) {
        q.g(annotation0, "annotation");
        super();
        this.a = annotation0;
    }

    public final ArrayList b() {
        s s0;
        Annotation annotation0 = this.a;
        Method[] arr_method = df.d.v(df.d.s(annotation0)).getDeclaredMethods();
        q.f(arr_method, "getDeclaredMethods(...)");
        ArrayList arrayList0 = new ArrayList(arr_method.length);
        for(int v = 0; v < arr_method.length; ++v) {
            Method method0 = arr_method[v];
            Object object0 = method0.invoke(annotation0, null);
            q.f(object0, "invoke(...)");
            e e0 = e.e(method0.getName());
            Class class0 = object0.getClass();
            if(Enum.class.isAssignableFrom(class0)) {
                s0 = new s(e0, ((Enum)object0));
            }
            else if(object0 instanceof Annotation) {
                s0 = new f(e0, ((Annotation)object0));
            }
            else if(object0 instanceof Object[]) {
                s0 = new g(e0, ((Object[])object0));
            }
            else if(object0 instanceof Class) {
                s0 = new o(e0, ((Class)object0));
            }
            else {
                s0 = new u(e0, object0);
            }
            arrayList0.add(s0);
        }
        return arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof d && this.a == ((d)object0).a;
    }

    @Override
    public final int hashCode() {
        return System.identityHashCode(this.a);
    }

    // 去混淆评级： 低(40)
    @Override
    public final String toString() {
        return "Se.d: " + this.a;
    }
}

