package T4;

import I7.c;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public abstract class m {
    public static final n a;

    static {
        c c0;
        InvocationHandler invocationHandler0;
        try {
            invocationHandler0 = Q1.c.v();
        }
        catch(IllegalAccessException | InvocationTargetException | NoSuchMethodException exception0) {
            throw new RuntimeException(exception0);
        }
        catch(ClassNotFoundException unused_ex) {
            c0 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
            m.a = c0;
            return;
        }
        c0 = new c(((WebViewProviderFactoryBoundaryInterface)BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebViewProviderFactoryBoundaryInterface.class, invocationHandler0)), 25);
        m.a = c0;
    }
}

