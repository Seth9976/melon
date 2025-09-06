package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\r\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0086\b¨\u0006\u0003"}, d2 = {"gzip", "Lokio/GzipSink;", "Lokio/Sink;", "okio"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public final class -GzipSinkExtensions {
    @NotNull
    public static final GzipSink gzip(@NotNull Sink sink0) {
        q.g(sink0, "<this>");
        return new GzipSink(sink0);
    }
}

