package androidx.window.embedding;

import android.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b&\u0018\u0000 \u00042\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Landroidx/window/embedding/EmbeddingAnimationBackground;", "", "()V", "ColorBackground", "Companion", "DefaultBackground", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public abstract class EmbeddingAnimationBackground {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000B\u001A\u00020\u0003H\u0016J\b\u0010\f\u001A\u00020\rH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u000E"}, d2 = {"Landroidx/window/embedding/EmbeddingAnimationBackground$ColorBackground;", "Landroidx/window/embedding/EmbeddingAnimationBackground;", "color", "", "(I)V", "getColor", "()I", "equals", "", "other", "", "hashCode", "toString", "", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class ColorBackground extends EmbeddingAnimationBackground {
        private final int color;

        public ColorBackground(int v) {
            super(null);
            this.color = v;
            if(Color.alpha(v) != 0xFF) {
                throw new IllegalArgumentException("Background color must be opaque");
            }
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(object0 == this) {
                return true;
            }
            return object0 instanceof ColorBackground ? this.color == ((ColorBackground)object0).color : false;
        }

        public final int getColor() {
            return this.color;
        }

        @Override
        public int hashCode() {
            return this.color;
        }

        @Override
        @NotNull
        public String toString() {
            return "ColorBackground{color:" + Integer.toHexString(this.color) + '}';
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0005\u001A\u00020\u00042\b\b\u0001\u0010\u0006\u001A\u00020\u0007H\u0000¢\u0006\u0002\b\bJ\u0012\u0010\t\u001A\u00020\n2\b\b\u0001\u0010\u0006\u001A\u00020\u0007H\u0007R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Landroidx/window/embedding/EmbeddingAnimationBackground$Companion;", "", "()V", "DEFAULT", "Landroidx/window/embedding/EmbeddingAnimationBackground;", "buildFromValue", "color", "", "buildFromValue$window_release", "createColorBackground", "Landroidx/window/embedding/EmbeddingAnimationBackground$ColorBackground;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final EmbeddingAnimationBackground buildFromValue$window_release(int v) {
            return Color.alpha(v) != 0xFF ? EmbeddingAnimationBackground.DEFAULT : this.createColorBackground(v);
        }

        @NotNull
        public final ColorBackground createColorBackground(int v) {
            return new ColorBackground(v);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001A\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Landroidx/window/embedding/EmbeddingAnimationBackground$DefaultBackground;", "Landroidx/window/embedding/EmbeddingAnimationBackground;", "()V", "toString", "", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    static final class DefaultBackground extends EmbeddingAnimationBackground {
        public DefaultBackground() {
            super(null);
        }

        @Override
        @NotNull
        public String toString() {
            return "DefaultBackground";
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    public static final EmbeddingAnimationBackground DEFAULT;

    static {
        EmbeddingAnimationBackground.Companion = new Companion(null);
        EmbeddingAnimationBackground.DEFAULT = new DefaultBackground();
    }

    private EmbeddingAnimationBackground() {
    }

    public EmbeddingAnimationBackground(DefaultConstructorMarker defaultConstructorMarker0) {
    }

    @NotNull
    public static final ColorBackground createColorBackground(int v) {
        return EmbeddingAnimationBackground.Companion.createColorBackground(v);
    }
}

