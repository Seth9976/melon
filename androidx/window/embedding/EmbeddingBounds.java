package androidx.window.embedding;

import android.graphics.Rect;
import androidx.window.core.Bounds;
import androidx.window.layout.FoldingFeature.Orientation;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowLayoutInfo;
import e.k;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 %2\u00020\u0001:\u0003$%&B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\u001D\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015H\u0001¢\u0006\u0002\b\u0016J\u001D\u0010\u0017\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015H\u0001¢\u0006\u0002\b\u0018J\b\u0010\u0019\u001A\u00020\u0011H\u0016J\u0015\u0010\u001A\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00020\u0015H\u0000¢\u0006\u0002\b\u001BJ\u0015\u0010\u001C\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00020\u0015H\u0000¢\u0006\u0002\b\u001DJ\b\u0010\u001E\u001A\u00020\u001FH\u0016J\u000E\u0010 \u001A\u0004\u0018\u00010!*\u00020\u0015H\u0002J\f\u0010\"\u001A\u00020\u000E*\u00020\u0015H\u0002J\f\u0010#\u001A\u00020\u000E*\u00020\u0015H\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000B¨\u0006\'"}, d2 = {"Landroidx/window/embedding/EmbeddingBounds;", "", "alignment", "Landroidx/window/embedding/EmbeddingBounds$Alignment;", "width", "Landroidx/window/embedding/EmbeddingBounds$Dimension;", "height", "(Landroidx/window/embedding/EmbeddingBounds$Alignment;Landroidx/window/embedding/EmbeddingBounds$Dimension;Landroidx/window/embedding/EmbeddingBounds$Dimension;)V", "getAlignment", "()Landroidx/window/embedding/EmbeddingBounds$Alignment;", "getHeight", "()Landroidx/window/embedding/EmbeddingBounds$Dimension;", "getWidth", "equals", "", "other", "getHeightInPixel", "", "parentContainerBounds", "Landroidx/window/core/Bounds;", "windowLayoutInfo", "Landroidx/window/layout/WindowLayoutInfo;", "getHeightInPixel$window_release", "getWidthInPixel", "getWidthInPixel$window_release", "hashCode", "shouldUseFallbackDimensionForHeight", "shouldUseFallbackDimensionForHeight$window_release", "shouldUseFallbackDimensionForWidth", "shouldUseFallbackDimensionForWidth$window_release", "toString", "", "getOnlyFoldingFeatureOrNull", "Landroidx/window/layout/FoldingFeature;", "isHorizontal", "isVertical", "Alignment", "Companion", "Dimension", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class EmbeddingBounds {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\b\u0000\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\n\u001A\u00020\u0003H\u0016J\b\u0010\u000B\u001A\u00020\fH\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u000E"}, d2 = {"Landroidx/window/embedding/EmbeddingBounds$Alignment;", "", "value", "", "(I)V", "getValue$window_release", "()I", "equals", "", "other", "hashCode", "toString", "", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Alignment {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/window/embedding/EmbeddingBounds$Alignment$Companion;", "", "()V", "ALIGN_BOTTOM", "Landroidx/window/embedding/EmbeddingBounds$Alignment;", "ALIGN_LEFT", "ALIGN_RIGHT", "ALIGN_TOP", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
        public static final class Companion {
            private Companion() {
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @NotNull
        public static final Alignment ALIGN_BOTTOM;
        @NotNull
        public static final Alignment ALIGN_LEFT;
        @NotNull
        public static final Alignment ALIGN_RIGHT;
        @NotNull
        public static final Alignment ALIGN_TOP;
        @NotNull
        public static final Companion Companion;
        private final int value;

        static {
            Alignment.Companion = new Companion(null);
            Alignment.ALIGN_LEFT = new Alignment(0);
            Alignment.ALIGN_TOP = new Alignment(1);
            Alignment.ALIGN_RIGHT = new Alignment(2);
            Alignment.ALIGN_BOTTOM = new Alignment(3);
        }

        public Alignment(int v) {
            this.value = v;
            if(v < 0 || v >= 4) {
                throw new IllegalArgumentException("Failed requirement.");
            }
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof Alignment ? this.value == ((Alignment)object0).value : false;
        }

        public final int getValue$window_release() {
            return this.value;
        }

        @Override
        public int hashCode() {
            return this.value;
        }

        @Override
        @NotNull
        public String toString() {
            switch(this.value) {
                case 0: {
                    return "left";
                }
                case 1: {
                    return "top";
                }
                case 2: {
                    return "right";
                }
                case 3: {
                    return "bottom";
                }
                default: {
                    return "unknown position:" + this.value;
                }
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\u000EH\u0001¢\u0006\u0002\b\u000FJ\u001D\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u0011H\u0000¢\u0006\u0002\b\u000FJ\u001C\u0010\u0012\u001A\u00020\n*\u00020\n2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0014H\u0002R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/window/embedding/EmbeddingBounds$Companion;", "", "()V", "BOUNDS_EXPANDED", "Landroidx/window/embedding/EmbeddingBounds;", "BOUNDS_HINGE_BOTTOM", "BOUNDS_HINGE_LEFT", "BOUNDS_HINGE_RIGHT", "BOUNDS_HINGE_TOP", "translateEmbeddingBounds", "Landroidx/window/core/Bounds;", "embeddingBounds", "parentContainerBounds", "windowLayoutInfo", "Landroidx/window/layout/WindowLayoutInfo;", "translateEmbeddingBounds$window_release", "parentContainerInfo", "Landroidx/window/embedding/ParentContainerInfo;", "offset", "dx", "", "dy", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class androidx.window.embedding.EmbeddingBounds.Companion {
        private androidx.window.embedding.EmbeddingBounds.Companion() {
        }

        public androidx.window.embedding.EmbeddingBounds.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final Bounds offset(Bounds bounds0, int v, int v1) {
            return new Bounds(bounds0.getLeft() + v, bounds0.getTop() + v1, bounds0.getRight() + v, bounds0.getBottom() + v1);
        }

        @NotNull
        public final Bounds translateEmbeddingBounds$window_release(@NotNull EmbeddingBounds embeddingBounds0, @NotNull Bounds bounds0, @NotNull WindowLayoutInfo windowLayoutInfo0) {
            q.g(embeddingBounds0, "embeddingBounds");
            q.g(bounds0, "parentContainerBounds");
            q.g(windowLayoutInfo0, "windowLayoutInfo");
            if(q.b(embeddingBounds0.getWidth(), Dimension.DIMENSION_EXPANDED) && q.b(embeddingBounds0.getHeight(), Dimension.DIMENSION_EXPANDED)) {
                return Bounds.Companion.getEMPTY_BOUNDS();
            }
            EmbeddingBounds embeddingBounds1 = new EmbeddingBounds(embeddingBounds0.getAlignment(), (embeddingBounds0.shouldUseFallbackDimensionForWidth$window_release(windowLayoutInfo0) ? Dimension.Companion.ratio(0.5f) : embeddingBounds0.getWidth()), (embeddingBounds0.shouldUseFallbackDimensionForHeight$window_release(windowLayoutInfo0) ? Dimension.Companion.ratio(0.5f) : embeddingBounds0.getHeight()));
            int v = embeddingBounds1.getWidthInPixel$window_release(bounds0, windowLayoutInfo0);
            int v1 = embeddingBounds1.getHeightInPixel$window_release(bounds0, windowLayoutInfo0);
            int v2 = bounds0.getWidth();
            int v3 = bounds0.getHeight();
            if(v == v2 && v1 == v3) {
                return Bounds.Companion.getEMPTY_BOUNDS();
            }
            Bounds bounds1 = new Bounds(0, 0, v, v1);
            Alignment embeddingBounds$Alignment0 = embeddingBounds0.getAlignment();
            if(q.b(embeddingBounds$Alignment0, Alignment.ALIGN_TOP)) {
                return EmbeddingBounds.Companion.offset(bounds1, (v2 - v) / 2, 0);
            }
            if(q.b(embeddingBounds$Alignment0, Alignment.ALIGN_LEFT)) {
                return EmbeddingBounds.Companion.offset(bounds1, 0, (v3 - v1) / 2);
            }
            if(q.b(embeddingBounds$Alignment0, Alignment.ALIGN_BOTTOM)) {
                return EmbeddingBounds.Companion.offset(bounds1, (v2 - v) / 2, v3 - v1);
            }
            if(!q.b(embeddingBounds$Alignment0, Alignment.ALIGN_RIGHT)) {
                throw new IllegalArgumentException("Unknown alignment: " + embeddingBounds0.getAlignment());
            }
            return EmbeddingBounds.Companion.offset(bounds1, v2 - v, (v3 - v1) / 2);
        }

        @NotNull
        public final Bounds translateEmbeddingBounds$window_release(@NotNull EmbeddingBounds embeddingBounds0, @NotNull ParentContainerInfo parentContainerInfo0) {
            q.g(embeddingBounds0, "embeddingBounds");
            q.g(parentContainerInfo0, "parentContainerInfo");
            return this.translateEmbeddingBounds$window_release(embeddingBounds0, parentContainerInfo0.getWindowBounds(), parentContainerInfo0.getWindowLayoutInfo());
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000 \r2\u00020\u0001:\u0003\r\u000E\u000FB\u000F\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\n\u001A\u00020\u000BH\u0016J\b\u0010\f\u001A\u00020\u0003H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/window/embedding/EmbeddingBounds$Dimension;", "", "description", "", "(Ljava/lang/String;)V", "getDescription$window_release", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "toString", "Companion", "Pixel", "Ratio", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static abstract class Dimension {
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001A\u00020\u00042\b\b\u0001\u0010\u0007\u001A\u00020\bH\u0007J\u0012\u0010\t\u001A\u00020\u00042\b\b\u0001\u0010\t\u001A\u00020\nH\u0007R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Landroidx/window/embedding/EmbeddingBounds$Dimension$Companion;", "", "()V", "DIMENSION_EXPANDED", "Landroidx/window/embedding/EmbeddingBounds$Dimension;", "DIMENSION_HINGE", "pixel", "value", "", "ratio", "", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
        public static final class androidx.window.embedding.EmbeddingBounds.Dimension.Companion {
            private androidx.window.embedding.EmbeddingBounds.Dimension.Companion() {
            }

            public androidx.window.embedding.EmbeddingBounds.Dimension.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final Dimension pixel(int v) {
                return new Pixel(v);
            }

            @NotNull
            public final Dimension ratio(float f) {
                return new Ratio(f);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\u0003H\u0080\u0002¢\u0006\u0002\b\tR\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Landroidx/window/embedding/EmbeddingBounds$Dimension$Pixel;", "Landroidx/window/embedding/EmbeddingBounds$Dimension;", "value", "", "(I)V", "getValue$window_release", "()I", "compareTo", "dimen", "compareTo$window_release", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
        public static final class Pixel extends Dimension {
            private final int value;

            public Pixel(int v) {
                super("dimension in pixel:" + v);
                this.value = v;
                if(v < 1) {
                    throw new IllegalArgumentException("Pixel value must be a positive integer.");
                }
            }

            public final int compareTo$window_release(int v) {
                return this.value - v;
            }

            public final int getValue$window_release() {
                return this.value;
            }
        }

        @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\bH\u0080\u0002¢\u0006\u0002\b\nR\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u000B"}, d2 = {"Landroidx/window/embedding/EmbeddingBounds$Dimension$Ratio;", "Landroidx/window/embedding/EmbeddingBounds$Dimension;", "value", "", "(F)V", "getValue$window_release", "()F", "times", "", "dimen", "times$window_release", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
        public static final class Ratio extends Dimension {
            private final float value;

            public Ratio(float f) {
                super("dimension in ratio:" + f);
                this.value = f;
                if(((double)f) <= 0.0 || ((double)f) > 1.0) {
                    throw new IllegalArgumentException("Ratio must be in range (0.0, 1.0]");
                }
            }

            public final float getValue$window_release() {
                return this.value;
            }

            public final int times$window_release(int v) {
                return (int)(this.value * ((float)v));
            }
        }

        @NotNull
        public static final androidx.window.embedding.EmbeddingBounds.Dimension.Companion Companion;
        @NotNull
        public static final Dimension DIMENSION_EXPANDED;
        @NotNull
        public static final Dimension DIMENSION_HINGE;
        @NotNull
        private final String description;

        static {
            Dimension.Companion = new androidx.window.embedding.EmbeddingBounds.Dimension.Companion(null);
            Dimension.DIMENSION_EXPANDED = new Ratio(1.0f);
            Dimension.DIMENSION_HINGE = new EmbeddingBounds.Dimension.Companion.DIMENSION_HINGE.1();
        }

        public Dimension(@NotNull String s) {
            q.g(s, "description");
            super();
            this.description = s;
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof Dimension ? q.b(this.description, ((Dimension)object0).description) : false;
        }

        @NotNull
        public final String getDescription$window_release() {
            return this.description;
        }

        @Override
        public int hashCode() {
            return this.description.hashCode();
        }

        @NotNull
        public static final Dimension pixel(int v) {
            return Dimension.Companion.pixel(v);
        }

        @NotNull
        public static final Dimension ratio(float f) {
            return Dimension.Companion.ratio(f);
        }

        @Override
        @NotNull
        public String toString() {
            return this.description;
        }
    }

    @NotNull
    public static final EmbeddingBounds BOUNDS_EXPANDED;
    @NotNull
    public static final EmbeddingBounds BOUNDS_HINGE_BOTTOM;
    @NotNull
    public static final EmbeddingBounds BOUNDS_HINGE_LEFT;
    @NotNull
    public static final EmbeddingBounds BOUNDS_HINGE_RIGHT;
    @NotNull
    public static final EmbeddingBounds BOUNDS_HINGE_TOP;
    @NotNull
    public static final androidx.window.embedding.EmbeddingBounds.Companion Companion;
    @NotNull
    private final Alignment alignment;
    @NotNull
    private final Dimension height;
    @NotNull
    private final Dimension width;

    static {
        EmbeddingBounds.Companion = new androidx.window.embedding.EmbeddingBounds.Companion(null);
        EmbeddingBounds.BOUNDS_EXPANDED = new EmbeddingBounds(Alignment.ALIGN_TOP, Dimension.DIMENSION_EXPANDED, Dimension.DIMENSION_EXPANDED);
        EmbeddingBounds.BOUNDS_HINGE_TOP = new EmbeddingBounds(Alignment.ALIGN_TOP, Dimension.DIMENSION_EXPANDED, Dimension.DIMENSION_HINGE);
        EmbeddingBounds.BOUNDS_HINGE_LEFT = new EmbeddingBounds(Alignment.ALIGN_LEFT, Dimension.DIMENSION_HINGE, Dimension.DIMENSION_EXPANDED);
        EmbeddingBounds.BOUNDS_HINGE_BOTTOM = new EmbeddingBounds(Alignment.ALIGN_BOTTOM, Dimension.DIMENSION_EXPANDED, Dimension.DIMENSION_HINGE);
        EmbeddingBounds.BOUNDS_HINGE_RIGHT = new EmbeddingBounds(Alignment.ALIGN_RIGHT, Dimension.DIMENSION_HINGE, Dimension.DIMENSION_EXPANDED);
    }

    public EmbeddingBounds(@NotNull Alignment embeddingBounds$Alignment0, @NotNull Dimension embeddingBounds$Dimension0, @NotNull Dimension embeddingBounds$Dimension1) {
        q.g(embeddingBounds$Alignment0, "alignment");
        q.g(embeddingBounds$Dimension0, "width");
        q.g(embeddingBounds$Dimension1, "height");
        super();
        this.alignment = embeddingBounds$Alignment0;
        this.width = embeddingBounds$Dimension0;
        this.height = embeddingBounds$Dimension1;
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof EmbeddingBounds ? q.b(this.alignment, ((EmbeddingBounds)object0).alignment) && q.b(this.width, ((EmbeddingBounds)object0).width) && q.b(this.height, ((EmbeddingBounds)object0).height) : false;
    }

    @NotNull
    public final Alignment getAlignment() {
        return this.alignment;
    }

    @NotNull
    public final Dimension getHeight() {
        return this.height;
    }

    public final int getHeightInPixel$window_release(@NotNull Bounds bounds0, @NotNull WindowLayoutInfo windowLayoutInfo0) {
        q.g(bounds0, "parentContainerBounds");
        q.g(windowLayoutInfo0, "windowLayoutInfo");
        int v = bounds0.getHeight();
        Dimension embeddingBounds$Dimension0 = this.shouldUseFallbackDimensionForHeight$window_release(windowLayoutInfo0) ? Dimension.Companion.ratio(0.5f) : this.height;
        if(embeddingBounds$Dimension0 instanceof Ratio) {
            return ((Ratio)embeddingBounds$Dimension0).times$window_release(v);
        }
        if(embeddingBounds$Dimension0 instanceof Pixel) {
            return Math.min(v, ((Pixel)embeddingBounds$Dimension0).getValue$window_release());
        }
        if(!q.b(embeddingBounds$Dimension0, Dimension.DIMENSION_HINGE)) {
            throw new IllegalArgumentException("Unhandled width dimension=" + this.width);
        }
        FoldingFeature foldingFeature0 = this.getOnlyFoldingFeatureOrNull(windowLayoutInfo0);
        q.d(foldingFeature0);
        Rect rect0 = foldingFeature0.getBounds();
        Alignment embeddingBounds$Alignment0 = this.alignment;
        if(q.b(embeddingBounds$Alignment0, Alignment.ALIGN_TOP)) {
            return rect0.top - bounds0.getTop();
        }
        if(!q.b(embeddingBounds$Alignment0, Alignment.ALIGN_BOTTOM)) {
            throw new IllegalStateException("Unhandled condition to get height in pixel! embeddingBounds=" + this + " taskBounds=" + bounds0 + " windowLayoutInfo=" + windowLayoutInfo0);
        }
        return bounds0.getBottom() - rect0.bottom;
    }

    private final FoldingFeature getOnlyFoldingFeatureOrNull(WindowLayoutInfo windowLayoutInfo0) {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: windowLayoutInfo0.getDisplayFeatures()) {
            if(object0 instanceof FoldingFeature) {
                arrayList0.add(object0);
            }
        }
        return arrayList0.size() == 1 ? ((FoldingFeature)arrayList0.get(0)) : null;
    }

    @NotNull
    public final Dimension getWidth() {
        return this.width;
    }

    public final int getWidthInPixel$window_release(@NotNull Bounds bounds0, @NotNull WindowLayoutInfo windowLayoutInfo0) {
        q.g(bounds0, "parentContainerBounds");
        q.g(windowLayoutInfo0, "windowLayoutInfo");
        int v = bounds0.getWidth();
        Dimension embeddingBounds$Dimension0 = this.shouldUseFallbackDimensionForWidth$window_release(windowLayoutInfo0) ? Dimension.Companion.ratio(0.5f) : this.width;
        if(embeddingBounds$Dimension0 instanceof Ratio) {
            return ((Ratio)embeddingBounds$Dimension0).times$window_release(v);
        }
        if(embeddingBounds$Dimension0 instanceof Pixel) {
            return Math.min(v, ((Pixel)embeddingBounds$Dimension0).getValue$window_release());
        }
        if(!q.b(embeddingBounds$Dimension0, Dimension.DIMENSION_HINGE)) {
            throw new IllegalArgumentException("Unhandled width dimension=" + this.width);
        }
        FoldingFeature foldingFeature0 = this.getOnlyFoldingFeatureOrNull(windowLayoutInfo0);
        q.d(foldingFeature0);
        Rect rect0 = foldingFeature0.getBounds();
        Alignment embeddingBounds$Alignment0 = this.alignment;
        if(q.b(embeddingBounds$Alignment0, Alignment.ALIGN_LEFT)) {
            return rect0.left - bounds0.getLeft();
        }
        if(!q.b(embeddingBounds$Alignment0, Alignment.ALIGN_RIGHT)) {
            throw new IllegalStateException("Unhandled condition to get height in pixel! embeddingBounds=" + this + " taskBounds=" + bounds0 + " windowLayoutInfo=" + windowLayoutInfo0);
        }
        return bounds0.getRight() - rect0.right;
    }

    @Override
    public int hashCode() {
        return this.height.hashCode() + (this.width.hashCode() + this.alignment.hashCode() * 0x1F) * 0x1F;
    }

    private final boolean isHorizontal(WindowLayoutInfo windowLayoutInfo0) {
        FoldingFeature foldingFeature0 = this.getOnlyFoldingFeatureOrNull(windowLayoutInfo0);
        return foldingFeature0 == null ? false : q.b(foldingFeature0.getOrientation(), Orientation.HORIZONTAL);
    }

    private final boolean isVertical(WindowLayoutInfo windowLayoutInfo0) {
        FoldingFeature foldingFeature0 = this.getOnlyFoldingFeatureOrNull(windowLayoutInfo0);
        return foldingFeature0 == null ? false : q.b(foldingFeature0.getOrientation(), Orientation.VERTICAL);
    }

    public final boolean shouldUseFallbackDimensionForHeight$window_release(@NotNull WindowLayoutInfo windowLayoutInfo0) {
        q.g(windowLayoutInfo0, "windowLayoutInfo");
        return q.b(this.height, Dimension.DIMENSION_HINGE) ? !this.isHorizontal(windowLayoutInfo0) || k.A(new Alignment[]{Alignment.ALIGN_LEFT, Alignment.ALIGN_RIGHT}).contains(this.alignment) : false;
    }

    public final boolean shouldUseFallbackDimensionForWidth$window_release(@NotNull WindowLayoutInfo windowLayoutInfo0) {
        q.g(windowLayoutInfo0, "windowLayoutInfo");
        return q.b(this.width, Dimension.DIMENSION_HINGE) ? !this.isVertical(windowLayoutInfo0) || k.A(new Alignment[]{Alignment.ALIGN_TOP, Alignment.ALIGN_BOTTOM}).contains(this.alignment) : false;
    }

    @Override
    @NotNull
    public String toString() {
        return "Bounds:{alignment=" + this.alignment + ", width=" + this.width + ", height=" + this.height + '}';
    }
}

