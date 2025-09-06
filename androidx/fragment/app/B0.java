package androidx.fragment.app;

import androidx.collection.V;
import i.n.i.b.a.s.e.M3;

public final class b0 {
    public final l0 a;
    public static final V b;

    static {
        b0.b = new V(0);
    }

    public b0(l0 l00) {
        this.a = l00;
    }

    public static Class a(ClassLoader classLoader0, String s) {
        V v0 = b0.b;
        V v1 = (V)v0.get(classLoader0);
        if(v1 == null) {
            v1 = new V(0);
            v0.put(classLoader0, v1);
        }
        Class class0 = (Class)v1.get(s);
        if(class0 == null) {
            Class class1 = Class.forName(s, false, classLoader0);
            v1.put(s, class1);
            return class1;
        }
        return class0;
    }

    public static Class b(ClassLoader classLoader0, String s) {
        try {
            return b0.a(classLoader0, s);
        }
        catch(ClassNotFoundException classNotFoundException0) {
            throw new M3("Unable to instantiate fragment " + s + ": make sure class name exists", classNotFoundException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
        }
        catch(ClassCastException classCastException0) {
            throw new M3("Unable to instantiate fragment " + s + ": make sure class is a valid subclass of Fragment", classCastException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
        }
    }
}

