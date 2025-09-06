package kotlinx.coroutines.internal;

import ie.p;
import kotlin.Metadata;
import oe.a;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A!\u0010\u0003\u001A\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001A\u00028\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u001C\u0010\n\u001A\n \t*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000B\"\u001C\u0010\f\u001A\n \t*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000B*\f\b\u0000\u0010\u000E\"\u00020\r2\u00020\r*\f\b\u0000\u0010\u000F\"\u00020\u00052\u00020\u0005¨\u0006\u0010"}, d2 = {"", "E", "exception", "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Ljava/lang/StackTraceElement;", "ARTIFICIAL_FRAME", "Ljava/lang/StackTraceElement;", "", "kotlin.jvm.PlatformType", "baseContinuationImplClassName", "Ljava/lang/String;", "stackTraceRecoveryClassName", "Loe/d;", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class StackTraceRecoveryKt {
    @NotNull
    private static final StackTraceElement ARTIFICIAL_FRAME;
    private static final String baseContinuationImplClassName;
    private static final String stackTraceRecoveryClassName;

    static {
        StackTraceElement stackTraceElement0 = new Exception().getStackTrace()[0];
        StackTraceRecoveryKt.ARTIFICIAL_FRAME = new StackTraceElement("_COROUTINE.a", "_", stackTraceElement0.getFileName(), stackTraceElement0.getLineNumber());
        StackTraceRecoveryKt.baseContinuationImplClassName = p.a(a.class.getCanonicalName()) == null ? a.class.getCanonicalName() : "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        StackTraceRecoveryKt.stackTraceRecoveryClassName = p.a(StackTraceRecoveryKt.class.getCanonicalName()) == null ? StackTraceRecoveryKt.class.getCanonicalName() : "kotlinx.coroutines.internal.StackTraceRecoveryKt";
    }

    @NotNull
    public static final Throwable recoverStackTrace(@NotNull Throwable throwable0) [...] // Inlined contents
}

