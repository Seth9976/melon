package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\r\b\u0087@\u0018\u0000 \u001E*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\u001F \u001EB\u0013\b\u0001\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0006\u0010\u0005J\u000F\u0010\u000B\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000F\u001A\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u0010\u0010\u0011\u001A\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001A\u0010\u0015\u001A\u00020\u00142\b\u0010\u0013\u001A\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001C\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u0012\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001B\u001A\u00020\u00148F¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u0016R\u0011\u0010\u001D\u001A\u00020\u00148F¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u0016\u0088\u0001\u0003\u0092\u0001\u0004\u0018\u00010\u0002¨\u0006!"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult;", "T", "", "holder", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrNull-impl", "getOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "exceptionOrNull", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getHolder$annotations", "()V", "isSuccess-impl", "isSuccess", "isClosed-impl", "isClosed", "Companion", "Failed", "Closed", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class ChannelResult {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\n\u001A\u00020\u000BH\u0016J\b\u0010\f\u001A\u00020\rH\u0016R\u0012\u0010\u0002\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Closed;", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "cause", "", "<init>", "(Ljava/lang/Throwable;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class Closed extends Failed {
        @Nullable
        public final Throwable cause;

        public Closed(@Nullable Throwable throwable0) {
            this.cause = throwable0;
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return object0 instanceof Closed && q.b(this.cause, ((Closed)object0).cause);
        }

        @Override
        public int hashCode() {
            return this.cause == null ? 0 : this.cause.hashCode();
        }

        @Override  // kotlinx.coroutines.channels.ChannelResult$Failed
        @NotNull
        public String toString() {
            return "Closed(" + this.cause + ')';
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0001\u0010\b2\u0006\u0010\t\u001A\u0002H\bH\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u001B\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0001\u0010\bH\u0007¢\u0006\u0004\b\r\u0010\u000EJ%\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0001\u0010\b2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Companion;", "", "<init>", "()V", "failed", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "success", "Lkotlinx/coroutines/channels/ChannelResult;", "E", "value", "success-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "failure", "failure-PtdJZtk", "()Ljava/lang/Object;", "closed", "cause", "", "closed-JP2dKIU", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final Object closed-JP2dKIU(@Nullable Throwable throwable0) {
            return ChannelResult.constructor-impl(new Closed(throwable0));
        }

        @NotNull
        public final Object failure-PtdJZtk() {
            return ChannelResult.failed;
        }

        @NotNull
        public final Object success-JP2dKIU(Object object0) {
            return ChannelResult.constructor-impl(object0);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Failed;", "", "<init>", "()V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static class Failed {
        @Override
        @NotNull
        public String toString() {
            return "Failed";
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final Failed failed;
    @Nullable
    private final Object holder;

    static {
        ChannelResult.Companion = new Companion(null);
        ChannelResult.failed = new Failed();
    }

    private ChannelResult(Object object0) {
        this.holder = object0;
    }

    public static final ChannelResult box-impl(Object object0) {
        return new ChannelResult(object0);
    }

    @NotNull
    public static Object constructor-impl(@Nullable Object object0) [...] // Inlined contents

    @Override
    public boolean equals(Object object0) {
        return ChannelResult.equals-impl(this.holder, object0);
    }

    // 去混淆评级： 低(20)
    public static boolean equals-impl(Object object0, Object object1) {
        return object1 instanceof ChannelResult ? q.b(object0, ((ChannelResult)object1).unbox-impl()) : false;
    }

    @Nullable
    public static final Throwable exceptionOrNull-impl(Object object0) {
        Closed channelResult$Closed0 = object0 instanceof Closed ? ((Closed)object0) : null;
        return channelResult$Closed0 == null ? null : channelResult$Closed0.cause;
    }

    @Nullable
    public static final Object getOrNull-impl(Object object0) {
        return object0 instanceof Failed ? null : object0;
    }

    @Override
    public int hashCode() {
        return ChannelResult.hashCode-impl(this.holder);
    }

    public static int hashCode-impl(Object object0) {
        return object0 == null ? 0 : object0.hashCode();
    }

    public static final boolean isClosed-impl(Object object0) {
        return object0 instanceof Closed;
    }

    public static final boolean isSuccess-impl(Object object0) {
        return !(object0 instanceof Failed);
    }

    @Override
    @NotNull
    public String toString() {
        return ChannelResult.toString-impl(this.holder);
    }

    // 去混淆评级： 低(20)
    @NotNull
    public static String toString-impl(Object object0) {
        return object0 instanceof Closed ? ((Closed)object0).toString() : "Value(" + object0 + ')';
    }

    public final Object unbox-impl() {
        return this.holder;
    }
}

