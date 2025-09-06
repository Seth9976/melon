package androidx.window.embedding;

import android.os.Bundle;
import androidx.window.RequiresWindowSdkExtension;
import androidx.window.WindowSdkExtensions;
import androidx.window.extensions.embedding.ActivityStack.Token;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u00C0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\b\u001A\u00020\u0007*\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001A\u0004\u0018\u00010\u0005*\u00020\u0004H\u0002\u00A2\u0006\u0004\b\n\u0010\u000BJ\u001B\u0010\u000F\u001A\u00020\u000E*\u00020\u00042\u0006\u0010\r\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\u000F\u0010\u0010J#\u0010\u0012\u001A\u00020\u0007*\u00020\u00042\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0011\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u001F\u0010\u0019\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u00042\u0006\u0010\u0016\u001A\u00020\u0015H\u0001\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u001B\u0010\u001B\u001A\u00020\u0007*\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0005H\u0000\u00A2\u0006\u0004\b\u001A\u0010\tJ\u0015\u0010\u001F\u001A\u0004\u0018\u00010\u001C*\u00020\u0004H\u0000\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u001F\u0010$\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u00042\u0006\u0010!\u001A\u00020 H\u0001\u00A2\u0006\u0004\b\"\u0010#R\u0014\u0010%\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010\'\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\'\u0010&R\u0014\u0010(\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b(\u0010&R\u0014\u0010)\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b)\u0010&R\u0014\u0010*\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b*\u0010&R\u0014\u0010+\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b+\u0010&R\u0014\u0010,\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b,\u0010&R\u0014\u0010-\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b-\u0010&R\u0014\u0010.\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b.\u0010&R\u0014\u0010/\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b/\u0010&R\u0014\u00100\u001A\u00020\f8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b0\u0010&\u00A8\u00061"}, d2 = {"Landroidx/window/embedding/ActivityEmbeddingOptionsImpl;", "", "<init>", "()V", "Landroid/os/Bundle;", "Landroidx/window/embedding/EmbeddingBounds;", "embeddingBounds", "Lie/H;", "putEmbeddingBounds", "(Landroid/os/Bundle;Landroidx/window/embedding/EmbeddingBounds;)V", "getEmbeddingBounds", "(Landroid/os/Bundle;)Landroidx/window/embedding/EmbeddingBounds;", "", "key", "Landroidx/window/embedding/EmbeddingBounds$Dimension;", "getDimension", "(Landroid/os/Bundle;Ljava/lang/String;)Landroidx/window/embedding/EmbeddingBounds$Dimension;", "dimension", "putDimension", "(Landroid/os/Bundle;Ljava/lang/String;Landroidx/window/embedding/EmbeddingBounds$Dimension;)V", "options", "Landroidx/window/embedding/OverlayCreateParams;", "overlayCreateParams", "setOverlayCreateParams$window_release", "(Landroid/os/Bundle;Landroidx/window/embedding/OverlayCreateParams;)V", "setOverlayCreateParams", "putActivityStackAlignment$window_release", "putActivityStackAlignment", "Landroidx/window/embedding/OverlayAttributes;", "getOverlayAttributes$window_release", "(Landroid/os/Bundle;)Landroidx/window/embedding/OverlayAttributes;", "getOverlayAttributes", "Landroidx/window/extensions/embedding/ActivityStack$Token;", "activityStackToken", "setActivityStackToken$window_release", "(Landroid/os/Bundle;Landroidx/window/extensions/embedding/ActivityStack$Token;)V", "setActivityStackToken", "KEY_EMBEDDING_BOUNDS", "Ljava/lang/String;", "KEY_EMBEDDING_BOUNDS_ALIGNMENT", "KEY_EMBEDDING_BOUNDS_WIDTH", "KEY_EMBEDDING_BOUNDS_HEIGHT", "DIMENSION_TYPE_EXPANDED", "DIMENSION_TYPE_HINGE", "DIMENSION_TYPE_RATIO", "DIMENSION_TYPE_PIXEL", "KEY_EMBEDDING_BOUNDS_DIMENSION_TYPE", "KEY_EMBEDDING_BOUNDS_DIMENSION_VALUE", "KEY_ACTIVITY_STACK_ALIGNMENT", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ActivityEmbeddingOptionsImpl {
    @NotNull
    private static final String DIMENSION_TYPE_EXPANDED = "expanded";
    @NotNull
    private static final String DIMENSION_TYPE_HINGE = "hinge";
    @NotNull
    private static final String DIMENSION_TYPE_PIXEL = "pixel";
    @NotNull
    private static final String DIMENSION_TYPE_RATIO = "ratio";
    @NotNull
    public static final ActivityEmbeddingOptionsImpl INSTANCE = null;
    @NotNull
    private static final String KEY_ACTIVITY_STACK_ALIGNMENT = "androidx.window.embedding.ActivityStackAlignment";
    @NotNull
    private static final String KEY_EMBEDDING_BOUNDS = "androidx.window.embedding.EmbeddingBounds";
    @NotNull
    private static final String KEY_EMBEDDING_BOUNDS_ALIGNMENT = "androidx.window.embedding.EmbeddingBounds.alignment";
    @NotNull
    private static final String KEY_EMBEDDING_BOUNDS_DIMENSION_TYPE = "androidx.window.embedding.EmbeddingBounds.dimension_type";
    @NotNull
    private static final String KEY_EMBEDDING_BOUNDS_DIMENSION_VALUE = "androidx.window.embedding.EmbeddingBounds.dimension_value";
    @NotNull
    private static final String KEY_EMBEDDING_BOUNDS_HEIGHT = "androidx.window.embedding.EmbeddingBounds.height";
    @NotNull
    private static final String KEY_EMBEDDING_BOUNDS_WIDTH = "androidx.window.embedding.EmbeddingBounds.width";

    static {
        ActivityEmbeddingOptionsImpl.INSTANCE = new ActivityEmbeddingOptionsImpl();
    }

    private final Dimension getDimension(Bundle bundle0, String s) {
        Bundle bundle1 = bundle0.getBundle(s);
        q.d(bundle1);
        String s1 = bundle1.getString("androidx.window.embedding.EmbeddingBounds.dimension_type");
        if(s1 != null) {
            switch(s1) {
                case "expanded": {
                    return Dimension.DIMENSION_EXPANDED;
                }
                case "hinge": {
                    return Dimension.DIMENSION_HINGE;
                }
                case "pixel": {
                    int v = bundle1.getInt("androidx.window.embedding.EmbeddingBounds.dimension_value");
                    return Dimension.Companion.pixel(v);
                }
                case "ratio": {
                    float f = bundle1.getFloat("androidx.window.embedding.EmbeddingBounds.dimension_value");
                    return Dimension.Companion.ratio(f);
                }
            }
        }
        throw new IllegalArgumentException("Illegal type " + s1);
    }

    private final EmbeddingBounds getEmbeddingBounds(Bundle bundle0) {
        Bundle bundle1 = bundle0.getBundle("androidx.window.embedding.EmbeddingBounds");
        return bundle1 == null ? null : new EmbeddingBounds(new Alignment(bundle1.getInt("androidx.window.embedding.EmbeddingBounds.alignment")), this.getDimension(bundle1, "androidx.window.embedding.EmbeddingBounds.width"), this.getDimension(bundle1, "androidx.window.embedding.EmbeddingBounds.height"));
    }

    @Nullable
    public final OverlayAttributes getOverlayAttributes$window_release(@NotNull Bundle bundle0) {
        q.g(bundle0, "<this>");
        EmbeddingBounds embeddingBounds0 = this.getEmbeddingBounds(bundle0);
        return embeddingBounds0 == null ? null : new OverlayAttributes(embeddingBounds0);
    }

    public final void putActivityStackAlignment$window_release(@NotNull Bundle bundle0, @NotNull EmbeddingBounds embeddingBounds0) {
        q.g(bundle0, "<this>");
        q.g(embeddingBounds0, "embeddingBounds");
        bundle0.putInt("androidx.window.embedding.ActivityStackAlignment", embeddingBounds0.getAlignment().getValue$window_release());
    }

    private final void putDimension(Bundle bundle0, String s, Dimension embeddingBounds$Dimension0) {
        Bundle bundle1 = new Bundle();
        if(q.b(embeddingBounds$Dimension0, Dimension.DIMENSION_EXPANDED)) {
            bundle1.putString("androidx.window.embedding.EmbeddingBounds.dimension_type", "expanded");
        }
        else if(q.b(embeddingBounds$Dimension0, Dimension.DIMENSION_HINGE)) {
            bundle1.putString("androidx.window.embedding.EmbeddingBounds.dimension_type", "hinge");
        }
        else if(embeddingBounds$Dimension0 instanceof Ratio) {
            bundle1.putString("androidx.window.embedding.EmbeddingBounds.dimension_type", "ratio");
            bundle1.putFloat("androidx.window.embedding.EmbeddingBounds.dimension_value", ((Ratio)embeddingBounds$Dimension0).getValue$window_release());
        }
        else if(embeddingBounds$Dimension0 instanceof Pixel) {
            bundle1.putString("androidx.window.embedding.EmbeddingBounds.dimension_type", "pixel");
            bundle1.putInt("androidx.window.embedding.EmbeddingBounds.dimension_value", ((Pixel)embeddingBounds$Dimension0).getValue$window_release());
        }
        bundle0.putBundle(s, bundle1);
    }

    private final void putEmbeddingBounds(Bundle bundle0, EmbeddingBounds embeddingBounds0) {
        Bundle bundle1 = new Bundle();
        bundle1.putInt("androidx.window.embedding.EmbeddingBounds.alignment", embeddingBounds0.getAlignment().getValue$window_release());
        ActivityEmbeddingOptionsImpl.INSTANCE.putDimension(bundle1, "androidx.window.embedding.EmbeddingBounds.width", embeddingBounds0.getWidth());
        ActivityEmbeddingOptionsImpl.INSTANCE.putDimension(bundle1, "androidx.window.embedding.EmbeddingBounds.height", embeddingBounds0.getHeight());
        bundle0.putBundle("androidx.window.embedding.EmbeddingBounds", bundle1);
    }

    @RequiresWindowSdkExtension(version = 5)
    public final void setActivityStackToken$window_release(@NotNull Bundle bundle0, @NotNull ActivityStack.Token activityStack$Token0) {
        q.g(bundle0, "options");
        q.g(activityStack$Token0, "activityStackToken");
        bundle0.putBundle("androidx.window.extensions.embedding.ActivityStackToken", activityStack$Token0.toBundle());
    }

    @RequiresWindowSdkExtension(version = 8)
    public final void setOverlayCreateParams$window_release(@NotNull Bundle bundle0, @NotNull OverlayCreateParams overlayCreateParams0) {
        q.g(bundle0, "options");
        q.g(overlayCreateParams0, "overlayCreateParams");
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(8);
        bundle0.putString("androidx.window.extensions.embedding.OverlayTag", overlayCreateParams0.getTag());
        this.putEmbeddingBounds(bundle0, overlayCreateParams0.getOverlayAttributes().getBounds());
    }
}

