package Y6;

import A7.c;
import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import java.lang.reflect.InvocationTargetException;
import y7.b;

public final class e implements b {
    public final int a;
    public final Object b;

    public e(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // y7.b
    public final Object get() {
        switch(this.a) {
            case 0: {
                String s = (String)this.b;
                try {
                    Class class0 = Class.forName(s);
                    if(!ComponentRegistrar.class.isAssignableFrom(class0)) {
                        throw new n("Class " + s + " is not an instance of com.google.firebase.components.ComponentRegistrar");  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
                    }
                    return (ComponentRegistrar)class0.getDeclaredConstructor(null).newInstance(null);
                }
                catch(ClassNotFoundException unused_ex) {
                }
                catch(IllegalAccessException illegalAccessException0) {
                    throw new n("Could not instantiate " + s + ".", illegalAccessException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
                }
                catch(InstantiationException instantiationException0) {
                    throw new n("Could not instantiate " + s + ".", instantiationException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
                }
                catch(NoSuchMethodException noSuchMethodException0) {
                    throw new n("Could not instantiate " + s, noSuchMethodException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
                }
                catch(InvocationTargetException invocationTargetException0) {
                    throw new n("Could not instantiate " + s, invocationTargetException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
                }
                Log.w("ComponentDiscovery", "Class " + s + " is not an found.");
                return null;
            }
            case 1: {
                return (ComponentRegistrar)this.b;
            }
            default: {
                return new c(((com.google.firebase.e)this.b));
            }
        }
    }
}

