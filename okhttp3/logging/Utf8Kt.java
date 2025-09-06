package okhttp3.logging;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"isProbablyUtf8", "", "Lokio/Buffer;", "okhttp-logging-interceptor"}, k = 2, mv = {1, 8, 0}, xi = 0x30)
public final class Utf8Kt {
    public static final boolean isProbablyUtf8(@NotNull Buffer buffer0) {
        q.g(buffer0, "<this>");
        try {
            Buffer buffer1 = new Buffer();
            long v = buffer0.size();
            buffer0.copyTo(buffer1, 0L, (v > 0x40L ? 0x40L : v));
            for(int v1 = 0; true; ++v1) {
                if(v1 >= 16 || buffer1.exhausted()) {
                    return true;
                }
                int v2 = buffer1.readUtf8CodePoint();
                if(Character.isISOControl(v2) && !Character.isWhitespace(v2)) {
                    break;
                }
            }
        }
        catch(EOFException unused_ex) {
        }
        return false;
    }
}

