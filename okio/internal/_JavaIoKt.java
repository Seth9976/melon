package okio.internal;

import Tf.o;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0016\u0010\u0000\u001A\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001C\u0010\u0003\u001A\u00020\u0004*\u00060\u0005j\u0002`\u00068@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0007¨\u0006\b"}, d2 = {"logger", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "isAndroidGetsocknameError", "", "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", "(Ljava/lang/AssertionError;)Z", "okio"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public final class _JavaIoKt {
    private static final Logger logger;

    static {
        _JavaIoKt.logger = Logger.getLogger("okio.Okio");
    }

    public static final Logger access$getLogger$p() {
        return _JavaIoKt.logger;
    }

    public static final boolean isAndroidGetsocknameError(@NotNull AssertionError assertionError0) {
        q.g(assertionError0, "<this>");
        if(assertionError0.getCause() != null) {
            String s = assertionError0.getMessage();
            return s == null ? false : o.v0(s, "getsockname failed", false);
        }
        return false;
    }
}

