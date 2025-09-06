package co.ab180.airbridge.internal.e0;

import android.os.SystemClock;
import java.util.Arrays;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0015\u0010\u0005\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\b¨\u0006\u000B"}, d2 = {"Lco/ab180/airbridge/internal/e0/g0;", "", "", "b", "()J", "a", "millisecond", "", "(J)Ljava/lang/String;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class g0 {
    @NotNull
    public static final g0 a;

    static {
        g0.a = new g0();
    }

    public final long a() {
        return SystemClock.elapsedRealtime();
    }

    @NotNull
    public final String a(long v) {
        return String.format("%.3f", Arrays.copyOf(new Object[]{((float)(((float)v) / 1000.0f))}, 1));
    }

    public final long b() {
        return System.currentTimeMillis();
    }
}

