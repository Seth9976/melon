package com.facebook.bolts;

import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0011\u0010\u0013\u001A\u00020\u00128F¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/facebook/bolts/CancellationToken;", "", "Lcom/facebook/bolts/CancellationTokenSource;", "tokenSource", "<init>", "(Lcom/facebook/bolts/CancellationTokenSource;)V", "Ljava/lang/Runnable;", "action", "Lcom/facebook/bolts/CancellationTokenRegistration;", "register", "(Ljava/lang/Runnable;)Lcom/facebook/bolts/CancellationTokenRegistration;", "Lie/H;", "throwIfCancellationRequested", "()V", "", "toString", "()Ljava/lang/String;", "Lcom/facebook/bolts/CancellationTokenSource;", "", "isCancellationRequested", "()Z", "facebook-bolts_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CancellationToken {
    @NotNull
    private final CancellationTokenSource tokenSource;

    public CancellationToken(@NotNull CancellationTokenSource cancellationTokenSource0) {
        q.g(cancellationTokenSource0, "tokenSource");
        super();
        this.tokenSource = cancellationTokenSource0;
    }

    public final boolean isCancellationRequested() {
        return this.tokenSource.isCancellationRequested();
    }

    @NotNull
    public final CancellationTokenRegistration register(@Nullable Runnable runnable0) {
        return this.tokenSource.register$facebook_bolts_release(runnable0);
    }

    public final void throwIfCancellationRequested() {
        this.tokenSource.throwIfCancellationRequested$facebook_bolts_release();
    }

    // 去混淆评级： 低(20)
    @Override
    @NotNull
    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", Arrays.copyOf(new Object[]{"com.facebook.bolts.CancellationToken", Integer.toHexString(this.hashCode()), Boolean.toString(this.tokenSource.isCancellationRequested())}, 3));
    }
}

