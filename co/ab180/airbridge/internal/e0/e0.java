package co.ab180.airbridge.internal.e0;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0010\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0002\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000E\u001A\u00020\u0007¢\u0006\u0004\b\u000E\u0010\u000FJ\r\u0010\u0011\u001A\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001A\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001A\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u0018R\u0014\u0010\u0004\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0018R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0019R\u0014\u0010\b\u001A\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001A\u0010\u001B¨\u0006\u001C"}, d2 = {"Lco/ab180/airbridge/internal/e0/e0;", "", "", "delayMillis", "maxDelayMillis", "", "multiplier", "", "maxRetryCount", "<init>", "(JJDI)V", "Lie/H;", "d", "()V", "b", "()I", "", "a", "()Z", "c", "()J", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "retryCount", "J", "D", "e", "I", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public class e0 {
    private final AtomicInteger a;
    private final long b;
    private final long c;
    private final double d;
    private final int e;

    public e0() {
        this(0L, 0L, 0.0, 0, 15, null);
    }

    public e0(long v, long v1, double f, int v2) {
        this.b = v;
        this.c = v1;
        this.d = f;
        this.e = v2;
        this.a = new AtomicInteger(0);
    }

    public e0(long v, long v1, double f, int v2, int v3, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v3 & 1) != 0) {
            v = 0L;
        }
        if((v3 & 2) != 0) {
            v1 = 0L;
        }
        if((v3 & 4) != 0) {
            f = 2.0;
        }
        if((v3 & 8) != 0) {
            v2 = 0x7FFFFFFF;
        }
        this(v, v1, f, v2);
    }

    public final boolean a() {
        return this.a.get() < this.e;
    }

    public final int b() {
        return this.a.incrementAndGet();
    }

    public final long c() {
        int v = this.a.get();
        return v > 1 ? Math.min(((long)(Math.pow(this.d, v - 2) * ((double)this.b))), this.c) : 0L;
    }

    public final void d() {
        this.a.set(0);
    }
}

