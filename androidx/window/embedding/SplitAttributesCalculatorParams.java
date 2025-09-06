package androidx.window.embedding;

import android.content.res.Configuration;
import androidx.appcompat.app.o;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.WindowMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000E\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\b\u0010\f\u001A\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000EJ\b\u0010\u001A\u001A\u00020\rH\u0016R\u0013\u0010\n\u001A\u00020\u000B8\u0007¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000FR\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0013\u0010\f\u001A\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019¨\u0006\u001B"}, d2 = {"Landroidx/window/embedding/SplitAttributesCalculatorParams;", "", "parentWindowMetrics", "Landroidx/window/layout/WindowMetrics;", "parentConfiguration", "Landroid/content/res/Configuration;", "parentWindowLayoutInfo", "Landroidx/window/layout/WindowLayoutInfo;", "defaultSplitAttributes", "Landroidx/window/embedding/SplitAttributes;", "areDefaultConstraintsSatisfied", "", "splitRuleTag", "", "(Landroidx/window/layout/WindowMetrics;Landroid/content/res/Configuration;Landroidx/window/layout/WindowLayoutInfo;Landroidx/window/embedding/SplitAttributes;ZLjava/lang/String;)V", "()Z", "getDefaultSplitAttributes", "()Landroidx/window/embedding/SplitAttributes;", "getParentConfiguration", "()Landroid/content/res/Configuration;", "getParentWindowLayoutInfo", "()Landroidx/window/layout/WindowLayoutInfo;", "getParentWindowMetrics", "()Landroidx/window/layout/WindowMetrics;", "getSplitRuleTag", "()Ljava/lang/String;", "toString", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class SplitAttributesCalculatorParams {
    private final boolean areDefaultConstraintsSatisfied;
    @NotNull
    private final SplitAttributes defaultSplitAttributes;
    @NotNull
    private final Configuration parentConfiguration;
    @NotNull
    private final WindowLayoutInfo parentWindowLayoutInfo;
    @NotNull
    private final WindowMetrics parentWindowMetrics;
    @Nullable
    private final String splitRuleTag;

    public SplitAttributesCalculatorParams(@NotNull WindowMetrics windowMetrics0, @NotNull Configuration configuration0, @NotNull WindowLayoutInfo windowLayoutInfo0, @NotNull SplitAttributes splitAttributes0, boolean z, @Nullable String s) {
        q.g(windowMetrics0, "parentWindowMetrics");
        q.g(configuration0, "parentConfiguration");
        q.g(windowLayoutInfo0, "parentWindowLayoutInfo");
        q.g(splitAttributes0, "defaultSplitAttributes");
        super();
        this.parentWindowMetrics = windowMetrics0;
        this.parentConfiguration = configuration0;
        this.parentWindowLayoutInfo = windowLayoutInfo0;
        this.defaultSplitAttributes = splitAttributes0;
        this.areDefaultConstraintsSatisfied = z;
        this.splitRuleTag = s;
    }

    public final boolean areDefaultConstraintsSatisfied() {
        return this.areDefaultConstraintsSatisfied;
    }

    @NotNull
    public final SplitAttributes getDefaultSplitAttributes() {
        return this.defaultSplitAttributes;
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

    @Nullable
    public final String getSplitRuleTag() {
        return this.splitRuleTag;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SplitAttributesCalculatorParams:{windowMetrics=");
        stringBuilder0.append(this.parentWindowMetrics);
        stringBuilder0.append(", configuration=");
        stringBuilder0.append(this.parentConfiguration);
        stringBuilder0.append(", windowLayoutInfo=");
        stringBuilder0.append(this.parentWindowLayoutInfo);
        stringBuilder0.append(", defaultSplitAttributes=");
        stringBuilder0.append(this.defaultSplitAttributes);
        stringBuilder0.append(", areDefaultConstraintsSatisfied=");
        stringBuilder0.append(this.areDefaultConstraintsSatisfied);
        stringBuilder0.append(", tag=");
        return o.r(stringBuilder0, this.splitRuleTag, '}');
    }
}

