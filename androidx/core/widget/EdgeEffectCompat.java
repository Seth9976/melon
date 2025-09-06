package androidx.core.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.widget.EdgeEffect;

public final class EdgeEffectCompat {
    @Deprecated
    public EdgeEffectCompat(Context context0) {
        new EdgeEffect(context0);
    }

    public static float a(EdgeEffect edgeEffect0) {
        return Build.VERSION.SDK_INT < 0x1F ? 0.0f : d.b(edgeEffect0);
    }

    public static float b(EdgeEffect edgeEffect0, float f, float f1) {
        if(Build.VERSION.SDK_INT >= 0x1F) {
            return d.c(edgeEffect0, f, f1);
        }
        c.a(edgeEffect0, f, f1);
        return f;
    }
}

