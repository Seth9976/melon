package androidx.window.core;

import i.n.i.b.a.s.e.M3;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B/\u0012\u0006\u0010\u0004\u001A\u00028\u0000\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001A\u00020\u00052\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000F0\u000EH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0013\u001A\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001A\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001A\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0006\u001A\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001A\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001A\u0004\b\u001A\u0010\u0019R\u0017\u0010\t\u001A\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001B\u001A\u0004\b\u001C\u0010\u001DR\u0017\u0010\u000B\u001A\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000B\u0010\u001E\u001A\u0004\b\u001F\u0010 R\u0017\u0010\"\u001A\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001A\u0004\b$\u0010%¨\u0006&"}, d2 = {"Landroidx/window/core/FailedSpecification;", "", "T", "Landroidx/window/core/SpecificationComputer;", "value", "", "tag", "message", "Landroidx/window/core/Logger;", "logger", "Landroidx/window/core/VerificationMode;", "verificationMode", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Landroidx/window/core/Logger;Landroidx/window/core/VerificationMode;)V", "Lkotlin/Function1;", "", "condition", "require", "(Ljava/lang/String;Lwe/k;)Landroidx/window/core/SpecificationComputer;", "compute", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "getMessage", "Landroidx/window/core/Logger;", "getLogger", "()Landroidx/window/core/Logger;", "Landroidx/window/core/VerificationMode;", "getVerificationMode", "()Landroidx/window/core/VerificationMode;", "Landroidx/window/core/WindowStrictModeException;", "exception", "Landroidx/window/core/WindowStrictModeException;", "getException", "()Landroidx/window/core/WindowStrictModeException;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class FailedSpecification extends SpecificationComputer {
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[VerificationMode.values().length];
            try {
                arr_v[VerificationMode.STRICT.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[VerificationMode.LOG.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[VerificationMode.QUIET.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    @NotNull
    private final WindowStrictModeException exception;
    @NotNull
    private final Logger logger;
    @NotNull
    private final String message;
    @NotNull
    private final String tag;
    @NotNull
    private final Object value;
    @NotNull
    private final VerificationMode verificationMode;

    public FailedSpecification(@NotNull Object object0, @NotNull String s, @NotNull String s1, @NotNull Logger logger0, @NotNull VerificationMode verificationMode0) {
        q.g(object0, "value");
        q.g(s, "tag");
        q.g(s1, "message");
        q.g(logger0, "logger");
        q.g(verificationMode0, "verificationMode");
        super();
        this.value = object0;
        this.tag = s;
        this.message = s1;
        this.logger = logger0;
        this.verificationMode = verificationMode0;
        WindowStrictModeException windowStrictModeException0 = new WindowStrictModeException(this.createMessage(object0, s1));
        StackTraceElement[] arr_stackTraceElement = windowStrictModeException0.getStackTrace();
        q.f(arr_stackTraceElement, "getStackTrace(...)");
        windowStrictModeException0.setStackTrace(((StackTraceElement[])n.b0(2, arr_stackTraceElement).toArray(new StackTraceElement[0])));
        this.exception = windowStrictModeException0;
    }

    @Override  // androidx.window.core.SpecificationComputer
    @Nullable
    public Object compute() {
        switch(WhenMappings.$EnumSwitchMapping$0[this.verificationMode.ordinal()]) {
            case 1: {
                throw this.exception;
            }
            case 2: {
                String s = this.createMessage(this.value, this.message);
                this.logger.debug(this.tag, s);
                return null;
            }
            case 3: {
                return null;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    @NotNull
    public final WindowStrictModeException getException() {
        return this.exception;
    }

    @NotNull
    public final Logger getLogger() {
        return this.logger;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    @NotNull
    public final Object getValue() {
        return this.value;
    }

    @NotNull
    public final VerificationMode getVerificationMode() {
        return this.verificationMode;
    }

    @Override  // androidx.window.core.SpecificationComputer
    @NotNull
    public SpecificationComputer require(@NotNull String s, @NotNull k k0) {
        q.g(s, "message");
        q.g(k0, "condition");
        return this;
    }
}

