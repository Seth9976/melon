package e1;

import i1.g;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import me.i;
import me.j;
import y8.s;

public final class r {
    public final s a;
    public final CoroutineScope b;
    public static final q c;

    static {
        r.c = new q(CoroutineExceptionHandler.Key);  // 初始化器: Lme/a;-><init>(Lme/h;)V
    }

    public r(s s0) {
        this.a = s0;
        i i0 = r.c.plus(g.a).plus(j.a);
        j.a.get(Job.Key);
        this.b = CoroutineScopeKt.CoroutineScope(i0.plus(SupervisorKt.SupervisorJob(null)));
    }
}

