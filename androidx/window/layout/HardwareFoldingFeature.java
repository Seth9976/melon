package androidx.window.layout;

import android.graphics.Rect;
import androidx.window.core.Bounds;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0000\u0018\u0000 #2\u00020\u0001:\u0002#$B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u001C\u001A\u00020\u000E2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001EH\u0096\u0002J\b\u0010\u001F\u001A\u00020 H\u0016J\b\u0010!\u001A\u00020\"H\u0016R\u0014\u0010\t\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001B¨\u0006%"}, d2 = {"Landroidx/window/layout/HardwareFoldingFeature;", "Landroidx/window/layout/FoldingFeature;", "featureBounds", "Landroidx/window/core/Bounds;", "type", "Landroidx/window/layout/HardwareFoldingFeature$Type;", "state", "Landroidx/window/layout/FoldingFeature$State;", "(Landroidx/window/core/Bounds;Landroidx/window/layout/HardwareFoldingFeature$Type;Landroidx/window/layout/FoldingFeature$State;)V", "bounds", "Landroid/graphics/Rect;", "getBounds", "()Landroid/graphics/Rect;", "isSeparating", "", "()Z", "occlusionType", "Landroidx/window/layout/FoldingFeature$OcclusionType;", "getOcclusionType", "()Landroidx/window/layout/FoldingFeature$OcclusionType;", "orientation", "Landroidx/window/layout/FoldingFeature$Orientation;", "getOrientation", "()Landroidx/window/layout/FoldingFeature$Orientation;", "getState", "()Landroidx/window/layout/FoldingFeature$State;", "getType$window_release", "()Landroidx/window/layout/HardwareFoldingFeature$Type;", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "Type", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class HardwareFoldingFeature implements FoldingFeature {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\t\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroidx/window/layout/HardwareFoldingFeature$Companion;", "", "<init>", "()V", "Landroidx/window/core/Bounds;", "bounds", "Lie/H;", "validateFeatureBounds$window_release", "(Landroidx/window/core/Bounds;)V", "validateFeatureBounds", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final void validateFeatureBounds$window_release(@NotNull Bounds bounds0) {
            q.g(bounds0, "bounds");
            if(bounds0.getWidth() == 0 && bounds0.getHeight() == 0) {
                throw new IllegalArgumentException("Bounds must be non zero");
            }
            if(bounds0.getLeft() != 0 && bounds0.getTop() != 0) {
                throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/window/layout/HardwareFoldingFeature$Type;", "", "description", "", "(Ljava/lang/String;)V", "toString", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Type {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/window/layout/HardwareFoldingFeature$Type$Companion;", "", "()V", "FOLD", "Landroidx/window/layout/HardwareFoldingFeature$Type;", "getFOLD", "()Landroidx/window/layout/HardwareFoldingFeature$Type;", "HINGE", "getHINGE", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
        public static final class androidx.window.layout.HardwareFoldingFeature.Type.Companion {
            private androidx.window.layout.HardwareFoldingFeature.Type.Companion() {
            }

            public androidx.window.layout.HardwareFoldingFeature.Type.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final Type getFOLD() {
                return Type.FOLD;
            }

            @NotNull
            public final Type getHINGE() {
                return Type.HINGE;
            }
        }

        @NotNull
        public static final androidx.window.layout.HardwareFoldingFeature.Type.Companion Companion;
        @NotNull
        private static final Type FOLD;
        @NotNull
        private static final Type HINGE;
        @NotNull
        private final String description;

        static {
            Type.Companion = new androidx.window.layout.HardwareFoldingFeature.Type.Companion(null);
            Type.FOLD = new Type("FOLD");
            Type.HINGE = new Type("HINGE");
        }

        private Type(String s) {
            this.description = s;
        }

        @Override
        @NotNull
        public String toString() {
            return this.description;
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final Bounds featureBounds;
    @NotNull
    private final State state;
    @NotNull
    private final Type type;

    static {
        HardwareFoldingFeature.Companion = new Companion(null);
    }

    public HardwareFoldingFeature(@NotNull Bounds bounds0, @NotNull Type hardwareFoldingFeature$Type0, @NotNull State foldingFeature$State0) {
        q.g(bounds0, "featureBounds");
        q.g(hardwareFoldingFeature$Type0, "type");
        q.g(foldingFeature$State0, "state");
        super();
        this.featureBounds = bounds0;
        this.type = hardwareFoldingFeature$Type0;
        this.state = foldingFeature$State0;
        HardwareFoldingFeature.Companion.validateFeatureBounds$window_release(bounds0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        Class class0 = object0 == null ? null : object0.getClass();
        if(!HardwareFoldingFeature.class.equals(class0)) {
            return false;
        }
        q.e(object0, "null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        if(!q.b(this.featureBounds, ((HardwareFoldingFeature)object0).featureBounds)) {
            return false;
        }
        return q.b(this.type, ((HardwareFoldingFeature)object0).type) ? q.b(this.getState(), ((HardwareFoldingFeature)object0).getState()) : false;
    }

    @Override  // androidx.window.layout.DisplayFeature
    @NotNull
    public Rect getBounds() {
        return this.featureBounds.toRect();
    }

    @Override  // androidx.window.layout.FoldingFeature
    @NotNull
    public OcclusionType getOcclusionType() {
        return this.featureBounds.getWidth() == 0 || this.featureBounds.getHeight() == 0 ? OcclusionType.NONE : OcclusionType.FULL;
    }

    @Override  // androidx.window.layout.FoldingFeature
    @NotNull
    public Orientation getOrientation() {
        return this.featureBounds.getWidth() <= this.featureBounds.getHeight() ? Orientation.VERTICAL : Orientation.HORIZONTAL;
    }

    @Override  // androidx.window.layout.FoldingFeature
    @NotNull
    public State getState() {
        return this.state;
    }

    @NotNull
    public final Type getType$window_release() {
        return this.type;
    }

    @Override
    public int hashCode() {
        return this.getState().hashCode() + (this.type.hashCode() + this.featureBounds.hashCode() * 0x1F) * 0x1F;
    }

    // 去混淆评级： 低(40)
    @Override  // androidx.window.layout.FoldingFeature
    public boolean isSeparating() {
        return q.b(this.type, Type.Companion.getHINGE()) ? true : q.b(this.type, Type.Companion.getFOLD()) && q.b(this.getState(), State.HALF_OPENED);
    }

    @Override
    @NotNull
    public String toString() {
        return "HardwareFoldingFeature { " + this.featureBounds + ", type=" + this.type + ", state=" + this.getState() + " }";
    }
}

