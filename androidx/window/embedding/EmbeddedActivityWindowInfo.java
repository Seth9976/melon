package androidx.window.embedding;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\u0018\u00002\u00020\u0001B\u001F\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0013\u0010\f\u001A\u00020\u00032\b\u0010\r\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000E\u001A\u00020\u000FH\u0016J\b\u0010\u0010\u001A\u00020\u0011H\u0016R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\t¨\u0006\u0012"}, d2 = {"Landroidx/window/embedding/EmbeddedActivityWindowInfo;", "", "isEmbedded", "", "parentHostBounds", "Landroid/graphics/Rect;", "boundsInParentHost", "(ZLandroid/graphics/Rect;Landroid/graphics/Rect;)V", "getBoundsInParentHost", "()Landroid/graphics/Rect;", "()Z", "getParentHostBounds", "equals", "other", "hashCode", "", "toString", "", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class EmbeddedActivityWindowInfo {
    @NotNull
    private final Rect boundsInParentHost;
    private final boolean isEmbedded;
    @NotNull
    private final Rect parentHostBounds;

    public EmbeddedActivityWindowInfo(boolean z, @NotNull Rect rect0, @NotNull Rect rect1) {
        q.g(rect0, "parentHostBounds");
        q.g(rect1, "boundsInParentHost");
        super();
        this.isEmbedded = z;
        this.parentHostBounds = rect0;
        this.boundsInParentHost = rect1;
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof EmbeddedActivityWindowInfo)) {
            return false;
        }
        if(this.isEmbedded != ((EmbeddedActivityWindowInfo)object0).isEmbedded) {
            return false;
        }
        return q.b(this.parentHostBounds, ((EmbeddedActivityWindowInfo)object0).parentHostBounds) ? q.b(this.boundsInParentHost, ((EmbeddedActivityWindowInfo)object0).boundsInParentHost) : false;
    }

    @NotNull
    public final Rect getBoundsInParentHost() {
        return this.boundsInParentHost;
    }

    @NotNull
    public final Rect getParentHostBounds() {
        return this.parentHostBounds;
    }

    @Override
    public int hashCode() {
        return this.boundsInParentHost.hashCode() + (this.parentHostBounds.hashCode() + Boolean.hashCode(this.isEmbedded) * 0x1F) * 0x1F;
    }

    public final boolean isEmbedded() {
        return this.isEmbedded;
    }

    @Override
    @NotNull
    public String toString() {
        return "EmbeddedActivityWindowInfo{isEmbedded=" + this.isEmbedded + ", parentHostBounds=" + this.parentHostBounds + ", boundsInParentHost=" + this.boundsInParentHost + '}';
    }
}

