package Re;

import Df.l;
import Se.r;
import gf.c;
import java.util.ArrayList;
import kotlin.jvm.internal.q;

public final class e implements l {
    public static final e b;
    public static final e c;

    static {
        e.b = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e.c = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // Df.l
    public void a(Me.e e0, ArrayList arrayList0) {
        throw new IllegalStateException("Incomplete hierarchy for class " + e0.getName() + ", unresolved classes " + arrayList0);
    }

    public g b(c c0) {
        q.g(c0, "javaElement");
        return new g(((r)c0));
    }

    @Override  // Df.l
    public void c(Me.c c0) {
        q.g(c0, "descriptor");
        throw new IllegalStateException("Cannot infer visibility for " + c0);
    }
}

