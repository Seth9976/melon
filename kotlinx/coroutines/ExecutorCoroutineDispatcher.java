package kotlinx.coroutines;

import Wf.a;
import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import me.b;
import me.g;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u000B2\u00020\u00012\u00020\u00022\u00060\u0003j\u0002`\u0004:\u0001\u000BB\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001A\u00020\u00078&X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/io/Closeable;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "<init>", "()V", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable, AutoCloseable {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcher$Key;", "Lme/b;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class Key extends b {
        private Key() {
            a a0 = new a(1);
            super(CoroutineDispatcher.Key, a0);
        }

        public Key(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        // 去混淆评级： 低(20)
        private static final ExecutorCoroutineDispatcher _init_$lambda$0(g g0) {
            return g0 instanceof ExecutorCoroutineDispatcher ? ((ExecutorCoroutineDispatcher)g0) : null;
        }

        public static ExecutorCoroutineDispatcher a(g g0) {
            return Key._init_$lambda$0(g0);
        }
    }

    @NotNull
    public static final Key Key;

    static {
        ExecutorCoroutineDispatcher.Key = new Key(null);
    }

    @NotNull
    public abstract Executor getExecutor();
}

