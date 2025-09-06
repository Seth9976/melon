package androidx.window.core.layout;

import ie.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@d
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000B2\u00020\u0001:\u0001\u000BB\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001A\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\b\u001A\u00020\u0003H\u0016J\b\u0010\t\u001A\u00020\nH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/window/core/layout/WindowWidthSizeClass;", "", "rawValue", "", "(I)V", "equals", "", "other", "hashCode", "toString", "", "Companion", "window-core"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class WindowWidthSizeClass {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\n\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\fH\u0001¢\u0006\u0002\b\rR\u0016\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0016\u0010\b\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002¨\u0006\u000E"}, d2 = {"Landroidx/window/core/layout/WindowWidthSizeClass$Companion;", "", "()V", "COMPACT", "Landroidx/window/core/layout/WindowWidthSizeClass;", "getCOMPACT$annotations", "EXPANDED", "getEXPANDED$annotations", "MEDIUM", "getMEDIUM$annotations", "compute", "dpWidth", "", "compute$window_core", "window-core"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @d
        @NotNull
        public final WindowWidthSizeClass compute$window_core(float f) {
            if(f < 0.0f) {
                throw new IllegalArgumentException(("Width must be positive, received " + f).toString());
            }
            if(f < 600.0f) {
                return WindowWidthSizeClass.COMPACT;
            }
            return f < 840.0f ? WindowWidthSizeClass.MEDIUM : WindowWidthSizeClass.EXPANDED;
        }

        @d
        public static void getCOMPACT$annotations() {
        }

        @d
        public static void getEXPANDED$annotations() {
        }

        @d
        public static void getMEDIUM$annotations() {
        }
    }

    @NotNull
    public static final WindowWidthSizeClass COMPACT;
    @NotNull
    public static final Companion Companion;
    @NotNull
    public static final WindowWidthSizeClass EXPANDED;
    @NotNull
    public static final WindowWidthSizeClass MEDIUM;
    private final int rawValue;

    static {
        WindowWidthSizeClass.Companion = new Companion(null);
        WindowWidthSizeClass.COMPACT = new WindowWidthSizeClass(0);
        WindowWidthSizeClass.MEDIUM = new WindowWidthSizeClass(1);
        WindowWidthSizeClass.EXPANDED = new WindowWidthSizeClass(2);
    }

    private WindowWidthSizeClass(int v) {
        this.rawValue = v;
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 == null) {
            return false;
        }
        Class class0 = object0.getClass();
        return WindowWidthSizeClass.class == class0 ? this.rawValue == ((WindowWidthSizeClass)object0).rawValue : false;
    }

    @Override
    public int hashCode() {
        return this.rawValue;
    }

    @Override
    @NotNull
    public String toString() {
        if(this.equals(WindowWidthSizeClass.COMPACT)) {
            return "WindowWidthSizeClass: COMPACT";
        }
        if(this.equals(WindowWidthSizeClass.MEDIUM)) {
            return "WindowWidthSizeClass: MEDIUM";
        }
        return this.equals(WindowWidthSizeClass.EXPANDED) ? "WindowWidthSizeClass: EXPANDED" : "WindowWidthSizeClass: UNKNOWN";
    }
}

