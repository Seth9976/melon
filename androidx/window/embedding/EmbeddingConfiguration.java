package androidx.window.embedding;

import androidx.window.RequiresWindowSdkExtension;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u000E\u000FB\u0011\b\u0002\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\n\u001A\u00020\u000BH\u0016J\b\u0010\f\u001A\u00020\rH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/window/embedding/EmbeddingConfiguration;", "", "dimAreaBehavior", "Landroidx/window/embedding/EmbeddingConfiguration$DimAreaBehavior;", "(Landroidx/window/embedding/EmbeddingConfiguration$DimAreaBehavior;)V", "getDimAreaBehavior", "()Landroidx/window/embedding/EmbeddingConfiguration$DimAreaBehavior;", "equals", "", "other", "hashCode", "", "toString", "", "Builder", "DimAreaBehavior", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class EmbeddingConfiguration {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001A\u00020\u0006J\u0010\u0010\u0007\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\u0004H\u0007R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/window/embedding/EmbeddingConfiguration$Builder;", "", "()V", "mDimAreaBehavior", "Landroidx/window/embedding/EmbeddingConfiguration$DimAreaBehavior;", "build", "Landroidx/window/embedding/EmbeddingConfiguration;", "setDimAreaBehavior", "area", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Builder {
        @NotNull
        private DimAreaBehavior mDimAreaBehavior;

        public Builder() {
            this.mDimAreaBehavior = DimAreaBehavior.UNDEFINED;
        }

        @NotNull
        public final EmbeddingConfiguration build() {
            return new EmbeddingConfiguration(this.mDimAreaBehavior, null);
        }

        @RequiresWindowSdkExtension(version = 5)
        @NotNull
        public final Builder setDimAreaBehavior(@NotNull DimAreaBehavior embeddingConfiguration$DimAreaBehavior0) {
            q.g(embeddingConfiguration$DimAreaBehavior0, "area");
            this.mDimAreaBehavior = embeddingConfiguration$DimAreaBehavior0;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001A\u00020\bH\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Landroidx/window/embedding/EmbeddingConfiguration$DimAreaBehavior;", "", "value", "", "(I)V", "getValue$window_release", "()I", "toString", "", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class DimAreaBehavior {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/window/embedding/EmbeddingConfiguration$DimAreaBehavior$Companion;", "", "()V", "ON_ACTIVITY_STACK", "Landroidx/window/embedding/EmbeddingConfiguration$DimAreaBehavior;", "ON_TASK", "UNDEFINED", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
        public static final class Companion {
            private Companion() {
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @NotNull
        public static final Companion Companion;
        @NotNull
        public static final DimAreaBehavior ON_ACTIVITY_STACK;
        @NotNull
        public static final DimAreaBehavior ON_TASK;
        @NotNull
        public static final DimAreaBehavior UNDEFINED;
        private final int value;

        static {
            DimAreaBehavior.Companion = new Companion(null);
            DimAreaBehavior.UNDEFINED = new DimAreaBehavior(0);
            DimAreaBehavior.ON_ACTIVITY_STACK = new DimAreaBehavior(1);
            DimAreaBehavior.ON_TASK = new DimAreaBehavior(2);
        }

        private DimAreaBehavior(int v) {
            this.value = v;
        }

        public final int getValue$window_release() {
            return this.value;
        }

        @Override
        @NotNull
        public String toString() {
            switch(this.value) {
                case 0: {
                    return "DimAreaBehavior=UNDEFINED";
                }
                case 1: {
                    return "DimAreaBehavior=ON_ACTIVITY_STACK";
                }
                case 2: {
                    return "DimAreaBehavior=ON_TASK";
                }
                default: {
                    return "DimAreaBehavior=UNKNOWN";
                }
            }
        }
    }

    @NotNull
    private final DimAreaBehavior dimAreaBehavior;

    private EmbeddingConfiguration(DimAreaBehavior embeddingConfiguration$DimAreaBehavior0) {
        this.dimAreaBehavior = embeddingConfiguration$DimAreaBehavior0;
    }

    public EmbeddingConfiguration(DimAreaBehavior embeddingConfiguration$DimAreaBehavior0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            embeddingConfiguration$DimAreaBehavior0 = DimAreaBehavior.UNDEFINED;
        }
        this(embeddingConfiguration$DimAreaBehavior0);
    }

    public EmbeddingConfiguration(DimAreaBehavior embeddingConfiguration$DimAreaBehavior0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(embeddingConfiguration$DimAreaBehavior0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof EmbeddingConfiguration ? q.b(this.dimAreaBehavior, ((EmbeddingConfiguration)object0).dimAreaBehavior) : false;
    }

    @NotNull
    public final DimAreaBehavior getDimAreaBehavior() {
        return this.dimAreaBehavior;
    }

    @Override
    public int hashCode() {
        return this.dimAreaBehavior.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "EmbeddingConfiguration{" + this.dimAreaBehavior + '}';
    }
}

