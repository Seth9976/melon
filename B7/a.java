package b7;

import I7.g;
import Y6.q;
import android.util.Log;
import androidx.media3.session.a0;
import h7.l0;
import java.util.concurrent.atomic.AtomicReference;

public final class a {
    public final q a;
    public final AtomicReference b;
    public static final c c;

    static {
        a.c = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public a(q q0) {
        this.b = new AtomicReference(null);
        this.a = q0;
        q0.a(new a0(this, 10));
    }

    public final c a(String s) {
        a a0 = (a)this.b.get();
        return a0 == null ? a.c : a0.a(s);
    }

    public final boolean b() {
        a a0 = (a)this.b.get();
        return a0 != null && a0.b();
    }

    public final boolean c(String s) {
        a a0 = (a)this.b.get();
        return a0 != null && a0.c(s);
    }

    public final void d(String s, long v, l0 l00) {
        if(Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "Deferring native open session: " + s, null);
        }
        g g0 = new g(s, v, l00);
        this.a.a(g0);
    }
}

