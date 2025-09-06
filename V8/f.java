package v8;

import androidx.lifecycle.f0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.i;

public abstract class f extends a {
    public static final int $stable = 8;
    private long cachedTime;
    private final long emptyTime;
    private long expiredTime;
    @Nullable
    private Job syncJob;

    public f() {
        this.emptyTime = -1L;
        this.cachedTime = -1L;
        this.expiredTime = P4.a.a * 5L;
    }

    public static final long access$getEmptyTime$p(f f0) {
        return f0.emptyTime;
    }

    public static final void access$setCachedTime$p(f f0, long v) {
        f0.cachedTime = v;
    }

    public final void changeDataSet() {
        this.cachedTime = this.emptyTime;
        this.request(i.b);
    }

    public final void clearCache() {
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getIO(), null, new c(this, null), 2, null);
    }

    @Nullable
    public Object clearSubCache(@NotNull Continuation continuation0) {
        return f.clearSubCache$suspendImpl(this, continuation0);
    }

    public static Object clearSubCache$suspendImpl(f f0, Continuation continuation0) {
        return H.a;
    }

    public abstract Object fetchRequest(i arg1, Continuation arg2);

    public abstract String getCacheKey();

    public final long getExpiredTime() {
        return this.expiredTime;
    }

    @Nullable
    public final Job getSyncJob() {
        return this.syncJob;
    }

    public final boolean isExpired() {
        return Long.compare(this.cachedTime, this.emptyTime) == 0 ? true : System.currentTimeMillis() - this.cachedTime > this.expiredTime;
    }

    public void request(@Nullable i i0) {
        Job job0 = this.syncJob;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        this.syncJob = BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getMain(), null, new e(this, i0, null), 2, null);
    }

    public final void setExpiredTime(long v) {
        this.expiredTime = v;
    }

    public final void setSyncJob(@Nullable Job job0) {
        this.syncJob = job0;
    }
}

