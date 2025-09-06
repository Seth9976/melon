package androidx.window.embedding;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000EB\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\n\u001A\u00020\u000BH\u0016J\b\u0010\f\u001A\u00020\rH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u000F"}, d2 = {"Landroidx/window/embedding/OverlayAttributes;", "", "bounds", "Landroidx/window/embedding/EmbeddingBounds;", "(Landroidx/window/embedding/EmbeddingBounds;)V", "getBounds", "()Landroidx/window/embedding/EmbeddingBounds;", "equals", "", "other", "hashCode", "", "toString", "", "Builder", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class OverlayAttributes {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001A\u00020\u0006J\u000E\u0010\u0007\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u0004R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/window/embedding/OverlayAttributes$Builder;", "", "()V", "bounds", "Landroidx/window/embedding/EmbeddingBounds;", "build", "Landroidx/window/embedding/OverlayAttributes;", "setBounds", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Builder {
        @NotNull
        private EmbeddingBounds bounds;

        public Builder() {
            this.bounds = EmbeddingBounds.BOUNDS_EXPANDED;
        }

        @NotNull
        public final OverlayAttributes build() {
            return new OverlayAttributes(this.bounds);
        }

        @NotNull
        public final Builder setBounds(@NotNull EmbeddingBounds embeddingBounds0) {
            q.g(embeddingBounds0, "bounds");
            this.bounds = embeddingBounds0;
            return this;
        }
    }

    @NotNull
    private final EmbeddingBounds bounds;

    public OverlayAttributes() {
        this(null, 1, null);
    }

    public OverlayAttributes(@NotNull EmbeddingBounds embeddingBounds0) {
        q.g(embeddingBounds0, "bounds");
        super();
        this.bounds = embeddingBounds0;
    }

    public OverlayAttributes(EmbeddingBounds embeddingBounds0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            embeddingBounds0 = EmbeddingBounds.BOUNDS_EXPANDED;
        }
        this(embeddingBounds0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof OverlayAttributes ? q.b(this.bounds, ((OverlayAttributes)object0).bounds) : false;
    }

    @NotNull
    public final EmbeddingBounds getBounds() {
        return this.bounds;
    }

    @Override
    public int hashCode() {
        return this.bounds.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "OverlayAttributes: {bounds=" + this.bounds + '}';
    }
}

