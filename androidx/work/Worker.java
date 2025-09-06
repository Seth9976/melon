package androidx.work;

import B9.g;
import U4.G;
import U4.t;
import U4.v;
import android.content.Context;
import e.k;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import w1.m;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/work/Worker;", "LU4/v;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public abstract class Worker extends v {
    public Worker(@NotNull Context context0, @NotNull WorkerParameters workerParameters0) {
        q.g(context0, "context");
        q.g(workerParameters0, "workerParams");
        super(context0, workerParameters0);
    }

    @Override  // U4.v
    public final m a() {
        ExecutorService executorService0 = this.b.d;
        q.f(executorService0, "backgroundExecutor");
        return k.q(new g(executorService0, new G(this, 0)));
    }

    @Override  // U4.v
    public final m b() {
        ExecutorService executorService0 = this.b.d;
        q.f(executorService0, "backgroundExecutor");
        return k.q(new g(executorService0, new G(this, 1)));
    }

    public abstract t c();
}

