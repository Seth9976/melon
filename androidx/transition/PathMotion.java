package androidx.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;

public abstract class PathMotion {
    public PathMotion(Context context0, AttributeSet attributeSet0) {
    }

    public abstract Path a(float arg1, float arg2, float arg3, float arg4);
}

