package co.ab180.airbridge.internal.b0.n;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001A\u0004\u0018\u00018\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lco/ab180/airbridge/internal/b0/n/h;", "R", "Ljava/io/Closeable;", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lie/H;", "close", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public interface h extends Closeable {
    @Override
    void close();

    @Nullable
    Object d(@NotNull Continuation arg1);
}

