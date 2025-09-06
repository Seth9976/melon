package okio;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001F\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0003\u0010\u0006J\u0017\u0010\u0007\u001A\u00020\u00012\u0006\u0010\u0007\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"okio/Timeout$Companion$NONE$1", "Lokio/Timeout;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;", "deadlineNanoTime", "(J)Lokio/Timeout;", "Lie/H;", "throwIfReached", "()V", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class Timeout.Companion.NONE.1 extends Timeout {
    @Override  // okio.Timeout
    public Timeout deadlineNanoTime(long v) {
        return this;
    }

    @Override  // okio.Timeout
    public void throwIfReached() {
    }

    @Override  // okio.Timeout
    public Timeout timeout(long v, TimeUnit timeUnit0) {
        q.g(timeUnit0, "unit");
        return this;
    }
}

