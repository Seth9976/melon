package androidx.window.area;

import androidx.window.core.ExperimentalWindowApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalWindowApi
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000E\u001A\u00020\u000FH\u0016J\b\u0010\u0010\u001A\u00020\u0011H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Landroidx/window/area/WindowAreaCapability;", "", "operation", "Landroidx/window/area/WindowAreaCapability$Operation;", "status", "Landroidx/window/area/WindowAreaCapability$Status;", "(Landroidx/window/area/WindowAreaCapability$Operation;Landroidx/window/area/WindowAreaCapability$Status;)V", "getOperation", "()Landroidx/window/area/WindowAreaCapability$Operation;", "getStatus", "()Landroidx/window/area/WindowAreaCapability$Status;", "equals", "", "other", "hashCode", "", "toString", "", "Operation", "Status", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class WindowAreaCapability {
    @ExperimentalWindowApi
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/window/area/WindowAreaCapability$Operation;", "", "description", "", "(Ljava/lang/String;)V", "toString", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Operation {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/window/area/WindowAreaCapability$Operation$Companion;", "", "()V", "OPERATION_PRESENT_ON_AREA", "Landroidx/window/area/WindowAreaCapability$Operation;", "OPERATION_TRANSFER_ACTIVITY_TO_AREA", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
        public static final class Companion {
            private Companion() {
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @NotNull
        public static final Companion Companion;
        @NotNull
        public static final Operation OPERATION_PRESENT_ON_AREA;
        @NotNull
        public static final Operation OPERATION_TRANSFER_ACTIVITY_TO_AREA;
        @NotNull
        private final String description;

        static {
            Operation.Companion = new Companion(null);
            Operation.OPERATION_TRANSFER_ACTIVITY_TO_AREA = new Operation("TRANSFER");
            Operation.OPERATION_PRESENT_ON_AREA = new Operation("PRESENT");
        }

        private Operation(String s) {
            this.description = s;
        }

        @Override
        @NotNull
        public String toString() {
            return this.description;
        }
    }

    @ExperimentalWindowApi
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/window/area/WindowAreaCapability$Status;", "", "description", "", "(Ljava/lang/String;)V", "toString", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Status {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0010\u0010\n\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Landroidx/window/area/WindowAreaCapability$Status$Companion;", "", "()V", "WINDOW_AREA_STATUS_ACTIVE", "Landroidx/window/area/WindowAreaCapability$Status;", "WINDOW_AREA_STATUS_AVAILABLE", "WINDOW_AREA_STATUS_UNAVAILABLE", "WINDOW_AREA_STATUS_UNKNOWN", "getWINDOW_AREA_STATUS_UNKNOWN$window_release", "()Landroidx/window/area/WindowAreaCapability$Status;", "WINDOW_AREA_STATUS_UNSUPPORTED", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
        public static final class androidx.window.area.WindowAreaCapability.Status.Companion {
            private androidx.window.area.WindowAreaCapability.Status.Companion() {
            }

            public androidx.window.area.WindowAreaCapability.Status.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final Status getWINDOW_AREA_STATUS_UNKNOWN$window_release() {
                return Status.WINDOW_AREA_STATUS_UNKNOWN;
            }
        }

        @NotNull
        public static final androidx.window.area.WindowAreaCapability.Status.Companion Companion;
        @NotNull
        public static final Status WINDOW_AREA_STATUS_ACTIVE;
        @NotNull
        public static final Status WINDOW_AREA_STATUS_AVAILABLE;
        @NotNull
        public static final Status WINDOW_AREA_STATUS_UNAVAILABLE;
        @NotNull
        private static final Status WINDOW_AREA_STATUS_UNKNOWN;
        @NotNull
        public static final Status WINDOW_AREA_STATUS_UNSUPPORTED;
        @NotNull
        private final String description;

        static {
            Status.Companion = new androidx.window.area.WindowAreaCapability.Status.Companion(null);
            Status.WINDOW_AREA_STATUS_UNKNOWN = new Status("UNKNOWN");
            Status.WINDOW_AREA_STATUS_UNSUPPORTED = new Status("UNSUPPORTED");
            Status.WINDOW_AREA_STATUS_UNAVAILABLE = new Status("UNAVAILABLE");
            Status.WINDOW_AREA_STATUS_AVAILABLE = new Status("AVAILABLE");
            Status.WINDOW_AREA_STATUS_ACTIVE = new Status("ACTIVE");
        }

        private Status(String s) {
            this.description = s;
        }

        @Override
        @NotNull
        public String toString() {
            return this.description;
        }
    }

    @NotNull
    private final Operation operation;
    @NotNull
    private final Status status;

    public WindowAreaCapability(@NotNull Operation windowAreaCapability$Operation0, @NotNull Status windowAreaCapability$Status0) {
        q.g(windowAreaCapability$Operation0, "operation");
        q.g(windowAreaCapability$Status0, "status");
        super();
        this.operation = windowAreaCapability$Operation0;
        this.status = windowAreaCapability$Status0;
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(@Nullable Object object0) {
        return object0 instanceof WindowAreaCapability && q.b(this.operation, ((WindowAreaCapability)object0).operation) && q.b(this.status, ((WindowAreaCapability)object0).status);
    }

    @NotNull
    public final Operation getOperation() {
        return this.operation;
    }

    @NotNull
    public final Status getStatus() {
        return this.status;
    }

    @Override
    public int hashCode() {
        return this.status.hashCode() + this.operation.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "Operation: " + this.operation + ": Status: " + this.status;
    }
}

