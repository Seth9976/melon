package com.facebook.bolts;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001B\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000B\u0010\nJ\u000F\u0010\r\u001A\u00020\bH\u0000¢\u0006\u0004\b\f\u0010\nR\u0018\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0005\u0010\u000ER\u0016\u0010\u0010\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/facebook/bolts/CancellationTokenRegistration;", "Ljava/io/Closeable;", "Lcom/facebook/bolts/CancellationTokenSource;", "tokenSource", "Ljava/lang/Runnable;", "action", "<init>", "(Lcom/facebook/bolts/CancellationTokenSource;Ljava/lang/Runnable;)V", "Lie/H;", "throwIfClosed", "()V", "close", "runAction$facebook_bolts_release", "runAction", "Ljava/lang/Runnable;", "", "closed", "Z", "Lcom/facebook/bolts/CancellationTokenSource;", "facebook-bolts_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CancellationTokenRegistration implements Closeable {
    @Nullable
    private Runnable action;
    private boolean closed;
    @Nullable
    private CancellationTokenSource tokenSource;

    public CancellationTokenRegistration(@NotNull CancellationTokenSource cancellationTokenSource0, @Nullable Runnable runnable0) {
        q.g(cancellationTokenSource0, "tokenSource");
        super();
        this.action = runnable0;
        this.tokenSource = cancellationTokenSource0;
    }

    @Override
    public void close() {
        __monitor_enter(this);
        try {
            if(!this.closed) {
                this.closed = true;
                CancellationTokenSource cancellationTokenSource0 = this.tokenSource;
                if(cancellationTokenSource0 != null) {
                    cancellationTokenSource0.unregister$facebook_bolts_release(this);
                }
                this.tokenSource = null;
                this.action = null;
                goto label_12;
            }
            goto label_14;
        }
        catch(Throwable throwable0) {
        }
        __monitor_exit(this);
        throw throwable0;
    label_12:
        __monitor_exit(this);
        return;
    label_14:
        __monitor_exit(this);
    }

    public final void runAction$facebook_bolts_release() {
        synchronized(this) {
            this.throwIfClosed();
            Runnable runnable0 = this.action;
            if(runnable0 != null) {
                runnable0.run();
            }
            this.close();
        }
    }

    private final void throwIfClosed() {
        if(this.closed) {
            throw new IllegalStateException("Object already closed");
        }
    }
}

