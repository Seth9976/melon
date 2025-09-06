package Qe;

import Me.X;
import Me.a0;
import Me.b0;
import Me.c0;
import Me.g0;
import kotlin.jvm.internal.q;

public final class b extends g0 {
    public static final b c;

    static {
        b.c = new b("protected_and_package", true);  // 初始化器: LMe/g0;-><init>(Ljava/lang/String;Z)V
    }

    @Override  // Me.g0
    public final Integer a(g0 g00) {
        q.g(g00, "visibility");
        if(this.equals(g00)) {
            return 0;
        }
        if(g00 == X.c) {
            return null;
        }
        return g00 == a0.c || g00 == b0.c ? 1 : -1;
    }

    @Override  // Me.g0
    public final String b() {
        return "protected/*protected and package*/";
    }

    @Override  // Me.g0
    public final g0 c() {
        return c0.c;
    }
}

