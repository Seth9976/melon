package com.facebook.bolts;

import com.facebook.appevents.c;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\t\u0010\nJ\u001D\u0010\u000E\u001A\u00020\b2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u000BH\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b\u0010\u0010\u0003J\u000F\u0010\u0011\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b\u0011\u0010\u0003J\r\u0010\u0012\u001A\u00020\b\u00A2\u0006\u0004\b\u0012\u0010\u0003J\u0015\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\t\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0003J\u0019\u0010\u0019\u001A\u00020\f2\b\u0010\u0016\u001A\u0004\u0018\u00010\u0015H\u0000\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u001B\u001A\u00020\bH\u0000\u00A2\u0006\u0004\b\u001A\u0010\u0003J\u0017\u0010\u001F\u001A\u00020\b2\u0006\u0010\u001C\u001A\u00020\fH\u0000\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010!\u001A\u00020 H\u0016\u00A2\u0006\u0004\b!\u0010\"R\u0014\u0010$\u001A\u00020#8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b$\u0010%R\u001A\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0&8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\r\u0010\'R\u0014\u0010)\u001A\u00020(8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b)\u0010*R\u001C\u0010,\u001A\b\u0012\u0002\b\u0003\u0018\u00010+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001A\u00020.8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001A\u00020.8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b1\u00100R\u0011\u00102\u001A\u00020.8F\u00A2\u0006\u0006\u001A\u0004\b2\u00103R\u0011\u00107\u001A\u0002048F\u00A2\u0006\u0006\u001A\u0004\b5\u00106\u00A8\u00068"}, d2 = {"Lcom/facebook/bolts/CancellationTokenSource;", "Ljava/io/Closeable;", "<init>", "()V", "", "delay", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "Lie/H;", "cancelAfter", "(JLjava/util/concurrent/TimeUnit;)V", "", "Lcom/facebook/bolts/CancellationTokenRegistration;", "registrations", "notifyListeners", "(Ljava/util/List;)V", "throwIfClosed", "cancelScheduledCancellation", "cancel", "(J)V", "close", "Ljava/lang/Runnable;", "action", "register$facebook_bolts_release", "(Ljava/lang/Runnable;)Lcom/facebook/bolts/CancellationTokenRegistration;", "register", "throwIfCancellationRequested$facebook_bolts_release", "throwIfCancellationRequested", "registration", "unregister$facebook_bolts_release", "(Lcom/facebook/bolts/CancellationTokenRegistration;)V", "unregister", "", "toString", "()Ljava/lang/String;", "", "lock", "Ljava/lang/Object;", "", "Ljava/util/List;", "Ljava/util/concurrent/ScheduledExecutorService;", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "Ljava/util/concurrent/ScheduledFuture;", "scheduledCancellation", "Ljava/util/concurrent/ScheduledFuture;", "", "cancellationRequested", "Z", "closed", "isCancellationRequested", "()Z", "Lcom/facebook/bolts/CancellationToken;", "getToken", "()Lcom/facebook/bolts/CancellationToken;", "token", "facebook-bolts_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CancellationTokenSource implements Closeable {
    private boolean cancellationRequested;
    private boolean closed;
    @NotNull
    private final ScheduledExecutorService executor;
    @NotNull
    private final Object lock;
    @NotNull
    private final List registrations;
    @Nullable
    private ScheduledFuture scheduledCancellation;

    public CancellationTokenSource() {
        this.lock = new Object();
        this.registrations = new ArrayList();
        this.executor = BoltsExecutors.Companion.scheduled$facebook_bolts_release();
    }

    public static void c(CancellationTokenSource cancellationTokenSource0) {
        CancellationTokenSource.cancelAfter$lambda$6$lambda$5(cancellationTokenSource0);
    }

    public final void cancel() {
        ArrayList arrayList0;
        synchronized(this.lock) {
            this.throwIfClosed();
            if(this.cancellationRequested) {
                return;
            }
            this.cancelScheduledCancellation();
            this.cancellationRequested = true;
            arrayList0 = new ArrayList(this.registrations);
        }
        this.notifyListeners(arrayList0);
    }

    private final void cancelAfter(long v, TimeUnit timeUnit0) {
        int v1 = Long.compare(v, -1L);
        if(v1 < 0) {
            throw new IllegalArgumentException("Delay must be >= -1");
        }
        if(v == 0L) {
            this.cancel();
            return;
        }
        synchronized(this.lock) {
            if(this.cancellationRequested) {
                return;
            }
            this.cancelScheduledCancellation();
            if(v1 != 0) {
                c c0 = new c(this, 3);
                this.scheduledCancellation = this.executor.schedule(c0, v, timeUnit0);
            }
        }
    }

    public final void cancelAfter(long v) {
        this.cancelAfter(v, TimeUnit.MILLISECONDS);
    }

    private static final void cancelAfter$lambda$6$lambda$5(CancellationTokenSource cancellationTokenSource0) {
        q.g(cancellationTokenSource0, "this$0");
        synchronized(cancellationTokenSource0.lock) {
            cancellationTokenSource0.scheduledCancellation = null;
        }
        cancellationTokenSource0.cancel();
    }

    private final void cancelScheduledCancellation() {
        ScheduledFuture scheduledFuture0 = this.scheduledCancellation;
        if(scheduledFuture0 == null) {
            return;
        }
        scheduledFuture0.cancel(true);
        this.scheduledCancellation = null;
    }

    @Override
    public void close() {
        Object object0 = this.lock;
        __monitor_enter(object0);
        try {
            if(!this.closed) {
                this.cancelScheduledCancellation();
                for(Object object1: this.registrations) {
                    ((CancellationTokenRegistration)object1).close();
                }
                this.registrations.clear();
                this.closed = true;
                goto label_15;
            }
            goto label_17;
        }
        catch(Throwable throwable0) {
        }
        __monitor_exit(object0);
        throw throwable0;
    label_15:
        __monitor_exit(object0);
        return;
    label_17:
        __monitor_exit(object0);
    }

    @NotNull
    public final CancellationToken getToken() {
        synchronized(this.lock) {
            this.throwIfClosed();
            return new CancellationToken(this);
        }
    }

    public final boolean isCancellationRequested() {
        synchronized(this.lock) {
            this.throwIfClosed();
            return this.cancellationRequested;
        }
    }

    private final void notifyListeners(List list0) {
        for(Object object0: list0) {
            ((CancellationTokenRegistration)object0).runAction$facebook_bolts_release();
        }
    }

    @NotNull
    public final CancellationTokenRegistration register$facebook_bolts_release(@Nullable Runnable runnable0) {
        synchronized(this.lock) {
            this.throwIfClosed();
            CancellationTokenRegistration cancellationTokenRegistration0 = new CancellationTokenRegistration(this, runnable0);
            if(this.cancellationRequested) {
                cancellationTokenRegistration0.runAction$facebook_bolts_release();
            }
            else {
                this.registrations.add(cancellationTokenRegistration0);
            }
            return cancellationTokenRegistration0;
        }
    }

    public final void throwIfCancellationRequested$facebook_bolts_release() {
        synchronized(this.lock) {
            this.throwIfClosed();
            if(!this.cancellationRequested) {
                return;
            }
        }
        throw new CancellationException();
    }

    private final void throwIfClosed() {
        if(this.closed) {
            throw new IllegalStateException("Object already closed");
        }
    }

    // 去混淆评级： 低(20)
    @Override
    @NotNull
    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", Arrays.copyOf(new Object[]{"com.facebook.bolts.CancellationTokenSource", Integer.toHexString(this.hashCode()), Boolean.toString(this.isCancellationRequested())}, 3));
    }

    public final void unregister$facebook_bolts_release(@NotNull CancellationTokenRegistration cancellationTokenRegistration0) {
        q.g(cancellationTokenRegistration0, "registration");
        synchronized(this.lock) {
            this.throwIfClosed();
            this.registrations.remove(cancellationTokenRegistration0);
        }
    }
}

