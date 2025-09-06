package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

public abstract class d {
    public static EdgeEffect a(Context context0, AttributeSet attributeSet0) {
        try {
            return new EdgeEffect(context0, attributeSet0);
        }
        catch(Throwable unused_ex) {
            return new EdgeEffect(context0);
        }
    }

    public static float b(EdgeEffect edgeEffect0) {
        try {
            return edgeEffect0.getDistance();
        }
        catch(Throwable unused_ex) {
            return 0.0f;
        }
    }

    public static float c(EdgeEffect edgeEffect0, float f, float f1) {
        try {
            return edgeEffect0.onPullDistance(f, f1);
        }
        catch(Throwable unused_ex) {
            edgeEffect0.onPull(f, f1);
            return 0.0f;
        }
    }
}

