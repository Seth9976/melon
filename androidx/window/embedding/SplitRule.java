package androidx.window.embedding;

import Q1.c;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.WindowMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0016\u0018\u0000 -2\u00020\u0001:\u0004+,-.BM\b\u0000\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0003\u0010\u0007\u001A\u00020\u0005\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\b\b\u0002\u0010\n\u001A\u00020\t\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0002\u0010\rJ\u001D\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001CH\u0000¢\u0006\u0002\b\u001DJ\u001D\u0010\u001E\u001A\u00020\u00182\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\"H\u0000¢\u0006\u0002\b#J\u001A\u0010$\u001A\u00020\u00052\u0006\u0010\u0019\u001A\u00020\u001A2\b\b\u0001\u0010%\u001A\u00020\u0005H\u0002J\u0013\u0010&\u001A\u00020\u00182\b\u0010\'\u001A\u0004\u0018\u00010(H\u0096\u0002J\b\u0010)\u001A\u00020\u0005H\u0016J\b\u0010*\u001A\u00020\u0003H\u0016R\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\n\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0014¨\u0006/"}, d2 = {"Landroidx/window/embedding/SplitRule;", "Landroidx/window/embedding/EmbeddingRule;", "tag", "", "minWidthDp", "", "minHeightDp", "minSmallestWidthDp", "maxAspectRatioInPortrait", "Landroidx/window/embedding/EmbeddingAspectRatio;", "maxAspectRatioInLandscape", "defaultSplitAttributes", "Landroidx/window/embedding/SplitAttributes;", "(Ljava/lang/String;IIILandroidx/window/embedding/EmbeddingAspectRatio;Landroidx/window/embedding/EmbeddingAspectRatio;Landroidx/window/embedding/SplitAttributes;)V", "getDefaultSplitAttributes", "()Landroidx/window/embedding/SplitAttributes;", "getMaxAspectRatioInLandscape", "()Landroidx/window/embedding/EmbeddingAspectRatio;", "getMaxAspectRatioInPortrait", "getMinHeightDp", "()I", "getMinSmallestWidthDp", "getMinWidthDp", "checkParentBounds", "", "density", "", "bounds", "Landroid/graphics/Rect;", "checkParentBounds$window_release", "checkParentMetrics", "context", "Landroid/content/Context;", "parentMetrics", "Landroid/view/WindowMetrics;", "checkParentMetrics$window_release", "convertDpToPx", "dimensionDp", "equals", "other", "", "hashCode", "toString", "Api30Impl", "Api34Impl", "Companion", "FinishBehavior", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public class SplitRule extends EmbeddingRule {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\u0007"}, d2 = {"Landroidx/window/embedding/SplitRule$Api30Impl;", "", "()V", "getBounds", "Landroid/graphics/Rect;", "windowMetrics", "Landroid/view/WindowMetrics;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Api30Impl {
        @NotNull
        public static final Api30Impl INSTANCE;

        static {
            Api30Impl.INSTANCE = new Api30Impl();
        }

        @NotNull
        public final Rect getBounds(@NotNull WindowMetrics windowMetrics0) {
            q.g(windowMetrics0, "windowMetrics");
            Rect rect0 = windowMetrics0.getBounds();
            q.f(rect0, "getBounds(...)");
            return rect0;
        }
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b¨\u0006\t"}, d2 = {"Landroidx/window/embedding/SplitRule$Api34Impl;", "", "()V", "getDensity", "", "windowMetrics", "Landroid/view/WindowMetrics;", "context", "Landroid/content/Context;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Api34Impl {
        @NotNull
        public static final Api34Impl INSTANCE;

        static {
            Api34Impl.INSTANCE = new Api34Impl();
        }

        public final float getDensity(@NotNull WindowMetrics windowMetrics0, @NotNull Context context0) {
            q.g(windowMetrics0, "windowMetrics");
            q.g(context0, "context");
            try {
                return windowMetrics0.getDensity();
            }
            catch(NoSuchMethodError unused_ex) {
                return context0.getResources().getDisplayMetrics().density;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/window/embedding/SplitRule$Companion;", "", "()V", "SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT", "Landroidx/window/embedding/EmbeddingAspectRatio;", "SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT", "SPLIT_MIN_DIMENSION_ALWAYS_ALLOW", "", "SPLIT_MIN_DIMENSION_DP_DEFAULT", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u000B"}, d2 = {"Landroidx/window/embedding/SplitRule$FinishBehavior;", "", "description", "", "value", "", "(Ljava/lang/String;I)V", "getValue$window_release", "()I", "toString", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class FinishBehavior {
        @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0007\u001A\u00020\u00042\b\b\u0001\u0010\b\u001A\u00020\tH\u0001¢\u0006\u0002\b\nR\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Landroidx/window/embedding/SplitRule$FinishBehavior$Companion;", "", "()V", "ADJACENT", "Landroidx/window/embedding/SplitRule$FinishBehavior;", "ALWAYS", "NEVER", "getFinishBehaviorFromValue", "value", "", "getFinishBehaviorFromValue$window_release", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
        public static final class androidx.window.embedding.SplitRule.FinishBehavior.Companion {
            private androidx.window.embedding.SplitRule.FinishBehavior.Companion() {
            }

            public androidx.window.embedding.SplitRule.FinishBehavior.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final FinishBehavior getFinishBehaviorFromValue$window_release(int v) {
                FinishBehavior splitRule$FinishBehavior0 = FinishBehavior.NEVER;
                if(v == splitRule$FinishBehavior0.getValue$window_release()) {
                    return splitRule$FinishBehavior0;
                }
                FinishBehavior splitRule$FinishBehavior1 = FinishBehavior.ALWAYS;
                if(v == splitRule$FinishBehavior1.getValue$window_release()) {
                    return splitRule$FinishBehavior1;
                }
                FinishBehavior splitRule$FinishBehavior2 = FinishBehavior.ADJACENT;
                if(v != splitRule$FinishBehavior2.getValue$window_release()) {
                    throw new IllegalArgumentException("Unknown finish behavior:" + v);
                }
                return splitRule$FinishBehavior2;
            }
        }

        @NotNull
        public static final FinishBehavior ADJACENT;
        @NotNull
        public static final FinishBehavior ALWAYS;
        @NotNull
        public static final androidx.window.embedding.SplitRule.FinishBehavior.Companion Companion;
        @NotNull
        public static final FinishBehavior NEVER;
        @NotNull
        private final String description;
        private final int value;

        static {
            FinishBehavior.Companion = new androidx.window.embedding.SplitRule.FinishBehavior.Companion(null);
            FinishBehavior.NEVER = new FinishBehavior("NEVER", 0);
            FinishBehavior.ALWAYS = new FinishBehavior("ALWAYS", 1);
            FinishBehavior.ADJACENT = new FinishBehavior("ADJACENT", 2);
        }

        private FinishBehavior(String s, int v) {
            this.description = s;
            this.value = v;
        }

        @NotNull
        public static final FinishBehavior getFinishBehaviorFromValue$window_release(int v) {
            return FinishBehavior.Companion.getFinishBehaviorFromValue$window_release(v);
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

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final EmbeddingAspectRatio SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT = null;
    @NotNull
    public static final EmbeddingAspectRatio SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT = null;
    public static final int SPLIT_MIN_DIMENSION_ALWAYS_ALLOW = 0;
    public static final int SPLIT_MIN_DIMENSION_DP_DEFAULT = 600;
    @NotNull
    private final SplitAttributes defaultSplitAttributes;
    @NotNull
    private final EmbeddingAspectRatio maxAspectRatioInLandscape;
    @NotNull
    private final EmbeddingAspectRatio maxAspectRatioInPortrait;
    private final int minHeightDp;
    private final int minSmallestWidthDp;
    private final int minWidthDp;

    static {
        SplitRule.Companion = new Companion(null);
        SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT = EmbeddingAspectRatio.Companion.ratio(1.4f);
        SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT = EmbeddingAspectRatio.ALWAYS_ALLOW;
    }

    public SplitRule(@Nullable String s, int v, int v1, int v2, @NotNull EmbeddingAspectRatio embeddingAspectRatio0, @NotNull EmbeddingAspectRatio embeddingAspectRatio1, @NotNull SplitAttributes splitAttributes0) {
        q.g(embeddingAspectRatio0, "maxAspectRatioInPortrait");
        q.g(embeddingAspectRatio1, "maxAspectRatioInLandscape");
        q.g(splitAttributes0, "defaultSplitAttributes");
        super(s);
        this.minWidthDp = v;
        this.minHeightDp = v1;
        this.minSmallestWidthDp = v2;
        this.maxAspectRatioInPortrait = embeddingAspectRatio0;
        this.maxAspectRatioInLandscape = embeddingAspectRatio1;
        this.defaultSplitAttributes = splitAttributes0;
        c.n(v, "minWidthDp must be non-negative");
        c.n(v1, "minHeightDp must be non-negative");
        c.n(v2, "minSmallestWidthDp must be non-negative");
    }

    public SplitRule(String s, int v, int v1, int v2, EmbeddingAspectRatio embeddingAspectRatio0, EmbeddingAspectRatio embeddingAspectRatio1, SplitAttributes splitAttributes0, int v3, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v3 & 1) != 0) {
            s = null;
        }
        if((v3 & 2) != 0) {
            v = 600;
        }
        if((v3 & 4) != 0) {
            v1 = 600;
        }
        if((v3 & 8) != 0) {
            v2 = 600;
        }
        if((v3 & 16) != 0) {
            embeddingAspectRatio0 = SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT;
        }
        if((v3 & 0x20) != 0) {
            embeddingAspectRatio1 = SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT;
        }
        this(s, v, v1, v2, embeddingAspectRatio0, embeddingAspectRatio1, splitAttributes0);
    }

    public final boolean checkParentBounds$window_release(float f, @NotNull Rect rect0) {
        q.g(rect0, "bounds");
        int v = rect0.width();
        int v1 = rect0.height();
        if(v != 0 && v1 != 0) {
            boolean z = this.minWidthDp == 0 || v >= ((int)(((float)this.minWidthDp) * f + 0.5f));
            boolean z1 = this.minHeightDp == 0 || v1 >= ((int)(((float)this.minHeightDp) * f + 0.5f));
            boolean z2 = this.minSmallestWidthDp == 0 || Math.min(v, v1) >= ((int)(((float)this.minSmallestWidthDp) * f + 0.5f));
            if(v1 >= v) {
                return q.b(this.maxAspectRatioInPortrait, EmbeddingAspectRatio.ALWAYS_ALLOW) || ((float)v1) * 1.0f / ((float)v) <= this.maxAspectRatioInPortrait.getValue$window_release() ? z && z1 && z2 : false;
            }
            return !q.b(this.maxAspectRatioInLandscape, EmbeddingAspectRatio.ALWAYS_ALLOW) && ((float)v) * 1.0f / ((float)v1) > this.maxAspectRatioInLandscape.getValue$window_release() ? false : z && z1 && z2;
        }
        return false;
    }

    public final boolean checkParentMetrics$window_release(@NotNull Context context0, @NotNull WindowMetrics windowMetrics0) {
        q.g(context0, "context");
        q.g(windowMetrics0, "parentMetrics");
        int v = Build.VERSION.SDK_INT;
        if(v <= 30) {
            return false;
        }
        Rect rect0 = Api30Impl.INSTANCE.getBounds(windowMetrics0);
        return v > 33 ? this.checkParentBounds$window_release(Api34Impl.INSTANCE.getDensity(windowMetrics0, context0), rect0) : this.checkParentBounds$window_release(context0.getResources().getDisplayMetrics().density, rect0);
    }

    private final int convertDpToPx(float f, int v) [...] // Inlined contents

    @Override  // androidx.window.embedding.EmbeddingRule
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof SplitRule)) {
            return false;
        }
        if(!super.equals(object0)) {
            return false;
        }
        if(this.minWidthDp != ((SplitRule)object0).minWidthDp) {
            return false;
        }
        if(this.minHeightDp != ((SplitRule)object0).minHeightDp) {
            return false;
        }
        if(this.minSmallestWidthDp != ((SplitRule)object0).minSmallestWidthDp) {
            return false;
        }
        if(!q.b(this.maxAspectRatioInPortrait, ((SplitRule)object0).maxAspectRatioInPortrait)) {
            return false;
        }
        return q.b(this.maxAspectRatioInLandscape, ((SplitRule)object0).maxAspectRatioInLandscape) ? q.b(this.defaultSplitAttributes, ((SplitRule)object0).defaultSplitAttributes) : false;
    }

    @NotNull
    public final SplitAttributes getDefaultSplitAttributes() {
        return this.defaultSplitAttributes;
    }

    @NotNull
    public final EmbeddingAspectRatio getMaxAspectRatioInLandscape() {
        return this.maxAspectRatioInLandscape;
    }

    @NotNull
    public final EmbeddingAspectRatio getMaxAspectRatioInPortrait() {
        return this.maxAspectRatioInPortrait;
    }

    public final int getMinHeightDp() {
        return this.minHeightDp;
    }

    public final int getMinSmallestWidthDp() {
        return this.minSmallestWidthDp;
    }

    public final int getMinWidthDp() {
        return this.minWidthDp;
    }

    @Override  // androidx.window.embedding.EmbeddingRule
    public int hashCode() {
        return this.defaultSplitAttributes.hashCode() + (this.maxAspectRatioInLandscape.hashCode() + (this.maxAspectRatioInPortrait.hashCode() + (((super.hashCode() * 0x1F + this.minWidthDp) * 0x1F + this.minHeightDp) * 0x1F + this.minSmallestWidthDp) * 0x1F) * 0x1F) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "SplitRule{ tag=" + this.getTag() + ", defaultSplitAttributes=" + this.defaultSplitAttributes + ", minWidthDp=" + this.minWidthDp + ", minHeightDp=" + this.minHeightDp + ", minSmallestWidthDp=" + this.minSmallestWidthDp + ", maxAspectRatioInPortrait=" + this.maxAspectRatioInPortrait + ", maxAspectRatioInLandscape=" + this.maxAspectRatioInLandscape + '}';
    }
}

