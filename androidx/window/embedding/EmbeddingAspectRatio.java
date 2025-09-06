package androidx.window.embedding;

import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000E\u001A\u00020\u000FH\u0016J\b\u0010\u0010\u001A\u00020\u0003H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Landroidx/window/embedding/EmbeddingAspectRatio;", "", "description", "", "value", "", "(Ljava/lang/String;F)V", "getDescription$window_release", "()Ljava/lang/String;", "getValue$window_release", "()F", "equals", "", "other", "hashCode", "", "toString", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class EmbeddingAspectRatio {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0006\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\bH\u0000¢\u0006\u0002\b\tJ\u0012\u0010\n\u001A\u00020\u00042\b\b\u0001\u0010\n\u001A\u00020\bH\u0007R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Landroidx/window/embedding/EmbeddingAspectRatio$Companion;", "", "()V", "ALWAYS_ALLOW", "Landroidx/window/embedding/EmbeddingAspectRatio;", "ALWAYS_DISALLOW", "buildAspectRatioFromValue", "value", "", "buildAspectRatioFromValue$window_release", "ratio", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final EmbeddingAspectRatio buildAspectRatioFromValue$window_release(float f) {
            EmbeddingAspectRatio embeddingAspectRatio0 = EmbeddingAspectRatio.ALWAYS_ALLOW;
            if(f == embeddingAspectRatio0.getValue$window_release()) {
                return embeddingAspectRatio0;
            }
            return f == EmbeddingAspectRatio.ALWAYS_DISALLOW.getValue$window_release() ? EmbeddingAspectRatio.ALWAYS_DISALLOW : this.ratio(f);
        }

        @NotNull
        public final EmbeddingAspectRatio ratio(float f) {
            if(f <= 1.0f) {
                throw new IllegalArgumentException("Ratio must be greater than 1.");
            }
            return new EmbeddingAspectRatio("ratio:" + f, f, null);
        }
    }

    @NotNull
    public static final EmbeddingAspectRatio ALWAYS_ALLOW;
    @NotNull
    public static final EmbeddingAspectRatio ALWAYS_DISALLOW;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String description;
    private final float value;

    static {
        EmbeddingAspectRatio.Companion = new Companion(null);
        EmbeddingAspectRatio.ALWAYS_ALLOW = new EmbeddingAspectRatio("ALWAYS_ALLOW", 0.0f);
        EmbeddingAspectRatio.ALWAYS_DISALLOW = new EmbeddingAspectRatio("ALWAYS_DISALLOW", -1.0f);
    }

    private EmbeddingAspectRatio(String s, float f) {
        this.description = s;
        this.value = f;
    }

    public EmbeddingAspectRatio(String s, float f, DefaultConstructorMarker defaultConstructorMarker0) {
        this(s, f);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof EmbeddingAspectRatio ? this.value == ((EmbeddingAspectRatio)object0).value && q.b(this.description, ((EmbeddingAspectRatio)object0).description) : false;
    }

    @NotNull
    public final String getDescription$window_release() {
        return this.description;
    }

    public final float getValue$window_release() {
        return this.value;
    }

    @Override
    public int hashCode() {
        return Float.hashCode(this.value) * 0x1F + this.description.hashCode();
    }

    @NotNull
    public static final EmbeddingAspectRatio ratio(float f) {
        return EmbeddingAspectRatio.Companion.ratio(f);
    }

    @Override
    @NotNull
    public String toString() {
        return o.r(new StringBuilder("EmbeddingAspectRatio("), this.description, ')');
    }
}

