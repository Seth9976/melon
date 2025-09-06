package co.ab180.airbridge.internal;

import co.ab180.airbridge.internal.w.b;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0005\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u001B\u0010\u0003\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lco/ab180/airbridge/internal/i;", "Ljava/io/Closeable;", "Lie/H;", "a", "()V", "b", "Lco/ab180/airbridge/internal/w/b;", "eventSeed", "", "(Lco/ab180/airbridge/internal/w/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public interface i extends Closeable {
    @Nullable
    Object a(@NotNull b arg1, @NotNull Continuation arg2);

    void a();

    void b();
}

