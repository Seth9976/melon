package androidx.window.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\n\b \u0018\u0000 \u0011*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J1\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0006\u001A\u00020\u00052\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0004\b\n\u0010\u000BJ\u0011\u0010\f\u001A\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\f\u0010\rJ\u001F\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u0005H\u0004¢\u0006\u0004\b\u000F\u0010\u0010¨\u0006\u0012"}, d2 = {"Landroidx/window/core/SpecificationComputer;", "", "T", "<init>", "()V", "", "message", "Lkotlin/Function1;", "", "condition", "require", "(Ljava/lang/String;Lwe/k;)Landroidx/window/core/SpecificationComputer;", "compute", "()Ljava/lang/Object;", "value", "createMessage", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public abstract class SpecificationComputer {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J;\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u0001*\u0002H\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Landroidx/window/core/SpecificationComputer$Companion;", "", "()V", "startSpecification", "Landroidx/window/core/SpecificationComputer;", "T", "tag", "", "verificationMode", "Landroidx/window/core/VerificationMode;", "logger", "Landroidx/window/core/Logger;", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/window/core/VerificationMode;Landroidx/window/core/Logger;)Landroidx/window/core/SpecificationComputer;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SpecificationComputer startSpecification(@NotNull Object object0, @NotNull String s, @NotNull VerificationMode verificationMode0, @NotNull Logger logger0) {
            q.g(object0, "<this>");
            q.g(s, "tag");
            q.g(verificationMode0, "verificationMode");
            q.g(logger0, "logger");
            return new ValidSpecification(object0, s, verificationMode0, logger0);
        }

        public static SpecificationComputer startSpecification$default(Companion specificationComputer$Companion0, Object object0, String s, VerificationMode verificationMode0, Logger logger0, int v, Object object1) {
            if((v & 2) != 0) {
                verificationMode0 = BuildConfig.INSTANCE.getVerificationMode();
            }
            if((v & 4) != 0) {
                logger0 = AndroidLogger.INSTANCE;
            }
            return specificationComputer$Companion0.startSpecification(object0, s, verificationMode0, logger0);
        }
    }

    @NotNull
    public static final Companion Companion;

    static {
        SpecificationComputer.Companion = new Companion(null);
    }

    @Nullable
    public abstract Object compute();

    @NotNull
    public final String createMessage(@NotNull Object object0, @NotNull String s) {
        q.g(object0, "value");
        q.g(s, "message");
        return s + " value: " + object0;
    }

    @NotNull
    public abstract SpecificationComputer require(@NotNull String arg1, @NotNull k arg2);
}

