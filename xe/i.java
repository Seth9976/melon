package Xe;

import java.util.List;
import java.util.ServiceLoader;
import je.p;
import kotlin.jvm.internal.q;
import we.a;

public final class i implements a {
    public static final i a;

    static {
        i.a = new i();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // we.a
    public final Object invoke() {
        ServiceLoader serviceLoader0 = ServiceLoader.load(k.class, k.class.getClassLoader());
        q.f(serviceLoader0, "load(...)");
        List list0 = p.P0(serviceLoader0);
        if(list0.isEmpty()) {
            throw new IllegalStateException("No MetadataExtensions instances found in the classpath. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
        }
        return list0;
    }
}

