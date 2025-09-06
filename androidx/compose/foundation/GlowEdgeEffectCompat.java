package androidx.compose.foundation;

import android.content.Context;
import android.widget.EdgeEffect;
import de.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/GlowEdgeEffectCompat;", "Landroid/widget/EdgeEffect;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class GlowEdgeEffectCompat extends EdgeEffect {
    public final float a;
    public float b;

    public GlowEdgeEffectCompat(@NotNull Context context0) {
        super(context0);
        this.a = c.c(context0).a * 1.0f;
    }

    @Override  // android.widget.EdgeEffect
    public final void onAbsorb(int v) {
        this.b = 0.0f;
        super.onAbsorb(v);
    }

    @Override  // android.widget.EdgeEffect
    public final void onPull(float f) {
        this.b = 0.0f;
        super.onPull(f);
    }

    @Override  // android.widget.EdgeEffect
    public final void onPull(float f, float f1) {
        this.b = 0.0f;
        super.onPull(f, f1);
    }

    @Override  // android.widget.EdgeEffect
    public final void onRelease() {
        this.b = 0.0f;
        super.onRelease();
    }
}

