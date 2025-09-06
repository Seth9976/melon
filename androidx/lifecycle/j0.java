package androidx.lifecycle;

import android.app.Application;
import c2.Y;
import e.k;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import je.n;
import kotlin.jvm.internal.q;

public abstract class j0 {
    public static final List a;
    public static final List b;

    static {
        j0.a = k.A(new Class[]{Application.class, c0.class});
        j0.b = k.z(c0.class);
    }

    public static final Constructor a(Class class0, List list0) {
        q.g(class0, "modelClass");
        q.g(list0, "signature");
        Y y0 = q.j(class0.getConstructors());
        while(y0.hasNext()) {
            Constructor constructor0 = (Constructor)y0.next();
            Class[] arr_class = constructor0.getParameterTypes();
            q.f(arr_class, "getParameterTypes(...)");
            List list1 = n.z0(arr_class);
            if(list0.equals(list1)) {
                return constructor0;
            }
            if(list0.size() == list1.size() && list1.containsAll(list0)) {
                throw new UnsupportedOperationException("Class " + class0.getSimpleName() + " must have parameters in the proper order: " + list0);
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    public static final m0 b(Class class0, Constructor constructor0, Object[] arr_object) {
        q.g(class0, "modelClass");
        try {
            return (m0)constructor0.newInstance(Arrays.copyOf(arr_object, arr_object.length));
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new RuntimeException("Failed to access " + class0, illegalAccessException0);
        }
        catch(InstantiationException instantiationException0) {
            throw new RuntimeException("A " + class0 + " cannot be instantiated.", instantiationException0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            throw new RuntimeException("An exception happened in constructor of " + class0, invocationTargetException0.getCause());
        }
    }
}

