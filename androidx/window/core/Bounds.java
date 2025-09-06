package androidx.window.core;

import U4.x;
import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001E2\u00020\u0001:\u0001\u001EB\u000F\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004B%\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\b\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\u0006¢\u0006\u0002\u0010\nJ\u0013\u0010\u0018\u001A\u00020\u00102\b\u0010\u0019\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001A\u001A\u00020\u0006H\u0016J\u0006\u0010\u001B\u001A\u00020\u0003J\b\u0010\u001C\u001A\u00020\u001DH\u0016R\u0011\u0010\t\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\r\u001A\u00020\u00068F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\fR\u0011\u0010\u000F\u001A\u00020\u00108F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0011R\u0011\u0010\u0012\u001A\u00020\u00108F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\fR\u0011\u0010\b\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\fR\u0011\u0010\u0007\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\fR\u0011\u0010\u0016\u001A\u00020\u00068F¢\u0006\u0006\u001A\u0004\b\u0017\u0010\f¨\u0006\u001F"}, d2 = {"Landroidx/window/core/Bounds;", "", "rect", "Landroid/graphics/Rect;", "(Landroid/graphics/Rect;)V", "left", "", "top", "right", "bottom", "(IIII)V", "getBottom", "()I", "height", "getHeight", "isEmpty", "", "()Z", "isZero", "getLeft", "getRight", "getTop", "width", "getWidth", "equals", "other", "hashCode", "toRect", "toString", "", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class Bounds {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/window/core/Bounds$Companion;", "", "()V", "EMPTY_BOUNDS", "Landroidx/window/core/Bounds;", "getEMPTY_BOUNDS", "()Landroidx/window/core/Bounds;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final Bounds getEMPTY_BOUNDS() {
            return Bounds.EMPTY_BOUNDS;
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final Bounds EMPTY_BOUNDS;
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    static {
        Bounds.Companion = new Companion(null);
        Bounds.EMPTY_BOUNDS = new Bounds(0, 0, 0, 0);
    }

    public Bounds(int v, int v1, int v2, int v3) {
        this.left = v;
        this.top = v1;
        this.right = v2;
        this.bottom = v3;
        if(v > v2) {
            throw new IllegalArgumentException(("Left must be less than or equal to right, left: " + v + ", right: " + v2).toString());
        }
        if(v1 > v3) {
            throw new IllegalArgumentException(("top must be less than or equal to bottom, top: " + v1 + ", bottom: " + v3).toString());
        }
    }

    public Bounds(@NotNull Rect rect0) {
        q.g(rect0, "rect");
        this(rect0.left, rect0.top, rect0.right, rect0.bottom);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        Class class0 = object0 == null ? null : object0.getClass();
        if(!Bounds.class.equals(class0)) {
            return false;
        }
        q.e(object0, "null cannot be cast to non-null type androidx.window.core.Bounds");
        if(this.left != ((Bounds)object0).left) {
            return false;
        }
        if(this.top != ((Bounds)object0).top) {
            return false;
        }
        return this.right == ((Bounds)object0).right ? this.bottom == ((Bounds)object0).bottom : false;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getHeight() {
        return this.bottom - this.top;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getTop() {
        return this.top;
    }

    public final int getWidth() {
        return this.right - this.left;
    }

    @Override
    public int hashCode() {
        return ((this.left * 0x1F + this.top) * 0x1F + this.right) * 0x1F + this.bottom;
    }

    public final boolean isEmpty() {
        return this.getHeight() == 0 || this.getWidth() == 0;
    }

    public final boolean isZero() {
        return this.getHeight() == 0 && this.getWidth() == 0;
    }

    @NotNull
    public final Rect toRect() {
        return new Rect(this.left, this.top, this.right, this.bottom);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Bounds { [");
        stringBuilder0.append(this.left);
        stringBuilder0.append(',');
        stringBuilder0.append(this.top);
        stringBuilder0.append(',');
        stringBuilder0.append(this.right);
        stringBuilder0.append(',');
        return x.g(this.bottom, "] }", stringBuilder0);
    }
}

