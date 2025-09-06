package androidx.window.core;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0011\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\'\u0012\u0006\u0010\u0004\u001A\u00028\u0000\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u000B\u0010\fJ1\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\r\u001A\u00020\u00052\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000F0\u000EH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001A\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001A\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0006\u001A\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019R\u0017\u0010\b\u001A\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001A\u001A\u0004\b\u001B\u0010\u001CR\u0017\u0010\n\u001A\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001D\u001A\u0004\b\u001E\u0010\u001F¨\u0006 "}, d2 = {"Landroidx/window/core/ValidSpecification;", "", "T", "Landroidx/window/core/SpecificationComputer;", "value", "", "tag", "Landroidx/window/core/VerificationMode;", "verificationMode", "Landroidx/window/core/Logger;", "logger", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/window/core/VerificationMode;Landroidx/window/core/Logger;)V", "message", "Lkotlin/Function1;", "", "condition", "require", "(Ljava/lang/String;Lwe/k;)Landroidx/window/core/SpecificationComputer;", "compute", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Landroidx/window/core/VerificationMode;", "getVerificationMode", "()Landroidx/window/core/VerificationMode;", "Landroidx/window/core/Logger;", "getLogger", "()Landroidx/window/core/Logger;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class ValidSpecification extends SpecificationComputer {
    @NotNull
    private final Logger logger;
    @NotNull
    private final String tag;
    @NotNull
    private final Object value;
    @NotNull
    private final VerificationMode verificationMode;

    public ValidSpecification(@NotNull Object object0, @NotNull String s, @NotNull VerificationMode verificationMode0, @NotNull Logger logger0) {
        q.g(object0, "value");
        q.g(s, "tag");
        q.g(verificationMode0, "verificationMode");
        q.g(logger0, "logger");
        super();
        this.value = object0;
        this.tag = s;
        this.verificationMode = verificationMode0;
        this.logger = logger0;
    }

    @Override  // androidx.window.core.SpecificationComputer
    @NotNull
    public Object compute() {
        return this.value;
    }

    @NotNull
    public final Logger getLogger() {
        return this.logger;
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
        return ((Boolean)k0.invoke(this.value)).booleanValue() ? this : new FailedSpecification(this.value, this.tag, s, this.logger, this.verificationMode);
    }
}

