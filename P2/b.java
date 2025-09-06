package p2;

import De.w;
import H.o;
import android.content.Context;
import e3.h;
import gd.k4;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import l2.M;
import l2.Q;
import m2.a;
import q2.d;
import q2.e;
import we.k;

public final class b implements ze.b {
    public final String a;
    public final a b;
    public final k c;
    public final CoroutineScope d;
    public final Object e;
    public volatile d f;

    public b(String s, a a0, k k0, CoroutineScope coroutineScope0) {
        q.g(s, "name");
        q.g(k0, "produceMigrations");
        q.g(coroutineScope0, "scope");
        super();
        this.a = s;
        this.b = a0;
        this.c = k0;
        this.d = coroutineScope0;
        this.e = new Object();
    }

    @Override  // ze.b
    public final Object getValue(Object object0, w w0) {
        q.g(((Context)object0), "thisRef");
        q.g(w0, "property");
        d d0 = this.f;
        if(d0 == null) {
            synchronized(this.e) {
                if(this.f == null) {
                    Context context0 = ((Context)object0).getApplicationContext();
                    a a0 = this.b;
                    q.f(context0, "applicationContext");
                    List list0 = (List)this.c.invoke(context0);
                    CoroutineScope coroutineScope0 = this.d;
                    k4 k40 = new k4(11, context0, this);
                    q.g(list0, "migrations");
                    q.g(coroutineScope0, "scope");
                    o o0 = new o(2, k40);
                    Q q0 = new Q(e.a, o0);
                    if(a0 == null) {
                        a0 = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
                    }
                    this.f = new d(new d(new M(q0, e.k.z(new l2.e(list0, null)), a0, coroutineScope0)));
                }
                d d1 = this.f;
                q.d(d1);
                return d1;
            }
        }
        return d0;
    }
}

