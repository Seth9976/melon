package okio;

import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A \u0010\u0000\u001A\u00020\u0001*\u00020\u00022\f\b\u0002\u0010\u0003\u001A\u00060\u0004j\u0002`\u0005H\u0086\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"deflate", "Lokio/DeflaterSink;", "Lokio/Sink;", "deflater", "Ljava/util/zip/Deflater;", "Lokio/Deflater;", "(Lokio/Sink;Ljava/util/zip/Deflater;)Lokio/DeflaterSink;", "okio"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public final class -DeflaterSinkExtensions {
    @NotNull
    public static final DeflaterSink deflate(@NotNull Sink sink0, @NotNull Deflater deflater0) {
        q.g(sink0, "<this>");
        q.g(deflater0, "deflater");
        return new DeflaterSink(sink0, deflater0);
    }

    public static DeflaterSink deflate$default(Sink sink0, Deflater deflater0, int v, Object object0) {
        if((v & 1) != 0) {
            deflater0 = new Deflater();
        }
        q.g(sink0, "<this>");
        q.g(deflater0, "deflater");
        return new DeflaterSink(sink0, deflater0);
    }
}

