package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0004¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lkotlinx/serialization/json/internal/CharArrayPool;", "Lkotlinx/serialization/json/internal/CharArrayPoolBase;", "<init>", "()V", "", "take", "()[C", "array", "Lie/H;", "release", "([C)V", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class CharArrayPool extends CharArrayPoolBase {
    @NotNull
    public static final CharArrayPool INSTANCE;

    static {
        CharArrayPool.INSTANCE = new CharArrayPool();
    }

    public final void release(@NotNull char[] arr_c) {
        q.g(arr_c, "array");
        this.releaseImpl(arr_c);
    }

    @NotNull
    public final char[] take() {
        return this.take(0x80);
    }
}

