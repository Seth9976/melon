package b5;

import android.content.Context;
import b.l;
import f5.a;
import java.util.LinkedHashSet;
import je.p;
import kotlin.jvm.internal.q;

public abstract class e {
    public final a a;
    public final Context b;
    public final Object c;
    public final LinkedHashSet d;
    public Object e;

    public e(Context context0, a a0) {
        this.a = a0;
        Context context1 = context0.getApplicationContext();
        q.f(context1, "context.applicationContext");
        this.b = context1;
        this.c = new Object();
        this.d = new LinkedHashSet();
    }

    public abstract Object a();

    public final void b(Object object0) {
        synchronized(this.c) {
            if(this.e != null && this.e.equals(object0)) {
                return;
            }
            this.e = object0;
            l l0 = new l(1, p.P0(this.d), this);
            this.a.d.execute(l0);
        }
    }

    public abstract void c();

    public abstract void d();
}

