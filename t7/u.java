package T7;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class u {
    public static final u a;

    static {
        q q0;
        Class class1;
        Class class0;
        try {
            class0 = ObjectStreamClass.class;
            class1 = Class.class;
            Class class2 = Class.forName("sun.misc.Unsafe");
            Field field0 = class2.getDeclaredField("theUnsafe");
            field0.setAccessible(true);
            Object object0 = field0.get(null);
            q0 = new q(class2.getMethod("allocateInstance", class1), object0);
        }
        catch(Exception unused_ex) {
            try {
                Method method0 = class0.getDeclaredMethod("getConstructorId", class1);
                method0.setAccessible(true);
                int v = (int)(((Integer)method0.invoke(null, Object.class)));
                Method method1 = class0.getDeclaredMethod("newInstance", class1, Integer.TYPE);
                method1.setAccessible(true);
                q0 = new r(method1, v);
            }
            catch(Exception unused_ex) {
                try {
                    Method method2 = ObjectInputStream.class.getDeclaredMethod("newInstance", class1, class1);
                    method2.setAccessible(true);
                    q0 = new s(method2);
                }
                catch(Exception unused_ex) {
                    q0 = new t();  // 初始化器: Ljava/lang/Object;-><init>()V
                }
            }
        }
        u.a = q0;
    }

    public abstract Object a(Class arg1);
}

