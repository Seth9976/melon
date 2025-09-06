package androidx.window.embedding;

import android.content.res.Configuration;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.WindowMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B/\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0002\u0010\fJ\b\u0010\u0017\u001A\u00020\tH\u0016R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Landroidx/window/embedding/OverlayAttributesCalculatorParams;", "", "parentWindowMetrics", "Landroidx/window/layout/WindowMetrics;", "parentConfiguration", "Landroid/content/res/Configuration;", "parentWindowLayoutInfo", "Landroidx/window/layout/WindowLayoutInfo;", "overlayTag", "", "defaultOverlayAttributes", "Landroidx/window/embedding/OverlayAttributes;", "(Landroidx/window/layout/WindowMetrics;Landroid/content/res/Configuration;Landroidx/window/layout/WindowLayoutInfo;Ljava/lang/String;Landroidx/window/embedding/OverlayAttributes;)V", "getDefaultOverlayAttributes", "()Landroidx/window/embedding/OverlayAttributes;", "getOverlayTag", "()Ljava/lang/String;", "getParentConfiguration", "()Landroid/content/res/Configuration;", "getParentWindowLayoutInfo", "()Landroidx/window/layout/WindowLayoutInfo;", "getParentWindowMetrics", "()Landroidx/window/layout/WindowMetrics;", "toString", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class OverlayAttributesCalculatorParams {
    @NotNull
    private final OverlayAttributes defaultOverlayAttributes;
    @NotNull
    private final String overlayTag;
    @NotNull
    private final Configuration parentConfiguration;
    @NotNull
    private final WindowLayoutInfo parentWindowLayoutInfo;
    @NotNull
    private final WindowMetrics parentWindowMetrics;

    public OverlayAttributesCalculatorParams(@NotNull WindowMetrics windowMetrics0, @NotNull Configuration configuration0, @NotNull WindowLayoutInfo windowLayoutInfo0, @NotNull String s, @NotNull OverlayAttributes overlayAttributes0) {
        q.g(windowMetrics0, "parentWindowMetrics");
        q.g(configuration0, "parentConfiguration");
        q.g(windowLayoutInfo0, "parentWindowLayoutInfo");
        q.g(s, "overlayTag");
        q.g(overlayAttributes0, "defaultOverlayAttributes");
        super();
        this.parentWindowMetrics = windowMetrics0;
        this.parentConfiguration = configuration0;
        this.parentWindowLayoutInfo = windowLayoutInfo0;
        this.overlayTag = s;
        this.defaultOverlayAttributes = overlayAttributes0;
    }

    @NotNull
    public final OverlayAttributes getDefaultOverlayAttributes() {
        return this.defaultOverlayAttributes;
    }

    @NotNull
    public final String getOverlayTag() {
        return this.overlayTag;
    }

    @NotNull
    public final Configuration getParentConfiguration() {
        return this.parentConfiguration;
    }

    @NotNull
    public final WindowLayoutInfo getParentWindowLayoutInfo() {
        return this.parentWindowLayoutInfo;
    }

    @NotNull
    public final WindowMetrics getParentWindowMetrics() {
        return this.parentWindowMetrics;
    }

    @Override
    @NotNull
    public String toString() {
        return OverlayAttributesCalculatorParams.class + ":{parentWindowMetrics=" + this.parentWindowMetrics + "parentConfiguration=" + this.parentConfiguration + "parentWindowLayoutInfo=" + this.parentWindowLayoutInfo + "overlayTag=" + this.overlayTag + "defaultOverlayAttributes=" + this.defaultOverlayAttributes;
    }
}

