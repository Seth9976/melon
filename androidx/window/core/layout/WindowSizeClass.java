package androidx.window.core.layout;

import androidx.appcompat.app.o;
import e.k;
import ie.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import je.p;
import je.q;
import je.u;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0002\u0010\u0005B\u0015\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0002\u0010\tJ\u0013\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001B\u001A\u00020\u0007H\u0016J\u0016\u0010\u001C\u001A\u00020\u00192\u0006\u0010\u001D\u001A\u00020\u00072\u0006\u0010\u001E\u001A\u00020\u0007J\u000E\u0010\u001F\u001A\u00020\u00192\u0006\u0010\u001E\u001A\u00020\u0007J\u000E\u0010 \u001A\u00020\u00192\u0006\u0010\u001D\u001A\u00020\u0007J\b\u0010!\u001A\u00020\"H\u0016R\u0011\u0010\b\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000BR\u001A\u0010\r\u001A\u00020\u000E8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0013\u001A\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0010\u001A\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Landroidx/window/core/layout/WindowSizeClass;", "", "widthDp", "", "heightDp", "(FF)V", "minWidthDp", "", "minHeightDp", "(II)V", "getMinHeightDp", "()I", "getMinWidthDp", "windowHeightSizeClass", "Landroidx/window/core/layout/WindowHeightSizeClass;", "getWindowHeightSizeClass$annotations", "()V", "getWindowHeightSizeClass", "()Landroidx/window/core/layout/WindowHeightSizeClass;", "windowWidthSizeClass", "Landroidx/window/core/layout/WindowWidthSizeClass;", "getWindowWidthSizeClass$annotations", "getWindowWidthSizeClass", "()Landroidx/window/core/layout/WindowWidthSizeClass;", "equals", "", "other", "hashCode", "isAtLeastBreakpoint", "widthDpBreakpoint", "heightDpBreakpoint", "isHeightAtLeastBreakpoint", "isWidthAtLeastBreakpoint", "toString", "", "Companion", "window-core"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class WindowSizeClass {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0010H\u0007R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/window/core/layout/WindowSizeClass$Companion;", "", "()V", "BREAKPOINTS_V1", "", "Landroidx/window/core/layout/WindowSizeClass;", "HEIGHT_DP_BREAKPOINTS_V1", "", "", "HEIGHT_DP_EXPANDED_LOWER_BOUND", "HEIGHT_DP_MEDIUM_LOWER_BOUND", "WIDTH_DP_BREAKPOINTS_V1", "WIDTH_DP_EXPANDED_LOWER_BOUND", "WIDTH_DP_MEDIUM_LOWER_BOUND", "compute", "dpWidth", "", "dpHeight", "window-core"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @d
        @NotNull
        public final WindowSizeClass compute(float f, float f1) {
            int v1;
            int v = 0;
            if(Float.compare(f, 840.0f) >= 0) {
                v1 = 840;
            }
            else {
                v1 = f >= 600.0f ? 600 : 0;
            }
            if(f1 >= 900.0f) {
                return new WindowSizeClass(v1, 900);
            }
            if(f1 >= 480.0f) {
                v = 480;
            }
            return new WindowSizeClass(v1, v);
        }
    }

    @NotNull
    public static final Set BREAKPOINTS_V1 = null;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final List HEIGHT_DP_BREAKPOINTS_V1 = null;
    public static final int HEIGHT_DP_EXPANDED_LOWER_BOUND = 900;
    public static final int HEIGHT_DP_MEDIUM_LOWER_BOUND = 480;
    @NotNull
    private static final List WIDTH_DP_BREAKPOINTS_V1 = null;
    public static final int WIDTH_DP_EXPANDED_LOWER_BOUND = 840;
    public static final int WIDTH_DP_MEDIUM_LOWER_BOUND = 600;
    private final int minHeightDp;
    private final int minWidthDp;

    static {
        WindowSizeClass.Companion = new Companion(null);
        List list0 = k.A(new Integer[]{0, 600, 840});
        WindowSizeClass.WIDTH_DP_BREAKPOINTS_V1 = list0;
        WindowSizeClass.HEIGHT_DP_BREAKPOINTS_V1 = k.A(new Integer[]{0, 480, 900});
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            int v = ((Number)object0).intValue();
            ArrayList arrayList1 = new ArrayList(q.Q(10, WindowSizeClass.HEIGHT_DP_BREAKPOINTS_V1));
            for(Object object1: WindowSizeClass.HEIGHT_DP_BREAKPOINTS_V1) {
                arrayList1.add(new WindowSizeClass(v, ((Number)object1).intValue()));
            }
            u.U(arrayList0, arrayList1);
        }
        WindowSizeClass.BREAKPOINTS_V1 = p.T0(arrayList0);
    }

    public WindowSizeClass(float f, float f1) {
        this(((int)f), ((int)f1));
    }

    public WindowSizeClass(int v, int v1) {
        this.minWidthDp = v;
        this.minHeightDp = v1;
        if(v < 0) {
            throw new IllegalArgumentException(("Expected minWidthDp to be at least 0, minWidthDp: " + v + '.').toString());
        }
        if(v1 < 0) {
            throw new IllegalArgumentException(("Expected minHeightDp to be at least 0, minHeightDp: " + v1 + '.').toString());
        }
    }

    @d
    @NotNull
    public static final WindowSizeClass compute(float f, float f1) {
        return WindowSizeClass.Companion.compute(f, f1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return WindowSizeClass.class == class0 && this.minWidthDp == ((WindowSizeClass)object0).minWidthDp ? this.minHeightDp == ((WindowSizeClass)object0).minHeightDp : false;
        }
        return false;
    }

    public final int getMinHeightDp() {
        return this.minHeightDp;
    }

    public final int getMinWidthDp() {
        return this.minWidthDp;
    }

    @NotNull
    public final WindowHeightSizeClass getWindowHeightSizeClass() {
        return WindowHeightSizeClass.Companion.compute$window_core(((float)this.minHeightDp));
    }

    @d
    public static void getWindowHeightSizeClass$annotations() {
    }

    @NotNull
    public final WindowWidthSizeClass getWindowWidthSizeClass() {
        return WindowWidthSizeClass.Companion.compute$window_core(((float)this.minWidthDp));
    }

    @d
    public static void getWindowWidthSizeClass$annotations() {
    }

    @Override
    public int hashCode() {
        return this.minWidthDp * 0x1F + this.minHeightDp;
    }

    // 去混淆评级： 低(20)
    public final boolean isAtLeastBreakpoint(int v, int v1) {
        return this.isWidthAtLeastBreakpoint(v) && this.isHeightAtLeastBreakpoint(v1);
    }

    public final boolean isHeightAtLeastBreakpoint(int v) {
        return this.minHeightDp >= v;
    }

    public final boolean isWidthAtLeastBreakpoint(int v) {
        return this.minWidthDp >= v;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("WindowSizeClass(minWidthDp=");
        stringBuilder0.append(this.minWidthDp);
        stringBuilder0.append(", minHeightDp=");
        return o.q(stringBuilder0, this.minHeightDp, ')');
    }
}

