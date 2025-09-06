package okio;

import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A \u0010\u0000\u001A\u00020\u0001*\u00020\u00022\f\b\u0002\u0010\u0003\u001A\u00060\u0004j\u0002`\u0005H\u0086\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"inflate", "Lokio/InflaterSource;", "Lokio/Source;", "inflater", "Ljava/util/zip/Inflater;", "Lokio/Inflater;", "(Lokio/Source;Ljava/util/zip/Inflater;)Lokio/InflaterSource;", "okio"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public final class -InflaterSourceExtensions {
    @NotNull
    public static final InflaterSource inflate(@NotNull Source source0, @NotNull Inflater inflater0) {
        q.g(source0, "<this>");
        q.g(inflater0, "inflater");
        return new InflaterSource(source0, inflater0);
    }

    public static InflaterSource inflate$default(Source source0, Inflater inflater0, int v, Object object0) {
        if((v & 1) != 0) {
            inflater0 = new Inflater();
        }
        q.g(source0, "<this>");
        q.g(inflater0, "inflater");
        return new InflaterSource(source0, inflater0);
    }
}

