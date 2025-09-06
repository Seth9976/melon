package androidx.window.embedding;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB\u001B\b\u0007\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000B\u001A\u00020\u0003H\u0016R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u000E"}, d2 = {"Landroidx/window/embedding/OverlayCreateParams;", "", "tag", "", "overlayAttributes", "Landroidx/window/embedding/OverlayAttributes;", "(Ljava/lang/String;Landroidx/window/embedding/OverlayAttributes;)V", "getOverlayAttributes", "()Landroidx/window/embedding/OverlayAttributes;", "getTag", "()Ljava/lang/String;", "toString", "Builder", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class OverlayCreateParams {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001A\u00020\bJ\u000E\u0010\t\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0004J\u000E\u0010\u000B\u001A\u00020\u00002\u0006\u0010\u0005\u001A\u00020\u0006R\u0010\u0010\u0003\u001A\u0004\u0018\u00010\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/window/embedding/OverlayCreateParams$Builder;", "", "()V", "launchAttrs", "Landroidx/window/embedding/OverlayAttributes;", "tag", "", "build", "Landroidx/window/embedding/OverlayCreateParams;", "setOverlayAttributes", "attrs", "setTag", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Builder {
        @Nullable
        private OverlayAttributes launchAttrs;
        @Nullable
        private String tag;

        // 去混淆评级： 低(40)
        @NotNull
        public final OverlayCreateParams build() {
            return new OverlayCreateParams((this.tag == null ? "871dba61-022b-49e8-abce-150b92a3a" : this.tag), (this.launchAttrs == null ? new androidx.window.embedding.OverlayAttributes.Builder().build() : this.launchAttrs));
        }

        @NotNull
        public final Builder setOverlayAttributes(@NotNull OverlayAttributes overlayAttributes0) {
            q.g(overlayAttributes0, "attrs");
            this.launchAttrs = overlayAttributes0;
            return this;
        }

        @NotNull
        public final Builder setTag(@NotNull String s) {
            q.g(s, "tag");
            this.tag = s;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001A\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Landroidx/window/embedding/OverlayCreateParams$Companion;", "", "()V", "generateOverlayTag", "", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        // 去混淆评级： 低(40)
        @NotNull
        public final String generateOverlayTag() [...] // 潜在的解密器
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final OverlayAttributes overlayAttributes;
    @NotNull
    private final String tag;

    static {
        OverlayCreateParams.Companion = new Companion(null);
    }

    public OverlayCreateParams() {
        this(null, null, 3, null);
    }

    public OverlayCreateParams(@NotNull String s) {
        q.g(s, "tag");
        this(s, null, 2, null);
    }

    public OverlayCreateParams(@NotNull String s, @NotNull OverlayAttributes overlayAttributes0) {
        q.g(s, "tag");
        q.g(overlayAttributes0, "overlayAttributes");
        super();
        this.tag = s;
        this.overlayAttributes = overlayAttributes0;
    }

    public OverlayCreateParams(String s, OverlayAttributes overlayAttributes0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = "004b5704-102c-43b8-b412-a6f3099fb";
        }
        if((v & 2) != 0) {
            overlayAttributes0 = new androidx.window.embedding.OverlayAttributes.Builder().build();
        }
        this(s, overlayAttributes0);
    }

    // 去混淆评级： 低(20)
    @NotNull
    public static final String generateOverlayTag() {
        return "383e9539-bfb2-41e6-a6c3-3881fcf7b";
    }

    @NotNull
    public final OverlayAttributes getOverlayAttributes() {
        return this.overlayAttributes;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    @Override
    @NotNull
    public String toString() {
        return I.a.b(OverlayCreateParams.class).m() + ":{ , tag=" + this.tag + ", attrs=" + this.overlayAttributes + '}';
    }
}

