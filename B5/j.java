package b5;

import android.content.Context;
import kotlin.jvm.internal.q;

public final class j {
    public final Context a;
    public final e b;
    public final a c;
    public final e d;
    public final e e;

    public j(Context context0, f5.a a0) {
        Context context1 = context0.getApplicationContext();
        q.f(context1, "context.applicationContext");
        a a1 = new a(context1, a0, 0);
        Context context2 = context0.getApplicationContext();
        q.f(context2, "context.applicationContext");
        a a2 = new a(context2, a0, 1);
        Context context3 = context0.getApplicationContext();
        q.f(context3, "context.applicationContext");
        g g0 = new g(context3, a0);
        Context context4 = context0.getApplicationContext();
        q.f(context4, "context.applicationContext");
        a a3 = new a(context4, a0, 2);
        super();
        this.a = context0;
        this.b = a1;
        this.c = a2;
        this.d = g0;
        this.e = a3;
    }
}

