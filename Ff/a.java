package Ff;

import De.w;
import Gf.i;
import Gf.m;
import Gf.p;
import Ne.b;
import Ne.h;
import d5.f;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.z;
import qf.c;

public class a implements h {
    public final i a;
    public static final w[] b;

    static {
        z z0 = new z(a.class, "annotations", "getAnnotations()Ljava/util/List;", 0);
        a.b = new w[]{I.a.g(z0)};
    }

    public a(p p0, we.a a0) {
        q.g(p0, "storageManager");
        super();
        this.a = new i(((m)p0), a0);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
    }

    @Override  // Ne.h
    public final boolean c(c c0) {
        return f.I(this, c0);
    }

    @Override  // Ne.h
    public final b e0(c c0) {
        return f.w(this, c0);
    }

    @Override  // Ne.h
    public boolean isEmpty() {
        return ((List)P4.a.r(this.a, a.b[0])).isEmpty();
    }

    @Override
    public final Iterator iterator() {
        return ((List)P4.a.r(this.a, a.b[0])).iterator();
    }
}

