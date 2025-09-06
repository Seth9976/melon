package a7;

import R6.c;
import Y6.q;
import java.util.ArrayList;
import v2.h;

public final class b {
    public final Object a;
    public volatile Object b;
    public volatile Object c;

    public b(q q0) {
        d7.b b0 = new d7.b();  // 初始化器: Ljava/lang/Object;-><init>()V
        c c0 = new c(22);
        super();
        this.c = b0;
        this.a = new ArrayList();
        this.b = c0;
        q0.a(new a(this));
    }

    public b(h h0) {
        this.a = h0;
    }
}

