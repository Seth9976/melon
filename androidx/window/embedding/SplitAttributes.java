package androidx.window.embedding;

import android.annotation.SuppressLint;
import androidx.window.RequiresWindowSdkExtension;
import androidx.window.core.SpecificationComputer;
import androidx.window.core.VerificationMode;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\u0018\u0000 \u001B2\u00020\u0001:\u0004\u001A\u001B\u001C\u001DB/\b\u0002\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0016\u001A\u00020\u0017H\u0016J\b\u0010\u0018\u001A\u00020\u0019H\u0016R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u001E"}, d2 = {"Landroidx/window/embedding/SplitAttributes;", "", "splitType", "Landroidx/window/embedding/SplitAttributes$SplitType;", "layoutDirection", "Landroidx/window/embedding/SplitAttributes$LayoutDirection;", "animationParams", "Landroidx/window/embedding/EmbeddingAnimationParams;", "dividerAttributes", "Landroidx/window/embedding/DividerAttributes;", "(Landroidx/window/embedding/SplitAttributes$SplitType;Landroidx/window/embedding/SplitAttributes$LayoutDirection;Landroidx/window/embedding/EmbeddingAnimationParams;Landroidx/window/embedding/DividerAttributes;)V", "getAnimationParams", "()Landroidx/window/embedding/EmbeddingAnimationParams;", "getDividerAttributes", "()Landroidx/window/embedding/DividerAttributes;", "getLayoutDirection", "()Landroidx/window/embedding/SplitAttributes$LayoutDirection;", "getSplitType", "()Landroidx/window/embedding/SplitAttributes$SplitType;", "equals", "", "other", "hashCode", "", "toString", "", "Builder", "Companion", "LayoutDirection", "SplitType", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class SplitAttributes {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000F\b\u0010\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000E\u001A\u00020\u0003J\u0010\u0010\u000F\u001A\u00020\u00002\u0006\u0010\u0010\u001A\u00020\u0007H\u0007J\u0010\u0010\u0011\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\tH\u0007J\u000E\u0010\u0012\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000BJ\u000E\u0010\u0013\u001A\u00020\u00002\u0006\u0010\u0014\u001A\u00020\rR\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/window/embedding/SplitAttributes$Builder;", "", "original", "Landroidx/window/embedding/SplitAttributes;", "(Landroidx/window/embedding/SplitAttributes;)V", "()V", "animationParams", "Landroidx/window/embedding/EmbeddingAnimationParams;", "dividerAttributes", "Landroidx/window/embedding/DividerAttributes;", "layoutDirection", "Landroidx/window/embedding/SplitAttributes$LayoutDirection;", "splitType", "Landroidx/window/embedding/SplitAttributes$SplitType;", "build", "setAnimationParams", "params", "setDividerAttributes", "setLayoutDirection", "setSplitType", "type", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Builder {
        @NotNull
        private EmbeddingAnimationParams animationParams;
        @NotNull
        private DividerAttributes dividerAttributes;
        @NotNull
        private LayoutDirection layoutDirection;
        @NotNull
        private SplitType splitType;

        public Builder() {
            this.splitType = SplitType.SPLIT_TYPE_EQUAL;
            this.layoutDirection = LayoutDirection.LOCALE;
            this.animationParams = new androidx.window.embedding.EmbeddingAnimationParams.Builder().build();
            this.dividerAttributes = DividerAttributes.NO_DIVIDER;
        }

        public Builder(@NotNull SplitAttributes splitAttributes0) {
            q.g(splitAttributes0, "original");
            this();
            this.setSplitType(splitAttributes0.getSplitType()).setLayoutDirection(splitAttributes0.getLayoutDirection()).setAnimationParams(this.animationParams).setDividerAttributes(splitAttributes0.getDividerAttributes());
        }

        @NotNull
        public final SplitAttributes build() {
            return new SplitAttributes(this.splitType, this.layoutDirection, this.animationParams, this.dividerAttributes, null);
        }

        @RequiresWindowSdkExtension(version = 5)
        @NotNull
        public final Builder setAnimationParams(@NotNull EmbeddingAnimationParams embeddingAnimationParams0) {
            q.g(embeddingAnimationParams0, "params");
            this.animationParams = embeddingAnimationParams0;
            return this;
        }

        @RequiresWindowSdkExtension(version = 6)
        @NotNull
        public final Builder setDividerAttributes(@NotNull DividerAttributes dividerAttributes0) {
            q.g(dividerAttributes0, "dividerAttributes");
            this.dividerAttributes = dividerAttributes0;
            return this;
        }

        @NotNull
        public final Builder setLayoutDirection(@NotNull LayoutDirection splitAttributes$LayoutDirection0) {
            q.g(splitAttributes$LayoutDirection0, "layoutDirection");
            this.layoutDirection = splitAttributes$LayoutDirection0;
            return this;
        }

        @NotNull
        public final Builder setSplitType(@NotNull SplitType splitAttributes$SplitType0) {
            q.g(splitAttributes$SplitType0, "type");
            this.splitType = splitAttributes$SplitType0;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/window/embedding/SplitAttributes$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u000B"}, d2 = {"Landroidx/window/embedding/SplitAttributes$LayoutDirection;", "", "description", "", "value", "", "(Ljava/lang/String;I)V", "getValue$window_release", "()I", "toString", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class LayoutDirection {
        @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\t\u001A\u00020\u00042\b\b\u0001\u0010\n\u001A\u00020\u000BH\u0001¢\u0006\u0002\b\fR\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/window/embedding/SplitAttributes$LayoutDirection$Companion;", "", "()V", "BOTTOM_TO_TOP", "Landroidx/window/embedding/SplitAttributes$LayoutDirection;", "LEFT_TO_RIGHT", "LOCALE", "RIGHT_TO_LEFT", "TOP_TO_BOTTOM", "getLayoutDirectionFromValue", "value", "", "getLayoutDirectionFromValue$window_release", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
        public static final class androidx.window.embedding.SplitAttributes.LayoutDirection.Companion {
            private androidx.window.embedding.SplitAttributes.LayoutDirection.Companion() {
            }

            public androidx.window.embedding.SplitAttributes.LayoutDirection.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final LayoutDirection getLayoutDirectionFromValue$window_release(int v) {
                LayoutDirection splitAttributes$LayoutDirection0 = LayoutDirection.LEFT_TO_RIGHT;
                if(v == splitAttributes$LayoutDirection0.getValue$window_release()) {
                    return splitAttributes$LayoutDirection0;
                }
                LayoutDirection splitAttributes$LayoutDirection1 = LayoutDirection.RIGHT_TO_LEFT;
                if(v == splitAttributes$LayoutDirection1.getValue$window_release()) {
                    return splitAttributes$LayoutDirection1;
                }
                LayoutDirection splitAttributes$LayoutDirection2 = LayoutDirection.LOCALE;
                if(v == splitAttributes$LayoutDirection2.getValue$window_release()) {
                    return splitAttributes$LayoutDirection2;
                }
                LayoutDirection splitAttributes$LayoutDirection3 = LayoutDirection.TOP_TO_BOTTOM;
                if(v == splitAttributes$LayoutDirection3.getValue$window_release()) {
                    return splitAttributes$LayoutDirection3;
                }
                LayoutDirection splitAttributes$LayoutDirection4 = LayoutDirection.BOTTOM_TO_TOP;
                if(v != splitAttributes$LayoutDirection4.getValue$window_release()) {
                    throw new IllegalArgumentException("Undefined value:" + v);
                }
                return splitAttributes$LayoutDirection4;
            }
        }

        @NotNull
        public static final LayoutDirection BOTTOM_TO_TOP;
        @NotNull
        public static final androidx.window.embedding.SplitAttributes.LayoutDirection.Companion Companion;
        @NotNull
        public static final LayoutDirection LEFT_TO_RIGHT;
        @NotNull
        public static final LayoutDirection LOCALE;
        @NotNull
        public static final LayoutDirection RIGHT_TO_LEFT;
        @NotNull
        public static final LayoutDirection TOP_TO_BOTTOM;
        @NotNull
        private final String description;
        private final int value;

        static {
            LayoutDirection.Companion = new androidx.window.embedding.SplitAttributes.LayoutDirection.Companion(null);
            LayoutDirection.LOCALE = new LayoutDirection("LOCALE", 0);
            LayoutDirection.LEFT_TO_RIGHT = new LayoutDirection("LEFT_TO_RIGHT", 1);
            LayoutDirection.RIGHT_TO_LEFT = new LayoutDirection("RIGHT_TO_LEFT", 2);
            LayoutDirection.TOP_TO_BOTTOM = new LayoutDirection("TOP_TO_BOTTOM", 3);
            LayoutDirection.BOTTOM_TO_TOP = new LayoutDirection("BOTTOM_TO_TOP", 4);
        }

        private LayoutDirection(String s, int v) {
            this.description = s;
            this.value = v;
        }

        @NotNull
        public static final LayoutDirection getLayoutDirectionFromValue$window_release(int v) {
            return LayoutDirection.Companion.getLayoutDirectionFromValue$window_release(v);
        }

        public final int getValue$window_release() {
            return this.value;
        }

        @Override
        @NotNull
        public String toString() {
            return this.description;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000E\u001A\u00020\u000FH\u0016J\b\u0010\u0010\u001A\u00020\u0003H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Landroidx/window/embedding/SplitAttributes$SplitType;", "", "description", "", "value", "", "(Ljava/lang/String;F)V", "getDescription$window_release", "()Ljava/lang/String;", "getValue$window_release", "()F", "equals", "", "other", "hashCode", "", "toString", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class SplitType {
        @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0007\u001A\u00020\u00042\b\b\u0001\u0010\b\u001A\u00020\tH\u0001¢\u0006\u0002\b\nJ\u0012\u0010\u000B\u001A\u00020\u00042\b\b\u0001\u0010\u000B\u001A\u00020\tH\u0007R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/window/embedding/SplitAttributes$SplitType$Companion;", "", "()V", "SPLIT_TYPE_EQUAL", "Landroidx/window/embedding/SplitAttributes$SplitType;", "SPLIT_TYPE_EXPAND", "SPLIT_TYPE_HINGE", "buildSplitTypeFromValue", "value", "", "buildSplitTypeFromValue$window_release", "ratio", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
        public static final class androidx.window.embedding.SplitAttributes.SplitType.Companion {
            private androidx.window.embedding.SplitAttributes.SplitType.Companion() {
            }

            public androidx.window.embedding.SplitAttributes.SplitType.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @SuppressLint({"Range"})
            @NotNull
            public final SplitType buildSplitTypeFromValue$window_release(float f) {
                return f == SplitType.SPLIT_TYPE_EXPAND.getValue$window_release() ? SplitType.SPLIT_TYPE_EXPAND : this.ratio(f);
            }

            @NotNull
            public final SplitType ratio(float f) {
                q.f("SplitAttributes", "access$getTAG$cp(...)");
                Object object0 = androidx.window.core.SpecificationComputer.Companion.startSpecification$default(SpecificationComputer.Companion, f, "SplitAttributes", VerificationMode.STRICT, null, 4, null).require("Ratio must be in range (0.0, 1.0). Use SplitType.expandContainers() instead of 0 or 1.", new k() {
                    final float $ratio;

                    {
                        this.$ratio = f;
                        super(1);
                    }

                    public final Boolean invoke(float f) {
                        double f1 = (double)this.$ratio;
                        return 0.0 > f1 || f1 > 1.0 || n.Q(new Float[]{0.0f, 1.0f}, this.$ratio) ? false : true;
                    }

                    @Override  // we.k
                    public Object invoke(Object object0) {
                        return this.invoke(((Number)object0).floatValue());
                    }
                }).compute();
                q.d(object0);
                float f1 = ((Number)object0).floatValue();
                return new SplitType("ratio:" + f1, f1);
            }
        }

        @NotNull
        public static final androidx.window.embedding.SplitAttributes.SplitType.Companion Companion;
        @NotNull
        public static final SplitType SPLIT_TYPE_EQUAL;
        @NotNull
        public static final SplitType SPLIT_TYPE_EXPAND;
        @NotNull
        public static final SplitType SPLIT_TYPE_HINGE;
        @NotNull
        private final String description;
        private final float value;

        static {
            androidx.window.embedding.SplitAttributes.SplitType.Companion splitAttributes$SplitType$Companion0 = new androidx.window.embedding.SplitAttributes.SplitType.Companion(null);
            SplitType.Companion = splitAttributes$SplitType$Companion0;
            SplitType.SPLIT_TYPE_EXPAND = new SplitType("expandContainers", 0.0f);
            SplitType.SPLIT_TYPE_EQUAL = splitAttributes$SplitType$Companion0.ratio(0.5f);
            SplitType.SPLIT_TYPE_HINGE = new SplitType("hinge", -1.0f);
        }

        public SplitType(@NotNull String s, float f) {
            q.g(s, "description");
            super();
            this.description = s;
            this.value = f;
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(object0 == this) {
                return true;
            }
            return object0 instanceof SplitType ? this.value == ((SplitType)object0).value && q.b(this.description, ((SplitType)object0).description) : false;
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
        public static final SplitType ratio(float f) {
            return SplitType.Companion.ratio(f);
        }

        @Override
        @NotNull
        public String toString() {
            return this.description;
        }
    }

    @NotNull
    public static final Companion Companion;
    private static final String TAG;
    @NotNull
    private final EmbeddingAnimationParams animationParams;
    @NotNull
    private final DividerAttributes dividerAttributes;
    @NotNull
    private final LayoutDirection layoutDirection;
    @NotNull
    private final SplitType splitType;

    static {
        SplitAttributes.Companion = new Companion(null);
        SplitAttributes.TAG = "SplitAttributes";
    }

    private SplitAttributes(SplitType splitAttributes$SplitType0, LayoutDirection splitAttributes$LayoutDirection0, EmbeddingAnimationParams embeddingAnimationParams0, DividerAttributes dividerAttributes0) {
        this.splitType = splitAttributes$SplitType0;
        this.layoutDirection = splitAttributes$LayoutDirection0;
        this.animationParams = embeddingAnimationParams0;
        this.dividerAttributes = dividerAttributes0;
    }

    public SplitAttributes(SplitType splitAttributes$SplitType0, LayoutDirection splitAttributes$LayoutDirection0, EmbeddingAnimationParams embeddingAnimationParams0, DividerAttributes dividerAttributes0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            splitAttributes$SplitType0 = SplitType.SPLIT_TYPE_EQUAL;
        }
        if((v & 2) != 0) {
            splitAttributes$LayoutDirection0 = LayoutDirection.LOCALE;
        }
        if((v & 4) != 0) {
            embeddingAnimationParams0 = new androidx.window.embedding.EmbeddingAnimationParams.Builder().build();
        }
        if((v & 8) != 0) {
            dividerAttributes0 = DividerAttributes.NO_DIVIDER;
        }
        this(splitAttributes$SplitType0, splitAttributes$LayoutDirection0, embeddingAnimationParams0, dividerAttributes0);
    }

    public SplitAttributes(SplitType splitAttributes$SplitType0, LayoutDirection splitAttributes$LayoutDirection0, EmbeddingAnimationParams embeddingAnimationParams0, DividerAttributes dividerAttributes0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(splitAttributes$SplitType0, splitAttributes$LayoutDirection0, embeddingAnimationParams0, dividerAttributes0);
    }

    // 去混淆评级： 低(20)
    public static final String access$getTAG$cp() [...] // 潜在的解密器

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof SplitAttributes ? q.b(this.splitType, ((SplitAttributes)object0).splitType) && q.b(this.layoutDirection, ((SplitAttributes)object0).layoutDirection) && q.b(this.animationParams, ((SplitAttributes)object0).animationParams) && q.b(this.dividerAttributes, ((SplitAttributes)object0).dividerAttributes) : false;
    }

    @NotNull
    public final EmbeddingAnimationParams getAnimationParams() {
        return this.animationParams;
    }

    @NotNull
    public final DividerAttributes getDividerAttributes() {
        return this.dividerAttributes;
    }

    @NotNull
    public final LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    @NotNull
    public final SplitType getSplitType() {
        return this.splitType;
    }

    @Override
    public int hashCode() {
        return this.dividerAttributes.hashCode() + (this.animationParams.hashCode() + (this.layoutDirection.hashCode() + this.splitType.hashCode() * 0x1F) * 0x1F) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "SplitAttributes:{splitType=" + this.splitType + ", layoutDir=" + this.layoutDirection + ", animationParams=" + this.animationParams + ", dividerAttributes=" + this.dividerAttributes + " }";
    }
}

