package co.ab180.airbridge.internal.x;

import kotlin.Metadata;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import we.n;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J6\u0010\r\u001A\u00020\f2\"\u0010\u000B\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\r\u001A\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000FJ\r\u0010\u0010\u001A\u00020\t¢\u0006\u0004\b\u0010\u0010\u000FR\u0018\u0010\u0012\u001A\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0016\u001A\u00020\u00138F¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lco/ab180/airbridge/internal/x/b;", "Lco/ab180/airbridge/internal/x/a;", "", "tag", "<init>", "(Ljava/lang/String;)V", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lie/H;", "", "block", "Lkotlinx/coroutines/Job;", "a", "(Lwe/n;)Lkotlinx/coroutines/Job;", "()V", "c", "Lkotlinx/coroutines/Job;", "_job", "", "d", "()Z", "isJobActive", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class b extends a {
    private Job c;

    public b(@NotNull String s) {
        super(s);
    }

    @Override  // co.ab180.airbridge.internal.x.a
    @NotNull
    public Job a(@NotNull n n0) {
        if(this.d()) {
            return this.c;
        }
        Job job0 = super.a(n0);
        this.c = job0;
        return job0;
    }

    @Override  // co.ab180.airbridge.internal.x.a
    public void a() {
        this.c();
        super.a();
    }

    public final void c() {
        Job job0 = this.c;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        this.c = null;
    }

    public final boolean d() {
        return this.c != null && this.c.isActive();
    }
}

