package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005B\u0017\b\u0016\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000BR\u0018\u0010\f\u001A\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000F\u001A\u0004\u0018\u00010\u000E8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000F\u0010\u0010R\u0013\u0010\u0003\u001A\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/facebook/internal/LockOnGetVariable;", "T", "", "value", "<init>", "(Ljava/lang/Object;)V", "Ljava/util/concurrent/Callable;", "callable", "(Ljava/util/concurrent/Callable;)V", "Lie/H;", "waitOnInit", "()V", "storedValue", "Ljava/lang/Object;", "Ljava/util/concurrent/CountDownLatch;", "initLatch", "Ljava/util/concurrent/CountDownLatch;", "getValue", "()Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class LockOnGetVariable {
    @Nullable
    private CountDownLatch initLatch;
    @Nullable
    private Object storedValue;

    public LockOnGetVariable(Object object0) {
        this.storedValue = object0;
    }

    public LockOnGetVariable(@NotNull Callable callable0) {
        q.g(callable0, "callable");
        super();
        this.initLatch = new CountDownLatch(1);
        FacebookSdk.getExecutor().execute(new FutureTask(new c(this, callable0)));
    }

    private static final Void _init_$lambda$0(LockOnGetVariable lockOnGetVariable0, Callable callable0) {
        CountDownLatch countDownLatch0;
        q.g(lockOnGetVariable0, "this$0");
        q.g(callable0, "$callable");
        try {
            lockOnGetVariable0.storedValue = callable0.call();
            countDownLatch0 = lockOnGetVariable0.initLatch;
        }
        catch(Throwable throwable0) {
            CountDownLatch countDownLatch1 = lockOnGetVariable0.initLatch;
            if(countDownLatch1 != null) {
                countDownLatch1.countDown();
            }
            throw throwable0;
        }
        if(countDownLatch0 != null) {
            countDownLatch0.countDown();
        }
        return null;
    }

    @Nullable
    public final Object getValue() {
        this.waitOnInit();
        return this.storedValue;
    }

    private final void waitOnInit() {
        CountDownLatch countDownLatch0 = this.initLatch;
        if(countDownLatch0 == null) {
            return;
        }
        try {
            countDownLatch0.await();
        }
        catch(InterruptedException unused_ex) {
        }
    }
}

