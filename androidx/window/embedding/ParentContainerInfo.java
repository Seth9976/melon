package androidx.window.embedding;

import A7.d;
import android.content.res.Configuration;
import androidx.window.core.Bounds;
import androidx.window.layout.WindowLayoutInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001A\u00020\tHÆ\u0003J1\u0010\u0017\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001B\u001A\u00020\u001CHÖ\u0001J\t\u0010\u001D\u001A\u00020\u001EHÖ\u0001R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u001F"}, d2 = {"Landroidx/window/embedding/ParentContainerInfo;", "", "windowBounds", "Landroidx/window/core/Bounds;", "windowLayoutInfo", "Landroidx/window/layout/WindowLayoutInfo;", "configuration", "Landroid/content/res/Configuration;", "density", "", "(Landroidx/window/core/Bounds;Landroidx/window/layout/WindowLayoutInfo;Landroid/content/res/Configuration;F)V", "getConfiguration", "()Landroid/content/res/Configuration;", "getDensity", "()F", "getWindowBounds", "()Landroidx/window/core/Bounds;", "getWindowLayoutInfo", "()Landroidx/window/layout/WindowLayoutInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ParentContainerInfo {
    @NotNull
    private final Configuration configuration;
    private final float density;
    @NotNull
    private final Bounds windowBounds;
    @NotNull
    private final WindowLayoutInfo windowLayoutInfo;

    public ParentContainerInfo(@NotNull Bounds bounds0, @NotNull WindowLayoutInfo windowLayoutInfo0, @NotNull Configuration configuration0, float f) {
        q.g(bounds0, "windowBounds");
        q.g(windowLayoutInfo0, "windowLayoutInfo");
        q.g(configuration0, "configuration");
        super();
        this.windowBounds = bounds0;
        this.windowLayoutInfo = windowLayoutInfo0;
        this.configuration = configuration0;
        this.density = f;
    }

    @NotNull
    public final Bounds component1() {
        return this.windowBounds;
    }

    @NotNull
    public final WindowLayoutInfo component2() {
        return this.windowLayoutInfo;
    }

    @NotNull
    public final Configuration component3() {
        return this.configuration;
    }

    public final float component4() {
        return this.density;
    }

    @NotNull
    public final ParentContainerInfo copy(@NotNull Bounds bounds0, @NotNull WindowLayoutInfo windowLayoutInfo0, @NotNull Configuration configuration0, float f) {
        q.g(bounds0, "windowBounds");
        q.g(windowLayoutInfo0, "windowLayoutInfo");
        q.g(configuration0, "configuration");
        return new ParentContainerInfo(bounds0, windowLayoutInfo0, configuration0, f);
    }

    public static ParentContainerInfo copy$default(ParentContainerInfo parentContainerInfo0, Bounds bounds0, WindowLayoutInfo windowLayoutInfo0, Configuration configuration0, float f, int v, Object object0) {
        if((v & 1) != 0) {
            bounds0 = parentContainerInfo0.windowBounds;
        }
        if((v & 2) != 0) {
            windowLayoutInfo0 = parentContainerInfo0.windowLayoutInfo;
        }
        if((v & 4) != 0) {
            configuration0 = parentContainerInfo0.configuration;
        }
        if((v & 8) != 0) {
            f = parentContainerInfo0.density;
        }
        return parentContainerInfo0.copy(bounds0, windowLayoutInfo0, configuration0, f);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ParentContainerInfo)) {
            return false;
        }
        if(!q.b(this.windowBounds, ((ParentContainerInfo)object0).windowBounds)) {
            return false;
        }
        if(!q.b(this.windowLayoutInfo, ((ParentContainerInfo)object0).windowLayoutInfo)) {
            return false;
        }
        return q.b(this.configuration, ((ParentContainerInfo)object0).configuration) ? Float.compare(this.density, ((ParentContainerInfo)object0).density) == 0 : false;
    }

    @NotNull
    public final Configuration getConfiguration() {
        return this.configuration;
    }

    public final float getDensity() {
        return this.density;
    }

    @NotNull
    public final Bounds getWindowBounds() {
        return this.windowBounds;
    }

    @NotNull
    public final WindowLayoutInfo getWindowLayoutInfo() {
        return this.windowLayoutInfo;
    }

    @Override
    public int hashCode() {
        return Float.hashCode(this.density) + (this.configuration.hashCode() + (this.windowLayoutInfo.hashCode() + this.windowBounds.hashCode() * 0x1F) * 0x1F) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ParentContainerInfo(windowBounds=");
        stringBuilder0.append(this.windowBounds);
        stringBuilder0.append(", windowLayoutInfo=");
        stringBuilder0.append(this.windowLayoutInfo);
        stringBuilder0.append(", configuration=");
        stringBuilder0.append(this.configuration);
        stringBuilder0.append(", density=");
        return d.m(stringBuilder0, this.density, ')');
    }
}

