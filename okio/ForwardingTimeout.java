package okio;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001A\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001F\u0010\b\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\b\u0010\u000BJ\u000F\u0010\f\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0011\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\rJ\u0017\u0010\u0011\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u0001H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\u0001H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000F\u0010\u0017\u001A\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u0019\u001A\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001C\u001A\u00020\u00162\u0006\u0010\u001B\u001A\u00020\u001AH\u0016¢\u0006\u0004\b\u001C\u0010\u001DJ\u0017\u0010 \u001A\u00020\u00162\u0006\u0010\u001F\u001A\u00020\u001EH\u0016¢\u0006\u0004\b \u0010!R\"\u0010\u0002\u001A\u00020\u00018G@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0002\u0010\"\u001A\u0004\b\u0002\u0010\u0014\"\u0004\b\u0005\u0010\u0004¨\u0006#"}, d2 = {"Lokio/ForwardingTimeout;", "Lokio/Timeout;", "delegate", "<init>", "(Lokio/Timeout;)V", "setDelegate", "(Lokio/Timeout;)Lokio/ForwardingTimeout;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;", "timeoutNanos", "()J", "", "hasDeadline", "()Z", "deadlineNanoTime", "(J)Lokio/Timeout;", "clearTimeout", "()Lokio/Timeout;", "clearDeadline", "Lie/H;", "throwIfReached", "()V", "cancel", "Ljava/util/concurrent/locks/Condition;", "condition", "awaitSignal", "(Ljava/util/concurrent/locks/Condition;)V", "", "monitor", "waitUntilNotified", "(Ljava/lang/Object;)V", "Lokio/Timeout;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public class ForwardingTimeout extends Timeout {
    @NotNull
    private Timeout delegate;

    public ForwardingTimeout(@NotNull Timeout timeout0) {
        q.g(timeout0, "delegate");
        super();
        this.delegate = timeout0;
    }

    @Override  // okio.Timeout
    public void awaitSignal(@NotNull Condition condition0) {
        q.g(condition0, "condition");
        this.delegate.awaitSignal(condition0);
    }

    @Override  // okio.Timeout
    public void cancel() {
        this.delegate.cancel();
    }

    @Override  // okio.Timeout
    @NotNull
    public Timeout clearDeadline() {
        return this.delegate.clearDeadline();
    }

    @Override  // okio.Timeout
    @NotNull
    public Timeout clearTimeout() {
        return this.delegate.clearTimeout();
    }

    @Override  // okio.Timeout
    public long deadlineNanoTime() {
        return this.delegate.deadlineNanoTime();
    }

    @Override  // okio.Timeout
    @NotNull
    public Timeout deadlineNanoTime(long v) {
        return this.delegate.deadlineNanoTime(v);
    }

    @NotNull
    public final Timeout delegate() {
        return this.delegate;
    }

    @Override  // okio.Timeout
    public boolean hasDeadline() {
        return this.delegate.hasDeadline();
    }

    @NotNull
    public final ForwardingTimeout setDelegate(@NotNull Timeout timeout0) {
        q.g(timeout0, "delegate");
        this.delegate = timeout0;
        return this;
    }

    public final void setDelegate(Timeout timeout0) {
        q.g(timeout0, "<set-?>");
        this.delegate = timeout0;
    }

    @Override  // okio.Timeout
    public void throwIfReached() {
        this.delegate.throwIfReached();
    }

    @Override  // okio.Timeout
    @NotNull
    public Timeout timeout(long v, @NotNull TimeUnit timeUnit0) {
        q.g(timeUnit0, "unit");
        return this.delegate.timeout(v, timeUnit0);
    }

    @Override  // okio.Timeout
    public long timeoutNanos() {
        return this.delegate.timeoutNanos();
    }

    @Override  // okio.Timeout
    public void waitUntilNotified(@NotNull Object object0) {
        q.g(object0, "monitor");
        this.delegate.waitUntilNotified(object0);
    }
}

