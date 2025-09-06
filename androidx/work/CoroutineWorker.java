package androidx.work;

import U4.e;
import U4.f;
import U4.g;
import U4.v;
import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.JobKt__JobKt;
import org.jetbrains.annotations.NotNull;
import w1.m;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/work/CoroutineWorker;", "LU4/v;", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "U4/e", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public abstract class CoroutineWorker extends v {
    public final WorkerParameters e;
    public final e f;

    public CoroutineWorker(@NotNull Context context0, @NotNull WorkerParameters workerParameters0) {
        q.g(context0, "appContext");
        q.g(workerParameters0, "params");
        super(context0, workerParameters0);
        this.e = workerParameters0;
        this.f = e.b;
    }

    @Override  // U4.v
    public final m a() {
        return U4.q.a(this.d().plus(JobKt__JobKt.Job$default(null, 1, null)), new f(this, null));
    }

    @Override  // U4.v
    public final m b() {
        CoroutineDispatcher coroutineDispatcher0 = q.b(this.d(), e.b) ? this.e.e : this.d();
        q.f(coroutineDispatcher0, "if (coroutineContext != …rkerContext\n            }");
        return U4.q.a(coroutineDispatcher0.plus(JobKt__JobKt.Job$default(null, 1, null)), new g(this, null));
    }

    public abstract Object c(Continuation arg1);

    public CoroutineDispatcher d() {
        return this.f;
    }
}

