package T2;

import H0.b;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.q;

public final class d {
    public final c a;
    public final LinkedHashMap b;
    public final LinkedHashSet c;
    public volatile boolean d;

    public d() {
        this.a = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.b = new LinkedHashMap();
        this.c = new LinkedHashSet();
    }

    public final void a(AutoCloseable autoCloseable0) {
        q.g(autoCloseable0, "closeable");
        if(this.d) {
            d.b(autoCloseable0);
            return;
        }
        synchronized(this.a) {
            this.c.add(autoCloseable0);
        }
    }

    public static void b(AutoCloseable autoCloseable0) {
        if(autoCloseable0 != null) {
            try {
                b.u(autoCloseable0);
            }
            catch(Exception exception0) {
                throw new RuntimeException(exception0);
            }
        }
    }
}

