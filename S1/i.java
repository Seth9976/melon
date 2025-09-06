package S1;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class i extends h {
    @Override  // S1.h
    public final Typeface b0(Object object0) {
        try {
            Object object1 = Array.newInstance(this.f, 1);
            Array.set(object1, 0, object0);
            return (Typeface)this.l.invoke(null, object1, "sans-serif", -1, -1);
        }
        catch(IllegalAccessException | InvocationTargetException illegalAccessException0) {
            throw new RuntimeException(illegalAccessException0);
        }
    }

    @Override  // S1.h
    public final Method f0(Class class0) {
        Class[] arr_class = {Array.newInstance(class0, 1).getClass(), String.class, Integer.TYPE, Integer.TYPE};
        Method method0 = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", arr_class);
        method0.setAccessible(true);
        return method0;
    }
}

