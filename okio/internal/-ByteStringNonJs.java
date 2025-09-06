package okio.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0000\u001A\r\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0080\b\u001A\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"commonDecodeHex", "Lokio/ByteString;", "", "decodeHexDigit", "", "c", "", "okio"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public final class -ByteStringNonJs {
    @NotNull
    public static final ByteString commonDecodeHex(@NotNull String s) {
        q.g(s, "<this>");
        if(s.length() % 2 != 0) {
            throw new IllegalArgumentException(("Unexpected hex string: " + s).toString());
        }
        int v = s.length();
        byte[] arr_b = new byte[v / 2];
        for(int v1 = 0; v1 < v / 2; ++v1) {
            int v2 = -ByteStringNonJs.decodeHexDigit(s.charAt(v1 * 2));
            arr_b[v1] = (byte)(-ByteStringNonJs.decodeHexDigit(s.charAt(v1 * 2 + 1)) + (v2 << 4));
        }
        return new ByteString(arr_b);
    }

    private static final int decodeHexDigit(char c) {
        if(0x30 <= c && c < 58) {
            return c - 0x30;
        }
        if(97 <= c && c < 103) {
            return c - 87;
        }
        if(65 > c || c >= 71) {
            throw new IllegalArgumentException("Unexpected hex digit: " + c);
        }
        return c - 55;
    }
}

