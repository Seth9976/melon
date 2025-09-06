package vc;

import B3.n;
import B3.v;
import H7.a;
import H7.b;
import H7.d;
import H7.m;
import I7.g;
import I7.j;
import Z6.h;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.e;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import java.util.HashMap;
import kotlin.jvm.internal.q;

public final class c {
    public static final c a;
    public static final LogU b;
    public static final x9.c c;

    static {
        c.a = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        c.b = Companion.create$default(LogU.Companion, "RemoteConfig", false, null, 6, null);
        c.c = new x9.c(14);
    }

    public static void a() {
        c.c.getClass();
        d d0 = ((m)e.c().b(m.class)).a();
        q.f(d0, "getInstance(...)");
        v v0 = new v();  // 初始化器: Ljava/lang/Object;-><init>()V
        v0.a = 0L;
        v v1 = new v();  // 初始化器: Ljava/lang/Object;-><init>()V
        v1.a = v0.a;
        a a0 = new a(0, d0, v1);
        Tasks.call(d0.b, a0);
        long v2 = d0.e.h.a.getLong("minimum_fetch_interval_in_seconds", j.j);
        HashMap hashMap0 = new HashMap(d0.e.i);
        hashMap0.put("X-Firebase-RC-Fetch-Type", "BASE/1");
        Task task0 = d0.e.f.b();
        g g0 = new g(d0.e, v2, hashMap0);
        Task task1 = task0.continueWithTask(d0.e.c, g0);
        n n0 = new n(14);
        Task task2 = task1.onSuccessTask(h.a, n0);
        b b0 = new b(d0);
        task2.onSuccessTask(d0.b, b0).addOnCompleteListener(new vc.a(c.c, d0));
    }
}

