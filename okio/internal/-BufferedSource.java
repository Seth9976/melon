package okio.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.BufferedSource;
import okio.TypedOptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A,\u0010\u0000\u001A\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0080\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"commonSelect", "T", "", "Lokio/BufferedSource;", "options", "Lokio/TypedOptions;", "(Lokio/BufferedSource;Lokio/TypedOptions;)Ljava/lang/Object;", "okio"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public final class -BufferedSource {
    @Nullable
    public static final Object commonSelect(@NotNull BufferedSource bufferedSource0, @NotNull TypedOptions typedOptions0) {
        q.g(bufferedSource0, "<this>");
        q.g(typedOptions0, "options");
        int v = bufferedSource0.select(typedOptions0.getOptions$okio());
        return v == -1 ? null : typedOptions0.get(v);
    }
}

