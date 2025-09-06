package Uf;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.q;
import pe.b;

public enum d {
    NANOSECONDS(TimeUnit.NANOSECONDS),
    MICROSECONDS(TimeUnit.MICROSECONDS),  // 此枚举字段已被移除
    MILLISECONDS(TimeUnit.MILLISECONDS),
    SECONDS(TimeUnit.SECONDS),
    MINUTES(TimeUnit.MINUTES),
    HOURS(TimeUnit.HOURS),
    DAYS(TimeUnit.DAYS);

    public final TimeUnit a;
    public static final d[] h;

    static {
        d.h = arr_d;
        q.g(arr_d, "entries");
        new b(arr_d);
    }

    public d(TimeUnit timeUnit0) {
        this.a = timeUnit0;
    }
}

