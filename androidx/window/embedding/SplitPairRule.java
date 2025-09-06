package androidx.window.embedding;

import java.util.LinkedHashSet;
import java.util.Set;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001%By\b\u0000\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u000B\u001A\u00020\n\u0012\b\b\u0002\u0010\f\u001A\u00020\r\u0012\b\b\u0003\u0010\u000E\u001A\u00020\u000F\u0012\b\b\u0003\u0010\u0010\u001A\u00020\u000F\u0012\b\b\u0003\u0010\u0011\u001A\u00020\u000F\u0012\b\b\u0002\u0010\u0012\u001A\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001A\u00020\u0013¢\u0006\u0002\u0010\u0015J\u0013\u0010\u001D\u001A\u00020\r2\b\u0010\u001E\u001A\u0004\u0018\u00010\u001FH\u0096\u0002J\b\u0010 \u001A\u00020\u000FH\u0016J\u0016\u0010!\u001A\u00020\u00002\u0006\u0010\"\u001A\u00020\u0004H\u0080\u0002¢\u0006\u0002\b#J\b\u0010$\u001A\u00020\bH\u0016R\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0011\u0010\u000B\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001B¨\u0006&"}, d2 = {"Landroidx/window/embedding/SplitPairRule;", "Landroidx/window/embedding/SplitRule;", "filters", "", "Landroidx/window/embedding/SplitPairFilter;", "defaultSplitAttributes", "Landroidx/window/embedding/SplitAttributes;", "tag", "", "finishPrimaryWithSecondary", "Landroidx/window/embedding/SplitRule$FinishBehavior;", "finishSecondaryWithPrimary", "clearTop", "", "minWidthDp", "", "minHeightDp", "minSmallestWidthDp", "maxAspectRatioInPortrait", "Landroidx/window/embedding/EmbeddingAspectRatio;", "maxAspectRatioInLandscape", "(Ljava/util/Set;Landroidx/window/embedding/SplitAttributes;Ljava/lang/String;Landroidx/window/embedding/SplitRule$FinishBehavior;Landroidx/window/embedding/SplitRule$FinishBehavior;ZIIILandroidx/window/embedding/EmbeddingAspectRatio;Landroidx/window/embedding/EmbeddingAspectRatio;)V", "getClearTop", "()Z", "getFilters", "()Ljava/util/Set;", "getFinishPrimaryWithSecondary", "()Landroidx/window/embedding/SplitRule$FinishBehavior;", "getFinishSecondaryWithPrimary", "equals", "other", "", "hashCode", "plus", "filter", "plus$window_release", "toString", "Builder", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class SplitPairRule extends SplitRule {
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000F\b\u0010\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0013\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0006\u0010\u0019\u001A\u00020\u0003J\u000E\u0010\u001A\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\nJ\u000E\u0010\u001B\u001A\u00020\u00002\u0006\u0010\u000B\u001A\u00020\fJ\u000E\u0010\u001C\u001A\u00020\u00002\u0006\u0010\r\u001A\u00020\u000EJ\u000E\u0010\u001D\u001A\u00020\u00002\u0006\u0010\u000F\u001A\u00020\u000EJ\u000E\u0010\u001E\u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u0011J\u000E\u0010 \u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u0011J\u0010\u0010!\u001A\u00020\u00002\b\b\u0001\u0010\u0013\u001A\u00020\u0014J\u0010\u0010\"\u001A\u00020\u00002\b\b\u0001\u0010\u0015\u001A\u00020\u0014J\u0010\u0010#\u001A\u00020\u00002\b\b\u0001\u0010\u0016\u001A\u00020\u0014J\u0010\u0010$\u001A\u00020\u00002\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001A\u00020\u00148\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001A\u00020\u00148\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001A\u00020\u00148\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001A\u0004\u0018\u00010\u0018X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/window/embedding/SplitPairRule$Builder;", "", "original", "Landroidx/window/embedding/SplitPairRule;", "(Landroidx/window/embedding/SplitPairRule;)V", "filters", "", "Landroidx/window/embedding/SplitPairFilter;", "(Ljava/util/Set;)V", "clearTop", "", "defaultSplitAttributes", "Landroidx/window/embedding/SplitAttributes;", "finishPrimaryWithSecondary", "Landroidx/window/embedding/SplitRule$FinishBehavior;", "finishSecondaryWithPrimary", "maxAspectRatioInLandscape", "Landroidx/window/embedding/EmbeddingAspectRatio;", "maxAspectRatioInPortrait", "minHeightDp", "", "minSmallestWidthDp", "minWidthDp", "tag", "", "build", "setClearTop", "setDefaultSplitAttributes", "setFinishPrimaryWithSecondary", "setFinishSecondaryWithPrimary", "setMaxAspectRatioInLandscape", "aspectRatio", "setMaxAspectRatioInPortrait", "setMinHeightDp", "setMinSmallestWidthDp", "setMinWidthDp", "setTag", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Builder {
        private boolean clearTop;
        @NotNull
        private SplitAttributes defaultSplitAttributes;
        @NotNull
        private final Set filters;
        @NotNull
        private FinishBehavior finishPrimaryWithSecondary;
        @NotNull
        private FinishBehavior finishSecondaryWithPrimary;
        @NotNull
        private EmbeddingAspectRatio maxAspectRatioInLandscape;
        @NotNull
        private EmbeddingAspectRatio maxAspectRatioInPortrait;
        private int minHeightDp;
        private int minSmallestWidthDp;
        private int minWidthDp;
        @Nullable
        private String tag;

        public Builder(@NotNull SplitPairRule splitPairRule0) {
            q.g(splitPairRule0, "original");
            this(splitPairRule0.getFilters());
            this.setTag(splitPairRule0.getTag()).setMinWidthDp(splitPairRule0.getMinWidthDp()).setMinHeightDp(splitPairRule0.getMinHeightDp()).setMinSmallestWidthDp(splitPairRule0.getMinSmallestWidthDp()).setMaxAspectRatioInPortrait(splitPairRule0.getMaxAspectRatioInPortrait()).setMaxAspectRatioInLandscape(splitPairRule0.getMaxAspectRatioInLandscape()).setFinishPrimaryWithSecondary(splitPairRule0.getFinishPrimaryWithSecondary()).setFinishSecondaryWithPrimary(splitPairRule0.getFinishSecondaryWithPrimary()).setClearTop(splitPairRule0.getClearTop()).setDefaultSplitAttributes(splitPairRule0.getDefaultSplitAttributes());
        }

        public Builder(@NotNull Set set0) {
            q.g(set0, "filters");
            super();
            this.filters = set0;
            this.minWidthDp = 600;
            this.minHeightDp = 600;
            this.minSmallestWidthDp = 600;
            this.maxAspectRatioInPortrait = SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT;
            this.maxAspectRatioInLandscape = SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT;
            this.finishPrimaryWithSecondary = FinishBehavior.NEVER;
            this.finishSecondaryWithPrimary = FinishBehavior.ALWAYS;
            this.defaultSplitAttributes = new androidx.window.embedding.SplitAttributes.Builder().build();
        }

        @NotNull
        public final SplitPairRule build() {
            return new SplitPairRule(this.filters, this.defaultSplitAttributes, this.tag, this.finishPrimaryWithSecondary, this.finishSecondaryWithPrimary, this.clearTop, this.minWidthDp, this.minHeightDp, this.minSmallestWidthDp, this.maxAspectRatioInPortrait, this.maxAspectRatioInLandscape);
        }

        @NotNull
        public final Builder setClearTop(boolean z) {
            this.clearTop = z;
            return this;
        }

        @NotNull
        public final Builder setDefaultSplitAttributes(@NotNull SplitAttributes splitAttributes0) {
            q.g(splitAttributes0, "defaultSplitAttributes");
            this.defaultSplitAttributes = splitAttributes0;
            return this;
        }

        @NotNull
        public final Builder setFinishPrimaryWithSecondary(@NotNull FinishBehavior splitRule$FinishBehavior0) {
            q.g(splitRule$FinishBehavior0, "finishPrimaryWithSecondary");
            this.finishPrimaryWithSecondary = splitRule$FinishBehavior0;
            return this;
        }

        @NotNull
        public final Builder setFinishSecondaryWithPrimary(@NotNull FinishBehavior splitRule$FinishBehavior0) {
            q.g(splitRule$FinishBehavior0, "finishSecondaryWithPrimary");
            this.finishSecondaryWithPrimary = splitRule$FinishBehavior0;
            return this;
        }

        @NotNull
        public final Builder setMaxAspectRatioInLandscape(@NotNull EmbeddingAspectRatio embeddingAspectRatio0) {
            q.g(embeddingAspectRatio0, "aspectRatio");
            this.maxAspectRatioInLandscape = embeddingAspectRatio0;
            return this;
        }

        @NotNull
        public final Builder setMaxAspectRatioInPortrait(@NotNull EmbeddingAspectRatio embeddingAspectRatio0) {
            q.g(embeddingAspectRatio0, "aspectRatio");
            this.maxAspectRatioInPortrait = embeddingAspectRatio0;
            return this;
        }

        @NotNull
        public final Builder setMinHeightDp(int v) {
            this.minHeightDp = v;
            return this;
        }

        @NotNull
        public final Builder setMinSmallestWidthDp(int v) {
            this.minSmallestWidthDp = v;
            return this;
        }

        @NotNull
        public final Builder setMinWidthDp(int v) {
            this.minWidthDp = v;
            return this;
        }

        @NotNull
        public final Builder setTag(@Nullable String s) {
            this.tag = s;
            return this;
        }
    }

    private final boolean clearTop;
    @NotNull
    private final Set filters;
    @NotNull
    private final FinishBehavior finishPrimaryWithSecondary;
    @NotNull
    private final FinishBehavior finishSecondaryWithPrimary;

    public SplitPairRule(@NotNull Set set0, @NotNull SplitAttributes splitAttributes0, @Nullable String s, @NotNull FinishBehavior splitRule$FinishBehavior0, @NotNull FinishBehavior splitRule$FinishBehavior1, boolean z, int v, int v1, int v2, @NotNull EmbeddingAspectRatio embeddingAspectRatio0, @NotNull EmbeddingAspectRatio embeddingAspectRatio1) {
        q.g(set0, "filters");
        q.g(splitAttributes0, "defaultSplitAttributes");
        q.g(splitRule$FinishBehavior0, "finishPrimaryWithSecondary");
        q.g(splitRule$FinishBehavior1, "finishSecondaryWithPrimary");
        q.g(embeddingAspectRatio0, "maxAspectRatioInPortrait");
        q.g(embeddingAspectRatio1, "maxAspectRatioInLandscape");
        super(s, v, v1, v2, embeddingAspectRatio0, embeddingAspectRatio1, splitAttributes0);
        this.filters = set0;
        this.finishPrimaryWithSecondary = splitRule$FinishBehavior0;
        this.finishSecondaryWithPrimary = splitRule$FinishBehavior1;
        this.clearTop = z;
    }

    public SplitPairRule(Set set0, SplitAttributes splitAttributes0, String s, FinishBehavior splitRule$FinishBehavior0, FinishBehavior splitRule$FinishBehavior1, boolean z, int v, int v1, int v2, EmbeddingAspectRatio embeddingAspectRatio0, EmbeddingAspectRatio embeddingAspectRatio1, int v3, DefaultConstructorMarker defaultConstructorMarker0) {
        this(set0, splitAttributes0, ((v3 & 4) == 0 ? s : null), ((v3 & 8) == 0 ? splitRule$FinishBehavior0 : FinishBehavior.NEVER), ((v3 & 16) == 0 ? splitRule$FinishBehavior1 : FinishBehavior.ALWAYS), ((v3 & 0x20) == 0 ? z : false), ((v3 & 0x40) == 0 ? v : 600), ((v3 & 0x80) == 0 ? v1 : 600), ((v3 & 0x100) == 0 ? v2 : 600), ((v3 & 0x200) == 0 ? embeddingAspectRatio0 : SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT), ((v3 & 0x400) == 0 ? embeddingAspectRatio1 : SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT));
    }

    @Override  // androidx.window.embedding.SplitRule
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof SplitPairRule)) {
            return false;
        }
        if(!super.equals(object0)) {
            return false;
        }
        if(!q.b(this.filters, ((SplitPairRule)object0).filters)) {
            return false;
        }
        if(!q.b(this.finishPrimaryWithSecondary, ((SplitPairRule)object0).finishPrimaryWithSecondary)) {
            return false;
        }
        return q.b(this.finishSecondaryWithPrimary, ((SplitPairRule)object0).finishSecondaryWithPrimary) ? this.clearTop == ((SplitPairRule)object0).clearTop : false;
    }

    public final boolean getClearTop() {
        return this.clearTop;
    }

    @NotNull
    public final Set getFilters() {
        return this.filters;
    }

    @NotNull
    public final FinishBehavior getFinishPrimaryWithSecondary() {
        return this.finishPrimaryWithSecondary;
    }

    @NotNull
    public final FinishBehavior getFinishSecondaryWithPrimary() {
        return this.finishSecondaryWithPrimary;
    }

    @Override  // androidx.window.embedding.SplitRule
    public int hashCode() {
        return Boolean.hashCode(this.clearTop) + (this.finishSecondaryWithPrimary.hashCode() + (this.finishPrimaryWithSecondary.hashCode() + (this.filters.hashCode() + super.hashCode() * 0x1F) * 0x1F) * 0x1F) * 0x1F;
    }

    @NotNull
    public final SplitPairRule plus$window_release(@NotNull SplitPairFilter splitPairFilter0) {
        q.g(splitPairFilter0, "filter");
        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
        linkedHashSet0.addAll(this.filters);
        linkedHashSet0.add(splitPairFilter0);
        return new Builder(p.T0(linkedHashSet0)).setTag(this.getTag()).setMinWidthDp(this.getMinWidthDp()).setMinHeightDp(this.getMinHeightDp()).setMinSmallestWidthDp(this.getMinSmallestWidthDp()).setMaxAspectRatioInPortrait(this.getMaxAspectRatioInPortrait()).setMaxAspectRatioInLandscape(this.getMaxAspectRatioInLandscape()).setFinishPrimaryWithSecondary(this.finishPrimaryWithSecondary).setFinishSecondaryWithPrimary(this.finishSecondaryWithPrimary).setClearTop(this.clearTop).setDefaultSplitAttributes(this.getDefaultSplitAttributes()).build();
    }

    @Override  // androidx.window.embedding.SplitRule
    @NotNull
    public String toString() {
        return "SplitPairRule{tag=" + this.getTag() + ", defaultSplitAttributes=" + this.getDefaultSplitAttributes() + ", minWidthDp=" + this.getMinWidthDp() + ", minHeightDp=" + this.getMinHeightDp() + ", minSmallestWidthDp=" + this.getMinSmallestWidthDp() + ", maxAspectRatioInPortrait=" + this.getMaxAspectRatioInPortrait() + ", maxAspectRatioInLandscape=" + this.getMaxAspectRatioInLandscape() + ", clearTop=" + this.clearTop + ", finishPrimaryWithSecondary=" + this.finishPrimaryWithSecondary + ", finishSecondaryWithPrimary=" + this.finishSecondaryWithPrimary + ", filters=" + this.filters + '}';
    }
}

