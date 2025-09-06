package kotlinx.coroutines.internal;

import e2.a;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001AE\u0010\u0007\u001A\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032\u0006\u0010\u0004\u001A\u00028\u00002\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001A?\u0010\u000B\u001A\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032\u0006\u0010\u0004\u001A\u00028\u00002\u0006\u0010\n\u001A\u00020\tH\u0000¢\u0006\u0004\b\u000B\u0010\f**\b\u0000\u0010\r\u001A\u0004\b\u0000\u0010\u0000\"\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u000E"}, d2 = {"E", "Lkotlin/Function1;", "Lie/H;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "element", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "undeliveredElementException", "callUndeliveredElementCatchingException", "(Lwe/k;Ljava/lang/Object;Lkotlinx/coroutines/internal/UndeliveredElementException;)Lkotlinx/coroutines/internal/UndeliveredElementException;", "Lme/i;", "context", "callUndeliveredElement", "(Lwe/k;Ljava/lang/Object;Lme/i;)V", "OnUndeliveredElement", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class OnUndeliveredElementKt {
    public static final void callUndeliveredElement(@NotNull k k0, Object object0, @NotNull i i0) {
        UndeliveredElementException undeliveredElementException0 = OnUndeliveredElementKt.callUndeliveredElementCatchingException(k0, object0, null);
        if(undeliveredElementException0 != null) {
            CoroutineExceptionHandlerKt.handleCoroutineException(i0, undeliveredElementException0);
        }
    }

    @Nullable
    public static final UndeliveredElementException callUndeliveredElementCatchingException(@NotNull k k0, Object object0, @Nullable UndeliveredElementException undeliveredElementException0) {
        try {
            k0.invoke(object0);
            return undeliveredElementException0;
        }
        catch(Throwable throwable0) {
            if(undeliveredElementException0 != null && undeliveredElementException0.getCause() != throwable0) {
                a.q(undeliveredElementException0, throwable0);
                return undeliveredElementException0;
            }
            return new UndeliveredElementException("Exception in undelivered element handler for " + object0, throwable0);
        }
    }

    public static UndeliveredElementException callUndeliveredElementCatchingException$default(k k0, Object object0, UndeliveredElementException undeliveredElementException0, int v, Object object1) {
        if((v & 2) != 0) {
            undeliveredElementException0 = null;
        }
        return OnUndeliveredElementKt.callUndeliveredElementCatchingException(k0, object0, undeliveredElementException0);
    }
}

