package b1;

import F.e;
import android.graphics.RectF;
import android.text.Layout.TextInclusionStrategy;

public final class a implements Layout.TextInclusionStrategy {
    public final e a;

    public a(e e0) {
        this.a = e0;
    }

    @Override  // android.text.Layout$TextInclusionStrategy
    public final boolean isSegmentInside(RectF rectF0, RectF rectF1) {
        return ((Boolean)this.a.invoke(rectF0, rectF1)).booleanValue();
    }
}

