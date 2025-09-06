package okio.internal;

import java.util.GregorianCalendar;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0003\u001A8\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020\u00012\u0006\u0010\u000B\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\u00012\u0006\u0010\r\u001A\u00020\u0001H\u0000\"\u0014\u0010\u0000\u001A\u00020\u0001X\u0080D¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u000E\u001A\u00020\u000FX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011*\f\b\u0000\u0010\u0004\"\u00020\u00052\u00020\u0005¨\u0006\u0012"}, d2 = {"DEFAULT_COMPRESSION", "", "getDEFAULT_COMPRESSION", "()I", "CRC32", "Ljava/util/zip/CRC32;", "datePartsToEpochMillis", "", "year", "month", "day", "hour", "minute", "second", "EMPTY_BYTE_ARRAY", "", "getEMPTY_BYTE_ARRAY", "()[B", "okio"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public final class _ZlibJvmKt {
    private static final int DEFAULT_COMPRESSION = -1;
    @NotNull
    private static final byte[] EMPTY_BYTE_ARRAY;

    static {
        _ZlibJvmKt.EMPTY_BYTE_ARRAY = new byte[0];
    }

    public static final long datePartsToEpochMillis(int v, int v1, int v2, int v3, int v4, int v5) {
        GregorianCalendar gregorianCalendar0 = new GregorianCalendar();
        gregorianCalendar0.set(14, 0);
        gregorianCalendar0.set(v, v1 - 1, v2, v3, v4, v5);
        return gregorianCalendar0.getTime().getTime();
    }

    public static final int getDEFAULT_COMPRESSION() [...] // 潜在的解密器

    @NotNull
    public static final byte[] getEMPTY_BYTE_ARRAY() [...] // 潜在的解密器
}

