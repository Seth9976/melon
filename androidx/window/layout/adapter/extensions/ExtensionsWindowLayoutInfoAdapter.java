package androidx.window.layout.adapter.extensions;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import androidx.window.core.Bounds;
import androidx.window.extensions.layout.DisplayFeature;
import androidx.window.extensions.layout.DisplayFoldFeature;
import androidx.window.extensions.layout.SupportedWindowFeatures;
import androidx.window.layout.FoldingFeature.State;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.HardwareFoldingFeature.Type;
import androidx.window.layout.HardwareFoldingFeature;
import androidx.window.layout.SupportedPosture;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.WindowMetrics;
import androidx.window.layout.WindowMetricsCalculatorCompat;
import e.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001D\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0000¢\u0006\u0002\b\tJ\u001B\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\u0006\u0010\f\u001A\u00020\rH\u0000¢\u0006\u0002\b\tJ\u001F\u0010\u0003\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0000¢\u0006\u0002\b\tJ\u001D\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0007\u001A\u00020\bH\u0000¢\u0006\u0002\b\tJ\u0018\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u00020\u0016H\u0002¨\u0006\u0017"}, d2 = {"Landroidx/window/layout/adapter/extensions/ExtensionsWindowLayoutInfoAdapter;", "", "()V", "translate", "Landroidx/window/layout/WindowLayoutInfo;", "context", "Landroid/content/Context;", "info", "Landroidx/window/extensions/layout/WindowLayoutInfo;", "translate$window_release", "", "Landroidx/window/layout/SupportedPosture;", "features", "Landroidx/window/extensions/layout/SupportedWindowFeatures;", "Landroidx/window/layout/FoldingFeature;", "windowMetrics", "Landroidx/window/layout/WindowMetrics;", "oemFeature", "Landroidx/window/extensions/layout/FoldingFeature;", "validBounds", "", "bounds", "Landroidx/window/core/Bounds;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ExtensionsWindowLayoutInfoAdapter {
    @NotNull
    public static final ExtensionsWindowLayoutInfoAdapter INSTANCE;

    static {
        ExtensionsWindowLayoutInfoAdapter.INSTANCE = new ExtensionsWindowLayoutInfoAdapter();
    }

    @Nullable
    public final FoldingFeature translate$window_release(@NotNull WindowMetrics windowMetrics0, @NotNull androidx.window.extensions.layout.FoldingFeature foldingFeature0) {
        State foldingFeature$State0;
        Type hardwareFoldingFeature$Type0;
        q.g(windowMetrics0, "windowMetrics");
        q.g(foldingFeature0, "oemFeature");
        switch(foldingFeature0.getType()) {
            case 1: {
                hardwareFoldingFeature$Type0 = Type.Companion.getFOLD();
                break;
            }
            case 2: {
                hardwareFoldingFeature$Type0 = Type.Companion.getHINGE();
                break;
            }
            default: {
                return null;
            }
        }
        switch(foldingFeature0.getState()) {
            case 1: {
                foldingFeature$State0 = State.FLAT;
                break;
            }
            case 2: {
                foldingFeature$State0 = State.HALF_OPENED;
                break;
            }
            default: {
                return null;
            }
        }
        Rect rect0 = foldingFeature0.getBounds();
        q.f(rect0, "getBounds(...)");
        if(this.validBounds(windowMetrics0, new Bounds(rect0))) {
            Rect rect1 = foldingFeature0.getBounds();
            q.f(rect1, "getBounds(...)");
            return new HardwareFoldingFeature(new Bounds(rect1), hardwareFoldingFeature$Type0, foldingFeature$State0);
        }
        return null;
    }

    @NotNull
    public final WindowLayoutInfo translate$window_release(@NotNull Context context0, @NotNull androidx.window.extensions.layout.WindowLayoutInfo windowLayoutInfo0) {
        q.g(context0, "context");
        q.g(windowLayoutInfo0, "info");
        WindowMetricsCalculatorCompat windowMetricsCalculatorCompat0 = new WindowMetricsCalculatorCompat(null, 1, null);
        int v = Build.VERSION.SDK_INT;
        if(v >= 30) {
            return this.translate$window_release(windowMetricsCalculatorCompat0.computeCurrentWindowMetrics(context0), windowLayoutInfo0);
        }
        if(v < 29 || !(context0 instanceof Activity)) {
            throw new UnsupportedOperationException("Display Features are only supported after Q. Display features for non-Activity contexts are not expected to be reported on devices running Q.");
        }
        return this.translate$window_release(windowMetricsCalculatorCompat0.computeCurrentWindowMetrics(((Activity)context0)), windowLayoutInfo0);
    }

    @NotNull
    public final WindowLayoutInfo translate$window_release(@NotNull WindowMetrics windowMetrics0, @NotNull androidx.window.extensions.layout.WindowLayoutInfo windowLayoutInfo0) {
        FoldingFeature foldingFeature0;
        q.g(windowMetrics0, "windowMetrics");
        q.g(windowLayoutInfo0, "info");
        List list0 = windowLayoutInfo0.getDisplayFeatures();
        q.f(list0, "getDisplayFeatures(...)");
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            DisplayFeature displayFeature0 = (DisplayFeature)object0;
            if(displayFeature0 instanceof androidx.window.extensions.layout.FoldingFeature) {
                q.d(displayFeature0);
                foldingFeature0 = ExtensionsWindowLayoutInfoAdapter.INSTANCE.translate$window_release(windowMetrics0, ((androidx.window.extensions.layout.FoldingFeature)displayFeature0));
            }
            else {
                foldingFeature0 = null;
            }
            if(foldingFeature0 != null) {
                arrayList0.add(foldingFeature0);
            }
        }
        return new WindowLayoutInfo(arrayList0);
    }

    @NotNull
    public final List translate$window_release(@NotNull SupportedWindowFeatures supportedWindowFeatures0) {
        q.g(supportedWindowFeatures0, "features");
        List list0 = supportedWindowFeatures0.getDisplayFoldFeatures();
        q.f(list0, "getDisplayFoldFeatures(...)");
        if(!(list0 instanceof Collection) || !list0.isEmpty()) {
            for(Object object0: list0) {
                if(((DisplayFoldFeature)object0).hasProperties(new int[]{1})) {
                    return k.z(SupportedPosture.TABLETOP);
                }
                if(false) {
                    break;
                }
            }
        }
        return w.a;
    }

    private final boolean validBounds(WindowMetrics windowMetrics0, Bounds bounds0) {
        Rect rect0 = windowMetrics0.getBounds();
        if(bounds0.isZero()) {
            return false;
        }
        if(bounds0.getWidth() != rect0.width() && bounds0.getHeight() != rect0.height()) {
            return false;
        }
        return bounds0.getWidth() >= rect0.width() || bounds0.getHeight() >= rect0.height() ? bounds0.getWidth() != rect0.width() || bounds0.getHeight() != rect0.height() : false;
    }
}

