package androidx.window.embedding;

import A7.d;
import androidx.appcompat.app.o;
import androidx.window.RequiresWindowSdkExtension;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0005\b&\u0018\u0000 \u000B2\u00020\u0001:\u0004\u000B\f\r\u000EB\u001B\b\u0002\u0012\b\b\u0003\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001A\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001A\u00020\nH\u0016R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u0007¨\u0006\u000F"}, d2 = {"Landroidx/window/embedding/DividerAttributes;", "", "widthDp", "", "color", "(II)V", "getColor", "()I", "getWidthDp", "toString", "", "Companion", "DragRange", "DraggableDividerAttributes", "FixedDividerAttributes", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public abstract class DividerAttributes {
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u000F\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001A\u00020\u00062\b\b\u0001\u0010\t\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0013\u0010\u000B\u001A\u00020\u0004*\u00020\u0004H\u0002¢\u0006\u0004\b\u000B\u0010\fJ7\u0010\u0014\u001A\u00020\u00112\u0006\u0010\r\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u000EH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\'\u0010\u001A\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\u00042\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\u0015H\u0000¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001B\u001A\u00020\u00048\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001B\u0010\u001CR\u0014\u0010\u001D\u001A\u00020\u000E8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001D\u0010\u001ER\u0014\u0010\u001F\u001A\u00020\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001F\u0010 R\u0014\u0010!\u001A\u00020\u00048\u0000X\u0080T¢\u0006\u0006\n\u0004\b!\u0010\u001CR\u0014\u0010\"\u001A\u00020\u00048\u0000X\u0080T¢\u0006\u0006\n\u0004\b\"\u0010\u001CR\u0014\u0010#\u001A\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\u001C¨\u0006$"}, d2 = {"Landroidx/window/embedding/DividerAttributes$Companion;", "", "<init>", "()V", "", "widthDp", "Lie/H;", "validateWidth", "(I)V", "color", "validateColor", "alpha", "(I)I", "type", "", "dragRangeMinRatio", "dragRangeMaxRatio", "Landroidx/window/embedding/DividerAttributes;", "createDividerAttributes$window_release", "(IIIFF)Landroidx/window/embedding/DividerAttributes;", "createDividerAttributes", "", "hasDragRangeMinRatio", "hasDragRangeMaxRatio", "validateXmlDividerAttributes$window_release", "(IZZ)V", "validateXmlDividerAttributes", "COLOR_SYSTEM_DEFAULT", "I", "DRAG_RANGE_VALUE_UNSPECIFIED", "F", "NO_DIVIDER", "Landroidx/window/embedding/DividerAttributes;", "TYPE_VALUE_DRAGGABLE", "TYPE_VALUE_FIXED", "WIDTH_SYSTEM_DEFAULT", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final int alpha(int v) [...] // Inlined contents

        @NotNull
        public final DividerAttributes createDividerAttributes$window_release(int v, int v1, int v2, float f, float f1) {
            switch(v) {
                case 0: {
                    return new Builder().setWidthDp(v1).setColor(v2).build();
                }
                case 1: {
                    androidx.window.embedding.DividerAttributes.DraggableDividerAttributes.Builder dividerAttributes$DraggableDividerAttributes$Builder0 = new androidx.window.embedding.DividerAttributes.DraggableDividerAttributes.Builder().setWidthDp(v1).setColor(v2);
                    if(f == -1.0f || f1 == -1.0f) {
                        dividerAttributes$DraggableDividerAttributes$Builder0.setDragRange(DragRange.DRAG_RANGE_SYSTEM_DEFAULT);
                        return dividerAttributes$DraggableDividerAttributes$Builder0.build();
                    }
                    dividerAttributes$DraggableDividerAttributes$Builder0.setDragRange(new SplitRatioDragRange(f, f1));
                    return dividerAttributes$DraggableDividerAttributes$Builder0.build();
                }
                default: {
                    throw new IllegalArgumentException("Got unknown divider type " + v + '!');
                }
            }
        }

        private final void validateColor(int v) {
            if(v >>> 24 != 0xFF) {
                throw new IllegalArgumentException(("Divider color must be opaque. Got: " + Integer.toHexString(v)).toString());
            }
        }

        private final void validateWidth(int v) {
            if(v != -1 && v < 0) {
                throw new IllegalArgumentException(("widthDp must be greater than or equal to 0 or WIDTH_SYSTEM_DEFAULT. Got: " + v).toString());
            }
        }

        public final void validateXmlDividerAttributes$window_release(int v, boolean z, boolean z1) {
            if(v != 1) {
                if(z) {
                    throw new IllegalArgumentException("Fixed divider does not allow attribute dragRangeMinRatio!");
                }
                if(z1) {
                    throw new IllegalArgumentException("Fixed divider does not allow attribute dragRangeMaxRatio!");
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b&\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Landroidx/window/embedding/DividerAttributes$DragRange;", "", "()V", "Companion", "SplitRatioDragRange", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static abstract class DragRange {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/window/embedding/DividerAttributes$DragRange$Companion;", "", "()V", "DRAG_RANGE_SYSTEM_DEFAULT", "Landroidx/window/embedding/DividerAttributes$DragRange;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
        public static final class androidx.window.embedding.DividerAttributes.DragRange.Companion {
            private androidx.window.embedding.DividerAttributes.DragRange.Companion() {
            }

            public androidx.window.embedding.DividerAttributes.DragRange.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001A\u00020\u000EH\u0016J\b\u0010\u000F\u001A\u00020\u0010H\u0016R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/window/embedding/DividerAttributes$DragRange$SplitRatioDragRange;", "Landroidx/window/embedding/DividerAttributes$DragRange;", "minRatio", "", "maxRatio", "(FF)V", "getMaxRatio", "()F", "getMinRatio", "equals", "", "other", "", "hashCode", "", "toString", "", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
        public static final class SplitRatioDragRange extends DragRange {
            private final float maxRatio;
            private final float minRatio;

            public SplitRatioDragRange(float f, float f1) {
                super(null);
                this.minRatio = f;
                this.maxRatio = f1;
                if(((double)f) <= 0.0 || ((double)f) >= 1.0) {
                    throw new IllegalArgumentException("minRatio must be in the interval (0.0, 1.0)");
                }
                if(((double)f1) <= 0.0 || ((double)f1) >= 1.0) {
                    throw new IllegalArgumentException("maxRatio must be in the interval (0.0, 1.0)");
                }
                if(f > f1) {
                    throw new IllegalArgumentException("minRatio must be less than or equal to maxRatio");
                }
            }

            @Override
            public boolean equals(@Nullable Object object0) {
                if(this == object0) {
                    return true;
                }
                return object0 instanceof SplitRatioDragRange ? this.minRatio == ((SplitRatioDragRange)object0).minRatio && this.maxRatio == ((SplitRatioDragRange)object0).maxRatio : false;
            }

            public final float getMaxRatio() {
                return this.maxRatio;
            }

            public final float getMinRatio() {
                return this.minRatio;
            }

            @Override
            public int hashCode() {
                return Float.hashCode(this.maxRatio) + Float.hashCode(this.minRatio) * 0x1F;
            }

            @Override
            @NotNull
            public String toString() {
                StringBuilder stringBuilder0 = new StringBuilder("SplitRatioDragRange[");
                stringBuilder0.append(this.minRatio);
                stringBuilder0.append(", ");
                return d.m(stringBuilder0, this.maxRatio, ']');
            }
        }

        @NotNull
        public static final androidx.window.embedding.DividerAttributes.DragRange.Companion Companion;
        @NotNull
        public static final DragRange DRAG_RANGE_SYSTEM_DEFAULT;

        static {
            DragRange.Companion = new androidx.window.embedding.DividerAttributes.DragRange.Companion(null);
            DragRange.DRAG_RANGE_SYSTEM_DEFAULT = new DividerAttributes.DragRange.Companion.DRAG_RANGE_SYSTEM_DEFAULT.1();
        }

        private DragRange() {
        }

        public DragRange(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B%\b\u0003\u0012\b\b\u0003\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000E\u001A\u00020\u0003H\u0016J\b\u0010\u000F\u001A\u00020\u0010H\u0016R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Landroidx/window/embedding/DividerAttributes$DraggableDividerAttributes;", "Landroidx/window/embedding/DividerAttributes;", "widthDp", "", "color", "dragRange", "Landroidx/window/embedding/DividerAttributes$DragRange;", "(IILandroidx/window/embedding/DividerAttributes$DragRange;)V", "getDragRange", "()Landroidx/window/embedding/DividerAttributes$DragRange;", "equals", "", "other", "", "hashCode", "toString", "", "Builder", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class DraggableDividerAttributes extends DividerAttributes {
        @RequiresWindowSdkExtension(version = 6)
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000F\b\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u000B\u001A\u00020\u0003H\u0007J\u0012\u0010\f\u001A\u00020\u00002\b\b\u0001\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\r\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\tH\u0007J\u0012\u0010\u000E\u001A\u00020\u00002\b\b\u0001\u0010\n\u001A\u00020\u0007H\u0007R\u0012\u0010\u0006\u001A\u00020\u00078\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001A\u00020\u00078\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Landroidx/window/embedding/DividerAttributes$DraggableDividerAttributes$Builder;", "", "original", "Landroidx/window/embedding/DividerAttributes$DraggableDividerAttributes;", "(Landroidx/window/embedding/DividerAttributes$DraggableDividerAttributes;)V", "()V", "color", "", "dragRange", "Landroidx/window/embedding/DividerAttributes$DragRange;", "widthDp", "build", "setColor", "setDragRange", "setWidthDp", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
        public static final class androidx.window.embedding.DividerAttributes.DraggableDividerAttributes.Builder {
            private int color;
            @NotNull
            private DragRange dragRange;
            private int widthDp;

            public androidx.window.embedding.DividerAttributes.DraggableDividerAttributes.Builder() {
                this.widthDp = -1;
                this.color = 0xFF000000;
                this.dragRange = DragRange.DRAG_RANGE_SYSTEM_DEFAULT;
            }

            @RequiresWindowSdkExtension(version = 6)
            public androidx.window.embedding.DividerAttributes.DraggableDividerAttributes.Builder(@NotNull DraggableDividerAttributes dividerAttributes$DraggableDividerAttributes0) {
                q.g(dividerAttributes$DraggableDividerAttributes0, "original");
                this();
                this.widthDp = dividerAttributes$DraggableDividerAttributes0.getWidthDp();
                this.dragRange = dividerAttributes$DraggableDividerAttributes0.getDragRange();
                this.color = dividerAttributes$DraggableDividerAttributes0.getColor();
            }

            @RequiresWindowSdkExtension(version = 6)
            @NotNull
            public final DraggableDividerAttributes build() {
                return new DraggableDividerAttributes(this.widthDp, this.color, this.dragRange, null);
            }

            @RequiresWindowSdkExtension(version = 6)
            @NotNull
            public final androidx.window.embedding.DividerAttributes.DraggableDividerAttributes.Builder setColor(int v) {
                DividerAttributes.Companion.validateColor(v);
                this.color = v;
                return this;
            }

            @RequiresWindowSdkExtension(version = 6)
            @NotNull
            public final androidx.window.embedding.DividerAttributes.DraggableDividerAttributes.Builder setDragRange(@NotNull DragRange dividerAttributes$DragRange0) {
                q.g(dividerAttributes$DragRange0, "dragRange");
                this.dragRange = dividerAttributes$DragRange0;
                return this;
            }

            @RequiresWindowSdkExtension(version = 6)
            @NotNull
            public final androidx.window.embedding.DividerAttributes.DraggableDividerAttributes.Builder setWidthDp(int v) {
                DividerAttributes.Companion.validateWidth(v);
                this.widthDp = v;
                return this;
            }
        }

        @NotNull
        private final DragRange dragRange;

        @RequiresWindowSdkExtension(version = 6)
        private DraggableDividerAttributes(int v, int v1, DragRange dividerAttributes$DragRange0) {
            super(v, v1, null);
            this.dragRange = dividerAttributes$DragRange0;
        }

        public DraggableDividerAttributes(int v, int v1, DragRange dividerAttributes$DragRange0, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v2 & 1) != 0) {
                v = -1;
            }
            if((v2 & 2) != 0) {
                v1 = 0xFF000000;
            }
            if((v2 & 4) != 0) {
                dividerAttributes$DragRange0 = DragRange.DRAG_RANGE_SYSTEM_DEFAULT;
            }
            this(v, v1, dividerAttributes$DragRange0);
        }

        public DraggableDividerAttributes(int v, int v1, DragRange dividerAttributes$DragRange0, DefaultConstructorMarker defaultConstructorMarker0) {
            this(v, v1, dividerAttributes$DragRange0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof DraggableDividerAttributes ? this.getWidthDp() == ((DraggableDividerAttributes)object0).getWidthDp() && this.getColor() == ((DraggableDividerAttributes)object0).getColor() && q.b(this.dragRange, ((DraggableDividerAttributes)object0).dragRange) : false;
        }

        @NotNull
        public final DragRange getDragRange() {
            return this.dragRange;
        }

        @Override
        public int hashCode() {
            return this.dragRange.hashCode() + (this.getColor() + this.getWidthDp() * 0x1F) * 0x1F;
        }

        @Override  // androidx.window.embedding.DividerAttributes
        @NotNull
        public String toString() {
            return "DividerAttributes{width=" + this.getWidthDp() + ", color=" + this.getColor() + ", primaryContainerDragRange=" + this.dragRange + '}';
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u000BB\u001B\b\u0003\u0012\b\b\u0003\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001A\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\n\u001A\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Landroidx/window/embedding/DividerAttributes$FixedDividerAttributes;", "Landroidx/window/embedding/DividerAttributes;", "widthDp", "", "color", "(II)V", "equals", "", "other", "", "hashCode", "Builder", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class FixedDividerAttributes extends DividerAttributes {
        @RequiresWindowSdkExtension(version = 6)
        @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000F\b\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001A\u00020\u0003H\u0007J\u0012\u0010\n\u001A\u00020\u00002\b\b\u0001\u0010\u0006\u001A\u00020\u0007H\u0007J\u0012\u0010\u000B\u001A\u00020\u00002\b\b\u0001\u0010\b\u001A\u00020\u0007H\u0007R\u0012\u0010\u0006\u001A\u00020\u00078\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001A\u00020\u00078\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/window/embedding/DividerAttributes$FixedDividerAttributes$Builder;", "", "original", "Landroidx/window/embedding/DividerAttributes$FixedDividerAttributes;", "(Landroidx/window/embedding/DividerAttributes$FixedDividerAttributes;)V", "()V", "color", "", "widthDp", "build", "setColor", "setWidthDp", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
        public static final class Builder {
            private int color;
            private int widthDp;

            public Builder() {
                this.widthDp = -1;
                this.color = 0xFF000000;
            }

            @RequiresWindowSdkExtension(version = 6)
            public Builder(@NotNull FixedDividerAttributes dividerAttributes$FixedDividerAttributes0) {
                q.g(dividerAttributes$FixedDividerAttributes0, "original");
                this();
                this.widthDp = dividerAttributes$FixedDividerAttributes0.getWidthDp();
                this.color = dividerAttributes$FixedDividerAttributes0.getColor();
            }

            @RequiresWindowSdkExtension(version = 6)
            @NotNull
            public final FixedDividerAttributes build() {
                return new FixedDividerAttributes(this.widthDp, this.color, null);
            }

            @RequiresWindowSdkExtension(version = 6)
            @NotNull
            public final Builder setColor(int v) {
                DividerAttributes.Companion.validateColor(v);
                this.color = v;
                return this;
            }

            @RequiresWindowSdkExtension(version = 6)
            @NotNull
            public final Builder setWidthDp(int v) {
                DividerAttributes.Companion.validateWidth(v);
                this.widthDp = v;
                return this;
            }
        }

        @RequiresWindowSdkExtension(version = 6)
        private FixedDividerAttributes(int v, int v1) {
            super(v, v1, null);
        }

        public FixedDividerAttributes(int v, int v1, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v2 & 1) != 0) {
                v = -1;
            }
            if((v2 & 2) != 0) {
                v1 = 0xFF000000;
            }
            this(v, v1);
        }

        public FixedDividerAttributes(int v, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
            this(v, v1);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof FixedDividerAttributes ? this.getWidthDp() == ((FixedDividerAttributes)object0).getWidthDp() && this.getColor() == ((FixedDividerAttributes)object0).getColor() : false;
        }

        @Override
        public int hashCode() {
            return this.getColor() + this.getWidthDp() * 0x1F;
        }
    }

    public static final int COLOR_SYSTEM_DEFAULT = 0xFF000000;
    @NotNull
    public static final Companion Companion = null;
    public static final float DRAG_RANGE_VALUE_UNSPECIFIED = -1.0f;
    @NotNull
    public static final DividerAttributes NO_DIVIDER = null;
    public static final int TYPE_VALUE_DRAGGABLE = 1;
    public static final int TYPE_VALUE_FIXED = 0;
    public static final int WIDTH_SYSTEM_DEFAULT = -1;
    private final int color;
    private final int widthDp;

    static {
        DividerAttributes.Companion = new Companion(null);
        DividerAttributes.NO_DIVIDER = new DividerAttributes.Companion.NO_DIVIDER.1();
    }

    private DividerAttributes(int v, int v1) {
        this.widthDp = v;
        this.color = v1;
    }

    public DividerAttributes(int v, int v1, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v2 & 1) != 0) {
            v = -1;
        }
        if((v2 & 2) != 0) {
            v1 = 0xFF000000;
        }
        this(v, v1);
    }

    public DividerAttributes(int v, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        this(v, v1);
    }

    public final int getColor() {
        return this.color;
    }

    public final int getWidthDp() {
        return this.widthDp;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("DividerAttributes{width=");
        stringBuilder0.append(this.widthDp);
        stringBuilder0.append(", color=");
        return o.q(stringBuilder0, this.color, '}');
    }
}

