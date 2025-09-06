package kotlinx.coroutines;

import kotlin.Metadata;
import me.g;
import me.h;
import me.i;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lme/g;", "Lme/i;", "context", "", "exception", "Lie/H;", "handleException", "(Lme/i;Ljava/lang/Throwable;)V", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public interface CoroutineExceptionHandler extends g {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler$Key;", "Lme/h;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class Key implements h {
        static final Key $$INSTANCE;

        static {
            Key.$$INSTANCE = new Key();
        }
    }

    @NotNull
    public static final Key Key;

    static {
        CoroutineExceptionHandler.Key = Key.$$INSTANCE;
    }

    void handleException(@NotNull i arg1, @NotNull Throwable arg2);
}

