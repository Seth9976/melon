package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.ThreadContextElement.DefaultImpls;
import kotlinx.coroutines.ThreadContextElement;
import me.g;
import me.h;
import me.i;
import me.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001D\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001A\u00028\u00002\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000E\u001A\u00020\r2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\f\u001A\u00028\u0000H\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u001B\u0010\u0012\u001A\u00020\b2\n\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J*\u0010\u0016\u001A\u0004\u0018\u00018\u0001\"\b\b\u0001\u0010\u0015*\u00020\u00142\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00010\u0010H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0019\u001A\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001AR\u0014\u0010\u0003\u001A\u00028\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001BR\u001A\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001CR\u001E\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001D\u001A\u0004\b\u001E\u0010\u001F¨\u0006 "}, d2 = {"Lkotlinx/coroutines/internal/ThreadLocalElement;", "T", "Lkotlinx/coroutines/ThreadContextElement;", "value", "Ljava/lang/ThreadLocal;", "threadLocal", "<init>", "(Ljava/lang/Object;Ljava/lang/ThreadLocal;)V", "Lme/i;", "context", "updateThreadContext", "(Lme/i;)Ljava/lang/Object;", "oldState", "Lie/H;", "restoreThreadContext", "(Lme/i;Ljava/lang/Object;)V", "Lme/h;", "key", "minusKey", "(Lme/h;)Lme/i;", "Lme/g;", "E", "get", "(Lme/h;)Lme/g;", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "Ljava/lang/ThreadLocal;", "Lme/h;", "getKey", "()Lme/h;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class ThreadLocalElement implements ThreadContextElement {
    @NotNull
    private final h key;
    @NotNull
    private final ThreadLocal threadLocal;
    private final Object value;

    public ThreadLocalElement(Object object0, @NotNull ThreadLocal threadLocal0) {
        this.value = object0;
        this.threadLocal = threadLocal0;
        this.key = new ThreadLocalKey(threadLocal0);
    }

    @Override  // me.i
    public Object fold(Object object0, @NotNull n n0) {
        return DefaultImpls.fold(this, object0, n0);
    }

    @Override  // me.i
    @Nullable
    public g get(@NotNull h h0) {
        return q.b(this.getKey(), h0) ? this : null;
    }

    @Override  // me.g
    @NotNull
    public h getKey() {
        return this.key;
    }

    @Override  // me.i
    @NotNull
    public i minusKey(@NotNull h h0) {
        return q.b(this.getKey(), h0) ? j.a : this;
    }

    @Override  // me.i
    @NotNull
    public i plus(@NotNull i i0) {
        return DefaultImpls.plus(this, i0);
    }

    @Override  // kotlinx.coroutines.ThreadContextElement
    public void restoreThreadContext(@NotNull i i0, Object object0) {
        this.threadLocal.set(object0);
    }

    @Override
    @NotNull
    public String toString() {
        return "ThreadLocal(value=" + this.value + ", threadLocal = " + this.threadLocal + ')';
    }

    @Override  // kotlinx.coroutines.ThreadContextElement
    public Object updateThreadContext(@NotNull i i0) {
        Object object0 = this.threadLocal.get();
        this.threadLocal.set(this.value);
        return object0;
    }
}

