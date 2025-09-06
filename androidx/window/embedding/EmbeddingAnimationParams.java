package androidx.window.embedding;

import androidx.window.RequiresWindowSdkExtension;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000EB\u0011\b\u0002\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\n\u001A\u00020\u000BH\u0016J\b\u0010\f\u001A\u00020\rH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u000F"}, d2 = {"Landroidx/window/embedding/EmbeddingAnimationParams;", "", "animationBackground", "Landroidx/window/embedding/EmbeddingAnimationBackground;", "(Landroidx/window/embedding/EmbeddingAnimationBackground;)V", "getAnimationBackground", "()Landroidx/window/embedding/EmbeddingAnimationBackground;", "equals", "", "other", "hashCode", "", "toString", "", "Builder", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class EmbeddingAnimationParams {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001A\u00020\u0006J\u0010\u0010\u0007\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\u0004H\u0007R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/window/embedding/EmbeddingAnimationParams$Builder;", "", "()V", "animationBackground", "Landroidx/window/embedding/EmbeddingAnimationBackground;", "build", "Landroidx/window/embedding/EmbeddingAnimationParams;", "setAnimationBackground", "background", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Builder {
        @NotNull
        private EmbeddingAnimationBackground animationBackground;

        public Builder() {
            this.animationBackground = EmbeddingAnimationBackground.DEFAULT;
        }

        @NotNull
        public final EmbeddingAnimationParams build() {
            return new EmbeddingAnimationParams(this.animationBackground, null);
        }

        @RequiresWindowSdkExtension(version = 5)
        @NotNull
        public final Builder setAnimationBackground(@NotNull EmbeddingAnimationBackground embeddingAnimationBackground0) {
            q.g(embeddingAnimationBackground0, "background");
            this.animationBackground = embeddingAnimationBackground0;
            return this;
        }
    }

    @NotNull
    private final EmbeddingAnimationBackground animationBackground;

    private EmbeddingAnimationParams(EmbeddingAnimationBackground embeddingAnimationBackground0) {
        this.animationBackground = embeddingAnimationBackground0;
    }

    public EmbeddingAnimationParams(EmbeddingAnimationBackground embeddingAnimationBackground0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            embeddingAnimationBackground0 = EmbeddingAnimationBackground.DEFAULT;
        }
        this(embeddingAnimationBackground0);
    }

    public EmbeddingAnimationParams(EmbeddingAnimationBackground embeddingAnimationBackground0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(embeddingAnimationBackground0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof EmbeddingAnimationParams ? q.b(this.animationBackground, ((EmbeddingAnimationParams)object0).animationBackground) : false;
    }

    @NotNull
    public final EmbeddingAnimationBackground getAnimationBackground() {
        return this.animationBackground;
    }

    @Override
    public int hashCode() {
        return this.animationBackground.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "EmbeddingAnimationParams:{animationBackground=" + this.animationBackground + " }";
    }
}

