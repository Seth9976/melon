package androidx.compose.runtime;

import kotlin.jvm.internal.q;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import me.i;
import me.j;

public final class y0 implements w0, CoroutineScope {
    public final i a;
    public final y0 b;
    public volatile i c;
    public static final f d;

    static {
        y0.d = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public y0(i i0) {
        this.a = i0;
        this.b = this;
    }

    public final void a() {
        synchronized(this.b) {
            i i0 = this.c;
            if(i0 == null) {
                this.c = y0.d;
            }
            else {
                JobKt.cancel(i0, new K(0));
            }
        }
    }

    @Override  // androidx.compose.runtime.w0
    public final void c() {
    }

    @Override  // androidx.compose.runtime.w0
    public final void d() {
        this.a();
    }

    @Override  // androidx.compose.runtime.w0
    public final void e() {
        this.a();
    }

    @Override  // kotlinx.coroutines.CoroutineScope
    public final i getCoroutineContext() {
        i i1;
        i i0 = this.c;
        if(i0 == null || i0 == y0.d) {
            synchronized(this.b) {
                i1 = this.c;
                if(i1 == null) {
                    CompletableJob completableJob0 = JobKt.Job(((Job)this.a.get(Job.Key)));
                    i1 = this.a.plus(completableJob0).plus(j.a);
                }
                else if(i1 == y0.d) {
                    CompletableJob completableJob1 = JobKt.Job(((Job)this.a.get(Job.Key)));
                    completableJob1.cancel(new K(0));
                    i1 = this.a.plus(completableJob1).plus(j.a);
                }
                this.c = i1;
            }
            i0 = i1;
        }
        q.d(i0);
        return i0;
    }
}

