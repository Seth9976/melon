package D2;

import F2.l;
import M2.g;
import android.content.Context;
import de.c;
import e.k;
import e3.h;
import java.io.File;
import je.w;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import l2.M;
import l2.Q;
import l2.e;

public final class w0 implements g {
    public static final w0 a;

    static {
        w0.a = new w0();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // M2.g
    public final File a(Context context0, String s) {
        return c.p(context0, s);
    }

    @Override  // M2.g
    public final Object b(Context context0, String s) {
        v0 v00 = new v0(context0, s, 0);
        CoroutineScope coroutineScope0 = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        q.g(coroutineScope0, "scope");
        Q q0 = new Q(l.a, v00);
        h h0 = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        return new M(q0, k.z(new e(w.a, null)), h0, coroutineScope0);
    }
}

