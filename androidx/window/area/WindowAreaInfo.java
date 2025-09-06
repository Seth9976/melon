package androidx.window.area;

import android.os.Binder;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.core.ExtensionsUtil;
import androidx.window.extensions.area.ExtensionWindowAreaPresentation;
import androidx.window.extensions.area.WindowAreaComponent;
import androidx.window.layout.WindowMetrics;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalWindowApi
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001&B\'\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\rH\u0002J\u0013\u0010\u001D\u001A\u00020\u001E2\b\u0010\u001F\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\u0010\u0010 \u001A\u0004\u0018\u00010\u001B2\u0006\u0010\u001C\u001A\u00020\rJ\u000E\u0010!\u001A\u00020\u000E2\u0006\u0010\u001C\u001A\u00020\rJ\b\u0010\"\u001A\u00020#H\u0016J\b\u0010$\u001A\u00020%H\u0016R0\u0010\u000B\u001A\u001E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E0\fj\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E`\u000FX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\'"}, d2 = {"Landroidx/window/area/WindowAreaInfo;", "", "metrics", "Landroidx/window/layout/WindowMetrics;", "type", "Landroidx/window/area/WindowAreaInfo$Type;", "token", "Landroid/os/Binder;", "windowAreaComponent", "Landroidx/window/extensions/area/WindowAreaComponent;", "(Landroidx/window/layout/WindowMetrics;Landroidx/window/area/WindowAreaInfo$Type;Landroid/os/Binder;Landroidx/window/extensions/area/WindowAreaComponent;)V", "capabilityMap", "Ljava/util/HashMap;", "Landroidx/window/area/WindowAreaCapability$Operation;", "Landroidx/window/area/WindowAreaCapability;", "Lkotlin/collections/HashMap;", "getCapabilityMap$window_release", "()Ljava/util/HashMap;", "getMetrics", "()Landroidx/window/layout/WindowMetrics;", "setMetrics", "(Landroidx/window/layout/WindowMetrics;)V", "getToken", "()Landroid/os/Binder;", "getType", "()Landroidx/window/area/WindowAreaInfo$Type;", "createRearFacingSession", "Landroidx/window/area/WindowAreaSession;", "operation", "equals", "", "other", "getActiveSession", "getCapability", "hashCode", "", "toString", "", "Type", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class WindowAreaInfo {
    @ExperimentalWindowApi
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/window/area/WindowAreaInfo$Type;", "", "description", "", "(Ljava/lang/String;)V", "toString", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Type {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/window/area/WindowAreaInfo$Type$Companion;", "", "()V", "TYPE_REAR_FACING", "Landroidx/window/area/WindowAreaInfo$Type;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
        public static final class Companion {
            private Companion() {
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @NotNull
        public static final Companion Companion;
        @NotNull
        public static final Type TYPE_REAR_FACING;
        @NotNull
        private final String description;

        static {
            Type.Companion = new Companion(null);
            Type.TYPE_REAR_FACING = new Type("REAR FACING");
        }

        private Type(String s) {
            this.description = s;
        }

        @Override
        @NotNull
        public String toString() {
            return this.description;
        }
    }

    @NotNull
    private final HashMap capabilityMap;
    @NotNull
    private WindowMetrics metrics;
    @NotNull
    private final Binder token;
    @NotNull
    private final Type type;
    @NotNull
    private final WindowAreaComponent windowAreaComponent;

    public WindowAreaInfo(@NotNull WindowMetrics windowMetrics0, @NotNull Type windowAreaInfo$Type0, @NotNull Binder binder0, @NotNull WindowAreaComponent windowAreaComponent0) {
        q.g(windowMetrics0, "metrics");
        q.g(windowAreaInfo$Type0, "type");
        q.g(binder0, "token");
        q.g(windowAreaComponent0, "windowAreaComponent");
        super();
        this.metrics = windowMetrics0;
        this.type = windowAreaInfo$Type0;
        this.token = binder0;
        this.windowAreaComponent = windowAreaComponent0;
        this.capabilityMap = new HashMap();
    }

    private final WindowAreaSession createRearFacingSession(Operation windowAreaCapability$Operation0) {
        if(q.b(windowAreaCapability$Operation0, Operation.OPERATION_TRANSFER_ACTIVITY_TO_AREA)) {
            return new RearDisplaySessionImpl(this.windowAreaComponent);
        }
        if(!q.b(windowAreaCapability$Operation0, Operation.OPERATION_PRESENT_ON_AREA)) {
            throw new IllegalArgumentException("Invalid operation provided");
        }
        ExtensionWindowAreaPresentation extensionWindowAreaPresentation0 = this.windowAreaComponent.getRearDisplayPresentation();
        q.d(extensionWindowAreaPresentation0);
        int v = ExtensionsUtil.INSTANCE.getSafeVendorApiLevel();
        return new RearDisplayPresentationSessionPresenterImpl(this.windowAreaComponent, extensionWindowAreaPresentation0, v);
    }

    // 去混淆评级： 低(40)
    @Override
    public boolean equals(@Nullable Object object0) {
        return object0 instanceof WindowAreaInfo && q.b(this.metrics, ((WindowAreaInfo)object0).metrics) && q.b(this.type, ((WindowAreaInfo)object0).type) && q.b(this.capabilityMap.entrySet(), ((WindowAreaInfo)object0).capabilityMap.entrySet());
    }

    @Nullable
    public final WindowAreaSession getActiveSession(@NotNull Operation windowAreaCapability$Operation0) {
        q.g(windowAreaCapability$Operation0, "operation");
        if(!q.b(this.getCapability(windowAreaCapability$Operation0).getStatus(), Status.WINDOW_AREA_STATUS_ACTIVE)) {
            throw new IllegalStateException("No session is currently active");
        }
        return q.b(this.type, Type.TYPE_REAR_FACING) ? this.createRearFacingSession(windowAreaCapability$Operation0) : null;
    }

    @NotNull
    public final WindowAreaCapability getCapability(@NotNull Operation windowAreaCapability$Operation0) {
        q.g(windowAreaCapability$Operation0, "operation");
        WindowAreaCapability windowAreaCapability0 = (WindowAreaCapability)this.capabilityMap.get(windowAreaCapability$Operation0);
        return windowAreaCapability0 == null ? new WindowAreaCapability(windowAreaCapability$Operation0, Status.WINDOW_AREA_STATUS_UNSUPPORTED) : windowAreaCapability0;
    }

    @NotNull
    public final HashMap getCapabilityMap$window_release() {
        return this.capabilityMap;
    }

    @NotNull
    public final WindowMetrics getMetrics() {
        return this.metrics;
    }

    @NotNull
    public final Binder getToken() {
        return this.token;
    }

    @NotNull
    public final Type getType() {
        return this.type;
    }

    @Override
    public int hashCode() {
        int v = this.metrics.hashCode();
        return this.capabilityMap.entrySet().hashCode() + (this.type.hashCode() + v * 0x1F) * 0x1F;
    }

    public final void setMetrics(@NotNull WindowMetrics windowMetrics0) {
        q.g(windowMetrics0, "<set-?>");
        this.metrics = windowMetrics0;
    }

    @Override
    @NotNull
    public String toString() {
        return "WindowAreaInfo{ Metrics: " + this.metrics + ", type: " + this.type + ", Capabilities: " + this.capabilityMap.entrySet() + " }";
    }
}

