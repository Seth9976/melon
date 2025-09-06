package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import me.a;
import me.h;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0005\u001A\u00020\u00048\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/YieldContext;", "Lme/a;", "<init>", "()V", "", "dispatcherWasUnconfined", "Z", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class YieldContext extends a {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/YieldContext$Key;", "Lme/h;", "Lkotlinx/coroutines/YieldContext;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class Key implements h {
        private Key() {
        }

        public Key(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Key Key;
    public boolean dispatcherWasUnconfined;

    static {
        YieldContext.Key = new Key(null);
    }

    public YieldContext() {
        super(YieldContext.Key);
    }
}

