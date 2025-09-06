package co.ab180.airbridge.internal.e0;

import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lco/ab180/airbridge/internal/e0/x;", "Lco/ab180/airbridge/internal/e0/e0;", "", "throwable", "", "a", "(Ljava/lang/Throwable;)Z", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class x extends e0 {
    public x() {
        super(1000L, 60000L, 0.0, 0, 12, null);
    }

    // 去混淆评级： 低(40)
    public final boolean a(@NotNull Throwable throwable0) {
        return throwable0 instanceof m || throwable0 instanceof UnknownHostException || throwable0 instanceof ConnectException || throwable0 instanceof IOException;
    }
}

