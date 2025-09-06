package androidx.window.layout;

import A7.d;
import android.graphics.Rect;
import androidx.window.core.Bounds;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0000\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\tJ\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001A\u00020\u0016H\u0016J\b\u0010\u0017\u001A\u00020\u0018H\u0016R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u000E\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\rR\u0011\u0010\u0010\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u0011\u0010\r¨\u0006\u0019"}, d2 = {"Landroidx/window/layout/WindowMetrics;", "", "bounds", "Landroid/graphics/Rect;", "density", "", "(Landroid/graphics/Rect;F)V", "_bounds", "Landroidx/window/core/Bounds;", "(Landroidx/window/core/Bounds;F)V", "getBounds", "()Landroid/graphics/Rect;", "getDensity", "()F", "heightDp", "getHeightDp", "widthDp", "getWidthDp", "equals", "", "other", "hashCode", "", "toString", "", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class WindowMetrics {
    @NotNull
    private final Bounds _bounds;
    private final float density;

    public WindowMetrics(@NotNull Rect rect0, float f) {
        q.g(rect0, "bounds");
        this(new Bounds(rect0), f);
    }

    public WindowMetrics(@NotNull Bounds bounds0, float f) {
        q.g(bounds0, "_bounds");
        super();
        this._bounds = bounds0;
        this.density = f;
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        Class class0 = object0 == null ? null : object0.getClass();
        if(!WindowMetrics.class.equals(class0)) {
            return false;
        }
        q.e(object0, "null cannot be cast to non-null type androidx.window.layout.WindowMetrics");
        return q.b(this._bounds, ((WindowMetrics)object0)._bounds) ? this.density == ((WindowMetrics)object0).density : false;
    }

    @NotNull
    public final Rect getBounds() {
        return this._bounds.toRect();
    }

    public final float getDensity() {
        return this.density;
    }

    public final float getHeightDp() {
        return ((float)this.getBounds().height()) / this.density;
    }

    public final float getWidthDp() {
        return ((float)this.getBounds().width()) / this.density;
    }

    @Override
    public int hashCode() {
        return Float.hashCode(this.density) + this._bounds.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("WindowMetrics(_bounds=");
        stringBuilder0.append(this._bounds);
        stringBuilder0.append(", density=");
        return d.m(stringBuilder0, this.density, ')');
    }
}

