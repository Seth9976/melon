package androidx.window.embedding;

import A7.d;
import android.content.Intent;
import java.util.LinkedHashSet;
import java.util.Set;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001&Bu\b\u0010\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f\u0012\b\b\u0003\u0010\r\u001A\u00020\u000E\u0012\b\b\u0003\u0010\u000F\u001A\u00020\u000E\u0012\b\b\u0003\u0010\u0010\u001A\u00020\u000E\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001A\u00020\u0012\u0012\u0006\u0010\u0014\u001A\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0013\u0010\u001E\u001A\u00020\n2\b\u0010\u001F\u001A\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001A\u00020\u000EH\u0016J\u0016\u0010\"\u001A\u00020\u00002\u0006\u0010#\u001A\u00020\u0006H\u0080\u0002¢\u0006\u0002\b$J\b\u0010%\u001A\u00020\u0003H\u0016R\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u001BR\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001D¨\u0006\'"}, d2 = {"Landroidx/window/embedding/SplitPlaceholderRule;", "Landroidx/window/embedding/SplitRule;", "tag", "", "filters", "", "Landroidx/window/embedding/ActivityFilter;", "placeholderIntent", "Landroid/content/Intent;", "isSticky", "", "finishPrimaryWithPlaceholder", "Landroidx/window/embedding/SplitRule$FinishBehavior;", "minWidthDp", "", "minHeightDp", "minSmallestWidthDp", "maxAspectRatioInPortrait", "Landroidx/window/embedding/EmbeddingAspectRatio;", "maxAspectRatioInLandscape", "defaultSplitAttributes", "Landroidx/window/embedding/SplitAttributes;", "(Ljava/lang/String;Ljava/util/Set;Landroid/content/Intent;ZLandroidx/window/embedding/SplitRule$FinishBehavior;IIILandroidx/window/embedding/EmbeddingAspectRatio;Landroidx/window/embedding/EmbeddingAspectRatio;Landroidx/window/embedding/SplitAttributes;)V", "getFilters", "()Ljava/util/Set;", "getFinishPrimaryWithPlaceholder", "()Landroidx/window/embedding/SplitRule$FinishBehavior;", "()Z", "getPlaceholderIntent", "()Landroid/content/Intent;", "equals", "other", "", "hashCode", "plus", "filter", "plus$window_release", "toString", "Builder", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class SplitPlaceholderRule extends SplitRule {
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000F\b\u0010\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001B\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u001A\u001A\u00020\u0003J\u000E\u0010\u001B\u001A\u00020\u00002\u0006\u0010\u000B\u001A\u00020\fJ\u000E\u0010\u001C\u001A\u00020\u00002\u0006\u0010\r\u001A\u00020\u000EJ\u000E\u0010\u001D\u001A\u00020\u00002\u0006\u0010\u001E\u001A\u00020\u0012J\u000E\u0010\u001F\u001A\u00020\u00002\u0006\u0010\u001E\u001A\u00020\u0012J\u0010\u0010 \u001A\u00020\u00002\b\b\u0001\u0010\u0014\u001A\u00020\u0015J\u0010\u0010!\u001A\u00020\u00002\b\b\u0001\u0010\u0016\u001A\u00020\u0015J\u0010\u0010\"\u001A\u00020\u00002\b\b\u0001\u0010\u0017\u001A\u00020\u0015J\u000E\u0010#\u001A\u00020\u00002\u0006\u0010\u000F\u001A\u00020\u0010J\u0010\u0010$\u001A\u00020\u00002\b\u0010\u0018\u001A\u0004\u0018\u00010\u0019R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001A\u00020\u00158\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001A\u00020\u00158\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001A\u00020\u00158\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001A\u0004\u0018\u00010\u0019X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/window/embedding/SplitPlaceholderRule$Builder;", "", "original", "Landroidx/window/embedding/SplitPlaceholderRule;", "(Landroidx/window/embedding/SplitPlaceholderRule;)V", "filters", "", "Landroidx/window/embedding/ActivityFilter;", "placeholderIntent", "Landroid/content/Intent;", "(Ljava/util/Set;Landroid/content/Intent;)V", "defaultSplitAttributes", "Landroidx/window/embedding/SplitAttributes;", "finishPrimaryWithPlaceholder", "Landroidx/window/embedding/SplitRule$FinishBehavior;", "isSticky", "", "maxAspectRatioInLandscape", "Landroidx/window/embedding/EmbeddingAspectRatio;", "maxAspectRatioInPortrait", "minHeightDp", "", "minSmallestWidthDp", "minWidthDp", "tag", "", "build", "setDefaultSplitAttributes", "setFinishPrimaryWithPlaceholder", "setMaxAspectRatioInLandscape", "aspectRatio", "setMaxAspectRatioInPortrait", "setMinHeightDp", "setMinSmallestWidthDp", "setMinWidthDp", "setSticky", "setTag", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Builder {
        @NotNull
        private SplitAttributes defaultSplitAttributes;
        @NotNull
        private final Set filters;
        @NotNull
        private FinishBehavior finishPrimaryWithPlaceholder;
        private boolean isSticky;
        @NotNull
        private EmbeddingAspectRatio maxAspectRatioInLandscape;
        @NotNull
        private EmbeddingAspectRatio maxAspectRatioInPortrait;
        private int minHeightDp;
        private int minSmallestWidthDp;
        private int minWidthDp;
        @NotNull
        private final Intent placeholderIntent;
        @Nullable
        private String tag;

        public Builder(@NotNull SplitPlaceholderRule splitPlaceholderRule0) {
            q.g(splitPlaceholderRule0, "original");
            this(splitPlaceholderRule0.getFilters(), splitPlaceholderRule0.getPlaceholderIntent());
            this.setTag(splitPlaceholderRule0.getTag()).setMinWidthDp(splitPlaceholderRule0.getMinWidthDp()).setMinHeightDp(splitPlaceholderRule0.getMinHeightDp()).setMinSmallestWidthDp(splitPlaceholderRule0.getMinSmallestWidthDp()).setMaxAspectRatioInPortrait(splitPlaceholderRule0.getMaxAspectRatioInPortrait()).setMaxAspectRatioInLandscape(splitPlaceholderRule0.getMaxAspectRatioInLandscape()).setFinishPrimaryWithPlaceholder(splitPlaceholderRule0.getFinishPrimaryWithPlaceholder()).setSticky(splitPlaceholderRule0.isSticky()).setDefaultSplitAttributes(splitPlaceholderRule0.getDefaultSplitAttributes());
        }

        public Builder(@NotNull Set set0, @NotNull Intent intent0) {
            q.g(set0, "filters");
            q.g(intent0, "placeholderIntent");
            super();
            this.filters = set0;
            this.placeholderIntent = intent0;
            this.minWidthDp = 600;
            this.minHeightDp = 600;
            this.minSmallestWidthDp = 600;
            this.maxAspectRatioInPortrait = SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT;
            this.maxAspectRatioInLandscape = SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT;
            this.finishPrimaryWithPlaceholder = FinishBehavior.ALWAYS;
            this.defaultSplitAttributes = new androidx.window.embedding.SplitAttributes.Builder().build();
        }

        @NotNull
        public final SplitPlaceholderRule build() {
            return new SplitPlaceholderRule(this.tag, this.filters, this.placeholderIntent, this.isSticky, this.finishPrimaryWithPlaceholder, this.minWidthDp, this.minHeightDp, this.minSmallestWidthDp, this.maxAspectRatioInPortrait, this.maxAspectRatioInLandscape, this.defaultSplitAttributes);
        }

        @NotNull
        public final Builder setDefaultSplitAttributes(@NotNull SplitAttributes splitAttributes0) {
            q.g(splitAttributes0, "defaultSplitAttributes");
            this.defaultSplitAttributes = splitAttributes0;
            return this;
        }

        @NotNull
        public final Builder setFinishPrimaryWithPlaceholder(@NotNull FinishBehavior splitRule$FinishBehavior0) {
            q.g(splitRule$FinishBehavior0, "finishPrimaryWithPlaceholder");
            this.finishPrimaryWithPlaceholder = splitRule$FinishBehavior0;
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
        public final Builder setSticky(boolean z) {
            this.isSticky = z;
            return this;
        }

        @NotNull
        public final Builder setTag(@Nullable String s) {
            this.tag = s;
            return this;
        }
    }

    @NotNull
    private final Set filters;
    @NotNull
    private final FinishBehavior finishPrimaryWithPlaceholder;
    private final boolean isSticky;
    @NotNull
    private final Intent placeholderIntent;

    public SplitPlaceholderRule(@Nullable String s, @NotNull Set set0, @NotNull Intent intent0, boolean z, @NotNull FinishBehavior splitRule$FinishBehavior0, int v, int v1, int v2, @NotNull EmbeddingAspectRatio embeddingAspectRatio0, @NotNull EmbeddingAspectRatio embeddingAspectRatio1, @NotNull SplitAttributes splitAttributes0) {
        q.g(set0, "filters");
        q.g(intent0, "placeholderIntent");
        q.g(splitRule$FinishBehavior0, "finishPrimaryWithPlaceholder");
        q.g(embeddingAspectRatio0, "maxAspectRatioInPortrait");
        q.g(embeddingAspectRatio1, "maxAspectRatioInLandscape");
        q.g(splitAttributes0, "defaultSplitAttributes");
        super(s, v, v1, v2, embeddingAspectRatio0, embeddingAspectRatio1, splitAttributes0);
        if(splitRule$FinishBehavior0.equals(FinishBehavior.NEVER)) {
            throw new IllegalArgumentException("NEVER is not a valid configuration for SplitPlaceholderRule. Please use FINISH_ALWAYS or FINISH_ADJACENT instead or refer to the current API.");
        }
        this.filters = p.T0(set0);
        this.placeholderIntent = intent0;
        this.isSticky = z;
        this.finishPrimaryWithPlaceholder = splitRule$FinishBehavior0;
    }

    public SplitPlaceholderRule(String s, Set set0, Intent intent0, boolean z, FinishBehavior splitRule$FinishBehavior0, int v, int v1, int v2, EmbeddingAspectRatio embeddingAspectRatio0, EmbeddingAspectRatio embeddingAspectRatio1, SplitAttributes splitAttributes0, int v3, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v3 & 1) != 0) {
            s = null;
        }
        if((v3 & 16) != 0) {
            splitRule$FinishBehavior0 = FinishBehavior.ALWAYS;
        }
        if((v3 & 0x20) != 0) {
            v = 600;
        }
        if((v3 & 0x40) != 0) {
            v1 = 600;
        }
        if((v3 & 0x80) != 0) {
            v2 = 600;
        }
        if((v3 & 0x100) != 0) {
            embeddingAspectRatio0 = SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT;
        }
        if((v3 & 0x200) != 0) {
            embeddingAspectRatio1 = SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT;
        }
        this(s, set0, intent0, z, splitRule$FinishBehavior0, v, v1, v2, embeddingAspectRatio0, embeddingAspectRatio1, splitAttributes0);
    }

    @Override  // androidx.window.embedding.SplitRule
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof SplitPlaceholderRule)) {
            return false;
        }
        if(!super.equals(object0)) {
            return false;
        }
        if(!q.b(this.placeholderIntent, ((SplitPlaceholderRule)object0).placeholderIntent)) {
            return false;
        }
        if(this.isSticky != ((SplitPlaceholderRule)object0).isSticky) {
            return false;
        }
        return q.b(this.finishPrimaryWithPlaceholder, ((SplitPlaceholderRule)object0).finishPrimaryWithPlaceholder) ? q.b(this.filters, ((SplitPlaceholderRule)object0).filters) : false;
    }

    @NotNull
    public final Set getFilters() {
        return this.filters;
    }

    @NotNull
    public final FinishBehavior getFinishPrimaryWithPlaceholder() {
        return this.finishPrimaryWithPlaceholder;
    }

    @NotNull
    public final Intent getPlaceholderIntent() {
        return this.placeholderIntent;
    }

    @Override  // androidx.window.embedding.SplitRule
    public int hashCode() {
        return this.filters.hashCode() + (this.finishPrimaryWithPlaceholder.hashCode() + d.e((this.placeholderIntent.hashCode() + super.hashCode() * 0x1F) * 0x1F, 0x1F, this.isSticky)) * 0x1F;
    }

    public final boolean isSticky() {
        return this.isSticky;
    }

    @NotNull
    public final SplitPlaceholderRule plus$window_release(@NotNull ActivityFilter activityFilter0) {
        q.g(activityFilter0, "filter");
        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
        linkedHashSet0.addAll(this.filters);
        linkedHashSet0.add(activityFilter0);
        return new Builder(p.T0(linkedHashSet0), this.placeholderIntent).setTag(this.getTag()).setMinWidthDp(this.getMinWidthDp()).setMinHeightDp(this.getMinHeightDp()).setMinSmallestWidthDp(this.getMinSmallestWidthDp()).setMaxAspectRatioInPortrait(this.getMaxAspectRatioInPortrait()).setMaxAspectRatioInLandscape(this.getMaxAspectRatioInLandscape()).setSticky(this.isSticky).setFinishPrimaryWithPlaceholder(this.finishPrimaryWithPlaceholder).setDefaultSplitAttributes(this.getDefaultSplitAttributes()).build();
    }

    @Override  // androidx.window.embedding.SplitRule
    @NotNull
    public String toString() {
        return "SplitPlaceholderRule{tag=" + this.getTag() + ", defaultSplitAttributes=" + this.getDefaultSplitAttributes() + ", minWidthDp=" + this.getMinWidthDp() + ", minHeightDp=" + this.getMinHeightDp() + ", minSmallestWidthDp=" + this.getMinSmallestWidthDp() + ", maxAspectRatioInPortrait=" + this.getMaxAspectRatioInPortrait() + ", maxAspectRatioInLandscape=" + this.getMaxAspectRatioInLandscape() + ", placeholderIntent=" + this.placeholderIntent + ", isSticky=" + this.isSticky + ", finishPrimaryWithPlaceholder=" + this.finishPrimaryWithPlaceholder + ", filters=" + this.filters + '}';
    }
}

