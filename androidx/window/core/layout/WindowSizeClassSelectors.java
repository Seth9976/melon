package androidx.window.core.layout;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001A \u0010\u0000\u001A\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0004\u001A \u0010\u0000\u001A\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0003\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0006\u001A \u0010\u0007\u001A\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0003\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\b"}, d2 = {"computeWindowSizeClass", "Landroidx/window/core/layout/WindowSizeClass;", "", "widthDp", "", "heightDp", "", "computeWindowSizeClassPreferHeight", "window-core"}, k = 2, mv = {1, 9, 0}, xi = 0x30)
public final class WindowSizeClassSelectors {
    @NotNull
    public static final WindowSizeClass computeWindowSizeClass(@NotNull Set set0, float f, float f1) {
        q.g(set0, "<this>");
        return WindowSizeClassSelectors.computeWindowSizeClass(set0, ((int)f), ((int)f1));
    }

    @NotNull
    public static final WindowSizeClass computeWindowSizeClass(@NotNull Set set0, int v, int v1) {
        q.g(set0, "<this>");
        int v2 = 0;
        for(Object object0: set0) {
            WindowSizeClass windowSizeClass0 = (WindowSizeClass)object0;
            if(windowSizeClass0.getMinWidthDp() <= v && windowSizeClass0.getMinWidthDp() > v2) {
                v2 = windowSizeClass0.getMinWidthDp();
            }
        }
        WindowSizeClass windowSizeClass1 = new WindowSizeClass(0, 0);
        for(Object object1: set0) {
            WindowSizeClass windowSizeClass2 = (WindowSizeClass)object1;
            if(windowSizeClass2.getMinWidthDp() == v2 && windowSizeClass2.getMinHeightDp() <= v1 && windowSizeClass1.getMinHeightDp() <= windowSizeClass2.getMinHeightDp()) {
                windowSizeClass1 = windowSizeClass2;
            }
        }
        return windowSizeClass1;
    }

    @NotNull
    public static final WindowSizeClass computeWindowSizeClassPreferHeight(@NotNull Set set0, int v, int v1) {
        q.g(set0, "<this>");
        int v2 = 0;
        for(Object object0: set0) {
            WindowSizeClass windowSizeClass0 = (WindowSizeClass)object0;
            if(windowSizeClass0.getMinHeightDp() <= v1 && windowSizeClass0.getMinHeightDp() > v2) {
                v2 = windowSizeClass0.getMinHeightDp();
            }
        }
        WindowSizeClass windowSizeClass1 = new WindowSizeClass(0, 0);
        for(Object object1: set0) {
            WindowSizeClass windowSizeClass2 = (WindowSizeClass)object1;
            if(windowSizeClass2.getMinHeightDp() == v2 && windowSizeClass2.getMinWidthDp() <= v && windowSizeClass1.getMinWidthDp() <= windowSizeClass2.getMinWidthDp()) {
                windowSizeClass1 = windowSizeClass2;
            }
        }
        return windowSizeClass1;
    }
}

