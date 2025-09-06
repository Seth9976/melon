package k2;

import De.w;
import android.content.Context;
import e3.h;
import i.n.i.b.a.s.e.Ga;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import l2.M;
import l2.e;
import m2.a;
import n2.f;
import okio.FileSystem;
import we.k;
import ze.b;

public final class c implements b {
    public final String a;
    public final Ga b;
    public final a c;
    public final k d;
    public final CoroutineScope e;
    public final Object f;
    public volatile M g;

    public c(String s, Ga ga0, a a0, k k0, CoroutineScope coroutineScope0) {
        this.a = s;
        this.b = ga0;
        this.c = a0;
        this.d = k0;
        this.e = coroutineScope0;
        this.f = new Object();
    }

    @Override  // ze.b
    public final Object getValue(Object object0, w w0) {
        q.g(((Context)object0), "thisRef");
        q.g(w0, "property");
        M m0 = this.g;
        if(m0 == null) {
            synchronized(this.f) {
                if(this.g == null) {
                    Context context0 = ((Context)object0).getApplicationContext();
                    k2.b b0 = new k2.b(context0, this);
                    f f0 = new f(FileSystem.SYSTEM, this.b, b0);
                    a a0 = this.c;
                    q.f(context0, "applicationContext");
                    List list0 = (List)this.d.invoke(context0);
                    CoroutineScope coroutineScope0 = this.e;
                    q.g(list0, "migrations");
                    if(a0 == null) {
                        a0 = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
                    }
                    this.g = new M(f0, e.k.z(new e(list0, null)), a0, coroutineScope0);
                }
                M m1 = this.g;
                q.d(m1);
                return m1;
            }
        }
        return m0;
    }
}

