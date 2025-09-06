package com.iloen.melon.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.sync.Mutex;
import me.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001A\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001A\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001A\u00020\u000BHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000F\u001A\u00020\u000EHÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u001A\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001A\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/utils/ReentrantMutexContextKey;", "Lme/h;", "Lcom/iloen/melon/utils/ReentrantMutexContextElement;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "<init>", "(Lkotlinx/coroutines/sync/Mutex;)V", "component1", "()Lkotlinx/coroutines/sync/Mutex;", "copy", "(Lkotlinx/coroutines/sync/Mutex;)Lcom/iloen/melon/utils/ReentrantMutexContextKey;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lkotlinx/coroutines/sync/Mutex;", "getMutex", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ReentrantMutexContextKey implements h {
    public static final int $stable = 8;
    public final Mutex a;

    public ReentrantMutexContextKey(@NotNull Mutex mutex0) {
        q.g(mutex0, "mutex");
        super();
        this.a = mutex0;
    }

    @NotNull
    public final Mutex component1() {
        return this.a;
    }

    @NotNull
    public final ReentrantMutexContextKey copy(@NotNull Mutex mutex0) {
        q.g(mutex0, "mutex");
        return new ReentrantMutexContextKey(mutex0);
    }

    public static ReentrantMutexContextKey copy$default(ReentrantMutexContextKey reentrantMutexContextKey0, Mutex mutex0, int v, Object object0) {
        if((v & 1) != 0) {
            mutex0 = reentrantMutexContextKey0.a;
        }
        return reentrantMutexContextKey0.copy(mutex0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof ReentrantMutexContextKey ? q.b(this.a, ((ReentrantMutexContextKey)object0).a) : false;
    }

    @NotNull
    public final Mutex getMutex() {
        return this.a;
    }

    @Override
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "ReentrantMutexContextKey(mutex=" + this.a + ")";
    }
}

