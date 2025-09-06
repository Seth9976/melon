package androidx.window.embedding;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B#\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0086\u0002J\b\u0010\u0013\u001A\u00020\u0003H\u0016R\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u0014"}, d2 = {"Landroidx/window/embedding/OverlayInfo;", "", "overlayTag", "", "currentOverlayAttributes", "Landroidx/window/embedding/OverlayAttributes;", "activityStack", "Landroidx/window/embedding/ActivityStack;", "(Ljava/lang/String;Landroidx/window/embedding/OverlayAttributes;Landroidx/window/embedding/ActivityStack;)V", "getActivityStack", "()Landroidx/window/embedding/ActivityStack;", "getCurrentOverlayAttributes", "()Landroidx/window/embedding/OverlayAttributes;", "getOverlayTag", "()Ljava/lang/String;", "contains", "", "activity", "Landroid/app/Activity;", "toString", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class OverlayInfo {
    @Nullable
    private final ActivityStack activityStack;
    @Nullable
    private final OverlayAttributes currentOverlayAttributes;
    @NotNull
    private final String overlayTag;

    public OverlayInfo(@NotNull String s, @Nullable OverlayAttributes overlayAttributes0, @Nullable ActivityStack activityStack0) {
        q.g(s, "overlayTag");
        super();
        this.overlayTag = s;
        this.currentOverlayAttributes = overlayAttributes0;
        this.activityStack = activityStack0;
    }

    public final boolean contains(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        return this.activityStack == null ? false : this.activityStack.contains(activity0);
    }

    @Nullable
    public final ActivityStack getActivityStack() {
        return this.activityStack;
    }

    @Nullable
    public final OverlayAttributes getCurrentOverlayAttributes() {
        return this.currentOverlayAttributes;
    }

    @NotNull
    public final String getOverlayTag() {
        return this.overlayTag;
    }

    @Override
    @NotNull
    public String toString() {
        return "OverlayInfo: {tag=" + this.overlayTag + ", currentOverlayAttrs=" + this.currentOverlayAttributes + ", activityStack=" + this.activityStack + '}';
    }
}

