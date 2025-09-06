package androidx.window.embedding;

import H0.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0016BU\b\u0000\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0003\u0010\b\u001A\u00020\t\u0012\b\b\u0003\u0010\n\u001A\u00020\t\u0012\b\b\u0003\u0010\u000B\u001A\u00020\t\u0012\b\b\u0002\u0010\f\u001A\u00020\r\u0012\b\b\u0002\u0010\u000E\u001A\u00020\r¢\u0006\u0002\u0010\u000FJ\u0013\u0010\u0011\u001A\u00020\u00072\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001A\u00020\tH\u0016J\b\u0010\u0015\u001A\u00020\u0003H\u0016R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0010¨\u0006\u0017"}, d2 = {"Landroidx/window/embedding/SplitPinRule;", "Landroidx/window/embedding/SplitRule;", "tag", "", "defaultSplitAttributes", "Landroidx/window/embedding/SplitAttributes;", "isSticky", "", "minWidthDp", "", "minHeightDp", "minSmallestWidthDp", "maxAspectRatioInPortrait", "Landroidx/window/embedding/EmbeddingAspectRatio;", "maxAspectRatioInLandscape", "(Ljava/lang/String;Landroidx/window/embedding/SplitAttributes;ZIIILandroidx/window/embedding/EmbeddingAspectRatio;Landroidx/window/embedding/EmbeddingAspectRatio;)V", "()Z", "equals", "other", "", "hashCode", "toString", "Builder", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class SplitPinRule extends SplitRule {
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001A\u00020\u0011J\u000E\u0010\u0012\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u0004J\u000E\u0010\u0013\u001A\u00020\u00002\u0006\u0010\u0014\u001A\u00020\bJ\u000E\u0010\u0015\u001A\u00020\u00002\u0006\u0010\u0014\u001A\u00020\bJ\u0010\u0010\u0016\u001A\u00020\u00002\b\b\u0001\u0010\n\u001A\u00020\u000BJ\u0010\u0010\u0017\u001A\u00020\u00002\b\b\u0001\u0010\f\u001A\u00020\u000BJ\u0010\u0010\u0018\u001A\u00020\u00002\b\b\u0001\u0010\r\u001A\u00020\u000BJ\u000E\u0010\u0019\u001A\u00020\u00002\u0006\u0010\u0005\u001A\u00020\u0006J\u0010\u0010\u001A\u001A\u00020\u00002\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FR\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001A\u00020\u000B8\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001A\u00020\u000B8\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001A\u00020\u000B8\u0002@\u0002X\u0083\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2 = {"Landroidx/window/embedding/SplitPinRule$Builder;", "", "()V", "defaultSplitAttributes", "Landroidx/window/embedding/SplitAttributes;", "isSticky", "", "maxAspectRatioInLandscape", "Landroidx/window/embedding/EmbeddingAspectRatio;", "maxAspectRatioInPortrait", "minHeightDp", "", "minSmallestWidthDp", "minWidthDp", "tag", "", "build", "Landroidx/window/embedding/SplitPinRule;", "setDefaultSplitAttributes", "setMaxAspectRatioInLandscape", "aspectRatio", "setMaxAspectRatioInPortrait", "setMinHeightDp", "setMinSmallestWidthDp", "setMinWidthDp", "setSticky", "setTag", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Builder {
        @NotNull
        private SplitAttributes defaultSplitAttributes;
        private boolean isSticky;
        @NotNull
        private EmbeddingAspectRatio maxAspectRatioInLandscape;
        @NotNull
        private EmbeddingAspectRatio maxAspectRatioInPortrait;
        private int minHeightDp;
        private int minSmallestWidthDp;
        private int minWidthDp;
        @Nullable
        private String tag;

        public Builder() {
            this.minWidthDp = 600;
            this.minHeightDp = 600;
            this.minSmallestWidthDp = 600;
            this.maxAspectRatioInPortrait = SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT;
            this.maxAspectRatioInLandscape = SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT;
            this.defaultSplitAttributes = new androidx.window.embedding.SplitAttributes.Builder().build();
        }

        @NotNull
        public final SplitPinRule build() {
            return new SplitPinRule(this.tag, this.defaultSplitAttributes, this.isSticky, this.minWidthDp, this.minHeightDp, this.minSmallestWidthDp, this.maxAspectRatioInPortrait, this.maxAspectRatioInLandscape);
        }

        @NotNull
        public final Builder setDefaultSplitAttributes(@NotNull SplitAttributes splitAttributes0) {
            q.g(splitAttributes0, "defaultSplitAttributes");
            this.defaultSplitAttributes = splitAttributes0;
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

    private final boolean isSticky;

    public SplitPinRule(@Nullable String s, @NotNull SplitAttributes splitAttributes0, boolean z, int v, int v1, int v2, @NotNull EmbeddingAspectRatio embeddingAspectRatio0, @NotNull EmbeddingAspectRatio embeddingAspectRatio1) {
        q.g(splitAttributes0, "defaultSplitAttributes");
        q.g(embeddingAspectRatio0, "maxAspectRatioInPortrait");
        q.g(embeddingAspectRatio1, "maxAspectRatioInLandscape");
        super(s, v, v1, v2, embeddingAspectRatio0, embeddingAspectRatio1, splitAttributes0);
        this.isSticky = z;
    }

    public SplitPinRule(String s, SplitAttributes splitAttributes0, boolean z, int v, int v1, int v2, EmbeddingAspectRatio embeddingAspectRatio0, EmbeddingAspectRatio embeddingAspectRatio1, int v3, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v3 & 1) != 0) {
            s = null;
        }
        if((v3 & 8) != 0) {
            v = 600;
        }
        if((v3 & 16) != 0) {
            v1 = 600;
        }
        if((v3 & 0x20) != 0) {
            v2 = 600;
        }
        if((v3 & 0x40) != 0) {
            embeddingAspectRatio0 = SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT;
        }
        if((v3 & 0x80) != 0) {
            embeddingAspectRatio1 = SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT;
        }
        this(s, splitAttributes0, z, v, v1, v2, embeddingAspectRatio0, embeddingAspectRatio1);
    }

    @Override  // androidx.window.embedding.SplitRule
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof SplitPinRule)) {
            return false;
        }
        return super.equals(object0) ? this.isSticky == ((SplitPinRule)object0).isSticky : false;
    }

    @Override  // androidx.window.embedding.SplitRule
    public int hashCode() {
        return Boolean.hashCode(this.isSticky) + super.hashCode() * 0x1F;
    }

    public final boolean isSticky() {
        return this.isSticky;
    }

    @Override  // androidx.window.embedding.SplitRule
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SplitPinRule{tag=");
        stringBuilder0.append(this.getTag());
        stringBuilder0.append(", defaultSplitAttributes=");
        stringBuilder0.append(this.getDefaultSplitAttributes());
        stringBuilder0.append(", isSticky=");
        return b.k(stringBuilder0, this.isSticky, '}');
    }
}

