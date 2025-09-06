package kotlinx.coroutines;

import df.v;
import kotlin.Metadata;
import me.g;
import me.i;
import org.jetbrains.annotations.NotNull;
import we.n;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001A\u00028\u00002\u0006\u0010\u0004\u001A\u00020\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00028\u0000H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lkotlinx/coroutines/ThreadContextElement;", "S", "Lme/g;", "Lme/i;", "context", "updateThreadContext", "(Lme/i;)Ljava/lang/Object;", "oldState", "Lie/H;", "restoreThreadContext", "(Lme/i;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public interface ThreadContextElement extends g {
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
    public static abstract class DefaultImpls {
        public static Object fold(@NotNull ThreadContextElement threadContextElement0, Object object0, @NotNull n n0) {
            return v.v(threadContextElement0, object0, n0);
        }

        @NotNull
        public static i plus(@NotNull ThreadContextElement threadContextElement0, @NotNull i i0) {
            return v.F(i0, threadContextElement0);
        }
    }

    void restoreThreadContext(@NotNull i arg1, Object arg2);

    Object updateThreadContext(@NotNull i arg1);
}

