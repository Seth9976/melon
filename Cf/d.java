package cf;

import Gf.e;
import Gf.f;
import Gf.m;
import Me.H;
import Nc.W0;
import Se.x;
import com.google.firebase.messaging.u;
import ie.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import je.w;
import kotlin.jvm.internal.q;
import qf.c;
import we.k;

public final class d implements H {
    public final u a;
    public final e b;

    public d(a a0) {
        g g0 = new g(null);
        this.a = new u(a0, b.b, g0);
        ((m)a0.a).getClass();
        ConcurrentHashMap concurrentHashMap0 = new ConcurrentHashMap(3, 1.0f, 2);
        f f0 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.b = new e(((m)a0.a), concurrentHashMap0, f0, 0);
    }

    @Override  // Me.H
    public final void a(c c0, ArrayList arrayList0) {
        q.g(c0, "fqName");
        arrayList0.add(this.c(c0));
    }

    @Override  // Me.H
    public final boolean b(c c0) {
        q.g(c0, "fqName");
        ((a)this.a.a).b.getClass();
        return false;
    }

    public final df.q c(c c0) {
        ((a)this.a.a).b.getClass();
        q.g(c0, "fqName");
        W0 w00 = new W0(19, this, new x(c0));
        this.b.getClass();
        Gf.g g0 = new Gf.g(c0, w00);
        Object object0 = this.b.invoke(g0);
        if(object0 != null) {
            return (df.q)object0;
        }
        e.d(3);
        throw null;
    }

    @Override  // Me.H
    public final Collection l(c c0, k k0) {
        q.g(c0, "fqName");
        List list0 = (List)this.c(c0).k.invoke();
        return list0 == null ? w.a : list0;
    }

    @Override
    public final String toString() {
        return "LazyJavaPackageFragmentProvider of module " + ((a)this.a.a).o;
    }
}

